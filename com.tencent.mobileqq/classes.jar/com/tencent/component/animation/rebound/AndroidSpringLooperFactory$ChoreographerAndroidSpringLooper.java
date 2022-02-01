package com.tencent.component.animation.rebound;

import android.annotation.TargetApi;
import android.os.SystemClock;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;

@TargetApi(16)
class AndroidSpringLooperFactory$ChoreographerAndroidSpringLooper
  extends SpringLooper
{
  private final Choreographer mChoreographer;
  private final Choreographer.FrameCallback mFrameCallback;
  private long mLastTime;
  private boolean mStarted;
  
  public AndroidSpringLooperFactory$ChoreographerAndroidSpringLooper(Choreographer paramChoreographer)
  {
    this.mChoreographer = paramChoreographer;
    this.mFrameCallback = new AndroidSpringLooperFactory.ChoreographerAndroidSpringLooper.1(this);
  }
  
  public static ChoreographerAndroidSpringLooper create()
  {
    return new ChoreographerAndroidSpringLooper(Choreographer.getInstance());
  }
  
  public void start()
  {
    if (this.mStarted) {
      return;
    }
    this.mStarted = true;
    this.mLastTime = SystemClock.uptimeMillis();
    this.mChoreographer.removeFrameCallback(this.mFrameCallback);
    this.mChoreographer.postFrameCallback(this.mFrameCallback);
  }
  
  public void stop()
  {
    this.mStarted = false;
    this.mChoreographer.removeFrameCallback(this.mFrameCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.animation.rebound.AndroidSpringLooperFactory.ChoreographerAndroidSpringLooper
 * JD-Core Version:    0.7.0.1
 */