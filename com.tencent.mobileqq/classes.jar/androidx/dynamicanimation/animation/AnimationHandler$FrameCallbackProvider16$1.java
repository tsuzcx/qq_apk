package androidx.dynamicanimation.animation;

import android.view.Choreographer.FrameCallback;

class AnimationHandler$FrameCallbackProvider16$1
  implements Choreographer.FrameCallback
{
  AnimationHandler$FrameCallbackProvider16$1(AnimationHandler.FrameCallbackProvider16 paramFrameCallbackProvider16) {}
  
  public void doFrame(long paramLong)
  {
    this.this$0.mDispatcher.dispatchAnimationFrame();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.dynamicanimation.animation.AnimationHandler.FrameCallbackProvider16.1
 * JD-Core Version:    0.7.0.1
 */