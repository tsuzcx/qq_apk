package com.tencent.luggage.wxa.bu;

import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.iu.c.c;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.q;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;
import com.tencent.magicbrush.MBRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

public class a
{
  private static a q;
  public boolean a;
  public int b;
  public double c;
  public int d = 1004;
  c.c e = new a.3(this);
  private int f = 0;
  private long g = 0L;
  private long h = 0L;
  private String i = "";
  private boolean j = false;
  private com.tencent.magicbrush.d k;
  private int l = -1;
  private float m = -1.0F;
  private ArrayList<String> n;
  private CopyOnWriteArrayList<Long> o = new CopyOnWriteArrayList();
  private final a.a p = new a.a(null);
  
  public static a a()
  {
    if (q == null) {
      try
      {
        if (q == null) {
          q = new a();
        }
      }
      finally {}
    }
    return q;
  }
  
  private void a(a.b paramb, CopyOnWriteArrayList<Long> paramCopyOnWriteArrayList)
  {
    int i1 = paramCopyOnWriteArrayList.size();
    o.d("MicroMsg.MBNiReporter", "hy: calculateAverageCost size:%d", new Object[] { Integer.valueOf(i1) });
    paramCopyOnWriteArrayList = (Long[])Arrays.copyOf(paramCopyOnWriteArrayList.toArray(new Long[0]), i1);
    if (paramCopyOnWriteArrayList != null)
    {
      if (paramCopyOnWriteArrayList.length <= 0) {
        return;
      }
      double d1 = 0.0D;
      int i2 = paramCopyOnWriteArrayList.length;
      i1 = 0;
      while (i1 < i2)
      {
        if (paramCopyOnWriteArrayList[i1] == null)
        {
          o.h("MicroMsg.MBNiReporter", "calculateAverageCost tempArray[%d] null!", new Object[] { Integer.valueOf(i1) });
        }
        else
        {
          d2 = paramCopyOnWriteArrayList[i1].longValue();
          Double.isNaN(d2);
          d1 += d2;
        }
        i1 += 1;
      }
      double d2 = i2;
      Double.isNaN(d2);
      d2 = d1 / d2;
      paramb.a = paramCopyOnWriteArrayList.length;
      paramb.b = (d1);
      paramb.c = d2;
    }
  }
  
  private void a(a.c paramc, CopyOnWriteArrayList<Long> paramCopyOnWriteArrayList)
  {
    if (paramCopyOnWriteArrayList.size() < this.f) {
      return;
    }
    int i1 = 0;
    paramCopyOnWriteArrayList = (Long[])Arrays.copyOf(paramCopyOnWriteArrayList.toArray(new Long[0]), this.f);
    if (paramCopyOnWriteArrayList != null)
    {
      if (paramCopyOnWriteArrayList.length <= 0) {
        return;
      }
      double d1 = 0.0D;
      int i2 = paramCopyOnWriteArrayList.length;
      while (i1 < i2)
      {
        d2 = paramCopyOnWriteArrayList[i1].longValue();
        Double.isNaN(d2);
        d1 += d2;
        i1 += 1;
      }
      double d2 = i2;
      Double.isNaN(d2);
      d2 = d1 / d2;
      paramc.a = paramCopyOnWriteArrayList.length;
      paramc.b = (d1);
      paramc.c = d2;
    }
  }
  
  private void a(String paramString, com.github.henryye.nativeiv.api.a parama)
  {
    f.a.c(new a.6(this, paramString, parama));
  }
  
  private void b(String paramString, com.github.henryye.nativeiv.api.a parama)
  {
    if (parama.a().equalsIgnoreCase("base64"))
    {
      paramString = q.a(paramString);
      this.n.add(paramString);
      ((com.tencent.luggage.wxa.ot.d)e.b(com.tencent.luggage.wxa.ot.d.class)).a(18076, new Object[] { "", parama.a(), this.i, Integer.valueOf(this.d), Long.valueOf(parama.b()), Long.valueOf(parama.f()), Long.valueOf(parama.g()) });
      return;
    }
    this.n.add(paramString);
    ((com.tencent.luggage.wxa.ot.d)e.b(com.tencent.luggage.wxa.ot.d.class)).a(18076, new Object[] { paramString, parama.a(), this.i, Integer.valueOf(this.d), Long.valueOf(parama.b()), Long.valueOf(parama.f()), Long.valueOf(parama.g()) });
  }
  
  private void d()
  {
    o.d("MicroMsg.MBNiReporter", "hy: initStatis!");
    ??? = this.o;
    if ((??? != null) && (((CopyOnWriteArrayList)???).size() > 0)) {
      this.o.clear();
    }
    synchronized (this.p)
    {
      if (this.p.size() > 0) {
        this.p.clear();
      }
      this.j = false;
      this.f = 0;
      this.g = 0L;
      this.h = 0L;
      return;
    }
  }
  
  private void e()
  {
    a.a locala = this.p;
    int i1 = 0;
    try
    {
      while (i1 < this.p.size())
      {
        int i2 = this.p.keyAt(i1);
        int i3 = this.p.valueAt(i1);
        o.d("MicroMsg.MBNiReporter", "hy: picSize level:%d,num:%d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i3) });
        ((com.tencent.luggage.wxa.ot.c)e.b(com.tencent.luggage.wxa.ot.c.class)).a(936L, i2, i3, false);
        i1 += 1;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void a(long paramLong)
  {
    this.o.add(Long.valueOf(paramLong));
  }
  
  public void a(long paramLong1, long paramLong2, String paramString, com.github.henryye.nativeiv.api.a parama)
  {
    b(paramLong1);
    a(paramLong2);
    a(paramString, parama);
  }
  
  public void a(MBRuntime paramMBRuntime)
  {
    this.h = af.b();
    try
    {
      this.k = paramMBRuntime.n();
    }
    catch (NullPointerException paramMBRuntime)
    {
      o.a("MicroMsg.MBNiReporter", paramMBRuntime, "inspector null pointer!", new Object[0]);
    }
    paramMBRuntime = this.k;
    if (paramMBRuntime != null) {
      this.l = paramMBRuntime.c();
    }
    f.a.c(new a.1(this));
    f.a.b(new a.2(this), 10L);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.i = paramString;
    o.d("MicroMsg.MBNiReporter", "hy: appId:%s,isGame:%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      com.tencent.luggage.wxa.iu.c.a(paramString, this.e);
    }
    this.n = new ArrayList();
    if (paramBoolean)
    {
      this.d = 1004;
      return;
    }
    this.d = 1000;
  }
  
  public void a(boolean paramBoolean, int paramInt, double paramDouble)
  {
    try
    {
      o.d("MicroMsg.MBNiReporter", "setConfig shouldDoSample:%b,maxSampleNum:%d,sampleRate:%f", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Double.valueOf(paramDouble) });
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.MBNiReporter", localException, "setConfig Exception", new Object[0]);
    }
    this.a = paramBoolean;
    this.b = paramInt;
    this.c = paramDouble;
  }
  
  public void b()
  {
    if (this.j)
    {
      o.d("MicroMsg.MBNiReporter", "hy: hasReported!");
      return;
    }
    f.a.c(new a.5(this));
  }
  
  public void b(long paramLong)
  {
    f.a.c(new a.4(this, paramLong));
  }
  
  public void c()
  {
    o.d("MicroMsg.MBNiReporter", "hy: release!");
    com.tencent.luggage.wxa.iu.c.b(this.i, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bu.a
 * JD-Core Version:    0.7.0.1
 */