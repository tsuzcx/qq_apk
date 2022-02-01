package com.tencent.av.service;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qcall.QCallCardHandler.OnGetQCallCardListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class QQServiceForAV$2
  implements QCallCardHandler.OnGetQCallCardListener
{
  QQServiceForAV$2(QQServiceForAV paramQQServiceForAV) {}
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "onGetQCallNickName");
    }
    new QavWrapper(((QQAppInterface)this.a.a()).getApp().getApplicationContext()).a(new QQServiceForAV.2.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.service.QQServiceForAV.2
 * JD-Core Version:    0.7.0.1
 */