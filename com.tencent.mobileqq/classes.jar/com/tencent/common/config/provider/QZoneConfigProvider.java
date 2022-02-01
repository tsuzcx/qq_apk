package com.tencent.common.config.provider;

import abfg;
import abfh;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.util.concurrent.ConcurrentHashMap;

public class QZoneConfigProvider
  extends ContentProvider
  implements abfh
{
  private static final UriMatcher a;
  public static ConcurrentHashMap<String, abfg> a;
  public Object a;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_AndroidContentUriMatcher = a();
  }
  
  public QZoneConfigProvider()
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
  }
  
  private int a(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    int i = a().d(paramString, paramArrayOfString);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return i;
  }
  
  private int a(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    int i = a().a(paramUri, "table_qz_unread", paramArrayOfContentValues);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return i;
  }
  
  /* Error */
  private abfg a()
  {
    // Byte code:
    //   0: ldc 68
    //   2: astore_2
    //   3: ldc 70
    //   5: getstatic 76	com/tencent/common/app/BaseApplicationImpl:sInjectResult	Ljava/lang/String;
    //   8: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11: ifeq +9 -> 20
    //   14: invokestatic 87	anrj:a	()Z
    //   17: ifne +43 -> 60
    //   20: ldc 89
    //   22: iconst_1
    //   23: new 91	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   30: ldc 94
    //   32: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: getstatic 76	com/tencent/common/app/BaseApplicationImpl:sInjectResult	Ljava/lang/String;
    //   38: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc 100
    //   43: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokestatic 87	anrj:a	()Z
    //   49: invokevirtual 103	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   52: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   58: aconst_null
    //   59: areturn
    //   60: invokestatic 117	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   63: ifnull +161 -> 224
    //   66: invokestatic 117	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   69: invokevirtual 121	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   72: ifnull +152 -> 224
    //   75: invokestatic 117	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   78: invokevirtual 121	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   81: invokevirtual 126	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   84: invokestatic 132	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   87: ifne +137 -> 224
    //   90: invokestatic 117	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   93: invokevirtual 121	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   96: invokevirtual 126	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   99: astore_1
    //   100: getstatic 20	com/tencent/common/config/provider/QZoneConfigProvider:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   103: aload_1
    //   104: invokevirtual 136	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   107: ifnull +14 -> 121
    //   110: getstatic 20	com/tencent/common/config/provider/QZoneConfigProvider:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   113: aload_1
    //   114: invokevirtual 136	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   117: checkcast 38	abfg
    //   120: areturn
    //   121: aload_0
    //   122: getfield 32	com/tencent/common/config/provider/QZoneConfigProvider:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   125: astore_2
    //   126: aload_2
    //   127: monitorenter
    //   128: ldc 89
    //   130: iconst_1
    //   131: new 91	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   138: ldc 138
    //   140: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_1
    //   144: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   153: new 38	abfg
    //   156: dup
    //   157: aload_0
    //   158: invokevirtual 46	com/tencent/common/config/provider/QZoneConfigProvider:getContext	()Landroid/content/Context;
    //   161: aload_1
    //   162: invokespecial 141	abfg:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   165: astore_3
    //   166: getstatic 20	com/tencent/common/config/provider/QZoneConfigProvider:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   169: aload_1
    //   170: aload_3
    //   171: invokevirtual 145	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   174: pop
    //   175: aload_2
    //   176: monitorexit
    //   177: aload_3
    //   178: areturn
    //   179: astore_3
    //   180: aload_2
    //   181: monitorexit
    //   182: aload_3
    //   183: athrow
    //   184: astore_2
    //   185: ldc 89
    //   187: iconst_1
    //   188: iconst_2
    //   189: anewarray 29	java/lang/Object
    //   192: dup
    //   193: iconst_0
    //   194: ldc 147
    //   196: aastore
    //   197: dup
    //   198: iconst_1
    //   199: new 91	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   206: ldc 149
    //   208: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aload_1
    //   212: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: aastore
    //   219: invokestatic 152	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   222: aconst_null
    //   223: areturn
    //   224: ldc 89
    //   226: iconst_1
    //   227: iconst_2
    //   228: anewarray 29	java/lang/Object
    //   231: dup
    //   232: iconst_0
    //   233: ldc 154
    //   235: aastore
    //   236: dup
    //   237: iconst_1
    //   238: new 91	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   245: ldc 156
    //   247: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: ldc 68
    //   252: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: aastore
    //   259: invokestatic 152	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   262: aconst_null
    //   263: areturn
    //   264: astore_1
    //   265: aload_2
    //   266: astore_1
    //   267: goto -82 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	this	QZoneConfigProvider
    //   99	113	1	str	String
    //   264	1	1	localThrowable1	Throwable
    //   266	1	1	localThrowable2	Throwable
    //   184	82	2	localThrowable3	Throwable
    //   165	13	3	localabfg	abfg
    //   179	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   128	177	179	finally
    //   180	182	179	finally
    //   100	121	184	java/lang/Throwable
    //   121	128	184	java/lang/Throwable
    //   182	184	184	java/lang/Throwable
    //   3	20	264	java/lang/Throwable
    //   20	58	264	java/lang/Throwable
    //   60	100	264	java/lang/Throwable
    //   224	262	264	java/lang/Throwable
  }
  
  private static UriMatcher a()
  {
    UriMatcher localUriMatcher = new UriMatcher(-1);
    localUriMatcher.addURI("com.tencent.common.config.provider.QZoneConfigProvider", "qz_configs", 1);
    localUriMatcher.addURI("com.tencent.common.config.provider.QZoneConfigProvider", "qz_cookie", 2);
    localUriMatcher.addURI("com.tencent.common.config.provider.QZoneConfigProvider", "qz_update", 3);
    localUriMatcher.addURI("com.tencent.common.config.provider.QZoneConfigProvider", "qz_isp_config", 4);
    localUriMatcher.addURI("com.tencent.common.config.provider.QZoneConfigProvider", "qz_delete", 6);
    localUriMatcher.addURI("com.tencent.common.config.provider.QZoneConfigProvider", "qz_check_time", 5);
    localUriMatcher.addURI("com.tencent.common.config.provider.QZoneConfigProvider", "qz_navigator_bar", 8);
    localUriMatcher.addURI("com.tencent.common.config.provider.QZoneConfigProvider", "table_qz_unread", 9);
    return localUriMatcher;
  }
  
  private Cursor a(String[] paramArrayOfString)
  {
    return a().c(paramArrayOfString);
  }
  
  private Cursor a(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return a().b(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
  }
  
  private Uri a(Uri paramUri, ContentValues paramContentValues)
  {
    paramContentValues.put("name", "cookie");
    paramUri = a().d(paramUri, paramContentValues);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return paramUri;
  }
  
  private int b(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    int i = a().a(paramUri, "qz_navigator_bar", paramArrayOfContentValues);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return i;
  }
  
  private Cursor b(String[] paramArrayOfString)
  {
    return a().a(paramArrayOfString);
  }
  
  private Cursor b(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return a().c(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
  }
  
  private Uri b(Uri paramUri, ContentValues paramContentValues)
  {
    paramContentValues.put("name", "check_time");
    paramUri = a().e(paramUri, paramContentValues);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return paramUri;
  }
  
  private Cursor c(String[] paramArrayOfString)
  {
    return a().b(paramArrayOfString);
  }
  
  private Cursor c(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return a().a(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
  }
  
  private Uri c(Uri paramUri, ContentValues paramContentValues)
  {
    paramContentValues.put("name", "updatelog");
    paramUri = a().f(paramUri, paramContentValues);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return paramUri;
  }
  
  private Cursor d(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return a().d(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
  }
  
  private Uri d(Uri paramUri, ContentValues paramContentValues)
  {
    paramUri = a().a(paramUri, paramContentValues);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return paramUri;
  }
  
  private Uri e(Uri paramUri, ContentValues paramContentValues)
  {
    paramUri = a().c(paramUri, paramContentValues);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return paramUri;
  }
  
  private Uri f(Uri paramUri, ContentValues paramContentValues)
  {
    paramUri = a().b(paramUri, paramContentValues);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return paramUri;
  }
  
  private Uri g(Uri paramUri, ContentValues paramContentValues)
  {
    paramUri = a().g(paramUri, paramContentValues);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return paramUri;
  }
  
  public int bulkInsert(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    switch (jdField_a_of_type_AndroidContentUriMatcher.match(paramUri))
    {
    default: 
      QZLog.e("QZoneConfigProvider", 1, new Object[] { "uri:", paramUri, "not used right" });
      return 0;
    case 9: 
      return a(paramUri, paramArrayOfContentValues);
    case 8: 
      return b(paramUri, paramArrayOfContentValues);
    }
    return a().a(paramUri, "qz_configs", paramArrayOfContentValues);
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    switch (jdField_a_of_type_AndroidContentUriMatcher.match(paramUri))
    {
    case 7: 
    default: 
      return 0;
    case 1: 
      return a().a(paramString, paramArrayOfString);
    case 2: 
      return a().a();
    case 3: 
      return a().c();
    case 4: 
      return a().b(paramString, paramArrayOfString);
    case 6: 
      return a().d();
    case 5: 
      return a().b();
    case 8: 
      return a().c(paramString, paramArrayOfString);
    }
    return a(paramUri, paramString, paramArrayOfString);
  }
  
  public String getType(Uri paramUri)
  {
    return "";
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    switch (jdField_a_of_type_AndroidContentUriMatcher.match(paramUri))
    {
    case 6: 
    case 7: 
    default: 
      return null;
    case 1: 
      return d(paramUri, paramContentValues);
    case 2: 
      return a(paramUri, paramContentValues);
    case 3: 
      return c(paramUri, paramContentValues);
    case 4: 
      return e(paramUri, paramContentValues);
    case 5: 
      return b(paramUri, paramContentValues);
    case 8: 
      return f(paramUri, paramContentValues);
    }
    return g(paramUri, paramContentValues);
  }
  
  public boolean onCreate()
  {
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    try
    {
      switch (jdField_a_of_type_AndroidContentUriMatcher.match(paramUri))
      {
      case 1: 
        return a(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
      }
    }
    catch (Throwable paramUri)
    {
      if (!QLog.isColorLevel()) {
        break label139;
      }
      QLog.e("QZoneConfigProvider", 2, "query异常", paramUri);
      return null;
    }
    return b(paramArrayOfString1);
    return a(paramArrayOfString1);
    return b(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
    return c(paramArrayOfString1);
    return c(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
    paramUri = d(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
    return paramUri;
    label139:
    return null;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.config.provider.QZoneConfigProvider
 * JD-Core Version:    0.7.0.1
 */