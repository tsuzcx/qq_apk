package com.tencent.biz.videostory.animator;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class ViewAnimator$2
  extends D8SafeAnimatorListener
{
  ViewAnimator$2(ViewAnimator paramViewAnimator) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (ViewAnimator.e(this.a) != null) {
      ViewAnimator.e(this.a).a();
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (ViewAnimator.c(this.a) != null) {
      ViewAnimator.c(this.a).a();
    }
    if (ViewAnimator.d(this.a) != null)
    {
      ViewAnimator.a(ViewAnimator.d(this.a), null);
      ViewAnimator.d(this.a).b();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (ViewAnimator.b(this.a) != null) {
      ViewAnimator.b(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.animator.ViewAnimator.2
 * JD-Core Version:    0.7.0.1
 */