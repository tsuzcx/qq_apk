package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class ViewPropertyAnimatorCompat$1
  extends AnimatorListenerAdapter
{
  ViewPropertyAnimatorCompat$1(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, ViewPropertyAnimatorListener paramViewPropertyAnimatorListener, View paramView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.val$listener.onAnimationCancel(this.val$view);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.val$listener.onAnimationEnd(this.val$view);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.val$listener.onAnimationStart(this.val$view);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.view.ViewPropertyAnimatorCompat.1
 * JD-Core Version:    0.7.0.1
 */