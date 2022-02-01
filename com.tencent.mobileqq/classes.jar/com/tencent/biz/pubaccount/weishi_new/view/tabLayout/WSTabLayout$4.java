package com.tencent.biz.pubaccount.weishi_new.view.tabLayout;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WSTabLayout$4
  extends AnimatorListenerAdapter
{
  WSTabLayout$4(WSTabLayout paramWSTabLayout) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    WSTabLayout.b(this.a);
    WSLog.b("WSTabLayoutLog", "[WSTabLayout.java][onAnimationCancel] hideTab!!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    WSTabLayout.b(this.a);
    WSLog.b("WSTabLayoutLog", "[WSTabLayout.java][onAnimationEnd] hideTab!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabLayout.4
 * JD-Core Version:    0.7.0.1
 */