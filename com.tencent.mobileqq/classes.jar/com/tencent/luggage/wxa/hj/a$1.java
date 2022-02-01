package com.tencent.luggage.wxa.hj;

import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import com.tencent.luggage.wxa.hl.a.a;

class a$1
  extends a.a
{
  a$1(a parama) {}
  
  public Bundle a(Bundle paramBundle, String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      if (paramBundle == null)
      {
        com.tencent.luggage.wxa.hs.b.b("IPC.BaseIPCService", "invokeSync failed, data is null.", new Object[0]);
        return null;
      }
      k localk = (k)p.a(paramString, k.class);
      if (localk == null)
      {
        com.tencent.luggage.wxa.hs.b.b("IPC.BaseIPCService", "invokeSync failed, can not newInstance by class %s.", new Object[] { paramString });
        return null;
      }
      paramBundle.setClassLoader(a.class.getClassLoader());
      paramBundle = paramBundle.getParcelable("__remote_task_data");
      paramString = new Bundle();
      paramString.putParcelable("__remote_task_result_data", (Parcelable)localk.invoke(paramBundle));
      return paramString;
    }
    com.tencent.luggage.wxa.hs.b.b("IPC.BaseIPCService", "invokeSync failed, class is null or nil.", new Object[0]);
    return null;
  }
  
  public void a(Bundle paramBundle, String paramString, com.tencent.luggage.wxa.hl.b paramb)
  {
    if (paramString != null) {}
    try
    {
      if (paramString.length() != 0)
      {
        if (paramBundle == null)
        {
          com.tencent.luggage.wxa.hs.b.b("IPC.BaseIPCService", "invokeAsync failed, data is null.", new Object[0]);
          return;
        }
        paramBundle.setClassLoader(a.class.getClassLoader());
        paramBundle = paramBundle.getParcelable("__remote_task_data");
        c localc = (c)p.a(paramString, c.class);
        if (localc == null)
        {
          com.tencent.luggage.wxa.hs.b.b("IPC.BaseIPCService", "invokeAsync failed, can not newInstance by class %s.", new Object[] { paramString });
          return;
        }
        com.tencent.luggage.wxa.hs.b.a("IPC.BaseIPCService", "invokeAsync in target process, before ThreadPool.post, clazz=%s", new Object[] { paramString });
        l.a(new a.1.1(this, localc, paramBundle, paramb, paramString), paramString);
        return;
      }
      com.tencent.luggage.wxa.hs.b.b("IPC.BaseIPCService", "invokeAsync failed, class is null or nil.", new Object[0]);
      return;
    }
    catch (Throwable paramBundle)
    {
      label124:
      break label124;
    }
    com.tencent.luggage.wxa.hs.b.b("IPC.BaseIPCService", "invokeAsync class:%s, get exception %s", new Object[] { paramString, paramBundle });
    if (!(paramBundle instanceof RemoteException))
    {
      paramb.a(Bundle.EMPTY);
      return;
    }
    throw paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hj.a.1
 * JD-Core Version:    0.7.0.1
 */