package com.tencent.falco.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.lang.reflect.Array;

public class FastBlurUtil
{
  public static Bitmap bitmapAvgConvolution(Bitmap paramBitmap)
  {
    float[] arrayOfFloat = new float[9];
    float[] tmp6_5 = arrayOfFloat;
    tmp6_5[0] = 0.1111111F;
    float[] tmp11_6 = tmp6_5;
    tmp11_6[1] = 0.1111111F;
    float[] tmp16_11 = tmp11_6;
    tmp16_11[2] = 0.1111111F;
    float[] tmp21_16 = tmp16_11;
    tmp21_16[3] = 0.1111111F;
    float[] tmp26_21 = tmp21_16;
    tmp26_21[4] = 0.1111111F;
    float[] tmp31_26 = tmp26_21;
    tmp31_26[5] = 0.1111111F;
    float[] tmp36_31 = tmp31_26;
    tmp36_31[6] = 0.1111111F;
    float[] tmp42_36 = tmp36_31;
    tmp42_36[7] = 0.1111111F;
    float[] tmp48_42 = tmp42_36;
    tmp48_42[8] = 0.1111111F;
    tmp48_42;
    return bitmapConvolution(bitmapConvolution(paramBitmap, arrayOfFloat), arrayOfFloat);
  }
  
  public static Bitmap bitmapConvolution(Bitmap paramBitmap, float[] paramArrayOfFloat)
  {
    int[] arrayOfInt1 = new int[paramBitmap.getWidth() * paramBitmap.getHeight()];
    int j = 0;
    while (j < paramBitmap.getHeight())
    {
      int k = 0;
      while (k < paramBitmap.getWidth())
      {
        int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { 9, 4 });
        int m = 0;
        int i = -1;
        while (i <= 1)
        {
          int n = -1;
          while (n <= 1)
          {
            int i1 = k + n;
            int i2 = j + i;
            if ((i1 >= 0) && (i2 >= 0) && (i1 < paramBitmap.getWidth()) && (i2 < paramBitmap.getHeight()))
            {
              i1 = paramBitmap.getPixel(i1, i2);
              arrayOfInt[m][0] = (i1 >> 24 & 0xFF);
              arrayOfInt[m][1] = (i1 >> 16 & 0xFF);
              arrayOfInt[m][2] = (i1 >> 8 & 0xFF);
              arrayOfInt[m][3] = (i1 & 0xFF);
            }
            m += 1;
            n += 1;
          }
          i += 1;
        }
        int[] arrayOfInt2 = new int[4];
        i = 0;
        while (i < paramArrayOfFloat.length)
        {
          m = 0;
          while (m < 4)
          {
            arrayOfInt2[m] += (int)(paramArrayOfFloat[(paramArrayOfFloat.length - i - 1)] * arrayOfInt[i][m]);
            m += 1;
          }
          i += 1;
        }
        m = 0;
        if (m < arrayOfInt2.length)
        {
          if (arrayOfInt2[m] < 0) {
            i = 0;
          }
          for (;;)
          {
            arrayOfInt2[m] = i;
            m += 1;
            break;
            if (arrayOfInt2[m] > 255) {
              i = 255;
            } else {
              i = arrayOfInt2[m];
            }
          }
        }
        i = paramBitmap.getWidth() * j + k;
        arrayOfInt1[i] |= arrayOfInt2[0] << 24;
        i = paramBitmap.getWidth() * j + k;
        arrayOfInt1[i] |= arrayOfInt2[1] << 16;
        i = paramBitmap.getWidth() * j + k;
        arrayOfInt1[i] |= arrayOfInt2[2] << 8;
        i = paramBitmap.getWidth() * j + k;
        arrayOfInt1[i] |= arrayOfInt2[3];
        k += 1;
      }
      j += 1;
    }
    return Bitmap.createBitmap(arrayOfInt1, paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
  }
  
  public static Bitmap doBlur(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    while (paramInt < 1)
    {
      return null;
      paramBitmap = paramBitmap.copy(paramBitmap.getConfig(), true);
    }
    int i12 = paramBitmap.getWidth();
    int i13 = paramBitmap.getHeight();
    int[] arrayOfInt1 = new int[i12 * i13];
    paramBitmap.getPixels(arrayOfInt1, 0, i12, 0, 0, i12, i13);
    int i11 = i12 - 1;
    int i14 = i13 - 1;
    int i = i12 * i13;
    int i15 = paramInt + paramInt + 1;
    int[] arrayOfInt2 = new int[i];
    int[] arrayOfInt3 = new int[i];
    int[] arrayOfInt4 = new int[i];
    int[] arrayOfInt5 = new int[Math.max(i12, i13)];
    i = i15 + 1 >> 1;
    int j = i * i;
    int[] arrayOfInt6 = new int[j * 256];
    i = 0;
    while (i < j * 256)
    {
      arrayOfInt6[i] = (i / j);
      i += 1;
    }
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { i15, 3 });
    int i16 = paramInt + 1;
    int i7 = 0;
    i = 0;
    int i6 = 0;
    int i8;
    int m;
    int n;
    int i1;
    int i2;
    int i3;
    int i4;
    int i5;
    int k;
    int i9;
    int[] arrayOfInt7;
    int i10;
    int i17;
    while (i6 < i13)
    {
      j = 0;
      i8 = -paramInt;
      m = 0;
      n = 0;
      i1 = 0;
      i2 = 0;
      i3 = 0;
      i4 = 0;
      i5 = 0;
      k = 0;
      if (i8 <= paramInt)
      {
        i9 = arrayOfInt1[(Math.min(i11, Math.max(i8, 0)) + i)];
        arrayOfInt7 = arrayOfInt[(i8 + paramInt)];
        arrayOfInt7[0] = ((0xFF0000 & i9) >> 16);
        arrayOfInt7[1] = ((0xFF00 & i9) >> 8);
        arrayOfInt7[2] = (i9 & 0xFF);
        i9 = i16 - Math.abs(i8);
        i5 += arrayOfInt7[0] * i9;
        i4 += arrayOfInt7[1] * i9;
        i3 += i9 * arrayOfInt7[2];
        if (i8 > 0)
        {
          m += arrayOfInt7[0];
          k += arrayOfInt7[1];
          j += arrayOfInt7[2];
        }
        for (;;)
        {
          i8 += 1;
          break;
          i2 += arrayOfInt7[0];
          i1 += arrayOfInt7[1];
          n += arrayOfInt7[2];
        }
      }
      i8 = i4;
      i10 = 0;
      i4 = paramInt;
      i9 = i5;
      i5 = i3;
      i3 = i10;
      while (i3 < i12)
      {
        arrayOfInt2[i] = arrayOfInt6[i9];
        arrayOfInt3[i] = arrayOfInt6[i8];
        arrayOfInt4[i] = arrayOfInt6[i5];
        arrayOfInt7 = arrayOfInt[((i4 - paramInt + i15) % i15)];
        int i18 = arrayOfInt7[0];
        i17 = arrayOfInt7[1];
        i10 = arrayOfInt7[2];
        if (i6 == 0) {
          arrayOfInt5[i3] = Math.min(i3 + paramInt + 1, i11);
        }
        int i19 = arrayOfInt1[(arrayOfInt5[i3] + i7)];
        arrayOfInt7[0] = ((0xFF0000 & i19) >> 16);
        arrayOfInt7[1] = ((0xFF00 & i19) >> 8);
        arrayOfInt7[2] = (i19 & 0xFF);
        m += arrayOfInt7[0];
        k += arrayOfInt7[1];
        j += arrayOfInt7[2];
        i9 = i9 - i2 + m;
        i8 = i8 - i1 + k;
        i5 = i5 - n + j;
        i4 = (i4 + 1) % i15;
        arrayOfInt7 = arrayOfInt[(i4 % i15)];
        i2 = i2 - i18 + arrayOfInt7[0];
        i1 = i1 - i17 + arrayOfInt7[1];
        n = n - i10 + arrayOfInt7[2];
        m -= arrayOfInt7[0];
        k -= arrayOfInt7[1];
        j -= arrayOfInt7[2];
        i += 1;
        i3 += 1;
      }
      i7 += i12;
      i6 += 1;
    }
    i = 0;
    while (i < i12)
    {
      i5 = 0;
      i7 = -paramInt * i12;
      i6 = -paramInt;
      i3 = 0;
      n = 0;
      i1 = 0;
      i2 = 0;
      j = 0;
      m = 0;
      k = 0;
      i4 = 0;
      if (i6 <= paramInt)
      {
        i8 = Math.max(0, i7) + i;
        arrayOfInt7 = arrayOfInt[(i6 + paramInt)];
        arrayOfInt7[0] = arrayOfInt2[i8];
        arrayOfInt7[1] = arrayOfInt3[i8];
        arrayOfInt7[2] = arrayOfInt4[i8];
        i9 = i16 - Math.abs(i6);
        i10 = arrayOfInt2[i8];
        i11 = arrayOfInt3[i8];
        i17 = arrayOfInt4[i8];
        if (i6 > 0)
        {
          i3 += arrayOfInt7[0];
          i4 += arrayOfInt7[1];
          i5 += arrayOfInt7[2];
        }
        for (;;)
        {
          i8 = i7;
          if (i6 < i14) {
            i8 = i7 + i12;
          }
          i6 += 1;
          j = i17 * i9 + j;
          m = i11 * i9 + m;
          k = i10 * i9 + k;
          i7 = i8;
          break;
          i2 += arrayOfInt7[0];
          i1 += arrayOfInt7[1];
          n += arrayOfInt7[2];
        }
      }
      i9 = m;
      i10 = k;
      i11 = 0;
      k = i;
      i6 = i5;
      i7 = i4;
      i8 = i3;
      m = n;
      n = i1;
      i1 = i2;
      i2 = paramInt;
      i5 = i10;
      i4 = i9;
      i3 = j;
      j = i11;
      while (j < i13)
      {
        arrayOfInt1[k] = (0xFF000000 & arrayOfInt1[k] | arrayOfInt6[i5] << 16 | arrayOfInt6[i4] << 8 | arrayOfInt6[i3]);
        arrayOfInt7 = arrayOfInt[((i2 - paramInt + i15) % i15)];
        i11 = arrayOfInt7[0];
        i10 = arrayOfInt7[1];
        i9 = arrayOfInt7[2];
        if (i == 0) {
          arrayOfInt5[j] = (Math.min(j + i16, i14) * i12);
        }
        i17 = arrayOfInt5[j] + i;
        arrayOfInt7[0] = arrayOfInt2[i17];
        arrayOfInt7[1] = arrayOfInt3[i17];
        arrayOfInt7[2] = arrayOfInt4[i17];
        i8 += arrayOfInt7[0];
        i7 += arrayOfInt7[1];
        i6 += arrayOfInt7[2];
        i5 = i5 - i1 + i8;
        i4 = i4 - n + i7;
        i3 = i3 - m + i6;
        i2 = (i2 + 1) % i15;
        arrayOfInt7 = arrayOfInt[i2];
        i1 = i1 - i11 + arrayOfInt7[0];
        n = n - i10 + arrayOfInt7[1];
        m = m - i9 + arrayOfInt7[2];
        i8 -= arrayOfInt7[0];
        i7 -= arrayOfInt7[1];
        i6 -= arrayOfInt7[2];
        k += i12;
        j += 1;
      }
      i += 1;
    }
    paramBitmap.setPixels(arrayOfInt1, 0, i12, 0, 0, i12, i13);
    return paramBitmap;
  }
  
  public static Bitmap transform(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    Bitmap localBitmap = Bitmap.createBitmap(i / paramInt1, j / paramInt1, Bitmap.Config.RGB_565);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.scale(1.0F / paramInt1, 1.0F / paramInt1);
    Paint localPaint = new Paint();
    localPaint.setFlags(2);
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
    return doBlur(localBitmap, paramInt2, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.utils.FastBlurUtil
 * JD-Core Version:    0.7.0.1
 */