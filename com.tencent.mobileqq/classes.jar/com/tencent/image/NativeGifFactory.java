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
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_2
    //   5: aconst_null
    //   6: astore 5
    //   8: ldc 94
    //   10: astore 6
    //   12: new 96	java/io/ByteArrayOutputStream
    //   15: dup
    //   16: invokespecial 97	java/io/ByteArrayOutputStream:<init>	()V
    //   19: astore_1
    //   20: aload_1
    //   21: astore_3
    //   22: aload_2
    //   23: astore 4
    //   25: new 99	java/io/FileInputStream
    //   28: dup
    //   29: ldc 101
    //   31: invokespecial 104	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   34: astore_2
    //   35: sipush 4096
    //   38: newarray byte
    //   40: astore_3
    //   41: aload_2
    //   42: aload_3
    //   43: iconst_0
    //   44: sipush 4096
    //   47: invokevirtual 108	java/io/FileInputStream:read	([BII)I
    //   50: istore_0
    //   51: iload_0
    //   52: ifle +73 -> 125
    //   55: aload_1
    //   56: aload_3
    //   57: iconst_0
    //   58: iload_0
    //   59: invokevirtual 112	java/io/ByteArrayOutputStream:write	([BII)V
    //   62: goto -21 -> 41
    //   65: astore_3
    //   66: aload_2
    //   67: astore 5
    //   69: aload_3
    //   70: astore_2
    //   71: aload_1
    //   72: astore_3
    //   73: aload 5
    //   75: astore 4
    //   77: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   80: ifeq +19 -> 99
    //   83: aload_1
    //   84: astore_3
    //   85: aload 5
    //   87: astore 4
    //   89: getstatic 19	com/tencent/image/NativeGifFactory:TAG	Ljava/lang/String;
    //   92: iconst_2
    //   93: ldc 114
    //   95: aload_2
    //   96: invokestatic 118	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   99: aload_1
    //   100: ifnull +7 -> 107
    //   103: aload_1
    //   104: invokevirtual 121	java/io/ByteArrayOutputStream:close	()V
    //   107: aload 6
    //   109: astore_1
    //   110: aload 5
    //   112: ifnull +11 -> 123
    //   115: aload 5
    //   117: invokevirtual 122	java/io/FileInputStream:close	()V
    //   120: aload 6
    //   122: astore_1
    //   123: aload_1
    //   124: areturn
    //   125: aload_1
    //   126: ldc 124
    //   128: invokevirtual 127	java/io/ByteArrayOutputStream:toString	(Ljava/lang/String;)Ljava/lang/String;
    //   131: astore_3
    //   132: aload_1
    //   133: ifnull +7 -> 140
    //   136: aload_1
    //   137: invokevirtual 121	java/io/ByteArrayOutputStream:close	()V
    //   140: aload_3
    //   141: astore_1
    //   142: aload_2
    //   143: ifnull -20 -> 123
    //   146: aload_2
    //   147: invokevirtual 122	java/io/FileInputStream:close	()V
    //   150: aload_3
    //   151: areturn
    //   152: astore_2
    //   153: aload_3
    //   154: astore_1
    //   155: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   158: ifeq -35 -> 123
    //   161: getstatic 19	com/tencent/image/NativeGifFactory:TAG	Ljava/lang/String;
    //   164: iconst_2
    //   165: ldc 114
    //   167: aload_2
    //   168: invokestatic 118	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   171: aload_3
    //   172: areturn
    //   173: astore_2
    //   174: aload 6
    //   176: astore_1
    //   177: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   180: ifeq -57 -> 123
    //   183: getstatic 19	com/tencent/image/NativeGifFactory:TAG	Ljava/lang/String;
    //   186: iconst_2
    //   187: ldc 114
    //   189: aload_2
    //   190: invokestatic 118	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   193: ldc 94
    //   195: areturn
    //   196: astore_1
    //   197: aconst_null
    //   198: astore_1
    //   199: aconst_null
    //   200: astore_2
    //   201: ldc 94
    //   203: astore_3
    //   204: aload_1
    //   205: ifnull +7 -> 212
    //   208: aload_1
    //   209: invokevirtual 121	java/io/ByteArrayOutputStream:close	()V
    //   212: aload_3
    //   213: astore_1
    //   214: aload_2
    //   215: ifnull -92 -> 123
    //   218: aload_2
    //   219: invokevirtual 122	java/io/FileInputStream:close	()V
    //   222: ldc 94
    //   224: areturn
    //   225: astore_2
    //   226: aload_3
    //   227: astore_1
    //   228: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   231: ifeq -108 -> 123
    //   234: getstatic 19	com/tencent/image/NativeGifFactory:TAG	Ljava/lang/String;
    //   237: iconst_2
    //   238: ldc 114
    //   240: aload_2
    //   241: invokestatic 118	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   244: ldc 94
    //   246: areturn
    //   247: astore_2
    //   248: aconst_null
    //   249: astore_1
    //   250: aload_1
    //   251: ifnull +7 -> 258
    //   254: aload_1
    //   255: invokevirtual 121	java/io/ByteArrayOutputStream:close	()V
    //   258: aload 4
    //   260: ifnull +8 -> 268
    //   263: aload 4
    //   265: invokevirtual 122	java/io/FileInputStream:close	()V
    //   268: aload_2
    //   269: athrow
    //   270: astore_1
    //   271: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   274: ifeq -6 -> 268
    //   277: getstatic 19	com/tencent/image/NativeGifFactory:TAG	Ljava/lang/String;
    //   280: iconst_2
    //   281: ldc 114
    //   283: aload_1
    //   284: invokestatic 118	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   287: goto -19 -> 268
    //   290: astore_2
    //   291: aload_3
    //   292: astore_1
    //   293: goto -43 -> 250
    //   296: astore_3
    //   297: aload_2
    //   298: astore 4
    //   300: aload_3
    //   301: astore_2
    //   302: goto -52 -> 250
    //   305: astore_2
    //   306: aconst_null
    //   307: astore_2
    //   308: goto -107 -> 201
    //   311: astore_3
    //   312: goto -111 -> 201
    //   315: astore_2
    //   316: aconst_null
    //   317: astore_1
    //   318: goto -247 -> 71
    //   321: astore_2
    //   322: goto -251 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   50	9	0	i	int
    //   19	158	1	localObject1	Object
    //   196	1	1	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   198	57	1	localObject2	Object
    //   270	14	1	localIOException1	IOException
    //   292	26	1	localObject3	Object
    //   4	143	2	localObject4	Object
    //   152	16	2	localIOException2	IOException
    //   173	17	2	localIOException3	IOException
    //   200	19	2	localObject5	Object
    //   225	16	2	localIOException4	IOException
    //   247	22	2	localObject6	Object
    //   290	8	2	localObject7	Object
    //   301	1	2	localObject8	Object
    //   305	1	2	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   307	1	2	localObject9	Object
    //   315	1	2	localIOException5	IOException
    //   321	1	2	localIOException6	IOException
    //   21	36	3	localObject10	Object
    //   65	5	3	localIOException7	IOException
    //   72	220	3	localObject11	Object
    //   296	5	3	localObject12	Object
    //   311	1	3	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   1	298	4	localObject13	Object
    //   6	110	5	localObject14	Object
    //   10	165	6	str	String
    // Exception table:
    //   from	to	target	type
    //   35	41	65	java/io/IOException
    //   41	51	65	java/io/IOException
    //   55	62	65	java/io/IOException
    //   125	132	65	java/io/IOException
    //   136	140	152	java/io/IOException
    //   146	150	152	java/io/IOException
    //   103	107	173	java/io/IOException
    //   115	120	173	java/io/IOException
    //   12	20	196	java/lang/OutOfMemoryError
    //   208	212	225	java/io/IOException
    //   218	222	225	java/io/IOException
    //   12	20	247	finally
    //   254	258	270	java/io/IOException
    //   263	268	270	java/io/IOException
    //   25	35	290	finally
    //   77	83	290	finally
    //   89	99	290	finally
    //   35	41	296	finally
    //   41	51	296	finally
    //   55	62	296	finally
    //   125	132	296	finally
    //   25	35	305	java/lang/OutOfMemoryError
    //   35	41	311	java/lang/OutOfMemoryError
    //   41	51	311	java/lang/OutOfMemoryError
    //   55	62	311	java/lang/OutOfMemoryError
    //   125	132	311	java/lang/OutOfMemoryError
    //   12	20	315	java/io/IOException
    //   25	35	321	java/io/IOException
  }
  
  public static AbstractGifImage getNativeGifObject(File paramFile, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "getNativeGifObject(File file, boolean cacheFirstFrame)");
    }
    do
    {
      try
      {
        if (isUseNewGif())
        {
          localNativeGifIndex8 = new NativeGifIndex8(paramFile, paramBoolean);
          localObject = localNativeGifIndex8;
        }
      }
      catch (IOException localIOException1)
      {
        paramFile = null;
      }
      try
      {
        if (((NativeGifIndex8)localNativeGifIndex8).mFrameNumber == -1001) {
          localObject = new NativeGifImage(paramFile, paramBoolean);
        }
        return localObject;
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          paramFile = localNativeGifIndex8;
        }
      }
      paramFile = new NativeGifImage(paramFile, paramBoolean);
      return paramFile;
      Object localObject = paramFile;
    } while (!QLog.isColorLevel());
    QLog.e(TAG, 2, "getNativeGifObject exception. msg:" + localIOException1.getMessage());
    return paramFile;
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
    boolean bool3 = false;
    boolean bool1 = false;
    Object localObject = Build.MANUFACTURER;
    String str = Build.MODEL;
    boolean bool2;
    if ((Build.VERSION.SDK_INT == 10) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      bool2 = bool1;
      if (((String)localObject).contains("samsung")) {}
    }
    else if (!TextUtils.isEmpty(str))
    {
      bool2 = bool1;
      if (!str.contains("m1"))
      {
        bool2 = bool1;
        if (!str.contains("meizu_m1"))
        {
          bool2 = bool1;
          if (str.contains("N1")) {}
        }
      }
    }
    else
    {
      bool2 = bool1;
      if (!str.contains("HYF9300"))
      {
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label140;
        }
        bool2 = bool1;
        if (!((String)localObject).contains("alps"))
        {
          bool2 = bool1;
          if (!((String)localObject).contains("Nokia"))
          {
            if (!((String)localObject).toLowerCase().contains("asus")) {
              break label140;
            }
            bool2 = bool1;
          }
        }
      }
    }
    label140:
    do
    {
      do
      {
        do
        {
          return bool2;
          bool2 = bool1;
        } while (isX86);
        bool2 = bool1;
      } while (isYunOS);
      localObject = URLDrawable.mApplicationContext.getSharedPreferences("early_qq.android.native.gif", 4);
      bool1 = bool3;
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