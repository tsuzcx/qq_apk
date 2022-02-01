package com.tencent.ark;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import java.util.ArrayList;

public class SQLiteHandler
{
  protected static final ArkEnvironmentManager ENV = ;
  private static final String TAG = "ArkApp.SQLiteHandler";
  
  public static boolean closeDB(SQLiteHandler.DBInstanse paramDBInstanse)
  {
    if ((paramDBInstanse != null) && (paramDBInstanse.db != null)) {
      try
      {
        paramDBInstanse.db.close();
        return true;
      }
      catch (Exception paramDBInstanse)
      {
        Logger.logE("ArkApp.SQLiteHandler", String.format("Failed to find closeDB %s", new Object[] { paramDBInstanse.toString() }));
      }
    }
    return false;
  }
  
  public static boolean closeStatement(SQLiteHandler.DBStatement paramDBStatement)
  {
    if (paramDBStatement != null) {
      try
      {
        if (paramDBStatement.cursor != null)
        {
          paramDBStatement.cursor.close();
          paramDBStatement.cursor = null;
        }
        if (paramDBStatement.stmt != null)
        {
          paramDBStatement.stmt.close();
          paramDBStatement.stmt = null;
        }
        paramDBStatement.isQuery = false;
        paramDBStatement.queryParams = null;
        paramDBStatement.querySql = null;
        return true;
      }
      catch (Exception paramDBStatement)
      {
        Logger.logE("ArkApp.SQLiteHandler", String.format("Failed to find closeStatement %s", new Object[] { paramDBStatement.toString() }));
      }
    }
    return false;
  }
  
  public static SQLiteHandler.DBInstanse createDB(String paramString)
  {
    try
    {
      paramString = SQLiteDatabase.openOrCreateDatabase(paramString, null);
      if ((paramString != null) && (paramString.isOpen()))
      {
        SQLiteHandler.DBInstanse localDBInstanse = new SQLiteHandler.DBInstanse();
        localDBInstanse.db = paramString;
        return localDBInstanse;
      }
    }
    catch (Exception paramString)
    {
      Logger.logE("ArkApp.SQLiteHandler", String.format("Failed to find createDB %s", new Object[] { paramString.toString() }));
    }
    return null;
  }
  
  public static SQLiteHandler.DBStatement createStatement(SQLiteHandler.DBInstanse paramDBInstanse, String paramString, boolean paramBoolean)
  {
    if (paramDBInstanse != null) {
      try
      {
        SQLiteHandler.DBStatement localDBStatement = new SQLiteHandler.DBStatement();
        localDBStatement.db = paramDBInstanse.db;
        localDBStatement.isQuery = paramBoolean;
        if (paramBoolean)
        {
          localDBStatement.querySql = paramString;
          localDBStatement.queryParams = new ArrayList();
          return localDBStatement;
        }
        localDBStatement.stmt = paramDBInstanse.db.compileStatement(paramString);
        return localDBStatement;
      }
      catch (Exception paramDBInstanse)
      {
        Logger.logE("ArkApp.SQLiteHandler", String.format("Failed to find createStatement %s", new Object[] { paramDBInstanse.toString() }));
      }
    }
    return null;
  }
  
  public static boolean execSQL(SQLiteHandler.DBInstanse paramDBInstanse, String paramString)
  {
    if (paramDBInstanse != null) {
      try
      {
        Logger.logD("ArkApp.SQLiteHandler", String.format("execSQL  %s", new Object[] { paramString }));
        paramDBInstanse.db.execSQL(paramString);
        return true;
      }
      catch (Exception paramDBInstanse)
      {
        Logger.logE("ArkApp.SQLiteHandler", String.format("Failed to find execSQL %s", new Object[] { paramDBInstanse.toString() }));
      }
    }
    return false;
  }
  
  public static boolean moveToNext(SQLiteHandler.DBStatement paramDBStatement)
  {
    return paramDBStatement.cursor.moveToNext();
  }
  
  public static byte[] queryGetBlobField(SQLiteHandler.DBStatement paramDBStatement, int paramInt, byte[] paramArrayOfByte)
  {
    if ((paramDBStatement != null) && (paramDBStatement.isQuery) && (paramDBStatement.queryHasRow)) {
      try
      {
        paramDBStatement = paramDBStatement.cursor.getBlob(paramInt);
        return paramDBStatement;
      }
      catch (Exception paramDBStatement)
      {
        Logger.logE("ArkApp.SQLiteHandler", String.format("Failed to find queryGetBlobField %s", new Object[] { paramDBStatement.toString() }));
      }
    }
    return paramArrayOfByte;
  }
  
  public static double queryGetDoubleField(SQLiteHandler.DBStatement paramDBStatement, int paramInt, double paramDouble)
  {
    if ((paramDBStatement != null) && (paramDBStatement.isQuery) && (paramDBStatement.queryHasRow)) {
      try
      {
        double d = paramDBStatement.cursor.getDouble(paramInt);
        return d;
      }
      catch (Exception paramDBStatement)
      {
        Logger.logE("ArkApp.SQLiteHandler", String.format("Failed to find queryGetDoubleField %s", new Object[] { paramDBStatement.toString() }));
      }
    }
    return paramDouble;
  }
  
  public static long queryGetLongField(SQLiteHandler.DBStatement paramDBStatement, int paramInt, long paramLong)
  {
    if ((paramDBStatement != null) && (paramDBStatement.isQuery) && (paramDBStatement.queryHasRow)) {
      try
      {
        long l = paramDBStatement.cursor.getLong(paramInt);
        return l;
      }
      catch (Exception paramDBStatement)
      {
        Logger.logE("ArkApp.SQLiteHandler", String.format("Failed to find queryGetLongField %s", new Object[] { paramDBStatement.toString() }));
      }
    }
    return paramLong;
  }
  
  public static String queryGetStrField(SQLiteHandler.DBStatement paramDBStatement, int paramInt, String paramString)
  {
    if ((paramDBStatement != null) && (paramDBStatement.isQuery) && (paramDBStatement.queryHasRow)) {
      try
      {
        paramDBStatement = paramDBStatement.cursor.getString(paramInt);
        return paramDBStatement;
      }
      catch (Exception paramDBStatement)
      {
        Logger.logE("ArkApp.SQLiteHandler", String.format("Failed to find queryGetStrField %s", new Object[] { paramDBStatement.toString() }));
      }
    }
    return paramString;
  }
  
  public static boolean statementBindBlob(SQLiteHandler.DBStatement paramDBStatement, byte[] paramArrayOfByte)
  {
    if (paramDBStatement != null) {
      try
      {
        if (paramDBStatement.isQuery) {
          return false;
        }
        SQLiteStatement localSQLiteStatement = paramDBStatement.stmt;
        int i = paramDBStatement.index;
        paramDBStatement.index = (i + 1);
        localSQLiteStatement.bindBlob(i, paramArrayOfByte);
        return true;
      }
      catch (Exception paramDBStatement)
      {
        Logger.logE("ArkApp.SQLiteHandler", String.format("Failed to find statementBindBlob %s", new Object[] { paramDBStatement.toString() }));
      }
    }
    return false;
  }
  
  public static boolean statementBindDouble(SQLiteHandler.DBStatement paramDBStatement, double paramDouble)
  {
    if (paramDBStatement != null) {
      try
      {
        if (paramDBStatement.isQuery)
        {
          paramDBStatement.queryParams.add(String.valueOf(paramDouble));
          return true;
        }
        SQLiteStatement localSQLiteStatement = paramDBStatement.stmt;
        int i = paramDBStatement.index;
        paramDBStatement.index = (i + 1);
        localSQLiteStatement.bindDouble(i, paramDouble);
        return true;
      }
      catch (Exception paramDBStatement)
      {
        Logger.logE("ArkApp.SQLiteHandler", String.format("Failed to find statementBindDouble %s", new Object[] { paramDBStatement.toString() }));
      }
    }
    return false;
  }
  
  public static boolean statementBindLong(SQLiteHandler.DBStatement paramDBStatement, long paramLong)
  {
    if (paramDBStatement != null) {
      try
      {
        if (paramDBStatement.isQuery)
        {
          paramDBStatement.queryParams.add(String.valueOf(paramLong));
          return true;
        }
        SQLiteStatement localSQLiteStatement = paramDBStatement.stmt;
        int i = paramDBStatement.index;
        paramDBStatement.index = (i + 1);
        localSQLiteStatement.bindLong(i, paramLong);
        return true;
      }
      catch (Exception paramDBStatement)
      {
        Logger.logE("ArkApp.SQLiteHandler", String.format("Failed to find statementBindLong %s", new Object[] { paramDBStatement.toString() }));
      }
    }
    return false;
  }
  
  public static boolean statementBindStr(SQLiteHandler.DBStatement paramDBStatement, String paramString)
  {
    try
    {
      if (paramDBStatement.isQuery)
      {
        paramDBStatement.queryParams.add(paramString);
        return true;
      }
      SQLiteStatement localSQLiteStatement = paramDBStatement.stmt;
      int i = paramDBStatement.index;
      paramDBStatement.index = (i + 1);
      localSQLiteStatement.bindString(i, paramString);
      return true;
    }
    catch (Exception paramDBStatement)
    {
      Logger.logE("ArkApp.SQLiteHandler", String.format("Failed to find statementBindStr %s", new Object[] { paramDBStatement.toString() }));
    }
    return false;
  }
  
  /* Error */
  public static boolean statementExec(SQLiteHandler.DBStatement paramDBStatement)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +342 -> 343
    //   4: aload_0
    //   5: getfield 79	com/tencent/ark/SQLiteHandler$DBStatement:isQuery	Z
    //   8: ifeq +130 -> 138
    //   11: getstatic 20	com/tencent/ark/SQLiteHandler:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   14: getfield 217	com/tencent/ark/ArkEnvironmentManager:mIsDebug	Z
    //   17: ifeq +24 -> 41
    //   20: ldc 10
    //   22: ldc 219
    //   24: iconst_1
    //   25: anewarray 4	java/lang/Object
    //   28: dup
    //   29: iconst_0
    //   30: aload_0
    //   31: getfield 86	com/tencent/ark/SQLiteHandler$DBStatement:querySql	Ljava/lang/String;
    //   34: aastore
    //   35: invokestatic 51	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   38: invokestatic 121	com/tencent/ark/Logger:logD	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: aload_0
    //   42: getfield 83	com/tencent/ark/SQLiteHandler$DBStatement:queryParams	Ljava/util/ArrayList;
    //   45: invokevirtual 223	java/util/ArrayList:size	()I
    //   48: anewarray 47	java/lang/String
    //   51: astore_2
    //   52: aload_0
    //   53: getfield 83	com/tencent/ark/SQLiteHandler$DBStatement:queryParams	Ljava/util/ArrayList;
    //   56: aload_2
    //   57: invokevirtual 227	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   60: checkcast 229	[Ljava/lang/String;
    //   63: astore_2
    //   64: aload_0
    //   65: aload_0
    //   66: getfield 105	com/tencent/ark/SQLiteHandler$DBStatement:db	Landroid/database/sqlite/SQLiteDatabase;
    //   69: aload_0
    //   70: getfield 86	com/tencent/ark/SQLiteHandler$DBStatement:querySql	Ljava/lang/String;
    //   73: aload_2
    //   74: invokevirtual 233	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   77: putfield 65	com/tencent/ark/SQLiteHandler$DBStatement:cursor	Landroid/database/Cursor;
    //   80: aload_0
    //   81: aload_0
    //   82: getfield 65	com/tencent/ark/SQLiteHandler$DBStatement:cursor	Landroid/database/Cursor;
    //   85: invokeinterface 236 1 0
    //   90: putfield 134	com/tencent/ark/SQLiteHandler$DBStatement:queryHasRow	Z
    //   93: aload_0
    //   94: getfield 134	com/tencent/ark/SQLiteHandler$DBStatement:queryHasRow	Z
    //   97: istore_1
    //   98: aload_0
    //   99: getfield 79	com/tencent/ark/SQLiteHandler$DBStatement:isQuery	Z
    //   102: ifne +34 -> 136
    //   105: aload_0
    //   106: getfield 105	com/tencent/ark/SQLiteHandler$DBStatement:db	Landroid/database/sqlite/SQLiteDatabase;
    //   109: invokevirtual 239	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   112: iload_1
    //   113: ireturn
    //   114: astore_0
    //   115: ldc 10
    //   117: ldc 241
    //   119: iconst_1
    //   120: anewarray 4	java/lang/Object
    //   123: dup
    //   124: iconst_0
    //   125: aload_0
    //   126: invokevirtual 45	java/lang/Exception:toString	()Ljava/lang/String;
    //   129: aastore
    //   130: invokestatic 51	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   133: invokestatic 57	com/tencent/ark/Logger:logE	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: iload_1
    //   137: ireturn
    //   138: aload_0
    //   139: getfield 105	com/tencent/ark/SQLiteHandler$DBStatement:db	Landroid/database/sqlite/SQLiteDatabase;
    //   142: invokevirtual 244	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   145: aload_0
    //   146: getfield 72	com/tencent/ark/SQLiteHandler$DBStatement:stmt	Landroid/database/sqlite/SQLiteStatement;
    //   149: invokevirtual 247	android/database/sqlite/SQLiteStatement:execute	()V
    //   152: aload_0
    //   153: getfield 105	com/tencent/ark/SQLiteHandler$DBStatement:db	Landroid/database/sqlite/SQLiteDatabase;
    //   156: invokevirtual 250	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   159: aload_0
    //   160: getfield 79	com/tencent/ark/SQLiteHandler$DBStatement:isQuery	Z
    //   163: ifne +34 -> 197
    //   166: aload_0
    //   167: getfield 105	com/tencent/ark/SQLiteHandler$DBStatement:db	Landroid/database/sqlite/SQLiteDatabase;
    //   170: invokevirtual 239	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   173: iconst_1
    //   174: ireturn
    //   175: astore_0
    //   176: ldc 10
    //   178: ldc 241
    //   180: iconst_1
    //   181: anewarray 4	java/lang/Object
    //   184: dup
    //   185: iconst_0
    //   186: aload_0
    //   187: invokevirtual 45	java/lang/Exception:toString	()Ljava/lang/String;
    //   190: aastore
    //   191: invokestatic 51	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   194: invokestatic 57	com/tencent/ark/Logger:logE	(Ljava/lang/String;Ljava/lang/String;)V
    //   197: iconst_1
    //   198: ireturn
    //   199: astore_2
    //   200: goto +62 -> 262
    //   203: astore_2
    //   204: ldc 10
    //   206: ldc 252
    //   208: iconst_1
    //   209: anewarray 4	java/lang/Object
    //   212: dup
    //   213: iconst_0
    //   214: aload_2
    //   215: invokevirtual 45	java/lang/Exception:toString	()Ljava/lang/String;
    //   218: aastore
    //   219: invokestatic 51	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   222: invokestatic 57	com/tencent/ark/Logger:logE	(Ljava/lang/String;Ljava/lang/String;)V
    //   225: aload_0
    //   226: getfield 79	com/tencent/ark/SQLiteHandler$DBStatement:isQuery	Z
    //   229: ifne +114 -> 343
    //   232: aload_0
    //   233: getfield 105	com/tencent/ark/SQLiteHandler$DBStatement:db	Landroid/database/sqlite/SQLiteDatabase;
    //   236: invokevirtual 239	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   239: iconst_0
    //   240: ireturn
    //   241: astore_0
    //   242: ldc 241
    //   244: iconst_1
    //   245: anewarray 4	java/lang/Object
    //   248: dup
    //   249: iconst_0
    //   250: aload_0
    //   251: invokevirtual 45	java/lang/Exception:toString	()Ljava/lang/String;
    //   254: aastore
    //   255: invokestatic 51	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   258: astore_0
    //   259: goto +78 -> 337
    //   262: aload_0
    //   263: getfield 79	com/tencent/ark/SQLiteHandler$DBStatement:isQuery	Z
    //   266: ifne +35 -> 301
    //   269: aload_0
    //   270: getfield 105	com/tencent/ark/SQLiteHandler$DBStatement:db	Landroid/database/sqlite/SQLiteDatabase;
    //   273: invokevirtual 239	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   276: goto +25 -> 301
    //   279: astore_0
    //   280: ldc 10
    //   282: ldc 241
    //   284: iconst_1
    //   285: anewarray 4	java/lang/Object
    //   288: dup
    //   289: iconst_0
    //   290: aload_0
    //   291: invokevirtual 45	java/lang/Exception:toString	()Ljava/lang/String;
    //   294: aastore
    //   295: invokestatic 51	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   298: invokestatic 57	com/tencent/ark/Logger:logE	(Ljava/lang/String;Ljava/lang/String;)V
    //   301: aload_2
    //   302: athrow
    //   303: aload_0
    //   304: getfield 79	com/tencent/ark/SQLiteHandler$DBStatement:isQuery	Z
    //   307: ifne +36 -> 343
    //   310: aload_0
    //   311: getfield 105	com/tencent/ark/SQLiteHandler$DBStatement:db	Landroid/database/sqlite/SQLiteDatabase;
    //   314: invokevirtual 239	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   317: iconst_0
    //   318: ireturn
    //   319: astore_0
    //   320: ldc 241
    //   322: iconst_1
    //   323: anewarray 4	java/lang/Object
    //   326: dup
    //   327: iconst_0
    //   328: aload_0
    //   329: invokevirtual 45	java/lang/Exception:toString	()Ljava/lang/String;
    //   332: aastore
    //   333: invokestatic 51	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   336: astore_0
    //   337: ldc 10
    //   339: aload_0
    //   340: invokestatic 57	com/tencent/ark/Logger:logE	(Ljava/lang/String;Ljava/lang/String;)V
    //   343: iconst_0
    //   344: ireturn
    //   345: astore_2
    //   346: goto -43 -> 303
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	349	0	paramDBStatement	SQLiteHandler.DBStatement
    //   97	40	1	bool	boolean
    //   51	23	2	arrayOfString	String[]
    //   199	1	2	localObject	Object
    //   203	99	2	localException	Exception
    //   345	1	2	localSQLiteConstraintException	android.database.sqlite.SQLiteConstraintException
    // Exception table:
    //   from	to	target	type
    //   105	112	114	java/lang/Exception
    //   166	173	175	java/lang/Exception
    //   4	41	199	finally
    //   41	98	199	finally
    //   138	159	199	finally
    //   204	225	199	finally
    //   4	41	203	java/lang/Exception
    //   41	98	203	java/lang/Exception
    //   138	159	203	java/lang/Exception
    //   232	239	241	java/lang/Exception
    //   269	276	279	java/lang/Exception
    //   310	317	319	java/lang/Exception
    //   4	41	345	android/database/sqlite/SQLiteConstraintException
    //   41	98	345	android/database/sqlite/SQLiteConstraintException
    //   138	159	345	android/database/sqlite/SQLiteConstraintException
  }
  
  public static boolean statementReset(SQLiteHandler.DBStatement paramDBStatement)
  {
    if (paramDBStatement == null) {
      return false;
    }
    try
    {
      paramDBStatement.index = 1;
      return true;
    }
    catch (Exception paramDBStatement)
    {
      Logger.logE("ArkApp.SQLiteHandler", String.format("ark.SQLiteHandler.statementReset %s", new Object[] { paramDBStatement.toString() }));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.SQLiteHandler
 * JD-Core Version:    0.7.0.1
 */