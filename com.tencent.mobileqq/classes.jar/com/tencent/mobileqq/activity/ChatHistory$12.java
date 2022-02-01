package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ChatHistory$12
  implements View.OnClickListener
{
  ChatHistory$12(ChatHistory paramChatHistory) {}
  
  public void onClick(View paramView)
  {
    this.a.m();
    ReportController.b(this.a.app, "CliOper", "", "", "0X800568E", "0X800568E", this.a.L, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.12
 * JD-Core Version:    0.7.0.1
 */