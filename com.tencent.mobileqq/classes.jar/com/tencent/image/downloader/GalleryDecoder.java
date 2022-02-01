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
import com.tencent.image.api.ILog;
import com.tencent.image.api.IVersion;
import com.tencent.image.api.URLDrawableDepWrap;
import com.tencent.image.utils.PicFormatUtils;
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
              break label535;
            }
            f = paramInt3 / paramInt5;
            break label187;
          }
          if (paramInt6 * 1.5F < paramInt4) {
            break label535;
          }
          f = paramInt4 / paramInt6;
          break label187;
        }
        if ((paramInt6 <= paramInt4) || (paramInt6 >= paramInt4 * 1.5F)) {
          break label535;
        }
        f = paramInt4 / paramInt6;
        break label187;
      }
      label355:
      if (paramInt1 > 64)
      {
        if (URLDrawable.depImp.mLog.isColorLevel()) {
          URLDrawable.depImp.mLog.d(getLogTag(), 2, "the pic it fxxking large.....");
        }
        return 64;
      }
      paramInt3 = 64;
      for (;;)
      {
        if (paramInt3 == 0) {
          break label423;
        }
        paramInt4 = paramInt1 & paramInt3;
        paramInt2 = paramInt4;
        if (paramInt4 != 0) {
          break;
        }
        paramInt3 >>= 1;
      }
      label423:
      return 1;
      if ((paramInt3 == 0) || (paramInt4 == 0) || (paramInt3 == -1) || (paramInt4 == -1)) {
        return 1;
      }
      int i = 1;
      paramInt5 = paramInt2;
      paramInt6 = paramInt1;
      paramInt1 = i;
      label459:
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
        break label459;
        i = paramInt2;
      }
      label535:
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
      break label790;
      paramURLDrawableHandler = null;
      break label401;
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
            paramURLDrawableHandler.inNeedFlashBackTest = URLDrawable.depImp.mVersion.isPublicVersion();
            localBitmap = SafeBitmapFactory.safeDecode(paramFile.getAbsolutePath(), paramURLDrawableHandler);
            if (URLDrawable.depImp.mLog.isColorLevel()) {
              URLDrawable.depImp.mLog.d(getLogTag(), 2, "GalleryDecoder regionDecodeInfo:" + paramURLDrawableHandler.toString());
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
                label401:
                if (localOptions.inSampleSize > 1)
                {
                  if (!paramDownloadParams.mAutoScaleByDensity) {
                    break label807;
                  }
                  paramDownloadParams.outWidth = ((int)Math.ceil(j * this.density));
                  paramDownloadParams.outHeight = ((int)Math.ceil(k * this.density));
                }
                if (URLDrawable.depImp.mLog.isColorLevel()) {
                  URLDrawable.depImp.mLog.d(getLogTag(), 2, "image file size:" + paramFile.length() + " , bound:" + localOptions.outWidth + "x" + localOptions.outHeight + " , sampleSize: " + localOptions.inSampleSize);
                }
                return paramURLDrawableHandler;
              }
              catch (Exception paramURLDrawableHandler)
              {
                if (localBitmap == null) {
                  break label575;
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
              if (URLDrawable.depImp.mLog.isColorLevel()) {
                URLDrawable.depImp.mLog.d(getLogTag(), 2, "DecodeFile ERROR,oom retryCount=" + i + ",options.inSampleSize=" + localOptions.inSampleSize + ",url=" + paramDownloadParams.urlStr + ",oom.msg:" + paramURLDrawableHandler.getMessage());
              }
              System.gc();
              Thread.yield();
              System.gc();
              i += 1;
              paramInt *= 2;
              break;
              if ((paramDownloadParams.mExtraInfo == null) || (!GalleryDecoder.DownloadParamsExtraInfo.class.isInstance(paramDownloadParams.mExtraInfo))) {
                break label801;
              }
              paramURLDrawableHandler = (GalleryDecoder.DownloadParamsExtraInfo)paramDownloadParams.mExtraInfo;
              if (paramURLDrawableHandler.mCornerRadius <= 0) {
                break label855;
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
            label575:
            paramFile.printStackTrace();
            return null;
          }
        }
        label790:
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
      label801:
      continue;
      label807:
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
    //   3: new 107	java/io/FileInputStream
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 110	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   11: astore 13
    //   13: iconst_2
    //   14: newarray byte
    //   16: astore 12
    //   18: aload 13
    //   20: aload 12
    //   22: invokevirtual 116	java/io/InputStream:read	([B)I
    //   25: pop
    //   26: aload 12
    //   28: iconst_0
    //   29: baload
    //   30: istore 9
    //   32: aload 12
    //   34: iconst_1
    //   35: baload
    //   36: istore 10
    //   38: getstatic 125	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   41: astore 12
    //   43: iconst_0
    //   44: istore 7
    //   46: iconst_0
    //   47: istore 8
    //   49: iload 9
    //   51: bipush 8
    //   53: ishl
    //   54: ldc 126
    //   56: iand
    //   57: iload 10
    //   59: sipush 255
    //   62: iand
    //   63: ior
    //   64: lookupswitch	default:+792->856, 8273:+205->269, 16973:+205->269, 18249:+213->277, 18761:+202->266, 19789:+202->266, 65496:+202->266
    //   125: aconst_null
    //   126: aastore
    //   127: dup
    //   128: invokespecial 340	com/tencent/mobileqq/pic/JpegOptions:<init>	()V
    //   131: astore 16
    //   133: aload 16
    //   135: iconst_1
    //   136: putfield 341	com/tencent/mobileqq/pic/JpegOptions:inJustDecodeBounds	Z
    //   139: aload 16
    //   141: aload 12
    //   143: putfield 342	com/tencent/mobileqq/pic/JpegOptions:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   146: aload_1
    //   147: invokevirtual 162	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   150: aload 16
    //   152: invokestatic 348	com/tencent/mobileqq/pic/JpegDecompressor:decodeFile	(Ljava/lang/String;Lcom/tencent/mobileqq/pic/JpegOptions;)Landroid/graphics/Bitmap;
    //   155: pop
    //   156: aload 16
    //   158: getfield 349	com/tencent/mobileqq/pic/JpegOptions:outWidth	I
    //   161: istore 9
    //   163: aload 16
    //   165: getfield 350	com/tencent/mobileqq/pic/JpegOptions:outHeight	I
    //   168: istore 10
    //   170: iload 7
    //   172: ifeq +14 -> 186
    //   175: aload_2
    //   176: aload_1
    //   177: invokevirtual 162	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   180: invokestatic 168	com/tencent/image/JpegExifReader:readOrientation	(Ljava/lang/String;)I
    //   183: putfield 173	com/tencent/image/DownloadParams:outOrientation	I
    //   186: aload 16
    //   188: iconst_0
    //   189: putfield 341	com/tencent/mobileqq/pic/JpegOptions:inJustDecodeBounds	Z
    //   192: aload_0
    //   193: iload 9
    //   195: iload 10
    //   197: aload_2
    //   198: getfield 176	com/tencent/image/DownloadParams:reqWidth	I
    //   201: aload_2
    //   202: getfield 179	com/tencent/image/DownloadParams:reqHeight	I
    //   205: aload_2
    //   206: getfield 173	com/tencent/image/DownloadParams:outOrientation	I
    //   209: iload 4
    //   211: invokespecial 181	com/tencent/image/downloader/GalleryDecoder:calculateSampleSize	(IIIIII)I
    //   214: istore 7
    //   216: iconst_1
    //   217: istore 8
    //   219: iload 8
    //   221: iconst_3
    //   222: if_icmpgt +628 -> 850
    //   225: aload 16
    //   227: iload 7
    //   229: putfield 351	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   232: aload_1
    //   233: invokevirtual 162	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   236: aload 16
    //   238: invokestatic 348	com/tencent/mobileqq/pic/JpegDecompressor:decodeFile	(Ljava/lang/String;Lcom/tencent/mobileqq/pic/JpegOptions;)Landroid/graphics/Bitmap;
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
    //   259: invokevirtual 119	java/io/InputStream:close	()V
    //   262: aload_2
    //   263: astore_1
    //   264: aload_1
    //   265: areturn
    //   266: iconst_1
    //   267: istore 7
    //   269: getstatic 272	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   272: astore 12
    //   274: goto -150 -> 124
    //   277: aconst_null
    //   278: astore_1
    //   279: aload 13
    //   281: ifnull -17 -> 264
    //   284: aload 13
    //   286: invokevirtual 119	java/io/InputStream:close	()V
    //   289: aconst_null
    //   290: areturn
    //   291: aload 14
    //   293: sipush 160
    //   296: invokevirtual 230	android/graphics/Bitmap:setDensity	(I)V
    //   299: aload 14
    //   301: invokestatic 236	com/tencent/image/SliceBitmap:needSliceBitmap	(Landroid/graphics/Bitmap;)Z
    //   304: istore 11
    //   306: iload 11
    //   308: ifeq +320 -> 628
    //   311: new 232	com/tencent/image/SliceBitmap
    //   314: dup
    //   315: aload 14
    //   317: invokespecial 239	com/tencent/image/SliceBitmap:<init>	(Landroid/graphics/Bitmap;)V
    //   320: astore 12
    //   322: aload 14
    //   324: invokevirtual 242	android/graphics/Bitmap:recycle	()V
    //   327: aload 16
    //   329: getfield 351	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   332: iconst_1
    //   333: if_icmple +44 -> 377
    //   336: aload_2
    //   337: getfield 245	com/tencent/image/DownloadParams:mAutoScaleByDensity	Z
    //   340: ifeq +443 -> 783
    //   343: aload_2
    //   344: iload 9
    //   346: i2f
    //   347: aload_0
    //   348: getfield 49	com/tencent/image/downloader/GalleryDecoder:density	F
    //   351: fmul
    //   352: f2d
    //   353: invokestatic 249	java/lang/Math:ceil	(D)D
    //   356: d2i
    //   357: putfield 250	com/tencent/image/DownloadParams:outWidth	I
    //   360: aload_2
    //   361: iload 10
    //   363: i2f
    //   364: aload_0
    //   365: getfield 49	com/tencent/image/downloader/GalleryDecoder:density	F
    //   368: fmul
    //   369: f2d
    //   370: invokestatic 249	java/lang/Math:ceil	(D)D
    //   373: d2i
    //   374: putfield 251	com/tencent/image/DownloadParams:outHeight	I
    //   377: getstatic 69	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   380: getfield 75	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   383: invokeinterface 81 1 0
    //   388: ifeq +83 -> 471
    //   391: getstatic 69	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   394: getfield 75	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   397: aload_0
    //   398: invokevirtual 85	com/tencent/image/downloader/GalleryDecoder:getLogTag	()Ljava/lang/String;
    //   401: iconst_2
    //   402: new 209	java/lang/StringBuilder
    //   405: dup
    //   406: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   409: ldc 253
    //   411: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: aload_1
    //   415: invokevirtual 257	java/io/File:length	()J
    //   418: invokevirtual 260	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   421: ldc_w 262
    //   424: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload 16
    //   429: getfield 349	com/tencent/mobileqq/pic/JpegOptions:outWidth	I
    //   432: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   435: ldc_w 267
    //   438: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: aload 16
    //   443: getfield 350	com/tencent/mobileqq/pic/JpegOptions:outHeight	I
    //   446: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   449: ldc_w 269
    //   452: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: aload 16
    //   457: getfield 351	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   460: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   463: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: invokeinterface 91 4 0
    //   471: aload 12
    //   473: astore_1
    //   474: aload 13
    //   476: ifnull -212 -> 264
    //   479: aload 13
    //   481: invokevirtual 119	java/io/InputStream:close	()V
    //   484: aload 12
    //   486: areturn
    //   487: astore 12
    //   489: aload 14
    //   491: ifnull +8 -> 499
    //   494: aload 14
    //   496: invokevirtual 242	android/graphics/Bitmap:recycle	()V
    //   499: new 101	java/lang/OutOfMemoryError
    //   502: dup
    //   503: ldc_w 274
    //   506: invokespecial 277	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   509: athrow
    //   510: astore 12
    //   512: getstatic 69	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   515: getfield 75	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   518: invokeinterface 81 1 0
    //   523: ifeq +81 -> 604
    //   526: getstatic 69	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   529: getfield 75	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   532: aload_0
    //   533: invokevirtual 85	com/tencent/image/downloader/GalleryDecoder:getLogTag	()Ljava/lang/String;
    //   536: iconst_2
    //   537: new 209	java/lang/StringBuilder
    //   540: dup
    //   541: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   544: ldc_w 279
    //   547: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: iload 8
    //   552: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   555: ldc_w 281
    //   558: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: aload 16
    //   563: getfield 351	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   566: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   569: ldc_w 283
    //   572: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: aload_2
    //   576: getfield 286	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   579: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: ldc_w 288
    //   585: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: aload 12
    //   590: invokevirtual 291	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   593: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   599: invokeinterface 91 4 0
    //   604: invokestatic 296	java/lang/System:gc	()V
    //   607: invokestatic 301	java/lang/Thread:yield	()V
    //   610: invokestatic 296	java/lang/System:gc	()V
    //   613: iload 8
    //   615: iconst_1
    //   616: iadd
    //   617: istore 8
    //   619: iload 7
    //   621: iconst_2
    //   622: imul
    //   623: istore 7
    //   625: goto -406 -> 219
    //   628: aload_2
    //   629: getfield 305	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   632: ifnull +144 -> 776
    //   635: ldc_w 307
    //   638: aload_2
    //   639: getfield 305	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   642: invokevirtual 313	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   645: ifeq +131 -> 776
    //   648: aload_2
    //   649: getfield 305	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   652: checkcast 307	com/tencent/image/downloader/GalleryDecoder$DownloadParamsExtraInfo
    //   655: astore 12
    //   657: aload 12
    //   659: getfield 316	com/tencent/image/downloader/GalleryDecoder$DownloadParamsExtraInfo:mCornerRadius	I
    //   662: ifle +182 -> 844
    //   665: aload_0
    //   666: aload 14
    //   668: aload 12
    //   670: getfield 316	com/tencent/image/downloader/GalleryDecoder$DownloadParamsExtraInfo:mCornerRadius	I
    //   673: invokevirtual 320	com/tencent/image/downloader/GalleryDecoder:resizeAndClipBitmap	(Landroid/graphics/Bitmap;I)Lcom/tencent/image/RoundRectBitmap;
    //   676: astore 15
    //   678: aload 15
    //   680: astore 12
    //   682: aload 15
    //   684: getfield 326	com/tencent/image/RoundRectBitmap:mBitmap	Landroid/graphics/Bitmap;
    //   687: aload 14
    //   689: invokevirtual 331	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   692: ifne -365 -> 327
    //   695: aload 14
    //   697: invokevirtual 242	android/graphics/Bitmap:recycle	()V
    //   700: aload 15
    //   702: astore 12
    //   704: goto -377 -> 327
    //   707: astore 14
    //   709: aload 13
    //   711: astore 12
    //   713: aload 14
    //   715: astore 13
    //   717: getstatic 69	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   720: getfield 75	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   723: invokeinterface 81 1 0
    //   728: ifeq +24 -> 752
    //   731: getstatic 69	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   734: getfield 75	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   737: aload_0
    //   738: invokevirtual 85	com/tencent/image/downloader/GalleryDecoder:getLogTag	()Ljava/lang/String;
    //   741: iconst_2
    //   742: ldc_w 353
    //   745: aload 13
    //   747: invokeinterface 357 5 0
    //   752: aload_0
    //   753: aload_1
    //   754: aload_2
    //   755: aload_3
    //   756: iload 4
    //   758: invokespecial 359	com/tencent/image/downloader/GalleryDecoder:decodeFileNormal	(Ljava/io/File;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;I)Ljava/lang/Object;
    //   761: astore_2
    //   762: aload_2
    //   763: astore_1
    //   764: aload 12
    //   766: ifnull -502 -> 264
    //   769: aload 12
    //   771: invokevirtual 119	java/io/InputStream:close	()V
    //   774: aload_2
    //   775: areturn
    //   776: aload 14
    //   778: astore 12
    //   780: goto -453 -> 327
    //   783: iload 9
    //   785: i2d
    //   786: dstore 5
    //   788: aload_2
    //   789: dload 5
    //   791: invokestatic 249	java/lang/Math:ceil	(D)D
    //   794: d2i
    //   795: putfield 250	com/tencent/image/DownloadParams:outWidth	I
    //   798: aload_2
    //   799: iload 10
    //   801: i2d
    //   802: invokestatic 249	java/lang/Math:ceil	(D)D
    //   805: d2i
    //   806: putfield 251	com/tencent/image/DownloadParams:outHeight	I
    //   809: goto -432 -> 377
    //   812: astore_1
    //   813: aload 13
    //   815: astore_2
    //   816: aload_2
    //   817: ifnull +7 -> 824
    //   820: aload_2
    //   821: invokevirtual 119	java/io/InputStream:close	()V
    //   824: aload_1
    //   825: athrow
    //   826: astore_1
    //   827: aconst_null
    //   828: astore_2
    //   829: goto -13 -> 816
    //   832: astore_1
    //   833: aload 12
    //   835: astore_2
    //   836: goto -20 -> 816
    //   839: astore 13
    //   841: goto -124 -> 717
    //   844: aconst_null
    //   845: astore 12
    //   847: goto -520 -> 327
    //   850: aconst_null
    //   851: astore 12
    //   853: goto -526 -> 327
    //   856: iload 8
    //   858: istore 7
    //   860: goto -736 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	863	0	this	GalleryDecoder
    //   0	863	1	paramFile	File
    //   0	863	2	paramDownloadParams	DownloadParams
    //   0	863	3	paramURLDrawableHandler	URLDrawableHandler
    //   0	863	4	paramInt	int
    //   786	4	5	d	double
    //   44	815	7	i	int
    //   47	810	8	j	int
    //   30	754	9	k	int
    //   36	764	10	m	int
    //   304	3	11	bool	boolean
    //   1	484	12	localObject1	Object
    //   487	1	12	localException	Exception
    //   510	79	12	localOutOfMemoryError	OutOfMemoryError
    //   655	197	12	localObject2	Object
    //   11	803	13	localObject3	Object
    //   839	1	13	localRuntimeException1	java.lang.RuntimeException
    //   241	455	14	localBitmap	Bitmap
    //   707	70	14	localRuntimeException2	java.lang.RuntimeException
    //   676	25	15	localRoundRectBitmap	RoundRectBitmap
    //   131	431	16	localJpegOptions	com.tencent.mobileqq.pic.JpegOptions
    // Exception table:
    //   from	to	target	type
    //   311	327	487	java/lang/Exception
    //   225	243	510	java/lang/OutOfMemoryError
    //   291	306	510	java/lang/OutOfMemoryError
    //   311	327	510	java/lang/OutOfMemoryError
    //   494	499	510	java/lang/OutOfMemoryError
    //   499	510	510	java/lang/OutOfMemoryError
    //   628	678	510	java/lang/OutOfMemoryError
    //   682	700	510	java/lang/OutOfMemoryError
    //   13	26	707	java/lang/RuntimeException
    //   38	43	707	java/lang/RuntimeException
    //   124	170	707	java/lang/RuntimeException
    //   175	186	707	java/lang/RuntimeException
    //   186	216	707	java/lang/RuntimeException
    //   225	243	707	java/lang/RuntimeException
    //   269	274	707	java/lang/RuntimeException
    //   291	306	707	java/lang/RuntimeException
    //   311	327	707	java/lang/RuntimeException
    //   327	377	707	java/lang/RuntimeException
    //   377	471	707	java/lang/RuntimeException
    //   494	499	707	java/lang/RuntimeException
    //   499	510	707	java/lang/RuntimeException
    //   512	604	707	java/lang/RuntimeException
    //   604	613	707	java/lang/RuntimeException
    //   628	678	707	java/lang/RuntimeException
    //   682	700	707	java/lang/RuntimeException
    //   788	809	707	java/lang/RuntimeException
    //   13	26	812	finally
    //   38	43	812	finally
    //   124	170	812	finally
    //   175	186	812	finally
    //   186	216	812	finally
    //   225	243	812	finally
    //   269	274	812	finally
    //   291	306	812	finally
    //   311	327	812	finally
    //   327	377	812	finally
    //   377	471	812	finally
    //   494	499	812	finally
    //   499	510	812	finally
    //   512	604	812	finally
    //   604	613	812	finally
    //   628	678	812	finally
    //   682	700	812	finally
    //   788	809	812	finally
    //   3	13	826	finally
    //   717	752	832	finally
    //   752	762	832	finally
    //   3	13	839	java/lang/RuntimeException
  }
  
  /* Error */
  private Object decodeFileWidthByteArray(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt)
  {
    // Byte code:
    //   0: new 107	java/io/FileInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 110	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore 18
    //   10: aconst_null
    //   11: astore 15
    //   13: iconst_0
    //   14: istore 6
    //   16: invokestatic 365	android/os/SystemClock:uptimeMillis	()J
    //   19: lstore 10
    //   21: iconst_2
    //   22: newarray byte
    //   24: astore 16
    //   26: aload 18
    //   28: aload 16
    //   30: invokevirtual 366	java/io/FileInputStream:read	([B)I
    //   33: pop
    //   34: aload 16
    //   36: iconst_0
    //   37: baload
    //   38: istore 8
    //   40: aload 16
    //   42: iconst_1
    //   43: baload
    //   44: istore 9
    //   46: getstatic 125	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   49: astore_3
    //   50: iconst_0
    //   51: istore 5
    //   53: iconst_0
    //   54: istore 7
    //   56: iload 8
    //   58: bipush 8
    //   60: ishl
    //   61: ldc 126
    //   63: iand
    //   64: iload 9
    //   66: sipush 255
    //   69: iand
    //   70: ior
    //   71: lookupswitch	default:+853->924, 8273:+549->620, 16973:+549->620, 18249:+556->627, 18761:+546->617, 19789:+546->617, 65496:+546->617
    //   129: invokevirtual 257	java/io/File:length	()J
    //   132: l2i
    //   133: newarray byte
    //   135: astore 20
    //   137: aload 16
    //   139: iconst_0
    //   140: aload 20
    //   142: iconst_0
    //   143: aload 16
    //   145: arraylength
    //   146: invokestatic 370	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   149: aload 18
    //   151: aload 20
    //   153: aload 16
    //   155: arraylength
    //   156: aload 18
    //   158: invokevirtual 374	java/io/FileInputStream:available	()I
    //   161: invokevirtual 377	java/io/FileInputStream:read	([BII)I
    //   164: pop
    //   165: aload 18
    //   167: invokevirtual 378	java/io/FileInputStream:close	()V
    //   170: getstatic 69	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   173: getfield 75	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   176: invokeinterface 81 1 0
    //   181: ifeq +48 -> 229
    //   184: invokestatic 365	android/os/SystemClock:uptimeMillis	()J
    //   187: lstore 12
    //   189: getstatic 69	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   192: getfield 75	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   195: aload_0
    //   196: invokevirtual 85	com/tencent/image/downloader/GalleryDecoder:getLogTag	()Ljava/lang/String;
    //   199: iconst_2
    //   200: new 209	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   207: ldc_w 380
    //   210: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: lload 12
    //   215: lload 10
    //   217: lsub
    //   218: invokevirtual 260	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   221: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokeinterface 91 4 0
    //   229: invokestatic 365	android/os/SystemClock:uptimeMillis	()J
    //   232: lstore 10
    //   234: new 128	android/graphics/BitmapFactory$Options
    //   237: dup
    //   238: invokespecial 129	android/graphics/BitmapFactory$Options:<init>	()V
    //   241: astore 19
    //   243: aload 19
    //   245: iconst_1
    //   246: putfield 133	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   249: aload 19
    //   251: aload_3
    //   252: putfield 136	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   255: aload 19
    //   257: sipush 160
    //   260: putfield 139	android/graphics/BitmapFactory$Options:inDensity	I
    //   263: aload 19
    //   265: sipush 160
    //   268: putfield 142	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   271: aload 19
    //   273: sipush 160
    //   276: putfield 145	android/graphics/BitmapFactory$Options:inScreenDensity	I
    //   279: aload 19
    //   281: iconst_1
    //   282: putfield 383	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   285: aload 19
    //   287: iconst_1
    //   288: putfield 386	android/graphics/BitmapFactory$Options:inInputShareable	Z
    //   291: aload 20
    //   293: iconst_0
    //   294: aload 20
    //   296: arraylength
    //   297: aload 19
    //   299: invokestatic 390	com/tencent/image/SafeBitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   302: pop
    //   303: aload 19
    //   305: getfield 154	android/graphics/BitmapFactory$Options:outWidth	I
    //   308: istore 6
    //   310: aload 19
    //   312: getfield 157	android/graphics/BitmapFactory$Options:outHeight	I
    //   315: istore 7
    //   317: iload 5
    //   319: ifeq +315 -> 634
    //   322: aload_2
    //   323: aload_1
    //   324: invokevirtual 162	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   327: invokestatic 168	com/tencent/image/JpegExifReader:readOrientation	(Ljava/lang/String;)I
    //   330: putfield 173	com/tencent/image/DownloadParams:outOrientation	I
    //   333: getstatic 69	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   336: getfield 75	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   339: invokeinterface 81 1 0
    //   344: ifeq +48 -> 392
    //   347: invokestatic 365	android/os/SystemClock:uptimeMillis	()J
    //   350: lstore 12
    //   352: getstatic 69	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   355: getfield 75	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   358: aload_0
    //   359: invokevirtual 85	com/tencent/image/downloader/GalleryDecoder:getLogTag	()Ljava/lang/String;
    //   362: iconst_2
    //   363: new 209	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   370: ldc_w 392
    //   373: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: lload 12
    //   378: lload 10
    //   380: lsub
    //   381: invokevirtual 260	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   384: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   387: invokeinterface 91 4 0
    //   392: aload 19
    //   394: iconst_0
    //   395: putfield 133	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   398: aload_0
    //   399: iload 6
    //   401: iload 7
    //   403: aload_2
    //   404: getfield 176	com/tencent/image/DownloadParams:reqWidth	I
    //   407: aload_2
    //   408: getfield 179	com/tencent/image/DownloadParams:reqHeight	I
    //   411: aload_2
    //   412: getfield 173	com/tencent/image/DownloadParams:outOrientation	I
    //   415: iload 4
    //   417: invokespecial 181	com/tencent/image/downloader/GalleryDecoder:calculateSampleSize	(IIIIII)I
    //   420: istore 4
    //   422: aload 19
    //   424: iload 4
    //   426: putfield 184	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   429: aload 20
    //   431: iconst_0
    //   432: aload 20
    //   434: arraylength
    //   435: aload 19
    //   437: invokestatic 390	com/tencent/image/SafeBitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   440: astore 16
    //   442: aload 16
    //   444: sipush 160
    //   447: invokevirtual 230	android/graphics/Bitmap:setDensity	(I)V
    //   450: aload 16
    //   452: invokestatic 236	com/tencent/image/SliceBitmap:needSliceBitmap	(Landroid/graphics/Bitmap;)Z
    //   455: istore 14
    //   457: iload 14
    //   459: ifeq +346 -> 805
    //   462: new 232	com/tencent/image/SliceBitmap
    //   465: dup
    //   466: aload 16
    //   468: invokespecial 239	com/tencent/image/SliceBitmap:<init>	(Landroid/graphics/Bitmap;)V
    //   471: astore_3
    //   472: aload 16
    //   474: invokevirtual 242	android/graphics/Bitmap:recycle	()V
    //   477: aload 19
    //   479: getfield 184	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   482: iconst_1
    //   483: if_icmple +44 -> 527
    //   486: aload_2
    //   487: getfield 245	com/tencent/image/DownloadParams:mAutoScaleByDensity	Z
    //   490: ifeq +396 -> 886
    //   493: aload_2
    //   494: iload 6
    //   496: i2f
    //   497: aload_0
    //   498: getfield 49	com/tencent/image/downloader/GalleryDecoder:density	F
    //   501: fmul
    //   502: f2d
    //   503: invokestatic 249	java/lang/Math:ceil	(D)D
    //   506: d2i
    //   507: putfield 250	com/tencent/image/DownloadParams:outWidth	I
    //   510: aload_2
    //   511: iload 7
    //   513: i2f
    //   514: aload_0
    //   515: getfield 49	com/tencent/image/downloader/GalleryDecoder:density	F
    //   518: fmul
    //   519: f2d
    //   520: invokestatic 249	java/lang/Math:ceil	(D)D
    //   523: d2i
    //   524: putfield 251	com/tencent/image/DownloadParams:outHeight	I
    //   527: getstatic 69	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   530: getfield 75	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   533: invokeinterface 81 1 0
    //   538: ifeq +77 -> 615
    //   541: getstatic 69	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   544: getfield 75	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   547: aload_0
    //   548: invokevirtual 85	com/tencent/image/downloader/GalleryDecoder:getLogTag	()Ljava/lang/String;
    //   551: iconst_2
    //   552: new 209	java/lang/StringBuilder
    //   555: dup
    //   556: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   559: ldc 253
    //   561: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: aload_1
    //   565: invokevirtual 257	java/io/File:length	()J
    //   568: invokevirtual 260	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   571: ldc_w 262
    //   574: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: iload 6
    //   579: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   582: ldc_w 267
    //   585: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: iload 7
    //   590: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   593: ldc_w 269
    //   596: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: aload 19
    //   601: getfield 184	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   604: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   607: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   610: invokeinterface 91 4 0
    //   615: aload_3
    //   616: areturn
    //   617: iconst_1
    //   618: istore 5
    //   620: getstatic 272	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   623: astore_3
    //   624: goto -496 -> 128
    //   627: aload 18
    //   629: invokevirtual 378	java/io/FileInputStream:close	()V
    //   632: aconst_null
    //   633: areturn
    //   634: aload_2
    //   635: aload_1
    //   636: invokevirtual 162	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   639: invokestatic 397	com/tencent/image/Utils:getHeifOrientation	(Ljava/lang/String;)I
    //   642: putfield 173	com/tencent/image/DownloadParams:outOrientation	I
    //   645: goto -312 -> 333
    //   648: astore_1
    //   649: iconst_1
    //   650: istore 4
    //   652: iload 4
    //   654: ifne +8 -> 662
    //   657: aload 18
    //   659: invokevirtual 378	java/io/FileInputStream:close	()V
    //   662: aload_1
    //   663: athrow
    //   664: astore_3
    //   665: aload 16
    //   667: ifnull +8 -> 675
    //   670: aload 16
    //   672: invokevirtual 242	android/graphics/Bitmap:recycle	()V
    //   675: new 101	java/lang/OutOfMemoryError
    //   678: dup
    //   679: ldc_w 274
    //   682: invokespecial 277	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   685: athrow
    //   686: astore_3
    //   687: getstatic 69	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   690: getfield 75	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   693: invokeinterface 81 1 0
    //   698: ifeq +79 -> 777
    //   701: getstatic 69	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   704: getfield 75	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   707: aload_0
    //   708: invokevirtual 85	com/tencent/image/downloader/GalleryDecoder:getLogTag	()Ljava/lang/String;
    //   711: iconst_2
    //   712: new 209	java/lang/StringBuilder
    //   715: dup
    //   716: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   719: ldc_w 279
    //   722: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   725: iconst_1
    //   726: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   729: ldc_w 281
    //   732: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: aload 19
    //   737: getfield 184	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   740: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   743: ldc_w 283
    //   746: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   749: aload_2
    //   750: getfield 286	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   753: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   756: ldc_w 288
    //   759: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   762: aload_3
    //   763: invokevirtual 291	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   766: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   772: invokeinterface 91 4 0
    //   777: iload 4
    //   779: iconst_2
    //   780: imul
    //   781: istore 4
    //   783: invokestatic 296	java/lang/System:gc	()V
    //   786: invokestatic 301	java/lang/Thread:yield	()V
    //   789: invokestatic 296	java/lang/System:gc	()V
    //   792: aload 15
    //   794: astore_3
    //   795: iload 4
    //   797: bipush 8
    //   799: if_icmple -322 -> 477
    //   802: goto -380 -> 422
    //   805: aload_2
    //   806: getfield 305	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   809: ifnull +122 -> 931
    //   812: ldc_w 307
    //   815: aload_2
    //   816: getfield 305	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   819: invokevirtual 313	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   822: ifeq +109 -> 931
    //   825: aload_2
    //   826: getfield 305	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   829: checkcast 307	com/tencent/image/downloader/GalleryDecoder$DownloadParamsExtraInfo
    //   832: astore_3
    //   833: aload_3
    //   834: getfield 316	com/tencent/image/downloader/GalleryDecoder$DownloadParamsExtraInfo:mCornerRadius	I
    //   837: ifle +82 -> 919
    //   840: aload_0
    //   841: aload 16
    //   843: aload_3
    //   844: getfield 316	com/tencent/image/downloader/GalleryDecoder$DownloadParamsExtraInfo:mCornerRadius	I
    //   847: invokevirtual 320	com/tencent/image/downloader/GalleryDecoder:resizeAndClipBitmap	(Landroid/graphics/Bitmap;I)Lcom/tencent/image/RoundRectBitmap;
    //   850: astore 17
    //   852: aload 17
    //   854: astore_3
    //   855: aload 17
    //   857: getfield 326	com/tencent/image/RoundRectBitmap:mBitmap	Landroid/graphics/Bitmap;
    //   860: aload 16
    //   862: invokevirtual 331	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   865: ifne -388 -> 477
    //   868: aload 16
    //   870: invokevirtual 242	android/graphics/Bitmap:recycle	()V
    //   873: aload 17
    //   875: astore_3
    //   876: goto -399 -> 477
    //   879: astore_1
    //   880: aload_1
    //   881: invokevirtual 334	java/lang/NullPointerException:printStackTrace	()V
    //   884: aconst_null
    //   885: areturn
    //   886: aload_2
    //   887: iload 6
    //   889: i2d
    //   890: invokestatic 249	java/lang/Math:ceil	(D)D
    //   893: d2i
    //   894: putfield 250	com/tencent/image/DownloadParams:outWidth	I
    //   897: aload_2
    //   898: iload 7
    //   900: i2d
    //   901: invokestatic 249	java/lang/Math:ceil	(D)D
    //   904: d2i
    //   905: putfield 251	com/tencent/image/DownloadParams:outHeight	I
    //   908: goto -381 -> 527
    //   911: astore_1
    //   912: iload 6
    //   914: istore 4
    //   916: goto -264 -> 652
    //   919: aconst_null
    //   920: astore_3
    //   921: goto -444 -> 477
    //   924: iload 7
    //   926: istore 5
    //   928: goto -800 -> 128
    //   931: aload 16
    //   933: astore_3
    //   934: goto -457 -> 477
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	937	0	this	GalleryDecoder
    //   0	937	1	paramFile	File
    //   0	937	2	paramDownloadParams	DownloadParams
    //   0	937	3	paramURLDrawableHandler	URLDrawableHandler
    //   0	937	4	paramInt	int
    //   51	876	5	i	int
    //   14	899	6	j	int
    //   54	871	7	k	int
    //   38	23	8	m	int
    //   44	26	9	n	int
    //   19	360	10	l1	long
    //   187	190	12	l2	long
    //   455	3	14	bool	boolean
    //   11	782	15	localObject1	Object
    //   24	908	16	localObject2	Object
    //   850	24	17	localRoundRectBitmap	RoundRectBitmap
    //   8	650	18	localFileInputStream	FileInputStream
    //   241	495	19	localOptions	BitmapFactory.Options
    //   135	298	20	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   170	229	648	finally
    //   229	317	648	finally
    //   322	333	648	finally
    //   333	392	648	finally
    //   392	422	648	finally
    //   422	457	648	finally
    //   462	477	648	finally
    //   477	527	648	finally
    //   527	615	648	finally
    //   634	645	648	finally
    //   670	675	648	finally
    //   675	686	648	finally
    //   687	777	648	finally
    //   783	792	648	finally
    //   805	852	648	finally
    //   855	873	648	finally
    //   880	884	648	finally
    //   886	908	648	finally
    //   462	477	664	java/lang/Exception
    //   422	457	686	java/lang/OutOfMemoryError
    //   462	477	686	java/lang/OutOfMemoryError
    //   670	675	686	java/lang/OutOfMemoryError
    //   675	686	686	java/lang/OutOfMemoryError
    //   805	852	686	java/lang/OutOfMemoryError
    //   855	873	686	java/lang/OutOfMemoryError
    //   422	457	879	java/lang/NullPointerException
    //   462	477	879	java/lang/NullPointerException
    //   670	675	879	java/lang/NullPointerException
    //   675	686	879	java/lang/NullPointerException
    //   805	852	879	java/lang/NullPointerException
    //   855	873	879	java/lang/NullPointerException
    //   16	34	911	finally
    //   46	50	911	finally
    //   128	170	911	finally
    //   620	624	911	finally
  }
  
  /* Error */
  private Object decodeFileWidthByteArrayWithTrubo(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt)
  {
    // Byte code:
    //   0: new 107	java/io/FileInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 110	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore 19
    //   10: iconst_0
    //   11: istore 8
    //   13: iconst_0
    //   14: istore 7
    //   16: iload 8
    //   18: istore 5
    //   20: invokestatic 365	android/os/SystemClock:uptimeMillis	()J
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
    //   42: invokevirtual 366	java/io/FileInputStream:read	([B)I
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
    //   62: getstatic 125	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   65: astore 16
    //   67: iconst_0
    //   68: istore 6
    //   70: iconst_0
    //   71: istore 5
    //   73: iload 9
    //   75: bipush 8
    //   77: ishl
    //   78: ldc 126
    //   80: iand
    //   81: iload 10
    //   83: sipush 255
    //   86: iand
    //   87: ior
    //   88: lookupswitch	default:+938->1026, 8273:+361->449, 16973:+361->449, 18249:+373->461, 18761:+358->446, 19789:+358->446, 65496:+358->446
    //   149: iconst_5
    //   150: istore 5
    //   152: aload_1
    //   153: invokevirtual 257	java/io/File:length	()J
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
    //   174: invokestatic 370	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   177: iload 8
    //   179: istore 5
    //   181: aload 19
    //   183: aload 21
    //   185: aload 17
    //   187: arraylength
    //   188: aload 19
    //   190: invokevirtual 374	java/io/FileInputStream:available	()I
    //   193: invokevirtual 377	java/io/FileInputStream:read	([BII)I
    //   196: pop
    //   197: iload 8
    //   199: istore 5
    //   201: aload 19
    //   203: invokevirtual 378	java/io/FileInputStream:close	()V
    //   206: iconst_1
    //   207: istore 7
    //   209: getstatic 69	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   212: getfield 75	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   215: invokeinterface 81 1 0
    //   220: ifeq +48 -> 268
    //   223: invokestatic 365	android/os/SystemClock:uptimeMillis	()J
    //   226: lstore 13
    //   228: getstatic 69	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   231: getfield 75	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   234: aload_0
    //   235: invokevirtual 85	com/tencent/image/downloader/GalleryDecoder:getLogTag	()Ljava/lang/String;
    //   238: iconst_2
    //   239: new 209	java/lang/StringBuilder
    //   242: dup
    //   243: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   246: ldc_w 380
    //   249: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: lload 13
    //   254: lload 11
    //   256: lsub
    //   257: invokevirtual 260	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   260: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: invokeinterface 91 4 0
    //   268: invokestatic 365	android/os/SystemClock:uptimeMillis	()J
    //   271: lstore 11
    //   273: new 339	com/tencent/mobileqq/pic/JpegOptions
    //   276: dup
    //   277: invokespecial 340	com/tencent/mobileqq/pic/JpegOptions:<init>	()V
    //   280: astore 20
    //   282: aload 20
    //   284: iconst_1
    //   285: putfield 341	com/tencent/mobileqq/pic/JpegOptions:inJustDecodeBounds	Z
    //   288: aload 20
    //   290: aload 16
    //   292: putfield 342	com/tencent/mobileqq/pic/JpegOptions:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   295: aload 21
    //   297: aload 20
    //   299: invokestatic 401	com/tencent/mobileqq/pic/JpegDecompressor:decodeByteArray	([BLcom/tencent/mobileqq/pic/JpegOptions;)Landroid/graphics/Bitmap;
    //   302: pop
    //   303: aload 20
    //   305: getfield 349	com/tencent/mobileqq/pic/JpegOptions:outWidth	I
    //   308: istore 8
    //   310: aload 20
    //   312: getfield 350	com/tencent/mobileqq/pic/JpegOptions:outHeight	I
    //   315: istore 9
    //   317: iload 6
    //   319: ifeq +14 -> 333
    //   322: aload_2
    //   323: aload_1
    //   324: invokevirtual 162	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   327: invokestatic 168	com/tencent/image/JpegExifReader:readOrientation	(Ljava/lang/String;)I
    //   330: putfield 173	com/tencent/image/DownloadParams:outOrientation	I
    //   333: getstatic 69	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   336: getfield 75	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   339: invokeinterface 81 1 0
    //   344: ifeq +48 -> 392
    //   347: invokestatic 365	android/os/SystemClock:uptimeMillis	()J
    //   350: lstore 13
    //   352: getstatic 69	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   355: getfield 75	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   358: aload_0
    //   359: invokevirtual 85	com/tencent/image/downloader/GalleryDecoder:getLogTag	()Ljava/lang/String;
    //   362: iconst_2
    //   363: new 209	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   370: ldc_w 392
    //   373: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: lload 13
    //   378: lload 11
    //   380: lsub
    //   381: invokevirtual 260	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   384: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   387: invokeinterface 91 4 0
    //   392: aload 20
    //   394: iconst_0
    //   395: putfield 341	com/tencent/mobileqq/pic/JpegOptions:inJustDecodeBounds	Z
    //   398: aload_0
    //   399: iload 8
    //   401: iload 9
    //   403: aload_2
    //   404: getfield 176	com/tencent/image/DownloadParams:reqWidth	I
    //   407: aload_2
    //   408: getfield 179	com/tencent/image/DownloadParams:reqHeight	I
    //   411: aload_2
    //   412: getfield 173	com/tencent/image/DownloadParams:outOrientation	I
    //   415: iload 4
    //   417: invokespecial 181	com/tencent/image/downloader/GalleryDecoder:calculateSampleSize	(IIIIII)I
    //   420: istore 5
    //   422: aload 20
    //   424: iload 5
    //   426: putfield 351	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   429: aload 21
    //   431: aload 20
    //   433: invokestatic 401	com/tencent/mobileqq/pic/JpegDecompressor:decodeByteArray	([BLcom/tencent/mobileqq/pic/JpegOptions;)Landroid/graphics/Bitmap;
    //   436: astore 17
    //   438: aload 17
    //   440: ifnonnull +28 -> 468
    //   443: aload 17
    //   445: areturn
    //   446: iconst_1
    //   447: istore 6
    //   449: iload 8
    //   451: istore 5
    //   453: getstatic 272	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   456: astore 16
    //   458: goto -310 -> 148
    //   461: aload 19
    //   463: invokevirtual 378	java/io/FileInputStream:close	()V
    //   466: aconst_null
    //   467: areturn
    //   468: aload 17
    //   470: sipush 160
    //   473: invokevirtual 230	android/graphics/Bitmap:setDensity	(I)V
    //   476: aload 17
    //   478: invokestatic 236	com/tencent/image/SliceBitmap:needSliceBitmap	(Landroid/graphics/Bitmap;)Z
    //   481: istore 15
    //   483: iload 15
    //   485: ifeq +385 -> 870
    //   488: new 232	com/tencent/image/SliceBitmap
    //   491: dup
    //   492: aload 17
    //   494: invokespecial 239	com/tencent/image/SliceBitmap:<init>	(Landroid/graphics/Bitmap;)V
    //   497: astore 16
    //   499: aload 17
    //   501: invokevirtual 242	android/graphics/Bitmap:recycle	()V
    //   504: aload 20
    //   506: getfield 351	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   509: iconst_1
    //   510: if_icmple +44 -> 554
    //   513: aload_2
    //   514: getfield 245	com/tencent/image/DownloadParams:mAutoScaleByDensity	Z
    //   517: ifeq +441 -> 958
    //   520: aload_2
    //   521: iload 8
    //   523: i2f
    //   524: aload_0
    //   525: getfield 49	com/tencent/image/downloader/GalleryDecoder:density	F
    //   528: fmul
    //   529: f2d
    //   530: invokestatic 249	java/lang/Math:ceil	(D)D
    //   533: d2i
    //   534: putfield 250	com/tencent/image/DownloadParams:outWidth	I
    //   537: aload_2
    //   538: iload 9
    //   540: i2f
    //   541: aload_0
    //   542: getfield 49	com/tencent/image/downloader/GalleryDecoder:density	F
    //   545: fmul
    //   546: f2d
    //   547: invokestatic 249	java/lang/Math:ceil	(D)D
    //   550: d2i
    //   551: putfield 251	com/tencent/image/DownloadParams:outHeight	I
    //   554: aload 16
    //   556: astore 17
    //   558: getstatic 69	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   561: getfield 75	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   564: invokeinterface 81 1 0
    //   569: ifeq -126 -> 443
    //   572: getstatic 69	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   575: getfield 75	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   578: aload_0
    //   579: invokevirtual 85	com/tencent/image/downloader/GalleryDecoder:getLogTag	()Ljava/lang/String;
    //   582: iconst_2
    //   583: new 209	java/lang/StringBuilder
    //   586: dup
    //   587: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   590: ldc 253
    //   592: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: aload_1
    //   596: invokevirtual 257	java/io/File:length	()J
    //   599: invokevirtual 260	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   602: ldc_w 262
    //   605: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: iload 8
    //   610: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   613: ldc_w 267
    //   616: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: iload 9
    //   621: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   624: ldc_w 269
    //   627: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: aload 20
    //   632: getfield 351	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   635: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   638: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   641: invokeinterface 91 4 0
    //   646: aload 16
    //   648: areturn
    //   649: astore 16
    //   651: iconst_1
    //   652: istore 6
    //   654: iload 6
    //   656: istore 5
    //   658: getstatic 69	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   661: getfield 75	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   664: invokeinterface 81 1 0
    //   669: ifeq +28 -> 697
    //   672: iload 6
    //   674: istore 5
    //   676: getstatic 69	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   679: getfield 75	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   682: aload_0
    //   683: invokevirtual 85	com/tencent/image/downloader/GalleryDecoder:getLogTag	()Ljava/lang/String;
    //   686: iconst_2
    //   687: ldc_w 403
    //   690: aload 16
    //   692: invokeinterface 357 5 0
    //   697: iload 6
    //   699: istore 5
    //   701: aload_0
    //   702: aload_1
    //   703: aload_2
    //   704: aload_3
    //   705: iload 4
    //   707: invokespecial 405	com/tencent/image/downloader/GalleryDecoder:decodeFileWidthByteArray	(Ljava/io/File;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;I)Ljava/lang/Object;
    //   710: astore_1
    //   711: aload_1
    //   712: astore 17
    //   714: iload 6
    //   716: ifne -273 -> 443
    //   719: aload 19
    //   721: invokevirtual 378	java/io/FileInputStream:close	()V
    //   724: aload_1
    //   725: areturn
    //   726: astore 16
    //   728: aload 17
    //   730: ifnull +8 -> 738
    //   733: aload 17
    //   735: invokevirtual 242	android/graphics/Bitmap:recycle	()V
    //   738: new 101	java/lang/OutOfMemoryError
    //   741: dup
    //   742: ldc_w 274
    //   745: invokespecial 277	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   748: athrow
    //   749: astore 16
    //   751: getstatic 69	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   754: getfield 75	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   757: invokeinterface 81 1 0
    //   762: ifeq +80 -> 842
    //   765: getstatic 69	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   768: getfield 75	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   771: aload_0
    //   772: invokevirtual 85	com/tencent/image/downloader/GalleryDecoder:getLogTag	()Ljava/lang/String;
    //   775: iconst_2
    //   776: new 209	java/lang/StringBuilder
    //   779: dup
    //   780: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   783: ldc_w 279
    //   786: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   789: iconst_1
    //   790: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   793: ldc_w 281
    //   796: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   799: aload 20
    //   801: getfield 351	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   804: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   807: ldc_w 283
    //   810: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   813: aload_2
    //   814: getfield 286	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   817: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: ldc_w 288
    //   823: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   826: aload 16
    //   828: invokevirtual 291	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   831: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   834: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   837: invokeinterface 91 4 0
    //   842: iload 5
    //   844: iconst_2
    //   845: imul
    //   846: istore 5
    //   848: invokestatic 296	java/lang/System:gc	()V
    //   851: invokestatic 301	java/lang/Thread:yield	()V
    //   854: invokestatic 296	java/lang/System:gc	()V
    //   857: iload 5
    //   859: bipush 8
    //   861: if_icmplt +156 -> 1017
    //   864: aconst_null
    //   865: astore 16
    //   867: goto -363 -> 504
    //   870: aload_2
    //   871: getfield 305	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   874: ifnull +159 -> 1033
    //   877: ldc_w 307
    //   880: aload_2
    //   881: getfield 305	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   884: invokevirtual 313	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   887: ifeq +146 -> 1033
    //   890: aload_2
    //   891: getfield 305	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   894: checkcast 307	com/tencent/image/downloader/GalleryDecoder$DownloadParamsExtraInfo
    //   897: astore 16
    //   899: aload 16
    //   901: getfield 316	com/tencent/image/downloader/GalleryDecoder$DownloadParamsExtraInfo:mCornerRadius	I
    //   904: ifle +116 -> 1020
    //   907: aload_0
    //   908: aload 17
    //   910: aload 16
    //   912: getfield 316	com/tencent/image/downloader/GalleryDecoder$DownloadParamsExtraInfo:mCornerRadius	I
    //   915: invokevirtual 320	com/tencent/image/downloader/GalleryDecoder:resizeAndClipBitmap	(Landroid/graphics/Bitmap;I)Lcom/tencent/image/RoundRectBitmap;
    //   918: astore 18
    //   920: aload 18
    //   922: astore 16
    //   924: aload 18
    //   926: getfield 326	com/tencent/image/RoundRectBitmap:mBitmap	Landroid/graphics/Bitmap;
    //   929: aload 17
    //   931: invokevirtual 331	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   934: ifne -430 -> 504
    //   937: aload 17
    //   939: invokevirtual 242	android/graphics/Bitmap:recycle	()V
    //   942: aload 18
    //   944: astore 16
    //   946: goto -442 -> 504
    //   949: astore 16
    //   951: aload 16
    //   953: invokevirtual 334	java/lang/NullPointerException:printStackTrace	()V
    //   956: aconst_null
    //   957: areturn
    //   958: aload_2
    //   959: iload 8
    //   961: i2d
    //   962: invokestatic 249	java/lang/Math:ceil	(D)D
    //   965: d2i
    //   966: putfield 250	com/tencent/image/DownloadParams:outWidth	I
    //   969: aload_2
    //   970: iload 9
    //   972: i2d
    //   973: invokestatic 249	java/lang/Math:ceil	(D)D
    //   976: d2i
    //   977: putfield 251	com/tencent/image/DownloadParams:outHeight	I
    //   980: goto -426 -> 554
    //   983: astore_1
    //   984: iload 7
    //   986: istore 4
    //   988: iload 4
    //   990: ifne +8 -> 998
    //   993: aload 19
    //   995: invokevirtual 378	java/io/FileInputStream:close	()V
    //   998: aload_1
    //   999: athrow
    //   1000: astore_1
    //   1001: iload 5
    //   1003: istore 4
    //   1005: goto -17 -> 988
    //   1008: astore 16
    //   1010: iload 7
    //   1012: istore 6
    //   1014: goto -360 -> 654
    //   1017: goto -595 -> 422
    //   1020: aconst_null
    //   1021: astore 16
    //   1023: goto -519 -> 504
    //   1026: iload 5
    //   1028: istore 6
    //   1030: goto -882 -> 148
    //   1033: aload 17
    //   1035: astore 16
    //   1037: goto -533 -> 504
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1040	0	this	GalleryDecoder
    //   0	1040	1	paramFile	File
    //   0	1040	2	paramDownloadParams	DownloadParams
    //   0	1040	3	paramURLDrawableHandler	URLDrawableHandler
    //   0	1040	4	paramInt	int
    //   18	1009	5	i	int
    //   68	961	6	j	int
    //   14	997	7	k	int
    //   11	949	8	m	int
    //   50	921	9	n	int
    //   56	31	10	i1	int
    //   23	356	11	l1	long
    //   226	151	13	l2	long
    //   481	3	15	bool	boolean
    //   65	582	16	localObject1	Object
    //   649	42	16	localRuntimeException1	java.lang.RuntimeException
    //   726	1	16	localException	Exception
    //   749	78	16	localOutOfMemoryError	OutOfMemoryError
    //   865	80	16	localObject2	Object
    //   949	3	16	localNullPointerException	NullPointerException
    //   1008	1	16	localRuntimeException2	java.lang.RuntimeException
    //   1021	15	16	localObject3	Object
    //   32	1002	17	localObject4	Object
    //   918	25	18	localRoundRectBitmap	RoundRectBitmap
    //   8	986	19	localFileInputStream	FileInputStream
    //   280	520	20	localJpegOptions	com.tencent.mobileqq.pic.JpegOptions
    //   159	271	21	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   209	268	649	java/lang/RuntimeException
    //   268	317	649	java/lang/RuntimeException
    //   322	333	649	java/lang/RuntimeException
    //   333	392	649	java/lang/RuntimeException
    //   392	422	649	java/lang/RuntimeException
    //   422	438	649	java/lang/RuntimeException
    //   468	483	649	java/lang/RuntimeException
    //   488	504	649	java/lang/RuntimeException
    //   504	554	649	java/lang/RuntimeException
    //   558	646	649	java/lang/RuntimeException
    //   733	738	649	java/lang/RuntimeException
    //   738	749	649	java/lang/RuntimeException
    //   751	842	649	java/lang/RuntimeException
    //   848	857	649	java/lang/RuntimeException
    //   870	920	649	java/lang/RuntimeException
    //   924	942	649	java/lang/RuntimeException
    //   951	956	649	java/lang/RuntimeException
    //   958	980	649	java/lang/RuntimeException
    //   488	504	726	java/lang/Exception
    //   422	438	749	java/lang/OutOfMemoryError
    //   468	483	749	java/lang/OutOfMemoryError
    //   488	504	749	java/lang/OutOfMemoryError
    //   733	738	749	java/lang/OutOfMemoryError
    //   738	749	749	java/lang/OutOfMemoryError
    //   870	920	749	java/lang/OutOfMemoryError
    //   924	942	749	java/lang/OutOfMemoryError
    //   422	438	949	java/lang/NullPointerException
    //   468	483	949	java/lang/NullPointerException
    //   488	504	949	java/lang/NullPointerException
    //   733	738	949	java/lang/NullPointerException
    //   738	749	949	java/lang/NullPointerException
    //   870	920	949	java/lang/NullPointerException
    //   924	942	949	java/lang/NullPointerException
    //   209	268	983	finally
    //   268	317	983	finally
    //   322	333	983	finally
    //   333	392	983	finally
    //   392	422	983	finally
    //   422	438	983	finally
    //   468	483	983	finally
    //   488	504	983	finally
    //   504	554	983	finally
    //   558	646	983	finally
    //   733	738	983	finally
    //   738	749	983	finally
    //   751	842	983	finally
    //   848	857	983	finally
    //   870	920	983	finally
    //   924	942	983	finally
    //   951	956	983	finally
    //   958	980	983	finally
    //   20	25	1000	finally
    //   29	34	1000	finally
    //   38	46	1000	finally
    //   62	67	1000	finally
    //   152	161	1000	finally
    //   165	177	1000	finally
    //   181	197	1000	finally
    //   201	206	1000	finally
    //   453	458	1000	finally
    //   658	672	1000	finally
    //   676	697	1000	finally
    //   701	711	1000	finally
    //   20	25	1008	java/lang/RuntimeException
    //   29	34	1008	java/lang/RuntimeException
    //   38	46	1008	java/lang/RuntimeException
    //   62	67	1008	java/lang/RuntimeException
    //   152	161	1008	java/lang/RuntimeException
    //   165	177	1008	java/lang/RuntimeException
    //   181	197	1008	java/lang/RuntimeException
    //   201	206	1008	java/lang/RuntimeException
    //   453	458	1008	java/lang/RuntimeException
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
        if (URLDrawable.depImp.mLog.isColorLevel())
        {
          l2 = SystemClock.uptimeMillis();
          URLDrawable.depImp.mLog.d(getLogTag(), 2, "decode file:" + paramFile.getAbsolutePath() + " cost: " + (l2 - l1));
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
      if (URLDrawable.depImp.mLog.isColorLevel())
      {
        l2 = SystemClock.uptimeMillis();
        URLDrawable.depImp.mLog.d(getLogTag(), 2, "decode file:" + paramFile.getAbsolutePath() + " cost: " + (l2 - l1));
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