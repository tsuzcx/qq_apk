package com.tencent.biz.qrcode.activity;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import wij;

class QRDisplayActivity$19
  implements Runnable
{
  QRDisplayActivity$19(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void run()
  {
    String str = "temp_qrcode_share_" + this.this$0.c + ".png";
    str = wij.a(this.this$0, str, this.this$0.b);
    ThreadManager.getUIHandler().post(new QRDisplayActivity.19.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.19
 * JD-Core Version:    0.7.0.1
 */