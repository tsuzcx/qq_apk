package com.nostra13.universalimageloader.utils;

import android.opengl.GLES10;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;

public final class ImageSizeUtils
{
  private static final int DEFAULT_MAX_BITMAP_DIMENSION = 2048;
  private static ImageSize maxBitmapSize;
  
  static
  {
    int[] arrayOfInt = new int[1];
    GLES10.glGetIntegerv(3379, arrayOfInt, 0);
    int i = Math.max(arrayOfInt[0], 2048);
    maxBitmapSize = new ImageSize(i, i);
  }
  
  public static int computeImageSampleSize(ImageSize paramImageSize1, ImageSize paramImageSize2, ViewScaleType paramViewScaleType, boolean paramBoolean)
  {
    int k = 1;
    int m = paramImageSize1.getWidth();
    int n = paramImageSize1.getHeight();
    int i1 = paramImageSize2.getWidth();
    int i2 = paramImageSize2.getHeight();
    int i;
    switch (ImageSizeUtils.1.$SwitchMap$com$nostra13$universalimageloader$core$assist$ViewScaleType[paramViewScaleType.ordinal()])
    {
    default: 
      i = 1;
      if (i < 1) {
        i = k;
      }
      break;
    }
    for (;;)
    {
      return considerMaxTextureSize(m, n, i, paramBoolean);
      int i3;
      int i4;
      int j;
      if (paramBoolean)
      {
        i3 = m / 2;
        i4 = n / 2;
        j = 1;
        for (;;)
        {
          if (i3 / j <= i1)
          {
            i = j;
            if (i4 / j <= i2) {
              break;
            }
          }
          j *= 2;
        }
      }
      i = Math.max(m / i1, n / i2);
      break;
      if (paramBoolean)
      {
        i3 = m / 2;
        i4 = n / 2;
        j = 1;
        for (;;)
        {
          i = j;
          if (i3 / j <= i1) {
            break;
          }
          i = j;
          if (i4 / j <= i2) {
            break;
          }
          j *= 2;
        }
      }
      i = Math.min(m / i1, n / i2);
      break;
    }
  }
  
  public static float computeImageScale(ImageSize paramImageSize1, ImageSize paramImageSize2, ViewScaleType paramViewScaleType, boolean paramBoolean)
  {
    int k = paramImageSize1.getWidth();
    int m = paramImageSize1.getHeight();
    int i = paramImageSize2.getWidth();
    int j = paramImageSize2.getHeight();
    float f1 = k / i;
    float f2 = m / j;
    if (((paramViewScaleType == ViewScaleType.FIT_INSIDE) && (f1 >= f2)) || ((paramViewScaleType == ViewScaleType.CROP) && (f1 < f2))) {
      j = (int)(m / f1);
    }
    for (;;)
    {
      f2 = 1.0F;
      if ((paramBoolean) || (i >= k) || (j >= m))
      {
        f1 = f2;
        if (paramBoolean)
        {
          f1 = f2;
          if (i != k)
          {
            f1 = f2;
            if (j == m) {}
          }
        }
      }
      else
      {
        f1 = i / k;
      }
      return f1;
      i = (int)(k / f2);
    }
  }
  
  public static int computeMinImageSampleSize(ImageSize paramImageSize)
  {
    int i = paramImageSize.getWidth();
    int j = paramImageSize.getHeight();
    int k = maxBitmapSize.getWidth();
    int m = maxBitmapSize.getHeight();
    return Math.max((int)Math.ceil(i / k), (int)Math.ceil(j / m));
  }
  
  private static int considerMaxTextureSize(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int i = maxBitmapSize.getWidth();
    int j = maxBitmapSize.getHeight();
    while ((paramInt1 / paramInt3 > i) || (paramInt2 / paramInt3 > j)) {
      if (paramBoolean) {
        paramInt3 *= 2;
      } else {
        paramInt3 += 1;
      }
    }
    return paramInt3;
  }
  
  public static ImageSize defineTargetSizeForView(ImageAware paramImageAware, ImageSize paramImageSize)
  {
    int j = paramImageAware.getWidth();
    int i = j;
    if (j <= 0) {
      i = paramImageSize.getWidth();
    }
    int k = paramImageAware.getHeight();
    j = k;
    if (k <= 0) {
      j = paramImageSize.getHeight();
    }
    return new ImageSize(i, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nostra13.universalimageloader.utils.ImageSizeUtils
 * JD-Core Version:    0.7.0.1
 */