package com.tencent.biz.qrcode.activity;

import android.view.View;
import bfpm;
import yuv;

class QRDisplayActivity$23
  implements Runnable
{
  QRDisplayActivity$23(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void run()
  {
    yuv localyuv = new yuv(this.this$0.d, this.this$0);
    this.this$0.d.setAccessibilityDelegate(localyuv);
    bfpm.a(this.this$0.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.23
 * JD-Core Version:    0.7.0.1
 */