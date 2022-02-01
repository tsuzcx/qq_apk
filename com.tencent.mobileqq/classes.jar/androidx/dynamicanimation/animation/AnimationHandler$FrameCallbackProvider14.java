package androidx.dynamicanimation.animation;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

class AnimationHandler$FrameCallbackProvider14
  extends AnimationHandler.AnimationFrameCallbackProvider
{
  private final Handler mHandler = new Handler(Looper.myLooper());
  long mLastFrameTime = -1L;
  private final Runnable mRunnable = new AnimationHandler.FrameCallbackProvider14.1(this);
  
  AnimationHandler$FrameCallbackProvider14(AnimationHandler.AnimationCallbackDispatcher paramAnimationCallbackDispatcher)
  {
    super(paramAnimationCallbackDispatcher);
  }
  
  void postFrameCallback()
  {
    long l = Math.max(10L - (SystemClock.uptimeMillis() - this.mLastFrameTime), 0L);
    this.mHandler.postDelayed(this.mRunnable, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.dynamicanimation.animation.AnimationHandler.FrameCallbackProvider14
 * JD-Core Version:    0.7.0.1
 */