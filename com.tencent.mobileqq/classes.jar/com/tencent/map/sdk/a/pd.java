package com.tencent.map.sdk.a;

import android.os.SystemClock;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.CancelableCallback;

public final class pd
  extends nv
{
  public boolean A = false;
  int B = 0;
  int C = 0;
  int D = 0;
  int E = 0;
  int F = 0;
  int G = 0;
  public int H = 0;
  public int I = 0;
  public boolean J = false;
  float K = 0.0F;
  float L = 0.0F;
  float M = 0.0F;
  public float N = 0.0F;
  public boolean O = false;
  float P = 0.0F;
  float Q = 0.0F;
  float R = 0.0F;
  public float S = 0.0F;
  private final Runnable T = new pd.1(this);
  private final Runnable U = new pd.2(this);
  private boolean V = false;
  private Interpolator W = new LinearInterpolator();
  private boolean X = false;
  private int Y = 0;
  private int Z = 0;
  public pd.a a = null;
  private boolean aa = false;
  private float ab = 0.0F;
  private float ac = 0.0F;
  private double ad = 0.0D;
  private double ae = 0.0D;
  private double af = 0.0D;
  private double ag = 1.0D;
  protected long b = 500L;
  protected long c = 0L;
  public TencentMap.CancelableCallback d = null;
  public boolean e = false;
  public boolean f = false;
  public int g = 0;
  public int h = 0;
  public int r = 0;
  public int s = 0;
  public boolean t = false;
  public boolean u = false;
  public boolean v = false;
  public double w = 0.0D;
  public boolean x = false;
  public int y = 0;
  public int z = 0;
  
  public pd()
  {
    super(10000, null);
  }
  
  private static float e(float paramFloat)
  {
    return (paramFloat % 360.0F + 360.0F) % 360.0F;
  }
  
  private static float f(float paramFloat)
  {
    float f1 = (paramFloat % 360.0F + 360.0F) % 360.0F;
    paramFloat = f1;
    if (f1 > 45.0F) {
      paramFloat = 45.0F;
    }
    return paramFloat;
  }
  
  public final void a()
  {
    super.a();
    this.X = true;
    if (this.d != null)
    {
      pd.a locala = this.a;
      if (locala != null) {
        locala.a(this.U);
      }
    }
  }
  
  public final void a(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return;
    }
    this.ab = paramFloat;
    this.t = true;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    this.y = paramInt1;
    this.z = paramInt2;
    this.x = true;
  }
  
  public final void a(long paramLong)
  {
    this.b = paramLong;
  }
  
  public final void b(float paramFloat)
  {
    if (paramFloat == 0.0F) {
      return;
    }
    this.ac = paramFloat;
    this.u = true;
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    this.B = paramInt1;
    this.C = paramInt2;
    this.A = true;
  }
  
  public final boolean b()
  {
    int i;
    Object localObject;
    int j;
    float f1;
    if (!this.V)
    {
      this.V = true;
      if (this.f)
      {
        this.Y = 0;
        this.Z = 0;
      }
      if ((this.t) || (this.u) || (this.v)) {
        this.ae = (1.0D / Math.pow(2.0D, 20.0F - this.a.e()));
      }
      if (this.t)
      {
        if (this.a.g()) {
          i = 22;
        } else {
          i = 20;
        }
        localObject = this.a;
        j = i;
        if (localObject != null) {
          j = Math.min(((pd.a)localObject).a(), i);
        }
        f1 = this.ab;
        f2 = j;
        if (f1 >= f2) {
          this.ab = f2;
        }
        localObject = this.a;
        if (localObject != null)
        {
          f1 = ((pd.a)localObject).e();
          if (Math.abs(this.ab - f1) < 0.001D) {
            this.aa = true;
          }
        }
        this.ad = (1.0D / Math.pow(2.0D, 20.0F - this.ab));
      }
      else if (this.u)
      {
        if (Math.abs(this.ac) < 0.001D) {
          this.aa = true;
        }
        this.ad = (1.0D / Math.pow(2.0D, 20.0F - (this.a.e() + this.ac)));
      }
      if (this.A)
      {
        localObject = this.a;
        if (localObject != null)
        {
          if (this.e == true) {
            localObject = ((pd.a)localObject).f();
          } else {
            localObject = ((pd.a)localObject).b();
          }
          if (localObject != null)
          {
            this.D = ((GeoPoint)localObject).getLatitudeE6();
            this.E = ((GeoPoint)localObject).getLongitudeE6();
            this.F = (this.B - this.D);
            this.G = (this.C - this.E);
          }
        }
      }
      if (this.J)
      {
        localObject = this.a;
        if (localObject != null) {
          this.L = ((pd.a)localObject).c();
        }
        this.M = (this.K - this.L);
        f1 = this.M;
        if (f1 > 180.0F) {
          this.M = (f1 - 360.0F);
        } else if (f1 < -180.0F) {
          this.M = (f1 + 360.0F);
        }
      }
      if (this.O)
      {
        localObject = this.a;
        if (localObject != null)
        {
          this.Q = ((pd.a)localObject).d();
          this.R = (this.P - this.Q);
        }
      }
      this.c = SystemClock.uptimeMillis();
    }
    if (!this.X)
    {
      f2 = (float)(SystemClock.uptimeMillis() - this.c) / (float)this.b;
      f1 = f2;
      if (f2 <= 1.0F) {}
    }
    else
    {
      f1 = 1.0F;
    }
    float f2 = this.W.getInterpolation(f1);
    this.X = true;
    if (this.f)
    {
      i = this.g;
      this.r = ((int)(i * f2));
      this.s = ((int)(this.h * f2));
      j = this.r;
      int k = this.Y;
      int m = this.s;
      int n = this.Z;
      this.Y = j;
      this.Z = m;
      this.r = (j - k);
      this.s = (m - n);
      if ((Math.abs(i) > 0) || (Math.abs(this.h) > 0)) {
        this.X = false;
      }
    }
    if ((this.t) || (this.u) || (this.v))
    {
      double d1 = this.ae;
      double d2 = this.ad;
      double d3 = f2;
      Double.isNaN(d3);
      this.w = (d1 + (d2 - d1) * d3);
      if (!this.aa) {
        this.X = false;
      }
    }
    if (this.A)
    {
      i = this.D;
      j = this.F;
      this.H = (i + (int)(j * f2));
      this.I = (this.E + (int)(this.G * f2));
      if ((Math.abs(j) > 1) || (Math.abs(this.G) > 1)) {
        this.X = false;
      }
    }
    float f3;
    float f4;
    if (this.J)
    {
      f3 = this.L;
      f4 = this.M;
      this.N = (f3 + f4 * f2);
      if (Math.abs(f4) > 1.0F) {
        this.X = false;
      }
    }
    if (this.O)
    {
      f3 = this.Q;
      f4 = this.R;
      this.S = (f3 + f2 * f4);
      if (Math.abs(f4) > 1.0F) {
        this.X = false;
      }
    }
    if (f1 >= 1.0F)
    {
      if (this.d != null)
      {
        localObject = this.a;
        if (localObject != null) {
          ((pd.a)localObject).a(this.T);
        }
      }
      return true;
    }
    return false;
  }
  
  public final void c(float paramFloat)
  {
    this.K = e(paramFloat);
    this.J = true;
  }
  
  public final void d(float paramFloat)
  {
    this.P = f(paramFloat);
    this.O = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.pd
 * JD-Core Version:    0.7.0.1
 */