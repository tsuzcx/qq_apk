package com.tencent.biz.qrcode.activity;

import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class QRDisplayActivity$23
  implements Runnable
{
  QRDisplayActivity$23(QRDisplayActivity paramQRDisplayActivity, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (QRUtils.a(this.this$0.app, this.this$0.c) == 1) {}
    for (String str = this.a;; str = this.b)
    {
      str = QRUtils.a(this.this$0, str, this.this$0.b);
      ThreadManager.getUIHandler().post(new QRDisplayActivity.23.1(this, str));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.23
 * JD-Core Version:    0.7.0.1
 */