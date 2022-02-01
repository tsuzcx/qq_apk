package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ChatSettingActivity$27
  implements DialogInterface.OnClickListener
{
  ChatSettingActivity$27(ChatSettingActivity paramChatSettingActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.finish();
    if ((ChatSettingActivity.x(this.a) != null) && (ChatSettingActivity.x(this.a).isShowing())) {
      ChatSettingActivity.x(this.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity.27
 * JD-Core Version:    0.7.0.1
 */