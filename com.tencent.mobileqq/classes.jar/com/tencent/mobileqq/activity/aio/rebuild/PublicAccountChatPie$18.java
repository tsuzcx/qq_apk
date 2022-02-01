package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class PublicAccountChatPie$18
  implements Animation.AnimationListener
{
  PublicAccountChatPie$18(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = this.a;
    paramAnimation.G = false;
    paramAnimation.P = false;
    paramAnimation.e(paramAnimation.g);
    this.a.i = 1;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.18
 * JD-Core Version:    0.7.0.1
 */