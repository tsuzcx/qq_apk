package com.tencent.component.animation.rebound;

import android.os.Handler;
import android.os.SystemClock;

class AndroidSpringLooperFactory$LegacyAndroidSpringLooper
  extends SpringLooper
{
  private final Handler mHandler;
  private long mLastTime;
  private final Runnable mLooperRunnable;
  private boolean mStarted;
  
  public AndroidSpringLooperFactory$LegacyAndroidSpringLooper(Handler paramHandler)
  {
    this.mHandler = paramHandler;
    this.mLooperRunnable = new AndroidSpringLooperFactory.LegacyAndroidSpringLooper.1(this);
  }
  
  public static SpringLooper create()
  {
    return new LegacyAndroidSpringLooper(new Handler());
  }
  
  public void start()
  {
    if (this.mStarted) {
      return;
    }
    this.mStarted = true;
    this.mLastTime = SystemClock.uptimeMillis();
    this.mHandler.removeCallbacks(this.mLooperRunnable);
    this.mHandler.post(this.mLooperRunnable);
  }
  
  public void stop()
  {
    this.mStarted = false;
    this.mHandler.removeCallbacks(this.mLooperRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.animation.rebound.AndroidSpringLooperFactory.LegacyAndroidSpringLooper
 * JD-Core Version:    0.7.0.1
 */