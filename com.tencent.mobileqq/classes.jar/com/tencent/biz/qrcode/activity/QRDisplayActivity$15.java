package com.tencent.biz.qrcode.activity;

import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.utils.TroopReportor;

class QRDisplayActivity$15
  implements Runnable
{
  QRDisplayActivity$15(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("temp_qrcode_share_");
    ((StringBuilder)localObject).append(this.this$0.n);
    ((StringBuilder)localObject).append(".png");
    localObject = ((StringBuilder)localObject).toString();
    try
    {
      localObject = QRUtils.a(this.this$0.getApplicationContext(), (String)localObject, this.this$0.k);
      this.this$0.runOnUiThread(new QRDisplayActivity.15.2(this, (String)localObject));
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label75:
      break label75;
    }
    if (this.this$0.t == 2) {
      TroopReportor.a("Grp_share", "grpData_admin", "qr_qzone", 0, 0, new String[] { this.this$0.n, String.valueOf(this.this$0.q), "1" });
    }
    this.this$0.runOnUiThread(new QRDisplayActivity.15.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.15
 * JD-Core Version:    0.7.0.1
 */