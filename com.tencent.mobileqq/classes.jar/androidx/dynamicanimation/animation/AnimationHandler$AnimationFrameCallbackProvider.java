package androidx.dynamicanimation.animation;

abstract class AnimationHandler$AnimationFrameCallbackProvider
{
  final AnimationHandler.AnimationCallbackDispatcher mDispatcher;
  
  AnimationHandler$AnimationFrameCallbackProvider(AnimationHandler.AnimationCallbackDispatcher paramAnimationCallbackDispatcher)
  {
    this.mDispatcher = paramAnimationCallbackDispatcher;
  }
  
  abstract void postFrameCallback();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.dynamicanimation.animation.AnimationHandler.AnimationFrameCallbackProvider
 * JD-Core Version:    0.7.0.1
 */