package com.google.android.exoplayer2.source;

import android.os.Handler;
import android.os.Looper;

final class DynamicConcatenatingMediaSource$EventDispatcher
{
  public final Handler eventHandler;
  public final Runnable runnable;
  
  public DynamicConcatenatingMediaSource$EventDispatcher(Runnable paramRunnable)
  {
    this.runnable = paramRunnable;
    if (Looper.myLooper() != null) {
      paramRunnable = Looper.myLooper();
    } else {
      paramRunnable = Looper.getMainLooper();
    }
    this.eventHandler = new Handler(paramRunnable);
  }
  
  public void dispatchEvent()
  {
    this.eventHandler.post(this.runnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.source.DynamicConcatenatingMediaSource.EventDispatcher
 * JD-Core Version:    0.7.0.1
 */