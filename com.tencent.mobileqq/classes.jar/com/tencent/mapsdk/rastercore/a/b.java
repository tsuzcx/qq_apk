package com.tencent.mapsdk.rastercore.a;

import com.tencent.mapsdk.rastercore.b.c;
import com.tencent.mapsdk.rastercore.d.e;
import com.tencent.tencentmap.mapsdk.map.CancelableCallback;

public final class b
  extends a
{
  private c d;
  private c e;
  private double f;
  private double g;
  
  public b(e parame, c paramc, long paramLong, CancelableCallback paramCancelableCallback)
  {
    super(parame, paramLong, paramCancelableCallback);
    this.e = paramc;
  }
  
  protected final void a(float paramFloat)
  {
    double d1 = this.f;
    double d2 = paramFloat;
    double d3 = this.g;
    double d4 = paramFloat;
    this.d.b(d1 * d2 + this.d.b());
    this.d.a(d3 * d4 + this.d.a());
    this.b.b(this.d);
  }
  
  protected final void c()
  {
    this.d = this.b.b();
    this.f = (this.e.b() - this.d.b());
    this.g = (this.e.a() - this.d.a());
  }
  
  protected final void d()
  {
    this.b.b(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.a.b
 * JD-Core Version:    0.7.0.1
 */