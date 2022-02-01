package com.tencent.component.media.image;

import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.region.RegionImageUtil;
import com.tencent.component.media.utils.ImageManagerLog;

public class ImageOptionSampleSize
{
  private static final int DEFAULT_BYTES_PER_PIXEL = 4;
  private static final float HEIGHER_IMGE_FACTOR = 1.5F;
  private static final float IMAGE_UPPER_SIZE_FACTOR = 0.2F;
  private static final int IMAGE_UPPER_SIZE_MIN = 10485760;
  private static final int MEGABYTE = 1048576;
  private static final float PREFER_QUALITY_LOWER_SCALE_RATIO = 1.2F;
  private static final float PREFER_QUALITY_UPPER_SIZE_FACTOR = 0.0625F;
  private static final int PREFER_QUALITY_UPPER_SIZE_MIN = 2097152;
  private static int mImageUpperSize;
  private static int mMemcachesize;
  private static int mPreferQualityUpperSize;
  
  private static boolean checkImageSize(int paramInt1, int paramInt2, float paramFloat, int paramInt3)
  {
    if (paramInt3 <= 0) {
      return true;
    }
    float f = paramFloat;
    if (paramFloat < 1.0F) {
      f = 1.0F;
    }
    paramInt3 = Math.min(mMemcachesize, paramInt3);
    return (int)(paramInt1 * paramInt2 / f) * 4 <= paramInt3;
  }
  
  public static int computeSampleSize(ImageLoader.Options paramOptions, int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0)
    {
      if (paramInt2 <= 0) {
        return 1;
      }
      int j = -1;
      int i;
      if ((paramOptions != null) && ((paramOptions.mImageType == 3) || (paramOptions.mImageType == 4)))
      {
        i = ImageManagerEnv.g().panoramaComputeSampleSize(paramOptions, paramInt1, paramInt2);
        if (i != -1) {
          return i;
        }
      }
      if ((paramOptions != null) && (paramOptions.isNeedPieceLoad) && (RegionImageUtil.isNeedPieceLoad(paramInt1, paramInt2)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" computeSampleSize:  outWidth = ");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(" outHeight = ");
        localStringBuilder.append(paramInt2);
        ImageManagerLog.i("zehong", localStringBuilder.toString());
        i = regionDecodeComputeSampleSize(paramInt1, paramInt2);
        if (i != -1) {
          return i;
        }
      }
      if (paramOptions == null) {
        i = -1;
      } else {
        i = paramOptions.clipWidth;
      }
      if (paramOptions != null) {
        j = paramOptions.clipHeight;
      }
      int n = 0;
      boolean bool;
      if (paramOptions == null) {
        bool = false;
      } else {
        bool = paramOptions.preferQuality;
      }
      int k = i;
      if (i <= 0) {
        k = ImageManagerEnv.g().getScreenWidth();
      }
      int m = j;
      if (j <= 0) {
        m = ImageManagerEnv.g().getScreenHeight();
      }
      float f3 = 1.0F;
      float f1;
      float f2;
      if (k >= paramInt1)
      {
        i = n;
        f1 = f3;
        if (m >= paramInt2) {}
      }
      else
      {
        if (k * paramInt2 > m * paramInt1)
        {
          f1 = paramInt1 / k;
          f2 = paramInt2 / m;
        }
        else
        {
          f1 = paramInt2 / m;
          f2 = paramInt1 / k;
        }
        if (!bool) {
          f1 = (float)Math.sqrt(f1 * f2);
        }
        if (f1 < 1.0F)
        {
          i = n;
          f1 = f3;
        }
        else
        {
          i = n;
        }
      }
      for (;;)
      {
        f2 = 1 << i;
        if (f1 <= f2) {
          break;
        }
        i += 1;
      }
      j = i;
      if (i > 0)
      {
        j = i;
        if (f2 / f1 > 1.2F)
        {
          j = i;
          if (checkImageSize(paramInt1, paramInt2, f2, mPreferQualityUpperSize)) {
            j = i - 1;
          }
        }
      }
      for (;;)
      {
        i = 1 << j;
        if (checkImageSize(paramInt1, paramInt2, i, mImageUpperSize)) {
          break;
        }
        j += 1;
      }
      return i;
    }
    return 1;
  }
  
  private static int regionDecodeComputeSampleSize(int paramInt1, int paramInt2)
  {
    int i = ImageManagerEnv.g().getScreenWidth();
    int j = ImageManagerEnv.g().getScreenHeight();
    if ((paramInt1 <= i) && (paramInt2 <= j)) {
      return -1;
    }
    int k = paramInt2 * i / paramInt1;
    float f2;
    if (paramInt1 >= i)
    {
      if (paramInt2 >= k) {}
      do
      {
        f1 = i;
        f2 = paramInt1;
        f1 /= f2;
        break;
        f1 = j;
      } while (1.5F * f1 < k);
      f2 = paramInt2;
    }
    do
    {
      f1 /= f2;
      break label169;
      if (paramInt2 < j)
      {
        if (paramInt2 >= k)
        {
          f2 = paramInt1;
          f1 = i;
          if (1.5F * f2 < f1) {
            break label167;
          }
          break;
        }
        f2 = paramInt2;
        f1 = j;
        if (1.5F * f2 < f1) {
          break label167;
        }
        break label164;
      }
      if (paramInt2 <= j) {
        break label167;
      }
      f2 = paramInt2;
      f1 = j;
    } while (f2 < 1.5F * f1);
    label164:
    label167:
    float f1 = 1.0F;
    label169:
    int m = (int)Math.ceil(1.0F / f1);
    i = 1;
    if (m <= 1) {
      return 1;
    }
    j = 64;
    k = j;
    if (m > 64)
    {
      i = 64;
      k = j;
    }
    for (;;)
    {
      j = i;
      if (k == 0) {
        break;
      }
      j = m & k;
      if (j != 0) {
        break;
      }
      k >>= 1;
    }
    for (;;)
    {
      if ((paramInt2 / j <= 2048) && (paramInt1 / j <= 2048)) {
        return j;
      }
      j <<= 1;
    }
  }
  
  public static void setSize(int paramInt1, int paramInt2)
  {
    mMemcachesize = paramInt2;
    float f = paramInt1 * 1048576;
    mImageUpperSize = (int)Math.max(0.2F * f, 10485760.0F);
    mPreferQualityUpperSize = (int)Math.max(f * 0.0625F, 2097152.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.image.ImageOptionSampleSize
 * JD-Core Version:    0.7.0.1
 */