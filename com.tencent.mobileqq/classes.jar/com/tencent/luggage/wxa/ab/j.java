package com.tencent.luggage.wxa.ab;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.luggage.wxa.am.b;
import com.tencent.luggage.wxa.am.t;
import com.tencent.luggage.wxa.am.t.a;
import com.tencent.luggage.wxa.am.t.c;
import com.tencent.luggage.wxa.am.t.d;
import com.tencent.luggage.wxa.ao.x;
import com.tencent.luggage.wxa.z.j.b;
import com.tencent.luggage.wxa.z.n;
import com.tencent.luggage.wxa.z.o;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

final class j
  implements t.a<com.tencent.luggage.wxa.aa.a>, t.d, com.tencent.luggage.wxa.l.f, j.b, com.tencent.luggage.wxa.z.l
{
  private long A;
  private boolean B;
  private boolean C;
  private boolean D;
  private final int a;
  private final j.a b;
  private final c c;
  private final b d;
  private final com.tencent.luggage.wxa.h.k e;
  private final int f;
  private final t g;
  private final com.tencent.luggage.wxa.z.a.a h;
  private final c.b i;
  private final LinkedList<f> j;
  private final Runnable k;
  private final Handler l;
  private com.tencent.luggage.wxa.z.j[] m;
  private int[] n;
  private boolean o;
  private boolean p;
  private int q;
  private com.tencent.luggage.wxa.h.k r;
  private int s;
  private boolean t;
  private o u;
  private int v;
  private boolean w;
  private boolean[] x;
  private boolean[] y;
  private long z;
  
  public j(int paramInt1, j.a parama, c paramc, b paramb, long paramLong, com.tencent.luggage.wxa.h.k paramk, int paramInt2, com.tencent.luggage.wxa.z.a.a parama1)
  {
    this.a = paramInt1;
    this.b = parama;
    this.c = paramc;
    this.d = paramb;
    this.e = paramk;
    this.f = paramInt2;
    this.h = parama1;
    this.g = new t("Loader:HlsSampleStreamWrapper");
    this.i = new c.b();
    this.n = new int[0];
    this.m = new com.tencent.luggage.wxa.z.j[0];
    this.j = new LinkedList();
    this.k = new j.1(this);
    this.l = new Handler();
    this.z = paramLong;
    this.A = paramLong;
  }
  
  private static com.tencent.luggage.wxa.h.k a(com.tencent.luggage.wxa.h.k paramk1, com.tencent.luggage.wxa.h.k paramk2)
  {
    if (paramk1 == null) {
      return paramk2;
    }
    String str = null;
    int i1 = com.tencent.luggage.wxa.ao.j.g(paramk2.f);
    if (i1 == 1) {
      str = a(paramk1.c);
    } else if (i1 == 2) {
      str = b(paramk1.c);
    }
    return paramk2.a(paramk1.a, str, paramk1.b, paramk1.j, paramk1.k, paramk1.x, paramk1.y);
  }
  
  private static String a(String paramString)
  {
    return a(paramString, 1);
  }
  
  private static String a(String paramString, int paramInt)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject = null;
    if (bool) {
      return null;
    }
    paramString = paramString.split("(\\s*,\\s*)|(\\s*$)");
    StringBuilder localStringBuilder = new StringBuilder();
    int i2 = paramString.length;
    int i1 = 0;
    while (i1 < i2)
    {
      String str = paramString[i1];
      if (paramInt == com.tencent.luggage.wxa.ao.j.h(str))
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append(",");
        }
        localStringBuilder.append(str);
      }
      i1 += 1;
    }
    paramString = localObject;
    if (localStringBuilder.length() > 0) {
      paramString = localStringBuilder.toString();
    }
    return paramString;
  }
  
  private boolean a(com.tencent.luggage.wxa.aa.a parama)
  {
    return parama instanceof f;
  }
  
  private boolean a(f paramf)
  {
    int i2 = paramf.j;
    int i1 = 0;
    for (;;)
    {
      paramf = this.m;
      if (i1 >= paramf.length) {
        break;
      }
      if ((this.x[i1] != 0) && (paramf[i1].f() == i2)) {
        return false;
      }
      i1 += 1;
    }
    return true;
  }
  
  private static String b(String paramString)
  {
    return a(paramString, 2);
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    boolean bool = this.x[paramInt];
    int i1 = 1;
    if (bool != paramBoolean) {
      bool = true;
    } else {
      bool = false;
    }
    com.tencent.luggage.wxa.ao.a.b(bool);
    this.x[paramInt] = paramBoolean;
    int i2 = this.q;
    if (paramBoolean) {
      paramInt = i1;
    } else {
      paramInt = -1;
    }
    this.q = (i2 + paramInt);
  }
  
  private boolean b(long paramLong)
  {
    int i2 = this.m.length;
    int i1 = 0;
    while (i1 < i2)
    {
      com.tencent.luggage.wxa.z.j localj = this.m[i1];
      localj.i();
      if ((!localj.b(paramLong, true, false)) && ((this.y[i1] != 0) || (!this.w))) {
        return false;
      }
      localj.j();
      i1 += 1;
    }
    return true;
  }
  
  private void j()
  {
    com.tencent.luggage.wxa.z.j[] arrayOfj = this.m;
    int i2 = arrayOfj.length;
    int i1 = 0;
    while (i1 < i2)
    {
      arrayOfj[i1].a(this.B);
      i1 += 1;
    }
    this.B = false;
  }
  
  private void k()
  {
    if ((!this.t) && (!this.p))
    {
      if (!this.o) {
        return;
      }
      com.tencent.luggage.wxa.z.j[] arrayOfj = this.m;
      int i2 = arrayOfj.length;
      int i1 = 0;
      while (i1 < i2)
      {
        if (arrayOfj[i1].g() == null) {
          return;
        }
        i1 += 1;
      }
      l();
      this.p = true;
      this.b.g();
    }
  }
  
  private void l()
  {
    int i7 = this.m.length;
    int i2 = 0;
    int i4 = 0;
    Object localObject;
    for (int i5 = -1;; i5 = i3)
    {
      i1 = 3;
      if (i2 >= i7) {
        break;
      }
      localObject = this.m[i2].g().f;
      if (!com.tencent.luggage.wxa.ao.j.b((String)localObject)) {
        if (com.tencent.luggage.wxa.ao.j.a((String)localObject)) {
          i1 = 2;
        } else if (com.tencent.luggage.wxa.ao.j.c((String)localObject)) {
          i1 = 1;
        } else {
          i1 = 0;
        }
      }
      int i6;
      if (i1 > i4)
      {
        i3 = i2;
        i6 = i1;
      }
      else
      {
        i6 = i4;
        i3 = i5;
        if (i1 == i4)
        {
          i6 = i4;
          i3 = i5;
          if (i5 != -1)
          {
            i3 = -1;
            i6 = i4;
          }
        }
      }
      i2 += 1;
      i4 = i6;
    }
    n localn = this.c.b();
    int i3 = localn.a;
    this.v = -1;
    this.x = new boolean[i7];
    this.y = new boolean[i7];
    n[] arrayOfn = new n[i7];
    int i1 = 0;
    while (i1 < i7)
    {
      com.tencent.luggage.wxa.h.k localk = this.m[i1].g();
      localObject = localk.f;
      int i8;
      if ((!com.tencent.luggage.wxa.ao.j.b((String)localObject)) && (!com.tencent.luggage.wxa.ao.j.a((String)localObject))) {
        i8 = 0;
      } else {
        i8 = 1;
      }
      this.y[i1] = i8;
      this.w = (i8 | this.w);
      if (i1 == i5)
      {
        localObject = new com.tencent.luggage.wxa.h.k[i3];
        i2 = 0;
        while (i2 < i3)
        {
          localObject[i2] = a(localn.a(i2), localk);
          i2 += 1;
        }
        arrayOfn[i1] = new n((com.tencent.luggage.wxa.h.k[])localObject);
        this.v = i1;
      }
      else
      {
        if ((i4 == 3) && (com.tencent.luggage.wxa.ao.j.a(localk.f))) {
          localObject = this.e;
        } else {
          localObject = null;
        }
        arrayOfn[i1] = new n(new com.tencent.luggage.wxa.h.k[] { a((com.tencent.luggage.wxa.h.k)localObject, localk) });
      }
      i1 += 1;
    }
    this.u = new o(arrayOfn);
  }
  
  private boolean m()
  {
    return this.A != -9223372036854775807L;
  }
  
  int a(int paramInt, com.tencent.luggage.wxa.h.l paraml, com.tencent.luggage.wxa.j.e parame, boolean paramBoolean)
  {
    if (m()) {
      return -3;
    }
    if (!this.j.isEmpty())
    {
      while ((this.j.size() > 1) && (a((f)this.j.getFirst()))) {
        this.j.removeFirst();
      }
      f localf = (f)this.j.getFirst();
      com.tencent.luggage.wxa.h.k localk = localf.c;
      if (!localk.equals(this.r)) {
        this.h.a(this.a, localk, localf.d, localf.e, localf.f);
      }
      this.r = localk;
    }
    return this.m[paramInt].a(paraml, parame, paramBoolean, this.D, this.z);
  }
  
  public int a(com.tencent.luggage.wxa.aa.a parama, long paramLong1, long paramLong2, IOException paramIOException)
  {
    long l1 = parama.d();
    boolean bool3 = a(parama);
    boolean bool2 = true;
    boolean bool1;
    if ((bool3) && (l1 != 0L)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    if (this.c.a(parama, bool1, paramIOException))
    {
      bool1 = bool2;
      if (bool3)
      {
        if ((f)this.j.removeLast() == parama) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        com.tencent.luggage.wxa.ao.a.b(bool1);
        bool1 = bool2;
        if (this.j.isEmpty())
        {
          this.A = this.z;
          bool1 = bool2;
        }
      }
    }
    else
    {
      bool1 = false;
    }
    this.h.a(parama.a, parama.b, this.a, parama.c, parama.d, parama.e, parama.f, parama.g, paramLong1, paramLong2, parama.d(), paramIOException, bool1);
    if (bool1)
    {
      if (!this.p) {
        c(this.z);
      } else {
        this.b.a(this);
      }
      return 2;
    }
    return 0;
  }
  
  public void a()
  {
    this.o = true;
    this.l.post(this.k);
  }
  
  void a(int paramInt, long paramLong)
  {
    com.tencent.luggage.wxa.z.j localj = this.m[paramInt];
    if ((this.D) && (paramLong > localj.h()))
    {
      localj.l();
      return;
    }
    localj.b(paramLong, true, true);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.s = paramInt;
    com.tencent.luggage.wxa.z.j[] arrayOfj = this.m;
    int i3 = arrayOfj.length;
    int i2 = 0;
    int i1 = 0;
    while (i1 < i3)
    {
      arrayOfj[i1].a(paramInt);
      i1 += 1;
    }
    if (paramBoolean)
    {
      arrayOfj = this.m;
      i1 = arrayOfj.length;
      paramInt = i2;
      while (paramInt < i1)
      {
        arrayOfj[paramInt].b();
        paramInt += 1;
      }
    }
  }
  
  public void a(long paramLong)
  {
    int i2 = this.m.length;
    int i1 = 0;
    while (i1 < i2)
    {
      this.m[i1].a(paramLong, false, this.x[i1]);
      i1 += 1;
    }
  }
  
  public void a(com.tencent.luggage.wxa.aa.a parama, long paramLong1, long paramLong2)
  {
    this.c.a(parama);
    this.h.a(parama.a, parama.b, this.a, parama.c, parama.d, parama.e, parama.f, parama.g, paramLong1, paramLong2, parama.d());
    if (!this.p)
    {
      c(this.z);
      return;
    }
    this.b.a(this);
  }
  
  public void a(com.tencent.luggage.wxa.aa.a parama, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.h.b(parama.a, parama.b, this.a, parama.c, parama.d, parama.e, parama.f, parama.g, paramLong1, paramLong2, parama.d());
    if (!paramBoolean)
    {
      j();
      if (this.q > 0) {
        this.b.a(this);
      }
    }
  }
  
  public void a(com.tencent.luggage.wxa.ac.a.a parama, long paramLong)
  {
    this.c.a(parama, paramLong);
  }
  
  public void a(com.tencent.luggage.wxa.h.k paramk)
  {
    this.l.post(this.k);
  }
  
  public void a(com.tencent.luggage.wxa.l.k paramk) {}
  
  public void a(boolean paramBoolean)
  {
    this.c.a(paramBoolean);
  }
  
  boolean a(int paramInt)
  {
    return (this.D) || ((!m()) && (this.m[paramInt].d()));
  }
  
  public boolean a(long paramLong, boolean paramBoolean)
  {
    this.z = paramLong;
    if ((!paramBoolean) && (!m()) && (b(paramLong))) {
      return false;
    }
    this.A = paramLong;
    this.D = false;
    this.j.clear();
    if (this.g.a()) {
      this.g.b();
    } else {
      j();
    }
    return true;
  }
  
  public boolean a(com.tencent.luggage.wxa.al.e[] paramArrayOfe, boolean[] paramArrayOfBoolean1, com.tencent.luggage.wxa.z.k[] paramArrayOfk, boolean[] paramArrayOfBoolean2, long paramLong, boolean paramBoolean)
  {
    com.tencent.luggage.wxa.ao.a.b(this.p);
    int i4 = this.q;
    int i2 = 0;
    int i3 = 0;
    int i1 = 0;
    while (i1 < paramArrayOfe.length)
    {
      if ((paramArrayOfk[i1] != null) && ((paramArrayOfe[i1] == null) || (paramArrayOfBoolean1[i1] == 0)))
      {
        b(((i)paramArrayOfk[i1]).a, false);
        paramArrayOfk[i1] = null;
      }
      i1 += 1;
    }
    boolean bool1;
    if ((!paramBoolean) && (this.C ? i4 != 0 : paramLong == this.z)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    com.tencent.luggage.wxa.al.e locale = this.c.c();
    paramArrayOfBoolean1 = locale;
    i1 = 0;
    boolean bool2;
    while (i1 < paramArrayOfe.length)
    {
      Object localObject = paramArrayOfBoolean1;
      bool2 = bool1;
      if (paramArrayOfk[i1] == null)
      {
        localObject = paramArrayOfBoolean1;
        bool2 = bool1;
        if (paramArrayOfe[i1] != null)
        {
          localObject = paramArrayOfe[i1];
          i4 = this.u.a(((com.tencent.luggage.wxa.al.e)localObject).d());
          b(i4, true);
          if (i4 == this.v)
          {
            this.c.a((com.tencent.luggage.wxa.al.e)localObject);
            paramArrayOfBoolean1 = (boolean[])localObject;
          }
          paramArrayOfk[i1] = new i(this, i4);
          paramArrayOfBoolean2[i1] = true;
          localObject = paramArrayOfBoolean1;
          bool2 = bool1;
          if (!bool1)
          {
            localObject = this.m[i4];
            ((com.tencent.luggage.wxa.z.j)localObject).i();
            if ((!((com.tencent.luggage.wxa.z.j)localObject).b(paramLong, true, true)) && (((com.tencent.luggage.wxa.z.j)localObject).e() != 0))
            {
              bool2 = true;
              localObject = paramArrayOfBoolean1;
            }
            else
            {
              bool2 = false;
              localObject = paramArrayOfBoolean1;
            }
          }
        }
      }
      i1 += 1;
      paramArrayOfBoolean1 = (boolean[])localObject;
      bool1 = bool2;
    }
    if (this.q == 0)
    {
      this.c.d();
      this.r = null;
      this.j.clear();
      if (this.g.a())
      {
        paramArrayOfe = this.m;
        i2 = paramArrayOfe.length;
        i1 = i3;
        while (i1 < i2)
        {
          paramArrayOfe[i1].k();
          i1 += 1;
        }
        this.g.b();
        bool2 = bool1;
      }
      else
      {
        j();
        bool2 = bool1;
      }
    }
    else
    {
      if ((!this.j.isEmpty()) && (!x.a(paramArrayOfBoolean1, locale)))
      {
        if (!this.C)
        {
          paramArrayOfBoolean1.a(0L);
          i1 = this.c.b().a(((f)this.j.getLast()).c);
          if (paramArrayOfBoolean1.g() == i1)
          {
            i1 = 0;
            break label496;
          }
        }
        i1 = 1;
        label496:
        if (i1 != 0)
        {
          this.B = true;
          paramBoolean = true;
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (bool1)
      {
        a(paramLong, paramBoolean);
        i1 = i2;
        for (;;)
        {
          bool2 = bool1;
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
    this.C = true;
    return bool2;
  }
  
  public com.tencent.luggage.wxa.z.j b(int paramInt1, int paramInt2)
  {
    int i1 = this.m.length;
    paramInt2 = 0;
    while (paramInt2 < i1)
    {
      if (this.n[paramInt2] == paramInt1) {
        return this.m[paramInt2];
      }
      paramInt2 += 1;
    }
    com.tencent.luggage.wxa.z.j localj = new com.tencent.luggage.wxa.z.j(this.d);
    localj.a(this);
    int[] arrayOfInt = this.n;
    paramInt2 = i1 + 1;
    this.n = Arrays.copyOf(arrayOfInt, paramInt2);
    this.n[i1] = paramInt1;
    this.m = ((com.tencent.luggage.wxa.z.j[])Arrays.copyOf(this.m, paramInt2));
    this.m[i1] = localj;
    return localj;
  }
  
  public void b()
  {
    if (!this.p) {
      c(this.z);
    }
  }
  
  public void b(com.tencent.luggage.wxa.h.k paramk)
  {
    b(0, -1).a(paramk);
    this.o = true;
    k();
  }
  
  public void c()
  {
    i();
  }
  
  public boolean c(long paramLong)
  {
    if (!this.D)
    {
      if (this.g.a()) {
        return false;
      }
      Object localObject2 = this.c;
      if (this.j.isEmpty()) {
        localObject1 = null;
      } else {
        localObject1 = (f)this.j.getLast();
      }
      long l1 = this.A;
      if (l1 != -9223372036854775807L) {
        paramLong = l1;
      }
      ((c)localObject2).a((f)localObject1, paramLong, this.i);
      boolean bool = this.i.b;
      Object localObject1 = this.i.a;
      localObject2 = this.i.c;
      this.i.a();
      if (bool)
      {
        this.A = -9223372036854775807L;
        this.D = true;
        return true;
      }
      if (localObject1 == null)
      {
        if (localObject2 != null) {
          this.b.a((com.tencent.luggage.wxa.ac.a.a)localObject2);
        }
        return false;
      }
      if (a((com.tencent.luggage.wxa.aa.a)localObject1))
      {
        this.A = -9223372036854775807L;
        localObject2 = (f)localObject1;
        ((f)localObject2).a(this);
        this.j.add(localObject2);
      }
      paramLong = this.g.a((t.c)localObject1, this, this.f);
      this.h.a(((com.tencent.luggage.wxa.aa.a)localObject1).a, ((com.tencent.luggage.wxa.aa.a)localObject1).b, this.a, ((com.tencent.luggage.wxa.aa.a)localObject1).c, ((com.tencent.luggage.wxa.aa.a)localObject1).d, ((com.tencent.luggage.wxa.aa.a)localObject1).e, ((com.tencent.luggage.wxa.aa.a)localObject1).f, ((com.tencent.luggage.wxa.aa.a)localObject1).g, paramLong);
      return true;
    }
    return false;
  }
  
  public long d()
  {
    if (this.D) {
      return -9223372036854775808L;
    }
    if (m()) {
      return this.A;
    }
    long l2 = this.z;
    Object localObject = (f)this.j.getLast();
    if (!((f)localObject).f()) {
      if (this.j.size() > 1)
      {
        localObject = this.j;
        localObject = (f)((LinkedList)localObject).get(((LinkedList)localObject).size() - 2);
      }
      else
      {
        localObject = null;
      }
    }
    long l1 = l2;
    if (localObject != null) {
      l1 = Math.max(l2, ((f)localObject).g);
    }
    localObject = this.m;
    int i2 = localObject.length;
    int i1 = 0;
    while (i1 < i2)
    {
      l1 = Math.max(l1, localObject[i1].h());
      i1 += 1;
    }
    return l1;
  }
  
  public long e()
  {
    if (m()) {
      return this.A;
    }
    if (this.D) {
      return -9223372036854775808L;
    }
    return ((f)this.j.getLast()).g;
  }
  
  public o f()
  {
    return this.u;
  }
  
  public void g()
  {
    j();
  }
  
  public void h()
  {
    boolean bool = this.g.a(this);
    if ((this.p) && (!bool))
    {
      com.tencent.luggage.wxa.z.j[] arrayOfj = this.m;
      int i2 = arrayOfj.length;
      int i1 = 0;
      while (i1 < i2)
      {
        arrayOfj[i1].k();
        i1 += 1;
      }
    }
    this.l.removeCallbacksAndMessages(null);
    this.t = true;
  }
  
  void i()
  {
    this.g.d();
    this.c.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ab.j
 * JD-Core Version:    0.7.0.1
 */