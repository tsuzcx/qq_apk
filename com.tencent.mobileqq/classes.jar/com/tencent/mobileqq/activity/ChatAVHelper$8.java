package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;

final class ChatAVHelper$8
  implements DialogInterface.OnClickListener
{
  ChatAVHelper$8(ChatActivityUtils.VideoCheckFlag paramVideoCheckFlag, ChatActivityUtils.StartVideoListener paramStartVideoListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.e) {
      ReportController.b(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "2", "", "", "");
    }
    ChatActivityUtils.StartVideoListener localStartVideoListener = this.b;
    if (localStartVideoListener != null) {
      localStartVideoListener.a();
    }
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatAVHelper.8
 * JD-Core Version:    0.7.0.1
 */