package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.util.Pair;
import java.util.ArrayList;

class AccountManageActivity$33
  extends MessageObserver
{
  AccountManageActivity$33(AccountManageActivity paramAccountManageActivity) {}
  
  public void onPushSubAccountMsg(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (this.a.isFinishing()) {
      return;
    }
    Object localObject = this.a;
    int i = 0;
    AccountManageActivity.a((AccountManageActivity)localObject, false);
    localObject = (ISubAccountControlService)this.a.app.getRuntimeService(ISubAccountControlService.class, null);
    if (paramSubAccountBackProtocData.a == 1)
    {
      if ((this.a.isResume()) && (((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).needShowHintDialog(this.a.app, "sub.uin.all")))
      {
        paramString = ((ISubAccountControlService)localObject).popWaittingHintPair("sub.uin.all");
        int j = paramString.size();
        while (i < j)
        {
          paramSubAccountBackProtocData = (Pair)paramString.get(i);
          ((ISubAccountControlService)localObject).showHintDialog(this.a.app, this.a, paramSubAccountBackProtocData, new AccountManageActivity.33.1(this, (ISubAccountControlService)localObject, paramSubAccountBackProtocData));
          i += 1;
        }
      }
    }
    else if (this.a.isResume()) {
      ((ISubAccountControlService)localObject).cancelHintDialog(paramString, 1, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.33
 * JD-Core Version:    0.7.0.1
 */