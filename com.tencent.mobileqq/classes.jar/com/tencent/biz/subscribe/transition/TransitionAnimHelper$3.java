package com.tencent.biz.subscribe.transition;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.FrameLayout;

class TransitionAnimHelper$3
  implements Animator.AnimatorListener
{
  TransitionAnimHelper$3(TransitionAnimHelper paramTransitionAnimHelper) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    TransitionAnimHelper.a(this.a, null);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (TransitionAnimHelper.a(this.a) != null) {
      TransitionAnimHelper.a(this.a).a(3);
    }
    if (TransitionAnimHelper.a(this.a) != null)
    {
      TransitionAnimHelper.a(this.a).setAlpha(0.0F);
      TransitionAnimHelper.a(this.a, null);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.transition.TransitionAnimHelper.3
 * JD-Core Version:    0.7.0.1
 */