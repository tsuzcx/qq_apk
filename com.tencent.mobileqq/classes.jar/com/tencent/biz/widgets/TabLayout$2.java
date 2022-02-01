package com.tencent.biz.widgets;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class TabLayout$2
  extends D8SafeAnimatorListener
{
  TabLayout$2(TabLayout paramTabLayout, Animator.AnimatorListener paramAnimatorListener) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.onAnimationCancel(paramAnimator);
    TabLayout.a(this.b, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.onAnimationEnd(paramAnimator);
    TabLayout.a(this.b, false);
    this.b.a();
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    this.a.onAnimationRepeat(paramAnimator);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.onAnimationStart(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.widgets.TabLayout.2
 * JD-Core Version:    0.7.0.1
 */