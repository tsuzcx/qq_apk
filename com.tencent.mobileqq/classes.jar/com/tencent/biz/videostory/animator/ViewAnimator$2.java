package com.tencent.biz.videostory.animator;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class ViewAnimator$2
  implements Animator.AnimatorListener
{
  ViewAnimator$2(ViewAnimator paramViewAnimator) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (ViewAnimator.a(this.a) != null) {
      ViewAnimator.a(this.a).a();
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (ViewAnimator.a(this.a) != null) {
      ViewAnimator.a(this.a).a();
    }
    if (ViewAnimator.a(this.a) != null)
    {
      ViewAnimator.a(ViewAnimator.a(this.a), null);
      ViewAnimator.a(this.a).a();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (ViewAnimator.a(this.a) != null) {
      ViewAnimator.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.videostory.animator.ViewAnimator.2
 * JD-Core Version:    0.7.0.1
 */