package com.tencent.component.media.image.drawable;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;

public class SliceBitmapDrawable$SliceBitmap
{
  public static final int DENSITY_NONE = 0;
  int jdField_a_of_type_Int;
  boolean jdField_a_of_type_Boolean;
  Bitmap[] jdField_a_of_type_ArrayOfAndroidGraphicsBitmap;
  int b;
  int c;
  int d;
  int e;
  
  public SliceBitmapDrawable$SliceBitmap(Bitmap paramBitmap)
  {
    if (needSlice(paramBitmap))
    {
      this.c = paramBitmap.getWidth();
      this.d = paramBitmap.getHeight();
      this.e = paramBitmap.getDensity();
      this.jdField_a_of_type_Boolean = paramBitmap.hasAlpha();
      this.jdField_a_of_type_Int = ((this.c + 2048 - 1) / 2048);
      this.b = ((this.d + 2048 - 1) / 2048);
      Bitmap[] arrayOfBitmap = new Bitmap[this.jdField_a_of_type_Int * this.b];
      int i = 0;
      int j = 0;
      while (i < this.jdField_a_of_type_Int)
      {
        int k = 0;
        if (k < this.b)
        {
          int i1 = i * 2048;
          int i2 = k * 2048;
          int m;
          if (i1 + 2048 > this.c)
          {
            m = this.c - i1;
            label154:
            if (i2 + 2048 <= this.d) {
              break label213;
            }
          }
          label213:
          for (int n = this.d - i2;; n = 2048)
          {
            arrayOfBitmap[j] = Bitmap.createBitmap(paramBitmap, i1, i2, m, n);
            k += 1;
            j += 1;
            break;
            m = 2048;
            break label154;
          }
        }
        i += 1;
      }
      this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap = arrayOfBitmap;
      return;
    }
    throw new IllegalArgumentException("the bitmap no need to Slice");
  }
  
  @SuppressLint({"NewApi"})
  public static int getBitmapSize(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return 0;
    }
    if (Build.VERSION.SDK_INT >= 12) {
      return paramBitmap.getByteCount();
    }
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
  
  public static boolean needSlice(Bitmap paramBitmap)
  {
    return (paramBitmap.getWidth() > 2048) || (paramBitmap.getHeight() > 2048);
  }
  
  public static int scaleFromDensity(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 0) || (paramInt2 == paramInt3)) {
      return paramInt1;
    }
    return (paramInt1 * paramInt3 + (paramInt2 >> 1)) / paramInt2;
  }
  
  @TargetApi(11)
  void a(Canvas paramCanvas, Rect paramRect, Paint paramPaint)
  {
    int m = paramCanvas.save();
    boolean bool = paramCanvas.isHardwareAccelerated();
    int n = paramCanvas.getDensity();
    paramCanvas.translate(paramRect.left, paramRect.top);
    if ((paramRect.width() != this.c) || (paramRect.height() != this.d)) {
      paramCanvas.scale(paramRect.width() / this.c, paramRect.height() / this.d);
    }
    if (!bool) {
      paramCanvas.setDensity(this.e);
    }
    int i = 0;
    int j = 0;
    while (i < this.jdField_a_of_type_Int)
    {
      int k = 0;
      while (k < this.b)
      {
        paramRect = this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[j];
        if (paramRect != null) {
          paramCanvas.drawBitmap(paramRect, i * 2048, k * 2048, paramPaint);
        }
        k += 1;
        j += 1;
      }
      i += 1;
    }
    if (!bool) {
      paramCanvas.setDensity(n);
    }
    paramCanvas.restoreToCount(m);
  }
  
  public Bitmap getBitmap(int paramInt)
  {
    if ((this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap != null) && (this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap.length > paramInt)) {
      return this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[paramInt];
    }
    return null;
  }
  
  public final int getByteCount()
  {
    int i = 0;
    Bitmap[] arrayOfBitmap = this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap;
    int k = arrayOfBitmap.length;
    int j = 0;
    while (i < k)
    {
      j += getBitmapSize(arrayOfBitmap[i]);
      i += 1;
    }
    return j;
  }
  
  public int getColumnCount()
  {
    return this.b;
  }
  
  public final int getHeight()
  {
    return this.d;
  }
  
  public int getRowCount()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int getScaledHeight(int paramInt)
  {
    return scaleFromDensity(getHeight(), this.e, paramInt);
  }
  
  public int getScaledHeight(Canvas paramCanvas)
  {
    return scaleFromDensity(getHeight(), this.e, paramCanvas.getDensity());
  }
  
  public int getScaledHeight(DisplayMetrics paramDisplayMetrics)
  {
    return scaleFromDensity(getHeight(), this.e, paramDisplayMetrics.densityDpi);
  }
  
  public int getScaledWidth(int paramInt)
  {
    return scaleFromDensity(getWidth(), this.e, paramInt);
  }
  
  public int getScaledWidth(Canvas paramCanvas)
  {
    return scaleFromDensity(getWidth(), this.e, paramCanvas.getDensity());
  }
  
  public int getScaledWidth(DisplayMetrics paramDisplayMetrics)
  {
    return scaleFromDensity(getWidth(), this.e, paramDisplayMetrics.densityDpi);
  }
  
  public final int getWidth()
  {
    return this.c;
  }
  
  public final boolean hasAlpha()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void recyle()
  {
    Bitmap[] arrayOfBitmap = this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap;
    int j = arrayOfBitmap.length;
    int i = 0;
    while (i < j)
    {
      Bitmap localBitmap = arrayOfBitmap[i];
      if (localBitmap != null) {
        localBitmap.recycle();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.drawable.SliceBitmapDrawable.SliceBitmap
 * JD-Core Version:    0.7.0.1
 */