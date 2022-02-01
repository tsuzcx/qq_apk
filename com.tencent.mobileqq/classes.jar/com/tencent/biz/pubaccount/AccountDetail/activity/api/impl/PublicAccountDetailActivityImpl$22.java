package com.tencent.biz.pubaccount.AccountDetail.activity.api.impl;

import android.os.Bundle;
import com.tencent.biz.pubaccount.AccountDetail.adapter.AccountDetailBaseAdapter;
import com.tencent.biz.pubaccount.PublicAccountStQWebServletWrapper.PublicAccountStQCallback;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.pb.oac.OACProfilePb.ProfileDataRsp;
import com.tencent.qphone.base.util.QLog;

class PublicAccountDetailActivityImpl$22
  implements PublicAccountStQWebServletWrapper.PublicAccountStQCallback<OACProfilePb.ProfileDataRsp>
{
  PublicAccountDetailActivityImpl$22(PublicAccountDetailActivityImpl paramPublicAccountDetailActivityImpl) {}
  
  public void a(int paramInt, boolean paramBoolean, OACProfilePb.ProfileDataRsp paramProfileDataRsp, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "success:" + String.valueOf(paramBoolean));
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
        }
      }
      else {
        return;
      }
      this.a.displayToast(2131695222);
      return;
    }
    paramBundle = new AccountDetail(paramProfileDataRsp);
    ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).savePublicAccountMenuSetting(this.a.app, this.a.uin, paramProfileDataRsp.menu_rsp);
    this.a.updateDetailInfo(paramBundle, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.PublicAccountDetailActivityImpl.22
 * JD-Core Version:    0.7.0.1
 */