package com.tencent.biz.pubaccount.util.api.impl;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;

class PublicAccountUtilImpl$10
  implements BusinessObserver
{
  PublicAccountUtilImpl$10(PublicAccountUtilImpl paramPublicAccountUtilImpl, AppInterface paramAppInterface) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("success:");
      localStringBuilder.append(String.valueOf(paramBoolean));
      QLog.d("PublicAccountUtil", 2, localStringBuilder.toString());
    }
    ThreadManager.getSubThreadHandler().postDelayed(new PublicAccountUtilImpl.10.1(this, paramBoolean, paramBundle), 10L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.10
 * JD-Core Version:    0.7.0.1
 */