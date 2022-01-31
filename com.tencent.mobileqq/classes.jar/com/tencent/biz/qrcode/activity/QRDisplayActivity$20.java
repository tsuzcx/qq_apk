package com.tencent.biz.qrcode.activity;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import wim;

class QRDisplayActivity$20
  implements Runnable
{
  QRDisplayActivity$20(QRDisplayActivity paramQRDisplayActivity, String paramString) {}
  
  public void run()
  {
    String str = wim.a(this.this$0, this.a, this.this$0.b);
    ThreadManager.getUIHandler().post(new QRDisplayActivity.20.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.20
 * JD-Core Version:    0.7.0.1
 */