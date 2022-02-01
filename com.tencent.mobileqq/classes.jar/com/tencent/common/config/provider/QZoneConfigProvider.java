package com.tencent.common.config.provider;

import aavf;
import aavg;
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
  implements aavg
{
  private static final UriMatcher a;
  public static ConcurrentHashMap<String, aavf> a;
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
  private aavf a()
  {
    // Byte code:
    //   0: ldc 68
    //   2: astore_2
    //   3: ldc 70
    //   5: getstatic 76	com/tencent/common/app/BaseApplicationImpl:sInjectResult	Ljava/lang/String;
    //   8: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11: ifne +43 -> 54
    //   14: ldc 84
    //   16: iconst_1
    //   17: new 86	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   24: ldc 89
    //   26: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: getstatic 76	com/tencent/common/app/BaseApplicationImpl:sInjectResult	Ljava/lang/String;
    //   32: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc 95
    //   37: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokestatic 100	aoae:a	()Z
    //   43: invokevirtual 103	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   46: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: aconst_null
    //   53: areturn
    //   54: invokestatic 117	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   57: ifnull +161 -> 218
    //   60: invokestatic 117	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   63: invokevirtual 121	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   66: ifnull +152 -> 218
    //   69: invokestatic 117	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   72: invokevirtual 121	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   75: invokevirtual 126	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   78: invokestatic 132	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   81: ifne +137 -> 218
    //   84: invokestatic 117	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   87: invokevirtual 121	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   90: invokevirtual 126	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   93: astore_1
    //   94: getstatic 20	com/tencent/common/config/provider/QZoneConfigProvider:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   97: aload_1
    //   98: invokevirtual 136	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   101: ifnull +14 -> 115
    //   104: getstatic 20	com/tencent/common/config/provider/QZoneConfigProvider:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   107: aload_1
    //   108: invokevirtual 136	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   111: checkcast 38	aavf
    //   114: areturn
    //   115: aload_0
    //   116: getfield 32	com/tencent/common/config/provider/QZoneConfigProvider:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   119: astore_2
    //   120: aload_2
    //   121: monitorenter
    //   122: ldc 84
    //   124: iconst_1
    //   125: new 86	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   132: ldc 138
    //   134: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_1
    //   138: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   147: new 38	aavf
    //   150: dup
    //   151: aload_0
    //   152: invokevirtual 46	com/tencent/common/config/provider/QZoneConfigProvider:getContext	()Landroid/content/Context;
    //   155: aload_1
    //   156: invokespecial 141	aavf:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   159: astore_3
    //   160: getstatic 20	com/tencent/common/config/provider/QZoneConfigProvider:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   163: aload_1
    //   164: aload_3
    //   165: invokevirtual 145	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   168: pop
    //   169: aload_2
    //   170: monitorexit
    //   171: aload_3
    //   172: areturn
    //   173: astore_3
    //   174: aload_2
    //   175: monitorexit
    //   176: aload_3
    //   177: athrow
    //   178: astore_2
    //   179: ldc 84
    //   181: iconst_1
    //   182: iconst_2
    //   183: anewarray 29	java/lang/Object
    //   186: dup
    //   187: iconst_0
    //   188: ldc 147
    //   190: aastore
    //   191: dup
    //   192: iconst_1
    //   193: new 86	java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   200: ldc 149
    //   202: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload_1
    //   206: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: aastore
    //   213: invokestatic 152	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   216: aconst_null
    //   217: areturn
    //   218: ldc 84
    //   220: iconst_1
    //   221: iconst_2
    //   222: anewarray 29	java/lang/Object
    //   225: dup
    //   226: iconst_0
    //   227: ldc 154
    //   229: aastore
    //   230: dup
    //   231: iconst_1
    //   232: new 86	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   239: ldc 156
    //   241: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: ldc 68
    //   246: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: aastore
    //   253: invokestatic 152	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   256: aconst_null
    //   257: areturn
    //   258: astore_1
    //   259: aload_2
    //   260: astore_1
    //   261: goto -82 -> 179
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	this	QZoneConfigProvider
    //   93	113	1	str	String
    //   258	1	1	localThrowable1	Throwable
    //   260	1	1	localThrowable2	Throwable
    //   178	82	2	localThrowable3	Throwable
    //   159	13	3	localaavf	aavf
    //   173	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   122	171	173	finally
    //   174	176	173	finally
    //   94	115	178	java/lang/Throwable
    //   115	122	178	java/lang/Throwable
    //   176	178	178	java/lang/Throwable
    //   3	52	258	java/lang/Throwable
    //   54	94	258	java/lang/Throwable
    //   218	256	258	java/lang/Throwable
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