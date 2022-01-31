package com.tencent.biz.qrcode.activity;

import android.view.View;
import azve;
import vsk;

class QRDisplayActivity$21
  implements Runnable
{
  QRDisplayActivity$21(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void run()
  {
    vsk localvsk = new vsk(this.this$0.d, this.this$0);
    this.this$0.d.setAccessibilityDelegate(localvsk);
    azve.a(this.this$0.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.21
 * JD-Core Version:    0.7.0.1
 */