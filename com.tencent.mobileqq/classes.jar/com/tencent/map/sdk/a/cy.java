package com.tencent.map.sdk.a;

import android.os.Handler;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class cy
  implements bu, cb
{
  private static cy b = new cy();
  public cv a;
  private Map<String, bv> c = new ConcurrentHashMap();
  private Runnable d = new da(this);
  private Runnable e = new db(this);
  
  private cy()
  {
    Object localObject = new ca();
    this.c.put(((bv)localObject).b(), localObject);
    localObject = new by();
    this.c.put(((bv)localObject).b(), localObject);
    localObject = new bw();
    this.c.put(((bv)localObject).b(), localObject);
    localObject = this.d;
    if ((!ac.e()) && (ac.f))
    {
      ay.a().a((Runnable)localObject);
      ay.a().a((Runnable)localObject, true, 30000L);
    }
    localObject = this.e;
    if ((!ac.e()) && (ac.f))
    {
      ay.a().a((Runnable)localObject);
      ay.a().a((Runnable)localObject, true, 30000L);
    }
  }
  
  public static cy d()
  {
    return b;
  }
  
  public final void a()
  {
    this.a.a();
  }
  
  public final void a(int paramInt)
  {
    ac.h().post(new cz(this, paramInt));
  }
  
  public final void a(String paramString1, String paramString2)
  {
    Object localObject = this.d;
    long l = as.a("app_ipc_timertask_gap", 0, 3600000, 60000);
    if ((!ac.e()) && (ac.f))
    {
      ay.a().a((Runnable)localObject);
      ay.a().a((Runnable)localObject, true, l);
    }
    localObject = this.c.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((bv)((Iterator)localObject).next()).a(paramString1, paramString2);
    }
  }
  
  public final void a(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    Object localObject = this.e;
    long l = as.a("app_ipc_timertask_gap", 0, 3600000, 60000);
    if ((!ac.e()) && (ac.f))
    {
      ay.a().a((Runnable)localObject);
      ay.a().a((Runnable)localObject, true, l);
    }
    localObject = this.c.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((bv)((Iterator)localObject).next()).a(paramString1, paramArrayOfByte, paramString2);
    }
  }
  
  public final void b()
  {
    this.a.b();
  }
  
  public final void c()
  {
    Iterator localIterator = this.c.values().iterator();
    while (localIterator.hasNext()) {
      ((bv)localIterator.next()).c();
    }
  }
  
  public final cw e()
  {
    return (cw)this.c.get("settings");
  }
  
  public final am f()
  {
    return (am)this.c.get("accessscheduler");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.cy
 * JD-Core Version:    0.7.0.1
 */