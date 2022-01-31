package com.tencent.image;

import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

class VideoDrawable$VideoState
  extends Drawable.ConstantState
{
  int mChangingConfigurations;
  int mGravity = 119;
  Paint mPaint = new Paint();
  int mTargetDensity = 160;
  AbstractVideoImage mVideo;
  
  public VideoDrawable$VideoState(AbstractVideoImage paramAbstractVideoImage)
  {
    this.mVideo = paramAbstractVideoImage;
  }
  
  public int getChangingConfigurations()
  {
    return this.mChangingConfigurations;
  }
  
  public Drawable newDrawable()
  {
    return new VideoDrawable(this, null);
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    return new VideoDrawable(this, paramResources);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.VideoDrawable.VideoState
 * JD-Core Version:    0.7.0.1
 */