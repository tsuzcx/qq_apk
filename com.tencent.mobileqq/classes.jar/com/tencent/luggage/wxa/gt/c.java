package com.tencent.luggage.wxa.gt;

import com.tencent.luggage.wxa.gn.e;
import com.tencent.luggage.wxa.gn.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class c
{
  private d a;
  private com.tencent.luggage.wxa.gq.a b;
  private HashMap<String, Boolean> c = new HashMap();
  private com.tencent.luggage.wxa.gp.g d;
  private com.tencent.luggage.wxa.go.c e;
  private String f;
  private volatile boolean g = false;
  
  public c(boolean paramBoolean)
  {
    this.a = new d(paramBoolean);
    this.b = new com.tencent.luggage.wxa.gq.a(this.a);
    this.a.a(this.b);
    this.d = new com.tencent.luggage.wxa.gp.g(null);
    this.e = new com.tencent.luggage.wxa.go.c();
  }
  
  private void d(com.tencent.luggage.wxa.if.b paramb)
  {
    paramb.z = true;
    int i = this.a.q(paramb.a);
    int j = this.a.k();
    if (!this.g)
    {
      if (i <= 2000) {
        paramb.z = false;
      }
      if (i >= 5000) {
        paramb.z = true;
      } else if (j <= 5) {
        paramb.z = false;
      } else {
        paramb.z = true;
      }
      if (paramb.c.contains("scale_intro")) {
        paramb.z = false;
      }
    }
    if (j > 5)
    {
      Object localObject = this.a.l();
      if (((ArrayList)localObject).contains(paramb.a)) {
        ((ArrayList)localObject).remove(paramb.a);
      }
      if (((ArrayList)localObject).size() > 2)
      {
        com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioMixPlayer", "do stop paused audio size:%d", new Object[] { Integer.valueOf(((ArrayList)localObject).size()) });
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          f((String)((Iterator)localObject).next());
        }
      }
    }
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioMixPlayer", "playingCount:%d, duration:%d, supportMixPlay:%b", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(paramb.z) });
  }
  
  public static boolean v(String paramString)
  {
    return com.tencent.luggage.wxa.gw.a.c(paramString);
  }
  
  public com.tencent.luggage.wxa.if.b a(String paramString)
  {
    return this.a.a(paramString);
  }
  
  public void a()
  {
    this.b.c();
    this.a.c();
    this.d.a(this.f);
    g();
    com.tencent.luggage.wxa.gn.a.a().b();
  }
  
  public void a(int paramInt, String paramString)
  {
    this.a.a(paramInt, paramString);
  }
  
  public void a(b paramb)
  {
    this.a.a(paramb);
  }
  
  public void a(g paramg)
  {
    this.a.a(paramg);
  }
  
  public void a(com.tencent.luggage.wxa.if.b paramb)
  {
    this.f = paramb.n;
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioMixPlayer", "preparePlay:%s", new Object[] { paramb.a });
    com.tencent.luggage.wxa.gn.a.a().a(this.f);
    if ((t(paramb.c)) && (paramb.g)) {
      d(paramb);
    }
    this.a.a(paramb);
    this.b.c(paramb);
  }
  
  public boolean a(String paramString, int paramInt)
  {
    boolean bool4 = false;
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioMixPlayer", "seekTo audioId:%s, position:%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    boolean bool1 = this.b.b(paramString, paramInt);
    if (!bool1)
    {
      com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioMixPlayer", "seekTo fail audioId:%s", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    a(10, paramString);
    long l = this.a.p(paramString);
    int i = this.a.t(paramString);
    if (!s(paramString))
    {
      com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioMixPlayer", "seekTo cache is not exist");
    }
    else if (o(paramString) <= 2000)
    {
      com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioMixPlayer", "seekTo duration is not support seek");
      if (!this.b.f(paramString)) {
        bool1 = this.b.a(paramString, paramInt);
      }
    }
    else if (Math.abs(paramInt - l) <= 3000L)
    {
      com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioMixPlayer", "seekTo time is not support seek");
    }
    else
    {
      if ((i == 0) || (i == 1) || (i == 2)) {
        break label201;
      }
      com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioMixPlayer", "seekTo state is not support seek");
    }
    for (;;)
    {
      bool2 = true;
      break label237;
      label201:
      if (this.b.f(paramString)) {
        break;
      }
      bool1 = this.b.a(paramString, paramInt);
    }
    boolean bool2 = this.a.a(paramString, paramInt);
    label237:
    a(6, paramString);
    boolean bool3 = bool4;
    if (bool2)
    {
      bool3 = bool4;
      if (bool1) {
        bool3 = true;
      }
    }
    return bool3;
  }
  
  public void b()
  {
    this.b.b();
    this.a.d();
  }
  
  public void b(com.tencent.luggage.wxa.if.b paramb)
  {
    this.a.b(paramb);
    this.b.a(paramb);
  }
  
  public boolean b(String paramString)
  {
    return this.a.b(paramString);
  }
  
  public void c(com.tencent.luggage.wxa.if.b paramb)
  {
    this.a.c(paramb);
    this.b.b(paramb);
  }
  
  public void c(String paramString)
  {
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioMixPlayer", "play audioId:%s, audio state:%d", new Object[] { paramString, Integer.valueOf(this.a.t(paramString)) });
    d(this.a.a(paramString));
    this.a.c(paramString);
    this.b.b(paramString);
  }
  
  public boolean c()
  {
    long l = d();
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioMixPlayer", "cacheInMemoryTotalSize:%d, appId:%s", new Object[] { Long.valueOf(l), this.f });
    boolean bool;
    if (l >= 50000000L) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool) {
      com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioMixPlayer", "isLoadedCacheExceedMaxMemory, exceed max cache 50M!, appId:%s", new Object[] { this.f });
    }
    return bool;
  }
  
  public long d()
  {
    return f.c().e();
  }
  
  public void d(String paramString)
  {
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioMixPlayer", "resume audioId:%s, audio state:%d", new Object[] { paramString, Integer.valueOf(this.a.t(paramString)) });
    d(this.a.a(paramString));
    this.a.d(paramString);
    this.b.b(paramString);
  }
  
  public long e()
  {
    return e.a().c();
  }
  
  public void e(String paramString)
  {
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioMixPlayer", "pause audioId:%s, audio state:%d", new Object[] { paramString, Integer.valueOf(this.a.t(paramString)) });
    this.a.e(paramString);
    this.b.c(paramString);
  }
  
  public void f()
  {
    this.e.a(this.f);
    this.c.clear();
  }
  
  public void f(String paramString)
  {
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioMixPlayer", "stop audioId:%s, audio state:%d", new Object[] { paramString, Integer.valueOf(this.a.t(paramString)) });
    this.a.f(paramString);
    this.b.d(paramString);
  }
  
  public void g()
  {
    f.c().g();
  }
  
  public void g(String paramString)
  {
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioMixPlayer", "remove audioId:%s", new Object[] { paramString });
    this.a.g(paramString);
    this.b.e(paramString);
  }
  
  public long h()
  {
    return this.a.m();
  }
  
  public boolean h(String paramString)
  {
    return this.a.h(paramString);
  }
  
  public boolean i(String paramString)
  {
    return this.a.i(paramString);
  }
  
  public boolean j(String paramString)
  {
    return this.a.j(paramString);
  }
  
  public boolean k(String paramString)
  {
    return this.a.k(paramString);
  }
  
  public boolean l(String paramString)
  {
    return this.a.l(paramString);
  }
  
  public boolean m(String paramString)
  {
    return this.a.m(paramString);
  }
  
  public boolean n(String paramString)
  {
    return this.a.n(paramString);
  }
  
  public int o(String paramString)
  {
    return this.a.q(paramString);
  }
  
  public com.tencent.luggage.wxa.if.d p(String paramString)
  {
    return this.a.s(paramString);
  }
  
  public long q(String paramString)
  {
    return f.c().d(paramString);
  }
  
  public void r(String paramString)
  {
    this.e.a(this.f, paramString);
  }
  
  public boolean s(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null)
    {
      if (this.c.containsKey(paramString.c)) {
        return ((Boolean)this.c.get(paramString.c)).booleanValue();
      }
      boolean bool = f.c().c(paramString.c);
      if (bool) {
        this.c.put(paramString.c, Boolean.valueOf(bool));
      }
      return bool;
    }
    return false;
  }
  
  public boolean t(String paramString)
  {
    if (this.c.containsKey(paramString)) {
      return ((Boolean)this.c.get(paramString)).booleanValue();
    }
    boolean bool = f.c().c(paramString);
    if (bool) {
      this.c.put(paramString, Boolean.valueOf(bool));
    }
    return bool;
  }
  
  public boolean u(String paramString)
  {
    return this.b.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gt.c
 * JD-Core Version:    0.7.0.1
 */