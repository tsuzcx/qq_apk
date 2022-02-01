package com.tencent.mobileqq.bubble;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.vas.AvatarPendantManager;

class BubbleNewAIOAnim$6
  extends AnimatorListenerAdapter
{
  BubbleNewAIOAnim$6(BubbleNewAIOAnim paramBubbleNewAIOAnim, BubbleNewAnimConf.PendantAnimConf paramPendantAnimConf) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if ((this.b.u != null) && (this.b.v != null))
    {
      this.b.u.setVisibility(4);
      this.b.v.setVisibility(0);
      paramAnimator = (AvatarPendantManager)this.b.y.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
      paramAnimator.c = -1L;
      BubbleNewAIOAnim localBubbleNewAIOAnim = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("show pendant, ");
      localStringBuilder.append(this.b.e);
      localBubbleNewAIOAnim.a(localStringBuilder.toString());
      paramAnimator.b();
    }
    if (this.b.t != null) {
      this.b.t.setVisibility(0);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if ((this.b.u != null) && (this.b.v != null))
    {
      this.b.u.setVisibility(0);
      this.b.v.setVisibility(4);
      paramAnimator = (AvatarPendantManager)this.b.y.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
      BubbleNewAIOAnim localBubbleNewAIOAnim = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stop show pendant, ");
      localStringBuilder.append(this.b.e);
      localBubbleNewAIOAnim.a(localStringBuilder.toString());
      paramAnimator.c = this.b.e;
      paramAnimator.a();
    }
    if ((this.b.t != null) && (TextUtils.isEmpty(this.a.m))) {
      this.b.t.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleNewAIOAnim.6
 * JD-Core Version:    0.7.0.1
 */