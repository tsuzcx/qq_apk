package com.tencent.biz.common.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.LightingColorFilter;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.media.MediaScannerConnection;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ImageUtil
{
  protected static int a = 7;
  protected static int b = 10;
  protected static String c;
  protected static String d = "ImageUtil";
  static MediaScannerConnection e;
  
  public static final int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = b(paramOptions, paramInt1, paramInt2);
    if (i <= 8)
    {
      paramInt1 = 1;
      for (;;)
      {
        paramInt2 = paramInt1;
        if (paramInt1 >= i) {
          break;
        }
        paramInt1 <<= 1;
      }
    }
    paramInt2 = (i + 7) / 8 * 8;
    return paramInt2;
  }
  
  public static final Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    Object localObject2 = null;
    Object localObject4 = null;
    if (paramBitmap == null) {
      return null;
    }
    int j = paramBitmap.getWidth();
    int k = paramBitmap.getHeight();
    Object localObject3;
    if (j > 0)
    {
      if (k <= 0) {
        return null;
      }
      int i;
      if (j > k) {
        i = j;
      } else {
        i = k;
      }
      if (i <= paramInt) {
        return paramBitmap;
      }
      float f = paramInt / i;
      Object localObject1 = new Matrix();
      ((Matrix)localObject1).postScale(f, f);
      try
      {
        localObject1 = Bitmap.createBitmap(paramBitmap, 0, 0, j, k, (Matrix)localObject1, true);
      }
      catch (Throwable localThrowable)
      {
        localObject1 = localObject4;
        if (QLog.isColorLevel())
        {
          QLog.e(d, 2, "scaleBitmap, exp=", localThrowable);
          localObject1 = localObject4;
        }
      }
      localObject3 = localObject1;
      if (paramBitmap != null)
      {
        localObject3 = localObject1;
        if (!paramBitmap.isRecycled())
        {
          paramBitmap.recycle();
          localObject3 = localObject1;
        }
      }
    }
    return localObject3;
  }
  
  public static Bitmap a(String paramString)
  {
    try
    {
      if (new File(paramString).exists())
      {
        Bitmap localBitmap = BitmapFactory.decodeFile(paramString);
        return localBitmap;
      }
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel())
      {
        String str = d;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("readImg OOM, fileName=");
        localStringBuilder.append(paramString);
        QLog.w(str, 2, localStringBuilder.toString(), localThrowable);
      }
    }
    return null;
  }
  
  /* Error */
  public static final Bitmap a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 108	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 110	android/graphics/BitmapFactory$Options
    //   12: dup
    //   13: invokespecial 111	android/graphics/BitmapFactory$Options:<init>	()V
    //   16: astore 6
    //   18: aload 6
    //   20: iconst_1
    //   21: putfield 115	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   24: aload_0
    //   25: aload 6
    //   27: invokestatic 118	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   30: pop
    //   31: aload 6
    //   33: getfield 121	android/graphics/BitmapFactory$Options:outWidth	I
    //   36: istore_2
    //   37: aload 6
    //   39: getfield 124	android/graphics/BitmapFactory$Options:outHeight	I
    //   42: istore_3
    //   43: aload 6
    //   45: getfield 127	android/graphics/BitmapFactory$Options:mCancel	Z
    //   48: ifne +319 -> 367
    //   51: aload 6
    //   53: getfield 121	android/graphics/BitmapFactory$Options:outWidth	I
    //   56: iconst_m1
    //   57: if_icmpeq +310 -> 367
    //   60: aload 6
    //   62: getfield 124	android/graphics/BitmapFactory$Options:outHeight	I
    //   65: iconst_m1
    //   66: if_icmpne +5 -> 71
    //   69: aconst_null
    //   70: areturn
    //   71: iload_2
    //   72: iload_3
    //   73: if_icmple +6 -> 79
    //   76: goto +5 -> 81
    //   79: iload_3
    //   80: istore_2
    //   81: aload 6
    //   83: getstatic 133	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   86: putfield 136	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   89: iload_2
    //   90: iload_1
    //   91: if_icmple +17 -> 108
    //   94: aload 6
    //   96: aload 6
    //   98: iconst_m1
    //   99: iload_1
    //   100: iload_1
    //   101: imul
    //   102: invokestatic 138	com/tencent/biz/common/util/ImageUtil:a	(Landroid/graphics/BitmapFactory$Options;II)I
    //   105: putfield 141	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   108: aload 6
    //   110: iconst_0
    //   111: putfield 115	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   114: new 143	java/io/BufferedInputStream
    //   117: dup
    //   118: new 145	java/io/FileInputStream
    //   121: dup
    //   122: aload_0
    //   123: invokespecial 146	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   126: invokespecial 149	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   129: astore 4
    //   131: aload 4
    //   133: astore_0
    //   134: aload 4
    //   136: aconst_null
    //   137: aload 6
    //   139: invokestatic 153	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   142: astore 5
    //   144: aload 4
    //   146: invokevirtual 156	java/io/BufferedInputStream:close	()V
    //   149: goto +20 -> 169
    //   152: astore_0
    //   153: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq +13 -> 169
    //   159: getstatic 56	com/tencent/biz/common/util/ImageUtil:d	Ljava/lang/String;
    //   162: iconst_2
    //   163: ldc 158
    //   165: aload_0
    //   166: invokestatic 61	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   169: aload 6
    //   171: getfield 121	android/graphics/BitmapFactory$Options:outWidth	I
    //   174: istore_2
    //   175: aload 6
    //   177: getfield 124	android/graphics/BitmapFactory$Options:outHeight	I
    //   180: istore_3
    //   181: iload_2
    //   182: iload_3
    //   183: if_icmple +6 -> 189
    //   186: goto +5 -> 191
    //   189: iload_3
    //   190: istore_2
    //   191: aload 5
    //   193: astore_0
    //   194: iload_2
    //   195: iload_1
    //   196: if_icmple +10 -> 206
    //   199: aload 5
    //   201: iload_1
    //   202: invokestatic 160	com/tencent/biz/common/util/ImageUtil:a	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   205: astore_0
    //   206: aload_0
    //   207: areturn
    //   208: astore 5
    //   210: goto +15 -> 225
    //   213: astore 4
    //   215: aconst_null
    //   216: astore_0
    //   217: goto +119 -> 336
    //   220: astore 5
    //   222: aconst_null
    //   223: astore 4
    //   225: aload 4
    //   227: astore_0
    //   228: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   231: ifeq +17 -> 248
    //   234: aload 4
    //   236: astore_0
    //   237: getstatic 56	com/tencent/biz/common/util/ImageUtil:d	Ljava/lang/String;
    //   240: iconst_2
    //   241: ldc 162
    //   243: aload 5
    //   245: invokestatic 61	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   248: aload 4
    //   250: ifnull +27 -> 277
    //   253: aload 4
    //   255: invokevirtual 156	java/io/BufferedInputStream:close	()V
    //   258: aconst_null
    //   259: areturn
    //   260: astore_0
    //   261: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   264: ifeq +13 -> 277
    //   267: getstatic 56	com/tencent/biz/common/util/ImageUtil:d	Ljava/lang/String;
    //   270: iconst_2
    //   271: ldc 158
    //   273: aload_0
    //   274: invokestatic 61	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   277: aconst_null
    //   278: areturn
    //   279: aconst_null
    //   280: astore 4
    //   282: aload 4
    //   284: astore_0
    //   285: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   288: ifeq +15 -> 303
    //   291: aload 4
    //   293: astore_0
    //   294: getstatic 56	com/tencent/biz/common/util/ImageUtil:d	Ljava/lang/String;
    //   297: iconst_2
    //   298: ldc 164
    //   300: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   303: aload 4
    //   305: ifnull +27 -> 332
    //   308: aload 4
    //   310: invokevirtual 156	java/io/BufferedInputStream:close	()V
    //   313: aconst_null
    //   314: areturn
    //   315: astore_0
    //   316: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   319: ifeq +13 -> 332
    //   322: getstatic 56	com/tencent/biz/common/util/ImageUtil:d	Ljava/lang/String;
    //   325: iconst_2
    //   326: ldc 158
    //   328: aload_0
    //   329: invokestatic 61	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   332: aconst_null
    //   333: areturn
    //   334: astore 4
    //   336: aload_0
    //   337: ifnull +27 -> 364
    //   340: aload_0
    //   341: invokevirtual 156	java/io/BufferedInputStream:close	()V
    //   344: goto +20 -> 364
    //   347: astore_0
    //   348: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   351: ifeq +13 -> 364
    //   354: getstatic 56	com/tencent/biz/common/util/ImageUtil:d	Ljava/lang/String;
    //   357: iconst_2
    //   358: ldc 158
    //   360: aload_0
    //   361: invokestatic 61	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   364: aload 4
    //   366: athrow
    //   367: aconst_null
    //   368: areturn
    //   369: astore_0
    //   370: goto -91 -> 279
    //   373: astore_0
    //   374: goto -92 -> 282
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	377	0	paramString	String
    //   0	377	1	paramInt	int
    //   36	161	2	i	int
    //   42	148	3	j	int
    //   129	16	4	localBufferedInputStream	java.io.BufferedInputStream
    //   213	1	4	localObject1	Object
    //   223	86	4	localObject2	Object
    //   334	31	4	localObject3	Object
    //   142	58	5	localBitmap	Bitmap
    //   208	1	5	localException1	java.lang.Exception
    //   220	24	5	localException2	java.lang.Exception
    //   16	160	6	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   144	149	152	java/lang/Exception
    //   134	144	208	java/lang/Exception
    //   114	131	213	finally
    //   114	131	220	java/lang/Exception
    //   253	258	260	java/lang/Exception
    //   308	313	315	java/lang/Exception
    //   134	144	334	finally
    //   228	234	334	finally
    //   237	248	334	finally
    //   285	291	334	finally
    //   294	303	334	finally
    //   340	344	347	java/lang/Exception
    //   114	131	369	java/lang/OutOfMemoryError
    //   134	144	373	java/lang/OutOfMemoryError
  }
  
  public static Drawable a(Drawable paramDrawable, int paramInt)
  {
    if (paramDrawable == null) {
      return null;
    }
    paramDrawable = paramDrawable.getConstantState().newDrawable().mutate();
    paramDrawable.setColorFilter(new LightingColorFilter(0, paramInt));
    return paramDrawable;
  }
  
  /* Error */
  public static String a(android.content.Context paramContext, String paramString, android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +326 -> 327
    //   4: aload_1
    //   5: ldc 197
    //   7: invokevirtual 203	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10: ifeq +6 -> 16
    //   13: goto +314 -> 327
    //   16: new 70	java/io/File
    //   19: dup
    //   20: getstatic 208	com/tencent/mobileqq/app/AppConstants:SDCARD_FILE_SAVE_TMP_PATH	Ljava/lang/String;
    //   23: invokespecial 73	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: astore 4
    //   28: aload 4
    //   30: invokevirtual 211	java/io/File:mkdirs	()Z
    //   33: pop
    //   34: aload 4
    //   36: invokevirtual 214	java/io/File:canWrite	()Z
    //   39: ifne +20 -> 59
    //   42: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   45: ifeq +12 -> 57
    //   48: getstatic 56	com/tencent/biz/common/util/ImageUtil:d	Ljava/lang/String;
    //   51: iconst_2
    //   52: ldc 216
    //   54: invokestatic 218	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: aconst_null
    //   58: areturn
    //   59: new 83	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   66: astore 4
    //   68: aload 4
    //   70: getstatic 208	com/tencent/mobileqq/app/AppConstants:SDCARD_FILE_SAVE_TMP_PATH	Ljava/lang/String;
    //   73: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload 4
    //   79: aload_1
    //   80: invokestatic 224	com/tencent/mobileqq/transfile/AbsDownloader:getFileName	(Ljava/lang/String;)Ljava/lang/String;
    //   83: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload 4
    //   89: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: astore 4
    //   94: new 70	java/io/File
    //   97: dup
    //   98: aload 4
    //   100: invokespecial 73	java/io/File:<init>	(Ljava/lang/String;)V
    //   103: astore 5
    //   105: aload 5
    //   107: invokevirtual 76	java/io/File:exists	()Z
    //   110: ifeq +6 -> 116
    //   113: aload 4
    //   115: areturn
    //   116: aload_1
    //   117: ldc 226
    //   119: invokevirtual 230	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   122: ifeq +41 -> 163
    //   125: aload_1
    //   126: bipush 44
    //   128: invokevirtual 234	java/lang/String:indexOf	(I)I
    //   131: istore_3
    //   132: iload_3
    //   133: ifle +47 -> 180
    //   136: aload_1
    //   137: iconst_0
    //   138: iload_3
    //   139: invokevirtual 238	java/lang/String:substring	(II)Ljava/lang/String;
    //   142: ldc 240
    //   144: invokevirtual 243	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   147: ifeq +33 -> 180
    //   150: aload_1
    //   151: iload_3
    //   152: invokevirtual 246	java/lang/String:substring	(I)Ljava/lang/String;
    //   155: iconst_0
    //   156: invokestatic 252	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   159: astore_1
    //   160: goto +22 -> 182
    //   163: aload_0
    //   164: aload_1
    //   165: ldc 254
    //   167: aconst_null
    //   168: aload_2
    //   169: invokestatic 260	com/tencent/biz/common/util/HttpUtil:openUrlForByte	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;)[B
    //   172: astore_1
    //   173: goto +9 -> 182
    //   176: astore_0
    //   177: goto +104 -> 281
    //   180: aconst_null
    //   181: astore_1
    //   182: aload_1
    //   183: ifnonnull +21 -> 204
    //   186: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   189: ifeq +13 -> 202
    //   192: getstatic 56	com/tencent/biz/common/util/ImageUtil:d	Ljava/lang/String;
    //   195: iconst_2
    //   196: ldc_w 262
    //   199: invokestatic 218	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   202: aconst_null
    //   203: areturn
    //   204: new 264	java/io/FileOutputStream
    //   207: dup
    //   208: aload 5
    //   210: invokespecial 267	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   213: astore_2
    //   214: aload_2
    //   215: astore_0
    //   216: aload_2
    //   217: aload_1
    //   218: invokevirtual 271	java/io/FileOutputStream:write	([B)V
    //   221: aload_2
    //   222: invokevirtual 272	java/io/FileOutputStream:close	()V
    //   225: aload 4
    //   227: areturn
    //   228: astore_0
    //   229: aconst_null
    //   230: astore_1
    //   231: goto +40 -> 271
    //   234: aconst_null
    //   235: astore_1
    //   236: aload_1
    //   237: astore_0
    //   238: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   241: ifeq +15 -> 256
    //   244: aload_1
    //   245: astore_0
    //   246: getstatic 56	com/tencent/biz/common/util/ImageUtil:d	Ljava/lang/String;
    //   249: iconst_2
    //   250: ldc_w 274
    //   253: invokestatic 218	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   256: aload_1
    //   257: ifnull +7 -> 264
    //   260: aload_1
    //   261: invokevirtual 272	java/io/FileOutputStream:close	()V
    //   264: aconst_null
    //   265: areturn
    //   266: astore_2
    //   267: aload_0
    //   268: astore_1
    //   269: aload_2
    //   270: astore_0
    //   271: aload_1
    //   272: ifnull +7 -> 279
    //   275: aload_1
    //   276: invokevirtual 272	java/io/FileOutputStream:close	()V
    //   279: aload_0
    //   280: athrow
    //   281: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   284: ifeq +41 -> 325
    //   287: getstatic 56	com/tencent/biz/common/util/ImageUtil:d	Ljava/lang/String;
    //   290: astore_1
    //   291: new 83	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   298: astore_2
    //   299: aload_2
    //   300: ldc_w 276
    //   303: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload_2
    //   308: aload_0
    //   309: invokevirtual 277	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   312: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: aload_1
    //   317: iconst_2
    //   318: aload_2
    //   319: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: invokestatic 218	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   325: aconst_null
    //   326: areturn
    //   327: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   330: ifeq +13 -> 343
    //   333: getstatic 56	com/tencent/biz/common/util/ImageUtil:d	Ljava/lang/String;
    //   336: iconst_2
    //   337: ldc_w 279
    //   340: invokestatic 218	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   343: aconst_null
    //   344: areturn
    //   345: astore_0
    //   346: goto -166 -> 180
    //   349: astore_0
    //   350: goto -116 -> 234
    //   353: astore_0
    //   354: aload_2
    //   355: astore_1
    //   356: goto -120 -> 236
    //   359: astore_0
    //   360: aload 4
    //   362: areturn
    //   363: astore_0
    //   364: aconst_null
    //   365: areturn
    //   366: astore_1
    //   367: goto -88 -> 279
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	370	0	paramContext	android.content.Context
    //   0	370	1	paramString	String
    //   0	370	2	paramBundle	android.os.Bundle
    //   131	21	3	i	int
    //   26	335	4	localObject	Object
    //   103	106	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   116	132	176	java/lang/OutOfMemoryError
    //   136	160	176	java/lang/OutOfMemoryError
    //   163	173	176	java/lang/OutOfMemoryError
    //   186	202	176	java/lang/OutOfMemoryError
    //   221	225	176	java/lang/OutOfMemoryError
    //   260	264	176	java/lang/OutOfMemoryError
    //   275	279	176	java/lang/OutOfMemoryError
    //   279	281	176	java/lang/OutOfMemoryError
    //   204	214	228	finally
    //   216	221	266	finally
    //   238	244	266	finally
    //   246	256	266	finally
    //   116	132	345	java/lang/Exception
    //   136	160	345	java/lang/Exception
    //   163	173	345	java/lang/Exception
    //   204	214	349	java/io/IOException
    //   216	221	353	java/io/IOException
    //   221	225	359	java/io/IOException
    //   260	264	363	java/io/IOException
    //   275	279	366	java/io/IOException
  }
  
  /* Error */
  public static String a(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: getstatic 282	com/tencent/biz/common/util/ImageUtil:c	Ljava/lang/String;
    //   3: invokestatic 108	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +12 -> 18
    //   9: invokestatic 288	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   12: invokevirtual 289	java/io/File:toString	()Ljava/lang/String;
    //   15: putstatic 282	com/tencent/biz/common/util/ImageUtil:c	Ljava/lang/String;
    //   18: new 83	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   25: astore_2
    //   26: aload_2
    //   27: getstatic 282	com/tencent/biz/common/util/ImageUtil:c	Ljava/lang/String;
    //   30: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload_2
    //   35: ldc_w 291
    //   38: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_2
    //   43: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: astore 5
    //   48: aconst_null
    //   49: astore 4
    //   51: aconst_null
    //   52: astore_3
    //   53: aload_3
    //   54: astore_2
    //   55: new 70	java/io/File
    //   58: dup
    //   59: aload 5
    //   61: invokespecial 73	java/io/File:<init>	(Ljava/lang/String;)V
    //   64: astore 6
    //   66: aload_3
    //   67: astore_2
    //   68: aload 6
    //   70: invokevirtual 76	java/io/File:exists	()Z
    //   73: ifne +11 -> 84
    //   76: aload_3
    //   77: astore_2
    //   78: aload 6
    //   80: invokevirtual 294	java/io/File:mkdir	()Z
    //   83: pop
    //   84: aload_3
    //   85: astore_2
    //   86: aload_0
    //   87: invokestatic 297	com/tencent/biz/common/util/ImageUtil:b	(Landroid/graphics/Bitmap;)[B
    //   90: invokestatic 303	com/tencent/qphone/base/util/MD5:toMD5	([B)Ljava/lang/String;
    //   93: astore 6
    //   95: aload_3
    //   96: astore_2
    //   97: new 83	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   104: astore 7
    //   106: aload_3
    //   107: astore_2
    //   108: aload 7
    //   110: ldc_w 305
    //   113: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload_3
    //   118: astore_2
    //   119: aload 7
    //   121: aload 6
    //   123: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload_3
    //   128: astore_2
    //   129: aload 7
    //   131: ldc_w 307
    //   134: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload_3
    //   139: astore_2
    //   140: aload 7
    //   142: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: astore 6
    //   147: aload_3
    //   148: astore_2
    //   149: new 83	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   156: astore 7
    //   158: aload_3
    //   159: astore_2
    //   160: aload 7
    //   162: aload 5
    //   164: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload_3
    //   169: astore_2
    //   170: aload 7
    //   172: aload 6
    //   174: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload_3
    //   179: astore_2
    //   180: aload 7
    //   182: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: astore 5
    //   187: aload_3
    //   188: astore_2
    //   189: new 70	java/io/File
    //   192: dup
    //   193: aload 5
    //   195: invokespecial 73	java/io/File:<init>	(Ljava/lang/String;)V
    //   198: astore 6
    //   200: aload_3
    //   201: astore_2
    //   202: aload 6
    //   204: invokevirtual 76	java/io/File:exists	()Z
    //   207: istore_1
    //   208: iload_1
    //   209: ifeq +87 -> 296
    //   212: aload_3
    //   213: astore_2
    //   214: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   217: ifeq +15 -> 232
    //   220: aload_3
    //   221: astore_2
    //   222: getstatic 56	com/tencent/biz/common/util/ImageUtil:d	Ljava/lang/String;
    //   225: iconst_2
    //   226: ldc_w 309
    //   229: invokestatic 312	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   232: aload_3
    //   233: astore_2
    //   234: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   237: ifeq +296 -> 533
    //   240: aload_3
    //   241: astore_2
    //   242: getstatic 56	com/tencent/biz/common/util/ImageUtil:d	Ljava/lang/String;
    //   245: astore_0
    //   246: aload_3
    //   247: astore_2
    //   248: new 83	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   255: astore 7
    //   257: aload_3
    //   258: astore_2
    //   259: aload 7
    //   261: ldc_w 314
    //   264: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: pop
    //   268: aload_3
    //   269: astore_2
    //   270: aload 7
    //   272: aload 6
    //   274: invokevirtual 318	java/io/File:length	()J
    //   277: invokevirtual 321	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload_3
    //   282: astore_2
    //   283: aload_0
    //   284: iconst_2
    //   285: aload 7
    //   287: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokestatic 312	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   293: aload 5
    //   295: areturn
    //   296: aload_3
    //   297: astore_2
    //   298: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   301: ifeq +15 -> 316
    //   304: aload_3
    //   305: astore_2
    //   306: getstatic 56	com/tencent/biz/common/util/ImageUtil:d	Ljava/lang/String;
    //   309: iconst_2
    //   310: ldc_w 323
    //   313: invokestatic 312	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   316: aload_3
    //   317: astore_2
    //   318: new 325	java/io/BufferedOutputStream
    //   321: dup
    //   322: new 264	java/io/FileOutputStream
    //   325: dup
    //   326: aload 6
    //   328: invokespecial 267	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   331: invokespecial 328	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   334: astore_3
    //   335: aload_0
    //   336: getstatic 334	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   339: bipush 100
    //   341: aload_3
    //   342: invokevirtual 338	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   345: pop
    //   346: aload_3
    //   347: invokevirtual 341	java/io/BufferedOutputStream:flush	()V
    //   350: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   353: ifeq +42 -> 395
    //   356: getstatic 56	com/tencent/biz/common/util/ImageUtil:d	Ljava/lang/String;
    //   359: astore_0
    //   360: new 83	java/lang/StringBuilder
    //   363: dup
    //   364: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   367: astore_2
    //   368: aload_2
    //   369: ldc_w 314
    //   372: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: aload_2
    //   377: aload 6
    //   379: invokevirtual 318	java/io/File:length	()J
    //   382: invokevirtual 321	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   385: pop
    //   386: aload_0
    //   387: iconst_2
    //   388: aload_2
    //   389: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: invokestatic 312	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   395: aload_3
    //   396: invokevirtual 342	java/io/BufferedOutputStream:close	()V
    //   399: aload 5
    //   401: areturn
    //   402: astore_0
    //   403: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   406: ifeq +14 -> 420
    //   409: getstatic 56	com/tencent/biz/common/util/ImageUtil:d	Ljava/lang/String;
    //   412: iconst_2
    //   413: ldc_w 344
    //   416: aload_0
    //   417: invokestatic 61	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   420: aload 5
    //   422: areturn
    //   423: astore_0
    //   424: aload_3
    //   425: astore_2
    //   426: goto +72 -> 498
    //   429: astore_2
    //   430: aload_3
    //   431: astore_0
    //   432: aload_2
    //   433: astore_3
    //   434: goto +11 -> 445
    //   437: astore_0
    //   438: goto +60 -> 498
    //   441: astore_3
    //   442: aload 4
    //   444: astore_0
    //   445: aload_0
    //   446: astore_2
    //   447: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   450: ifeq +16 -> 466
    //   453: aload_0
    //   454: astore_2
    //   455: getstatic 56	com/tencent/biz/common/util/ImageUtil:d	Ljava/lang/String;
    //   458: iconst_2
    //   459: ldc_w 346
    //   462: aload_3
    //   463: invokestatic 61	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   466: aload_0
    //   467: ifnull +28 -> 495
    //   470: aload_0
    //   471: invokevirtual 342	java/io/BufferedOutputStream:close	()V
    //   474: ldc 197
    //   476: areturn
    //   477: astore_0
    //   478: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   481: ifeq +14 -> 495
    //   484: getstatic 56	com/tencent/biz/common/util/ImageUtil:d	Ljava/lang/String;
    //   487: iconst_2
    //   488: ldc_w 344
    //   491: aload_0
    //   492: invokestatic 61	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   495: ldc 197
    //   497: areturn
    //   498: aload_2
    //   499: ifnull +28 -> 527
    //   502: aload_2
    //   503: invokevirtual 342	java/io/BufferedOutputStream:close	()V
    //   506: goto +21 -> 527
    //   509: astore_2
    //   510: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   513: ifeq +14 -> 527
    //   516: getstatic 56	com/tencent/biz/common/util/ImageUtil:d	Ljava/lang/String;
    //   519: iconst_2
    //   520: ldc_w 344
    //   523: aload_2
    //   524: invokestatic 61	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   527: aload_0
    //   528: athrow
    //   529: astore_2
    //   530: goto -512 -> 18
    //   533: aload 5
    //   535: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	536	0	paramBitmap	Bitmap
    //   207	2	1	bool	boolean
    //   25	401	2	localObject1	Object
    //   429	4	2	localIOException1	java.io.IOException
    //   446	57	2	localBitmap	Bitmap
    //   509	15	2	localException1	java.lang.Exception
    //   529	1	2	localException2	java.lang.Exception
    //   52	382	3	localObject2	Object
    //   441	22	3	localIOException2	java.io.IOException
    //   49	394	4	localObject3	Object
    //   46	488	5	str	String
    //   64	314	6	localObject4	Object
    //   104	182	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   395	399	402	java/lang/Exception
    //   335	395	423	finally
    //   335	395	429	java/io/IOException
    //   55	66	437	finally
    //   68	76	437	finally
    //   78	84	437	finally
    //   86	95	437	finally
    //   97	106	437	finally
    //   108	117	437	finally
    //   119	127	437	finally
    //   129	138	437	finally
    //   140	147	437	finally
    //   149	158	437	finally
    //   160	168	437	finally
    //   170	178	437	finally
    //   180	187	437	finally
    //   189	200	437	finally
    //   202	208	437	finally
    //   214	220	437	finally
    //   222	232	437	finally
    //   234	240	437	finally
    //   242	246	437	finally
    //   248	257	437	finally
    //   259	268	437	finally
    //   270	281	437	finally
    //   283	293	437	finally
    //   298	304	437	finally
    //   306	316	437	finally
    //   318	335	437	finally
    //   447	453	437	finally
    //   455	466	437	finally
    //   55	66	441	java/io/IOException
    //   68	76	441	java/io/IOException
    //   78	84	441	java/io/IOException
    //   86	95	441	java/io/IOException
    //   97	106	441	java/io/IOException
    //   108	117	441	java/io/IOException
    //   119	127	441	java/io/IOException
    //   129	138	441	java/io/IOException
    //   140	147	441	java/io/IOException
    //   149	158	441	java/io/IOException
    //   160	168	441	java/io/IOException
    //   170	178	441	java/io/IOException
    //   180	187	441	java/io/IOException
    //   189	200	441	java/io/IOException
    //   202	208	441	java/io/IOException
    //   214	220	441	java/io/IOException
    //   222	232	441	java/io/IOException
    //   234	240	441	java/io/IOException
    //   242	246	441	java/io/IOException
    //   248	257	441	java/io/IOException
    //   259	268	441	java/io/IOException
    //   270	281	441	java/io/IOException
    //   283	293	441	java/io/IOException
    //   298	304	441	java/io/IOException
    //   306	316	441	java/io/IOException
    //   318	335	441	java/io/IOException
    //   470	474	477	java/lang/Exception
    //   502	506	509	java/lang/Exception
    //   9	18	529	java/lang/Exception
  }
  
  private static int b(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    double d2 = paramOptions.outWidth;
    double d1 = paramOptions.outHeight;
    int i;
    double d3;
    if (paramInt2 == -1)
    {
      i = 1;
    }
    else
    {
      Double.isNaN(d2);
      Double.isNaN(d1);
      d3 = paramInt2;
      Double.isNaN(d3);
      i = (int)Math.ceil(Math.sqrt(d2 * d1 / d3));
    }
    int j;
    if (paramInt1 == -1)
    {
      j = 128;
    }
    else
    {
      d3 = paramInt1;
      Double.isNaN(d2);
      Double.isNaN(d3);
      d2 = Math.floor(d2 / d3);
      Double.isNaN(d1);
      Double.isNaN(d3);
      j = (int)Math.min(d2, Math.floor(d1 / d3));
    }
    if (j < i) {
      return i;
    }
    if ((paramInt2 == -1) && (paramInt1 == -1)) {
      return 1;
    }
    if (paramInt1 == -1) {
      return i;
    }
    return j;
  }
  
  public static Bitmap b(Bitmap paramBitmap, int paramInt)
  {
    if (paramBitmap == null) {
      return paramBitmap;
    }
    int j = paramBitmap.getHeight();
    int i = paramBitmap.getWidth();
    int m;
    if (j > i) {
      m = i;
    } else {
      m = j;
    }
    int n = 0;
    int i1 = 0;
    int k = i1;
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        break label76;
      }
      if (paramInt == 2) {
        break label63;
      }
    }
    for (k = i1;; k = paramInt - k)
    {
      paramInt = 0;
      break;
      label63:
      k = j;
      paramInt = i;
      if (j > i)
      {
        label76:
        if (j > i)
        {
          j /= 2;
          i /= 2;
          paramInt = j - i;
          k = n;
          break;
        }
        paramInt = i / 2;
        k = j / 2;
      }
    }
    try
    {
      paramBitmap = Bitmap.createBitmap(paramBitmap, k, paramInt, m, m);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      if (QLog.isColorLevel())
      {
        String str = d;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("cutSquareBitmap OOM, e:");
        localStringBuilder.append(paramBitmap);
        QLog.w(str, 2, localStringBuilder.toString());
      }
    }
    return null;
  }
  
  public static byte[] b(Bitmap paramBitmap)
  {
    return BaseImageUtil.d(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.common.util.ImageUtil
 * JD-Core Version:    0.7.0.1
 */