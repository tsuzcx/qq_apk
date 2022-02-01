package com.tencent.mobileqq.app.identity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class AccountIdentityManager$AccountIdentityFinishReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    AccountIdentityManager.a().b(paramIntent);
    ReportController.b(paramIntent, "dc00898", "", "", "0X800B278", "0X800B278", 0, 0, "", "", "", "");
    try
    {
      paramContext.unregisterReceiver(this);
      return;
    }
    catch (Exception paramContext)
    {
      QLog.d("AccountIdentityManager", 1, new Object[] { "unregisterReceiver error : ", paramContext.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.AccountIdentityManager.AccountIdentityFinishReceiver
 * JD-Core Version:    0.7.0.1
 */