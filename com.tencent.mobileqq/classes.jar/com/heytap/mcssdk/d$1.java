package com.heytap.mcssdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.heytap.mcssdk.f.c;
import com.mcs.aidl.IMcsSdkService;
import com.mcs.aidl.IMcsSdkService.Stub;

class d$1
  implements ServiceConnection
{
  d$1(d paramd, Intent paramIntent) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    paramComponentName = new Bundle();
    paramComponentName.putAll(this.a.getExtras());
    try
    {
      IMcsSdkService.Stub.a(paramIBinder).a(paramComponentName);
    }
    catch (Exception paramComponentName)
    {
      paramIBinder = new StringBuilder();
      paramIBinder.append("bindMcsService exception:");
      paramIBinder.append(paramComponentName);
      c.a(paramIBinder.toString());
    }
    d.a(this.b).unbindService(this);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.heytap.mcssdk.d.1
 * JD-Core Version:    0.7.0.1
 */