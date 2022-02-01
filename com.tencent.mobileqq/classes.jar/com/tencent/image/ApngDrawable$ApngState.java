package com.tencent.image;

import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

final class ApngDrawable$ApngState
  extends Drawable.ConstantState
{
  ApngImage mApng;
  int mChangingConfigurations;
  int mGravity = 119;
  Paint mPaint = new Paint(6);
  int mTargetDensity = 160;
  
  public ApngDrawable$ApngState(ApngImage paramApngImage)
  {
    this.mApng = paramApngImage;
  }
  
  public int getChangingConfigurations()
  {
    return this.mChangingConfigurations;
  }
  
  public Drawable newDrawable()
  {
    return new ApngDrawable(this, null);
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    return new ApngDrawable(this, paramResources);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.image.ApngDrawable.ApngState
 * JD-Core Version:    0.7.0.1
 */