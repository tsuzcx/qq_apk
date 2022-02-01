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
  private static int dbError_count = 0;
  private static long dbError_lastCheckTime = 0L;
  private static long dbError_lastToastTime = 0L;
  private static boolean dbError_toastTimeInited = false;
  public static boolean sIsLogcatDBOperation = false;
  final android.database.sqlite.SQLiteDatabase db;
  private DBThreadMonitor mDBThreadMonitor = new DBThreadMonitor("SQLiteDataBaseLog");
  private long mOpCount = 0L;
  private boolean mUinNeedReport;
  private final Map<String, ArrayList<String>> queryCacheMap = new ConcurrentHashMap(32);
  private final Map<String, ArrayList<String>> tableMap = new ConcurrentHashMap(32);
  private TableNameCache tableNameCache = null;
  
  SQLiteDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, TableNameCache paramTableNameCache, String paramString)
  {
    boolean bool = false;
    this.mUinNeedReport = false;
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
      paramString = paramString.substring(paramString.indexOf("(") + 1, paramString.indexOf(")")).split(",");
      ArrayList localArrayList = new ArrayList();
      int k = paramArrayOfString.length;
      int i = 0;
      while (i < k)
      {
        String str = paramArrayOfString[i].toLowerCase();
        int m = paramString.length;
        int j = 0;
        while (j < m)
        {
          String[] arrayOfString = paramString[j].trim().split(" ");
          if ((arrayOfString.length > 1) && (str.equals(arrayOfString[1].toLowerCase()))) {
            localArrayList.add(arrayOfString[0]);
          }
          j += 1;
        }
        i += 1;
      }
      return localArrayList;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("db", 2, "analyseTableField exception: ", paramString);
      }
    }
    return new ArrayList();
  }
  
  public static void beginTransactionLog() {}
  
  private void buildTableNameCache()
  {
    if (!this.tableNameCache.isInit) {
      try
      {
        String[] arrayOfString = getAllTableNameFromDB();
        this.tableNameCache.initTableCache(arrayOfString);
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.w("db", 2, "buildTableNameCache exception", localException);
        }
      }
    }
  }
  
  private byte[] convertBlob(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return paramArrayOfByte;
      }
      arrayOfByte = SecurityUtile.encode(paramArrayOfByte);
    }
    return arrayOfByte;
  }
  
  private ContentValues convertContentValues(String paramString, ContentValues paramContentValues)
  {
    if (paramContentValues != null)
    {
      if (paramContentValues.size() <= 0) {
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
    return paramContentValues;
  }
  
  private String convertStr(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    String str = paramObject.toString();
    paramObject = str;
    if (str.length() > 0) {
      paramObject = SecurityUtile.encode(str);
    }
    return paramObject;
  }
  
  private void convertWhereValues(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    if (paramString2 != null)
    {
      if (paramArrayOfString == null) {
        return;
      }
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
    int j = paramArrayOfStackTraceElement2.length;
    int k = paramArrayOfStackTraceElement1.length;
    int i = 0;
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
    boolean bool;
    if (System.currentTimeMillis() - EntityManagerFactory.corruptedTime < 100L) {
      bool = true;
    } else {
      bool = false;
    }
    if (((paramThrowable instanceof SQLiteDatabaseCorruptException)) || (bool))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" ");
      localStringBuilder.append(bool);
      QLog.e("SQLiteDatabase", 1, localStringBuilder.toString());
      EntityManagerFactory.corruptedTime = -1L;
    }
    handleDBErr(paramThrowable);
  }
  
  public static void loadIsLogcatDBOperation()
  {
    sIsLogcatDBOperation = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getBoolean("isLogcatDBOperation", false);
  }
  
  private static void logcatSQLiteProfiler(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject, long paramLong)
  {
    if ((QLog.isColorLevel()) || (filterExtensionInfoTableLog(paramString2, paramString3)))
    {
      Object localObject = Thread.currentThread();
      String str = ((Thread)localObject).getName();
      Thread localThread = Looper.getMainLooper().getThread();
      int i = 0;
      boolean bool;
      if (localObject == localThread) {
        bool = true;
      } else {
        bool = false;
      }
      localObject = new StringBuilder(512);
      ((StringBuilder)localObject).append("TableName:");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append('|');
      ((StringBuilder)localObject).append("ExecuteType:");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append("CurrentThreadName:");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append('|');
      ((StringBuilder)localObject).append("IsMainThread:");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append('|');
      ((StringBuilder)localObject).append("Cost:");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append('|');
      ((StringBuilder)localObject).append("CMD:");
      ((StringBuilder)localObject).append(paramString3);
      if (paramArrayOfObject != null)
      {
        int j = paramArrayOfObject.length;
        while (i < j)
        {
          paramString1 = paramArrayOfObject[i];
          if (paramString1 == null)
          {
            ((StringBuilder)localObject).append("null,");
          }
          else
          {
            ((StringBuilder)localObject).append(paramString1.toString());
            ((StringBuilder)localObject).append(',');
          }
          i += 1;
        }
      }
      paramString1 = ((StringBuilder)localObject).toString();
      paramArrayOfObject = new RuntimeException("ExtensionInfo table change ");
      paramArrayOfObject.fillInStackTrace();
      if (bool)
      {
        if ((!sIsLogcatDBOperation) && (!filterExtensionInfoTableLog(paramString2, paramString3)))
        {
          if (QLog.isColorLevel())
          {
            paramString2 = new StringBuilder();
            paramString2.append("isMainThread = true, ");
            paramString2.append(paramString1);
            QLog.d("SQLiteDataBaseLog", 2, paramString2.toString(), paramArrayOfObject);
          }
        }
        else
        {
          paramString2 = new StringBuilder();
          paramString2.append("isMainThread = true, ");
          paramString2.append(paramString1);
          paramString2.append(", StackTrace = ");
          QLog.d("SQLiteDataBaseLog", 1, paramString2.toString(), paramArrayOfObject);
        }
      }
      else if ((!sIsLogcatDBOperation) && (!filterExtensionInfoTableLog(paramString2, paramString3)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SQLiteDataBaseLog", 2, paramString1);
        }
      }
      else
      {
        paramString2 = new StringBuilder();
        paramString2.append(paramString1);
        paramString2.append(", StackTrace = ");
        QLog.d("SQLiteDataBaseLog", 1, paramString2.toString(), paramArrayOfObject);
      }
    }
  }
  
  private void outputExtensionInfoLog(String paramString1, ContentValues paramContentValues, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramContentValues != null) && (TextUtils.equals("ExtensionInfo", paramString1)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContentValues);
      localStringBuilder.append("");
      if (filterExtensionInfoTableLog(paramString1, localStringBuilder.toString()))
      {
        paramString1 = new StringBuilder();
        paramString1.append("from = ");
        paramString1.append(paramString2);
        paramString1.append(", contentValues = ");
        paramString1.append(paramContentValues);
        QLog.d("SQLiteDataBaseLog", 1, paramString1.toString());
      }
    }
  }
  
  private void printDBErrStackTrace(Throwable paramThrowable, StringBuilder paramStringBuilder, String paramString, StackTraceElement[] paramArrayOfStackTraceElement, int paramInt)
  {
    StringBuilder localStringBuilder = paramStringBuilder;
    if (paramStringBuilder == null) {
      localStringBuilder = new StringBuilder();
    }
    localStringBuilder.append(paramThrowable.toString());
    localStringBuilder.append("\n");
    paramStringBuilder = paramThrowable.getStackTrace();
    if (paramStringBuilder != null)
    {
      int j = 0;
      int i;
      if (paramArrayOfStackTraceElement != null) {
        i = countDuplicates(paramStringBuilder, paramArrayOfStackTraceElement);
      } else {
        i = 0;
      }
      while (j < paramStringBuilder.length - i)
      {
        if (j < 3)
        {
          localStringBuilder.append(paramString);
          localStringBuilder.append("\tat ");
          localStringBuilder.append(paramStringBuilder[j].toString());
          localStringBuilder.append("\n");
        }
        else if (j == paramStringBuilder.length - i - 1)
        {
          localStringBuilder.append(paramString);
          localStringBuilder.append("\t...at ");
          localStringBuilder.append(paramStringBuilder[j].toString());
          localStringBuilder.append("\n");
        }
        j += 1;
      }
      if (i > 0)
      {
        localStringBuilder.append(paramString);
        localStringBuilder.append("\t... ");
        localStringBuilder.append(Integer.toString(i));
        localStringBuilder.append(" more\n");
      }
    }
    if ((paramThrowable.getCause() != null) && (paramInt < 5))
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append("Caused by: ");
      printDBErrStackTrace(paramThrowable, localStringBuilder, paramString, paramStringBuilder, paramInt + 1);
    }
  }
  
  /* Error */
  private Cursor query(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    // Byte code:
    //   0: invokestatic 382	java/lang/System:currentTimeMillis	()J
    //   3: lstore 13
    //   5: aload_0
    //   6: aload_2
    //   7: aload 4
    //   9: aload 5
    //   11: invokespecial 526	com/tencent/mobileqq/app/SQLiteDatabase:convertWhereValues	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   14: aconst_null
    //   15: astore 18
    //   17: aload 18
    //   19: astore 17
    //   21: aload_0
    //   22: getfield 92	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   25: invokevirtual 529	com/tencent/mobileqq/app/db/DBThreadMonitor:a	()V
    //   28: aload 18
    //   30: astore 17
    //   32: aload_0
    //   33: getfield 98	com/tencent/mobileqq/app/SQLiteDatabase:db	Landroid/database/sqlite/SQLiteDatabase;
    //   36: iconst_0
    //   37: aload_2
    //   38: aload_3
    //   39: aload 4
    //   41: aload 5
    //   43: aload 6
    //   45: aload 7
    //   47: aload 8
    //   49: aload 9
    //   51: invokevirtual 533	android/database/sqlite/SQLiteDatabase:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   54: astore 18
    //   56: aload 18
    //   58: astore 17
    //   60: aload_0
    //   61: getfield 92	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   64: invokevirtual 536	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   67: aload 18
    //   69: astore 17
    //   71: invokestatic 382	java/lang/System:currentTimeMillis	()J
    //   74: lstore 15
    //   76: aload 18
    //   78: astore 17
    //   80: getstatic 426	com/tencent/mobileqq/app/SQLiteDatabase:sIsLogcatDBOperation	Z
    //   83: istore_1
    //   84: iconst_0
    //   85: istore 11
    //   87: iload_1
    //   88: ifne +13 -> 101
    //   91: aload 18
    //   93: astore 17
    //   95: invokestatic 541	com/tencent/mobileqq/imcore/proxy/msg/AIOUtilsProxy:getLogcatDBOperation	()Z
    //   98: ifeq +372 -> 470
    //   101: aload 18
    //   103: astore 17
    //   105: new 365	java/lang/StringBuilder
    //   108: dup
    //   109: bipush 32
    //   111: invokespecial 449	java/lang/StringBuilder:<init>	(I)V
    //   114: astore 19
    //   116: aload 18
    //   118: astore 17
    //   120: aload 19
    //   122: aload_3
    //   123: invokevirtual 491	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload 18
    //   129: astore 17
    //   131: aload 19
    //   133: ldc_w 543
    //   136: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload 18
    //   142: astore 17
    //   144: aload 19
    //   146: aload 4
    //   148: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload 18
    //   154: astore 17
    //   156: aload 19
    //   158: ldc_w 543
    //   161: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload 5
    //   167: ifnull +46 -> 213
    //   170: aload 18
    //   172: astore 17
    //   174: aload 5
    //   176: arraylength
    //   177: istore 12
    //   179: iconst_0
    //   180: istore 10
    //   182: iload 10
    //   184: iload 12
    //   186: if_icmpge +27 -> 213
    //   189: aload 18
    //   191: astore 17
    //   193: aload 19
    //   195: aload 5
    //   197: iload 10
    //   199: aaload
    //   200: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: iload 10
    //   206: iconst_1
    //   207: iadd
    //   208: istore 10
    //   210: goto -28 -> 182
    //   213: aload 18
    //   215: astore 17
    //   217: aload 19
    //   219: ldc_w 543
    //   222: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload 18
    //   228: astore 17
    //   230: aload 19
    //   232: aload 6
    //   234: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload 18
    //   240: astore 17
    //   242: aload 19
    //   244: ldc_w 543
    //   247: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload 18
    //   253: astore 17
    //   255: aload 19
    //   257: aload 7
    //   259: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload 18
    //   265: astore 17
    //   267: aload 19
    //   269: ldc_w 543
    //   272: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: aload 18
    //   278: astore 17
    //   280: aload 19
    //   282: aload 8
    //   284: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload 18
    //   290: astore 17
    //   292: aload 19
    //   294: ldc_w 543
    //   297: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload 18
    //   303: astore 17
    //   305: aload 19
    //   307: aload 9
    //   309: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: aload 18
    //   315: astore 17
    //   317: ldc_w 544
    //   320: aload_2
    //   321: aload 19
    //   323: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: aconst_null
    //   327: lload 15
    //   329: lload 13
    //   331: lsub
    //   332: invokestatic 546	com/tencent/mobileqq/app/SQLiteDatabase:logcatSQLiteProfiler	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;J)V
    //   335: goto +135 -> 470
    //   338: aload 18
    //   340: astore 17
    //   342: aload_0
    //   343: ldc_w 544
    //   346: aload_2
    //   347: iload 10
    //   349: invokespecial 550	com/tencent/mobileqq/app/SQLiteDatabase:reportDbOperatorResult	(Ljava/lang/String;Ljava/lang/String;I)V
    //   352: aload 18
    //   354: astore 17
    //   356: goto +77 -> 433
    //   359: astore_2
    //   360: goto +95 -> 455
    //   363: astore_3
    //   364: new 365	java/lang/StringBuilder
    //   367: dup
    //   368: invokespecial 366	java/lang/StringBuilder:<init>	()V
    //   371: astore 5
    //   373: aload 5
    //   375: ldc_w 552
    //   378: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: pop
    //   382: aload 5
    //   384: aload_2
    //   385: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: aload 4
    //   391: invokestatic 104	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   394: ifne +20 -> 414
    //   397: aload 5
    //   399: ldc_w 554
    //   402: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: aload 5
    //   408: aload 4
    //   410: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: pop
    //   414: aload_0
    //   415: ldc_w 544
    //   418: aload_2
    //   419: iconst_1
    //   420: invokespecial 550	com/tencent/mobileqq/app/SQLiteDatabase:reportDbOperatorResult	(Ljava/lang/String;Ljava/lang/String;I)V
    //   423: aload_0
    //   424: aload_3
    //   425: aload 5
    //   427: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: invokespecial 556	com/tencent/mobileqq/app/SQLiteDatabase:handleDBErr	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   433: aload_0
    //   434: getfield 92	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   437: invokevirtual 536	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   440: invokestatic 562	com/tencent/util/MsgAutoMonitorUtil:getInstance	()Lcom/tencent/util/MsgAutoMonitorUtil;
    //   443: invokestatic 382	java/lang/System:currentTimeMillis	()J
    //   446: lload 13
    //   448: lsub
    //   449: invokevirtual 566	com/tencent/util/MsgAutoMonitorUtil:addDbIoTime	(J)V
    //   452: aload 17
    //   454: areturn
    //   455: aload_0
    //   456: getfield 92	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   459: invokevirtual 536	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   462: goto +5 -> 467
    //   465: aload_2
    //   466: athrow
    //   467: goto -2 -> 465
    //   470: aload 18
    //   472: ifnull +10 -> 482
    //   475: iload 11
    //   477: istore 10
    //   479: goto -141 -> 338
    //   482: iconst_1
    //   483: istore 10
    //   485: goto -147 -> 338
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	488	0	this	SQLiteDatabase
    //   0	488	1	paramBoolean	boolean
    //   0	488	2	paramString1	String
    //   0	488	3	paramArrayOfString1	String[]
    //   0	488	4	paramString2	String
    //   0	488	5	paramArrayOfString2	String[]
    //   0	488	6	paramString3	String
    //   0	488	7	paramString4	String
    //   0	488	8	paramString5	String
    //   0	488	9	paramString6	String
    //   180	304	10	i	int
    //   85	391	11	j	int
    //   177	10	12	k	int
    //   3	444	13	l1	long
    //   74	254	15	l2	long
    //   19	434	17	localCursor1	Cursor
    //   15	456	18	localCursor2	Cursor
    //   114	208	19	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   21	28	359	finally
    //   32	56	359	finally
    //   60	67	359	finally
    //   71	76	359	finally
    //   80	84	359	finally
    //   95	101	359	finally
    //   105	116	359	finally
    //   120	127	359	finally
    //   131	140	359	finally
    //   144	152	359	finally
    //   156	165	359	finally
    //   174	179	359	finally
    //   193	204	359	finally
    //   217	226	359	finally
    //   230	238	359	finally
    //   242	251	359	finally
    //   255	263	359	finally
    //   267	276	359	finally
    //   280	288	359	finally
    //   292	301	359	finally
    //   305	313	359	finally
    //   317	335	359	finally
    //   342	352	359	finally
    //   364	414	359	finally
    //   414	433	359	finally
    //   21	28	363	java/lang/Throwable
    //   32	56	363	java/lang/Throwable
    //   60	67	363	java/lang/Throwable
    //   71	76	363	java/lang/Throwable
    //   80	84	363	java/lang/Throwable
    //   95	101	363	java/lang/Throwable
    //   105	116	363	java/lang/Throwable
    //   120	127	363	java/lang/Throwable
    //   131	140	363	java/lang/Throwable
    //   144	152	363	java/lang/Throwable
    //   156	165	363	java/lang/Throwable
    //   174	179	363	java/lang/Throwable
    //   193	204	363	java/lang/Throwable
    //   217	226	363	java/lang/Throwable
    //   230	238	363	java/lang/Throwable
    //   242	251	363	java/lang/Throwable
    //   255	263	363	java/lang/Throwable
    //   267	276	363	java/lang/Throwable
    //   280	288	363	java/lang/Throwable
    //   292	301	363	java/lang/Throwable
    //   305	313	363	java/lang/Throwable
    //   317	335	363	java/lang/Throwable
    //   342	352	363	java/lang/Throwable
  }
  
  private void reportDbOperatorResult(String paramString1, String paramString2, int paramInt)
  {
    if (!this.mUinNeedReport) {
      return;
    }
    this.mOpCount += 1L;
    if ("insert".equals(paramString1))
    {
      if (this.mOpCount % 100L == 0L) {}
    }
    else if (this.mOpCount % 500L != 0L) {
      return;
    }
    HashMap localHashMap = new HashMap(4);
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("OpType", paramString1);
    localHashMap.put("OpTableName", paramString2);
    localHashMap.put("param_FailCode", Integer.toString(paramInt));
    paramString2 = new StringBuilder();
    paramString2.append("DatabaseOperatorResult_");
    paramString2.append(paramString1);
    paramString1 = paramString2.toString();
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    StatisticCollectorProxy.collectPerformance("", paramString1, bool, 0L, 0L, localHashMap, null);
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
    }
    catch (Throwable localThrowable)
    {
      handleDBErr(localThrowable, "beginTransaction");
    }
    MsgAutoMonitorUtil.getInstance().addDbIoTime(System.currentTimeMillis() - l);
    MsgAutoMonitorUtil.getInstance().addDbIoTransaction(1L);
  }
  
  @TargetApi(11)
  public void beginTransactionNonExclusive()
  {
    long l = System.currentTimeMillis();
    try
    {
      beginTransactionLog();
      this.db.beginTransactionNonExclusive();
    }
    catch (Throwable localThrowable)
    {
      handleDBErr(localThrowable, "beginTransactionNonExclusive");
    }
    MsgAutoMonitorUtil.getInstance().addDbIoTime(System.currentTimeMillis() - l);
    MsgAutoMonitorUtil.getInstance().addDbIoTransaction(1L);
  }
  
  public void close()
  {
    long l = System.currentTimeMillis();
    try
    {
      QLog.e("db", 1, "SQLiteDatabase close");
      this.db.close();
    }
    catch (Throwable localThrowable)
    {
      handleDBErr(localThrowable, "close");
    }
    MsgAutoMonitorUtil.getInstance().addDbIoTime(System.currentTimeMillis() - l);
  }
  
  public boolean containsTable(String paramString)
  {
    buildTableNameCache();
    return this.tableNameCache.isContainsTableInCache(paramString);
  }
  
  public int count(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    long l = System.currentTimeMillis();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select count(*) from ");
    ((StringBuilder)localObject).append(paramString1);
    String str = ((StringBuilder)localObject).toString();
    localObject = str;
    if (paramString2 != null)
    {
      localObject = str;
      if (paramArrayOfString != null)
      {
        convertWhereValues(paramString1, paramString2, paramArrayOfString);
        paramString1 = new StringBuilder();
        paramString1.append(str);
        paramString1.append(" where ");
        paramString1.append(paramString2);
        localObject = paramString1.toString();
      }
    }
    paramString1 = rawQuery((String)localObject, paramArrayOfString);
    int i = 0;
    if (paramString1 != null)
    {
      paramString1.moveToFirst();
      i = paramString1.getInt(0);
      paramString1.close();
    }
    MsgAutoMonitorUtil.getInstance().addDbIoTime(System.currentTimeMillis() - l);
    return i;
  }
  
  /* Error */
  public int delete(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: invokestatic 382	java/lang/System:currentTimeMillis	()J
    //   3: lstore 5
    //   5: aload_0
    //   6: aload_1
    //   7: aconst_null
    //   8: invokespecial 648	com/tencent/mobileqq/app/SQLiteDatabase:detectIllegalMsgDelete	(Ljava/lang/String;Ljava/lang/String;)V
    //   11: aload_0
    //   12: aload_1
    //   13: aload_2
    //   14: aload_3
    //   15: invokespecial 526	com/tencent/mobileqq/app/SQLiteDatabase:convertWhereValues	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   18: aload_0
    //   19: getfield 92	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   22: invokevirtual 529	com/tencent/mobileqq/app/db/DBThreadMonitor:a	()V
    //   25: aload_0
    //   26: getfield 98	com/tencent/mobileqq/app/SQLiteDatabase:db	Landroid/database/sqlite/SQLiteDatabase;
    //   29: aload_1
    //   30: aload_2
    //   31: aload_3
    //   32: invokevirtual 650	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   35: istore 4
    //   37: aload_0
    //   38: getfield 92	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   41: invokevirtual 536	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   44: invokestatic 382	java/lang/System:currentTimeMillis	()J
    //   47: lload 5
    //   49: lsub
    //   50: lstore 7
    //   52: getstatic 426	com/tencent/mobileqq/app/SQLiteDatabase:sIsLogcatDBOperation	Z
    //   55: ifne +9 -> 64
    //   58: invokestatic 541	com/tencent/mobileqq/imcore/proxy/msg/AIOUtilsProxy:getLogcatDBOperation	()Z
    //   61: ifeq +43 -> 104
    //   64: new 365	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 366	java/lang/StringBuilder:<init>	()V
    //   71: astore 9
    //   73: aload 9
    //   75: aload_2
    //   76: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload 9
    //   82: ldc_w 543
    //   85: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: ldc_w 651
    //   92: aload_1
    //   93: aload 9
    //   95: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: aload_3
    //   99: lload 7
    //   101: invokestatic 546	com/tencent/mobileqq/app/SQLiteDatabase:logcatSQLiteProfiler	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;J)V
    //   104: invokestatic 562	com/tencent/util/MsgAutoMonitorUtil:getInstance	()Lcom/tencent/util/MsgAutoMonitorUtil;
    //   107: lload 7
    //   109: invokevirtual 566	com/tencent/util/MsgAutoMonitorUtil:addDbIoTime	(J)V
    //   112: aload_0
    //   113: ldc_w 651
    //   116: aload_1
    //   117: iconst_0
    //   118: invokespecial 550	com/tencent/mobileqq/app/SQLiteDatabase:reportDbOperatorResult	(Ljava/lang/String;Ljava/lang/String;I)V
    //   121: aload_0
    //   122: getfield 92	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   125: invokevirtual 536	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   128: iload 4
    //   130: ireturn
    //   131: astore_1
    //   132: goto +117 -> 249
    //   135: astore_3
    //   136: new 365	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 366	java/lang/StringBuilder:<init>	()V
    //   143: astore 9
    //   145: aload 9
    //   147: ldc_w 653
    //   150: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload 9
    //   156: aload_1
    //   157: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload_2
    //   162: invokestatic 104	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   165: ifne +93 -> 258
    //   168: new 365	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 366	java/lang/StringBuilder:<init>	()V
    //   175: astore 10
    //   177: aload 10
    //   179: ldc_w 554
    //   182: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload 10
    //   188: aload_2
    //   189: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload 10
    //   195: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: astore_2
    //   199: goto +3 -> 202
    //   202: aload 9
    //   204: aload_2
    //   205: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload_0
    //   210: aload_3
    //   211: aload 9
    //   213: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokespecial 556	com/tencent/mobileqq/app/SQLiteDatabase:handleDBErr	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   219: aload_0
    //   220: ldc_w 651
    //   223: aload_1
    //   224: iconst_1
    //   225: invokespecial 550	com/tencent/mobileqq/app/SQLiteDatabase:reportDbOperatorResult	(Ljava/lang/String;Ljava/lang/String;I)V
    //   228: aload_0
    //   229: getfield 92	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   232: invokevirtual 536	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   235: invokestatic 562	com/tencent/util/MsgAutoMonitorUtil:getInstance	()Lcom/tencent/util/MsgAutoMonitorUtil;
    //   238: invokestatic 382	java/lang/System:currentTimeMillis	()J
    //   241: lload 5
    //   243: lsub
    //   244: invokevirtual 566	com/tencent/util/MsgAutoMonitorUtil:addDbIoTime	(J)V
    //   247: iconst_m1
    //   248: ireturn
    //   249: aload_0
    //   250: getfield 92	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   253: invokevirtual 536	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   256: aload_1
    //   257: athrow
    //   258: ldc_w 368
    //   261: astore_2
    //   262: goto -60 -> 202
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	this	SQLiteDatabase
    //   0	265	1	paramString1	String
    //   0	265	2	paramString2	String
    //   0	265	3	paramArrayOfString	String[]
    //   35	94	4	i	int
    //   3	239	5	l1	long
    //   50	58	7	l2	long
    //   71	141	9	localStringBuilder1	StringBuilder
    //   175	19	10	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   18	64	131	finally
    //   64	104	131	finally
    //   104	121	131	finally
    //   136	199	131	finally
    //   202	228	131	finally
    //   18	64	135	java/lang/Throwable
    //   64	104	135	java/lang/Throwable
    //   104	121	135	java/lang/Throwable
  }
  
  public void endTransaction()
  {
    long l = System.currentTimeMillis();
    try
    {
      this.db.endTransaction();
      endTransactionLog();
    }
    catch (Throwable localThrowable)
    {
      handleDBErr(localThrowable, "endTransaction");
    }
    MsgAutoMonitorUtil.getInstance().addDbIoTime(System.currentTimeMillis() - l);
  }
  
  /* Error */
  public boolean execSQL(String paramString)
  {
    // Byte code:
    //   0: invokestatic 382	java/lang/System:currentTimeMillis	()J
    //   3: lstore_2
    //   4: aload_0
    //   5: aconst_null
    //   6: aload_1
    //   7: invokespecial 648	com/tencent/mobileqq/app/SQLiteDatabase:detectIllegalMsgDelete	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: aload_0
    //   11: getfield 92	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   14: invokevirtual 529	com/tencent/mobileqq/app/db/DBThreadMonitor:a	()V
    //   17: aload_0
    //   18: getfield 98	com/tencent/mobileqq/app/SQLiteDatabase:db	Landroid/database/sqlite/SQLiteDatabase;
    //   21: aload_1
    //   22: invokevirtual 662	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   25: aload_0
    //   26: getfield 92	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   29: invokevirtual 536	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   32: invokestatic 382	java/lang/System:currentTimeMillis	()J
    //   35: lload_2
    //   36: lsub
    //   37: lstore_2
    //   38: getstatic 426	com/tencent/mobileqq/app/SQLiteDatabase:sIsLogcatDBOperation	Z
    //   41: ifne +9 -> 50
    //   44: invokestatic 541	com/tencent/mobileqq/imcore/proxy/msg/AIOUtilsProxy:getLogcatDBOperation	()Z
    //   47: ifeq +15 -> 62
    //   50: ldc_w 663
    //   53: ldc_w 368
    //   56: aload_1
    //   57: aconst_null
    //   58: lload_2
    //   59: invokestatic 546	com/tencent/mobileqq/app/SQLiteDatabase:logcatSQLiteProfiler	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;J)V
    //   62: invokestatic 562	com/tencent/util/MsgAutoMonitorUtil:getInstance	()Lcom/tencent/util/MsgAutoMonitorUtil;
    //   65: lload_2
    //   66: invokevirtual 566	com/tencent/util/MsgAutoMonitorUtil:addDbIoTime	(J)V
    //   69: iconst_1
    //   70: istore 4
    //   72: aload_0
    //   73: getfield 92	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   76: invokevirtual 536	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   79: iload 4
    //   81: ireturn
    //   82: astore_1
    //   83: goto +18 -> 101
    //   86: astore 5
    //   88: aload_0
    //   89: aload 5
    //   91: aload_1
    //   92: invokespecial 556	com/tencent/mobileqq/app/SQLiteDatabase:handleDBErr	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   95: iconst_0
    //   96: istore 4
    //   98: goto -26 -> 72
    //   101: aload_0
    //   102: getfield 92	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   105: invokevirtual 536	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   108: goto +5 -> 113
    //   111: aload_1
    //   112: athrow
    //   113: goto -2 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	SQLiteDatabase
    //   0	116	1	paramString	String
    //   3	63	2	l	long
    //   70	27	4	bool	boolean
    //   86	4	5	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   4	50	82	finally
    //   50	62	82	finally
    //   62	69	82	finally
    //   88	95	82	finally
    //   4	50	86	java/lang/Throwable
    //   50	62	86	java/lang/Throwable
    //   62	69	86	java/lang/Throwable
  }
  
  /* Error */
  public boolean execSQL(String paramString, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: invokestatic 382	java/lang/System:currentTimeMillis	()J
    //   3: lstore 4
    //   5: aconst_null
    //   6: astore 7
    //   8: iconst_0
    //   9: istore_3
    //   10: aload 7
    //   12: astore 6
    //   14: iload_3
    //   15: aload_2
    //   16: arraylength
    //   17: if_icmpge +45 -> 62
    //   20: aload_2
    //   21: iload_3
    //   22: aaload
    //   23: instanceof 106
    //   26: ifeq +151 -> 177
    //   29: aload_2
    //   30: iload_3
    //   31: aaload
    //   32: checkcast 106	java/lang/String
    //   35: astore 6
    //   37: aload 6
    //   39: ldc_w 666
    //   42: invokevirtual 669	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   45: ifeq +132 -> 177
    //   48: aload 6
    //   50: ldc_w 671
    //   53: invokevirtual 110	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   56: ifeq +121 -> 177
    //   59: goto +3 -> 62
    //   62: aload_0
    //   63: aload 6
    //   65: aload_1
    //   66: invokespecial 648	com/tencent/mobileqq/app/SQLiteDatabase:detectIllegalMsgDelete	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: aload_0
    //   70: getfield 92	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   73: invokevirtual 529	com/tencent/mobileqq/app/db/DBThreadMonitor:a	()V
    //   76: aload_0
    //   77: getfield 98	com/tencent/mobileqq/app/SQLiteDatabase:db	Landroid/database/sqlite/SQLiteDatabase;
    //   80: aload_1
    //   81: aload_2
    //   82: invokevirtual 674	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   85: aload_0
    //   86: getfield 92	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   89: invokevirtual 536	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   92: invokestatic 382	java/lang/System:currentTimeMillis	()J
    //   95: lload 4
    //   97: lsub
    //   98: lstore 4
    //   100: getstatic 426	com/tencent/mobileqq/app/SQLiteDatabase:sIsLogcatDBOperation	Z
    //   103: ifne +9 -> 112
    //   106: invokestatic 541	com/tencent/mobileqq/imcore/proxy/msg/AIOUtilsProxy:getLogcatDBOperation	()Z
    //   109: ifeq +16 -> 125
    //   112: ldc_w 663
    //   115: ldc_w 368
    //   118: aload_1
    //   119: aload_2
    //   120: lload 4
    //   122: invokestatic 546	com/tencent/mobileqq/app/SQLiteDatabase:logcatSQLiteProfiler	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;J)V
    //   125: invokestatic 562	com/tencent/util/MsgAutoMonitorUtil:getInstance	()Lcom/tencent/util/MsgAutoMonitorUtil;
    //   128: lload 4
    //   130: invokevirtual 566	com/tencent/util/MsgAutoMonitorUtil:addDbIoTime	(J)V
    //   133: aload_0
    //   134: getfield 92	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   137: invokevirtual 536	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   140: iconst_1
    //   141: ireturn
    //   142: astore_1
    //   143: goto +19 -> 162
    //   146: astore_2
    //   147: aload_0
    //   148: aload_2
    //   149: aload_1
    //   150: invokespecial 556	com/tencent/mobileqq/app/SQLiteDatabase:handleDBErr	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   153: aload_0
    //   154: getfield 92	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   157: invokevirtual 536	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   160: iconst_0
    //   161: ireturn
    //   162: aload_0
    //   163: getfield 92	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   166: invokevirtual 536	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   169: goto +5 -> 174
    //   172: aload_1
    //   173: athrow
    //   174: goto -2 -> 172
    //   177: iload_3
    //   178: iconst_1
    //   179: iadd
    //   180: istore_3
    //   181: goto -171 -> 10
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	SQLiteDatabase
    //   0	184	1	paramString	String
    //   0	184	2	paramArrayOfObject	Object[]
    //   9	172	3	i	int
    //   3	126	4	l	long
    //   12	52	6	localObject1	Object
    //   6	5	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   14	59	142	finally
    //   62	112	142	finally
    //   112	125	142	finally
    //   125	133	142	finally
    //   147	153	142	finally
    //   14	59	146	java/lang/Throwable
    //   62	112	146	java/lang/Throwable
    //   112	125	146	java/lang/Throwable
    //   125	133	146	java/lang/Throwable
  }
  
  public String[] getAllTableNameFromCache()
  {
    buildTableNameCache();
    return this.tableNameCache.getAllTableNames();
  }
  
  public String[] getAllTableNameFromDB()
  {
    long l = System.currentTimeMillis();
    try
    {
      localObject4 = this.db;
      localObject1 = null;
      Object localObject3 = null;
      if (localObject4 == null) {
        break label136;
      }
      this.mDBThreadMonitor.a();
      localObject4 = this.db.rawQuery("select distinct tbl_name from Sqlite_master", null);
      this.mDBThreadMonitor.b();
      localObject1 = localObject3;
      if (localObject4 == null) {
        break label113;
      }
      localObject1 = localObject3;
      if (!((Cursor)localObject4).moveToFirst()) {
        break label113;
      }
      localObject1 = new String[((Cursor)localObject4).getCount()];
      i = 0;
    }
    finally
    {
      for (;;)
      {
        Object localObject4;
        Object localObject1;
        int i;
        label113:
        this.mDBThreadMonitor.b();
        for (;;)
        {
          label136:
          throw localObject2;
        }
        i += 1;
      }
    }
    localObject1[i] = SecurityUtile.decode(((Cursor)localObject4).getString(0));
    if (!((Cursor)localObject4).moveToNext())
    {
      if (localObject4 != null) {
        ((Cursor)localObject4).close();
      }
      MsgAutoMonitorUtil.getInstance().addDbIoTime(System.currentTimeMillis() - l);
      this.mDBThreadMonitor.b();
      return localObject1;
    }
  }
  
  public int getCount(String paramString)
  {
    long l = System.currentTimeMillis();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select count() from ");
    ((StringBuilder)localObject).append(paramString);
    localObject = rawQuery(((StringBuilder)localObject).toString(), null);
    int i = 0;
    int j = 0;
    if (localObject != null)
    {
      i = j;
      try
      {
        if (((Cursor)localObject).moveToFirst()) {
          i = ((Cursor)localObject).getInt(0);
        }
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("select count() from ");
        localStringBuilder.append(paramString);
        handleDBErr(localThrowable, localStringBuilder.toString());
        i = j;
      }
      ((Cursor)localObject).close();
    }
    MsgAutoMonitorUtil.getInstance().addDbIoTime(System.currentTimeMillis() - l);
    return i;
  }
  
  public int getCount(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    long l = System.currentTimeMillis();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("select count() from ");
    ((StringBuilder)localObject1).append(paramString);
    Object localObject3 = ((StringBuilder)localObject1).toString();
    int j = 0;
    int i = 0;
    if (paramLong1 >= 0L) {
      localObject2 = String.format(" where time >= %d and time <= %d ", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    } else {
      localObject2 = null;
    }
    localObject1 = localObject2;
    if (paramInt1 == paramInt2) {
      if (localObject2 != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" and msgtype = ");
        ((StringBuilder)localObject1).append(paramInt1);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" where msgtype = ");
        ((StringBuilder)localObject1).append(paramInt1);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    Object localObject2 = localObject3;
    if (localObject1 != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject3);
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(" getCount sql = ");
      ((StringBuilder)localObject1).append((String)localObject2);
      QLog.d("msgbackup_sqliteDB", 4, ((StringBuilder)localObject1).toString());
    }
    localObject1 = rawQuery((String)localObject2, null);
    paramInt1 = j;
    if (localObject1 != null)
    {
      paramInt1 = i;
      try
      {
        if (((Cursor)localObject1).moveToFirst()) {
          paramInt1 = ((Cursor)localObject1).getInt(0);
        }
      }
      catch (Throwable localThrowable)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("select count() from ");
        ((StringBuilder)localObject3).append(paramString);
        handleDBErr(localThrowable, ((StringBuilder)localObject3).toString());
        paramInt1 = i;
      }
      ((Cursor)localObject1).close();
    }
    MsgAutoMonitorUtil.getInstance().addDbIoTime(System.currentTimeMillis() - l);
    return paramInt1;
  }
  
  /* Error */
  public long insert(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    // Byte code:
    //   0: invokestatic 382	java/lang/System:currentTimeMillis	()J
    //   3: lstore 7
    //   5: aload_0
    //   6: aload_1
    //   7: aload_3
    //   8: invokespecial 719	com/tencent/mobileqq/app/SQLiteDatabase:convertContentValues	(Ljava/lang/String;Landroid/content/ContentValues;)Landroid/content/ContentValues;
    //   11: astore_3
    //   12: aload_0
    //   13: getfield 92	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   16: invokevirtual 529	com/tencent/mobileqq/app/db/DBThreadMonitor:a	()V
    //   19: aload_0
    //   20: getfield 98	com/tencent/mobileqq/app/SQLiteDatabase:db	Landroid/database/sqlite/SQLiteDatabase;
    //   23: aload_1
    //   24: aload_2
    //   25: aload_3
    //   26: invokevirtual 721	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   29: lstore 5
    //   31: aload_0
    //   32: getfield 92	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   35: invokevirtual 536	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   38: invokestatic 382	java/lang/System:currentTimeMillis	()J
    //   41: lload 7
    //   43: lsub
    //   44: lstore 7
    //   46: getstatic 426	com/tencent/mobileqq/app/SQLiteDatabase:sIsLogcatDBOperation	Z
    //   49: ifne +22 -> 71
    //   52: invokestatic 541	com/tencent/mobileqq/imcore/proxy/msg/AIOUtilsProxy:getLogcatDBOperation	()Z
    //   55: ifne +16 -> 71
    //   58: ldc_w 311
    //   61: aload_1
    //   62: invokestatic 314	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   65: ifeq +177 -> 242
    //   68: goto +3 -> 71
    //   71: new 365	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 366	java/lang/StringBuilder:<init>	()V
    //   78: astore 9
    //   80: aload 9
    //   82: aload_2
    //   83: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload 9
    //   89: ldc_w 543
    //   92: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload 9
    //   98: aload_3
    //   99: invokevirtual 491	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: ldc_w 568
    //   106: aload_1
    //   107: aload 9
    //   109: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: aconst_null
    //   113: lload 7
    //   115: invokestatic 546	com/tencent/mobileqq/app/SQLiteDatabase:logcatSQLiteProfiler	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;J)V
    //   118: invokestatic 562	com/tencent/util/MsgAutoMonitorUtil:getInstance	()Lcom/tencent/util/MsgAutoMonitorUtil;
    //   121: lload 7
    //   123: invokevirtual 566	com/tencent/util/MsgAutoMonitorUtil:addDbIoTime	(J)V
    //   126: lload 5
    //   128: ldc2_w 400
    //   131: lcmp
    //   132: ifle +113 -> 245
    //   135: iconst_0
    //   136: istore 4
    //   138: goto +3 -> 141
    //   141: aload_0
    //   142: ldc_w 568
    //   145: aload_1
    //   146: iload 4
    //   148: invokespecial 550	com/tencent/mobileqq/app/SQLiteDatabase:reportDbOperatorResult	(Ljava/lang/String;Ljava/lang/String;I)V
    //   151: aload_0
    //   152: getfield 92	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   155: invokevirtual 536	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   158: lload 5
    //   160: lreturn
    //   161: astore_1
    //   162: goto +71 -> 233
    //   165: astore_2
    //   166: aload_3
    //   167: ifnull +84 -> 251
    //   170: aload_3
    //   171: invokevirtual 242	android/content/ContentValues:size	()I
    //   174: ifle +77 -> 251
    //   177: aload_3
    //   178: invokevirtual 242	android/content/ContentValues:size	()I
    //   181: istore 4
    //   183: goto +3 -> 186
    //   186: aload_0
    //   187: aload_2
    //   188: ldc_w 723
    //   191: iconst_2
    //   192: anewarray 4	java/lang/Object
    //   195: dup
    //   196: iconst_0
    //   197: aload_1
    //   198: aastore
    //   199: dup
    //   200: iconst_1
    //   201: iload 4
    //   203: invokestatic 726	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   206: aastore
    //   207: invokestatic 702	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   210: invokespecial 556	com/tencent/mobileqq/app/SQLiteDatabase:handleDBErr	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   213: aload_0
    //   214: ldc_w 568
    //   217: aload_1
    //   218: iconst_1
    //   219: invokespecial 550	com/tencent/mobileqq/app/SQLiteDatabase:reportDbOperatorResult	(Ljava/lang/String;Ljava/lang/String;I)V
    //   222: aload_0
    //   223: getfield 92	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   226: invokevirtual 536	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   229: ldc2_w 400
    //   232: lreturn
    //   233: aload_0
    //   234: getfield 92	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   237: invokevirtual 536	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   240: aload_1
    //   241: athrow
    //   242: goto -124 -> 118
    //   245: iconst_1
    //   246: istore 4
    //   248: goto -107 -> 141
    //   251: iconst_0
    //   252: istore 4
    //   254: goto -68 -> 186
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	this	SQLiteDatabase
    //   0	257	1	paramString1	String
    //   0	257	2	paramString2	String
    //   0	257	3	paramContentValues	ContentValues
    //   136	117	4	i	int
    //   29	130	5	l1	long
    //   3	119	7	l2	long
    //   78	30	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   12	68	161	finally
    //   71	118	161	finally
    //   118	126	161	finally
    //   141	151	161	finally
    //   170	183	161	finally
    //   186	222	161	finally
    //   12	68	165	java/lang/Throwable
    //   71	118	165	java/lang/Throwable
    //   118	126	165	java/lang/Throwable
    //   141	151	165	java/lang/Throwable
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
    //   0: invokestatic 382	java/lang/System:currentTimeMillis	()J
    //   3: lstore 5
    //   5: aload_0
    //   6: aload_2
    //   7: aload_3
    //   8: aload 4
    //   10: invokespecial 526	com/tencent/mobileqq/app/SQLiteDatabase:convertWhereValues	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   13: aconst_null
    //   14: astore 10
    //   16: aload 10
    //   18: astore 9
    //   20: aload_0
    //   21: getfield 92	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   24: invokevirtual 529	com/tencent/mobileqq/app/db/DBThreadMonitor:a	()V
    //   27: aload 10
    //   29: astore 9
    //   31: aload_0
    //   32: getfield 98	com/tencent/mobileqq/app/SQLiteDatabase:db	Landroid/database/sqlite/SQLiteDatabase;
    //   35: aload_1
    //   36: aload 4
    //   38: invokevirtual 681	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   41: astore 10
    //   43: aload 10
    //   45: astore 9
    //   47: aload_0
    //   48: getfield 92	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   51: invokevirtual 536	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   54: aload 10
    //   56: astore 9
    //   58: invokestatic 382	java/lang/System:currentTimeMillis	()J
    //   61: lstore 7
    //   63: aload 10
    //   65: astore 9
    //   67: getstatic 426	com/tencent/mobileqq/app/SQLiteDatabase:sIsLogcatDBOperation	Z
    //   70: ifne +17 -> 87
    //   73: aload 10
    //   75: astore 9
    //   77: aload 10
    //   79: astore 11
    //   81: invokestatic 541	com/tencent/mobileqq/imcore/proxy/msg/AIOUtilsProxy:getLogcatDBOperation	()Z
    //   84: ifeq +96 -> 180
    //   87: aload 10
    //   89: astore 9
    //   91: new 365	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 366	java/lang/StringBuilder:<init>	()V
    //   98: astore 11
    //   100: aload 10
    //   102: astore 9
    //   104: aload 11
    //   106: aload_1
    //   107: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload 10
    //   113: astore 9
    //   115: aload 11
    //   117: ldc_w 543
    //   120: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload 10
    //   126: astore 9
    //   128: aload 11
    //   130: aload_3
    //   131: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload 10
    //   137: astore 9
    //   139: ldc_w 731
    //   142: aload_2
    //   143: aload 11
    //   145: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: aload 4
    //   150: lload 7
    //   152: lload 5
    //   154: lsub
    //   155: invokestatic 546	com/tencent/mobileqq/app/SQLiteDatabase:logcatSQLiteProfiler	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;J)V
    //   158: aload 10
    //   160: astore 11
    //   162: goto +18 -> 180
    //   165: astore_1
    //   166: goto +36 -> 202
    //   169: astore_2
    //   170: aload_0
    //   171: aload_2
    //   172: aload_1
    //   173: invokespecial 556	com/tencent/mobileqq/app/SQLiteDatabase:handleDBErr	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   176: aload 9
    //   178: astore 11
    //   180: aload_0
    //   181: getfield 92	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   184: invokevirtual 536	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   187: invokestatic 562	com/tencent/util/MsgAutoMonitorUtil:getInstance	()Lcom/tencent/util/MsgAutoMonitorUtil;
    //   190: invokestatic 382	java/lang/System:currentTimeMillis	()J
    //   193: lload 5
    //   195: lsub
    //   196: invokevirtual 566	com/tencent/util/MsgAutoMonitorUtil:addDbIoTime	(J)V
    //   199: aload 11
    //   201: areturn
    //   202: aload_0
    //   203: getfield 92	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   206: invokevirtual 536	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   209: aload_1
    //   210: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	this	SQLiteDatabase
    //   0	211	1	paramString1	String
    //   0	211	2	paramString2	String
    //   0	211	3	paramString3	String
    //   0	211	4	paramArrayOfString	String[]
    //   3	191	5	l1	long
    //   61	90	7	l2	long
    //   18	159	9	localCursor1	Cursor
    //   14	145	10	localCursor2	Cursor
    //   79	121	11	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   20	27	165	finally
    //   31	43	165	finally
    //   47	54	165	finally
    //   58	63	165	finally
    //   67	73	165	finally
    //   81	87	165	finally
    //   91	100	165	finally
    //   104	111	165	finally
    //   115	124	165	finally
    //   128	135	165	finally
    //   139	158	165	finally
    //   170	176	165	finally
    //   20	27	169	java/lang/Throwable
    //   31	43	169	java/lang/Throwable
    //   47	54	169	java/lang/Throwable
    //   58	63	169	java/lang/Throwable
    //   67	73	169	java/lang/Throwable
    //   81	87	169	java/lang/Throwable
    //   91	100	169	java/lang/Throwable
    //   104	111	169	java/lang/Throwable
    //   115	124	169	java/lang/Throwable
    //   128	135	169	java/lang/Throwable
    //   139	158	169	java/lang/Throwable
  }
  
  /* Error */
  @java.lang.Deprecated
  public Cursor rawQuery(String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: invokestatic 382	java/lang/System:currentTimeMillis	()J
    //   3: lstore_3
    //   4: aconst_null
    //   5: astore 6
    //   7: aload 6
    //   9: astore 5
    //   11: aload_0
    //   12: getfield 92	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   15: invokevirtual 529	com/tencent/mobileqq/app/db/DBThreadMonitor:a	()V
    //   18: aload 6
    //   20: astore 5
    //   22: aload_0
    //   23: getfield 98	com/tencent/mobileqq/app/SQLiteDatabase:db	Landroid/database/sqlite/SQLiteDatabase;
    //   26: aload_1
    //   27: aload_2
    //   28: invokevirtual 681	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   31: astore 6
    //   33: aload 6
    //   35: astore 5
    //   37: aload_0
    //   38: getfield 92	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   41: invokevirtual 536	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   44: aload_0
    //   45: getfield 92	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   48: invokevirtual 536	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   51: invokestatic 382	java/lang/System:currentTimeMillis	()J
    //   54: lload_3
    //   55: lsub
    //   56: lstore_3
    //   57: invokestatic 562	com/tencent/util/MsgAutoMonitorUtil:getInstance	()Lcom/tencent/util/MsgAutoMonitorUtil;
    //   60: lload_3
    //   61: invokevirtual 566	com/tencent/util/MsgAutoMonitorUtil:addDbIoTime	(J)V
    //   64: aload 6
    //   66: astore 7
    //   68: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   71: ifeq +150 -> 221
    //   74: new 365	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 366	java/lang/StringBuilder:<init>	()V
    //   81: astore 7
    //   83: aload 6
    //   85: astore 5
    //   87: aload 7
    //   89: astore 6
    //   91: aload 6
    //   93: ldc_w 734
    //   96: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload 6
    //   102: aload_1
    //   103: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload 6
    //   109: ldc_w 736
    //   112: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload 6
    //   118: aload_2
    //   119: invokestatic 741	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   122: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload 6
    //   128: ldc_w 743
    //   131: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload 6
    //   137: lload_3
    //   138: invokevirtual 467	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload 6
    //   144: ldc_w 745
    //   147: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: ldc 37
    //   153: iconst_2
    //   154: aload 6
    //   156: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: aload 5
    //   164: areturn
    //   165: astore 5
    //   167: goto +57 -> 224
    //   170: astore 6
    //   172: aload_0
    //   173: aload 6
    //   175: aload_1
    //   176: invokespecial 556	com/tencent/mobileqq/app/SQLiteDatabase:handleDBErr	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   179: aload_0
    //   180: getfield 92	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   183: invokevirtual 536	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   186: invokestatic 382	java/lang/System:currentTimeMillis	()J
    //   189: lload_3
    //   190: lsub
    //   191: lstore_3
    //   192: invokestatic 562	com/tencent/util/MsgAutoMonitorUtil:getInstance	()Lcom/tencent/util/MsgAutoMonitorUtil;
    //   195: lload_3
    //   196: invokevirtual 566	com/tencent/util/MsgAutoMonitorUtil:addDbIoTime	(J)V
    //   199: aload 5
    //   201: astore 7
    //   203: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   206: ifeq +15 -> 221
    //   209: new 365	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 366	java/lang/StringBuilder:<init>	()V
    //   216: astore 6
    //   218: goto -127 -> 91
    //   221: aload 7
    //   223: areturn
    //   224: aload_0
    //   225: getfield 92	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   228: invokevirtual 536	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   231: invokestatic 382	java/lang/System:currentTimeMillis	()J
    //   234: lload_3
    //   235: lsub
    //   236: lstore_3
    //   237: invokestatic 562	com/tencent/util/MsgAutoMonitorUtil:getInstance	()Lcom/tencent/util/MsgAutoMonitorUtil;
    //   240: lload_3
    //   241: invokevirtual 566	com/tencent/util/MsgAutoMonitorUtil:addDbIoTime	(J)V
    //   244: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   247: ifeq +83 -> 330
    //   250: new 365	java/lang/StringBuilder
    //   253: dup
    //   254: invokespecial 366	java/lang/StringBuilder:<init>	()V
    //   257: astore 6
    //   259: aload 6
    //   261: ldc_w 734
    //   264: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: pop
    //   268: aload 6
    //   270: aload_1
    //   271: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: pop
    //   275: aload 6
    //   277: ldc_w 736
    //   280: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload 6
    //   286: aload_2
    //   287: invokestatic 741	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   290: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload 6
    //   296: ldc_w 743
    //   299: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: aload 6
    //   305: lload_3
    //   306: invokevirtual 467	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: aload 6
    //   312: ldc_w 745
    //   315: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: ldc 37
    //   321: iconst_2
    //   322: aload 6
    //   324: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   330: goto +6 -> 336
    //   333: aload 5
    //   335: athrow
    //   336: goto -3 -> 333
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	339	0	this	SQLiteDatabase
    //   0	339	1	paramString	String
    //   0	339	2	paramArrayOfString	String[]
    //   3	303	3	l	long
    //   9	154	5	localObject1	Object
    //   165	169	5	localObject2	Object
    //   5	150	6	localObject3	Object
    //   170	4	6	localThrowable	Throwable
    //   216	107	6	localStringBuilder	StringBuilder
    //   66	156	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   11	18	165	finally
    //   22	33	165	finally
    //   37	44	165	finally
    //   172	179	165	finally
    //   11	18	170	java/lang/Throwable
    //   22	33	170	java/lang/Throwable
    //   37	44	170	java/lang/Throwable
  }
  
  public void removeFromTableCache(String paramString)
  {
    this.tableNameCache.deleteFromTableCache(paramString);
  }
  
  /* Error */
  public long replace(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    // Byte code:
    //   0: invokestatic 382	java/lang/System:currentTimeMillis	()J
    //   3: lstore 7
    //   5: aload_0
    //   6: aload_1
    //   7: aload_3
    //   8: invokespecial 719	com/tencent/mobileqq/app/SQLiteDatabase:convertContentValues	(Ljava/lang/String;Landroid/content/ContentValues;)Landroid/content/ContentValues;
    //   11: astore_3
    //   12: aload_0
    //   13: getfield 92	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   16: invokevirtual 529	com/tencent/mobileqq/app/db/DBThreadMonitor:a	()V
    //   19: aload_0
    //   20: getfield 98	com/tencent/mobileqq/app/SQLiteDatabase:db	Landroid/database/sqlite/SQLiteDatabase;
    //   23: aload_1
    //   24: aload_2
    //   25: aload_3
    //   26: invokevirtual 753	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   29: lstore 5
    //   31: aload_0
    //   32: getfield 92	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   35: invokevirtual 536	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   38: invokestatic 382	java/lang/System:currentTimeMillis	()J
    //   41: lload 7
    //   43: lsub
    //   44: lstore 7
    //   46: getstatic 426	com/tencent/mobileqq/app/SQLiteDatabase:sIsLogcatDBOperation	Z
    //   49: ifne +22 -> 71
    //   52: invokestatic 541	com/tencent/mobileqq/imcore/proxy/msg/AIOUtilsProxy:getLogcatDBOperation	()Z
    //   55: ifne +16 -> 71
    //   58: ldc_w 311
    //   61: aload_1
    //   62: invokestatic 314	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   65: ifeq +177 -> 242
    //   68: goto +3 -> 71
    //   71: new 365	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 366	java/lang/StringBuilder:<init>	()V
    //   78: astore 9
    //   80: aload 9
    //   82: aload_2
    //   83: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload 9
    //   89: ldc_w 543
    //   92: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload 9
    //   98: aload_3
    //   99: invokevirtual 491	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: ldc_w 754
    //   106: aload_1
    //   107: aload 9
    //   109: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: aconst_null
    //   113: lload 7
    //   115: invokestatic 546	com/tencent/mobileqq/app/SQLiteDatabase:logcatSQLiteProfiler	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;J)V
    //   118: invokestatic 562	com/tencent/util/MsgAutoMonitorUtil:getInstance	()Lcom/tencent/util/MsgAutoMonitorUtil;
    //   121: lload 7
    //   123: invokevirtual 566	com/tencent/util/MsgAutoMonitorUtil:addDbIoTime	(J)V
    //   126: lload 5
    //   128: ldc2_w 400
    //   131: lcmp
    //   132: ifle +113 -> 245
    //   135: iconst_0
    //   136: istore 4
    //   138: goto +3 -> 141
    //   141: aload_0
    //   142: ldc_w 754
    //   145: aload_1
    //   146: iload 4
    //   148: invokespecial 550	com/tencent/mobileqq/app/SQLiteDatabase:reportDbOperatorResult	(Ljava/lang/String;Ljava/lang/String;I)V
    //   151: aload_0
    //   152: getfield 92	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   155: invokevirtual 536	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   158: lload 5
    //   160: lreturn
    //   161: astore_1
    //   162: goto +71 -> 233
    //   165: astore_2
    //   166: aload_3
    //   167: ifnull +84 -> 251
    //   170: aload_3
    //   171: invokevirtual 242	android/content/ContentValues:size	()I
    //   174: ifle +77 -> 251
    //   177: aload_3
    //   178: invokevirtual 242	android/content/ContentValues:size	()I
    //   181: istore 4
    //   183: goto +3 -> 186
    //   186: aload_0
    //   187: aload_2
    //   188: ldc_w 756
    //   191: iconst_2
    //   192: anewarray 4	java/lang/Object
    //   195: dup
    //   196: iconst_0
    //   197: aload_1
    //   198: aastore
    //   199: dup
    //   200: iconst_1
    //   201: iload 4
    //   203: invokestatic 726	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   206: aastore
    //   207: invokestatic 702	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   210: invokespecial 556	com/tencent/mobileqq/app/SQLiteDatabase:handleDBErr	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   213: aload_0
    //   214: ldc_w 754
    //   217: aload_1
    //   218: iconst_1
    //   219: invokespecial 550	com/tencent/mobileqq/app/SQLiteDatabase:reportDbOperatorResult	(Ljava/lang/String;Ljava/lang/String;I)V
    //   222: aload_0
    //   223: getfield 92	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   226: invokevirtual 536	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   229: ldc2_w 400
    //   232: lreturn
    //   233: aload_0
    //   234: getfield 92	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   237: invokevirtual 536	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   240: aload_1
    //   241: athrow
    //   242: goto -124 -> 118
    //   245: iconst_1
    //   246: istore 4
    //   248: goto -107 -> 141
    //   251: iconst_0
    //   252: istore 4
    //   254: goto -68 -> 186
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	this	SQLiteDatabase
    //   0	257	1	paramString1	String
    //   0	257	2	paramString2	String
    //   0	257	3	paramContentValues	ContentValues
    //   136	117	4	i	int
    //   29	130	5	l1	long
    //   3	119	7	l2	long
    //   78	30	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   12	68	161	finally
    //   71	118	161	finally
    //   118	126	161	finally
    //   141	151	161	finally
    //   170	183	161	finally
    //   186	222	161	finally
    //   12	68	165	java/lang/Throwable
    //   71	118	165	java/lang/Throwable
    //   118	126	165	java/lang/Throwable
    //   141	151	165	java/lang/Throwable
  }
  
  public void setLockingEnabled(boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    try
    {
      this.db.setLockingEnabled(paramBoolean);
    }
    catch (Throwable localThrowable)
    {
      handleDBErr(localThrowable, "setLockingEnabled");
    }
    MsgAutoMonitorUtil.getInstance().addDbIoTime(System.currentTimeMillis() - l);
  }
  
  public void setTransactionSuccessful()
  {
    long l = System.currentTimeMillis();
    try
    {
      this.db.setTransactionSuccessful();
    }
    catch (Throwable localThrowable)
    {
      handleDBErr(localThrowable, "setTransactionSuccessful");
    }
    MsgAutoMonitorUtil.getInstance().addDbIoTime(System.currentTimeMillis() - l);
  }
  
  /* Error */
  public int update(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: invokestatic 382	java/lang/System:currentTimeMillis	()J
    //   3: lstore 6
    //   5: aload_0
    //   6: aload_1
    //   7: aload_2
    //   8: ldc_w 768
    //   11: invokespecial 770	com/tencent/mobileqq/app/SQLiteDatabase:outputExtensionInfoLog	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;)V
    //   14: aload_0
    //   15: aload_1
    //   16: aload_2
    //   17: invokespecial 719	com/tencent/mobileqq/app/SQLiteDatabase:convertContentValues	(Ljava/lang/String;Landroid/content/ContentValues;)Landroid/content/ContentValues;
    //   20: astore_2
    //   21: aload_0
    //   22: aload_1
    //   23: aload_2
    //   24: ldc_w 772
    //   27: invokespecial 770	com/tencent/mobileqq/app/SQLiteDatabase:outputExtensionInfoLog	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;)V
    //   30: aload_0
    //   31: aload_1
    //   32: aload_3
    //   33: aload 4
    //   35: invokespecial 526	com/tencent/mobileqq/app/SQLiteDatabase:convertWhereValues	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   38: aload_0
    //   39: getfield 92	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   42: invokevirtual 529	com/tencent/mobileqq/app/db/DBThreadMonitor:a	()V
    //   45: aload_0
    //   46: getfield 98	com/tencent/mobileqq/app/SQLiteDatabase:db	Landroid/database/sqlite/SQLiteDatabase;
    //   49: aload_1
    //   50: aload_2
    //   51: aload_3
    //   52: aload 4
    //   54: invokevirtual 774	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   57: istore 5
    //   59: aload_0
    //   60: getfield 92	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   63: invokevirtual 536	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   66: invokestatic 382	java/lang/System:currentTimeMillis	()J
    //   69: lload 6
    //   71: lsub
    //   72: lstore 6
    //   74: getstatic 426	com/tencent/mobileqq/app/SQLiteDatabase:sIsLogcatDBOperation	Z
    //   77: ifne +19 -> 96
    //   80: invokestatic 541	com/tencent/mobileqq/imcore/proxy/msg/AIOUtilsProxy:getLogcatDBOperation	()Z
    //   83: ifne +13 -> 96
    //   86: ldc_w 311
    //   89: aload_1
    //   90: invokestatic 314	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   93: ifeq +51 -> 144
    //   96: new 365	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 366	java/lang/StringBuilder:<init>	()V
    //   103: astore 8
    //   105: aload 8
    //   107: aload_2
    //   108: invokevirtual 491	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload 8
    //   114: ldc_w 543
    //   117: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload 8
    //   123: aload_3
    //   124: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: ldc_w 775
    //   131: aload_1
    //   132: aload 8
    //   134: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: aload 4
    //   139: lload 6
    //   141: invokestatic 546	com/tencent/mobileqq/app/SQLiteDatabase:logcatSQLiteProfiler	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;J)V
    //   144: invokestatic 562	com/tencent/util/MsgAutoMonitorUtil:getInstance	()Lcom/tencent/util/MsgAutoMonitorUtil;
    //   147: lload 6
    //   149: invokevirtual 566	com/tencent/util/MsgAutoMonitorUtil:addDbIoTime	(J)V
    //   152: aload_0
    //   153: getfield 92	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   156: invokevirtual 536	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   159: iload 5
    //   161: ireturn
    //   162: astore_1
    //   163: goto +60 -> 223
    //   166: astore_3
    //   167: aload_2
    //   168: ifnull +64 -> 232
    //   171: aload_2
    //   172: invokevirtual 242	android/content/ContentValues:size	()I
    //   175: ifle +57 -> 232
    //   178: aload_2
    //   179: invokevirtual 242	android/content/ContentValues:size	()I
    //   182: istore 5
    //   184: goto +3 -> 187
    //   187: aload_0
    //   188: aload_3
    //   189: ldc_w 777
    //   192: iconst_2
    //   193: anewarray 4	java/lang/Object
    //   196: dup
    //   197: iconst_0
    //   198: aload_1
    //   199: aastore
    //   200: dup
    //   201: iconst_1
    //   202: iload 5
    //   204: invokestatic 726	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   207: aastore
    //   208: invokestatic 702	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   211: invokespecial 556	com/tencent/mobileqq/app/SQLiteDatabase:handleDBErr	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   214: aload_0
    //   215: getfield 92	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   218: invokevirtual 536	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   221: iconst_m1
    //   222: ireturn
    //   223: aload_0
    //   224: getfield 92	com/tencent/mobileqq/app/SQLiteDatabase:mDBThreadMonitor	Lcom/tencent/mobileqq/app/db/DBThreadMonitor;
    //   227: invokevirtual 536	com/tencent/mobileqq/app/db/DBThreadMonitor:b	()V
    //   230: aload_1
    //   231: athrow
    //   232: iconst_0
    //   233: istore 5
    //   235: goto -48 -> 187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	this	SQLiteDatabase
    //   0	238	1	paramString1	String
    //   0	238	2	paramContentValues	ContentValues
    //   0	238	3	paramString2	String
    //   0	238	4	paramArrayOfString	String[]
    //   57	177	5	i	int
    //   3	145	6	l	long
    //   103	30	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   38	96	162	finally
    //   96	144	162	finally
    //   144	152	162	finally
    //   171	184	162	finally
    //   187	214	162	finally
    //   38	96	166	java/lang/Throwable
    //   96	144	166	java/lang/Throwable
    //   144	152	166	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.SQLiteDatabase
 * JD-Core Version:    0.7.0.1
 */