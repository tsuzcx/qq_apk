package com.tencent.mobileqq.app;

import com.tencent.mobileqq.imcore.constants.AppConstants;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.StatisticCollector;
import com.tencent.mobileqq.persistence.TableNameCache;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.util.HashMap;

public class SQLiteOpenHelper
{
  private static final String REPORT_WAL_EXCEPTION = "actWALException";
  private static final String REPORT_WAL_READ_EXCEPTION_KEY = "ReadWALException";
  private static final String REPORT_WAL_WRITE_EXCEPTION_KEY = "WriteWALException";
  public static final String TAG = "SQLiteOpenHelper";
  public static boolean WAL_ENABLE = false;
  public static String WAL_FLAG_FILE_PATH = AppConstants.SDCARD_PATH + "WalFlag";
  private static boolean sTryWalException = false;
  private SQLiteDatabase dbR;
  private SQLiteDatabase dbW;
  private android.database.sqlite.SQLiteOpenHelper helper;
  private TableNameCache tbnCache = new TableNameCache();
  
  public SQLiteOpenHelper(android.database.sqlite.SQLiteOpenHelper paramSQLiteOpenHelper)
  {
    QLog.d("SQLiteOpenHelper", 1, new Object[] { " new SQLiteOpenHelper  helper = ", paramSQLiteOpenHelper, " this = ", this });
    if (QLog.isColorLevel()) {
      QLog.d("SQLiteOpenHelper", 1, new Object[] { " new SQLiteOpenHelper, db name = ", paramSQLiteOpenHelper.getDatabaseName() });
    }
    this.helper = paramSQLiteOpenHelper;
  }
  
  public static final void throwDebugException(Exception paramException) {}
  
  /* Error */
  public void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 92	com/tencent/mobileqq/app/SQLiteOpenHelper:dbR	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   6: ifnull +94 -> 100
    //   9: aload_0
    //   10: getfield 92	com/tencent/mobileqq/app/SQLiteOpenHelper:dbR	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   13: invokevirtual 96	java/lang/Object:hashCode	()I
    //   16: invokestatic 102	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   19: astore_1
    //   20: aload_0
    //   21: getfield 104	com/tencent/mobileqq/app/SQLiteOpenHelper:dbW	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   24: ifnull +82 -> 106
    //   27: aload_0
    //   28: getfield 104	com/tencent/mobileqq/app/SQLiteOpenHelper:dbW	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   31: invokevirtual 96	java/lang/Object:hashCode	()I
    //   34: invokestatic 102	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   37: astore_2
    //   38: ldc 17
    //   40: iconst_1
    //   41: bipush 8
    //   43: anewarray 4	java/lang/Object
    //   46: dup
    //   47: iconst_0
    //   48: ldc 106
    //   50: aastore
    //   51: dup
    //   52: iconst_1
    //   53: aload_1
    //   54: aastore
    //   55: dup
    //   56: iconst_2
    //   57: ldc 108
    //   59: aastore
    //   60: dup
    //   61: iconst_3
    //   62: aload_2
    //   63: aastore
    //   64: dup
    //   65: iconst_4
    //   66: ldc 110
    //   68: aastore
    //   69: dup
    //   70: iconst_5
    //   71: aload_0
    //   72: getfield 87	com/tencent/mobileqq/app/SQLiteOpenHelper:helper	Landroid/database/sqlite/SQLiteOpenHelper;
    //   75: aastore
    //   76: dup
    //   77: bipush 6
    //   79: ldc 68
    //   81: aastore
    //   82: dup
    //   83: bipush 7
    //   85: aload_0
    //   86: aastore
    //   87: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   90: aload_0
    //   91: getfield 87	com/tencent/mobileqq/app/SQLiteOpenHelper:helper	Landroid/database/sqlite/SQLiteOpenHelper;
    //   94: invokevirtual 112	android/database/sqlite/SQLiteOpenHelper:close	()V
    //   97: aload_0
    //   98: monitorexit
    //   99: return
    //   100: ldc 114
    //   102: astore_1
    //   103: goto -83 -> 20
    //   106: ldc 114
    //   108: astore_2
    //   109: goto -71 -> 38
    //   112: astore_1
    //   113: aload_0
    //   114: monitorexit
    //   115: aload_1
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	SQLiteOpenHelper
    //   19	84	1	localObject1	Object
    //   112	4	1	localObject2	Object
    //   37	72	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	112	finally
    //   20	38	112	finally
    //   38	97	112	finally
  }
  
  public SQLiteDatabase getReadableDatabase()
  {
    for (;;)
    {
      try
      {
        localSQLiteDatabase = this.helper.getReadableDatabase();
        if ((WAL_ENABLE) && (VersionUtils.isHoneycomb()) && (localSQLiteDatabase != null))
        {
          boolean bool = sTryWalException;
          if (bool) {}
        }
      }
      catch (Exception localException)
      {
        android.database.sqlite.SQLiteDatabase localSQLiteDatabase;
        if (this.dbR == null) {
          break label556;
        }
        Object localObject2 = Integer.valueOf(this.dbR.hashCode());
        QLog.e("SQLiteOpenHelper", 1, new Object[] { "getReadableDatabase error, ", "dbR = ", localObject2, " helper = ", this.helper, " this = ", this });
        QLog.e("SQLiteOpenHelper", 1, "getReadableDatabase", localException);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SQLiteOpenHelper", 1, new Object[] { " getReadableDatabase error, db name = ", this.helper.getDatabaseName() });
        throwDebugException(localException);
        continue;
      }
      finally {}
      try
      {
        localSQLiteDatabase.enableWriteAheadLogging();
        if (localSQLiteDatabase == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("SQLiteOpenHelper", 1, new Object[] { "rdbIsNull, ", Integer.valueOf(this.helper.hashCode()), new Exception(), " this =", this });
          }
        }
        else
        {
          if ((this.dbR == null) || (this.dbR.db != localSQLiteDatabase))
          {
            if (this.dbR == null) {
              break label562;
            }
            localObject1 = Integer.valueOf(this.dbR.hashCode());
            if (localSQLiteDatabase == null) {
              break label568;
            }
            Integer localInteger = Integer.valueOf(localSQLiteDatabase.hashCode());
            QLog.d("SQLiteOpenHelper", 1, new Object[] { "check dbRIsNull: ", localObject1, " dbIsNull: ", localInteger });
            this.dbR = new SQLiteDatabase(localSQLiteDatabase, this.tbnCache, this.helper.getDatabaseName());
            if (this.dbR == null) {
              break label550;
            }
            localObject1 = Integer.valueOf(this.dbR.hashCode());
            QLog.d("SQLiteOpenHelper", 1, new Object[] { "new dbR = ", localObject1, " helper = ", this.helper, " this = ", this });
          }
          Object localObject1 = this.dbR;
          return localObject1;
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
        QLog.e("SQLiteOpenHelper", 1, new Object[] { "try WAL enalbe exception ", localIllegalStateException, " helper = ", this.helper, " this = ", this });
        if (QLog.isColorLevel()) {
          QLog.d("SQLiteOpenHelper", 1, new Object[] { " try WAL enalbe exception, db name = ", this.helper.getDatabaseName() });
        }
        sTryWalException = true;
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("ReadWALException", "1");
        IMCoreProxyRoute.StatisticCollector.collectPerformance(null, "actWALException", true, 0L, 0L, (HashMap)localObject2, null);
        continue;
      }
      QLog.e("SQLiteOpenHelper", 1, new Object[] { "rdbIsNull, ", Integer.valueOf(this.helper.hashCode()), " helper = ", this.helper, " this = ", this });
      continue;
      label550:
      String str1 = "null";
      continue;
      label556:
      str1 = "null";
      continue;
      label562:
      str1 = "null";
      continue;
      label568:
      String str2 = "null";
    }
  }
  
  public SQLiteDatabase getWritableDatabase()
  {
    for (;;)
    {
      try
      {
        localSQLiteDatabase = this.helper.getWritableDatabase();
        if ((WAL_ENABLE) && (VersionUtils.isHoneycomb()) && (localSQLiteDatabase != null))
        {
          boolean bool = sTryWalException;
          if (bool) {}
        }
      }
      catch (Exception localException)
      {
        android.database.sqlite.SQLiteDatabase localSQLiteDatabase;
        if (this.dbW == null) {
          break label570;
        }
        Object localObject2 = Integer.valueOf(this.dbW.hashCode());
        QLog.e("SQLiteOpenHelper", 1, new Object[] { "getWritableDatabase error, ", "dbW = ", localObject2, " helper = ", this.helper, " this = ", this });
        QLog.e("SQLiteOpenHelper", 1, "getWritableDatabase", localException);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SQLiteOpenHelper", 1, new Object[] { " getWritableDatabase error, db name = ", this.helper.getDatabaseName() });
        throwDebugException(localException);
        continue;
      }
      finally {}
      try
      {
        localSQLiteDatabase.enableWriteAheadLogging();
        if (localSQLiteDatabase == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("SQLiteOpenHelper", 1, new Object[] { "wdbIsNull, ", Integer.valueOf(this.helper.hashCode()), new Exception(), " helper = ", this.helper, " this = ", this });
          }
        }
        else
        {
          if ((this.dbW == null) || (this.dbW.db != localSQLiteDatabase))
          {
            if (this.dbW == null) {
              break label576;
            }
            localObject1 = Integer.valueOf(this.dbW.hashCode());
            if (localSQLiteDatabase == null) {
              break label582;
            }
            Integer localInteger = Integer.valueOf(localSQLiteDatabase.hashCode());
            QLog.d("SQLiteOpenHelper", 1, new Object[] { "check dbWIsNull: ", localObject1, " dbIsNull: ", localInteger });
            this.dbW = new SQLiteDatabase(localSQLiteDatabase, this.tbnCache, this.helper.getDatabaseName());
            if (this.dbW == null) {
              break label564;
            }
            localObject1 = Integer.valueOf(this.dbW.hashCode());
            QLog.d("SQLiteOpenHelper", 1, new Object[] { "new dbW = ", localObject1, " helper = ", this.helper, " this = ", this });
          }
          Object localObject1 = this.dbW;
          return localObject1;
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
        QLog.e("SQLiteOpenHelper", 1, new Object[] { "try WAL enalbe exception ", localIllegalStateException, " helper = ", this.helper, " this = ", this });
        if (QLog.isColorLevel()) {
          QLog.d("SQLiteOpenHelper", 1, new Object[] { " try WAL enalbe exception, db name = ", this.helper.getDatabaseName() });
        }
        sTryWalException = true;
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("WriteWALException", "1");
        IMCoreProxyRoute.StatisticCollector.collectPerformance(null, "actWALException", true, 0L, 0L, (HashMap)localObject2, null);
        continue;
      }
      QLog.e("SQLiteOpenHelper", 1, new Object[] { "wdbIsNull, ", Integer.valueOf(this.helper.hashCode()), " helper = ", this.helper, " this = ", this });
      continue;
      label564:
      String str1 = "null";
      continue;
      label570:
      str1 = "null";
      continue;
      label576:
      str1 = "null";
      continue;
      label582:
      String str2 = "null";
    }
  }
  
  /* Error */
  public void stop()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 92	com/tencent/mobileqq/app/SQLiteOpenHelper:dbR	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   6: ifnull +92 -> 98
    //   9: aload_0
    //   10: getfield 92	com/tencent/mobileqq/app/SQLiteOpenHelper:dbR	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   13: invokevirtual 96	java/lang/Object:hashCode	()I
    //   16: invokestatic 102	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   19: astore_1
    //   20: aload_0
    //   21: getfield 104	com/tencent/mobileqq/app/SQLiteOpenHelper:dbW	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   24: ifnull +80 -> 104
    //   27: aload_0
    //   28: getfield 104	com/tencent/mobileqq/app/SQLiteOpenHelper:dbW	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   31: invokevirtual 96	java/lang/Object:hashCode	()I
    //   34: invokestatic 102	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   37: astore_2
    //   38: ldc 17
    //   40: iconst_1
    //   41: bipush 8
    //   43: anewarray 4	java/lang/Object
    //   46: dup
    //   47: iconst_0
    //   48: ldc 206
    //   50: aastore
    //   51: dup
    //   52: iconst_1
    //   53: aload_1
    //   54: aastore
    //   55: dup
    //   56: iconst_2
    //   57: ldc 108
    //   59: aastore
    //   60: dup
    //   61: iconst_3
    //   62: aload_2
    //   63: aastore
    //   64: dup
    //   65: iconst_4
    //   66: ldc 110
    //   68: aastore
    //   69: dup
    //   70: iconst_5
    //   71: aload_0
    //   72: getfield 87	com/tencent/mobileqq/app/SQLiteOpenHelper:helper	Landroid/database/sqlite/SQLiteOpenHelper;
    //   75: aastore
    //   76: dup
    //   77: bipush 6
    //   79: ldc 68
    //   81: aastore
    //   82: dup
    //   83: bipush 7
    //   85: aload_0
    //   86: aastore
    //   87: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   90: aload_0
    //   91: aconst_null
    //   92: putfield 87	com/tencent/mobileqq/app/SQLiteOpenHelper:helper	Landroid/database/sqlite/SQLiteOpenHelper;
    //   95: aload_0
    //   96: monitorexit
    //   97: return
    //   98: ldc 114
    //   100: astore_1
    //   101: goto -81 -> 20
    //   104: ldc 114
    //   106: astore_2
    //   107: goto -69 -> 38
    //   110: astore_1
    //   111: aload_0
    //   112: monitorexit
    //   113: aload_1
    //   114: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	this	SQLiteOpenHelper
    //   19	82	1	localObject1	Object
    //   110	4	1	localObject2	Object
    //   37	70	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	110	finally
    //   20	38	110	finally
    //   38	95	110	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SQLiteOpenHelper
 * JD-Core Version:    0.7.0.1
 */