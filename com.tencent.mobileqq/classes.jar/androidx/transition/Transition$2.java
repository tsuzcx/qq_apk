package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.collection.ArrayMap;
import java.util.ArrayList;

class Transition$2
  extends AnimatorListenerAdapter
{
  Transition$2(Transition paramTransition, ArrayMap paramArrayMap) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.val$runningAnimators.remove(paramAnimator);
    this.this$0.mCurrentAnimators.remove(paramAnimator);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.this$0.mCurrentAnimators.add(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.Transition.2
 * JD-Core Version:    0.7.0.1
 */