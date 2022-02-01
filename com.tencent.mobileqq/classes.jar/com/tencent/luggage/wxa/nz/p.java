package com.tencent.luggage.wxa.nz;

import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdManager.DiscoveryListener;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum p
{
  private final Map<p.b, NsdManager.DiscoveryListener> b = new ConcurrentHashMap();
  
  private p() {}
  
  private NsdManager a()
  {
    return (NsdManager)r.a().getSystemService("servicediscovery");
  }
  
  public void a(p.b paramb)
  {
    synchronized (this.b)
    {
      if (!this.b.containsKey(paramb)) {
        return;
      }
      NsdManager localNsdManager = a();
      try
      {
        localNsdManager.stopServiceDiscovery((NsdManager.DiscoveryListener)this.b.get(paramb));
      }
      catch (Throwable localThrowable)
      {
        o.a("MicroMsg.LocalServiceMgr", localThrowable, "Throwable: stopScanServices", new Object[0]);
      }
      this.b.remove(paramb);
      return;
    }
  }
  
  public void a(p.c paramc, p.a parama)
  {
    f.a.a(new p.2(this, paramc, parama), "LocalServiceMgr#resolveService");
  }
  
  public void a(String paramString, p.b paramb)
  {
    NsdManager localNsdManager = a();
    p.1 local1 = new p.1(this, paramb);
    this.b.put(paramb, local1);
    localNsdManager.discoverServices(paramString, 1, local1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nz.p
 * JD-Core Version:    0.7.0.1
 */