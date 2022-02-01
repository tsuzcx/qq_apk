package com.tencent.luggage.wxa.al;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.tencent.luggage.wxa.h.t;
import com.tencent.luggage.wxa.h.u;
import com.tencent.luggage.wxa.z.n;
import com.tencent.luggage.wxa.z.o;
import java.util.Arrays;
import java.util.Map;

public abstract class d
  extends g
{
  private final SparseArray<Map<o, d.b>> a = new SparseArray();
  private final SparseBooleanArray b = new SparseBooleanArray();
  private int c = 0;
  private d.a d;
  
  private static int a(t[] paramArrayOft, n paramn)
  {
    int j = paramArrayOft.length;
    int i = 0;
    int m;
    for (int k = 0; i < paramArrayOft.length; k = m)
    {
      t localt = paramArrayOft[i];
      m = j;
      int n = 0;
      j = k;
      k = m;
      m = n;
      while (m < paramn.a)
      {
        int i1 = localt.a(paramn.a(m)) & 0x7;
        n = j;
        if (i1 > j)
        {
          if (i1 == 4) {
            return i;
          }
          k = i;
          n = i1;
        }
        m += 1;
        j = n;
      }
      i += 1;
      m = j;
      j = k;
    }
    return j;
  }
  
  private static void a(t[] paramArrayOft, o[] paramArrayOfo, int[][][] paramArrayOfInt, u[] paramArrayOfu, e[] paramArrayOfe, int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    int i1 = 0;
    int i = 0;
    int k = -1;
    int n;
    for (int j = -1; i < paramArrayOft.length; j = n)
    {
      int i2 = paramArrayOft[i].a();
      e locale = paramArrayOfe[i];
      if (i2 != 1)
      {
        m = k;
        n = j;
        if (i2 != 2) {}
      }
      else
      {
        m = k;
        n = j;
        if (locale != null)
        {
          m = k;
          n = j;
          if (a(paramArrayOfInt[i], paramArrayOfo[i], locale))
          {
            if (i2 == 1)
            {
              if (j == -1)
              {
                n = i;
                m = k;
                break label146;
              }
            }
            else {
              if (k == -1) {
                break label138;
              }
            }
            i = 0;
            break label166;
            label138:
            m = i;
            n = j;
          }
        }
      }
      label146:
      i += 1;
      k = m;
    }
    i = 1;
    label166:
    int m = i1;
    if (j != -1)
    {
      m = i1;
      if (k != -1) {
        m = 1;
      }
    }
    if ((i & m) != 0)
    {
      paramArrayOft = new u(paramInt);
      paramArrayOfu[j] = paramArrayOft;
      paramArrayOfu[k] = paramArrayOft;
    }
  }
  
  private static boolean a(int[][] paramArrayOfInt, o paramo, e parame)
  {
    if (parame == null) {
      return false;
    }
    int j = paramo.a(parame.d());
    int i = 0;
    while (i < parame.e())
    {
      if ((paramArrayOfInt[j][parame.b(i)] & 0x20) != 32) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private static int[] a(t paramt, n paramn)
  {
    int[] arrayOfInt = new int[paramn.a];
    int i = 0;
    while (i < paramn.a)
    {
      arrayOfInt[i] = paramt.a(paramn.a(i));
      i += 1;
    }
    return arrayOfInt;
  }
  
  private static int[] a(t[] paramArrayOft)
  {
    int[] arrayOfInt = new int[paramArrayOft.length];
    int i = 0;
    while (i < arrayOfInt.length)
    {
      arrayOfInt[i] = paramArrayOft[i].m();
      i += 1;
    }
    return arrayOfInt;
  }
  
  public final h a(t[] paramArrayOft, o paramo)
  {
    Object localObject4 = new int[paramArrayOft.length + 1];
    Object localObject6 = new n[paramArrayOft.length + 1][];
    int[][][] arrayOfInt = new int[paramArrayOft.length + 1][][];
    int j = 0;
    int i = 0;
    while (i < localObject6.length)
    {
      localObject6[i] = new n[paramo.b];
      arrayOfInt[i] = new int[paramo.b][];
      i += 1;
    }
    Object localObject3 = a(paramArrayOft);
    i = 0;
    int k;
    Object localObject1;
    while (i < paramo.b)
    {
      localObject2 = paramo.a(i);
      k = a(paramArrayOft, (n)localObject2);
      if (k == paramArrayOft.length) {
        localObject1 = new int[((n)localObject2).a];
      } else {
        localObject1 = a(paramArrayOft[k], (n)localObject2);
      }
      int m = localObject4[k];
      localObject6[k][m] = localObject2;
      arrayOfInt[k][m] = localObject1;
      localObject4[k] += 1;
      i += 1;
    }
    Object localObject2 = new o[paramArrayOft.length];
    Object localObject5 = new int[paramArrayOft.length];
    i = 0;
    while (i < paramArrayOft.length)
    {
      k = localObject4[i];
      localObject2[i] = new o((n[])Arrays.copyOf(localObject6[i], k));
      arrayOfInt[i] = ((int[][])Arrays.copyOf(arrayOfInt[i], k));
      localObject5[i] = paramArrayOft[i].a();
      i += 1;
    }
    i = localObject4[paramArrayOft.length];
    localObject6 = new o((n[])Arrays.copyOf(localObject6[paramArrayOft.length], i));
    localObject4 = a(paramArrayOft, (o[])localObject2, arrayOfInt);
    i = 0;
    for (;;)
    {
      k = paramArrayOft.length;
      localObject1 = null;
      if (i >= k) {
        break;
      }
      if (this.b.get(i))
      {
        localObject4[i] = null;
      }
      else
      {
        o localo = localObject2[i];
        if (a(i, localo))
        {
          d.b localb = (d.b)((Map)this.a.get(i)).get(localo);
          if (localb != null) {
            localObject1 = localb.a(localo);
          }
          localObject4[i] = localObject1;
        }
      }
      i += 1;
    }
    localObject3 = new d.a((int[])localObject5, (o[])localObject2, (int[])localObject3, arrayOfInt, (o)localObject6);
    localObject5 = new u[paramArrayOft.length];
    i = j;
    while (i < paramArrayOft.length)
    {
      if (localObject4[i] != null) {
        localObject1 = u.a;
      } else {
        localObject1 = null;
      }
      localObject5[i] = localObject1;
      i += 1;
    }
    a(paramArrayOft, (o[])localObject2, arrayOfInt, (u[])localObject5, (e[])localObject4, this.c);
    return new h(paramo, new f((e[])localObject4), localObject3, (u[])localObject5);
  }
  
  public final void a(Object paramObject)
  {
    this.d = ((d.a)paramObject);
  }
  
  public final boolean a(int paramInt, o paramo)
  {
    Map localMap = (Map)this.a.get(paramInt);
    return (localMap != null) && (localMap.containsKey(paramo));
  }
  
  protected abstract e[] a(t[] paramArrayOft, o[] paramArrayOfo, int[][][] paramArrayOfInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.al.d
 * JD-Core Version:    0.7.0.1
 */