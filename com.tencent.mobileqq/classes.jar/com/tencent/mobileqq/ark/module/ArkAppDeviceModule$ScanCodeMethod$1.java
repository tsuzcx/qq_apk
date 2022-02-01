package com.tencent.mobileqq.ark.module;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;

class ArkAppDeviceModule$ScanCodeMethod$1
  extends BroadcastReceiver
{
  ArkAppDeviceModule$ScanCodeMethod$1(ArkAppDeviceModule.ScanCodeMethod paramScanCodeMethod, long paramLong) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getStringExtra("com.tencent.ark.scanResultData");
    paramIntent = paramIntent.getStringExtra("com.tencent.ark.scanResultType");
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToAppThread(this.b.a.f, new ArkAppDeviceModule.ScanCodeMethod.1.1(this, paramContext, paramIntent));
    try
    {
      BaseApplication.getContext().unregisterReceiver(ArkAppDeviceModule.e(this.b.a));
      label63:
      ArkAppDeviceModule.a(this.b.a, null);
      return;
    }
    catch (Exception paramContext)
    {
      break label63;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.module.ArkAppDeviceModule.ScanCodeMethod.1
 * JD-Core Version:    0.7.0.1
 */