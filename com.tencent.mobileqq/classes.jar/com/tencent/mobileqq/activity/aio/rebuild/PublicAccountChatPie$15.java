package com.tencent.mobileqq.activity.aio.rebuild;

import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;

class PublicAccountChatPie$15
  implements Animation.AnimationListener
{
  PublicAccountChatPie$15(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.n = 5;
    PublicAccountChatPie.c(this.a).post(new PublicAccountChatPie.15.1(this));
    this.a.a.sendEmptyMessage(1);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.15
 * JD-Core Version:    0.7.0.1
 */