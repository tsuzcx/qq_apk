package com.tencent.component.media.image;

import com.tencent.component.media.ImageManagerEnv;

public class ImageOptionSampleSize
{
  private static int a = 0;
  private static int b = 0;
  private static int c = 0;
  
  private static boolean a(int paramInt1, int paramInt2, float paramFloat, int paramInt3)
  {
    if (paramInt3 <= 0) {
      return true;
    }
    float f = paramFloat;
    if (paramFloat < 1.0F) {
      f = 1.0F;
    }
    paramInt3 = Math.min(a, paramInt3);
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
    int j;
    label67:
    boolean bool;
    if (paramOptions == null)
    {
      j = -1;
      if (paramOptions != null) {
        break label190;
      }
      i = -1;
      if (paramOptions != null) {
        break label199;
      }
      bool = false;
      label74:
      if (j > 0) {
        break label316;
      }
      j = ImageManagerEnv.g().getScreenWidth();
    }
    label145:
    label150:
    label313:
    label316:
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
          break label208;
        }
        f1 = paramInt1 / j;
        f2 = paramInt2 / k;
        if (!bool) {
          break label226;
        }
        if (f1 >= 1.0F) {
          break label313;
        }
        f1 = f3;
      }
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
            label190:
            i = paramOptions.clipHeight;
            break label67;
            label199:
            bool = paramOptions.preferQuality;
            break label74;
            label208:
            f1 = paramInt2 / k;
            f2 = paramInt1 / j;
            break label145;
            label226:
            f1 = (float)Math.sqrt(f1 * f2);
            break label150;
          }
        }
        if (i > 0)
        {
          f2 = 1 << i;
          if ((f2 / f1 > 1.2F) && (a(paramInt1, paramInt2, f2, c))) {
            i -= 1;
          }
        }
        for (;;)
        {
          if (!a(paramInt1, paramInt2, 1 << i, b)) {
            i += 1;
          } else {
            return 1 << i;
          }
        }
      }
    }
  }
  
  public static void setSize(int paramInt1, int paramInt2)
  {
    a = paramInt2;
    b = (int)Math.max(paramInt1 * 1048576 * 0.2F, 10485760.0F);
    c = (int)Math.max(paramInt1 * 1048576 * 0.0625F, 2097152.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.ImageOptionSampleSize
 * JD-Core Version:    0.7.0.1
 */