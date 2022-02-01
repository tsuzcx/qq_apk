package com.tencent.luggage.wxa.ab;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.luggage.wxa.ac.e.b;
import com.tencent.luggage.wxa.am.b;
import com.tencent.luggage.wxa.z.g.a;
import com.tencent.luggage.wxa.z.n;
import com.tencent.luggage.wxa.z.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;

public final class g
  implements j.a, e.b, com.tencent.luggage.wxa.z.g
{
  private final com.tencent.luggage.wxa.ac.e a;
  private final d b;
  private final int c;
  private final com.tencent.luggage.wxa.z.a.a d;
  private final b e;
  private final IdentityHashMap<com.tencent.luggage.wxa.z.k, Integer> f;
  private final k g;
  private final Handler h;
  private g.a i;
  private int j;
  private o k;
  private j[] l;
  private j[] m;
  private com.tencent.luggage.wxa.z.d n;
  
  public g(com.tencent.luggage.wxa.ac.e parame, d paramd, int paramInt, com.tencent.luggage.wxa.z.a.a parama, b paramb)
  {
    this.a = parame;
    this.b = paramd;
    this.c = paramInt;
    this.d = parama;
    this.e = paramb;
    this.f = new IdentityHashMap();
    this.g = new k();
    this.h = new Handler();
    this.l = new j[0];
    this.m = new j[0];
  }
  
  private j a(int paramInt, com.tencent.luggage.wxa.ac.a.a[] paramArrayOfa, com.tencent.luggage.wxa.h.k paramk, List<com.tencent.luggage.wxa.h.k> paramList, long paramLong)
  {
    return new j(paramInt, this, new c(this.a, paramArrayOfa, this.b, this.g, paramList), this.e, paramLong, paramk, this.c, this.d);
  }
  
  private static boolean a(com.tencent.luggage.wxa.ac.a.a parama, String paramString)
  {
    parama = parama.b.c;
    if (TextUtils.isEmpty(parama)) {
      return false;
    }
    parama = parama.split("(\\s*,\\s*)|(\\s*$)");
    int i2 = parama.length;
    int i1 = 0;
    while (i1 < i2)
    {
      if (parama[i1].startsWith(paramString)) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  private void d(long paramLong)
  {
    Object localObject3 = this.a.b();
    Object localObject2 = new ArrayList(((com.tencent.luggage.wxa.ac.a)localObject3).a);
    Object localObject1 = new ArrayList();
    Object localObject4 = new ArrayList();
    int i1 = 0;
    while (i1 < ((List)localObject2).size())
    {
      localObject5 = (com.tencent.luggage.wxa.ac.a.a)((List)localObject2).get(i1);
      if ((((com.tencent.luggage.wxa.ac.a.a)localObject5).b.k <= 0) && (!a((com.tencent.luggage.wxa.ac.a.a)localObject5, "avc")))
      {
        if (a((com.tencent.luggage.wxa.ac.a.a)localObject5, "mp4a")) {
          ((ArrayList)localObject4).add(localObject5);
        }
      }
      else {
        ((ArrayList)localObject1).add(localObject5);
      }
      i1 += 1;
    }
    if (((ArrayList)localObject1).isEmpty())
    {
      localObject1 = localObject2;
      if (((ArrayList)localObject4).size() < ((List)localObject2).size())
      {
        ((List)localObject2).removeAll((Collection)localObject4);
        localObject1 = localObject2;
      }
    }
    localObject4 = ((com.tencent.luggage.wxa.ac.a)localObject3).b;
    localObject2 = ((com.tencent.luggage.wxa.ac.a)localObject3).c;
    this.l = new j[((List)localObject4).size() + 1 + ((List)localObject2).size()];
    this.j = this.l.length;
    com.tencent.luggage.wxa.ao.a.a(((List)localObject1).isEmpty() ^ true);
    Object localObject5 = new com.tencent.luggage.wxa.ac.a.a[((List)localObject1).size()];
    ((List)localObject1).toArray((Object[])localObject5);
    localObject1 = a(0, (com.tencent.luggage.wxa.ac.a.a[])localObject5, ((com.tencent.luggage.wxa.ac.a)localObject3).d, ((com.tencent.luggage.wxa.ac.a)localObject3).e, paramLong);
    this.l[0] = localObject1;
    ((j)localObject1).a(true);
    ((j)localObject1).b();
    int i2 = 0;
    i1 = 1;
    while (i2 < ((List)localObject4).size())
    {
      localObject1 = (com.tencent.luggage.wxa.ac.a.a)((List)localObject4).get(i2);
      localObject3 = Collections.emptyList();
      localObject1 = a(1, new com.tencent.luggage.wxa.ac.a.a[] { localObject1 }, null, (List)localObject3, paramLong);
      this.l[i1] = localObject1;
      ((j)localObject1).b();
      i2 += 1;
      i1 += 1;
    }
    i2 = 0;
    while (i2 < ((List)localObject2).size())
    {
      localObject1 = (com.tencent.luggage.wxa.ac.a.a)((List)localObject2).get(i2);
      localObject3 = Collections.emptyList();
      localObject3 = a(3, new com.tencent.luggage.wxa.ac.a.a[] { localObject1 }, null, (List)localObject3, paramLong);
      ((j)localObject3).b(((com.tencent.luggage.wxa.ac.a.a)localObject1).b);
      this.l[i1] = localObject3;
      i2 += 1;
      i1 += 1;
    }
    this.m = this.l;
  }
  
  private void i()
  {
    if (this.k != null)
    {
      this.i.a(this);
      return;
    }
    j[] arrayOfj = this.l;
    int i2 = arrayOfj.length;
    int i1 = 0;
    while (i1 < i2)
    {
      arrayOfj[i1].b();
      i1 += 1;
    }
  }
  
  public long a(com.tencent.luggage.wxa.al.e[] paramArrayOfe, boolean[] paramArrayOfBoolean1, com.tencent.luggage.wxa.z.k[] paramArrayOfk, boolean[] paramArrayOfBoolean2, long paramLong)
  {
    Object localObject1 = paramArrayOfk;
    int[] arrayOfInt1 = new int[paramArrayOfe.length];
    int[] arrayOfInt2 = new int[paramArrayOfe.length];
    int i1 = 0;
    Object localObject3;
    while (i1 < paramArrayOfe.length)
    {
      if (localObject1[i1] == null) {
        i2 = -1;
      } else {
        i2 = ((Integer)this.f.get(localObject1[i1])).intValue();
      }
      arrayOfInt1[i1] = i2;
      arrayOfInt2[i1] = -1;
      if (paramArrayOfe[i1] != null)
      {
        localObject2 = paramArrayOfe[i1].d();
        i2 = 0;
        for (;;)
        {
          localObject3 = this.l;
          if (i2 >= localObject3.length) {
            break;
          }
          if (localObject3[i2].f().a((n)localObject2) != -1)
          {
            arrayOfInt2[i1] = i2;
            break;
          }
          i2 += 1;
        }
      }
      i1 += 1;
    }
    this.f.clear();
    com.tencent.luggage.wxa.z.k[] arrayOfk1 = new com.tencent.luggage.wxa.z.k[paramArrayOfe.length];
    com.tencent.luggage.wxa.z.k[] arrayOfk2 = new com.tencent.luggage.wxa.z.k[paramArrayOfe.length];
    localObject1 = new com.tencent.luggage.wxa.al.e[paramArrayOfe.length];
    Object localObject2 = new j[this.l.length];
    i1 = 0;
    int i2 = 0;
    boolean bool1 = false;
    while (i2 < this.l.length)
    {
      int i3 = 0;
      j[] arrayOfj;
      while (i3 < paramArrayOfe.length)
      {
        i4 = arrayOfInt1[i3];
        arrayOfj = null;
        if (i4 == i2) {
          localObject3 = paramArrayOfk[i3];
        } else {
          localObject3 = null;
        }
        arrayOfk2[i3] = localObject3;
        localObject3 = arrayOfj;
        if (arrayOfInt2[i3] == i2) {
          localObject3 = paramArrayOfe[i3];
        }
        localObject1[i3] = localObject3;
        i3 += 1;
      }
      localObject3 = this.l[i2];
      boolean bool3 = ((j)localObject3).a((com.tencent.luggage.wxa.al.e[])localObject1, paramArrayOfBoolean1, arrayOfk2, paramArrayOfBoolean2, paramLong, bool1);
      i3 = 0;
      int i5;
      for (int i4 = 0;; i4 = i5)
      {
        i5 = paramArrayOfe.length;
        boolean bool2 = true;
        if (i3 >= i5) {
          break;
        }
        if (arrayOfInt2[i3] == i2)
        {
          if (arrayOfk2[i3] != null) {
            bool2 = true;
          } else {
            bool2 = false;
          }
          com.tencent.luggage.wxa.ao.a.b(bool2);
          arrayOfk1[i3] = arrayOfk2[i3];
          this.f.put(arrayOfk2[i3], Integer.valueOf(i2));
          i5 = 1;
        }
        else
        {
          i5 = i4;
          if (arrayOfInt1[i3] == i2)
          {
            if (arrayOfk2[i3] != null) {
              bool2 = false;
            }
            com.tencent.luggage.wxa.ao.a.b(bool2);
            i5 = i4;
          }
        }
        i3 += 1;
      }
      if (i4 != 0)
      {
        localObject2[i1] = localObject3;
        i3 = i1 + 1;
        if (i1 == 0)
        {
          ((j)localObject3).a(true);
          if (!bool3)
          {
            arrayOfj = this.m;
            if (arrayOfj.length != 0) {
              if (localObject3 == arrayOfj[0]) {
                break label535;
              }
            }
          }
          this.g.a();
          i1 = i3;
          bool1 = true;
          break label542;
        }
        else
        {
          ((j)localObject3).a(false);
        }
        label535:
        i1 = i3;
      }
      label542:
      i2 += 1;
    }
    System.arraycopy(arrayOfk1, 0, paramArrayOfk, 0, arrayOfk1.length);
    this.m = ((j[])Arrays.copyOf((Object[])localObject2, i1));
    this.n = new com.tencent.luggage.wxa.z.d(this.m);
    return paramLong;
  }
  
  public void a(long paramLong)
  {
    j[] arrayOfj = this.m;
    int i2 = arrayOfj.length;
    int i1 = 0;
    while (i1 < i2)
    {
      arrayOfj[i1].a(paramLong);
      i1 += 1;
    }
  }
  
  public void a(j paramj)
  {
    if (this.k == null) {
      return;
    }
    this.i.a(this);
  }
  
  public void a(com.tencent.luggage.wxa.ac.a.a parama)
  {
    this.a.d(parama);
  }
  
  public void a(com.tencent.luggage.wxa.ac.a.a parama, long paramLong)
  {
    j[] arrayOfj = this.l;
    int i2 = arrayOfj.length;
    int i1 = 0;
    while (i1 < i2)
    {
      arrayOfj[i1].a(parama, paramLong);
      i1 += 1;
    }
    i();
  }
  
  public void a(g.a parama, long paramLong)
  {
    this.i = parama;
    this.a.a(this);
    d(paramLong);
  }
  
  public long b(long paramLong)
  {
    j[] arrayOfj = this.m;
    if (arrayOfj.length > 0)
    {
      boolean bool = arrayOfj[0].a(paramLong, false);
      int i1 = 1;
      for (;;)
      {
        arrayOfj = this.m;
        if (i1 >= arrayOfj.length) {
          break;
        }
        arrayOfj[i1].a(paramLong, bool);
        i1 += 1;
      }
      if (bool) {
        this.g.a();
      }
    }
    return paramLong;
  }
  
  public o b()
  {
    return this.k;
  }
  
  public long c()
  {
    return -9223372036854775807L;
  }
  
  public boolean c(long paramLong)
  {
    return this.n.c(paramLong);
  }
  
  public long d()
  {
    return this.n.d();
  }
  
  public void d_()
  {
    j[] arrayOfj = this.l;
    int i2 = arrayOfj.length;
    int i1 = 0;
    while (i1 < i2)
    {
      arrayOfj[i1].c();
      i1 += 1;
    }
  }
  
  public long e()
  {
    return this.n.e();
  }
  
  public void f()
  {
    this.a.b(this);
    this.h.removeCallbacksAndMessages(null);
    j[] arrayOfj = this.l;
    int i2 = arrayOfj.length;
    int i1 = 0;
    while (i1 < i2)
    {
      arrayOfj[i1].h();
      i1 += 1;
    }
  }
  
  public void g()
  {
    int i1 = this.j - 1;
    this.j = i1;
    if (i1 > 0) {
      return;
    }
    Object localObject = this.l;
    int i3 = localObject.length;
    i1 = 0;
    int i2 = 0;
    while (i1 < i3)
    {
      i2 += localObject[i1].f().b;
      i1 += 1;
    }
    localObject = new n[i2];
    j[] arrayOfj = this.l;
    int i4 = arrayOfj.length;
    i2 = 0;
    i1 = 0;
    while (i2 < i4)
    {
      j localj = arrayOfj[i2];
      int i5 = localj.f().b;
      i3 = 0;
      while (i3 < i5)
      {
        localObject[i1] = localj.f().a(i3);
        i3 += 1;
        i1 += 1;
      }
      i2 += 1;
    }
    this.k = new o((n[])localObject);
    this.i.a(this);
  }
  
  public void h()
  {
    i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ab.g
 * JD-Core Version:    0.7.0.1
 */