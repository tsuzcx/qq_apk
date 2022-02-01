package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class PublicAccountChatPie$17
  implements Animation.AnimationListener
{
  PublicAccountChatPie$17(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = this.a;
    paramAnimation.G = false;
    paramAnimation.i = 0;
    paramAnimation.H = false;
    paramAnimation.Q = false;
    paramAnimation.P = false;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    paramAnimation = this.a;
    paramAnimation.a(paramAnimation.g, PublicAccountChatPie.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.17
 * JD-Core Version:    0.7.0.1
 */