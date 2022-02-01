package com.tencent.biz.pubaccount;

import android.os.Bundle;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.pb.oac.OACProfilePb.ProfileDataRsp;

class AccountSettingFragment$2
  implements PublicAccountStQWebServletWrapper.PublicAccountStQCallback<OACProfilePb.ProfileDataRsp>
{
  AccountSettingFragment$2(AccountSettingFragment paramAccountSettingFragment) {}
  
  public void a(int paramInt, boolean paramBoolean, OACProfilePb.ProfileDataRsp paramProfileDataRsp, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      AccountSettingFragment.a(this.a, new PublicAccountDetailImpl(paramProfileDataRsp));
      paramProfileDataRsp = this.a;
      AccountSettingFragment.b(paramProfileDataRsp, AccountSettingFragment.b(paramProfileDataRsp));
      AccountSettingFragment.c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountSettingFragment.2
 * JD-Core Version:    0.7.0.1
 */