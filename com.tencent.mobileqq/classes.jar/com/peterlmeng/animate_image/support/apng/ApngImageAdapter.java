package com.peterlmeng.animate_image.support.apng;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.peterlmeng.animate_image.support.common.IBitmapAnimator;
import com.peterlmeng.animate_image.support.common.IBitmapAnimator.AnimatorState;
import com.peterlmeng.animate_image.support.common.IInvalidateCallback;
import com.peterlmeng.animate_image.support.common.ILoadAnimatorCallback;

public class ApngImageAdapter
  implements IBitmapAnimator
{
  public Bitmap currentFrame()
  {
    return null;
  }
  
  public void draw(Canvas paramCanvas) {}
  
  public int getHeight()
  {
    return 0;
  }
  
  public IBitmapAnimator.AnimatorState getState()
  {
    return IBitmapAnimator.AnimatorState.NotLoad;
  }
  
  public int getWidth()
  {
    return 0;
  }
  
  public void load() {}
  
  public void pause() {}
  
  public void play() {}
  
  public void setInvalidateCallback(IInvalidateCallback<Bitmap> paramIInvalidateCallback) {}
  
  public void setLoadResultCallback(ILoadAnimatorCallback paramILoadAnimatorCallback) {}
  
  public void stop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.peterlmeng.animate_image.support.apng.ApngImageAdapter
 * JD-Core Version:    0.7.0.1
 */