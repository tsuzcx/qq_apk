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
    if (this.a.a.bm != null)
    {
      paramAnimation = AnimationUtils.loadAnimation(this.a.a.e, 2130772359);
      paramAnimation.setAnimationListener(this);
      this.a.a.bm.startAnimation(paramAnimation);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.11.1
 * JD-Core Version:    0.7.0.1
 */