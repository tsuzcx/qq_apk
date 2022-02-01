package com.tencent.biz.pubaccount.accountdetail.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.GetEqqAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class EqqAccountDetailActivityImpl$2
  implements BusinessObserver
{
  EqqAccountDetailActivityImpl$2(EqqAccountDetailActivityImpl paramEqqAccountDetailActivityImpl) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.a.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("success:");
      localStringBuilder.append(String.valueOf(paramBoolean));
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (!paramBoolean)
    {
      if (!this.a.isFirst) {
        this.a.displayToast(2131695217);
      }
    }
    else if (!paramBoolean) {}
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null)
      {
        localObject = new mobileqq_mp.GetEqqAccountDetailInfoResponse();
        ((mobileqq_mp.GetEqqAccountDetailInfoResponse)localObject).mergeFrom(paramBundle);
        if (((mobileqq_mp.RetInfo)((mobileqq_mp.GetEqqAccountDetailInfoResponse)localObject).ret_info.get()).ret_code.get() == 0)
        {
          if ((this.a.eqqDetail != null) && ((!((mobileqq_mp.GetEqqAccountDetailInfoResponse)localObject).seqno.has()) || (((mobileqq_mp.GetEqqAccountDetailInfoResponse)localObject).seqno.get() == this.a.eqqDetail.seqno)))
          {
            if ((this.a.mIsSendMessage) && (this.a.eqqDetail.followType == 1)) {
              this.a.gotoChatActivity();
            }
          }
          else
          {
            this.a.gEqqData = ((mobileqq_mp.GetEqqAccountDetailInfoResponse)localObject);
            paramBundle = new EqqDetail(this.a.gEqqData);
            if ((this.a.mIsSendMessage) && (paramBundle.followType == 1)) {
              this.a.updateDetailInfo(paramBundle, false);
            } else {
              this.a.updateDetailInfo(paramBundle, true);
            }
          }
        }
        else {
          this.a.displayToast(2131695217);
        }
      }
      else if (!this.a.isFirst)
      {
        this.a.displayToast(2131695217);
      }
    }
    catch (Exception paramBundle)
    {
      break label331;
    }
    if (!this.a.isFirst) {
      this.a.displayToast(2131695217);
    }
    label331:
    paramBundle = this.a;
    paramBundle.waitingCount -= 1;
    if (this.a.waitingCount == 0) {
      this.a.removeLoading();
    }
    if (QLog.isDevelopLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("receive sendCrmDetailInfoRequest, ts=");
      paramBundle.append(System.currentTimeMillis());
      QLog.d("crmtest", 4, paramBundle.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.EqqAccountDetailActivityImpl.2
 * JD-Core Version:    0.7.0.1
 */