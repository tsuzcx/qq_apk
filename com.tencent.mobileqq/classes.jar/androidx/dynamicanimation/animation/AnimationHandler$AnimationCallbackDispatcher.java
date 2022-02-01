package androidx.dynamicanimation.animation;

import android.os.SystemClock;
import java.util.ArrayList;

class AnimationHandler$AnimationCallbackDispatcher
{
  AnimationHandler$AnimationCallbackDispatcher(AnimationHandler paramAnimationHandler) {}
  
  void dispatchAnimationFrame()
  {
    this.this$0.mCurrentFrameTime = SystemClock.uptimeMillis();
    AnimationHandler localAnimationHandler = this.this$0;
    localAnimationHandler.doAnimationFrame(localAnimationHandler.mCurrentFrameTime);
    if (this.this$0.mAnimationCallbacks.size() > 0) {
      this.this$0.getProvider().postFrameCallback();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.dynamicanimation.animation.AnimationHandler.AnimationCallbackDispatcher
 * JD-Core Version:    0.7.0.1
 */