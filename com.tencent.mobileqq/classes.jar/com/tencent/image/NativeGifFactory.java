package com.tencent.image;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.image.api.ILog;
import com.tencent.image.api.URLDrawableDepWrap;
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
    if (URLDrawable.depImp.mLog.isColorLevel()) {
      URLDrawable.depImp.mLog.d(TAG, 2, "isX86:" + isX86);
    }
    str = getSystemProperties(URLDrawable.mApplicationContext, "ro.yunos.version");
    if ((!TextUtils.isEmpty(str)) && (str.length() > 1)) {
      isYunOS = true;
    }
    if (URLDrawable.depImp.mLog.isColorLevel()) {
      URLDrawable.depImp.mLog.d(TAG, 2, "isYunOS:" + isYunOS);
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
    //   8: ldc 104
    //   10: astore 6
    //   12: new 106	java/io/ByteArrayOutputStream
    //   15: dup
    //   16: invokespecial 107	java/io/ByteArrayOutputStream:<init>	()V
    //   19: astore_1
    //   20: aload_1
    //   21: astore_3
    //   22: aload_2
    //   23: astore 4
    //   25: new 109	java/io/FileInputStream
    //   28: dup
    //   29: ldc 111
    //   31: invokespecial 114	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   34: astore_2
    //   35: sipush 4096
    //   38: newarray byte
    //   40: astore_3
    //   41: aload_2
    //   42: aload_3
    //   43: iconst_0
    //   44: sipush 4096
    //   47: invokevirtual 118	java/io/FileInputStream:read	([BII)I
    //   50: istore_0
    //   51: iload_0
    //   52: ifle +89 -> 141
    //   55: aload_1
    //   56: aload_3
    //   57: iconst_0
    //   58: iload_0
    //   59: invokevirtual 122	java/io/ByteArrayOutputStream:write	([BII)V
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
    //   77: getstatic 47	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   80: getfield 53	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   83: invokeinterface 59 1 0
    //   88: ifeq +27 -> 115
    //   91: aload_1
    //   92: astore_3
    //   93: aload 5
    //   95: astore 4
    //   97: getstatic 47	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   100: getfield 53	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   103: getstatic 19	com/tencent/image/NativeGifFactory:TAG	Ljava/lang/String;
    //   106: iconst_2
    //   107: ldc 124
    //   109: aload_2
    //   110: invokeinterface 128 5 0
    //   115: aload_1
    //   116: ifnull +7 -> 123
    //   119: aload_1
    //   120: invokevirtual 131	java/io/ByteArrayOutputStream:close	()V
    //   123: aload 6
    //   125: astore_1
    //   126: aload 5
    //   128: ifnull +11 -> 139
    //   131: aload 5
    //   133: invokevirtual 132	java/io/FileInputStream:close	()V
    //   136: aload 6
    //   138: astore_1
    //   139: aload_1
    //   140: areturn
    //   141: aload_1
    //   142: ldc 134
    //   144: invokevirtual 137	java/io/ByteArrayOutputStream:toString	(Ljava/lang/String;)Ljava/lang/String;
    //   147: astore_3
    //   148: aload_1
    //   149: ifnull +7 -> 156
    //   152: aload_1
    //   153: invokevirtual 131	java/io/ByteArrayOutputStream:close	()V
    //   156: aload_3
    //   157: astore_1
    //   158: aload_2
    //   159: ifnull -20 -> 139
    //   162: aload_2
    //   163: invokevirtual 132	java/io/FileInputStream:close	()V
    //   166: aload_3
    //   167: areturn
    //   168: astore_2
    //   169: aload_3
    //   170: astore_1
    //   171: getstatic 47	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   174: getfield 53	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   177: invokeinterface 59 1 0
    //   182: ifeq -43 -> 139
    //   185: getstatic 47	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   188: getfield 53	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   191: getstatic 19	com/tencent/image/NativeGifFactory:TAG	Ljava/lang/String;
    //   194: iconst_2
    //   195: ldc 124
    //   197: aload_2
    //   198: invokeinterface 128 5 0
    //   203: aload_3
    //   204: areturn
    //   205: astore_2
    //   206: aload 6
    //   208: astore_1
    //   209: getstatic 47	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   212: getfield 53	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   215: invokeinterface 59 1 0
    //   220: ifeq -81 -> 139
    //   223: getstatic 47	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   226: getfield 53	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   229: getstatic 19	com/tencent/image/NativeGifFactory:TAG	Ljava/lang/String;
    //   232: iconst_2
    //   233: ldc 124
    //   235: aload_2
    //   236: invokeinterface 128 5 0
    //   241: ldc 104
    //   243: areturn
    //   244: astore_1
    //   245: aconst_null
    //   246: astore_1
    //   247: aconst_null
    //   248: astore_2
    //   249: ldc 104
    //   251: astore_3
    //   252: aload_1
    //   253: ifnull +7 -> 260
    //   256: aload_1
    //   257: invokevirtual 131	java/io/ByteArrayOutputStream:close	()V
    //   260: aload_3
    //   261: astore_1
    //   262: aload_2
    //   263: ifnull -124 -> 139
    //   266: aload_2
    //   267: invokevirtual 132	java/io/FileInputStream:close	()V
    //   270: ldc 104
    //   272: areturn
    //   273: astore_2
    //   274: aload_3
    //   275: astore_1
    //   276: getstatic 47	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   279: getfield 53	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   282: invokeinterface 59 1 0
    //   287: ifeq -148 -> 139
    //   290: getstatic 47	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   293: getfield 53	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   296: getstatic 19	com/tencent/image/NativeGifFactory:TAG	Ljava/lang/String;
    //   299: iconst_2
    //   300: ldc 124
    //   302: aload_2
    //   303: invokeinterface 128 5 0
    //   308: ldc 104
    //   310: areturn
    //   311: astore_2
    //   312: aconst_null
    //   313: astore_1
    //   314: aload_1
    //   315: ifnull +7 -> 322
    //   318: aload_1
    //   319: invokevirtual 131	java/io/ByteArrayOutputStream:close	()V
    //   322: aload 4
    //   324: ifnull +8 -> 332
    //   327: aload 4
    //   329: invokevirtual 132	java/io/FileInputStream:close	()V
    //   332: aload_2
    //   333: athrow
    //   334: astore_1
    //   335: getstatic 47	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   338: getfield 53	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   341: invokeinterface 59 1 0
    //   346: ifeq -14 -> 332
    //   349: getstatic 47	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   352: getfield 53	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   355: getstatic 19	com/tencent/image/NativeGifFactory:TAG	Ljava/lang/String;
    //   358: iconst_2
    //   359: ldc 124
    //   361: aload_1
    //   362: invokeinterface 128 5 0
    //   367: goto -35 -> 332
    //   370: astore_2
    //   371: aload_3
    //   372: astore_1
    //   373: goto -59 -> 314
    //   376: astore_3
    //   377: aload_2
    //   378: astore 4
    //   380: aload_3
    //   381: astore_2
    //   382: goto -68 -> 314
    //   385: astore_2
    //   386: aconst_null
    //   387: astore_2
    //   388: goto -139 -> 249
    //   391: astore_3
    //   392: goto -143 -> 249
    //   395: astore_2
    //   396: aconst_null
    //   397: astore_1
    //   398: goto -327 -> 71
    //   401: astore_2
    //   402: goto -331 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   50	9	0	i	int
    //   19	190	1	localObject1	Object
    //   244	1	1	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   246	73	1	localObject2	Object
    //   334	28	1	localIOException1	IOException
    //   372	26	1	localObject3	Object
    //   4	159	2	localObject4	Object
    //   168	30	2	localIOException2	IOException
    //   205	31	2	localIOException3	IOException
    //   248	19	2	localObject5	Object
    //   273	30	2	localIOException4	IOException
    //   311	22	2	localObject6	Object
    //   370	8	2	localObject7	Object
    //   381	1	2	localObject8	Object
    //   385	1	2	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   387	1	2	localObject9	Object
    //   395	1	2	localIOException5	IOException
    //   401	1	2	localIOException6	IOException
    //   21	36	3	localObject10	Object
    //   65	5	3	localIOException7	IOException
    //   72	300	3	localObject11	Object
    //   376	5	3	localObject12	Object
    //   391	1	3	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   1	378	4	localObject13	Object
    //   6	126	5	localObject14	Object
    //   10	197	6	str	String
    // Exception table:
    //   from	to	target	type
    //   35	41	65	java/io/IOException
    //   41	51	65	java/io/IOException
    //   55	62	65	java/io/IOException
    //   141	148	65	java/io/IOException
    //   152	156	168	java/io/IOException
    //   162	166	168	java/io/IOException
    //   119	123	205	java/io/IOException
    //   131	136	205	java/io/IOException
    //   12	20	244	java/lang/OutOfMemoryError
    //   256	260	273	java/io/IOException
    //   266	270	273	java/io/IOException
    //   12	20	311	finally
    //   318	322	334	java/io/IOException
    //   327	332	334	java/io/IOException
    //   25	35	370	finally
    //   77	91	370	finally
    //   97	115	370	finally
    //   35	41	376	finally
    //   41	51	376	finally
    //   55	62	376	finally
    //   141	148	376	finally
    //   25	35	385	java/lang/OutOfMemoryError
    //   35	41	391	java/lang/OutOfMemoryError
    //   41	51	391	java/lang/OutOfMemoryError
    //   55	62	391	java/lang/OutOfMemoryError
    //   141	148	391	java/lang/OutOfMemoryError
    //   12	20	395	java/io/IOException
    //   25	35	401	java/io/IOException
  }
  
  public static AbstractGifImage getNativeGifObject(File paramFile, boolean paramBoolean)
  {
    if (URLDrawable.depImp.mLog.isColorLevel()) {
      URLDrawable.depImp.mLog.d(TAG, 2, "getNativeGifObject(File file, boolean cacheFirstFrame)");
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
    } while (!URLDrawable.depImp.mLog.isColorLevel());
    URLDrawable.depImp.mLog.e(TAG, 2, "getNativeGifObject exception. msg:" + localIOException1.getMessage());
    return paramFile;
  }
  
  public static AbstractGifImage getNativeGifObject(File paramFile, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, float paramFloat)
  {
    if (URLDrawable.depImp.mLog.isColorLevel()) {
      URLDrawable.depImp.mLog.d(TAG, 2, "getNativeGifObject(File file, boolean cacheFirstFrame, boolean isEmosmFile, int maxWidth, int maxHeight, float roundCorner)");
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
    } while (!URLDrawable.depImp.mLog.isColorLevel());
    URLDrawable.depImp.mLog.e(TAG, 2, "getNativeGifObject exception. msg:" + localIOException2.getMessage());
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
    } while (!URLDrawable.depImp.mLog.isColorLevel());
    URLDrawable.depImp.mLog.d(TAG, 2, "use_new_gif_so:" + bool1);
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.NativeGifFactory
 * JD-Core Version:    0.7.0.1
 */