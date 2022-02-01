package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxObserver;

class ChatSettingActivity$9
  extends TempMsgBoxObserver
{
  ChatSettingActivity$9(ChatSettingActivity paramChatSettingActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt != 1) {
      return;
    }
    if (ChatSettingActivity.k(this.a))
    {
      if (this.a.y != null) {
        this.a.y.setVisibility(0);
      }
      if (ChatSettingActivity.j(this.a) != null) {
        ChatSettingActivity.j(this.a).setVisibility(0);
      }
    }
    else
    {
      if (this.a.y != null) {
        this.a.y.setVisibility(8);
      }
      if (ChatSettingActivity.j(this.a) != null) {
        ChatSettingActivity.j(this.a).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity.9
 * JD-Core Version:    0.7.0.1
 */