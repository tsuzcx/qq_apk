package com.tencent.biz.pubaccount.util.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;

class PublicAccountUtilImpl$10
  implements BusinessObserver
{
  PublicAccountUtilImpl$10(PublicAccountUtilImpl paramPublicAccountUtilImpl, QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountUtil", 2, "success:" + String.valueOf(paramBoolean));
    }
    ThreadManager.getSubThreadHandler().postDelayed(new PublicAccountUtilImpl.10.1(this, paramBoolean, paramBundle), 10L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.10
 * JD-Core Version:    0.7.0.1
 */