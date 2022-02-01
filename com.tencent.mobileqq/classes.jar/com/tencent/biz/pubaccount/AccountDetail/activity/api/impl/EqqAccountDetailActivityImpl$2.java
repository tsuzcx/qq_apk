package com.tencent.biz.pubaccount.AccountDetail.activity.api.impl;

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
    if (QLog.isColorLevel()) {
      QLog.d(this.a.TAG, 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean) {
      if (!this.a.isFirst) {
        this.a.displayToast(2131695222);
      }
    }
    for (;;)
    {
      paramBundle = this.a;
      paramBundle.waitingCount -= 1;
      if (this.a.waitingCount == 0) {
        this.a.removeLoading();
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("crmtest", 4, "receive sendCrmDetailInfoRequest, ts=" + System.currentTimeMillis());
      }
      return;
      if (paramBoolean) {}
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          mobileqq_mp.GetEqqAccountDetailInfoResponse localGetEqqAccountDetailInfoResponse = new mobileqq_mp.GetEqqAccountDetailInfoResponse();
          localGetEqqAccountDetailInfoResponse.mergeFrom(paramBundle);
          if (((mobileqq_mp.RetInfo)localGetEqqAccountDetailInfoResponse.ret_info.get()).ret_code.get() == 0)
          {
            if ((this.a.eqqDetail == null) || ((localGetEqqAccountDetailInfoResponse.seqno.has()) && (localGetEqqAccountDetailInfoResponse.seqno.get() != this.a.eqqDetail.seqno)))
            {
              this.a.gEqqData = localGetEqqAccountDetailInfoResponse;
              paramBundle = new EqqDetail(this.a.gEqqData);
              if ((this.a.mIsSendMessage) && (paramBundle.followType == 1))
              {
                this.a.updateDetailInfo(paramBundle, false);
                continue;
              }
              this.a.updateDetailInfo(paramBundle, true);
              continue;
            }
            if ((!this.a.mIsSendMessage) || (this.a.eqqDetail.followType != 1)) {
              continue;
            }
            this.a.gotoChatActivity();
            continue;
          }
          this.a.displayToast(2131695222);
          continue;
        }
        if (this.a.isFirst) {
          continue;
        }
        this.a.displayToast(2131695222);
      }
      catch (Exception paramBundle) {}
      if (!this.a.isFirst) {
        this.a.displayToast(2131695222);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.EqqAccountDetailActivityImpl.2
 * JD-Core Version:    0.7.0.1
 */