package com.tencent.ad.tangram.util;

import android.view.ViewTreeObserver.OnScrollChangedListener;

abstract class AdExposureChecker$b
  implements ViewTreeObserver.OnScrollChangedListener
{
  private long duration;
  private long lastActionTime;
  private final Object object = new Object();
  
  AdExposureChecker$b(AdExposureChecker paramAdExposureChecker, long paramLong)
  {
    this.duration = paramLong;
  }
  
  public void onScrollChanged()
  {
    if (this.lastActionTime == 0L)
    {
      this.lastActionTime = System.currentTimeMillis();
      onScrollChangedOverDuration();
    }
    long l = System.currentTimeMillis();
    if (l - this.lastActionTime >= this.duration)
    {
      onScrollChangedOverDuration();
      synchronized (this.object)
      {
        this.lastActionTime = l;
        return;
      }
    }
  }
  
  abstract void onScrollChangedOverDuration();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdExposureChecker.b
 * JD-Core Version:    0.7.0.1
 */