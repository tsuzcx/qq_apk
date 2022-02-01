package com.tencent.image;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.DisplayMetrics;

public class RoundRectDrawable
  extends Drawable
{
  public static final String TAG = "RoundRectDrawable";
  private RoundRectDrawable.RoundRectDrawableState mBitmapState;
  private float mBorderWidth;
  final RectF mBounds = new RectF();
  private float mCornerRadius;
  private int mHeight;
  private int mTargetDensity = 160;
  private int mWidth;
  boolean reBuildCornerRadius = false;
  
  public RoundRectDrawable(Resources paramResources, RoundRectBitmap paramRoundRectBitmap)
  {
    this.mBitmapState = new RoundRectDrawable.RoundRectDrawableState(paramRoundRectBitmap);
    if (paramResources != null)
    {
      this.mTargetDensity = paramResources.getDisplayMetrics().densityDpi;
      this.mBitmapState.mTargetDensity = this.mTargetDensity;
    }
    computeBitmapSize();
  }
  
  private RoundRectDrawable(RoundRectDrawable.RoundRectDrawableState paramRoundRectDrawableState, Resources paramResources)
  {
    this.mBitmapState = paramRoundRectDrawableState;
    if (paramResources != null) {
      this.mTargetDensity = paramResources.getDisplayMetrics().densityDpi;
    } else {
      this.mTargetDensity = paramRoundRectDrawableState.mTargetDensity;
    }
    computeBitmapSize();
  }
  
  private void computeBitmapSize()
  {
    this.mWidth = this.mBitmapState.mRoundRectBitmap.mBitmap.getScaledWidth(this.mTargetDensity);
    this.mHeight = this.mBitmapState.mRoundRectBitmap.mBitmap.getScaledHeight(this.mTargetDensity);
    int i = this.mBitmapState.mRoundRectBitmap.mBitmap.getDensity();
    this.mBorderWidth = (((int)(this.mBitmapState.mRoundRectBitmap.mBorderWidth * this.mTargetDensity) + (i >> 1)) / i);
  }
  
  public void draw(Canvas paramCanvas)
  {
    RectF localRectF1 = this.mBitmapState.mDrawableRect;
    RectF localRectF2 = this.mBitmapState.mBorderRect;
    Paint localPaint1 = this.mBitmapState.mBorderPaint;
    Paint localPaint2 = this.mBitmapState.mBitmapPaint;
    float f2 = localRectF1.width();
    float f1 = localRectF1.height();
    int i = paramCanvas.getWidth();
    int j = paramCanvas.getHeight();
    if ((i != this.mBitmapState.mRoundRectBitmap.mDisplayWidth) && (j != this.mBitmapState.mRoundRectBitmap.mDisplayHeight))
    {
      f2 = i / f2;
      float f3 = j / f1;
      f1 = f3;
      if (f2 < f3) {
        f1 = f2;
      }
    }
    else
    {
      f1 = 1.0F;
    }
    i = this.mBitmapState.mRoundRectBitmap.mBitmap.getDensity();
    this.mCornerRadius = ((this.mBitmapState.mRoundRectBitmap.mCornerRadius * this.mTargetDensity + (i >> 1)) / i / f1);
    if (this.mBitmapState.mOval)
    {
      if (this.mBorderWidth > 0.0F)
      {
        paramCanvas.drawOval(localRectF1, localPaint2);
        paramCanvas.drawOval(localRectF2, localPaint1);
        return;
      }
      paramCanvas.drawOval(localRectF1, localPaint2);
      return;
    }
    if (this.mBorderWidth > 0.0F)
    {
      paramCanvas.drawRoundRect(localRectF1, Math.max(this.mCornerRadius, 0.0F), Math.max(this.mCornerRadius, 0.0F), localPaint2);
      f1 = this.mCornerRadius;
      paramCanvas.drawRoundRect(localRectF2, f1, f1, localPaint1);
      return;
    }
    f1 = this.mCornerRadius;
    paramCanvas.drawRoundRect(localRectF1, f1, f1, localPaint2);
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.mBitmapState.mChangingConfigurations;
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    this.mBitmapState.mChangingConfigurations = getChangingConfigurations();
    return this.mBitmapState;
  }
  
  public int getIntrinsicHeight()
  {
    return this.mHeight;
  }
  
  public int getIntrinsicWidth()
  {
    return this.mWidth;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public Drawable mutate()
  {
    this.mBitmapState = new RoundRectDrawable.RoundRectDrawableState(this.mBitmapState.mRoundRectBitmap);
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.mBounds.set(paramRect);
    this.mBitmapState.updateShaderMatrix(this.mBounds);
    this.reBuildCornerRadius = true;
  }
  
  public void setAlpha(int paramInt)
  {
    this.mBitmapState.mBitmapPaint.setAlpha(paramInt);
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mBitmapState.mBitmapPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.mBitmapState.mBorderPaint.setDither(paramBoolean);
    this.mBitmapState.mBitmapPaint.setDither(paramBoolean);
    invalidateSelf();
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.mBitmapState.mBitmapPaint.setFilterBitmap(paramBoolean);
    invalidateSelf();
  }
  
  public RoundRectDrawable setOval(boolean paramBoolean)
  {
    this.mBitmapState.mOval = paramBoolean;
    return this;
  }
  
  public void setTargetDensity(int paramInt)
  {
    if (paramInt != this.mTargetDensity)
    {
      int i = paramInt;
      if (paramInt == 0) {
        i = 160;
      }
      this.mTargetDensity = i;
      computeBitmapSize();
      invalidateSelf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.image.RoundRectDrawable
 * JD-Core Version:    0.7.0.1
 */