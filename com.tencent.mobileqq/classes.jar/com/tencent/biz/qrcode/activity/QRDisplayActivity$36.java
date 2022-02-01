package com.tencent.biz.qrcode.activity;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class QRDisplayActivity$36
  implements BusinessObserver
{
  QRDisplayActivity$36(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    ThreadManager.getUIHandler().post(new QRDisplayActivity.36.1(this, paramBoolean, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.36
 * JD-Core Version:    0.7.0.1
 */