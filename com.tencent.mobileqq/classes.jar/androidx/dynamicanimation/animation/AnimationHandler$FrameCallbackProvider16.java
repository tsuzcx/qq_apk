package androidx.dynamicanimation.animation;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import androidx.annotation.RequiresApi;

@RequiresApi(16)
class AnimationHandler$FrameCallbackProvider16
  extends AnimationHandler.AnimationFrameCallbackProvider
{
  private final Choreographer.FrameCallback jdField_a_of_type_AndroidViewChoreographer$FrameCallback = new AnimationHandler.FrameCallbackProvider16.1(this);
  private final Choreographer jdField_a_of_type_AndroidViewChoreographer = Choreographer.getInstance();
  
  AnimationHandler$FrameCallbackProvider16(AnimationHandler.AnimationCallbackDispatcher paramAnimationCallbackDispatcher)
  {
    super(paramAnimationCallbackDispatcher);
  }
  
  void a()
  {
    this.jdField_a_of_type_AndroidViewChoreographer.postFrameCallback(this.jdField_a_of_type_AndroidViewChoreographer$FrameCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.dynamicanimation.animation.AnimationHandler.FrameCallbackProvider16
 * JD-Core Version:    0.7.0.1
 */