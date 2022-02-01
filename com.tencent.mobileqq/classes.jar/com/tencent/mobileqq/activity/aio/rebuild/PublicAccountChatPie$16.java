package com.tencent.mobileqq.activity.aio.rebuild;

import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;

class PublicAccountChatPie$16
  implements Animation.AnimationListener
{
  PublicAccountChatPie$16(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = this.a;
    paramAnimation.by = 5;
    PublicAccountChatPie.m(paramAnimation).post(new PublicAccountChatPie.16.1(this));
    this.a.ce.sendEmptyMessage(1);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.16
 * JD-Core Version:    0.7.0.1
 */