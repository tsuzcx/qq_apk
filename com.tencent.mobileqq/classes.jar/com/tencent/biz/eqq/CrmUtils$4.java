package com.tencent.biz.eqq;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

final class CrmUtils$4
  implements ActionSheet.OnButtonClickListener
{
  CrmUtils$4(ActionSheet paramActionSheet, QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo) {}
  
  public void onClick(View paramView, int paramInt)
  {
    this.a.dismiss();
    if (paramInt != 0) {
      return;
    }
    ReportController.b(this.b, "CliOper", "", "", "0X8004655", "0X8004655", 0, 0, "", "", "", "");
    try
    {
      CrmUtils.a(this.b, this.c, this.d, "IvrAIOMessageEngineFalse");
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("CrmUtils", 2, "Start ivr audio error", paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.eqq.CrmUtils.4
 * JD-Core Version:    0.7.0.1
 */