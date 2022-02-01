package com.tencent.biz.qrcode.activity;

import android.view.View;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.qid.QidCardManager;
import com.tencent.mobileqq.vas.qid.QidCardManager.QidCardReport;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class QRDisplayActivity$28
  implements ActionSheet.OnButtonClickListener
{
  QRDisplayActivity$28(QRDisplayActivity paramQRDisplayActivity, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    paramInt = paramView.getId();
    if (paramInt != 7)
    {
      if (paramInt != 8)
      {
        if (paramInt == 10)
        {
          QidCardManager.QidCardReport.b("0X800B974");
          QidCardManager.a(this.b.app, this.b, 1);
        }
      }
      else
      {
        this.b.b(8);
        ReportController.b(this.b.app, "CliOper", "", "", "0X800AEB7", "0X800AEB7", 0, 0, "", "", "", "");
      }
    }
    else
    {
      ReportController.b(this.b.app, "CliOper", "", "", "0X800AEB6", "0X800AEB6", 0, 0, "", "", "", "");
      this.b.b(7);
    }
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.28
 * JD-Core Version:    0.7.0.1
 */