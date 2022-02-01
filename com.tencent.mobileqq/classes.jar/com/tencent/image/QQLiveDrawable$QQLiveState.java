package com.tencent.image;

import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

class QQLiveDrawable$QQLiveState
  extends Drawable.ConstantState
{
  int mChangingConfigurations;
  int mGravity = 119;
  Paint mPaint = new Paint();
  int mTargetDensity = 160;
  public QQLiveImage mVideo;
  
  public QQLiveDrawable$QQLiveState(QQLiveImage paramQQLiveImage)
  {
    this.mVideo = paramQQLiveImage;
  }
  
  public int getChangingConfigurations()
  {
    return this.mChangingConfigurations;
  }
  
  public Drawable newDrawable()
  {
    return new QQLiveDrawable(this, null);
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    return new QQLiveDrawable(this, paramResources);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image.QQLiveDrawable.QQLiveState
 * JD-Core Version:    0.7.0.1
 */