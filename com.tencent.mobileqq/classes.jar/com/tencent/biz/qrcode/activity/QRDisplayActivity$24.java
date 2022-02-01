package com.tencent.biz.qrcode.activity;

import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class QRDisplayActivity$24
  implements Runnable
{
  QRDisplayActivity$24(QRDisplayActivity paramQRDisplayActivity, String paramString) {}
  
  public void run()
  {
    String str = QRUtils.a(this.this$0, this.a, this.this$0.b);
    ThreadManager.getUIHandler().post(new QRDisplayActivity.24.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.24
 * JD-Core Version:    0.7.0.1
 */