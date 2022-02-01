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
    int i = paramInt2;
    int i2 = paramInt1 - 1;
    int i4 = i - 1;
    int i1 = paramInt3 * 2 + 1;
    int i5 = stackblur_mul[paramInt3];
    int i6 = stackblur_shr[paramInt3];
    int[] arrayOfInt = new int[i1];
    long l6;
    long l5;
    long l4;
    long l1;
    long l2;
    long l3;
    int j;
    long l10;
    long l11;
    long l12;
    long l9;
    long l8;
    long l7;
    int k;
    int n;
    int i3;
    int m;
    if (paramInt6 == 1)
    {
      paramInt2 = paramInt5 * i / paramInt4;
      paramInt5 = (paramInt5 + 1) * i / paramInt4;
      paramInt4 = paramInt2;
      while (paramInt4 < paramInt5)
      {
        paramInt6 = paramInt1 * paramInt4;
        paramInt2 = 0;
        l6 = 0L;
        l5 = 0L;
        l4 = 0L;
        l1 = 0L;
        l2 = 0L;
        for (l3 = 0L; paramInt2 <= paramInt3; l3 += (paramArrayOfInt[paramInt6] & 0xFF))
        {
          arrayOfInt[paramInt2] = paramArrayOfInt[paramInt6];
          i = paramArrayOfInt[paramInt6];
          paramInt2 += 1;
          l6 += (i >>> 16 & 0xFF) * paramInt2;
          l5 += (paramArrayOfInt[paramInt6] >>> 8 & 0xFF) * paramInt2;
          l4 += (paramArrayOfInt[paramInt6] & 0xFF) * paramInt2;
          l1 += (paramArrayOfInt[paramInt6] >>> 16 & 0xFF);
          l2 += (paramArrayOfInt[paramInt6] >>> 8 & 0xFF);
        }
        j = paramInt6;
        paramInt2 = 1;
        l10 = 0L;
        l11 = 0L;
        l12 = 0L;
        l9 = l6;
        l8 = l5;
        l7 = l4;
        l6 = l12;
        l5 = l11;
        l4 = l10;
        while (paramInt2 <= paramInt3)
        {
          i = j;
          if (paramInt2 <= i2) {
            i = j + 1;
          }
          arrayOfInt[(paramInt2 + paramInt3)] = paramArrayOfInt[i];
          j = paramArrayOfInt[i];
          k = paramInt3 + 1 - paramInt2;
          l9 += (j >>> 16 & 0xFF) * k;
          l8 += (paramArrayOfInt[i] >>> 8 & 0xFF) * k;
          l7 += (paramArrayOfInt[i] & 0xFF) * k;
          l6 += (paramArrayOfInt[i] >>> 16 & 0xFF);
          l5 += (paramArrayOfInt[i] >>> 8 & 0xFF);
          l4 += (paramArrayOfInt[i] & 0xFF);
          paramInt2 += 1;
          j = i;
        }
        if (paramInt3 > i2) {
          paramInt2 = i2;
        } else {
          paramInt2 = paramInt3;
        }
        i = paramInt2;
        j = paramInt2 + paramInt6;
        paramInt2 = paramInt3;
        k = 0;
        n = paramInt6;
        paramInt6 = k;
        while (paramInt6 < paramInt1)
        {
          l10 = paramArrayOfInt[n] & 0xFF000000;
          l11 = i5;
          paramArrayOfInt[n] = ((int)(l10 | (l9 * l11 >>> i6 & 0xFF) << 16 | (l8 * l11 >>> i6 & 0xFF) << 8 | l11 * l7 >>> i6 & 0xFF));
          i3 = n + 1;
          k = paramInt2 + i1 - paramInt3;
          n = k;
          if (k >= i1) {
            n = k - i1;
          }
          l12 = arrayOfInt[n] >>> 16 & 0xFF;
          l11 = arrayOfInt[n] >>> 8 & 0xFF;
          l10 = arrayOfInt[n] & 0xFF;
          m = i;
          k = j;
          if (i < i2)
          {
            k = j + 1;
            m = i + 1;
          }
          arrayOfInt[n] = paramArrayOfInt[k];
          l6 += (paramArrayOfInt[k] >>> 16 & 0xFF);
          l5 += (paramArrayOfInt[k] >>> 8 & 0xFF);
          l4 += (paramArrayOfInt[k] & 0xFF);
          l9 = l9 - l1 + l6;
          l8 = l8 - l2 + l5;
          l7 = l7 - l3 + l4;
          i = paramInt2 + 1;
          paramInt2 = i;
          if (i >= i1) {
            paramInt2 = 0;
          }
          l1 = l1 - l12 + (arrayOfInt[paramInt2] >>> 16 & 0xFF);
          l2 = l2 - l11 + (arrayOfInt[paramInt2] >>> 8 & 0xFF);
          l3 = l3 - l10 + (arrayOfInt[paramInt2] & 0xFF);
          l6 -= (arrayOfInt[paramInt2] >>> 16 & 0xFF);
          l5 -= (arrayOfInt[paramInt2] >>> 8 & 0xFF);
          l4 -= (arrayOfInt[paramInt2] & 0xFF);
          paramInt6 += 1;
          n = i3;
          i = m;
          j = k;
        }
        paramInt4 += 1;
      }
    }
    if (paramInt6 == 2)
    {
      i = paramInt5 * paramInt1 / paramInt4;
      paramInt5 = (paramInt5 + 1) * paramInt1 / paramInt4;
      paramInt6 = i1;
      for (paramInt4 = i; paramInt4 < paramInt5; paramInt4 = i + 1)
      {
        i = 0;
        l6 = 0L;
        l5 = 0L;
        l4 = 0L;
        l1 = 0L;
        l2 = 0L;
        for (l3 = 0L; i <= paramInt3; l3 += (paramArrayOfInt[paramInt4] & 0xFF))
        {
          arrayOfInt[i] = paramArrayOfInt[paramInt4];
          j = paramArrayOfInt[paramInt4];
          i += 1;
          l6 += (j >>> 16 & 0xFF) * i;
          l5 += (paramArrayOfInt[paramInt4] >>> 8 & 0xFF) * i;
          l4 += (paramArrayOfInt[paramInt4] & 0xFF) * i;
          l1 += (paramArrayOfInt[paramInt4] >>> 16 & 0xFF);
          l2 += (paramArrayOfInt[paramInt4] >>> 8 & 0xFF);
        }
        k = paramInt4;
        i = 1;
        l8 = 0L;
        l9 = 0L;
        l10 = 0L;
        l7 = l6;
        l6 = l5;
        l5 = l4;
        l4 = l10;
        while (i <= paramInt3)
        {
          j = k;
          if (i <= i4) {
            j = k + paramInt1;
          }
          arrayOfInt[(i + paramInt3)] = paramArrayOfInt[j];
          k = paramArrayOfInt[j];
          m = paramInt3 + 1 - i;
          l7 += (k >>> 16 & 0xFF) * m;
          l6 += (paramArrayOfInt[j] >>> 8 & 0xFF) * m;
          l5 += (paramArrayOfInt[j] & 0xFF) * m;
          l4 += (paramArrayOfInt[j] >>> 16 & 0xFF);
          l9 += (paramArrayOfInt[j] >>> 8 & 0xFF);
          l8 += (paramArrayOfInt[j] & 0xFF);
          i += 1;
          k = j;
        }
        i = paramInt6;
        if (paramInt3 > i4) {
          paramInt6 = i4;
        } else {
          paramInt6 = paramInt3;
        }
        k = paramInt3;
        m = paramInt6;
        l10 = l9;
        j = 0;
        l11 = l8;
        n = paramInt6 * paramInt1 + paramInt4;
        i3 = paramInt4;
        paramInt6 = i;
        l9 = l4;
        l8 = l10;
        l4 = l11;
        i = paramInt4;
        while (j < paramInt2)
        {
          l10 = paramArrayOfInt[i3] & 0xFF000000;
          l11 = i5;
          paramArrayOfInt[i3] = ((int)(l10 | (l7 * l11 >>> i6 & 0xFF) << 16 | (l6 * l11 >>> i6 & 0xFF) << 8 | l11 * l5 >>> i6 & 0xFF));
          i3 += paramInt1;
          i1 = k + paramInt6 - paramInt3;
          paramInt4 = i1;
          if (i1 >= paramInt6) {
            paramInt4 = i1 - paramInt6;
          }
          l12 = arrayOfInt[paramInt4] >>> 16 & 0xFF;
          l11 = arrayOfInt[paramInt4] >>> 8 & 0xFF;
          l10 = arrayOfInt[paramInt4] & 0xFF;
          i2 = m;
          i1 = n;
          if (m < i4)
          {
            i1 = n + paramInt1;
            i2 = m + 1;
          }
          arrayOfInt[paramInt4] = paramArrayOfInt[i1];
          l9 += (paramArrayOfInt[i1] >>> 16 & 0xFF);
          l8 += (paramArrayOfInt[i1] >>> 8 & 0xFF);
          l4 += (paramArrayOfInt[i1] & 0xFF);
          l7 = l7 - l1 + l9;
          l6 = l6 - l2 + l8;
          l5 = l5 - l3 + l4;
          k += 1;
          paramInt4 = k;
          if (k >= paramInt6) {
            paramInt4 = 0;
          }
          k = arrayOfInt[paramInt4];
          l1 = l1 - l12 + (k >>> 16 & 0xFF);
          l2 = l2 - l11 + (arrayOfInt[paramInt4] >>> 8 & 0xFF);
          l3 = l3 - l10 + (arrayOfInt[paramInt4] & 0xFF);
          l9 -= (arrayOfInt[paramInt4] >>> 16 & 0xFF);
          l8 -= (arrayOfInt[paramInt4] >>> 8 & 0xFF);
          l4 -= (arrayOfInt[paramInt4] & 0xFF);
          j += 1;
          k = paramInt4;
          m = i2;
          n = i1;
        }
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
      int n = (int)paramFloat;
      paramBitmap.add(new JavaBlurProcess.BlurTask(arrayOfInt, j, k, n, m, i, 1));
      localArrayList.add(new JavaBlurProcess.BlurTask(arrayOfInt, j, k, n, m, i, 2));
      i += 1;
    }
    try
    {
      StackBlurManager.EXECUTOR.invokeAll(paramBitmap);
      StackBlurManager.EXECUTOR.invokeAll(localArrayList);
      return Bitmap.createBitmap(arrayOfInt, j, k, Bitmap.Config.ARGB_8888);
    }
    catch (InterruptedException paramBitmap) {}
    return null;
  }
  
  public String toString()
  {
    return getClass().getSimpleName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.enrique.stackblur.JavaBlurProcess
 * JD-Core Version:    0.7.0.1
 */