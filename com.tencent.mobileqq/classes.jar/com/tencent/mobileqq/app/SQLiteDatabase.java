package com.tencent.mobileqq.app;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.imcore.constants.AppSetting;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.AIOUtils;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.SQLiteFTSUtils;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.StatisticCollector;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.TableNameCache;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQLiteDatabase
{
  private static final String DBTRANSLOG = "SQLiteDatabase";
  private static final long DbError_CheckInternal = 240000L;
  private static final int DbError_ThresholdCount = 10;
  private static final long DbError_ToastInternal = 21600000L;
  private static final boolean OPEN_DB_LOG = false;
  private static final String REPORT_TAG_OP_TABLE_NAME = "OpTableName";
  private static final String REPORT_TAG_OP_TYPE = "OpType";
  private static final int SAMPLE_SIZE = 500;
  private static final int SAMPLE_SIZE_FOR_INSERT = 100;
  static final String SQL_GET_TABLE_ATTR = "select sql from sqlite_master where type=? and name=?";
  private static final String TAG = "db";
  private static final String TAG_SQLITE_DB = "SQLiteDataBaseLog";
  private static final String UIN_SAMPLE_SUFFIX = "59.db";
  private static int dbError_count;
  private static long dbError_lastCheckTime;
  private static long dbError_lastToastTime;
  private static boolean dbError_toastTimeInited;
  public static boolean sIsLogcatDBOperation;
  final android.database.sqlite.SQLiteDatabase db;
  private long mOpCount;
  private boolean mUinNeedReport;
  private final Map<String, ArrayList<String>> queryCacheMap = new ConcurrentHashMap(32);
  private final Map<String, ArrayList<String>> tableMap = new ConcurrentHashMap(32);
  private TableNameCache tableNameCache;
  
  SQLiteDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, TableNameCache paramTableNameCache, String paramString)
  {
    this.db = paramSQLiteDatabase;
    this.tableNameCache = paramTableNameCache;
    if (AppSetting.isDebugVersion) {
      loadIsLogcatDBOperation();
    }
    if ((TextUtils.isEmpty(paramString)) || (paramString.endsWith("59.db"))) {}
    for (boolean bool = true;; bool = false)
    {
      this.mUinNeedReport = bool;
      return;
    }
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
  
  public static void beginTransactionLog()
  {
    if (AppSetting.isDebugVersion) {}
  }
  
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
  
  private void detectIllegalMsgDelete(String paramString1, String paramString2)
  {
    int j = 0;
    if ((AppSetting.isPublicVersion) || (IMCoreProxyRoute.SQLiteFTSUtils.getFTSNotifyFlag() != 1) || ((paramString1 == null) && (paramString2 == null))) {}
    label175:
    for (;;)
    {
      return;
      if (((paramString1 != null) && (paramString1.startsWith("mr_")) && (paramString1.endsWith("_New"))) || ((paramString2 != null) && (paramString2.trim().toLowerCase().startsWith("delete")) && (paramString2.contains("mr_")) && (paramString2.contains("_New"))))
      {
        paramString1 = new Throwable().getStackTrace();
        int i = 0;
        if (i < paramString1.length) {
          if (!paramString1[i].getClassName().endsWith("ProxyManager")) {}
        }
        for (i = j;; i = 1)
        {
          if (i == 0) {
            break label175;
          }
          QLog.w("db", 2, "detect illegal message delete，please use MsgProxy.delete()");
          new Handler(BaseApplication.getContext().getMainLooper()).post(new SQLiteDatabase.1(this));
          return;
          i += 1;
          break;
        }
      }
    }
  }
  
  public static void endTransactionLog()
  {
    if (AppSetting.isDebugVersion) {}
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
      printDBErrStackTrace(paramThrowable, localStringBuilder, "", null);
      label56:
      QLog.e("SQLiteDatabase", 2, new Object[] { localStringBuilder });
      if (!AppSetting.isDebugVersion) {
        break label77;
      }
      label77:
      while ((paramThrowable.getMessage() == null) || (paramThrowable.getMessage().contains("no such table"))) {
        return;
      }
      if (!dbError_toastTimeInited)
      {
        dbError_lastToastTime = BaseApplication.getContext().getSharedPreferences("dbError", 0).getLong("lastToastTime", 0L);
        dbError_toastTimeInited = true;
      }
      long l = System.currentTimeMillis();
      if (l - dbError_lastCheckTime > 240000L) {}
      for (dbError_count = 0;; dbError_count += 1)
      {
        dbError_lastCheckTime = l;
        if (dbError_count <= 10) {
          break;
        }
        dbError_count = 0;
        QLog.e("db", 1, "handleDBErr, find multi db error");
        if (l - dbError_lastToastTime <= 21600000L) {
          break;
        }
        dbError_lastToastTime = l;
        BaseApplication.getContext().getSharedPreferences("dbError", 0).edit().putLong("lastToastTime", dbError_lastToastTime).apply();
        if (QLog.isColorLevel()) {
          QLog.e("SQLiteDatabase", 2, "show db error toast");
        }
        new Handler(BaseApplication.getContext().getMainLooper()).post(new SQLiteDatabase.2(this));
        return;
      }
    }
    catch (Exception localException)
    {
      break label56;
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
    if (QLog.isColorLevel())
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
          break label220;
        }
        int j = paramArrayOfObject.length;
        label162:
        if (i >= j) {
          break label220;
        }
        paramString1 = paramArrayOfObject[i];
        if (paramString1 != null) {
          break label202;
        }
        ((StringBuilder)localObject).append("null,");
      }
      for (;;)
      {
        i += 1;
        break label162;
        bool = false;
        break;
        label202:
        ((StringBuilder)localObject).append(paramString1.toString()).append(',');
      }
      label220:
      paramString1 = ((StringBuilder)localObject).toString();
      if (bool) {
        QLog.d("SQLiteDataBaseLog", 2, paramString1, new Throwable("WTF"));
      }
    }
    else
    {
      return;
    }
    QLog.d("SQLiteDataBaseLog", 2, paramString1);
  }
  
  private void printDBErrStackTrace(Throwable paramThrowable, StringBuilder paramStringBuilder, String paramString, StackTraceElement[] paramArrayOfStackTraceElement)
  {
    int j = 0;
    StringBuilder localStringBuilder = paramStringBuilder;
    if (paramStringBuilder == null) {
      localStringBuilder = new StringBuilder();
    }
    localStringBuilder.append(paramThrowable.toString());
    localStringBuilder.append("\n");
    paramStringBuilder = paramThrowable.getStackTrace();
    if (paramStringBuilder != null)
    {
      int i;
      if (paramArrayOfStackTraceElement != null)
      {
        i = countDuplicates(paramStringBuilder, paramArrayOfStackTraceElement);
        if (j >= paramStringBuilder.length - i) {
          break label182;
        }
        if (j >= 3) {
          break label129;
        }
        localStringBuilder.append(paramString);
        localStringBuilder.append("\tat ");
        localStringBuilder.append(paramStringBuilder[j].toString());
        localStringBuilder.append("\n");
      }
      for (;;)
      {
        j += 1;
        break;
        i = 0;
        break;
        label129:
        if (j == paramStringBuilder.length - i - 1)
        {
          localStringBuilder.append(paramString);
          localStringBuilder.append("\t...at ");
          localStringBuilder.append(paramStringBuilder[j].toString());
          localStringBuilder.append("\n");
        }
      }
      label182:
      if (i > 0)
      {
        localStringBuilder.append(paramString);
        localStringBuilder.append("\t... ");
        localStringBuilder.append(Integer.toString(i));
        localStringBuilder.append(" more\n");
      }
    }
    if (paramThrowable.getCause() != null)
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append("Caused by: ");
      printDBErrStackTrace(paramThrowable, localStringBuilder, paramString, paramStringBuilder);
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
        localCursor = this.db.query(false, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6);
      }
      catch (Throwable paramArrayOfString2)
      {
        long l2;
        StringBuilder localStringBuilder;
        paramArrayOfString2 = paramArrayOfString2;
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
        continue;
      }
      finally {}
      try
      {
        l2 = System.currentTimeMillis();
        if ((!sIsLogcatDBOperation) && (!IMCoreProxyRoute.AIOUtils.getLogcatDBOperation())) {
          break label319;
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
      IMCoreProxyRoute.StatisticCollector.collectPerformance("", paramString1, bool, 0L, 0L, localHashMap, null);
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
    StringBuilder localStringBuilder;
    try
    {
      int i = this.db.delete(paramString1, paramString2, paramArrayOfString);
      long l2 = System.currentTimeMillis() - l1;
      if ((sIsLogcatDBOperation) || (IMCoreProxyRoute.AIOUtils.getLogcatDBOperation())) {
        logcatSQLiteProfiler("delete", paramString1, paramString2 + ";", paramArrayOfString, l2);
      }
      MsgAutoMonitorUtil.getInstance().addDbIoTime(l2);
      reportDbOperatorResult("delete", paramString1, 0);
      return i;
    }
    catch (Throwable paramArrayOfString)
    {
      localStringBuilder = new StringBuilder().append("DELETE FROM ").append(paramString1);
      if (TextUtils.isEmpty(paramString2)) {}
    }
    for (paramString2 = " WHERE " + paramString2;; paramString2 = "")
    {
      handleDBErr(paramArrayOfString, paramString2);
      reportDbOperatorResult("delete", paramString1, 1);
      MsgAutoMonitorUtil.getInstance().addDbIoTime(System.currentTimeMillis() - l1);
      return -1;
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
      this.db.execSQL(paramString);
      l = System.currentTimeMillis() - l;
      if ((sIsLogcatDBOperation) || (IMCoreProxyRoute.AIOUtils.getLogcatDBOperation())) {
        logcatSQLiteProfiler("execSQL", "", paramString, null, l);
      }
      MsgAutoMonitorUtil.getInstance().addDbIoTime(l);
      return true;
    }
    catch (Throwable localThrowable)
    {
      handleDBErr(localThrowable, paramString);
    }
    return false;
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
              this.db.execSQL(paramString, paramArrayOfObject);
              l = System.currentTimeMillis() - l;
              if ((sIsLogcatDBOperation) || (IMCoreProxyRoute.AIOUtils.getLogcatDBOperation())) {
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
    Object localObject2 = null;
    long l = System.currentTimeMillis();
    Cursor localCursor;
    int i;
    if (this.db != null)
    {
      localCursor = this.db.rawQuery("select distinct tbl_name from Sqlite_master", null);
      localObject1 = localObject2;
      if (localCursor != null)
      {
        localObject1 = localObject2;
        if (localCursor.moveToFirst())
        {
          localObject1 = new String[localCursor.getCount()];
          i = 0;
        }
      }
    }
    for (;;)
    {
      localObject1[i] = SecurityUtile.decode(localCursor.getString(0));
      if (!localCursor.moveToNext())
      {
        if (localCursor != null) {
          localCursor.close();
        }
        MsgAutoMonitorUtil.getInstance().addDbIoTime(System.currentTimeMillis() - l);
        return localObject1;
      }
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
  
  public long insert(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    long l2 = System.currentTimeMillis();
    paramContentValues = convertContentValues(paramString1, paramContentValues);
    try
    {
      long l1 = this.db.insert(paramString1, paramString2, paramContentValues);
      l2 = System.currentTimeMillis() - l2;
      if ((sIsLogcatDBOperation) || (IMCoreProxyRoute.AIOUtils.getLogcatDBOperation())) {
        logcatSQLiteProfiler("insert", paramString1, paramString2 + ";" + paramContentValues, null, l2);
      }
      MsgAutoMonitorUtil.getInstance().addDbIoTime(l2);
      if (l1 > -1L) {}
      for (i = 0;; i = 1)
      {
        reportDbOperatorResult("insert", paramString1, i);
        return l1;
      }
      if (paramContentValues.size() <= 0) {}
    }
    catch (Throwable paramString2)
    {
      if (paramContentValues == null) {}
    }
    for (int i = paramContentValues.size();; i = 0)
    {
      handleDBErr(paramString2, String.format("INSERT INTO %s, %d", new Object[] { paramString1, Integer.valueOf(i) }));
      reportDbOperatorResult("insert", paramString1, 1);
      return -1L;
    }
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
    //   0: invokestatic 429	java/lang/System:currentTimeMillis	()J
    //   3: lstore 5
    //   5: aload_0
    //   6: aload_2
    //   7: aload_3
    //   8: aload 4
    //   10: invokespecial 560	com/tencent/mobileqq/app/SQLiteDatabase:convertWhereValues	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield 73	com/tencent/mobileqq/app/SQLiteDatabase:db	Landroid/database/sqlite/SQLiteDatabase;
    //   17: aload_1
    //   18: aload 4
    //   20: invokevirtual 699	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   23: astore 9
    //   25: invokestatic 429	java/lang/System:currentTimeMillis	()J
    //   28: lstore 7
    //   30: getstatic 485	com/tencent/mobileqq/app/SQLiteDatabase:sIsLogcatDBOperation	Z
    //   33: ifne +9 -> 42
    //   36: invokestatic 569	com/tencent/mobileqq/imcore/proxy/IMCoreProxyRoute$AIOUtils:getLogcatDBOperation	()Z
    //   39: ifeq +41 -> 80
    //   42: ldc_w 749
    //   45: aload_2
    //   46: new 395	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 396	java/lang/StringBuilder:<init>	()V
    //   53: aload_1
    //   54: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: ldc_w 574
    //   60: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_3
    //   64: invokevirtual 467	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 471	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: aload 4
    //   72: lload 7
    //   74: lload 5
    //   76: lsub
    //   77: invokestatic 577	com/tencent/mobileqq/app/SQLiteDatabase:logcatSQLiteProfiler	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;J)V
    //   80: aload 9
    //   82: astore_2
    //   83: invokestatic 587	com/tencent/util/MsgAutoMonitorUtil:getInstance	()Lcom/tencent/util/MsgAutoMonitorUtil;
    //   86: invokestatic 429	java/lang/System:currentTimeMillis	()J
    //   89: lload 5
    //   91: lsub
    //   92: invokevirtual 591	com/tencent/util/MsgAutoMonitorUtil:addDbIoTime	(J)V
    //   95: aload_2
    //   96: areturn
    //   97: astore_3
    //   98: aconst_null
    //   99: astore_2
    //   100: aload_0
    //   101: aload_3
    //   102: aload_1
    //   103: invokespecial 597	com/tencent/mobileqq/app/SQLiteDatabase:handleDBErr	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   106: goto -23 -> 83
    //   109: astore_1
    //   110: aload_1
    //   111: athrow
    //   112: astore_3
    //   113: aload 9
    //   115: astore_2
    //   116: goto -16 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	SQLiteDatabase
    //   0	119	1	paramString1	String
    //   0	119	2	paramString2	String
    //   0	119	3	paramString3	String
    //   0	119	4	paramArrayOfString	String[]
    //   3	87	5	l1	long
    //   28	45	7	l2	long
    //   23	91	9	localCursor	Cursor
    // Exception table:
    //   from	to	target	type
    //   13	25	97	java/lang/Throwable
    //   13	25	109	finally
    //   25	42	109	finally
    //   42	80	109	finally
    //   100	106	109	finally
    //   25	42	112	java/lang/Throwable
    //   42	80	112	java/lang/Throwable
  }
  
  @Deprecated
  public Cursor rawQuery(String paramString, String[] paramArrayOfString)
  {
    l = System.currentTimeMillis();
    Object localObject2 = null;
    try
    {
      Cursor localCursor = this.db.rawQuery(paramString, paramArrayOfString);
      l = System.currentTimeMillis() - l;
      MsgAutoMonitorUtil.getInstance().addDbIoTime(l);
      localObject2 = localCursor;
      if (QLog.isColorLevel())
      {
        QLog.d("db", 2, "rawQuery() called with: sql = [" + paramString + "], selectionArgs = [" + Arrays.toString(paramArrayOfString) + "], cost = [" + l + "]");
        localObject2 = localCursor;
      }
    }
    catch (Throwable localThrowable)
    {
      handleDBErr(localThrowable, paramString);
      return null;
    }
    finally
    {
      l = System.currentTimeMillis() - l;
      MsgAutoMonitorUtil.getInstance().addDbIoTime(l);
      if (!QLog.isColorLevel()) {
        break label264;
      }
      QLog.d("db", 2, "rawQuery() called with: sql = [" + paramString + "], selectionArgs = [" + Arrays.toString(paramArrayOfString) + "], cost = [" + l + "]");
    }
    return localObject2;
  }
  
  public void removeFromTableCache(String paramString)
  {
    this.tableNameCache.deleteFromTableCache(paramString);
  }
  
  public long replace(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    long l2 = System.currentTimeMillis();
    paramContentValues = convertContentValues(paramString1, paramContentValues);
    try
    {
      long l1 = this.db.replace(paramString1, paramString2, paramContentValues);
      l2 = System.currentTimeMillis() - l2;
      if ((sIsLogcatDBOperation) || (IMCoreProxyRoute.AIOUtils.getLogcatDBOperation())) {
        logcatSQLiteProfiler("replace", paramString1, paramString2 + ";" + paramContentValues, null, l2);
      }
      MsgAutoMonitorUtil.getInstance().addDbIoTime(l2);
      if (l1 > -1L) {}
      for (i = 0;; i = 1)
      {
        reportDbOperatorResult("replace", paramString1, i);
        return l1;
      }
      if (paramContentValues.size() <= 0) {}
    }
    catch (Throwable paramString2)
    {
      if (paramContentValues == null) {}
    }
    for (int i = paramContentValues.size();; i = 0)
    {
      handleDBErr(paramString2, String.format("replace, INSERT INTO %s, %d", new Object[] { paramString1, Integer.valueOf(i) }));
      reportDbOperatorResult("replace", paramString1, 1);
      return -1L;
    }
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
    paramContentValues = convertContentValues(paramString1, paramContentValues);
    convertWhereValues(paramString1, paramString2, paramArrayOfString);
    try
    {
      i = this.db.update(paramString1, paramContentValues, paramString2, paramArrayOfString);
      l = System.currentTimeMillis() - l;
      if ((sIsLogcatDBOperation) || (IMCoreProxyRoute.AIOUtils.getLogcatDBOperation())) {
        logcatSQLiteProfiler("update", paramString1, paramContentValues + ";" + paramString2, paramArrayOfString, l);
      }
      MsgAutoMonitorUtil.getInstance().addDbIoTime(l);
      return i;
    }
    catch (Throwable paramString2)
    {
      if (paramContentValues == null) {
        break label147;
      }
    }
    if (paramContentValues.size() > 0) {}
    label147:
    for (int i = paramContentValues.size();; i = 0)
    {
      handleDBErr(paramString2, String.format("UPDATE %s, %d", new Object[] { paramString1, Integer.valueOf(i) }));
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SQLiteDatabase
 * JD-Core Version:    0.7.0.1
 */