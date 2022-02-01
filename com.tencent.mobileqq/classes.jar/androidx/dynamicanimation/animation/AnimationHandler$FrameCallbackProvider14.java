package androidx.dynamicanimation.animation;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

class AnimationHandler$FrameCallbackProvider14
  extends AnimationHandler.AnimationFrameCallbackProvider
{
  long jdField_a_of_type_Long = -1L;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.myLooper());
  private final Runnable jdField_a_of_type_JavaLangRunnable = new AnimationHandler.FrameCallbackProvider14.1(this);
  
  AnimationHandler$FrameCallbackProvider14(AnimationHandler.AnimationCallbackDispatcher paramAnimationCallbackDispatcher)
  {
    super(paramAnimationCallbackDispatcher);
  }
  
  void a()
  {
    long l = Math.max(10L - (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long), 0L);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.dynamicanimation.animation.AnimationHandler.FrameCallbackProvider14
 * JD-Core Version:    0.7.0.1
 */