package androidx.dynamicanimation.animation;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import androidx.annotation.RequiresApi;

@RequiresApi(16)
class AnimationHandler$FrameCallbackProvider16
  extends AnimationHandler.AnimationFrameCallbackProvider
{
  private final Choreographer mChoreographer = Choreographer.getInstance();
  private final Choreographer.FrameCallback mChoreographerCallback = new AnimationHandler.FrameCallbackProvider16.1(this);
  
  AnimationHandler$FrameCallbackProvider16(AnimationHandler.AnimationCallbackDispatcher paramAnimationCallbackDispatcher)
  {
    super(paramAnimationCallbackDispatcher);
  }
  
  void postFrameCallback()
  {
    this.mChoreographer.postFrameCallback(this.mChoreographerCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.dynamicanimation.animation.AnimationHandler.FrameCallbackProvider16
 * JD-Core Version:    0.7.0.1
 */