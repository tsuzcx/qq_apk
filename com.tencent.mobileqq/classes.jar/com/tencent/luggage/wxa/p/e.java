package com.tencent.luggage.wxa.p;

import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.ao.u;
import com.tencent.luggage.wxa.ao.x;
import com.tencent.luggage.wxa.h.p;
import com.tencent.luggage.wxa.l.d;
import com.tencent.luggage.wxa.l.f;
import com.tencent.luggage.wxa.l.g;
import com.tencent.luggage.wxa.l.k.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.UUID;

public final class e
  implements d
{
  public static final g a = new e.1();
  private static final int b = x.f("seig");
  private static final byte[] c = { -94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12 };
  private int A;
  private int B;
  private int C;
  private boolean D;
  private f E;
  private com.tencent.luggage.wxa.l.l F;
  private com.tencent.luggage.wxa.l.l[] G;
  private boolean H;
  private final int d;
  private final j e;
  private final SparseArray<e.b> f;
  private final m g;
  private final m h;
  private final m i;
  private final m j;
  private final m k;
  private final u l;
  private final m m;
  private final byte[] n;
  private final Stack<a.a> o;
  private final LinkedList<e.a> p;
  private int q;
  private int r;
  private long s;
  private int t;
  private m u;
  private long v;
  private int w;
  private long x;
  private long y;
  private e.b z;
  
  public e()
  {
    this(0);
  }
  
  public e(int paramInt)
  {
    this(paramInt, null);
  }
  
  public e(int paramInt, u paramu)
  {
    this(paramInt, paramu, null);
  }
  
  public e(int paramInt, u paramu, j paramj)
  {
    int i1;
    if (paramj != null) {
      i1 = 16;
    } else {
      i1 = 0;
    }
    this.d = (paramInt | i1);
    this.l = paramu;
    this.e = paramj;
    this.m = new m(16);
    this.g = new m(com.tencent.luggage.wxa.ao.k.a);
    this.h = new m(5);
    this.i = new m();
    this.j = new m(1);
    this.k = new m();
    this.n = new byte[16];
    this.o = new Stack();
    this.p = new LinkedList();
    this.f = new SparseArray();
    this.x = -9223372036854775807L;
    this.y = -9223372036854775807L;
    a();
  }
  
  private int a(e.b paramb)
  {
    l locall = paramb.a;
    int i1 = locall.a.a;
    if (locall.o != null) {
      localObject1 = locall.o;
    } else {
      localObject1 = paramb.c.a(i1);
    }
    if (((k)localObject1).d != 0)
    {
      localObject2 = locall.q;
      i1 = ((k)localObject1).d;
      localObject1 = localObject2;
    }
    else
    {
      localObject2 = ((k)localObject1).e;
      this.k.a((byte[])localObject2, localObject2.length);
      localObject1 = this.k;
      i1 = localObject2.length;
    }
    int i3 = locall.n[paramb.e];
    Object localObject2 = this.j.a;
    if (i3 != 0) {
      i2 = 128;
    } else {
      i2 = 0;
    }
    localObject2[0] = ((byte)(i2 | i1));
    this.j.c(0);
    paramb = paramb.b;
    paramb.a(this.j, 1);
    paramb.a((m)localObject1, i1);
    if (i3 == 0) {
      return i1 + 1;
    }
    Object localObject1 = locall.q;
    int i2 = ((m)localObject1).h();
    ((m)localObject1).d(-2);
    i2 = i2 * 6 + 2;
    paramb.a((m)localObject1, i2);
    return i1 + 1 + i2;
  }
  
  private static int a(e.b paramb, int paramInt1, long paramLong, int paramInt2, m paramm, int paramInt3)
  {
    paramm.c(8);
    int i5 = a.b(paramm.n());
    j localj = paramb.c;
    paramb = paramb.a;
    c localc = paramb.a;
    paramb.h[paramInt1] = paramm.t();
    paramb.g[paramInt1] = paramb.c;
    if ((i5 & 0x1) != 0)
    {
      localObject = paramb.g;
      localObject[paramInt1] += paramm.n();
    }
    int i2;
    if ((i5 & 0x4) != 0) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    int i1 = localc.d;
    if (i2 != 0) {
      i1 = paramm.t();
    }
    int i3;
    if ((i5 & 0x100) != 0) {
      i3 = 1;
    } else {
      i3 = 0;
    }
    int i4;
    if ((i5 & 0x200) != 0) {
      i4 = 1;
    } else {
      i4 = 0;
    }
    int i6;
    if ((i5 & 0x400) != 0) {
      i6 = 1;
    } else {
      i6 = 0;
    }
    if ((i5 & 0x800) != 0) {
      i5 = 1;
    } else {
      i5 = 0;
    }
    Object localObject = localj.h;
    long l2 = 0L;
    long l1 = l2;
    if (localObject != null)
    {
      l1 = l2;
      if (localj.h.length == 1)
      {
        l1 = l2;
        if (localj.h[0] == 0L) {
          l1 = x.b(localj.i[0], 1000L, localj.c);
        }
      }
    }
    localObject = paramb.i;
    int[] arrayOfInt = paramb.j;
    long[] arrayOfLong = paramb.k;
    boolean[] arrayOfBoolean = paramb.l;
    if ((localj.b == 2) && ((paramInt2 & 0x1) != 0)) {
      paramInt2 = 1;
    } else {
      paramInt2 = 0;
    }
    int i8 = paramInt3 + paramb.h[paramInt1];
    l2 = localj.c;
    if (paramInt1 > 0) {
      paramLong = paramb.s;
    }
    int i7 = paramInt3;
    paramInt3 = i8;
    while (i7 < paramInt3)
    {
      if (i3 != 0) {
        i8 = paramm.t();
      } else {
        i8 = localc.b;
      }
      int i9;
      if (i4 != 0) {
        i9 = paramm.t();
      } else {
        i9 = localc.c;
      }
      if ((i7 == 0) && (i2 != 0)) {
        paramInt1 = i1;
      } else if (i6 != 0) {
        paramInt1 = paramm.n();
      } else {
        paramInt1 = localc.d;
      }
      if (i5 != 0) {
        arrayOfInt[i7] = ((int)(paramm.n() * 1000L / l2));
      } else {
        arrayOfInt[i7] = 0;
      }
      arrayOfLong[i7] = (x.b(paramLong, 1000L, l2) - l1);
      localObject[i7] = i9;
      int i10;
      if (((paramInt1 >> 16 & 0x1) == 0) && ((paramInt2 == 0) || (i7 == 0))) {
        i10 = 1;
      } else {
        i10 = 0;
      }
      arrayOfBoolean[i7] = i10;
      long l3 = i8;
      i7 += 1;
      paramLong += l3;
    }
    paramb.s = paramLong;
    return paramInt3;
  }
  
  private static Pair<Long, com.tencent.luggage.wxa.l.a> a(m paramm, long paramLong)
  {
    paramm.c(8);
    int i1 = a.a(paramm.n());
    paramm.d(4);
    long l4 = paramm.l();
    if (i1 == 0)
    {
      l1 = paramm.l();
      l2 = paramm.l();
    }
    else
    {
      l1 = paramm.v();
      l2 = paramm.v();
    }
    paramLong += l2;
    long l3 = x.b(l1, 1000000L, l4);
    paramm.d(2);
    i1 = paramm.h();
    int[] arrayOfInt = new int[i1];
    long[] arrayOfLong1 = new long[i1];
    long[] arrayOfLong2 = new long[i1];
    long[] arrayOfLong3 = new long[i1];
    long l2 = l1;
    long l1 = l3;
    int i2 = 0;
    while (i2 < i1)
    {
      int i3 = paramm.n();
      if ((i3 & 0x80000000) == 0)
      {
        long l5 = paramm.l();
        arrayOfInt[i2] = (i3 & 0x7FFFFFFF);
        arrayOfLong1[i2] = paramLong;
        arrayOfLong3[i2] = l1;
        l2 += l5;
        l1 = x.b(l2, 1000000L, l4);
        arrayOfLong2[i2] = (l1 - arrayOfLong3[i2]);
        paramm.d(4);
        paramLong += arrayOfInt[i2];
        i2 += 1;
      }
      else
      {
        throw new p("Unhandled indirect reference");
      }
    }
    return Pair.create(Long.valueOf(l3), new com.tencent.luggage.wxa.l.a(arrayOfInt, arrayOfLong1, arrayOfLong2, arrayOfLong3));
  }
  
  private static com.tencent.luggage.wxa.k.a a(List<a.b> paramList)
  {
    int i2 = paramList.size();
    int i1 = 0;
    Object localObject1;
    for (Object localObject2 = null; i1 < i2; localObject2 = localObject1)
    {
      Object localObject3 = (a.b)paramList.get(i1);
      localObject1 = localObject2;
      if (((a.b)localObject3).aP == a.U)
      {
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new ArrayList();
        }
        localObject2 = ((a.b)localObject3).aQ.a;
        localObject3 = h.a((byte[])localObject2);
        if (localObject3 == null) {
          Log.w("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
        } else {
          ((ArrayList)localObject1).add(new com.tencent.luggage.wxa.k.a.a((UUID)localObject3, null, "video/mp4", (byte[])localObject2));
        }
      }
      i1 += 1;
    }
    if (localObject2 == null) {
      return null;
    }
    return new com.tencent.luggage.wxa.k.a((List)localObject2);
  }
  
  private static e.b a(SparseArray<e.b> paramSparseArray)
  {
    int i2 = paramSparseArray.size();
    Object localObject = null;
    long l1 = 9223372036854775807L;
    int i1 = 0;
    while (i1 < i2)
    {
      e.b localb = (e.b)paramSparseArray.valueAt(i1);
      long l2;
      if (localb.g == localb.a.e)
      {
        l2 = l1;
      }
      else
      {
        long l3 = localb.a.g[localb.g];
        l2 = l1;
        if (l3 < l1)
        {
          localObject = localb;
          l2 = l3;
        }
      }
      i1 += 1;
      l1 = l2;
    }
    return localObject;
  }
  
  private static e.b a(m paramm, SparseArray<e.b> paramSparseArray, int paramInt)
  {
    paramm.c(8);
    int i3 = a.b(paramm.n());
    int i1 = paramm.n();
    if ((paramInt & 0x10) == 0) {
      paramInt = i1;
    } else {
      paramInt = 0;
    }
    paramSparseArray = (e.b)paramSparseArray.get(paramInt);
    if (paramSparseArray == null) {
      return null;
    }
    if ((i3 & 0x1) != 0)
    {
      long l1 = paramm.v();
      paramSparseArray.a.c = l1;
      paramSparseArray.a.d = l1;
    }
    c localc = paramSparseArray.d;
    if ((i3 & 0x2) != 0) {
      paramInt = paramm.t() - 1;
    } else {
      paramInt = localc.a;
    }
    if ((i3 & 0x8) != 0) {
      i1 = paramm.t();
    } else {
      i1 = localc.b;
    }
    int i2;
    if ((i3 & 0x10) != 0) {
      i2 = paramm.t();
    } else {
      i2 = localc.c;
    }
    if ((i3 & 0x20) != 0) {
      i3 = paramm.t();
    } else {
      i3 = localc.d;
    }
    paramSparseArray.a.a = new c(paramInt, i1, i2, i3);
    return paramSparseArray;
  }
  
  private void a()
  {
    this.q = 0;
    this.t = 0;
  }
  
  private void a(long paramLong)
  {
    while ((!this.o.isEmpty()) && (((a.a)this.o.peek()).aQ == paramLong)) {
      a((a.a)this.o.pop());
    }
    a();
  }
  
  private void a(m paramm)
  {
    if (this.F == null) {
      return;
    }
    paramm.c(12);
    paramm.x();
    paramm.x();
    long l1 = paramm.l();
    l1 = x.b(paramm.l(), 1000000L, l1);
    paramm.c(12);
    int i1 = paramm.b();
    this.F.a(paramm, i1);
    long l2 = this.y;
    if (l2 != -9223372036854775807L)
    {
      this.F.a(l1 + l2, 1, i1, 0, null);
      return;
    }
    this.p.addLast(new e.a(l1, i1));
    this.w += i1;
  }
  
  private static void a(m paramm, int paramInt, l paraml)
  {
    paramm.c(paramInt + 8);
    paramInt = a.b(paramm.n());
    if ((paramInt & 0x1) == 0)
    {
      boolean bool;
      if ((paramInt & 0x2) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      paramInt = paramm.t();
      if (paramInt == paraml.f)
      {
        Arrays.fill(paraml.n, 0, paramInt, bool);
        paraml.a(paramm.b());
        paraml.a(paramm);
        return;
      }
      paramm = new StringBuilder();
      paramm.append("Length mismatch: ");
      paramm.append(paramInt);
      paramm.append(", ");
      paramm.append(paraml.f);
      throw new p(paramm.toString());
    }
    throw new p("Overriding TrackEncryptionBox parameters is unsupported.");
  }
  
  private static void a(m paramm1, m paramm2, String paramString, l paraml)
  {
    paramm1.c(8);
    int i1 = paramm1.n();
    if (paramm1.n() != b) {
      return;
    }
    if (a.a(i1) == 1) {
      paramm1.d(4);
    }
    if (paramm1.n() == 1)
    {
      paramm2.c(8);
      i1 = paramm2.n();
      if (paramm2.n() != b) {
        return;
      }
      i1 = a.a(i1);
      if (i1 == 1)
      {
        if (paramm2.l() == 0L) {
          throw new p("Variable length description in sgpd found (unsupported)");
        }
      }
      else if (i1 >= 2) {
        paramm2.d(4);
      }
      if (paramm2.l() == 1L)
      {
        paramm2.d(1);
        i1 = paramm2.g();
        boolean bool;
        if (paramm2.g() == 1) {
          bool = true;
        } else {
          bool = false;
        }
        if (!bool) {
          return;
        }
        int i2 = paramm2.g();
        byte[] arrayOfByte = new byte[16];
        paramm2.a(arrayOfByte, 0, arrayOfByte.length);
        if ((bool) && (i2 == 0))
        {
          int i3 = paramm2.g();
          paramm1 = new byte[i3];
          paramm2.a(paramm1, 0, i3);
        }
        else
        {
          paramm1 = null;
        }
        paraml.m = true;
        paraml.o = new k(bool, paramString, i2, arrayOfByte, (i1 & 0xF0) >> 4, i1 & 0xF, paramm1);
        return;
      }
      throw new p("Entry count in sgpd != 1 (unsupported).");
    }
    throw new p("Entry count in sbgp != 1 (unsupported).");
  }
  
  private static void a(m paramm, l paraml)
  {
    paramm.c(8);
    int i1 = paramm.n();
    if ((a.b(i1) & 0x1) == 1) {
      paramm.d(8);
    }
    int i2 = paramm.t();
    if (i2 == 1)
    {
      i1 = a.a(i1);
      long l2 = paraml.d;
      long l1;
      if (i1 == 0) {
        l1 = paramm.l();
      } else {
        l1 = paramm.v();
      }
      paraml.d = (l2 + l1);
      return;
    }
    paramm = new StringBuilder();
    paramm.append("Unexpected saio entry count: ");
    paramm.append(i2);
    throw new p(paramm.toString());
  }
  
  private static void a(m paramm, l paraml, byte[] paramArrayOfByte)
  {
    paramm.c(8);
    paramm.a(paramArrayOfByte, 0, 16);
    if (!Arrays.equals(paramArrayOfByte, c)) {
      return;
    }
    a(paramm, 16, paraml);
  }
  
  private void a(a.a parama)
  {
    if (parama.aP == a.B)
    {
      b(parama);
      return;
    }
    if (parama.aP == a.K)
    {
      c(parama);
      return;
    }
    if (!this.o.isEmpty()) {
      ((a.a)this.o.peek()).a(parama);
    }
  }
  
  private static void a(a.a parama, SparseArray<e.b> paramSparseArray, int paramInt, byte[] paramArrayOfByte)
  {
    int i2 = parama.aS.size();
    int i1 = 0;
    while (i1 < i2)
    {
      a.a locala = (a.a)parama.aS.get(i1);
      if (locala.aP == a.L) {
        b(locala, paramSparseArray, paramInt, paramArrayOfByte);
      }
      i1 += 1;
    }
  }
  
  private static void a(a.a parama, e.b paramb, long paramLong, int paramInt)
  {
    parama = parama.aR;
    int i7 = parama.size();
    int i6 = 0;
    int i1 = 0;
    int i2 = 0;
    Object localObject;
    int i5;
    int i4;
    for (int i3 = 0; i1 < i7; i3 = i4)
    {
      localObject = (a.b)parama.get(i1);
      i5 = i2;
      i4 = i3;
      if (((a.b)localObject).aP == a.z)
      {
        localObject = ((a.b)localObject).aQ;
        ((m)localObject).c(12);
        int i8 = ((m)localObject).t();
        i5 = i2;
        i4 = i3;
        if (i8 > 0)
        {
          i4 = i3 + i8;
          i5 = i2 + 1;
        }
      }
      i1 += 1;
      i2 = i5;
    }
    paramb.g = 0;
    paramb.f = 0;
    paramb.e = 0;
    paramb.a.a(i2, i3);
    i2 = 0;
    i3 = 0;
    i1 = i6;
    while (i1 < i7)
    {
      localObject = (a.b)parama.get(i1);
      i5 = i2;
      i4 = i3;
      if (((a.b)localObject).aP == a.z)
      {
        i4 = a(paramb, i2, paramLong, paramInt, ((a.b)localObject).aQ, i3);
        i5 = i2 + 1;
      }
      i1 += 1;
      i2 = i5;
      i3 = i4;
    }
  }
  
  private void a(a.b paramb, long paramLong)
  {
    if (!this.o.isEmpty())
    {
      ((a.a)this.o.peek()).a(paramb);
      return;
    }
    if (paramb.aP == a.A)
    {
      paramb = a(paramb.aQ, paramLong);
      this.y = ((Long)paramb.first).longValue();
      this.E.a((com.tencent.luggage.wxa.l.k)paramb.second);
      this.H = true;
      return;
    }
    if (paramb.aP == a.aG) {
      a(paramb.aQ);
    }
  }
  
  private static void a(k paramk, m paramm, l paraml)
  {
    int i4 = paramk.d;
    paramm.c(8);
    int i1 = a.b(paramm.n());
    boolean bool = true;
    if ((i1 & 0x1) == 1) {
      paramm.d(8);
    }
    i1 = paramm.g();
    int i5 = paramm.t();
    if (i5 == paraml.f)
    {
      if (i1 == 0)
      {
        paramk = paraml.n;
        int i2 = 0;
        i1 = 0;
        for (;;)
        {
          i3 = i1;
          if (i2 >= i5) {
            break;
          }
          i3 = paramm.g();
          i1 += i3;
          if (i3 > i4) {
            bool = true;
          } else {
            bool = false;
          }
          paramk[i2] = bool;
          i2 += 1;
        }
      }
      if (i1 <= i4) {
        bool = false;
      }
      int i3 = i1 * i5 + 0;
      Arrays.fill(paraml.n, 0, i5, bool);
      paraml.a(i3);
      return;
    }
    paramk = new StringBuilder();
    paramk.append("Length mismatch: ");
    paramk.append(i5);
    paramk.append(", ");
    paramk.append(paraml.f);
    paramk = new p(paramk.toString());
    for (;;)
    {
      throw paramk;
    }
  }
  
  private static boolean a(int paramInt)
  {
    return (paramInt == a.S) || (paramInt == a.R) || (paramInt == a.C) || (paramInt == a.A) || (paramInt == a.T) || (paramInt == a.w) || (paramInt == a.x) || (paramInt == a.O) || (paramInt == a.y) || (paramInt == a.z) || (paramInt == a.U) || (paramInt == a.ac) || (paramInt == a.ad) || (paramInt == a.ah) || (paramInt == a.ag) || (paramInt == a.ae) || (paramInt == a.af) || (paramInt == a.Q) || (paramInt == a.N) || (paramInt == a.aG);
  }
  
  private static Pair<Integer, c> b(m paramm)
  {
    paramm.c(12);
    return Pair.create(Integer.valueOf(paramm.n()), new c(paramm.t() - 1, paramm.t(), paramm.t(), paramm.n()));
  }
  
  private void b()
  {
    if (((this.d & 0x4) != 0) && (this.F == null))
    {
      this.F = this.E.a(this.f.size(), 4);
      this.F.a(com.tencent.luggage.wxa.h.k.a(null, "application/x-emsg", 9223372036854775807L));
    }
    if (((this.d & 0x8) != 0) && (this.G == null))
    {
      com.tencent.luggage.wxa.l.l locall = this.E.a(this.f.size() + 1, 3);
      locall.a(com.tencent.luggage.wxa.h.k.a(null, "application/cea-608", 0, null));
      this.G = new com.tencent.luggage.wxa.l.l[] { locall };
    }
  }
  
  private static void b(m paramm, l paraml)
  {
    a(paramm, 0, paraml);
  }
  
  private void b(a.a parama)
  {
    Object localObject1 = this.e;
    boolean bool2 = true;
    int i4 = 0;
    int i3 = 0;
    boolean bool1;
    if (localObject1 == null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    com.tencent.luggage.wxa.ao.a.b(bool1, "Unexpected moov box.");
    Object localObject2 = a(parama.aR);
    Object localObject3 = parama.e(a.M);
    localObject1 = new SparseArray();
    int i2 = ((a.a)localObject3).aR.size();
    long l1 = -9223372036854775807L;
    int i1 = 0;
    Object localObject4;
    while (i1 < i2)
    {
      localObject4 = (a.b)((a.a)localObject3).aR.get(i1);
      if (((a.b)localObject4).aP == a.y)
      {
        localObject4 = b(((a.b)localObject4).aQ);
        ((SparseArray)localObject1).put(((Integer)((Pair)localObject4).first).intValue(), ((Pair)localObject4).second);
      }
      else if (((a.b)localObject4).aP == a.N)
      {
        l1 = c(((a.b)localObject4).aQ);
      }
      i1 += 1;
    }
    localObject3 = new SparseArray();
    i1 = parama.aS.size();
    i2 = 0;
    while (i2 < i1)
    {
      localObject4 = (a.a)parama.aS.get(i2);
      if (((a.a)localObject4).aP == a.D)
      {
        a.b localb = parama.d(a.C);
        if ((this.d & 0x20) != 0) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        localObject4 = b.a((a.a)localObject4, localb, l1, (com.tencent.luggage.wxa.k.a)localObject2, bool1, false);
        if (localObject4 != null) {
          ((SparseArray)localObject3).put(((j)localObject4).a, localObject4);
        }
      }
      i2 += 1;
    }
    i2 = ((SparseArray)localObject3).size();
    if (this.f.size() == 0)
    {
      i1 = i3;
      while (i1 < i2)
      {
        parama = (j)((SparseArray)localObject3).valueAt(i1);
        localObject2 = new e.b(this.E.a(i1, parama.b));
        ((e.b)localObject2).a(parama, (c)((SparseArray)localObject1).get(parama.a));
        this.f.put(parama.a, localObject2);
        this.x = Math.max(this.x, parama.e);
        i1 += 1;
      }
      b();
      this.E.a();
      return;
    }
    if (this.f.size() == i2) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    com.tencent.luggage.wxa.ao.a.b(bool1);
    i1 = i4;
    while (i1 < i2)
    {
      parama = (j)((SparseArray)localObject3).valueAt(i1);
      ((e.b)this.f.get(parama.a)).a(parama, (c)((SparseArray)localObject1).get(parama.a));
      i1 += 1;
    }
  }
  
  private static void b(a.a parama, SparseArray<e.b> paramSparseArray, int paramInt, byte[] paramArrayOfByte)
  {
    paramSparseArray = a(parama.d(a.x).aQ, paramSparseArray, paramInt);
    if (paramSparseArray == null) {
      return;
    }
    l locall = paramSparseArray.a;
    long l2 = locall.s;
    paramSparseArray.a();
    long l1 = l2;
    if (parama.d(a.w) != null)
    {
      l1 = l2;
      if ((paramInt & 0x2) == 0) {
        l1 = d(parama.d(a.w).aQ);
      }
    }
    a(parama, paramSparseArray, l1, paramInt);
    paramSparseArray = paramSparseArray.c.a(locall.a.a);
    Object localObject1 = parama.d(a.ac);
    if (localObject1 != null) {
      a(paramSparseArray, ((a.b)localObject1).aQ, locall);
    }
    localObject1 = parama.d(a.ad);
    if (localObject1 != null) {
      a(((a.b)localObject1).aQ, locall);
    }
    localObject1 = parama.d(a.ah);
    if (localObject1 != null) {
      b(((a.b)localObject1).aQ, locall);
    }
    localObject1 = parama.d(a.ae);
    Object localObject2 = parama.d(a.af);
    if ((localObject1 != null) && (localObject2 != null))
    {
      localObject1 = ((a.b)localObject1).aQ;
      localObject2 = ((a.b)localObject2).aQ;
      if (paramSparseArray != null) {
        paramSparseArray = paramSparseArray.b;
      } else {
        paramSparseArray = null;
      }
      a((m)localObject1, (m)localObject2, paramSparseArray, locall);
    }
    int i1 = parama.aR.size();
    paramInt = 0;
    while (paramInt < i1)
    {
      paramSparseArray = (a.b)parama.aR.get(paramInt);
      if (paramSparseArray.aP == a.ag) {
        a(paramSparseArray.aQ, locall, paramArrayOfByte);
      }
      paramInt += 1;
    }
  }
  
  private static boolean b(int paramInt)
  {
    return (paramInt == a.B) || (paramInt == a.D) || (paramInt == a.E) || (paramInt == a.F) || (paramInt == a.G) || (paramInt == a.K) || (paramInt == a.L) || (paramInt == a.M) || (paramInt == a.P);
  }
  
  private boolean b(com.tencent.luggage.wxa.l.e parame)
  {
    if (this.t == 0)
    {
      if (!parame.a(this.m.a, 0, 8, true)) {
        return false;
      }
      this.t = 8;
      this.m.c(0);
      this.s = this.m.l();
      this.r = this.m.n();
    }
    long l1 = this.s;
    if (l1 == 1L)
    {
      parame.b(this.m.a, 8, 8);
      this.t += 8;
      this.s = this.m.v();
    }
    else if (l1 == 0L)
    {
      long l2 = parame.d();
      l1 = l2;
      if (l2 == -1L)
      {
        l1 = l2;
        if (!this.o.isEmpty()) {
          l1 = ((a.a)this.o.peek()).aQ;
        }
      }
      if (l1 != -1L) {
        this.s = (l1 - parame.c() + this.t);
      }
    }
    if (this.s >= this.t)
    {
      l1 = parame.c() - this.t;
      if (this.r == a.K)
      {
        int i2 = this.f.size();
        int i1 = 0;
        while (i1 < i2)
        {
          l locall = ((e.b)this.f.valueAt(i1)).a;
          locall.b = l1;
          locall.d = l1;
          locall.c = l1;
          i1 += 1;
        }
      }
      if (this.r == a.h)
      {
        this.z = null;
        this.v = (l1 + this.s);
        if (!this.H)
        {
          this.E.a(new k.a(this.x));
          this.H = true;
        }
        this.q = 2;
        return true;
      }
      if (b(this.r))
      {
        l1 = parame.c() + this.s - 8L;
        this.o.add(new a.a(this.r, l1));
        if (this.s == this.t)
        {
          a(l1);
          return true;
        }
        a();
        return true;
      }
      if (a(this.r))
      {
        if (this.t == 8)
        {
          l1 = this.s;
          if (l1 <= 2147483647L)
          {
            this.u = new m((int)l1);
            System.arraycopy(this.m.a, 0, this.u.a, 0, 8);
            this.q = 1;
            return true;
          }
          throw new p("Leaf atom with length > 2147483647 (unsupported).");
        }
        throw new p("Leaf atom defines extended atom size (unsupported).");
      }
      if (this.s <= 2147483647L)
      {
        this.u = null;
        this.q = 1;
        return true;
      }
      throw new p("Skipping atom with length > 2147483647 (unsupported).");
    }
    parame = new p("Atom size less than header length (unsupported).");
    for (;;)
    {
      throw parame;
    }
  }
  
  private static long c(m paramm)
  {
    paramm.c(8);
    if (a.a(paramm.n()) == 0) {
      return paramm.l();
    }
    return paramm.v();
  }
  
  private void c(com.tencent.luggage.wxa.l.e parame)
  {
    int i1 = (int)this.s - this.t;
    m localm = this.u;
    if (localm != null)
    {
      parame.b(localm.a, 8, i1);
      a(new a.b(this.r, this.u), parame.c());
    }
    else
    {
      parame.b(i1);
    }
    a(parame.c());
  }
  
  private void c(a.a parama)
  {
    a(parama, this.f, this.d, this.n);
    parama = a(parama.aR);
    if (parama != null)
    {
      int i2 = this.f.size();
      int i1 = 0;
      while (i1 < i2)
      {
        ((e.b)this.f.valueAt(i1)).a(parama);
        i1 += 1;
      }
    }
  }
  
  private static long d(m paramm)
  {
    paramm.c(8);
    if (a.a(paramm.n()) == 1) {
      return paramm.v();
    }
    return paramm.l();
  }
  
  private void d(com.tencent.luggage.wxa.l.e parame)
  {
    int i2 = this.f.size();
    Object localObject1 = null;
    long l1 = 9223372036854775807L;
    int i1 = 0;
    while (i1 < i2)
    {
      l locall = ((e.b)this.f.valueAt(i1)).a;
      Object localObject2 = localObject1;
      long l2 = l1;
      if (locall.r)
      {
        localObject2 = localObject1;
        l2 = l1;
        if (locall.d < l1)
        {
          l2 = locall.d;
          localObject2 = (e.b)this.f.valueAt(i1);
        }
      }
      i1 += 1;
      localObject1 = localObject2;
      l1 = l2;
    }
    if (localObject1 == null)
    {
      this.q = 3;
      return;
    }
    i1 = (int)(l1 - parame.c());
    if (i1 >= 0)
    {
      parame.b(i1);
      localObject1.a.a(parame);
      return;
    }
    parame = new p("Offset to encryption data was negative.");
    for (;;)
    {
      throw parame;
    }
  }
  
  private boolean e(com.tencent.luggage.wxa.l.e parame)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public int a(com.tencent.luggage.wxa.l.e parame, com.tencent.luggage.wxa.l.j paramj)
  {
    do
    {
      for (;;)
      {
        int i1 = this.q;
        if (i1 == 0) {
          break;
        }
        if (i1 != 1)
        {
          if (i1 != 2)
          {
            if (e(parame)) {
              return 0;
            }
          }
          else {
            d(parame);
          }
        }
        else {
          c(parame);
        }
      }
    } while (b(parame));
    return -1;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    int i2 = this.f.size();
    int i1 = 0;
    while (i1 < i2)
    {
      ((e.b)this.f.valueAt(i1)).a();
      i1 += 1;
    }
    this.p.clear();
    this.w = 0;
    this.o.clear();
    a();
  }
  
  public void a(f paramf)
  {
    this.E = paramf;
    j localj = this.e;
    if (localj != null)
    {
      paramf = new e.b(paramf.a(0, localj.b));
      paramf.a(this.e, new c(0, 0, 0, 0));
      this.f.put(0, paramf);
      b();
      this.E.a();
    }
  }
  
  public boolean a(com.tencent.luggage.wxa.l.e parame)
  {
    return i.a(parame);
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.p.e
 * JD-Core Version:    0.7.0.1
 */