package com.tencent.biz.pubaccount.util.api.impl;

import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse;

final class PublicAccountUtilImpl$9
  implements BusinessObserver
{
  PublicAccountUtilImpl$9(Context paramContext, AppInterface paramAppInterface, int paramInt, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("success:");
      ((StringBuilder)localObject).append(String.valueOf(paramBoolean));
      QLog.d("PublicAccountUtil", 2, ((StringBuilder)localObject).toString());
    }
    if (!paramBoolean)
    {
      PublicAccountUtilImpl.access$300(this.a, 2131892951);
      return;
    }
    try
    {
      localObject = paramBundle.getByteArray("data");
      paramInt = paramBundle.getInt("type", 0);
      if (localObject != null)
      {
        paramBundle = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
        oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse localGetPublicAccountDetailInfoResponse = new oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse();
        if (paramInt == 0)
        {
          paramBundle.mergeFrom((byte[])localObject);
          paramBoolean = true;
        }
        else
        {
          paramBoolean = PublicAccountUtilImpl.convert0xcf8ToMobileMP((byte[])localObject, localGetPublicAccountDetailInfoResponse, paramBundle);
        }
        if (paramBoolean)
        {
          if ((paramBundle.ret_info.has()) && (((mobileqq_mp.RetInfo)paramBundle.ret_info.get()).ret_code.has()) && (((mobileqq_mp.RetInfo)paramBundle.ret_info.get()).ret_code.get() == 0))
          {
            ThreadManager.getSubThreadHandler().postDelayed(new PublicAccountUtilImpl.9.1(this, paramBundle), 10L);
            return;
          }
          PublicAccountUtilImpl.access$300(this.a, 2131892951);
          return;
        }
        PublicAccountUtilImpl.access$300(this.a, 2131892951);
        return;
      }
      PublicAccountUtilImpl.access$300(this.a, 2131892951);
      return;
    }
    catch (Exception paramBundle) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.9
 * JD-Core Version:    0.7.0.1
 */