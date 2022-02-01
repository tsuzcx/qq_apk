package com.tencent.mobileqq.activity;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.qphone.base.util.QLog;

class ChatFragment$2
  implements Animation.AnimationListener
{
  ChatFragment$2(ChatFragment paramChatFragment) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    QLog.d("Q.aio.ChatFragment", 2, "AIO onAnimationEnd");
    this.a.b(1);
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    QLog.d("Q.aio.ChatFragment", 2, "AIO onAnimationRepeat");
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    QLog.d("Q.aio.ChatFragment", 2, "AIO onAnimationStart");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatFragment.2
 * JD-Core Version:    0.7.0.1
 */