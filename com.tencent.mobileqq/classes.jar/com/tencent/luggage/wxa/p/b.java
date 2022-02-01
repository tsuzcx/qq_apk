package com.tencent.luggage.wxa.p;

import android.util.Log;
import android.util.Pair;
import com.tencent.luggage.wxa.ao.x;
import com.tencent.luggage.wxa.h.p;
import com.tencent.luggage.wxa.l.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class b
{
  private static final int a = x.f("vide");
  private static final int b = x.f("soun");
  private static final int c = x.f("text");
  private static final int d = x.f("sbtl");
  private static final int e = x.f("subt");
  private static final int f = x.f("clcp");
  private static final int g = x.f("cenc");
  private static final int h = x.f("meta");
  
  private static long a(com.tencent.luggage.wxa.ao.m paramm)
  {
    int i = 8;
    paramm.c(8);
    if (a.a(paramm.n()) != 0) {
      i = 16;
    }
    paramm.d(i);
    return paramm.l();
  }
  
  static Pair<Integer, k> a(com.tencent.luggage.wxa.ao.m paramm, int paramInt1, int paramInt2)
  {
    int i = paramInt1 + 8;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    int k = -1;
    int j = 0;
    while (i - paramInt1 < paramInt2)
    {
      paramm.c(i);
      int m = paramm.n();
      int n = paramm.n();
      Object localObject4;
      Object localObject3;
      if (n == a.ab)
      {
        localObject4 = Integer.valueOf(paramm.n());
        localObject3 = localObject2;
      }
      else if (n == a.W)
      {
        paramm.d(4);
        localObject3 = paramm.e(4);
        localObject4 = localObject1;
      }
      else
      {
        localObject3 = localObject2;
        localObject4 = localObject1;
        if (n == a.X)
        {
          k = i;
          j = m;
          localObject4 = localObject1;
          localObject3 = localObject2;
        }
      }
      i += m;
      localObject2 = localObject3;
      localObject1 = localObject4;
    }
    if ((!"cenc".equals(localObject2)) && (!"cbc1".equals(localObject2)) && (!"cens".equals(localObject2)) && (!"cbcs".equals(localObject2))) {
      return null;
    }
    boolean bool2 = true;
    boolean bool1;
    if (localObject1 != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    com.tencent.luggage.wxa.ao.a.a(bool1, "frma atom is mandatory");
    if (k != -1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    com.tencent.luggage.wxa.ao.a.a(bool1, "schi atom is mandatory");
    paramm = a(paramm, k, j, localObject2);
    if (paramm != null) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    com.tencent.luggage.wxa.ao.a.a(bool1, "tenc atom is mandatory");
    return Pair.create(localObject1, paramm);
  }
  
  private static Pair<long[], long[]> a(a.a parama)
  {
    if (parama != null)
    {
      parama = parama.d(a.Q);
      if (parama != null)
      {
        parama = parama.aQ;
        parama.c(8);
        int j = a.a(parama.n());
        int k = parama.t();
        long[] arrayOfLong1 = new long[k];
        long[] arrayOfLong2 = new long[k];
        int i = 0;
        while (i < k)
        {
          long l;
          if (j == 1) {
            l = parama.v();
          } else {
            l = parama.l();
          }
          arrayOfLong1[i] = l;
          if (j == 1) {
            l = parama.p();
          } else {
            l = parama.n();
          }
          arrayOfLong2[i] = l;
          if (parama.j() == 1)
          {
            parama.d(2);
            i += 1;
          }
          else
          {
            throw new IllegalArgumentException("Unsupported media rate.");
          }
        }
        return Pair.create(arrayOfLong1, arrayOfLong2);
      }
    }
    return Pair.create(null, null);
  }
  
  private static b.c a(com.tencent.luggage.wxa.ao.m paramm, int paramInt1, int paramInt2, String paramString, com.tencent.luggage.wxa.k.a parama, boolean paramBoolean)
  {
    paramm.c(12);
    int j = paramm.n();
    b.c localc = new b.c(j);
    int i = 0;
    while (i < j)
    {
      int k = paramm.d();
      int m = paramm.n();
      boolean bool;
      if (m > 0) {
        bool = true;
      } else {
        bool = false;
      }
      com.tencent.luggage.wxa.ao.a.a(bool, "childAtomSize should be positive");
      int n = paramm.n();
      if ((n != a.b) && (n != a.c) && (n != a.Z) && (n != a.al) && (n != a.d) && (n != a.e) && (n != a.f) && (n != a.aK) && (n != a.aL))
      {
        if ((n != a.i) && (n != a.aa) && (n != a.n) && (n != a.p) && (n != a.r) && (n != a.u) && (n != a.s) && (n != a.t) && (n != a.ay) && (n != a.az) && (n != a.l) && (n != a.m) && (n != a.j) && (n != a.aO))
        {
          if ((n != a.aj) && (n != a.au) && (n != a.av) && (n != a.aw) && (n != a.ax))
          {
            if (n == a.aN) {
              localc.b = com.tencent.luggage.wxa.h.k.a(Integer.toString(paramInt1), "application/x-camera-motion", null, -1, null);
            }
          }
          else {
            a(paramm, n, k, m, paramInt1, paramString, localc);
          }
        }
        else {
          a(paramm, n, k, m, paramInt1, paramString, paramBoolean, parama, localc, i);
        }
      }
      else {
        a(paramm, n, k, m, paramInt1, paramInt2, parama, localc, i);
      }
      paramm.c(k + m);
      i += 1;
    }
    return localc;
  }
  
  public static j a(a.a parama, a.b paramb, long paramLong, com.tencent.luggage.wxa.k.a parama1, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = parama.e(a.E);
    int i = c(((a.a)localObject).d(a.S).aQ);
    if (i == -1) {
      return null;
    }
    b.f localf = b(parama.d(a.O).aQ);
    long l1 = -9223372036854775807L;
    if (paramLong == -9223372036854775807L) {
      paramLong = b.f.a(localf);
    }
    long l2 = a(paramb.aQ);
    if (paramLong == -9223372036854775807L) {
      paramLong = l1;
    } else {
      paramLong = x.b(paramLong, 1000000L, l2);
    }
    paramb = ((a.a)localObject).e(a.F).e(a.G);
    localObject = d(((a.a)localObject).d(a.R).aQ);
    parama1 = a(paramb.d(a.T).aQ, b.f.b(localf), b.f.c(localf), (String)((Pair)localObject).second, parama1, paramBoolean2);
    if (!paramBoolean1)
    {
      paramb = a(parama.e(a.P));
      parama = (long[])paramb.first;
      paramb = (long[])paramb.second;
    }
    else
    {
      parama = null;
      paramb = parama;
    }
    if (parama1.b == null) {
      return null;
    }
    return new j(b.f.b(localf), i, ((Long)((Pair)localObject).first).longValue(), l2, paramLong, parama1.b, parama1.d, parama1.a, parama1.c, parama, paramb);
  }
  
  private static k a(com.tencent.luggage.wxa.ao.m paramm, int paramInt1, int paramInt2, String paramString)
  {
    int i = paramInt1 + 8;
    for (;;)
    {
      Object localObject2 = null;
      if (i - paramInt1 >= paramInt2) {
        break;
      }
      paramm.c(i);
      int j = paramm.n();
      if (paramm.n() == a.Y)
      {
        paramInt1 = a.a(paramm.n());
        paramm.d(1);
        if (paramInt1 == 0)
        {
          paramm.d(1);
          paramInt1 = 0;
          paramInt2 = 0;
        }
        else
        {
          paramInt1 = paramm.g();
          paramInt2 = paramInt1 & 0xF;
          paramInt1 = (paramInt1 & 0xF0) >> 4;
        }
        boolean bool;
        if (paramm.g() == 1) {
          bool = true;
        } else {
          bool = false;
        }
        i = paramm.g();
        byte[] arrayOfByte = new byte[16];
        paramm.a(arrayOfByte, 0, arrayOfByte.length);
        Object localObject1 = localObject2;
        if (bool)
        {
          localObject1 = localObject2;
          if (i == 0)
          {
            j = paramm.g();
            localObject1 = new byte[j];
            paramm.a((byte[])localObject1, 0, j);
          }
        }
        return new k(bool, paramString, i, arrayOfByte, paramInt1, paramInt2, (byte[])localObject1);
      }
      i += j;
    }
    return null;
  }
  
  public static m a(j paramj, a.a parama, h paramh)
  {
    Object localObject1 = parama.d(a.aq);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = new b.d((a.b)localObject1);
    }
    else
    {
      localObject1 = parama.d(a.ar);
      if (localObject1 == null) {
        break label2153;
      }
      localObject2 = new b.e((a.b)localObject1);
    }
    int m = ((b.b)localObject2).a();
    if (m == 0) {
      return new m(new long[0], new int[0], 0, new long[0], new int[0]);
    }
    localObject1 = parama.d(a.as);
    boolean bool;
    if (localObject1 == null)
    {
      localObject1 = parama.d(a.at);
      bool = true;
    }
    else
    {
      bool = false;
    }
    Object localObject3 = ((a.b)localObject1).aQ;
    Object localObject4 = parama.d(a.ap).aQ;
    Object localObject7 = parama.d(a.am).aQ;
    localObject1 = parama.d(a.an);
    if (localObject1 != null) {
      localObject1 = ((a.b)localObject1).aQ;
    } else {
      localObject1 = null;
    }
    parama = parama.d(a.ao);
    if (parama != null) {
      parama = parama.aQ;
    } else {
      parama = null;
    }
    Object localObject8 = new b.a((com.tencent.luggage.wxa.ao.m)localObject4, (com.tencent.luggage.wxa.ao.m)localObject3, bool);
    ((com.tencent.luggage.wxa.ao.m)localObject7).c(12);
    int i1 = ((com.tencent.luggage.wxa.ao.m)localObject7).t() - 1;
    int i2 = ((com.tencent.luggage.wxa.ao.m)localObject7).t();
    int i5 = ((com.tencent.luggage.wxa.ao.m)localObject7).t();
    int i;
    if (parama != null)
    {
      parama.c(12);
      i = parama.t();
    }
    else
    {
      i = 0;
    }
    int j = -1;
    int k;
    if (localObject1 != null)
    {
      ((com.tencent.luggage.wxa.ao.m)localObject1).c(12);
      k = ((com.tencent.luggage.wxa.ao.m)localObject1).t();
      if (k > 0) {
        j = ((com.tencent.luggage.wxa.ao.m)localObject1).t() - 1;
      } else {
        localObject1 = null;
      }
    }
    else
    {
      k = 0;
    }
    int n;
    if ((((b.b)localObject2).c()) && ("audio/raw".equals(paramj.f.f)) && (i1 == 0) && (i == 0) && (k == 0)) {
      n = 1;
    } else {
      n = 0;
    }
    long l3 = 0L;
    Object localObject6;
    Object localObject5;
    long l1;
    int i3;
    long l2;
    int i4;
    if (n == 0)
    {
      localObject6 = new long[m];
      localObject5 = new int[m];
      localObject3 = new long[m];
      localObject4 = new int[m];
      int i6 = k;
      int i7 = j;
      l1 = 0L;
      n = i1;
      int i8 = 0;
      k = 0;
      i3 = 0;
      i1 = 0;
      l2 = l1;
      i4 = 0;
      j = i;
      i = i8;
      while (i4 < m)
      {
        int i10 = i2;
        while (i3 == 0)
        {
          com.tencent.luggage.wxa.ao.a.b(((b.a)localObject8).a());
          l2 = ((b.a)localObject8).d;
          i3 = ((b.a)localObject8).c;
        }
        i2 = n;
        n = k;
        int i9 = j;
        i8 = i1;
        if (parama != null)
        {
          while ((i1 == 0) && (j > 0))
          {
            i1 = parama.t();
            k = parama.n();
            j -= 1;
          }
          i8 = i1 - 1;
          i9 = j;
          n = k;
        }
        localObject6[i4] = l2;
        localObject5[i4] = ((b.b)localObject2).b();
        j = i;
        if (localObject5[i4] > i) {
          j = localObject5[i4];
        }
        localObject3[i4] = (l1 + n);
        if (localObject1 == null) {
          i = 1;
        } else {
          i = 0;
        }
        localObject4[i4] = i;
        int i11 = i6;
        i1 = i7;
        if (i4 == i7)
        {
          localObject4[i4] = 1;
          i = i6 - 1;
          i11 = i;
          i1 = i7;
          if (i > 0)
          {
            i1 = ((com.tencent.luggage.wxa.ao.m)localObject1).t() - 1;
            i11 = i;
          }
        }
        l1 += i5;
        i6 = i10 - 1;
        k = i6;
        i7 = i5;
        i = i2;
        if (i6 == 0)
        {
          k = i6;
          i7 = i5;
          i = i2;
          if (i2 > 0)
          {
            k = ((com.tencent.luggage.wxa.ao.m)localObject7).t();
            i7 = ((com.tencent.luggage.wxa.ao.m)localObject7).t();
            i = i2 - 1;
          }
        }
        l2 += localObject5[i4];
        i3 -= 1;
        i4 += 1;
        i2 = m;
        m = j;
        j = n;
        n = i;
        i6 = i11;
        i = m;
        m = i2;
        i5 = i7;
        i7 = i1;
        i2 = k;
        k = j;
        j = i9;
        i1 = i8;
      }
      if (i1 == 0) {
        bool = true;
      } else {
        bool = false;
      }
      com.tencent.luggage.wxa.ao.a.a(bool);
      while (j > 0)
      {
        if (parama.t() == 0) {
          bool = true;
        } else {
          bool = false;
        }
        com.tencent.luggage.wxa.ao.a.a(bool);
        parama.n();
        j -= 1;
      }
      if ((i6 == 0) && (i2 == 0) && (i3 == 0) && (n == 0)) {
        break label978;
      }
      parama = new StringBuilder();
      parama.append("Inconsistent stbl box for track ");
      parama.append(paramj.a);
      parama.append(": remainingSynchronizationSamples ");
      parama.append(i6);
      parama.append(", remainingSamplesAtTimestampDelta ");
      parama.append(i2);
      parama.append(", remainingSamplesInChunk ");
      parama.append(i3);
      parama.append(", remainingTimestampDeltaChanges ");
      parama.append(n);
      Log.w("AtomParsers", parama.toString());
      label978:
      localObject1 = localObject6;
      parama = (a.a)localObject5;
      localObject2 = localObject4;
      j = m;
    }
    else
    {
      j = m;
      parama = new long[((b.a)localObject8).a];
      localObject1 = new int[((b.a)localObject8).a];
      while (((b.a)localObject8).a())
      {
        parama[localObject8.b] = ((b.a)localObject8).d;
        localObject1[localObject8.b] = ((b.a)localObject8).c;
      }
      localObject2 = d.a(((b.b)localObject2).b(), parama, (int[])localObject1, i5);
      localObject1 = ((d.a)localObject2).a;
      parama = ((d.a)localObject2).b;
      i = ((d.a)localObject2).c;
      localObject3 = ((d.a)localObject2).d;
      localObject2 = ((d.a)localObject2).e;
      l1 = 0L;
    }
    localObject7 = "AtomParsers";
    localObject8 = paramj;
    if ((((j)localObject8).h != null) && (!paramh.a()))
    {
      long l4;
      if ((((j)localObject8).h.length == 1) && (((j)localObject8).b == 1) && (localObject3.length >= 2))
      {
        l4 = localObject8.i[0];
        l2 = x.b(localObject8.h[0], ((j)localObject8).c, ((j)localObject8).d) + l4;
        if ((localObject3[0] <= l4) && (l4 < localObject3[1]) && (localObject3[(localObject3.length - 1)] < l2) && (l2 <= l1))
        {
          l4 = x.b(l4 - localObject3[0], ((j)localObject8).f.s, ((j)localObject8).c);
          l1 = x.b(l1 - l2, ((j)localObject8).f.s, ((j)localObject8).c);
          if (((l4 != 0L) || (l1 != 0L)) && (l4 <= 2147483647L) && (l1 <= 2147483647L))
          {
            paramh.b = ((int)l4);
            paramh.c = ((int)l1);
            x.a((long[])localObject3, 1000000L, ((j)localObject8).c);
            return new m((long[])localObject1, parama, i, (long[])localObject3, (int[])localObject2);
          }
        }
      }
      if ((((j)localObject8).h.length == 1) && (localObject8.h[0] == 0L))
      {
        j = 0;
        while (j < localObject3.length)
        {
          localObject3[j] = x.b(localObject3[j] - localObject8.i[0], 1000000L, ((j)localObject8).c);
          j += 1;
        }
        return new m((long[])localObject1, parama, i, (long[])localObject3, (int[])localObject2);
      }
      if (((j)localObject8).b == 1) {
        bool = true;
      } else {
        bool = false;
      }
      n = 0;
      k = 0;
      m = 0;
      i1 = 0;
      paramj = parama;
      while (n < ((j)localObject8).h.length)
      {
        l1 = localObject8.i[n];
        if (l1 != -1L)
        {
          l2 = x.b(localObject8.h[n], ((j)localObject8).c, ((j)localObject8).d);
          i4 = x.b((long[])localObject3, l1, true, true);
          i3 = x.b((long[])localObject3, l1 + l2, bool, false);
          i2 = m + (i3 - i4);
          if (i1 != i4) {
            m = 1;
          } else {
            m = 0;
          }
          k |= m;
          i1 = i3;
          m = i2;
        }
        n += 1;
      }
      parama = (a.a)localObject2;
      if (m != j) {
        j = 1;
      } else {
        j = 0;
      }
      i2 = j | k;
      if (i2 != 0) {
        paramh = new long[m];
      } else {
        paramh = (h)localObject1;
      }
      if (i2 != 0) {
        localObject4 = new int[m];
      } else {
        localObject4 = paramj;
      }
      if (i2 != 0) {
        j = 0;
      } else {
        j = i;
      }
      if (i2 != 0) {
        localObject2 = new int[m];
      } else {
        localObject2 = parama;
      }
      long[] arrayOfLong = new long[m];
      m = 0;
      k = 0;
      localObject6 = parama;
      localObject5 = paramj;
      l1 = l3;
      parama = (a.a)localObject2;
      localObject2 = arrayOfLong;
      paramj = (j)localObject7;
      while (m < ((j)localObject8).h.length)
      {
        l2 = localObject8.i[m];
        l3 = localObject8.h[m];
        if (l2 != -1L)
        {
          l4 = x.b(l3, ((j)localObject8).c, ((j)localObject8).d);
          n = x.b((long[])localObject3, l2, true, true);
          i3 = x.b((long[])localObject3, l4 + l2, bool, false);
          if (i2 != 0)
          {
            i1 = i3 - n;
            System.arraycopy(localObject1, n, paramh, k, i1);
            System.arraycopy(localObject5, n, localObject4, k, i1);
            System.arraycopy(localObject6, n, parama, k, i1);
          }
          while (n < i3)
          {
            localObject2[k] = (x.b(l1, 1000000L, ((j)localObject8).d) + x.b(localObject3[n] - l2, 1000000L, ((j)localObject8).c));
            i1 = j;
            if (i2 != 0)
            {
              i1 = j;
              if (localObject4[k] > j) {
                i1 = localObject5[n];
              }
            }
            k += 1;
            n += 1;
            j = i1;
          }
          localObject7 = paramj;
          paramj = parama;
          parama = (a.a)localObject7;
        }
        else
        {
          localObject7 = parama;
          parama = paramj;
          paramj = (j)localObject7;
        }
        l1 += l3;
        m += 1;
        localObject7 = localObject5;
        localObject5 = paramj;
        paramj = parama;
        parama = (a.a)localObject5;
        localObject5 = localObject7;
      }
      k = 0;
      m = 0;
      while ((k < parama.length) && (m == 0))
      {
        if ((parama[k] & 0x1) != 0) {
          n = 1;
        } else {
          n = 0;
        }
        m |= n;
        k += 1;
      }
      if (m == 0)
      {
        Log.w(paramj, "Ignoring edit list: Edited sample sequence does not contain a sync sample.");
        x.a((long[])localObject3, 1000000L, ((j)localObject8).c);
        return new m((long[])localObject1, (int[])localObject5, i, (long[])localObject3, (int[])localObject6);
      }
      return new m(paramh, (int[])localObject4, j, (long[])localObject2, parama);
    }
    x.a((long[])localObject3, 1000000L, ((j)localObject8).c);
    return new m((long[])localObject1, parama, i, (long[])localObject3, (int[])localObject2);
    label2153:
    paramj = new p("Track has no sample table size information");
    for (;;)
    {
      throw paramj;
    }
  }
  
  private static com.tencent.luggage.wxa.v.a a(com.tencent.luggage.wxa.ao.m paramm, int paramInt)
  {
    paramm.d(12);
    while (paramm.d() < paramInt)
    {
      int i = paramm.d();
      int j = paramm.n();
      if (paramm.n() == a.aC)
      {
        paramm.c(i);
        return b(paramm, i + j);
      }
      paramm.d(j - 8);
    }
    return null;
  }
  
  public static com.tencent.luggage.wxa.v.a a(a.b paramb, boolean paramBoolean)
  {
    if (paramBoolean) {
      return null;
    }
    paramb = paramb.aQ;
    paramb.c(8);
    while (paramb.b() >= 8)
    {
      int i = paramb.d();
      int j = paramb.n();
      if (paramb.n() == a.aB)
      {
        paramb.c(i);
        return a(paramb, i + j);
      }
      paramb.d(j - 8);
    }
    return null;
  }
  
  private static void a(com.tencent.luggage.wxa.ao.m paramm, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, com.tencent.luggage.wxa.k.a parama, b.c paramc, int paramInt6)
  {
    paramm.c(paramInt2 + 8 + 8);
    paramm.d(16);
    int n = paramm.h();
    int i1 = paramm.h();
    paramm.d(50);
    int j = paramm.d();
    int k = a.Z;
    com.tencent.luggage.wxa.k.a locala = null;
    Object localObject2 = parama;
    int i = paramInt1;
    Object localObject1;
    if (paramInt1 == k)
    {
      localObject2 = c(paramm, paramInt2, paramInt3);
      localObject1 = parama;
      if (localObject2 != null)
      {
        paramInt1 = ((Integer)((Pair)localObject2).first).intValue();
        if (parama == null) {
          localObject1 = null;
        } else {
          localObject1 = parama.a(((k)((Pair)localObject2).second).b);
        }
        paramc.a[paramInt6] = ((k)((Pair)localObject2).second);
      }
      paramm.c(j);
      i = paramInt1;
      localObject2 = localObject1;
    }
    Object localObject4 = null;
    Object localObject3 = localObject4;
    paramInt1 = 0;
    float f1 = 1.0F;
    k = -1;
    paramInt6 = j;
    j = paramInt1;
    while (paramInt6 - paramInt2 < paramInt3)
    {
      paramm.c(paramInt6);
      paramInt1 = paramm.d();
      int i2 = paramm.n();
      if ((i2 == 0) && (paramm.d() - paramInt2 == paramInt3)) {
        break;
      }
      boolean bool;
      if (i2 > 0) {
        bool = true;
      } else {
        bool = false;
      }
      com.tencent.luggage.wxa.ao.a.a(bool, "childAtomSize should be positive");
      int i3 = paramm.n();
      int m;
      float f2;
      Object localObject5;
      if (i3 == a.H)
      {
        if (locala == null) {
          bool = true;
        } else {
          bool = false;
        }
        com.tencent.luggage.wxa.ao.a.b(bool);
        paramm.c(paramInt1 + 8);
        parama = com.tencent.luggage.wxa.ap.a.a(paramm);
        localObject1 = parama.a;
        paramc.c = parama.b;
        if (j == 0) {
          f1 = parama.e;
        }
        parama = "video/avc";
        m = j;
        f2 = f1;
        localObject5 = localObject3;
        paramInt1 = k;
      }
      else if (i3 == a.I)
      {
        if (locala == null) {
          bool = true;
        } else {
          bool = false;
        }
        com.tencent.luggage.wxa.ao.a.b(bool);
        paramm.c(paramInt1 + 8);
        parama = com.tencent.luggage.wxa.ap.d.a(paramm);
        localObject1 = parama.a;
        paramc.c = parama.b;
        parama = "video/hevc";
        m = j;
        f2 = f1;
        localObject5 = localObject3;
        paramInt1 = k;
      }
      else if (i3 == a.aM)
      {
        if (locala == null) {
          bool = true;
        } else {
          bool = false;
        }
        com.tencent.luggage.wxa.ao.a.b(bool);
        if (i == a.aK) {
          parama = "video/x-vnd.on2.vp8";
        } else {
          parama = "video/x-vnd.on2.vp9";
        }
        m = j;
        localObject1 = localObject4;
        f2 = f1;
        localObject5 = localObject3;
        paramInt1 = k;
      }
      else if (i3 == a.g)
      {
        if (locala == null) {
          bool = true;
        } else {
          bool = false;
        }
        com.tencent.luggage.wxa.ao.a.b(bool);
        parama = "video/3gpp";
        m = j;
        localObject1 = localObject4;
        f2 = f1;
        localObject5 = localObject3;
        paramInt1 = k;
      }
      else if (i3 == a.J)
      {
        if (locala == null) {
          bool = true;
        } else {
          bool = false;
        }
        com.tencent.luggage.wxa.ao.a.b(bool);
        localObject1 = d(paramm, paramInt1);
        parama = (String)((Pair)localObject1).first;
        localObject1 = Collections.singletonList(((Pair)localObject1).second);
        m = j;
        f2 = f1;
        localObject5 = localObject3;
        paramInt1 = k;
      }
      else if (i3 == a.ai)
      {
        f2 = c(paramm, paramInt1);
        m = 1;
        parama = locala;
        localObject1 = localObject4;
        localObject5 = localObject3;
        paramInt1 = k;
      }
      else if (i3 == a.aI)
      {
        localObject5 = d(paramm, paramInt1, i2);
        m = j;
        parama = locala;
        localObject1 = localObject4;
        f2 = f1;
        paramInt1 = k;
      }
      else
      {
        m = j;
        parama = locala;
        localObject1 = localObject4;
        f2 = f1;
        localObject5 = localObject3;
        paramInt1 = k;
        if (i3 == a.aH)
        {
          i3 = paramm.g();
          paramm.d(3);
          m = j;
          parama = locala;
          localObject1 = localObject4;
          f2 = f1;
          localObject5 = localObject3;
          paramInt1 = k;
          if (i3 == 0)
          {
            paramInt1 = paramm.g();
            if (paramInt1 != 0)
            {
              if (paramInt1 != 1)
              {
                if (paramInt1 != 2)
                {
                  if (paramInt1 != 3)
                  {
                    m = j;
                    parama = locala;
                    localObject1 = localObject4;
                    f2 = f1;
                    localObject5 = localObject3;
                    paramInt1 = k;
                  }
                  else
                  {
                    paramInt1 = 3;
                    m = j;
                    parama = locala;
                    localObject1 = localObject4;
                    f2 = f1;
                    localObject5 = localObject3;
                  }
                }
                else
                {
                  paramInt1 = 2;
                  m = j;
                  parama = locala;
                  localObject1 = localObject4;
                  f2 = f1;
                  localObject5 = localObject3;
                }
              }
              else
              {
                paramInt1 = 1;
                m = j;
                parama = locala;
                localObject1 = localObject4;
                f2 = f1;
                localObject5 = localObject3;
              }
            }
            else
            {
              paramInt1 = 0;
              localObject5 = localObject3;
              f2 = f1;
              localObject1 = localObject4;
              parama = locala;
              m = j;
            }
          }
        }
      }
      paramInt6 += i2;
      j = m;
      locala = parama;
      localObject4 = localObject1;
      f1 = f2;
      localObject3 = localObject5;
      k = paramInt1;
    }
    if (locala == null) {
      return;
    }
    paramc.b = com.tencent.luggage.wxa.h.k.a(Integer.toString(paramInt4), locala, null, -1, -1, n, i1, -1.0F, localObject4, paramInt5, f1, localObject3, k, null, (com.tencent.luggage.wxa.k.a)localObject2);
  }
  
  private static void a(com.tencent.luggage.wxa.ao.m paramm, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, b.c paramc)
  {
    paramm.c(paramInt2 + 8 + 8);
    paramInt2 = a.aj;
    String str = "application/ttml+xml";
    Object localObject = null;
    long l = 9223372036854775807L;
    if (paramInt1 == paramInt2) {
      paramm = str;
    }
    for (;;)
    {
      break;
      if (paramInt1 == a.au)
      {
        paramInt1 = paramInt3 - 8 - 8;
        localObject = new byte[paramInt1];
        paramm.a((byte[])localObject, 0, paramInt1);
        localObject = Collections.singletonList(localObject);
        paramm = "application/x-quicktime-tx3g";
      }
      else if (paramInt1 == a.av)
      {
        paramm = "application/x-mp4-vtt";
      }
      else if (paramInt1 == a.aw)
      {
        l = 0L;
        paramm = str;
      }
      else
      {
        if (paramInt1 != a.ax) {
          break label157;
        }
        paramc.d = 1;
        paramm = "application/x-mp4-cea-608";
      }
    }
    paramc.b = com.tencent.luggage.wxa.h.k.a(Integer.toString(paramInt4), paramm, null, -1, 0, paramString, -1, null, l, (List)localObject);
    return;
    label157:
    paramm = new IllegalStateException();
    for (;;)
    {
      throw paramm;
    }
  }
  
  private static void a(com.tencent.luggage.wxa.ao.m paramm, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, boolean paramBoolean, com.tencent.luggage.wxa.k.a parama, b.c paramc, int paramInt5)
  {
    int m = paramInt2;
    paramm.c(m + 8 + 8);
    if (paramBoolean)
    {
      k = paramm.h();
      paramm.d(6);
    }
    else
    {
      paramm.d(8);
      k = 0;
    }
    int j;
    int i;
    if ((k != 0) && (k != 1))
    {
      if (k == 2)
      {
        paramm.d(16);
        j = (int)Math.round(paramm.w());
        i = paramm.t();
        paramm.d(20);
      }
    }
    else
    {
      n = paramm.h();
      paramm.d(6);
      i1 = paramm.r();
      j = i1;
      i = n;
      if (k == 1)
      {
        paramm.d(16);
        i = n;
        j = i1;
      }
    }
    int n = paramm.d();
    int i1 = a.aa;
    Object localObject1 = parama;
    int k = paramInt1;
    if (paramInt1 == i1)
    {
      localObject2 = c(paramm, m, paramInt3);
      localObject1 = parama;
      if (localObject2 != null)
      {
        paramInt1 = ((Integer)((Pair)localObject2).first).intValue();
        if (parama == null) {
          localObject1 = null;
        } else {
          localObject1 = parama.a(((k)((Pair)localObject2).second).b);
        }
        paramc.a[paramInt5] = ((k)((Pair)localObject2).second);
      }
      paramm.c(n);
      k = paramInt1;
    }
    Object localObject2 = localObject1;
    paramInt1 = a.n;
    String str1 = "audio/raw";
    if (k == paramInt1) {
      parama = "audio/ac3";
    } else if (k == a.p) {
      parama = "audio/eac3";
    } else if (k == a.r) {
      parama = "audio/vnd.dts";
    } else if ((k != a.s) && (k != a.t))
    {
      if (k == a.u) {
        parama = "audio/vnd.dts.hd;profile=lbr";
      } else if (k == a.ay) {
        parama = "audio/3gpp";
      } else if (k == a.az) {
        parama = "audio/amr-wb";
      } else if ((k != a.l) && (k != a.m))
      {
        if (k == a.j) {
          parama = "audio/mpeg";
        } else if (k == a.aO) {
          parama = "audio/alac";
        } else {
          parama = null;
        }
      }
      else {
        parama = "audio/raw";
      }
    }
    else {
      parama = "audio/vnd.dts.hd";
    }
    paramInt1 = n;
    localObject1 = null;
    k = j;
    m = i;
    while (paramInt1 - paramInt2 < paramInt3)
    {
      paramm.c(paramInt1);
      paramInt5 = paramm.n();
      boolean bool;
      if (paramInt5 > 0) {
        bool = true;
      } else {
        bool = false;
      }
      com.tencent.luggage.wxa.ao.a.a(bool, "childAtomSize should be positive");
      n = paramm.n();
      if ((n != a.J) && ((!paramBoolean) || (n != a.k)))
      {
        if (n == a.o) {
          paramm.c(paramInt1 + 8);
        }
        for (paramc.b = com.tencent.luggage.wxa.i.a.a(paramm, Integer.toString(paramInt4), paramString, (com.tencent.luggage.wxa.k.a)localObject2);; paramc.b = com.tencent.luggage.wxa.i.a.b(paramm, Integer.toString(paramInt4), paramString, (com.tencent.luggage.wxa.k.a)localObject2))
        {
          i = paramInt1;
          paramInt1 = paramInt5;
          paramInt5 = i;
          break label704;
          if (n != a.q) {
            break;
          }
          paramm.c(paramInt1 + 8);
        }
        if (n == a.v)
        {
          paramc.b = com.tencent.luggage.wxa.h.k.a(Integer.toString(paramInt4), parama, null, -1, -1, m, k, null, (com.tencent.luggage.wxa.k.a)localObject2, 0, paramString);
        }
        else if (n == a.aO)
        {
          localObject1 = new byte[paramInt5];
          i = paramInt1;
          paramm.c(i);
          paramm.a((byte[])localObject1, 0, paramInt5);
          paramInt1 = paramInt5;
          paramInt5 = i;
          break label704;
        }
        i = paramInt5;
        paramInt5 = paramInt1;
        paramInt1 = i;
      }
      for (;;)
      {
        label704:
        break;
        j = paramInt5;
        i = paramInt1;
        if (n == a.J) {
          n = i;
        } else {
          n = b(paramm, i, j);
        }
        paramInt1 = j;
        paramInt5 = i;
        if (n != -1)
        {
          parama = d(paramm, n);
          String str2 = (String)parama.first;
          byte[] arrayOfByte = (byte[])parama.second;
          paramInt1 = j;
          paramInt5 = i;
          parama = str2;
          localObject1 = arrayOfByte;
          if ("audio/mp4a-latm".equals(str2))
          {
            parama = com.tencent.luggage.wxa.ao.d.a(arrayOfByte);
            k = ((Integer)parama.first).intValue();
            m = ((Integer)parama.second).intValue();
            localObject1 = arrayOfByte;
            parama = str2;
            paramInt5 = i;
            paramInt1 = j;
          }
        }
      }
      paramInt1 = paramInt5 + paramInt1;
    }
    paramInt1 = 2;
    if ((paramc.b == null) && (parama != null))
    {
      if (!str1.equals(parama)) {
        paramInt1 = -1;
      }
      str1 = Integer.toString(paramInt4);
      if (localObject1 == null) {
        paramm = null;
      } else {
        paramm = Collections.singletonList(localObject1);
      }
      paramc.b = com.tencent.luggage.wxa.h.k.a(str1, parama, null, -1, -1, m, k, paramInt1, paramm, (com.tencent.luggage.wxa.k.a)localObject2, 0, paramString);
    }
  }
  
  private static int b(com.tencent.luggage.wxa.ao.m paramm, int paramInt1, int paramInt2)
  {
    int i = paramm.d();
    while (i - paramInt1 < paramInt2)
    {
      paramm.c(i);
      int j = paramm.n();
      boolean bool;
      if (j > 0) {
        bool = true;
      } else {
        bool = false;
      }
      com.tencent.luggage.wxa.ao.a.a(bool, "childAtomSize should be positive");
      if (paramm.n() == a.J) {
        return i;
      }
      i += j;
    }
    return -1;
  }
  
  private static b.f b(com.tencent.luggage.wxa.ao.m paramm)
  {
    int j = 8;
    paramm.c(8);
    int n = a.a(paramm.n());
    if (n == 0) {
      i = 8;
    } else {
      i = 16;
    }
    paramm.d(i);
    int m = paramm.n();
    paramm.d(4);
    int i1 = paramm.d();
    int i = j;
    if (n == 0) {
      i = 4;
    }
    int k = 0;
    j = 0;
    while (j < i)
    {
      if (paramm.a[(i1 + j)] != -1)
      {
        j = 0;
        break label99;
      }
      j += 1;
    }
    j = 1;
    label99:
    long l2 = -9223372036854775807L;
    long l1;
    if (j != 0)
    {
      paramm.d(i);
      l1 = l2;
    }
    else
    {
      if (n == 0) {
        l1 = paramm.l();
      } else {
        l1 = paramm.v();
      }
      if (l1 == 0L) {
        l1 = l2;
      }
    }
    paramm.d(16);
    j = paramm.n();
    n = paramm.n();
    paramm.d(4);
    i1 = paramm.n();
    int i2 = paramm.n();
    if ((j == 0) && (n == 65536) && (i1 == -65536) && (i2 == 0))
    {
      i = 90;
    }
    else if ((j == 0) && (n == -65536) && (i1 == 65536) && (i2 == 0))
    {
      i = 270;
    }
    else
    {
      i = k;
      if (j == -65536)
      {
        i = k;
        if (n == 0)
        {
          i = k;
          if (i1 == 0)
          {
            i = k;
            if (i2 == -65536) {
              i = 180;
            }
          }
        }
      }
    }
    return new b.f(m, l1, i);
  }
  
  private static com.tencent.luggage.wxa.v.a b(com.tencent.luggage.wxa.ao.m paramm, int paramInt)
  {
    paramm.d(8);
    ArrayList localArrayList = new ArrayList();
    while (paramm.d() < paramInt)
    {
      com.tencent.luggage.wxa.v.a.a locala = f.a(paramm);
      if (locala != null) {
        localArrayList.add(locala);
      }
    }
    if (localArrayList.isEmpty()) {
      return null;
    }
    return new com.tencent.luggage.wxa.v.a(localArrayList);
  }
  
  private static float c(com.tencent.luggage.wxa.ao.m paramm, int paramInt)
  {
    paramm.c(paramInt + 8);
    paramInt = paramm.t();
    int i = paramm.t();
    return paramInt / i;
  }
  
  private static int c(com.tencent.luggage.wxa.ao.m paramm)
  {
    paramm.c(16);
    int i = paramm.n();
    if (i == b) {
      return 1;
    }
    if (i == a) {
      return 2;
    }
    if ((i != c) && (i != d) && (i != e) && (i != f))
    {
      if (i == h) {
        return 4;
      }
      return -1;
    }
    return 3;
  }
  
  private static Pair<Integer, k> c(com.tencent.luggage.wxa.ao.m paramm, int paramInt1, int paramInt2)
  {
    int i = paramm.d();
    while (i - paramInt1 < paramInt2)
    {
      paramm.c(i);
      int j = paramm.n();
      boolean bool;
      if (j > 0) {
        bool = true;
      } else {
        bool = false;
      }
      com.tencent.luggage.wxa.ao.a.a(bool, "childAtomSize should be positive");
      if (paramm.n() == a.V)
      {
        Pair localPair = a(paramm, i, j);
        if (localPair != null) {
          return localPair;
        }
      }
      i += j;
    }
    return null;
  }
  
  private static Pair<Long, String> d(com.tencent.luggage.wxa.ao.m paramm)
  {
    int j = 8;
    paramm.c(8);
    int k = a.a(paramm.n());
    if (k == 0) {
      i = 8;
    } else {
      i = 16;
    }
    paramm.d(i);
    long l = paramm.l();
    int i = j;
    if (k == 0) {
      i = 4;
    }
    paramm.d(i);
    i = paramm.h();
    paramm = new StringBuilder();
    paramm.append("");
    paramm.append((char)((i >> 10 & 0x1F) + 96));
    paramm.append((char)((i >> 5 & 0x1F) + 96));
    paramm.append((char)((i & 0x1F) + 96));
    return Pair.create(Long.valueOf(l), paramm.toString());
  }
  
  private static Pair<String, byte[]> d(com.tencent.luggage.wxa.ao.m paramm, int paramInt)
  {
    paramm.c(paramInt + 8 + 4);
    paramm.d(1);
    e(paramm);
    paramm.d(2);
    paramInt = paramm.g();
    if ((paramInt & 0x80) != 0) {
      paramm.d(2);
    }
    if ((paramInt & 0x40) != 0) {
      paramm.d(paramm.h());
    }
    if ((paramInt & 0x20) != 0) {
      paramm.d(2);
    }
    paramm.d(1);
    e(paramm);
    paramInt = paramm.g();
    String str = null;
    if (paramInt != 32)
    {
      if (paramInt != 33)
      {
        if (paramInt != 35)
        {
          if (paramInt != 64)
          {
            if (paramInt != 107) {
              if ((paramInt != 96) && (paramInt != 97)) {
                if (paramInt != 165) {
                  if (paramInt == 166) {}
                }
              }
            }
            switch (paramInt)
            {
            default: 
              switch (paramInt)
              {
              default: 
                break;
              case 170: 
              case 171: 
                return Pair.create("audio/vnd.dts.hd", null);
              case 169: 
              case 172: 
                return Pair.create("audio/vnd.dts", null);
                str = "audio/eac3";
                break;
                str = "audio/ac3";
                break;
                str = "video/mpeg2";
                break;
                return Pair.create("audio/mpeg", null);
              }
              break;
            }
          }
          else
          {
            str = "audio/mp4a-latm";
          }
        }
        else {
          str = "video/hevc";
        }
      }
      else {
        str = "video/avc";
      }
    }
    else {
      str = "video/mp4v-es";
    }
    paramm.d(12);
    paramm.d(1);
    paramInt = e(paramm);
    byte[] arrayOfByte = new byte[paramInt];
    paramm.a(arrayOfByte, 0, paramInt);
    return Pair.create(str, arrayOfByte);
  }
  
  private static byte[] d(com.tencent.luggage.wxa.ao.m paramm, int paramInt1, int paramInt2)
  {
    int i = paramInt1 + 8;
    while (i - paramInt1 < paramInt2)
    {
      paramm.c(i);
      int j = paramm.n();
      if (paramm.n() == a.aJ) {
        return Arrays.copyOfRange(paramm.a, i, j + i);
      }
      i += j;
    }
    return null;
  }
  
  private static int e(com.tencent.luggage.wxa.ao.m paramm)
  {
    int j = paramm.g();
    for (int i = j & 0x7F; (j & 0x80) == 128; i = i << 7 | j & 0x7F) {
      j = paramm.g();
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.p.b
 * JD-Core Version:    0.7.0.1
 */