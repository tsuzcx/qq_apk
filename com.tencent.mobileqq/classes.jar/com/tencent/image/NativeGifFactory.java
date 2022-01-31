package com.tencent.image;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class NativeGifFactory
{
  static final String TAG = NativeGifFactory.class.getSimpleName();
  static boolean isX86 = false;
  static boolean isYunOS = false;
  
  static
  {
    String str = getKernelVersion();
    if ((TextUtils.isEmpty(str)) || (str.contains("x86")) || (str.contains("X86"))) {
      isX86 = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "isX86:" + isX86);
    }
    str = getSystemProperties(URLDrawable.mApplicationContext, "ro.yunos.version");
    if ((!TextUtils.isEmpty(str)) && (str.length() > 1)) {
      isYunOS = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "isYunOS:" + isYunOS);
    }
  }
  
  /* Error */
  public static String getKernelVersion()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 6
    //   8: aconst_null
    //   9: astore 4
    //   11: aconst_null
    //   12: astore 7
    //   14: aconst_null
    //   15: astore_2
    //   16: aconst_null
    //   17: astore 8
    //   19: new 94	java/io/ByteArrayOutputStream
    //   22: dup
    //   23: invokespecial 95	java/io/ByteArrayOutputStream:<init>	()V
    //   26: astore_1
    //   27: new 97	java/io/FileInputStream
    //   30: dup
    //   31: ldc 99
    //   33: invokespecial 102	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   36: astore_2
    //   37: sipush 4096
    //   40: newarray byte
    //   42: astore_3
    //   43: aload_2
    //   44: aload_3
    //   45: iconst_0
    //   46: sipush 4096
    //   49: invokevirtual 106	java/io/FileInputStream:read	([BII)I
    //   52: istore_0
    //   53: iload_0
    //   54: ifle +66 -> 120
    //   57: aload_1
    //   58: aload_3
    //   59: iconst_0
    //   60: iload_0
    //   61: invokevirtual 110	java/io/ByteArrayOutputStream:write	([BII)V
    //   64: goto -21 -> 43
    //   67: astore 5
    //   69: aload_2
    //   70: astore 4
    //   72: aload_1
    //   73: astore_2
    //   74: aload 4
    //   76: astore_3
    //   77: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   80: ifeq +19 -> 99
    //   83: aload_1
    //   84: astore_2
    //   85: aload 4
    //   87: astore_3
    //   88: getstatic 19	com/tencent/image/NativeGifFactory:TAG	Ljava/lang/String;
    //   91: iconst_2
    //   92: ldc 112
    //   94: aload 5
    //   96: invokestatic 116	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   99: aload_1
    //   100: ifnull +7 -> 107
    //   103: aload_1
    //   104: invokevirtual 119	java/io/ByteArrayOutputStream:close	()V
    //   107: aload 4
    //   109: ifnull +8 -> 117
    //   112: aload 4
    //   114: invokevirtual 120	java/io/FileInputStream:close	()V
    //   117: ldc 122
    //   119: areturn
    //   120: aload_1
    //   121: ldc 124
    //   123: invokevirtual 127	java/io/ByteArrayOutputStream:toString	(Ljava/lang/String;)Ljava/lang/String;
    //   126: astore_3
    //   127: aload_1
    //   128: ifnull +7 -> 135
    //   131: aload_1
    //   132: invokevirtual 119	java/io/ByteArrayOutputStream:close	()V
    //   135: aload_2
    //   136: ifnull +7 -> 143
    //   139: aload_2
    //   140: invokevirtual 120	java/io/FileInputStream:close	()V
    //   143: aload_3
    //   144: areturn
    //   145: astore_1
    //   146: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   149: ifeq +13 -> 162
    //   152: getstatic 19	com/tencent/image/NativeGifFactory:TAG	Ljava/lang/String;
    //   155: iconst_2
    //   156: ldc 112
    //   158: aload_1
    //   159: invokestatic 116	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   162: aload_3
    //   163: areturn
    //   164: astore_1
    //   165: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   168: ifeq -51 -> 117
    //   171: getstatic 19	com/tencent/image/NativeGifFactory:TAG	Ljava/lang/String;
    //   174: iconst_2
    //   175: ldc 112
    //   177: aload_1
    //   178: invokestatic 116	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   181: ldc 122
    //   183: areturn
    //   184: astore_1
    //   185: aload 5
    //   187: astore_2
    //   188: aload 7
    //   190: astore_1
    //   191: aload_1
    //   192: ifnull +7 -> 199
    //   195: aload_1
    //   196: invokevirtual 119	java/io/ByteArrayOutputStream:close	()V
    //   199: aload_2
    //   200: ifnull -83 -> 117
    //   203: aload_2
    //   204: invokevirtual 120	java/io/FileInputStream:close	()V
    //   207: ldc 122
    //   209: areturn
    //   210: astore_1
    //   211: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   214: ifeq -97 -> 117
    //   217: getstatic 19	com/tencent/image/NativeGifFactory:TAG	Ljava/lang/String;
    //   220: iconst_2
    //   221: ldc 112
    //   223: aload_1
    //   224: invokestatic 116	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   227: ldc 122
    //   229: areturn
    //   230: astore_1
    //   231: aload_2
    //   232: ifnull +7 -> 239
    //   235: aload_2
    //   236: invokevirtual 119	java/io/ByteArrayOutputStream:close	()V
    //   239: aload_3
    //   240: ifnull +7 -> 247
    //   243: aload_3
    //   244: invokevirtual 120	java/io/FileInputStream:close	()V
    //   247: aload_1
    //   248: athrow
    //   249: astore_2
    //   250: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   253: ifeq -6 -> 247
    //   256: getstatic 19	com/tencent/image/NativeGifFactory:TAG	Ljava/lang/String;
    //   259: iconst_2
    //   260: ldc 112
    //   262: aload_2
    //   263: invokestatic 116	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   266: goto -19 -> 247
    //   269: astore 4
    //   271: aload_1
    //   272: astore_2
    //   273: aload 6
    //   275: astore_3
    //   276: aload 4
    //   278: astore_1
    //   279: goto -48 -> 231
    //   282: astore 4
    //   284: aload_2
    //   285: astore_3
    //   286: aload_1
    //   287: astore_2
    //   288: aload 4
    //   290: astore_1
    //   291: goto -60 -> 231
    //   294: astore_2
    //   295: aload 5
    //   297: astore_2
    //   298: goto -107 -> 191
    //   301: astore_3
    //   302: goto -111 -> 191
    //   305: astore 5
    //   307: aload 8
    //   309: astore_1
    //   310: goto -238 -> 72
    //   313: astore 5
    //   315: goto -243 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   52	9	0	i	int
    //   26	106	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   145	14	1	localIOException1	IOException
    //   164	14	1	localIOException2	IOException
    //   184	1	1	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   190	6	1	localObject1	Object
    //   210	14	1	localIOException3	IOException
    //   230	42	1	localObject2	Object
    //   278	32	1	localObject3	Object
    //   15	221	2	localObject4	Object
    //   249	14	2	localIOException4	IOException
    //   272	16	2	localObject5	Object
    //   294	1	2	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   297	1	2	localIOException5	IOException
    //   4	282	3	localObject6	Object
    //   301	1	3	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   9	104	4	localObject7	Object
    //   269	8	4	localObject8	Object
    //   282	7	4	localObject9	Object
    //   1	1	5	localObject10	Object
    //   67	229	5	localIOException6	IOException
    //   305	1	5	localIOException7	IOException
    //   313	1	5	localIOException8	IOException
    //   6	268	6	localObject11	Object
    //   12	177	7	localObject12	Object
    //   17	291	8	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   37	43	67	java/io/IOException
    //   43	53	67	java/io/IOException
    //   57	64	67	java/io/IOException
    //   120	127	67	java/io/IOException
    //   131	135	145	java/io/IOException
    //   139	143	145	java/io/IOException
    //   103	107	164	java/io/IOException
    //   112	117	164	java/io/IOException
    //   19	27	184	java/lang/OutOfMemoryError
    //   195	199	210	java/io/IOException
    //   203	207	210	java/io/IOException
    //   19	27	230	finally
    //   77	83	230	finally
    //   88	99	230	finally
    //   235	239	249	java/io/IOException
    //   243	247	249	java/io/IOException
    //   27	37	269	finally
    //   37	43	282	finally
    //   43	53	282	finally
    //   57	64	282	finally
    //   120	127	282	finally
    //   27	37	294	java/lang/OutOfMemoryError
    //   37	43	301	java/lang/OutOfMemoryError
    //   43	53	301	java/lang/OutOfMemoryError
    //   57	64	301	java/lang/OutOfMemoryError
    //   120	127	301	java/lang/OutOfMemoryError
    //   19	27	305	java/io/IOException
    //   27	37	313	java/io/IOException
  }
  
  public static AbstractGifImage getNativeGifObject(File paramFile, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "getNativeGifObject(File file, boolean cacheFirstFrame)");
    }
    Object localObject1 = null;
    label77:
    File localFile;
    try
    {
      if (isUseNewGif()) {
        localObject2 = new NativeGifIndex8(paramFile, paramBoolean);
      }
    }
    catch (IOException localIOException2)
    {
      do
      {
        Object localObject2;
        paramFile = localObject1;
        localObject1 = localIOException2;
        localFile = paramFile;
      } while (!QLog.isColorLevel());
      QLog.e(TAG, 2, "getNativeGifObject exception. msg:" + localObject1.getMessage());
      return paramFile;
    }
    try
    {
      if (((NativeGifIndex8)localObject2).mFrameNumber != -1001) {
        return localObject2;
      }
      paramFile = new NativeGifImage(paramFile, paramBoolean);
      localObject2 = paramFile;
      return localObject2;
    }
    catch (IOException localIOException1)
    {
      paramFile = localFile;
      break label77;
    }
    paramFile = new NativeGifImage(paramFile, paramBoolean);
    return paramFile;
    return localFile;
  }
  
  public static AbstractGifImage getNativeGifObject(File paramFile, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "getNativeGifObject(File file, boolean cacheFirstFrame, boolean isEmosmFile, int maxWidth, int maxHeight, float roundCorner)");
    }
    if (paramFloat == 0.0F) {}
    do
    {
      try
      {
        if (isUseNewGif())
        {
          localNativeGifIndex8 = new NativeGifIndex8(paramFile, paramBoolean1, paramBoolean2, paramInt1, paramInt2, paramFloat);
          localObject1 = localNativeGifIndex8;
        }
      }
      catch (IOException localIOException2)
      {
        NativeGifIndex8 localNativeGifIndex8;
        paramFile = null;
      }
      try
      {
        if (((NativeGifIndex8)localNativeGifIndex8).mFrameNumber == -1001) {
          localObject1 = new NativeGifImage(paramFile, paramBoolean1, paramBoolean2, paramInt1, paramInt2, paramFloat);
        }
        return localObject1;
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          paramFile = localIOException2;
          Object localObject2 = localIOException1;
        }
      }
      paramFile = new NativeGifImage(paramFile, paramBoolean1, paramBoolean2, paramInt1, paramInt2, paramFloat);
      return paramFile;
      Object localObject1 = paramFile;
    } while (!QLog.isColorLevel());
    QLog.e(TAG, 2, "getNativeGifObject exception. msg:" + localIOException2.getMessage());
    return paramFile;
  }
  
  public static String getSystemProperties(Context paramContext, String paramString)
    throws IllegalArgumentException
  {
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("android.os.SystemProperties");
      paramContext = (String)paramContext.getMethod("get", new Class[] { String.class }).invoke(paramContext, new Object[] { new String(paramString) });
      return paramContext;
    }
    catch (IllegalArgumentException paramContext)
    {
      return "";
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  public static boolean isUseNewGif()
  {
    Object localObject = Build.MANUFACTURER;
    String str = Build.MODEL;
    boolean bool2;
    if (((Build.VERSION.SDK_INT == 10) && (!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).contains("samsung"))) || ((!TextUtils.isEmpty(str)) && ((str.contains("m1")) || (str.contains("meizu_m1")) || (str.contains("N1")))) || (str.contains("HYF9300")) || ((!TextUtils.isEmpty((CharSequence)localObject)) && ((((String)localObject).contains("alps")) || (((String)localObject).contains("Nokia")) || (((String)localObject).toLowerCase().contains("asus"))))) {
      bool2 = false;
    }
    boolean bool1;
    do
    {
      return bool2;
      if ((isX86) || (isYunOS)) {
        return false;
      }
      localObject = URLDrawable.mApplicationContext.getSharedPreferences("early_qq.android.native.gif", 4);
      bool1 = false;
      if (localObject != null) {
        bool1 = ((SharedPreferences)localObject).getBoolean("use_new_gif_so", false);
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d(TAG, 2, "use_new_gif_so:" + bool1);
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.NativeGifFactory
 * JD-Core Version:    0.7.0.1
 */