package com.tencent.biz.qrcode.activity;

import android.view.View;
import com.tencent.biz.qrcode.ipc.QrImageScan.FileDecodeListener;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class ScannerActivity$1
  implements QrImageScan.FileDecodeListener
{
  ScannerActivity$1(ScannerActivity paramScannerActivity) {}
  
  public void a(int paramInt)
  {
    if (this.a.isFinishing()) {
      return;
    }
    this.a.a.d = false;
    ScannerActivity.a(this.a).setVisibility(8);
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.a, 230);
    if (paramInt == 2) {
      localQQCustomDialog.setMessage(2131718692);
    }
    for (;;)
    {
      ScannerActivity.1.1 local1 = new ScannerActivity.1.1(this);
      localQQCustomDialog.setPositiveButton(2131694615, local1);
      localQQCustomDialog.setOnCancelListener(local1);
      localQQCustomDialog.show();
      return;
      localQQCustomDialog.setMessage(2131718702);
    }
  }
  
  public void a(ScannerResult paramScannerResult, int paramInt)
  {
    if (this.a.isFinishing()) {
      return;
    }
    this.a.a.d = false;
    ScannerActivity.a(this.a, paramScannerResult, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.ScannerActivity.1
 * JD-Core Version:    0.7.0.1
 */