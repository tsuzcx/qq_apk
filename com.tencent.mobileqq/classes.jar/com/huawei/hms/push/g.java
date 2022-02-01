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

public class g
  implements ServiceConnection
{
  public g(h paramh, Bundle paramBundle, Context paramContext) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    HMSLog.i("RemoteService", "remote service onConnected");
    h.a(this.c, new Messenger(paramIBinder));
    paramComponentName = Message.obtain();
    paramComponentName.setData(this.a);
    try
    {
      h.a(this.c).send(paramComponentName);
    }
    catch (RemoteException paramComponentName)
    {
      label49:
      break label49;
    }
    HMSLog.i("RemoteService", "remote service message send failed");
    HMSLog.i("RemoteService", "remote service unbindservice");
    this.b.unbindService(h.b(this.c));
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    HMSLog.i("RemoteService", "remote service onDisconnected");
    h.a(this.c, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.push.g
 * JD-Core Version:    0.7.0.1
 */