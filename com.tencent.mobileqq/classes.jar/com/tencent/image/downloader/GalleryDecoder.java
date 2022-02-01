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
import com.tencent.image.Utils;
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
    int j = 1;
    int i = 1;
    if (((paramInt6 == 2) || (paramInt3 == 2147483647) || (paramInt4 == 2147483647)) && (paramInt1 * paramInt2 <= this.mContext.getResources().getDisplayMetrics().widthPixels * this.mContext.getResources().getDisplayMetrics().heightPixels * 4)) {
      return 1;
    }
    if (paramInt6 == 1)
    {
      if ((paramInt5 == 5) || (paramInt5 == 6) || (paramInt5 == 7) || (paramInt5 == 8))
      {
        paramInt5 = paramInt2;
        paramInt2 = paramInt1;
        paramInt1 = paramInt5;
      }
      paramInt6 = paramInt1;
      paramInt5 = paramInt2;
      if (paramInt1 > paramInt3 * 2)
      {
        paramInt6 = paramInt1;
        paramInt5 = paramInt2;
        if (paramInt2 > paramInt4)
        {
          f1 = paramInt1;
          f2 = this.density;
          double d = f1 * f2;
          Double.isNaN(d);
          paramInt6 = (int)(d + 0.5D);
          d = paramInt2 * f2;
          Double.isNaN(d);
          paramInt5 = (int)(d + 0.5D);
        }
      }
      paramInt1 = paramInt5 * paramInt3 / paramInt6;
      float f3 = 1.0F;
      if (paramInt6 >= paramInt3) {
        if (paramInt4 >= paramInt1)
        {
          f2 = paramInt3;
          f1 = paramInt6;
        }
      }
      do
      {
        f1 = f2 / f1;
        break label350;
        f1 = paramInt4;
        if (1.5F * f1 < paramInt1) {
          break;
        }
        f1 /= paramInt5;
        break label350;
        if (paramInt5 < paramInt4)
        {
          if (paramInt4 >= paramInt1)
          {
            f1 = paramInt6;
            f2 = paramInt3;
            if (1.5F * f1 < f2) {
              break label347;
            }
            break label344;
          }
          f1 = paramInt5;
          f2 = paramInt4;
          if (1.5F * f1 < f2) {
            break label347;
          }
          break label344;
        }
        if (paramInt5 <= paramInt4) {
          break label347;
        }
        f1 = paramInt5;
        f2 = paramInt4;
      } while (f1 < 1.5F * f2);
      label344:
      label347:
      float f1 = 1.0F;
      label350:
      float f2 = f1;
      if (this.density > 2.0F)
      {
        f3 = 1.0F / f1 * 3.0F;
        f2 = 4.0F;
      }
      paramInt2 = (int)(f3 / f2);
      if (paramInt2 <= 1) {
        return 1;
      }
      paramInt1 = 64;
      if (paramInt2 > 64)
      {
        if (URLDrawable.depImp.mLog.isColorLevel()) {
          URLDrawable.depImp.mLog.d(getLogTag(), 2, "the pic it fxxking large.....");
        }
        return 64;
      }
      while (paramInt1 != 0)
      {
        paramInt3 = paramInt2 & paramInt1;
        if (paramInt3 != 0) {
          return paramInt3;
        }
        paramInt1 >>= 1;
      }
      return 1;
    }
    paramInt6 = j;
    if (paramInt3 != 0)
    {
      paramInt6 = j;
      if (paramInt4 != 0)
      {
        paramInt6 = j;
        if (paramInt3 != -1)
        {
          paramInt5 = i;
          if (paramInt4 == -1) {
            return 1;
          }
          for (;;)
          {
            if (paramInt2 <= paramInt4)
            {
              paramInt6 = paramInt5;
              if (paramInt1 <= paramInt3) {
                break;
              }
            }
            i = Math.round(paramInt2 / paramInt4);
            paramInt6 = Math.round(paramInt1 / paramInt3);
            if (i <= paramInt6) {
              i = paramInt6;
            }
            paramInt6 = paramInt5;
            if (i < 2) {
              break;
            }
            paramInt1 /= 2;
            paramInt2 /= 2;
            paramInt5 *= 2;
          }
        }
      }
    }
    return paramInt6;
  }
  
  private Object decodeFileNormal(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt)
  {
    paramURLDrawableHandler = new FileInputStream(paramFile);
    for (;;)
    {
      try
      {
        Object localObject1 = new byte[2];
        paramURLDrawableHandler.read((byte[])localObject1);
        int i = localObject1[0];
        i = localObject1[1] & 0xFF | i << 8 & 0xFF00;
        paramURLDrawableHandler.close();
        localObject1 = new FileInputStream(paramFile);
        try
        {
          paramURLDrawableHandler = Bitmap.Config.ARGB_8888;
          String str = null;
          if ((i != 8273) && (i != 16973))
          {
            if (i != 18249)
            {
              if ((i != 18761) && (i != 19789) && (i != 65496))
              {
                i = 0;
                continue;
              }
              i = 1;
            }
            else
            {
              ((InputStream)localObject1).close();
              return null;
            }
          }
          else {
            i = 0;
          }
          paramURLDrawableHandler = Bitmap.Config.RGB_565;
          BitmapFactory.Options localOptions = new BitmapFactory.Options();
          localOptions.inJustDecodeBounds = true;
          localOptions.inPreferredConfig = paramURLDrawableHandler;
          localOptions.inDensity = 160;
          localOptions.inTargetDensity = 160;
          localOptions.inScreenDensity = 160;
          SafeBitmapFactory.decodeStream((InputStream)localObject1, null, localOptions);
          int j = localOptions.outWidth;
          int k = localOptions.outHeight;
          ((InputStream)localObject1).close();
          if (i != 0) {}
          try
          {
            paramDownloadParams.outOrientation = JpegExifReader.readOrientation(paramFile.getAbsolutePath());
            localOptions.inJustDecodeBounds = false;
            i = calculateSampleSize(j, k, paramDownloadParams.reqWidth, paramDownloadParams.reqHeight, paramDownloadParams.outOrientation, paramInt);
            paramInt = 1;
            paramURLDrawableHandler = str;
            if (paramInt <= 3) {
              try
              {
                localOptions.inSampleSize = i;
                paramURLDrawableHandler = new SafeBitmapFactory.SafeDecodeOption();
                paramURLDrawableHandler.inOptions = localOptions;
                paramURLDrawableHandler.inNeedFlashBackTest = URLDrawable.depImp.mVersion.isPublicVersion();
                localObject2 = SafeBitmapFactory.safeDecode(paramFile.getAbsolutePath(), paramURLDrawableHandler);
                if (URLDrawable.depImp.mLog.isColorLevel())
                {
                  localObject3 = URLDrawable.depImp.mLog;
                  localObject4 = getLogTag();
                  StringBuilder localStringBuilder = new StringBuilder();
                  localStringBuilder.append("GalleryDecoder regionDecodeInfo:");
                  localStringBuilder.append(paramURLDrawableHandler.toString());
                  ((ILog)localObject3).d((String)localObject4, 2, localStringBuilder.toString());
                }
                reportSafeDecode(paramURLDrawableHandler);
                ((Bitmap)localObject2).setDensity(160);
                boolean bool = SliceBitmap.needSliceBitmap((Bitmap)localObject2);
                if (!bool) {}
              }
              catch (NullPointerException paramFile)
              {
                paramFile.printStackTrace();
                return null;
              }
              catch (OutOfMemoryError paramURLDrawableHandler)
              {
                Object localObject3;
                Object localObject4;
                if (URLDrawable.depImp.mLog.isColorLevel())
                {
                  localObject2 = URLDrawable.depImp.mLog;
                  localObject3 = getLogTag();
                  localObject4 = new StringBuilder();
                  ((StringBuilder)localObject4).append("DecodeFile ERROR,oom retryCount=");
                  ((StringBuilder)localObject4).append(paramInt);
                  ((StringBuilder)localObject4).append(",options.inSampleSize=");
                  ((StringBuilder)localObject4).append(localOptions.inSampleSize);
                  ((StringBuilder)localObject4).append(",url=");
                  ((StringBuilder)localObject4).append(paramDownloadParams.urlStr);
                  ((StringBuilder)localObject4).append(",oom.msg:");
                  ((StringBuilder)localObject4).append(paramURLDrawableHandler.getMessage());
                  ((ILog)localObject2).d((String)localObject3, 2, ((StringBuilder)localObject4).toString());
                }
                i *= 2;
                System.gc();
                Thread.yield();
                System.gc();
                paramInt += 1;
              }
            }
          }
          finally
          {
            Object localObject2;
            paramInt = 1;
          }
        }
        finally
        {
          paramDownloadParams = (DownloadParams)localObject1;
        }
      }
      finally
      {
        paramDownloadParams = paramURLDrawableHandler;
      }
      try
      {
        paramURLDrawableHandler = new SliceBitmap((Bitmap)localObject2);
        ((Bitmap)localObject2).recycle();
      }
      catch (Exception paramURLDrawableHandler)
      {
        continue;
      }
      if (localObject2 != null) {
        ((Bitmap)localObject2).recycle();
      }
      throw new OutOfMemoryError("slice failed.");
      if ((paramDownloadParams.mExtraInfo != null) && (GalleryDecoder.DownloadParamsExtraInfo.class.isInstance(paramDownloadParams.mExtraInfo)))
      {
        localObject3 = (GalleryDecoder.DownloadParamsExtraInfo)paramDownloadParams.mExtraInfo;
        paramURLDrawableHandler = str;
        if (((GalleryDecoder.DownloadParamsExtraInfo)localObject3).mCornerRadius > 0)
        {
          localObject3 = resizeAndClipBitmap((Bitmap)localObject2, ((GalleryDecoder.DownloadParamsExtraInfo)localObject3).mCornerRadius);
          paramURLDrawableHandler = (URLDrawableHandler)localObject3;
          if (!((RoundRectBitmap)localObject3).mBitmap.equals(localObject2))
          {
            ((Bitmap)localObject2).recycle();
            paramURLDrawableHandler = (URLDrawableHandler)localObject3;
          }
        }
      }
      else
      {
        paramURLDrawableHandler = (URLDrawableHandler)localObject2;
        continue;
        continue;
      }
      i = localOptions.inSampleSize;
      paramInt = 1;
      if (i > 1) {}
      try
      {
        if (paramDownloadParams.mAutoScaleByDensity)
        {
          paramDownloadParams.outWidth = ((int)Math.ceil(j * this.density));
          paramDownloadParams.outHeight = ((int)Math.ceil(k * this.density));
        }
        else
        {
          paramDownloadParams.outWidth = ((int)Math.ceil(j));
          paramDownloadParams.outHeight = ((int)Math.ceil(k));
        }
        if (URLDrawable.depImp.mLog.isColorLevel())
        {
          paramDownloadParams = URLDrawable.depImp.mLog;
          str = getLogTag();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("image file size:");
          ((StringBuilder)localObject2).append(paramFile.length());
          ((StringBuilder)localObject2).append(" , bound:");
          ((StringBuilder)localObject2).append(localOptions.outWidth);
          ((StringBuilder)localObject2).append("x");
          ((StringBuilder)localObject2).append(localOptions.outHeight);
          ((StringBuilder)localObject2).append(" , sampleSize: ");
          ((StringBuilder)localObject2).append(localOptions.inSampleSize);
          paramDownloadParams.d(str, 2, ((StringBuilder)localObject2).toString());
        }
        return paramURLDrawableHandler;
      }
      finally
      {
        paramDownloadParams = (DownloadParams)localObject1;
        break;
      }
      paramInt = 0;
    }
    if (paramInt == 0) {
      paramDownloadParams.close();
    }
    for (;;)
    {
      throw paramFile;
    }
  }
  
  /* Error */
  private Object decodeFileNormalWithTrubo(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 13
    //   6: aconst_null
    //   7: astore 12
    //   9: new 113	java/io/FileInputStream
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 116	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   17: astore 11
    //   19: iconst_2
    //   20: newarray byte
    //   22: astore 10
    //   24: aload 11
    //   26: aload 10
    //   28: invokevirtual 122	java/io/InputStream:read	([B)I
    //   31: pop
    //   32: aload 10
    //   34: iconst_0
    //   35: baload
    //   36: istore 5
    //   38: aload 10
    //   40: iconst_1
    //   41: baload
    //   42: sipush 255
    //   45: iand
    //   46: iload 5
    //   48: bipush 8
    //   50: ishl
    //   51: ldc 123
    //   53: iand
    //   54: ior
    //   55: istore 5
    //   57: getstatic 132	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   60: astore 10
    //   62: iload 5
    //   64: sipush 8273
    //   67: if_icmpeq +61 -> 128
    //   70: iload 5
    //   72: sipush 16973
    //   75: if_icmpeq +53 -> 128
    //   78: iload 5
    //   80: sipush 18249
    //   83: if_icmpeq +38 -> 121
    //   86: iload 5
    //   88: sipush 18761
    //   91: if_icmpeq +24 -> 115
    //   94: iload 5
    //   96: sipush 19789
    //   99: if_icmpeq +16 -> 115
    //   102: iload 5
    //   104: ldc 133
    //   106: if_icmpeq +9 -> 115
    //   109: iconst_0
    //   110: istore 5
    //   112: goto +24 -> 136
    //   115: iconst_1
    //   116: istore 5
    //   118: goto +13 -> 131
    //   121: aload 11
    //   123: invokevirtual 126	java/io/InputStream:close	()V
    //   126: aconst_null
    //   127: areturn
    //   128: iconst_0
    //   129: istore 5
    //   131: getstatic 136	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   134: astore 10
    //   136: new 346	com/tencent/mobileqq/pic/JpegOptions
    //   139: dup
    //   140: invokespecial 347	com/tencent/mobileqq/pic/JpegOptions:<init>	()V
    //   143: astore 15
    //   145: aload 15
    //   147: iconst_1
    //   148: putfield 348	com/tencent/mobileqq/pic/JpegOptions:inJustDecodeBounds	Z
    //   151: aload 15
    //   153: aload 10
    //   155: putfield 349	com/tencent/mobileqq/pic/JpegOptions:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   158: aload_1
    //   159: invokevirtual 172	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   162: aload 15
    //   164: invokestatic 355	com/tencent/mobileqq/pic/JpegDecompressor:decodeFile	(Ljava/lang/String;Lcom/tencent/mobileqq/pic/JpegOptions;)Landroid/graphics/Bitmap;
    //   167: pop
    //   168: aload 15
    //   170: getfield 356	com/tencent/mobileqq/pic/JpegOptions:outWidth	I
    //   173: istore 7
    //   175: aload 15
    //   177: getfield 357	com/tencent/mobileqq/pic/JpegOptions:outHeight	I
    //   180: istore 8
    //   182: iload 5
    //   184: ifeq +14 -> 198
    //   187: aload_2
    //   188: aload_1
    //   189: invokevirtual 172	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   192: invokestatic 178	com/tencent/image/JpegExifReader:readOrientation	(Ljava/lang/String;)I
    //   195: putfield 183	com/tencent/image/DownloadParams:outOrientation	I
    //   198: aload 15
    //   200: iconst_0
    //   201: putfield 348	com/tencent/mobileqq/pic/JpegOptions:inJustDecodeBounds	Z
    //   204: aload_0
    //   205: iload 7
    //   207: iload 8
    //   209: aload_2
    //   210: getfield 186	com/tencent/image/DownloadParams:reqWidth	I
    //   213: aload_2
    //   214: getfield 189	com/tencent/image/DownloadParams:reqHeight	I
    //   217: aload_2
    //   218: getfield 183	com/tencent/image/DownloadParams:outOrientation	I
    //   221: iload 4
    //   223: invokespecial 191	com/tencent/image/downloader/GalleryDecoder:calculateSampleSize	(IIIIII)I
    //   226: istore 6
    //   228: iconst_1
    //   229: istore 5
    //   231: aload 12
    //   233: astore 10
    //   235: iload 5
    //   237: iconst_3
    //   238: if_icmpgt +338 -> 576
    //   241: aload 15
    //   243: iload 6
    //   245: putfield 358	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   248: aload_1
    //   249: invokevirtual 172	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   252: aload 15
    //   254: invokestatic 355	com/tencent/mobileqq/pic/JpegDecompressor:decodeFile	(Ljava/lang/String;Lcom/tencent/mobileqq/pic/JpegOptions;)Landroid/graphics/Bitmap;
    //   257: astore 13
    //   259: aload 13
    //   261: ifnonnull +10 -> 271
    //   264: aload 11
    //   266: invokevirtual 126	java/io/InputStream:close	()V
    //   269: aconst_null
    //   270: areturn
    //   271: aload 13
    //   273: sipush 160
    //   276: invokevirtual 240	android/graphics/Bitmap:setDensity	(I)V
    //   279: aload 13
    //   281: invokestatic 246	com/tencent/image/SliceBitmap:needSliceBitmap	(Landroid/graphics/Bitmap;)Z
    //   284: istore 9
    //   286: iload 9
    //   288: ifeq +42 -> 330
    //   291: new 242	com/tencent/image/SliceBitmap
    //   294: dup
    //   295: aload 13
    //   297: invokespecial 249	com/tencent/image/SliceBitmap:<init>	(Landroid/graphics/Bitmap;)V
    //   300: astore 10
    //   302: aload 13
    //   304: invokevirtual 252	android/graphics/Bitmap:recycle	()V
    //   307: goto +269 -> 576
    //   310: aload 13
    //   312: ifnull +8 -> 320
    //   315: aload 13
    //   317: invokevirtual 252	android/graphics/Bitmap:recycle	()V
    //   320: new 107	java/lang/OutOfMemoryError
    //   323: dup
    //   324: ldc 254
    //   326: invokespecial 257	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   329: athrow
    //   330: aload_2
    //   331: getfield 261	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   334: ifnull +81 -> 415
    //   337: ldc_w 263
    //   340: aload_2
    //   341: getfield 261	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   344: invokevirtual 269	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   347: ifeq +68 -> 415
    //   350: aload_2
    //   351: getfield 261	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   354: checkcast 263	com/tencent/image/downloader/GalleryDecoder$DownloadParamsExtraInfo
    //   357: astore 10
    //   359: aload 10
    //   361: getfield 272	com/tencent/image/downloader/GalleryDecoder$DownloadParamsExtraInfo:mCornerRadius	I
    //   364: ifle +45 -> 409
    //   367: aload_0
    //   368: aload 13
    //   370: aload 10
    //   372: getfield 272	com/tencent/image/downloader/GalleryDecoder$DownloadParamsExtraInfo:mCornerRadius	I
    //   375: invokevirtual 276	com/tencent/image/downloader/GalleryDecoder:resizeAndClipBitmap	(Landroid/graphics/Bitmap;I)Lcom/tencent/image/RoundRectBitmap;
    //   378: astore 14
    //   380: aload 14
    //   382: astore 10
    //   384: aload 14
    //   386: getfield 282	com/tencent/image/RoundRectBitmap:mBitmap	Landroid/graphics/Bitmap;
    //   389: aload 13
    //   391: invokevirtual 287	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   394: ifne -87 -> 307
    //   397: aload 13
    //   399: invokevirtual 252	android/graphics/Bitmap:recycle	()V
    //   402: aload 14
    //   404: astore 10
    //   406: goto -99 -> 307
    //   409: aconst_null
    //   410: astore 10
    //   412: goto -105 -> 307
    //   415: aload 13
    //   417: astore 10
    //   419: goto +157 -> 576
    //   422: astore 10
    //   424: getstatic 75	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   427: getfield 81	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   430: invokeinterface 87 1 0
    //   435: ifeq +117 -> 552
    //   438: getstatic 75	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   441: getfield 81	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   444: astore 13
    //   446: aload_0
    //   447: invokevirtual 91	com/tencent/image/downloader/GalleryDecoder:getLogTag	()Ljava/lang/String;
    //   450: astore 14
    //   452: new 219	java/lang/StringBuilder
    //   455: dup
    //   456: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   459: astore 16
    //   461: aload 16
    //   463: ldc_w 292
    //   466: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: pop
    //   470: aload 16
    //   472: iload 5
    //   474: invokevirtual 295	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   477: pop
    //   478: aload 16
    //   480: ldc_w 297
    //   483: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: pop
    //   487: aload 16
    //   489: aload 15
    //   491: getfield 358	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   494: invokevirtual 295	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   497: pop
    //   498: aload 16
    //   500: ldc_w 299
    //   503: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: pop
    //   507: aload 16
    //   509: aload_2
    //   510: getfield 302	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   513: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: pop
    //   517: aload 16
    //   519: ldc_w 304
    //   522: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: pop
    //   526: aload 16
    //   528: aload 10
    //   530: invokevirtual 307	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   533: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: pop
    //   537: aload 13
    //   539: aload 14
    //   541: iconst_2
    //   542: aload 16
    //   544: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   547: invokeinterface 97 4 0
    //   552: iload 6
    //   554: iconst_2
    //   555: imul
    //   556: istore 6
    //   558: invokestatic 312	java/lang/System:gc	()V
    //   561: invokestatic 317	java/lang/Thread:yield	()V
    //   564: invokestatic 312	java/lang/System:gc	()V
    //   567: iload 5
    //   569: iconst_1
    //   570: iadd
    //   571: istore 5
    //   573: goto -342 -> 231
    //   576: aload 15
    //   578: getfield 358	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   581: iconst_1
    //   582: if_icmple +69 -> 651
    //   585: aload_2
    //   586: getfield 320	com/tencent/image/DownloadParams:mAutoScaleByDensity	Z
    //   589: ifeq +40 -> 629
    //   592: aload_2
    //   593: iload 7
    //   595: i2f
    //   596: aload_0
    //   597: getfield 49	com/tencent/image/downloader/GalleryDecoder:density	F
    //   600: fmul
    //   601: f2d
    //   602: invokestatic 324	java/lang/Math:ceil	(D)D
    //   605: d2i
    //   606: putfield 325	com/tencent/image/DownloadParams:outWidth	I
    //   609: aload_2
    //   610: iload 8
    //   612: i2f
    //   613: aload_0
    //   614: getfield 49	com/tencent/image/downloader/GalleryDecoder:density	F
    //   617: fmul
    //   618: f2d
    //   619: invokestatic 324	java/lang/Math:ceil	(D)D
    //   622: d2i
    //   623: putfield 326	com/tencent/image/DownloadParams:outHeight	I
    //   626: goto +25 -> 651
    //   629: aload_2
    //   630: iload 7
    //   632: i2d
    //   633: invokestatic 324	java/lang/Math:ceil	(D)D
    //   636: d2i
    //   637: putfield 325	com/tencent/image/DownloadParams:outWidth	I
    //   640: aload_2
    //   641: iload 8
    //   643: i2d
    //   644: invokestatic 324	java/lang/Math:ceil	(D)D
    //   647: d2i
    //   648: putfield 326	com/tencent/image/DownloadParams:outHeight	I
    //   651: getstatic 75	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   654: getfield 81	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   657: invokeinterface 87 1 0
    //   662: ifeq +120 -> 782
    //   665: getstatic 75	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   668: getfield 81	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   671: astore 12
    //   673: aload_0
    //   674: invokevirtual 91	com/tencent/image/downloader/GalleryDecoder:getLogTag	()Ljava/lang/String;
    //   677: astore 13
    //   679: new 219	java/lang/StringBuilder
    //   682: dup
    //   683: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   686: astore 14
    //   688: aload 14
    //   690: ldc_w 328
    //   693: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: pop
    //   697: aload 14
    //   699: aload_1
    //   700: invokevirtual 332	java/io/File:length	()J
    //   703: invokevirtual 335	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   706: pop
    //   707: aload 14
    //   709: ldc_w 337
    //   712: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: pop
    //   716: aload 14
    //   718: aload 15
    //   720: getfield 356	com/tencent/mobileqq/pic/JpegOptions:outWidth	I
    //   723: invokevirtual 295	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   726: pop
    //   727: aload 14
    //   729: ldc_w 339
    //   732: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: pop
    //   736: aload 14
    //   738: aload 15
    //   740: getfield 357	com/tencent/mobileqq/pic/JpegOptions:outHeight	I
    //   743: invokevirtual 295	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   746: pop
    //   747: aload 14
    //   749: ldc_w 341
    //   752: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   755: pop
    //   756: aload 14
    //   758: aload 15
    //   760: getfield 358	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   763: invokevirtual 295	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   766: pop
    //   767: aload 12
    //   769: aload 13
    //   771: iconst_2
    //   772: aload 14
    //   774: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   777: invokeinterface 97 4 0
    //   782: aload 11
    //   784: invokevirtual 126	java/io/InputStream:close	()V
    //   787: aload 10
    //   789: areturn
    //   790: astore_1
    //   791: aload 11
    //   793: astore 10
    //   795: goto +92 -> 887
    //   798: astore 12
    //   800: goto +18 -> 818
    //   803: astore 12
    //   805: aload 13
    //   807: astore 11
    //   809: goto +9 -> 818
    //   812: astore_1
    //   813: goto +74 -> 887
    //   816: astore 10
    //   818: aload 11
    //   820: astore 10
    //   822: getstatic 75	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   825: getfield 81	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   828: invokeinterface 87 1 0
    //   833: ifeq +28 -> 861
    //   836: aload 11
    //   838: astore 10
    //   840: getstatic 75	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   843: getfield 81	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   846: aload_0
    //   847: invokevirtual 91	com/tencent/image/downloader/GalleryDecoder:getLogTag	()Ljava/lang/String;
    //   850: iconst_2
    //   851: ldc_w 360
    //   854: aload 12
    //   856: invokeinterface 364 5 0
    //   861: aload 11
    //   863: astore 10
    //   865: aload_0
    //   866: aload_1
    //   867: aload_2
    //   868: aload_3
    //   869: iload 4
    //   871: invokespecial 366	com/tencent/image/downloader/GalleryDecoder:decodeFileNormal	(Ljava/io/File;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;I)Ljava/lang/Object;
    //   874: astore_1
    //   875: aload 11
    //   877: ifnull +8 -> 885
    //   880: aload 11
    //   882: invokevirtual 126	java/io/InputStream:close	()V
    //   885: aload_1
    //   886: areturn
    //   887: aload 10
    //   889: ifnull +8 -> 897
    //   892: aload 10
    //   894: invokevirtual 126	java/io/InputStream:close	()V
    //   897: goto +5 -> 902
    //   900: aload_1
    //   901: athrow
    //   902: goto -2 -> 900
    //   905: astore 10
    //   907: goto -597 -> 310
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	910	0	this	GalleryDecoder
    //   0	910	1	paramFile	File
    //   0	910	2	paramDownloadParams	DownloadParams
    //   0	910	3	paramURLDrawableHandler	URLDrawableHandler
    //   0	910	4	paramInt	int
    //   36	536	5	i	int
    //   226	331	6	j	int
    //   173	458	7	k	int
    //   180	462	8	m	int
    //   284	3	9	bool	boolean
    //   1	417	10	localObject1	Object
    //   422	366	10	localOutOfMemoryError	OutOfMemoryError
    //   793	1	10	localObject2	Object
    //   17	791	11	localObject3	Object
    //   7	761	12	localILog	ILog
    //   798	1	12	localRuntimeException1	java.lang.RuntimeException
    //   803	1	12	localRuntimeException2	java.lang.RuntimeException
    //   4	802	13	localObject4	Object
    //   378	395	14	localObject5	Object
    //   143	616	15	localJpegOptions	com.tencent.mobileqq.pic.JpegOptions
    //   459	84	16	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   241	259	422	java/lang/OutOfMemoryError
    //   271	286	422	java/lang/OutOfMemoryError
    //   291	307	422	java/lang/OutOfMemoryError
    //   315	320	422	java/lang/OutOfMemoryError
    //   320	330	422	java/lang/OutOfMemoryError
    //   330	380	422	java/lang/OutOfMemoryError
    //   384	402	422	java/lang/OutOfMemoryError
    //   19	32	790	finally
    //   57	62	790	finally
    //   131	136	790	finally
    //   136	182	790	finally
    //   187	198	790	finally
    //   198	228	790	finally
    //   241	259	790	finally
    //   271	286	790	finally
    //   291	307	790	finally
    //   315	320	790	finally
    //   320	330	790	finally
    //   330	380	790	finally
    //   384	402	790	finally
    //   424	552	790	finally
    //   558	567	790	finally
    //   576	626	790	finally
    //   629	651	790	finally
    //   651	782	790	finally
    //   19	32	798	java/lang/RuntimeException
    //   57	62	798	java/lang/RuntimeException
    //   131	136	798	java/lang/RuntimeException
    //   136	182	798	java/lang/RuntimeException
    //   187	198	798	java/lang/RuntimeException
    //   198	228	798	java/lang/RuntimeException
    //   241	259	798	java/lang/RuntimeException
    //   271	286	798	java/lang/RuntimeException
    //   291	307	798	java/lang/RuntimeException
    //   315	320	798	java/lang/RuntimeException
    //   320	330	798	java/lang/RuntimeException
    //   330	380	798	java/lang/RuntimeException
    //   384	402	798	java/lang/RuntimeException
    //   424	552	798	java/lang/RuntimeException
    //   558	567	798	java/lang/RuntimeException
    //   576	626	798	java/lang/RuntimeException
    //   629	651	798	java/lang/RuntimeException
    //   651	782	798	java/lang/RuntimeException
    //   9	19	803	java/lang/RuntimeException
    //   9	19	812	finally
    //   822	836	812	finally
    //   840	861	812	finally
    //   865	875	812	finally
    //   291	307	905	java/lang/Exception
  }
  
  private Object decodeFileWidthByteArray(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt)
  {
    FileInputStream localFileInputStream = new FileInputStream(paramFile);
    for (;;)
    {
      try
      {
        long l1 = SystemClock.uptimeMillis();
        Object localObject1 = new byte[2];
        localFileInputStream.read((byte[])localObject1);
        int i = localObject1[0] << 8 & 0xFF00 | localObject1[1] & 0xFF;
        paramURLDrawableHandler = Bitmap.Config.ARGB_8888;
        String str = null;
        if ((i != 8273) && (i != 16973))
        {
          if (i != 18249)
          {
            if ((i != 18761) && (i != 19789) && (i != 65496))
            {
              i = 0;
              continue;
            }
            i = 1;
          }
          else
          {
            localFileInputStream.close();
            return null;
          }
        }
        else {
          i = 0;
        }
        paramURLDrawableHandler = Bitmap.Config.RGB_565;
        byte[] arrayOfByte = new byte[(int)paramFile.length()];
        System.arraycopy(localObject1, 0, arrayOfByte, 0, localObject1.length);
        localFileInputStream.read(arrayOfByte, localObject1.length, localFileInputStream.available());
        localFileInputStream.close();
        try
        {
          long l2;
          Object localObject2;
          if (URLDrawable.depImp.mLog.isColorLevel())
          {
            l2 = SystemClock.uptimeMillis();
            localObject1 = URLDrawable.depImp.mLog;
            localObject2 = getLogTag();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("read file to memory cost: ");
            ((StringBuilder)localObject3).append(l2 - l1);
            ((ILog)localObject1).d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
          }
          l1 = SystemClock.uptimeMillis();
          localObject3 = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject3).inJustDecodeBounds = true;
          ((BitmapFactory.Options)localObject3).inPreferredConfig = paramURLDrawableHandler;
          ((BitmapFactory.Options)localObject3).inDensity = 160;
          ((BitmapFactory.Options)localObject3).inTargetDensity = 160;
          ((BitmapFactory.Options)localObject3).inScreenDensity = 160;
          ((BitmapFactory.Options)localObject3).inPurgeable = true;
          ((BitmapFactory.Options)localObject3).inInputShareable = true;
          SafeBitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, (BitmapFactory.Options)localObject3);
          j = ((BitmapFactory.Options)localObject3).outWidth;
          k = ((BitmapFactory.Options)localObject3).outHeight;
          if (i != 0) {
            paramDownloadParams.outOrientation = JpegExifReader.readOrientation(paramFile.getAbsolutePath());
          } else {
            paramDownloadParams.outOrientation = Utils.getHeifOrientation(paramFile.getAbsolutePath());
          }
          if (URLDrawable.depImp.mLog.isColorLevel())
          {
            l2 = SystemClock.uptimeMillis();
            paramURLDrawableHandler = URLDrawable.depImp.mLog;
            localObject1 = getLogTag();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("read size & exif cost: ");
            ((StringBuilder)localObject2).append(l2 - l1);
            paramURLDrawableHandler.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
          }
          ((BitmapFactory.Options)localObject3).inJustDecodeBounds = false;
          paramInt = calculateSampleSize(j, k, paramDownloadParams.reqWidth, paramDownloadParams.reqHeight, paramDownloadParams.outOrientation, paramInt);
          try
          {
            ((BitmapFactory.Options)localObject3).inSampleSize = paramInt;
            localObject1 = SafeBitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, (BitmapFactory.Options)localObject3);
            ((Bitmap)localObject1).setDensity(160);
            boolean bool = SliceBitmap.needSliceBitmap((Bitmap)localObject1);
            if (!bool) {}
          }
          catch (NullPointerException paramFile)
          {
            paramFile.printStackTrace();
            return null;
          }
          catch (OutOfMemoryError paramURLDrawableHandler)
          {
            if (URLDrawable.depImp.mLog.isColorLevel())
            {
              localObject1 = URLDrawable.depImp.mLog;
              localObject2 = getLogTag();
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("DecodeFile ERROR,oom retryCount=");
              localStringBuilder.append(1);
              localStringBuilder.append(",options.inSampleSize=");
              localStringBuilder.append(((BitmapFactory.Options)localObject3).inSampleSize);
              localStringBuilder.append(",url=");
              localStringBuilder.append(paramDownloadParams.urlStr);
              localStringBuilder.append(",oom.msg:");
              localStringBuilder.append(paramURLDrawableHandler.getMessage());
              ((ILog)localObject1).d((String)localObject2, 2, localStringBuilder.toString());
            }
            i = paramInt * 2;
            System.gc();
            Thread.yield();
            System.gc();
            paramInt = i;
          }
        }
        finally
        {
          Object localObject3;
          int j;
          int k;
          paramInt = 1;
        }
      }
      finally
      {
        paramInt = 0;
      }
      try
      {
        paramURLDrawableHandler = new SliceBitmap((Bitmap)localObject1);
        ((Bitmap)localObject1).recycle();
      }
      catch (Exception paramURLDrawableHandler)
      {
        continue;
        continue;
      }
      if (localObject1 != null) {
        ((Bitmap)localObject1).recycle();
      }
      throw new OutOfMemoryError("slice failed.");
      if ((paramDownloadParams.mExtraInfo != null) && (GalleryDecoder.DownloadParamsExtraInfo.class.isInstance(paramDownloadParams.mExtraInfo)))
      {
        localObject2 = (GalleryDecoder.DownloadParamsExtraInfo)paramDownloadParams.mExtraInfo;
        paramURLDrawableHandler = str;
        if (((GalleryDecoder.DownloadParamsExtraInfo)localObject2).mCornerRadius > 0)
        {
          localObject2 = resizeAndClipBitmap((Bitmap)localObject1, ((GalleryDecoder.DownloadParamsExtraInfo)localObject2).mCornerRadius);
          paramURLDrawableHandler = (URLDrawableHandler)localObject2;
          if (!((RoundRectBitmap)localObject2).mBitmap.equals(localObject1))
          {
            ((Bitmap)localObject1).recycle();
            paramURLDrawableHandler = (URLDrawableHandler)localObject2;
          }
        }
      }
      else
      {
        paramURLDrawableHandler = (URLDrawableHandler)localObject1;
        continue;
        if (i > 8) {
          continue;
        }
        paramURLDrawableHandler = str;
      }
      i = ((BitmapFactory.Options)localObject3).inSampleSize;
      paramInt = 1;
      if (i <= 1) {
        break label1045;
      }
      try
      {
        if (paramDownloadParams.mAutoScaleByDensity)
        {
          paramDownloadParams.outWidth = ((int)Math.ceil(j * this.density));
          paramDownloadParams.outHeight = ((int)Math.ceil(k * this.density));
        }
        else
        {
          paramDownloadParams.outWidth = ((int)Math.ceil(j));
          paramDownloadParams.outHeight = ((int)Math.ceil(k));
        }
        if (URLDrawable.depImp.mLog.isColorLevel())
        {
          paramDownloadParams = URLDrawable.depImp.mLog;
          str = getLogTag();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("image file size:");
          ((StringBuilder)localObject1).append(paramFile.length());
          ((StringBuilder)localObject1).append(" , bound:");
          ((StringBuilder)localObject1).append(j);
          ((StringBuilder)localObject1).append("x");
          ((StringBuilder)localObject1).append(k);
          ((StringBuilder)localObject1).append(" , sampleSize: ");
          ((StringBuilder)localObject1).append(((BitmapFactory.Options)localObject3).inSampleSize);
          paramDownloadParams.d(str, 2, ((StringBuilder)localObject1).toString());
        }
        return paramURLDrawableHandler;
      }
      finally
      {
        break label1023;
      }
    }
    label1023:
    if (paramInt == 0) {
      localFileInputStream.close();
    }
    for (;;)
    {
      throw paramFile;
    }
  }
  
  /* Error */
  private Object decodeFileWidthByteArrayWithTrubo(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt)
  {
    // Byte code:
    //   0: new 113	java/io/FileInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 116	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore 16
    //   10: iconst_1
    //   11: istore 6
    //   13: invokestatic 372	android/os/SystemClock:uptimeMillis	()J
    //   16: lstore 9
    //   18: iconst_2
    //   19: newarray byte
    //   21: astore 15
    //   23: aload 16
    //   25: aload 15
    //   27: invokevirtual 373	java/io/FileInputStream:read	([B)I
    //   30: pop
    //   31: aload 15
    //   33: iconst_0
    //   34: baload
    //   35: bipush 8
    //   37: ishl
    //   38: ldc 123
    //   40: iand
    //   41: aload 15
    //   43: iconst_1
    //   44: baload
    //   45: sipush 255
    //   48: iand
    //   49: ior
    //   50: istore 5
    //   52: getstatic 132	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   55: astore 14
    //   57: iload 5
    //   59: sipush 8273
    //   62: if_icmpeq +61 -> 123
    //   65: iload 5
    //   67: sipush 16973
    //   70: if_icmpeq +53 -> 123
    //   73: iload 5
    //   75: sipush 18249
    //   78: if_icmpeq +38 -> 116
    //   81: iload 5
    //   83: sipush 18761
    //   86: if_icmpeq +24 -> 110
    //   89: iload 5
    //   91: sipush 19789
    //   94: if_icmpeq +16 -> 110
    //   97: iload 5
    //   99: ldc 133
    //   101: if_icmpeq +9 -> 110
    //   104: iconst_0
    //   105: istore 5
    //   107: goto +24 -> 131
    //   110: iconst_1
    //   111: istore 5
    //   113: goto +13 -> 126
    //   116: aload 16
    //   118: invokevirtual 374	java/io/FileInputStream:close	()V
    //   121: aconst_null
    //   122: areturn
    //   123: iconst_0
    //   124: istore 5
    //   126: getstatic 136	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   129: astore 14
    //   131: aload_1
    //   132: invokevirtual 332	java/io/File:length	()J
    //   135: l2i
    //   136: newarray byte
    //   138: astore 18
    //   140: aload 15
    //   142: iconst_0
    //   143: aload 18
    //   145: iconst_0
    //   146: aload 15
    //   148: arraylength
    //   149: invokestatic 378	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   152: aload 16
    //   154: aload 18
    //   156: aload 15
    //   158: arraylength
    //   159: aload 16
    //   161: invokevirtual 382	java/io/FileInputStream:available	()I
    //   164: invokevirtual 385	java/io/FileInputStream:read	([BII)I
    //   167: pop
    //   168: aload 16
    //   170: invokevirtual 374	java/io/FileInputStream:close	()V
    //   173: getstatic 75	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   176: getfield 81	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   179: invokeinterface 87 1 0
    //   184: istore 13
    //   186: iload 13
    //   188: ifeq +78 -> 266
    //   191: invokestatic 372	android/os/SystemClock:uptimeMillis	()J
    //   194: lstore 11
    //   196: getstatic 75	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   199: getfield 81	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   202: astore 15
    //   204: aload_0
    //   205: invokevirtual 91	com/tencent/image/downloader/GalleryDecoder:getLogTag	()Ljava/lang/String;
    //   208: astore 17
    //   210: new 219	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   217: astore 19
    //   219: aload 19
    //   221: ldc_w 387
    //   224: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: aload 19
    //   230: lload 11
    //   232: lload 9
    //   234: lsub
    //   235: invokevirtual 335	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload 15
    //   241: aload 17
    //   243: iconst_2
    //   244: aload 19
    //   246: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokeinterface 97 4 0
    //   254: goto +12 -> 266
    //   257: astore 14
    //   259: iload 6
    //   261: istore 5
    //   263: goto +774 -> 1037
    //   266: invokestatic 372	android/os/SystemClock:uptimeMillis	()J
    //   269: lstore 9
    //   271: new 346	com/tencent/mobileqq/pic/JpegOptions
    //   274: dup
    //   275: invokespecial 347	com/tencent/mobileqq/pic/JpegOptions:<init>	()V
    //   278: astore 17
    //   280: aload 17
    //   282: iconst_1
    //   283: putfield 348	com/tencent/mobileqq/pic/JpegOptions:inJustDecodeBounds	Z
    //   286: aload 17
    //   288: aload 14
    //   290: putfield 349	com/tencent/mobileqq/pic/JpegOptions:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   293: aload 18
    //   295: aload 17
    //   297: invokestatic 408	com/tencent/mobileqq/pic/JpegDecompressor:decodeByteArray	([BLcom/tencent/mobileqq/pic/JpegOptions;)Landroid/graphics/Bitmap;
    //   300: pop
    //   301: aload 17
    //   303: getfield 356	com/tencent/mobileqq/pic/JpegOptions:outWidth	I
    //   306: istore 7
    //   308: aload 17
    //   310: getfield 357	com/tencent/mobileqq/pic/JpegOptions:outHeight	I
    //   313: istore 8
    //   315: iload 5
    //   317: ifeq +14 -> 331
    //   320: aload_2
    //   321: aload_1
    //   322: invokevirtual 172	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   325: invokestatic 178	com/tencent/image/JpegExifReader:readOrientation	(Ljava/lang/String;)I
    //   328: putfield 183	com/tencent/image/DownloadParams:outOrientation	I
    //   331: getstatic 75	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   334: getfield 81	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   337: invokeinterface 87 1 0
    //   342: istore 13
    //   344: iload 13
    //   346: ifeq +74 -> 420
    //   349: invokestatic 372	android/os/SystemClock:uptimeMillis	()J
    //   352: lstore 11
    //   354: getstatic 75	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   357: getfield 81	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   360: astore 14
    //   362: aload_0
    //   363: invokevirtual 91	com/tencent/image/downloader/GalleryDecoder:getLogTag	()Ljava/lang/String;
    //   366: astore 15
    //   368: new 219	java/lang/StringBuilder
    //   371: dup
    //   372: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   375: astore 19
    //   377: aload 19
    //   379: ldc_w 404
    //   382: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: pop
    //   386: aload 19
    //   388: lload 11
    //   390: lload 9
    //   392: lsub
    //   393: invokevirtual 335	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   396: pop
    //   397: aload 14
    //   399: aload 15
    //   401: iconst_2
    //   402: aload 19
    //   404: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: invokeinterface 97 4 0
    //   412: goto +8 -> 420
    //   415: astore 14
    //   417: goto +602 -> 1019
    //   420: aload 17
    //   422: iconst_0
    //   423: putfield 348	com/tencent/mobileqq/pic/JpegOptions:inJustDecodeBounds	Z
    //   426: aload_0
    //   427: iload 7
    //   429: iload 8
    //   431: aload_2
    //   432: getfield 186	com/tencent/image/DownloadParams:reqWidth	I
    //   435: aload_2
    //   436: getfield 189	com/tencent/image/DownloadParams:reqHeight	I
    //   439: aload_2
    //   440: getfield 183	com/tencent/image/DownloadParams:outOrientation	I
    //   443: iload 4
    //   445: invokespecial 191	com/tencent/image/downloader/GalleryDecoder:calculateSampleSize	(IIIIII)I
    //   448: istore 5
    //   450: aload 17
    //   452: iload 5
    //   454: putfield 358	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   457: aload 18
    //   459: aload 17
    //   461: invokestatic 408	com/tencent/mobileqq/pic/JpegDecompressor:decodeByteArray	([BLcom/tencent/mobileqq/pic/JpegOptions;)Landroid/graphics/Bitmap;
    //   464: astore 15
    //   466: aload 15
    //   468: ifnonnull +6 -> 474
    //   471: aload 15
    //   473: areturn
    //   474: aload 15
    //   476: sipush 160
    //   479: invokevirtual 240	android/graphics/Bitmap:setDensity	(I)V
    //   482: aload 15
    //   484: invokestatic 246	com/tencent/image/SliceBitmap:needSliceBitmap	(Landroid/graphics/Bitmap;)Z
    //   487: istore 13
    //   489: iload 13
    //   491: ifeq +42 -> 533
    //   494: new 242	com/tencent/image/SliceBitmap
    //   497: dup
    //   498: aload 15
    //   500: invokespecial 249	com/tencent/image/SliceBitmap:<init>	(Landroid/graphics/Bitmap;)V
    //   503: astore 14
    //   505: aload 15
    //   507: invokevirtual 252	android/graphics/Bitmap:recycle	()V
    //   510: goto +612 -> 1122
    //   513: aload 15
    //   515: ifnull +8 -> 523
    //   518: aload 15
    //   520: invokevirtual 252	android/graphics/Bitmap:recycle	()V
    //   523: new 107	java/lang/OutOfMemoryError
    //   526: dup
    //   527: ldc 254
    //   529: invokespecial 257	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   532: athrow
    //   533: aload 15
    //   535: astore 14
    //   537: aload_2
    //   538: getfield 261	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   541: ifnull +251 -> 792
    //   544: aload 15
    //   546: astore 14
    //   548: ldc_w 263
    //   551: aload_2
    //   552: getfield 261	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   555: invokevirtual 269	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   558: ifeq +234 -> 792
    //   561: aload_2
    //   562: getfield 261	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   565: checkcast 263	com/tencent/image/downloader/GalleryDecoder$DownloadParamsExtraInfo
    //   568: astore 14
    //   570: aload 14
    //   572: getfield 272	com/tencent/image/downloader/GalleryDecoder$DownloadParamsExtraInfo:mCornerRadius	I
    //   575: ifle +37 -> 612
    //   578: aload_0
    //   579: aload 15
    //   581: aload 14
    //   583: getfield 272	com/tencent/image/downloader/GalleryDecoder$DownloadParamsExtraInfo:mCornerRadius	I
    //   586: invokevirtual 276	com/tencent/image/downloader/GalleryDecoder:resizeAndClipBitmap	(Landroid/graphics/Bitmap;I)Lcom/tencent/image/RoundRectBitmap;
    //   589: astore 14
    //   591: aload 14
    //   593: getfield 282	com/tencent/image/RoundRectBitmap:mBitmap	Landroid/graphics/Bitmap;
    //   596: aload 15
    //   598: invokevirtual 287	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   601: ifne +8 -> 609
    //   604: aload 15
    //   606: invokevirtual 252	android/graphics/Bitmap:recycle	()V
    //   609: goto +6 -> 615
    //   612: aconst_null
    //   613: astore 14
    //   615: goto +177 -> 792
    //   618: astore 14
    //   620: aload 14
    //   622: invokevirtual 290	java/lang/NullPointerException:printStackTrace	()V
    //   625: aconst_null
    //   626: areturn
    //   627: astore 15
    //   629: aconst_null
    //   630: astore 14
    //   632: getstatic 75	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   635: getfield 81	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   638: invokeinterface 87 1 0
    //   643: istore 13
    //   645: iload 13
    //   647: ifeq +116 -> 763
    //   650: getstatic 75	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   653: getfield 81	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   656: astore 19
    //   658: aload_0
    //   659: invokevirtual 91	com/tencent/image/downloader/GalleryDecoder:getLogTag	()Ljava/lang/String;
    //   662: astore 20
    //   664: new 219	java/lang/StringBuilder
    //   667: dup
    //   668: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   671: astore 21
    //   673: aload 21
    //   675: ldc_w 292
    //   678: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: pop
    //   682: aload 21
    //   684: iconst_1
    //   685: invokevirtual 295	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   688: pop
    //   689: aload 21
    //   691: ldc_w 297
    //   694: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: pop
    //   698: aload 21
    //   700: aload 17
    //   702: getfield 358	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   705: invokevirtual 295	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   708: pop
    //   709: aload 21
    //   711: ldc_w 299
    //   714: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   717: pop
    //   718: aload 21
    //   720: aload_2
    //   721: getfield 302	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   724: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: pop
    //   728: aload 21
    //   730: ldc_w 304
    //   733: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   736: pop
    //   737: aload 21
    //   739: aload 15
    //   741: invokevirtual 307	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   744: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: pop
    //   748: aload 19
    //   750: aload 20
    //   752: iconst_2
    //   753: aload 21
    //   755: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   758: invokeinterface 97 4 0
    //   763: iload 5
    //   765: iconst_2
    //   766: imul
    //   767: istore 6
    //   769: invokestatic 312	java/lang/System:gc	()V
    //   772: invokestatic 317	java/lang/Thread:yield	()V
    //   775: invokestatic 312	java/lang/System:gc	()V
    //   778: iload 6
    //   780: istore 5
    //   782: iload 6
    //   784: bipush 8
    //   786: if_icmplt -336 -> 450
    //   789: goto +333 -> 1122
    //   792: aload 17
    //   794: getfield 358	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   797: istore 6
    //   799: iconst_1
    //   800: istore 5
    //   802: iload 6
    //   804: iconst_1
    //   805: if_icmple +69 -> 874
    //   808: aload_2
    //   809: getfield 320	com/tencent/image/DownloadParams:mAutoScaleByDensity	Z
    //   812: ifeq +40 -> 852
    //   815: aload_2
    //   816: iload 7
    //   818: i2f
    //   819: aload_0
    //   820: getfield 49	com/tencent/image/downloader/GalleryDecoder:density	F
    //   823: fmul
    //   824: f2d
    //   825: invokestatic 324	java/lang/Math:ceil	(D)D
    //   828: d2i
    //   829: putfield 325	com/tencent/image/DownloadParams:outWidth	I
    //   832: aload_2
    //   833: iload 8
    //   835: i2f
    //   836: aload_0
    //   837: getfield 49	com/tencent/image/downloader/GalleryDecoder:density	F
    //   840: fmul
    //   841: f2d
    //   842: invokestatic 324	java/lang/Math:ceil	(D)D
    //   845: d2i
    //   846: putfield 326	com/tencent/image/DownloadParams:outHeight	I
    //   849: goto +25 -> 874
    //   852: aload_2
    //   853: iload 7
    //   855: i2d
    //   856: invokestatic 324	java/lang/Math:ceil	(D)D
    //   859: d2i
    //   860: putfield 325	com/tencent/image/DownloadParams:outWidth	I
    //   863: aload_2
    //   864: iload 8
    //   866: i2d
    //   867: invokestatic 324	java/lang/Math:ceil	(D)D
    //   870: d2i
    //   871: putfield 326	com/tencent/image/DownloadParams:outHeight	I
    //   874: getstatic 75	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   877: getfield 81	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   880: invokeinterface 87 1 0
    //   885: ifeq +114 -> 999
    //   888: getstatic 75	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   891: getfield 81	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   894: astore 15
    //   896: aload_0
    //   897: invokevirtual 91	com/tencent/image/downloader/GalleryDecoder:getLogTag	()Ljava/lang/String;
    //   900: astore 18
    //   902: new 219	java/lang/StringBuilder
    //   905: dup
    //   906: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   909: astore 19
    //   911: aload 19
    //   913: ldc_w 328
    //   916: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   919: pop
    //   920: aload 19
    //   922: aload_1
    //   923: invokevirtual 332	java/io/File:length	()J
    //   926: invokevirtual 335	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   929: pop
    //   930: aload 19
    //   932: ldc_w 337
    //   935: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   938: pop
    //   939: aload 19
    //   941: iload 7
    //   943: invokevirtual 295	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   946: pop
    //   947: aload 19
    //   949: ldc_w 339
    //   952: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   955: pop
    //   956: aload 19
    //   958: iload 8
    //   960: invokevirtual 295	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   963: pop
    //   964: aload 19
    //   966: ldc_w 341
    //   969: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   972: pop
    //   973: aload 19
    //   975: aload 17
    //   977: getfield 358	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   980: invokevirtual 295	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   983: pop
    //   984: aload 15
    //   986: aload 18
    //   988: iconst_2
    //   989: aload 19
    //   991: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   994: invokeinterface 97 4 0
    //   999: aload 14
    //   1001: areturn
    //   1002: astore_1
    //   1003: iload 5
    //   1005: istore 4
    //   1007: goto +92 -> 1099
    //   1010: astore_1
    //   1011: iconst_1
    //   1012: istore 4
    //   1014: goto +85 -> 1099
    //   1017: astore 14
    //   1019: iconst_1
    //   1020: istore 5
    //   1022: goto +15 -> 1037
    //   1025: astore_1
    //   1026: iconst_0
    //   1027: istore 4
    //   1029: goto +70 -> 1099
    //   1032: astore 14
    //   1034: iconst_0
    //   1035: istore 5
    //   1037: getstatic 75	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1040: getfield 81	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1043: invokeinterface 87 1 0
    //   1048: ifeq +24 -> 1072
    //   1051: getstatic 75	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1054: getfield 81	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1057: aload_0
    //   1058: invokevirtual 91	com/tencent/image/downloader/GalleryDecoder:getLogTag	()Ljava/lang/String;
    //   1061: iconst_2
    //   1062: ldc_w 410
    //   1065: aload 14
    //   1067: invokeinterface 364 5 0
    //   1072: aload_0
    //   1073: aload_1
    //   1074: aload_2
    //   1075: aload_3
    //   1076: iload 4
    //   1078: invokespecial 412	com/tencent/image/downloader/GalleryDecoder:decodeFileWidthByteArray	(Ljava/io/File;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;I)Ljava/lang/Object;
    //   1081: astore_1
    //   1082: iload 5
    //   1084: ifne +8 -> 1092
    //   1087: aload 16
    //   1089: invokevirtual 374	java/io/FileInputStream:close	()V
    //   1092: aload_1
    //   1093: areturn
    //   1094: astore_1
    //   1095: iload 5
    //   1097: istore 4
    //   1099: iload 4
    //   1101: ifne +8 -> 1109
    //   1104: aload 16
    //   1106: invokevirtual 374	java/io/FileInputStream:close	()V
    //   1109: goto +5 -> 1114
    //   1112: aload_1
    //   1113: athrow
    //   1114: goto -2 -> 1112
    //   1117: astore 14
    //   1119: goto -606 -> 513
    //   1122: goto -330 -> 792
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1125	0	this	GalleryDecoder
    //   0	1125	1	paramFile	File
    //   0	1125	2	paramDownloadParams	DownloadParams
    //   0	1125	3	paramURLDrawableHandler	URLDrawableHandler
    //   0	1125	4	paramInt	int
    //   50	1046	5	i	int
    //   11	795	6	j	int
    //   306	636	7	k	int
    //   313	646	8	m	int
    //   16	375	9	l1	long
    //   194	195	11	l2	long
    //   184	462	13	bool	boolean
    //   55	75	14	localConfig	Bitmap.Config
    //   257	32	14	localRuntimeException1	java.lang.RuntimeException
    //   360	38	14	localILog1	ILog
    //   415	1	14	localRuntimeException2	java.lang.RuntimeException
    //   503	111	14	localObject1	Object
    //   618	3	14	localNullPointerException	NullPointerException
    //   630	370	14	localObject2	Object
    //   1017	1	14	localRuntimeException3	java.lang.RuntimeException
    //   1032	34	14	localRuntimeException4	java.lang.RuntimeException
    //   1117	1	14	localException	Exception
    //   21	584	15	localObject3	Object
    //   627	113	15	localOutOfMemoryError	OutOfMemoryError
    //   894	91	15	localILog2	ILog
    //   8	1097	16	localFileInputStream	FileInputStream
    //   208	768	17	localObject4	Object
    //   138	849	18	localObject5	Object
    //   217	773	19	localObject6	Object
    //   662	89	20	str	String
    //   671	83	21	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   191	254	257	java/lang/RuntimeException
    //   320	331	257	java/lang/RuntimeException
    //   349	412	415	java/lang/RuntimeException
    //   450	466	415	java/lang/RuntimeException
    //   474	489	415	java/lang/RuntimeException
    //   494	510	415	java/lang/RuntimeException
    //   518	523	415	java/lang/RuntimeException
    //   523	533	415	java/lang/RuntimeException
    //   537	544	415	java/lang/RuntimeException
    //   548	609	415	java/lang/RuntimeException
    //   620	625	415	java/lang/RuntimeException
    //   650	763	415	java/lang/RuntimeException
    //   808	849	415	java/lang/RuntimeException
    //   852	874	415	java/lang/RuntimeException
    //   874	999	415	java/lang/RuntimeException
    //   450	466	618	java/lang/NullPointerException
    //   474	489	618	java/lang/NullPointerException
    //   494	510	618	java/lang/NullPointerException
    //   518	523	618	java/lang/NullPointerException
    //   523	533	618	java/lang/NullPointerException
    //   537	544	618	java/lang/NullPointerException
    //   548	609	618	java/lang/NullPointerException
    //   450	466	627	java/lang/OutOfMemoryError
    //   474	489	627	java/lang/OutOfMemoryError
    //   494	510	627	java/lang/OutOfMemoryError
    //   518	523	627	java/lang/OutOfMemoryError
    //   523	533	627	java/lang/OutOfMemoryError
    //   537	544	627	java/lang/OutOfMemoryError
    //   548	609	627	java/lang/OutOfMemoryError
    //   808	849	1002	finally
    //   852	874	1002	finally
    //   874	999	1002	finally
    //   173	186	1010	finally
    //   191	254	1010	finally
    //   266	315	1010	finally
    //   320	331	1010	finally
    //   331	344	1010	finally
    //   349	412	1010	finally
    //   420	450	1010	finally
    //   450	466	1010	finally
    //   474	489	1010	finally
    //   494	510	1010	finally
    //   518	523	1010	finally
    //   523	533	1010	finally
    //   537	544	1010	finally
    //   548	609	1010	finally
    //   620	625	1010	finally
    //   632	645	1010	finally
    //   650	763	1010	finally
    //   769	778	1010	finally
    //   792	799	1010	finally
    //   173	186	1017	java/lang/RuntimeException
    //   266	315	1017	java/lang/RuntimeException
    //   331	344	1017	java/lang/RuntimeException
    //   420	450	1017	java/lang/RuntimeException
    //   632	645	1017	java/lang/RuntimeException
    //   769	778	1017	java/lang/RuntimeException
    //   792	799	1017	java/lang/RuntimeException
    //   13	31	1025	finally
    //   52	57	1025	finally
    //   126	131	1025	finally
    //   131	173	1025	finally
    //   13	31	1032	java/lang/RuntimeException
    //   52	57	1032	java/lang/RuntimeException
    //   126	131	1032	java/lang/RuntimeException
    //   131	173	1032	java/lang/RuntimeException
    //   1037	1072	1094	finally
    //   1072	1082	1094	finally
    //   494	510	1117	java/lang/Exception
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    long l1 = SystemClock.uptimeMillis();
    try
    {
      if (VideoDrawable.isVideo(paramFile))
      {
        paramDownloadParams = decodeVideo(paramFile, paramDownloadParams, paramURLDrawableHandler);
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
          paramDownloadParams = decodeFileWidthByteArrayWithTrubo(paramFile, paramDownloadParams, paramURLDrawableHandler, i);
          return paramDownloadParams;
        }
        paramDownloadParams = decodeFileNormalWithTrubo(paramFile, paramDownloadParams, paramURLDrawableHandler, i);
        return paramDownloadParams;
      }
      if (l2 < 5242880L)
      {
        paramDownloadParams = decodeFileWidthByteArray(paramFile, paramDownloadParams, paramURLDrawableHandler, i);
        return paramDownloadParams;
      }
      paramDownloadParams = decodeFileNormal(paramFile, paramDownloadParams, paramURLDrawableHandler, i);
      return paramDownloadParams;
    }
    finally
    {
      long l2;
      String str;
      StringBuilder localStringBuilder;
      if (URLDrawable.depImp.mLog.isColorLevel())
      {
        l2 = SystemClock.uptimeMillis();
        paramURLDrawableHandler = URLDrawable.depImp.mLog;
        str = getLogTag();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("decode file:");
        localStringBuilder.append(paramFile.getAbsolutePath());
        localStringBuilder.append(" cost: ");
        localStringBuilder.append(l2 - l1);
        paramURLDrawableHandler.d(str, 2, localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image.downloader.GalleryDecoder
 * JD-Core Version:    0.7.0.1
 */