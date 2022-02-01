package com.tencent.featuretoggle.hltxkg.common.c;

import android.os.Handler;
import com.tencent.featuretoggle.hltxkg.common.a.o;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class f
  implements a, b
{
  private static f a = new f();
  private Map<String, com.tencent.featuretoggle.hltxkg.common.c.a.a> b = new ConcurrentHashMap();
  private c c;
  private Runnable d = new h(this);
  private Runnable e = new i(this);
  
  private f()
  {
    Object localObject = new com.tencent.featuretoggle.hltxkg.common.c.a.d();
    this.b.put(((com.tencent.featuretoggle.hltxkg.common.c.a.a)localObject).b(), localObject);
    localObject = new com.tencent.featuretoggle.hltxkg.common.c.a.b();
    this.b.put(((com.tencent.featuretoggle.hltxkg.common.c.a.a)localObject).b(), localObject);
    localObject = new com.tencent.featuretoggle.hltxkg.common.c.a.a.a();
    this.b.put(((com.tencent.featuretoggle.hltxkg.common.c.a.a)localObject).b(), localObject);
    localObject = this.d;
    if ((!com.tencent.featuretoggle.hltxkg.common.a.e()) && (com.tencent.featuretoggle.hltxkg.common.a.g))
    {
      o.a().a((Runnable)localObject);
      o.a().b((Runnable)localObject, 30000L);
    }
    localObject = this.e;
    if ((!com.tencent.featuretoggle.hltxkg.common.a.e()) && (com.tencent.featuretoggle.hltxkg.common.a.g))
    {
      o.a().a((Runnable)localObject);
      o.a().b((Runnable)localObject, 30000L);
    }
  }
  
  public static f d()
  {
    return a;
  }
  
  public final void a()
  {
    this.c.a();
  }
  
  public final void a(int paramInt)
  {
    com.tencent.featuretoggle.hltxkg.common.a.i().post(new g(this, paramInt));
  }
  
  public final void a(String paramString)
  {
    this.c.a(paramString);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    Object localObject = this.d;
    long l = com.tencent.featuretoggle.hltxkg.common.a.i.a("app_ipc_timertask_gap", 0, 3600000, 60000);
    if ((!com.tencent.featuretoggle.hltxkg.common.a.e()) && (com.tencent.featuretoggle.hltxkg.common.a.g))
    {
      o.a().a((Runnable)localObject);
      o.a().b((Runnable)localObject, l);
    }
    localObject = this.b.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.featuretoggle.hltxkg.common.c.a.a)((Iterator)localObject).next()).a(paramString1, paramString2);
    }
  }
  
  public final void a(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    Object localObject = this.e;
    long l = com.tencent.featuretoggle.hltxkg.common.a.i.a("app_ipc_timertask_gap", 0, 3600000, 60000);
    if ((!com.tencent.featuretoggle.hltxkg.common.a.e()) && (com.tencent.featuretoggle.hltxkg.common.a.g))
    {
      o.a().a((Runnable)localObject);
      o.a().b((Runnable)localObject, l);
    }
    localObject = this.b.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.featuretoggle.hltxkg.common.c.a.a)((Iterator)localObject).next()).a(paramString1, paramArrayOfByte, paramString2);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    int i;
    if (com.tencent.featuretoggle.hltxkg.common.a.f != paramBoolean) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      com.tencent.featuretoggle.hltxkg.common.a.f = paramBoolean;
      this.c.a(paramBoolean);
    }
  }
  
  public final void b()
  {
    this.c.b();
  }
  
  public final void c()
  {
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.featuretoggle.hltxkg.common.c.a.a)localIterator.next()).c();
    }
  }
  
  public final d e()
  {
    return (d)this.b.get("settings");
  }
  
  public final com.tencent.featuretoggle.hltxkg.common.a.c.d f()
  {
    return (com.tencent.featuretoggle.hltxkg.common.a.c.d)this.b.get("accessscheduler");
  }
  
  public final void g()
  {
    if (com.tencent.featuretoggle.hltxkg.common.a.e()) {
      this.c = e.e();
    }
    this.c.a(this);
    this.c.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.c.f
 * JD-Core Version:    0.7.0.1
 */