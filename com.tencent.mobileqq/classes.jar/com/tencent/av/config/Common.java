package com.tencent.av.config;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

public class Common
{
  static String a;
  public static final ConcurrentHashMap<String, byte[]> a;
  public static final String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Common";
    b = "SharpConfigPayload_" + Build.MODEL;
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public static String a(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return "6.0.0";
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
        if ((paramContext != null) && (!TextUtils.isEmpty(paramContext.versionName.trim())))
        {
          paramContext = paramContext.versionName.trim();
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return "6.0.0";
  }
  
  public static void a(Context paramContext, String paramString, byte[] paramArrayOfByte)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    StringBuilder localStringBuilder = null;
    String str = null;
    Object localObject2 = str;
    Object localObject1 = localStringBuilder;
    for (;;)
    {
      try
      {
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramArrayOfByte);
        localObject2 = str;
        localObject1 = localStringBuilder;
        paramContext = paramContext.openFileOutput(paramString, 0);
        localObject2 = paramContext;
        localObject1 = paramContext;
        paramContext.write(paramArrayOfByte);
      }
      catch (Exception paramContext)
      {
        localObject1 = localObject2;
        str = jdField_a_of_type_JavaLangString;
        localObject1 = localObject2;
        localStringBuilder = new StringBuilder().append("writeFile, Exception, fileName[").append(paramString).append("], bytes[");
        if (paramArrayOfByte == null) {
          continue;
        }
        bool1 = true;
        localObject1 = localObject2;
        QLog.w(str, 1, bool1 + "]", paramContext);
        if (localObject2 == null) {
          continue;
        }
        try
        {
          ((FileOutputStream)localObject2).close();
          return;
        }
        catch (IOException paramContext) {}
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        localObject1 = jdField_a_of_type_JavaLangString;
        paramString = new StringBuilder().append("writeFile, IOException, fileName[").append(paramString).append("], bytes[");
        bool1 = bool2;
        if (paramArrayOfByte == null) {
          continue;
        }
        bool1 = true;
        QLog.w((String)localObject1, 1, bool1 + "]", paramContext);
        return;
        bool1 = false;
        continue;
      }
      finally
      {
        if (localObject1 == null) {
          break label286;
        }
      }
      try
      {
        paramContext.close();
        return;
      }
      catch (IOException paramContext)
      {
        if (QLog.isDevelopLevel())
        {
          localObject1 = jdField_a_of_type_JavaLangString;
          paramString = new StringBuilder().append("writeFile, IOException, fileName[").append(paramString).append("], bytes[");
          if (paramArrayOfByte != null) {
            bool1 = true;
          }
          QLog.w((String)localObject1, 1, bool1 + "]", paramContext);
          return;
        }
      }
    }
    try
    {
      ((FileOutputStream)localObject1).close();
      label286:
      throw paramContext;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel())
        {
          localObject2 = jdField_a_of_type_JavaLangString;
          paramString = new StringBuilder().append("writeFile, IOException, fileName[").append(paramString).append("], bytes[");
          bool1 = bool3;
          if (paramArrayOfByte != null) {
            bool1 = true;
          }
          QLog.w((String)localObject2, 1, bool1 + "]", localIOException);
        }
      }
    }
  }
  
  /* Error */
  public static byte[] a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: getstatic 42	com/tencent/av/config/Common:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   3: aload_1
    //   4: invokevirtual 129	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   7: checkcast 131	[B
    //   10: astore 4
    //   12: aload 4
    //   14: astore_3
    //   15: aload 4
    //   17: ifnonnull +49 -> 66
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 135	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   25: astore 5
    //   27: aload 5
    //   29: astore_0
    //   30: aload 4
    //   32: astore_3
    //   33: aload 5
    //   35: invokevirtual 141	java/io/FileInputStream:available	()I
    //   38: istore_2
    //   39: iload_2
    //   40: ifgt +70 -> 110
    //   43: aload 5
    //   45: astore_0
    //   46: aload 4
    //   48: astore_3
    //   49: aload 5
    //   51: invokevirtual 142	java/io/FileInputStream:close	()V
    //   54: aload 5
    //   56: ifnull +8 -> 64
    //   59: aload 5
    //   61: invokevirtual 142	java/io/FileInputStream:close	()V
    //   64: aconst_null
    //   65: astore_3
    //   66: aload_3
    //   67: areturn
    //   68: astore_0
    //   69: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   72: ifeq -8 -> 64
    //   75: getstatic 15	com/tencent/av/config/Common:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   78: iconst_1
    //   79: new 17	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   86: ldc 144
    //   88: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_1
    //   92: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: ldc 118
    //   97: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: aload_0
    //   104: invokestatic 122	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   107: goto -43 -> 64
    //   110: aload 5
    //   112: astore_0
    //   113: aload 4
    //   115: astore_3
    //   116: iload_2
    //   117: newarray byte
    //   119: astore 4
    //   121: aload 5
    //   123: astore_0
    //   124: aload 4
    //   126: astore_3
    //   127: aload 5
    //   129: aload 4
    //   131: invokevirtual 148	java/io/FileInputStream:read	([B)I
    //   134: pop
    //   135: aload 5
    //   137: astore_0
    //   138: aload 4
    //   140: astore_3
    //   141: getstatic 42	com/tencent/av/config/Common:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   144: aload_1
    //   145: aload 4
    //   147: invokevirtual 90	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   150: pop
    //   151: aload 4
    //   153: astore_3
    //   154: aload 5
    //   156: ifnull -90 -> 66
    //   159: aload 5
    //   161: invokevirtual 142	java/io/FileInputStream:close	()V
    //   164: aload 4
    //   166: areturn
    //   167: astore_0
    //   168: aload 4
    //   170: astore_3
    //   171: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   174: ifeq -108 -> 66
    //   177: getstatic 15	com/tencent/av/config/Common:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   180: iconst_1
    //   181: new 17	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   188: ldc 144
    //   190: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: aload_1
    //   194: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: ldc 118
    //   199: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: aload_0
    //   206: invokestatic 122	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   209: aload 4
    //   211: areturn
    //   212: astore_3
    //   213: aconst_null
    //   214: astore 5
    //   216: aload 5
    //   218: astore_0
    //   219: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   222: ifeq +38 -> 260
    //   225: aload 5
    //   227: astore_0
    //   228: getstatic 15	com/tencent/av/config/Common:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   231: iconst_1
    //   232: new 17	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   239: ldc 153
    //   241: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: aload_1
    //   245: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: ldc 118
    //   250: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: aload_3
    //   257: invokestatic 122	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   260: aload 4
    //   262: astore_3
    //   263: aload 5
    //   265: ifnull -199 -> 66
    //   268: aload 5
    //   270: invokevirtual 142	java/io/FileInputStream:close	()V
    //   273: aload 4
    //   275: areturn
    //   276: astore_0
    //   277: aload 4
    //   279: astore_3
    //   280: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   283: ifeq -217 -> 66
    //   286: getstatic 15	com/tencent/av/config/Common:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   289: iconst_1
    //   290: new 17	java/lang/StringBuilder
    //   293: dup
    //   294: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   297: ldc 144
    //   299: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: aload_1
    //   303: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: ldc 118
    //   308: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   314: aload_0
    //   315: invokestatic 122	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   318: aload 4
    //   320: areturn
    //   321: astore_3
    //   322: aconst_null
    //   323: astore_0
    //   324: aload_0
    //   325: ifnull +7 -> 332
    //   328: aload_0
    //   329: invokevirtual 142	java/io/FileInputStream:close	()V
    //   332: aload_3
    //   333: athrow
    //   334: astore_0
    //   335: invokestatic 109	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   338: ifeq -6 -> 332
    //   341: getstatic 15	com/tencent/av/config/Common:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   344: iconst_1
    //   345: new 17	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   352: ldc 144
    //   354: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: aload_1
    //   358: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: ldc 118
    //   363: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: aload_0
    //   370: invokestatic 122	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   373: goto -41 -> 332
    //   376: astore_3
    //   377: goto -53 -> 324
    //   380: astore_0
    //   381: aload_3
    //   382: astore 4
    //   384: aload_0
    //   385: astore_3
    //   386: goto -170 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	389	0	paramContext	Context
    //   0	389	1	paramString	String
    //   38	79	2	i	int
    //   14	157	3	localObject1	Object
    //   212	45	3	localException	Exception
    //   262	18	3	localObject2	Object
    //   321	12	3	localObject3	Object
    //   376	6	3	localObject4	Object
    //   385	1	3	localContext	Context
    //   10	373	4	localObject5	Object
    //   25	244	5	localFileInputStream	java.io.FileInputStream
    // Exception table:
    //   from	to	target	type
    //   59	64	68	java/io/IOException
    //   159	164	167	java/io/IOException
    //   20	27	212	java/lang/Exception
    //   268	273	276	java/io/IOException
    //   20	27	321	finally
    //   328	332	334	java/io/IOException
    //   33	39	376	finally
    //   49	54	376	finally
    //   116	121	376	finally
    //   127	135	376	finally
    //   141	151	376	finally
    //   219	225	376	finally
    //   228	260	376	finally
    //   33	39	380	java/lang/Exception
    //   49	54	380	java/lang/Exception
    //   116	121	380	java/lang/Exception
    //   127	135	380	java/lang/Exception
    //   141	151	380	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.config.Common
 * JD-Core Version:    0.7.0.1
 */