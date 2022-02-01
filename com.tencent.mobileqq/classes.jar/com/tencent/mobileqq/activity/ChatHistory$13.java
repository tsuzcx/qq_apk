package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ChatHistory$13
  implements View.OnClickListener
{
  ChatHistory$13(ChatHistory paramChatHistory) {}
  
  public void onClick(View paramView)
  {
    this.a.a(12, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.13
 * JD-Core Version:    0.7.0.1
 */