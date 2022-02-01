package com.tencent.beacon.core.a.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.beacon.core.d.i;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class e
  extends SQLiteOpenHelper
{
  private static Map<String, e> a = new HashMap();
  private static Map<String, Object> b = new HashMap();
  protected Context c;
  private SQLiteDatabase d;
  
  private e(Context paramContext, String paramString) {}
  
  public static e a(Context paramContext, String paramString)
  {
    try
    {
      e locale2 = (e)a.get(paramString);
      e locale1 = locale2;
      if (locale2 == null)
      {
        locale1 = new e(paramContext, paramString);
        a.put(paramString, locale1);
        paramContext = new Object();
        b.put(paramString, paramContext);
      }
      return locale1;
    }
    finally {}
  }
  
  public static Object a(String paramString)
  {
    Object localObject2 = b.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new Object();
      b.put(paramString, localObject1);
    }
    return localObject1;
  }
  
  private void b(SQLiteDatabase paramSQLiteDatabase)
  {
    if (a(paramSQLiteDatabase))
    {
      com.tencent.beacon.core.e.d.g("[db] drop all success recreate!", new Object[0]);
      onCreate(paramSQLiteDatabase);
    }
    do
    {
      return;
      com.tencent.beacon.core.e.d.i("[db] drop all fail try deleted file,may next time will success!", new Object[0]);
      paramSQLiteDatabase = this.c.getDatabasePath("beacon_db");
    } while ((paramSQLiteDatabase == null) || (!paramSQLiteDatabase.canWrite()));
    paramSQLiteDatabase.delete();
  }
  
  /* Error */
  protected boolean a(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 114	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 115	java/util/ArrayList:<init>	()V
    //   9: astore 5
    //   11: aload_1
    //   12: ldc 117
    //   14: iconst_1
    //   15: anewarray 119	java/lang/String
    //   18: dup
    //   19: iconst_0
    //   20: ldc 121
    //   22: aastore
    //   23: ldc 123
    //   25: aconst_null
    //   26: aconst_null
    //   27: aconst_null
    //   28: aconst_null
    //   29: invokevirtual 129	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   32: astore 4
    //   34: aload 4
    //   36: ifnull +99 -> 135
    //   39: aload 4
    //   41: astore_3
    //   42: aload 4
    //   44: invokeinterface 134 1 0
    //   49: ifeq +86 -> 135
    //   52: aload 4
    //   54: astore_3
    //   55: aload 5
    //   57: aload 4
    //   59: iconst_0
    //   60: invokeinterface 138 2 0
    //   65: invokeinterface 144 2 0
    //   70: pop
    //   71: goto -32 -> 39
    //   74: astore_1
    //   75: aload 4
    //   77: astore_3
    //   78: aload_0
    //   79: getfield 45	com/tencent/beacon/core/a/a/e:c	Landroid/content/Context;
    //   82: invokestatic 149	com/tencent/beacon/core/d/i:a	(Landroid/content/Context;)Lcom/tencent/beacon/core/d/i;
    //   85: astore 5
    //   87: aload 4
    //   89: astore_3
    //   90: aload 5
    //   92: ldc 151
    //   94: ldc 153
    //   96: aload_1
    //   97: invokevirtual 156	com/tencent/beacon/core/d/i:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   100: aload 4
    //   102: astore_3
    //   103: aload_1
    //   104: invokestatic 159	com/tencent/beacon/core/e/d:a	(Ljava/lang/Throwable;)V
    //   107: aload 4
    //   109: ifnull +20 -> 129
    //   112: aload 4
    //   114: invokeinterface 162 1 0
    //   119: ifne +10 -> 129
    //   122: aload 4
    //   124: invokeinterface 165 1 0
    //   129: iconst_0
    //   130: istore_2
    //   131: aload_0
    //   132: monitorexit
    //   133: iload_2
    //   134: ireturn
    //   135: aload 4
    //   137: astore_3
    //   138: aload 5
    //   140: invokeinterface 169 1 0
    //   145: ifle +142 -> 287
    //   148: aload 4
    //   150: astore_3
    //   151: aload 5
    //   153: invokeinterface 173 1 0
    //   158: astore 5
    //   160: aload 4
    //   162: astore_3
    //   163: aload 5
    //   165: invokeinterface 178 1 0
    //   170: ifeq +117 -> 287
    //   173: aload 4
    //   175: astore_3
    //   176: aload 5
    //   178: invokeinterface 182 1 0
    //   183: checkcast 119	java/lang/String
    //   186: astore 6
    //   188: aload 4
    //   190: astore_3
    //   191: aload 6
    //   193: ldc 184
    //   195: invokevirtual 187	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   198: istore_2
    //   199: iload_2
    //   200: ifne -40 -> 160
    //   203: aload 4
    //   205: astore_3
    //   206: aload 6
    //   208: ldc 189
    //   210: invokevirtual 187	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   213: ifne -53 -> 160
    //   216: aload 4
    //   218: astore_3
    //   219: aload_1
    //   220: getstatic 195	java/util/Locale:US	Ljava/util/Locale;
    //   223: ldc 197
    //   225: iconst_1
    //   226: anewarray 73	java/lang/Object
    //   229: dup
    //   230: iconst_0
    //   231: aload 6
    //   233: aastore
    //   234: invokestatic 201	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   237: invokevirtual 205	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   240: aload 4
    //   242: astore_3
    //   243: ldc 207
    //   245: iconst_1
    //   246: anewarray 73	java/lang/Object
    //   249: dup
    //   250: iconst_0
    //   251: aload 6
    //   253: aastore
    //   254: invokestatic 87	com/tencent/beacon/core/e/d:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   257: goto -97 -> 160
    //   260: astore_1
    //   261: aload_3
    //   262: ifnull +18 -> 280
    //   265: aload_3
    //   266: invokeinterface 162 1 0
    //   271: ifne +9 -> 280
    //   274: aload_3
    //   275: invokeinterface 165 1 0
    //   280: aload_1
    //   281: athrow
    //   282: astore_1
    //   283: aload_0
    //   284: monitorexit
    //   285: aload_1
    //   286: athrow
    //   287: aload 4
    //   289: ifnull +20 -> 309
    //   292: aload 4
    //   294: invokeinterface 162 1 0
    //   299: ifne +10 -> 309
    //   302: aload 4
    //   304: invokeinterface 165 1 0
    //   309: iconst_1
    //   310: istore_2
    //   311: goto -180 -> 131
    //   314: astore_1
    //   315: aconst_null
    //   316: astore_3
    //   317: goto -56 -> 261
    //   320: astore_1
    //   321: aconst_null
    //   322: astore 4
    //   324: goto -249 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	327	0	this	e
    //   0	327	1	paramSQLiteDatabase	SQLiteDatabase
    //   130	181	2	bool	boolean
    //   41	276	3	localCursor1	android.database.Cursor
    //   32	291	4	localCursor2	android.database.Cursor
    //   9	168	5	localObject	Object
    //   186	66	6	str	String
    // Exception table:
    //   from	to	target	type
    //   42	52	74	java/lang/Throwable
    //   55	71	74	java/lang/Throwable
    //   138	148	74	java/lang/Throwable
    //   151	160	74	java/lang/Throwable
    //   163	173	74	java/lang/Throwable
    //   176	188	74	java/lang/Throwable
    //   191	199	74	java/lang/Throwable
    //   206	216	74	java/lang/Throwable
    //   219	240	74	java/lang/Throwable
    //   243	257	74	java/lang/Throwable
    //   42	52	260	finally
    //   55	71	260	finally
    //   78	87	260	finally
    //   90	100	260	finally
    //   103	107	260	finally
    //   138	148	260	finally
    //   151	160	260	finally
    //   163	173	260	finally
    //   176	188	260	finally
    //   191	199	260	finally
    //   206	216	260	finally
    //   219	240	260	finally
    //   243	257	260	finally
    //   112	129	282	finally
    //   265	280	282	finally
    //   280	282	282	finally
    //   292	309	282	finally
    //   2	11	314	finally
    //   11	34	314	finally
    //   2	11	320	java/lang/Throwable
    //   11	34	320	java/lang/Throwable
  }
  
  public SQLiteDatabase getWritableDatabase()
  {
    int i = 0;
    try
    {
      for (;;)
      {
        SQLiteDatabase localSQLiteDatabase1 = this.d;
        if ((localSQLiteDatabase1 != null) || (i >= 5)) {
          break;
        }
        i += 1;
        try
        {
          this.d = super.getWritableDatabase();
        }
        catch (Exception localException)
        {
          com.tencent.beacon.core.e.d.i("[db] getWritableDatabase error count %d", new Object[] { Integer.valueOf(i) });
          if (i == 5)
          {
            i.a(this.c).a("503", "[db] get WritableDatabase error! ", localException);
            com.tencent.beacon.core.e.d.b("[db] error get DB failed", new Object[0]);
          }
          else
          {
            try
            {
              Thread.sleep(200L);
            }
            catch (InterruptedException localInterruptedException)
            {
              com.tencent.beacon.core.e.d.a(localInterruptedException);
            }
          }
        }
      }
      SQLiteDatabase localSQLiteDatabase2 = this.d;
      return localSQLiteDatabase2;
    }
    finally {}
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    int i = 0;
    if (paramSQLiteDatabase != null) {}
    try
    {
      String[][] arrayOfString = d.b;
      if (arrayOfString != null)
      {
        int j = arrayOfString.length;
        while (i < j)
        {
          String[] arrayOfString1 = arrayOfString[i];
          com.tencent.beacon.core.e.d.g("[db] Table:%s", new Object[] { arrayOfString1[0] });
          paramSQLiteDatabase.execSQL(arrayOfString1[1]);
          i += 1;
        }
      }
      return;
    }
    finally {}
  }
  
  @TargetApi(11)
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    try
    {
      if (com.tencent.beacon.core.info.e.d(this.c).c() >= 11)
      {
        com.tencent.beacon.core.e.d.g("[db] Downgrade a db  [%s] from v %d to  v%d , deleted all tables!", new Object[] { "beacon_db", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        b(paramSQLiteDatabase);
      }
      return;
    }
    finally
    {
      paramSQLiteDatabase = finally;
      throw paramSQLiteDatabase;
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    try
    {
      com.tencent.beacon.core.e.d.g("[db] Upgrade a db  [%s] from v %d to v %d , deleted all tables!", new Object[] { "beacon_db", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      b(paramSQLiteDatabase);
      return;
    }
    finally
    {
      paramSQLiteDatabase = finally;
      throw paramSQLiteDatabase;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.a.a.e
 * JD-Core Version:    0.7.0.1
 */