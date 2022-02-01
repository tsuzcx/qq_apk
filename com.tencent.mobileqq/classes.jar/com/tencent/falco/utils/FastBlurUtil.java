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
        int m = -1;
        int i = 0;
        while (m <= 1)
        {
          int n = -1;
          while (n <= 1)
          {
            int i1 = k + n;
            int i2 = j + m;
            if ((i1 >= 0) && (i2 >= 0) && (i1 < paramBitmap.getWidth()) && (i2 < paramBitmap.getHeight()))
            {
              i1 = paramBitmap.getPixel(i1, i2);
              arrayOfInt[i][0] = (i1 >> 24 & 0xFF);
              arrayOfInt[i][1] = (i1 >> 16 & 0xFF);
              arrayOfInt[i][2] = (i1 >> 8 & 0xFF);
              arrayOfInt[i][3] = (i1 & 0xFF);
            }
            i += 1;
            n += 1;
          }
          m += 1;
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
        while (m < arrayOfInt2.length)
        {
          if (arrayOfInt2[m] < 0) {
            i = 0;
          } else if (arrayOfInt2[m] > 255) {
            i = 255;
          } else {
            i = arrayOfInt2[m];
          }
          arrayOfInt2[m] = i;
          m += 1;
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
    int i7 = paramInt;
    if (!paramBoolean) {
      paramBitmap = paramBitmap.copy(paramBitmap.getConfig(), true);
    }
    if (i7 < 1) {
      return null;
    }
    int i15 = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    int i = i15 * j;
    int[] arrayOfInt3 = new int[i];
    paramBitmap.getPixels(arrayOfInt3, 0, i15, 0, 0, i15, j);
    int i18 = i15 - 1;
    int k = j - 1;
    int i16 = i7 + i7 + 1;
    int[] arrayOfInt4 = new int[i];
    int[] arrayOfInt5 = new int[i];
    int[] arrayOfInt6 = new int[i];
    int[] arrayOfInt2 = new int[Math.max(i15, j)];
    i = i16 + 1 >> 1;
    int m = i * i;
    int n = m * 256;
    int[] arrayOfInt1 = new int[n];
    i = 0;
    while (i < n)
    {
      arrayOfInt1[i] = (i / m);
      i += 1;
    }
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { i16, 3 });
    int i17 = i7 + 1;
    int i9 = 0;
    int i10 = 0;
    int i8 = 0;
    i = k;
    Bitmap localBitmap = paramBitmap;
    int i11;
    int i1;
    int i2;
    int i3;
    int i4;
    int i5;
    int i6;
    int i12;
    int i13;
    int i14;
    while (i9 < j)
    {
      i11 = -i7;
      i1 = 0;
      i2 = 0;
      i3 = 0;
      n = 0;
      m = 0;
      k = 0;
      i4 = 0;
      i5 = 0;
      i6 = 0;
      while (i11 <= i7)
      {
        i12 = arrayOfInt3[(i10 + Math.min(i18, Math.max(i11, 0)))];
        paramBitmap = arrayOfInt[(i11 + i7)];
        paramBitmap[0] = ((i12 & 0xFF0000) >> 16);
        paramBitmap[1] = ((i12 & 0xFF00) >> 8);
        paramBitmap[2] = (i12 & 0xFF);
        i12 = i17 - Math.abs(i11);
        i1 += paramBitmap[0] * i12;
        i2 += paramBitmap[1] * i12;
        i3 += paramBitmap[2] * i12;
        if (i11 > 0)
        {
          i4 += paramBitmap[0];
          i5 += paramBitmap[1];
          i6 += paramBitmap[2];
        }
        else
        {
          n += paramBitmap[0];
          m += paramBitmap[1];
          k += paramBitmap[2];
        }
        i11 += 1;
      }
      i13 = i7;
      i14 = 0;
      i11 = i5;
      i12 = i4;
      i5 = i1;
      i4 = i13;
      i1 = i14;
      while (i1 < i15)
      {
        arrayOfInt4[i10] = arrayOfInt1[i5];
        arrayOfInt5[i10] = arrayOfInt1[i2];
        arrayOfInt6[i10] = arrayOfInt1[i3];
        paramBitmap = arrayOfInt[((i4 - i7 + i16) % i16)];
        int i19 = paramBitmap[0];
        i14 = paramBitmap[1];
        i13 = paramBitmap[2];
        if (i9 == 0) {
          arrayOfInt2[i1] = Math.min(i1 + i7 + 1, i18);
        }
        int i20 = arrayOfInt3[(i8 + arrayOfInt2[i1])];
        paramBitmap[0] = ((i20 & 0xFF0000) >> 16);
        paramBitmap[1] = ((i20 & 0xFF00) >> 8);
        paramBitmap[2] = (i20 & 0xFF);
        i12 += paramBitmap[0];
        i11 += paramBitmap[1];
        i6 += paramBitmap[2];
        i5 = i5 - n + i12;
        i2 = i2 - m + i11;
        i3 = i3 - k + i6;
        i4 = (i4 + 1) % i16;
        paramBitmap = arrayOfInt[(i4 % i16)];
        n = n - i19 + paramBitmap[0];
        m = m - i14 + paramBitmap[1];
        k = k - i13 + paramBitmap[2];
        i12 -= paramBitmap[0];
        i11 -= paramBitmap[1];
        i6 -= paramBitmap[2];
        i10 += 1;
        i1 += 1;
      }
      i8 += i15;
      i9 += 1;
    }
    i7 = j;
    k = 0;
    j = i;
    paramBitmap = arrayOfInt2;
    i = k;
    for (;;)
    {
      i8 = paramInt;
      if (i >= i15) {
        break;
      }
      i9 = -i8;
      i10 = i9 * i15;
      i2 = 0;
      i3 = 0;
      i4 = 0;
      i1 = 0;
      n = 0;
      m = 0;
      i6 = 0;
      i5 = 0;
      k = 0;
      while (i9 <= i8)
      {
        i12 = Math.max(0, i10) + i;
        arrayOfInt2 = arrayOfInt[(i9 + i8)];
        arrayOfInt2[0] = arrayOfInt4[i12];
        arrayOfInt2[1] = arrayOfInt5[i12];
        arrayOfInt2[2] = arrayOfInt6[i12];
        i13 = i17 - Math.abs(i9);
        i11 = i2 + arrayOfInt4[i12] * i13;
        i3 += arrayOfInt5[i12] * i13;
        i4 += arrayOfInt6[i12] * i13;
        if (i9 > 0)
        {
          i6 += arrayOfInt2[0];
          i5 += arrayOfInt2[1];
          k += arrayOfInt2[2];
        }
        else
        {
          i1 += arrayOfInt2[0];
          n += arrayOfInt2[1];
          m += arrayOfInt2[2];
        }
        i2 = i10;
        if (i9 < j) {
          i2 = i10 + i15;
        }
        i9 += 1;
        i10 = i2;
        i2 = i11;
      }
      i9 = i;
      i13 = i5;
      i14 = 0;
      i5 = i8;
      i11 = i1;
      i12 = i2;
      i10 = i6;
      i8 = i13;
      i6 = k;
      i1 = i5;
      k = m;
      m = n;
      n = i11;
      i2 = i4;
      i5 = i12;
      i4 = i14;
      while (i4 < i7)
      {
        arrayOfInt3[i9] = (arrayOfInt3[i9] & 0xFF000000 | arrayOfInt1[i5] << 16 | arrayOfInt1[i3] << 8 | arrayOfInt1[i2]);
        arrayOfInt2 = arrayOfInt[((i1 - paramInt + i16) % i16)];
        i13 = arrayOfInt2[0];
        i12 = arrayOfInt2[1];
        i11 = arrayOfInt2[2];
        if (i == 0) {
          paramBitmap[i4] = (Math.min(i4 + i17, j) * i15);
        }
        i14 = paramBitmap[i4] + i;
        arrayOfInt2[0] = arrayOfInt4[i14];
        arrayOfInt2[1] = arrayOfInt5[i14];
        arrayOfInt2[2] = arrayOfInt6[i14];
        i10 += arrayOfInt2[0];
        i8 += arrayOfInt2[1];
        i6 += arrayOfInt2[2];
        i5 = i5 - n + i10;
        i3 = i3 - m + i8;
        i2 = i2 - k + i6;
        i1 = (i1 + 1) % i16;
        arrayOfInt2 = arrayOfInt[i1];
        n = n - i13 + arrayOfInt2[0];
        m = m - i12 + arrayOfInt2[1];
        k = k - i11 + arrayOfInt2[2];
        i10 -= arrayOfInt2[0];
        i8 -= arrayOfInt2[1];
        i6 -= arrayOfInt2[2];
        i9 += i15;
        i4 += 1;
      }
      i += 1;
    }
    localBitmap.setPixels(arrayOfInt3, 0, i15, 0, 0, i15, i7);
    return localBitmap;
  }
  
  public static Bitmap transform(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    Bitmap localBitmap = Bitmap.createBitmap(i / paramInt1, j / paramInt1, Bitmap.Config.RGB_565);
    Canvas localCanvas = new Canvas(localBitmap);
    float f = 1.0F / paramInt1;
    localCanvas.scale(f, f);
    Paint localPaint = new Paint();
    localPaint.setFlags(2);
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
    return doBlur(localBitmap, paramInt2, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.utils.FastBlurUtil
 * JD-Core Version:    0.7.0.1
 */