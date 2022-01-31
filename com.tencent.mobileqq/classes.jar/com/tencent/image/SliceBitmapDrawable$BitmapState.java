package com.tencent.image;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

final class SliceBitmapDrawable$BitmapState
  extends Drawable.ConstantState
{
  int mChangingConfigurations;
  Paint mPaint = new Paint(6);
  SliceBitmap mSliceBitmap;
  int mTargetDensity = 160;
  
  SliceBitmapDrawable$BitmapState(Bitmap paramBitmap)
  {
    this.mSliceBitmap = new SliceBitmap(paramBitmap);
  }
  
  SliceBitmapDrawable$BitmapState(SliceBitmap paramSliceBitmap)
  {
    this.mSliceBitmap = paramSliceBitmap;
  }
  
  SliceBitmapDrawable$BitmapState(BitmapState paramBitmapState)
  {
    this.mSliceBitmap = paramBitmapState.mSliceBitmap;
    this.mChangingConfigurations = paramBitmapState.mChangingConfigurations;
    this.mTargetDensity = paramBitmapState.mTargetDensity;
    this.mPaint = new Paint(paramBitmapState.mPaint);
  }
  
  public int getChangingConfigurations()
  {
    return this.mChangingConfigurations;
  }
  
  public Drawable newDrawable()
  {
    return new SliceBitmapDrawable(this, null, null);
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    return new SliceBitmapDrawable(this, paramResources, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.SliceBitmapDrawable.BitmapState
 * JD-Core Version:    0.7.0.1
 */