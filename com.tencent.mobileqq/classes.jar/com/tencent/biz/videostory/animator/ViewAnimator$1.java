package com.tencent.biz.videostory.animator;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class ViewAnimator$1
  extends D8SafeAnimatorListener
{
  ViewAnimator$1(ViewAnimator paramViewAnimator) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator) {}
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    if (ViewAnimator.a(this.a) != null) {
      ViewAnimator.a(this.a).a();
    }
  }
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.animator.ViewAnimator.1
 * JD-Core Version:    0.7.0.1
 */