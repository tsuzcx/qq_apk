import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.utils.SecurityUtile;

class apfl
  extends SQLiteCursor
{
  apfl(apfk paramapfk, SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteQuery paramSQLiteQuery)
  {
    super(paramSQLiteDatabase, paramSQLiteCursorDriver, paramString, paramSQLiteQuery);
  }
  
  public byte[] getBlob(int paramInt)
  {
    byte[] arrayOfByte2 = super.getBlob(paramInt);
    byte[] arrayOfByte1 = arrayOfByte2;
    if (this.a.a.isNeedEncry()) {
      arrayOfByte1 = SecurityUtile.a(arrayOfByte2);
    }
    return arrayOfByte1;
  }
  
  public String getString(int paramInt)
  {
    String str2 = super.getString(paramInt);
    String str1 = str2;
    if (this.a.a.isNeedEncry()) {}
    try
    {
      str1 = SecurityUtile.b(str2);
      return str1;
    }
    catch (Exception localException) {}
    return str2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apfl
 * JD-Core Version:    0.7.0.1
 */