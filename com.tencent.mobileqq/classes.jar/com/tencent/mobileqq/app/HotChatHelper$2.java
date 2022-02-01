package com.tencent.mobileqq.app;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;

final class HotChatHelper$2
  implements DialogInterface.OnClickListener
{
  HotChatHelper$2(Activity paramActivity, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    HotChatManager.a(this.a, false);
    ReportController.b(this.b, "CliOper", "", "", "0X8004C6B", "0X8004C6B", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotChatHelper.2
 * JD-Core Version:    0.7.0.1
 */