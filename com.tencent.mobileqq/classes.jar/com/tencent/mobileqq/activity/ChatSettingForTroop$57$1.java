package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class ChatSettingForTroop$57$1
  implements DialogInterface.OnClickListener
{
  ChatSettingForTroop$57$1(ChatSettingForTroop.57 param57) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      this.a.this$0.a.cancel();
      return;
    }
    try
    {
      ForwardSdkShareOption.a(this.a.this$0, true, "action_game_join_group", Long.valueOf(this.a.this$0.d).longValue(), -1, this.a.a);
      this.a.this$0.a.cancel();
      this.a.this$0.finish();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      for (;;)
      {
        QLog.e("Q.chatopttroop", 1, "showAlertDlg error = " + paramDialogInterface);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.57.1
 * JD-Core Version:    0.7.0.1
 */