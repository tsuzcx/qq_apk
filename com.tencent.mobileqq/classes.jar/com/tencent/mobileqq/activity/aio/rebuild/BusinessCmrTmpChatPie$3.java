package com.tencent.mobileqq.activity.aio.rebuild;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.GetEqqAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;

class BusinessCmrTmpChatPie$3
  implements BusinessObserver
{
  BusinessCmrTmpChatPie$3(BusinessCmrTmpChatPie paramBusinessCmrTmpChatPie) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("success:");
      ((StringBuilder)localObject).append(String.valueOf(paramBoolean));
      QLog.d("BusinessChatPie", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null) {
        localObject = new mobileqq_mp.GetEqqAccountDetailInfoResponse();
      }
    }
    try
    {
      ((mobileqq_mp.GetEqqAccountDetailInfoResponse)localObject).mergeFrom(paramBundle);
      if (((mobileqq_mp.RetInfo)((mobileqq_mp.GetEqqAccountDetailInfoResponse)localObject).ret_info.get()).ret_code.get() == 0)
      {
        paramBundle = new EqqDetail((mobileqq_mp.GetEqqAccountDetailInfoResponse)localObject);
        ThreadManager.getFileThreadHandler().post(new BusinessCmrTmpChatPie.3.1(this, paramBundle));
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramBundle) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie.3
 * JD-Core Version:    0.7.0.1
 */