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
    paramFloat = (paramFloat % 360.0F + 360.0F) % 360.0F;
    if (paramFloat > 45.0F) {
      return 45.0F;
    }
    return paramFloat;
  }
  
  public final void a()
  {
    super.a();
    this.X = true;
    if ((this.d != null) && (this.a != null)) {
      this.a.a(this.U);
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
    int j;
    label202:
    GeoPoint localGeoPoint;
    label235:
    float f2;
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
      if (!this.t) {
        break label799;
      }
      if (this.a.g())
      {
        i = 22;
        j = i;
        if (this.a != null) {
          j = Math.min(this.a.a(), i);
        }
        if (this.ab >= j) {
          this.ab = j;
        }
        if (this.a != null)
        {
          f1 = this.a.e();
          if (Math.abs(this.ab - f1) < 0.001D) {
            this.aa = true;
          }
        }
        this.ad = (1.0D / Math.pow(2.0D, 20.0F - this.ab));
        if ((this.A) && (this.a != null))
        {
          if (this.e != true) {
            break label859;
          }
          localGeoPoint = this.a.f();
          if (localGeoPoint != null)
          {
            this.D = localGeoPoint.getLatitudeE6();
            this.E = localGeoPoint.getLongitudeE6();
            this.F = (this.B - this.D);
            this.G = (this.C - this.E);
          }
        }
        if (this.J)
        {
          if (this.a != null) {
            this.L = this.a.c();
          }
          this.M = (this.K - this.L);
          if (this.M <= 180.0F) {
            break label873;
          }
          this.M -= 360.0F;
        }
        label345:
        if ((this.O) && (this.a != null))
        {
          this.Q = this.a.d();
          this.R = (this.P - this.Q);
        }
        this.c = SystemClock.uptimeMillis();
      }
    }
    else
    {
      if (this.X) {
        break label899;
      }
      f2 = (float)(SystemClock.uptimeMillis() - this.c) / (float)this.b;
      f1 = f2;
      if (f2 <= 1.0F) {}
    }
    label899:
    for (float f1 = 1.0F;; f1 = 1.0F)
    {
      f2 = this.W.getInterpolation(f1);
      this.X = true;
      if (this.f)
      {
        this.r = ((int)(this.g * f2));
        this.s = ((int)(this.h * f2));
        i = this.r;
        j = this.Y;
        int k = this.s;
        int m = this.Z;
        this.Y = this.r;
        this.Z = this.s;
        this.r = (i - j);
        this.s = (k - m);
        if ((Math.abs(this.g) > 0) || (Math.abs(this.h) > 0)) {
          this.X = false;
        }
      }
      if ((this.t) || (this.u) || (this.v))
      {
        this.w = (this.ae + (this.ad - this.ae) * f2);
        if (!this.aa) {
          this.X = false;
        }
      }
      if (this.A)
      {
        this.H = (this.D + (int)(this.F * f2));
        this.I = (this.E + (int)(this.G * f2));
        if ((Math.abs(this.F) > 1) || (Math.abs(this.G) > 1)) {
          this.X = false;
        }
      }
      if (this.J)
      {
        this.N = (this.L + this.M * f2);
        if (Math.abs(this.M) > 1.0F) {
          this.X = false;
        }
      }
      if (this.O)
      {
        float f3 = this.Q;
        this.S = (f2 * this.R + f3);
        if (Math.abs(this.R) > 1.0F) {
          this.X = false;
        }
      }
      if (f1 >= 1.0F)
      {
        if ((this.d != null) && (this.a != null)) {
          this.a.a(this.T);
        }
        return true;
        i = 20;
        break;
        label799:
        if (!this.u) {
          break label202;
        }
        if (Math.abs(this.ac) < 0.001D) {
          this.aa = true;
        }
        this.ad = (1.0D / Math.pow(2.0D, 20.0F - (this.a.e() + this.ac)));
        break label202;
        label859:
        localGeoPoint = this.a.b();
        break label235;
        label873:
        if (this.M >= -180.0F) {
          break label345;
        }
        this.M += 360.0F;
        break label345;
      }
      return false;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.pd
 * JD-Core Version:    0.7.0.1
 */