package com.tencent.biz.qrcode.activity;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import znl;

class QRDisplayActivity$31
  implements Runnable
{
  QRDisplayActivity$31(QRDisplayActivity paramQRDisplayActivity, String paramString1, int paramInt, String paramString2) {}
  
  public void run()
  {
    String str = znl.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.this$0.b);
    ThreadManager.getUIHandler().post(new QRDisplayActivity.31.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.31
 * JD-Core Version:    0.7.0.1
 */