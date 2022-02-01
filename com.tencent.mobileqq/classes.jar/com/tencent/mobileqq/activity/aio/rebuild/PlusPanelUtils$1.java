package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet.OnDismissListener;

final class PlusPanelUtils$1
  implements ActionSheet.OnDismissListener
{
  PlusPanelUtils$1(QQAppInterface paramQQAppInterface) {}
  
  public void onDismiss()
  {
    ReportController.b(this.a, "CliOper", "", "", "0X8004862", "0X8004862", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils.1
 * JD-Core Version:    0.7.0.1
 */