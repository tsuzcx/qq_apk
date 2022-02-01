package com.tencent.biz.eqq;

import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

final class CrmUtils$3
  implements BusinessObserver
{
  CrmUtils$3(Context paramContext, QQAppInterface paramQQAppInterface, QQProgressDialog paramQQProgressDialog, EqqDetail paramEqqDetail, SessionInfo paramSessionInfo, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("success:");
      ((StringBuilder)localObject).append(String.valueOf(paramBoolean));
      QLog.d("CrmUtils", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null) {
        localObject = new mobileqq_mp.FollowResponse();
      }
    }
    try
    {
      ((mobileqq_mp.FollowResponse)localObject).mergeFrom(paramBundle);
      paramInt = ((mobileqq_mp.RetInfo)((mobileqq_mp.FollowResponse)localObject).ret_info.get()).ret_code.get();
      if (paramInt == 0)
      {
        paramBundle = this.d;
        paramBundle.followType = 1;
        CrmUtils.a(this.b, paramBundle);
        paramBundle = (IPublicAccountHandler)this.b.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
        if (paramBundle != null) {
          paramBundle.onFollowPublicAccount(this.d);
        }
        if (QLog.isDevelopLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("<<<end follow, ts=");
          paramBundle.append(System.currentTimeMillis());
          QLog.d("IVR_TS_CrmUtils", 4, paramBundle.toString());
        }
        CrmUtils.b(this.b, this.a, this.e, this.f);
        EnterpriseQQManager.a(this.b).a(this.b, this.d.uin, true);
      }
      else if (paramInt == 58)
      {
        CrmUtils.a(this.a, 2131892946);
        ReportController.b(this.b, "CliOper", "", "", "0X80049DF", "PublicAccount_max_limit_false", 0, 0, "", "", "", "");
      }
      else if (paramInt == 65)
      {
        CrmUtils.a(this.a, 2131892918);
      }
      else if (paramInt == 20)
      {
        CrmUtils.a(this.a, 2131892919);
      }
      else
      {
        CrmUtils.a(this.a, 2131892951);
        ReportController.b(this.b, "CliOper", "", "", "0X80049DF", "AutoFollowFalse", 0, 0, "", "", "", "");
      }
    }
    catch (InvalidProtocolBufferMicroException paramBundle)
    {
      label346:
      break label346;
    }
    CrmUtils.a(this.a, 2131892951);
    ReportController.b(this.b, "CliOper", "", "", "0X80049DF", "AutoFollowFalse", 0, 0, "", "", "", "");
    CrmUtils.a(this.c);
    return;
    CrmUtils.a(this.a, 2131892951);
    ReportController.b(this.b, "CliOper", "", "", "0X80049DF", "AutoFollowFalse", 0, 0, "", "", "", "");
    break label465;
    CrmUtils.a(this.a, 2131892951);
    ReportController.b(this.b, "CliOper", "", "", "0X80049DF", "AutoFollowFalse", 0, 0, "", "", "", "");
    label465:
    CrmUtils.a(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.eqq.CrmUtils.3
 * JD-Core Version:    0.7.0.1
 */