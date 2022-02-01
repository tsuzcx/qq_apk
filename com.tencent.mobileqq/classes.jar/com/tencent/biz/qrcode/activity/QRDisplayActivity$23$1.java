package com.tencent.biz.qrcode.activity;

import android.text.TextUtils;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.mobileqq.wxapi.WXShareHelper;

class QRDisplayActivity$23$1
  implements Runnable
{
  QRDisplayActivity$23$1(QRDisplayActivity.23 param23, String paramString) {}
  
  public void run()
  {
    if (this.b.this$0.isFinishing()) {
      return;
    }
    if (TextUtils.isEmpty(this.a))
    {
      QRUtils.a(1, 2131894251);
      if (this.b.this$0.t == 2)
      {
        String str;
        if (this.b.this$0.aN == 2) {
          str = "qr_wechat";
        } else {
          str = "qr_circle";
        }
        TroopReportor.a("Grp_share", "grpData_admin", str, 0, 0, new String[] { this.b.this$0.n, String.valueOf(this.b.this$0.q), "1" });
      }
      return;
    }
    if (this.b.this$0.aN == 2)
    {
      WXShareHelper.a().a(this.a, this.b.this$0.k, 0);
      if (this.b.this$0.t == 2)
      {
        ReportController.b(this.b.this$0.app, "P_CliOper", "Grp_set", "", "Grp_data", "qr_wechat", 0, 0, this.b.this$0.n, "", String.valueOf(this.b.this$0.q), "");
        return;
      }
      if (this.b.this$0.t == 5) {
        ReportController.b(this.b.this$0.app, "CliOper", "", "", "0X8006676", "0X8006676", 0, 0, "", "", "", "");
      }
    }
    else
    {
      WXShareHelper.a().a(this.a, this.b.this$0.k, 1);
      if (this.b.this$0.t == 2)
      {
        ReportController.b(this.b.this$0.app, "P_CliOper", "Grp_set", "", "Grp_data", "qr_circle", 0, 0, this.b.this$0.n, "", String.valueOf(this.b.this$0.q), "");
        return;
      }
      if (this.b.this$0.t == 5) {
        ReportController.b(this.b.this$0.app, "CliOper", "", "", "0X8006677", "0X8006677", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.23.1
 * JD-Core Version:    0.7.0.1
 */