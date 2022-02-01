package com.tencent.luggage.wxa.hj;

import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;

class a$a$a
  implements Runnable
{
  private static final Bundle b = new Bundle();
  com.tencent.luggage.wxa.hl.b a;
  
  static
  {
    b.putBoolean("__command_release_ref", true);
  }
  
  a$a$a(com.tencent.luggage.wxa.hl.b paramb)
  {
    this.a = paramb;
  }
  
  public void run()
  {
    try
    {
      com.tencent.luggage.wxa.hs.b.a("IPC.IPCInvokeCallbackProxy", "notify release ref of callback(%s).", new Object[] { Integer.valueOf(this.a.hashCode()) });
      this.a.a(b);
      com.tencent.luggage.wxa.hq.b.b(this.a);
      this.a = null;
      return;
    }
    catch (Exception localException) {}catch (RemoteException localRemoteException)
    {
      break label83;
    }
    com.tencent.luggage.wxa.hs.b.b("IPC.IPCInvokeCallbackProxy", "notify release ref error, %s\n %s", new Object[] { localRemoteException.getMessage(), Log.getStackTraceString(localRemoteException) });
    return;
    label83:
    com.tencent.luggage.wxa.hs.b.b("IPC.IPCInvokeCallbackProxy", "notify release ref error, %s", new Object[] { Log.getStackTraceString(localRemoteException) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hj.a.a.a
 * JD-Core Version:    0.7.0.1
 */