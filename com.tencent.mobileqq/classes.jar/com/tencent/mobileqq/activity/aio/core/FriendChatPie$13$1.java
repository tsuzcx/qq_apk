package com.tencent.mobileqq.activity.aio.core;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;

class FriendChatPie$13$1
  implements Animation.AnimationListener
{
  FriendChatPie$13$1(FriendChatPie.13 param13) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a.a.m != null)
    {
      paramAnimation = AnimationUtils.loadAnimation(this.a.a.a, 2130772245);
      paramAnimation.setAnimationListener(this);
      this.a.a.m.startAnimation(paramAnimation);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.13.1
 * JD-Core Version:    0.7.0.1
 */