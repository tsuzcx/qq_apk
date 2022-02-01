package com.tencent.mobileqq.ark;

import agpq;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

final class ArkAppCenter$ProxyChangeNotifier
  extends BroadcastReceiver
  implements Runnable
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("android.intent.action.PROXY_CHANGE".equals(paramIntent.getAction()))
    {
      ArkAppCenter.c("ArkApp", "receive broadcast proxy change.");
      ThreadManager.executeOnSubThread(this);
    }
  }
  
  public void run()
  {
    if (AppNetConnInfo.isWifiConn())
    {
      agpq.setArkHttpProxy();
      return;
    }
    agpq.clearArkHttpProxy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppCenter.ProxyChangeNotifier
 * JD-Core Version:    0.7.0.1
 */