package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ChatHistory$7
  implements View.OnClickListener
{
  ChatHistory$7(ChatHistory paramChatHistory) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.a.J > 1000L)
    {
      ChatHistory localChatHistory = this.a;
      localChatHistory.J = l;
      localChatHistory.c();
      ReportController.b(this.a.app, "CliOper", "", "", "0X800568D", "0X800568D", this.a.L, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.7
 * JD-Core Version:    0.7.0.1
 */