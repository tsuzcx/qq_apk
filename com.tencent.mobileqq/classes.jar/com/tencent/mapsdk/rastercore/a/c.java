package com.tencent.mapsdk.rastercore.a;

import android.graphics.PointF;
import com.tencent.mapsdk.rastercore.d.b;
import com.tencent.mapsdk.rastercore.d.f;
import com.tencent.tencentmap.mapsdk.map.CancelableCallback;

public final class c
  extends a
{
  private PointF d;
  private double e;
  private double f;
  
  public c(f paramf, double paramDouble, PointF paramPointF, long paramLong, CancelableCallback paramCancelableCallback)
  {
    super(paramf, paramLong, paramCancelableCallback);
    this.e = paramDouble;
    this.d = paramPointF;
  }
  
  protected final void a(float paramFloat)
  {
    this.b.a(this.f * paramFloat, this.d, false, null);
  }
  
  protected final void c()
  {
    double d1 = this.b.c();
    this.f = (this.e - d1);
    new StringBuilder("newZoom:").append(this.e).append(",oldZoom=").append(d1);
  }
  
  protected final void d()
  {
    this.b.a(this.e, this.d, false, 0L, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.a.c
 * JD-Core Version:    0.7.0.1
 */