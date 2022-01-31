package com.tencent.av.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Array;

public class BitmapTools
{
  public static Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
      return null;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    RectF localRectF = new RectF(localRect);
    float f = paramInt;
    localPaint.setAntiAlias(true);
    localCanvas.drawARGB(0, 0, 0, 0);
    localPaint.setColor(-12434878);
    localCanvas.drawRoundRect(localRectF, f, f, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap, localRect, localRect, localPaint);
    return localBitmap;
  }
  
  public static BitmapDrawable a(Bitmap paramBitmap, int paramInt)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("doBlur", 2, "start");
    }
    if (paramInt < 1) {
      return null;
    }
    paramBitmap = Bitmap.createScaledBitmap(paramBitmap, paramBitmap.getWidth() / 8, paramBitmap.getHeight() / 8, false);
    int i11 = paramBitmap.getWidth();
    int i12 = paramBitmap.getHeight();
    Object localObject = new int[i11 * i12];
    paramBitmap.getPixels((int[])localObject, 0, i11, 0, 0, i11, i12);
    int i14 = i11 - 1;
    int i13 = i12 - 1;
    paramInt = i11 * i12;
    int[] arrayOfInt1 = new int[paramInt];
    int[] arrayOfInt2 = new int[paramInt];
    int[] arrayOfInt3 = new int[paramInt];
    int[] arrayOfInt4 = new int[Math.max(i11, i12)];
    int[] arrayOfInt5 = new int[2304];
    paramInt = 0;
    while (paramInt < 2304)
    {
      arrayOfInt5[paramInt] = (paramInt / 9);
      paramInt += 1;
    }
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { 5, 3 });
    int i6 = 0;
    paramInt = 0;
    int i5 = 0;
    int i;
    int i7;
    int k;
    int m;
    int n;
    int i1;
    int i2;
    int i3;
    int i4;
    int j;
    int i8;
    int[] arrayOfInt6;
    int i10;
    int i9;
    while (i5 < i12)
    {
      i = 0;
      i7 = -2;
      k = 0;
      m = 0;
      n = 0;
      i1 = 0;
      i2 = 0;
      i3 = 0;
      i4 = 0;
      j = 0;
      if (i7 <= 2)
      {
        i8 = localObject[(Math.min(i14, Math.max(i7, 0)) + paramInt)];
        arrayOfInt6 = arrayOfInt[(i7 + 2)];
        arrayOfInt6[0] = ((0xFF0000 & i8) >> 16);
        arrayOfInt6[1] = ((0xFF00 & i8) >> 8);
        arrayOfInt6[2] = (i8 & 0xFF);
        i8 = 3 - Math.abs(i7);
        i4 += arrayOfInt6[0] * i8;
        i3 += arrayOfInt6[1] * i8;
        i2 += i8 * arrayOfInt6[2];
        if (i7 > 0)
        {
          k += arrayOfInt6[0];
          j += arrayOfInt6[1];
          i += arrayOfInt6[2];
        }
        for (;;)
        {
          i7 += 1;
          break;
          i1 += arrayOfInt6[0];
          n += arrayOfInt6[1];
          m += arrayOfInt6[2];
        }
      }
      i10 = 0;
      i9 = 2;
      i8 = i4;
      i7 = i3;
      i4 = i2;
      i2 = i10;
      i3 = i9;
      while (i2 < i11)
      {
        arrayOfInt1[paramInt] = arrayOfInt5[i8];
        arrayOfInt2[paramInt] = arrayOfInt5[i7];
        arrayOfInt3[paramInt] = arrayOfInt5[i4];
        arrayOfInt6 = arrayOfInt[((i3 - 2 + 5) % 5)];
        int i15 = arrayOfInt6[0];
        i10 = arrayOfInt6[1];
        i9 = arrayOfInt6[2];
        if (i5 == 0) {
          arrayOfInt4[i2] = Math.min(i2 + 2 + 1, i14);
        }
        int i16 = localObject[(arrayOfInt4[i2] + i6)];
        arrayOfInt6[0] = ((0xFF0000 & i16) >> 16);
        arrayOfInt6[1] = ((0xFF00 & i16) >> 8);
        arrayOfInt6[2] = (i16 & 0xFF);
        k += arrayOfInt6[0];
        j += arrayOfInt6[1];
        i += arrayOfInt6[2];
        i8 = i8 - i1 + k;
        i7 = i7 - n + j;
        i4 = i4 - m + i;
        i3 = (i3 + 1) % 5;
        arrayOfInt6 = arrayOfInt[(i3 % 5)];
        i1 = i1 - i15 + arrayOfInt6[0];
        n = n - i10 + arrayOfInt6[1];
        m = m - i9 + arrayOfInt6[2];
        k -= arrayOfInt6[0];
        j -= arrayOfInt6[1];
        i -= arrayOfInt6[2];
        paramInt += 1;
        i2 += 1;
      }
      i6 += i11;
      i5 += 1;
    }
    paramInt = 0;
    while (paramInt < i11)
    {
      i4 = 0;
      i6 = -2 * i11;
      i5 = -2;
      i2 = 0;
      m = 0;
      n = 0;
      i1 = 0;
      i = 0;
      k = 0;
      j = 0;
      i3 = 0;
      if (i5 <= 2)
      {
        i7 = Math.max(0, i6) + paramInt;
        arrayOfInt6 = arrayOfInt[(i5 + 2)];
        arrayOfInt6[0] = arrayOfInt1[i7];
        arrayOfInt6[1] = arrayOfInt2[i7];
        arrayOfInt6[2] = arrayOfInt3[i7];
        i8 = 3 - Math.abs(i5);
        i9 = arrayOfInt1[i7];
        i10 = arrayOfInt2[i7];
        i14 = arrayOfInt3[i7];
        if (i5 > 0)
        {
          i2 += arrayOfInt6[0];
          i3 += arrayOfInt6[1];
          i4 += arrayOfInt6[2];
        }
        for (;;)
        {
          i7 = i6;
          if (i5 < i13) {
            i7 = i6 + i11;
          }
          i5 += 1;
          i = i14 * i8 + i;
          k = i10 * i8 + k;
          j = i9 * i8 + j;
          i6 = i7;
          break;
          i1 += arrayOfInt6[0];
          n += arrayOfInt6[1];
          m += arrayOfInt6[2];
        }
      }
      i8 = k;
      i9 = j;
      i10 = 0;
      j = paramInt;
      i5 = i4;
      i6 = i3;
      i7 = i2;
      k = m;
      m = n;
      n = i1;
      i1 = 2;
      i4 = i9;
      i3 = i8;
      i2 = i;
      i = i10;
      while (i < i12)
      {
        localObject[j] = (0xFF000000 & localObject[j] | arrayOfInt5[i4] << 16 | arrayOfInt5[i3] << 8 | arrayOfInt5[i2]);
        arrayOfInt6 = arrayOfInt[((i1 - 2 + 5) % 5)];
        i10 = arrayOfInt6[0];
        i9 = arrayOfInt6[1];
        i8 = arrayOfInt6[2];
        if (paramInt == 0) {
          arrayOfInt4[i] = (Math.min(i + 3, i13) * i11);
        }
        i14 = arrayOfInt4[i] + paramInt;
        arrayOfInt6[0] = arrayOfInt1[i14];
        arrayOfInt6[1] = arrayOfInt2[i14];
        arrayOfInt6[2] = arrayOfInt3[i14];
        i7 += arrayOfInt6[0];
        i6 += arrayOfInt6[1];
        i5 += arrayOfInt6[2];
        i4 = i4 - n + i7;
        i3 = i3 - m + i6;
        i2 = i2 - k + i5;
        i1 = (i1 + 1) % 5;
        arrayOfInt6 = arrayOfInt[i1];
        n = n - i10 + arrayOfInt6[0];
        m = m - i9 + arrayOfInt6[1];
        k = k - i8 + arrayOfInt6[2];
        i7 -= arrayOfInt6[0];
        i6 -= arrayOfInt6[1];
        i5 -= arrayOfInt6[2];
        j += i11;
        i += 1;
      }
      paramInt += 1;
    }
    paramBitmap.setPixels((int[])localObject, 0, i11, 0, 0, i11, i12);
    localObject = Bitmap.createScaledBitmap(paramBitmap, i11, i12, false);
    paramBitmap.recycle();
    if (QLog.isColorLevel()) {
      QLog.d("doBlur", 2, "end comsume : " + (System.currentTimeMillis() - l) + "ms");
    }
    return new BitmapDrawable((Bitmap)localObject);
  }
  
  public static Drawable a(Context paramContext, int paramInt)
  {
    BitmapDrawable localBitmapDrawable = null;
    int i = UITools.a(paramContext);
    int j = UITools.b(paramContext);
    if (QLog.isColorLevel()) {
      QLog.d("BitmapTools", 2, "screenWidth = " + i + " # screenHeight =" + j);
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    if (i <= 480) {}
    for (localOptions.inSampleSize = 4;; localOptions.inSampleSize = 2) {
      do
      {
        try
        {
          localBitmapDrawable = new BitmapDrawable(paramContext.getResources(), BitmapFactory.decodeResource(paramContext.getResources(), paramInt, localOptions));
          return localBitmapDrawable;
        }
        catch (OutOfMemoryError paramContext)
        {
          return null;
        }
        catch (Exception paramContext) {}
      } while (i > 720);
    }
    return null;
  }
  
  public static Drawable b(Context paramContext, int paramInt)
  {
    BitmapDrawable localBitmapDrawable = null;
    int i = UITools.a(paramContext);
    int j = UITools.b(paramContext);
    if (QLog.isColorLevel()) {
      QLog.d("BitmapTools", 2, "screenWidth = " + i + " # screenHeight =" + j);
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    if (i <= 480) {}
    for (localOptions.inSampleSize = 4;; localOptions.inSampleSize = 2) {
      do
      {
        try
        {
          localOptions.inScaled = false;
          localBitmapDrawable = new BitmapDrawable(paramContext.getResources(), BitmapFactory.decodeResource(paramContext.getResources(), paramInt, localOptions));
          return localBitmapDrawable;
        }
        catch (OutOfMemoryError paramContext)
        {
          return null;
        }
        catch (Exception paramContext) {}
      } while (i > 720);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.utils.BitmapTools
 * JD-Core Version:    0.7.0.1
 */