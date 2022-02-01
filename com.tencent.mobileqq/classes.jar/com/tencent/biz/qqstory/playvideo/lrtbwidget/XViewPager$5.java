package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class XViewPager$5
  extends D8SafeAnimatorListener
{
  XViewPager$5(XViewPager paramXViewPager) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (XViewPager.a(this.a) != null) {
      XViewPager.a(this.a).b(0);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (XViewPager.a(this.a) != null) {
      XViewPager.a(this.a).b(0);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager.5
 * JD-Core Version:    0.7.0.1
 */