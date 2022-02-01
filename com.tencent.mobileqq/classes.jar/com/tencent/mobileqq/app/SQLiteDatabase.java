package com.tencent.mobileqq.app;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.db.DBThreadMonitor;
import com.tencent.mobileqq.imcore.proxy.basic.StatisticCollectorProxy;
import com.tencent.mobileqq.imcore.proxy.msg.AIOUtilsProxy;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.TableNameCache;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQLiteDatabase
{
  private static final String DBTRANSLOG = "SQLiteDatabase";
  private static final long DB_ERROR_CHECK_INTERNAL = 240000L;
  private static final int DB_ERROR_THRESHOLD_COUNT = 10;
  private static final long DB_ERROR_TOAST_INTERNAL = 21600000L;
  private static final boolean OPEN_DB_LOG = false;
  private static final String REPORT_TAG_OP_TABLE_NAME = "OpTableName";
  private static final String REPORT_TAG_OP_TYPE = "OpType";
  private static final int SAMPLE_SIZE = 500;
  private static final int SAMPLE_SIZE_FOR_INSERT = 100;
  static final String SQL_GET_TABLE_ATTR = "select sql from sqlite_master where type=? and name=?";
  private static final String TAG = "db";
  private static final String TAG_SQLITE_DB = "SQLiteDataBaseLog";
  public static final String TOAST_DB_CORRUPTION = "DB读写异常，请联系 williscao";
  public static final String TOAST_PROCESS = "进程：";
  private static final String UIN_SAMPLE_SUFFIX = "59.db";
  private static int dbError_count;
  private static long dbError_lastCheckTime = 0L;
  private static long dbError_lastToastTime;
  private static boolean dbError_toastTimeInited;
  public static boolean sIsLogcatDBOperation = false;
  final android.database.sqlite.SQLiteDatabase db;
  private DBThreadMonitor mDBThreadMonitor = new DBThreadMonitor("SQLiteDataBaseLog");
  private long mOpCount = 0L;
  private boolean mUinNeedReport = false;
  private final Map<String, ArrayList<String>> queryCacheMap = new ConcurrentHashMap(32);
  private final Map<String, ArrayList<String>> tableMap = new ConcurrentHashMap(32);
  private TableNameCache tableNameCache = null;
  
  static
  {
    dbError_count = 0;
    dbError_toastTimeInited = false;
    dbError_lastToastTime = 0L;
  }
  
  SQLiteDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, TableNameCache paramTableNameCache, String paramString)
  {
    this.db = paramSQLiteDatabase;
    this.tableNameCache = paramTableNameCache;
    if ((TextUtils.isEmpty(paramString)) || (paramString.endsWith("59.db"))) {
      bool = true;
    }
    this.mUinNeedReport = bool;
  }
  
  private ArrayList<String> analyseRawQueryWhere(String paramString)
  {
    if (this.queryCacheMap.containsKey(paramString)) {
      return (ArrayList)this.queryCacheMap.get(paramString);
    }
    Matcher localMatcher = Pattern.compile("\\s*\\w+\\s*(>|<|=|>=|<=|!=|=!|<>)\\s*\\?\\s*").matcher(paramString);
    ArrayList localArrayList = new ArrayList();
    while (localMatcher.find())
    {
      Object localObject = localMatcher.group().trim();
      localObject = Pattern.compile("\\w+").matcher((CharSequence)localObject);
      ((Matcher)localObject).find();
      localArrayList.add(((Matcher)localObject).group());
    }
    this.queryCacheMap.put(paramString, localArrayList);
    return localArrayList;
  }
  
  private ArrayList<String> analyseTableField(String paramString, String[] paramArrayOfString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("db", 2, paramString);
    }
    try
    {
      String[] arrayOfString1 = paramString.substring(paramString.indexOf("(") + 1, paramString.indexOf(")")).split(",");
      ArrayList localArrayList = new ArrayList();
      int k = paramArrayOfString.length;
      int i = 0;
      for (;;)
      {
        paramString = localArrayList;
        if (i >= k) {
          break;
        }
        paramString = paramArrayOfString[i].toLowerCase();
        int m = arrayOfString1.length;
        int j = 0;
        while (j < m)
        {
          String[] arrayOfString2 = arrayOfString1[j].trim().split(" ");
          if ((arrayOfString2.length > 1) && (paramString.equals(arrayOfString2[1].toLowerCase()))) {
            localArrayList.add(arrayOfString2[0]);
          }
          j += 1;
        }
        i += 1;
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("db", 2, "analyseTableField exception: ", paramString);
      }
      paramString = new ArrayList();
    }
  }
  
  public static void beginTransactionLog() {}
  
  private void buildTableNameCache()
  {
    if (!this.tableNameCache.isInit) {}
    try
    {
      String[] arrayOfString = getAllTableNameFromDB();
      this.tableNameCache.initTableCache(arrayOfString);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("db", 2, "buildTableNameCache exception", localException);
    }
  }
  
  private byte[] convertBlob(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return paramArrayOfByte;
    }
    return SecurityUtile.encode(paramArrayOfByte);
  }
  
  private ContentValues convertContentValues(String paramString, ContentValues paramContentValues)
  {
    if ((paramContentValues == null) || (paramContentValues.size() <= 0)) {
      return paramContentValues;
    }
    ContentValues localContentValues = new ContentValues(paramContentValues);
    paramString = getTableInfo(paramString);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        String str = (String)paramString.next();
        if (paramContentValues.containsKey(str))
        {
          Object localObject = paramContentValues.get(str);
          if ((localObject instanceof String))
          {
            localObject = (String)paramContentValues.get(str);
            if ((localObject != null) && (((String)localObject).length() > 0)) {
              localContentValues.put(str, convertStr(localObject));
            }
          }
          else if ((localObject instanceof byte[]))
          {
            localContentValues.put(str, convertBlob((byte[])localObject));
          }
        }
      }
    }
    return localContentValues;
  }
  
  private String convertStr(Object paramObject)
  {
    if (paramObject == null) {
      paramObject = null;
    }
    String str;
    do
    {
      return paramObject;
      str = paramObject.toString();
      paramObject = str;
    } while (str.length() <= 0);
    return SecurityUtile.encode(str);
  }
  
  private void convertWhereValues(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    if ((paramString2 == null) || (paramArrayOfString == null)) {}
    for (;;)
    {
      return;
      paramString1 = getTableInfo(paramString1);
      if (paramString1 != null)
      {
        paramString2 = analyseRawQueryWhere(paramString2);
        int i = 0;
        while (i < paramString2.size())
        {
          if ((paramString1.contains(paramString2.get(i))) && ((paramArrayOfString[i] instanceof String))) {
            paramArrayOfString[i] = convertStr(paramArrayOfString[i]);
          }
          i += 1;
        }
      }
    }
  }
  
  private static int countDuplicates(StackTraceElement[] paramArrayOfStackTraceElement1, StackTraceElement[] paramArrayOfStackTraceElement2)
  {
    int i = 0;
    int j = paramArrayOfStackTraceElement2.length;
    int k = paramArrayOfStackTraceElement1.length;
    for (;;)
    {
      k -= 1;
      if (k < 0) {
        break;
      }
      j -= 1;
      if ((j < 0) || (!paramArrayOfStackTraceElement2[j].equals(paramArrayOfStackTraceElement1[k]))) {
        break;
      }
      i += 1;
    }
    return i;
  }
  
  private void detectIllegalMsgDelete(String paramString1, String paramString2) {}
  
  public static void endTransactionLog() {}
  
  public static boolean filterExtensionInfoTableLog(String paramString1, String paramString2)
  {
    return (TextUtils.equals("ExtensionInfo", paramString1)) && (!TextUtils.isEmpty(paramString2)) && ((paramString2.contains("intimate_type=1")) || (paramString2.contains("hiddenChatSwitch=1")) || (paramString2.contains("isSharingLocation=1")));
  }
  
  public static Map<String, SQLiteDatabase.DbHistory> getCursorTrace()
  {
    return null;
  }
  
  private ArrayList<String> getTableInfo(String paramString)
  {
    if (!this.tableMap.containsKey(paramString))
    {
      Cursor localCursor = rawQuery("select sql from sqlite_master where type=? and name=?", new String[] { "table", paramString });
      if (localCursor != null)
      {
        if (localCursor.moveToFirst())
        {
          ArrayList localArrayList = analyseTableField(SecurityUtile.decode(localCursor.getString(0)), new String[] { "TEXT", "BLOB" });
          this.tableMap.put(paramString, localArrayList);
        }
        localCursor.close();
      }
    }
    return (ArrayList)this.tableMap.get(paramString);
  }
  
  private void handleDBErr(Throwable paramThrowable)
  {
    StringBuilder localStringBuilder;
    if ((QLog.isColorLevel()) && (paramThrowable.getMessage() != null) && (!paramThrowable.getMessage().contains("no such table")))
    {
      QLog.e("SQLiteDatabase", 2, paramThrowable.getMessage());
      localStringBuilder = new StringBuilder();
    }
    try
    {
      printDBErrStackTrace(paramThrowable, localStringBuilder, "", null, 0);
      label55:
      QLog.e("SQLiteDatabase", 2, new Object[] { localStringBuilder });
      return;
    }
    catch (Exception paramThrowable)
    {
      break label55;
    }
  }
  
  private void handleDBErr(Throwable paramThrowable, String paramString)
  {
    if (System.currentTimeMillis() - EntityManagerFactory.corruptedTime < 100L) {}
    for (boolean bool = true;; bool = false)
    {
      if (((paramThrowable instanceof SQLiteDatabaseCorruptException)) || (bool))
      {
        QLog.e("SQLiteDatabase", 1, paramString + " " + bool);
        EntityManagerFactory.corruptedTime = -1L;
      }
      handleDBErr(paramThrowable);
      return;
    }
  }
  
  public static void loadIsLogcatDBOperation()
  {
    sIsLogcatDBOperation = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getBoolean("isLogcatDBOperation", false);
  }
  
  private static void logcatSQLiteProfiler(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject, long paramLong)
  {
    int i = 0;
    if ((QLog.isColorLevel()) || (filterExtensionInfoTableLog(paramString2, paramString3)))
    {
      Object localObject = Thread.currentThread();
      String str = ((Thread)localObject).getName();
      boolean bool;
      if (localObject == Looper.getMainLooper().getThread())
      {
        bool = true;
        localObject = new StringBuilder(512);
        ((StringBuilder)localObject).append("TableName:").append(paramString2).append('|');
        ((StringBuilder)localObject).append("ExecuteType:").append(paramString1).append("|");
        ((StringBuilder)localObject).append("CurrentThreadName:").append(str).append('|');
        ((StringBuilder)localObject).append("IsMainThread:").append(bool).append('|');
        ((StringBuilder)localObject).append("Cost:").append(paramLong).append('|');
        ((StringBuilder)localObject).append("CMD:").append(paramString3);
        if (paramArrayOfObject == null) {
          break label228;
        }
        int j = paramArrayOfObject.length;
        label170:
        if (i >= j) {
          break label228;
        }
        paramString1 = paramArrayOfObject[i];
        if (paramString1 != null) {
          break label210;
        }
        ((StringBuilder)localObject).append("null,");
      }
      for (;;)
      {
        i += 1;
        break label170;
        bool = false;
        break;
        label210:
        ((StringBuilder)localObject).append(paramString1.toString()).append(',');
      }
      label228:
      paramString1 = ((StringBuilder)localObject).toString();
      paramArrayOfObject = new RuntimeException("ExtensionInfo table change ");
      paramArrayOfObject.fillInStackTrace();
      if (!bool) {
        break label337;
      }
      if ((!sIsLogcatDBOperation) && (!filterExtensionInfoTableLog(paramString2, paramString3))) {
        break label303;
      }
      QLog.d("SQLiteDataBaseLog", 1, "isMainThread = true, " + paramString1 + ", StackTrace = ", paramArrayOfObject);
    }
    label303:
    label337:
    do
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("SQLiteDataBaseLog", 2, "isMainThread = true, " + paramString1, paramArrayOfObject);
      return;
      if ((sIsLogcatDBOperation) || (filterExtensionInfoTableLog(paramString2, paramString3)))
      {
        QLog.d("SQLiteDataBaseLog", 1, paramString1 + ", StackTrace = ", paramArrayOfObject);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SQLiteDataBaseLog", 2, paramString1);
  }
  
  private void outputExtensionInfoLog(String paramString1, ContentValues paramContentValues, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramContentValues != null) && (TextUtils.equals("ExtensionInfo", paramString1)) && (filterExtensionInfoTableLog(paramString1, paramContentValues + ""))) {
      QLog.d("SQLiteDataBaseLog", 1, "from = " + paramString2 + ", contentValues = " + paramContentValues);
    }
  }
  
  private void printDBErrStackTrace(Throwable paramThrowable, StringBuilder paramStringBuilder, String paramString, StackTraceElement[] paramArrayOfStackTraceElement, int paramInt)
  {
    int j = 0;
    if (paramStringBuilder == null) {
      paramStringBuilder = new StringBuilder();
    }
    for (;;)
    {
      paramStringBuilder.append(paramThrowable.toString());
      paramStringBuilder.append("\n");
      StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
      if (arrayOfStackTraceElement != null)
      {
        int i;
        if (paramArrayOfStackTraceElement != null)
        {
          i = countDuplicates(arrayOfStackTraceElement, paramArrayOfStackTraceElement);
          if (j >= arrayOfStackTraceElement.length - i) {
            break label175;
          }
          if (j >= 3) {
            break label124;
          }
          paramStringBuilder.append(paramString);
          paramStringBuilder.append("\tat ");
          paramStringBuilder.append(arrayOfStackTraceElement[j].toString());
          paramStringBuilder.append("\n");
        }
        for (;;)
        {
          j += 1;
          break;
          i = 0;
          break;
          label124:
          if (j == arrayOfStackTraceElement.length - i - 1)
          {
            paramStringBuilder.append(paramString);
            paramStringBuilder.append("\t...at ");
            paramStringBuilder.append(arrayOfStackTraceElement[j].toString());
            paramStringBuilder.append("\n");
          }
        }
        label175:
        if (i > 0)
        {
          paramStringBuilder.append(paramString);
          paramStringBuilder.append("\t... ");
          paramStringBuilder.append(Integer.toString(i));
          paramStringBuilder.append(" more\n");
        }
      }
      if ((paramThrowable.getCause() != null) && (paramInt < 5))
      {
        paramStringBuilder.append(paramString);
        paramStringBuilder.append("Caused by: ");
        printDBErrStackTrace(paramThrowable, paramStringBuilder, paramString, arrayOfStackTraceElement, paramInt + 1);
      }
      return;
    }
  }
  
  private Cursor query(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    long l1 = System.currentTimeMillis();
    convertWhereValues(paramString1, paramString2, paramArrayOfString2);
    for (;;)
    {
      try
      {
        this.mDBThreadMonitor.a();
        localCursor = this.db.query(false, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6);
      }
      catch (Throwable paramArrayOfString2)
      {
        long l2;
        StringBuilder localStringBuilder;
        paramArrayOfString1 = null;
        paramString3 = new StringBuilder();
        paramString3.append("SELECT * FROM ");
        paramString3.append(paramString1);
        if (!TextUtils.isEmpty(paramString2))
        {
          paramString3.append(" WHERE ");
          paramString3.append(paramString2);
        }
        reportDbOperatorResult("query", paramString1, 1);
        handleDBErr(paramArrayOfString2, paramString3.toString());
        this.mDBThreadMonitor.b();
        continue;
      }
      finally
      {
        this.mDBThreadMonitor.b();
      }
      try
      {
        this.mDBThreadMonitor.b();
        l2 = System.currentTimeMillis();
        if ((!sIsLogcatDBOperation) && (!AIOUtilsProxy.getLogcatDBOperation())) {
          break label354;
        }
        localStringBuilder = new StringBuilder(32);
        localStringBuilder.append(paramArrayOfString1).append(";").append(paramString2).append(";");
        if (paramArrayOfString2 != null)
        {
          int j = paramArrayOfString2.length;
          i = 0;
          if (i < j)
          {
            localStringBuilder.append(paramArrayOfString2[i]);
            i += 1;
            continue;
          }
        }
        localStringBuilder.append(";").append(paramString3).append(";").append(paramString4).append(";").append(paramString5).append(";").append(paramString6);
        logcatSQLiteProfiler("query", paramString1, localStringBuilder.toString(), null, l2 - l1);
      }
      catch (Throwable paramArrayOfString2)
      {
        paramArrayOfString1 = localCursor;
        continue;
        if (localCursor == null) {
          continue;
        }
        i = 0;
        continue;
      }
      reportDbOperatorResult("query", paramString1, i);
      this.mDBThreadMonitor.b();
      paramArrayOfString1 = localCursor;
      MsgAutoMonitorUtil.getInstance().addDbIoTime(System.currentTimeMillis() - l1);
      return paramArrayOfString1;
      i = 1;
    }
  }
  
  private void reportDbOperatorResult(String paramString1, String paramString2, int paramInt)
  {
    if (!this.mUinNeedReport) {}
    do
    {
      return;
      this.mOpCount += 1L;
      if (!"insert".equals(paramString1)) {
        break;
      }
    } while (this.mOpCount % 100L != 0L);
    HashMap localHashMap = new HashMap(4);
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("OpType", paramString1);
    localHashMap.put("OpTableName", paramString2);
    localHashMap.put("param_FailCode", Integer.toString(paramInt));
    paramString1 = "DatabaseOperatorResult_" + paramString1;
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      StatisticCollectorProxy.collectPerformance("", paramString1, bool, 0L, 0L, localHashMap, null);
      return;
      if (this.mOpCount % 500L == 0L) {
        break;
      }
      return;
    }
  }
  
  public static void saveIsLogcatDBOperation(boolean paramBoolean)
  {
    if ((sIsLogcatDBOperation ^ paramBoolean))
    {
      sIsLogcatDBOperation = paramBoolean;
      SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit();
      localEditor.putBoolean("isLogcatDBOperation", paramBoolean);
      localEditor.commit();
    }
  }
  
  public void addToTableCache(String paramString)
  {
    this.tableNameCache.addToTableNameCache(paramString);
  }
  
  public void beginTransaction()
  {
    long l = System.currentTimeMillis();
    try
    {
      beginTransactionLog();
      this.db.beginTransaction();
      MsgAutoMonitorUtil.getInstance().addDbIoTime(System.currentTimeMillis() - l);
      MsgAutoMonitorUtil.getInstance().addDbIoTransaction(1L);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        handleDBErr(localThrowable, "beginTransaction");
      }
    }
  }
  
  @TargetApi(11)
  public void beginTransactionNonExclusive()
  {
    long l = System.currentTimeMillis();
    try
    {
      beginTransactionLog();
      this.db.beginTransactionNonExclusive();
      MsgAutoMonitorUtil.getInstance().addDbIoTime(System.currentTimeMillis() - l);
      MsgAutoMonitorUtil.getInstance().addDbIoTransaction(1L);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        handleDBErr(localThrowable, "beginTransactionNonExclusive");
      }
    }
  }
  
  public void close()
  {
    long l = System.currentTimeMillis();
    try
    {
      QLog.e("db", 1, "SQLiteDatabase close");
      this.db.close();
      MsgAutoMonitorUtil.getInstance().addDbIoTime(System.currentTimeMillis() - l);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        handleDBErr(localThrowable, "close");
      }
    }
  }
  
  public boolean containsTable(String paramString)
  {
    buildTableNameCache();
    return this.tableNameCache.isContainsTableInCache(paramString);
  }
  
  public int count(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    long l = System.currentTimeMillis();
    String str2 = "select count(*) from " + paramString1;
    String str1 = str2;
    if (paramString2 != null)
    {
      str1 = str2;
      if (paramArrayOfString != null)
      {
        convertWhereValues(paramString1, paramString2, paramArrayOfString);
        str1 = str2 + " where " + paramString2;
      }
    }
    paramString1 = rawQuery(str1, paramArrayOfString);
    int i;
    if (paramString1 != null)
    {
      paramString1.moveToFirst();
      i = paramString1.getInt(0);
      paramString1.close();
    }
    for (;;)
    {
      MsgAutoMonitorUtil.getInstance().addDbIoTime(System.currentTimeMillis() - l);
      return i;
      i = 0;
    }
  }
  
  public int delete(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    long l1 = System.currentTimeMillis();
    detectIllegalMsgDelete(paramString1, null);
    convertWhereValues(paramString1, paramString2, paramArrayOfString);
    try
    {
      this.mDBThreadMonitor.a();
      int i = this.db.delete(paramString1, paramString2, paramArrayOfString);
      this.mDBThreadMonitor.b();
      long l2 = System.currentTimeMillis() - l1;
      if ((sIsLogcatDBOperation) || (AIOUtilsProxy.getLogcatDBOperation())) {
        logcatSQLiteProfiler("delete", paramString1, paramString2 + ";", paramArrayOfString, l2);
      }
      MsgAutoMonitorUtil.getInstance().addDbIoTime(l2);
      reportDbOperatorResult("delete", paramString1, 0);
      return i;
    }
    catch (Throwable paramArrayOfString)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("DELETE FROM ").append(paramString1);
      if (!TextUtils.isEmpty(paramString2)) {}
      for (paramString2 = " WHERE " + paramString2;; paramString2 = "")
      {
        handleDBErr(paramArrayOfString, paramString2);
        reportDbOperatorResult("delete", paramString1, 1);
        this.mDBThreadMonitor.b();
        MsgAutoMonitorUtil.getInstance().addDbIoTime(System.currentTimeMillis() - l1);
        return -1;
      }
    }
    finally
    {
      this.mDBThreadMonitor.b();
    }
  }
  
  public void endTransaction()
  {
    long l = System.currentTimeMillis();
    try
    {
      this.db.endTransaction();
      endTransactionLog();
      MsgAutoMonitorUtil.getInstance().addDbIoTime(System.currentTimeMillis() - l);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        handleDBErr(localThrowable, "endTransaction");
      }
    }
  }
  
  public boolean execSQL(String paramString)
  {
    long l = System.currentTimeMillis();
    try
    {
      detectIllegalMsgDelete(null, paramString);
      this.mDBThreadMonitor.a();
      this.db.execSQL(paramString);
      this.mDBThreadMonitor.b();
      l = System.currentTimeMillis() - l;
      if ((sIsLogcatDBOperation) || (AIOUtilsProxy.getLogcatDBOperation())) {
        logcatSQLiteProfiler("execSQL", "", paramString, null, l);
      }
      MsgAutoMonitorUtil.getInstance().addDbIoTime(l);
      return true;
    }
    catch (Throwable localThrowable)
    {
      handleDBErr(localThrowable, paramString);
      return false;
    }
    finally
    {
      this.mDBThreadMonitor.b();
    }
  }
  
  public boolean execSQL(String paramString, Object[] paramArrayOfObject)
  {
    long l = System.currentTimeMillis();
    int i = 0;
    for (;;)
    {
      try
      {
        String str;
        if (i < paramArrayOfObject.length)
        {
          if ((paramArrayOfObject[i] instanceof String))
          {
            str = (String)paramArrayOfObject[i];
            if ((str.startsWith("mr_")) && (str.endsWith("_New")))
            {
              detectIllegalMsgDelete(str, paramString);
              this.mDBThreadMonitor.a();
              this.db.execSQL(paramString, paramArrayOfObject);
              this.mDBThreadMonitor.b();
              l = System.currentTimeMillis() - l;
              if ((sIsLogcatDBOperation) || (AIOUtilsProxy.getLogcatDBOperation())) {
                logcatSQLiteProfiler("execSQL", "", paramString, paramArrayOfObject, l);
              }
              MsgAutoMonitorUtil.getInstance().addDbIoTime(l);
              return true;
            }
          }
          i += 1;
        }
        else
        {
          str = null;
        }
      }
      catch (Throwable paramArrayOfObject)
      {
        handleDBErr(paramArrayOfObject, paramString);
        return false;
      }
      finally
      {
        this.mDBThreadMonitor.b();
      }
    }
  }
  
  public String[] getAllTableNameFromCache()
  {
    buildTableNameCache();
    return this.tableNameCache.getAllTableNames();
  }
  
  public String[] getAllTableNameFromDB()
  {
    Object localObject1 = null;
    Object localObject3 = null;
    int i = 0;
    long l = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        if (this.db != null)
        {
          this.mDBThreadMonitor.a();
          Cursor localCursor = this.db.rawQuery("select distinct tbl_name from Sqlite_master", null);
          this.mDBThreadMonitor.b();
          localObject1 = localObject3;
          if (localCursor != null)
          {
            localObject1 = localObject3;
            if (localCursor.moveToFirst())
            {
              localObject1 = new String[localCursor.getCount()];
              localObject1[i] = SecurityUtile.decode(localCursor.getString(0));
              if (localCursor.moveToNext()) {
                break label151;
              }
            }
          }
          if (localCursor != null) {
            localCursor.close();
          }
          MsgAutoMonitorUtil.getInstance().addDbIoTime(System.currentTimeMillis() - l);
        }
        else
        {
          return localObject1;
        }
      }
      finally
      {
        this.mDBThreadMonitor.b();
      }
      label151:
      i += 1;
    }
  }
  
  public int getCount(String paramString)
  {
    int i = 0;
    int j = 0;
    long l = System.currentTimeMillis();
    Cursor localCursor = rawQuery("select count() from " + paramString, null);
    if (localCursor != null) {
      i = j;
    }
    try
    {
      if (localCursor.moveToFirst()) {
        i = localCursor.getInt(0);
      }
      localCursor.close();
      MsgAutoMonitorUtil.getInstance().addDbIoTime(System.currentTimeMillis() - l);
      return i;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        handleDBErr(localThrowable, "select count() from " + paramString);
        i = j;
      }
    }
  }
  
  public int getCount(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    long l = System.currentTimeMillis();
    String str2 = "select count() from " + paramString;
    String str1 = null;
    if (paramLong1 >= 0L) {
      str1 = String.format(" where time >= %d and time <= %d ", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    }
    Object localObject = str1;
    if (paramInt1 == paramInt2)
    {
      if (str1 != null) {
        localObject = str1 + " and msgtype = " + paramInt1;
      }
    }
    else
    {
      str1 = str2;
      if (localObject != null) {
        str1 = str2 + (String)localObject;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("msgbackup_sqliteDB", 4, " getCount sql = " + str1);
      }
      localObject = rawQuery(str1, null);
      if (localObject == null) {
        break label288;
      }
    }
    for (;;)
    {
      try
      {
        if (((Cursor)localObject).moveToFirst())
        {
          paramInt1 = ((Cursor)localObject).getInt(0);
          ((Cursor)localObject).close();
          MsgAutoMonitorUtil.getInstance().addDbIoTime(System.currentTimeMillis() - l);
          return paramInt1;
          localObject = " where msgtype = " + paramInt1;
        }
      }
      catch (Throwable localThrowable)
      {
        handleDBErr(localThrowable, "select count() from " + paramString);
        paramInt1 = 0;
        continue;
      }
      label288:
      paramInt1 = 0;
    }
  }
  
  /* Error */
  public long insert(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    // Byte code:
    //   0: invokestatic 390	java/lang/System:currentTimeMillis	()J
    //   3: lstore 7
    //   5: aload_0
    //   6: aload_1
    //   7: aload_3
    //   8: invokespecial 725	com/tencent/mobileqq/app/SQLiteDatabase:convertContentValues	(Ljava/lang/String;Landroid/content/ContentValues;)Landroid/content/ContentValues;
    //   11: astore_3
    //   12: aload_0
    //   13: getfield 100	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   16: invokevirtual 535	com/tencent/mobileqq/app/db/DBThreadMonitor:a	()V
    //   19: aload_0
    //   20: getfield 106	com/tencent/mobileqq/app/SQLiteDatabase:db	Landroid/database/sqlite/SQLiteDatabase;
    //   23: aload_1
    //   24: aload_2
    //   25: aload_3
    //   26: invokevirtual 727	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   29: lstore 5
    //   31: aload_0
    //   32: getfield 100	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   35: invokevirtual 542	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   38: invokestatic 390	java/lang/System:currentTimeMillis	()J
    //   41: lload 7
    //   43: lsub
    //   44: lstore 7
    //   46: getstatic 69	com/tencent/mobileqq/app/SQLiteDatabase:sIsLogcatDBOperation	Z
    //   49: ifne +19 -> 68
    //   52: invokestatic 547	com/tencent/mobileqq/imcore/proxy/msg/AIOUtilsProxy:getLogcatDBOperation	()Z
    //   55: ifne +13 -> 68
    //   58: ldc_w 319
    //   61: aload_1
    //   62: invokestatic 322	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   65: ifeq +37 -> 102
    //   68: ldc_w 574
    //   71: aload_1
    //   72: new 373	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 374	java/lang/StringBuilder:<init>	()V
    //   79: aload_2
    //   80: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc_w 549
    //   86: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_3
    //   90: invokevirtual 497	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 407	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: aconst_null
    //   97: lload 7
    //   99: invokestatic 552	com/tencent/mobileqq/app/SQLiteDatabase:logcatSQLiteProfiler	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;J)V
    //   102: invokestatic 562	com/tencent/util/MsgAutoMonitorUtil:getInstance	()Lcom/tencent/util/MsgAutoMonitorUtil;
    //   105: lload 7
    //   107: invokevirtual 566	com/tencent/util/MsgAutoMonitorUtil:addDbIoTime	(J)V
    //   110: lload 5
    //   112: ldc2_w 408
    //   115: lcmp
    //   116: ifle +26 -> 142
    //   119: iconst_0
    //   120: istore 4
    //   122: aload_0
    //   123: ldc_w 574
    //   126: aload_1
    //   127: iload 4
    //   129: invokespecial 556	com/tencent/mobileqq/app/SQLiteDatabase:reportDbOperatorResult	(Ljava/lang/String;Ljava/lang/String;I)V
    //   132: aload_0
    //   133: getfield 100	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   136: invokevirtual 542	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   139: lload 5
    //   141: lreturn
    //   142: iconst_1
    //   143: istore 4
    //   145: goto -23 -> 122
    //   148: astore_2
    //   149: aload_3
    //   150: ifnull +63 -> 213
    //   153: aload_3
    //   154: invokevirtual 250	android/content/ContentValues:size	()I
    //   157: ifle +56 -> 213
    //   160: aload_3
    //   161: invokevirtual 250	android/content/ContentValues:size	()I
    //   164: istore 4
    //   166: aload_0
    //   167: aload_2
    //   168: ldc_w 729
    //   171: iconst_2
    //   172: anewarray 4	java/lang/Object
    //   175: dup
    //   176: iconst_0
    //   177: aload_1
    //   178: aastore
    //   179: dup
    //   180: iconst_1
    //   181: iload 4
    //   183: invokestatic 732	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   186: aastore
    //   187: invokestatic 708	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   190: invokespecial 572	com/tencent/mobileqq/app/SQLiteDatabase:handleDBErr	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   193: aload_0
    //   194: ldc_w 574
    //   197: aload_1
    //   198: iconst_1
    //   199: invokespecial 556	com/tencent/mobileqq/app/SQLiteDatabase:reportDbOperatorResult	(Ljava/lang/String;Ljava/lang/String;I)V
    //   202: aload_0
    //   203: getfield 100	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   206: invokevirtual 542	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   209: ldc2_w 408
    //   212: lreturn
    //   213: iconst_0
    //   214: istore 4
    //   216: goto -50 -> 166
    //   219: astore_1
    //   220: aload_0
    //   221: getfield 100	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   224: invokevirtual 542	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   227: aload_1
    //   228: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	this	SQLiteDatabase
    //   0	229	1	paramString1	String
    //   0	229	2	paramString2	String
    //   0	229	3	paramContentValues	ContentValues
    //   120	95	4	i	int
    //   29	111	5	l1	long
    //   3	103	7	l2	long
    // Exception table:
    //   from	to	target	type
    //   12	68	148	java/lang/Throwable
    //   68	102	148	java/lang/Throwable
    //   102	110	148	java/lang/Throwable
    //   122	132	148	java/lang/Throwable
    //   12	68	219	finally
    //   68	102	219	finally
    //   102	110	219	finally
    //   122	132	219	finally
    //   153	166	219	finally
    //   166	202	219	finally
  }
  
  public Cursor query(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return query(false, paramString1, null, paramString2, paramArrayOfString, null, null, null, null);
  }
  
  public Cursor query(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4)
  {
    return query(false, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, null, null, paramString3, paramString4);
  }
  
  /* Error */
  public Cursor rawQuery(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: invokestatic 390	java/lang/System:currentTimeMillis	()J
    //   3: lstore 5
    //   5: aload_0
    //   6: aload_2
    //   7: aload_3
    //   8: aload 4
    //   10: invokespecial 532	com/tencent/mobileqq/app/SQLiteDatabase:convertWhereValues	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield 100	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   17: invokevirtual 535	com/tencent/mobileqq/app/db/DBThreadMonitor:a	()V
    //   20: aload_0
    //   21: getfield 106	com/tencent/mobileqq/app/SQLiteDatabase:db	Landroid/database/sqlite/SQLiteDatabase;
    //   24: aload_1
    //   25: aload 4
    //   27: invokevirtual 687	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   30: astore 9
    //   32: aload_0
    //   33: getfield 100	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   36: invokevirtual 542	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   39: invokestatic 390	java/lang/System:currentTimeMillis	()J
    //   42: lstore 7
    //   44: getstatic 69	com/tencent/mobileqq/app/SQLiteDatabase:sIsLogcatDBOperation	Z
    //   47: ifne +9 -> 56
    //   50: invokestatic 547	com/tencent/mobileqq/imcore/proxy/msg/AIOUtilsProxy:getLogcatDBOperation	()Z
    //   53: ifeq +41 -> 94
    //   56: ldc_w 737
    //   59: aload_2
    //   60: new 373	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 374	java/lang/StringBuilder:<init>	()V
    //   67: aload_1
    //   68: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc_w 549
    //   74: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload_3
    //   78: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 407	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: aload 4
    //   86: lload 7
    //   88: lload 5
    //   90: lsub
    //   91: invokestatic 552	com/tencent/mobileqq/app/SQLiteDatabase:logcatSQLiteProfiler	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;J)V
    //   94: aload_0
    //   95: getfield 100	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   98: invokevirtual 542	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   101: aload 9
    //   103: astore_2
    //   104: invokestatic 562	com/tencent/util/MsgAutoMonitorUtil:getInstance	()Lcom/tencent/util/MsgAutoMonitorUtil;
    //   107: invokestatic 390	java/lang/System:currentTimeMillis	()J
    //   110: lload 5
    //   112: lsub
    //   113: invokevirtual 566	com/tencent/util/MsgAutoMonitorUtil:addDbIoTime	(J)V
    //   116: aload_2
    //   117: areturn
    //   118: astore_3
    //   119: aconst_null
    //   120: astore_2
    //   121: aload_0
    //   122: aload_3
    //   123: aload_1
    //   124: invokespecial 572	com/tencent/mobileqq/app/SQLiteDatabase:handleDBErr	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   127: aload_0
    //   128: getfield 100	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   131: invokevirtual 542	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   134: goto -30 -> 104
    //   137: astore_1
    //   138: aload_0
    //   139: getfield 100	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   142: invokevirtual 542	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   145: aload_1
    //   146: athrow
    //   147: astore_3
    //   148: aload 9
    //   150: astore_2
    //   151: goto -30 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	SQLiteDatabase
    //   0	154	1	paramString1	String
    //   0	154	2	paramString2	String
    //   0	154	3	paramString3	String
    //   0	154	4	paramArrayOfString	String[]
    //   3	108	5	l1	long
    //   42	45	7	l2	long
    //   30	119	9	localCursor	Cursor
    // Exception table:
    //   from	to	target	type
    //   13	32	118	java/lang/Throwable
    //   13	32	137	finally
    //   32	56	137	finally
    //   56	94	137	finally
    //   121	127	137	finally
    //   32	56	147	java/lang/Throwable
    //   56	94	147	java/lang/Throwable
  }
  
  /* Error */
  @java.lang.Deprecated
  public Cursor rawQuery(String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: invokestatic 390	java/lang/System:currentTimeMillis	()J
    //   3: lstore_3
    //   4: aload_0
    //   5: getfield 100	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   8: invokevirtual 535	com/tencent/mobileqq/app/db/DBThreadMonitor:a	()V
    //   11: aload_0
    //   12: getfield 106	com/tencent/mobileqq/app/SQLiteDatabase:db	Landroid/database/sqlite/SQLiteDatabase;
    //   15: aload_1
    //   16: aload_2
    //   17: invokevirtual 687	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   20: astore 5
    //   22: aload_0
    //   23: getfield 100	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   26: invokevirtual 542	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   29: aload_0
    //   30: getfield 100	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   33: invokevirtual 542	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   36: invokestatic 390	java/lang/System:currentTimeMillis	()J
    //   39: lload_3
    //   40: lsub
    //   41: lstore_3
    //   42: invokestatic 562	com/tencent/util/MsgAutoMonitorUtil:getInstance	()Lcom/tencent/util/MsgAutoMonitorUtil;
    //   45: lload_3
    //   46: invokevirtual 566	com/tencent/util/MsgAutoMonitorUtil:addDbIoTime	(J)V
    //   49: aload 5
    //   51: astore 6
    //   53: invokestatic 178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   56: ifeq +62 -> 118
    //   59: ldc 37
    //   61: iconst_2
    //   62: new 373	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 374	java/lang/StringBuilder:<init>	()V
    //   69: ldc_w 740
    //   72: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_1
    //   76: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: ldc_w 742
    //   82: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_2
    //   86: invokestatic 747	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   89: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: ldc_w 749
    //   95: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: lload_3
    //   99: invokevirtual 473	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   102: ldc_w 751
    //   105: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 407	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: aload 5
    //   116: astore 6
    //   118: aload 6
    //   120: areturn
    //   121: astore 6
    //   123: aconst_null
    //   124: astore 5
    //   126: aload_0
    //   127: aload 6
    //   129: aload_1
    //   130: invokespecial 572	com/tencent/mobileqq/app/SQLiteDatabase:handleDBErr	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   133: aload_0
    //   134: getfield 100	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   137: invokevirtual 542	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   140: invokestatic 390	java/lang/System:currentTimeMillis	()J
    //   143: lload_3
    //   144: lsub
    //   145: lstore_3
    //   146: invokestatic 562	com/tencent/util/MsgAutoMonitorUtil:getInstance	()Lcom/tencent/util/MsgAutoMonitorUtil;
    //   149: lload_3
    //   150: invokevirtual 566	com/tencent/util/MsgAutoMonitorUtil:addDbIoTime	(J)V
    //   153: aload 5
    //   155: astore 6
    //   157: invokestatic 178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   160: ifeq -42 -> 118
    //   163: ldc 37
    //   165: iconst_2
    //   166: new 373	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 374	java/lang/StringBuilder:<init>	()V
    //   173: ldc_w 740
    //   176: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: aload_1
    //   180: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: ldc_w 742
    //   186: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: aload_2
    //   190: invokestatic 747	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   193: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: ldc_w 749
    //   199: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: lload_3
    //   203: invokevirtual 473	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   206: ldc_w 751
    //   209: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 407	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   218: aload 5
    //   220: areturn
    //   221: astore 5
    //   223: aload_0
    //   224: getfield 100	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   227: invokevirtual 542	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   230: invokestatic 390	java/lang/System:currentTimeMillis	()J
    //   233: lload_3
    //   234: lsub
    //   235: lstore_3
    //   236: invokestatic 562	com/tencent/util/MsgAutoMonitorUtil:getInstance	()Lcom/tencent/util/MsgAutoMonitorUtil;
    //   239: lload_3
    //   240: invokevirtual 566	com/tencent/util/MsgAutoMonitorUtil:addDbIoTime	(J)V
    //   243: invokestatic 178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   246: ifeq +58 -> 304
    //   249: ldc 37
    //   251: iconst_2
    //   252: new 373	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 374	java/lang/StringBuilder:<init>	()V
    //   259: ldc_w 740
    //   262: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: aload_1
    //   266: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: ldc_w 742
    //   272: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload_2
    //   276: invokestatic 747	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   279: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: ldc_w 749
    //   285: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: lload_3
    //   289: invokevirtual 473	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   292: ldc_w 751
    //   295: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: invokevirtual 407	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   304: aload 5
    //   306: athrow
    //   307: astore 6
    //   309: goto -183 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	this	SQLiteDatabase
    //   0	312	1	paramString	String
    //   0	312	2	paramArrayOfString	String[]
    //   3	286	3	l	long
    //   20	199	5	localCursor1	Cursor
    //   221	84	5	localObject	Object
    //   51	68	6	localCursor2	Cursor
    //   121	7	6	localThrowable1	Throwable
    //   155	1	6	localCursor3	Cursor
    //   307	1	6	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   4	22	121	java/lang/Throwable
    //   4	22	221	finally
    //   22	29	221	finally
    //   126	133	221	finally
    //   22	29	307	java/lang/Throwable
  }
  
  public void removeFromTableCache(String paramString)
  {
    this.tableNameCache.deleteFromTableCache(paramString);
  }
  
  /* Error */
  public long replace(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    // Byte code:
    //   0: invokestatic 390	java/lang/System:currentTimeMillis	()J
    //   3: lstore 7
    //   5: aload_0
    //   6: aload_1
    //   7: aload_3
    //   8: invokespecial 725	com/tencent/mobileqq/app/SQLiteDatabase:convertContentValues	(Ljava/lang/String;Landroid/content/ContentValues;)Landroid/content/ContentValues;
    //   11: astore_3
    //   12: aload_0
    //   13: getfield 100	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   16: invokevirtual 535	com/tencent/mobileqq/app/db/DBThreadMonitor:a	()V
    //   19: aload_0
    //   20: getfield 106	com/tencent/mobileqq/app/SQLiteDatabase:db	Landroid/database/sqlite/SQLiteDatabase;
    //   23: aload_1
    //   24: aload_2
    //   25: aload_3
    //   26: invokevirtual 759	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   29: lstore 5
    //   31: aload_0
    //   32: getfield 100	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   35: invokevirtual 542	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   38: invokestatic 390	java/lang/System:currentTimeMillis	()J
    //   41: lload 7
    //   43: lsub
    //   44: lstore 7
    //   46: getstatic 69	com/tencent/mobileqq/app/SQLiteDatabase:sIsLogcatDBOperation	Z
    //   49: ifne +19 -> 68
    //   52: invokestatic 547	com/tencent/mobileqq/imcore/proxy/msg/AIOUtilsProxy:getLogcatDBOperation	()Z
    //   55: ifne +13 -> 68
    //   58: ldc_w 319
    //   61: aload_1
    //   62: invokestatic 322	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   65: ifeq +37 -> 102
    //   68: ldc_w 760
    //   71: aload_1
    //   72: new 373	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 374	java/lang/StringBuilder:<init>	()V
    //   79: aload_2
    //   80: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc_w 549
    //   86: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_3
    //   90: invokevirtual 497	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 407	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: aconst_null
    //   97: lload 7
    //   99: invokestatic 552	com/tencent/mobileqq/app/SQLiteDatabase:logcatSQLiteProfiler	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;J)V
    //   102: invokestatic 562	com/tencent/util/MsgAutoMonitorUtil:getInstance	()Lcom/tencent/util/MsgAutoMonitorUtil;
    //   105: lload 7
    //   107: invokevirtual 566	com/tencent/util/MsgAutoMonitorUtil:addDbIoTime	(J)V
    //   110: lload 5
    //   112: ldc2_w 408
    //   115: lcmp
    //   116: ifle +26 -> 142
    //   119: iconst_0
    //   120: istore 4
    //   122: aload_0
    //   123: ldc_w 760
    //   126: aload_1
    //   127: iload 4
    //   129: invokespecial 556	com/tencent/mobileqq/app/SQLiteDatabase:reportDbOperatorResult	(Ljava/lang/String;Ljava/lang/String;I)V
    //   132: aload_0
    //   133: getfield 100	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   136: invokevirtual 542	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   139: lload 5
    //   141: lreturn
    //   142: iconst_1
    //   143: istore 4
    //   145: goto -23 -> 122
    //   148: astore_2
    //   149: aload_3
    //   150: ifnull +63 -> 213
    //   153: aload_3
    //   154: invokevirtual 250	android/content/ContentValues:size	()I
    //   157: ifle +56 -> 213
    //   160: aload_3
    //   161: invokevirtual 250	android/content/ContentValues:size	()I
    //   164: istore 4
    //   166: aload_0
    //   167: aload_2
    //   168: ldc_w 762
    //   171: iconst_2
    //   172: anewarray 4	java/lang/Object
    //   175: dup
    //   176: iconst_0
    //   177: aload_1
    //   178: aastore
    //   179: dup
    //   180: iconst_1
    //   181: iload 4
    //   183: invokestatic 732	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   186: aastore
    //   187: invokestatic 708	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   190: invokespecial 572	com/tencent/mobileqq/app/SQLiteDatabase:handleDBErr	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   193: aload_0
    //   194: ldc_w 760
    //   197: aload_1
    //   198: iconst_1
    //   199: invokespecial 556	com/tencent/mobileqq/app/SQLiteDatabase:reportDbOperatorResult	(Ljava/lang/String;Ljava/lang/String;I)V
    //   202: aload_0
    //   203: getfield 100	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   206: invokevirtual 542	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   209: ldc2_w 408
    //   212: lreturn
    //   213: iconst_0
    //   214: istore 4
    //   216: goto -50 -> 166
    //   219: astore_1
    //   220: aload_0
    //   221: getfield 100	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   224: invokevirtual 542	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   227: aload_1
    //   228: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	this	SQLiteDatabase
    //   0	229	1	paramString1	String
    //   0	229	2	paramString2	String
    //   0	229	3	paramContentValues	ContentValues
    //   120	95	4	i	int
    //   29	111	5	l1	long
    //   3	103	7	l2	long
    // Exception table:
    //   from	to	target	type
    //   12	68	148	java/lang/Throwable
    //   68	102	148	java/lang/Throwable
    //   102	110	148	java/lang/Throwable
    //   122	132	148	java/lang/Throwable
    //   12	68	219	finally
    //   68	102	219	finally
    //   102	110	219	finally
    //   122	132	219	finally
    //   153	166	219	finally
    //   166	202	219	finally
  }
  
  public void setLockingEnabled(boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    try
    {
      this.db.setLockingEnabled(paramBoolean);
      MsgAutoMonitorUtil.getInstance().addDbIoTime(System.currentTimeMillis() - l);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        handleDBErr(localThrowable, "setLockingEnabled");
      }
    }
  }
  
  public void setTransactionSuccessful()
  {
    long l = System.currentTimeMillis();
    try
    {
      this.db.setTransactionSuccessful();
      MsgAutoMonitorUtil.getInstance().addDbIoTime(System.currentTimeMillis() - l);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        handleDBErr(localThrowable, "setTransactionSuccessful");
      }
    }
  }
  
  public int update(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    long l = System.currentTimeMillis();
    outputExtensionInfoLog(paramString1, paramContentValues, "before convertContentValues");
    paramContentValues = convertContentValues(paramString1, paramContentValues);
    outputExtensionInfoLog(paramString1, paramContentValues, "after convertContentValues");
    convertWhereValues(paramString1, paramString2, paramArrayOfString);
    try
    {
      this.mDBThreadMonitor.a();
      i = this.db.update(paramString1, paramContentValues, paramString2, paramArrayOfString);
      this.mDBThreadMonitor.b();
      l = System.currentTimeMillis() - l;
      if ((sIsLogcatDBOperation) || (AIOUtilsProxy.getLogcatDBOperation()) || (TextUtils.equals("ExtensionInfo", paramString1))) {
        logcatSQLiteProfiler("update", paramString1, paramContentValues + ";" + paramString2, paramArrayOfString, l);
      }
      MsgAutoMonitorUtil.getInstance().addDbIoTime(l);
      return i;
    }
    catch (Throwable paramString2)
    {
      if ((paramContentValues != null) && (paramContentValues.size() > 0)) {}
      for (int i = paramContentValues.size();; i = 0)
      {
        handleDBErr(paramString2, String.format("UPDATE %s, %d", new Object[] { paramString1, Integer.valueOf(i) }));
        return -1;
      }
    }
    finally
    {
      this.mDBThreadMonitor.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SQLiteDatabase
 * JD-Core Version:    0.7.0.1
 */