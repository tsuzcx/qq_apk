package com.tencent.mobileqq.activity.aio.rebuild;

import android.os.Bundle;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class PublicAccountChatPie$45
  implements BusinessObserver
{
  PublicAccountChatPie$45(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.a.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("success:");
      localStringBuilder.append(String.valueOf(paramBoolean));
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    bool2 = true;
    if (!paramBoolean)
    {
      this.a.m(2131695217);
      bool1 = bool2;
    }
    else
    {
      bool1 = bool2;
      if (!paramBoolean) {}
    }
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      bool1 = bool2;
      if (paramBundle != null)
      {
        localObject = new mobileqq_mp.FollowResponse();
        ((mobileqq_mp.FollowResponse)localObject).mergeFrom(paramBundle);
        paramInt = ((mobileqq_mp.RetInfo)((mobileqq_mp.FollowResponse)localObject).ret_info.get()).ret_code.get();
        bool1 = PublicAccountChatPie.a(this.a, true, paramInt);
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        bool1 = bool2;
      }
    }
    if (bool1) {
      this.a.ao();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.45
 * JD-Core Version:    0.7.0.1
 */