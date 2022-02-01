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
  static final String TAG = "NativeGifFactory";
  static boolean isX86 = false;
  static boolean isYunOS = false;
  
  static
  {
    Object localObject = getKernelVersion();
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (((String)localObject).contains("x86")) || (((String)localObject).contains("X86"))) {
      isX86 = true;
    }
    String str;
    StringBuilder localStringBuilder;
    if (URLDrawable.depImp.mLog.isColorLevel())
    {
      localObject = URLDrawable.depImp.mLog;
      str = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isX86:");
      localStringBuilder.append(isX86);
      ((ILog)localObject).d(str, 2, localStringBuilder.toString());
    }
    localObject = getSystemProperties(URLDrawable.mApplicationContext, "ro.yunos.version");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).length() > 1)) {
      isYunOS = true;
    }
    if (URLDrawable.depImp.mLog.isColorLevel())
    {
      localObject = URLDrawable.depImp.mLog;
      str = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isYunOS:");
      localStringBuilder.append(isYunOS);
      ((ILog)localObject).d(str, 2, localStringBuilder.toString());
    }
  }
  
  /* Error */
  public static String getKernelVersion()
  {
    // Byte code:
    //   0: ldc 102
    //   2: astore 7
    //   4: aconst_null
    //   5: astore_3
    //   6: new 104	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: invokespecial 105	java/io/ByteArrayOutputStream:<init>	()V
    //   13: astore_1
    //   14: new 107	java/io/FileInputStream
    //   17: dup
    //   18: ldc 109
    //   20: invokespecial 112	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   23: astore_2
    //   24: aload_1
    //   25: astore_3
    //   26: aload_2
    //   27: astore 4
    //   29: sipush 4096
    //   32: newarray byte
    //   34: astore 5
    //   36: aload_1
    //   37: astore_3
    //   38: aload_2
    //   39: astore 4
    //   41: aload_2
    //   42: aload 5
    //   44: iconst_0
    //   45: sipush 4096
    //   48: invokevirtual 116	java/io/FileInputStream:read	([BII)I
    //   51: istore_0
    //   52: iload_0
    //   53: ifle +19 -> 72
    //   56: aload_1
    //   57: astore_3
    //   58: aload_2
    //   59: astore 4
    //   61: aload_1
    //   62: aload 5
    //   64: iconst_0
    //   65: iload_0
    //   66: invokevirtual 120	java/io/ByteArrayOutputStream:write	([BII)V
    //   69: goto -33 -> 36
    //   72: aload_1
    //   73: astore_3
    //   74: aload_2
    //   75: astore 4
    //   77: aload_1
    //   78: ldc 122
    //   80: invokevirtual 125	java/io/ByteArrayOutputStream:toString	(Ljava/lang/String;)Ljava/lang/String;
    //   83: astore 5
    //   85: aload_1
    //   86: invokevirtual 128	java/io/ByteArrayOutputStream:close	()V
    //   89: aload_2
    //   90: invokevirtual 129	java/io/FileInputStream:close	()V
    //   93: aload 5
    //   95: areturn
    //   96: astore_1
    //   97: aload 5
    //   99: astore_2
    //   100: getstatic 41	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   103: getfield 47	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   106: invokeinterface 53 1 0
    //   111: ifeq +221 -> 332
    //   114: getstatic 41	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   117: getfield 47	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   120: getstatic 55	com/tencent/image/NativeGifFactory:TAG	Ljava/lang/String;
    //   123: iconst_2
    //   124: ldc 131
    //   126: aload_1
    //   127: invokeinterface 135 5 0
    //   132: aload 5
    //   134: areturn
    //   135: aload_2
    //   136: astore_3
    //   137: goto +43 -> 180
    //   140: astore 5
    //   142: aload_1
    //   143: astore 6
    //   145: aload_2
    //   146: astore_1
    //   147: goto +89 -> 236
    //   150: astore_2
    //   151: aconst_null
    //   152: astore 4
    //   154: goto +183 -> 337
    //   157: astore 5
    //   159: aconst_null
    //   160: astore_2
    //   161: aload_1
    //   162: astore 6
    //   164: aload_2
    //   165: astore_1
    //   166: goto +70 -> 236
    //   169: astore_2
    //   170: aconst_null
    //   171: astore_1
    //   172: aload_1
    //   173: astore 4
    //   175: goto +162 -> 337
    //   178: aconst_null
    //   179: astore_1
    //   180: aload_1
    //   181: ifnull +10 -> 191
    //   184: aload_1
    //   185: invokevirtual 128	java/io/ByteArrayOutputStream:close	()V
    //   188: goto +3 -> 191
    //   191: aload 7
    //   193: astore_2
    //   194: aload_3
    //   195: ifnull +137 -> 332
    //   198: aload_3
    //   199: invokevirtual 129	java/io/FileInputStream:close	()V
    //   202: ldc 102
    //   204: areturn
    //   205: aload 7
    //   207: astore_2
    //   208: getstatic 41	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   211: getfield 47	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   214: invokeinterface 53 1 0
    //   219: ifeq +113 -> 332
    //   222: aload 7
    //   224: astore 5
    //   226: goto -112 -> 114
    //   229: astore 5
    //   231: aconst_null
    //   232: astore_1
    //   233: aload_1
    //   234: astore 6
    //   236: aload 6
    //   238: astore_3
    //   239: aload_1
    //   240: astore 4
    //   242: getstatic 41	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   245: getfield 47	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   248: invokeinterface 53 1 0
    //   253: ifeq +28 -> 281
    //   256: aload 6
    //   258: astore_3
    //   259: aload_1
    //   260: astore 4
    //   262: getstatic 41	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   265: getfield 47	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   268: getstatic 55	com/tencent/image/NativeGifFactory:TAG	Ljava/lang/String;
    //   271: iconst_2
    //   272: ldc 131
    //   274: aload 5
    //   276: invokeinterface 135 5 0
    //   281: aload 6
    //   283: ifnull +11 -> 294
    //   286: aload 6
    //   288: invokevirtual 128	java/io/ByteArrayOutputStream:close	()V
    //   291: goto +3 -> 294
    //   294: aload 7
    //   296: astore_2
    //   297: aload_1
    //   298: ifnull +34 -> 332
    //   301: aload_1
    //   302: invokevirtual 129	java/io/FileInputStream:close	()V
    //   305: ldc 102
    //   307: areturn
    //   308: aload 7
    //   310: astore_2
    //   311: getstatic 41	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   314: getfield 47	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   317: invokeinterface 53 1 0
    //   322: ifeq +10 -> 332
    //   325: aload 7
    //   327: astore 5
    //   329: goto -215 -> 114
    //   332: aload_2
    //   333: areturn
    //   334: astore_2
    //   335: aload_3
    //   336: astore_1
    //   337: aload_1
    //   338: ifnull +10 -> 348
    //   341: aload_1
    //   342: invokevirtual 128	java/io/ByteArrayOutputStream:close	()V
    //   345: goto +3 -> 348
    //   348: aload 4
    //   350: ifnull +43 -> 393
    //   353: aload 4
    //   355: invokevirtual 129	java/io/FileInputStream:close	()V
    //   358: goto +35 -> 393
    //   361: getstatic 41	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   364: getfield 47	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   367: invokeinterface 53 1 0
    //   372: ifeq +21 -> 393
    //   375: getstatic 41	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   378: getfield 47	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   381: getstatic 55	com/tencent/image/NativeGifFactory:TAG	Ljava/lang/String;
    //   384: iconst_2
    //   385: ldc 131
    //   387: aload_1
    //   388: invokeinterface 135 5 0
    //   393: goto +5 -> 398
    //   396: aload_2
    //   397: athrow
    //   398: goto -2 -> 396
    //   401: astore_1
    //   402: goto -224 -> 178
    //   405: astore_2
    //   406: goto -226 -> 180
    //   409: astore_3
    //   410: goto -275 -> 135
    //   413: astore_1
    //   414: goto -209 -> 205
    //   417: astore_1
    //   418: goto -110 -> 308
    //   421: astore_1
    //   422: goto -61 -> 361
    // Local variable table:
    //   start	length	slot	name	signature
    //   51	15	0	i	int
    //   13	73	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   96	47	1	localIOException1	IOException
    //   146	242	1	localObject1	Object
    //   401	1	1	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   413	1	1	localIOException2	IOException
    //   417	1	1	localIOException3	IOException
    //   421	1	1	localIOException4	IOException
    //   23	123	2	localObject2	Object
    //   150	1	2	localObject3	Object
    //   160	5	2	localObject4	Object
    //   169	1	2	localObject5	Object
    //   193	140	2	str1	String
    //   334	63	2	localObject6	Object
    //   405	1	2	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   5	331	3	localObject7	Object
    //   409	1	3	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   27	327	4	localObject8	Object
    //   34	99	5	localObject9	Object
    //   140	1	5	localIOException5	IOException
    //   157	1	5	localIOException6	IOException
    //   224	1	5	str2	String
    //   229	46	5	localIOException7	IOException
    //   327	1	5	str3	String
    //   143	144	6	localObject10	Object
    //   2	324	7	str4	String
    // Exception table:
    //   from	to	target	type
    //   85	93	96	java/io/IOException
    //   29	36	140	java/io/IOException
    //   41	52	140	java/io/IOException
    //   61	69	140	java/io/IOException
    //   77	85	140	java/io/IOException
    //   14	24	150	finally
    //   14	24	157	java/io/IOException
    //   6	14	169	finally
    //   6	14	229	java/io/IOException
    //   29	36	334	finally
    //   41	52	334	finally
    //   61	69	334	finally
    //   77	85	334	finally
    //   242	256	334	finally
    //   262	281	334	finally
    //   6	14	401	java/lang/OutOfMemoryError
    //   14	24	405	java/lang/OutOfMemoryError
    //   29	36	409	java/lang/OutOfMemoryError
    //   41	52	409	java/lang/OutOfMemoryError
    //   61	69	409	java/lang/OutOfMemoryError
    //   77	85	409	java/lang/OutOfMemoryError
    //   184	188	413	java/io/IOException
    //   198	202	413	java/io/IOException
    //   286	291	417	java/io/IOException
    //   301	305	417	java/io/IOException
    //   341	345	421	java/io/IOException
    //   353	358	421	java/io/IOException
  }
  
  public static AbstractGifImage getNativeGifObject(File paramFile, boolean paramBoolean)
  {
    if (URLDrawable.depImp.mLog.isColorLevel()) {
      URLDrawable.depImp.mLog.d(TAG, 2, "getNativeGifObject(File file, boolean cacheFirstFrame)");
    }
    try
    {
      if (isUseNewGif())
      {
        Object localObject1 = new NativeGifIndex8(paramFile, paramBoolean);
        Object localObject2 = localObject1;
        try
        {
          if (((NativeGifIndex8)localObject1).mFrameNumber != -1001) {
            return ???;
          }
          paramFile = new NativeGifImage(paramFile, paramBoolean);
          return paramFile;
        }
        catch (IOException localIOException2)
        {
          paramFile = (File)localObject1;
          localObject1 = localIOException2;
        }
      }
      else
      {
        paramFile = new NativeGifImage(paramFile, paramBoolean);
        return paramFile;
      }
    }
    catch (IOException localIOException1)
    {
      paramFile = null;
      Object localObject3 = paramFile;
      if (URLDrawable.depImp.mLog.isColorLevel())
      {
        localObject3 = URLDrawable.depImp.mLog;
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getNativeGifObject exception. msg:");
        localStringBuilder.append(localIOException1.getMessage());
        ((ILog)localObject3).e(str, 2, localStringBuilder.toString());
        localObject3 = paramFile;
      }
      return localObject3;
    }
  }
  
  public static AbstractGifImage getNativeGifObject(File paramFile, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, float paramFloat)
  {
    if (URLDrawable.depImp.mLog.isColorLevel()) {
      URLDrawable.depImp.mLog.d(TAG, 2, "getNativeGifObject(File file, boolean cacheFirstFrame, boolean isEmosmFile, int maxWidth, int maxHeight, float roundCorner)");
    }
    Object localObject1 = null;
    if (paramFloat == 0.0F) {}
    try
    {
      if (isUseNewGif())
      {
        localObject2 = new NativeGifIndex8(paramFile, paramBoolean1, paramBoolean2, paramInt1, paramInt2, paramFloat);
        try
        {
          if (((NativeGifIndex8)localObject2).mFrameNumber == -1001)
          {
            paramFile = new NativeGifImage(paramFile, paramBoolean1, paramBoolean2, paramInt1, paramInt2, paramFloat);
            return paramFile;
          }
          return localObject2;
        }
        catch (IOException paramFile)
        {
          localObject1 = localObject2;
        }
      }
      else
      {
        paramFile = new NativeGifImage(paramFile, paramBoolean1, paramBoolean2, paramInt1, paramInt2, paramFloat);
        return paramFile;
      }
    }
    catch (IOException paramFile)
    {
      Object localObject2;
      if (URLDrawable.depImp.mLog.isColorLevel())
      {
        localObject2 = URLDrawable.depImp.mLog;
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getNativeGifObject exception. msg:");
        localStringBuilder.append(paramFile.getMessage());
        ((ILog)localObject2).e(str, 2, localStringBuilder.toString());
      }
    }
    return localObject1;
  }
  
  public static String getSystemProperties(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("android.os.SystemProperties");
      paramContext = (String)paramContext.getMethod("get", new Class[] { String.class }).invoke(paramContext, new Object[] { new String(paramString) });
      return paramContext;
    }
    catch (IllegalArgumentException|Exception paramContext) {}
    return "";
  }
  
  public static boolean isUseNewGif()
  {
    Object localObject = Build.MANUFACTURER;
    String str = Build.MODEL;
    int i = Build.VERSION.SDK_INT;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2;
    if ((i == 10) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      bool2 = bool3;
      if (((String)localObject).contains("samsung")) {}
    }
    else if (!TextUtils.isEmpty(str))
    {
      bool2 = bool3;
      if (!str.contains("m1"))
      {
        bool2 = bool3;
        if (!str.contains("meizu_m1"))
        {
          bool2 = bool3;
          if (str.contains("N1")) {}
        }
      }
    }
    else
    {
      bool2 = bool3;
      if (!str.contains("HYF9300"))
      {
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          bool2 = bool3;
          if (((String)localObject).contains("alps")) {
            return bool2;
          }
          bool2 = bool3;
          if (((String)localObject).contains("Nokia")) {
            return bool2;
          }
          if (((String)localObject).toLowerCase().contains("asus")) {
            return false;
          }
        }
        bool2 = bool3;
        if (!isX86)
        {
          if (isYunOS) {
            return false;
          }
          localObject = URLDrawable.mApplicationContext.getSharedPreferences("early_qq.android.native.gif", 4);
          if (localObject != null) {
            bool1 = ((SharedPreferences)localObject).getBoolean("use_new_gif_so", false);
          }
          bool2 = bool1;
          if (URLDrawable.depImp.mLog.isColorLevel())
          {
            localObject = URLDrawable.depImp.mLog;
            str = TAG;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("use_new_gif_so:");
            localStringBuilder.append(bool1);
            ((ILog)localObject).d(str, 2, localStringBuilder.toString());
            bool2 = bool1;
          }
        }
      }
    }
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image.NativeGifFactory
 * JD-Core Version:    0.7.0.1
 */