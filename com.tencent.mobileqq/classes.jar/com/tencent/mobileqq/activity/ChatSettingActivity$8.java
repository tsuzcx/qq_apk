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
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        if (!ChatSettingActivity.b(this.a)) {
          break;
        }
        if (this.a.e != null) {
          this.a.e.setVisibility(0);
        }
      } while (ChatSettingActivity.b(this.a) == null);
      ChatSettingActivity.b(this.a).setVisibility(0);
      return;
      if (this.a.e != null) {
        this.a.e.setVisibility(8);
      }
    } while (ChatSettingActivity.b(this.a) == null);
    ChatSettingActivity.b(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity.8
 * JD-Core Version:    0.7.0.1
 */