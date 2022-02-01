package com.tencent.luggage.wxa.ov;

import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.ou.j;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.c;
import com.tencent.luggage.wxa.qz.o;
import java.util.LinkedList;
import junit.framework.a;

public class b
{
  protected final j a;
  private volatile String b;
  private volatile String c;
  private volatile d d;
  private volatile long e = 0L;
  private volatile long f = 0L;
  private final LinkedList<Runnable> g = new LinkedList();
  
  public b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MicroMsg.AppBrandPageViewStatistics[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    this.a = new j(localStringBuilder.toString());
  }
  
  public void a(d paramd)
  {
    this.c = paramd.aa();
    this.d = paramd;
  }
  
  public void a(String paramString)
  {
    this.e = af.d();
    this.b = paramString;
  }
  
  public boolean a()
  {
    return (this.e > 0L) && (this.f <= 0L);
  }
  
  public long b()
  {
    return this.e;
  }
  
  public long c()
  {
    return Math.max(0L, this.f);
  }
  
  public void d()
  {
    this.f = (af.d() - this.e);
  }
  
  public long e()
  {
    if ((!h()) && (!i())) {
      return 0L;
    }
    long l1 = this.a.e();
    long l2 = this.e;
    long l3 = this.f;
    if (l1 <= 0L)
    {
      boolean bool;
      if ((this.d != null) && (this.d.av())) {
        bool = true;
      } else {
        bool = false;
      }
      o.d("MicroMsg.AppBrandPageViewStatistics", "foregroundMs invalid(%d), loadStart %d, loadCost %d, [%s/%s], runtimeIsFinishing=%b", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), this.c, this.b, Boolean.valueOf(bool) });
      if ((c.a) && (!bool)) {
        a.a("foregroundStayTime cant be MINUS, call @smoothieli to fix this");
      }
      if ((l2 > 0L) && (l3 > 0L) && (l1 == 0L)) {
        return af.d() - l2;
      }
    }
    return Math.max(0L, l1);
  }
  
  public void f()
  {
    if (this.a.d()) {
      while (!this.g.isEmpty()) {
        ((Runnable)this.g.pollFirst()).run();
      }
    }
  }
  
  public void g()
  {
    if (this.e <= 0L) {
      return;
    }
    if (this.a.c()) {
      this.g.clear();
    }
  }
  
  public boolean h()
  {
    return this.a.a();
  }
  
  public boolean i()
  {
    return this.a.b();
  }
  
  public void j()
  {
    this.a.d();
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ov.b
 * JD-Core Version:    0.7.0.1
 */