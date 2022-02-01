package com.tencent.luggage.wxa.ap;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import com.tencent.luggage.wxa.ao.j;
import com.tencent.luggage.wxa.ao.v;
import com.tencent.luggage.wxa.ao.x;
import com.tencent.luggage.wxa.h.k;
import com.tencent.luggage.wxa.h.u;
import com.tencent.luggage.wxa.k.a.a;
import com.tencent.luggage.wxa.u.b;
import java.nio.ByteBuffer;
import java.util.List;

@TargetApi(16)
public class e
  extends b
{
  private static final int[] c = { 1920, 1600, 1440, 1280, 960, 854, 640, 540, 480 };
  private float A;
  private int B;
  private int C;
  private int D;
  private float E;
  private boolean F;
  private int G;
  private long H;
  private int I;
  e.b b;
  private final Context d;
  private final f e;
  private final g.a f;
  private final long g;
  private final int h;
  private final boolean i;
  private final long[] j;
  private k[] k;
  private e.a l;
  private boolean m;
  private Surface n;
  private Surface o;
  private int p;
  private boolean q;
  private long r;
  private long s;
  private int t;
  private int u;
  private int v;
  private float w;
  private int x;
  private int y;
  private int z;
  
  public e(Context paramContext, com.tencent.luggage.wxa.u.c paramc, long paramLong, com.tencent.luggage.wxa.k.c<com.tencent.luggage.wxa.k.e> paramc1, boolean paramBoolean, Handler paramHandler, g paramg, int paramInt)
  {
    super(2, paramc, paramc1, paramBoolean);
    this.g = paramLong;
    this.h = paramInt;
    this.d = paramContext.getApplicationContext();
    this.e = new f(paramContext);
    this.f = new g.a(paramHandler, paramg);
    this.i = K();
    this.j = new long[10];
    this.H = -9223372036854775807L;
    this.r = -9223372036854775807L;
    this.x = -1;
    this.y = -1;
    this.A = -1.0F;
    this.w = -1.0F;
    this.p = 1;
    G();
  }
  
  private void F()
  {
    if (this.q) {
      this.f.a(this.n);
    }
  }
  
  private void G()
  {
    this.B = -1;
    this.C = -1;
    this.E = -1.0F;
    this.D = -1;
  }
  
  private void H()
  {
    if (((this.x != -1) || (this.y != -1)) && ((this.B != this.x) || (this.C != this.y) || (this.D != this.z) || (this.E != this.A)))
    {
      this.f.a(this.x, this.y, this.z, this.A);
      this.B = this.x;
      this.C = this.y;
      this.D = this.z;
      this.E = this.A;
    }
  }
  
  private void I()
  {
    if ((this.B != -1) || (this.C != -1)) {
      this.f.a(this.B, this.C, this.D, this.E);
    }
  }
  
  private void J()
  {
    if (this.t > 0)
    {
      long l1 = SystemClock.elapsedRealtime();
      long l2 = this.s;
      this.f.a(this.t, l1 - l2);
      this.t = 0;
      this.s = l1;
    }
  }
  
  private static boolean K()
  {
    return (x.a <= 22) && ("foster".equals(x.b)) && ("NVIDIA".equals(x.c));
  }
  
  private static int a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt1 != -1)
    {
      if (paramInt2 == -1) {
        return -1;
      }
      int i1 = paramString.hashCode();
      int i2 = 4;
      switch (i1)
      {
      default: 
        break;
      case 1599127257: 
        if (paramString.equals("video/x-vnd.on2.vp9")) {
          i1 = 5;
        }
        break;
      case 1599127256: 
        if (paramString.equals("video/x-vnd.on2.vp8")) {
          i1 = 3;
        }
        break;
      case 1331836730: 
        if (paramString.equals("video/avc")) {
          i1 = 2;
        }
        break;
      case 1187890754: 
        if (paramString.equals("video/mp4v-es")) {
          i1 = 1;
        }
        break;
      case -1662541442: 
        if (paramString.equals("video/hevc")) {
          i1 = 4;
        }
        break;
      case -1664118616: 
        if (paramString.equals("video/3gpp")) {
          i1 = 0;
        }
        break;
      }
      i1 = -1;
      if ((i1 != 0) && (i1 != 1)) {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if ((i1 != 4) && (i1 != 5)) {
              return -1;
            }
            paramInt2 = paramInt1 * paramInt2;
            paramInt1 = i2;
            break label256;
          }
        }
        else
        {
          if ("BRAVIA 4K 2015".equals(x.d)) {
            return -1;
          }
          paramInt1 = x.a(paramInt1, 16) * x.a(paramInt2, 16) * 16 * 16;
          break label250;
        }
      }
      paramInt1 *= paramInt2;
      label250:
      i1 = 2;
      paramInt2 = paramInt1;
      paramInt1 = i1;
      label256:
      return paramInt2 * 3 / (paramInt1 * 2);
    }
    return -1;
  }
  
  private static Point a(com.tencent.luggage.wxa.u.a parama, k paramk)
  {
    int i1 = paramk.k;
    int i2 = paramk.j;
    int i4 = 0;
    if (i1 > i2) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0) {
      i2 = paramk.k;
    } else {
      i2 = paramk.j;
    }
    int i3;
    if (i1 != 0) {
      i3 = paramk.j;
    } else {
      i3 = paramk.k;
    }
    float f1 = i3 / i2;
    int[] arrayOfInt = c;
    int i8 = arrayOfInt.length;
    while (i4 < i8)
    {
      int i5 = arrayOfInt[i4];
      int i6 = (int)(i5 * f1);
      if (i5 <= i2) {
        break;
      }
      if (i6 <= i3) {
        return null;
      }
      if (x.a >= 21)
      {
        int i7;
        if (i1 != 0) {
          i7 = i6;
        } else {
          i7 = i5;
        }
        if (i1 == 0) {
          i5 = i6;
        }
        Point localPoint = parama.a(i7, i5);
        float f2 = paramk.l;
        if (parama.a(localPoint.x, localPoint.y, f2)) {
          return localPoint;
        }
      }
      else
      {
        i5 = x.a(i5, 16) * 16;
        i6 = x.a(i6, 16) * 16;
        if (i5 * i6 <= com.tencent.luggage.wxa.u.d.b())
        {
          if (i1 != 0) {
            i2 = i6;
          } else {
            i2 = i5;
          }
          if (i1 != 0) {
            i6 = i5;
          }
          return new Point(i2, i6);
        }
      }
      i4 += 1;
    }
    return null;
  }
  
  private static void a(MediaCodec paramMediaCodec, int paramInt)
  {
    paramMediaCodec.setVideoScalingMode(paramInt);
  }
  
  @TargetApi(23)
  private static void a(MediaCodec paramMediaCodec, Surface paramSurface)
  {
    paramMediaCodec.setOutputSurface(paramSurface);
  }
  
  @TargetApi(21)
  private static void a(MediaFormat paramMediaFormat, int paramInt)
  {
    paramMediaFormat.setFeatureEnabled("tunneled-playback", true);
    paramMediaFormat.setInteger("audio-session-id", paramInt);
  }
  
  private void a(Surface paramSurface)
  {
    Surface localSurface = paramSurface;
    if (paramSurface == null)
    {
      localSurface = this.o;
      if (localSurface == null)
      {
        com.tencent.luggage.wxa.u.a locala = B();
        localSurface = paramSurface;
        if (locala != null)
        {
          localSurface = paramSurface;
          if (b(locala.d))
          {
            this.o = c.a(this.d, locala.d);
            localSurface = this.o;
          }
        }
      }
    }
    if (this.n != localSurface)
    {
      this.n = localSurface;
      int i1 = d();
      if ((i1 == 1) || (i1 == 2))
      {
        paramSurface = A();
        if ((x.a >= 23) && (paramSurface != null) && (localSurface != null) && (!this.m))
        {
          a(paramSurface, localSurface);
        }
        else
        {
          C();
          z();
        }
      }
      if ((localSurface != null) && (localSurface != this.o))
      {
        I();
        x();
        if (i1 == 2) {
          w();
        }
      }
      else
      {
        G();
        x();
      }
    }
    else if ((localSurface != null) && (localSurface != this.o))
    {
      I();
      F();
    }
  }
  
  private static boolean a(String paramString)
  {
    return (("deb".equals(x.b)) || ("flo".equals(x.b))) && (("OMX.qcom.video.decoder.avc".equals(paramString)) || (("tcl_eu".equals(x.b)) && ("OMX.MTK.VIDEO.DECODER.AVC".equals(paramString))));
  }
  
  private static boolean a(boolean paramBoolean, k paramk1, k paramk2)
  {
    return (paramk1.f.equals(paramk2.f)) && (e(paramk1) == e(paramk2)) && ((paramBoolean) || ((paramk1.j == paramk2.j) && (paramk1.k == paramk2.k)));
  }
  
  private boolean b(boolean paramBoolean)
  {
    return (x.a >= 23) && (!this.F) && ((!paramBoolean) || (c.a(this.d)));
  }
  
  private static int c(k paramk)
  {
    if (paramk.g != -1)
    {
      int i3 = paramk.h.size();
      int i1 = 0;
      int i2 = 0;
      while (i1 < i3)
      {
        i2 += ((byte[])paramk.h.get(i1)).length;
        i1 += 1;
      }
      return paramk.g + i2;
    }
    return a(paramk.f, paramk.j, paramk.k);
  }
  
  private static float d(k paramk)
  {
    if (paramk.n == -1.0F) {
      return 1.0F;
    }
    return paramk.n;
  }
  
  private static boolean d(long paramLong)
  {
    return paramLong < -30000L;
  }
  
  private static int e(k paramk)
  {
    if (paramk.m == -1) {
      return 0;
    }
    return paramk.m;
  }
  
  private void w()
  {
    long l1;
    if (this.g > 0L) {
      l1 = SystemClock.elapsedRealtime() + this.g;
    } else {
      l1 = -9223372036854775807L;
    }
    this.r = l1;
  }
  
  private void x()
  {
    this.q = false;
    if ((x.a >= 23) && (this.F))
    {
      MediaCodec localMediaCodec = A();
      if (localMediaCodec != null) {
        this.b = new e.b(this, localMediaCodec, null);
      }
    }
  }
  
  protected void C()
  {
    try
    {
      super.C();
      Surface localSurface1;
      return;
    }
    finally
    {
      Surface localSurface2 = this.o;
      if (localSurface2 != null)
      {
        if (this.n == localSurface2) {
          this.n = null;
        }
        this.o.release();
        this.o = null;
      }
    }
  }
  
  protected int a(com.tencent.luggage.wxa.u.c paramc, k paramk)
  {
    Object localObject = paramk.f;
    boolean bool1 = j.b((String)localObject);
    int i2 = 0;
    if (!bool1) {
      return 0;
    }
    com.tencent.luggage.wxa.k.a locala = paramk.i;
    int i1;
    if (locala != null)
    {
      i1 = 0;
      bool1 = false;
      for (;;)
      {
        bool2 = bool1;
        if (i1 >= locala.a) {
          break;
        }
        bool1 |= locala.a(i1).d;
        i1 += 1;
      }
    }
    boolean bool2 = false;
    paramc = paramc.a((String)localObject, bool2);
    if (paramc == null) {
      return 1;
    }
    bool2 = paramc.b(paramk.c);
    bool1 = bool2;
    if (bool2)
    {
      bool1 = bool2;
      if (paramk.j > 0)
      {
        bool1 = bool2;
        if (paramk.k > 0) {
          if (x.a >= 21)
          {
            bool1 = paramc.a(paramk.j, paramk.k, paramk.l);
          }
          else
          {
            if (paramk.j * paramk.k <= com.tencent.luggage.wxa.u.d.b()) {
              bool2 = true;
            } else {
              bool2 = false;
            }
            bool1 = bool2;
            if (!bool2)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("FalseCheck [legacyFrameSize, ");
              ((StringBuilder)localObject).append(paramk.j);
              ((StringBuilder)localObject).append("x");
              ((StringBuilder)localObject).append(paramk.k);
              ((StringBuilder)localObject).append("] [");
              ((StringBuilder)localObject).append(x.e);
              ((StringBuilder)localObject).append("]");
              Log.d("MediaCodecVideoRenderer", ((StringBuilder)localObject).toString());
              bool1 = bool2;
            }
          }
        }
      }
    }
    if (paramc.b) {
      i1 = 16;
    } else {
      i1 = 8;
    }
    if (paramc.c) {
      i2 = 32;
    }
    int i3;
    if (bool1) {
      i3 = 4;
    } else {
      i3 = 3;
    }
    return i3 | i1 | i2;
  }
  
  @SuppressLint({"InlinedApi"})
  protected MediaFormat a(k paramk, e.a parama, boolean paramBoolean, int paramInt)
  {
    paramk = paramk.b();
    paramk.setInteger("max-width", parama.a);
    paramk.setInteger("max-height", parama.b);
    if (parama.c != -1) {
      paramk.setInteger("max-input-size", parama.c);
    }
    if (paramBoolean) {
      paramk.setInteger("auto-frc", 0);
    }
    if (paramInt != 0) {
      a(paramk, paramInt);
    }
    return paramk;
  }
  
  protected e.a a(com.tencent.luggage.wxa.u.a parama, k paramk, k[] paramArrayOfk)
  {
    int i3 = paramk.j;
    int i2 = paramk.k;
    int i1 = c(paramk);
    if (paramArrayOfk.length == 1) {
      return new e.a(i3, i2, i1);
    }
    int i10 = paramArrayOfk.length;
    int i5 = 0;
    int i4 = 0;
    while (i4 < i10)
    {
      k localk = paramArrayOfk[i4];
      int i9 = i5;
      int i8 = i3;
      i7 = i2;
      i6 = i1;
      if (a(parama.b, paramk, localk))
      {
        if ((localk.j != -1) && (localk.k != -1)) {
          i6 = 0;
        } else {
          i6 = 1;
        }
        i9 = i5 | i6;
        i8 = Math.max(i3, localk.j);
        i7 = Math.max(i2, localk.k);
        i6 = Math.max(i1, c(localk));
      }
      i4 += 1;
      i5 = i9;
      i3 = i8;
      i2 = i7;
      i1 = i6;
    }
    int i7 = i3;
    int i6 = i2;
    i4 = i1;
    if (i5 != 0)
    {
      paramArrayOfk = new StringBuilder();
      paramArrayOfk.append("Resolutions unknown. Codec max resolution: ");
      paramArrayOfk.append(i3);
      paramArrayOfk.append("x");
      paramArrayOfk.append(i2);
      Log.w("MediaCodecVideoRenderer", paramArrayOfk.toString());
      parama = a(parama, paramk);
      i7 = i3;
      i6 = i2;
      i4 = i1;
      if (parama != null)
      {
        i7 = Math.max(i3, parama.x);
        i6 = Math.max(i2, parama.y);
        i4 = Math.max(i1, a(paramk.f, i7, i6));
        parama = new StringBuilder();
        parama.append("Codec max resolution adjusted to: ");
        parama.append(i7);
        parama.append("x");
        parama.append(i6);
        Log.w("MediaCodecVideoRenderer", parama.toString());
      }
    }
    return new e.a(i7, i6, i4);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (paramInt == 1)
    {
      a((Surface)paramObject);
      return;
    }
    if (paramInt == 4)
    {
      this.p = ((Integer)paramObject).intValue();
      paramObject = A();
      if (paramObject != null) {
        a(paramObject, this.p);
      }
    }
    else
    {
      super.a(paramInt, paramObject);
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean)
  {
    super.a(paramLong, paramBoolean);
    x();
    this.u = 0;
    int i1 = this.I;
    if (i1 != 0)
    {
      this.H = this.j[(i1 - 1)];
      this.I = 0;
    }
    if (paramBoolean)
    {
      w();
      return;
    }
    this.r = -9223372036854775807L;
  }
  
  protected void a(MediaCodec paramMediaCodec, int paramInt, long paramLong)
  {
    v.a("skipVideoBuffer");
    paramMediaCodec.releaseOutputBuffer(paramInt, false);
    v.a();
    paramMediaCodec = this.a;
    paramMediaCodec.e += 1;
  }
  
  @TargetApi(21)
  protected void a(MediaCodec paramMediaCodec, int paramInt, long paramLong1, long paramLong2)
  {
    H();
    v.a("releaseOutputBuffer");
    paramMediaCodec.releaseOutputBuffer(paramInt, paramLong2);
    v.a();
    paramMediaCodec = this.a;
    paramMediaCodec.d += 1;
    this.u = 0;
    v();
  }
  
  protected void a(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    int i1;
    if ((paramMediaFormat.containsKey("crop-right")) && (paramMediaFormat.containsKey("crop-left")) && (paramMediaFormat.containsKey("crop-bottom")) && (paramMediaFormat.containsKey("crop-top"))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2;
    if (i1 != 0) {
      i2 = paramMediaFormat.getInteger("crop-right") - paramMediaFormat.getInteger("crop-left") + 1;
    } else {
      i2 = paramMediaFormat.getInteger("width");
    }
    this.x = i2;
    if (i1 != 0) {
      i1 = paramMediaFormat.getInteger("crop-bottom") - paramMediaFormat.getInteger("crop-top") + 1;
    } else {
      i1 = paramMediaFormat.getInteger("height");
    }
    this.y = i1;
    this.A = this.w;
    if (x.a >= 21)
    {
      i1 = this.v;
      if ((i1 == 90) || (i1 == 270))
      {
        i1 = this.x;
        this.x = this.y;
        this.y = i1;
        this.A = (1.0F / this.A);
      }
    }
    else
    {
      this.z = this.v;
    }
    a(paramMediaCodec, this.p);
  }
  
  protected void a(com.tencent.luggage.wxa.j.e parame)
  {
    if ((x.a < 23) && (this.F)) {
      v();
    }
  }
  
  protected void a(com.tencent.luggage.wxa.u.a parama, MediaCodec paramMediaCodec, k paramk, MediaCrypto paramMediaCrypto)
  {
    this.l = a(parama, paramk, this.k);
    paramk = a(paramk, this.l, this.i, this.G);
    if (this.n == null)
    {
      com.tencent.luggage.wxa.ao.a.b(b(parama.d));
      if (this.o == null) {
        this.o = c.a(this.d, parama.d);
      }
      this.n = this.o;
    }
    paramMediaCodec.configure(paramk, this.n, paramMediaCrypto, 0);
    if ((x.a >= 23) && (this.F)) {
      this.b = new e.b(this, paramMediaCodec, null);
    }
  }
  
  protected void a(String paramString, long paramLong1, long paramLong2)
  {
    this.f.a(paramString, paramLong1, paramLong2);
    this.m = a(paramString);
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    this.G = q().b;
    if (this.G != 0) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    this.F = paramBoolean;
    this.f.a(this.a);
    this.e.a();
  }
  
  protected void a(k[] paramArrayOfk, long paramLong)
  {
    this.k = paramArrayOfk;
    if (this.H == -9223372036854775807L)
    {
      this.H = paramLong;
    }
    else
    {
      int i1 = this.I;
      if (i1 == this.j.length)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Too many stream changes, so dropping offset: ");
        localStringBuilder.append(this.j[(this.I - 1)]);
        Log.w("MediaCodecVideoRenderer", localStringBuilder.toString());
      }
      else
      {
        this.I = (i1 + 1);
      }
      this.j[(this.I - 1)] = paramLong;
    }
    super.a(paramArrayOfk, paramLong);
  }
  
  protected boolean a(long paramLong1, long paramLong2, MediaCodec paramMediaCodec, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, long paramLong3, boolean paramBoolean)
  {
    for (;;)
    {
      paramInt2 = this.I;
      if (paramInt2 == 0) {
        break;
      }
      paramByteBuffer = this.j;
      if (paramLong3 < paramByteBuffer[0]) {
        break;
      }
      this.H = paramByteBuffer[0];
      this.I = (paramInt2 - 1);
      System.arraycopy(paramByteBuffer, 1, paramByteBuffer, 0, this.I);
    }
    long l1 = paramLong3 - this.H;
    if (paramBoolean)
    {
      a(paramMediaCodec, paramInt1, l1);
      return true;
    }
    long l2 = paramLong3 - paramLong1;
    if (this.n == this.o)
    {
      if (d(l2))
      {
        a(paramMediaCodec, paramInt1, l1);
        return true;
      }
      return false;
    }
    if (!this.q)
    {
      if (x.a >= 21)
      {
        a(paramMediaCodec, paramInt1, l1, System.nanoTime());
        return true;
      }
      c(paramMediaCodec, paramInt1, l1);
      return true;
    }
    if (d() != 2) {
      return false;
    }
    long l3 = SystemClock.elapsedRealtime();
    paramLong1 = System.nanoTime();
    paramLong3 = this.e.a(paramLong3, (l2 - (l3 * 1000L - paramLong2)) * 1000L + paramLong1);
    paramLong1 = (paramLong3 - paramLong1) / 1000L;
    if (b(paramLong1, paramLong2))
    {
      b(paramMediaCodec, paramInt1, l1);
      return true;
    }
    if (x.a >= 21)
    {
      if (paramLong1 < 50000L)
      {
        a(paramMediaCodec, paramInt1, l1, paramLong3);
        return true;
      }
    }
    else if ((paramLong1 < 30000L) && (paramLong1 <= 11000L)) {}
    try
    {
      Thread.sleep((paramLong1 - 10000L) / 1000L);
    }
    catch (InterruptedException paramByteBuffer)
    {
      label304:
      break label304;
    }
    Thread.currentThread().interrupt();
    c(paramMediaCodec, paramInt1, l1);
    return true;
    return false;
  }
  
  protected boolean a(MediaCodec paramMediaCodec, boolean paramBoolean, k paramk1, k paramk2)
  {
    return (a(paramBoolean, paramk1, paramk2)) && (paramk2.j <= this.l.a) && (paramk2.k <= this.l.b) && (c(paramk2) <= this.l.c);
  }
  
  protected boolean a(com.tencent.luggage.wxa.u.a parama)
  {
    return (this.n != null) || (b(parama.d));
  }
  
  protected void b(MediaCodec paramMediaCodec, int paramInt, long paramLong)
  {
    v.a("dropVideoBuffer");
    paramMediaCodec.releaseOutputBuffer(paramInt, false);
    v.a();
    paramMediaCodec = this.a;
    paramMediaCodec.f += 1;
    this.t += 1;
    this.u += 1;
    this.a.g = Math.max(this.u, this.a.g);
    if (this.t == this.h) {
      J();
    }
  }
  
  protected void b(k paramk)
  {
    super.b(paramk);
    this.f.a(paramk);
    this.w = d(paramk);
    this.v = e(paramk);
  }
  
  protected boolean b(long paramLong1, long paramLong2)
  {
    return d(paramLong1);
  }
  
  protected void c(MediaCodec paramMediaCodec, int paramInt, long paramLong)
  {
    H();
    v.a("releaseOutputBuffer");
    paramMediaCodec.releaseOutputBuffer(paramInt, true);
    v.a();
    paramMediaCodec = this.a;
    paramMediaCodec.d += 1;
    this.u = 0;
    v();
  }
  
  protected void n()
  {
    super.n();
    this.t = 0;
    this.s = SystemClock.elapsedRealtime();
  }
  
  protected void o()
  {
    this.r = -9223372036854775807L;
    J();
    super.o();
  }
  
  protected void p()
  {
    this.x = -1;
    this.y = -1;
    this.A = -1.0F;
    this.w = -1.0F;
    this.H = -9223372036854775807L;
    this.I = 0;
    G();
    x();
    this.e.b();
    this.b = null;
    this.F = false;
    try
    {
      super.p();
      return;
    }
    finally
    {
      this.a.a();
      this.f.b(this.a);
    }
  }
  
  public boolean t()
  {
    if (super.t()) {
      if (!this.q)
      {
        Surface localSurface = this.o;
        if (((localSurface == null) || (this.n != localSurface)) && (A() != null) && (!this.F)) {}
      }
      else
      {
        this.r = -9223372036854775807L;
        return true;
      }
    }
    if (this.r == -9223372036854775807L) {
      return false;
    }
    if (SystemClock.elapsedRealtime() < this.r) {
      return true;
    }
    this.r = -9223372036854775807L;
    return false;
  }
  
  void v()
  {
    if (!this.q)
    {
      this.q = true;
      this.f.a(this.n);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ap.e
 * JD-Core Version:    0.7.0.1
 */