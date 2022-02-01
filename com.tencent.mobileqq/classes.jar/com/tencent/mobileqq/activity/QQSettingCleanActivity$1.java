package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

class QQSettingCleanActivity$1
  implements DialogInterface.OnClickListener
{
  QQSettingCleanActivity$1(QQSettingCleanActivity paramQQSettingCleanActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(this.a.app, "dc00898", "", "", "0X8007915", "0X8007915", 0, 0, this.a.app.getCurrentAccountUin(), "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingCleanActivity.1
 * JD-Core Version:    0.7.0.1
 */