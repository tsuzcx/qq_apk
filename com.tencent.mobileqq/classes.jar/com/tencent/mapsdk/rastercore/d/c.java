package com.tencent.mapsdk.rastercore.d;

import android.graphics.PointF;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.CameraPosition.Builder;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.rastercore.b.d;
import com.tencent.mapsdk.rastercore.b.e;

public final class c
{
  private static final e a = new e(new com.tencent.mapsdk.rastercore.b.f(-20037508.34D, -20037508.34D), new com.tencent.mapsdk.rastercore.b.f(20037508.34D, 20037508.34D));
  private f b;
  private b c;
  private d d;
  private d e;
  private boolean f = false;
  private e g;
  private double h = 0.0D;
  private double i = 0.0D;
  
  public c(f paramf)
  {
    this.b = paramf;
  }
  
  private double a(double paramDouble)
  {
    return this.c.d().d() * Math.cos(0.0174532925199433D * paramDouble);
  }
  
  private double a(boolean paramBoolean)
  {
    LatLngBounds localLatLngBounds = c();
    if (paramBoolean) {
      return Math.abs(localLatLngBounds.getNortheast().getLongitude() - localLatLngBounds.getSouthwest().getLongitude());
    }
    return Math.abs(localLatLngBounds.getNortheast().getLatitude() - localLatLngBounds.getSouthwest().getLatitude());
  }
  
  private com.tencent.mapsdk.rastercore.b.f[] k()
  {
    int j = this.c.getWidth();
    return new com.tencent.mapsdk.rastercore.b.f[] { com.tencent.mapsdk.rastercore.c.a(new PointF(0.0F, this.c.getHeight()), this.c.b(), this.c.a(), this.c.d()), com.tencent.mapsdk.rastercore.c.a(new PointF(j, 0.0F), this.c.b(), this.c.a(), this.c.d()) };
  }
  
  public final float a(double paramDouble1, double paramDouble2)
  {
    return (float)(paramDouble2 / a(paramDouble1));
  }
  
  public final float a(float paramFloat)
  {
    return (float)(paramFloat / a(0.0D));
  }
  
  public final PointF a(LatLng paramLatLng)
  {
    com.tencent.mapsdk.rastercore.b.f localf = this.c.b();
    PointF localPointF = this.c.a();
    d locald = this.c.d();
    paramLatLng = com.tencent.mapsdk.rastercore.c.a(paramLatLng);
    double d3 = paramLatLng.b();
    double d4 = localf.b();
    double d1 = paramLatLng.a();
    double d2 = localf.a();
    d3 = (d3 - d4) / locald.d();
    d1 = (d1 - d2) / locald.d();
    paramLatLng = new PointF();
    paramLatLng.x = ((float)(d3 + localPointF.x));
    paramLatLng.y = ((float)(localPointF.y - d1));
    return paramLatLng;
  }
  
  public final LatLng a(int paramInt1, int paramInt2)
  {
    return com.tencent.mapsdk.rastercore.c.a(com.tencent.mapsdk.rastercore.c.a(new PointF(paramInt1, paramInt2), this.c.b(), this.c.a(), this.c.d()));
  }
  
  public final d a(d paramd)
  {
    int j;
    double d2;
    double d3;
    double d1;
    label67:
    d locald2;
    if ((this.b.f().a() >= 3) && (this.b.f().b() > 1.0F))
    {
      j = 1;
      d2 = paramd.c();
      d3 = this.e.a();
      if (j == 0) {
        break label200;
      }
      d1 = Math.log(1.3D) / Math.log(2.0D);
      if (d2 >= d1 + d3) {
        break label210;
      }
      locald2 = new d(this.e.c());
      locald1 = locald2;
      if (j != 0) {
        locald2.a(1.3D);
      }
    }
    label200:
    label210:
    for (d locald1 = locald2;; locald1 = paramd)
    {
      d2 = paramd.c();
      d3 = this.d.c();
      if (j != 0) {}
      for (d1 = Math.log(1.3D) / Math.log(2.0D);; d1 = 0.0D)
      {
        if (d2 > d1 + d3)
        {
          paramd = new d(this.d.c());
          locald1 = paramd;
          if (j != 0)
          {
            paramd.a(1.3D);
            locald1 = paramd;
          }
        }
        return locald1;
        j = 0;
        break;
        d1 = 0.0D;
        break label67;
      }
    }
  }
  
  public final void a()
  {
    this.g = a;
    this.d = new d(19.0D);
    this.e = new d(d.a);
    this.c = this.b.c();
  }
  
  protected final void a(int paramInt)
  {
    this.h = 0.0D;
  }
  
  public final void a(com.tencent.mapsdk.rastercore.b.f paramf)
  {
    double d2 = 0.0D;
    if (this.g == null) {
      return;
    }
    com.tencent.mapsdk.rastercore.b.f[] arrayOff = k();
    com.tencent.mapsdk.rastercore.b.f localf1 = this.g.a();
    com.tencent.mapsdk.rastercore.b.f localf2 = this.g.b();
    if (localf1.a() > arrayOff[0].a()) {}
    for (double d1 = localf1.a() - arrayOff[0].a();; d1 = 0.0D)
    {
      if (localf1.b() > arrayOff[0].b()) {
        d2 = localf1.b() - arrayOff[0].b();
      }
      if (localf2.a() < arrayOff[1].a()) {
        d1 = localf2.a() - arrayOff[1].a();
      }
      if (localf2.b() < arrayOff[1].b()) {
        d2 = localf2.b() - arrayOff[1].b();
      }
      paramf.a(d1 + paramf.a());
      paramf.b(paramf.b() + d2);
      return;
    }
  }
  
  public final boolean a(LatLngBounds paramLatLngBounds)
  {
    if (paramLatLngBounds == null)
    {
      this.g = a;
      this.e.b(d.a);
      this.f = false;
      return true;
    }
    int j = this.c.getHeight();
    int k = this.c.getWidth();
    if ((j == 0) || (k == 0)) {
      return false;
    }
    Object localObject = paramLatLngBounds.getNortheast();
    paramLatLngBounds = paramLatLngBounds.getSouthwest();
    localObject = com.tencent.mapsdk.rastercore.c.a((LatLng)localObject);
    paramLatLngBounds = com.tencent.mapsdk.rastercore.c.a(paramLatLngBounds);
    double d1 = ((com.tencent.mapsdk.rastercore.b.f)localObject).a() - paramLatLngBounds.a();
    double d2 = ((com.tencent.mapsdk.rastercore.b.f)localObject).b() - paramLatLngBounds.b();
    if (j * 1.0F / k > (float)(d1 / d2)) {}
    for (float f1 = (float)(j * d.c(19.0D) / d1); f1 > 2.0F; f1 = (float)(k * d.c(19.0D) / d2)) {
      return false;
    }
    this.e.a(19);
    this.e.a(f1);
    this.c.d().b(this.e.c());
    this.g = new e(paramLatLngBounds, (com.tencent.mapsdk.rastercore.b.f)localObject);
    a(this.c.b());
    this.f = true;
    this.b.a(false, false);
    return true;
  }
  
  protected final void b(double paramDouble1, double paramDouble2)
  {
    if ((paramDouble1 <= 0.0D) || (paramDouble2 <= 0.0D)) {
      return;
    }
    double d1 = a(true);
    double d2 = a(false);
    if ((d1 == 0.0D) && (d2 == 0.0D))
    {
      this.h = paramDouble1;
      this.i = paramDouble2;
      return;
    }
    paramDouble1 = Math.max(paramDouble1 / d2, paramDouble2 / d1);
    d locald = this.c.d();
    locald.a(paramDouble1 * locald.b());
    a(locald);
    this.b.a(false, false);
  }
  
  protected final void b(int paramInt)
  {
    this.i = 0.0D;
  }
  
  public final com.tencent.mapsdk.rastercore.b.f[] b()
  {
    int j = 0;
    com.tencent.mapsdk.rastercore.b.f[] arrayOff = new com.tencent.mapsdk.rastercore.b.f[8];
    float f1 = this.c.getWidth();
    float f2 = this.c.getHeight();
    PointF localPointF1 = new PointF(0.0F, 0.0F);
    PointF localPointF2 = new PointF(f1 / 2.0F, 0.0F);
    PointF localPointF3 = new PointF(f1, 0.0F);
    PointF localPointF4 = new PointF(f1, f2 / 2.0F);
    PointF localPointF5 = new PointF(f1, f2);
    PointF localPointF6 = new PointF(f1 / 2.0F, f2);
    PointF localPointF7 = new PointF(0.0F, f2);
    PointF localPointF8 = new PointF(0.0F, f2 / 2.0F);
    while (j < 8)
    {
      arrayOff[j] = com.tencent.mapsdk.rastercore.c.a(new PointF[] { localPointF1, localPointF2, localPointF3, localPointF4, localPointF5, localPointF6, localPointF7, localPointF8 }[j], this.c.b(), this.c.a(), this.c.d());
      j += 1;
    }
    return arrayOff;
  }
  
  public final LatLngBounds c()
  {
    com.tencent.mapsdk.rastercore.b.f[] arrayOff = k();
    return new LatLngBounds(com.tencent.mapsdk.rastercore.c.a(arrayOff[0]), com.tencent.mapsdk.rastercore.c.a(arrayOff[1]));
  }
  
  public final void c(int paramInt)
  {
    int j = 19;
    if (paramInt <= this.e.a()) {
      paramInt = this.e.a();
    }
    for (;;)
    {
      if (paramInt >= 19) {
        paramInt = j;
      }
      for (;;)
      {
        this.d.b(paramInt);
        if (this.c.d().c() >= this.d.c()) {
          this.c.b(this.d.c(), true, null);
        }
        return;
      }
    }
  }
  
  public final CameraPosition d()
  {
    LatLng localLatLng = com.tencent.mapsdk.rastercore.c.a(this.c.b());
    float f1 = this.c.d().a();
    return CameraPosition.builder().target(localLatLng).zoom(f1).build();
  }
  
  public final void d(int paramInt)
  {
    int j = paramInt;
    if (this.f)
    {
      j = paramInt;
      if (paramInt <= this.e.c()) {
        j = this.e.a();
      }
    }
    paramInt = j;
    if (j <= d.a) {
      paramInt = d.a;
    }
    j = paramInt;
    if (paramInt >= this.d.c()) {
      j = this.d.a();
    }
    this.e.b(j);
    if (this.c.d().c() <= this.e.c()) {
      this.c.b(this.e.c(), true, null);
    }
  }
  
  public final double e()
  {
    double d1 = 1.0D;
    if (this.c.d().a() < 7) {}
    for (;;)
    {
      return d1 * this.c.d().d();
      double d2 = 1.0D - Math.abs(this.c.b().a() / 20037508.34D);
      d1 = d2;
      if (d2 < 0.1D) {
        d1 = 0.1D;
      }
    }
  }
  
  public final float f()
  {
    int j = this.c.getWidth();
    return (float)(com.tencent.mapsdk.rastercore.c.a(a(0, 0), a(j, 0)) / j);
  }
  
  protected final double g()
  {
    return this.h;
  }
  
  protected final double h()
  {
    return this.i;
  }
  
  public final d i()
  {
    return this.d;
  }
  
  public final d j()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.d.c
 * JD-Core Version:    0.7.0.1
 */