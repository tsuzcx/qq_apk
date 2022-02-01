package com.tencent.luggage.wxa.nz;

import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.q;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.net.ssl.SSLContext;
import org.json.JSONObject;

public class b
{
  public static int a = 0;
  public static int b = -1;
  protected final ArrayList<String> c;
  private int d;
  private String e;
  private boolean f;
  private SSLContext g;
  private final String h;
  private c i;
  private final Map<String, ConcurrentLinkedQueue<Runnable>> j;
  private final ArrayList<com.tencent.luggage.wxa.oa.b> k;
  
  public b(c paramc, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(com.tencent.luggage.wxa.hz.a.e());
    localStringBuilder.append("appbrand/");
    this.e = localStringBuilder.toString();
    this.f = false;
    this.c = new ArrayList();
    this.k = new ArrayList();
    this.i = paramc;
    paramc = (a)paramc.b(a.class);
    this.d = paramc.j;
    this.h = paramc.u;
    this.g = j.a(paramc);
    this.j = new Hashtable(10);
    this.f = paramBoolean;
  }
  
  private void c(String paramString)
  {
    com.tencent.luggage.wxa.rd.a.b(new b.2(this, paramString), "appbrand_download_thread");
  }
  
  private void d(String paramString)
  {
    if (paramString == null) {
      return;
    }
    synchronized (this.k)
    {
      Iterator localIterator = this.k.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.luggage.wxa.oa.b localb = (com.tencent.luggage.wxa.oa.b)localIterator.next();
        if (paramString.equals(localb.c())) {
          this.k.remove(localb);
        }
      }
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public com.tencent.luggage.wxa.oa.b a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    synchronized (this.k)
    {
      Iterator localIterator = this.k.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.luggage.wxa.oa.b localb = (com.tencent.luggage.wxa.oa.b)localIterator.next();
        if (paramString.equals(localb.c())) {
          return localb;
        }
      }
      return null;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void a()
  {
    synchronized (this.k)
    {
      Iterator localIterator = this.k.iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.luggage.wxa.oa.b)localIterator.next()).a(false);
      }
      this.k.clear();
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void a(com.tencent.luggage.wxa.oa.b paramb)
  {
    if (paramb == null) {
      return;
    }
    this.c.add(paramb.c());
    d(paramb.c());
    paramb.b();
  }
  
  public void a(JSONObject arg1, int paramInt1, Map<String, String> arg3, ArrayList<String> paramArrayList, int paramInt2, b.a parama, String paramString1, String paramString2)
  {
    String str = ???.optString("url");
    o.d("MicroMsg.AppBrandNetworkDownload", "download taskId:%s url:%s", new Object[] { paramString1, str });
    str = j.c(str);
    synchronized (this.k)
    {
      if (this.k.size() >= this.d)
      {
        parama.a(-1, "max_connected");
        o.d("MicroMsg.AppBrandNetworkDownload", "max connected mDownloadTaskList.size():%d,mMaxConnected:%d", new Object[] { Integer.valueOf(this.k.size()), Integer.valueOf(this.d) });
        return;
      }
      ??? = ???.optString("filePath");
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.e);
      ((StringBuilder)localObject2).append(q.a(str));
      ((StringBuilder)localObject2).append("temp");
      ((StringBuilder)localObject2).append(System.currentTimeMillis());
      localObject2 = ((StringBuilder)localObject2).toString();
      boolean bool1 = ???.optBoolean("enableHttp2", false);
      boolean bool2 = ???.optBoolean("enableQuic", false);
      boolean bool3 = ???.optBoolean("enableCache", false);
      boolean bool4 = ???.optBoolean("enableProfile", true);
      o.d("MicroMsg.AppBrandNetworkDownload", "download taskId %s,useHttp2 %b, useQuic %b, useMemoryCache %b, useProfile %b", new Object[] { paramString1, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
      parama = new com.tencent.luggage.wxa.oa.b(this.i, str, (String)localObject2, (String)???, this.h, this.f, bool1, bool2, bool3, bool4, new b.1(this, paramString1, parama));
      parama.a(???);
      parama.a(paramInt1);
      parama.a(true);
      parama.a(paramArrayList);
      parama.b(paramInt2);
      parama.a(this.g);
      parama.a(paramString1);
      parama.b(paramString2);
      synchronized (this.k)
      {
        this.k.add(parama);
        synchronized (this.j)
        {
          if (!this.j.containsKey(str))
          {
            ??? = new ConcurrentLinkedQueue();
            this.j.put(str, ???);
          }
          else
          {
            ??? = (ConcurrentLinkedQueue)this.j.get(str);
          }
          ???.offer(parama);
          if ((this.j.get(str) != null) && (((ConcurrentLinkedQueue)this.j.get(str)).size() > 1))
          {
            o.d("MicroMsg.AppBrandNetworkDownload", "hy: more than one same url in the queue, just add and wait");
            return;
          }
          c(str);
          return;
        }
      }
    }
  }
  
  public boolean b(String paramString)
  {
    return this.c.contains(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nz.b
 * JD-Core Version:    0.7.0.1
 */