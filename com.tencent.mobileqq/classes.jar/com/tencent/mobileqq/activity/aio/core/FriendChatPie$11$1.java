package com.tencent.mobileqq.activity.aio.core;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;

class FriendChatPie$11$1
  implements Animation.AnimationListener
{
  FriendChatPie$11$1(FriendChatPie.11 param11) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a.a.g != null)
    {
      paramAnimation = AnimationUtils.loadAnimation(this.a.a.a, 2130772273);
      paramAnimation.setAnimationListener(this);
      this.a.a.g.startAnimation(paramAnimation);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.11.1
 * JD-Core Version:    0.7.0.1
 */