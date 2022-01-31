package com.tencent.mobileqq.activity.aio.photo;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.media.ThumbnailUtils;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.JpegExifReader;
import com.tencent.image.LocaleFileDownloader;
import com.tencent.image.RoundRectBitmap;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.SliceBitmap;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.VideoDrawable;
import com.tencent.mobileqq.pic.compress.Utils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class PhotoDecoder
  extends LocaleFileDownloader
{
  private float jdField_a_of_type_Float;
  private BaseApplicationImpl jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  
  public PhotoDecoder(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = paramBaseApplicationImpl;
    this.jdField_a_of_type_Float = paramBaseApplicationImpl.getResources().getDisplayMetrics().density;
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (((paramInt6 == 2) || (paramInt3 == 2147483647) || (paramInt4 == 2147483647)) && (paramInt1 * paramInt2 <= this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources().getDisplayMetrics().widthPixels * this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources().getDisplayMetrics().heightPixels * 4))
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
            paramInt5 = (int)(paramInt2 * this.jdField_a_of_type_Float + 0.5D);
            paramInt6 = (int)(paramInt1 * this.jdField_a_of_type_Float + 0.5D);
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
      if (this.jdField_a_of_type_Float > 2.0F) {}
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
              break label517;
            }
            f = paramInt3 / paramInt5;
            break label187;
          }
          if (paramInt6 * 1.5F < paramInt4) {
            break label517;
          }
          f = paramInt4 / paramInt6;
          break label187;
        }
        if ((paramInt6 <= paramInt4) || (paramInt6 >= paramInt4 * 1.5F)) {
          break label517;
        }
        f = paramInt4 / paramInt6;
        break label187;
      }
      label355:
      if (paramInt1 > 64)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PEAK", 2, "the pic it fxxking large.....");
        }
        return 64;
      }
      paramInt3 = 64;
      for (;;)
      {
        if (paramInt3 == 0) {
          break label405;
        }
        paramInt4 = paramInt1 & paramInt3;
        paramInt2 = paramInt4;
        if (paramInt4 != 0) {
          break;
        }
        paramInt3 >>= 1;
      }
      label405:
      return 1;
      if ((paramInt3 == 0) || (paramInt4 == 0) || (paramInt3 == -1) || (paramInt4 == -1)) {
        return 1;
      }
      int i = 1;
      paramInt5 = paramInt2;
      paramInt6 = paramInt1;
      paramInt1 = i;
      label441:
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
        break label441;
        i = paramInt2;
      }
      label517:
      f = 1.0F;
    }
  }
  
  private RoundRectBitmap a(Bitmap paramBitmap, int paramInt)
  {
    try
    {
      RoundRectBitmap localRoundRectBitmap = new RoundRectBitmap(paramBitmap, paramInt);
      return localRoundRectBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    return new RoundRectBitmap(paramBitmap, 12.0F);
  }
  
  private Object a(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    int i = 0;
    if (paramDownloadParams.tag != null) {
      i = ((Integer)paramDownloadParams.tag).intValue();
    }
    if (i == 3)
    {
      paramURLDrawableHandler = ThumbnailUtils.createVideoThumbnail(paramFile.getAbsolutePath(), 1);
      int j = paramURLDrawableHandler.getWidth();
      i = paramURLDrawableHandler.getHeight();
      float f = Gallery.a(j, i, paramDownloadParams.reqWidth, paramDownloadParams.reqHeight, null);
      j = (int)(j * f);
      i = (int)(i * f);
      return ThumbnailUtils.createVideoThumbnail(paramFile.getAbsolutePath(), 1);
    }
    return null;
  }
  
  private Object a(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt)
  {
    FileInputStream localFileInputStream = new FileInputStream(paramFile);
    j = 0;
    try
    {
      l1 = SystemClock.uptimeMillis();
      localObject = new byte[2];
      localFileInputStream.read((byte[])localObject);
      int m = localObject[0];
      int n = localObject[1];
      paramURLDrawableHandler = Bitmap.Config.ARGB_8888;
      i = 0;
      k = 0;
      switch (m << 8 & 0xFF00 | n & 0xFF)
      {
      }
    }
    finally
    {
      for (;;)
      {
        long l1;
        Object localObject;
        int k;
        byte[] arrayOfByte;
        paramInt = j;
        continue;
        continue;
        paramURLDrawableHandler = null;
        continue;
        int i = k;
      }
    }
    arrayOfByte = new byte[(int)paramFile.length()];
    System.arraycopy(localObject, 0, arrayOfByte, 0, localObject.length);
    localFileInputStream.read(arrayOfByte, localObject.length, localFileInputStream.available());
    localFileInputStream.close();
    for (;;)
    {
      try
      {
        for (;;)
        {
          long l2;
          if (QLog.isColorLevel())
          {
            l2 = SystemClock.uptimeMillis();
            QLog.d("PEAK", 2, "read file to memory cost: " + (l2 - l1));
          }
          l1 = SystemClock.uptimeMillis();
          BitmapFactory.Options localOptions = new BitmapFactory.Options();
          localOptions.inJustDecodeBounds = true;
          localOptions.inPreferredConfig = paramURLDrawableHandler;
          localOptions.inDensity = 160;
          localOptions.inTargetDensity = 160;
          localOptions.inScreenDensity = 160;
          localOptions.inPurgeable = true;
          localOptions.inInputShareable = true;
          SafeBitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
          j = localOptions.outWidth;
          k = localOptions.outHeight;
          if (i != 0) {
            paramDownloadParams.outOrientation = JpegExifReader.readOrientation(paramFile.getAbsolutePath());
          }
          if (QLog.isColorLevel())
          {
            l2 = SystemClock.uptimeMillis();
            QLog.d("PEAK", 2, "read size & exif cost: " + (l2 - l1));
          }
          localOptions.inJustDecodeBounds = false;
          paramInt = a(j, k, paramDownloadParams.reqWidth, paramDownloadParams.reqHeight, paramDownloadParams.outOrientation, paramInt);
          try
          {
            localOptions.inSampleSize = paramInt;
            localObject = SafeBitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
            ((Bitmap)localObject).setDensity(160);
            if (Build.VERSION.SDK_INT < 11) {
              break label709;
            }
            boolean bool = SliceBitmap.needSlice((Bitmap)localObject);
            if (!bool) {
              break label709;
            }
            try
            {
              paramURLDrawableHandler = new SliceBitmap((Bitmap)localObject);
              ((Bitmap)localObject).recycle();
              if (localOptions.inSampleSize > 1)
              {
                if (!paramDownloadParams.mAutoScaleByDensity) {
                  break label805;
                }
                paramDownloadParams.outWidth = ((int)Math.ceil(j * this.jdField_a_of_type_Float));
                paramDownloadParams.outHeight = ((int)Math.ceil(k * this.jdField_a_of_type_Float));
              }
              if (QLog.isColorLevel()) {
                QLog.d("PEAK", 2, "image file size:" + paramFile.length() + " , bound:" + j + "x" + k + " , sampleSize: " + localOptions.inSampleSize);
              }
              return paramURLDrawableHandler;
            }
            catch (Exception paramURLDrawableHandler)
            {
              if (localObject == null) {
                break label598;
              }
              ((Bitmap)localObject).recycle();
              throw new OutOfMemoryError("slice failed.");
            }
            i = 1;
            paramURLDrawableHandler = Bitmap.Config.RGB_565;
          }
          catch (OutOfMemoryError paramURLDrawableHandler)
          {
            label598:
            if (!QLog.isColorLevel()) {
              break label682;
            }
            QLog.d("PEAK", 2, "DecodeFile ERROR,oom retryCount=" + 1 + ",options.inSampleSize=" + localOptions.inSampleSize + ",url=" + paramDownloadParams.urlStr + ",oom.msg:" + paramURLDrawableHandler.getMessage());
            label682:
            paramInt *= 2;
            System.gc();
            Thread.yield();
            System.gc();
            if (paramInt > 8) {
              break label842;
            }
          }
        }
        localFileInputStream.close();
        return null;
      }
      finally
      {
        label709:
        RoundRectBitmap localRoundRectBitmap;
        paramInt = 1;
        if (paramInt != 0) {
          continue;
        }
        localFileInputStream.close();
      }
      paramURLDrawableHandler = null;
      continue;
      if ((paramDownloadParams.mExtraInfo != null) && (PhotoDecoder.DownloadParamsExtraInfo.class.isInstance(paramDownloadParams.mExtraInfo)))
      {
        paramURLDrawableHandler = (PhotoDecoder.DownloadParamsExtraInfo)paramDownloadParams.mExtraInfo;
        if (paramURLDrawableHandler.a <= 0) {
          break label845;
        }
        localRoundRectBitmap = a((Bitmap)localObject, paramURLDrawableHandler.a);
        paramURLDrawableHandler = localRoundRectBitmap;
        if (!localRoundRectBitmap.mBitmap.equals(localObject))
        {
          ((Bitmap)localObject).recycle();
          paramURLDrawableHandler = localRoundRectBitmap;
        }
      }
      else
      {
        paramURLDrawableHandler = (URLDrawableHandler)localObject;
        continue;
        label805:
        double d = j;
        paramDownloadParams.outWidth = ((int)Math.ceil(d));
        paramDownloadParams.outHeight = ((int)Math.ceil(k));
      }
    }
  }
  
  private Object b(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt)
  {
    paramURLDrawableHandler = new FileInputStream(paramFile);
    try
    {
      localObject = new byte[2];
      paramURLDrawableHandler.read((byte[])localObject);
      k = localObject[0];
      m = localObject[1];
      paramURLDrawableHandler.close();
      localObject = new FileInputStream(paramFile);
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
      paramDownloadParams = (DownloadParams)localObject;
      break label668;
      paramURLDrawableHandler = null;
      break label321;
      paramURLDrawableHandler = null;
      break label321;
      i = j;
      break label132;
    }
    localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    localOptions.inPreferredConfig = paramURLDrawableHandler;
    localOptions.inDensity = 160;
    localOptions.inTargetDensity = 160;
    localOptions.inScreenDensity = 160;
    SafeBitmapFactory.decodeStream((InputStream)localObject, null, localOptions);
    j = localOptions.outWidth;
    k = localOptions.outHeight;
    ((InputStream)localObject).close();
    if (i != 0) {}
    for (;;)
    {
      Bitmap localBitmap;
      try
      {
        for (;;)
        {
          paramDownloadParams.outOrientation = JpegExifReader.readOrientation(paramFile.getAbsolutePath());
          localOptions.inJustDecodeBounds = false;
          paramInt = a(j, k, paramDownloadParams.reqWidth, paramDownloadParams.reqHeight, paramDownloadParams.outOrientation, paramInt);
          i = 1;
          if (i > 3) {
            break label738;
          }
          try
          {
            localOptions.inSampleSize = paramInt;
            localBitmap = SafeBitmapFactory.decodeFile(paramFile.getAbsolutePath(), localOptions);
            localBitmap.setDensity(160);
            if (Build.VERSION.SDK_INT < 11) {
              break label587;
            }
            boolean bool = SliceBitmap.needSlice(localBitmap);
            if (!bool) {
              break label587;
            }
            try
            {
              paramURLDrawableHandler = new SliceBitmap(localBitmap);
              localBitmap.recycle();
              label321:
              if (localOptions.inSampleSize > 1)
              {
                if (!paramDownloadParams.mAutoScaleByDensity) {
                  break label685;
                }
                paramDownloadParams.outWidth = ((int)Math.ceil(j * this.jdField_a_of_type_Float));
                paramDownloadParams.outHeight = ((int)Math.ceil(k * this.jdField_a_of_type_Float));
              }
              if (QLog.isColorLevel()) {
                QLog.d("PEAK", 2, "image file size:" + paramFile.length() + " , bound:" + localOptions.outWidth + "x" + localOptions.outHeight + " , sampleSize: " + localOptions.inSampleSize);
              }
              return paramURLDrawableHandler;
            }
            catch (Exception paramURLDrawableHandler)
            {
              if (localBitmap == null) {
                break label478;
              }
              localBitmap.recycle();
              throw new OutOfMemoryError("slice failed.");
            }
            i = 1;
            paramURLDrawableHandler = Bitmap.Config.RGB_565;
          }
          catch (OutOfMemoryError paramURLDrawableHandler)
          {
            label478:
            if (!QLog.isColorLevel()) {
              break label563;
            }
            QLog.d("PEAK", 2, "DecodeFile ERROR,oom retryCount=" + i + ",options.inSampleSize=" + localOptions.inSampleSize + ",url=" + paramDownloadParams.urlStr + ",oom.msg:" + paramURLDrawableHandler.getMessage());
            label563:
            System.gc();
            Thread.yield();
            System.gc();
            i += 1;
            paramInt *= 2;
          }
        }
        ((InputStream)localObject).close();
        return null;
      }
      finally
      {
        label587:
        RoundRectBitmap localRoundRectBitmap;
        paramInt = 1;
        paramDownloadParams = (DownloadParams)localObject;
        label668:
        if (paramInt != 0) {
          continue;
        }
        paramDownloadParams.close();
      }
      continue;
      if ((paramDownloadParams.mExtraInfo != null) && (PhotoDecoder.DownloadParamsExtraInfo.class.isInstance(paramDownloadParams.mExtraInfo)))
      {
        paramURLDrawableHandler = (PhotoDecoder.DownloadParamsExtraInfo)paramDownloadParams.mExtraInfo;
        if (paramURLDrawableHandler.a <= 0) {
          break label733;
        }
        localRoundRectBitmap = a(localBitmap, paramURLDrawableHandler.a);
        paramURLDrawableHandler = localRoundRectBitmap;
        if (!localRoundRectBitmap.mBitmap.equals(localBitmap))
        {
          localBitmap.recycle();
          paramURLDrawableHandler = localRoundRectBitmap;
        }
      }
      else
      {
        paramURLDrawableHandler = localBitmap;
        continue;
        label685:
        double d = j;
        paramDownloadParams.outWidth = ((int)Math.ceil(d));
        paramDownloadParams.outHeight = ((int)Math.ceil(k));
      }
    }
  }
  
  /* Error */
  private Object c(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt)
  {
    // Byte code:
    //   0: new 126	java/io/FileInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 129	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore 21
    //   10: iconst_0
    //   11: istore 10
    //   13: iconst_0
    //   14: istore 9
    //   16: iload 10
    //   18: istore 7
    //   20: invokestatic 135	android/os/SystemClock:uptimeMillis	()J
    //   23: lstore 13
    //   25: iload 10
    //   27: istore 7
    //   29: iconst_2
    //   30: newarray byte
    //   32: astore 19
    //   34: iload 10
    //   36: istore 7
    //   38: aload 21
    //   40: aload 19
    //   42: invokevirtual 139	java/io/FileInputStream:read	([B)I
    //   45: pop
    //   46: aload 19
    //   48: iconst_0
    //   49: baload
    //   50: istore 11
    //   52: aload 19
    //   54: iconst_1
    //   55: baload
    //   56: istore 12
    //   58: iload 10
    //   60: istore 7
    //   62: getstatic 145	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   65: astore 18
    //   67: iconst_0
    //   68: istore 8
    //   70: iconst_0
    //   71: istore 7
    //   73: iload 11
    //   75: bipush 8
    //   77: ishl
    //   78: ldc 146
    //   80: iand
    //   81: iload 12
    //   83: sipush 255
    //   86: iand
    //   87: ior
    //   88: lookupswitch	default:+858->946, 8273:+323->411, 16973:+323->411, 18249:+335->423, 18761:+320->408, 19789:+320->408, 65496:+320->408
    //   149: lconst_1
    //   150: istore 7
    //   152: aload_1
    //   153: invokevirtual 149	java/io/File:length	()J
    //   156: l2i
    //   157: newarray byte
    //   159: astore 23
    //   161: iload 10
    //   163: istore 7
    //   165: aload 19
    //   167: iconst_0
    //   168: aload 23
    //   170: iconst_0
    //   171: aload 19
    //   173: arraylength
    //   174: invokestatic 155	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   177: iload 10
    //   179: istore 7
    //   181: aload 21
    //   183: aload 23
    //   185: aload 19
    //   187: arraylength
    //   188: aload 21
    //   190: invokevirtual 158	java/io/FileInputStream:available	()I
    //   193: invokevirtual 161	java/io/FileInputStream:read	([BII)I
    //   196: pop
    //   197: iload 10
    //   199: istore 7
    //   201: aload 21
    //   203: invokevirtual 164	java/io/FileInputStream:close	()V
    //   206: iconst_1
    //   207: istore 9
    //   209: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   212: ifeq +37 -> 249
    //   215: invokestatic 135	android/os/SystemClock:uptimeMillis	()J
    //   218: lstore 15
    //   220: ldc 56
    //   222: iconst_2
    //   223: new 166	java/lang/StringBuilder
    //   226: dup
    //   227: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   230: ldc 169
    //   232: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: lload 15
    //   237: lload 13
    //   239: lsub
    //   240: invokevirtual 176	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   243: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   249: invokestatic 135	android/os/SystemClock:uptimeMillis	()J
    //   252: lstore 13
    //   254: new 346	com/tencent/mobileqq/pic/JpegOptions
    //   257: dup
    //   258: invokespecial 347	com/tencent/mobileqq/pic/JpegOptions:<init>	()V
    //   261: astore 22
    //   263: aload 22
    //   265: iconst_1
    //   266: putfield 348	com/tencent/mobileqq/pic/JpegOptions:inJustDecodeBounds	Z
    //   269: aload 22
    //   271: aload 18
    //   273: putfield 349	com/tencent/mobileqq/pic/JpegOptions:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   276: aload 23
    //   278: aload 22
    //   280: invokestatic 354	com/tencent/mobileqq/pic/JpegDecompressor:decodeByteArray	([BLcom/tencent/mobileqq/pic/JpegOptions;)Landroid/graphics/Bitmap;
    //   283: pop
    //   284: aload 22
    //   286: getfield 355	com/tencent/mobileqq/pic/JpegOptions:outWidth	I
    //   289: istore 10
    //   291: aload 22
    //   293: getfield 356	com/tencent/mobileqq/pic/JpegOptions:outHeight	I
    //   296: istore 11
    //   298: iload 8
    //   300: ifeq +14 -> 314
    //   303: aload_2
    //   304: aload_1
    //   305: invokevirtual 96	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   308: invokestatic 222	com/tencent/image/JpegExifReader:readOrientation	(Ljava/lang/String;)I
    //   311: putfield 225	com/tencent/image/DownloadParams:outOrientation	I
    //   314: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   317: ifeq +37 -> 354
    //   320: invokestatic 135	android/os/SystemClock:uptimeMillis	()J
    //   323: lstore 15
    //   325: ldc 56
    //   327: iconst_2
    //   328: new 166	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   335: ldc 227
    //   337: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: lload 15
    //   342: lload 13
    //   344: lsub
    //   345: invokevirtual 176	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   348: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   354: aload 22
    //   356: iconst_0
    //   357: putfield 348	com/tencent/mobileqq/pic/JpegOptions:inJustDecodeBounds	Z
    //   360: aload_0
    //   361: iload 10
    //   363: iload 11
    //   365: aload_2
    //   366: getfield 113	com/tencent/image/DownloadParams:reqWidth	I
    //   369: aload_2
    //   370: getfield 116	com/tencent/image/DownloadParams:reqHeight	I
    //   373: aload_2
    //   374: getfield 225	com/tencent/image/DownloadParams:outOrientation	I
    //   377: iload 4
    //   379: invokespecial 229	com/tencent/mobileqq/activity/aio/photo/PhotoDecoder:a	(IIIIII)I
    //   382: istore 7
    //   384: aload 22
    //   386: iload 7
    //   388: putfield 357	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   391: aload 23
    //   393: aload 22
    //   395: invokestatic 354	com/tencent/mobileqq/pic/JpegDecompressor:decodeByteArray	([BLcom/tencent/mobileqq/pic/JpegOptions;)Landroid/graphics/Bitmap;
    //   398: astore 19
    //   400: aload 19
    //   402: ifnonnull +28 -> 430
    //   405: aload 19
    //   407: areturn
    //   408: iconst_1
    //   409: istore 8
    //   411: iload 10
    //   413: istore 7
    //   415: getstatic 276	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   418: astore 18
    //   420: goto -272 -> 148
    //   423: aload 21
    //   425: invokevirtual 164	java/io/FileInputStream:close	()V
    //   428: aconst_null
    //   429: areturn
    //   430: aload 19
    //   432: sipush 160
    //   435: invokevirtual 236	android/graphics/Bitmap:setDensity	(I)V
    //   438: getstatic 241	android/os/Build$VERSION:SDK_INT	I
    //   441: bipush 11
    //   443: if_icmplt +345 -> 788
    //   446: aload 19
    //   448: invokestatic 247	com/tencent/image/SliceBitmap:needSlice	(Landroid/graphics/Bitmap;)Z
    //   451: istore 17
    //   453: iload 17
    //   455: ifeq +333 -> 788
    //   458: new 243	com/tencent/image/SliceBitmap
    //   461: dup
    //   462: aload 19
    //   464: invokespecial 250	com/tencent/image/SliceBitmap:<init>	(Landroid/graphics/Bitmap;)V
    //   467: astore 18
    //   469: aload 19
    //   471: invokevirtual 253	android/graphics/Bitmap:recycle	()V
    //   474: aload 22
    //   476: getfield 357	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   479: iconst_1
    //   480: if_icmple +44 -> 524
    //   483: aload_2
    //   484: getfield 256	com/tencent/image/DownloadParams:mAutoScaleByDensity	Z
    //   487: ifeq +404 -> 891
    //   490: aload_2
    //   491: iload 10
    //   493: i2f
    //   494: aload_0
    //   495: getfield 33	com/tencent/mobileqq/activity/aio/photo/PhotoDecoder:jdField_a_of_type_Float	F
    //   498: fmul
    //   499: f2d
    //   500: invokestatic 260	java/lang/Math:ceil	(D)D
    //   503: d2i
    //   504: putfield 261	com/tencent/image/DownloadParams:outWidth	I
    //   507: aload_2
    //   508: iload 11
    //   510: i2f
    //   511: aload_0
    //   512: getfield 33	com/tencent/mobileqq/activity/aio/photo/PhotoDecoder:jdField_a_of_type_Float	F
    //   515: fmul
    //   516: f2d
    //   517: invokestatic 260	java/lang/Math:ceil	(D)D
    //   520: d2i
    //   521: putfield 262	com/tencent/image/DownloadParams:outHeight	I
    //   524: aload 18
    //   526: astore 19
    //   528: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   531: ifeq -126 -> 405
    //   534: ldc 56
    //   536: iconst_2
    //   537: new 166	java/lang/StringBuilder
    //   540: dup
    //   541: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   544: ldc_w 264
    //   547: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: aload_1
    //   551: invokevirtual 149	java/io/File:length	()J
    //   554: invokevirtual 176	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   557: ldc_w 266
    //   560: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: iload 10
    //   565: invokevirtual 269	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   568: ldc_w 271
    //   571: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: iload 11
    //   576: invokevirtual 269	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   579: ldc_w 273
    //   582: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: aload 22
    //   587: getfield 357	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   590: invokevirtual 269	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   593: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   596: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   599: aload 18
    //   601: areturn
    //   602: astore 18
    //   604: iconst_1
    //   605: istore 8
    //   607: iload 8
    //   609: istore 7
    //   611: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   614: ifeq +19 -> 633
    //   617: iload 8
    //   619: istore 7
    //   621: ldc_w 359
    //   624: iconst_2
    //   625: ldc_w 361
    //   628: aload 18
    //   630: invokestatic 365	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   633: iload 8
    //   635: istore 7
    //   637: aload_0
    //   638: aload_1
    //   639: aload_2
    //   640: aload_3
    //   641: iload 4
    //   643: invokespecial 367	com/tencent/mobileqq/activity/aio/photo/PhotoDecoder:a	(Ljava/io/File;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;I)Ljava/lang/Object;
    //   646: astore_1
    //   647: aload_1
    //   648: astore 19
    //   650: iload 8
    //   652: ifne -247 -> 405
    //   655: aload 21
    //   657: invokevirtual 164	java/io/FileInputStream:close	()V
    //   660: aload_1
    //   661: areturn
    //   662: astore 18
    //   664: aload 19
    //   666: ifnull +8 -> 674
    //   669: aload 19
    //   671: invokevirtual 253	android/graphics/Bitmap:recycle	()V
    //   674: new 71	java/lang/OutOfMemoryError
    //   677: dup
    //   678: ldc_w 278
    //   681: invokespecial 281	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   684: athrow
    //   685: astore 18
    //   687: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   690: ifeq +70 -> 760
    //   693: ldc 56
    //   695: iconst_2
    //   696: new 166	java/lang/StringBuilder
    //   699: dup
    //   700: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   703: ldc_w 283
    //   706: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: iconst_1
    //   710: invokevirtual 269	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   713: ldc_w 285
    //   716: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: aload 22
    //   721: getfield 357	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   724: invokevirtual 269	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   727: ldc_w 287
    //   730: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: aload_2
    //   734: getfield 291	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   737: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: ldc_w 293
    //   743: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   746: aload 18
    //   748: invokevirtual 296	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   751: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   754: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   757: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   760: iload 7
    //   762: iconst_2
    //   763: imul
    //   764: istore 7
    //   766: invokestatic 299	java/lang/System:gc	()V
    //   769: invokestatic 304	java/lang/Thread:yield	()V
    //   772: invokestatic 299	java/lang/System:gc	()V
    //   775: iload 7
    //   777: bipush 8
    //   779: if_icmplt +158 -> 937
    //   782: aconst_null
    //   783: astore 18
    //   785: goto -311 -> 474
    //   788: aload_2
    //   789: getfield 307	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   792: ifnull +92 -> 884
    //   795: ldc_w 309
    //   798: aload_2
    //   799: getfield 307	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   802: invokevirtual 315	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   805: ifeq +79 -> 884
    //   808: aload_2
    //   809: getfield 307	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   812: checkcast 309	com/tencent/mobileqq/activity/aio/photo/PhotoDecoder$DownloadParamsExtraInfo
    //   815: astore 18
    //   817: aload 18
    //   819: getfield 317	com/tencent/mobileqq/activity/aio/photo/PhotoDecoder$DownloadParamsExtraInfo:a	I
    //   822: ifle +118 -> 940
    //   825: aload_0
    //   826: aload 19
    //   828: aload 18
    //   830: getfield 317	com/tencent/mobileqq/activity/aio/photo/PhotoDecoder$DownloadParamsExtraInfo:a	I
    //   833: invokespecial 319	com/tencent/mobileqq/activity/aio/photo/PhotoDecoder:a	(Landroid/graphics/Bitmap;I)Lcom/tencent/image/RoundRectBitmap;
    //   836: astore 20
    //   838: aload 20
    //   840: astore 18
    //   842: aload 20
    //   844: getfield 323	com/tencent/image/RoundRectBitmap:mBitmap	Landroid/graphics/Bitmap;
    //   847: aload 19
    //   849: invokevirtual 328	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   852: ifne -378 -> 474
    //   855: aload 19
    //   857: invokevirtual 253	android/graphics/Bitmap:recycle	()V
    //   860: aload 20
    //   862: astore 18
    //   864: goto -390 -> 474
    //   867: astore_1
    //   868: iload 9
    //   870: istore 4
    //   872: iload 4
    //   874: ifne +8 -> 882
    //   877: aload 21
    //   879: invokevirtual 164	java/io/FileInputStream:close	()V
    //   882: aload_1
    //   883: athrow
    //   884: aload 19
    //   886: astore 18
    //   888: goto -414 -> 474
    //   891: iload 10
    //   893: i2d
    //   894: dstore 5
    //   896: aload_2
    //   897: dload 5
    //   899: invokestatic 260	java/lang/Math:ceil	(D)D
    //   902: d2i
    //   903: putfield 261	com/tencent/image/DownloadParams:outWidth	I
    //   906: aload_2
    //   907: iload 11
    //   909: i2d
    //   910: invokestatic 260	java/lang/Math:ceil	(D)D
    //   913: d2i
    //   914: putfield 262	com/tencent/image/DownloadParams:outHeight	I
    //   917: goto -393 -> 524
    //   920: astore_1
    //   921: iload 7
    //   923: istore 4
    //   925: goto -53 -> 872
    //   928: astore 18
    //   930: iload 9
    //   932: istore 8
    //   934: goto -327 -> 607
    //   937: goto -553 -> 384
    //   940: aconst_null
    //   941: astore 18
    //   943: goto -469 -> 474
    //   946: iload 7
    //   948: istore 8
    //   950: goto -802 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	953	0	this	PhotoDecoder
    //   0	953	1	paramFile	File
    //   0	953	2	paramDownloadParams	DownloadParams
    //   0	953	3	paramURLDrawableHandler	URLDrawableHandler
    //   0	953	4	paramInt	int
    //   894	4	5	d	double
    //   18	929	7	i	int
    //   68	881	8	j	int
    //   14	917	9	k	int
    //   11	881	10	m	int
    //   50	858	11	n	int
    //   56	31	12	i1	int
    //   23	320	13	l1	long
    //   218	123	15	l2	long
    //   451	3	17	bool	boolean
    //   65	535	18	localObject1	Object
    //   602	27	18	localRuntimeException1	java.lang.RuntimeException
    //   662	1	18	localException	Exception
    //   685	62	18	localOutOfMemoryError	OutOfMemoryError
    //   783	104	18	localObject2	Object
    //   928	1	18	localRuntimeException2	java.lang.RuntimeException
    //   941	1	18	localObject3	Object
    //   32	853	19	localObject4	Object
    //   836	25	20	localRoundRectBitmap	RoundRectBitmap
    //   8	870	21	localFileInputStream	FileInputStream
    //   261	459	22	localJpegOptions	com.tencent.mobileqq.pic.JpegOptions
    //   159	233	23	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   209	249	602	java/lang/RuntimeException
    //   249	298	602	java/lang/RuntimeException
    //   303	314	602	java/lang/RuntimeException
    //   314	354	602	java/lang/RuntimeException
    //   354	384	602	java/lang/RuntimeException
    //   384	400	602	java/lang/RuntimeException
    //   430	453	602	java/lang/RuntimeException
    //   458	474	602	java/lang/RuntimeException
    //   474	524	602	java/lang/RuntimeException
    //   528	599	602	java/lang/RuntimeException
    //   669	674	602	java/lang/RuntimeException
    //   674	685	602	java/lang/RuntimeException
    //   687	760	602	java/lang/RuntimeException
    //   766	775	602	java/lang/RuntimeException
    //   788	838	602	java/lang/RuntimeException
    //   842	860	602	java/lang/RuntimeException
    //   896	917	602	java/lang/RuntimeException
    //   458	474	662	java/lang/Exception
    //   384	400	685	java/lang/OutOfMemoryError
    //   430	453	685	java/lang/OutOfMemoryError
    //   458	474	685	java/lang/OutOfMemoryError
    //   669	674	685	java/lang/OutOfMemoryError
    //   674	685	685	java/lang/OutOfMemoryError
    //   788	838	685	java/lang/OutOfMemoryError
    //   842	860	685	java/lang/OutOfMemoryError
    //   209	249	867	finally
    //   249	298	867	finally
    //   303	314	867	finally
    //   314	354	867	finally
    //   354	384	867	finally
    //   384	400	867	finally
    //   430	453	867	finally
    //   458	474	867	finally
    //   474	524	867	finally
    //   528	599	867	finally
    //   669	674	867	finally
    //   674	685	867	finally
    //   687	760	867	finally
    //   766	775	867	finally
    //   788	838	867	finally
    //   842	860	867	finally
    //   896	917	867	finally
    //   20	25	920	finally
    //   29	34	920	finally
    //   38	46	920	finally
    //   62	67	920	finally
    //   152	161	920	finally
    //   165	177	920	finally
    //   181	197	920	finally
    //   201	206	920	finally
    //   415	420	920	finally
    //   611	617	920	finally
    //   621	633	920	finally
    //   637	647	920	finally
    //   20	25	928	java/lang/RuntimeException
    //   29	34	928	java/lang/RuntimeException
    //   38	46	928	java/lang/RuntimeException
    //   62	67	928	java/lang/RuntimeException
    //   152	161	928	java/lang/RuntimeException
    //   165	177	928	java/lang/RuntimeException
    //   181	197	928	java/lang/RuntimeException
    //   201	206	928	java/lang/RuntimeException
    //   415	420	928	java/lang/RuntimeException
  }
  
  /* Error */
  private Object d(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: new 126	java/io/FileInputStream
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 129	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   11: astore 13
    //   13: iconst_2
    //   14: newarray byte
    //   16: astore 12
    //   18: aload 13
    //   20: aload 12
    //   22: invokevirtual 332	java/io/InputStream:read	([B)I
    //   25: pop
    //   26: aload 12
    //   28: iconst_0
    //   29: baload
    //   30: istore 9
    //   32: aload 12
    //   34: iconst_1
    //   35: baload
    //   36: istore 10
    //   38: getstatic 145	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   41: astore 12
    //   43: iconst_0
    //   44: istore 7
    //   46: iconst_0
    //   47: istore 8
    //   49: iload 9
    //   51: bipush 8
    //   53: ishl
    //   54: ldc 146
    //   56: iand
    //   57: iload 10
    //   59: sipush 255
    //   62: iand
    //   63: ior
    //   64: lookupswitch	default:+748->812, 8273:+205->269, 16973:+205->269, 18249:+213->277, 18761:+202->266, 19789:+202->266, 65496:+202->266
    //   125: aconst_null
    //   126: dup_x1
    //   127: dup
    //   128: invokespecial 347	com/tencent/mobileqq/pic/JpegOptions:<init>	()V
    //   131: astore 16
    //   133: aload 16
    //   135: iconst_1
    //   136: putfield 348	com/tencent/mobileqq/pic/JpegOptions:inJustDecodeBounds	Z
    //   139: aload 16
    //   141: aload 12
    //   143: putfield 349	com/tencent/mobileqq/pic/JpegOptions:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   146: aload_1
    //   147: invokevirtual 96	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   150: aload 16
    //   152: invokestatic 370	com/tencent/mobileqq/pic/JpegDecompressor:decodeFile	(Ljava/lang/String;Lcom/tencent/mobileqq/pic/JpegOptions;)Landroid/graphics/Bitmap;
    //   155: pop
    //   156: aload 16
    //   158: getfield 355	com/tencent/mobileqq/pic/JpegOptions:outWidth	I
    //   161: istore 9
    //   163: aload 16
    //   165: getfield 356	com/tencent/mobileqq/pic/JpegOptions:outHeight	I
    //   168: istore 10
    //   170: iload 7
    //   172: ifeq +14 -> 186
    //   175: aload_2
    //   176: aload_1
    //   177: invokevirtual 96	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   180: invokestatic 222	com/tencent/image/JpegExifReader:readOrientation	(Ljava/lang/String;)I
    //   183: putfield 225	com/tencent/image/DownloadParams:outOrientation	I
    //   186: aload 16
    //   188: iconst_0
    //   189: putfield 348	com/tencent/mobileqq/pic/JpegOptions:inJustDecodeBounds	Z
    //   192: aload_0
    //   193: iload 9
    //   195: iload 10
    //   197: aload_2
    //   198: getfield 113	com/tencent/image/DownloadParams:reqWidth	I
    //   201: aload_2
    //   202: getfield 116	com/tencent/image/DownloadParams:reqHeight	I
    //   205: aload_2
    //   206: getfield 225	com/tencent/image/DownloadParams:outOrientation	I
    //   209: iload 4
    //   211: invokespecial 229	com/tencent/mobileqq/activity/aio/photo/PhotoDecoder:a	(IIIIII)I
    //   214: istore 7
    //   216: iconst_1
    //   217: istore 8
    //   219: iload 8
    //   221: iconst_3
    //   222: if_icmpgt +584 -> 806
    //   225: aload 16
    //   227: iload 7
    //   229: putfield 357	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   232: aload_1
    //   233: invokevirtual 96	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   236: aload 16
    //   238: invokestatic 370	com/tencent/mobileqq/pic/JpegDecompressor:decodeFile	(Ljava/lang/String;Lcom/tencent/mobileqq/pic/JpegOptions;)Landroid/graphics/Bitmap;
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
    //   259: invokevirtual 333	java/io/InputStream:close	()V
    //   262: aload_2
    //   263: astore_1
    //   264: aload_1
    //   265: areturn
    //   266: iconst_1
    //   267: istore 7
    //   269: getstatic 276	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   272: astore 12
    //   274: goto -150 -> 124
    //   277: aconst_null
    //   278: astore_1
    //   279: aload 13
    //   281: ifnull -17 -> 264
    //   284: aload 13
    //   286: invokevirtual 333	java/io/InputStream:close	()V
    //   289: aconst_null
    //   290: areturn
    //   291: aload 14
    //   293: sipush 160
    //   296: invokevirtual 236	android/graphics/Bitmap:setDensity	(I)V
    //   299: getstatic 241	android/os/Build$VERSION:SDK_INT	I
    //   302: bipush 11
    //   304: if_icmplt +297 -> 601
    //   307: aload 14
    //   309: invokestatic 247	com/tencent/image/SliceBitmap:needSlice	(Landroid/graphics/Bitmap;)Z
    //   312: istore 11
    //   314: iload 11
    //   316: ifeq +285 -> 601
    //   319: new 243	com/tencent/image/SliceBitmap
    //   322: dup
    //   323: aload 14
    //   325: invokespecial 250	com/tencent/image/SliceBitmap:<init>	(Landroid/graphics/Bitmap;)V
    //   328: astore 12
    //   330: aload 14
    //   332: invokevirtual 253	android/graphics/Bitmap:recycle	()V
    //   335: aload 16
    //   337: getfield 357	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   340: iconst_1
    //   341: if_icmple +44 -> 385
    //   344: aload_2
    //   345: getfield 256	com/tencent/image/DownloadParams:mAutoScaleByDensity	Z
    //   348: ifeq +391 -> 739
    //   351: aload_2
    //   352: iload 9
    //   354: i2f
    //   355: aload_0
    //   356: getfield 33	com/tencent/mobileqq/activity/aio/photo/PhotoDecoder:jdField_a_of_type_Float	F
    //   359: fmul
    //   360: f2d
    //   361: invokestatic 260	java/lang/Math:ceil	(D)D
    //   364: d2i
    //   365: putfield 261	com/tencent/image/DownloadParams:outWidth	I
    //   368: aload_2
    //   369: iload 10
    //   371: i2f
    //   372: aload_0
    //   373: getfield 33	com/tencent/mobileqq/activity/aio/photo/PhotoDecoder:jdField_a_of_type_Float	F
    //   376: fmul
    //   377: f2d
    //   378: invokestatic 260	java/lang/Math:ceil	(D)D
    //   381: d2i
    //   382: putfield 262	com/tencent/image/DownloadParams:outHeight	I
    //   385: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   388: ifeq +74 -> 462
    //   391: ldc 56
    //   393: iconst_2
    //   394: new 166	java/lang/StringBuilder
    //   397: dup
    //   398: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   401: ldc_w 264
    //   404: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: aload_1
    //   408: invokevirtual 149	java/io/File:length	()J
    //   411: invokevirtual 176	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   414: ldc_w 266
    //   417: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: aload 16
    //   422: getfield 355	com/tencent/mobileqq/pic/JpegOptions:outWidth	I
    //   425: invokevirtual 269	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   428: ldc_w 271
    //   431: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: aload 16
    //   436: getfield 356	com/tencent/mobileqq/pic/JpegOptions:outHeight	I
    //   439: invokevirtual 269	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   442: ldc_w 273
    //   445: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: aload 16
    //   450: getfield 357	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   453: invokevirtual 269	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   456: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   462: aload 12
    //   464: astore_1
    //   465: aload 13
    //   467: ifnull -203 -> 264
    //   470: aload 13
    //   472: invokevirtual 333	java/io/InputStream:close	()V
    //   475: aload 12
    //   477: areturn
    //   478: astore 12
    //   480: aload 14
    //   482: ifnull +8 -> 490
    //   485: aload 14
    //   487: invokevirtual 253	android/graphics/Bitmap:recycle	()V
    //   490: new 71	java/lang/OutOfMemoryError
    //   493: dup
    //   494: ldc_w 278
    //   497: invokespecial 281	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   500: athrow
    //   501: astore 12
    //   503: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   506: ifeq +71 -> 577
    //   509: ldc 56
    //   511: iconst_2
    //   512: new 166	java/lang/StringBuilder
    //   515: dup
    //   516: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   519: ldc_w 283
    //   522: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: iload 8
    //   527: invokevirtual 269	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   530: ldc_w 285
    //   533: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: aload 16
    //   538: getfield 357	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   541: invokevirtual 269	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   544: ldc_w 287
    //   547: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: aload_2
    //   551: getfield 291	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   554: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: ldc_w 293
    //   560: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: aload 12
    //   565: invokevirtual 296	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   568: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   574: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   577: invokestatic 299	java/lang/System:gc	()V
    //   580: invokestatic 304	java/lang/Thread:yield	()V
    //   583: invokestatic 299	java/lang/System:gc	()V
    //   586: iload 8
    //   588: iconst_1
    //   589: iadd
    //   590: istore 8
    //   592: iload 7
    //   594: iconst_2
    //   595: imul
    //   596: istore 7
    //   598: goto -379 -> 219
    //   601: aload_2
    //   602: getfield 307	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   605: ifnull +127 -> 732
    //   608: ldc_w 309
    //   611: aload_2
    //   612: getfield 307	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   615: invokevirtual 315	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   618: ifeq +114 -> 732
    //   621: aload_2
    //   622: getfield 307	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   625: checkcast 309	com/tencent/mobileqq/activity/aio/photo/PhotoDecoder$DownloadParamsExtraInfo
    //   628: astore 12
    //   630: aload 12
    //   632: getfield 317	com/tencent/mobileqq/activity/aio/photo/PhotoDecoder$DownloadParamsExtraInfo:a	I
    //   635: ifle +165 -> 800
    //   638: aload_0
    //   639: aload 14
    //   641: aload 12
    //   643: getfield 317	com/tencent/mobileqq/activity/aio/photo/PhotoDecoder$DownloadParamsExtraInfo:a	I
    //   646: invokespecial 319	com/tencent/mobileqq/activity/aio/photo/PhotoDecoder:a	(Landroid/graphics/Bitmap;I)Lcom/tencent/image/RoundRectBitmap;
    //   649: astore 15
    //   651: aload 15
    //   653: astore 12
    //   655: aload 15
    //   657: getfield 323	com/tencent/image/RoundRectBitmap:mBitmap	Landroid/graphics/Bitmap;
    //   660: aload 14
    //   662: invokevirtual 328	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   665: ifne -330 -> 335
    //   668: aload 14
    //   670: invokevirtual 253	android/graphics/Bitmap:recycle	()V
    //   673: aload 15
    //   675: astore 12
    //   677: goto -342 -> 335
    //   680: astore 14
    //   682: aload 13
    //   684: astore 12
    //   686: aload 14
    //   688: astore 13
    //   690: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   693: ifeq +15 -> 708
    //   696: ldc_w 359
    //   699: iconst_2
    //   700: ldc_w 372
    //   703: aload 13
    //   705: invokestatic 365	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   708: aload_0
    //   709: aload_1
    //   710: aload_2
    //   711: aload_3
    //   712: iload 4
    //   714: invokespecial 374	com/tencent/mobileqq/activity/aio/photo/PhotoDecoder:b	(Ljava/io/File;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;I)Ljava/lang/Object;
    //   717: astore_2
    //   718: aload_2
    //   719: astore_1
    //   720: aload 12
    //   722: ifnull -458 -> 264
    //   725: aload 12
    //   727: invokevirtual 333	java/io/InputStream:close	()V
    //   730: aload_2
    //   731: areturn
    //   732: aload 14
    //   734: astore 12
    //   736: goto -401 -> 335
    //   739: iload 9
    //   741: i2d
    //   742: dstore 5
    //   744: aload_2
    //   745: dload 5
    //   747: invokestatic 260	java/lang/Math:ceil	(D)D
    //   750: d2i
    //   751: putfield 261	com/tencent/image/DownloadParams:outWidth	I
    //   754: aload_2
    //   755: iload 10
    //   757: i2d
    //   758: invokestatic 260	java/lang/Math:ceil	(D)D
    //   761: d2i
    //   762: putfield 262	com/tencent/image/DownloadParams:outHeight	I
    //   765: goto -380 -> 385
    //   768: astore_1
    //   769: aload 13
    //   771: astore_2
    //   772: aload_2
    //   773: ifnull +7 -> 780
    //   776: aload_2
    //   777: invokevirtual 333	java/io/InputStream:close	()V
    //   780: aload_1
    //   781: athrow
    //   782: astore_1
    //   783: aconst_null
    //   784: astore_2
    //   785: goto -13 -> 772
    //   788: astore_1
    //   789: aload 12
    //   791: astore_2
    //   792: goto -20 -> 772
    //   795: astore 13
    //   797: goto -107 -> 690
    //   800: aconst_null
    //   801: astore 12
    //   803: goto -468 -> 335
    //   806: aconst_null
    //   807: astore 12
    //   809: goto -474 -> 335
    //   812: iload 8
    //   814: istore 7
    //   816: goto -692 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	819	0	this	PhotoDecoder
    //   0	819	1	paramFile	File
    //   0	819	2	paramDownloadParams	DownloadParams
    //   0	819	3	paramURLDrawableHandler	URLDrawableHandler
    //   0	819	4	paramInt	int
    //   742	4	5	d	double
    //   44	771	7	i	int
    //   47	766	8	j	int
    //   30	710	9	k	int
    //   36	720	10	m	int
    //   312	3	11	bool	boolean
    //   1	475	12	localObject1	Object
    //   478	1	12	localException	Exception
    //   501	63	12	localOutOfMemoryError	OutOfMemoryError
    //   628	180	12	localObject2	Object
    //   11	759	13	localObject3	Object
    //   795	1	13	localRuntimeException1	java.lang.RuntimeException
    //   241	428	14	localBitmap	Bitmap
    //   680	53	14	localRuntimeException2	java.lang.RuntimeException
    //   649	25	15	localRoundRectBitmap	RoundRectBitmap
    //   131	406	16	localJpegOptions	com.tencent.mobileqq.pic.JpegOptions
    // Exception table:
    //   from	to	target	type
    //   319	335	478	java/lang/Exception
    //   225	243	501	java/lang/OutOfMemoryError
    //   291	314	501	java/lang/OutOfMemoryError
    //   319	335	501	java/lang/OutOfMemoryError
    //   485	490	501	java/lang/OutOfMemoryError
    //   490	501	501	java/lang/OutOfMemoryError
    //   601	651	501	java/lang/OutOfMemoryError
    //   655	673	501	java/lang/OutOfMemoryError
    //   13	26	680	java/lang/RuntimeException
    //   38	43	680	java/lang/RuntimeException
    //   124	170	680	java/lang/RuntimeException
    //   175	186	680	java/lang/RuntimeException
    //   186	216	680	java/lang/RuntimeException
    //   225	243	680	java/lang/RuntimeException
    //   269	274	680	java/lang/RuntimeException
    //   291	314	680	java/lang/RuntimeException
    //   319	335	680	java/lang/RuntimeException
    //   335	385	680	java/lang/RuntimeException
    //   385	462	680	java/lang/RuntimeException
    //   485	490	680	java/lang/RuntimeException
    //   490	501	680	java/lang/RuntimeException
    //   503	577	680	java/lang/RuntimeException
    //   577	586	680	java/lang/RuntimeException
    //   601	651	680	java/lang/RuntimeException
    //   655	673	680	java/lang/RuntimeException
    //   744	765	680	java/lang/RuntimeException
    //   13	26	768	finally
    //   38	43	768	finally
    //   124	170	768	finally
    //   175	186	768	finally
    //   186	216	768	finally
    //   225	243	768	finally
    //   269	274	768	finally
    //   291	314	768	finally
    //   319	335	768	finally
    //   335	385	768	finally
    //   385	462	768	finally
    //   485	490	768	finally
    //   490	501	768	finally
    //   503	577	768	finally
    //   577	586	768	finally
    //   601	651	768	finally
    //   655	673	768	finally
    //   744	765	768	finally
    //   3	13	782	finally
    //   690	708	788	finally
    //   708	718	788	finally
    //   3	13	795	java/lang/RuntimeException
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    long l1 = SystemClock.uptimeMillis();
    try
    {
      if (VideoDrawable.isVideo(paramFile))
      {
        paramURLDrawableHandler = a(paramFile, paramDownloadParams, paramURLDrawableHandler);
        paramDownloadParams = paramURLDrawableHandler;
        if (QLog.isColorLevel())
        {
          l2 = SystemClock.uptimeMillis();
          QLog.d("PEAK", 2, "decode file:" + paramFile.getAbsolutePath() + " cost: " + (l2 - l1));
          paramDownloadParams = paramURLDrawableHandler;
        }
        return paramDownloadParams;
      }
      l2 = paramFile.length();
      int i = 0;
      if (paramDownloadParams.tag != null) {
        i = ((Integer)paramDownloadParams.tag).intValue();
      }
      if ((Utils.b()) && (ImageUtil.b(paramFile.getAbsolutePath())))
      {
        if (l2 < 5242880L)
        {
          paramURLDrawableHandler = c(paramFile, paramDownloadParams, paramURLDrawableHandler, i);
          paramDownloadParams = paramURLDrawableHandler;
          return paramURLDrawableHandler;
        }
        paramURLDrawableHandler = d(paramFile, paramDownloadParams, paramURLDrawableHandler, i);
        paramDownloadParams = paramURLDrawableHandler;
        return paramURLDrawableHandler;
      }
      if (l2 < 5242880L)
      {
        paramURLDrawableHandler = a(paramFile, paramDownloadParams, paramURLDrawableHandler, i);
        paramDownloadParams = paramURLDrawableHandler;
        return paramURLDrawableHandler;
      }
      paramURLDrawableHandler = b(paramFile, paramDownloadParams, paramURLDrawableHandler, i);
      paramDownloadParams = paramURLDrawableHandler;
      return paramURLDrawableHandler;
    }
    finally
    {
      long l2;
      if (QLog.isColorLevel())
      {
        l2 = SystemClock.uptimeMillis();
        QLog.d("PEAK", 2, "decode file:" + paramFile.getAbsolutePath() + " cost: " + (l2 - l1));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoDecoder
 * JD-Core Version:    0.7.0.1
 */