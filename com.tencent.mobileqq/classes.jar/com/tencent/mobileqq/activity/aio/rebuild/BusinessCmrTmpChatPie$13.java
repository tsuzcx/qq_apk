package com.tencent.mobileqq.activity.aio.rebuild;

import android.os.Bundle;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.GetEqqAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class BusinessCmrTmpChatPie$13
  implements BusinessObserver
{
  BusinessCmrTmpChatPie$13(BusinessCmrTmpChatPie paramBusinessCmrTmpChatPie) {}
  
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
      paramInt = ((mobileqq_mp.RetInfo)((mobileqq_mp.GetEqqAccountDetailInfoResponse)localObject).ret_info.get()).ret_code.get();
      if (paramInt == 0)
      {
        paramBundle = new EqqDetail((mobileqq_mp.GetEqqAccountDetailInfoResponse)localObject);
        CrmUtils.a(this.a.d, paramBundle);
        this.a.bV = PublicAccountInfo.createPublicAccount(paramBundle, 0L);
        BusinessCmrTmpChatPie.a(this.a, paramBundle);
        paramBundle = this.a;
        paramBundle.c(paramBundle.f.getIntent());
        return;
      }
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("showEqqLbsEnableDialog() get eqq detail ret code error: ");
        paramBundle.append(paramInt);
        QLog.d("BusinessChatPie", 2, paramBundle.toString());
        return;
        if (QLog.isColorLevel())
        {
          QLog.d("BusinessChatPie", 2, "showEqqLbsEnableDialog() get eqq detail data is null");
          return;
          if (QLog.isColorLevel()) {
            QLog.d("BusinessChatPie", 2, "showEqqLbsEnableDialog() get eqq detail isSuccess is null");
          }
        }
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramBundle) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie.13
 * JD-Core Version:    0.7.0.1
 */