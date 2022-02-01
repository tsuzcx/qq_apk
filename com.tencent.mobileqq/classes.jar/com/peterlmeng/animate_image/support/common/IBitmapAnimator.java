package com.peterlmeng.animate_image.support.common;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public abstract interface IBitmapAnimator
{
  public abstract Bitmap currentFrame();
  
  public abstract void draw(Canvas paramCanvas);
  
  public abstract int getHeight();
  
  public abstract IBitmapAnimator.AnimatorState getState();
  
  public abstract int getWidth();
  
  public abstract void load();
  
  public abstract void pause();
  
  public abstract void play();
  
  public abstract void setInvalidateCallback(IInvalidateCallback<Bitmap> paramIInvalidateCallback);
  
  public abstract void setLoadResultCallback(ILoadAnimatorCallback paramILoadAnimatorCallback);
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.peterlmeng.animate_image.support.common.IBitmapAnimator
 * JD-Core Version:    0.7.0.1
 */