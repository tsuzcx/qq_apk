package com.tencent.luggage.wxa.n;

import android.util.SparseArray;
import com.tencent.luggage.wxa.ao.h;
import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.ao.x;
import com.tencent.luggage.wxa.h.p;
import com.tencent.luggage.wxa.k.a.a;
import com.tencent.luggage.wxa.l.g;
import com.tencent.luggage.wxa.l.j;
import com.tencent.luggage.wxa.l.k.a;
import com.tencent.luggage.wxa.l.l;
import com.tencent.luggage.wxa.l.l.a;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;

public final class d
  implements com.tencent.luggage.wxa.l.d
{
  public static final g a = new d.1();
  private static final byte[] b = { 49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10 };
  private static final byte[] c = { 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
  private static long d = 1000L;
  private static final byte[] e = x.c("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
  private static final byte[] f = { 68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44 };
  private static long g = 10000L;
  private static final byte[] h = { 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
  private static final UUID i = new UUID(72057594037932032L, -9223371306706625679L);
  private long A = -9223372036854775807L;
  private long B = -9223372036854775807L;
  private d.b C;
  private boolean D;
  private int E;
  private long F;
  private boolean G;
  private long H = -1L;
  private long I = -1L;
  private long J = -9223372036854775807L;
  private h K;
  private h L;
  private boolean M;
  private int N;
  private long O;
  private long P;
  private int Q;
  private int R;
  private int[] S;
  private int T;
  private int U;
  private int V;
  private int W;
  private boolean X;
  private boolean Y;
  private boolean Z;
  private boolean aa;
  private byte ab;
  private int ac;
  private int ad;
  private int ae;
  private boolean af;
  private boolean ag;
  private com.tencent.luggage.wxa.l.f ah;
  private final b j;
  private final f k;
  private final SparseArray<d.b> l;
  private final boolean m;
  private final m n;
  private final m o;
  private final m p;
  private final m q;
  private final m r;
  private final m s;
  private final m t;
  private final m u;
  private final m v;
  private ByteBuffer w;
  private long x;
  private long y = -1L;
  private long z = -9223372036854775807L;
  
  public d()
  {
    this(0);
  }
  
  public d(int paramInt)
  {
    this(new a(), paramInt);
  }
  
  d(b paramb, int paramInt)
  {
    this.j = paramb;
    this.j.a(new d.a(this, null));
    boolean bool = true;
    if ((paramInt & 0x1) != 0) {
      bool = false;
    }
    this.m = bool;
    this.k = new f();
    this.l = new SparseArray();
    this.p = new m(4);
    this.q = new m(ByteBuffer.allocate(4).putInt(-1).array());
    this.r = new m(4);
    this.n = new m(com.tencent.luggage.wxa.ao.k.a);
    this.o = new m(4);
    this.s = new m();
    this.t = new m();
    this.u = new m(8);
    this.v = new m();
  }
  
  private int a(com.tencent.luggage.wxa.l.e parame, l paraml, int paramInt)
  {
    int i1 = this.s.b();
    if (i1 > 0)
    {
      paramInt = Math.min(paramInt, i1);
      paraml.a(this.s, paramInt);
    }
    else
    {
      paramInt = paraml.a(parame, paramInt, false);
    }
    this.W += paramInt;
    this.ae += paramInt;
    return paramInt;
  }
  
  private long a(long paramLong)
  {
    long l1 = this.z;
    if (l1 != -9223372036854775807L) {
      return x.b(paramLong, l1, 1000L);
    }
    throw new p("Can't scale timecode prior to timecodeScale being set.");
  }
  
  private void a(com.tencent.luggage.wxa.l.e parame, int paramInt)
  {
    if (this.p.c() >= paramInt) {
      return;
    }
    if (this.p.e() < paramInt)
    {
      m localm = this.p;
      localm.a(Arrays.copyOf(localm.a, Math.max(this.p.a.length * 2, paramInt)), this.p.c());
    }
    parame.b(this.p.a, this.p.c(), paramInt - this.p.c());
    this.p.b(paramInt);
  }
  
  private void a(com.tencent.luggage.wxa.l.e parame, d.b paramb, int paramInt)
  {
    if ("S_TEXT/UTF8".equals(paramb.a))
    {
      a(parame, b, paramInt);
      return;
    }
    if ("S_TEXT/ASS".equals(paramb.a))
    {
      a(parame, f, paramInt);
      return;
    }
    l locall = paramb.N;
    int i3;
    if (!this.X)
    {
      if (paramb.e)
      {
        this.V &= 0xBFFFFFFF;
        boolean bool = this.Y;
        i2 = 128;
        if (!bool)
        {
          parame.b(this.p.a, 0, 1);
          this.W += 1;
          if ((this.p.a[0] & 0x80) != 128)
          {
            this.ab = this.p.a[0];
            this.Y = true;
          }
          else
          {
            throw new p("Extension bit is set in signal byte");
          }
        }
        if ((this.ab & 0x1) == 1) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        if (i1 != 0)
        {
          if ((this.ab & 0x2) == 2) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          this.V |= 0x40000000;
          if (!this.Z)
          {
            parame.b(this.u.a, 0, 8);
            this.W += 8;
            this.Z = true;
            localObject = this.p.a;
            if (i1 == 0) {
              i2 = 0;
            }
            localObject[0] = ((byte)(i2 | 0x8));
            this.p.c(0);
            locall.a(this.p, 1);
            this.ae += 1;
            this.u.c(0);
            locall.a(this.u, 8);
            this.ae += 8;
          }
          if (i1 != 0)
          {
            if (!this.aa)
            {
              parame.b(this.p.a, 0, 1);
              this.W += 1;
              this.p.c(0);
              this.ac = this.p.g();
              this.aa = true;
            }
            i1 = this.ac * 4;
            this.p.a(i1);
            parame.b(this.p.a, 0, i1);
            this.W += i1;
            short s1 = (short)(this.ac / 2 + 1);
            int i4 = s1 * 6 + 2;
            localObject = this.w;
            if ((localObject == null) || (((ByteBuffer)localObject).capacity() < i4)) {
              this.w = ByteBuffer.allocate(i4);
            }
            this.w.position(0);
            this.w.putShort(s1);
            i1 = 0;
            for (i2 = 0;; i2 = i3)
            {
              i3 = this.ac;
              if (i1 >= i3) {
                break;
              }
              i3 = this.p.t();
              if (i1 % 2 == 0) {
                this.w.putShort((short)(i3 - i2));
              } else {
                this.w.putInt(i3 - i2);
              }
              i1 += 1;
            }
            i1 = paramInt - this.W - i2;
            if (i3 % 2 == 1)
            {
              this.w.putInt(i1);
            }
            else
            {
              this.w.putShort((short)i1);
              this.w.putInt(0);
            }
            this.v.a(this.w.array(), i4);
            locall.a(this.v, i4);
            this.ae += i4;
          }
        }
      }
      else if (paramb.f != null)
      {
        this.s.a(paramb.f, paramb.f.length);
      }
      this.X = true;
    }
    paramInt += this.s.c();
    if ((!"V_MPEG4/ISO/AVC".equals(paramb.a)) && (!"V_MPEGH/ISO/HEVC".equals(paramb.a))) {
      for (;;)
      {
        i1 = this.W;
        if (i1 >= paramInt) {
          break;
        }
        a(parame, locall, paramInt - i1);
      }
    }
    Object localObject = this.o.a;
    localObject[0] = 0;
    localObject[1] = 0;
    localObject[2] = 0;
    int i1 = paramb.O;
    int i2 = paramb.O;
    while (this.W < paramInt)
    {
      i3 = this.ad;
      if (i3 == 0)
      {
        a(parame, (byte[])localObject, 4 - i2, i1);
        this.o.c(0);
        this.ad = this.o.t();
        this.n.c(0);
        locall.a(this.n, 4);
        this.ae += 4;
      }
      else
      {
        this.ad = (i3 - a(parame, locall, i3));
      }
    }
    if ("A_VORBIS".equals(paramb.a))
    {
      this.q.c(0);
      locall.a(this.q, 4);
      this.ae += 4;
    }
  }
  
  private void a(com.tencent.luggage.wxa.l.e parame, byte[] paramArrayOfByte, int paramInt)
  {
    int i1 = paramArrayOfByte.length + paramInt;
    if (this.t.e() < i1) {
      this.t.a = Arrays.copyOf(paramArrayOfByte, i1 + paramInt);
    } else {
      System.arraycopy(paramArrayOfByte, 0, this.t.a, 0, paramArrayOfByte.length);
    }
    parame.b(this.t.a, paramArrayOfByte.length, paramInt);
    this.t.a(i1);
  }
  
  private void a(com.tencent.luggage.wxa.l.e parame, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i1 = Math.min(paramInt2, this.s.b());
    parame.b(paramArrayOfByte, paramInt1 + i1, paramInt2 - i1);
    if (i1 > 0) {
      this.s.a(paramArrayOfByte, paramInt1, i1);
    }
    this.W += paramInt2;
  }
  
  private void a(d.b paramb, long paramLong)
  {
    if ("S_TEXT/UTF8".equals(paramb.a)) {
      a(paramb, "%02d:%02d:%02d,%03d", 19, d, c);
    } else if ("S_TEXT/ASS".equals(paramb.a)) {
      a(paramb, "%01d:%02d:%02d:%02d", 21, g, h);
    }
    paramb.N.a(paramLong, this.V, this.ae, 0, paramb.g);
    this.af = true;
    d();
  }
  
  private void a(d.b paramb, String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    a(this.t.a, this.P, paramString, paramInt, paramLong, paramArrayOfByte);
    paramb = paramb.N;
    paramString = this.t;
    paramb.a(paramString, paramString.c());
    this.ae += this.t.c();
  }
  
  private static void a(byte[] paramArrayOfByte1, long paramLong1, String paramString, int paramInt, long paramLong2, byte[] paramArrayOfByte2)
  {
    if (paramLong1 == -9223372036854775807L)
    {
      paramString = paramArrayOfByte2;
    }
    else
    {
      int i1 = (int)(paramLong1 / 3600000000L);
      paramLong1 -= i1 * 3600 * 1000000L;
      int i2 = (int)(paramLong1 / 60000000L);
      paramLong1 -= i2 * 60 * 1000000L;
      int i3 = (int)(paramLong1 / 1000000L);
      int i4 = (int)((paramLong1 - i3 * 1000000L) / paramLong2);
      paramString = x.c(String.format(Locale.US, paramString, new Object[] { Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4) }));
    }
    System.arraycopy(paramString, 0, paramArrayOfByte1, paramInt, paramArrayOfByte2.length);
  }
  
  private boolean a(j paramj, long paramLong)
  {
    if (this.G)
    {
      this.I = paramLong;
      paramj.a = this.H;
      this.G = false;
      return true;
    }
    if (this.D)
    {
      paramLong = this.I;
      if (paramLong != -1L)
      {
        paramj.a = paramLong;
        this.I = -1L;
        return true;
      }
    }
    return false;
  }
  
  private static boolean a(String paramString)
  {
    return ("V_VP8".equals(paramString)) || ("V_VP9".equals(paramString)) || ("V_MPEG2".equals(paramString)) || ("V_MPEG4/ISO/SP".equals(paramString)) || ("V_MPEG4/ISO/ASP".equals(paramString)) || ("V_MPEG4/ISO/AP".equals(paramString)) || ("V_MPEG4/ISO/AVC".equals(paramString)) || ("V_MPEGH/ISO/HEVC".equals(paramString)) || ("V_MS/VFW/FOURCC".equals(paramString)) || ("V_THEORA".equals(paramString)) || ("A_OPUS".equals(paramString)) || ("A_VORBIS".equals(paramString)) || ("A_AAC".equals(paramString)) || ("A_MPEG/L2".equals(paramString)) || ("A_MPEG/L3".equals(paramString)) || ("A_AC3".equals(paramString)) || ("A_EAC3".equals(paramString)) || ("A_TRUEHD".equals(paramString)) || ("A_DTS".equals(paramString)) || ("A_DTS/EXPRESS".equals(paramString)) || ("A_DTS/LOSSLESS".equals(paramString)) || ("A_FLAC".equals(paramString)) || ("A_MS/ACM".equals(paramString)) || ("A_PCM/INT/LIT".equals(paramString)) || ("S_TEXT/UTF8".equals(paramString)) || ("S_TEXT/ASS".equals(paramString)) || ("S_VOBSUB".equals(paramString)) || ("S_HDMV/PGS".equals(paramString)) || ("S_DVBSUB".equals(paramString));
  }
  
  private static int[] a(int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt == null) {
      return new int[paramInt];
    }
    if (paramArrayOfInt.length >= paramInt) {
      return paramArrayOfInt;
    }
    return new int[Math.max(paramArrayOfInt.length * 2, paramInt)];
  }
  
  private void d()
  {
    this.W = 0;
    this.ae = 0;
    this.ad = 0;
    this.X = false;
    this.Y = false;
    this.aa = false;
    this.ac = 0;
    this.ab = 0;
    this.Z = false;
    this.s.a();
  }
  
  private com.tencent.luggage.wxa.l.k e()
  {
    if ((this.y != -1L) && (this.B != -9223372036854775807L))
    {
      Object localObject = this.K;
      if ((localObject != null) && (((h)localObject).a() != 0))
      {
        localObject = this.L;
        if ((localObject != null) && (((h)localObject).a() == this.K.a()))
        {
          int i4 = this.K.a();
          localObject = new int[i4];
          long[] arrayOfLong1 = new long[i4];
          long[] arrayOfLong2 = new long[i4];
          long[] arrayOfLong3 = new long[i4];
          int i3 = 0;
          int i2 = 0;
          int i1;
          for (;;)
          {
            i1 = i3;
            if (i2 >= i4) {
              break;
            }
            arrayOfLong3[i2] = this.K.a(i2);
            arrayOfLong1[i2] = (this.y + this.L.a(i2));
            i2 += 1;
          }
          for (;;)
          {
            i2 = i4 - 1;
            if (i1 >= i2) {
              break;
            }
            i2 = i1 + 1;
            localObject[i1] = ((int)(arrayOfLong1[i2] - arrayOfLong1[i1]));
            arrayOfLong3[i2] -= arrayOfLong3[i1];
            i1 = i2;
          }
          localObject[i2] = ((int)(this.y + this.x - arrayOfLong1[i2]));
          arrayOfLong2[i2] = (this.B - arrayOfLong3[i2]);
          this.K = null;
          this.L = null;
          return new com.tencent.luggage.wxa.l.a((int[])localObject, arrayOfLong1, arrayOfLong2, arrayOfLong3);
        }
      }
    }
    this.K = null;
    this.L = null;
    return new k.a(this.B);
  }
  
  int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 181: 
    case 17545: 
    case 21969: 
    case 21970: 
    case 21971: 
    case 21972: 
    case 21973: 
    case 21974: 
    case 21975: 
    case 21976: 
    case 21977: 
    case 21978: 
      return 5;
    case 161: 
    case 163: 
    case 16981: 
    case 18402: 
    case 21419: 
    case 25506: 
    case 30322: 
      return 4;
    case 160: 
    case 174: 
    case 183: 
    case 187: 
    case 224: 
    case 225: 
    case 18407: 
    case 19899: 
    case 20532: 
    case 20533: 
    case 21936: 
    case 21968: 
    case 25152: 
    case 28032: 
    case 30320: 
    case 290298740: 
    case 357149030: 
    case 374648427: 
    case 408125543: 
    case 440786851: 
    case 475249515: 
    case 524531317: 
      return 1;
    case 134: 
    case 17026: 
    case 2274716: 
      return 3;
    }
    return 2;
  }
  
  public int a(com.tencent.luggage.wxa.l.e parame, j paramj)
  {
    this.af = false;
    int i1 = 1;
    while ((i1 != 0) && (!this.af))
    {
      boolean bool = this.j.a(parame);
      i1 = bool;
      if (bool)
      {
        i1 = bool;
        if (a(paramj, parame.c())) {
          return 1;
        }
      }
    }
    if (i1 != 0) {
      return 0;
    }
    return -1;
  }
  
  void a(int paramInt, double paramDouble)
  {
    if (paramInt != 181)
    {
      if (paramInt != 17545)
      {
        switch (paramInt)
        {
        default: 
          return;
        case 21978: 
          this.C.F = ((float)paramDouble);
          return;
        case 21977: 
          this.C.E = ((float)paramDouble);
          return;
        case 21976: 
          this.C.D = ((float)paramDouble);
          return;
        case 21975: 
          this.C.C = ((float)paramDouble);
          return;
        case 21974: 
          this.C.B = ((float)paramDouble);
          return;
        case 21973: 
          this.C.A = ((float)paramDouble);
          return;
        case 21972: 
          this.C.z = ((float)paramDouble);
          return;
        case 21971: 
          this.C.y = ((float)paramDouble);
          return;
        case 21970: 
          this.C.x = ((float)paramDouble);
          return;
        }
        this.C.w = ((float)paramDouble);
        return;
      }
      this.A = (paramDouble);
      return;
    }
    this.C.I = ((int)paramDouble);
  }
  
  void a(int paramInt1, int paramInt2, com.tencent.luggage.wxa.l.e parame)
  {
    if ((paramInt1 != 161) && (paramInt1 != 163))
    {
      if (paramInt1 != 16981)
      {
        if (paramInt1 != 18402)
        {
          if (paramInt1 != 21419)
          {
            if (paramInt1 != 25506)
            {
              if (paramInt1 == 30322)
              {
                localObject1 = this.C;
                ((d.b)localObject1).o = new byte[paramInt2];
                parame.b(((d.b)localObject1).o, 0, paramInt2);
                return;
              }
              parame = new StringBuilder();
              parame.append("Unexpected id: ");
              parame.append(paramInt1);
              throw new p(parame.toString());
            }
            localObject1 = this.C;
            ((d.b)localObject1).h = new byte[paramInt2];
            parame.b(((d.b)localObject1).h, 0, paramInt2);
            return;
          }
          Arrays.fill(this.r.a, (byte)0);
          parame.b(this.r.a, 4 - paramInt2, paramInt2);
          this.r.c(0);
          this.E = ((int)this.r.l());
          return;
        }
        localObject1 = new byte[paramInt2];
        parame.b((byte[])localObject1, 0, paramInt2);
        this.C.g = new l.a(1, (byte[])localObject1, 0, 0);
        return;
      }
      localObject1 = this.C;
      ((d.b)localObject1).f = new byte[paramInt2];
      parame.b(((d.b)localObject1).f, 0, paramInt2);
      return;
    }
    if (this.N == 0)
    {
      this.T = ((int)this.k.a(parame, false, true, 8));
      this.U = this.k.b();
      this.P = -9223372036854775807L;
      this.N = 1;
      this.p.a();
    }
    Object localObject1 = (d.b)this.l.get(this.T);
    if (localObject1 == null)
    {
      parame.b(paramInt2 - this.U);
      this.N = 0;
      return;
    }
    if (this.N == 1)
    {
      a(parame, 3);
      int i1 = (this.p.a[2] & 0x6) >> 1;
      if (i1 == 0)
      {
        this.R = 1;
        this.S = a(this.S, 1);
        this.S[0] = (paramInt2 - this.U - 3);
      }
      else
      {
        if (paramInt1 != 163) {
          break label1209;
        }
        a(parame, 4);
        this.R = ((this.p.a[3] & 0xFF) + 1);
        this.S = a(this.S, this.R);
        int i2;
        if (i1 == 2)
        {
          i2 = this.U;
          i1 = this.R;
          paramInt2 = (paramInt2 - i2 - 4) / i1;
          Arrays.fill(this.S, 0, i1, paramInt2);
        }
        else
        {
          int i3;
          int i4;
          int i5;
          Object localObject2;
          if (i1 == 1)
          {
            i3 = 0;
            i1 = 4;
            i2 = 0;
            for (;;)
            {
              i4 = this.R;
              if (i3 >= i4 - 1) {
                break;
              }
              this.S[i3] = 0;
              i4 = i1;
              do
              {
                i1 = i4 + 1;
                a(parame, i1);
                i5 = this.p.a[(i1 - 1)] & 0xFF;
                localObject2 = this.S;
                localObject2[i3] += i5;
                i4 = i1;
              } while (i5 == 255);
              i2 += localObject2[i3];
              i3 += 1;
            }
            this.S[(i4 - 1)] = (paramInt2 - this.U - i1 - i2);
          }
          else
          {
            if (i1 != 3) {
              break label1174;
            }
            i3 = 0;
            i1 = 4;
            i2 = 0;
            for (;;)
            {
              i4 = this.R;
              if (i3 >= i4 - 1) {
                break label999;
              }
              this.S[i3] = 0;
              i5 = i1 + 1;
              a(parame, i5);
              localObject2 = this.p.a;
              int i6 = i5 - 1;
              if (localObject2[i6] == 0) {
                break label988;
              }
              long l2 = 0L;
              i4 = 0;
              long l1;
              for (;;)
              {
                i1 = i5;
                l1 = l2;
                if (i4 >= 8) {
                  break;
                }
                i1 = 1 << 7 - i4;
                if ((this.p.a[i6] & i1) != 0)
                {
                  i5 += i4;
                  a(parame, i5);
                  l1 = this.p.a[i6] & 0xFF & (i1 ^ 0xFFFFFFFF);
                  i1 = i6 + 1;
                  for (;;)
                  {
                    l2 = l1;
                    if (i1 >= i5) {
                      break;
                    }
                    l1 = l2 << 8 | this.p.a[i1] & 0xFF;
                    i1 += 1;
                  }
                  i1 = i5;
                  l1 = l2;
                  if (i3 <= 0) {
                    break;
                  }
                  l1 = l2 - ((1L << i4 * 7 + 6) - 1L);
                  i1 = i5;
                  break;
                }
                i4 += 1;
              }
              if ((l1 < -2147483648L) || (l1 > 2147483647L)) {
                break;
              }
              i4 = (int)l1;
              localObject2 = this.S;
              if (i3 != 0) {
                i4 += localObject2[(i3 - 1)];
              }
              localObject2[i3] = i4;
              i2 += this.S[i3];
              i3 += 1;
            }
            throw new p("EBML lacing sample size out of range.");
            label988:
            throw new p("No valid varint length mask found");
            label999:
            this.S[(i4 - 1)] = (paramInt2 - this.U - i1 - i2);
          }
        }
      }
      paramInt2 = this.p.a[0];
      i1 = this.p.a[1];
      this.O = (this.J + a(paramInt2 << 8 | i1 & 0xFF));
      if ((this.p.a[2] & 0x8) == 8) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if ((((d.b)localObject1).c != 2) && ((paramInt1 != 163) || ((this.p.a[2] & 0x80) != 128))) {
        paramInt2 = 0;
      } else {
        paramInt2 = 1;
      }
      if (i1 != 0) {
        i1 = -2147483648;
      } else {
        i1 = 0;
      }
      this.V = (paramInt2 | i1);
      this.N = 2;
      this.Q = 0;
      break label1220;
      label1174:
      parame = new StringBuilder();
      parame.append("Unexpected lacing value: ");
      parame.append(i1);
      throw new p(parame.toString());
      label1209:
      throw new p("Lacing only supported in SimpleBlocks.");
    }
    label1220:
    if (paramInt1 == 163)
    {
      for (;;)
      {
        paramInt1 = this.Q;
        if (paramInt1 >= this.R) {
          break;
        }
        a(parame, (d.b)localObject1, this.S[paramInt1]);
        a((d.b)localObject1, this.O + this.Q * ((d.b)localObject1).d / 1000);
        this.Q += 1;
      }
      this.N = 0;
      return;
    }
    a(parame, (d.b)localObject1, this.S[0]);
  }
  
  void a(int paramInt, long paramLong)
  {
    if (paramInt != 20529)
    {
      if (paramInt != 20530)
      {
        boolean bool2 = false;
        boolean bool1 = false;
        switch (paramInt)
        {
        default: 
          switch (paramInt)
          {
          default: 
            return;
          case 21949: 
            this.C.v = ((int)paramLong);
            return;
          case 21948: 
            this.C.u = ((int)paramLong);
            return;
          case 21947: 
            localObject = this.C;
            ((d.b)localObject).q = true;
            paramInt = (int)paramLong;
            if (paramInt != 1)
            {
              if (paramInt != 9)
              {
                if ((paramInt != 4) && (paramInt != 5) && (paramInt != 6) && (paramInt != 7)) {
                  return;
                }
                this.C.r = 2;
                return;
              }
              ((d.b)localObject).r = 6;
              return;
            }
            ((d.b)localObject).r = 1;
            return;
          case 21946: 
            paramInt = (int)paramLong;
            if (paramInt != 1) {
              if (paramInt != 16)
              {
                if (paramInt != 18)
                {
                  if ((paramInt == 6) || (paramInt == 7)) {}
                }
                else {
                  this.C.s = 7;
                }
              }
              else
              {
                this.C.s = 6;
                return;
              }
            }
            this.C.s = 3;
            return;
          }
          paramInt = (int)paramLong;
          if (paramInt != 1)
          {
            if (paramInt != 2) {
              return;
            }
            this.C.t = 1;
            return;
          }
          this.C.t = 2;
          return;
        case 2807729: 
          this.z = paramLong;
          return;
        case 2352003: 
          this.C.d = ((int)paramLong);
          return;
        case 25188: 
          this.C.H = ((int)paramLong);
          return;
        case 22203: 
          this.C.K = paramLong;
          return;
        case 22186: 
          this.C.J = paramLong;
          return;
        case 21930: 
          localObject = this.C;
          if (paramLong == 1L) {
            bool1 = true;
          }
          ((d.b)localObject).M = bool1;
          return;
        case 21690: 
          this.C.m = ((int)paramLong);
          return;
        case 21682: 
          this.C.n = ((int)paramLong);
          return;
        case 21680: 
          this.C.l = ((int)paramLong);
          return;
        case 21432: 
          paramInt = (int)paramLong;
          if (paramInt != 0)
          {
            if (paramInt != 1)
            {
              if (paramInt != 3)
              {
                if (paramInt != 15) {
                  return;
                }
                this.C.p = 3;
                return;
              }
              this.C.p = 1;
              return;
            }
            this.C.p = 2;
            return;
          }
          this.C.p = 0;
          return;
        case 21420: 
          this.F = (paramLong + this.y);
          return;
        case 18408: 
          if (paramLong == 1L) {
            return;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("AESSettingsCipherMode ");
          ((StringBuilder)localObject).append(paramLong);
          ((StringBuilder)localObject).append(" not supported");
          throw new p(((StringBuilder)localObject).toString());
        case 18401: 
          if (paramLong == 5L) {
            return;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("ContentEncAlgo ");
          ((StringBuilder)localObject).append(paramLong);
          ((StringBuilder)localObject).append(" not supported");
          throw new p(((StringBuilder)localObject).toString());
        case 17143: 
          if (paramLong == 1L) {
            return;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("EBMLReadVersion ");
          ((StringBuilder)localObject).append(paramLong);
          ((StringBuilder)localObject).append(" not supported");
          throw new p(((StringBuilder)localObject).toString());
        case 17029: 
          if ((paramLong >= 1L) && (paramLong <= 2L)) {
            return;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("DocTypeReadVersion ");
          ((StringBuilder)localObject).append(paramLong);
          ((StringBuilder)localObject).append(" not supported");
          throw new p(((StringBuilder)localObject).toString());
        case 16980: 
          if (paramLong == 3L) {
            return;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("ContentCompAlgo ");
          ((StringBuilder)localObject).append(paramLong);
          ((StringBuilder)localObject).append(" not supported");
          throw new p(((StringBuilder)localObject).toString());
        case 251: 
          this.ag = true;
          return;
        case 241: 
          if (this.M) {
            break;
          }
          this.L.a(paramLong);
          this.M = true;
          return;
        case 231: 
          this.J = a(paramLong);
          return;
        case 215: 
          this.C.b = ((int)paramLong);
          return;
        case 186: 
          this.C.k = ((int)paramLong);
          return;
        case 179: 
          this.K.a(a(paramLong));
          return;
        case 176: 
          this.C.j = ((int)paramLong);
          return;
        case 159: 
          this.C.G = ((int)paramLong);
          return;
        case 155: 
          this.P = a(paramLong);
          return;
        case 136: 
          localObject = this.C;
          bool1 = bool2;
          if (paramLong == 1L) {
            bool1 = true;
          }
          ((d.b)localObject).L = bool1;
          return;
        case 131: 
          this.C.c = ((int)paramLong);
          return;
        }
      }
      else
      {
        if (paramLong == 1L) {
          return;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ContentEncodingScope ");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append(" not supported");
        throw new p(((StringBuilder)localObject).toString());
      }
    }
    else {
      if (paramLong != 0L) {
        break label1120;
      }
    }
    return;
    label1120:
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ContentEncodingOrder ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" not supported");
    throw new p(((StringBuilder)localObject).toString());
  }
  
  void a(int paramInt, long paramLong1, long paramLong2)
  {
    if (paramInt != 160)
    {
      if (paramInt != 174)
      {
        if (paramInt != 187)
        {
          if (paramInt != 19899)
          {
            if (paramInt != 20533)
            {
              if (paramInt != 21968)
              {
                if (paramInt != 25152) {
                  if (paramInt != 408125543)
                  {
                    if (paramInt != 475249515)
                    {
                      if (paramInt != 524531317) {
                        return;
                      }
                      if (!this.D)
                      {
                        if ((this.m) && (this.H != -1L))
                        {
                          this.G = true;
                          return;
                        }
                        this.ah.a(new k.a(this.B));
                        this.D = true;
                      }
                    }
                    else
                    {
                      this.K = new h();
                      this.L = new h();
                    }
                  }
                  else
                  {
                    long l1 = this.y;
                    if ((l1 != -1L) && (l1 != paramLong1)) {
                      throw new p("Multiple Segment elements not supported");
                    }
                    this.y = paramLong1;
                    this.x = paramLong2;
                  }
                }
              }
              else {
                this.C.q = true;
              }
            }
            else {
              this.C.e = true;
            }
          }
          else
          {
            this.E = -1;
            this.F = -1L;
          }
        }
        else {
          this.M = false;
        }
      }
      else {
        this.C = new d.b(null);
      }
    }
    else {
      this.ag = false;
    }
  }
  
  void a(int paramInt, String paramString)
  {
    if (paramInt != 134)
    {
      if (paramInt != 17026)
      {
        if (paramInt != 2274716) {
          return;
        }
        d.b.a(this.C, paramString);
        return;
      }
      if (!"webm".equals(paramString))
      {
        if ("matroska".equals(paramString)) {
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("DocType ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" not supported");
        throw new p(localStringBuilder.toString());
      }
    }
    else
    {
      this.C.a = paramString;
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.J = -9223372036854775807L;
    this.N = 0;
    this.j.a();
    this.k.a();
    d();
  }
  
  public void a(com.tencent.luggage.wxa.l.f paramf)
  {
    this.ah = paramf;
  }
  
  public boolean a(com.tencent.luggage.wxa.l.e parame)
  {
    return new e().a(parame);
  }
  
  boolean b(int paramInt)
  {
    return (paramInt == 357149030) || (paramInt == 524531317) || (paramInt == 475249515) || (paramInt == 374648427);
  }
  
  public void c() {}
  
  void c(int paramInt)
  {
    if (paramInt != 160)
    {
      if (paramInt != 174)
      {
        long l1;
        if (paramInt != 19899)
        {
          if (paramInt != 25152)
          {
            if (paramInt != 28032)
            {
              if (paramInt != 357149030)
              {
                if (paramInt != 374648427)
                {
                  if (paramInt != 475249515) {
                    return;
                  }
                  if (!this.D)
                  {
                    this.ah.a(e());
                    this.D = true;
                  }
                }
                else
                {
                  if (this.l.size() != 0)
                  {
                    this.ah.a();
                    return;
                  }
                  throw new p("No valid tracks were found");
                }
              }
              else
              {
                if (this.z == -9223372036854775807L) {
                  this.z = 1000000L;
                }
                l1 = this.A;
                if (l1 != -9223372036854775807L) {
                  this.B = a(l1);
                }
              }
            }
            else if (this.C.e)
            {
              if (this.C.f == null) {
                return;
              }
              throw new p("Combining encryption and compression is not supported");
            }
          }
          else if (this.C.e)
          {
            if (this.C.g != null)
            {
              this.C.i = new com.tencent.luggage.wxa.k.a(new a.a[] { new a.a(com.tencent.luggage.wxa.h.b.b, null, "video/webm", this.C.g.b) });
              return;
            }
            throw new p("Encrypted Track found but ContentEncKeyID was not found");
          }
        }
        else
        {
          paramInt = this.E;
          if (paramInt != -1)
          {
            l1 = this.F;
            if (l1 != -1L)
            {
              if (paramInt != 475249515) {
                return;
              }
              this.H = l1;
              return;
            }
          }
          throw new p("Mandatory element SeekID or SeekPosition not found");
        }
      }
      else
      {
        if (a(this.C.a))
        {
          d.b localb = this.C;
          localb.a(this.ah, localb.b);
          this.l.put(this.C.b, this.C);
        }
        this.C = null;
      }
    }
    else
    {
      if (this.N != 2) {
        return;
      }
      if (!this.ag) {
        this.V |= 0x1;
      }
      a((d.b)this.l.get(this.T), this.O);
      this.N = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.n.d
 * JD-Core Version:    0.7.0.1
 */