package com.tencent.mobileqq.activity.aio.rebuild;

import android.animation.Animator;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class PublicAccountChatPie$15
  extends D8SafeAnimatorListener
{
  PublicAccountChatPie$15(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.U.removeHeaderView(PublicAccountChatPie.k(this.a));
    PublicAccountChatPie.a(this.a, true);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.15
 * JD-Core Version:    0.7.0.1
 */