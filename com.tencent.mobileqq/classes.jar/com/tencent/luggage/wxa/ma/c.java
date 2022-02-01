package com.tencent.luggage.wxa.ma;

import android.net.Uri;
import com.tencent.luggage.wxa.am.f.a;
import com.tencent.luggage.wxa.am.g.a;
import com.tencent.luggage.wxa.an.e;
import com.tencent.luggage.wxa.an.f;
import com.tencent.luggage.wxa.an.h;
import com.tencent.luggage.wxa.an.l;
import com.tencent.luggage.wxa.hw.b;
import com.tencent.luggage.wxa.mk.d;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rt.i;
import java.io.File;

public class c
  implements b, g
{
  private static c c;
  private com.tencent.luggage.wxa.an.a a;
  private e b;
  
  private c()
  {
    f();
  }
  
  public static c a()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new c();
        }
      }
      finally {}
    }
    return c;
  }
  
  private void f()
  {
    Object localObject1 = com.tencent.luggage.wxa.qz.r.c();
    if (!af.c((String)localObject1))
    {
      int j = ((String)localObject1).indexOf(":");
      if (j >= 0)
      {
        int i = ((String)localObject1).length();
        j += 1;
        if (i >= j)
        {
          localObject1 = ((String)localObject1).substring(j);
          break label48;
        }
      }
    }
    localObject1 = "main";
    label48:
    g();
    Object localObject3 = com.tencent.luggage.wxa.hz.a.d();
    Object localObject2 = localObject3;
    if (!((String)localObject3).endsWith("/"))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject3);
      ((StringBuilder)localObject2).append("/");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append("videocache/");
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append("/");
    localObject1 = ((StringBuilder)localObject3).toString();
    try
    {
      if (!com.tencent.luggage.wxa.rt.k.g((String)localObject1))
      {
        o.c("MicroMsg.SameLayer.ExoVideoCacheHandler", "mkdirs fail 1, maybe file exist");
        if (!new i((String)localObject1).n())
        {
          o.c("MicroMsg.SameLayer.ExoVideoCacheHandler", "mkdirs fail, not dir");
          com.tencent.luggage.wxa.rt.k.i((String)localObject1);
          if (!com.tencent.luggage.wxa.rt.k.g((String)localObject1))
          {
            o.c("MicroMsg.SameLayer.ExoVideoCacheHandler", "mkdirs fail 2, no space?");
            return;
          }
        }
      }
      localObject1 = new i((String)localObject1);
      localObject2 = new com.tencent.luggage.wxa.an.k(536870912L);
      this.a = new l(new File(com.tencent.luggage.wxa.rt.k.c(((i)localObject1).l(), true)), (f)localObject2);
      o.d("MicroMsg.SameLayer.ExoVideoCacheHandler", "initVideoCacheDataSource, cacheFolder:%s", new Object[] { ((i)localObject1).l() });
      localObject1 = d.a(com.tencent.luggage.wxa.qz.r.a());
      localObject2 = new com.tencent.luggage.wxa.an.c(this.a, 10485760L);
      this.b = new e(this.a, (g.a)localObject1, new com.tencent.luggage.wxa.am.r(), (f.a)localObject2, 3, new c.1(this));
      o.d("MicroMsg.SameLayer.ExoVideoCacheHandler", "initVideoCacheDataSource, cache:%s", new Object[] { this.a });
      return;
    }
    catch (Throwable localThrowable)
    {
      o.b("MicroMsg.SameLayer.ExoVideoCacheHandler", "mkdirs exception:%s", new Object[] { localThrowable });
    }
  }
  
  private void g()
  {
    Object localObject2 = com.tencent.luggage.wxa.hz.a.d();
    Object localObject1 = localObject2;
    if (!((String)localObject2).endsWith("/"))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("/");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("wxavideocache/");
    localObject1 = ((StringBuilder)localObject2).toString();
    try
    {
      com.tencent.luggage.wxa.rt.k.j((String)localObject1);
      return;
    }
    catch (Throwable localThrowable)
    {
      o.b("MicroMsg.SameLayer.ExoVideoCacheHandler", "cleanOldVideoCacheFolder exception:%s", new Object[] { localThrowable });
    }
  }
  
  public long a(String paramString, long paramLong1, long paramLong2)
  {
    if (this.a == null)
    {
      o.c("MicroMsg.SameLayer.ExoVideoCacheHandler", "getCachedBytes, cache is null");
      return 0L;
    }
    String str = h.a(Uri.parse(paramString));
    long l = this.a.b(str, paramLong1, paramLong2);
    o.d("MicroMsg.SameLayer.ExoVideoCacheHandler", "getCachedBytes, cachedSize:%s, position:%s, length:%s, url:%s", new Object[] { Long.valueOf(l), Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString });
    return l;
  }
  
  public String a(String paramString)
  {
    return paramString;
  }
  
  public g.a b()
  {
    return e();
  }
  
  public void c()
  {
    o.d("MicroMsg.SameLayer.ExoVideoCacheHandler", "register VideoCacheService#ExoVideoCacheHandler");
  }
  
  public void d()
  {
    o.d("MicroMsg.SameLayer.ExoVideoCacheHandler", "unregister VideoCacheService#ExoVideoCacheHandler");
  }
  
  public g.a e()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ma.c
 * JD-Core Version:    0.7.0.1
 */