import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteQuery;
import com.tencent.mobileqq.data.QQEntityManagerFactory;

public class apbb
  implements SQLiteDatabase.CursorFactory
{
  private apbb(QQEntityManagerFactory paramQQEntityManagerFactory) {}
  
  public Cursor newCursor(SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteQuery paramSQLiteQuery)
  {
    return new apbc(this, paramSQLiteDatabase, paramSQLiteCursorDriver, paramString, paramSQLiteQuery);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apbb
 * JD-Core Version:    0.7.0.1
 */