package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.messagesearch.MessageSearchDialog;

class ChatHistory$4
  implements Animation.AnimationListener
{
  ChatHistory$4(ChatHistory paramChatHistory, View paramView1, View paramView2) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.c.I.show();
    this.a.setAnimation(null);
    this.b.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.4
 * JD-Core Version:    0.7.0.1
 */