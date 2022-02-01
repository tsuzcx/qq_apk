package androidx.dynamicanimation.animation;

import android.os.SystemClock;
import java.util.ArrayList;

class AnimationHandler$AnimationCallbackDispatcher
{
  AnimationHandler$AnimationCallbackDispatcher(AnimationHandler paramAnimationHandler) {}
  
  void a()
  {
    this.a.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    this.a.a(this.a.jdField_a_of_type_Long);
    if (this.a.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      this.a.a().a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.dynamicanimation.animation.AnimationHandler.AnimationCallbackDispatcher
 * JD-Core Version:    0.7.0.1
 */