package com.tencent.mobileqq.activity.history;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;

class ChatHistoryC2CAllFragment$6
  implements View.OnClickListener
{
  ChatHistoryC2CAllFragment$6(ChatHistoryC2CAllFragment paramChatHistoryC2CAllFragment) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.d) {
      if (VersionUtils.e()) {
        this.a.startActivity(new Intent("android.settings.SETTINGS"));
      } else {
        this.a.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment.6
 * JD-Core Version:    0.7.0.1
 */