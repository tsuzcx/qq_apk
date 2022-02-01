package com.tencent.biz.qrcode.activity;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import yyi;

class QRDisplayActivity$29
  implements Runnable
{
  QRDisplayActivity$29(QRDisplayActivity paramQRDisplayActivity, String paramString1, int paramInt, String paramString2) {}
  
  public void run()
  {
    String str = yyi.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.this$0.b);
    ThreadManager.getUIHandler().post(new QRDisplayActivity.29.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.29
 * JD-Core Version:    0.7.0.1
 */