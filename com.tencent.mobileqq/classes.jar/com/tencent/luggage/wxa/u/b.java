package com.tencent.luggage.wxa.u;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CryptoException;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.ao.v;
import com.tencent.luggage.wxa.ao.x;
import com.tencent.luggage.wxa.h.l;
import com.tencent.luggage.wxa.j.d;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
public abstract class b
  extends com.tencent.luggage.wxa.h.a
{
  private static final byte[] b = x.g("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
  private long A;
  private int B;
  private int C;
  private boolean D;
  private boolean E;
  private int F;
  private int G;
  private boolean H;
  private boolean I;
  private boolean J;
  private boolean K;
  private boolean L;
  private boolean M;
  protected d a;
  private final c c;
  private final com.tencent.luggage.wxa.k.c<com.tencent.luggage.wxa.k.e> d;
  private final boolean e;
  private final com.tencent.luggage.wxa.j.e f;
  private final com.tencent.luggage.wxa.j.e g;
  private final l h;
  private final List<Long> i;
  private final MediaCodec.BufferInfo j;
  private com.tencent.luggage.wxa.h.k k;
  private com.tencent.luggage.wxa.k.b<com.tencent.luggage.wxa.k.e> l;
  private com.tencent.luggage.wxa.k.b<com.tencent.luggage.wxa.k.e> m;
  private MediaCodec n;
  private a o;
  private int p;
  private boolean q;
  private boolean r;
  private boolean s;
  private boolean t;
  private boolean u;
  private boolean v;
  private boolean w;
  private boolean x;
  private ByteBuffer[] y;
  private ByteBuffer[] z;
  
  public b(int paramInt, c paramc, com.tencent.luggage.wxa.k.c<com.tencent.luggage.wxa.k.e> paramc1, boolean paramBoolean)
  {
    super(paramInt);
    boolean bool;
    if (x.a >= 16) {
      bool = true;
    } else {
      bool = false;
    }
    com.tencent.luggage.wxa.ao.a.b(bool);
    this.c = ((c)com.tencent.luggage.wxa.ao.a.a(paramc));
    this.d = paramc1;
    this.e = paramBoolean;
    this.f = new com.tencent.luggage.wxa.j.e(0);
    this.g = com.tencent.luggage.wxa.j.e.e();
    this.h = new l();
    this.i = new ArrayList();
    this.j = new MediaCodec.BufferInfo();
    this.F = 0;
    this.G = 0;
  }
  
  private void F()
  {
    if (this.G == 2)
    {
      C();
      z();
      return;
    }
    this.K = true;
    y();
  }
  
  private static MediaCodec.CryptoInfo a(com.tencent.luggage.wxa.j.e parame, int paramInt)
  {
    parame = parame.a.a();
    if (paramInt == 0) {
      return parame;
    }
    if (parame.numBytesOfClearData == null) {
      parame.numBytesOfClearData = new int[1];
    }
    int[] arrayOfInt = parame.numBytesOfClearData;
    arrayOfInt[0] += paramInt;
    return parame;
  }
  
  private void a(b.a parama)
  {
    throw com.tencent.luggage.wxa.h.e.a(parama, r());
  }
  
  private static boolean a(com.tencent.luggage.wxa.k.c paramc, @Nullable com.tencent.luggage.wxa.k.a parama)
  {
    if (parama == null) {
      return true;
    }
    if (paramc == null) {
      return false;
    }
    return paramc.a(parama);
  }
  
  private static boolean a(String paramString)
  {
    return (x.a < 18) || ((x.a == 18) && (("OMX.SEC.avc.dec".equals(paramString)) || ("OMX.SEC.avc.dec.secure".equals(paramString)))) || ((x.a == 19) && (x.d.startsWith("SM-G800")) && (("OMX.Exynos.avc.dec".equals(paramString)) || ("OMX.Exynos.avc.dec.secure".equals(paramString))));
  }
  
  private static boolean a(String paramString, com.tencent.luggage.wxa.h.k paramk)
  {
    return (x.a < 21) && (paramk.h.isEmpty()) && ("OMX.MTK.VIDEO.DECODER.AVC".equals(paramString));
  }
  
  private int b(String paramString)
  {
    if ((x.a <= 24) && ("OMX.Exynos.avc.dec.secure".equals(paramString)) && ((x.d.startsWith("SM-T585")) || (x.d.startsWith("SM-A520")))) {
      return 2;
    }
    if ((x.a < 24) && (("OMX.Nvidia.h264.decode".equals(paramString)) || ("OMX.Nvidia.h264.decode.secure".equals(paramString))) && (("flounder".equals(x.b)) || ("flounder_lte".equals(x.b)) || ("grouper".equals(x.b)) || ("tilapia".equals(x.b)))) {
      return 1;
    }
    return 0;
  }
  
  private boolean b(long paramLong1, long paramLong2)
  {
    if ((this.C >= 0) || ((this.u) && (this.I))) {}
    try
    {
      this.C = this.n.dequeueOutputBuffer(this.j, E());
    }
    catch (IllegalStateException localIllegalStateException1)
    {
      label43:
      int i1;
      Object localObject;
      break label43;
    }
    F();
    if (this.K) {
      C();
    }
    return false;
    this.C = this.n.dequeueOutputBuffer(this.j, E());
    i1 = this.C;
    if (i1 >= 0)
    {
      if (this.x)
      {
        this.x = false;
        this.n.releaseOutputBuffer(i1, false);
        this.C = -1;
        return true;
      }
      if ((this.j.flags & 0x4) != 0)
      {
        F();
        this.C = -1;
        return false;
      }
      localObject = this.z[this.C];
      if (localObject != null)
      {
        ((ByteBuffer)localObject).position(this.j.offset);
        ((ByteBuffer)localObject).limit(this.j.offset + this.j.size);
      }
      this.D = d(this.j.presentationTimeUs);
    }
    else
    {
      if (i1 == -2)
      {
        w();
        return true;
      }
      if (i1 == -3)
      {
        x();
        return true;
      }
      if ((this.s) && ((this.J) || (this.G == 2))) {
        F();
      }
      return false;
    }
    if ((this.u) && (this.I)) {}
    try
    {
      bool = a(paramLong1, paramLong2, this.n, this.z[this.C], this.C, this.j.flags, this.j.presentationTimeUs, this.D);
    }
    catch (IllegalStateException localIllegalStateException2)
    {
      boolean bool;
      label324:
      ByteBuffer[] arrayOfByteBuffer;
      break label324;
    }
    F();
    if (this.K) {
      C();
    }
    return false;
    localObject = this.n;
    arrayOfByteBuffer = this.z;
    i1 = this.C;
    bool = a(paramLong1, paramLong2, (MediaCodec)localObject, arrayOfByteBuffer[i1], i1, this.j.flags, this.j.presentationTimeUs, this.D);
    if (bool)
    {
      c(this.j.presentationTimeUs);
      this.C = -1;
      return true;
    }
    return false;
  }
  
  private static boolean b(String paramString, com.tencent.luggage.wxa.h.k paramk)
  {
    return (x.a <= 18) && (paramk.r == 1) && ("OMX.MTK.AUDIO.DECODER.MP3".equals(paramString));
  }
  
  private boolean b(boolean paramBoolean)
  {
    if (this.l != null)
    {
      if ((!paramBoolean) && (this.e)) {
        return false;
      }
      int i1 = this.l.a();
      if (i1 != 1) {
        return i1 != 4;
      }
      throw com.tencent.luggage.wxa.h.e.a(this.l.b(), r());
    }
    return false;
  }
  
  private static boolean c(String paramString)
  {
    return (x.a <= 17) && (("OMX.rk.video_decoder.avc".equals(paramString)) || ("OMX.allwinner.video.decoder.avc".equals(paramString)));
  }
  
  private boolean d(long paramLong)
  {
    int i2 = this.i.size();
    int i1 = 0;
    while (i1 < i2)
    {
      if (((Long)this.i.get(i1)).longValue() == paramLong)
      {
        this.i.remove(i1);
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  private static boolean d(String paramString)
  {
    return ((x.a <= 23) && ("OMX.google.vorbis.decoder".equals(paramString))) || ((x.a <= 19) && ("hb2000".equals(x.b)) && (("OMX.amlogic.avc.decoder.awesome".equals(paramString)) || ("OMX.amlogic.avc.decoder.awesome.secure".equals(paramString))));
  }
  
  private static boolean e(String paramString)
  {
    return (x.a == 21) && ("OMX.google.aac.decoder".equals(paramString));
  }
  
  private boolean v()
  {
    Object localObject1 = this.n;
    if ((localObject1 != null) && (this.G != 2))
    {
      if (this.J) {
        return false;
      }
      int i1;
      if (this.B < 0)
      {
        this.B = ((MediaCodec)localObject1).dequeueInputBuffer(0L);
        i1 = this.B;
        if (i1 < 0) {
          return false;
        }
        localObject1 = this.f;
        ((com.tencent.luggage.wxa.j.e)localObject1).b = this.y[i1];
        ((com.tencent.luggage.wxa.j.e)localObject1).a();
      }
      if (this.G == 1)
      {
        if (!this.s)
        {
          this.I = true;
          this.n.queueInputBuffer(this.B, 0, 0, 0L, 4);
          this.B = -1;
        }
        this.G = 2;
        return false;
      }
      if (this.w)
      {
        this.w = false;
        this.f.b.put(b);
        this.n.queueInputBuffer(this.B, 0, b.length, 0L, 0);
        this.B = -1;
        this.H = true;
        return true;
      }
      int i2;
      if (this.L)
      {
        i2 = -4;
        i1 = 0;
      }
      else
      {
        if (this.F == 1)
        {
          i1 = 0;
          while (i1 < this.k.h.size())
          {
            localObject1 = (byte[])this.k.h.get(i1);
            this.f.b.put((byte[])localObject1);
            i1 += 1;
          }
          this.F = 2;
        }
        i1 = this.f.b.position();
        i2 = a(this.h, this.f, false);
      }
      if (i2 == -3) {
        return false;
      }
      if (i2 == -5)
      {
        if (this.F == 2)
        {
          this.f.a();
          this.F = 1;
        }
        b(this.h.a);
        return true;
      }
      if (this.f.c())
      {
        if (this.F == 2)
        {
          this.f.a();
          this.F = 1;
        }
        this.J = true;
        if (!this.H)
        {
          F();
          return false;
        }
        try
        {
          if (this.s) {
            return false;
          }
          this.I = true;
          this.n.queueInputBuffer(this.B, 0, 0, 0L, 4);
          this.B = -1;
          return false;
        }
        catch (MediaCodec.CryptoException localCryptoException1)
        {
          throw com.tencent.luggage.wxa.h.e.a(localCryptoException1, r());
        }
      }
      if ((this.M) && (!this.f.d()))
      {
        this.f.a();
        if (this.F == 2) {
          this.F = 1;
        }
        return true;
      }
      this.M = false;
      boolean bool = this.f.g();
      this.L = b(bool);
      if (this.L) {
        return false;
      }
      if ((this.q) && (!bool))
      {
        com.tencent.luggage.wxa.ao.k.a(this.f.b);
        if (this.f.b.position() == 0) {
          return true;
        }
        this.q = false;
      }
      try
      {
        long l1 = this.f.c;
        if (this.f.e_()) {
          this.i.add(Long.valueOf(l1));
        }
        this.f.h();
        a(this.f);
        if (bool)
        {
          localObject2 = a(this.f, i1);
          this.n.queueSecureInputBuffer(this.B, 0, (MediaCodec.CryptoInfo)localObject2, l1, 0);
        }
        else
        {
          this.n.queueInputBuffer(this.B, 0, this.f.b.limit(), l1, 0);
        }
        this.B = -1;
        this.H = true;
        this.F = 0;
        Object localObject2 = this.a;
        ((d)localObject2).c += 1;
        return true;
      }
      catch (MediaCodec.CryptoException localCryptoException2)
      {
        throw com.tencent.luggage.wxa.h.e.a(localCryptoException2, r());
      }
    }
    return false;
  }
  
  private void w()
  {
    MediaFormat localMediaFormat = this.n.getOutputFormat();
    if ((this.p != 0) && (localMediaFormat.getInteger("width") == 32) && (localMediaFormat.getInteger("height") == 32))
    {
      this.x = true;
      return;
    }
    if (this.v) {
      localMediaFormat.setInteger("channel-count", 1);
    }
    a(this.n, localMediaFormat);
  }
  
  private void x()
  {
    this.z = this.n.getOutputBuffers();
  }
  
  protected final MediaCodec A()
  {
    return this.n;
  }
  
  protected final a B()
  {
    return this.o;
  }
  
  /* Error */
  protected void C()
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc2_w 462
    //   4: putfield 465	com/tencent/luggage/wxa/u/b:A	J
    //   7: aload_0
    //   8: iconst_m1
    //   9: putfield 341	com/tencent/luggage/wxa/u/b:B	I
    //   12: aload_0
    //   13: iconst_m1
    //   14: putfield 230	com/tencent/luggage/wxa/u/b:C	I
    //   17: aload_0
    //   18: iconst_0
    //   19: putfield 366	com/tencent/luggage/wxa/u/b:L	Z
    //   22: aload_0
    //   23: iconst_0
    //   24: putfield 281	com/tencent/luggage/wxa/u/b:D	Z
    //   27: aload_0
    //   28: getfield 119	com/tencent/luggage/wxa/u/b:i	Ljava/util/List;
    //   31: invokeinterface 468 1 0
    //   36: aload_0
    //   37: aconst_null
    //   38: putfield 347	com/tencent/luggage/wxa/u/b:y	[Ljava/nio/ByteBuffer;
    //   41: aload_0
    //   42: aconst_null
    //   43: putfield 258	com/tencent/luggage/wxa/u/b:z	[Ljava/nio/ByteBuffer;
    //   46: aload_0
    //   47: aconst_null
    //   48: putfield 461	com/tencent/luggage/wxa/u/b:o	Lcom/tencent/luggage/wxa/u/a;
    //   51: aload_0
    //   52: iconst_0
    //   53: putfield 470	com/tencent/luggage/wxa/u/b:E	Z
    //   56: aload_0
    //   57: iconst_0
    //   58: putfield 364	com/tencent/luggage/wxa/u/b:H	Z
    //   61: aload_0
    //   62: iconst_0
    //   63: putfield 391	com/tencent/luggage/wxa/u/b:q	Z
    //   66: aload_0
    //   67: iconst_0
    //   68: putfield 472	com/tencent/luggage/wxa/u/b:r	Z
    //   71: aload_0
    //   72: iconst_0
    //   73: putfield 433	com/tencent/luggage/wxa/u/b:p	I
    //   76: aload_0
    //   77: iconst_0
    //   78: putfield 287	com/tencent/luggage/wxa/u/b:s	Z
    //   81: aload_0
    //   82: iconst_0
    //   83: putfield 474	com/tencent/luggage/wxa/u/b:t	Z
    //   86: aload_0
    //   87: iconst_0
    //   88: putfield 444	com/tencent/luggage/wxa/u/b:v	Z
    //   91: aload_0
    //   92: iconst_0
    //   93: putfield 358	com/tencent/luggage/wxa/u/b:w	Z
    //   96: aload_0
    //   97: iconst_0
    //   98: putfield 249	com/tencent/luggage/wxa/u/b:x	Z
    //   101: aload_0
    //   102: iconst_0
    //   103: putfield 234	com/tencent/luggage/wxa/u/b:I	Z
    //   106: aload_0
    //   107: iconst_0
    //   108: putfield 126	com/tencent/luggage/wxa/u/b:F	I
    //   111: aload_0
    //   112: iconst_0
    //   113: putfield 128	com/tencent/luggage/wxa/u/b:G	I
    //   116: aload_0
    //   117: getfield 103	com/tencent/luggage/wxa/u/b:f	Lcom/tencent/luggage/wxa/j/e;
    //   120: aconst_null
    //   121: putfield 350	com/tencent/luggage/wxa/j/e:b	Ljava/nio/ByteBuffer;
    //   124: aload_0
    //   125: getfield 236	com/tencent/luggage/wxa/u/b:n	Landroid/media/MediaCodec;
    //   128: ifnull +238 -> 366
    //   131: aload_0
    //   132: getfield 423	com/tencent/luggage/wxa/u/b:a	Lcom/tencent/luggage/wxa/j/d;
    //   135: astore_1
    //   136: aload_1
    //   137: aload_1
    //   138: getfield 476	com/tencent/luggage/wxa/j/d:b	I
    //   141: iconst_1
    //   142: iadd
    //   143: putfield 476	com/tencent/luggage/wxa/j/d:b	I
    //   146: aload_0
    //   147: getfield 236	com/tencent/luggage/wxa/u/b:n	Landroid/media/MediaCodec;
    //   150: invokevirtual 479	android/media/MediaCodec:stop	()V
    //   153: aload_0
    //   154: getfield 236	com/tencent/luggage/wxa/u/b:n	Landroid/media/MediaCodec;
    //   157: invokevirtual 482	android/media/MediaCodec:release	()V
    //   160: aload_0
    //   161: aconst_null
    //   162: putfield 236	com/tencent/luggage/wxa/u/b:n	Landroid/media/MediaCodec;
    //   165: aload_0
    //   166: getfield 302	com/tencent/luggage/wxa/u/b:l	Lcom/tencent/luggage/wxa/k/b;
    //   169: astore_1
    //   170: aload_1
    //   171: ifnull +195 -> 366
    //   174: aload_0
    //   175: getfield 484	com/tencent/luggage/wxa/u/b:m	Lcom/tencent/luggage/wxa/k/b;
    //   178: aload_1
    //   179: if_acmpeq +187 -> 366
    //   182: aload_0
    //   183: getfield 96	com/tencent/luggage/wxa/u/b:d	Lcom/tencent/luggage/wxa/k/c;
    //   186: aload_1
    //   187: invokeinterface 487 2 0
    //   192: aload_0
    //   193: aconst_null
    //   194: putfield 302	com/tencent/luggage/wxa/u/b:l	Lcom/tencent/luggage/wxa/k/b;
    //   197: return
    //   198: astore_1
    //   199: aload_0
    //   200: aconst_null
    //   201: putfield 302	com/tencent/luggage/wxa/u/b:l	Lcom/tencent/luggage/wxa/k/b;
    //   204: aload_1
    //   205: athrow
    //   206: astore_1
    //   207: aload_0
    //   208: aconst_null
    //   209: putfield 236	com/tencent/luggage/wxa/u/b:n	Landroid/media/MediaCodec;
    //   212: aload_0
    //   213: getfield 302	com/tencent/luggage/wxa/u/b:l	Lcom/tencent/luggage/wxa/k/b;
    //   216: astore_2
    //   217: aload_2
    //   218: ifnull +37 -> 255
    //   221: aload_0
    //   222: getfield 484	com/tencent/luggage/wxa/u/b:m	Lcom/tencent/luggage/wxa/k/b;
    //   225: aload_2
    //   226: if_acmpeq +29 -> 255
    //   229: aload_0
    //   230: getfield 96	com/tencent/luggage/wxa/u/b:d	Lcom/tencent/luggage/wxa/k/c;
    //   233: aload_2
    //   234: invokeinterface 487 2 0
    //   239: aload_0
    //   240: aconst_null
    //   241: putfield 302	com/tencent/luggage/wxa/u/b:l	Lcom/tencent/luggage/wxa/k/b;
    //   244: goto +11 -> 255
    //   247: astore_1
    //   248: aload_0
    //   249: aconst_null
    //   250: putfield 302	com/tencent/luggage/wxa/u/b:l	Lcom/tencent/luggage/wxa/k/b;
    //   253: aload_1
    //   254: athrow
    //   255: aload_1
    //   256: athrow
    //   257: astore_1
    //   258: aload_0
    //   259: getfield 236	com/tencent/luggage/wxa/u/b:n	Landroid/media/MediaCodec;
    //   262: invokevirtual 482	android/media/MediaCodec:release	()V
    //   265: aload_0
    //   266: aconst_null
    //   267: putfield 236	com/tencent/luggage/wxa/u/b:n	Landroid/media/MediaCodec;
    //   270: aload_0
    //   271: getfield 302	com/tencent/luggage/wxa/u/b:l	Lcom/tencent/luggage/wxa/k/b;
    //   274: astore_2
    //   275: aload_2
    //   276: ifnull +37 -> 313
    //   279: aload_0
    //   280: getfield 484	com/tencent/luggage/wxa/u/b:m	Lcom/tencent/luggage/wxa/k/b;
    //   283: aload_2
    //   284: if_acmpeq +29 -> 313
    //   287: aload_0
    //   288: getfield 96	com/tencent/luggage/wxa/u/b:d	Lcom/tencent/luggage/wxa/k/c;
    //   291: aload_2
    //   292: invokeinterface 487 2 0
    //   297: aload_0
    //   298: aconst_null
    //   299: putfield 302	com/tencent/luggage/wxa/u/b:l	Lcom/tencent/luggage/wxa/k/b;
    //   302: goto +11 -> 313
    //   305: astore_1
    //   306: aload_0
    //   307: aconst_null
    //   308: putfield 302	com/tencent/luggage/wxa/u/b:l	Lcom/tencent/luggage/wxa/k/b;
    //   311: aload_1
    //   312: athrow
    //   313: aload_1
    //   314: athrow
    //   315: astore_1
    //   316: aload_0
    //   317: aconst_null
    //   318: putfield 236	com/tencent/luggage/wxa/u/b:n	Landroid/media/MediaCodec;
    //   321: aload_0
    //   322: getfield 302	com/tencent/luggage/wxa/u/b:l	Lcom/tencent/luggage/wxa/k/b;
    //   325: astore_2
    //   326: aload_2
    //   327: ifnull +37 -> 364
    //   330: aload_0
    //   331: getfield 484	com/tencent/luggage/wxa/u/b:m	Lcom/tencent/luggage/wxa/k/b;
    //   334: aload_2
    //   335: if_acmpeq +29 -> 364
    //   338: aload_0
    //   339: getfield 96	com/tencent/luggage/wxa/u/b:d	Lcom/tencent/luggage/wxa/k/c;
    //   342: aload_2
    //   343: invokeinterface 487 2 0
    //   348: aload_0
    //   349: aconst_null
    //   350: putfield 302	com/tencent/luggage/wxa/u/b:l	Lcom/tencent/luggage/wxa/k/b;
    //   353: goto +11 -> 364
    //   356: astore_1
    //   357: aload_0
    //   358: aconst_null
    //   359: putfield 302	com/tencent/luggage/wxa/u/b:l	Lcom/tencent/luggage/wxa/k/b;
    //   362: aload_1
    //   363: athrow
    //   364: aload_1
    //   365: athrow
    //   366: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	367	0	this	b
    //   135	52	1	localObject1	Object
    //   198	7	1	localObject2	Object
    //   206	1	1	localObject3	Object
    //   247	9	1	localObject4	Object
    //   257	1	1	localObject5	Object
    //   305	9	1	localObject6	Object
    //   315	1	1	localObject7	Object
    //   356	9	1	localObject8	Object
    //   216	127	2	localb	com.tencent.luggage.wxa.k.b
    // Exception table:
    //   from	to	target	type
    //   182	192	198	finally
    //   153	160	206	finally
    //   229	239	247	finally
    //   146	153	257	finally
    //   287	297	305	finally
    //   258	265	315	finally
    //   338	348	356	finally
  }
  
  protected void D()
  {
    this.A = -9223372036854775807L;
    this.B = -1;
    this.C = -1;
    this.M = true;
    this.L = false;
    this.D = false;
    this.i.clear();
    this.w = false;
    this.x = false;
    if ((!this.r) && ((!this.t) || (!this.I)))
    {
      if (this.G != 0)
      {
        C();
        z();
      }
      else
      {
        this.n.flush();
        this.H = false;
      }
    }
    else
    {
      C();
      z();
    }
    if ((this.E) && (this.k != null)) {
      this.F = 1;
    }
  }
  
  protected long E()
  {
    return 0L;
  }
  
  public final int a(com.tencent.luggage.wxa.h.k paramk)
  {
    try
    {
      int i2 = a(this.c, paramk);
      int i1 = i2;
      if ((i2 & 0x7) > 2)
      {
        boolean bool = a(this.d, paramk.i);
        i1 = i2;
        if (!bool) {
          i1 = i2 & 0xFFFFFFF8 | 0x2;
        }
      }
      return i1;
    }
    catch (d.b paramk)
    {
      throw com.tencent.luggage.wxa.h.e.a(paramk, r());
    }
  }
  
  protected abstract int a(c paramc, com.tencent.luggage.wxa.h.k paramk);
  
  protected a a(c paramc, com.tencent.luggage.wxa.h.k paramk, boolean paramBoolean)
  {
    return paramc.a(paramk.f, paramBoolean);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.K)
    {
      y();
      return;
    }
    int i1;
    if (this.k == null)
    {
      this.g.a();
      i1 = a(this.h, this.g, true);
      if (i1 == -5)
      {
        b(this.h.a);
      }
      else
      {
        if (i1 == -4)
        {
          com.tencent.luggage.wxa.ao.a.b(this.g.c());
          this.J = true;
          F();
        }
        return;
      }
    }
    z();
    if (this.n != null)
    {
      v.a("drainAndFeed");
      while (b(paramLong1, paramLong2)) {}
      while (v()) {}
      v.a();
    }
    else
    {
      b(paramLong1);
      this.g.a();
      i1 = a(this.h, this.g, false);
      if (i1 == -5)
      {
        b(this.h.a);
      }
      else if (i1 == -4)
      {
        com.tencent.luggage.wxa.ao.a.b(this.g.c());
        this.J = true;
        F();
      }
    }
    this.a.a();
  }
  
  protected void a(long paramLong, boolean paramBoolean)
  {
    this.J = false;
    this.K = false;
    if (this.n != null) {
      D();
    }
  }
  
  protected void a(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat) {}
  
  protected void a(com.tencent.luggage.wxa.j.e parame) {}
  
  protected abstract void a(a parama, MediaCodec paramMediaCodec, com.tencent.luggage.wxa.h.k paramk, MediaCrypto paramMediaCrypto);
  
  protected void a(String paramString, long paramLong1, long paramLong2) {}
  
  protected void a(boolean paramBoolean)
  {
    this.a = new d();
  }
  
  protected abstract boolean a(long paramLong1, long paramLong2, MediaCodec paramMediaCodec, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, long paramLong3, boolean paramBoolean);
  
  protected boolean a(MediaCodec paramMediaCodec, boolean paramBoolean, com.tencent.luggage.wxa.h.k paramk1, com.tencent.luggage.wxa.h.k paramk2)
  {
    return false;
  }
  
  protected boolean a(a parama)
  {
    return true;
  }
  
  protected void b(com.tencent.luggage.wxa.h.k paramk)
  {
    com.tencent.luggage.wxa.h.k localk = this.k;
    this.k = paramk;
    com.tencent.luggage.wxa.k.a locala = this.k.i;
    if (localk == null) {
      paramk = null;
    } else {
      paramk = localk.i;
    }
    boolean bool1 = x.a(locala, paramk);
    boolean bool2 = true;
    if ((bool1 ^ true)) {
      if (this.k.i != null)
      {
        paramk = this.d;
        if (paramk != null)
        {
          this.m = paramk.a(Looper.myLooper(), this.k.i);
          paramk = this.m;
          if (paramk == this.l) {
            this.d.a(paramk);
          }
        }
        else
        {
          throw com.tencent.luggage.wxa.h.e.a(new IllegalStateException("Media requires a DrmSessionManager"), r());
        }
      }
      else
      {
        this.m = null;
      }
    }
    if (this.m == this.l)
    {
      paramk = this.n;
      if ((paramk != null) && (a(paramk, this.o.b, localk, this.k)))
      {
        this.E = true;
        this.F = 1;
        int i1 = this.p;
        bool1 = bool2;
        if (i1 != 2) {
          if ((i1 == 1) && (this.k.j == localk.j) && (this.k.k == localk.k)) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
        }
        this.w = bool1;
        return;
      }
    }
    if (this.H)
    {
      this.G = 1;
      return;
    }
    C();
    z();
  }
  
  protected void c(long paramLong) {}
  
  public final int m()
  {
    return 8;
  }
  
  protected void n() {}
  
  protected void o() {}
  
  /* Error */
  protected void p()
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: putfield 368	com/tencent/luggage/wxa/u/b:k	Lcom/tencent/luggage/wxa/h/k;
    //   5: aload_0
    //   6: invokevirtual 132	com/tencent/luggage/wxa/u/b:C	()V
    //   9: aload_0
    //   10: getfield 302	com/tencent/luggage/wxa/u/b:l	Lcom/tencent/luggage/wxa/k/b;
    //   13: ifnull +16 -> 29
    //   16: aload_0
    //   17: getfield 96	com/tencent/luggage/wxa/u/b:d	Lcom/tencent/luggage/wxa/k/c;
    //   20: aload_0
    //   21: getfield 302	com/tencent/luggage/wxa/u/b:l	Lcom/tencent/luggage/wxa/k/b;
    //   24: invokeinterface 487 2 0
    //   29: aload_0
    //   30: getfield 484	com/tencent/luggage/wxa/u/b:m	Lcom/tencent/luggage/wxa/k/b;
    //   33: ifnull +27 -> 60
    //   36: aload_0
    //   37: getfield 484	com/tencent/luggage/wxa/u/b:m	Lcom/tencent/luggage/wxa/k/b;
    //   40: aload_0
    //   41: getfield 302	com/tencent/luggage/wxa/u/b:l	Lcom/tencent/luggage/wxa/k/b;
    //   44: if_acmpeq +16 -> 60
    //   47: aload_0
    //   48: getfield 96	com/tencent/luggage/wxa/u/b:d	Lcom/tencent/luggage/wxa/k/c;
    //   51: aload_0
    //   52: getfield 484	com/tencent/luggage/wxa/u/b:m	Lcom/tencent/luggage/wxa/k/b;
    //   55: invokeinterface 487 2 0
    //   60: aload_0
    //   61: aconst_null
    //   62: putfield 302	com/tencent/luggage/wxa/u/b:l	Lcom/tencent/luggage/wxa/k/b;
    //   65: aload_0
    //   66: aconst_null
    //   67: putfield 484	com/tencent/luggage/wxa/u/b:m	Lcom/tencent/luggage/wxa/k/b;
    //   70: return
    //   71: astore_1
    //   72: aload_0
    //   73: aconst_null
    //   74: putfield 302	com/tencent/luggage/wxa/u/b:l	Lcom/tencent/luggage/wxa/k/b;
    //   77: aload_0
    //   78: aconst_null
    //   79: putfield 484	com/tencent/luggage/wxa/u/b:m	Lcom/tencent/luggage/wxa/k/b;
    //   82: aload_1
    //   83: athrow
    //   84: astore_1
    //   85: aload_0
    //   86: getfield 484	com/tencent/luggage/wxa/u/b:m	Lcom/tencent/luggage/wxa/k/b;
    //   89: ifnull +27 -> 116
    //   92: aload_0
    //   93: getfield 484	com/tencent/luggage/wxa/u/b:m	Lcom/tencent/luggage/wxa/k/b;
    //   96: aload_0
    //   97: getfield 302	com/tencent/luggage/wxa/u/b:l	Lcom/tencent/luggage/wxa/k/b;
    //   100: if_acmpeq +16 -> 116
    //   103: aload_0
    //   104: getfield 96	com/tencent/luggage/wxa/u/b:d	Lcom/tencent/luggage/wxa/k/c;
    //   107: aload_0
    //   108: getfield 484	com/tencent/luggage/wxa/u/b:m	Lcom/tencent/luggage/wxa/k/b;
    //   111: invokeinterface 487 2 0
    //   116: aload_0
    //   117: aconst_null
    //   118: putfield 302	com/tencent/luggage/wxa/u/b:l	Lcom/tencent/luggage/wxa/k/b;
    //   121: aload_0
    //   122: aconst_null
    //   123: putfield 484	com/tencent/luggage/wxa/u/b:m	Lcom/tencent/luggage/wxa/k/b;
    //   126: aload_1
    //   127: athrow
    //   128: astore_1
    //   129: aload_0
    //   130: aconst_null
    //   131: putfield 302	com/tencent/luggage/wxa/u/b:l	Lcom/tencent/luggage/wxa/k/b;
    //   134: aload_0
    //   135: aconst_null
    //   136: putfield 484	com/tencent/luggage/wxa/u/b:m	Lcom/tencent/luggage/wxa/k/b;
    //   139: aload_1
    //   140: athrow
    //   141: astore_1
    //   142: aload_0
    //   143: getfield 302	com/tencent/luggage/wxa/u/b:l	Lcom/tencent/luggage/wxa/k/b;
    //   146: ifnull +16 -> 162
    //   149: aload_0
    //   150: getfield 96	com/tencent/luggage/wxa/u/b:d	Lcom/tencent/luggage/wxa/k/c;
    //   153: aload_0
    //   154: getfield 302	com/tencent/luggage/wxa/u/b:l	Lcom/tencent/luggage/wxa/k/b;
    //   157: invokeinterface 487 2 0
    //   162: aload_0
    //   163: getfield 484	com/tencent/luggage/wxa/u/b:m	Lcom/tencent/luggage/wxa/k/b;
    //   166: ifnull +27 -> 193
    //   169: aload_0
    //   170: getfield 484	com/tencent/luggage/wxa/u/b:m	Lcom/tencent/luggage/wxa/k/b;
    //   173: aload_0
    //   174: getfield 302	com/tencent/luggage/wxa/u/b:l	Lcom/tencent/luggage/wxa/k/b;
    //   177: if_acmpeq +16 -> 193
    //   180: aload_0
    //   181: getfield 96	com/tencent/luggage/wxa/u/b:d	Lcom/tencent/luggage/wxa/k/c;
    //   184: aload_0
    //   185: getfield 484	com/tencent/luggage/wxa/u/b:m	Lcom/tencent/luggage/wxa/k/b;
    //   188: invokeinterface 487 2 0
    //   193: aload_0
    //   194: aconst_null
    //   195: putfield 302	com/tencent/luggage/wxa/u/b:l	Lcom/tencent/luggage/wxa/k/b;
    //   198: aload_0
    //   199: aconst_null
    //   200: putfield 484	com/tencent/luggage/wxa/u/b:m	Lcom/tencent/luggage/wxa/k/b;
    //   203: aload_1
    //   204: athrow
    //   205: astore_1
    //   206: aload_0
    //   207: aconst_null
    //   208: putfield 302	com/tencent/luggage/wxa/u/b:l	Lcom/tencent/luggage/wxa/k/b;
    //   211: aload_0
    //   212: aconst_null
    //   213: putfield 484	com/tencent/luggage/wxa/u/b:m	Lcom/tencent/luggage/wxa/k/b;
    //   216: aload_1
    //   217: athrow
    //   218: astore_1
    //   219: aload_0
    //   220: getfield 484	com/tencent/luggage/wxa/u/b:m	Lcom/tencent/luggage/wxa/k/b;
    //   223: ifnull +27 -> 250
    //   226: aload_0
    //   227: getfield 484	com/tencent/luggage/wxa/u/b:m	Lcom/tencent/luggage/wxa/k/b;
    //   230: aload_0
    //   231: getfield 302	com/tencent/luggage/wxa/u/b:l	Lcom/tencent/luggage/wxa/k/b;
    //   234: if_acmpeq +16 -> 250
    //   237: aload_0
    //   238: getfield 96	com/tencent/luggage/wxa/u/b:d	Lcom/tencent/luggage/wxa/k/c;
    //   241: aload_0
    //   242: getfield 484	com/tencent/luggage/wxa/u/b:m	Lcom/tencent/luggage/wxa/k/b;
    //   245: invokeinterface 487 2 0
    //   250: aload_0
    //   251: aconst_null
    //   252: putfield 302	com/tencent/luggage/wxa/u/b:l	Lcom/tencent/luggage/wxa/k/b;
    //   255: aload_0
    //   256: aconst_null
    //   257: putfield 484	com/tencent/luggage/wxa/u/b:m	Lcom/tencent/luggage/wxa/k/b;
    //   260: aload_1
    //   261: athrow
    //   262: astore_1
    //   263: aload_0
    //   264: aconst_null
    //   265: putfield 302	com/tencent/luggage/wxa/u/b:l	Lcom/tencent/luggage/wxa/k/b;
    //   268: aload_0
    //   269: aconst_null
    //   270: putfield 484	com/tencent/luggage/wxa/u/b:m	Lcom/tencent/luggage/wxa/k/b;
    //   273: aload_1
    //   274: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	this	b
    //   71	12	1	localObject1	Object
    //   84	43	1	localObject2	Object
    //   128	12	1	localObject3	Object
    //   141	63	1	localObject4	Object
    //   205	12	1	localObject5	Object
    //   218	43	1	localObject6	Object
    //   262	12	1	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   29	60	71	finally
    //   9	29	84	finally
    //   85	116	128	finally
    //   5	9	141	finally
    //   162	193	205	finally
    //   142	162	218	finally
    //   219	250	262	finally
  }
  
  public boolean t()
  {
    return (this.k != null) && (!this.L) && ((s()) || (this.C >= 0) || ((this.A != -9223372036854775807L) && (SystemClock.elapsedRealtime() < this.A)));
  }
  
  public boolean u()
  {
    return this.K;
  }
  
  protected void y() {}
  
  protected final void z()
  {
    if (this.n == null)
    {
      Object localObject1 = this.k;
      if (localObject1 == null) {
        return;
      }
      this.l = this.m;
      String str1 = ((com.tencent.luggage.wxa.h.k)localObject1).f;
      localObject1 = this.l;
      Object localObject2;
      boolean bool;
      if (localObject1 != null)
      {
        localObject2 = (com.tencent.luggage.wxa.k.e)((com.tencent.luggage.wxa.k.b)localObject1).c();
        if (localObject2 == null)
        {
          localObject1 = this.l.b();
          if (localObject1 == null) {
            return;
          }
          throw com.tencent.luggage.wxa.h.e.a((Exception)localObject1, r());
        }
        localObject1 = ((com.tencent.luggage.wxa.k.e)localObject2).a();
        bool = ((com.tencent.luggage.wxa.k.e)localObject2).a(str1);
      }
      else
      {
        localObject1 = null;
        bool = false;
      }
      if (this.o == null)
      {
        try
        {
          this.o = a(this.c, this.k, bool);
          if ((this.o == null) && (bool))
          {
            this.o = a(this.c, this.k, false);
            if (this.o != null)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("Drm session requires secure decoder for ");
              ((StringBuilder)localObject2).append(str1);
              ((StringBuilder)localObject2).append(", but no secure decoder available. Trying to proceed with ");
              ((StringBuilder)localObject2).append(this.o.a);
              ((StringBuilder)localObject2).append(".");
              Log.w("MediaCodecRenderer", ((StringBuilder)localObject2).toString());
            }
          }
        }
        catch (d.b localb)
        {
          a(new b.a(this.k, localb, bool, -49998));
        }
        if (this.o == null) {
          a(new b.a(this.k, null, bool, -49999));
        }
      }
      if (!a(this.o)) {
        return;
      }
      String str2 = this.o.a;
      this.p = b(str2);
      this.q = a(str2, this.k);
      this.r = a(str2);
      this.s = c(str2);
      this.t = d(str2);
      this.u = e(str2);
      this.v = b(str2, this.k);
      long l1;
      try
      {
        l1 = SystemClock.elapsedRealtime();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("createCodec:");
        ((StringBuilder)localObject2).append(str2);
        v.a(((StringBuilder)localObject2).toString());
        this.n = MediaCodec.createByCodecName(str2);
        v.a();
        v.a("configureCodec");
        a(this.o, this.n, this.k, (MediaCrypto)localObject1);
        v.a();
        v.a("startCodec");
        this.n.start();
        v.a();
        long l2 = SystemClock.elapsedRealtime();
        a(str2, l2, l2 - l1);
        this.y = this.n.getInputBuffers();
        this.z = this.n.getOutputBuffers();
      }
      catch (Exception localException)
      {
        a(new b.a(this.k, localException, bool, str2));
      }
      if (d() == 2) {
        l1 = SystemClock.elapsedRealtime() + 1000L;
      } else {
        l1 = -9223372036854775807L;
      }
      this.A = l1;
      this.B = -1;
      this.C = -1;
      this.M = true;
      d locald = this.a;
      locald.a += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.u.b
 * JD-Core Version:    0.7.0.1
 */