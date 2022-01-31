package com.tencent.component.animation.rebound;

import android.annotation.TargetApi;
import android.view.Choreographer.FrameCallback;

public abstract class ChoreographerCompat$FrameCallback
{
  private Choreographer.FrameCallback mFrameCallback;
  private Runnable mRunnable;
  
  public abstract void doFrame(long paramLong);
  
  @TargetApi(16)
  Choreographer.FrameCallback getFrameCallback()
  {
    if (this.mFrameCallback == null) {
      this.mFrameCallback = new ChoreographerCompat.FrameCallback.1(this);
    }
    return this.mFrameCallback;
  }
  
  Runnable getRunnable()
  {
    if (this.mRunnable == null) {
      this.mRunnable = new ChoreographerCompat.FrameCallback.2(this);
    }
    return this.mRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.animation.rebound.ChoreographerCompat.FrameCallback
 * JD-Core Version:    0.7.0.1
 */