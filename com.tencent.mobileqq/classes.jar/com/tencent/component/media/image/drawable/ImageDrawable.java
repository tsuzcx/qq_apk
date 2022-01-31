package com.tencent.component.media.image.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.DisplayMetrics;
import com.tencent.component.media.image.BitmapReference;

public class ImageDrawable
  extends Drawable
{
  private static final int DEFAULT_PAINT_FLAGS = 6;
  private BitmapReference mBitmap;
  private int mHeight = -1;
  private ImageDrawable.ImageState mImageState;
  private boolean mMutated;
  private int mOriginalHeight;
  private int mOriginalWidth;
  private int mTargetDensity;
  private int mWidth = -1;
  
  public ImageDrawable(Resources paramResources, BitmapReference paramBitmapReference)
  {
    this(paramResources, paramBitmapReference, -1, -1);
  }
  
  public ImageDrawable(Resources paramResources, BitmapReference paramBitmapReference, int paramInt1, int paramInt2)
  {
    this.mImageState = new ImageDrawable.ImageState(paramBitmapReference, paramInt1, paramInt2);
    if (paramResources != null) {
      this.mTargetDensity = paramResources.getDisplayMetrics().densityDpi;
    }
    setBitmapInternal(paramBitmapReference);
  }
  
  public ImageDrawable(BitmapReference paramBitmapReference)
  {
    this(null, paramBitmapReference, -1, -1);
  }
  
  public ImageDrawable(BitmapReference paramBitmapReference, int paramInt1, int paramInt2)
  {
    this(null, paramBitmapReference, paramInt1, paramInt2);
  }
  
  private ImageDrawable(ImageDrawable.ImageState paramImageState, Resources paramResources)
  {
    this.mImageState = new ImageDrawable.ImageState(paramImageState);
    if (paramResources != null)
    {
      this.mTargetDensity = paramResources.getDisplayMetrics().densityDpi;
      if (paramImageState == null) {
        break label71;
      }
    }
    label71:
    for (paramImageState = paramImageState.mBitmap;; paramImageState = null)
    {
      setBitmapInternal(paramImageState);
      return;
      if (paramImageState == null) {
        break;
      }
      this.mTargetDensity = paramImageState.mTargetDensity;
      break;
    }
  }
  
  private void computeBitmapSize()
  {
    Bitmap localBitmap = this.mBitmap.getBitmap();
    if (localBitmap == null)
    {
      this.mHeight = -1;
      this.mWidth = -1;
      return;
    }
    int j = this.mTargetDensity;
    int i;
    if (j == 0)
    {
      i = localBitmap.getWidth();
      if (j != 0) {
        break label84;
      }
    }
    label84:
    for (j = localBitmap.getHeight();; j = localBitmap.getScaledHeight(j))
    {
      long l = computeProperSize(i, j);
      this.mWidth = extractRangeStartFromLong(l);
      this.mHeight = extractRangeEndFromLong(l);
      return;
      i = localBitmap.getScaledWidth(j);
      break;
    }
  }
  
  protected static long computeProperScale(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f2 = 1.0F;
    float f1;
    if ((paramInt3 <= 0) && (paramInt4 <= 0))
    {
      f1 = 1.0F;
      if (f1 >= 1.0F) {
        break label70;
      }
      f1 = f2;
    }
    label70:
    for (;;)
    {
      return packRangeInLong((int)(paramInt1 * f1), (int)(f1 * paramInt2));
      if (paramInt3 * paramInt2 > paramInt4 * paramInt1)
      {
        f1 = paramInt3 / paramInt1;
        break;
      }
      f1 = paramInt4 / paramInt2;
      break;
    }
  }
  
  protected static int extractRangeEndFromLong(long paramLong)
  {
    return (int)(0xFFFFFFFF & paramLong);
  }
  
  protected static int extractRangeStartFromLong(long paramLong)
  {
    return (int)(paramLong >>> 32);
  }
  
  protected static long packRangeInLong(int paramInt1, int paramInt2)
  {
    return paramInt1 << 32 | paramInt2;
  }
  
  protected final long computeProperSize(int paramInt1, int paramInt2)
  {
    return computeProperScale(paramInt1, paramInt2, this.mImageState.mClipWidth, this.mImageState.mClipHeight);
  }
  
  public void draw(Canvas paramCanvas)
  {
    Object localObject = this.mBitmap;
    if (localObject != null) {}
    for (localObject = ((BitmapReference)localObject).getBitmap();; localObject = null)
    {
      if (localObject != null)
      {
        ImageDrawable.ImageState localImageState = this.mImageState;
        paramCanvas.drawBitmap((Bitmap)localObject, null, getBounds(), localImageState.mPaint);
      }
      return;
    }
  }
  
  public Bitmap getBitmap()
  {
    if (this.mBitmap != null) {
      return this.mBitmap.getBitmap();
    }
    return null;
  }
  
  public int getBitmapHeight()
  {
    BitmapReference localBitmapReference = this.mBitmap;
    if (localBitmapReference == null) {
      return -1;
    }
    return localBitmapReference.getHeight();
  }
  
  public BitmapReference getBitmapRef()
  {
    return this.mBitmap;
  }
  
  public int getBitmapWidth()
  {
    BitmapReference localBitmapReference = this.mBitmap;
    if (localBitmapReference == null) {
      return -1;
    }
    return localBitmapReference.getWidth();
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.mImageState.mChangingConfigurations;
  }
  
  public int getClipHeight()
  {
    return this.mImageState.mClipHeight;
  }
  
  public int getClipWidth()
  {
    return this.mImageState.mClipWidth;
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    this.mImageState.mChangingConfigurations = getChangingConfigurations();
    return this.mImageState;
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
    BitmapReference localBitmapReference = this.mBitmap;
    if ((localBitmapReference == null) || (localBitmapReference.hasAlpha()) || (this.mImageState.mPaint.getAlpha() < 255)) {
      return -3;
    }
    return -1;
  }
  
  public int getOriginalHeight()
  {
    if (this.mOriginalHeight > 0) {
      return this.mOriginalHeight;
    }
    return getIntrinsicHeight();
  }
  
  public int getOriginalWidth()
  {
    if (this.mOriginalWidth > 0) {
      return this.mOriginalWidth;
    }
    return getIntrinsicWidth();
  }
  
  public final Paint getPaint()
  {
    return this.mImageState.mPaint;
  }
  
  public Drawable mutate()
  {
    if ((!this.mMutated) && (super.mutate() == this))
    {
      this.mImageState = new ImageDrawable.ImageState(this.mImageState);
      this.mMutated = true;
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
  }
  
  public void resize(int paramInt1, int paramInt2)
  {
    if ((this.mImageState.mClipWidth != paramInt1) || (this.mImageState.mClipHeight != paramInt2))
    {
      this.mImageState.mClipWidth = paramInt1;
      this.mImageState.mClipHeight = paramInt2;
      computeBitmapSize();
    }
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.mImageState.mPaint.getAlpha())
    {
      this.mImageState.mPaint.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setAntiAlias(boolean paramBoolean)
  {
    this.mImageState.mPaint.setAntiAlias(paramBoolean);
    invalidateSelf();
  }
  
  protected final void setBitmapInternal(BitmapReference paramBitmapReference)
  {
    setBitmapInternal(paramBitmapReference, true);
  }
  
  protected final void setBitmapInternal(BitmapReference paramBitmapReference, boolean paramBoolean)
  {
    if (paramBitmapReference != this.mBitmap)
    {
      this.mBitmap = paramBitmapReference;
      computeBitmapSize();
      if (paramBoolean) {
        invalidateSelf();
      }
    }
  }
  
  public void setBitmapRef(BitmapReference paramBitmapReference)
  {
    setBitmapInternal(paramBitmapReference);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mImageState.mPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.mImageState.mPaint.setDither(paramBoolean);
    invalidateSelf();
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.mImageState.mPaint.setFilterBitmap(paramBoolean);
    invalidateSelf();
  }
  
  public void setOriginalHeight(int paramInt)
  {
    this.mOriginalHeight = paramInt;
  }
  
  public void setOriginalWidth(int paramInt)
  {
    this.mOriginalWidth = paramInt;
  }
  
  public void setTargetDensity(int paramInt)
  {
    if (this.mTargetDensity != paramInt)
    {
      int i = paramInt;
      if (paramInt == 0) {
        i = 160;
      }
      this.mTargetDensity = i;
      if (this.mBitmap != null) {
        computeBitmapSize();
      }
      invalidateSelf();
    }
  }
  
  public void setTargetDensity(Canvas paramCanvas)
  {
    setTargetDensity(paramCanvas.getDensity());
  }
  
  public void setTargetDensity(DisplayMetrics paramDisplayMetrics)
  {
    setTargetDensity(paramDisplayMetrics.densityDpi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.drawable.ImageDrawable
 * JD-Core Version:    0.7.0.1
 */