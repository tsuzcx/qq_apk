package com.tencent.mm.plugin.appbrand.ipc;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class AppBrandMainProcessService$4
  implements ServiceConnection
{
  public void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    AppBrandMainProcessService.a(a.a.a(paramIBinder));
    AppBrandMainProcessService.b();
    AppBrandMainProcessService.b(r.b());
    try
    {
      AppBrandMainProcessService.c().a(new Binder(), r.c());
    }
    catch (Exception ???)
    {
      o.b("MicroMsg.AppBrandMainProcessService", "onServiceConnected, registerDeathRecipient, %s", new Object[] { ??? });
    }
    o.d("MicroMsg.AppBrandMainProcessService", "onServiceConnected(%s)", new Object[] { r.c() });
    synchronized (AppBrandMainProcessService.d())
    {
      paramIBinder = new HashSet(AppBrandMainProcessService.d());
      AppBrandMainProcessService.d().clear();
      ??? = paramIBinder.iterator();
      while (???.hasNext())
      {
        paramIBinder = (Runnable)???.next();
        if (paramIBinder != null) {
          paramIBinder.run();
        }
      }
      return;
    }
    for (;;)
    {
      throw paramIBinder;
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    AppBrandMainProcessService.a(null);
    AppBrandMainProcessService.a(r.b());
    AppBrandMainProcessService.a();
    o.d("MicroMsg.AppBrandMainProcessService", "onServiceDisconnected(%s)", new Object[] { r.c() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.4
 * JD-Core Version:    0.7.0.1
 */