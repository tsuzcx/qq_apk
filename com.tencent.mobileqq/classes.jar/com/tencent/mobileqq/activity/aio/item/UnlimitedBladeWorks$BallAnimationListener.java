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
    if (UnlimitedBladeWorks.a(this.a).a)
    {
      if (UnlimitedBladeWorks.a(this.a) == 2.0D)
      {
        UnlimitedBladeWorks.a(this.a);
        UnlimitedBladeWorks.a(this.a, 5);
      }
      else
      {
        UnlimitedBladeWorks.b(this.a).setImageDrawable(UnlimitedBladeWorks.a(this.a));
        UnlimitedBladeWorks.a(this.a).a(UnlimitedBladeWorks.a(this.a));
        UnlimitedBladeWorks.a(this.a).a(new UnlimitedBladeWorks.BallAnimationListener.1(this));
        UnlimitedBladeWorks.a(this.a).c();
        UnlimitedBladeWorks.a(this.a, 1);
      }
      UnlimitedBladeWorks.a(this.a).setImageDrawable(null);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (UnlimitedBladeWorks.a(this.a))
    {
      UnlimitedBladeWorks.a(this.a).setImageDrawable(UnlimitedBladeWorks.a(this.a));
      return;
    }
    UnlimitedBladeWorks.a(this.a).setImageBitmap(UnlimitedBladeWorks.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.UnlimitedBladeWorks.BallAnimationListener
 * JD-Core Version:    0.7.0.1
 */