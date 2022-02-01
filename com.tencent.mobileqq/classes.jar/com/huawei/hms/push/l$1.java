package com.huawei.hms.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.huawei.hms.support.log.HMSLog;

class l$1
  implements ServiceConnection
{
  l$1(l paraml, Bundle paramBundle, Context paramContext) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    HMSLog.i("RemoteService", "remote service onConnected");
    l.a(this.c, new Messenger(paramIBinder));
    paramComponentName = Message.obtain();
    paramComponentName.setData(this.a);
    try
    {
      l.a(this.c).send(paramComponentName);
      HMSLog.i("RemoteService", "remote service unbindservice");
      this.b.unbindService(l.b(this.c));
      return;
    }
    catch (RemoteException paramComponentName)
    {
      for (;;)
      {
        HMSLog.i("RemoteService", "remote service message send failed");
      }
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    HMSLog.i("RemoteService", "remote service onDisconnected");
    l.a(this.c, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.l.1
 * JD-Core Version:    0.7.0.1
 */