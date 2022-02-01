package com.tencent.mobileqq.app.identity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class AccountPhoneUnityManager$PhoneUnityReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    QLog.d("AccountPhoneUnityManager", 1, "onReceive broadcast");
    ReportController.b(MobileQQ.sMobileQQ.waitAppRuntime(null), "dc00898", "", "", "0X800B3EB", "0X800B3EB", 0, 0, "", "", "", "");
    paramIntent = AccountLifeCycleClient.a().a(AccountPhoneUnityManager.class);
    if ((paramIntent instanceof AccountPhoneUnityManager))
    {
      paramIntent = (AccountPhoneUnityManager)paramIntent;
      paramIntent.f();
      AccountPhoneUnityManager.a(paramIntent, paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.AccountPhoneUnityManager.PhoneUnityReceiver
 * JD-Core Version:    0.7.0.1
 */