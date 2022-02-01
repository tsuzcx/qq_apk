package com.tencent.biz.pubaccount.accountdetail.api.impl;

import android.os.Bundle;
import com.tencent.biz.pubaccount.PublicAccountStQWebServletWrapper.PublicAccountStQCallback;
import com.tencent.biz.pubaccount.accountdetail.adapter.AccountDetailBaseAdapter;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.pb.oac.OACProfilePb.ProfileDataRsp;
import com.tencent.qphone.base.util.QLog;

class PublicAccountDetailActivityImpl$22
  implements PublicAccountStQWebServletWrapper.PublicAccountStQCallback<OACProfilePb.ProfileDataRsp>
{
  PublicAccountDetailActivityImpl$22(PublicAccountDetailActivityImpl paramPublicAccountDetailActivityImpl) {}
  
  public void a(int paramInt, boolean paramBoolean, OACProfilePb.ProfileDataRsp paramProfileDataRsp, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("success:");
      paramBundle.append(String.valueOf(paramBoolean));
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, paramBundle.toString());
    }
    paramBundle = this.a;
    paramBundle.waitingCount -= 1;
    if (this.a.waitingCount == 0) {
      this.a.removeLoading();
    }
    if (!paramBoolean)
    {
      if (this.a.isFirst)
      {
        if (this.a.mAccountDetailAdapter != null)
        {
          this.a.mAccountDetailAdapter.b(false);
          this.a.mAccountDetailAdapter.notifyDataSetChanged();
          return;
        }
        this.a.displayToast(2131892951);
      }
      return;
    }
    paramBundle = new PublicAccountDetailImpl(paramProfileDataRsp);
    ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).savePublicAccountMenuSetting(this.a.app, this.a.uin, paramProfileDataRsp.menu_rsp);
    this.a.updateDetailInfo(paramBundle, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.22
 * JD-Core Version:    0.7.0.1
 */