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
  public static final int SLICE_SIZE = 2048;
  boolean hasAlpha;
  Bitmap[] mBitmaps;
  int mChangingConfigurations;
  int mColumnCount;
  int mDensity;
  int mHeight;
  int mRowCount;
  int mWidth;
  
  public SliceBitmapDrawable$SliceBitmap(Bitmap paramBitmap)
  {
    if (needSlice(paramBitmap))
    {
      this.mWidth = paramBitmap.getWidth();
      this.mHeight = paramBitmap.getHeight();
      this.mDensity = paramBitmap.getDensity();
      this.hasAlpha = paramBitmap.hasAlpha();
      this.mRowCount = ((this.mWidth + 2048 - 1) / 2048);
      this.mColumnCount = ((this.mHeight + 2048 - 1) / 2048);
      Bitmap[] arrayOfBitmap = new Bitmap[this.mRowCount * this.mColumnCount];
      int j = 0;
      int i = 0;
      while (j < this.mRowCount)
      {
        int k = 0;
        while (k < this.mColumnCount)
        {
          int i1 = j * 2048;
          int i2 = k * 2048;
          int m = this.mWidth;
          if (i1 + 2048 > m) {
            m -= i1;
          } else {
            m = 2048;
          }
          int n = this.mHeight;
          if (i2 + 2048 > n) {
            n -= i2;
          } else {
            n = 2048;
          }
          arrayOfBitmap[i] = Bitmap.createBitmap(paramBitmap, i1, i2, m, n);
          i += 1;
          k += 1;
        }
        j += 1;
      }
      this.mBitmaps = arrayOfBitmap;
      return;
    }
    paramBitmap = new IllegalArgumentException("the bitmap no need to Slice");
    for (;;)
    {
      throw paramBitmap;
    }
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
    int i = paramBitmap.getRowBytes();
    return paramBitmap.getHeight() * i;
  }
  
  public static boolean needSlice(Bitmap paramBitmap)
  {
    return (paramBitmap.getWidth() > 2048) || (paramBitmap.getHeight() > 2048);
  }
  
  public static int scaleFromDensity(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt1;
    if (paramInt2 != 0)
    {
      if (paramInt2 == paramInt3) {
        return paramInt1;
      }
      i = (paramInt1 * paramInt3 + (paramInt2 >> 1)) / paramInt2;
    }
    return i;
  }
  
  @TargetApi(11)
  void draw(Canvas paramCanvas, Rect paramRect, Paint paramPaint)
  {
    int m = paramCanvas.save();
    boolean bool = paramCanvas.isHardwareAccelerated();
    int n = paramCanvas.getDensity();
    paramCanvas.translate(paramRect.left, paramRect.top);
    if ((paramRect.width() != this.mWidth) || (paramRect.height() != this.mHeight)) {
      paramCanvas.scale(paramRect.width() / this.mWidth, paramRect.height() / this.mHeight);
    }
    if (!bool) {
      paramCanvas.setDensity(this.mDensity);
    }
    int j = 0;
    int i = 0;
    while (j < this.mRowCount)
    {
      int k = 0;
      while (k < this.mColumnCount)
      {
        paramRect = this.mBitmaps[i];
        if (paramRect != null) {
          paramCanvas.drawBitmap(paramRect, j * 2048, k * 2048, paramPaint);
        }
        i += 1;
        k += 1;
      }
      j += 1;
    }
    if (!bool) {
      paramCanvas.setDensity(n);
    }
    paramCanvas.restoreToCount(m);
  }
  
  public Bitmap getBitmap(int paramInt)
  {
    Bitmap[] arrayOfBitmap = this.mBitmaps;
    if ((arrayOfBitmap != null) && (arrayOfBitmap.length > paramInt)) {
      return arrayOfBitmap[paramInt];
    }
    return null;
  }
  
  public final int getByteCount()
  {
    Bitmap[] arrayOfBitmap = this.mBitmaps;
    int k = arrayOfBitmap.length;
    int i = 0;
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
    return this.mColumnCount;
  }
  
  public final int getHeight()
  {
    return this.mHeight;
  }
  
  public int getRowCount()
  {
    return this.mRowCount;
  }
  
  public int getScaledHeight(int paramInt)
  {
    return scaleFromDensity(getHeight(), this.mDensity, paramInt);
  }
  
  public int getScaledHeight(Canvas paramCanvas)
  {
    return scaleFromDensity(getHeight(), this.mDensity, paramCanvas.getDensity());
  }
  
  public int getScaledHeight(DisplayMetrics paramDisplayMetrics)
  {
    return scaleFromDensity(getHeight(), this.mDensity, paramDisplayMetrics.densityDpi);
  }
  
  public int getScaledWidth(int paramInt)
  {
    return scaleFromDensity(getWidth(), this.mDensity, paramInt);
  }
  
  public int getScaledWidth(Canvas paramCanvas)
  {
    return scaleFromDensity(getWidth(), this.mDensity, paramCanvas.getDensity());
  }
  
  public int getScaledWidth(DisplayMetrics paramDisplayMetrics)
  {
    return scaleFromDensity(getWidth(), this.mDensity, paramDisplayMetrics.densityDpi);
  }
  
  public final int getWidth()
  {
    return this.mWidth;
  }
  
  public final boolean hasAlpha()
  {
    return this.hasAlpha;
  }
  
  public void recyle()
  {
    Bitmap[] arrayOfBitmap = this.mBitmaps;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.image.drawable.SliceBitmapDrawable.SliceBitmap
 * JD-Core Version:    0.7.0.1
 */