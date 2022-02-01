package com.tencent.liteav.beauty.b.b;

import android.util.Log;
import com.tencent.liteav.beauty.b.r;

public class a
  extends com.tencent.liteav.beauty.b.b
{
  private b r = null;
  private r s = null;
  private String t = "TXCBeauty3Filter";
  private float u = 0.0F;
  private float v = 0.0F;
  private float w = 0.0F;
  private float x = 0.0F;
  
  private boolean d(int paramInt1, int paramInt2)
  {
    if (this.r == null)
    {
      this.r = new b();
      this.r.a(true);
      if (!this.r.a())
      {
        Log.e(this.t, "m_verticalFilter init failed!!, break init");
        return false;
      }
    }
    this.r.a(paramInt1, paramInt2);
    if (this.s == null)
    {
      this.s = new r();
      this.s.a(true);
      if (!this.s.a())
      {
        Log.e(this.t, "mSharpnessFilter init failed!!, break init");
        return false;
      }
    }
    this.s.a(paramInt1, paramInt2);
    return true;
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
    int i;
    if ((this.u <= 0.0F) && (this.v <= 0.0F))
    {
      i = paramInt;
      if (this.w <= 0.0F) {}
    }
    else
    {
      i = this.r.b(paramInt);
    }
    paramInt = i;
    if (this.x > 0.0F) {
      paramInt = this.s.b(i);
    }
    return paramInt;
  }
  
  public void c(int paramInt)
  {
    this.u = (paramInt / 10.0F);
    b localb = this.r;
    if (localb != null) {
      localb.a(this.u);
    }
  }
  
  public boolean c(int paramInt1, int paramInt2)
  {
    return d(paramInt1, paramInt2);
  }
  
  public void d(int paramInt)
  {
    this.v = (paramInt / 10.0F);
    b localb = this.r;
    if (localb != null) {
      localb.b(this.v);
    }
  }
  
  public void e()
  {
    super.e();
    q();
  }
  
  public void e(int paramInt)
  {
    this.w = (paramInt / 10.0F);
    b localb = this.r;
    if (localb != null) {
      localb.c(this.w);
    }
  }
  
  public void f(int paramInt)
  {
    float f = paramInt / 20.0F;
    if (Math.abs(this.x - f) < 0.001D) {
      return;
    }
    this.x = f;
    r localr = this.s;
    if (localr != null) {
      localr.a(this.x);
    }
  }
  
  void q()
  {
    Object localObject = this.r;
    if (localObject != null)
    {
      ((b)localObject).e();
      this.r = null;
    }
    localObject = this.s;
    if (localObject != null)
    {
      ((r)localObject).e();
      this.s = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.b.a
 * JD-Core Version:    0.7.0.1
 */