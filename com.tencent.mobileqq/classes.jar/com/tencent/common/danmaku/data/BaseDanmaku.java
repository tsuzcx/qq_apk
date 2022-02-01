package com.tencent.common.danmaku.data;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.annotation.CallSuper;
import com.tencent.common.danmaku.DanmakuDependImp;
import com.tencent.common.danmaku.IDanmakuDepend;
import com.tencent.common.danmaku.inject.DanmakuContext;
import com.tencent.common.danmaku.inject.IDanmakuUIConfig;
import com.tencent.common.danmaku.inject.WindowConfig;
import com.tencent.common.danmaku.tool.ClickResult;
import com.tencent.common.danmaku.tool.Duration;
import com.tencent.common.danmaku.tool.TouchPoint;
import com.tencent.common.danmaku.util.Logger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class BaseDanmaku<DATA, CONFIG extends IDanmakuUIConfig>
{
  private static final AtomicInteger x = new AtomicInteger();
  private volatile boolean A = true;
  private volatile boolean B = true;
  private DATA C;
  private HashMap<String, Object> D;
  protected DanmakuContext a;
  protected final int b = x.incrementAndGet();
  protected long c;
  protected Duration d;
  protected long e;
  protected final PriorityQueue<BaseDanmaku.TimePassedData> f;
  protected int g;
  protected int h;
  protected float i = -1.0F;
  protected float j = -1.0F;
  protected float k;
  protected int l;
  protected boolean m;
  protected Bitmap n;
  protected Canvas o;
  protected int p;
  protected int q = -1;
  protected int r;
  protected boolean s;
  protected boolean t;
  protected boolean u = false;
  protected BaseDanmaku.IHitLeftSideListener v;
  protected CONFIG w;
  private float y = -1.0F;
  private float z = -1.0F;
  
  public BaseDanmaku(DanmakuContext paramDanmakuContext)
  {
    this.a = paramDanmakuContext;
    this.f = new PriorityQueue();
    S();
    j();
  }
  
  private void S()
  {
    try
    {
      this.w = this.a.a(q());
      return;
    }
    catch (Exception localException)
    {
      if (!DanmakuDependImp.a().b().a()) {
        return;
      }
      throw new RuntimeException("IDanmakuUIConfig should been provided by IDanmakuUIConfigCreator in DanmakuContext", localException);
    }
  }
  
  private void T()
  {
    this.f.clear();
    this.g = 0;
    this.h = 0;
    this.i = -1.0F;
    this.j = -1.0F;
    this.l = 0;
    this.n = null;
    this.p = 0;
    this.r = 0;
    this.s = false;
    this.u = false;
    this.A = true;
    this.B = true;
    this.y = -1.0F;
    this.z = -1.0F;
    this.t = false;
    Object localObject1 = this.D;
    if (localObject1 != null)
    {
      localObject1 = ((HashMap)localObject1).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if ((localObject2 instanceof BaseDanmaku.IRecyclableExtraObject)) {
          ((BaseDanmaku.IRecyclableExtraObject)localObject2).a();
        }
      }
      this.D.clear();
      this.D = null;
    }
  }
  
  public float A()
  {
    return this.i;
  }
  
  public float B()
  {
    return this.j;
  }
  
  public int C()
  {
    return DanmakuContext.a().d();
  }
  
  public int D()
  {
    return this.p;
  }
  
  public boolean E()
  {
    return DanmakuContext.a().f();
  }
  
  public float F()
  {
    return s() + DanmakuContext.a().l();
  }
  
  public float G()
  {
    return t() + C();
  }
  
  public int H()
  {
    return DanmakuContext.a().j();
  }
  
  public int I()
  {
    return DanmakuContext.a().k();
  }
  
  public boolean J()
  {
    return (this.m) && (WindowConfig.a());
  }
  
  public Bitmap K()
  {
    return this.n;
  }
  
  public boolean L()
  {
    return this.B;
  }
  
  public boolean M()
  {
    return this.A;
  }
  
  public Canvas N()
  {
    return this.o;
  }
  
  public void O()
  {
    this.o.setBitmap(null);
  }
  
  public boolean P()
  {
    return this.t;
  }
  
  public long Q()
  {
    return this.c;
  }
  
  protected void R()
  {
    DanmakuContext localDanmakuContext = this.a;
    if (localDanmakuContext != null) {
      localDanmakuContext.b(this);
    }
  }
  
  public ClickResult a(TouchPoint paramTouchPoint)
  {
    return new ClickResult(-1);
  }
  
  public void a()
  {
    a(new Duration(DanmakuContext.a().e()));
    b();
  }
  
  public void a(float paramFloat)
  {
    this.z = paramFloat;
  }
  
  public abstract void a(float paramFloat1, float paramFloat2, long paramLong1, long paramLong2);
  
  public final void a(long paramLong1, long paramLong2)
  {
    if (this.s) {
      this.c += paramLong1;
    }
    d(paramLong2);
    if (!this.f.isEmpty())
    {
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext())
      {
        BaseDanmaku.TimePassedData localTimePassedData = (BaseDanmaku.TimePassedData)localIterator.next();
        localTimePassedData.a -= paramLong1;
        if (localTimePassedData.a <= 0L)
        {
          localIterator.remove();
          localTimePassedData.b.a(this);
        }
      }
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.n = paramBitmap;
  }
  
  public void a(Canvas paramCanvas)
  {
    this.o = paramCanvas;
    c(true);
  }
  
  public void a(Duration paramDuration)
  {
    this.d = paramDuration;
  }
  
  public void a(DATA paramDATA)
  {
    if ((DanmakuDependImp.a().b().a()) && (paramDATA == null)) {
      throw new RuntimeException("Danmaku data should been null");
    }
    this.C = paramDATA;
    c(true);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.l = 1;
      return;
    }
    this.l = 0;
  }
  
  public boolean a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    float[] arrayOfFloat = f(paramLong);
    boolean bool2 = false;
    if (arrayOfFloat == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (arrayOfFloat[0] <= paramFloat1)
    {
      bool1 = bool2;
      if (paramFloat1 <= arrayOfFloat[2] + paramFloat3)
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
    return bool1;
  }
  
  public boolean a(int paramInt)
  {
    if ((!P()) && (this.p - paramInt < 0)) {
      return false;
    }
    this.p -= paramInt;
    this.c += paramInt;
    return true;
  }
  
  public boolean a(long paramLong)
  {
    boolean bool2 = this.t;
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (paramLong - this.e >= this.d.a()) {
      bool1 = true;
    }
    return bool1;
  }
  
  protected void b() {}
  
  public void b(float paramFloat)
  {
    this.y = paramFloat;
  }
  
  public void b(int paramInt)
  {
    this.p = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public boolean b(long paramLong)
  {
    long l1 = this.c;
    return (l1 > 0L) && (paramLong - l1 >= this.d.a());
  }
  
  public int c(int paramInt)
  {
    int i2 = this.r;
    int i1 = i2;
    if (i2 > paramInt) {
      i1 = paramInt - 1;
    }
    return i1;
  }
  
  public CONFIG c()
  {
    return this.w;
  }
  
  public void c(float paramFloat)
  {
    this.d.a(paramFloat);
  }
  
  public void c(boolean paramBoolean)
  {
    this.B = paramBoolean;
  }
  
  public boolean c(long paramLong)
  {
    long l1 = this.c;
    return (l1 > 0L) && (paramLong - l1 < 0L);
  }
  
  public float d()
  {
    return this.z;
  }
  
  public int d(int paramInt)
  {
    int i2 = this.q;
    int i1 = i2;
    if (i2 >= paramInt) {
      i1 = paramInt - 1;
    }
    return i1;
  }
  
  public void d(float paramFloat)
  {
    this.i = paramFloat;
  }
  
  public abstract void d(long paramLong);
  
  public void d(boolean paramBoolean)
  {
    this.A = paramBoolean;
  }
  
  public float e()
  {
    return this.y;
  }
  
  public void e(float paramFloat)
  {
    this.j = paramFloat;
  }
  
  public void e(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }
  
  public abstract float[] e(long paramLong);
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (BaseDanmaku)paramObject;
      Object localObject = this.C;
      if (localObject != null) {
        return localObject.equals(paramObject.C);
      }
      return paramObject.C == null;
    }
    return false;
  }
  
  public void f()
  {
    this.s = true;
  }
  
  public void f(float paramFloat)
  {
    this.k = paramFloat;
  }
  
  public abstract float[] f(long paramLong);
  
  public void g(long paramLong)
  {
    this.e = paramLong;
  }
  
  public boolean g()
  {
    return this.s;
  }
  
  public void h()
  {
    this.s = false;
  }
  
  public void h(long paramLong)
  {
    this.c = paramLong;
  }
  
  public int hashCode()
  {
    Object localObject = this.C;
    if (localObject == null) {
      return 0;
    }
    return localObject.hashCode();
  }
  
  public abstract float i();
  
  @CallSuper
  public void j()
  {
    WindowConfig localWindowConfig = DanmakuContext.a();
    f(localWindowConfig.g());
    b(localWindowConfig.i());
    T();
    a();
  }
  
  public long k()
  {
    return this.d.a();
  }
  
  public long l()
  {
    return this.c + k();
  }
  
  public void m()
  {
    float f1 = s();
    if ((!this.u) && (f1 < H()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onFirstExposure, danmaku = ");
      ((StringBuilder)localObject).append(toString());
      Logger.c("BaseDanmaku", ((StringBuilder)localObject).toString());
      R();
      this.u = true;
    }
    Object localObject = this.v;
    if ((localObject != null) && (f1 <= 0.0F))
    {
      ((BaseDanmaku.IHitLeftSideListener)localObject).a(this);
      this.v = null;
    }
  }
  
  public boolean n()
  {
    return (this.i >= 0.0F) && (this.j >= 0.0F) && (!M());
  }
  
  @CallSuper
  public void o()
  {
    d(false);
  }
  
  public boolean p()
  {
    return this.l == 1;
  }
  
  public abstract int q();
  
  public DATA r()
  {
    return this.C;
  }
  
  public abstract float s();
  
  public abstract float t();
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BaseDanmaku");
    localStringBuilder.append(this.b);
    localStringBuilder.append("[left:");
    localStringBuilder.append(s());
    localStringBuilder.append(",top:");
    localStringBuilder.append(t());
    localStringBuilder.append(",right:");
    localStringBuilder.append(u());
    localStringBuilder.append(",bottom:");
    localStringBuilder.append(v());
    localStringBuilder.append(", time:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", mData=");
    localStringBuilder.append(String.valueOf(this.C));
    localStringBuilder.append(", mType=");
    localStringBuilder.append(q());
    localStringBuilder.append(", playerTime=");
    localStringBuilder.append(this.a.e());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public abstract float u();
  
  public abstract float v();
  
  public long w()
  {
    return this.b;
  }
  
  public long x()
  {
    return this.e;
  }
  
  public int y()
  {
    return this.g;
  }
  
  public int z()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.data.BaseDanmaku
 * JD-Core Version:    0.7.0.1
 */