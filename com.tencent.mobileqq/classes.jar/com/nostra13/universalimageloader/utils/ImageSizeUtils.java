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
    int k = paramImageSize1.getWidth();
    int m = paramImageSize1.getHeight();
    int n = paramImageSize2.getWidth();
    int i1 = paramImageSize2.getHeight();
    int i = ImageSizeUtils.1.$SwitchMap$com$nostra13$universalimageloader$core$assist$ViewScaleType[paramViewScaleType.ordinal()];
    int i2;
    int i3;
    if (i != 1)
    {
      if (i != 2)
      {
        i = 1;
      }
      else if (paramBoolean)
      {
        i2 = k / 2;
        i3 = m / 2;
        j = 1;
        for (;;)
        {
          i = j;
          if (i2 / j <= n) {
            break;
          }
          i = j;
          if (i3 / j <= i1) {
            break;
          }
          j *= 2;
        }
      }
      else
      {
        i = Math.min(k / n, m / i1);
      }
    }
    else
    {
      if (paramBoolean)
      {
        i2 = k / 2;
        i3 = m / 2;
        j = 1;
        for (;;)
        {
          if (i2 / j <= n)
          {
            i = j;
            if (i3 / j <= i1) {
              break;
            }
          }
          j *= 2;
        }
      }
      i = Math.max(k / n, m / i1);
    }
    int j = i;
    if (i < 1) {
      j = 1;
    }
    return considerMaxTextureSize(k, m, j, paramBoolean);
  }
  
  public static float computeImageScale(ImageSize paramImageSize1, ImageSize paramImageSize2, ViewScaleType paramViewScaleType, boolean paramBoolean)
  {
    int k = paramImageSize1.getWidth();
    int m = paramImageSize1.getHeight();
    int i = paramImageSize2.getWidth();
    int j = paramImageSize2.getHeight();
    float f3 = k;
    float f1 = f3 / i;
    float f2 = m;
    float f4 = f2 / j;
    if (((paramViewScaleType == ViewScaleType.FIT_INSIDE) && (f1 >= f4)) || ((paramViewScaleType == ViewScaleType.CROP) && (f1 < f4))) {
      j = (int)(f2 / f1);
    } else {
      i = (int)(f3 / f4);
    }
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
      f1 = i / f3;
    }
    return f1;
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
    for (;;)
    {
      if ((paramInt1 / paramInt3 <= i) && (paramInt2 / paramInt3 <= j)) {
        return paramInt3;
      }
      if (paramBoolean) {
        paramInt3 *= 2;
      } else {
        paramInt3 += 1;
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.nostra13.universalimageloader.utils.ImageSizeUtils
 * JD-Core Version:    0.7.0.1
 */