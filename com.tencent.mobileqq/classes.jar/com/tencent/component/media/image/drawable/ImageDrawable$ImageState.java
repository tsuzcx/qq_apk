package com.tencent.component.media.image.drawable;

import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import com.tencent.component.media.image.BitmapReference;

final class ImageDrawable$ImageState
  extends Drawable.ConstantState
{
  BitmapReference mBitmap;
  int mChangingConfigurations;
  int mClipHeight;
  int mClipWidth;
  Paint mPaint;
  int mTargetDensity = 160;
  
  ImageDrawable$ImageState(BitmapReference paramBitmapReference, int paramInt1, int paramInt2)
  {
    this.mBitmap = paramBitmapReference;
    this.mClipWidth = paramInt1;
    this.mClipHeight = paramInt2;
    this.mPaint = new Paint(6);
  }
  
  ImageDrawable$ImageState(ImageState paramImageState)
  {
    this(paramImageState.mBitmap, paramImageState.mClipWidth, paramImageState.mClipHeight);
    this.mChangingConfigurations = paramImageState.mChangingConfigurations;
    this.mTargetDensity = paramImageState.mTargetDensity;
    this.mPaint = new Paint(paramImageState.mPaint);
  }
  
  public int getChangingConfigurations()
  {
    return this.mChangingConfigurations;
  }
  
  public Drawable newDrawable()
  {
    return new ImageDrawable(this, null, null);
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    return new ImageDrawable(this, paramResources, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.drawable.ImageDrawable.ImageState
 * JD-Core Version:    0.7.0.1
 */