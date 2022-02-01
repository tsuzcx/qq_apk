package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

final class ChatAVHelper$7
  implements DialogInterface.OnClickListener
{
  ChatAVHelper$7(QQAppInterface paramQQAppInterface, ChatActivityUtils.VideoCheckFlag paramVideoCheckFlag, long paramLong, Context paramContext, ChatActivityUtils.StartVideoListener paramStartVideoListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ChatActivityUtils.a(this.a, null, this.b.a, this.b.b, this.b.d, true);
    if (this.b.e) {
      ReportController.b(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "1", "", "", "");
    }
    ChatActivityUtils.VideoCheckFlag localVideoCheckFlag = this.b;
    localVideoCheckFlag.g = false;
    localVideoCheckFlag.h = true;
    localVideoCheckFlag.l = false;
    ChatActivityUtils.a(this.c, this.a, this.d, this.e, localVideoCheckFlag);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatAVHelper.7
 * JD-Core Version:    0.7.0.1
 */