package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.statistics.ReportController;

class PublicAccountChatPie$23
  implements DialogInterface.OnDismissListener
{
  PublicAccountChatPie$23(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.ab = false;
    ReportController.b(this.a.a, "CliOper", "", "", "0X8004EFA", "0X8004EFA", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.23
 * JD-Core Version:    0.7.0.1
 */