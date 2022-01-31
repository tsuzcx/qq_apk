package com.huawei.hiar;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.huawei.arengine.service.IAREngine;
import com.huawei.arengine.service.IAREngine.Stub;

class ARServiceProxy$1
  implements ServiceConnection
{
  ARServiceProxy$1(ARServiceProxy paramARServiceProxy) {}
  
  public void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    synchronized (ARServiceProxy.access$000(this.a))
    {
      Log.d(ARServiceProxy.access$100(), "bind a connection with service");
      ARServiceProxy.access$202(this.a, IAREngine.Stub.asInterface(paramIBinder));
      paramIBinder = ARServiceProxy.access$200(this.a);
      if (paramIBinder != null) {}
      try
      {
        ARServiceProxy.access$302(this.a, ARServiceProxy.access$200(this.a).getMetaData());
        ARServiceProxy.access$500(this.a, ARServiceProxy.access$400(this.a));
        return;
      }
      catch (Exception paramIBinder)
      {
        for (;;)
        {
          Log.e(ARServiceProxy.access$100(), "getMetaData failed!");
          paramIBinder.printStackTrace();
        }
      }
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    Log.d(ARServiceProxy.access$100(), "onServiceDisconnected called since the service is lost or stop!");
    ARServiceProxy.access$202(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.huawei.hiar.ARServiceProxy.1
 * JD-Core Version:    0.7.0.1
 */