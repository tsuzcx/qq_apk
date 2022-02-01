package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.TroopNotifyHelper.OnTroopSafeDialogClickConfirm;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.widget.QQProgressDialog;

class TroopInviteStatusFragment$7
  implements TroopNotifyHelper.OnTroopSafeDialogClickConfirm
{
  TroopInviteStatusFragment$7(TroopInviteStatusFragment paramTroopInviteStatusFragment) {}
  
  public void a(Object... paramVarArgs)
  {
    ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).requestTroopPrivilege(this.a.l, this.a.m, this.a.n, null, this.a.G);
    if (this.a.x != null)
    {
      this.a.x.c(2131916272);
      this.a.x.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInviteStatusFragment.7
 * JD-Core Version:    0.7.0.1
 */