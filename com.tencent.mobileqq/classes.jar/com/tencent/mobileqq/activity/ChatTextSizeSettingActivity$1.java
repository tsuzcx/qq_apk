package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ChatTextSizeSettingActivity$1
  implements View.OnClickListener
{
  ChatTextSizeSettingActivity$1(ChatTextSizeSettingActivity paramChatTextSizeSettingActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131378596: 
    default: 
      this.a.a = 0;
      break;
    case 2131378598: 
      this.a.a = 1;
      break;
    case 2131378597: 
      this.a.a = 2;
      break;
    case 2131378595: 
      this.a.a = 3;
    }
    ChatTextSizeSettingActivity localChatTextSizeSettingActivity = this.a;
    localChatTextSizeSettingActivity.a(localChatTextSizeSettingActivity.a);
    ReportController.b(this.a.app, "CliOper", "", "", "Trends_tab", "Font_size", 0, 0, Integer.toString(this.a.a), "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatTextSizeSettingActivity.1
 * JD-Core Version:    0.7.0.1
 */