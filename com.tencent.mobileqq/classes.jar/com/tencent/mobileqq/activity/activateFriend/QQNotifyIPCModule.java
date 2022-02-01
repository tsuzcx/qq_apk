package com.tencent.mobileqq.activity.activateFriend;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.reminder.api.IQQReminderService;
import eipc.EIPCResult;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

public class QQNotifyIPCModule
  extends QIPCModule
  implements QQNotifyUtils.QQNotifyListener
{
  private static volatile QQNotifyIPCModule a;
  
  public QQNotifyIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static QQNotifyIPCModule a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new QQNotifyIPCModule("QQNotifyIPCModule");
      }
      return a;
    }
    finally {}
  }
  
  private void a(int paramInt)
  {
    if (QQReminderAMSHelper.a())
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("allowed", true);
      callbackResult(paramInt, EIPCResult.createResult(0, localBundle));
      return;
    }
    QQReminderAMSHelper.a(new WeakReference(new QQNotifyIPCModule.1(this, paramInt)));
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if ("newSubscribe".equals(paramString)) {}
    for (;;)
    {
      return EIPCResult.createResult(-100, null);
      if ("query".equals(paramString))
      {
        paramString = (IQQReminderService)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IQQReminderService.class, "");
        if (paramString != null) {
          paramString.queryNotifyIsSubscribed(paramBundle.getString("msgid"), new QQNotifyIPCModule.QQNotifyObserver(this, QQNotifyUtils.a(paramInt)));
        }
      }
      else if ("switch".equals(paramString))
      {
        a(paramInt);
      }
      else if ("add_msg".equals(paramString))
      {
        QQReminderAMSHelper.a(paramBundle);
      }
      else if ("switch_query".equals(paramString))
      {
        paramString = new Bundle();
        paramString.putBoolean("allowed", QQReminderAMSHelper.a());
        callbackResult(paramInt, EIPCResult.createResult(0, paramString));
      }
    }
  }
  
  public void queryHasSetNotify(Bundle paramBundle1, Bundle paramBundle2)
  {
    callbackResult(QQNotifyUtils.a(paramBundle2), EIPCResult.createResult(0, paramBundle1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.QQNotifyIPCModule
 * JD-Core Version:    0.7.0.1
 */