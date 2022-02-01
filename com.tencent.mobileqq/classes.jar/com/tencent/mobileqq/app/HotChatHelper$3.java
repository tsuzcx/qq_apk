package com.tencent.mobileqq.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;

final class HotChatHelper$3
  implements DialogInterface.OnClickListener
{
  HotChatHelper$3(QQAppInterface paramQQAppInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ReportController.b(this.a, "CliOper", "", "", "0X8004C6C", "0X8004C6C", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotChatHelper.3
 * JD-Core Version:    0.7.0.1
 */