import android.database.Cursor;
import com.tencent.mobileqq.data.Ability;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.QQEntityManagerFactory.SQLiteOpenHelperImpl;
import com.tencent.mobileqq.utils.SecurityUtile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class auma
  extends QQEntityManagerFactory
{
  public auma(String paramString)
  {
    super(paramString);
  }
  
  private void a(String paramString, android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    System.currentTimeMillis();
    Cursor localCursor1 = paramSQLiteDatabase.rawQuery("select distinct tbl_name from Sqlite_master", null);
    ArrayList localArrayList = new ArrayList();
    if (localCursor1 != null)
    {
      while (localCursor1.moveToNext())
      {
        String str = SecurityUtile.b(localCursor1.getString(0));
        Cursor localCursor2 = paramSQLiteDatabase.rawQuery("select sql from sqlite_master where type=? and name=?", new String[] { "table", str });
        if (localCursor2 != null) {
          for (;;)
          {
            try
            {
              if (!str.startsWith("mr_slow_")) {
                continue;
              }
              localObject = MessageRecord.class;
              aulc.a(localArrayList, str, localCursor2, (Class)localObject);
            }
            catch (ClassNotFoundException localClassNotFoundException)
            {
              Object localObject;
              continue;
            }
            localCursor2.close();
            break;
            localObject = Class.forName(paramString + "." + str);
          }
        }
      }
      localCursor1.close();
    }
    com.tencent.mobileqq.app.SQLiteDatabase.beginTransactionLog();
    paramSQLiteDatabase.beginTransaction();
    try
    {
      paramString = localArrayList.iterator();
      while (paramString.hasNext()) {
        paramSQLiteDatabase.execSQL((String)paramString.next());
      }
      paramSQLiteDatabase.setTransactionSuccessful();
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
      com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
    }
    paramSQLiteDatabase.endTransaction();
    com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
  }
  
  public akfu build(String paramString)
  {
    if (this.dbHelper == null)
    {
      this.mInnerDbHelper = new QQEntityManagerFactory.SQLiteOpenHelperImpl(this, "slowtable_" + paramString + ".db", null, 1);
      this.dbHelper = new akfu(this.mInnerDbHelper);
    }
    return this.dbHelper;
  }
  
  public void createDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(aulp.a(new Ability()));
  }
  
  public String getPackageName()
  {
    return getClass().getPackage().getName();
  }
  
  public void upgradeDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    a(getPackageName(), paramSQLiteDatabase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     auma
 * JD-Core Version:    0.7.0.1
 */