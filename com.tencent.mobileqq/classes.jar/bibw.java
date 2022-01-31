import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.qphone.base.util.QLog;

public class bibw
  extends SQLiteOpenHelper
{
  private SQLiteDatabase a;
  private SQLiteDatabase b;
  
  public bibw(Context paramContext)
  {
    super(paramContext, "WADLTASK.db", null, 27);
  }
  
  public int a(ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    try
    {
      int j = this.a.update("TASKS", paramContentValues, paramString, paramArrayOfString);
      i = j;
      if (j <= 0)
      {
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.e("WadlProviderDBHelper", 2, "execUpdateSQL error selection=" + paramString);
          i = j;
        }
      }
    }
    catch (SQLiteFullException paramContentValues)
    {
      for (;;)
      {
        paramContentValues.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("WadlProviderDBHelper", 2, "execUpdateSQL exception ", paramContentValues);
        }
        int i = -1;
      }
    }
    finally {}
    return i;
  }
  
  public int a(String paramString, String[] paramArrayOfString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("WadlProviderDBHelper", 2, "execDelSQL selection=" + paramString);
      }
      int i = this.a.delete("TASKS", paramString, paramArrayOfString);
      return i;
    }
    finally {}
  }
  
  /* Error */
  public long a(ContentValues paramContentValues)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +28 -> 33
    //   8: ldc 36
    //   10: iconst_2
    //   11: new 38	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   18: ldc 78
    //   20: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_1
    //   24: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aload_0
    //   34: getfield 20	bibw:a	Landroid/database/sqlite/SQLiteDatabase;
    //   37: ldc 22
    //   39: aconst_null
    //   40: aload_1
    //   41: invokevirtual 85	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   44: lstore_2
    //   45: aload_0
    //   46: monitorexit
    //   47: lload_2
    //   48: lreturn
    //   49: astore_1
    //   50: aload_1
    //   51: invokevirtual 86	java/lang/Exception:printStackTrace	()V
    //   54: ldc2_w 87
    //   57: lstore_2
    //   58: goto -13 -> 45
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	bibw
    //   0	66	1	paramContentValues	ContentValues
    //   44	14	2	l	long
    // Exception table:
    //   from	to	target	type
    //   33	45	49	java/lang/Exception
    //   2	33	61	finally
    //   33	45	61	finally
    //   50	54	61	finally
  }
  
  public Cursor a(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    try
    {
      paramArrayOfString1 = this.b.query("TASKS", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
      return paramArrayOfString1;
    }
    finally
    {
      paramArrayOfString1 = finally;
      throw paramArrayOfString1;
    }
  }
  
  public void a(SQLiteDatabase paramSQLiteDatabase1, SQLiteDatabase paramSQLiteDatabase2)
  {
    this.b = paramSQLiteDatabase1;
    this.a = paramSQLiteDatabase2;
    paramSQLiteDatabase1 = new ContentValues();
    paramSQLiteDatabase1.put("status", Integer.valueOf(5));
    paramSQLiteDatabase2.update("TASKS", paramSQLiteDatabase1, "status<?", new String[] { "5" });
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WadlProviderDBHelper", 2, "onCreate sql=" + "CREATE TABLE TASKS (appId TEXT NOT NULL, apkUrl TEXT NOT NULL, packageName TEXT, versionCode INTEGER, totalSize INTEGER, downloadSize INTEGER, status INTEGER ,apkChannel TEXT, PRIMARY KEY(appId))");
    }
    paramSQLiteDatabase.execSQL("CREATE TABLE TASKS (appId TEXT NOT NULL, apkUrl TEXT NOT NULL, packageName TEXT, versionCode INTEGER, totalSize INTEGER, downloadSize INTEGER, status INTEGER ,apkChannel TEXT, PRIMARY KEY(appId))");
  }
  
  public void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WadlProviderDBHelper", 2, "onOpen db=" + paramSQLiteDatabase);
    }
    super.onOpen(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WadlProviderDBHelper", 2, "onUpgrade oldVersion=" + paramInt1 + ",newVersion=" + paramInt2);
    }
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS TASKS");
    onCreate(paramSQLiteDatabase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bibw
 * JD-Core Version:    0.7.0.1
 */