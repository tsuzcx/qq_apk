package com.tencent.luggage.wxa.i;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.media.AudioAttributes.Builder;
import android.media.AudioFormat;
import android.media.AudioFormat.Builder;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.luggage.wxa.ao.x;
import com.tencent.luggage.wxa.h.q;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportAudioTrack;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.LinkedList;

public final class f
{
  public static boolean a = false;
  public static boolean b = false;
  private int A;
  private int B;
  private int C;
  private long D;
  private long E;
  private boolean F;
  private long G;
  private Method H;
  private int I;
  private long J;
  private long K;
  private int L;
  private long M;
  private long N;
  private int O;
  private int P;
  private long Q;
  private long R;
  private long S;
  private float T;
  private d[] U;
  private ByteBuffer[] V;
  private ByteBuffer W;
  private ByteBuffer X;
  private byte[] Y;
  private int Z;
  private int aa;
  private boolean ab;
  private boolean ac;
  private int ad;
  private boolean ae;
  private boolean af;
  private long ag;
  private final c c;
  private final g d;
  private final l e;
  private final d[] f;
  private final f.f g;
  private final ConditionVariable h;
  private final long[] i;
  private final f.a j;
  private final LinkedList<f.g> k;
  private AudioTrack l;
  private AudioTrack m;
  private int n;
  private int o;
  private int p;
  private int q;
  private b r;
  private boolean s;
  private int t;
  private long u;
  private q v;
  private q w;
  private long x;
  private long y;
  private ByteBuffer z;
  
  public f(c paramc, d[] paramArrayOfd, f.f paramf)
  {
    this.c = paramc;
    this.g = paramf;
    this.h = new ConditionVariable(true);
    if (x.a >= 18) {}
    try
    {
      this.H = AudioTrack.class.getMethod("getLatency", (Class[])null);
    }
    catch (NoSuchMethodException paramc)
    {
      label52:
      break label52;
    }
    if (x.a >= 19) {
      this.j = new f.b();
    } else {
      this.j = new f.a(null);
    }
    this.d = new g();
    this.e = new l();
    this.f = new d[paramArrayOfd.length + 3];
    this.f[0] = new j();
    paramc = this.f;
    paramc[1] = this.d;
    System.arraycopy(paramArrayOfd, 0, paramc, 2, paramArrayOfd.length);
    this.f[(paramArrayOfd.length + 2)] = this.e;
    this.i = new long[10];
    this.T = 1.0F;
    this.P = 0;
    this.r = b.a;
    this.ad = 0;
    this.w = q.a;
    this.aa = -1;
    this.U = new d[0];
    this.V = new ByteBuffer[0];
    this.k = new LinkedList();
  }
  
  private static int a(int paramInt, ByteBuffer paramByteBuffer)
  {
    if ((paramInt != 7) && (paramInt != 8))
    {
      if (paramInt == 5) {
        return a.a();
      }
      if (paramInt == 6) {
        return a.a(paramByteBuffer);
      }
      paramByteBuffer = new StringBuilder();
      paramByteBuffer.append("Unexpected audio encoding: ");
      paramByteBuffer.append(paramInt);
      throw new IllegalStateException(paramByteBuffer.toString());
    }
    return h.a(paramByteBuffer);
  }
  
  @TargetApi(21)
  private static int a(AudioTrack paramAudioTrack, ByteBuffer paramByteBuffer, int paramInt)
  {
    return paramAudioTrack.write(paramByteBuffer, paramInt, 1);
  }
  
  @TargetApi(21)
  private int a(AudioTrack paramAudioTrack, ByteBuffer paramByteBuffer, int paramInt, long paramLong)
  {
    if (this.z == null)
    {
      this.z = ByteBuffer.allocate(16);
      this.z.order(ByteOrder.BIG_ENDIAN);
      this.z.putInt(1431633921);
    }
    if (this.A == 0)
    {
      this.z.putInt(4, paramInt);
      this.z.putLong(8, paramLong * 1000L);
      this.z.position(0);
      this.A = paramInt;
    }
    int i1 = this.z.remaining();
    if (i1 > 0)
    {
      int i2 = paramAudioTrack.write(this.z, i1, 1);
      if (i2 < 0)
      {
        this.A = 0;
        return i2;
      }
      if (i2 < i1) {
        return 0;
      }
    }
    paramInt = a(paramAudioTrack, paramByteBuffer, paramInt);
    if (paramInt < 0)
    {
      this.A = 0;
      return paramInt;
    }
    this.A -= paramInt;
    return paramInt;
  }
  
  private void a(long paramLong)
  {
    int i2 = this.U.length;
    int i1 = i2;
    while (i1 >= 0)
    {
      ByteBuffer localByteBuffer;
      if (i1 > 0)
      {
        localByteBuffer = this.V[(i1 - 1)];
      }
      else
      {
        localByteBuffer = this.W;
        if (localByteBuffer == null) {
          localByteBuffer = d.a;
        }
      }
      if (i1 == i2)
      {
        b(localByteBuffer, paramLong);
      }
      else
      {
        Object localObject = this.U[i1];
        ((d)localObject).a(localByteBuffer);
        localObject = ((d)localObject).e();
        this.V[i1] = localObject;
        if (((ByteBuffer)localObject).hasRemaining())
        {
          i1 += 1;
          continue;
        }
      }
      if (localByteBuffer.hasRemaining()) {
        return;
      }
      i1 -= 1;
    }
  }
  
  @TargetApi(21)
  private static void a(AudioTrack paramAudioTrack, float paramFloat)
  {
    paramAudioTrack.setVolume(paramFloat);
  }
  
  private static int b(String paramString)
  {
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 1505942594: 
      if (paramString.equals("audio/vnd.dts.hd")) {
        i1 = 3;
      }
      break;
    case 1504578661: 
      if (paramString.equals("audio/eac3")) {
        i1 = 1;
      }
      break;
    case 187078296: 
      if (paramString.equals("audio/ac3")) {
        i1 = 0;
      }
      break;
    case -1095064472: 
      if (paramString.equals("audio/vnd.dts")) {
        i1 = 2;
      }
      break;
    }
    int i1 = -1;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3) {
            return 0;
          }
          return 8;
        }
        return 7;
      }
      return 6;
    }
    return 5;
  }
  
  private long b(long paramLong)
  {
    while ((!this.k.isEmpty()) && (paramLong >= f.g.b((f.g)this.k.getFirst())))
    {
      f.g localg = (f.g)this.k.remove();
      this.w = f.g.a(localg);
      this.y = f.g.b(localg);
      this.x = (f.g.c(localg) - this.Q);
    }
    if (this.w.b == 1.0F) {
      return paramLong + this.x - this.y;
    }
    long l2;
    long l1;
    if ((this.k.isEmpty()) && (this.e.j() >= 1024L))
    {
      l2 = this.x;
      l1 = x.b(paramLong - this.y, this.e.i(), this.e.j());
      paramLong = l2;
    }
    for (;;)
    {
      return paramLong + l1;
      l1 = this.x;
      double d1 = this.w.b;
      double d2 = paramLong - this.y;
      Double.isNaN(d1);
      Double.isNaN(d2);
      l2 = (d1 * d2);
      paramLong = l1;
      l1 = l2;
    }
  }
  
  private AudioTrack b(int paramInt)
  {
    return new ReportAudioTrack(3, 4000, 4, 2, 2, 0, paramInt);
  }
  
  private static void b(AudioTrack paramAudioTrack, float paramFloat)
  {
    paramAudioTrack.setStereoVolume(paramFloat, paramFloat);
  }
  
  private boolean b(ByteBuffer paramByteBuffer, long paramLong)
  {
    if (!paramByteBuffer.hasRemaining()) {
      return true;
    }
    Object localObject = this.X;
    boolean bool;
    int i1;
    int i2;
    if (localObject != null)
    {
      if (localObject == paramByteBuffer) {
        bool = true;
      } else {
        bool = false;
      }
      com.tencent.luggage.wxa.ao.a.a(bool);
    }
    else
    {
      this.X = paramByteBuffer;
      if (x.a < 21)
      {
        i1 = paramByteBuffer.remaining();
        localObject = this.Y;
        if ((localObject == null) || (localObject.length < i1)) {
          this.Y = new byte[i1];
        }
        i2 = paramByteBuffer.position();
        paramByteBuffer.get(this.Y, 0, i1);
        paramByteBuffer.position(i2);
        this.Z = 0;
      }
    }
    int i3 = paramByteBuffer.remaining();
    if (x.a < 21)
    {
      i1 = (int)(this.M - this.j.b() * this.L);
      i1 = this.t - i1;
      if (i1 > 0)
      {
        i1 = Math.min(i3, i1);
        i2 = this.m.write(this.Y, this.Z, i1);
        i1 = i2;
        if (i2 > 0)
        {
          this.Z += i2;
          paramByteBuffer.position(paramByteBuffer.position() + i2);
          i1 = i2;
        }
      }
      else
      {
        i1 = 0;
      }
    }
    else if (this.ae)
    {
      if (paramLong != -9223372036854775807L) {
        bool = true;
      } else {
        bool = false;
      }
      com.tencent.luggage.wxa.ao.a.b(bool);
      i1 = a(this.m, paramByteBuffer, i3, paramLong);
    }
    else
    {
      i1 = a(this.m, paramByteBuffer, i3);
    }
    this.ag = SystemClock.elapsedRealtime();
    if (i1 >= 0)
    {
      if (!this.s) {
        this.M += i1;
      }
      if (i1 == i3)
      {
        if (this.s) {
          this.N += this.O;
        }
        this.X = null;
        return true;
      }
      return false;
    }
    throw new f.h(i1);
  }
  
  private long c(long paramLong)
  {
    return paramLong * 1000000L / this.n;
  }
  
  private long d(long paramLong)
  {
    return paramLong * this.n / 1000000L;
  }
  
  private void k()
  {
    Object localObject = new ArrayList();
    d[] arrayOfd = this.f;
    int i3 = arrayOfd.length;
    int i2 = 0;
    int i1 = 0;
    while (i1 < i3)
    {
      d locald = arrayOfd[i1];
      if (locald.a()) {
        ((ArrayList)localObject).add(locald);
      } else {
        locald.g();
      }
      i1 += 1;
    }
    i3 = ((ArrayList)localObject).size();
    this.U = ((d[])((ArrayList)localObject).toArray(new d[i3]));
    this.V = new ByteBuffer[i3];
    i1 = i2;
    while (i1 < i3)
    {
      localObject = this.U[i1];
      ((d)localObject).g();
      this.V[i1] = ((d)localObject).e();
      i1 += 1;
    }
  }
  
  private void l()
  {
    this.h.block();
    this.m = x();
    int i1 = this.m.getAudioSessionId();
    if ((a) && (x.a < 21))
    {
      AudioTrack localAudioTrack = this.l;
      if ((localAudioTrack != null) && (i1 != localAudioTrack.getAudioSessionId())) {
        o();
      }
      if (this.l == null) {
        this.l = b(i1);
      }
    }
    if (this.ad != i1)
    {
      this.ad = i1;
      this.g.a(i1);
    }
    this.j.a(this.m, v());
    n();
    this.af = false;
  }
  
  private boolean m()
  {
    int i1;
    if (this.aa == -1) {
      if (this.s) {
        i1 = this.U.length;
      } else {
        i1 = 0;
      }
    }
    for (this.aa = i1;; this.aa += 1)
    {
      i1 = 1;
      break label38;
      i1 = 0;
      label38:
      int i2 = this.aa;
      localObject = this.U;
      if (i2 >= localObject.length) {
        break;
      }
      localObject = localObject[i2];
      if (i1 != 0) {
        ((d)localObject).d();
      }
      a(-9223372036854775807L);
      if (!((d)localObject).f()) {
        return false;
      }
    }
    Object localObject = this.X;
    if (localObject != null)
    {
      b((ByteBuffer)localObject, -9223372036854775807L);
      if (this.X != null) {
        return false;
      }
    }
    this.aa = -1;
    return true;
  }
  
  private void n()
  {
    if (!r()) {
      return;
    }
    if (x.a >= 21)
    {
      a(this.m, this.T);
      return;
    }
    b(this.m, this.T);
  }
  
  private void o()
  {
    AudioTrack localAudioTrack = this.l;
    if (localAudioTrack == null) {
      return;
    }
    this.l = null;
    new f.2(this, localAudioTrack).start();
  }
  
  private boolean p()
  {
    return (r()) && (this.P != 0);
  }
  
  private void q()
  {
    long l1 = this.j.c();
    if (l1 == 0L) {
      return;
    }
    long l2 = System.nanoTime() / 1000L;
    Object localObject;
    if (l2 - this.E >= 30000L)
    {
      localObject = this.i;
      int i1 = this.B;
      localObject[i1] = (l1 - l2);
      this.B = ((i1 + 1) % 10);
      i1 = this.C;
      if (i1 < 10) {
        this.C = (i1 + 1);
      }
      this.E = l2;
      this.D = 0L;
      i1 = 0;
      for (;;)
      {
        int i2 = this.C;
        if (i1 >= i2) {
          break;
        }
        this.D += this.i[i1] / i2;
        i1 += 1;
      }
    }
    if (v()) {
      return;
    }
    if (l2 - this.G >= 500000L)
    {
      this.F = this.j.d();
      if (this.F)
      {
        long l3 = this.j.e() / 1000L;
        long l4 = this.j.f();
        if (l3 < this.R)
        {
          this.F = false;
        }
        else if (Math.abs(l3 - l2) > 5000000L)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Spurious audio timestamp (system clock mismatch): ");
          ((StringBuilder)localObject).append(l4);
          ((StringBuilder)localObject).append(", ");
          ((StringBuilder)localObject).append(l3);
          ((StringBuilder)localObject).append(", ");
          ((StringBuilder)localObject).append(l2);
          ((StringBuilder)localObject).append(", ");
          ((StringBuilder)localObject).append(l1);
          ((StringBuilder)localObject).append(", ");
          ((StringBuilder)localObject).append(s());
          ((StringBuilder)localObject).append(", ");
          ((StringBuilder)localObject).append(t());
          localObject = ((StringBuilder)localObject).toString();
          if (!b)
          {
            Log.w("AudioTrack", (String)localObject);
            this.F = false;
          }
          else
          {
            throw new f.e((String)localObject);
          }
        }
        else if (Math.abs(c(l4) - l1) > 5000000L)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Spurious audio timestamp (frame position mismatch): ");
          ((StringBuilder)localObject).append(l4);
          ((StringBuilder)localObject).append(", ");
          ((StringBuilder)localObject).append(l3);
          ((StringBuilder)localObject).append(", ");
          ((StringBuilder)localObject).append(l2);
          ((StringBuilder)localObject).append(", ");
          ((StringBuilder)localObject).append(l1);
          ((StringBuilder)localObject).append(", ");
          ((StringBuilder)localObject).append(s());
          ((StringBuilder)localObject).append(", ");
          ((StringBuilder)localObject).append(t());
          localObject = ((StringBuilder)localObject).toString();
          if (!b)
          {
            Log.w("AudioTrack", (String)localObject);
            this.F = false;
          }
          else
          {
            throw new f.e((String)localObject);
          }
        }
      }
      localObject = this.H;
      if ((localObject == null) || (this.s)) {}
    }
    try
    {
      this.S = (((Integer)((Method)localObject).invoke(this.m, (Object[])null)).intValue() * 1000L - this.u);
      this.S = Math.max(this.S, 0L);
      if (this.S <= 5000000L) {
        break label681;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Ignoring impossibly large audio latency: ");
      ((StringBuilder)localObject).append(this.S);
      Log.w("AudioTrack", ((StringBuilder)localObject).toString());
      this.S = 0L;
    }
    catch (Exception localException)
    {
      label676:
      break label676;
    }
    this.H = null;
    label681:
    this.G = l2;
  }
  
  private boolean r()
  {
    return this.m != null;
  }
  
  private long s()
  {
    if (this.s) {
      return this.K;
    }
    return this.J / this.I;
  }
  
  private long t()
  {
    if (this.s) {
      return this.N;
    }
    return this.M / this.L;
  }
  
  private void u()
  {
    this.D = 0L;
    this.C = 0;
    this.B = 0;
    this.E = 0L;
    this.F = false;
    this.G = 0L;
  }
  
  private boolean v()
  {
    if (x.a < 23)
    {
      int i1 = this.q;
      if ((i1 == 5) || (i1 == 6)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean w()
  {
    return (v()) && (this.m.getPlayState() == 2) && (this.m.getPlaybackHeadPosition() == 0);
  }
  
  private AudioTrack x()
  {
    Object localObject;
    if (x.a >= 21)
    {
      localObject = y();
    }
    else
    {
      i1 = x.c(this.r.d);
      int i2 = this.ad;
      if (i2 == 0) {
        localObject = new ReportAudioTrack(i1, this.n, this.o, this.q, this.t, 1);
      } else {
        localObject = new ReportAudioTrack(i1, this.n, this.o, this.q, this.t, 1, i2);
      }
    }
    int i1 = ((AudioTrack)localObject).getState();
    if (i1 == 1) {
      return localObject;
    }
    try
    {
      ((AudioTrack)localObject).release();
      label108:
      throw new f.d(i1, this.n, this.o, this.t);
    }
    catch (Exception localException)
    {
      break label108;
    }
  }
  
  @TargetApi(21)
  private AudioTrack y()
  {
    AudioAttributes localAudioAttributes;
    if (this.ae) {
      localAudioAttributes = new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
    } else {
      localAudioAttributes = this.r.a();
    }
    AudioFormat localAudioFormat = new AudioFormat.Builder().setChannelMask(this.o).setEncoding(this.q).setSampleRate(this.n).build();
    int i1 = this.ad;
    if (i1 == 0) {
      i1 = 0;
    }
    return new ReportAudioTrack(localAudioAttributes, localAudioFormat, this.t, 1, i1);
  }
  
  public long a(boolean paramBoolean)
  {
    if (!p()) {
      return -9223372036854775808L;
    }
    if (this.m.getPlayState() == 3) {
      q();
    }
    long l1 = System.nanoTime() / 1000L;
    long l2;
    if (this.F)
    {
      l1 = d(l1 - this.j.e() / 1000L);
      l2 = c(this.j.f() + l1);
    }
    else
    {
      if (this.C == 0) {
        l1 = this.j.c();
      } else {
        l1 += this.D;
      }
      l2 = l1;
      if (!paramBoolean) {
        l2 = l1 - this.S;
      }
    }
    return this.Q + b(l2);
  }
  
  public q a(q paramq)
  {
    if (this.s)
    {
      this.w = q.a;
      return this.w;
    }
    q localq = new q(this.e.a(paramq.b), this.e.b(paramq.c));
    paramq = this.v;
    if (paramq == null) {
      if (!this.k.isEmpty()) {
        paramq = f.g.a((f.g)this.k.getLast());
      } else {
        paramq = this.w;
      }
    }
    if (!localq.equals(paramq)) {
      if (r()) {
        this.v = localq;
      } else {
        this.w = localq;
      }
    }
    return this.w;
  }
  
  public void a()
  {
    this.ac = true;
    if (r())
    {
      this.R = (System.nanoTime() / 1000L);
      this.m.play();
    }
  }
  
  public void a(float paramFloat)
  {
    if (this.T != paramFloat)
    {
      this.T = paramFloat;
      n();
    }
  }
  
  public void a(int paramInt)
  {
    boolean bool;
    if (x.a >= 21) {
      bool = true;
    } else {
      bool = false;
    }
    com.tencent.luggage.wxa.ao.a.b(bool);
    if ((!this.ae) || (this.ad != paramInt))
    {
      this.ae = true;
      this.ad = paramInt;
      i();
    }
  }
  
  public void a(b paramb)
  {
    if (this.r.equals(paramb)) {
      return;
    }
    this.r = paramb;
    if (this.ae) {
      return;
    }
    i();
    this.ad = 0;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    boolean bool2 = "audio/raw".equals(paramString);
    boolean bool1 = true;
    bool2 ^= true;
    int i1;
    if (bool2) {
      i1 = b(paramString);
    } else {
      i1 = paramInt3;
    }
    int i3;
    int i2;
    if (!bool2)
    {
      this.I = x.b(paramInt3, paramInt1);
      this.d.a(paramArrayOfInt);
      paramString = this.f;
      i4 = paramString.length;
      paramInt3 = i1;
      i3 = paramInt1;
      i2 = 0;
      i1 = 0;
      paramInt1 = paramInt3;
      paramInt3 = i3;
      while (i2 < i4)
      {
        paramArrayOfInt = paramString[i2];
        try
        {
          int i5 = paramArrayOfInt.a(paramInt2, paramInt3, paramInt1);
          i1 |= i5;
          if (paramArrayOfInt.a())
          {
            paramInt3 = paramArrayOfInt.b();
            paramInt1 = paramArrayOfInt.c();
          }
          i2 += 1;
        }
        catch (d.a paramString)
        {
          throw new f.c(paramString);
        }
      }
      if (i1 != 0) {
        k();
      }
      i3 = i1;
      i1 = paramInt1;
      i2 = paramInt3;
    }
    else
    {
      i3 = 0;
      i2 = paramInt1;
    }
    int i4 = 252;
    switch (i2)
    {
    default: 
      paramString = new StringBuilder();
      paramString.append("Unsupported channel count: ");
      paramString.append(i2);
      throw new f.c(paramString.toString());
    case 8: 
      paramInt1 = com.tencent.luggage.wxa.h.b.a;
      break;
    case 7: 
      paramInt1 = 1276;
      break;
    case 6: 
      paramInt1 = 252;
      break;
    case 5: 
      paramInt1 = 220;
      break;
    case 4: 
      paramInt1 = 204;
      break;
    case 3: 
      paramInt1 = 28;
      break;
    case 2: 
      paramInt1 = 12;
      break;
    case 1: 
      paramInt1 = 4;
    }
    if ((x.a <= 23) && ("foster".equals(x.b)) && ("NVIDIA".equals(x.c)))
    {
      paramInt3 = i4;
      if (i2 == 3) {
        break label409;
      }
      paramInt3 = i4;
      if (i2 == 5) {
        break label409;
      }
      if (i2 == 7)
      {
        paramInt3 = com.tencent.luggage.wxa.h.b.a;
        break label409;
      }
    }
    paramInt3 = paramInt1;
    label409:
    paramInt1 = paramInt3;
    if (x.a <= 25)
    {
      paramInt1 = paramInt3;
      if ("fugu".equals(x.b))
      {
        paramInt1 = paramInt3;
        if (bool2)
        {
          paramInt1 = paramInt3;
          if (i2 == 1) {
            paramInt1 = 12;
          }
        }
      }
    }
    if ((i3 == 0) && (r()) && (this.p == i1) && (this.n == paramInt2) && (this.o == paramInt1)) {
      return;
    }
    i();
    this.p = i1;
    this.s = bool2;
    this.n = paramInt2;
    this.o = paramInt1;
    if (!bool2) {
      i1 = 2;
    }
    this.q = i1;
    this.L = x.b(2, i2);
    if (paramInt4 != 0)
    {
      this.t = paramInt4;
    }
    else if (bool2)
    {
      paramInt1 = this.q;
      if ((paramInt1 != 5) && (paramInt1 != 6)) {
        this.t = 49152;
      } else {
        this.t = 20480;
      }
    }
    else
    {
      paramInt3 = AudioTrack.getMinBufferSize(paramInt2, paramInt1, this.q);
      if (paramInt3 == -2) {
        bool1 = false;
      }
      com.tencent.luggage.wxa.ao.a.b(bool1);
      paramInt1 = paramInt3 * 4;
      paramInt2 = (int)d(250000L);
      paramInt2 = this.L * paramInt2;
      paramInt3 = (int)Math.max(paramInt3, d(750000L) * this.L);
      if (paramInt1 < paramInt2) {
        paramInt1 = paramInt2;
      } else if (paramInt1 > paramInt3) {
        paramInt1 = paramInt3;
      }
      this.t = paramInt1;
    }
    long l1;
    if (bool2) {
      l1 = -9223372036854775807L;
    } else {
      l1 = c(this.t / this.L);
    }
    this.u = l1;
    a(this.w);
  }
  
  public boolean a(String paramString)
  {
    c localc = this.c;
    return (localc != null) && (localc.a(b(paramString)));
  }
  
  public boolean a(ByteBuffer paramByteBuffer, long paramLong)
  {
    Object localObject = this.W;
    if ((localObject != null) && (paramByteBuffer != localObject)) {
      bool = false;
    } else {
      bool = true;
    }
    com.tencent.luggage.wxa.ao.a.a(bool);
    if (!r())
    {
      l();
      if (this.ac) {
        a();
      }
    }
    if (v())
    {
      if (this.m.getPlayState() == 2)
      {
        this.af = false;
        return false;
      }
      if ((this.m.getPlayState() == 1) && (this.j.b() != 0L)) {
        return false;
      }
    }
    boolean bool = this.af;
    this.af = e();
    long l1;
    if ((bool) && (!this.af) && (this.m.getPlayState() != 1))
    {
      l1 = SystemClock.elapsedRealtime();
      long l2 = this.ag;
      this.g.a(this.t, com.tencent.luggage.wxa.h.b.a(this.u), l1 - l2);
    }
    if (this.W == null)
    {
      if (!paramByteBuffer.hasRemaining()) {
        return true;
      }
      if ((this.s) && (this.O == 0)) {
        this.O = a(this.q, paramByteBuffer);
      }
      if (this.v != null)
      {
        if (!m()) {
          return false;
        }
        this.k.add(new f.g(this.v, Math.max(0L, paramLong), c(t()), null));
        this.v = null;
        k();
      }
      if (this.P == 0)
      {
        this.Q = Math.max(0L, paramLong);
        this.P = 1;
      }
      else
      {
        l1 = this.Q + c(s());
        if ((this.P == 1) && (Math.abs(l1 - paramLong) > 200000L))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Discontinuity detected [expected ");
          ((StringBuilder)localObject).append(l1);
          ((StringBuilder)localObject).append(", got ");
          ((StringBuilder)localObject).append(paramLong);
          ((StringBuilder)localObject).append("]");
          Log.e("AudioTrack", ((StringBuilder)localObject).toString());
          this.P = 2;
        }
        if (this.P == 2)
        {
          this.Q += paramLong - l1;
          this.P = 1;
          this.g.a();
        }
      }
      if (this.s) {
        this.K += this.O;
      } else {
        this.J += paramByteBuffer.remaining();
      }
      this.W = paramByteBuffer;
    }
    if (this.s) {
      b(this.W, paramLong);
    } else {
      a(paramLong);
    }
    if (!this.W.hasRemaining())
    {
      this.W = null;
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if (this.P == 1) {
      this.P = 2;
    }
  }
  
  public void c()
  {
    if (!this.ab)
    {
      if (!r()) {
        return;
      }
      if (m())
      {
        this.j.a(t());
        this.A = 0;
        this.ab = true;
      }
    }
  }
  
  public boolean d()
  {
    return (!r()) || ((this.ab) && (!e()));
  }
  
  public boolean e()
  {
    return (r()) && ((t() > this.j.b()) || (w()));
  }
  
  public q f()
  {
    return this.w;
  }
  
  public void g()
  {
    if (this.ae)
    {
      this.ae = false;
      this.ad = 0;
      i();
    }
  }
  
  public void h()
  {
    this.ac = false;
    if (r())
    {
      u();
      this.j.a();
    }
  }
  
  public void i()
  {
    if (r())
    {
      this.J = 0L;
      this.K = 0L;
      this.M = 0L;
      this.N = 0L;
      this.O = 0;
      Object localObject = this.v;
      if (localObject != null)
      {
        this.w = ((q)localObject);
        this.v = null;
      }
      else if (!this.k.isEmpty())
      {
        this.w = f.g.a((f.g)this.k.getLast());
      }
      this.k.clear();
      this.x = 0L;
      this.y = 0L;
      this.W = null;
      this.X = null;
      int i1 = 0;
      for (;;)
      {
        localObject = this.U;
        if (i1 >= localObject.length) {
          break;
        }
        localObject = localObject[i1];
        ((d)localObject).g();
        this.V[i1] = ((d)localObject).e();
        i1 += 1;
      }
      this.ab = false;
      this.aa = -1;
      this.z = null;
      this.A = 0;
      this.P = 0;
      this.S = 0L;
      u();
      if (this.m.getPlayState() == 3) {
        this.m.pause();
      }
      localObject = this.m;
      this.m = null;
      this.j.a(null, false);
      this.h.close();
      new f.1(this, (AudioTrack)localObject).start();
    }
  }
  
  public void j()
  {
    i();
    o();
    d[] arrayOfd = this.f;
    int i2 = arrayOfd.length;
    int i1 = 0;
    while (i1 < i2)
    {
      arrayOfd[i1].h();
      i1 += 1;
    }
    this.ad = 0;
    this.ac = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.i.f
 * JD-Core Version:    0.7.0.1
 */