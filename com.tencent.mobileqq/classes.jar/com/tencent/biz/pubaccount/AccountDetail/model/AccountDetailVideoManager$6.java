package com.tencent.biz.pubaccount.accountdetail.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class AccountDetailVideoManager$6
  extends BroadcastReceiver
{
  AccountDetailVideoManager$6(AccountDetailVideoManager paramAccountDetailVideoManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onReceive ===>");
      paramIntent.append(paramContext);
      QLog.d("AccountDetailVideoManager", 2, paramIntent.toString());
    }
    if (("android.intent.action.SCREEN_OFF".equals(paramContext)) || ("tencent.av.v2q.StartVideoChat".equals(paramContext))) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.model.AccountDetailVideoManager.6
 * JD-Core Version:    0.7.0.1
 */