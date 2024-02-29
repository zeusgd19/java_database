import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    private static java.sql.Connection con;
    public static void main(String[] args) throws SQLException {
        //Conectar
        String host = "jdbc:sqlite:src/main/resources/network";
        con = java.sql.DriverManager.getConnection( host );
        //createTable();
        readUsers();
    }

    public static void createTable() throws SQLException {
        Statement st = con.createStatement();
        st.executeUpdate("CREATE TABLE T1(c1 VARCHAR(50));");
        st.close();
    }

    public static void readUsers() throws SQLException {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM usuarios");
        while (rs.next()){
            System.out.printf("ID %d ",rs.getInt(1));
            System.out.println();
            System.out.printf("%s %s",rs.getString(2),rs.getString(3));
            System.out.println();
        }
        st.close();
    }
}
