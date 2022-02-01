package com.tencent.liteav.beauty.b.c;

import com.tencent.liteav.basic.log.TXCLog;

public class a
  extends com.tencent.liteav.beauty.b.b
{
  private d r = null;
  private d s = null;
  private b t = null;
  private c u = null;
  private d v = null;
  private d w = null;
  private float x = 0.2F;
  private float y = 0.2F;
  private float z = 0.2F;
  
  private boolean d(int paramInt1, int paramInt2)
  {
    if (this.r == null)
    {
      this.r = new d(true);
      this.r.a(true);
      if (!this.r.a())
      {
        TXCLog.e("TXCBeauty4Filter", "mSkinBlurFilterVertical init failed!!, break init");
        return false;
      }
    }
    if (this.s == null)
    {
      this.s = new d(false);
      this.s.a(true);
      if (!this.s.a())
      {
        TXCLog.e("TXCBeauty4Filter", "mSkinBlurFilterHorizontal init failed!!, break init");
        return false;
      }
    }
    if (this.t == null)
    {
      this.t = new b();
      this.t.a(true);
      if (!this.t.a())
      {
        TXCLog.e("TXCBeauty4Filter", "mBorderFilter init failed!!, break init");
        return false;
      }
    }
    if (this.v == null)
    {
      this.v = new d(true);
      this.v.a(true);
      if (!this.v.a())
      {
        TXCLog.e("TXCBeauty4Filter", "mBorderBlurFilterVertical init failed!!, break init");
        return false;
      }
    }
    if (this.w == null)
    {
      this.w = new d(false);
      this.w.a(true);
      if (!this.w.a())
      {
        TXCLog.e("TXCBeauty4Filter", "mBorderBlurFilterHorizontal init failed!!, break init");
        return false;
      }
    }
    if (this.u == null)
    {
      this.u = new c();
      this.u.a(true);
      if (!this.u.a())
      {
        TXCLog.e("TXCBeauty4Filter", "mSmoothFilter init failed!!, break init");
        return false;
      }
    }
    this.u.a(360.0F, 640.0F);
    this.u.a(this.x);
    this.u.b(this.y);
    this.u.c(this.z);
    a(paramInt1, paramInt2);
    return true;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    this.e = paramInt1;
    this.f = paramInt2;
    this.r.a(paramInt1, paramInt2);
    this.s.a(paramInt1, paramInt2);
    this.t.a(paramInt1, paramInt2);
    this.v.a(paramInt1, paramInt2);
    this.w.a(paramInt1, paramInt2);
    this.u.a(paramInt1, paramInt2);
  }
  
  public int b(int paramInt)
  {
    int i;
    if ((this.x <= 0.0F) && (this.y <= 0.0F))
    {
      i = paramInt;
      if (this.z <= 0.0F) {}
    }
    else
    {
      i = this.r.b(paramInt);
      i = this.s.b(i);
      int j = this.t.c(paramInt, i);
      j = this.v.b(j);
      j = this.w.b(j);
      i = this.u.a(paramInt, i, j);
    }
    return i;
  }
  
  public void c(int paramInt)
  {
    this.x = (paramInt / 10.0F);
    c localc = this.u;
    if (localc != null) {
      localc.a(this.x);
    }
  }
  
  public boolean c(int paramInt1, int paramInt2)
  {
    this.e = paramInt1;
    this.f = paramInt2;
    return d(paramInt1, paramInt2);
  }
  
  public void d(int paramInt)
  {
    this.y = (paramInt / 10.0F);
    c localc = this.u;
    if (localc != null) {
      localc.b(this.y);
    }
  }
  
  public void e()
  {
    super.e();
    r();
  }
  
  public void e(int paramInt)
  {
    this.z = (paramInt / 10.0F);
    c localc = this.u;
    if (localc != null) {
      localc.c(this.z);
    }
  }
  
  public void f(int paramInt)
  {
    this.u.d(paramInt / 10.0F);
  }
  
  void r()
  {
    Object localObject = this.r;
    if (localObject != null)
    {
      ((d)localObject).e();
      this.r = null;
    }
    localObject = this.s;
    if (localObject != null)
    {
      ((d)localObject).e();
      this.s = null;
    }
    localObject = this.t;
    if (localObject != null)
    {
      ((b)localObject).e();
      this.t = null;
    }
    localObject = this.u;
    if (localObject != null)
    {
      ((c)localObject).e();
      this.u = null;
    }
    localObject = this.v;
    if (localObject != null)
    {
      ((d)localObject).e();
      this.v = null;
    }
    localObject = this.w;
    if (localObject != null)
    {
      ((d)localObject).e();
      this.w = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.c.a
 * JD-Core Version:    0.7.0.1
 */