package com.tencent.mapsdk.rastercore.c;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.rastercore.b.d;

public final class b
  extends a
{
  private int d;
  private int e;
  private LatLngBounds f;
  private int g;
  
  public final void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public final void a(LatLngBounds paramLatLngBounds)
  {
    this.f = paramLatLngBounds;
  }
  
  public final void a(com.tencent.mapsdk.rastercore.d.f paramf)
  {
    com.tencent.mapsdk.rastercore.d.b localb = paramf.c();
    if (this.e == 0)
    {
      i = localb.getHeight() - this.g * 2;
      this.e = i;
      if (this.d != 0) {
        break label91;
      }
    }
    label91:
    for (int i = localb.getWidth() - this.g * 2;; i = this.d - this.g * 2)
    {
      this.d = i;
      if ((this.e != 0) && (this.d != 0)) {
        break label107;
      }
      return;
      i = this.e - this.g * 2;
      break;
    }
    label107:
    Object localObject2 = this.f.getNortheast();
    Object localObject1 = this.f.getSouthwest();
    localObject2 = com.tencent.mapsdk.rastercore.c.a((LatLng)localObject2);
    localObject1 = com.tencent.mapsdk.rastercore.c.a((LatLng)localObject1);
    double d1 = ((com.tencent.mapsdk.rastercore.b.f)localObject2).a() - ((com.tencent.mapsdk.rastercore.b.f)localObject1).a();
    double d3 = ((com.tencent.mapsdk.rastercore.b.f)localObject2).b() - ((com.tencent.mapsdk.rastercore.b.f)localObject1).b();
    float f1;
    if (this.e * 1.0F / this.d < (float)(d1 / d3))
    {
      f1 = (float)(this.e * 156543.03390000001D / d1);
      paramf = paramf.b().a(new d(0, f1));
      double d2 = ((com.tencent.mapsdk.rastercore.b.f)localObject1).b();
      d3 /= 2.0D;
      double d4 = ((com.tencent.mapsdk.rastercore.b.f)localObject1).a();
      localObject1 = new com.tencent.mapsdk.rastercore.b.f(d3 + d2, d1 / 2.0D + d4);
      if (!this.a) {
        break label321;
      }
      localb.a((com.tencent.mapsdk.rastercore.b.f)localObject1, this.b, this.c);
    }
    for (;;)
    {
      localb.b(paramf.c(), this.a, this.c);
      return;
      f1 = (float)(this.d * 156543.03390000001D / d3);
      break;
      label321:
      localb.b((com.tencent.mapsdk.rastercore.b.f)localObject1);
    }
  }
  
  public final void b(int paramInt)
  {
    this.e = paramInt;
  }
  
  public final void c(int paramInt)
  {
    this.g = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.c.b
 * JD-Core Version:    0.7.0.1
 */