package com.tencent.mobileqq.ark.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.ark.ArkViewModel;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;

final class ArkAppCenter$ProxyChangeNotifier
  extends BroadcastReceiver
  implements Runnable
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("android.intent.action.PROXY_CHANGE".equals(paramIntent.getAction()))
    {
      QLog.i("ArkApp.AppCenter", 1, "receive broadcast proxy change.");
      ThreadManager.executeOnSubThread(this);
    }
  }
  
  public void run()
  {
    if (AppNetConnInfo.isWifiConn())
    {
      ArkViewModel.setArkHttpProxy();
      return;
    }
    ArkViewModel.clearArkHttpProxy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.base.ArkAppCenter.ProxyChangeNotifier
 * JD-Core Version:    0.7.0.1
 */