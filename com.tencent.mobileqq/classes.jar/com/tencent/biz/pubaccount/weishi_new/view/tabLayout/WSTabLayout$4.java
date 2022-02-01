package com.tencent.biz.pubaccount.weishi_new.view.tabLayout;

import android.widget.LinearLayout.LayoutParams;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;

class WSTabLayout$4
  implements Animator.AnimatorListener
{
  WSTabLayout$4(WSTabLayout paramWSTabLayout) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    paramAnimator = (LinearLayout.LayoutParams)this.a.getLayoutParams();
    paramAnimator.topMargin = (-WSTabLayout.a(this.a));
    this.a.setLayoutParams(paramAnimator);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = (LinearLayout.LayoutParams)this.a.getLayoutParams();
    paramAnimator.topMargin = (-WSTabLayout.a(this.a));
    this.a.setLayoutParams(paramAnimator);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (WSTabLayout.a(this.a) != null) {
      WSTabLayout.a(this.a).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabLayout.4
 * JD-Core Version:    0.7.0.1
 */