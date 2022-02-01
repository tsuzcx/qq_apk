package com.tencent.luggage.wxa.p;

import com.tencent.luggage.wxa.ao.x;
import com.tencent.luggage.wxa.h.p;
import com.tencent.luggage.wxa.l.d;
import com.tencent.luggage.wxa.l.e;
import com.tencent.luggage.wxa.l.f;
import com.tencent.luggage.wxa.l.h;
import com.tencent.luggage.wxa.l.l;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public final class g
  implements d, com.tencent.luggage.wxa.l.k
{
  public static final com.tencent.luggage.wxa.l.g a = new g.1();
  private static final int b = x.f("qt  ");
  private final int c;
  private final com.tencent.luggage.wxa.ao.m d;
  private final com.tencent.luggage.wxa.ao.m e;
  private final com.tencent.luggage.wxa.ao.m f;
  private final Stack<a.a> g;
  private int h;
  private int i;
  private long j;
  private int k;
  private com.tencent.luggage.wxa.ao.m l;
  private int m;
  private int n;
  private f o;
  private g.a[] p;
  private long q;
  private boolean r;
  
  public g()
  {
    this(0);
  }
  
  public g(int paramInt)
  {
    this.c = paramInt;
    this.f = new com.tencent.luggage.wxa.ao.m(16);
    this.g = new Stack();
    this.d = new com.tencent.luggage.wxa.ao.m(com.tencent.luggage.wxa.ao.k.a);
    this.e = new com.tencent.luggage.wxa.ao.m(4);
  }
  
  private void a(long paramLong)
  {
    while ((!this.g.isEmpty()) && (((a.a)this.g.peek()).aQ == paramLong))
    {
      a.a locala = (a.a)this.g.pop();
      if (locala.aP == a.B)
      {
        a(locala);
        this.g.clear();
        this.h = 2;
      }
      else if (!this.g.isEmpty())
      {
        ((a.a)this.g.peek()).a(locala);
      }
    }
    if (this.h != 2) {
      d();
    }
  }
  
  private void a(a.a parama)
  {
    ArrayList localArrayList = new ArrayList();
    h localh = new h();
    Object localObject1 = parama.d(a.aA);
    Object localObject3;
    if (localObject1 != null)
    {
      localObject1 = b.a((a.b)localObject1, this.r);
      localObject3 = localObject1;
      if (localObject1 != null)
      {
        localh.a((com.tencent.luggage.wxa.v.a)localObject1);
        localObject3 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
    }
    long l1 = 9223372036854775807L;
    long l3 = -9223372036854775807L;
    int i1 = 0;
    while (i1 < parama.aS.size())
    {
      localObject1 = (a.a)parama.aS.get(i1);
      j localj;
      m localm;
      if (((a.a)localObject1).aP == a.D)
      {
        localObject2 = parama.d(a.C);
        boolean bool;
        if ((this.c & 0x1) != 0) {
          bool = true;
        } else {
          bool = false;
        }
        localj = b.a((a.a)localObject1, (a.b)localObject2, -9223372036854775807L, null, bool, this.r);
        if (localj != null)
        {
          localm = b.a(localj, ((a.a)localObject1).e(a.E).e(a.F).e(a.G), localh);
          if (localm.a != 0) {
            break label222;
          }
        }
      }
      long l2 = l1;
      break label397;
      label222:
      g.a locala = new g.a(localj, localm, this.o.a(i1, localj.b));
      int i2 = localm.d;
      com.tencent.luggage.wxa.h.k localk = localj.f.a(i2 + 30);
      Object localObject2 = localk;
      if (localj.b == 1)
      {
        localObject1 = localk;
        if (localh.a()) {
          localObject1 = localk.a(localh.b, localh.c);
        }
        localObject2 = localObject1;
        if (localObject3 != null) {
          localObject2 = ((com.tencent.luggage.wxa.h.k)localObject1).a(localObject3);
        }
      }
      locala.c.a((com.tencent.luggage.wxa.h.k)localObject2);
      long l4 = Math.max(l3, localj.e);
      localArrayList.add(locala);
      long l5 = localm.b[0];
      l3 = l4;
      l2 = l1;
      if (l5 < l1)
      {
        l2 = l5;
        l3 = l4;
      }
      label397:
      i1 += 1;
      l1 = l2;
    }
    this.q = l3;
    this.p = ((g.a[])localArrayList.toArray(new g.a[localArrayList.size()]));
    this.o.a();
    this.o.a(this);
  }
  
  private static boolean a(int paramInt)
  {
    return (paramInt == a.R) || (paramInt == a.C) || (paramInt == a.S) || (paramInt == a.T) || (paramInt == a.am) || (paramInt == a.an) || (paramInt == a.ao) || (paramInt == a.Q) || (paramInt == a.ap) || (paramInt == a.aq) || (paramInt == a.ar) || (paramInt == a.as) || (paramInt == a.at) || (paramInt == a.O) || (paramInt == a.a) || (paramInt == a.aA);
  }
  
  private static boolean a(com.tencent.luggage.wxa.ao.m paramm)
  {
    paramm.c(8);
    if (paramm.n() == b) {
      return true;
    }
    paramm.d(4);
    while (paramm.b() > 0) {
      if (paramm.n() == b) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean b(int paramInt)
  {
    return (paramInt == a.B) || (paramInt == a.D) || (paramInt == a.E) || (paramInt == a.F) || (paramInt == a.G) || (paramInt == a.P);
  }
  
  private boolean b(e parame)
  {
    if (this.k == 0)
    {
      if (!parame.a(this.f.a, 0, 8, true)) {
        return false;
      }
      this.k = 8;
      this.f.c(0);
      this.j = this.f.l();
      this.i = this.f.n();
    }
    long l1 = this.j;
    if (l1 == 1L)
    {
      parame.b(this.f.a, 8, 8);
      this.k += 8;
      this.j = this.f.v();
    }
    else if (l1 == 0L)
    {
      long l2 = parame.d();
      l1 = l2;
      if (l2 == -1L)
      {
        l1 = l2;
        if (!this.g.isEmpty()) {
          l1 = ((a.a)this.g.peek()).aQ;
        }
      }
      if (l1 != -1L) {
        this.j = (l1 - parame.c() + this.k);
      }
    }
    if (this.j >= this.k)
    {
      if (b(this.i))
      {
        l1 = parame.c() + this.j - this.k;
        this.g.add(new a.a(this.i, l1));
        if (this.j == this.k)
        {
          a(l1);
          return true;
        }
        d();
        return true;
      }
      if (a(this.i))
      {
        boolean bool;
        if (this.k == 8) {
          bool = true;
        } else {
          bool = false;
        }
        com.tencent.luggage.wxa.ao.a.b(bool);
        if (this.j <= 2147483647L) {
          bool = true;
        } else {
          bool = false;
        }
        com.tencent.luggage.wxa.ao.a.b(bool);
        this.l = new com.tencent.luggage.wxa.ao.m((int)this.j);
        System.arraycopy(this.f.a, 0, this.l.a, 0, 8);
        this.h = 1;
        return true;
      }
      this.l = null;
      this.h = 1;
      return true;
    }
    throw new p("Atom size less than header length (unsupported).");
  }
  
  private boolean b(e parame, com.tencent.luggage.wxa.l.j paramj)
  {
    long l1 = this.j - this.k;
    long l2 = parame.c();
    com.tencent.luggage.wxa.ao.m localm = this.l;
    if (localm != null)
    {
      parame.b(localm.a, this.k, (int)l1);
      if (this.i == a.a) {
        this.r = a(this.l);
      } else if (!this.g.isEmpty()) {
        ((a.a)this.g.peek()).a(new a.b(this.i, this.l));
      }
    }
    else
    {
      if (l1 >= 262144L) {
        break label137;
      }
      parame.b((int)l1);
    }
    int i1 = 0;
    break label152;
    label137:
    paramj.a = (parame.c() + l1);
    i1 = 1;
    label152:
    a(l2 + l1);
    return (i1 != 0) && (this.h != 2);
  }
  
  private int c(e parame, com.tencent.luggage.wxa.l.j paramj)
  {
    int i1 = e();
    if (i1 == -1) {
      return -1;
    }
    g.a locala = this.p[i1];
    l locall = locala.c;
    int i3 = locala.d;
    long l2 = locala.b.b[i3];
    int i2 = locala.b.c[i3];
    i1 = i2;
    long l1 = l2;
    if (locala.a.g == 1)
    {
      l1 = l2 + 8L;
      i1 = i2 - 8;
    }
    l2 = l1 - parame.c() + this.m;
    if ((l2 >= 0L) && (l2 < 262144L))
    {
      parame.b((int)l2);
      int i4;
      if (locala.a.j != 0)
      {
        paramj = this.e.a;
        paramj[0] = 0;
        paramj[1] = 0;
        paramj[2] = 0;
        i4 = locala.a.j;
        int i5 = 4 - locala.a.j;
        for (;;)
        {
          i2 = i1;
          if (this.m >= i1) {
            break;
          }
          i2 = this.n;
          if (i2 == 0)
          {
            parame.b(this.e.a, i5, i4);
            this.e.c(0);
            this.n = this.e.t();
            this.d.c(0);
            locall.a(this.d, 4);
            this.m += 4;
            i1 += i5;
          }
          else
          {
            i2 = locall.a(parame, i2, false);
            this.m += i2;
            this.n -= i2;
          }
        }
      }
      for (;;)
      {
        i4 = this.m;
        i2 = i1;
        if (i4 >= i1) {
          break;
        }
        i2 = locall.a(parame, i1 - i4, false);
        this.m += i2;
        this.n -= i2;
      }
      locall.a(locala.b.e[i3], locala.b.f[i3], i2, 0, null);
      locala.d += 1;
      this.m = 0;
      this.n = 0;
      return 0;
    }
    paramj.a = l1;
    return 1;
  }
  
  private void c(long paramLong)
  {
    g.a[] arrayOfa = this.p;
    int i4 = arrayOfa.length;
    int i1 = 0;
    while (i1 < i4)
    {
      g.a locala = arrayOfa[i1];
      m localm = locala.b;
      int i3 = localm.a(paramLong);
      int i2 = i3;
      if (i3 == -1) {
        i2 = localm.b(paramLong);
      }
      locala.d = i2;
      i1 += 1;
    }
  }
  
  private void d()
  {
    this.h = 0;
    this.k = 0;
  }
  
  private int e()
  {
    int i2 = -1;
    long l1 = 9223372036854775807L;
    int i1 = 0;
    for (;;)
    {
      Object localObject = this.p;
      if (i1 >= localObject.length) {
        break;
      }
      localObject = localObject[i1];
      int i3 = ((g.a)localObject).d;
      long l2;
      if (i3 == ((g.a)localObject).b.a)
      {
        l2 = l1;
      }
      else
      {
        long l3 = localObject.b.b[i3];
        l2 = l1;
        if (l3 < l1)
        {
          i2 = i1;
          l2 = l3;
        }
      }
      i1 += 1;
      l1 = l2;
    }
    return i2;
  }
  
  public int a(e parame, com.tencent.luggage.wxa.l.j paramj)
  {
    do
    {
      do
      {
        int i1 = this.h;
        if (i1 == 0) {
          break;
        }
        if (i1 != 1)
        {
          if (i1 == 2) {
            return c(parame, paramj);
          }
          throw new IllegalStateException();
        }
      } while (!b(parame, paramj));
      return 1;
    } while (b(parame));
    return -1;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.g.clear();
    this.k = 0;
    this.m = 0;
    this.n = 0;
    if (paramLong1 == 0L)
    {
      d();
      return;
    }
    if (this.p != null) {
      c(paramLong2);
    }
  }
  
  public void a(f paramf)
  {
    this.o = paramf;
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(e parame)
  {
    return i.b(parame);
  }
  
  public long b()
  {
    return this.q;
  }
  
  public long b(long paramLong)
  {
    g.a[] arrayOfa = this.p;
    int i4 = arrayOfa.length;
    long l1 = 9223372036854775807L;
    int i1 = 0;
    while (i1 < i4)
    {
      m localm = arrayOfa[i1].b;
      int i3 = localm.a(paramLong);
      int i2 = i3;
      if (i3 == -1) {
        i2 = localm.b(paramLong);
      }
      long l3 = localm.b[i2];
      long l2 = l1;
      if (l3 < l1) {
        l2 = l3;
      }
      i1 += 1;
      l1 = l2;
    }
    return l1;
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.p.g
 * JD-Core Version:    0.7.0.1
 */