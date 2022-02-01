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
    if (paramResources != null) {
      this.mTargetDensity = paramResources.getDisplayMetrics().densityDpi;
    } else if (paramImageState != null) {
      this.mTargetDensity = paramImageState.mTargetDensity;
    }
    if (paramImageState != null) {
      paramImageState = paramImageState.mBitmap;
    } else {
      paramImageState = null;
    }
    setBitmapInternal(paramImageState);
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
    if (j == 0) {
      i = localBitmap.getWidth();
    } else {
      i = localBitmap.getScaledWidth(j);
    }
    if (j == 0) {
      j = localBitmap.getHeight();
    } else {
      j = localBitmap.getScaledHeight(j);
    }
    long l = computeProperSize(i, j);
    this.mWidth = extractRangeStartFromLong(l);
    this.mHeight = extractRangeEndFromLong(l);
  }
  
  protected static long computeProperScale(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f1;
    if ((paramInt3 <= 0) && (paramInt4 <= 0))
    {
      f1 = 1.0F;
    }
    else
    {
      if (paramInt3 * paramInt2 > paramInt4 * paramInt1)
      {
        f1 = paramInt3;
        f2 = paramInt1;
      }
      else
      {
        f1 = paramInt4;
        f2 = paramInt2;
      }
      f1 /= f2;
    }
    float f2 = f1;
    if (f1 < 1.0F) {
      f2 = 1.0F;
    }
    return packRangeInLong((int)(paramInt1 * f2), (int)(paramInt2 * f2));
  }
  
  protected static int extractRangeEndFromLong(long paramLong)
  {
    return (int)(paramLong & 0xFFFFFFFF);
  }
  
  protected static int extractRangeStartFromLong(long paramLong)
  {
    return (int)(paramLong >>> 32);
  }
  
  protected static long packRangeInLong(int paramInt1, int paramInt2)
  {
    long l = paramInt1;
    return paramInt2 | l << 32;
  }
  
  protected final long computeProperSize(int paramInt1, int paramInt2)
  {
    return computeProperScale(paramInt1, paramInt2, this.mImageState.mClipWidth, this.mImageState.mClipHeight);
  }
  
  public void draw(Canvas paramCanvas)
  {
    Object localObject = this.mBitmap;
    if (localObject != null) {
      localObject = ((BitmapReference)localObject).getBitmap();
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      ImageDrawable.ImageState localImageState = this.mImageState;
      paramCanvas.drawBitmap((Bitmap)localObject, null, getBounds(), localImageState.mPaint);
    }
  }
  
  public Bitmap getBitmap()
  {
    BitmapReference localBitmapReference = this.mBitmap;
    if (localBitmapReference != null) {
      return localBitmapReference.getBitmap();
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
    if ((localBitmapReference != null) && (!localBitmapReference.hasAlpha()) && (this.mImageState.mPaint.getAlpha() >= 255)) {
      return -1;
    }
    return -3;
  }
  
  public int getOriginalHeight()
  {
    int i = this.mOriginalHeight;
    if (i > 0) {
      return i;
    }
    return getIntrinsicHeight();
  }
  
  public int getOriginalWidth()
  {
    int i = this.mOriginalWidth;
    if (i > 0) {
      return i;
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
      ImageDrawable.ImageState localImageState = this.mImageState;
      localImageState.mClipWidth = paramInt1;
      localImageState.mClipHeight = paramInt2;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.image.drawable.ImageDrawable
 * JD-Core Version:    0.7.0.1
 */