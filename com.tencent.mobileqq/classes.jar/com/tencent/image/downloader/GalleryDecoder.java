package com.tencent.image.downloader;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.tencent.image.DownloadParams;
import com.tencent.image.JpegExifReader;
import com.tencent.image.LocaleFileDownloader;
import com.tencent.image.RoundRectBitmap;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.SafeBitmapFactory.SafeDecodeOption;
import com.tencent.image.SliceBitmap;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.VideoDrawable;
import com.tencent.image.utils.PicFormatUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class GalleryDecoder
  extends LocaleFileDownloader
{
  public static final int DECODE_TYPE_GALLERY = 1;
  public static final int DECODE_TYPE_NORMAL = 0;
  public static final int DECODE_TYPE_NOSAMPLE = 2;
  public static final int DECODE_TYPE_VIDEO = 3;
  private static final int FILE_LENGTH_LIMIT = 5242880;
  private static final float HEIGHER_IMGE_FACTOR = 1.5F;
  private static final String TAG = "GalleryDecoder";
  private float density;
  private Context mContext;
  
  public GalleryDecoder(Context paramContext)
  {
    this.mContext = paramContext;
    this.density = paramContext.getResources().getDisplayMetrics().density;
  }
  
  private int calculateSampleSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (((paramInt6 == 2) || (paramInt3 == 2147483647) || (paramInt4 == 2147483647)) && (paramInt1 * paramInt2 <= this.mContext.getResources().getDisplayMetrics().widthPixels * this.mContext.getResources().getDisplayMetrics().heightPixels * 4))
    {
      paramInt2 = 1;
      return paramInt2;
    }
    float f;
    if (paramInt6 == 1) {
      switch (paramInt5)
      {
      default: 
        paramInt5 = paramInt2;
        paramInt2 = paramInt1;
        paramInt1 = paramInt5;
        paramInt6 = paramInt1;
        paramInt5 = paramInt2;
        if (paramInt2 > paramInt3 * 2)
        {
          paramInt6 = paramInt1;
          paramInt5 = paramInt2;
          if (paramInt1 > paramInt4)
          {
            paramInt5 = (int)(paramInt2 * this.density + 0.5D);
            paramInt6 = (int)(paramInt1 * this.density + 0.5D);
          }
        }
        paramInt1 = paramInt6 * paramInt3 / paramInt5;
        if (paramInt5 >= paramInt3) {
          if (paramInt4 >= paramInt1) {
            f = paramInt3 / paramInt5;
          }
        }
        break;
      }
    }
    for (;;)
    {
      label187:
      if (this.density > 2.0F) {}
      for (paramInt1 = (int)(1.0F / f * 3.0F / 4.0F);; paramInt1 = (int)(1.0F / f))
      {
        if (paramInt1 > 1) {
          break label355;
        }
        return 1;
        break;
        if (paramInt4 * 1.5F >= paramInt1)
        {
          f = paramInt4 / paramInt6;
          break label187;
        }
        f = paramInt3 / paramInt5;
        break label187;
        if (paramInt6 < paramInt4)
        {
          if (paramInt4 >= paramInt1)
          {
            if (paramInt5 * 1.5F < paramInt3) {
              break label519;
            }
            f = paramInt3 / paramInt5;
            break label187;
          }
          if (paramInt6 * 1.5F < paramInt4) {
            break label519;
          }
          f = paramInt4 / paramInt6;
          break label187;
        }
        if ((paramInt6 <= paramInt4) || (paramInt6 >= paramInt4 * 1.5F)) {
          break label519;
        }
        f = paramInt4 / paramInt6;
        break label187;
      }
      label355:
      if (paramInt1 > 64)
      {
        if (QLog.isColorLevel()) {
          QLog.d(getLogTag(), 2, "the pic it fxxking large.....");
        }
        return 64;
      }
      paramInt3 = 64;
      for (;;)
      {
        if (paramInt3 == 0) {
          break label407;
        }
        paramInt4 = paramInt1 & paramInt3;
        paramInt2 = paramInt4;
        if (paramInt4 != 0) {
          break;
        }
        paramInt3 >>= 1;
      }
      label407:
      return 1;
      if ((paramInt3 == 0) || (paramInt4 == 0) || (paramInt3 == -1) || (paramInt4 == -1)) {
        return 1;
      }
      int i = 1;
      paramInt5 = paramInt2;
      paramInt6 = paramInt1;
      paramInt1 = i;
      label443:
      if (paramInt5 <= paramInt4)
      {
        paramInt2 = paramInt1;
        if (paramInt6 <= paramInt3) {
          break;
        }
      }
      i = Math.round(paramInt5 / paramInt4);
      paramInt2 = Math.round(paramInt6 / paramInt3);
      if (i > paramInt2) {}
      for (;;)
      {
        paramInt2 = paramInt1;
        if (i < 2) {
          break;
        }
        paramInt6 /= 2;
        paramInt5 /= 2;
        paramInt1 *= 2;
        break label443;
        i = paramInt2;
      }
      label519:
      f = 1.0F;
    }
  }
  
  private Object decodeFileNormal(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt)
  {
    paramURLDrawableHandler = new FileInputStream(paramFile);
    Object localObject2 = null;
    try
    {
      localObject1 = new byte[2];
      paramURLDrawableHandler.read((byte[])localObject1);
      k = localObject1[0];
      m = localObject1[1];
      paramURLDrawableHandler.close();
      localObject1 = new FileInputStream(paramFile);
    }
    finally
    {
      for (;;)
      {
        int k;
        int m;
        label132:
        BitmapFactory.Options localOptions;
        paramDownloadParams = paramURLDrawableHandler;
        paramInt = 0;
      }
    }
    try
    {
      paramURLDrawableHandler = Bitmap.Config.ARGB_8888;
      i = 0;
      j = 0;
      switch (k << 8 & 0xFF00 | m & 0xFF)
      {
      }
    }
    finally
    {
      paramInt = 0;
      paramDownloadParams = (DownloadParams)localObject1;
      break label731;
      paramURLDrawableHandler = null;
      break label377;
      i = j;
      break label132;
    }
    localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    localOptions.inPreferredConfig = paramURLDrawableHandler;
    localOptions.inDensity = 160;
    localOptions.inTargetDensity = 160;
    localOptions.inScreenDensity = 160;
    SafeBitmapFactory.decodeStream((InputStream)localObject1, null, localOptions);
    j = localOptions.outWidth;
    k = localOptions.outHeight;
    ((InputStream)localObject1).close();
    if (i != 0) {}
    for (;;)
    {
      try
      {
        Bitmap localBitmap;
        for (;;)
        {
          paramDownloadParams.outOrientation = JpegExifReader.readOrientation(paramFile.getAbsolutePath());
          localOptions.inJustDecodeBounds = false;
          paramInt = calculateSampleSize(j, k, paramDownloadParams.reqWidth, paramDownloadParams.reqHeight, paramDownloadParams.outOrientation, paramInt);
          i = 1;
          paramURLDrawableHandler = localObject2;
          if (i <= 3) {}
          try
          {
            localOptions.inSampleSize = paramInt;
            paramURLDrawableHandler = new SafeBitmapFactory.SafeDecodeOption();
            paramURLDrawableHandler.inOptions = localOptions;
            paramURLDrawableHandler.inNeedFlashBackTest = URLDrawable.isPublicVersion;
            localBitmap = SafeBitmapFactory.safeDecode(paramFile.getAbsolutePath(), paramURLDrawableHandler);
            if (QLog.isColorLevel()) {
              QLog.d(getLogTag(), 2, "GalleryDecoder regionDecodeInfo:" + paramURLDrawableHandler.toString());
            }
            reportSafeDecode(paramURLDrawableHandler);
            localBitmap.setDensity(160);
            boolean bool = SliceBitmap.needSliceBitmap(localBitmap);
            if (bool)
            {
              try
              {
                paramURLDrawableHandler = new SliceBitmap(localBitmap);
                localBitmap.recycle();
                label377:
                if (localOptions.inSampleSize > 1)
                {
                  if (!paramDownloadParams.mAutoScaleByDensity) {
                    break label748;
                  }
                  paramDownloadParams.outWidth = ((int)Math.ceil(j * this.density));
                  paramDownloadParams.outHeight = ((int)Math.ceil(k * this.density));
                }
                if (QLog.isColorLevel()) {
                  QLog.d(getLogTag(), 2, "image file size:" + paramFile.length() + " , bound:" + localOptions.outWidth + "x" + localOptions.outHeight + " , sampleSize: " + localOptions.inSampleSize);
                }
                return paramURLDrawableHandler;
              }
              catch (Exception paramURLDrawableHandler)
              {
                if (localBitmap == null) {
                  break label532;
                }
                localBitmap.recycle();
                throw new OutOfMemoryError("slice failed.");
              }
              i = 1;
              paramURLDrawableHandler = Bitmap.Config.RGB_565;
              break;
              ((InputStream)localObject1).close();
              return null;
            }
          }
          catch (OutOfMemoryError paramURLDrawableHandler)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d(getLogTag(), 2, "DecodeFile ERROR,oom retryCount=" + i + ",options.inSampleSize=" + localOptions.inSampleSize + ",url=" + paramDownloadParams.urlStr + ",oom.msg:" + paramURLDrawableHandler.getMessage());
              }
              System.gc();
              Thread.yield();
              System.gc();
              i += 1;
              paramInt *= 2;
              break;
              if ((paramDownloadParams.mExtraInfo == null) || (!GalleryDecoder.DownloadParamsExtraInfo.class.isInstance(paramDownloadParams.mExtraInfo))) {
                break label742;
              }
              paramURLDrawableHandler = (GalleryDecoder.DownloadParamsExtraInfo)paramDownloadParams.mExtraInfo;
              if (paramURLDrawableHandler.mCornerRadius <= 0) {
                break label796;
              }
              RoundRectBitmap localRoundRectBitmap = resizeAndClipBitmap(localBitmap, paramURLDrawableHandler.mCornerRadius);
              paramURLDrawableHandler = localRoundRectBitmap;
              if (!localRoundRectBitmap.mBitmap.equals(localBitmap))
              {
                localBitmap.recycle();
                paramURLDrawableHandler = localRoundRectBitmap;
              }
            }
          }
          catch (NullPointerException paramFile)
          {
            label532:
            paramFile.printStackTrace();
            return null;
          }
        }
        label731:
        paramURLDrawableHandler = localBitmap;
      }
      finally
      {
        paramInt = 1;
        paramDownloadParams = (DownloadParams)localObject1;
        if (paramInt == 0) {
          paramDownloadParams.close();
        }
      }
      label742:
      continue;
      label748:
      double d = j;
      paramDownloadParams.outWidth = ((int)Math.ceil(d));
      paramDownloadParams.outHeight = ((int)Math.ceil(k));
    }
  }
  
  /* Error */
  private Object decodeFileNormalWithTrubo(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: new 95	java/io/FileInputStream
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 98	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   11: astore 13
    //   13: iconst_2
    //   14: newarray byte
    //   16: astore 12
    //   18: aload 13
    //   20: aload 12
    //   22: invokevirtual 104	java/io/InputStream:read	([B)I
    //   25: pop
    //   26: aload 12
    //   28: iconst_0
    //   29: baload
    //   30: istore 9
    //   32: aload 12
    //   34: iconst_1
    //   35: baload
    //   36: istore 10
    //   38: getstatic 113	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   41: astore 12
    //   43: iconst_0
    //   44: istore 7
    //   46: iconst_0
    //   47: istore 8
    //   49: iload 9
    //   51: bipush 8
    //   53: ishl
    //   54: ldc 114
    //   56: iand
    //   57: iload 10
    //   59: sipush 255
    //   62: iand
    //   63: ior
    //   64: lookupswitch	default:+741->805, 8273:+205->269, 16973:+205->269, 18249:+213->277, 18761:+202->266, 19789:+202->266, 65496:+202->266
    //   125: aconst_null
    //   126: fstore_0
    //   127: dup
    //   128: invokespecial 324	com/tencent/mobileqq/pic/JpegOptions:<init>	()V
    //   131: astore 16
    //   133: aload 16
    //   135: iconst_1
    //   136: putfield 325	com/tencent/mobileqq/pic/JpegOptions:inJustDecodeBounds	Z
    //   139: aload 16
    //   141: aload 12
    //   143: putfield 326	com/tencent/mobileqq/pic/JpegOptions:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   146: aload_1
    //   147: invokevirtual 150	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   150: aload 16
    //   152: invokestatic 332	com/tencent/mobileqq/pic/JpegDecompressor:decodeFile	(Ljava/lang/String;Lcom/tencent/mobileqq/pic/JpegOptions;)Landroid/graphics/Bitmap;
    //   155: pop
    //   156: aload 16
    //   158: getfield 333	com/tencent/mobileqq/pic/JpegOptions:outWidth	I
    //   161: istore 9
    //   163: aload 16
    //   165: getfield 334	com/tencent/mobileqq/pic/JpegOptions:outHeight	I
    //   168: istore 10
    //   170: iload 7
    //   172: ifeq +14 -> 186
    //   175: aload_2
    //   176: aload_1
    //   177: invokevirtual 150	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   180: invokestatic 156	com/tencent/image/JpegExifReader:readOrientation	(Ljava/lang/String;)I
    //   183: putfield 161	com/tencent/image/DownloadParams:outOrientation	I
    //   186: aload 16
    //   188: iconst_0
    //   189: putfield 325	com/tencent/mobileqq/pic/JpegOptions:inJustDecodeBounds	Z
    //   192: aload_0
    //   193: iload 9
    //   195: iload 10
    //   197: aload_2
    //   198: getfield 164	com/tencent/image/DownloadParams:reqWidth	I
    //   201: aload_2
    //   202: getfield 167	com/tencent/image/DownloadParams:reqHeight	I
    //   205: aload_2
    //   206: getfield 161	com/tencent/image/DownloadParams:outOrientation	I
    //   209: iload 4
    //   211: invokespecial 169	com/tencent/image/downloader/GalleryDecoder:calculateSampleSize	(IIIIII)I
    //   214: istore 7
    //   216: iconst_1
    //   217: istore 8
    //   219: iload 8
    //   221: iconst_3
    //   222: if_icmpgt +577 -> 799
    //   225: aload 16
    //   227: iload 7
    //   229: putfield 335	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   232: aload_1
    //   233: invokevirtual 150	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   236: aload 16
    //   238: invokestatic 332	com/tencent/mobileqq/pic/JpegDecompressor:decodeFile	(Ljava/lang/String;Lcom/tencent/mobileqq/pic/JpegOptions;)Landroid/graphics/Bitmap;
    //   241: astore 14
    //   243: aload 14
    //   245: ifnonnull +46 -> 291
    //   248: aconst_null
    //   249: astore_2
    //   250: aload_2
    //   251: astore_1
    //   252: aload 13
    //   254: ifnull +10 -> 264
    //   257: aload 13
    //   259: invokevirtual 107	java/io/InputStream:close	()V
    //   262: aload_2
    //   263: astore_1
    //   264: aload_1
    //   265: areturn
    //   266: iconst_1
    //   267: istore 7
    //   269: getstatic 256	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   272: astore 12
    //   274: goto -150 -> 124
    //   277: aconst_null
    //   278: astore_1
    //   279: aload 13
    //   281: ifnull -17 -> 264
    //   284: aload 13
    //   286: invokevirtual 107	java/io/InputStream:close	()V
    //   289: aconst_null
    //   290: areturn
    //   291: aload 14
    //   293: sipush 160
    //   296: invokevirtual 214	android/graphics/Bitmap:setDensity	(I)V
    //   299: aload 14
    //   301: invokestatic 220	com/tencent/image/SliceBitmap:needSliceBitmap	(Landroid/graphics/Bitmap;)Z
    //   304: istore 11
    //   306: iload 11
    //   308: ifeq +285 -> 593
    //   311: new 216	com/tencent/image/SliceBitmap
    //   314: dup
    //   315: aload 14
    //   317: invokespecial 223	com/tencent/image/SliceBitmap:<init>	(Landroid/graphics/Bitmap;)V
    //   320: astore 12
    //   322: aload 14
    //   324: invokevirtual 226	android/graphics/Bitmap:recycle	()V
    //   327: aload 16
    //   329: getfield 335	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   332: iconst_1
    //   333: if_icmple +44 -> 377
    //   336: aload_2
    //   337: getfield 229	com/tencent/image/DownloadParams:mAutoScaleByDensity	Z
    //   340: ifeq +392 -> 732
    //   343: aload_2
    //   344: iload 9
    //   346: i2f
    //   347: aload_0
    //   348: getfield 49	com/tencent/image/downloader/GalleryDecoder:density	F
    //   351: fmul
    //   352: f2d
    //   353: invokestatic 233	java/lang/Math:ceil	(D)D
    //   356: d2i
    //   357: putfield 234	com/tencent/image/DownloadParams:outWidth	I
    //   360: aload_2
    //   361: iload 10
    //   363: i2f
    //   364: aload_0
    //   365: getfield 49	com/tencent/image/downloader/GalleryDecoder:density	F
    //   368: fmul
    //   369: f2d
    //   370: invokestatic 233	java/lang/Math:ceil	(D)D
    //   373: d2i
    //   374: putfield 235	com/tencent/image/DownloadParams:outHeight	I
    //   377: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   380: ifeq +72 -> 452
    //   383: aload_0
    //   384: invokevirtual 73	com/tencent/image/downloader/GalleryDecoder:getLogTag	()Ljava/lang/String;
    //   387: iconst_2
    //   388: new 193	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   395: ldc 237
    //   397: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: aload_1
    //   401: invokevirtual 241	java/io/File:length	()J
    //   404: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   407: ldc 246
    //   409: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: aload 16
    //   414: getfield 333	com/tencent/mobileqq/pic/JpegOptions:outWidth	I
    //   417: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   420: ldc 251
    //   422: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: aload 16
    //   427: getfield 334	com/tencent/mobileqq/pic/JpegOptions:outHeight	I
    //   430: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   433: ldc 253
    //   435: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: aload 16
    //   440: getfield 335	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   443: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   446: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   449: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   452: aload 12
    //   454: astore_1
    //   455: aload 13
    //   457: ifnull -193 -> 264
    //   460: aload 13
    //   462: invokevirtual 107	java/io/InputStream:close	()V
    //   465: aload 12
    //   467: areturn
    //   468: astore 12
    //   470: aload 14
    //   472: ifnull +8 -> 480
    //   475: aload 14
    //   477: invokevirtual 226	android/graphics/Bitmap:recycle	()V
    //   480: new 89	java/lang/OutOfMemoryError
    //   483: dup
    //   484: ldc_w 258
    //   487: invokespecial 261	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   490: athrow
    //   491: astore 12
    //   493: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   496: ifeq +73 -> 569
    //   499: aload_0
    //   500: invokevirtual 73	com/tencent/image/downloader/GalleryDecoder:getLogTag	()Ljava/lang/String;
    //   503: iconst_2
    //   504: new 193	java/lang/StringBuilder
    //   507: dup
    //   508: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   511: ldc_w 263
    //   514: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: iload 8
    //   519: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   522: ldc_w 265
    //   525: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: aload 16
    //   530: getfield 335	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   533: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   536: ldc_w 267
    //   539: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: aload_2
    //   543: getfield 270	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   546: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: ldc_w 272
    //   552: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: aload 12
    //   557: invokevirtual 275	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   560: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   566: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   569: invokestatic 280	java/lang/System:gc	()V
    //   572: invokestatic 285	java/lang/Thread:yield	()V
    //   575: invokestatic 280	java/lang/System:gc	()V
    //   578: iload 8
    //   580: iconst_1
    //   581: iadd
    //   582: istore 8
    //   584: iload 7
    //   586: iconst_2
    //   587: imul
    //   588: istore 7
    //   590: goto -371 -> 219
    //   593: aload_2
    //   594: getfield 289	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   597: ifnull +128 -> 725
    //   600: ldc_w 291
    //   603: aload_2
    //   604: getfield 289	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   607: invokevirtual 297	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   610: ifeq +115 -> 725
    //   613: aload_2
    //   614: getfield 289	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   617: checkcast 291	com/tencent/image/downloader/GalleryDecoder$DownloadParamsExtraInfo
    //   620: astore 12
    //   622: aload 12
    //   624: getfield 300	com/tencent/image/downloader/GalleryDecoder$DownloadParamsExtraInfo:mCornerRadius	I
    //   627: ifle +166 -> 793
    //   630: aload_0
    //   631: aload 14
    //   633: aload 12
    //   635: getfield 300	com/tencent/image/downloader/GalleryDecoder$DownloadParamsExtraInfo:mCornerRadius	I
    //   638: invokevirtual 304	com/tencent/image/downloader/GalleryDecoder:resizeAndClipBitmap	(Landroid/graphics/Bitmap;I)Lcom/tencent/image/RoundRectBitmap;
    //   641: astore 15
    //   643: aload 15
    //   645: astore 12
    //   647: aload 15
    //   649: getfield 310	com/tencent/image/RoundRectBitmap:mBitmap	Landroid/graphics/Bitmap;
    //   652: aload 14
    //   654: invokevirtual 315	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   657: ifne -330 -> 327
    //   660: aload 14
    //   662: invokevirtual 226	android/graphics/Bitmap:recycle	()V
    //   665: aload 15
    //   667: astore 12
    //   669: goto -342 -> 327
    //   672: astore 14
    //   674: aload 13
    //   676: astore 12
    //   678: aload 14
    //   680: astore 13
    //   682: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   685: ifeq +16 -> 701
    //   688: aload_0
    //   689: invokevirtual 73	com/tencent/image/downloader/GalleryDecoder:getLogTag	()Ljava/lang/String;
    //   692: iconst_2
    //   693: ldc_w 337
    //   696: aload 13
    //   698: invokestatic 341	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   701: aload_0
    //   702: aload_1
    //   703: aload_2
    //   704: aload_3
    //   705: iload 4
    //   707: invokespecial 343	com/tencent/image/downloader/GalleryDecoder:decodeFileNormal	(Ljava/io/File;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;I)Ljava/lang/Object;
    //   710: astore_2
    //   711: aload_2
    //   712: astore_1
    //   713: aload 12
    //   715: ifnull -451 -> 264
    //   718: aload 12
    //   720: invokevirtual 107	java/io/InputStream:close	()V
    //   723: aload_2
    //   724: areturn
    //   725: aload 14
    //   727: astore 12
    //   729: goto -402 -> 327
    //   732: iload 9
    //   734: i2d
    //   735: dstore 5
    //   737: aload_2
    //   738: dload 5
    //   740: invokestatic 233	java/lang/Math:ceil	(D)D
    //   743: d2i
    //   744: putfield 234	com/tencent/image/DownloadParams:outWidth	I
    //   747: aload_2
    //   748: iload 10
    //   750: i2d
    //   751: invokestatic 233	java/lang/Math:ceil	(D)D
    //   754: d2i
    //   755: putfield 235	com/tencent/image/DownloadParams:outHeight	I
    //   758: goto -381 -> 377
    //   761: astore_1
    //   762: aload 13
    //   764: astore_2
    //   765: aload_2
    //   766: ifnull +7 -> 773
    //   769: aload_2
    //   770: invokevirtual 107	java/io/InputStream:close	()V
    //   773: aload_1
    //   774: athrow
    //   775: astore_1
    //   776: aconst_null
    //   777: astore_2
    //   778: goto -13 -> 765
    //   781: astore_1
    //   782: aload 12
    //   784: astore_2
    //   785: goto -20 -> 765
    //   788: astore 13
    //   790: goto -108 -> 682
    //   793: aconst_null
    //   794: astore 12
    //   796: goto -469 -> 327
    //   799: aconst_null
    //   800: astore 12
    //   802: goto -475 -> 327
    //   805: iload 8
    //   807: istore 7
    //   809: goto -685 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	812	0	this	GalleryDecoder
    //   0	812	1	paramFile	File
    //   0	812	2	paramDownloadParams	DownloadParams
    //   0	812	3	paramURLDrawableHandler	URLDrawableHandler
    //   0	812	4	paramInt	int
    //   735	4	5	d	double
    //   44	764	7	i	int
    //   47	759	8	j	int
    //   30	703	9	k	int
    //   36	713	10	m	int
    //   304	3	11	bool	boolean
    //   1	465	12	localObject1	Object
    //   468	1	12	localException	Exception
    //   491	65	12	localOutOfMemoryError	OutOfMemoryError
    //   620	181	12	localObject2	Object
    //   11	752	13	localObject3	Object
    //   788	1	13	localRuntimeException1	java.lang.RuntimeException
    //   241	420	14	localBitmap	Bitmap
    //   672	54	14	localRuntimeException2	java.lang.RuntimeException
    //   641	25	15	localRoundRectBitmap	RoundRectBitmap
    //   131	398	16	localJpegOptions	com.tencent.mobileqq.pic.JpegOptions
    // Exception table:
    //   from	to	target	type
    //   311	327	468	java/lang/Exception
    //   225	243	491	java/lang/OutOfMemoryError
    //   291	306	491	java/lang/OutOfMemoryError
    //   311	327	491	java/lang/OutOfMemoryError
    //   475	480	491	java/lang/OutOfMemoryError
    //   480	491	491	java/lang/OutOfMemoryError
    //   593	643	491	java/lang/OutOfMemoryError
    //   647	665	491	java/lang/OutOfMemoryError
    //   13	26	672	java/lang/RuntimeException
    //   38	43	672	java/lang/RuntimeException
    //   124	170	672	java/lang/RuntimeException
    //   175	186	672	java/lang/RuntimeException
    //   186	216	672	java/lang/RuntimeException
    //   225	243	672	java/lang/RuntimeException
    //   269	274	672	java/lang/RuntimeException
    //   291	306	672	java/lang/RuntimeException
    //   311	327	672	java/lang/RuntimeException
    //   327	377	672	java/lang/RuntimeException
    //   377	452	672	java/lang/RuntimeException
    //   475	480	672	java/lang/RuntimeException
    //   480	491	672	java/lang/RuntimeException
    //   493	569	672	java/lang/RuntimeException
    //   569	578	672	java/lang/RuntimeException
    //   593	643	672	java/lang/RuntimeException
    //   647	665	672	java/lang/RuntimeException
    //   737	758	672	java/lang/RuntimeException
    //   13	26	761	finally
    //   38	43	761	finally
    //   124	170	761	finally
    //   175	186	761	finally
    //   186	216	761	finally
    //   225	243	761	finally
    //   269	274	761	finally
    //   291	306	761	finally
    //   311	327	761	finally
    //   327	377	761	finally
    //   377	452	761	finally
    //   475	480	761	finally
    //   480	491	761	finally
    //   493	569	761	finally
    //   569	578	761	finally
    //   593	643	761	finally
    //   647	665	761	finally
    //   737	758	761	finally
    //   3	13	775	finally
    //   682	701	781	finally
    //   701	711	781	finally
    //   3	13	788	java/lang/RuntimeException
  }
  
  /* Error */
  private Object decodeFileWidthByteArray(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt)
  {
    // Byte code:
    //   0: new 95	java/io/FileInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 98	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore 18
    //   10: aconst_null
    //   11: astore 15
    //   13: iconst_0
    //   14: istore 6
    //   16: invokestatic 349	android/os/SystemClock:uptimeMillis	()J
    //   19: lstore 10
    //   21: iconst_2
    //   22: newarray byte
    //   24: astore 16
    //   26: aload 18
    //   28: aload 16
    //   30: invokevirtual 350	java/io/FileInputStream:read	([B)I
    //   33: pop
    //   34: aload 16
    //   36: iconst_0
    //   37: baload
    //   38: istore 8
    //   40: aload 16
    //   42: iconst_1
    //   43: baload
    //   44: istore 9
    //   46: getstatic 113	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   49: astore_3
    //   50: iconst_0
    //   51: istore 5
    //   53: iconst_0
    //   54: istore 7
    //   56: iload 8
    //   58: bipush 8
    //   60: ishl
    //   61: ldc 114
    //   63: iand
    //   64: iload 9
    //   66: sipush 255
    //   69: iand
    //   70: ior
    //   71: lookupswitch	default:+786->857, 8273:+498->569, 16973:+498->569, 18249:+505->576, 18761:+495->566, 19789:+495->566, 65496:+495->566
    //   129: invokevirtual 241	java/io/File:length	()J
    //   132: l2i
    //   133: newarray byte
    //   135: astore 20
    //   137: aload 16
    //   139: iconst_0
    //   140: aload 20
    //   142: iconst_0
    //   143: aload 16
    //   145: arraylength
    //   146: invokestatic 354	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   149: aload 18
    //   151: aload 20
    //   153: aload 16
    //   155: arraylength
    //   156: aload 18
    //   158: invokevirtual 358	java/io/FileInputStream:available	()I
    //   161: invokevirtual 361	java/io/FileInputStream:read	([BII)I
    //   164: pop
    //   165: aload 18
    //   167: invokevirtual 362	java/io/FileInputStream:close	()V
    //   170: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   173: ifeq +40 -> 213
    //   176: invokestatic 349	android/os/SystemClock:uptimeMillis	()J
    //   179: lstore 12
    //   181: aload_0
    //   182: invokevirtual 73	com/tencent/image/downloader/GalleryDecoder:getLogTag	()Ljava/lang/String;
    //   185: iconst_2
    //   186: new 193	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   193: ldc_w 364
    //   196: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: lload 12
    //   201: lload 10
    //   203: lsub
    //   204: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   207: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   213: invokestatic 349	android/os/SystemClock:uptimeMillis	()J
    //   216: lstore 10
    //   218: new 116	android/graphics/BitmapFactory$Options
    //   221: dup
    //   222: invokespecial 117	android/graphics/BitmapFactory$Options:<init>	()V
    //   225: astore 19
    //   227: aload 19
    //   229: iconst_1
    //   230: putfield 121	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   233: aload 19
    //   235: aload_3
    //   236: putfield 124	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   239: aload 19
    //   241: sipush 160
    //   244: putfield 127	android/graphics/BitmapFactory$Options:inDensity	I
    //   247: aload 19
    //   249: sipush 160
    //   252: putfield 130	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   255: aload 19
    //   257: sipush 160
    //   260: putfield 133	android/graphics/BitmapFactory$Options:inScreenDensity	I
    //   263: aload 19
    //   265: iconst_1
    //   266: putfield 367	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   269: aload 19
    //   271: iconst_1
    //   272: putfield 370	android/graphics/BitmapFactory$Options:inInputShareable	Z
    //   275: aload 20
    //   277: iconst_0
    //   278: aload 20
    //   280: arraylength
    //   281: aload 19
    //   283: invokestatic 374	com/tencent/image/SafeBitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   286: pop
    //   287: aload 19
    //   289: getfield 142	android/graphics/BitmapFactory$Options:outWidth	I
    //   292: istore 6
    //   294: aload 19
    //   296: getfield 145	android/graphics/BitmapFactory$Options:outHeight	I
    //   299: istore 7
    //   301: iload 5
    //   303: ifeq +280 -> 583
    //   306: aload_2
    //   307: aload_1
    //   308: invokevirtual 150	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   311: invokestatic 156	com/tencent/image/JpegExifReader:readOrientation	(Ljava/lang/String;)I
    //   314: putfield 161	com/tencent/image/DownloadParams:outOrientation	I
    //   317: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   320: ifeq +40 -> 360
    //   323: invokestatic 349	android/os/SystemClock:uptimeMillis	()J
    //   326: lstore 12
    //   328: aload_0
    //   329: invokevirtual 73	com/tencent/image/downloader/GalleryDecoder:getLogTag	()Ljava/lang/String;
    //   332: iconst_2
    //   333: new 193	java/lang/StringBuilder
    //   336: dup
    //   337: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   340: ldc_w 376
    //   343: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: lload 12
    //   348: lload 10
    //   350: lsub
    //   351: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   354: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   360: aload 19
    //   362: iconst_0
    //   363: putfield 121	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   366: aload_0
    //   367: iload 6
    //   369: iload 7
    //   371: aload_2
    //   372: getfield 164	com/tencent/image/DownloadParams:reqWidth	I
    //   375: aload_2
    //   376: getfield 167	com/tencent/image/DownloadParams:reqHeight	I
    //   379: aload_2
    //   380: getfield 161	com/tencent/image/DownloadParams:outOrientation	I
    //   383: iload 4
    //   385: invokespecial 169	com/tencent/image/downloader/GalleryDecoder:calculateSampleSize	(IIIIII)I
    //   388: istore 4
    //   390: aload 19
    //   392: iload 4
    //   394: putfield 172	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   397: aload 20
    //   399: iconst_0
    //   400: aload 20
    //   402: arraylength
    //   403: aload 19
    //   405: invokestatic 374	com/tencent/image/SafeBitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   408: astore 16
    //   410: aload 16
    //   412: sipush 160
    //   415: invokevirtual 214	android/graphics/Bitmap:setDensity	(I)V
    //   418: aload 16
    //   420: invokestatic 220	com/tencent/image/SliceBitmap:needSliceBitmap	(Landroid/graphics/Bitmap;)Z
    //   423: istore 14
    //   425: iload 14
    //   427: ifeq +311 -> 738
    //   430: new 216	com/tencent/image/SliceBitmap
    //   433: dup
    //   434: aload 16
    //   436: invokespecial 223	com/tencent/image/SliceBitmap:<init>	(Landroid/graphics/Bitmap;)V
    //   439: astore_3
    //   440: aload 16
    //   442: invokevirtual 226	android/graphics/Bitmap:recycle	()V
    //   445: aload 19
    //   447: getfield 172	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   450: iconst_1
    //   451: if_icmple +44 -> 495
    //   454: aload_2
    //   455: getfield 229	com/tencent/image/DownloadParams:mAutoScaleByDensity	Z
    //   458: ifeq +361 -> 819
    //   461: aload_2
    //   462: iload 6
    //   464: i2f
    //   465: aload_0
    //   466: getfield 49	com/tencent/image/downloader/GalleryDecoder:density	F
    //   469: fmul
    //   470: f2d
    //   471: invokestatic 233	java/lang/Math:ceil	(D)D
    //   474: d2i
    //   475: putfield 234	com/tencent/image/DownloadParams:outWidth	I
    //   478: aload_2
    //   479: iload 7
    //   481: i2f
    //   482: aload_0
    //   483: getfield 49	com/tencent/image/downloader/GalleryDecoder:density	F
    //   486: fmul
    //   487: f2d
    //   488: invokestatic 233	java/lang/Math:ceil	(D)D
    //   491: d2i
    //   492: putfield 235	com/tencent/image/DownloadParams:outHeight	I
    //   495: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   498: ifeq +66 -> 564
    //   501: aload_0
    //   502: invokevirtual 73	com/tencent/image/downloader/GalleryDecoder:getLogTag	()Ljava/lang/String;
    //   505: iconst_2
    //   506: new 193	java/lang/StringBuilder
    //   509: dup
    //   510: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   513: ldc 237
    //   515: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: aload_1
    //   519: invokevirtual 241	java/io/File:length	()J
    //   522: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   525: ldc 246
    //   527: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: iload 6
    //   532: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   535: ldc 251
    //   537: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: iload 7
    //   542: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   545: ldc 253
    //   547: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: aload 19
    //   552: getfield 172	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   555: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   558: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   561: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   564: aload_3
    //   565: areturn
    //   566: iconst_1
    //   567: istore 5
    //   569: getstatic 256	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   572: astore_3
    //   573: goto -445 -> 128
    //   576: aload 18
    //   578: invokevirtual 362	java/io/FileInputStream:close	()V
    //   581: aconst_null
    //   582: areturn
    //   583: aload_2
    //   584: aload_1
    //   585: invokevirtual 150	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   588: invokestatic 381	com/tencent/image/Utils:getHeifOrientation	(Ljava/lang/String;)I
    //   591: putfield 161	com/tencent/image/DownloadParams:outOrientation	I
    //   594: goto -277 -> 317
    //   597: astore_1
    //   598: iconst_1
    //   599: istore 4
    //   601: iload 4
    //   603: ifne +8 -> 611
    //   606: aload 18
    //   608: invokevirtual 362	java/io/FileInputStream:close	()V
    //   611: aload_1
    //   612: athrow
    //   613: astore_3
    //   614: aload 16
    //   616: ifnull +8 -> 624
    //   619: aload 16
    //   621: invokevirtual 226	android/graphics/Bitmap:recycle	()V
    //   624: new 89	java/lang/OutOfMemoryError
    //   627: dup
    //   628: ldc_w 258
    //   631: invokespecial 261	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   634: athrow
    //   635: astore_3
    //   636: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   639: ifeq +71 -> 710
    //   642: aload_0
    //   643: invokevirtual 73	com/tencent/image/downloader/GalleryDecoder:getLogTag	()Ljava/lang/String;
    //   646: iconst_2
    //   647: new 193	java/lang/StringBuilder
    //   650: dup
    //   651: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   654: ldc_w 263
    //   657: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: iconst_1
    //   661: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   664: ldc_w 265
    //   667: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: aload 19
    //   672: getfield 172	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   675: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   678: ldc_w 267
    //   681: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: aload_2
    //   685: getfield 270	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   688: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: ldc_w 272
    //   694: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: aload_3
    //   698: invokevirtual 275	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   701: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   707: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   710: iload 4
    //   712: iconst_2
    //   713: imul
    //   714: istore 4
    //   716: invokestatic 280	java/lang/System:gc	()V
    //   719: invokestatic 285	java/lang/Thread:yield	()V
    //   722: invokestatic 280	java/lang/System:gc	()V
    //   725: aload 15
    //   727: astore_3
    //   728: iload 4
    //   730: bipush 8
    //   732: if_icmple -287 -> 445
    //   735: goto -345 -> 390
    //   738: aload_2
    //   739: getfield 289	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   742: ifnull +122 -> 864
    //   745: ldc_w 291
    //   748: aload_2
    //   749: getfield 289	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   752: invokevirtual 297	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   755: ifeq +109 -> 864
    //   758: aload_2
    //   759: getfield 289	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   762: checkcast 291	com/tencent/image/downloader/GalleryDecoder$DownloadParamsExtraInfo
    //   765: astore_3
    //   766: aload_3
    //   767: getfield 300	com/tencent/image/downloader/GalleryDecoder$DownloadParamsExtraInfo:mCornerRadius	I
    //   770: ifle +82 -> 852
    //   773: aload_0
    //   774: aload 16
    //   776: aload_3
    //   777: getfield 300	com/tencent/image/downloader/GalleryDecoder$DownloadParamsExtraInfo:mCornerRadius	I
    //   780: invokevirtual 304	com/tencent/image/downloader/GalleryDecoder:resizeAndClipBitmap	(Landroid/graphics/Bitmap;I)Lcom/tencent/image/RoundRectBitmap;
    //   783: astore 17
    //   785: aload 17
    //   787: astore_3
    //   788: aload 17
    //   790: getfield 310	com/tencent/image/RoundRectBitmap:mBitmap	Landroid/graphics/Bitmap;
    //   793: aload 16
    //   795: invokevirtual 315	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   798: ifne -353 -> 445
    //   801: aload 16
    //   803: invokevirtual 226	android/graphics/Bitmap:recycle	()V
    //   806: aload 17
    //   808: astore_3
    //   809: goto -364 -> 445
    //   812: astore_1
    //   813: aload_1
    //   814: invokevirtual 318	java/lang/NullPointerException:printStackTrace	()V
    //   817: aconst_null
    //   818: areturn
    //   819: aload_2
    //   820: iload 6
    //   822: i2d
    //   823: invokestatic 233	java/lang/Math:ceil	(D)D
    //   826: d2i
    //   827: putfield 234	com/tencent/image/DownloadParams:outWidth	I
    //   830: aload_2
    //   831: iload 7
    //   833: i2d
    //   834: invokestatic 233	java/lang/Math:ceil	(D)D
    //   837: d2i
    //   838: putfield 235	com/tencent/image/DownloadParams:outHeight	I
    //   841: goto -346 -> 495
    //   844: astore_1
    //   845: iload 6
    //   847: istore 4
    //   849: goto -248 -> 601
    //   852: aconst_null
    //   853: astore_3
    //   854: goto -409 -> 445
    //   857: iload 7
    //   859: istore 5
    //   861: goto -733 -> 128
    //   864: aload 16
    //   866: astore_3
    //   867: goto -422 -> 445
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	870	0	this	GalleryDecoder
    //   0	870	1	paramFile	File
    //   0	870	2	paramDownloadParams	DownloadParams
    //   0	870	3	paramURLDrawableHandler	URLDrawableHandler
    //   0	870	4	paramInt	int
    //   51	809	5	i	int
    //   14	832	6	j	int
    //   54	804	7	k	int
    //   38	23	8	m	int
    //   44	26	9	n	int
    //   19	330	10	l1	long
    //   179	168	12	l2	long
    //   423	3	14	bool	boolean
    //   11	715	15	localObject1	Object
    //   24	841	16	localObject2	Object
    //   783	24	17	localRoundRectBitmap	RoundRectBitmap
    //   8	599	18	localFileInputStream	FileInputStream
    //   225	446	19	localOptions	BitmapFactory.Options
    //   135	266	20	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   170	213	597	finally
    //   213	301	597	finally
    //   306	317	597	finally
    //   317	360	597	finally
    //   360	390	597	finally
    //   390	425	597	finally
    //   430	445	597	finally
    //   445	495	597	finally
    //   495	564	597	finally
    //   583	594	597	finally
    //   619	624	597	finally
    //   624	635	597	finally
    //   636	710	597	finally
    //   716	725	597	finally
    //   738	785	597	finally
    //   788	806	597	finally
    //   813	817	597	finally
    //   819	841	597	finally
    //   430	445	613	java/lang/Exception
    //   390	425	635	java/lang/OutOfMemoryError
    //   430	445	635	java/lang/OutOfMemoryError
    //   619	624	635	java/lang/OutOfMemoryError
    //   624	635	635	java/lang/OutOfMemoryError
    //   738	785	635	java/lang/OutOfMemoryError
    //   788	806	635	java/lang/OutOfMemoryError
    //   390	425	812	java/lang/NullPointerException
    //   430	445	812	java/lang/NullPointerException
    //   619	624	812	java/lang/NullPointerException
    //   624	635	812	java/lang/NullPointerException
    //   738	785	812	java/lang/NullPointerException
    //   788	806	812	java/lang/NullPointerException
    //   16	34	844	finally
    //   46	50	844	finally
    //   128	170	844	finally
    //   569	573	844	finally
  }
  
  /* Error */
  private Object decodeFileWidthByteArrayWithTrubo(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt)
  {
    // Byte code:
    //   0: new 95	java/io/FileInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 98	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore 19
    //   10: iconst_0
    //   11: istore 8
    //   13: iconst_0
    //   14: istore 7
    //   16: iload 8
    //   18: istore 5
    //   20: invokestatic 349	android/os/SystemClock:uptimeMillis	()J
    //   23: lstore 11
    //   25: iload 8
    //   27: istore 5
    //   29: iconst_2
    //   30: newarray byte
    //   32: astore 17
    //   34: iload 8
    //   36: istore 5
    //   38: aload 19
    //   40: aload 17
    //   42: invokevirtual 350	java/io/FileInputStream:read	([B)I
    //   45: pop
    //   46: aload 17
    //   48: iconst_0
    //   49: baload
    //   50: istore 9
    //   52: aload 17
    //   54: iconst_1
    //   55: baload
    //   56: istore 10
    //   58: iload 8
    //   60: istore 5
    //   62: getstatic 113	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   65: astore 16
    //   67: iconst_0
    //   68: istore 6
    //   70: iconst_0
    //   71: istore 5
    //   73: iload 9
    //   75: bipush 8
    //   77: ishl
    //   78: ldc 114
    //   80: iand
    //   81: iload 10
    //   83: sipush 255
    //   86: iand
    //   87: ior
    //   88: lookupswitch	default:+855->943, 8273:+329->417, 16973:+329->417, 18249:+341->429, 18761:+326->414, 19789:+326->414, 65496:+326->414
    //   149: iconst_5
    //   150: istore 5
    //   152: aload_1
    //   153: invokevirtual 241	java/io/File:length	()J
    //   156: l2i
    //   157: newarray byte
    //   159: astore 21
    //   161: iload 8
    //   163: istore 5
    //   165: aload 17
    //   167: iconst_0
    //   168: aload 21
    //   170: iconst_0
    //   171: aload 17
    //   173: arraylength
    //   174: invokestatic 354	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   177: iload 8
    //   179: istore 5
    //   181: aload 19
    //   183: aload 21
    //   185: aload 17
    //   187: arraylength
    //   188: aload 19
    //   190: invokevirtual 358	java/io/FileInputStream:available	()I
    //   193: invokevirtual 361	java/io/FileInputStream:read	([BII)I
    //   196: pop
    //   197: iload 8
    //   199: istore 5
    //   201: aload 19
    //   203: invokevirtual 362	java/io/FileInputStream:close	()V
    //   206: iconst_1
    //   207: istore 7
    //   209: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   212: ifeq +40 -> 252
    //   215: invokestatic 349	android/os/SystemClock:uptimeMillis	()J
    //   218: lstore 13
    //   220: aload_0
    //   221: invokevirtual 73	com/tencent/image/downloader/GalleryDecoder:getLogTag	()Ljava/lang/String;
    //   224: iconst_2
    //   225: new 193	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   232: ldc_w 364
    //   235: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: lload 13
    //   240: lload 11
    //   242: lsub
    //   243: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   246: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   252: invokestatic 349	android/os/SystemClock:uptimeMillis	()J
    //   255: lstore 11
    //   257: new 323	com/tencent/mobileqq/pic/JpegOptions
    //   260: dup
    //   261: invokespecial 324	com/tencent/mobileqq/pic/JpegOptions:<init>	()V
    //   264: astore 20
    //   266: aload 20
    //   268: iconst_1
    //   269: putfield 325	com/tencent/mobileqq/pic/JpegOptions:inJustDecodeBounds	Z
    //   272: aload 20
    //   274: aload 16
    //   276: putfield 326	com/tencent/mobileqq/pic/JpegOptions:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   279: aload 21
    //   281: aload 20
    //   283: invokestatic 385	com/tencent/mobileqq/pic/JpegDecompressor:decodeByteArray	([BLcom/tencent/mobileqq/pic/JpegOptions;)Landroid/graphics/Bitmap;
    //   286: pop
    //   287: aload 20
    //   289: getfield 333	com/tencent/mobileqq/pic/JpegOptions:outWidth	I
    //   292: istore 8
    //   294: aload 20
    //   296: getfield 334	com/tencent/mobileqq/pic/JpegOptions:outHeight	I
    //   299: istore 9
    //   301: iload 6
    //   303: ifeq +14 -> 317
    //   306: aload_2
    //   307: aload_1
    //   308: invokevirtual 150	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   311: invokestatic 156	com/tencent/image/JpegExifReader:readOrientation	(Ljava/lang/String;)I
    //   314: putfield 161	com/tencent/image/DownloadParams:outOrientation	I
    //   317: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   320: ifeq +40 -> 360
    //   323: invokestatic 349	android/os/SystemClock:uptimeMillis	()J
    //   326: lstore 13
    //   328: aload_0
    //   329: invokevirtual 73	com/tencent/image/downloader/GalleryDecoder:getLogTag	()Ljava/lang/String;
    //   332: iconst_2
    //   333: new 193	java/lang/StringBuilder
    //   336: dup
    //   337: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   340: ldc_w 376
    //   343: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: lload 13
    //   348: lload 11
    //   350: lsub
    //   351: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   354: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   360: aload 20
    //   362: iconst_0
    //   363: putfield 325	com/tencent/mobileqq/pic/JpegOptions:inJustDecodeBounds	Z
    //   366: aload_0
    //   367: iload 8
    //   369: iload 9
    //   371: aload_2
    //   372: getfield 164	com/tencent/image/DownloadParams:reqWidth	I
    //   375: aload_2
    //   376: getfield 167	com/tencent/image/DownloadParams:reqHeight	I
    //   379: aload_2
    //   380: getfield 161	com/tencent/image/DownloadParams:outOrientation	I
    //   383: iload 4
    //   385: invokespecial 169	com/tencent/image/downloader/GalleryDecoder:calculateSampleSize	(IIIIII)I
    //   388: istore 5
    //   390: aload 20
    //   392: iload 5
    //   394: putfield 335	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   397: aload 21
    //   399: aload 20
    //   401: invokestatic 385	com/tencent/mobileqq/pic/JpegDecompressor:decodeByteArray	([BLcom/tencent/mobileqq/pic/JpegOptions;)Landroid/graphics/Bitmap;
    //   404: astore 17
    //   406: aload 17
    //   408: ifnonnull +28 -> 436
    //   411: aload 17
    //   413: areturn
    //   414: iconst_1
    //   415: istore 6
    //   417: iload 8
    //   419: istore 5
    //   421: getstatic 256	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   424: astore 16
    //   426: goto -278 -> 148
    //   429: aload 19
    //   431: invokevirtual 362	java/io/FileInputStream:close	()V
    //   434: aconst_null
    //   435: areturn
    //   436: aload 17
    //   438: sipush 160
    //   441: invokevirtual 214	android/graphics/Bitmap:setDensity	(I)V
    //   444: aload 17
    //   446: invokestatic 220	com/tencent/image/SliceBitmap:needSliceBitmap	(Landroid/graphics/Bitmap;)Z
    //   449: istore 15
    //   451: iload 15
    //   453: ifeq +334 -> 787
    //   456: new 216	com/tencent/image/SliceBitmap
    //   459: dup
    //   460: aload 17
    //   462: invokespecial 223	com/tencent/image/SliceBitmap:<init>	(Landroid/graphics/Bitmap;)V
    //   465: astore 16
    //   467: aload 17
    //   469: invokevirtual 226	android/graphics/Bitmap:recycle	()V
    //   472: aload 20
    //   474: getfield 335	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   477: iconst_1
    //   478: if_icmple +44 -> 522
    //   481: aload_2
    //   482: getfield 229	com/tencent/image/DownloadParams:mAutoScaleByDensity	Z
    //   485: ifeq +390 -> 875
    //   488: aload_2
    //   489: iload 8
    //   491: i2f
    //   492: aload_0
    //   493: getfield 49	com/tencent/image/downloader/GalleryDecoder:density	F
    //   496: fmul
    //   497: f2d
    //   498: invokestatic 233	java/lang/Math:ceil	(D)D
    //   501: d2i
    //   502: putfield 234	com/tencent/image/DownloadParams:outWidth	I
    //   505: aload_2
    //   506: iload 9
    //   508: i2f
    //   509: aload_0
    //   510: getfield 49	com/tencent/image/downloader/GalleryDecoder:density	F
    //   513: fmul
    //   514: f2d
    //   515: invokestatic 233	java/lang/Math:ceil	(D)D
    //   518: d2i
    //   519: putfield 235	com/tencent/image/DownloadParams:outHeight	I
    //   522: aload 16
    //   524: astore 17
    //   526: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   529: ifeq -118 -> 411
    //   532: aload_0
    //   533: invokevirtual 73	com/tencent/image/downloader/GalleryDecoder:getLogTag	()Ljava/lang/String;
    //   536: iconst_2
    //   537: new 193	java/lang/StringBuilder
    //   540: dup
    //   541: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   544: ldc 237
    //   546: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: aload_1
    //   550: invokevirtual 241	java/io/File:length	()J
    //   553: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   556: ldc 246
    //   558: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: iload 8
    //   563: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   566: ldc 251
    //   568: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: iload 9
    //   573: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   576: ldc 253
    //   578: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: aload 20
    //   583: getfield 335	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   586: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   589: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   592: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   595: aload 16
    //   597: areturn
    //   598: astore 16
    //   600: iconst_1
    //   601: istore 6
    //   603: iload 6
    //   605: istore 5
    //   607: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   610: ifeq +20 -> 630
    //   613: iload 6
    //   615: istore 5
    //   617: aload_0
    //   618: invokevirtual 73	com/tencent/image/downloader/GalleryDecoder:getLogTag	()Ljava/lang/String;
    //   621: iconst_2
    //   622: ldc_w 387
    //   625: aload 16
    //   627: invokestatic 341	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   630: iload 6
    //   632: istore 5
    //   634: aload_0
    //   635: aload_1
    //   636: aload_2
    //   637: aload_3
    //   638: iload 4
    //   640: invokespecial 389	com/tencent/image/downloader/GalleryDecoder:decodeFileWidthByteArray	(Ljava/io/File;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;I)Ljava/lang/Object;
    //   643: astore_1
    //   644: aload_1
    //   645: astore 17
    //   647: iload 6
    //   649: ifne -238 -> 411
    //   652: aload 19
    //   654: invokevirtual 362	java/io/FileInputStream:close	()V
    //   657: aload_1
    //   658: areturn
    //   659: astore 16
    //   661: aload 17
    //   663: ifnull +8 -> 671
    //   666: aload 17
    //   668: invokevirtual 226	android/graphics/Bitmap:recycle	()V
    //   671: new 89	java/lang/OutOfMemoryError
    //   674: dup
    //   675: ldc_w 258
    //   678: invokespecial 261	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   681: athrow
    //   682: astore 16
    //   684: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   687: ifeq +72 -> 759
    //   690: aload_0
    //   691: invokevirtual 73	com/tencent/image/downloader/GalleryDecoder:getLogTag	()Ljava/lang/String;
    //   694: iconst_2
    //   695: new 193	java/lang/StringBuilder
    //   698: dup
    //   699: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   702: ldc_w 263
    //   705: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   708: iconst_1
    //   709: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   712: ldc_w 265
    //   715: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: aload 20
    //   720: getfield 335	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   723: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   726: ldc_w 267
    //   729: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   732: aload_2
    //   733: getfield 270	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   736: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   739: ldc_w 272
    //   742: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   745: aload 16
    //   747: invokevirtual 275	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   750: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   753: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   756: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   759: iload 5
    //   761: iconst_2
    //   762: imul
    //   763: istore 5
    //   765: invokestatic 280	java/lang/System:gc	()V
    //   768: invokestatic 285	java/lang/Thread:yield	()V
    //   771: invokestatic 280	java/lang/System:gc	()V
    //   774: iload 5
    //   776: bipush 8
    //   778: if_icmplt +156 -> 934
    //   781: aconst_null
    //   782: astore 16
    //   784: goto -312 -> 472
    //   787: aload_2
    //   788: getfield 289	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   791: ifnull +159 -> 950
    //   794: ldc_w 291
    //   797: aload_2
    //   798: getfield 289	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   801: invokevirtual 297	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   804: ifeq +146 -> 950
    //   807: aload_2
    //   808: getfield 289	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   811: checkcast 291	com/tencent/image/downloader/GalleryDecoder$DownloadParamsExtraInfo
    //   814: astore 16
    //   816: aload 16
    //   818: getfield 300	com/tencent/image/downloader/GalleryDecoder$DownloadParamsExtraInfo:mCornerRadius	I
    //   821: ifle +116 -> 937
    //   824: aload_0
    //   825: aload 17
    //   827: aload 16
    //   829: getfield 300	com/tencent/image/downloader/GalleryDecoder$DownloadParamsExtraInfo:mCornerRadius	I
    //   832: invokevirtual 304	com/tencent/image/downloader/GalleryDecoder:resizeAndClipBitmap	(Landroid/graphics/Bitmap;I)Lcom/tencent/image/RoundRectBitmap;
    //   835: astore 18
    //   837: aload 18
    //   839: astore 16
    //   841: aload 18
    //   843: getfield 310	com/tencent/image/RoundRectBitmap:mBitmap	Landroid/graphics/Bitmap;
    //   846: aload 17
    //   848: invokevirtual 315	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   851: ifne -379 -> 472
    //   854: aload 17
    //   856: invokevirtual 226	android/graphics/Bitmap:recycle	()V
    //   859: aload 18
    //   861: astore 16
    //   863: goto -391 -> 472
    //   866: astore 16
    //   868: aload 16
    //   870: invokevirtual 318	java/lang/NullPointerException:printStackTrace	()V
    //   873: aconst_null
    //   874: areturn
    //   875: aload_2
    //   876: iload 8
    //   878: i2d
    //   879: invokestatic 233	java/lang/Math:ceil	(D)D
    //   882: d2i
    //   883: putfield 234	com/tencent/image/DownloadParams:outWidth	I
    //   886: aload_2
    //   887: iload 9
    //   889: i2d
    //   890: invokestatic 233	java/lang/Math:ceil	(D)D
    //   893: d2i
    //   894: putfield 235	com/tencent/image/DownloadParams:outHeight	I
    //   897: goto -375 -> 522
    //   900: astore_1
    //   901: iload 7
    //   903: istore 4
    //   905: iload 4
    //   907: ifne +8 -> 915
    //   910: aload 19
    //   912: invokevirtual 362	java/io/FileInputStream:close	()V
    //   915: aload_1
    //   916: athrow
    //   917: astore_1
    //   918: iload 5
    //   920: istore 4
    //   922: goto -17 -> 905
    //   925: astore 16
    //   927: iload 7
    //   929: istore 6
    //   931: goto -328 -> 603
    //   934: goto -544 -> 390
    //   937: aconst_null
    //   938: astore 16
    //   940: goto -468 -> 472
    //   943: iload 5
    //   945: istore 6
    //   947: goto -799 -> 148
    //   950: aload 17
    //   952: astore 16
    //   954: goto -482 -> 472
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	957	0	this	GalleryDecoder
    //   0	957	1	paramFile	File
    //   0	957	2	paramDownloadParams	DownloadParams
    //   0	957	3	paramURLDrawableHandler	URLDrawableHandler
    //   0	957	4	paramInt	int
    //   18	926	5	i	int
    //   68	878	6	j	int
    //   14	914	7	k	int
    //   11	866	8	m	int
    //   50	838	9	n	int
    //   56	31	10	i1	int
    //   23	326	11	l1	long
    //   218	129	13	l2	long
    //   449	3	15	bool	boolean
    //   65	531	16	localObject1	Object
    //   598	28	16	localRuntimeException1	java.lang.RuntimeException
    //   659	1	16	localException	Exception
    //   682	64	16	localOutOfMemoryError	OutOfMemoryError
    //   782	80	16	localObject2	Object
    //   866	3	16	localNullPointerException	NullPointerException
    //   925	1	16	localRuntimeException2	java.lang.RuntimeException
    //   938	15	16	localObject3	Object
    //   32	919	17	localObject4	Object
    //   835	25	18	localRoundRectBitmap	RoundRectBitmap
    //   8	903	19	localFileInputStream	FileInputStream
    //   264	455	20	localJpegOptions	com.tencent.mobileqq.pic.JpegOptions
    //   159	239	21	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   209	252	598	java/lang/RuntimeException
    //   252	301	598	java/lang/RuntimeException
    //   306	317	598	java/lang/RuntimeException
    //   317	360	598	java/lang/RuntimeException
    //   360	390	598	java/lang/RuntimeException
    //   390	406	598	java/lang/RuntimeException
    //   436	451	598	java/lang/RuntimeException
    //   456	472	598	java/lang/RuntimeException
    //   472	522	598	java/lang/RuntimeException
    //   526	595	598	java/lang/RuntimeException
    //   666	671	598	java/lang/RuntimeException
    //   671	682	598	java/lang/RuntimeException
    //   684	759	598	java/lang/RuntimeException
    //   765	774	598	java/lang/RuntimeException
    //   787	837	598	java/lang/RuntimeException
    //   841	859	598	java/lang/RuntimeException
    //   868	873	598	java/lang/RuntimeException
    //   875	897	598	java/lang/RuntimeException
    //   456	472	659	java/lang/Exception
    //   390	406	682	java/lang/OutOfMemoryError
    //   436	451	682	java/lang/OutOfMemoryError
    //   456	472	682	java/lang/OutOfMemoryError
    //   666	671	682	java/lang/OutOfMemoryError
    //   671	682	682	java/lang/OutOfMemoryError
    //   787	837	682	java/lang/OutOfMemoryError
    //   841	859	682	java/lang/OutOfMemoryError
    //   390	406	866	java/lang/NullPointerException
    //   436	451	866	java/lang/NullPointerException
    //   456	472	866	java/lang/NullPointerException
    //   666	671	866	java/lang/NullPointerException
    //   671	682	866	java/lang/NullPointerException
    //   787	837	866	java/lang/NullPointerException
    //   841	859	866	java/lang/NullPointerException
    //   209	252	900	finally
    //   252	301	900	finally
    //   306	317	900	finally
    //   317	360	900	finally
    //   360	390	900	finally
    //   390	406	900	finally
    //   436	451	900	finally
    //   456	472	900	finally
    //   472	522	900	finally
    //   526	595	900	finally
    //   666	671	900	finally
    //   671	682	900	finally
    //   684	759	900	finally
    //   765	774	900	finally
    //   787	837	900	finally
    //   841	859	900	finally
    //   868	873	900	finally
    //   875	897	900	finally
    //   20	25	917	finally
    //   29	34	917	finally
    //   38	46	917	finally
    //   62	67	917	finally
    //   152	161	917	finally
    //   165	177	917	finally
    //   181	197	917	finally
    //   201	206	917	finally
    //   421	426	917	finally
    //   607	613	917	finally
    //   617	630	917	finally
    //   634	644	917	finally
    //   20	25	925	java/lang/RuntimeException
    //   29	34	925	java/lang/RuntimeException
    //   38	46	925	java/lang/RuntimeException
    //   62	67	925	java/lang/RuntimeException
    //   152	161	925	java/lang/RuntimeException
    //   165	177	925	java/lang/RuntimeException
    //   181	197	925	java/lang/RuntimeException
    //   201	206	925	java/lang/RuntimeException
    //   421	426	925	java/lang/RuntimeException
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    long l1 = SystemClock.uptimeMillis();
    try
    {
      if (VideoDrawable.isVideo(paramFile))
      {
        paramURLDrawableHandler = decodeVideo(paramFile, paramDownloadParams, paramURLDrawableHandler);
        paramDownloadParams = paramURLDrawableHandler;
        if (QLog.isColorLevel())
        {
          l2 = SystemClock.uptimeMillis();
          QLog.d(getLogTag(), 2, "decode file:" + paramFile.getAbsolutePath() + " cost: " + (l2 - l1));
          paramDownloadParams = paramURLDrawableHandler;
        }
        return paramDownloadParams;
      }
      l2 = paramFile.length();
      int i = 0;
      if (paramDownloadParams.tag != null) {
        i = ((Integer)paramDownloadParams.tag).intValue();
      }
      if ((useJpegTurbo()) && (PicFormatUtils.isJPEGImage(paramFile.getAbsolutePath())))
      {
        if (l2 < 5242880L)
        {
          paramURLDrawableHandler = decodeFileWidthByteArrayWithTrubo(paramFile, paramDownloadParams, paramURLDrawableHandler, i);
          paramDownloadParams = paramURLDrawableHandler;
          return paramURLDrawableHandler;
        }
        paramURLDrawableHandler = decodeFileNormalWithTrubo(paramFile, paramDownloadParams, paramURLDrawableHandler, i);
        paramDownloadParams = paramURLDrawableHandler;
        return paramURLDrawableHandler;
      }
      if (l2 < 5242880L)
      {
        paramURLDrawableHandler = decodeFileWidthByteArray(paramFile, paramDownloadParams, paramURLDrawableHandler, i);
        paramDownloadParams = paramURLDrawableHandler;
        return paramURLDrawableHandler;
      }
      paramURLDrawableHandler = decodeFileNormal(paramFile, paramDownloadParams, paramURLDrawableHandler, i);
      paramDownloadParams = paramURLDrawableHandler;
      return paramURLDrawableHandler;
    }
    finally
    {
      long l2;
      if (QLog.isColorLevel())
      {
        l2 = SystemClock.uptimeMillis();
        QLog.d(getLogTag(), 2, "decode file:" + paramFile.getAbsolutePath() + " cost: " + (l2 - l1));
      }
    }
  }
  
  protected Object decodeVideo(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return null;
  }
  
  protected String getLogTag()
  {
    return "GalleryDecoder";
  }
  
  protected void reportSafeDecode(SafeBitmapFactory.SafeDecodeOption paramSafeDecodeOption) {}
  
  protected RoundRectBitmap resizeAndClipBitmap(Bitmap paramBitmap, int paramInt)
  {
    return new RoundRectBitmap(paramBitmap, paramInt);
  }
  
  protected boolean useJpegTurbo()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.downloader.GalleryDecoder
 * JD-Core Version:    0.7.0.1
 */