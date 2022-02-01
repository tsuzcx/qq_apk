package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public final class Downsampler
{
  public static final Option<DecodeFormat> a = Option.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);
  @Deprecated
  public static final Option<DownsampleStrategy> b = DownsampleStrategy.h;
  public static final Option<Boolean> c = Option.a("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", Boolean.valueOf(false));
  public static final Option<Boolean> d = Option.a("com.bumtpech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode");
  private static final Set<String> e = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] { "image/vnd.wap.wbmp", "image/x-ico" })));
  private static final Downsampler.DecodeCallbacks f = new Downsampler.1();
  private static final Set<ImageHeaderParser.ImageType> g = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
  private static final Queue<BitmapFactory.Options> h = Util.a(0);
  private final BitmapPool i;
  private final DisplayMetrics j;
  private final ArrayPool k;
  private final List<ImageHeaderParser> l;
  private final HardwareConfigState m = HardwareConfigState.a();
  
  public Downsampler(List<ImageHeaderParser> paramList, DisplayMetrics paramDisplayMetrics, BitmapPool paramBitmapPool, ArrayPool paramArrayPool)
  {
    this.l = paramList;
    this.j = ((DisplayMetrics)Preconditions.a(paramDisplayMetrics));
    this.i = ((BitmapPool)Preconditions.a(paramBitmapPool));
    this.k = ((ArrayPool)Preconditions.a(paramArrayPool));
  }
  
  private static int a(double paramDouble)
  {
    int n = b(paramDouble);
    double d1 = n;
    Double.isNaN(d1);
    int i1 = c(d1 * paramDouble);
    d1 = i1 / n;
    Double.isNaN(d1);
    paramDouble /= d1;
    d1 = i1;
    Double.isNaN(d1);
    return c(paramDouble * d1);
  }
  
  private Bitmap a(InputStream paramInputStream, BitmapFactory.Options paramOptions, DownsampleStrategy paramDownsampleStrategy, DecodeFormat paramDecodeFormat, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, Downsampler.DecodeCallbacks paramDecodeCallbacks)
  {
    long l1 = LogTime.a();
    Object localObject = a(paramInputStream, paramOptions, paramDecodeCallbacks, this.i);
    int i2 = 0;
    int i3 = localObject[0];
    int i4 = localObject[1];
    localObject = paramOptions.outMimeType;
    if ((i3 != -1) && (i4 != -1)) {
      break label60;
    }
    paramBoolean1 = false;
    label60:
    int i6 = ImageHeaderParserUtils.b(this.l, paramInputStream, this.k);
    int i5 = TransformationUtils.a(i6);
    boolean bool = TransformationUtils.b(i6);
    int n;
    if (paramInt1 == -2147483648) {
      n = i3;
    } else {
      n = paramInt1;
    }
    int i1 = paramInt2;
    if (i1 == -2147483648) {
      i1 = i4;
    }
    ImageHeaderParser.ImageType localImageType = ImageHeaderParserUtils.a(this.l, paramInputStream, this.k);
    a(localImageType, paramInputStream, paramDecodeCallbacks, this.i, paramDownsampleStrategy, i5, i3, i4, n, i1, paramOptions);
    a(paramInputStream, paramDecodeFormat, paramBoolean1, bool, paramOptions, n, i1);
    if (Build.VERSION.SDK_INT >= 19) {
      i2 = 1;
    }
    if ((paramOptions.inSampleSize != 1) && (i2 == 0)) {
      break label538;
    }
    paramDownsampleStrategy = this;
    if (paramDownsampleStrategy.a(localImageType))
    {
      if ((i3 < 0) || (i4 < 0) || (!paramBoolean2) || (i2 == 0))
      {
        float f1;
        if (a(paramOptions)) {
          f1 = paramOptions.inTargetDensity / paramOptions.inDensity;
        } else {
          f1 = 1.0F;
        }
        int i7 = paramOptions.inSampleSize;
        float f2 = i3;
        float f3 = i7;
        i1 = (int)Math.ceil(f2 / f3);
        n = (int)Math.ceil(i4 / f3);
        i2 = Math.round(i1 * f1);
        i5 = Math.round(n * f1);
        n = i2;
        i1 = i5;
        if (Log.isLoggable("Downsampler", 2))
        {
          paramDecodeFormat = new StringBuilder();
          paramDecodeFormat.append("Calculated target [");
          paramDecodeFormat.append(i2);
          paramDecodeFormat.append("x");
          paramDecodeFormat.append(i5);
          paramDecodeFormat.append("] for source [");
          paramDecodeFormat.append(i3);
          paramDecodeFormat.append("x");
          paramDecodeFormat.append(i4);
          paramDecodeFormat.append("], sampleSize: ");
          paramDecodeFormat.append(i7);
          paramDecodeFormat.append(", targetDensity: ");
          paramDecodeFormat.append(paramOptions.inTargetDensity);
          paramDecodeFormat.append(", density: ");
          paramDecodeFormat.append(paramOptions.inDensity);
          paramDecodeFormat.append(", density multiplier: ");
          paramDecodeFormat.append(f1);
          Log.v("Downsampler", paramDecodeFormat.toString());
          i1 = i5;
          n = i2;
        }
      }
      if ((n > 0) && (i1 > 0)) {
        a(paramOptions, paramDownsampleStrategy.i, n, i1);
      }
    }
    label538:
    paramDownsampleStrategy = this;
    paramDecodeFormat = b(paramInputStream, paramOptions, paramDecodeCallbacks, paramDownsampleStrategy.i);
    paramDecodeCallbacks.a(paramDownsampleStrategy.i, paramDecodeFormat);
    if (Log.isLoggable("Downsampler", 2)) {
      a(i3, i4, (String)localObject, paramOptions, paramDecodeFormat, paramInt1, paramInt2, l1);
    }
    paramInputStream = null;
    if (paramDecodeFormat != null)
    {
      paramDecodeFormat.setDensity(paramDownsampleStrategy.j.densityDpi);
      paramOptions = TransformationUtils.a(paramDownsampleStrategy.i, paramDecodeFormat, i6);
      paramInputStream = paramOptions;
      if (!paramDecodeFormat.equals(paramOptions))
      {
        paramDownsampleStrategy.i.a(paramDecodeFormat);
        paramInputStream = paramOptions;
      }
    }
    return paramInputStream;
  }
  
  /* Error */
  private static BitmapFactory.Options a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 133	com/bumptech/glide/load/resource/bitmap/Downsampler:h	Ljava/util/Queue;
    //   6: astore_0
    //   7: aload_0
    //   8: monitorenter
    //   9: getstatic 133	com/bumptech/glide/load/resource/bitmap/Downsampler:h	Ljava/util/Queue;
    //   12: invokeinterface 327 1 0
    //   17: checkcast 186	android/graphics/BitmapFactory$Options
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: astore_0
    //   25: aload_1
    //   26: ifnonnull +15 -> 41
    //   29: new 186	android/graphics/BitmapFactory$Options
    //   32: dup
    //   33: invokespecial 328	android/graphics/BitmapFactory$Options:<init>	()V
    //   36: astore_0
    //   37: aload_0
    //   38: invokestatic 331	com/bumptech/glide/load/resource/bitmap/Downsampler:d	(Landroid/graphics/BitmapFactory$Options;)V
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: areturn
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    //   51: astore_0
    //   52: ldc 2
    //   54: monitorexit
    //   55: aload_0
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   51	5	0	localObject2	Object
    //   20	6	1	localOptions	BitmapFactory.Options
    //   46	4	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   9	23	46	finally
    //   47	49	46	finally
    //   3	9	51	finally
    //   29	41	51	finally
    //   49	51	51	finally
  }
  
  private static IOException a(IllegalArgumentException paramIllegalArgumentException, int paramInt1, int paramInt2, String paramString, BitmapFactory.Options paramOptions)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Exception decoding bitmap, outWidth: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", outHeight: ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", outMimeType: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", inBitmap: ");
    localStringBuilder.append(b(paramOptions));
    return new IOException(localStringBuilder.toString(), paramIllegalArgumentException);
  }
  
  @TargetApi(19)
  @Nullable
  private static String a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    Object localObject;
    if (Build.VERSION.SDK_INT >= 19)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" (");
      ((StringBuilder)localObject).append(paramBitmap.getAllocationByteCount());
      ((StringBuilder)localObject).append(")");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramBitmap.getWidth());
    localStringBuilder.append("x");
    localStringBuilder.append(paramBitmap.getHeight());
    localStringBuilder.append("] ");
    localStringBuilder.append(paramBitmap.getConfig());
    localStringBuilder.append((String)localObject);
    return localStringBuilder.toString();
  }
  
  private static void a(int paramInt1, int paramInt2, String paramString, BitmapFactory.Options paramOptions, Bitmap paramBitmap, int paramInt3, int paramInt4, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Decoded ");
    localStringBuilder.append(a(paramBitmap));
    localStringBuilder.append(" from [");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("x");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("] ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" with inBitmap ");
    localStringBuilder.append(b(paramOptions));
    localStringBuilder.append(" for [");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("x");
    localStringBuilder.append(paramInt4);
    localStringBuilder.append("], sample size: ");
    localStringBuilder.append(paramOptions.inSampleSize);
    localStringBuilder.append(", density: ");
    localStringBuilder.append(paramOptions.inDensity);
    localStringBuilder.append(", target density: ");
    localStringBuilder.append(paramOptions.inTargetDensity);
    localStringBuilder.append(", thread: ");
    localStringBuilder.append(Thread.currentThread().getName());
    localStringBuilder.append(", duration: ");
    localStringBuilder.append(LogTime.a(paramLong));
    Log.v("Downsampler", localStringBuilder.toString());
  }
  
  @TargetApi(26)
  private static void a(BitmapFactory.Options paramOptions, BitmapPool paramBitmapPool, int paramInt1, int paramInt2)
  {
    Bitmap.Config localConfig1;
    if (Build.VERSION.SDK_INT >= 26)
    {
      if (paramOptions.inPreferredConfig == Bitmap.Config.HARDWARE) {
        return;
      }
      localConfig1 = paramOptions.outConfig;
    }
    else
    {
      localConfig1 = null;
    }
    Bitmap.Config localConfig2 = localConfig1;
    if (localConfig1 == null) {
      localConfig2 = paramOptions.inPreferredConfig;
    }
    paramOptions.inBitmap = paramBitmapPool.b(paramInt1, paramInt2, localConfig2);
  }
  
  private static void a(ImageHeaderParser.ImageType paramImageType, InputStream paramInputStream, Downsampler.DecodeCallbacks paramDecodeCallbacks, BitmapPool paramBitmapPool, DownsampleStrategy paramDownsampleStrategy, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, BitmapFactory.Options paramOptions)
  {
    if ((paramInt2 > 0) && (paramInt3 > 0))
    {
      float f1;
      if ((paramInt1 != 90) && (paramInt1 != 270)) {
        f1 = paramDownsampleStrategy.a(paramInt2, paramInt3, paramInt4, paramInt5);
      } else {
        f1 = paramDownsampleStrategy.a(paramInt3, paramInt2, paramInt4, paramInt5);
      }
      if (f1 > 0.0F)
      {
        DownsampleStrategy.SampleSizeRounding localSampleSizeRounding = paramDownsampleStrategy.b(paramInt2, paramInt3, paramInt4, paramInt5);
        if (localSampleSizeRounding != null)
        {
          float f2 = paramInt2;
          int n = c(f1 * f2);
          float f3 = paramInt3;
          paramInt1 = c(f1 * f3);
          n = paramInt2 / n;
          paramInt1 = paramInt3 / paramInt1;
          if (localSampleSizeRounding == DownsampleStrategy.SampleSizeRounding.MEMORY) {
            paramInt1 = Math.max(n, paramInt1);
          } else {
            paramInt1 = Math.min(n, paramInt1);
          }
          int i1;
          if ((Build.VERSION.SDK_INT <= 23) && (e.contains(paramOptions.outMimeType)))
          {
            i1 = 1;
          }
          else
          {
            i1 = Math.max(1, Integer.highestOneBit(paramInt1));
            if ((localSampleSizeRounding == DownsampleStrategy.SampleSizeRounding.MEMORY) && (i1 < 1.0F / f1)) {
              i1 <<= 1;
            }
          }
          paramOptions.inSampleSize = i1;
          float f4;
          if (paramImageType == ImageHeaderParser.ImageType.JPEG)
          {
            f4 = Math.min(i1, 8);
            int i3 = (int)Math.ceil(f2 / f4);
            int i2 = (int)Math.ceil(f3 / f4);
            int i4 = i1 / 8;
            paramInt1 = i2;
            n = i3;
            if (i4 > 0)
            {
              n = i3 / i4;
              paramInt1 = i2 / i4;
            }
          }
          else
          {
            if ((paramImageType != ImageHeaderParser.ImageType.PNG) && (paramImageType != ImageHeaderParser.ImageType.PNG_A))
            {
              if ((paramImageType != ImageHeaderParser.ImageType.WEBP) && (paramImageType != ImageHeaderParser.ImageType.WEBP_A))
              {
                if ((paramInt2 % i1 == 0) && (paramInt3 % i1 == 0))
                {
                  n = paramInt2 / i1;
                  paramInt1 = paramInt3 / i1;
                  break label512;
                }
                paramImageType = a(paramInputStream, paramOptions, paramDecodeCallbacks, paramBitmapPool);
                n = paramImageType[0];
                paramInt1 = paramImageType[1];
                break label512;
              }
              if (Build.VERSION.SDK_INT >= 24)
              {
                f4 = i1;
                n = Math.round(f2 / f4);
                paramInt1 = Math.round(f3 / f4);
                break label512;
              }
              f4 = i1;
              n = (int)Math.floor(f2 / f4);
              d1 = Math.floor(f3 / f4);
            }
            else
            {
              f4 = i1;
              n = (int)Math.floor(f2 / f4);
              d1 = Math.floor(f3 / f4);
            }
            paramInt1 = (int)d1;
          }
          label512:
          double d1 = paramDownsampleStrategy.a(n, paramInt1, paramInt4, paramInt5);
          if (Build.VERSION.SDK_INT >= 19)
          {
            paramOptions.inTargetDensity = a(d1);
            paramOptions.inDensity = b(d1);
          }
          if (a(paramOptions))
          {
            paramOptions.inScaled = true;
          }
          else
          {
            paramOptions.inTargetDensity = 0;
            paramOptions.inDensity = 0;
          }
          if (Log.isLoggable("Downsampler", 2))
          {
            paramImageType = new StringBuilder();
            paramImageType.append("Calculate scaling, source: [");
            paramImageType.append(paramInt2);
            paramImageType.append("x");
            paramImageType.append(paramInt3);
            paramImageType.append("], target: [");
            paramImageType.append(paramInt4);
            paramImageType.append("x");
            paramImageType.append(paramInt5);
            paramImageType.append("], power of two scaled: [");
            paramImageType.append(n);
            paramImageType.append("x");
            paramImageType.append(paramInt1);
            paramImageType.append("], exact scale factor: ");
            paramImageType.append(f1);
            paramImageType.append(", power of 2 sample size: ");
            paramImageType.append(i1);
            paramImageType.append(", adjusted scale factor: ");
            paramImageType.append(d1);
            paramImageType.append(", target density: ");
            paramImageType.append(paramOptions.inTargetDensity);
            paramImageType.append(", density: ");
            paramImageType.append(paramOptions.inDensity);
            Log.v("Downsampler", paramImageType.toString());
          }
          return;
        }
        throw new IllegalArgumentException("Cannot round with null rounding");
      }
      paramImageType = new StringBuilder();
      paramImageType.append("Cannot scale with factor: ");
      paramImageType.append(f1);
      paramImageType.append(" from: ");
      paramImageType.append(paramDownsampleStrategy);
      paramImageType.append(", source: [");
      paramImageType.append(paramInt2);
      paramImageType.append("x");
      paramImageType.append(paramInt3);
      paramImageType.append("], target: [");
      paramImageType.append(paramInt4);
      paramImageType.append("x");
      paramImageType.append(paramInt5);
      paramImageType.append("]");
      throw new IllegalArgumentException(paramImageType.toString());
    }
    if (Log.isLoggable("Downsampler", 3))
    {
      paramInputStream = new StringBuilder();
      paramInputStream.append("Unable to determine dimensions for: ");
      paramInputStream.append(paramImageType);
      paramInputStream.append(" with target [");
      paramInputStream.append(paramInt4);
      paramInputStream.append("x");
      paramInputStream.append(paramInt5);
      paramInputStream.append("]");
      Log.d("Downsampler", paramInputStream.toString());
    }
  }
  
  private void a(InputStream paramInputStream, DecodeFormat paramDecodeFormat, boolean paramBoolean1, boolean paramBoolean2, BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    if (this.m.a(paramInt1, paramInt2, paramOptions, paramDecodeFormat, paramBoolean1, paramBoolean2)) {
      return;
    }
    if ((paramDecodeFormat != DecodeFormat.PREFER_ARGB_8888) && (paramDecodeFormat != DecodeFormat.PREFER_ARGB_8888_DISALLOW_HARDWARE) && (Build.VERSION.SDK_INT != 16))
    {
      paramBoolean2 = false;
      try
      {
        paramBoolean1 = ImageHeaderParserUtils.a(this.l, paramInputStream, this.k).hasAlpha();
      }
      catch (IOException paramInputStream)
      {
        paramBoolean1 = paramBoolean2;
        if (Log.isLoggable("Downsampler", 3))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Cannot determine whether the image has alpha or not from header, format ");
          localStringBuilder.append(paramDecodeFormat);
          Log.d("Downsampler", localStringBuilder.toString(), paramInputStream);
          paramBoolean1 = paramBoolean2;
        }
      }
      if (paramBoolean1) {
        paramInputStream = Bitmap.Config.ARGB_8888;
      } else {
        paramInputStream = Bitmap.Config.RGB_565;
      }
      paramOptions.inPreferredConfig = paramInputStream;
      if (paramOptions.inPreferredConfig == Bitmap.Config.RGB_565) {
        paramOptions.inDither = true;
      }
      return;
    }
    paramOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
  }
  
  private static boolean a(BitmapFactory.Options paramOptions)
  {
    return (paramOptions.inTargetDensity > 0) && (paramOptions.inDensity > 0) && (paramOptions.inTargetDensity != paramOptions.inDensity);
  }
  
  private boolean a(ImageHeaderParser.ImageType paramImageType)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return true;
    }
    return g.contains(paramImageType);
  }
  
  private static int[] a(InputStream paramInputStream, BitmapFactory.Options paramOptions, Downsampler.DecodeCallbacks paramDecodeCallbacks, BitmapPool paramBitmapPool)
  {
    paramOptions.inJustDecodeBounds = true;
    b(paramInputStream, paramOptions, paramDecodeCallbacks, paramBitmapPool);
    paramOptions.inJustDecodeBounds = false;
    return new int[] { paramOptions.outWidth, paramOptions.outHeight };
  }
  
  private static int b(double paramDouble)
  {
    if (paramDouble > 1.0D) {
      paramDouble = 1.0D / paramDouble;
    }
    return (int)Math.round(paramDouble * 2147483647.0D);
  }
  
  /* Error */
  private static Bitmap b(InputStream paramInputStream, BitmapFactory.Options paramOptions, Downsampler.DecodeCallbacks paramDecodeCallbacks, BitmapPool paramBitmapPool)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 541	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   4: ifeq +13 -> 17
    //   7: aload_0
    //   8: ldc_w 553
    //   11: invokevirtual 558	java/io/InputStream:mark	(I)V
    //   14: goto +9 -> 23
    //   17: aload_2
    //   18: invokeinterface 560 1 0
    //   23: aload_1
    //   24: getfield 544	android/graphics/BitmapFactory$Options:outWidth	I
    //   27: istore 4
    //   29: aload_1
    //   30: getfield 547	android/graphics/BitmapFactory$Options:outHeight	I
    //   33: istore 5
    //   35: aload_1
    //   36: getfield 190	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   39: astore 6
    //   41: invokestatic 563	com/bumptech/glide/load/resource/bitmap/TransformationUtils:a	()Ljava/util/concurrent/locks/Lock;
    //   44: invokeinterface 568 1 0
    //   49: aload_0
    //   50: aconst_null
    //   51: aload_1
    //   52: invokestatic 574	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   55: astore 7
    //   57: invokestatic 563	com/bumptech/glide/load/resource/bitmap/TransformationUtils:a	()Ljava/util/concurrent/locks/Lock;
    //   60: invokeinterface 577 1 0
    //   65: aload_1
    //   66: getfield 541	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   69: ifeq +7 -> 76
    //   72: aload_0
    //   73: invokevirtual 580	java/io/InputStream:reset	()V
    //   76: aload 7
    //   78: areturn
    //   79: astore_0
    //   80: goto +93 -> 173
    //   83: astore 7
    //   85: aload 7
    //   87: iload 4
    //   89: iload 5
    //   91: aload 6
    //   93: aload_1
    //   94: invokestatic 582	com/bumptech/glide/load/resource/bitmap/Downsampler:a	(Ljava/lang/IllegalArgumentException;IILjava/lang/String;Landroid/graphics/BitmapFactory$Options;)Ljava/io/IOException;
    //   97: astore 6
    //   99: ldc 246
    //   101: iconst_3
    //   102: invokestatic 252	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   105: ifeq +14 -> 119
    //   108: ldc 246
    //   110: ldc_w 584
    //   113: aload 6
    //   115: invokestatic 529	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   118: pop
    //   119: aload_1
    //   120: getfield 434	android/graphics/BitmapFactory$Options:inBitmap	Landroid/graphics/Bitmap;
    //   123: astore 7
    //   125: aload 7
    //   127: ifnull +43 -> 170
    //   130: aload_0
    //   131: invokevirtual 580	java/io/InputStream:reset	()V
    //   134: aload_3
    //   135: aload_1
    //   136: getfield 434	android/graphics/BitmapFactory$Options:inBitmap	Landroid/graphics/Bitmap;
    //   139: invokeinterface 320 2 0
    //   144: aload_1
    //   145: aconst_null
    //   146: putfield 434	android/graphics/BitmapFactory$Options:inBitmap	Landroid/graphics/Bitmap;
    //   149: aload_0
    //   150: aload_1
    //   151: aload_2
    //   152: aload_3
    //   153: invokestatic 293	com/bumptech/glide/load/resource/bitmap/Downsampler:b	(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;Lcom/bumptech/glide/load/resource/bitmap/Downsampler$DecodeCallbacks;Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;)Landroid/graphics/Bitmap;
    //   156: astore_0
    //   157: invokestatic 563	com/bumptech/glide/load/resource/bitmap/TransformationUtils:a	()Ljava/util/concurrent/locks/Lock;
    //   160: invokeinterface 577 1 0
    //   165: aload_0
    //   166: areturn
    //   167: aload 6
    //   169: athrow
    //   170: aload 6
    //   172: athrow
    //   173: invokestatic 563	com/bumptech/glide/load/resource/bitmap/TransformationUtils:a	()Ljava/util/concurrent/locks/Lock;
    //   176: invokeinterface 577 1 0
    //   181: aload_0
    //   182: athrow
    //   183: astore_0
    //   184: goto -17 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	paramInputStream	InputStream
    //   0	187	1	paramOptions	BitmapFactory.Options
    //   0	187	2	paramDecodeCallbacks	Downsampler.DecodeCallbacks
    //   0	187	3	paramBitmapPool	BitmapPool
    //   27	61	4	n	int
    //   33	57	5	i1	int
    //   39	132	6	localObject	Object
    //   55	22	7	localBitmap1	Bitmap
    //   83	3	7	localIllegalArgumentException	IllegalArgumentException
    //   123	3	7	localBitmap2	Bitmap
    // Exception table:
    //   from	to	target	type
    //   49	57	79	finally
    //   85	119	79	finally
    //   119	125	79	finally
    //   130	157	79	finally
    //   167	170	79	finally
    //   170	173	79	finally
    //   49	57	83	java/lang/IllegalArgumentException
    //   130	157	183	java/io/IOException
  }
  
  private static String b(BitmapFactory.Options paramOptions)
  {
    return a(paramOptions.inBitmap);
  }
  
  private static int c(double paramDouble)
  {
    return (int)(paramDouble + 0.5D);
  }
  
  private static void c(BitmapFactory.Options paramOptions)
  {
    d(paramOptions);
    synchronized (h)
    {
      h.offer(paramOptions);
      return;
    }
  }
  
  private static void d(BitmapFactory.Options paramOptions)
  {
    paramOptions.inTempStorage = null;
    paramOptions.inDither = false;
    paramOptions.inScaled = false;
    paramOptions.inSampleSize = 1;
    paramOptions.inPreferredConfig = null;
    paramOptions.inJustDecodeBounds = false;
    paramOptions.inDensity = 0;
    paramOptions.inTargetDensity = 0;
    paramOptions.outWidth = 0;
    paramOptions.outHeight = 0;
    paramOptions.outMimeType = null;
    paramOptions.inBitmap = null;
    paramOptions.inMutable = true;
  }
  
  public Resource<Bitmap> a(InputStream paramInputStream, int paramInt1, int paramInt2, Options paramOptions)
  {
    return a(paramInputStream, paramInt1, paramInt2, paramOptions, f);
  }
  
  public Resource<Bitmap> a(InputStream paramInputStream, int paramInt1, int paramInt2, Options paramOptions, Downsampler.DecodeCallbacks paramDecodeCallbacks)
  {
    Preconditions.a(paramInputStream.markSupported(), "You must provide an InputStream that supports mark()");
    byte[] arrayOfByte = (byte[])this.k.a(65536, [B.class);
    BitmapFactory.Options localOptions = a();
    localOptions.inTempStorage = arrayOfByte;
    DecodeFormat localDecodeFormat = (DecodeFormat)paramOptions.a(a);
    DownsampleStrategy localDownsampleStrategy = (DownsampleStrategy)paramOptions.a(DownsampleStrategy.h);
    boolean bool2 = ((Boolean)paramOptions.a(c)).booleanValue();
    boolean bool1;
    if ((paramOptions.a(d) != null) && (((Boolean)paramOptions.a(d)).booleanValue())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (localDecodeFormat == DecodeFormat.PREFER_ARGB_8888_DISALLOW_HARDWARE) {
      bool1 = false;
    }
    try
    {
      paramInputStream = BitmapResource.a(a(paramInputStream, localOptions, localDownsampleStrategy, localDecodeFormat, bool1, paramInt1, paramInt2, bool2, paramDecodeCallbacks), this.i);
      return paramInputStream;
    }
    finally
    {
      c(localOptions);
      this.k.a(arrayOfByte);
    }
  }
  
  public boolean a(InputStream paramInputStream)
  {
    return true;
  }
  
  public boolean a(ByteBuffer paramByteBuffer)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.bitmap.Downsampler
 * JD-Core Version:    0.7.0.1
 */