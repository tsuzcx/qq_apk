package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxObserver;

class ChatSettingActivity$8
  extends TempMsgBoxObserver
{
  ChatSettingActivity$8(ChatSettingActivity paramChatSettingActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt != 1) {
      return;
    }
    if (ChatSettingActivity.b(this.a))
    {
      if (this.a.e != null) {
        this.a.e.setVisibility(0);
      }
      if (ChatSettingActivity.b(this.a) != null) {
        ChatSettingActivity.b(this.a).setVisibility(0);
      }
    }
    else
    {
      if (this.a.e != null) {
        this.a.e.setVisibility(8);
      }
      if (ChatSettingActivity.b(this.a) != null) {
        ChatSettingActivity.b(this.a).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity.8
 * JD-Core Version:    0.7.0.1
 */