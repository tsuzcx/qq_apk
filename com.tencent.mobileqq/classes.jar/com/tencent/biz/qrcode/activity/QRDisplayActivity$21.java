package com.tencent.biz.qrcode.activity;

import android.view.View;
import baww;
import wfd;

class QRDisplayActivity$21
  implements Runnable
{
  QRDisplayActivity$21(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void run()
  {
    wfd localwfd = new wfd(this.this$0.d, this.this$0);
    this.this$0.d.setAccessibilityDelegate(localwfd);
    baww.a(this.this$0.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.21
 * JD-Core Version:    0.7.0.1
 */