package com.tencent.biz.qrcode.activity;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import zyx;

class QRDisplayActivity$22
  implements Runnable
{
  QRDisplayActivity$22(QRDisplayActivity paramQRDisplayActivity, String paramString) {}
  
  public void run()
  {
    String str = zyx.a(this.this$0, this.a, this.this$0.b);
    ThreadManager.getUIHandler().post(new QRDisplayActivity.22.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.22
 * JD-Core Version:    0.7.0.1
 */