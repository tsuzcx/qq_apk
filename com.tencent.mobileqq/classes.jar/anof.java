import android.database.Cursor;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.QQEntityManagerFactory.SQLiteOpenHelperImpl;
import com.tencent.mobileqq.utils.SecurityUtile;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class anof
  extends QQEntityManagerFactory
{
  public anof(String paramString)
  {
    super(paramString);
  }
  
  private void a(String paramString, android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    System.currentTimeMillis();
    Cursor localCursor1 = paramSQLiteDatabase.rawQuery("select distinct tbl_name from Sqlite_master", null);
    ArrayList localArrayList = new ArrayList();
    String str1;
    Cursor localCursor2;
    if (localCursor1 != null) {
      do
      {
        if (!localCursor1.moveToNext()) {
          break;
        }
        str1 = SecurityUtile.b(localCursor1.getString(0));
        localCursor2 = paramSQLiteDatabase.rawQuery("select sql from sqlite_master where type=? and name=?", new String[] { "table", str1 });
      } while (localCursor2 == null);
    }
    label395:
    for (;;)
    {
      Field localField;
      int i;
      boolean bool;
      try
      {
        Object localObject = awhf.a(Class.forName(paramString + "." + str1));
        if (localCursor2.moveToFirst())
        {
          String[] arrayOfString = SecurityUtile.b(localCursor2.getString(0)).split(",");
          localObject = ((List)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            localField = (Field)((Iterator)localObject).next();
            i = 1;
            if (i >= arrayOfString.length) {
              break label395;
            }
            String str2 = arrayOfString[i].trim().split(" ")[0];
            if (!localField.getName().equals(str2)) {
              break label279;
            }
            i = 1;
            if (i != 0) {
              continue;
            }
            if (!localField.isAnnotationPresent(awhm.class)) {
              break label286;
            }
            i = 0;
            bool = true;
            localArrayList.add(awhf.a(str1, localField.getName(), (String)awhf.a.get(localField.getType()), bool, i));
            continue;
          }
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        localCursor2.close();
      }
      label279:
      i += 1;
      continue;
      label286:
      if (localField.isAnnotationPresent(awhl.class))
      {
        i = ((awhl)localField.getAnnotation(awhl.class)).a();
        bool = true;
        continue;
        localCursor1.close();
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
      else
      {
        i = 0;
        bool = false;
        continue;
        i = 0;
      }
    }
  }
  
  public ambz build(String paramString)
  {
    if (this.dbHelper == null)
    {
      this.mInnerDbHelper = new QQEntityManagerFactory.SQLiteOpenHelperImpl(this, "arkapp_" + paramString + ".db", null, 1);
      this.dbHelper = new ambz(this.mInnerDbHelper);
    }
    return this.dbHelper;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anof
 * JD-Core Version:    0.7.0.1
 */