package com.tencent.liteav.beauty.b.a;

import android.opengl.GLES20;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.b.h;
import com.tencent.liteav.beauty.b.q;

public class a
  extends com.tencent.liteav.beauty.b.b
{
  private int A = 0;
  private float B = 1.0F;
  private final float C = 0.7F;
  private float D = 0.8F;
  private float E = 2.0F;
  private int F = 0;
  private int G = 0;
  private int H = 0;
  private int I = 0;
  private c r = null;
  private d s = null;
  private e t = null;
  private h u = null;
  private q v = null;
  private b w = null;
  private String x = "TXCBeauty2Filter";
  private int y = 0;
  private int z = 0;
  
  private boolean d(int paramInt1, int paramInt2)
  {
    this.F = paramInt1;
    this.G = paramInt2;
    this.H = paramInt1;
    this.I = paramInt2;
    float f = this.E;
    if (1.0F != f)
    {
      this.H = ((int)(this.H / f));
      this.I = ((int)(this.I / f));
    }
    String str = this.x;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mResampleRatio ");
    localStringBuilder.append(this.E);
    localStringBuilder.append(" mResampleWidth ");
    localStringBuilder.append(this.H);
    localStringBuilder.append(" mResampleHeight ");
    localStringBuilder.append(this.I);
    TXCLog.i(str, localStringBuilder.toString());
    if (this.w == null)
    {
      this.w = new b();
      this.w.a(true);
      if (!this.w.a())
      {
        TXCLog.e(this.x, "mBeautyBlendFilter init failed!!, break init");
        return false;
      }
    }
    this.w.a(paramInt1, paramInt2);
    if (this.s == null)
    {
      this.s = new d();
      this.s.a(true);
      if (!this.s.a())
      {
        TXCLog.e(this.x, "m_horizontalFilter init failed!!, break init");
        return false;
      }
    }
    this.s.a(this.H, this.I);
    if (this.t == null)
    {
      this.t = new e();
      this.t.a(true);
      boolean bool;
      if (1.0F == this.E) {
        bool = false;
      } else {
        bool = true;
      }
      this.t.b(bool);
      if (!this.t.a())
      {
        TXCLog.e(this.x, "m_verticalFilter init failed!!, break init");
        return false;
      }
    }
    this.t.a(this.H, this.I);
    if (this.u == null)
    {
      this.u = new h(1.0F);
      this.u.a(true);
      if (!this.u.a())
      {
        TXCLog.e(this.x, "m_gammaFilter init failed!!, break init");
        return false;
      }
    }
    this.u.a(this.H, this.I);
    if (this.v == null)
    {
      this.v = new q();
      this.v.a(true);
      if (!this.v.a())
      {
        TXCLog.e(this.x, "mSharpenFilter init failed!!, break init");
        return false;
      }
    }
    this.v.a(paramInt1, paramInt2);
    return true;
  }
  
  private void g(int paramInt)
  {
    this.B = (1.0F - paramInt / 50.0F);
    h localh = this.u;
    if (localh != null) {
      localh.a(this.B);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.e == paramInt1) && (this.f == paramInt2)) {
      return;
    }
    this.e = paramInt1;
    this.f = paramInt2;
    d(paramInt1, paramInt2);
  }
  
  public int b(int paramInt)
  {
    if (1.0F != this.E) {
      GLES20.glViewport(0, 0, this.H, this.I);
    }
    int i = this.s.b(paramInt);
    int j = this.t.c(i, paramInt);
    if (1.0F != this.E) {
      GLES20.glViewport(0, 0, this.F, this.G);
    }
    i = j;
    if (this.D > 0.7F) {
      i = this.v.b(j);
    }
    return this.w.c(i, paramInt);
  }
  
  public void c(int paramInt)
  {
    e locale = this.t;
    if (locale != null) {
      locale.a(paramInt / 10.0F);
    }
    this.y = paramInt;
    g(paramInt);
  }
  
  public boolean c(int paramInt1, int paramInt2)
  {
    return d(paramInt1, paramInt2);
  }
  
  public void d(int paramInt)
  {
    b localb = this.w;
    if (localb != null) {
      localb.a(paramInt / 10.0F);
    }
    this.z = paramInt;
  }
  
  public void e()
  {
    super.e();
    r();
  }
  
  public void e(int paramInt)
  {
    b localb = this.w;
    if (localb != null) {
      localb.b(paramInt / 10.0F);
    }
    this.A = paramInt;
  }
  
  public void f(int paramInt)
  {
    float f = paramInt / 12.0F + 0.7F;
    if (Math.abs(this.D - f) < 0.001D) {
      return;
    }
    this.D = f;
    Object localObject = this.x;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("set mSharpenLevel ");
    localStringBuilder.append(paramInt);
    TXCLog.i((String)localObject, localStringBuilder.toString());
    localObject = this.v;
    if (localObject != null) {
      ((q)localObject).a(this.D);
    }
  }
  
  void r()
  {
    Object localObject = this.w;
    if (localObject != null)
    {
      ((b)localObject).d();
      this.w = null;
    }
    localObject = this.s;
    if (localObject != null)
    {
      ((d)localObject).d();
      this.s = null;
    }
    localObject = this.t;
    if (localObject != null)
    {
      ((e)localObject).d();
      this.t = null;
    }
    localObject = this.u;
    if (localObject != null)
    {
      ((h)localObject).d();
      this.u = null;
    }
    localObject = this.v;
    if (localObject != null)
    {
      ((q)localObject).d();
      this.v = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.a.a
 * JD-Core Version:    0.7.0.1
 */