package com.tencent.component.animation.rebound;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;

public class ChoreographerCompat
{
  private static final boolean IS_JELLYBEAN_OR_HIGHER;
  private static final long ONE_FRAME_MILLIS = 17L;
  private static ChoreographerCompat __instance = new ChoreographerCompat();
  private Choreographer mChoreographer;
  private Handler mHandler;
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 16) {
      bool = true;
    } else {
      bool = false;
    }
    IS_JELLYBEAN_OR_HIGHER = bool;
  }
  
  private ChoreographerCompat()
  {
    if (IS_JELLYBEAN_OR_HIGHER)
    {
      this.mChoreographer = getChoreographer();
      return;
    }
    this.mHandler = new Handler(Looper.getMainLooper());
  }
  
  @TargetApi(16)
  private void choreographerPostFrameCallback(Choreographer.FrameCallback paramFrameCallback)
  {
    this.mChoreographer.postFrameCallback(paramFrameCallback);
  }
  
  @TargetApi(16)
  private void choreographerPostFrameCallbackDelayed(Choreographer.FrameCallback paramFrameCallback, long paramLong)
  {
    this.mChoreographer.postFrameCallbackDelayed(paramFrameCallback, paramLong);
  }
  
  @TargetApi(16)
  private void choreographerRemoveFrameCallback(Choreographer.FrameCallback paramFrameCallback)
  {
    this.mChoreographer.removeFrameCallback(paramFrameCallback);
  }
  
  @TargetApi(16)
  private Choreographer getChoreographer()
  {
    return Choreographer.getInstance();
  }
  
  public static ChoreographerCompat getInstance()
  {
    return __instance;
  }
  
  public void postFrameCallback(ChoreographerCompat.FrameCallback paramFrameCallback)
  {
    if (IS_JELLYBEAN_OR_HIGHER)
    {
      choreographerPostFrameCallback(paramFrameCallback.getFrameCallback());
      return;
    }
    this.mHandler.postDelayed(paramFrameCallback.getRunnable(), 0L);
  }
  
  public void postFrameCallbackDelayed(ChoreographerCompat.FrameCallback paramFrameCallback, long paramLong)
  {
    if (IS_JELLYBEAN_OR_HIGHER)
    {
      choreographerPostFrameCallbackDelayed(paramFrameCallback.getFrameCallback(), paramLong);
      return;
    }
    this.mHandler.postDelayed(paramFrameCallback.getRunnable(), paramLong + 17L);
  }
  
  public void removeFrameCallback(ChoreographerCompat.FrameCallback paramFrameCallback)
  {
    if (IS_JELLYBEAN_OR_HIGHER)
    {
      choreographerRemoveFrameCallback(paramFrameCallback.getFrameCallback());
      return;
    }
    this.mHandler.removeCallbacks(paramFrameCallback.getRunnable());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.animation.rebound.ChoreographerCompat
 * JD-Core Version:    0.7.0.1
 */