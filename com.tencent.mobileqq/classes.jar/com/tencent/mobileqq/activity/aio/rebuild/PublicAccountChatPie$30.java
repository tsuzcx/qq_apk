package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;

class PublicAccountChatPie$30
  implements Animation.AnimationListener
{
  PublicAccountChatPie$30(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    PublicAccountChatPie.d(this.a).post(new PublicAccountChatPie.30.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.30
 * JD-Core Version:    0.7.0.1
 */