package com.tencent.biz.qqcircle.bizparts.danmaku.entity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.bizparts.danmaku.config.PhotoDanmakuConfig;
import com.tencent.biz.qqcircle.bizparts.danmaku.core.PhotoDanmakuDrawer;
import com.tencent.biz.qqcircle.bizparts.danmaku.util.DanmakuUtils;
import feedcloud.FeedCloudMeta.StUser;
import java.util.concurrent.atomic.AtomicLong;

public abstract class AbsDanmaku
  implements Comparable<AbsDanmaku>
{
  private static final AtomicLong ak = new AtomicLong();
  protected int A;
  protected int B;
  protected int C;
  protected float D;
  protected float E;
  protected float F;
  protected int G;
  protected float H;
  protected byte I;
  protected int J;
  protected final int K;
  protected final int L;
  protected String M;
  protected String N;
  protected float O;
  protected float P = -1.0F;
  protected float Q = -1.0F;
  protected float R = -1.0F;
  protected float S = -1.0F;
  protected int T;
  protected boolean U;
  protected boolean V;
  protected volatile boolean W;
  protected Bitmap X;
  protected Canvas Y;
  protected Bitmap Z;
  public boolean a = false;
  protected int aa;
  protected boolean ab;
  protected boolean ac;
  public int ad;
  protected boolean ae;
  public int af;
  public boolean ag = false;
  public int ah = 0;
  public int ai = 0;
  public boolean aj;
  protected final PhotoDanmakuConfig b;
  protected final long c = ak.incrementAndGet();
  protected long d = -1L;
  protected PhotoDanmakuTimer e;
  protected Duration f;
  protected long g;
  protected CharSequence h;
  protected String i;
  protected String j;
  protected float k;
  protected int l;
  protected int m = -1;
  public boolean n = false;
  public int o;
  public int p;
  public int q;
  public int r;
  protected int s = -1;
  protected int t;
  protected String u;
  protected long v;
  protected FeedCloudMeta.StUser w;
  protected int x;
  protected float y;
  protected String z;
  
  public AbsDanmaku(PhotoDanmakuConfig paramPhotoDanmakuConfig, Duration paramDuration, PhotoDanmakuTimer paramPhotoDanmakuTimer)
  {
    this.b = paramPhotoDanmakuConfig;
    this.f = paramDuration;
    this.e = paramPhotoDanmakuTimer;
    this.aa = 10000;
    this.K = this.b.u;
    this.L = this.b.v;
    a();
  }
  
  public int A()
  {
    return this.G;
  }
  
  public int B()
  {
    return this.B;
  }
  
  public int C()
  {
    return this.C;
  }
  
  public byte D()
  {
    return this.I;
  }
  
  public int E()
  {
    return this.J;
  }
  
  public float F()
  {
    return this.P;
  }
  
  public float G()
  {
    return this.Q;
  }
  
  public int H()
  {
    return this.aa;
  }
  
  public boolean I()
  {
    return this.ac;
  }
  
  public String J()
  {
    return this.i;
  }
  
  public String K()
  {
    return this.j;
  }
  
  public float L()
  {
    return this.F;
  }
  
  public float M()
  {
    return this.D;
  }
  
  public float N()
  {
    return this.E;
  }
  
  public PhotoDanmakuConfig O()
  {
    return this.b;
  }
  
  public float P()
  {
    return this.O;
  }
  
  public String Q()
  {
    return this.M;
  }
  
  public String R()
  {
    return this.N;
  }
  
  public float S()
  {
    return this.S;
  }
  
  public float T()
  {
    return this.R;
  }
  
  public float U()
  {
    return l() + C();
  }
  
  public float V()
  {
    return m() + B();
  }
  
  public float W()
  {
    return this.y;
  }
  
  public boolean X()
  {
    return this.U;
  }
  
  public boolean Y()
  {
    return this.V;
  }
  
  public Bitmap Z()
  {
    return this.X;
  }
  
  public int a(AbsDanmaku paramAbsDanmaku)
  {
    return DanmakuUtils.a(this, paramAbsDanmaku);
  }
  
  protected void a()
  {
    g(this.b.h);
    f(this.b.g);
    e(this.b.l);
    f(this.b.m);
    k(this.b.n);
    d(this.b.i);
    a(this.b.j);
    b(this.b.k);
    d(this.b.r);
    e(this.b.t);
    d(this.b.o);
    c(this.b.s);
  }
  
  public void a(float paramFloat)
  {
    if (this.k != paramFloat)
    {
      this.k = paramFloat;
      this.M = null;
      this.W = true;
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.X = paramBitmap;
  }
  
  public void a(Canvas paramCanvas)
  {
    this.Y = paramCanvas;
  }
  
  public void a(PhotoDanmakuDrawer paramPhotoDanmakuDrawer)
  {
    paramPhotoDanmakuDrawer.a(this);
  }
  
  public final void a(PhotoDanmakuDrawer paramPhotoDanmakuDrawer, float paramFloat1, float paramFloat2)
  {
    b(paramPhotoDanmakuDrawer, paramFloat1, paramFloat2);
  }
  
  public void a(PhotoDanmakuTimer paramPhotoDanmakuTimer)
  {
    this.e = paramPhotoDanmakuTimer;
  }
  
  public void a(FeedCloudMeta.StUser paramStUser)
  {
    if (this.w == paramStUser) {
      return;
    }
    this.w = paramStUser;
    this.W = true;
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.h = paramCharSequence;
    this.P = -1.0F;
    this.M = null;
    this.W = true;
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.equals(this.z, paramString))
    {
      this.z = paramString;
      this.N = null;
      this.W = true;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.T = 1;
      h();
      return;
    }
    this.T = 0;
  }
  
  public boolean a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    float[] arrayOfFloat = c(paramLong);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (arrayOfFloat != null)
    {
      if (arrayOfFloat.length < 4) {
        return false;
      }
      bool1 = bool2;
      if (arrayOfFloat[0] <= paramFloat1)
      {
        bool1 = bool2;
        if (paramFloat1 <= arrayOfFloat[2])
        {
          bool1 = bool2;
          if (arrayOfFloat[1] <= paramFloat2)
          {
            bool1 = bool2;
            if (paramFloat2 <= arrayOfFloat[3]) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean a(int paramInt)
  {
    int i1 = this.aa;
    if (i1 - paramInt >= 0)
    {
      this.aa = (i1 - paramInt);
      this.g += paramInt;
      return true;
    }
    return false;
  }
  
  public boolean a(long paramLong)
  {
    return paramLong - this.g >= this.f.a();
  }
  
  public boolean aa()
  {
    return this.W;
  }
  
  public Canvas ab()
  {
    return this.Y;
  }
  
  public Bitmap ac()
  {
    return this.Z;
  }
  
  public boolean ad()
  {
    return this.ag;
  }
  
  public abstract float b();
  
  public void b(float paramFloat)
  {
    this.P = paramFloat;
  }
  
  public void b(int paramInt)
  {
    if (this.l != paramInt)
    {
      this.l = paramInt;
      this.M = null;
      this.W = true;
    }
  }
  
  public void b(Bitmap paramBitmap)
  {
    this.W = true;
    this.Z = paramBitmap;
  }
  
  public void b(PhotoDanmakuDrawer paramPhotoDanmakuDrawer)
  {
    paramPhotoDanmakuDrawer.b(this);
  }
  
  protected abstract void b(PhotoDanmakuDrawer paramPhotoDanmakuDrawer, float paramFloat1, float paramFloat2);
  
  public void b(String paramString)
  {
    this.i = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.ab = paramBoolean;
  }
  
  public abstract float[] b(long paramLong);
  
  public long c()
  {
    return this.f.a();
  }
  
  public void c(float paramFloat)
  {
    this.Q = paramFloat;
  }
  
  public void c(int paramInt)
  {
    if (this.x != paramInt)
    {
      this.x = paramInt;
      this.W = true;
    }
  }
  
  public void c(String paramString)
  {
    this.j = paramString;
    this.W = true;
  }
  
  public void c(boolean paramBoolean)
  {
    this.ac = paramBoolean;
  }
  
  public abstract float[] c(long paramLong);
  
  public long d()
  {
    return r() + c();
  }
  
  public void d(float paramFloat)
  {
    if (this.F != paramFloat)
    {
      this.F = paramFloat;
      this.N = null;
      this.W = true;
    }
  }
  
  public void d(int paramInt)
  {
    if (this.A != paramInt)
    {
      this.A = paramInt;
      this.M = null;
      this.N = null;
      this.W = true;
    }
  }
  
  public void d(long paramLong)
  {
    this.g = paramLong;
  }
  
  public void d(String paramString)
  {
    this.M = paramString;
  }
  
  public void d(boolean paramBoolean)
  {
    this.U = paramBoolean;
    this.W = true;
  }
  
  public void e(float paramFloat)
  {
    this.D = paramFloat;
    this.W = true;
  }
  
  public void e(int paramInt)
  {
    if (this.G != paramInt)
    {
      this.G = paramInt;
      this.N = null;
      this.W = true;
    }
  }
  
  public void e(String paramString)
  {
    this.N = paramString;
  }
  
  public void e(boolean paramBoolean)
  {
    this.V = paramBoolean;
  }
  
  public boolean e()
  {
    return (this.P >= 0.0F) && (this.Q >= 0.0F);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof AbsDanmaku;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (AbsDanmaku)paramObject;
    long l1 = this.d;
    bool1 = bool2;
    if (l1 != -1L)
    {
      long l2 = paramObject.d;
      if (l2 == -1L) {
        return false;
      }
      bool1 = bool2;
      if (l1 == l2) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void f(float paramFloat)
  {
    this.E = paramFloat;
    this.W = true;
  }
  
  public void f(int paramInt)
  {
    this.B = paramInt;
    this.W = true;
  }
  
  public void f(String paramString)
  {
    this.u = paramString;
  }
  
  public void f(boolean paramBoolean)
  {
    this.W = paramBoolean;
  }
  
  public boolean f()
  {
    return this.T == 1;
  }
  
  public void g(float paramFloat)
  {
    this.H = paramFloat;
    this.W = true;
  }
  
  public void g(int paramInt)
  {
    this.C = paramInt;
    this.W = true;
  }
  
  public boolean g()
  {
    PhotoDanmakuTimer localPhotoDanmakuTimer = this.e;
    if (localPhotoDanmakuTimer != null) {
      return a(localPhotoDanmakuTimer.a());
    }
    return true;
  }
  
  public int h(int paramInt)
  {
    int i2 = this.ad;
    int i1 = i2;
    if (i2 > paramInt) {
      i1 = paramInt - 1;
    }
    return i1;
  }
  
  protected abstract void h();
  
  public void h(float paramFloat)
  {
    this.O = paramFloat;
  }
  
  public int hashCode()
  {
    return (int)this.d;
  }
  
  public final void i()
  {
    long l1 = this.e.b();
    if (this.ae) {
      this.g += l1;
    }
    j();
  }
  
  public void i(float paramFloat)
  {
    this.S = paramFloat;
  }
  
  public void i(int paramInt)
  {
    this.s = paramInt;
  }
  
  public abstract void j();
  
  public void j(float paramFloat)
  {
    this.R = paramFloat;
  }
  
  public void j(int paramInt)
  {
    this.t = paramInt;
  }
  
  public abstract int k();
  
  public void k(float paramFloat)
  {
    this.y = paramFloat;
    this.W = true;
  }
  
  public void k(int paramInt)
  {
    this.af = paramInt;
    this.W = true;
  }
  
  public abstract float l();
  
  public abstract float m();
  
  public abstract float n();
  
  public abstract float o();
  
  public PhotoDanmakuTimer p()
  {
    return this.e;
  }
  
  public long q()
  {
    return this.c;
  }
  
  public long r()
  {
    return this.g;
  }
  
  public CharSequence s()
  {
    return this.h;
  }
  
  public float t()
  {
    return this.k;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("absDanmaku_");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
  
  public int u()
  {
    return this.l;
  }
  
  public int v()
  {
    return this.m;
  }
  
  public long w()
  {
    return this.v;
  }
  
  public FeedCloudMeta.StUser x()
  {
    return this.w;
  }
  
  public String y()
  {
    return this.z;
  }
  
  public int z()
  {
    return this.A;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.entity.AbsDanmaku
 * JD-Core Version:    0.7.0.1
 */