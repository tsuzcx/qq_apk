package com.tencent.biz.qrcode.activity;

import android.content.Context;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class QRDisplayActivity$24
  implements Runnable
{
  QRDisplayActivity$24(QRDisplayActivity paramQRDisplayActivity, String paramString) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    localObject = QRUtils.a((Context)localObject, this.a, ((QRDisplayActivity)localObject).k);
    ThreadManager.getUIHandler().post(new QRDisplayActivity.24.1(this, (String)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.24
 * JD-Core Version:    0.7.0.1
 */