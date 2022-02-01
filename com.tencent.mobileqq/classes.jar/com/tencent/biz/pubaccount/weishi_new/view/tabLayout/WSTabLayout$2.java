package com.tencent.biz.pubaccount.weishi_new.view.tabLayout;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WSTabLayout$2
  extends AnimatorListenerAdapter
{
  WSTabLayout$2(WSTabLayout paramWSTabLayout) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    WSTabLayout.a(this.a);
    WSLog.b("WSTabLayoutLog", "[WSTabLayout.java][onAnimationCancel] showTab!!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    WSTabLayout.a(this.a);
    WSLog.b("WSTabLayoutLog", "[WSTabLayout.java][onAnimationCancel] showTab!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabLayout.2
 * JD-Core Version:    0.7.0.1
 */