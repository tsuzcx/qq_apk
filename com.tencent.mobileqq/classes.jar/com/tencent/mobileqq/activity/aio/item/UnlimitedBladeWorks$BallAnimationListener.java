package com.tencent.mobileqq.activity.aio.item;

import android.animation.Animator;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class UnlimitedBladeWorks$BallAnimationListener
  extends D8SafeAnimatorListener
{
  private UnlimitedBladeWorks$BallAnimationListener(UnlimitedBladeWorks paramUnlimitedBladeWorks) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (UnlimitedBladeWorks.d(this.a).d)
    {
      if (UnlimitedBladeWorks.j(this.a) == 2.0D)
      {
        UnlimitedBladeWorks.k(this.a);
        UnlimitedBladeWorks.c(this.a, 5);
      }
      else
      {
        UnlimitedBladeWorks.m(this.a).setImageDrawable(UnlimitedBladeWorks.l(this.a));
        UnlimitedBladeWorks.l(this.a).a(UnlimitedBladeWorks.c(this.a));
        UnlimitedBladeWorks.l(this.a).a(new UnlimitedBladeWorks.BallAnimationListener.1(this));
        UnlimitedBladeWorks.l(this.a).c();
        UnlimitedBladeWorks.c(this.a, 1);
      }
      UnlimitedBladeWorks.b(this.a).setImageDrawable(null);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (UnlimitedBladeWorks.c(this.a))
    {
      UnlimitedBladeWorks.b(this.a).setImageDrawable(UnlimitedBladeWorks.h(this.a));
      return;
    }
    UnlimitedBladeWorks.b(this.a).setImageBitmap(UnlimitedBladeWorks.i(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.UnlimitedBladeWorks.BallAnimationListener
 * JD-Core Version:    0.7.0.1
 */