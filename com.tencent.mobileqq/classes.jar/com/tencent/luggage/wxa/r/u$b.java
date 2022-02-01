package com.tencent.luggage.wxa.r;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.tencent.luggage.wxa.ao.l;
import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.l.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class u$b
  implements q
{
  private final l b = new l(new byte[5]);
  private final SparseArray<v> c = new SparseArray();
  private final SparseIntArray d = new SparseIntArray();
  private final int e;
  
  public u$b(u paramu, int paramInt)
  {
    this.e = paramInt;
  }
  
  private v.b a(m paramm, int paramInt)
  {
    int i = paramm.d();
    int j = paramInt + i;
    Object localObject1 = null;
    paramInt = -1;
    Object localObject4;
    for (Object localObject2 = null; paramm.d() < j; localObject2 = localObject4)
    {
      int m = paramm.g();
      int k = paramm.g();
      k = paramm.d() + k;
      if (m == 5)
      {
        long l = paramm.l();
        if (l != u.a())
        {
          if (l == u.b()) {
            break label144;
          }
          localObject3 = localObject1;
          localObject4 = localObject2;
          if (l != u.d()) {
            break label296;
          }
          paramInt = 36;
          localObject3 = localObject1;
          localObject4 = localObject2;
          break label296;
        }
      }
      else
      {
        if (m != 106) {
          break label137;
        }
      }
      paramInt = 129;
      Object localObject3 = localObject1;
      localObject4 = localObject2;
      break label296;
      label137:
      if (m == 122)
      {
        label144:
        paramInt = 135;
        localObject3 = localObject1;
        localObject4 = localObject2;
      }
      else if (m == 123)
      {
        paramInt = 138;
        localObject3 = localObject1;
        localObject4 = localObject2;
      }
      else if (m == 10)
      {
        localObject3 = paramm.e(3).trim();
        localObject4 = localObject2;
      }
      else
      {
        localObject3 = localObject1;
        localObject4 = localObject2;
        if (m == 89)
        {
          localObject4 = new ArrayList();
          while (paramm.d() < k)
          {
            localObject2 = paramm.e(3).trim();
            paramInt = paramm.g();
            localObject3 = new byte[4];
            paramm.a((byte[])localObject3, 0, 4);
            ((List)localObject4).add(new v.a((String)localObject2, paramInt, (byte[])localObject3));
          }
          paramInt = 89;
          localObject3 = localObject1;
        }
      }
      label296:
      paramm.d(k - paramm.d());
      localObject1 = localObject3;
    }
    paramm.c(j);
    return new v.b(paramInt, localObject1, (List)localObject2, Arrays.copyOfRange(paramm.a, i, j));
  }
  
  public void a(m paramm)
  {
    if (paramm.g() != 2) {
      return;
    }
    int i = u.c(this.a);
    int k = 0;
    com.tencent.luggage.wxa.ao.u localu;
    if ((i != 1) && (u.c(this.a) != 2) && (u.d(this.a) != 1))
    {
      localu = new com.tencent.luggage.wxa.ao.u(((com.tencent.luggage.wxa.ao.u)u.e(this.a).get(0)).a());
      u.e(this.a).add(localu);
    }
    else
    {
      localu = (com.tencent.luggage.wxa.ao.u)u.e(this.a).get(0);
    }
    paramm.d(2);
    int i1 = paramm.h();
    paramm.d(5);
    paramm.a(this.b, 2);
    this.b.b(4);
    paramm.d(this.b.c(12));
    Object localObject;
    if ((u.c(this.a) == 2) && (u.f(this.a) == null))
    {
      localObject = new v.b(21, null, null, new byte[0]);
      u localu1 = this.a;
      u.a(localu1, u.g(localu1).a(21, (v.b)localObject));
      u.f(this.a).a(localu, u.h(this.a), new v.d(i1, 21, 8192));
    }
    this.c.clear();
    this.d.clear();
    int n;
    int m;
    for (int j = paramm.b(); j > 0; j = n)
    {
      paramm.a(this.b, 5);
      n = this.b.c(8);
      this.b.b(3);
      m = this.b.c(13);
      this.b.b(4);
      int i2 = this.b.c(12);
      localObject = a(paramm, i2);
      i = n;
      if (n == 6) {
        i = ((v.b)localObject).a;
      }
      n = j - (i2 + 5);
      if (u.c(this.a) == 2) {
        j = i;
      } else {
        j = m;
      }
      if (!u.i(this.a).get(j))
      {
        if ((u.c(this.a) == 2) && (i == 21)) {
          localObject = u.f(this.a);
        } else {
          localObject = u.g(this.a).a(i, (v.b)localObject);
        }
        if ((u.c(this.a) != 2) || (m < this.d.get(j, 8192)))
        {
          this.d.put(j, m);
          this.c.put(j, localObject);
        }
      }
    }
    j = this.d.size();
    i = 0;
    while (i < j)
    {
      m = this.d.keyAt(i);
      u.i(this.a).put(m, true);
      paramm = (v)this.c.valueAt(i);
      if (paramm != null)
      {
        if (paramm != u.f(this.a)) {
          paramm.a(localu, u.h(this.a), new v.d(i1, m, 8192));
        }
        u.a(this.a).put(this.d.valueAt(i), paramm);
      }
      i += 1;
    }
    if (u.c(this.a) == 2)
    {
      if (!u.j(this.a))
      {
        u.h(this.a).a();
        u.a(this.a, 0);
        u.a(this.a, true);
      }
    }
    else
    {
      u.a(this.a).remove(this.e);
      paramm = this.a;
      if (u.c(paramm) == 1) {
        i = k;
      } else {
        i = u.d(this.a) - 1;
      }
      u.a(paramm, i);
      if (u.d(this.a) == 0)
      {
        u.h(this.a).a();
        u.a(this.a, true);
      }
    }
  }
  
  public void a(com.tencent.luggage.wxa.ao.u paramu, f paramf, v.d paramd) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.r.u.b
 * JD-Core Version:    0.7.0.1
 */