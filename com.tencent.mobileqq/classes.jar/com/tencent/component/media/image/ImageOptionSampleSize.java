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
  private static int mImageUpperSize = 0;
  private static int mMemcachesize = 0;
  private static int mPreferQualityUpperSize = 0;
  
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
    if ((int)(paramInt1 * paramInt2 / f) * 4 <= paramInt3) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static int computeSampleSize(ImageLoader.Options paramOptions, int paramInt1, int paramInt2)
  {
    float f3 = 1.0F;
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      return 1;
    }
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
      ImageManagerLog.i("zehong", " computeSampleSize:  outWidth = " + paramInt1 + " outHeight = " + paramInt2);
      i = regionDecodeComputeSampleSize(paramInt1, paramInt2);
      if (i != -1) {
        return i;
      }
    }
    int j;
    label135:
    boolean bool;
    if (paramOptions == null)
    {
      j = -1;
      if (paramOptions != null) {
        break label258;
      }
      i = -1;
      if (paramOptions != null) {
        break label267;
      }
      bool = false;
      label142:
      if (j > 0) {
        break label384;
      }
      j = ImageManagerEnv.g().getScreenWidth();
    }
    label384:
    for (;;)
    {
      int k = i;
      if (i <= 0) {
        k = ImageManagerEnv.g().getScreenHeight();
      }
      float f1;
      float f2;
      if (j >= paramInt1)
      {
        f1 = f3;
        if (k >= paramInt2) {}
      }
      else
      {
        if (j * paramInt2 <= k * paramInt1) {
          break label276;
        }
        f1 = paramInt1 / j;
        f2 = paramInt2 / k;
        label213:
        if (!bool) {
          break label294;
        }
        label218:
        if (f1 >= 1.0F) {
          break label381;
        }
        f1 = f3;
      }
      label258:
      label267:
      label276:
      label294:
      label381:
      for (;;)
      {
        i = 0;
        for (;;)
        {
          if (f1 > 1 << i)
          {
            i += 1;
            continue;
            j = paramOptions.clipWidth;
            break;
            i = paramOptions.clipHeight;
            break label135;
            bool = paramOptions.preferQuality;
            break label142;
            f1 = paramInt2 / k;
            f2 = paramInt1 / j;
            break label213;
            f1 = (float)Math.sqrt(f1 * f2);
            break label218;
          }
        }
        if (i > 0)
        {
          f2 = 1 << i;
          if ((f2 / f1 > 1.2F) && (checkImageSize(paramInt1, paramInt2, f2, mPreferQualityUpperSize))) {
            i -= 1;
          }
        }
        for (;;)
        {
          if (!checkImageSize(paramInt1, paramInt2, 1 << i, mImageUpperSize)) {
            i += 1;
          } else {
            return 1 << i;
          }
        }
      }
    }
  }
  
  private static int regionDecodeComputeSampleSize(int paramInt1, int paramInt2)
  {
    int k = 64;
    int i = ImageManagerEnv.g().getScreenWidth();
    int j = ImageManagerEnv.g().getScreenHeight();
    int m;
    float f;
    if ((paramInt1 > i) || (paramInt2 > j))
    {
      m = paramInt2 * i / paramInt1;
      if (paramInt1 >= i) {
        if (paramInt2 >= m) {
          f = i / paramInt1;
        }
      }
    }
    for (;;)
    {
      m = (int)Math.ceil(1.0F / f);
      if (m <= 1)
      {
        return 1;
        if (j * 1.5F >= m)
        {
          f = j / paramInt2;
          continue;
        }
        f = i / paramInt1;
        continue;
        if (paramInt2 < j)
        {
          if (paramInt2 >= m)
          {
            if (paramInt1 * 1.5F >= i) {
              f = i / paramInt1;
            }
          }
          else if (paramInt2 * 1.5F >= j) {
            f = j / paramInt2;
          }
        }
        else if ((paramInt2 > j) && (paramInt2 < j * 1.5F)) {
          f = j / paramInt2;
        }
      }
      else
      {
        if (m > 64) {
          i = 64;
        }
        for (;;)
        {
          j = i;
          if (k != 0)
          {
            j = m & k;
            if (j == 0) {}
          }
          else
          {
            while ((paramInt2 / j > 2048) || (paramInt1 / j > 2048)) {
              j <<= 1;
            }
          }
          k >>= 1;
          continue;
          return j;
          return -1;
          i = 1;
        }
      }
      f = 1.0F;
    }
  }
  
  public static void setSize(int paramInt1, int paramInt2)
  {
    mMemcachesize = paramInt2;
    mImageUpperSize = (int)Math.max(paramInt1 * 1048576 * 0.2F, 10485760.0F);
    mPreferQualityUpperSize = (int)Math.max(paramInt1 * 1048576 * 0.0625F, 2097152.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.media.image.ImageOptionSampleSize
 * JD-Core Version:    0.7.0.1
 */