package com.tencent.biz.pubaccount.weishi_new.view.tabLayout;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;

class WSTabLayout$2
  implements Animator.AnimatorListener
{
  WSTabLayout$2(WSTabLayout paramWSTabLayout) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.d();
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.d();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (WSTabLayout.a(this.a) != null) {
      WSTabLayout.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabLayout.2
 * JD-Core Version:    0.7.0.1
 */