package com.tencent.luggage.wxa.z;

import android.net.Uri;
import android.os.Handler;
import com.tencent.luggage.wxa.am.b;
import com.tencent.luggage.wxa.am.t;
import com.tencent.luggage.wxa.am.t.a;
import com.tencent.luggage.wxa.am.t.d;
import com.tencent.luggage.wxa.ao.a;
import com.tencent.luggage.wxa.l.d;
import java.io.IOException;
import java.util.Arrays;

final class e
  implements t.a<e.a>, t.d, com.tencent.luggage.wxa.l.f, g, j.b
{
  private boolean[] A;
  private boolean[] B;
  private boolean C;
  private long D;
  private long E;
  private long F;
  private int G;
  private boolean H;
  private boolean I;
  private final Uri a;
  private final com.tencent.luggage.wxa.am.g b;
  private final int c;
  private final Handler d;
  private final f.a e;
  private final e.c f;
  private final b g;
  private final String h;
  private final long i;
  private final t j;
  private final e.b k;
  private final com.tencent.luggage.wxa.ao.f l;
  private final Runnable m;
  private final Runnable n;
  private final Handler o;
  private g.a p;
  private com.tencent.luggage.wxa.l.k q;
  private j[] r;
  private int[] s;
  private boolean t;
  private boolean u;
  private boolean v;
  private boolean w;
  private int x;
  private o y;
  private long z;
  
  public e(Uri paramUri, com.tencent.luggage.wxa.am.g paramg, d[] paramArrayOfd, int paramInt1, Handler paramHandler, f.a parama, e.c paramc, b paramb, String paramString, int paramInt2)
  {
    this.a = paramUri;
    this.b = paramg;
    this.c = paramInt1;
    this.d = paramHandler;
    this.e = parama;
    this.f = paramc;
    this.g = paramb;
    this.h = paramString;
    this.i = paramInt2;
    this.j = new t("Loader:ExtractorMediaPeriod");
    this.k = new e.b(paramArrayOfd, this);
    this.l = new com.tencent.luggage.wxa.ao.f();
    this.m = new e.1(this);
    this.n = new e.2(this);
    this.o = new Handler();
    this.s = new int[0];
    this.r = new j[0];
    this.F = -9223372036854775807L;
    this.D = -1L;
  }
  
  private void a(e.a parama)
  {
    if (this.D == -1L) {
      this.D = e.a.a(parama);
    }
  }
  
  private boolean a(IOException paramIOException)
  {
    return paramIOException instanceof p;
  }
  
  private void b(e.a parama)
  {
    if (this.D == -1L)
    {
      Object localObject = this.q;
      if ((localObject != null) && (((com.tencent.luggage.wxa.l.k)localObject).b() != -9223372036854775807L)) {
        return;
      }
      this.E = 0L;
      this.w = this.u;
      localObject = this.r;
      int i2 = localObject.length;
      int i1 = 0;
      while (i1 < i2)
      {
        localObject[i1].a();
        i1 += 1;
      }
      parama.a(0L, 0L);
    }
  }
  
  private void b(IOException paramIOException)
  {
    Handler localHandler = this.d;
    if ((localHandler != null) && (this.e != null)) {
      localHandler.post(new e.3(this, paramIOException));
    }
  }
  
  private boolean d(long paramLong)
  {
    int i2 = this.r.length;
    int i1 = 0;
    while (i1 < i2)
    {
      j localj = this.r[i1];
      localj.i();
      if ((!localj.b(paramLong, true, false)) && ((this.B[i1] != 0) || (!this.C))) {
        return false;
      }
      localj.j();
      i1 += 1;
    }
    return true;
  }
  
  private void i()
  {
    if ((!this.I) && (!this.u) && (this.q != null))
    {
      if (!this.t) {
        return;
      }
      Object localObject1 = this.r;
      int i2 = localObject1.length;
      int i1 = 0;
      while (i1 < i2)
      {
        if (localObject1[i1].g() == null) {
          return;
        }
        i1 += 1;
      }
      this.l.b();
      i2 = this.r.length;
      localObject1 = new n[i2];
      this.B = new boolean[i2];
      this.A = new boolean[i2];
      this.z = this.q.b();
      i1 = 0;
      for (;;)
      {
        int i4 = 1;
        if (i1 >= i2) {
          break;
        }
        Object localObject2 = this.r[i1].g();
        localObject1[i1] = new n(new com.tencent.luggage.wxa.h.k[] { localObject2 });
        localObject2 = ((com.tencent.luggage.wxa.h.k)localObject2).f;
        int i3 = i4;
        if (!com.tencent.luggage.wxa.ao.j.b((String)localObject2)) {
          if (com.tencent.luggage.wxa.ao.j.a((String)localObject2)) {
            i3 = i4;
          } else {
            i3 = 0;
          }
        }
        this.B[i1] = i3;
        this.C = (i3 | this.C);
        i1 += 1;
      }
      this.y = new o((n[])localObject1);
      this.u = true;
      this.f.a(this.z, this.q.a());
      this.p.a(this);
    }
  }
  
  private void j()
  {
    e.a locala = new e.a(this, this.a, this.b, this.k, this.l);
    if (this.u)
    {
      a.b(m());
      long l1 = this.z;
      if ((l1 != -9223372036854775807L) && (this.F >= l1))
      {
        this.H = true;
        this.F = -9223372036854775807L;
        return;
      }
      locala.a(this.q.b(this.F), this.F);
      this.F = -9223372036854775807L;
    }
    this.G = k();
    int i2 = this.c;
    int i1 = i2;
    if (i2 == -1)
    {
      if ((this.u) && (this.D == -1L))
      {
        com.tencent.luggage.wxa.l.k localk = this.q;
        if ((localk == null) || (localk.b() == -9223372036854775807L))
        {
          i1 = 6;
          break label178;
        }
      }
      i1 = 3;
    }
    label178:
    this.j.a(locala, this, i1);
  }
  
  private int k()
  {
    j[] arrayOfj = this.r;
    int i3 = arrayOfj.length;
    int i1 = 0;
    int i2 = 0;
    while (i1 < i3)
    {
      i2 += arrayOfj[i1].c();
      i1 += 1;
    }
    return i2;
  }
  
  private long l()
  {
    j[] arrayOfj = this.r;
    int i2 = arrayOfj.length;
    long l1 = -9223372036854775808L;
    int i1 = 0;
    while (i1 < i2)
    {
      l1 = Math.max(l1, arrayOfj[i1].h());
      i1 += 1;
    }
    return l1;
  }
  
  private boolean m()
  {
    return this.F != -9223372036854775807L;
  }
  
  int a(int paramInt, com.tencent.luggage.wxa.h.l paraml, com.tencent.luggage.wxa.j.e parame, boolean paramBoolean)
  {
    if ((!this.w) && (!m())) {
      return this.r[paramInt].a(paraml, parame, paramBoolean, this.H, this.E);
    }
    return -3;
  }
  
  public int a(e.a parama, long paramLong1, long paramLong2, IOException paramIOException)
  {
    a(parama);
    b(paramIOException);
    if (a(paramIOException)) {
      return 3;
    }
    int i1;
    if (k() > this.G) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    b(parama);
    this.G = k();
    return i1;
  }
  
  public long a(com.tencent.luggage.wxa.al.e[] paramArrayOfe, boolean[] paramArrayOfBoolean1, k[] paramArrayOfk, boolean[] paramArrayOfBoolean2, long paramLong)
  {
    a.b(this.u);
    int i2 = this.x;
    int i5 = 0;
    int i6 = 0;
    int i4 = 0;
    int i1 = 0;
    while (i1 < paramArrayOfe.length)
    {
      if ((paramArrayOfk[i1] != null) && ((paramArrayOfe[i1] == null) || (paramArrayOfBoolean1[i1] == 0)))
      {
        i3 = e.d.a((e.d)paramArrayOfk[i1]);
        a.b(this.A[i3]);
        this.x -= 1;
        this.A[i3] = false;
        paramArrayOfk[i1] = null;
      }
      i1 += 1;
    }
    if (this.v ? i2 == 0 : paramLong != 0L) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    i2 = 0;
    for (int i3 = i1; i2 < paramArrayOfe.length; i3 = i1)
    {
      i1 = i3;
      if (paramArrayOfk[i2] == null)
      {
        i1 = i3;
        if (paramArrayOfe[i2] != null)
        {
          paramArrayOfBoolean1 = paramArrayOfe[i2];
          boolean bool;
          if (paramArrayOfBoolean1.e() == 1) {
            bool = true;
          } else {
            bool = false;
          }
          a.b(bool);
          if (paramArrayOfBoolean1.b(0) == 0) {
            bool = true;
          } else {
            bool = false;
          }
          a.b(bool);
          int i7 = this.y.a(paramArrayOfBoolean1.d());
          a.b(this.A[i7] ^ 0x1);
          this.x += 1;
          this.A[i7] = true;
          paramArrayOfk[i2] = new e.d(this, i7);
          paramArrayOfBoolean2[i2] = true;
          i1 = i3;
          if (i3 == 0)
          {
            paramArrayOfBoolean1 = this.r[i7];
            paramArrayOfBoolean1.i();
            if ((!paramArrayOfBoolean1.b(paramLong, true, true)) && (paramArrayOfBoolean1.e() != 0)) {
              i1 = 1;
            } else {
              i1 = 0;
            }
          }
        }
      }
      i2 += 1;
    }
    long l1;
    if (this.x == 0)
    {
      this.w = false;
      if (this.j.a())
      {
        paramArrayOfe = this.r;
        i2 = paramArrayOfe.length;
        i1 = i4;
        while (i1 < i2)
        {
          paramArrayOfe[i1].k();
          i1 += 1;
        }
        this.j.b();
        l1 = paramLong;
      }
      else
      {
        paramArrayOfe = this.r;
        i2 = paramArrayOfe.length;
        i1 = i5;
        for (;;)
        {
          l1 = paramLong;
          if (i1 >= i2) {
            break;
          }
          paramArrayOfe[i1].a();
          i1 += 1;
        }
      }
    }
    else
    {
      l1 = paramLong;
      if (i3 != 0)
      {
        paramLong = b(paramLong);
        i1 = i6;
        for (;;)
        {
          l1 = paramLong;
          if (i1 >= paramArrayOfk.length) {
            break;
          }
          if (paramArrayOfk[i1] != null) {
            paramArrayOfBoolean2[i1] = true;
          }
          i1 += 1;
        }
      }
    }
    this.v = true;
    return l1;
  }
  
  public com.tencent.luggage.wxa.l.l a(int paramInt1, int paramInt2)
  {
    int i1 = this.r.length;
    paramInt2 = 0;
    while (paramInt2 < i1)
    {
      if (this.s[paramInt2] == paramInt1) {
        return this.r[paramInt2];
      }
      paramInt2 += 1;
    }
    j localj = new j(this.g);
    localj.a(this);
    int[] arrayOfInt = this.s;
    paramInt2 = i1 + 1;
    this.s = Arrays.copyOf(arrayOfInt, paramInt2);
    this.s[i1] = paramInt1;
    this.r = ((j[])Arrays.copyOf(this.r, paramInt2));
    this.r[i1] = localj;
    return localj;
  }
  
  public void a()
  {
    this.t = true;
    this.o.post(this.m);
  }
  
  void a(int paramInt, long paramLong)
  {
    j localj = this.r[paramInt];
    if ((this.H) && (paramLong > localj.h()))
    {
      localj.l();
      return;
    }
    localj.b(paramLong, true, true);
  }
  
  public void a(long paramLong)
  {
    int i2 = this.r.length;
    int i1 = 0;
    while (i1 < i2)
    {
      this.r[i1].a(paramLong, false, this.A[i1]);
      i1 += 1;
    }
  }
  
  public void a(com.tencent.luggage.wxa.h.k paramk)
  {
    this.o.post(this.m);
  }
  
  public void a(com.tencent.luggage.wxa.l.k paramk)
  {
    this.q = paramk;
    this.o.post(this.m);
  }
  
  public void a(e.a parama, long paramLong1, long paramLong2)
  {
    a(parama);
    this.H = true;
    if (this.z == -9223372036854775807L)
    {
      paramLong1 = l();
      if (paramLong1 == -9223372036854775808L) {
        paramLong1 = 0L;
      } else {
        paramLong1 += 10000L;
      }
      this.z = paramLong1;
      this.f.a(this.z, this.q.a());
    }
    this.p.a(this);
  }
  
  public void a(e.a parama, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    a(parama);
    parama = this.r;
    int i2 = parama.length;
    int i1 = 0;
    while (i1 < i2)
    {
      parama[i1].a();
      i1 += 1;
    }
    if (this.x > 0) {
      this.p.a(this);
    }
  }
  
  public void a(g.a parama, long paramLong)
  {
    this.p = parama;
    this.l.a();
    j();
  }
  
  boolean a(int paramInt)
  {
    return (this.H) || ((!m()) && (this.r[paramInt].d()));
  }
  
  public long b(long paramLong)
  {
    if (!this.q.a()) {
      paramLong = 0L;
    }
    this.E = paramLong;
    int i1 = 0;
    this.w = false;
    if ((!m()) && (d(paramLong))) {
      return paramLong;
    }
    this.F = paramLong;
    this.H = false;
    if (this.j.a())
    {
      this.j.b();
      return paramLong;
    }
    j[] arrayOfj = this.r;
    int i2 = arrayOfj.length;
    while (i1 < i2)
    {
      arrayOfj[i1].a();
      i1 += 1;
    }
    return paramLong;
  }
  
  public o b()
  {
    return this.y;
  }
  
  public long c()
  {
    if (this.w)
    {
      this.w = false;
      return this.E;
    }
    return -9223372036854775807L;
  }
  
  public boolean c(long paramLong)
  {
    if ((!this.H) && ((!this.u) || (this.x != 0)))
    {
      boolean bool = this.l.a();
      if (!this.j.a())
      {
        j();
        bool = true;
      }
      return bool;
    }
    return false;
  }
  
  public long d()
  {
    if (this.H) {
      return -9223372036854775808L;
    }
    if (m()) {
      return this.F;
    }
    if (this.C)
    {
      l1 = 9223372036854775807L;
      int i2 = this.r.length;
      int i1 = 0;
      for (;;)
      {
        l2 = l1;
        if (i1 >= i2) {
          break;
        }
        l2 = l1;
        if (this.B[i1] != 0) {
          l2 = Math.min(l1, this.r[i1].h());
        }
        i1 += 1;
        l1 = l2;
      }
    }
    long l2 = l();
    long l1 = l2;
    if (l2 == -9223372036854775808L) {
      l1 = this.E;
    }
    return l1;
  }
  
  public void d_()
  {
    h();
  }
  
  public long e()
  {
    if (this.x == 0) {
      return -9223372036854775808L;
    }
    return d();
  }
  
  public void f()
  {
    boolean bool = this.j.a(this);
    if ((this.u) && (!bool))
    {
      j[] arrayOfj = this.r;
      int i2 = arrayOfj.length;
      int i1 = 0;
      while (i1 < i2)
      {
        arrayOfj[i1].k();
        i1 += 1;
      }
    }
    this.o.removeCallbacksAndMessages(null);
    this.I = true;
  }
  
  public void g()
  {
    this.k.a();
    j[] arrayOfj = this.r;
    int i2 = arrayOfj.length;
    int i1 = 0;
    while (i1 < i2)
    {
      arrayOfj[i1].a();
      i1 += 1;
    }
  }
  
  void h()
  {
    this.j.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.z.e
 * JD-Core Version:    0.7.0.1
 */