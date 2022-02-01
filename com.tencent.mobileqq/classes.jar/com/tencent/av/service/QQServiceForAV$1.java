package com.tencent.av.service;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class QQServiceForAV$1
  implements DecodeTaskCompletionListener
{
  QQServiceForAV$1(QQServiceForAV paramQQServiceForAV) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "onDecodeTaskCompleted");
    }
    new QavWrapper(((QQAppInterface)this.a.a()).getApp().getApplicationContext()).a(new QQServiceForAV.1.1(this, paramString, paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.service.QQServiceForAV.1
 * JD-Core Version:    0.7.0.1
 */