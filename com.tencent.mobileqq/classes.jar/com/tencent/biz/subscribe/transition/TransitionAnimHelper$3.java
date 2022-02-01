package com.tencent.biz.subscribe.transition;

import android.animation.Animator;
import android.widget.FrameLayout;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class TransitionAnimHelper$3
  extends D8SafeAnimatorListener
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.transition.TransitionAnimHelper.3
 * JD-Core Version:    0.7.0.1
 */