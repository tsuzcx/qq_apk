package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class ChatHistory$5
  implements Animation.AnimationListener
{
  ChatHistory$5(ChatHistory paramChatHistory, View paramView, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.offsetTopAndBottom(this.b);
    this.a.requestLayout();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.5
 * JD-Core Version:    0.7.0.1
 */