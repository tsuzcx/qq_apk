package com.tencent.luggage.wxa.al;

import android.graphics.Point;
import android.text.TextUtils;
import com.tencent.luggage.wxa.ao.x;
import com.tencent.luggage.wxa.h.k;
import com.tencent.luggage.wxa.h.t;
import com.tencent.luggage.wxa.z.n;
import com.tencent.luggage.wxa.z.o;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class b
  extends d
{
  private static final int[] a = new int[0];
  private final e.a b;
  private final AtomicReference<b.b> c;
  
  public b()
  {
    this((e.a)null);
  }
  
  public b(e.a parama)
  {
    this.b = parama;
    this.c = new AtomicReference(new b.b());
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    int i = -1;
    if (paramInt1 == -1)
    {
      paramInt1 = i;
      if (paramInt2 == -1) {
        return 0;
      }
    }
    else
    {
      if (paramInt2 == -1) {
        return 1;
      }
      paramInt1 -= paramInt2;
    }
    return paramInt1;
  }
  
  private static int a(int paramInt, String paramString, k paramk)
  {
    int j = paramk.x;
    int i = 1;
    if ((j & 0x1) != 0) {
      j = 1;
    } else {
      j = 0;
    }
    if (a(paramk, paramString))
    {
      if (j != 0) {
        i = 4;
      } else {
        i = 3;
      }
    }
    else if (j != 0) {
      i = 2;
    }
    j = i;
    if (a(paramInt, false)) {
      j = i + 1000;
    }
    return j;
  }
  
  private static int a(n paramn, int[] paramArrayOfInt, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, List<Integer> paramList)
  {
    int i = 0;
    int k;
    for (int j = 0; i < paramList.size(); j = k)
    {
      int m = ((Integer)paramList.get(i)).intValue();
      k = j;
      if (a(paramn.a(m), paramString, paramArrayOfInt[m], paramInt1, paramInt2, paramInt3, paramInt4)) {
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  private static int a(n paramn, int[] paramArrayOfInt, b.a parama)
  {
    int i = 0;
    int k;
    for (int j = 0; i < paramn.a; j = k)
    {
      k = j;
      if (a(paramn.a(i), paramArrayOfInt[i], parama)) {
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  private static Point a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramBoolean)
    {
      j = 1;
      if (paramInt3 > paramInt4) {
        i = 1;
      } else {
        i = 0;
      }
      if (paramInt1 <= paramInt2) {
        j = 0;
      }
      if (i != j) {}
    }
    else
    {
      i = paramInt2;
      paramInt2 = paramInt1;
      paramInt1 = i;
    }
    int i = paramInt3 * paramInt1;
    int j = paramInt4 * paramInt2;
    if (i >= j) {
      return new Point(paramInt2, x.a(j, paramInt3));
    }
    return new Point(x.a(i, paramInt4), paramInt1);
  }
  
  private static List<Integer> a(n paramn, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(paramn.a);
    int j = 0;
    int i = 0;
    while (i < paramn.a)
    {
      localArrayList.add(Integer.valueOf(i));
      i += 1;
    }
    if (paramInt1 != 2147483647)
    {
      if (paramInt2 == 2147483647) {
        return localArrayList;
      }
      int k;
      for (i = 2147483647; j < paramn.a; i = k)
      {
        k localk = paramn.a(j);
        k = i;
        if (localk.j > 0)
        {
          k = i;
          if (localk.k > 0)
          {
            Point localPoint = a(paramBoolean, paramInt1, paramInt2, localk.j, localk.k);
            int m = localk.j * localk.k;
            k = i;
            if (localk.j >= (int)(localPoint.x * 0.98F))
            {
              k = i;
              if (localk.k >= (int)(localPoint.y * 0.98F))
              {
                k = i;
                if (m < i) {
                  k = m;
                }
              }
            }
          }
        }
        j += 1;
      }
      if (i != 2147483647)
      {
        paramInt1 = localArrayList.size() - 1;
        while (paramInt1 >= 0)
        {
          paramInt2 = paramn.a(((Integer)localArrayList.get(paramInt1)).intValue()).a();
          if ((paramInt2 == -1) || (paramInt2 > i)) {
            localArrayList.remove(paramInt1);
          }
          paramInt1 -= 1;
        }
      }
    }
    return localArrayList;
  }
  
  protected static boolean a(int paramInt, boolean paramBoolean)
  {
    paramInt &= 0x7;
    return (paramInt == 4) || ((paramBoolean) && (paramInt == 3));
  }
  
  private static boolean a(k paramk, int paramInt, b.a parama)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (a(paramInt, false))
    {
      bool1 = bool2;
      if (paramk.r == parama.a)
      {
        bool1 = bool2;
        if (paramk.s == parama.b) {
          if (parama.c != null)
          {
            bool1 = bool2;
            if (!TextUtils.equals(parama.c, paramk.f)) {}
          }
          else
          {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  protected static boolean a(k paramk, String paramString)
  {
    return (paramString != null) && (TextUtils.equals(paramString, x.b(paramk.y)));
  }
  
  private static boolean a(k paramk, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (a(paramInt1, false))
    {
      bool1 = bool2;
      if ((paramInt1 & paramInt2) != 0) {
        if (paramString != null)
        {
          bool1 = bool2;
          if (!x.a(paramk.f, paramString)) {}
        }
        else if (paramk.j != -1)
        {
          bool1 = bool2;
          if (paramk.j > paramInt3) {}
        }
        else if (paramk.k != -1)
        {
          bool1 = bool2;
          if (paramk.k > paramInt4) {}
        }
        else if (paramk.b != -1)
        {
          bool1 = bool2;
          if (paramk.b > paramInt5) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private static int[] a(n paramn, int[] paramArrayOfInt, boolean paramBoolean)
  {
    HashSet localHashSet = new HashSet();
    int m = 0;
    Object localObject1 = null;
    int i = 0;
    int j = 0;
    Object localObject2;
    int k;
    while (i < paramn.a)
    {
      localObject2 = paramn.a(i);
      k = ((k)localObject2).r;
      int n = ((k)localObject2).s;
      if (paramBoolean) {
        localObject2 = null;
      } else {
        localObject2 = ((k)localObject2).f;
      }
      b.a locala = new b.a(k, n, (String)localObject2);
      k = j;
      localObject2 = localObject1;
      if (localHashSet.add(locala))
      {
        n = a(paramn, paramArrayOfInt, locala);
        k = j;
        localObject2 = localObject1;
        if (n > j)
        {
          k = n;
          localObject2 = locala;
        }
      }
      i += 1;
      j = k;
      localObject1 = localObject2;
    }
    if (j > 1)
    {
      localObject2 = new int[j];
      j = 0;
      i = m;
      while (i < paramn.a)
      {
        k = j;
        if (a(paramn.a(i), paramArrayOfInt[i], localObject1))
        {
          localObject2[j] = i;
          k = j + 1;
        }
        i += 1;
        j = k;
      }
      return localObject2;
    }
    return a;
  }
  
  private static int[] a(n paramn, int[] paramArrayOfInt, boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean2)
  {
    if (paramn.a < 2) {
      return a;
    }
    List localList = a(paramn, paramInt5, paramInt6, paramBoolean2);
    if (localList.size() < 2) {
      return a;
    }
    Object localObject1;
    if (!paramBoolean1)
    {
      HashSet localHashSet = new HashSet();
      localObject1 = null;
      paramInt5 = 0;
      int i;
      for (paramInt6 = 0; paramInt5 < localList.size(); paramInt6 = i)
      {
        String str = paramn.a(((Integer)localList.get(paramInt5)).intValue()).f;
        Object localObject2 = localObject1;
        i = paramInt6;
        if (localHashSet.add(str))
        {
          int j = a(paramn, paramArrayOfInt, paramInt1, str, paramInt2, paramInt3, paramInt4, localList);
          localObject2 = localObject1;
          i = paramInt6;
          if (j > paramInt6)
          {
            i = j;
            localObject2 = str;
          }
        }
        paramInt5 += 1;
        localObject1 = localObject2;
      }
    }
    else
    {
      localObject1 = null;
    }
    b(paramn, paramArrayOfInt, paramInt1, localObject1, paramInt2, paramInt3, paramInt4, localList);
    if (localList.size() < 2) {
      return a;
    }
    return x.a(localList);
  }
  
  private static e b(t paramt, o paramo, int[][] paramArrayOfInt, b.b paramb, e.a parama)
  {
    int i;
    if (paramb.k) {
      i = 24;
    } else {
      i = 16;
    }
    boolean bool;
    if ((paramb.j) && ((paramt.m() & i) != 0)) {
      bool = true;
    } else {
      bool = false;
    }
    int j = 0;
    while (j < paramo.b)
    {
      paramt = paramo.a(j);
      int[] arrayOfInt = a(paramt, paramArrayOfInt[j], bool, i, paramb.c, paramb.d, paramb.e, paramb.g, paramb.h, paramb.i);
      if (arrayOfInt.length > 0) {
        return parama.a(paramt, arrayOfInt);
      }
      j += 1;
    }
    return null;
  }
  
  private static e b(o paramo, int[][] paramArrayOfInt, b.b paramb)
  {
    int i3 = 0;
    Object localObject1 = null;
    int i = 0;
    int j = 0;
    int k = -1;
    int i1;
    for (int m = -1;; m = i1)
    {
      Object localObject2 = paramo;
      if (i3 >= ((o)localObject2).b) {
        break;
      }
      n localn = ((o)localObject2).a(i3);
      List localList = a(localn, paramb.g, paramb.h, paramb.i);
      int[] arrayOfInt = paramArrayOfInt[i3];
      int n = j;
      i1 = i;
      int i2 = 0;
      i = m;
      j = k;
      m = n;
      n = i1;
      k = i2;
      while (k < localn.a)
      {
        localObject2 = localObject1;
        int i7 = n;
        int i6 = m;
        int i5 = j;
        int i4 = i;
        if (a(arrayOfInt[k], paramb.l))
        {
          k localk = localn.a(k);
          if ((localList.contains(Integer.valueOf(k))) && ((localk.j == -1) || (localk.j <= paramb.c)) && ((localk.k == -1) || (localk.k <= paramb.d)) && ((localk.b == -1) || (localk.b <= paramb.e))) {
            i4 = 1;
          } else {
            i4 = 0;
          }
          if ((i4 == 0) && (!paramb.f))
          {
            localObject2 = localObject1;
            i7 = n;
            i6 = m;
            i5 = j;
            i4 = i;
          }
          else
          {
            if (i4 != 0) {
              i2 = 2;
            } else {
              i2 = 1;
            }
            boolean bool = a(arrayOfInt[k], false);
            i1 = i2;
            if (bool) {
              i1 = i2 + 1000;
            }
            if (i1 > m) {
              i2 = 1;
            } else {
              i2 = 0;
            }
            if (i1 == m)
            {
              if (localk.a() != j) {
                i2 = a(localk.a(), j);
              } else {
                i2 = a(localk.b, i);
              }
              if ((bool) && (i4 != 0) ? i2 > 0 : i2 < 0) {
                i2 = 1;
              } else {
                i2 = 0;
              }
            }
            localObject2 = localObject1;
            i7 = n;
            i6 = m;
            i5 = j;
            i4 = i;
            if (i2 != 0)
            {
              i4 = localk.b;
              i5 = localk.a();
              i7 = k;
              localObject2 = localn;
              i6 = i1;
            }
          }
        }
        k += 1;
        localObject1 = localObject2;
        n = i7;
        m = i6;
        j = i5;
        i = i4;
      }
      i3 += 1;
      k = j;
      i1 = i;
      i = n;
      j = m;
    }
    if (localObject1 == null) {
      return null;
    }
    return new c(localObject1, i);
  }
  
  private static void b(n paramn, int[] paramArrayOfInt, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, List<Integer> paramList)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      int j = ((Integer)paramList.get(i)).intValue();
      if (!a(paramn.a(j), paramString, paramArrayOfInt[j], paramInt1, paramInt2, paramInt3, paramInt4)) {
        paramList.remove(i);
      }
      i -= 1;
    }
  }
  
  protected e a(int paramInt, o paramo, int[][] paramArrayOfInt, b.b paramb)
  {
    Object localObject1 = null;
    int n = 0;
    paramInt = 0;
    int i = 0;
    while (n < paramo.b)
    {
      n localn = paramo.a(n);
      int[] arrayOfInt = paramArrayOfInt[n];
      int j = paramInt;
      int k = 0;
      paramInt = i;
      i = k;
      while (i < localn.a)
      {
        Object localObject2 = localObject1;
        int i1 = j;
        int m = paramInt;
        if (a(arrayOfInt[i], paramb.l))
        {
          k = localn.a(i).x;
          m = 1;
          if ((k & 0x1) != 0) {
            k = 1;
          } else {
            k = 0;
          }
          if (k != 0) {
            m = 2;
          }
          k = m;
          if (a(arrayOfInt[i], false)) {
            k = m + 1000;
          }
          localObject2 = localObject1;
          i1 = j;
          m = paramInt;
          if (k > paramInt)
          {
            i1 = i;
            localObject2 = localn;
            m = k;
          }
        }
        i += 1;
        localObject1 = localObject2;
        j = i1;
        paramInt = m;
      }
      n += 1;
      i = paramInt;
      paramInt = j;
    }
    if (localObject1 == null) {
      return null;
    }
    return new c(localObject1, paramInt);
  }
  
  protected e a(t paramt, o paramo, int[][] paramArrayOfInt, b.b paramb, e.a parama)
  {
    if (parama != null) {
      paramt = b(paramt, paramo, paramArrayOfInt, paramb, parama);
    } else {
      paramt = null;
    }
    parama = paramt;
    if (paramt == null) {
      parama = b(paramo, paramArrayOfInt, paramb);
    }
    return parama;
  }
  
  protected e a(o paramo, int[][] paramArrayOfInt, b.b paramb)
  {
    int i1 = 0;
    Object localObject1 = null;
    int i = 0;
    int j = 0;
    while (i1 < paramo.b)
    {
      n localn = paramo.a(i1);
      int[] arrayOfInt = paramArrayOfInt[i1];
      int k = 0;
      int m = i;
      while (k < localn.a)
      {
        Object localObject2 = localObject1;
        int i2 = m;
        i = j;
        if (a(arrayOfInt[k], paramb.l))
        {
          k localk = localn.a(k);
          i = localk.x;
          int i3 = 1;
          if ((i & 0x1) != 0) {
            i = 1;
          } else {
            i = 0;
          }
          if ((localk.x & 0x2) != 0) {
            n = 1;
          } else {
            n = 0;
          }
          if (a(localk, paramb.b))
          {
            if (i != 0) {
              i = 6;
            } else if (n == 0) {
              i = 5;
            } else {
              i = 4;
            }
          }
          else if (i != 0)
          {
            i = 3;
          }
          else
          {
            localObject2 = localObject1;
            i2 = m;
            i = j;
            if (n == 0) {
              break label276;
            }
            i = i3;
            if (a(localk, paramb.a)) {
              i = 2;
            }
          }
          int n = i;
          if (a(arrayOfInt[k], false)) {
            n = i + 1000;
          }
          localObject2 = localObject1;
          i2 = m;
          i = j;
          if (n > j)
          {
            i2 = k;
            localObject2 = localn;
            i = n;
          }
        }
        label276:
        k += 1;
        localObject1 = localObject2;
        m = i2;
        j = i;
      }
      i1 += 1;
      i = m;
    }
    if (localObject1 == null) {
      return null;
    }
    return new c(localObject1, i);
  }
  
  protected e a(o paramo, int[][] paramArrayOfInt, b.b paramb, e.a parama)
  {
    int i = 0;
    int j = -1;
    int k = -1;
    int m = 0;
    while (i < paramo.b)
    {
      n localn = paramo.a(i);
      int[] arrayOfInt = paramArrayOfInt[i];
      int n = j;
      int i1 = 0;
      j = m;
      m = i1;
      while (m < localn.a)
      {
        int i3 = n;
        int i2 = k;
        i1 = j;
        if (a(arrayOfInt[m], paramb.l))
        {
          k localk = localn.a(m);
          int i4 = a(arrayOfInt[m], paramb.a, localk);
          i3 = n;
          i2 = k;
          i1 = j;
          if (i4 > j)
          {
            i3 = i;
            i2 = m;
            i1 = i4;
          }
        }
        m += 1;
        n = i3;
        k = i2;
        j = i1;
      }
      i += 1;
      m = j;
      j = n;
    }
    if (j == -1) {
      return null;
    }
    paramo = paramo.a(j);
    if (parama != null)
    {
      paramArrayOfInt = a(paramo, paramArrayOfInt[j], paramb.j);
      if (paramArrayOfInt.length > 0) {
        return parama.a(paramo, paramArrayOfInt);
      }
    }
    return new c(paramo, k);
  }
  
  protected e[] a(t[] paramArrayOft, o[] paramArrayOfo, int[][][] paramArrayOfInt)
  {
    int i2 = paramArrayOft.length;
    e[] arrayOfe = new e[i2];
    b.b localb = (b.b)this.c.get();
    int j = 0;
    int m = 0;
    int i;
    for (int k = 0;; k = n)
    {
      i1 = 1;
      if (m >= i2) {
        break;
      }
      i = j;
      n = k;
      if (2 == paramArrayOft[m].a())
      {
        i = j;
        if (j == 0)
        {
          arrayOfe[m] = a(paramArrayOft[m], paramArrayOfo[m], paramArrayOfInt[m], localb, this.b);
          if (arrayOfe[m] != null) {
            i = 1;
          } else {
            i = 0;
          }
        }
        if (paramArrayOfo[m].b > 0) {
          j = i1;
        } else {
          j = 0;
        }
        n = k | j;
      }
      m += 1;
      j = i;
    }
    m = 0;
    int i1 = 0;
    for (int n = 0; m < i2; n = j)
    {
      int i3 = paramArrayOft[m].a();
      if (i3 != 1)
      {
        i = i1;
        j = n;
        if (i3 != 2) {
          if (i3 != 3)
          {
            arrayOfe[m] = a(paramArrayOft[m].a(), paramArrayOfo[m], paramArrayOfInt[m], localb);
            i = i1;
            j = n;
          }
          else
          {
            i = i1;
            j = n;
            if (n == 0)
            {
              arrayOfe[m] = a(paramArrayOfo[m], paramArrayOfInt[m], localb);
              if (arrayOfe[m] != null)
              {
                j = 1;
                i = i1;
              }
              else
              {
                j = 0;
                i = i1;
              }
            }
          }
        }
      }
      else
      {
        i = i1;
        j = n;
        if (i1 == 0)
        {
          o localo = paramArrayOfo[m];
          int[][] arrayOfInt = paramArrayOfInt[m];
          e.a locala;
          if (k != 0) {
            locala = null;
          } else {
            locala = this.b;
          }
          arrayOfe[m] = a(localo, arrayOfInt, localb, locala);
          if (arrayOfe[m] != null)
          {
            i = 1;
            j = n;
          }
          else
          {
            i = 0;
            j = n;
          }
        }
      }
      m += 1;
      i1 = i;
    }
    return arrayOfe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.al.b
 * JD-Core Version:    0.7.0.1
 */