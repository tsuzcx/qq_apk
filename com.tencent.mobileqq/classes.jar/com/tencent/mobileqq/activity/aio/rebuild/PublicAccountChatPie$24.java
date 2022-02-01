package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.statistics.ReportController;

class PublicAccountChatPie$24
  implements DialogInterface.OnDismissListener
{
  PublicAccountChatPie$24(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.a;
    paramDialogInterface.cj = false;
    ReportController.b(paramDialogInterface.d, "CliOper", "", "", "0X8004EFA", "0X8004EFA", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.24
 * JD-Core Version:    0.7.0.1
 */