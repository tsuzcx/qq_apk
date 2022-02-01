package com.tencent.mobileqq.activity.aio.rebuild;

import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class PublicAccountChatPie$27
  implements BusinessObserver
{
  PublicAccountChatPie$27(PublicAccountChatPie paramPublicAccountChatPie, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.b.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("success:");
      localStringBuilder.append(String.valueOf(paramBoolean));
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (!paramBoolean) {
      this.b.t(2131892951);
    }
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null)
      {
        localObject = new mobileqq_mp.UnFollowResponse();
        ((mobileqq_mp.UnFollowResponse)localObject).mergeFrom(paramBundle);
        if (((mobileqq_mp.RetInfo)((mobileqq_mp.UnFollowResponse)localObject).ret_info.get()).ret_code.get() == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.b.c, 2, "unfollow success");
          }
          PublicAccountChatPie.a(this.b, PublicAccountChatPie.o(this.b));
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.b.d, "P_CliOper", "Pb_account_lifeservice", this.a, "0X8005A2D", "0X8005A2D", 0, 0, "", "", "", "", false);
          StructLongMessageDownloadProcessor.deleteTask(this.b.d, this.a);
          ((TroopBindPublicAccountMgr)this.b.d.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER)).a(this.b.ah.b);
          PublicAccountChatPie.b(this.b, false);
        }
        else
        {
          this.b.t(2131892951);
        }
      }
    }
    catch (Exception paramBundle)
    {
      label259:
      break label259;
    }
    PublicAccountChatPie.p(this.b);
    if (PublicAccountChatPie.q(this.b) == 0) {
      this.b.bz();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.27
 * JD-Core Version:    0.7.0.1
 */