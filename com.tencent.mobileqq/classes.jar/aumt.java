import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.flutter.channel.qqcircle.QCircleSearchHistoryWords;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManagerFactory.SQLiteOpenHelperImpl;
import com.tencent.mobileqq.persistence.TableBuilder;

public class aumt
  extends EntityManagerFactory
{
  public aumt(String paramString)
  {
    super(paramString);
  }
  
  public SQLiteOpenHelper build(String paramString)
  {
    if (this.dbHelper == null)
    {
      this.mInnerDbHelper = new EntityManagerFactory.SQLiteOpenHelperImpl(this, "qcircle_flutter_db_" + paramString + ".db", null, 1);
      this.dbHelper = new SQLiteOpenHelper(this.mInnerDbHelper);
    }
    return this.dbHelper;
  }
  
  public void createDatabase(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new QCircleSearchHistoryWords()));
  }
  
  public String getPackageName()
  {
    return getClass().getPackage().getName();
  }
  
  public void upgradeDatabase(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aumt
 * JD-Core Version:    0.7.0.1
 */