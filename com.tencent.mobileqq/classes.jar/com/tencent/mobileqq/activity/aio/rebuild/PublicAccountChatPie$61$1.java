package com.tencent.mobileqq.activity.aio.rebuild;

import android.os.Bundle;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.SendMenuEventResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class PublicAccountChatPie$61$1
  implements BusinessObserver
{
  PublicAccountChatPie$61$1(PublicAccountChatPie.61 param61) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.a.a.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestQidiKefu ... onReceive = ");
      localStringBuilder.append(paramBoolean);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (paramBoolean) {}
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      localObject = new mobileqq_mp.SendMenuEventResponse();
      ((mobileqq_mp.SendMenuEventResponse)localObject).mergeFrom(paramBundle);
      paramInt = ((mobileqq_mp.SendMenuEventResponse)localObject).ret_info.ret_code.get();
      if (QLog.isColorLevel())
      {
        paramBundle = this.a.a.c;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("requestQidiKefu ... onReceive: retCode = ");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d(paramBundle, 2, ((StringBuilder)localObject).toString());
      }
      if (paramInt == 0)
      {
        this.a.a.cD = true;
        this.a.a.bS();
        this.a.a.bz();
        return;
      }
    }
    catch (Exception paramBundle)
    {
      label179:
      break label179;
    }
    this.a.a.t(2131892951);
    this.a.a.bz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.61.1
 * JD-Core Version:    0.7.0.1
 */