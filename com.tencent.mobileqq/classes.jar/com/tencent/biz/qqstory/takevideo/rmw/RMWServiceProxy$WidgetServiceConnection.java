package com.tencent.biz.qqstory.takevideo.rmw;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

class RMWServiceProxy$WidgetServiceConnection
  implements ServiceConnection
{
  private RMWServiceProxy a;
  
  public RMWServiceProxy$WidgetServiceConnection(RMWServiceProxy paramRMWServiceProxy)
  {
    this.a = paramRMWServiceProxy;
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    RMWServiceProxy localRMWServiceProxy = this.a;
    if (localRMWServiceProxy != null) {
      localRMWServiceProxy.a(paramComponentName, paramIBinder);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    RMWServiceProxy localRMWServiceProxy = this.a;
    if (localRMWServiceProxy != null) {
      localRMWServiceProxy.a(paramComponentName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.rmw.RMWServiceProxy.WidgetServiceConnection
 * JD-Core Version:    0.7.0.1
 */