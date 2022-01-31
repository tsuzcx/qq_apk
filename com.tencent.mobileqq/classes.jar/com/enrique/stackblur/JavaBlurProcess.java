package com.enrique.stackblur;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

class JavaBlurProcess
  implements BlurProcess
{
  private static final short[] stackblur_mul = { 512, 512, 456, 512, 328, 456, 335, 512, 405, 328, 271, 456, 388, 335, 292, 512, 454, 405, 364, 328, 298, 271, 496, 456, 420, 388, 360, 335, 312, 292, 273, 512, 482, 454, 428, 405, 383, 364, 345, 328, 312, 298, 284, 271, 259, 496, 475, 456, 437, 420, 404, 388, 374, 360, 347, 335, 323, 312, 302, 292, 282, 273, 265, 512, 497, 482, 468, 454, 441, 428, 417, 405, 394, 383, 373, 364, 354, 345, 337, 328, 320, 312, 305, 298, 291, 284, 278, 271, 265, 259, 507, 496, 485, 475, 465, 456, 446, 437, 428, 420, 412, 404, 396, 388, 381, 374, 367, 360, 354, 347, 341, 335, 329, 323, 318, 312, 307, 302, 297, 292, 287, 282, 278, 273, 269, 265, 261, 512, 505, 497, 489, 482, 475, 468, 461, 454, 447, 441, 435, 428, 422, 417, 411, 405, 399, 394, 389, 383, 378, 373, 368, 364, 359, 354, 350, 345, 341, 337, 332, 328, 324, 320, 316, 312, 309, 305, 301, 298, 294, 291, 287, 284, 281, 278, 274, 271, 268, 265, 262, 259, 257, 507, 501, 496, 491, 485, 480, 475, 470, 465, 460, 456, 451, 446, 442, 437, 433, 428, 424, 420, 416, 412, 408, 404, 400, 396, 392, 388, 385, 381, 377, 374, 370, 367, 363, 360, 357, 354, 350, 347, 344, 341, 338, 335, 332, 329, 326, 323, 320, 318, 315, 312, 310, 307, 304, 302, 299, 297, 294, 292, 289, 287, 285, 282, 280, 278, 275, 273, 271, 269, 267, 265, 263, 261, 259 };
  private static final byte[] stackblur_shr = { 9, 11, 12, 13, 13, 14, 14, 15, 15, 15, 15, 16, 16, 16, 16, 17, 17, 17, 17, 17, 17, 17, 18, 18, 18, 18, 18, 18, 18, 18, 18, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24 };
  
  private static void blurIteration(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    int i1 = paramInt1 - 1;
    int i2 = paramInt2 - 1;
    int i3 = paramInt3 * 2 + 1;
    int i4 = stackblur_mul[paramInt3];
    int i5 = stackblur_shr[paramInt3];
    int[] arrayOfInt = new int[i3];
    long l4;
    long l3;
    long l1;
    long l7;
    long l8;
    long l9;
    long l2;
    long l6;
    long l5;
    if (paramInt6 == 1)
    {
      paramInt6 = paramInt5 * paramInt2 / paramInt4;
      i2 = (paramInt5 + 1) * paramInt2 / paramInt4;
      paramInt4 = paramInt6;
      if (paramInt4 >= i2) {
        break label1724;
      }
      l4 = 0L;
      paramInt5 = paramInt1 * paramInt4;
      l3 = 0L;
      l1 = 0L;
      l7 = 0L;
      l8 = 0L;
      l9 = 0L;
      paramInt2 = 0;
      l2 = 0L;
      while (paramInt2 <= paramInt3)
      {
        arrayOfInt[paramInt2] = paramArrayOfInt[paramInt5];
        l9 += (paramArrayOfInt[paramInt5] >>> 16 & 0xFF) * (paramInt2 + 1);
        l8 += (paramArrayOfInt[paramInt5] >>> 8 & 0xFF) * (paramInt2 + 1);
        l7 += (paramArrayOfInt[paramInt5] & 0xFF) * (paramInt2 + 1);
        l1 += (paramArrayOfInt[paramInt5] >>> 16 & 0xFF);
        l3 += (paramArrayOfInt[paramInt5] >>> 8 & 0xFF);
        l2 += (paramArrayOfInt[paramInt5] & 0xFF);
        paramInt2 += 1;
      }
      l6 = 0L;
      paramInt2 = 1;
      l5 = 0L;
      while (paramInt2 <= paramInt3)
      {
        paramInt6 = paramInt5;
        if (paramInt2 <= i1) {
          paramInt6 = paramInt5 + 1;
        }
        arrayOfInt[(paramInt2 + paramInt3)] = paramArrayOfInt[paramInt6];
        l9 += (paramArrayOfInt[paramInt6] >>> 16 & 0xFF) * (paramInt3 + 1 - paramInt2);
        l8 += (paramArrayOfInt[paramInt6] >>> 8 & 0xFF) * (paramInt3 + 1 - paramInt2);
        l7 += (paramArrayOfInt[paramInt6] & 0xFF) * (paramInt3 + 1 - paramInt2);
        l6 += (paramArrayOfInt[paramInt6] >>> 16 & 0xFF);
        l5 += (paramArrayOfInt[paramInt6] >>> 8 & 0xFF);
        l4 += (paramArrayOfInt[paramInt6] & 0xFF);
        paramInt2 += 1;
        paramInt5 = paramInt6;
      }
      if (paramInt3 <= i1) {
        break label1731;
      }
    }
    label1724:
    label1725:
    label1731:
    for (paramInt2 = i1;; paramInt2 = paramInt3)
    {
      paramInt6 = paramInt3;
      paramInt5 = 0;
      int m = paramInt2 + paramInt4 * paramInt1;
      int i = paramInt2;
      int j = paramInt4 * paramInt1;
      long l10 = l6;
      long l11 = l5;
      long l12 = l4;
      paramInt2 = paramInt6;
      l6 = l9;
      l5 = l8;
      l4 = l7;
      l9 = l10;
      l8 = l11;
      l7 = l12;
      paramInt6 = j;
      int n;
      int k;
      while (paramInt5 < paramInt1)
      {
        paramArrayOfInt[paramInt6] = ((int)(paramArrayOfInt[paramInt6] & 0xFF000000 | (i4 * l6 >>> i5 & 0xFF) << 16 | (i4 * l5 >>> i5 & 0xFF) << 8 | i4 * l4 >>> i5 & 0xFF));
        j = paramInt2 + i3 - paramInt3;
        n = j;
        if (j >= i3) {
          n = j - i3;
        }
        l12 = arrayOfInt[n] >>> 16 & 0xFF;
        l11 = arrayOfInt[n] >>> 8 & 0xFF;
        l10 = arrayOfInt[n] & 0xFF;
        k = m;
        j = i;
        if (i < i1)
        {
          k = m + 1;
          j = i + 1;
        }
        arrayOfInt[n] = paramArrayOfInt[k];
        l9 += (paramArrayOfInt[k] >>> 16 & 0xFF);
        l8 += (paramArrayOfInt[k] >>> 8 & 0xFF);
        l7 += (paramArrayOfInt[k] & 0xFF);
        l6 = l6 - l1 + l9;
        l5 = l5 - l3 + l8;
        l4 = l4 - l2 + l7;
        i = paramInt2 + 1;
        paramInt2 = i;
        if (i >= i3) {
          paramInt2 = 0;
        }
        l1 = l1 - l12 + (arrayOfInt[paramInt2] >>> 16 & 0xFF);
        l3 = l3 - l11 + (arrayOfInt[paramInt2] >>> 8 & 0xFF);
        l2 = l2 - l10 + (arrayOfInt[paramInt2] & 0xFF);
        l9 -= (arrayOfInt[paramInt2] >>> 16 & 0xFF);
        l8 -= (arrayOfInt[paramInt2] >>> 8 & 0xFF);
        l7 -= (arrayOfInt[paramInt2] & 0xFF);
        paramInt5 += 1;
        paramInt6 += 1;
        m = k;
        i = j;
      }
      paramInt4 += 1;
      break;
      if (paramInt6 == 2)
      {
        paramInt6 = paramInt5 * paramInt1 / paramInt4;
        int i6 = (paramInt5 + 1) * paramInt1 / paramInt4;
        paramInt4 = paramInt6;
        if (paramInt4 < i6)
        {
          l10 = 0L;
          paramInt5 = 0;
          l1 = 0L;
          l2 = 0L;
          l3 = 0L;
          l4 = 0L;
          l5 = 0L;
          l6 = 0L;
          while (paramInt5 <= paramInt3)
          {
            arrayOfInt[paramInt5] = paramArrayOfInt[paramInt4];
            l6 += (paramArrayOfInt[paramInt4] >>> 16 & 0xFF) * (paramInt5 + 1);
            l5 += (paramArrayOfInt[paramInt4] >>> 8 & 0xFF) * (paramInt5 + 1);
            l4 += (paramArrayOfInt[paramInt4] & 0xFF) * (paramInt5 + 1);
            l3 += (paramArrayOfInt[paramInt4] >>> 16 & 0xFF);
            l2 += (paramArrayOfInt[paramInt4] >>> 8 & 0xFF);
            l1 += (paramArrayOfInt[paramInt4] & 0xFF);
            paramInt5 += 1;
          }
          l11 = 0L;
          l12 = 0L;
          paramInt5 = 1;
          paramInt6 = paramInt4;
          l9 = l6;
          l8 = l5;
          l7 = l4;
          l6 = l12;
          l5 = l11;
          l4 = l10;
          while (paramInt5 <= paramInt3)
          {
            i = paramInt6;
            if (paramInt5 <= i2) {
              i = paramInt6 + paramInt1;
            }
            arrayOfInt[(paramInt5 + paramInt3)] = paramArrayOfInt[i];
            l9 += (paramArrayOfInt[i] >>> 16 & 0xFF) * (paramInt3 + 1 - paramInt5);
            l8 += (paramArrayOfInt[i] >>> 8 & 0xFF) * (paramInt3 + 1 - paramInt5);
            l7 += (paramArrayOfInt[i] & 0xFF) * (paramInt3 + 1 - paramInt5);
            l6 += (paramArrayOfInt[i] >>> 16 & 0xFF);
            l5 += (paramArrayOfInt[i] >>> 8 & 0xFF);
            l4 += (paramArrayOfInt[i] & 0xFF);
            paramInt5 += 1;
            paramInt6 = i;
          }
          if (paramInt3 <= i2) {
            break label1725;
          }
        }
      }
      for (paramInt5 = i2;; paramInt5 = paramInt3)
      {
        n = paramInt5 * paramInt1 + paramInt4;
        j = paramInt3;
        paramInt6 = 0;
        k = paramInt5;
        i = paramInt4;
        paramInt5 = j;
        for (j = k; paramInt6 < paramInt2; j = k)
        {
          paramArrayOfInt[i] = ((int)(paramArrayOfInt[i] & 0xFF000000 | (i4 * l9 >>> i5 & 0xFF) << 16 | (i4 * l8 >>> i5 & 0xFF) << 8 | i4 * l7 >>> i5 & 0xFF));
          k = paramInt5 + i3 - paramInt3;
          i1 = k;
          if (k >= i3) {
            i1 = k - i3;
          }
          l12 = arrayOfInt[i1] >>> 16 & 0xFF;
          l11 = arrayOfInt[i1] >>> 8 & 0xFF;
          l10 = arrayOfInt[i1] & 0xFF;
          m = n;
          k = j;
          if (j < i2)
          {
            m = n + paramInt1;
            k = j + 1;
          }
          arrayOfInt[i1] = paramArrayOfInt[m];
          l6 += (paramArrayOfInt[m] >>> 16 & 0xFF);
          l5 += (paramArrayOfInt[m] >>> 8 & 0xFF);
          l4 += (paramArrayOfInt[m] & 0xFF);
          l9 = l9 - l3 + l6;
          l8 = l8 - l2 + l5;
          l7 = l7 - l1 + l4;
          j = paramInt5 + 1;
          paramInt5 = j;
          if (j >= i3) {
            paramInt5 = 0;
          }
          l3 = l3 - l12 + (arrayOfInt[paramInt5] >>> 16 & 0xFF);
          l2 = l2 - l11 + (arrayOfInt[paramInt5] >>> 8 & 0xFF);
          l1 = l1 - l10 + (arrayOfInt[paramInt5] & 0xFF);
          l6 -= (arrayOfInt[paramInt5] >>> 16 & 0xFF);
          l5 -= (arrayOfInt[paramInt5] >>> 8 & 0xFF);
          l4 -= (arrayOfInt[paramInt5] & 0xFF);
          paramInt6 += 1;
          i += paramInt1;
          n = m;
        }
        paramInt4 += 1;
        break;
        return;
      }
    }
  }
  
  public Bitmap blur(Bitmap paramBitmap, float paramFloat)
  {
    int j = paramBitmap.getWidth();
    int k = paramBitmap.getHeight();
    int[] arrayOfInt = new int[j * k];
    paramBitmap.getPixels(arrayOfInt, 0, j, 0, 0, j, k);
    int m = StackBlurManager.EXECUTOR_THREADS;
    paramBitmap = new ArrayList(m);
    ArrayList localArrayList = new ArrayList(m);
    int i = 0;
    while (i < m)
    {
      paramBitmap.add(new JavaBlurProcess.BlurTask(arrayOfInt, j, k, (int)paramFloat, m, i, 1));
      localArrayList.add(new JavaBlurProcess.BlurTask(arrayOfInt, j, k, (int)paramFloat, m, i, 2));
      i += 1;
    }
    try
    {
      StackBlurManager.EXECUTOR.invokeAll(paramBitmap);
      return null;
    }
    catch (InterruptedException paramBitmap)
    {
      try
      {
        StackBlurManager.EXECUTOR.invokeAll(localArrayList);
        return Bitmap.createBitmap(arrayOfInt, j, k, Bitmap.Config.ARGB_8888);
      }
      catch (InterruptedException paramBitmap) {}
      paramBitmap = paramBitmap;
      return null;
    }
  }
  
  public String toString()
  {
    return getClass().getSimpleName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.enrique.stackblur.JavaBlurProcess
 * JD-Core Version:    0.7.0.1
 */