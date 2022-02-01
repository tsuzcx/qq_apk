package com.tencent.biz.qrcode.activity;

import android.view.View;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class QRDisplayActivity$12
  implements ActionSheet.OnButtonClickListener
{
  QRDisplayActivity$12(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (this.a.aM) {
      return;
    }
    paramView = this.a;
    paramView.aM = true;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if ((paramInt == 2) && (!paramView.g))
        {
          this.a.e();
          if ((this.a.L & 0x1) != 0) {
            ReportController.b(this.a.app, "P_CliOper", "flag1", "", "0X8004171", "0X8004171", 0, 0, "", "", "", "");
          }
          if (this.a.t == 2) {
            ReportController.b(this.a.app, "P_CliOper", "Grp_set", "", "Grp_data", "qr_save", 0, 0, this.a.n, "", "", String.valueOf(this.a.q));
          }
        }
      }
      else if (!paramView.g)
      {
        this.a.h();
        if ((this.a.L & 0x1) != 0) {
          ReportController.b(this.a.app, "P_CliOper", "flag1", "", "0X8004170", "0X8004170", 0, 0, "", "", "", "");
        }
      }
    }
    else if (!paramView.g)
    {
      this.a.g();
      if ((this.a.L & 0x1) != 0) {
        ReportController.b(this.a.app, "P_CliOper", "flag1", "", "0X800416E", "0X800416E", 0, 0, "", "", "", "");
      }
    }
    this.a.aL.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.12
 * JD-Core Version:    0.7.0.1
 */