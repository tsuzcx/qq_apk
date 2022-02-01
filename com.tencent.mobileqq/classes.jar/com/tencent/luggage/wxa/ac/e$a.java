package com.tencent.luggage.wxa.ac;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.luggage.wxa.ab.d;
import com.tencent.luggage.wxa.am.t;
import com.tencent.luggage.wxa.am.t.a;
import com.tencent.luggage.wxa.am.u;
import com.tencent.luggage.wxa.ao.w;
import com.tencent.luggage.wxa.h.p;
import java.io.IOException;
import java.util.List;

final class e$a
  implements t.a<u<c>>, Runnable
{
  private final a.a b;
  private final t c;
  private final u<c> d;
  private b e;
  private long f;
  private long g;
  private long h;
  private long i;
  private boolean j;
  private IOException k;
  
  public e$a(e parame, a.a parama)
  {
    this.b = parama;
    this.c = new t("HlsPlaylistTracker:MediaPlaylist");
    this.d = new u(e.a(parame).a(4), w.a(e.b(parame).o, parama.a), 4, e.c(parame));
  }
  
  private void a(b paramb)
  {
    b localb1 = this.e;
    long l2 = SystemClock.elapsedRealtime();
    this.f = l2;
    this.e = e.a(this.a, localb1, paramb);
    b localb2 = this.e;
    if (localb2 != localb1)
    {
      this.k = null;
      this.g = l2;
      e.a(this.a, this.b, localb2);
    }
    else if (!localb2.j)
    {
      if (paramb.f + paramb.m.size() < this.e.f)
      {
        this.k = new e.c(this.b.a, null);
      }
      else
      {
        double d1 = l2 - this.g;
        double d2 = com.tencent.luggage.wxa.h.b.a(this.e.h);
        Double.isNaN(d2);
        if (d1 > d2 * 3.5D)
        {
          this.k = new e.d(this.b.a, null);
          g();
        }
      }
    }
    paramb = this.e;
    long l1;
    if (paramb != localb1) {
      l1 = paramb.h;
    } else {
      l1 = paramb.h / 2L;
    }
    this.h = (l2 + com.tencent.luggage.wxa.h.b.a(l1));
    if ((this.b == e.g(this.a)) && (!this.e.j)) {
      d();
    }
  }
  
  private void f()
  {
    this.c.a(this.d, this, e.f(this.a));
  }
  
  private boolean g()
  {
    this.i = (SystemClock.elapsedRealtime() + 60000L);
    e.a(this.a, this.b, 60000L);
    return (e.g(this.a) == this.b) && (!e.h(this.a));
  }
  
  public int a(u<c> paramu, long paramLong1, long paramLong2, IOException paramIOException)
  {
    boolean bool = paramIOException instanceof p;
    e.e(this.a).a(paramu.a, 4, paramLong1, paramLong2, paramu.e(), paramIOException, bool);
    if (bool) {
      return 3;
    }
    bool = true;
    if (com.tencent.luggage.wxa.aa.b.a(paramIOException)) {
      bool = g();
    }
    if (bool) {
      return 0;
    }
    return 2;
  }
  
  public b a()
  {
    return this.e;
  }
  
  public void a(u<c> paramu, long paramLong1, long paramLong2)
  {
    Object localObject = (c)paramu.d();
    if ((localObject instanceof b))
    {
      localObject = (b)localObject;
      a((b)localObject);
      if (((b)localObject).j) {
        e.e(this.a).a();
      }
      e.e(this.a).a(paramu.a, 4, paramLong1, paramLong2, paramu.e());
      return;
    }
    this.k = new p("Loaded playlist has unexpected type.");
  }
  
  public void a(u<c> paramu, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    e.e(this.a).b(paramu.a, 4, paramLong1, paramLong2, paramu.e());
  }
  
  public boolean b()
  {
    b localb = this.e;
    boolean bool = false;
    if (localb == null) {
      return false;
    }
    long l1 = SystemClock.elapsedRealtime();
    long l2 = Math.max(30000L, com.tencent.luggage.wxa.h.b.a(this.e.n));
    if ((this.e.j) || (this.e.a == 2) || (this.e.a == 1) || (this.f + l2 > l1)) {
      bool = true;
    }
    return bool;
  }
  
  public void c()
  {
    this.c.c();
  }
  
  public void d()
  {
    this.i = 0L;
    if (!this.j)
    {
      if (this.c.a()) {
        return;
      }
      long l = SystemClock.elapsedRealtime();
      if (l < this.h)
      {
        this.j = true;
        e.d(this.a).postDelayed(this, this.h - l);
        return;
      }
      f();
    }
  }
  
  public void e()
  {
    this.c.d();
    IOException localIOException = this.k;
    if (localIOException == null) {
      return;
    }
    throw localIOException;
  }
  
  public void run()
  {
    this.j = false;
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ac.e.a
 * JD-Core Version:    0.7.0.1
 */