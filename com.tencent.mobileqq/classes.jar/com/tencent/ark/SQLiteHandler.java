package com.tencent.ark;

import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
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
        ENV.logE("ArkApp.SQLiteHandler", String.format("Failed to find closeDB %s", new Object[] { paramDBInstanse.toString() }));
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
        ENV.logE("ArkApp.SQLiteHandler", String.format("Failed to find closeStatement %s", new Object[] { paramDBStatement.toString() }));
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
      ENV.logE("ArkApp.SQLiteHandler", String.format("Failed to find createDB %s", new Object[] { paramString.toString() }));
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
        ENV.logE("ArkApp.SQLiteHandler", String.format("Failed to find createStatement %s", new Object[] { paramDBInstanse.toString() }));
      }
    }
    return null;
  }
  
  public static boolean execSQL(SQLiteHandler.DBInstanse paramDBInstanse, String paramString)
  {
    if (paramDBInstanse != null) {
      try
      {
        ENV.logD("ArkApp.SQLiteHandler", String.format("execSQL  %s", new Object[] { paramString }));
        paramDBInstanse.db.execSQL(paramString);
        return true;
      }
      catch (Exception paramDBInstanse)
      {
        ENV.logE("ArkApp.SQLiteHandler", String.format("Failed to find execSQL %s", new Object[] { paramDBInstanse.toString() }));
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
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramDBStatement != null)
    {
      arrayOfByte = paramArrayOfByte;
      if (paramDBStatement.isQuery)
      {
        arrayOfByte = paramArrayOfByte;
        if (!paramDBStatement.queryHasRow) {}
      }
    }
    try
    {
      arrayOfByte = paramDBStatement.cursor.getBlob(paramInt);
      return arrayOfByte;
    }
    catch (Exception paramDBStatement)
    {
      ENV.logE("ArkApp.SQLiteHandler", String.format("Failed to find queryGetBlobField %s", new Object[] { paramDBStatement.toString() }));
    }
    return paramArrayOfByte;
  }
  
  public static double queryGetDoubleField(SQLiteHandler.DBStatement paramDBStatement, int paramInt, double paramDouble)
  {
    double d = paramDouble;
    if (paramDBStatement != null)
    {
      d = paramDouble;
      if (paramDBStatement.isQuery)
      {
        d = paramDouble;
        if (!paramDBStatement.queryHasRow) {}
      }
    }
    try
    {
      d = paramDBStatement.cursor.getDouble(paramInt);
      return d;
    }
    catch (Exception paramDBStatement)
    {
      ENV.logE("ArkApp.SQLiteHandler", String.format("Failed to find queryGetDoubleField %s", new Object[] { paramDBStatement.toString() }));
    }
    return paramDouble;
  }
  
  public static long queryGetLongField(SQLiteHandler.DBStatement paramDBStatement, int paramInt, long paramLong)
  {
    long l = paramLong;
    if (paramDBStatement != null)
    {
      l = paramLong;
      if (paramDBStatement.isQuery)
      {
        l = paramLong;
        if (!paramDBStatement.queryHasRow) {}
      }
    }
    try
    {
      l = paramDBStatement.cursor.getLong(paramInt);
      return l;
    }
    catch (Exception paramDBStatement)
    {
      ENV.logE("ArkApp.SQLiteHandler", String.format("Failed to find queryGetLongField %s", new Object[] { paramDBStatement.toString() }));
    }
    return paramLong;
  }
  
  public static String queryGetStrField(SQLiteHandler.DBStatement paramDBStatement, int paramInt, String paramString)
  {
    String str = paramString;
    if (paramDBStatement != null)
    {
      str = paramString;
      if (paramDBStatement.isQuery)
      {
        str = paramString;
        if (!paramDBStatement.queryHasRow) {}
      }
    }
    try
    {
      str = paramDBStatement.cursor.getString(paramInt);
      return str;
    }
    catch (Exception paramDBStatement)
    {
      ENV.logE("ArkApp.SQLiteHandler", String.format("Failed to find queryGetStrField %s", new Object[] { paramDBStatement.toString() }));
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
        ENV.logE("ArkApp.SQLiteHandler", String.format("Failed to find statementBindBlob %s", new Object[] { paramDBStatement.toString() }));
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
        ENV.logE("ArkApp.SQLiteHandler", String.format("Failed to find statementBindDouble %s", new Object[] { paramDBStatement.toString() }));
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
        ENV.logE("ArkApp.SQLiteHandler", String.format("Failed to find statementBindLong %s", new Object[] { paramDBStatement.toString() }));
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
      ENV.logE("ArkApp.SQLiteHandler", String.format("Failed to find statementBindStr %s", new Object[] { paramDBStatement.toString() }));
    }
    return false;
  }
  
  public static boolean statementExec(SQLiteHandler.DBStatement paramDBStatement)
  {
    if (paramDBStatement != null) {}
    try
    {
      if (paramDBStatement.isQuery)
      {
        if (ENV.mIsDebug) {
          ENV.logD("ArkApp.SQLiteHandler", String.format("statementExec is query %s", new Object[] { paramDBStatement.querySql }));
        }
        String[] arrayOfString = new String[paramDBStatement.queryParams.size()];
        arrayOfString = (String[])paramDBStatement.queryParams.toArray(arrayOfString);
        paramDBStatement.cursor = paramDBStatement.db.rawQuery(paramDBStatement.querySql, arrayOfString);
        paramDBStatement.queryHasRow = paramDBStatement.cursor.moveToFirst();
        boolean bool = paramDBStatement.queryHasRow;
        if (!paramDBStatement.isQuery) {}
        try
        {
          paramDBStatement.db.endTransaction();
          return bool;
        }
        catch (Exception paramDBStatement)
        {
          ENV.logE("ArkApp.SQLiteHandler", String.format("ark.SQLiteHandler.statementExec.finally %s", new Object[] { paramDBStatement.toString() }));
          return bool;
        }
      }
      paramDBStatement.db.beginTransaction();
      paramDBStatement.stmt.execute();
      paramDBStatement.db.setTransactionSuccessful();
      if (!paramDBStatement.isQuery) {}
      try
      {
        paramDBStatement.db.endTransaction();
        return true;
      }
      catch (Exception paramDBStatement)
      {
        for (;;)
        {
          ENV.logE("ArkApp.SQLiteHandler", String.format("ark.SQLiteHandler.statementExec.finally %s", new Object[] { paramDBStatement.toString() }));
        }
      }
      try
      {
        paramDBStatement.db.endTransaction();
        throw localObject;
      }
      catch (Exception paramDBStatement)
      {
        for (;;)
        {
          ENV.logE("ArkApp.SQLiteHandler", String.format("ark.SQLiteHandler.statementExec.finally %s", new Object[] { paramDBStatement.toString() }));
        }
      }
    }
    catch (SQLiteConstraintException localSQLiteConstraintException)
    {
      if (!paramDBStatement.isQuery) {}
      try
      {
        paramDBStatement.db.endTransaction();
        return false;
      }
      catch (Exception paramDBStatement)
      {
        for (;;)
        {
          ENV.logE("ArkApp.SQLiteHandler", String.format("ark.SQLiteHandler.statementExec.finally %s", new Object[] { paramDBStatement.toString() }));
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ENV.logE("ArkApp.SQLiteHandler", String.format("ark.SQLiteHandler.statementExec %s", new Object[] { localException.toString() }));
        if (!paramDBStatement.isQuery) {
          try
          {
            paramDBStatement.db.endTransaction();
          }
          catch (Exception paramDBStatement)
          {
            ENV.logE("ArkApp.SQLiteHandler", String.format("ark.SQLiteHandler.statementExec.finally %s", new Object[] { paramDBStatement.toString() }));
          }
        }
      }
    }
    finally
    {
      if (paramDBStatement.isQuery) {}
    }
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
      ENV.logE("ArkApp.SQLiteHandler", String.format("ark.SQLiteHandler.statementReset %s", new Object[] { paramDBStatement.toString() }));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ark.SQLiteHandler
 * JD-Core Version:    0.7.0.1
 */