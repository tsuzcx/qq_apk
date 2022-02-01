package com.tencent.biz.qrcode.activity;

import android.os.CountDownTimer;
import com.tencent.qphone.base.util.QLog;

class QRDisplayActivity$27
  extends CountDownTimer
{
  QRDisplayActivity$27(QRDisplayActivity paramQRDisplayActivity, long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish()
  {
    QRDisplayActivity.a(this.a, true);
    if (QRDisplayActivity.f(this.a) == null)
    {
      QRDisplayActivity.g(this.a);
      if (QLog.isColorLevel()) {
        QLog.d("QRDisplayActivity", 4, "enter longclick");
      }
    }
    else if (QRDisplayActivity.f(this.a) != null)
    {
      QRDisplayActivity.h(this.a);
      if (QLog.isColorLevel()) {
        QLog.d("QRDisplayActivity", 4, "enter longclickstop");
      }
    }
  }
  
  public void onTick(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.27
 * JD-Core Version:    0.7.0.1
 */