package com.tencent.luggage.wxa.hj;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.tencent.luggage.wxa.hl.a.a;
import java.util.Map;

class d$2
  implements ServiceConnection
{
  d$2(d paramd, String paramString, d.a parama, long paramLong, Context paramContext) {}
  
  public void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    if (paramIBinder == null)
    {
      com.tencent.luggage.wxa.hs.b.a("IPC.IPCBridgeManager", "[%s]->[%s] onServiceConnected(%s), but service is null, id:%d", new Object[] { g.b(), this.a, Integer.valueOf(this.b.hashCode()), Long.valueOf(this.c) });
      this.d.unbindService(this.b.b);
      d.a(this.e).remove(this.a);
      ??? = this.b;
      ???.b = null;
      ???.a = null;
    }
    else
    {
      com.tencent.luggage.wxa.hs.b.a("IPC.IPCBridgeManager", "onServiceConnected(%s), id:%d", new Object[] { Integer.valueOf(this.b.hashCode()), Long.valueOf(this.c) });
      this.b.a = a.a.a(paramIBinder);
      try
      {
        paramIBinder.linkToDeath(new d.2.1(this, paramIBinder), 0);
      }
      catch (RemoteException ???)
      {
        com.tencent.luggage.wxa.hs.b.b("IPC.IPCBridgeManager", "binder register linkToDeath listener error, bw:%d, id:%d, %s", new Object[] { Integer.valueOf(this.b.hashCode()), Long.valueOf(this.c), Log.getStackTraceString(???) });
      }
    }
    if (this.b.d != null) {
      d.b(this.e).removeCallbacks(this.b.d);
    }
    synchronized (this.b)
    {
      this.b.c = false;
      this.b.notifyAll();
      this.b.d = null;
      this.b.b = this;
      com.tencent.luggage.wxa.hs.b.e("IPC.IPCBridgeManager", "onServiceConnected: [%s]->[%s] success", new Object[] { g.b(), this.a });
      synchronized (d.a(this.e))
      {
        d.a(this.e).put(this.a, this.b);
        d.b(this.e, this.a);
        return;
      }
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    com.tencent.luggage.wxa.hs.b.a("IPC.IPCBridgeManager", "onServiceDisconnected(%s, tid : %s)", new Object[] { Integer.valueOf(this.b.hashCode()), Long.valueOf(Thread.currentThread().getId()) });
    this.e.b(this.a);
    com.tencent.luggage.wxa.hq.b.a(this.a);
    d.c(this.e, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hj.d.2
 * JD-Core Version:    0.7.0.1
 */