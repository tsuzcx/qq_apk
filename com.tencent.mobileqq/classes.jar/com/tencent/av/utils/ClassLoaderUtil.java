package com.tencent.av.utils;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Method;

public class ClassLoaderUtil
{
  private static volatile DexClassLoader a;
  
  public static DexClassLoader a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = a(BaseApplication.getContext(), "libqav_utils.so");
        }
      }
      finally {}
    }
    return a;
  }
  
  public static DexClassLoader a(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return null;
    }
    paramString = b(paramContext, paramString);
    File localFile = paramContext.getDir("temp", 0);
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramContext = new DexClassLoader(paramString, localFile.getAbsolutePath(), null, paramContext.getClassLoader());
      return paramContext;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClassLoaderUtil", 2, "", paramContext);
      }
    }
    return null;
  }
  
  public static Object a(DexClassLoader paramDexClassLoader, Object paramObject, String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    if ((paramDexClassLoader != null) && (!TextUtils.isEmpty(paramString)) && (paramObject != null)) {
      try
      {
        paramDexClassLoader = paramObject.getClass().getMethod(paramString, paramArrayOfClass);
        paramDexClassLoader.setAccessible(true);
        paramDexClassLoader = paramDexClassLoader.invoke(paramObject, paramArrayOfObject);
        return paramDexClassLoader;
      }
      catch (Exception paramDexClassLoader)
      {
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("invokeMethodInDex, Exception, methodName[");
          paramObject.append(paramString);
          paramObject.append("]");
          QLog.w("ClassLoaderUtil", 1, paramObject.toString(), paramDexClassLoader);
        }
      }
    }
    return null;
  }
  
  public static Object a(DexClassLoader paramDexClassLoader, String paramString)
  {
    if ((paramDexClassLoader != null) && (!TextUtils.isEmpty(paramString))) {
      try
      {
        paramDexClassLoader = paramDexClassLoader.loadClass(paramString).newInstance();
        return paramDexClassLoader;
      }
      catch (Exception paramDexClassLoader)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ClassLoaderUtil", 2, "", paramDexClassLoader);
        }
      }
    }
    return null;
  }
  
  public static boolean a(DexClassLoader paramDexClassLoader, Object paramObject, String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    if ((paramDexClassLoader != null) && (!TextUtils.isEmpty(paramString)) && (paramObject != null))
    {
      paramDexClassLoader = paramObject.getClass().getMethod(paramString, paramArrayOfClass);
      paramDexClassLoader.setAccessible(true);
      paramArrayOfObject2[0] = paramDexClassLoader.invoke(paramObject, paramArrayOfObject1);
      return true;
    }
    return false;
  }
  
  /* Error */
  public static String b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: new 98	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   13: astore_3
    //   14: aload_3
    //   15: aload_0
    //   16: invokevirtual 129	android/content/Context:getFilesDir	()Ljava/io/File;
    //   19: invokevirtual 132	java/io/File:getParent	()Ljava/lang/String;
    //   22: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload_3
    //   27: ldc 134
    //   29: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload_3
    //   34: aload_1
    //   35: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload_3
    //   40: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: astore_3
    //   44: aload_0
    //   45: invokevirtual 129	android/content/Context:getFilesDir	()Ljava/io/File;
    //   48: invokevirtual 54	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   51: astore_0
    //   52: new 98	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   59: astore 6
    //   61: aload 6
    //   63: aload_0
    //   64: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload 6
    //   70: getstatic 138	java/io/File:separator	Ljava/lang/String;
    //   73: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload 6
    //   79: aload_1
    //   80: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload 6
    //   86: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: astore_1
    //   90: new 50	java/io/File
    //   93: dup
    //   94: aload_1
    //   95: invokespecial 141	java/io/File:<init>	(Ljava/lang/String;)V
    //   98: astore_0
    //   99: aload_0
    //   100: invokevirtual 144	java/io/File:exists	()Z
    //   103: ifeq +8 -> 111
    //   106: aload_0
    //   107: invokevirtual 147	java/io/File:delete	()Z
    //   110: pop
    //   111: new 149	java/io/BufferedInputStream
    //   114: dup
    //   115: new 151	java/io/FileInputStream
    //   118: dup
    //   119: new 50	java/io/File
    //   122: dup
    //   123: aload_3
    //   124: invokespecial 141	java/io/File:<init>	(Ljava/lang/String;)V
    //   127: invokespecial 154	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   130: invokespecial 157	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   133: astore_3
    //   134: aload_0
    //   135: invokevirtual 160	java/io/File:createNewFile	()Z
    //   138: pop
    //   139: new 162	java/io/BufferedOutputStream
    //   142: dup
    //   143: new 164	java/io/FileOutputStream
    //   146: dup
    //   147: aload_0
    //   148: invokespecial 165	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   151: invokespecial 168	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   154: astore_0
    //   155: sipush 1024
    //   158: newarray byte
    //   160: astore 4
    //   162: aload_3
    //   163: aload 4
    //   165: iconst_0
    //   166: aload 4
    //   168: arraylength
    //   169: invokevirtual 172	java/io/BufferedInputStream:read	([BII)I
    //   172: istore_2
    //   173: iload_2
    //   174: iconst_m1
    //   175: if_icmpeq +14 -> 189
    //   178: aload_0
    //   179: aload 4
    //   181: iconst_0
    //   182: iload_2
    //   183: invokevirtual 176	java/io/BufferedOutputStream:write	([BII)V
    //   186: goto -24 -> 162
    //   189: aload_3
    //   190: invokevirtual 179	java/io/BufferedInputStream:close	()V
    //   193: goto +19 -> 212
    //   196: astore_3
    //   197: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   200: ifeq +12 -> 212
    //   203: ldc 69
    //   205: iconst_2
    //   206: ldc 71
    //   208: aload_3
    //   209: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   212: aload_0
    //   213: invokevirtual 180	java/io/BufferedOutputStream:close	()V
    //   216: aload_1
    //   217: areturn
    //   218: astore_0
    //   219: aload_1
    //   220: astore_3
    //   221: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   224: ifeq +143 -> 367
    //   227: ldc 69
    //   229: iconst_2
    //   230: ldc 71
    //   232: aload_0
    //   233: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   236: aload_1
    //   237: areturn
    //   238: astore 4
    //   240: aload_0
    //   241: astore_1
    //   242: aload 4
    //   244: astore_0
    //   245: goto +11 -> 256
    //   248: astore 4
    //   250: goto +16 -> 266
    //   253: astore_0
    //   254: aconst_null
    //   255: astore_1
    //   256: aload_0
    //   257: astore 4
    //   259: goto +114 -> 373
    //   262: astore 4
    //   264: aconst_null
    //   265: astore_0
    //   266: goto +34 -> 300
    //   269: astore 4
    //   271: aconst_null
    //   272: astore_0
    //   273: aload 5
    //   275: astore_3
    //   276: goto +24 -> 300
    //   279: astore_0
    //   280: aconst_null
    //   281: astore_1
    //   282: aload 4
    //   284: astore_3
    //   285: aload_0
    //   286: astore 4
    //   288: goto +85 -> 373
    //   291: astore 4
    //   293: aconst_null
    //   294: astore_1
    //   295: aload_1
    //   296: astore_0
    //   297: aload 5
    //   299: astore_3
    //   300: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   303: ifeq +13 -> 316
    //   306: ldc 69
    //   308: iconst_2
    //   309: ldc 71
    //   311: aload 4
    //   313: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   316: aload_3
    //   317: ifnull +26 -> 343
    //   320: aload_3
    //   321: invokevirtual 179	java/io/BufferedInputStream:close	()V
    //   324: goto +19 -> 343
    //   327: astore_3
    //   328: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   331: ifeq +12 -> 343
    //   334: ldc 69
    //   336: iconst_2
    //   337: ldc 71
    //   339: aload_3
    //   340: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   343: aload_1
    //   344: astore_3
    //   345: aload_0
    //   346: ifnull +21 -> 367
    //   349: aload_0
    //   350: invokevirtual 180	java/io/BufferedOutputStream:close	()V
    //   353: aload_1
    //   354: areturn
    //   355: astore_0
    //   356: aload_1
    //   357: astore_3
    //   358: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   361: ifeq +6 -> 367
    //   364: goto -137 -> 227
    //   367: aload_3
    //   368: areturn
    //   369: astore 4
    //   371: aload_0
    //   372: astore_1
    //   373: aload_3
    //   374: ifnull +26 -> 400
    //   377: aload_3
    //   378: invokevirtual 179	java/io/BufferedInputStream:close	()V
    //   381: goto +19 -> 400
    //   384: astore_0
    //   385: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   388: ifeq +12 -> 400
    //   391: ldc 69
    //   393: iconst_2
    //   394: ldc 71
    //   396: aload_0
    //   397: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   400: aload_1
    //   401: ifnull +26 -> 427
    //   404: aload_1
    //   405: invokevirtual 180	java/io/BufferedOutputStream:close	()V
    //   408: goto +19 -> 427
    //   411: astore_0
    //   412: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   415: ifeq +12 -> 427
    //   418: ldc 69
    //   420: iconst_2
    //   421: ldc 71
    //   423: aload_0
    //   424: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   427: goto +6 -> 433
    //   430: aload 4
    //   432: athrow
    //   433: goto -3 -> 430
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	436	0	paramContext	Context
    //   0	436	1	paramString	String
    //   172	11	2	i	int
    //   13	177	3	localObject1	Object
    //   196	13	3	localIOException1	java.io.IOException
    //   220	101	3	localObject2	Object
    //   327	13	3	localIOException2	java.io.IOException
    //   344	34	3	str	String
    //   1	179	4	arrayOfByte	byte[]
    //   238	5	4	localObject3	Object
    //   248	1	4	localException1	Exception
    //   257	1	4	localContext1	Context
    //   262	1	4	localException2	Exception
    //   269	14	4	localException3	Exception
    //   286	1	4	localContext2	Context
    //   291	21	4	localException4	Exception
    //   369	62	4	localObject4	Object
    //   4	294	5	localObject5	Object
    //   59	26	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   189	193	196	java/io/IOException
    //   212	216	218	java/io/IOException
    //   155	162	238	finally
    //   162	173	238	finally
    //   178	186	238	finally
    //   155	162	248	java/lang/Exception
    //   162	173	248	java/lang/Exception
    //   178	186	248	java/lang/Exception
    //   134	155	253	finally
    //   134	155	262	java/lang/Exception
    //   90	111	269	java/lang/Exception
    //   111	134	269	java/lang/Exception
    //   6	90	279	finally
    //   90	111	279	finally
    //   111	134	279	finally
    //   6	90	291	java/lang/Exception
    //   320	324	327	java/io/IOException
    //   349	353	355	java/io/IOException
    //   300	316	369	finally
    //   377	381	384	java/io/IOException
    //   404	408	411	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.ClassLoaderUtil
 * JD-Core Version:    0.7.0.1
 */