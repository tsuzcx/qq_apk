package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ChatHistory$3
  implements View.OnClickListener
{
  ChatHistory$3(ChatHistory paramChatHistory) {}
  
  public void onClick(View paramView)
  {
    this.a.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.3
 * JD-Core Version:    0.7.0.1
 */