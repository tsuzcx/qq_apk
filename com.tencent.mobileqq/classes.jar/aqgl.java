import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.data.RockDownloadInfo;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManagerFactory.SQLiteOpenHelperImpl;
import com.tencent.mobileqq.persistence.TableBuilder;
import java.util.HashMap;
import java.util.Map;

public class aqgl
  extends EntityManagerFactory
{
  private static Map<String, Class<?>> a = new HashMap();
  
  static
  {
    a.put(RockDownloadInfo.class.getSimpleName(), RockDownloadInfo.class);
  }
  
  public aqgl()
  {
    super("RockDownload");
  }
  
  public SQLiteOpenHelper build(String paramString)
  {
    if (this.dbHelper == null)
    {
      this.mInnerDbHelper = new EntityManagerFactory.SQLiteOpenHelperImpl(this, paramString + ".db", null, 1);
      this.dbHelper = new SQLiteOpenHelper(this.mInnerDbHelper);
    }
    return this.dbHelper;
  }
  
  public void createDatabase(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new RockDownloadInfo()));
  }
  
  public String getPackageName()
  {
    return getClass().getPackage().getName();
  }
  
  public void upgradeDatabase(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqgl
 * JD-Core Version:    0.7.0.1
 */