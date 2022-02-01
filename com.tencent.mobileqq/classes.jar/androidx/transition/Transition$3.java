package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class Transition$3
  extends AnimatorListenerAdapter
{
  Transition$3(Transition paramTransition) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.this$0.end();
    paramAnimator.removeListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.Transition.3
 * JD-Core Version:    0.7.0.1
 */