package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;

class PublicAccountChatPie$31
  implements Animation.AnimationListener
{
  PublicAccountChatPie$31(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    PublicAccountChatPie.s(this.a).post(new PublicAccountChatPie.31.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.31
 * JD-Core Version:    0.7.0.1
 */