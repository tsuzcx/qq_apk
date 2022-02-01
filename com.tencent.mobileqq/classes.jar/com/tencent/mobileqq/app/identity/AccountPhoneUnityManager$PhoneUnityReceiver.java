package com.tencent.mobileqq.app.identity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class AccountPhoneUnityManager$PhoneUnityReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    QLog.d("AccountPhoneUnityManager", 1, "onReceive broadcast");
    ReportController.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "dc00898", "", "", "0X800B3EB", "0X800B3EB", 0, 0, "", "", "", "");
    paramIntent = AccountLifeCycleClient.a().a(AccountPhoneUnityManager.class);
    if ((paramIntent instanceof AccountPhoneUnityManager))
    {
      ((AccountPhoneUnityManager)paramIntent).d();
      AccountPhoneUnityManager.a((AccountPhoneUnityManager)paramIntent, paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.AccountPhoneUnityManager.PhoneUnityReceiver
 * JD-Core Version:    0.7.0.1
 */