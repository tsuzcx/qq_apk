package com.tencent.ilinkservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

class IlinkServiceImpl$2
  implements ServiceConnection
{
  IlinkServiceImpl$2(IlinkServiceImpl paramIlinkServiceImpl) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    IlinkServiceImpl.access$1102(this.a, u.a.a(paramIBinder));
    try
    {
      IlinkServiceImpl.access$1202(this.a, IlinkServiceImpl.access$1100(this.a).a(IlinkServiceImpl.access$800(this.a), IlinkServiceImpl.access$1300(this.a), IlinkServiceImpl.access$1400(this.a)));
      paramComponentName = af.a();
      paramIBinder = new StringBuilder();
      paramIBinder.append("my process name is:");
      paramIBinder.append(IlinkServiceImpl.access$800(this.a));
      paramIBinder.append(", my cookie is:");
      paramIBinder.append(IlinkServiceImpl.access$1200(this.a));
      paramIBinder.append(", my package name is:");
      paramIBinder.append(IlinkServiceImpl.access$1500(this.a));
      paramComponentName.a("IlinkServiceImpl", paramIBinder.toString(), new Object[0]);
      v.a().a(true);
      af.a().a("IlinkServiceImpl", "onServiceConnected finished", new Object[0]);
      return;
    }
    catch (RemoteException paramComponentName)
    {
      paramComponentName.printStackTrace();
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    paramComponentName = af.a();
    int j = 0;
    paramComponentName.a("IlinkServiceImpl", "onServiceDisconnected then we should bind again", new Object[0]);
    if (IlinkServiceImpl.access$1600(this.a)) {
      try
      {
        IlinkServiceImpl.access$1800(this.a).unbindService(IlinkServiceImpl.access$1700(this.a));
        IlinkServiceImpl.access$1602(this.a, false);
      }
      catch (IllegalArgumentException paramComponentName)
      {
        paramComponentName.printStackTrace();
        af.a().d("IlinkServiceImpl", "Disconnected catch argument exception!", new Object[0]);
      }
    }
    v.a().a(false);
    v.a().c();
    IlinkServiceImpl.access$1102(this.a, null);
    IlinkServiceImpl.access$200(this.a).clear();
    IlinkServiceImpl.access$900(this.a).clear();
    IlinkServiceImpl.access$400(this.a).clear();
    paramComponentName = IlinkServiceImpl.access$500(this.a);
    int i = 0;
    try
    {
      while (i < IlinkServiceImpl.access$500(this.a).size())
      {
        ((x)IlinkServiceImpl.access$500(this.a).get(i)).a();
        i += 1;
      }
      paramComponentName = IlinkServiceImpl.access$300(this.a);
      i = j;
      try
      {
        while (i < IlinkServiceImpl.access$300(this.a).size())
        {
          ((ac)IlinkServiceImpl.access$300(this.a).get(i)).a();
          i += 1;
        }
        IlinkServiceImpl.access$1900(this.a).setAction("com.tencent.ilinkservice.StartIlinkService");
        IlinkServiceImpl.access$1900(this.a).setPackage(IlinkServiceImpl.access$1500(this.a));
        IlinkServiceImpl.access$1900(this.a).putExtra("caller", IlinkServiceImpl.access$800(this.a));
        IlinkServiceImpl.access$1900(this.a).putExtra("initpara", IlinkServiceImpl.access$1400(this.a));
        paramComponentName = this.a;
        IlinkServiceImpl.access$1602(paramComponentName, IlinkServiceImpl.access$1800(paramComponentName).bindService(IlinkServiceImpl.access$1900(this.a), IlinkServiceImpl.access$1700(this.a), 1));
        return;
      }
      finally {}
      throw localObject2;
    }
    finally {}
    for (;;) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilinkservice.IlinkServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */