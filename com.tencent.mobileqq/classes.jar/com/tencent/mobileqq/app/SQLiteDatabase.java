package com.tencent.mobileqq.app;

import actn;
import android.annotation.TargetApi;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.os.Looper;
import android.text.TextUtils;
import aulo;
import axrl;
import bfmu;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQLiteDatabase
{
  public static boolean a;
  private long jdField_a_of_type_Long;
  public final android.database.sqlite.SQLiteDatabase a;
  private aulo jdField_a_of_type_Aulo;
  private final Map<String, ArrayList<String>> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap(32);
  private final Map<String, ArrayList<String>> jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap(32);
  private boolean jdField_b_of_type_Boolean;
  
  public SQLiteDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, aulo paramaulo, String paramString)
  {
    this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = paramSQLiteDatabase;
    this.jdField_a_of_type_Aulo = paramaulo;
    if ((TextUtils.isEmpty(paramString)) || (paramString.endsWith("59.db"))) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_b_of_type_Boolean = bool;
      return;
    }
  }
  
  private static int a(StackTraceElement[] paramArrayOfStackTraceElement1, StackTraceElement[] paramArrayOfStackTraceElement2)
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
  
  private ContentValues a(String paramString, ContentValues paramContentValues)
  {
    if ((paramContentValues == null) || (paramContentValues.size() <= 0)) {
      return paramContentValues;
    }
    ContentValues localContentValues = new ContentValues(paramContentValues);
    paramString = a(paramString);
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
              localContentValues.put(str, a(localObject));
            }
          }
          else if ((localObject instanceof byte[]))
          {
            localContentValues.put(str, a((byte[])localObject));
          }
        }
      }
    }
    return localContentValues;
  }
  
  private Cursor a(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    long l1 = System.currentTimeMillis();
    a(paramString1, paramString2, paramArrayOfString2);
    for (;;)
    {
      try
      {
        localCursor = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.query(false, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6);
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
        a("query", paramString1, 1);
        a(paramArrayOfString2, paramString3.toString());
        continue;
      }
      finally {}
      try
      {
        l2 = System.currentTimeMillis();
        if ((!jdField_a_of_type_Boolean) && (!actn.f)) {
          break label308;
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
        a("query", paramString1, localStringBuilder.toString(), null, l2 - l1);
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
      a("query", paramString1, i);
      paramArrayOfString1 = localCursor;
      bfmu.a().a(System.currentTimeMillis() - l1);
      return paramArrayOfString1;
      i = 1;
    }
  }
  
  private String a(Object paramObject)
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
    return SecurityUtile.a(str);
  }
  
  private ArrayList<String> a(String paramString)
  {
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
    {
      Cursor localCursor = a("select sql from sqlite_master where type=? and name=?", new String[] { "table", paramString });
      if (localCursor != null)
      {
        if (localCursor.moveToFirst())
        {
          ArrayList localArrayList = a(SecurityUtile.b(localCursor.getString(0)), new String[] { "TEXT", "BLOB" });
          this.jdField_a_of_type_JavaUtilMap.put(paramString, localArrayList);
        }
        localCursor.close();
      }
    }
    return (ArrayList)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  private ArrayList<String> a(String paramString, String[] paramArrayOfString)
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
  
  private void a(String paramString1, String paramString2) {}
  
  private void a(String paramString1, String paramString2, int paramInt)
  {
    if (!this.jdField_b_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_Long += 1L;
      if (!"insert".equals(paramString1)) {
        break;
      }
    } while (this.jdField_a_of_type_Long % 100L != 0L);
    HashMap localHashMap = new HashMap(4);
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("OpType", paramString1);
    localHashMap.put("OpTableName", paramString2);
    localHashMap.put("param_FailCode", Integer.toString(paramInt));
    paramString2 = axrl.a(BaseApplication.getContext());
    paramString1 = "DatabaseOperatorResult_" + paramString1;
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramString2.a("", paramString1, bool, 0L, 0L, localHashMap, null);
      return;
      if (this.jdField_a_of_type_Long % 500L == 0L) {
        break;
      }
      return;
    }
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject, long paramLong)
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
  
  private void a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    if ((paramString2 == null) || (paramArrayOfString == null)) {}
    for (;;)
    {
      return;
      paramString1 = a(paramString1);
      if (paramString1 != null)
      {
        paramString2 = b(paramString2);
        int i = 0;
        while (i < paramString2.size())
        {
          if ((paramString1.contains(paramString2.get(i))) && ((paramArrayOfString[i] instanceof String))) {
            paramArrayOfString[i] = a(paramArrayOfString[i]);
          }
          i += 1;
        }
      }
    }
  }
  
  private void a(Throwable paramThrowable)
  {
    StringBuilder localStringBuilder;
    if ((QLog.isColorLevel()) && (paramThrowable.getMessage() != null) && (!paramThrowable.getMessage().contains("no such table")))
    {
      QLog.e("SQLiteDatabase", 2, paramThrowable.getMessage());
      localStringBuilder = new StringBuilder();
    }
    try
    {
      a(paramThrowable, localStringBuilder, "", null);
      label55:
      QLog.e("SQLiteDatabase", 2, new Object[] { localStringBuilder });
      return;
    }
    catch (Exception paramThrowable)
    {
      break label55;
    }
  }
  
  private void a(Throwable paramThrowable, String paramString)
  {
    if (System.currentTimeMillis() - QQEntityManagerFactory.corruptedTime < 100L) {}
    for (boolean bool = true;; bool = false)
    {
      if (((paramThrowable instanceof SQLiteDatabaseCorruptException)) || (bool))
      {
        QLog.e("SQLiteDatabase", 1, paramString + " " + bool);
        QQEntityManagerFactory.corruptedTime = -1L;
      }
      a(paramThrowable);
      return;
    }
  }
  
  private void a(Throwable paramThrowable, StringBuilder paramStringBuilder, String paramString, StackTraceElement[] paramArrayOfStackTraceElement)
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
        i = a(paramStringBuilder, paramArrayOfStackTraceElement);
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
      a(paramThrowable, localStringBuilder, paramString, paramStringBuilder);
    }
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return paramArrayOfByte;
    }
    return SecurityUtile.a(paramArrayOfByte);
  }
  
  private ArrayList<String> b(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilMap.containsKey(paramString)) {
      return (ArrayList)this.jdField_b_of_type_JavaUtilMap.get(paramString);
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
    this.jdField_b_of_type_JavaUtilMap.put(paramString, localArrayList);
    return localArrayList;
  }
  
  public static void beginTransactionLog() {}
  
  public static void endTransactionLog() {}
  
  private void f()
  {
    if (!this.jdField_a_of_type_Aulo.jdField_a_of_type_Boolean) {}
    try
    {
      String[] arrayOfString = a();
      this.jdField_a_of_type_Aulo.a(arrayOfString);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("db", 2, "buildTableNameCache exception", localException);
    }
  }
  
  public int a(String paramString)
  {
    int i = 0;
    int j = 0;
    long l = System.currentTimeMillis();
    Cursor localCursor = a("select count() from " + paramString, null);
    if (localCursor != null) {
      i = j;
    }
    try
    {
      if (localCursor.moveToFirst()) {
        i = localCursor.getInt(0);
      }
      localCursor.close();
      bfmu.a().a(System.currentTimeMillis() - l);
      return i;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        a(localThrowable, "select count() from " + paramString);
        i = j;
      }
    }
  }
  
  public int a(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    long l = System.currentTimeMillis();
    String str2 = "select count() from " + paramString;
    if (paramLong1 >= 0L) {}
    label286:
    Object localObject2;
    for (String str1 = String.format(" where time >= %d and time <= %d ", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });; localObject2 = null)
    {
      Object localObject1 = str1;
      if (paramInt == -1000)
      {
        if (str1 != null) {
          localObject1 = str1 + " and msgtype = " + paramInt;
        }
      }
      else
      {
        str1 = str2;
        if (localObject1 != null) {
          str1 = str2 + (String)localObject1;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("msgbackup_sqliteDB", 4, " getCount sql = " + str1);
        }
        localObject1 = a(str1, null);
        if (localObject1 == null) {
          break label286;
        }
      }
      for (;;)
      {
        try
        {
          if (((Cursor)localObject1).moveToFirst())
          {
            paramInt = ((Cursor)localObject1).getInt(0);
            ((Cursor)localObject1).close();
            bfmu.a().a(System.currentTimeMillis() - l);
            return paramInt;
            localObject1 = " where msgtype = " + paramInt;
          }
        }
        catch (Throwable localThrowable)
        {
          a(localThrowable, "select count() from " + paramString);
          paramInt = 0;
          continue;
        }
        paramInt = 0;
      }
    }
  }
  
  public int a(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    long l = System.currentTimeMillis();
    paramContentValues = a(paramString1, paramContentValues);
    a(paramString1, paramString2, paramArrayOfString);
    try
    {
      i = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.update(paramString1, paramContentValues, paramString2, paramArrayOfString);
      l = System.currentTimeMillis() - l;
      if ((jdField_a_of_type_Boolean) || (actn.f)) {
        a("update", paramString1, paramContentValues + ";" + paramString2, paramArrayOfString, l);
      }
      bfmu.a().a(l);
      return i;
    }
    catch (Throwable paramString2)
    {
      if (paramContentValues == null) {
        break label146;
      }
    }
    if (paramContentValues.size() > 0) {}
    label146:
    for (int i = paramContentValues.size();; i = 0)
    {
      a(paramString2, String.format("UPDATE %s, %d", new Object[] { paramString1, Integer.valueOf(i) }));
      return -1;
    }
  }
  
  public int a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    long l1 = System.currentTimeMillis();
    a(paramString1, null);
    a(paramString1, paramString2, paramArrayOfString);
    StringBuilder localStringBuilder;
    try
    {
      int i = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.delete(paramString1, paramString2, paramArrayOfString);
      long l2 = System.currentTimeMillis() - l1;
      if ((jdField_a_of_type_Boolean) || (actn.f)) {
        a("delete", paramString1, paramString2 + ";", paramArrayOfString, l2);
      }
      bfmu.a().a(l2);
      a("delete", paramString1, 0);
      return i;
    }
    catch (Throwable paramArrayOfString)
    {
      localStringBuilder = new StringBuilder().append("DELETE FROM ").append(paramString1);
      if (TextUtils.isEmpty(paramString2)) {}
    }
    for (paramString2 = " WHERE " + paramString2;; paramString2 = "")
    {
      a(paramArrayOfString, paramString2);
      a("delete", paramString1, 1);
      bfmu.a().a(System.currentTimeMillis() - l1);
      return -1;
    }
  }
  
  public long a(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    long l2 = System.currentTimeMillis();
    paramContentValues = a(paramString1, paramContentValues);
    try
    {
      long l1 = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.insert(paramString1, paramString2, paramContentValues);
      l2 = System.currentTimeMillis() - l2;
      if ((jdField_a_of_type_Boolean) || (actn.f)) {
        a("insert", paramString1, paramString2 + ";" + paramContentValues, null, l2);
      }
      bfmu.a().a(l2);
      if (l1 > -1L) {}
      for (i = 0;; i = 1)
      {
        a("insert", paramString1, i);
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
      a(paramString2, String.format("INSERT INTO %s, %d", new Object[] { paramString1, Integer.valueOf(i) }));
      a("insert", paramString1, 1);
      return -1L;
    }
  }
  
  /* Error */
  public Cursor a(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: invokestatic 117	java/lang/System:currentTimeMillis	()J
    //   3: lstore 5
    //   5: aload_0
    //   6: aload_2
    //   7: aload_3
    //   8: aload 4
    //   10: invokespecial 120	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield 28	com/tencent/mobileqq/app/SQLiteDatabase:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   17: aload_1
    //   18: aload 4
    //   20: invokevirtual 530	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   23: astore 9
    //   25: invokestatic 117	java/lang/System:currentTimeMillis	()J
    //   28: lstore 7
    //   30: getstatic 127	com/tencent/mobileqq/app/SQLiteDatabase:jdField_a_of_type_Boolean	Z
    //   33: ifne +9 -> 42
    //   36: getstatic 132	actn:f	Z
    //   39: ifeq +40 -> 79
    //   42: ldc_w 531
    //   45: aload_2
    //   46: new 134	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   53: aload_1
    //   54: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: ldc 141
    //   59: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload_3
    //   63: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: aload 4
    //   71: lload 7
    //   73: lload 5
    //   75: lsub
    //   76: invokestatic 152	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;J)V
    //   79: aload 9
    //   81: astore_2
    //   82: invokestatic 160	bfmu:a	()Lbfmu;
    //   85: invokestatic 117	java/lang/System:currentTimeMillis	()J
    //   88: lload 5
    //   90: lsub
    //   91: invokevirtual 163	bfmu:a	(J)V
    //   94: aload_2
    //   95: areturn
    //   96: astore_3
    //   97: aconst_null
    //   98: astore_2
    //   99: aload_0
    //   100: aload_3
    //   101: aload_1
    //   102: invokespecial 171	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   105: goto -23 -> 82
    //   108: astore_1
    //   109: aload_1
    //   110: athrow
    //   111: astore_3
    //   112: aload 9
    //   114: astore_2
    //   115: goto -16 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	SQLiteDatabase
    //   0	118	1	paramString1	String
    //   0	118	2	paramString2	String
    //   0	118	3	paramString3	String
    //   0	118	4	paramArrayOfString	String[]
    //   3	86	5	l1	long
    //   28	44	7	l2	long
    //   23	90	9	localCursor	Cursor
    // Exception table:
    //   from	to	target	type
    //   13	25	96	java/lang/Throwable
    //   13	25	108	finally
    //   25	42	108	finally
    //   42	79	108	finally
    //   99	105	108	finally
    //   25	42	111	java/lang/Throwable
    //   42	79	111	java/lang/Throwable
  }
  
  @Deprecated
  public Cursor a(String paramString, String[] paramArrayOfString)
  {
    long l = System.currentTimeMillis();
    localObject = null;
    try
    {
      paramArrayOfString = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.rawQuery(paramString, paramArrayOfString);
      paramString = paramArrayOfString;
    }
    catch (Throwable paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString = paramArrayOfString;
        a(paramArrayOfString, paramString);
        paramString = localObject;
      }
    }
    finally {}
    bfmu.a().a(System.currentTimeMillis() - l);
    return paramString;
  }
  
  public Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4)
  {
    return a(false, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, null, null, paramString3, paramString4);
  }
  
  public void a()
  {
    long l = System.currentTimeMillis();
    try
    {
      beginTransactionLog();
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.beginTransaction();
      bfmu.a().a(System.currentTimeMillis() - l);
      bfmu.a().b(1L);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        a(localThrowable, "beginTransaction");
      }
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Aulo.a(paramString);
  }
  
  public boolean a(String paramString)
  {
    long l = System.currentTimeMillis();
    try
    {
      a(null, paramString);
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.execSQL(paramString);
      l = System.currentTimeMillis() - l;
      if ((jdField_a_of_type_Boolean) || (actn.f)) {
        a("execSQL", "", paramString, null, l);
      }
      bfmu.a().a(l);
      return true;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable, paramString);
    }
    return false;
  }
  
  public boolean a(String paramString, Object[] paramArrayOfObject)
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
              a(str, paramString);
              this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.execSQL(paramString, paramArrayOfObject);
              l = System.currentTimeMillis() - l;
              if ((jdField_a_of_type_Boolean) || (actn.f)) {
                a("execSQL", "", paramString, paramArrayOfObject, l);
              }
              bfmu.a().a(l);
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
        a(paramArrayOfObject, paramString);
        return false;
      }
    }
  }
  
  public String[] a()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    long l = System.currentTimeMillis();
    Cursor localCursor;
    int i;
    if (this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase != null)
    {
      localCursor = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.rawQuery("select distinct tbl_name from Sqlite_master", null);
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
      localObject1[i] = SecurityUtile.b(localCursor.getString(0));
      if (!localCursor.moveToNext())
      {
        if (localCursor != null) {
          localCursor.close();
        }
        bfmu.a().a(System.currentTimeMillis() - l);
        return localObject1;
      }
      i += 1;
    }
  }
  
  public long b(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    long l2 = System.currentTimeMillis();
    paramContentValues = a(paramString1, paramContentValues);
    try
    {
      long l1 = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace(paramString1, paramString2, paramContentValues);
      l2 = System.currentTimeMillis() - l2;
      if ((jdField_a_of_type_Boolean) || (actn.f)) {
        a("replace", paramString1, paramString2 + ";" + paramContentValues, null, l2);
      }
      bfmu.a().a(l2);
      if (l1 > -1L) {}
      for (i = 0;; i = 1)
      {
        a("replace", paramString1, i);
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
      a(paramString2, String.format("replace, INSERT INTO %s, %d", new Object[] { paramString1, Integer.valueOf(i) }));
      a("replace", paramString1, 1);
      return -1L;
    }
  }
  
  @TargetApi(11)
  public void b()
  {
    long l = System.currentTimeMillis();
    try
    {
      beginTransactionLog();
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.beginTransactionNonExclusive();
      bfmu.a().a(System.currentTimeMillis() - l);
      bfmu.a().b(1L);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        a(localThrowable, "beginTransactionNonExclusive");
      }
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_Aulo.b(paramString);
  }
  
  public boolean b(String paramString)
  {
    f();
    return this.jdField_a_of_type_Aulo.a(paramString);
  }
  
  public String[] b()
  {
    f();
    return this.jdField_a_of_type_Aulo.a();
  }
  
  public void c()
  {
    long l = System.currentTimeMillis();
    try
    {
      QLog.e("db", 1, "SQLiteDatabase close");
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.close();
      bfmu.a().a(System.currentTimeMillis() - l);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        a(localThrowable, "close");
      }
    }
  }
  
  public void d()
  {
    long l = System.currentTimeMillis();
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.endTransaction();
      endTransactionLog();
      bfmu.a().a(System.currentTimeMillis() - l);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        a(localThrowable, "endTransaction");
      }
    }
  }
  
  public void e()
  {
    long l = System.currentTimeMillis();
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.setTransactionSuccessful();
      bfmu.a().a(System.currentTimeMillis() - l);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        a(localThrowable, "setTransactionSuccessful");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SQLiteDatabase
 * JD-Core Version:    0.7.0.1
 */