package com.tencent.mapsdk.rastercore.d;

import android.graphics.PointF;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.CameraPosition.Builder;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.rastercore.b.a;
import com.tencent.mapsdk.rastercore.d.a;

public final class c
{
  private static final com.tencent.mapsdk.rastercore.b.b a = new com.tencent.mapsdk.rastercore.b.b(new com.tencent.mapsdk.rastercore.b.c(-20037508.34D, -20037508.34D), new com.tencent.mapsdk.rastercore.b.c(20037508.34D, 20037508.34D));
  private e b;
  private b c;
  private a d;
  private a e;
  private boolean f = false;
  private com.tencent.mapsdk.rastercore.b.b g;
  private double h = 0.0D;
  private double i = 0.0D;
  
  public c(e parame)
  {
    this.b = parame;
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
  
  private com.tencent.mapsdk.rastercore.b.c[] k()
  {
    int j = this.c.getWidth();
    return new com.tencent.mapsdk.rastercore.b.c[] { d.a.a(new PointF(0.0F, this.c.getHeight()), this.c.b(), this.c.a(), this.c.d()), d.a.a(new PointF(j, 0.0F), this.c.b(), this.c.a(), this.c.d()) };
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
    com.tencent.mapsdk.rastercore.b.c localc = this.c.b();
    PointF localPointF = this.c.a();
    a locala = this.c.d();
    paramLatLng = d.a.a(paramLatLng);
    double d3 = paramLatLng.b();
    double d4 = localc.b();
    double d1 = paramLatLng.a();
    double d2 = localc.a();
    d3 = (d3 - d4) / locala.d();
    d1 = (d1 - d2) / locala.d();
    paramLatLng = new PointF();
    paramLatLng.x = ((float)(d3 + localPointF.x));
    paramLatLng.y = ((float)(localPointF.y - d1));
    return paramLatLng;
  }
  
  public final LatLng a(int paramInt1, int paramInt2)
  {
    return d.a.a(d.a.a(new PointF(paramInt1, paramInt2), this.c.b(), this.c.a(), this.c.d()));
  }
  
  public final a a(a parama)
  {
    int j;
    double d2;
    double d3;
    double d1;
    label67:
    a locala2;
    if ((this.b.f().a() >= 3) && (this.b.f().b() > 1.0F))
    {
      j = 1;
      d2 = parama.c();
      d3 = this.e.a();
      if (j == 0) {
        break label200;
      }
      d1 = Math.log(1.3D) / Math.log(2.0D);
      if (d2 >= d1 + d3) {
        break label210;
      }
      locala2 = new a(this.e.c());
      locala1 = locala2;
      if (j != 0) {
        locala2.a(1.3D);
      }
    }
    label200:
    label210:
    for (a locala1 = locala2;; locala1 = parama)
    {
      d2 = parama.c();
      d3 = this.d.c();
      if (j != 0) {}
      for (d1 = Math.log(1.3D) / Math.log(2.0D);; d1 = 0.0D)
      {
        if (d2 > d1 + d3)
        {
          parama = new a(this.d.c());
          locala1 = parama;
          if (j != 0)
          {
            parama.a(1.3D);
            locala1 = parama;
          }
        }
        return locala1;
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
    this.d = new a(18.0D);
    this.e = new a(a.a);
    this.c = this.b.c();
  }
  
  protected final void a(int paramInt)
  {
    this.h = 0.0D;
  }
  
  public final void a(com.tencent.mapsdk.rastercore.b.c paramc)
  {
    double d2 = 0.0D;
    if (this.g == null) {
      return;
    }
    com.tencent.mapsdk.rastercore.b.c[] arrayOfc = k();
    com.tencent.mapsdk.rastercore.b.c localc1 = this.g.a();
    com.tencent.mapsdk.rastercore.b.c localc2 = this.g.b();
    if (localc1.a() > arrayOfc[0].a()) {}
    for (double d1 = localc1.a() - arrayOfc[0].a();; d1 = 0.0D)
    {
      if (localc1.b() > arrayOfc[0].b()) {
        d2 = localc1.b() - arrayOfc[0].b();
      }
      if (localc2.a() < arrayOfc[1].a()) {
        d1 = localc2.a() - arrayOfc[1].a();
      }
      if (localc2.b() < arrayOfc[1].b()) {
        d2 = localc2.b() - arrayOfc[1].b();
      }
      paramc.a(d1 + paramc.a());
      paramc.b(paramc.b() + d2);
      return;
    }
  }
  
  public final boolean a(LatLngBounds paramLatLngBounds)
  {
    if (paramLatLngBounds == null)
    {
      this.g = a;
      this.e.b(a.a);
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
    localObject = d.a.a((LatLng)localObject);
    paramLatLngBounds = d.a.a(paramLatLngBounds);
    double d1 = ((com.tencent.mapsdk.rastercore.b.c)localObject).a() - paramLatLngBounds.a();
    double d2 = ((com.tencent.mapsdk.rastercore.b.c)localObject).b() - paramLatLngBounds.b();
    if (j * 1.0F / k > (float)(d1 / d2)) {}
    for (float f1 = (float)(j * a.c(19.0D) / d1); f1 > 2.0F; f1 = (float)(k * a.c(19.0D) / d2)) {
      return false;
    }
    this.e.a(19);
    this.e.a(f1);
    this.c.d().b(this.e.c());
    this.g = new com.tencent.mapsdk.rastercore.b.b(paramLatLngBounds, (com.tencent.mapsdk.rastercore.b.c)localObject);
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
    a locala = this.c.d();
    locala.a(paramDouble1 * locala.b());
    a(locala);
    this.b.a(false, false);
  }
  
  protected final void b(int paramInt)
  {
    this.i = 0.0D;
  }
  
  public final com.tencent.mapsdk.rastercore.b.c[] b()
  {
    int j = 0;
    com.tencent.mapsdk.rastercore.b.c[] arrayOfc = new com.tencent.mapsdk.rastercore.b.c[8];
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
      arrayOfc[j] = d.a.a(new PointF[] { localPointF1, localPointF2, localPointF3, localPointF4, localPointF5, localPointF6, localPointF7, localPointF8 }[j], this.c.b(), this.c.a(), this.c.d());
      j += 1;
    }
    return arrayOfc;
  }
  
  public final LatLngBounds c()
  {
    com.tencent.mapsdk.rastercore.b.c[] arrayOfc = k();
    return new LatLngBounds(d.a.a(arrayOfc[0]), d.a.a(arrayOfc[1]));
  }
  
  public final void c(int paramInt)
  {
    int j = 18;
    if ((this.f) && (paramInt >= this.d.c())) {
      paramInt = this.d.a();
    }
    for (;;)
    {
      if (paramInt >= 18) {
        paramInt = j;
      }
      for (;;)
      {
        j = paramInt;
        if (paramInt <= this.e.c()) {
          j = this.e.a();
        }
        this.d.b(j);
        return;
      }
    }
  }
  
  public final CameraPosition d()
  {
    LatLng localLatLng = d.a.a(this.c.b());
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
    if (j <= a.a) {
      paramInt = a.a;
    }
    j = paramInt;
    if (paramInt >= this.d.c()) {
      j = this.d.a();
    }
    this.e.b(j);
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
    return (float)(d.a.a(a(0, 0), a(j, 0)) / j);
  }
  
  protected final double g()
  {
    return this.h;
  }
  
  protected final double h()
  {
    return this.i;
  }
  
  public final a i()
  {
    return this.d;
  }
  
  public final a j()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.d.c
 * JD-Core Version:    0.7.0.1
 */