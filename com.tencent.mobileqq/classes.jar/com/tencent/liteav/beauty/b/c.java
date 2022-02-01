package com.tencent.liteav.beauty.b;

import android.util.Log;

public class c
  extends b
{
  private static final String r = "c";
  private float A = 0.0F;
  private f s;
  private c.a t;
  private r u = null;
  private int v = -1;
  private int w = -1;
  private float x = 0.0F;
  private float y = 0.0F;
  private float z = 0.0F;
  
  private static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return paramFloat2 + (paramFloat3 - paramFloat2) * paramFloat1;
  }
  
  private static float b(float paramFloat)
  {
    if (paramFloat > 1.0F)
    {
      double d = paramFloat;
      float f;
      if (d < 2.5D)
      {
        f = a((paramFloat - 1.0F) / 1.5F, 1.0F, 4.1F);
      }
      else if (paramFloat < 4.0F)
      {
        f = a((paramFloat - 2.5F) / 1.5F, 4.1F, 5.6F);
      }
      else if (d < 5.5D)
      {
        f = a((paramFloat - 4.0F) / 1.5F, 5.6F, 6.8F);
      }
      else
      {
        f = paramFloat;
        if (d <= 7.0D) {
          f = a((paramFloat - 5.5F) / 1.5F, 6.8F, 7.0F);
        }
      }
      return f / 10.0F;
    }
    return 0.1F;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.v == paramInt1) && (this.w == paramInt2)) {
      return;
    }
    String str = r;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onOutputSizeChanged mFrameWidth = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("  mFrameHeight = ");
    localStringBuilder.append(paramInt2);
    Log.i(str, localStringBuilder.toString());
    this.v = paramInt1;
    this.w = paramInt2;
    c(this.v, this.w);
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
      if (this.x != 0.0F) {
        i = this.s.b(paramInt);
      } else {
        i = paramInt;
      }
      i = this.t.a(i, paramInt, paramInt);
    }
    paramInt = i;
    if (this.A > 0.0F) {
      paramInt = this.u.b(i);
    }
    return paramInt;
  }
  
  public void c(int paramInt)
  {
    float f = paramInt;
    this.x = f;
    c.a locala = this.t;
    if (locala != null) {
      locala.a(f);
    }
  }
  
  public boolean c(int paramInt1, int paramInt2)
  {
    this.v = paramInt1;
    this.w = paramInt2;
    String str = r;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("init mFrameWidth = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("  mFrameHeight = ");
    localStringBuilder.append(paramInt2);
    Log.i(str, localStringBuilder.toString());
    if (this.s == null)
    {
      this.s = new f();
      this.s.a(true);
      if (!this.s.a())
      {
        Log.e(r, "mNewFaceFilter init Failed");
        return false;
      }
    }
    this.s.a(this.v, this.w);
    if (this.t == null)
    {
      this.t = new c.a();
      this.t.a(true);
      if (!this.t.a())
      {
        Log.e(r, "mBeautyCoreFilter init Failed");
        return false;
      }
    }
    this.t.a(this.v, this.w);
    if (this.u == null)
    {
      this.u = new r();
      this.u.a(true);
      if (!this.u.a())
      {
        Log.e(r, "mSharpenessFilter init Failed");
        return false;
      }
    }
    this.u.a(this.v, this.w);
    return true;
  }
  
  public void d(int paramInt)
  {
    float f = paramInt;
    this.y = f;
    c.a locala = this.t;
    if (locala != null) {
      locala.b(f);
    }
  }
  
  public void e()
  {
    Object localObject = this.t;
    if (localObject != null)
    {
      ((c.a)localObject).d();
      this.t = null;
    }
    localObject = this.s;
    if (localObject != null)
    {
      ((f)localObject).d();
      this.s = null;
    }
    localObject = this.u;
    if (localObject != null)
    {
      ((r)localObject).d();
      this.u = null;
    }
  }
  
  public void e(int paramInt)
  {
    float f = paramInt;
    this.z = f;
    c.a locala = this.t;
    if (locala != null) {
      locala.c(f);
    }
  }
  
  public void f(int paramInt)
  {
    float f = paramInt / 15.0F;
    if (Math.abs(this.A - f) < 0.001D) {
      return;
    }
    this.A = f;
    r localr = this.u;
    if (localr != null) {
      localr.a(this.A);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.c
 * JD-Core Version:    0.7.0.1
 */