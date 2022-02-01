package com.tencent.biz.pubaccount;

import android.os.Bundle;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.pb.oac.OACProfilePb.ProfileDataRsp;

class AccountSettingFragment$2
  implements PublicAccountStQWebServletWrapper.PublicAccountStQCallback<OACProfilePb.ProfileDataRsp>
{
  AccountSettingFragment$2(AccountSettingFragment paramAccountSettingFragment) {}
  
  public void a(int paramInt, boolean paramBoolean, OACProfilePb.ProfileDataRsp paramProfileDataRsp, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      AccountSettingFragment.a(this.a, new AccountDetail(paramProfileDataRsp));
      AccountSettingFragment.a(this.a, AccountSettingFragment.a(this.a));
      AccountSettingFragment.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountSettingFragment.2
 * JD-Core Version:    0.7.0.1
 */