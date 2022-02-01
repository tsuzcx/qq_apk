package com.tencent.mobileqq.bubble;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.vas.AvatarPendantManager;

class BubbleNewAIOAnim$3
  extends AnimatorListenerAdapter
{
  BubbleNewAIOAnim$3(BubbleNewAIOAnim paramBubbleNewAIOAnim) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.a("animator set end!");
    if (this.a.t != null)
    {
      BubbleNewAIOAnim.a(this.a).removeView(this.a.t);
      this.a.t = null;
    }
    else
    {
      this.a.a("something wrong, bubble view is null!");
    }
    if (this.a.u != null)
    {
      BubbleNewAIOAnim.b(this.a).removeView(this.a.u);
      this.a.u = null;
    }
    else
    {
      this.a.a("something wrong, pendview is null!");
    }
    if (this.a.v != null)
    {
      this.a.v.setVisibility(0);
      paramAnimator = (AvatarPendantManager)this.a.y.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
      paramAnimator.c = -1L;
      paramAnimator.b();
    }
    if (this.a.s != null) {
      this.a.s.invalidate();
    }
    paramAnimator = this.a;
    paramAnimator.A = "";
    paramAnimator.B = "";
    paramAnimator.a(true);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.a("animator set start!");
    this.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleNewAIOAnim.3
 * JD-Core Version:    0.7.0.1
 */