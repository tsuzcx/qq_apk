package com.tencent.featuretoggle.db;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.featuretoggle.ToggleSetting;
import com.tencent.featuretoggle.utils.DeviceUtils;
import com.tencent.featuretoggle.utils.LogUtils;
import java.io.File;

public class DBOpenHelper
  extends SQLiteOpenHelper
{
  private static final String a;
  private Context b;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ToggleSetting.s());
    localStringBuilder.append("toggle.db");
    a = localStringBuilder.toString();
  }
  
  DBOpenHelper(Context paramContext)
  {
    super(paramContext, a, null, 3);
    this.b = paramContext;
  }
  
  /* Error */
  public boolean a(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_1
    //   3: anewarray 44	java/lang/String
    //   6: astore 4
    //   8: aload 4
    //   10: iconst_0
    //   11: ldc 46
    //   13: aastore
    //   14: aload 4
    //   16: arraylength
    //   17: istore_3
    //   18: iconst_0
    //   19: istore_2
    //   20: iload_2
    //   21: iload_3
    //   22: if_icmpge +50 -> 72
    //   25: aload 4
    //   27: iload_2
    //   28: aaload
    //   29: astore 5
    //   31: new 12	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 15	java/lang/StringBuilder:<init>	()V
    //   38: astore 6
    //   40: aload 6
    //   42: ldc 48
    //   44: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload 6
    //   50: aload 5
    //   52: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload_1
    //   57: aload 6
    //   59: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokevirtual 54	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   65: iload_2
    //   66: iconst_1
    //   67: iadd
    //   68: istore_2
    //   69: goto -49 -> 20
    //   72: aload_0
    //   73: monitorexit
    //   74: iconst_1
    //   75: ireturn
    //   76: astore_1
    //   77: goto +19 -> 96
    //   80: astore_1
    //   81: aload_1
    //   82: invokestatic 59	com/tencent/featuretoggle/utils/LogUtils:a	(Ljava/lang/Throwable;)Z
    //   85: ifne +7 -> 92
    //   88: aload_1
    //   89: invokevirtual 62	java/lang/Throwable:printStackTrace	()V
    //   92: aload_0
    //   93: monitorexit
    //   94: iconst_0
    //   95: ireturn
    //   96: aload_0
    //   97: monitorexit
    //   98: goto +5 -> 103
    //   101: aload_1
    //   102: athrow
    //   103: goto -2 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	DBOpenHelper
    //   0	106	1	paramSQLiteDatabase	SQLiteDatabase
    //   19	50	2	i	int
    //   17	6	3	j	int
    //   6	20	4	arrayOfString	String[]
    //   29	22	5	str	String
    //   38	20	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	8	76	finally
    //   14	18	76	finally
    //   31	65	76	finally
    //   81	92	76	finally
    //   2	8	80	java/lang/Throwable
    //   14	18	80	java/lang/Throwable
    //   31	65	80	java/lang/Throwable
  }
  
  void b(SQLiteDatabase paramSQLiteDatabase)
  {
    if (a(paramSQLiteDatabase))
    {
      onCreate(paramSQLiteDatabase);
      return;
    }
    LogUtils.b("drop fail delete db", new Object[0]);
    paramSQLiteDatabase = this.b.getDatabasePath(a);
    if ((paramSQLiteDatabase != null) && (paramSQLiteDatabase.canWrite())) {
      paramSQLiteDatabase.delete();
    }
  }
  
  /* Error */
  public SQLiteDatabase getReadableDatabase()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_2
    //   4: iconst_0
    //   5: istore_1
    //   6: aload_2
    //   7: ifnonnull +79 -> 86
    //   10: iload_1
    //   11: iconst_5
    //   12: if_icmpge +74 -> 86
    //   15: iload_1
    //   16: iconst_1
    //   17: iadd
    //   18: istore_1
    //   19: aload_0
    //   20: invokespecial 96	android/database/sqlite/SQLiteOpenHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   23: astore_3
    //   24: aload_3
    //   25: astore_2
    //   26: goto -20 -> 6
    //   29: astore_2
    //   30: goto +52 -> 82
    //   33: ldc 98
    //   35: iconst_1
    //   36: anewarray 72	java/lang/Object
    //   39: dup
    //   40: iconst_0
    //   41: iload_1
    //   42: invokestatic 104	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   45: aastore
    //   46: invokestatic 108	com/tencent/featuretoggle/utils/LogUtils:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   49: pop
    //   50: iload_1
    //   51: iconst_5
    //   52: if_icmpne +13 -> 65
    //   55: ldc 110
    //   57: iconst_0
    //   58: anewarray 72	java/lang/Object
    //   61: invokestatic 113	com/tencent/featuretoggle/utils/LogUtils:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   64: pop
    //   65: ldc2_w 114
    //   68: invokestatic 121	java/lang/Thread:sleep	(J)V
    //   71: goto -65 -> 6
    //   74: astore_3
    //   75: aload_3
    //   76: invokevirtual 122	java/lang/InterruptedException:printStackTrace	()V
    //   79: goto -73 -> 6
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_2
    //   85: athrow
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_2
    //   89: areturn
    //   90: astore_3
    //   91: goto -58 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	DBOpenHelper
    //   5	48	1	i	int
    //   3	23	2	localObject	Object
    //   29	60	2	localSQLiteDatabase1	SQLiteDatabase
    //   23	2	3	localSQLiteDatabase2	SQLiteDatabase
    //   74	2	3	localInterruptedException	InterruptedException
    //   90	1	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   19	24	29	finally
    //   33	50	29	finally
    //   55	65	29	finally
    //   65	71	29	finally
    //   75	79	29	finally
    //   65	71	74	java/lang/InterruptedException
    //   19	24	90	java/lang/Throwable
  }
  
  public SQLiteDatabase getWritableDatabase()
  {
    Object localObject1 = null;
    Object localObject4 = null;
    int i = 0;
    Object localObject5 = localObject1;
    if ((localObject5 == null) && (i < 5)) {
      i += 1;
    }
    for (;;)
    {
      StringBuilder localStringBuilder;
      try
      {
        localObject1 = super.getWritableDatabase();
        break;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          LogUtils.c("[Database] try db %d", new Object[] { Integer.valueOf(i) });
          if (i == 5) {
            LogUtils.d("[Database] get db fail!", new Object[0]);
          }
          try
          {
            Thread.sleep(200L);
            localObject1 = localObject5;
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
            localObject2 = localObject5;
          }
        }
        break;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(localThrowable.getClass().getName());
        ((StringBuilder)localObject2).append(":");
        ((StringBuilder)localObject2).append(localThrowable.getMessage());
        localObject2 = ((StringBuilder)localObject2).toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[Database] db error :");
        localStringBuilder.append((String)localObject2);
        LogUtils.d(localStringBuilder.toString(), new Object[0]);
      }
      finally {}
      do
      {
        return localObject5;
      } while (localObject5 != null);
      if (localStringBuilder == null) {
        String str = "";
      }
    }
  }
  
  /* Error */
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 12	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 15	java/lang/StringBuilder:<init>	()V
    //   9: astore_2
    //   10: aload_2
    //   11: ldc 147
    //   13: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload_2
    //   18: ldc 46
    //   20: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload_2
    //   25: ldc 149
    //   27: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload_2
    //   32: ldc 151
    //   34: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload_2
    //   39: ldc 153
    //   41: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload_2
    //   46: ldc 155
    //   48: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload_2
    //   53: ldc 157
    //   55: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload_2
    //   60: ldc 159
    //   62: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload_2
    //   67: ldc 161
    //   69: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload_2
    //   74: ldc 163
    //   76: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload_2
    //   81: ldc 165
    //   83: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload_2
    //   88: ldc 167
    //   90: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload_2
    //   95: ldc 165
    //   97: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload_2
    //   102: ldc 169
    //   104: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload_2
    //   109: ldc 157
    //   111: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload_2
    //   116: ldc 171
    //   118: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload_2
    //   123: ldc 157
    //   125: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload_2
    //   130: ldc 173
    //   132: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload_2
    //   137: ldc 157
    //   139: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload_2
    //   144: ldc 175
    //   146: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload_2
    //   151: ldc 177
    //   153: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload_2
    //   158: ldc 179
    //   160: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: ldc 181
    //   166: iconst_1
    //   167: anewarray 72	java/lang/Object
    //   170: dup
    //   171: iconst_0
    //   172: aload_2
    //   173: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: aastore
    //   177: invokestatic 75	com/tencent/featuretoggle/utils/LogUtils:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   180: aload_1
    //   181: aload_2
    //   182: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokevirtual 54	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   188: goto +19 -> 207
    //   191: astore_1
    //   192: goto +18 -> 210
    //   195: astore_1
    //   196: aload_1
    //   197: invokestatic 59	com/tencent/featuretoggle/utils/LogUtils:a	(Ljava/lang/Throwable;)Z
    //   200: ifne +7 -> 207
    //   203: aload_1
    //   204: invokevirtual 62	java/lang/Throwable:printStackTrace	()V
    //   207: aload_0
    //   208: monitorexit
    //   209: return
    //   210: aload_0
    //   211: monitorexit
    //   212: aload_1
    //   213: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	this	DBOpenHelper
    //   0	214	1	paramSQLiteDatabase	SQLiteDatabase
    //   9	173	2	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	188	191	finally
    //   196	207	191	finally
    //   2	188	195	java/lang/Throwable
  }
  
  @TargetApi(11)
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    try
    {
      if (DeviceUtils.c() >= 11)
      {
        LogUtils.b("downgrade %d to %d drop tables!}", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
    LogUtils.b("upgrade %d to %d , update tables!", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 1) && (paramInt2 == 2)) {}
    try
    {
      paramSQLiteDatabase.execSQL(String.format("ALTER TABLE %s ADD %s varchar(20);", new Object[] { "t_f_e", "_abt" }));
      return;
    }
    catch (Exception localException)
    {
      b(paramSQLiteDatabase);
      if (LogUtils.a(localException)) {
        return;
      }
      localException.printStackTrace();
    }
    if ((paramInt1 == 2) && (paramInt2 == 3))
    {
      paramSQLiteDatabase.execSQL(String.format("ALTER TABLE %s ADD %s varchar(20);", new Object[] { "t_f_e", "_dsid" }));
      paramSQLiteDatabase.execSQL(String.format("ALTER TABLE %s ADD %s varchar(20);", new Object[] { "t_f_e", "_dsvid" }));
      return;
    }
    b(paramSQLiteDatabase);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.db.DBOpenHelper
 * JD-Core Version:    0.7.0.1
 */