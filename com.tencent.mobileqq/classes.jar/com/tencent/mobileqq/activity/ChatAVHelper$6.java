package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.statistics.ReportController;

final class ChatAVHelper$6
  implements DialogInterface.OnCancelListener
{
  ChatAVHelper$6(ChatActivityUtils.VideoCheckFlag paramVideoCheckFlag, ChatActivityUtils.StartVideoListener paramStartVideoListener) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.a.e) {
      ReportController.b(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "3", "", "", "");
    }
    ChatActivityUtils.StartVideoListener localStartVideoListener = this.b;
    if (localStartVideoListener != null) {
      localStartVideoListener.a();
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatAVHelper.6
 * JD-Core Version:    0.7.0.1
 */