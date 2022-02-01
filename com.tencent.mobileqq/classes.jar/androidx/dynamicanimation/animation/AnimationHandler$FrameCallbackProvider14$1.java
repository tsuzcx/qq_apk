package androidx.dynamicanimation.animation;

import android.os.SystemClock;

class AnimationHandler$FrameCallbackProvider14$1
  implements Runnable
{
  AnimationHandler$FrameCallbackProvider14$1(AnimationHandler.FrameCallbackProvider14 paramFrameCallbackProvider14) {}
  
  public void run()
  {
    this.this$0.mLastFrameTime = SystemClock.uptimeMillis();
    this.this$0.mDispatcher.dispatchAnimationFrame();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.dynamicanimation.animation.AnimationHandler.FrameCallbackProvider14.1
 * JD-Core Version:    0.7.0.1
 */