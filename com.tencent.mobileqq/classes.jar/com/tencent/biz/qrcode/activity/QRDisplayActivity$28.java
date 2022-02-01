package com.tencent.biz.qrcode.activity;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import zvc;

class QRDisplayActivity$28
  implements Runnable
{
  QRDisplayActivity$28(QRDisplayActivity paramQRDisplayActivity, String paramString1, int paramInt, String paramString2) {}
  
  public void run()
  {
    String str = zvc.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.this$0.b);
    ThreadManager.getUIHandler().post(new QRDisplayActivity.28.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.28
 * JD-Core Version:    0.7.0.1
 */