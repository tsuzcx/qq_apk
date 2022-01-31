package com.tencent.mapsdk.rastercore.c;

import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.rastercore.d.b;
import com.tencent.mapsdk.rastercore.d.f;

public final class c
  extends a
{
  private CameraPosition d;
  
  public final void a(CameraPosition paramCameraPosition)
  {
    this.d = paramCameraPosition;
  }
  
  public final void a(f paramf)
  {
    paramf = paramf.c();
    if (this.a) {
      paramf.a(com.tencent.mapsdk.rastercore.c.a(this.d.getTarget()), this.b, this.c);
    }
    for (;;)
    {
      if (this.d.getZoom() > 0.0F) {
        paramf.b(this.d.getZoom(), false, this.c);
      }
      return;
      paramf.b(com.tencent.mapsdk.rastercore.c.a(this.d.getTarget()));
    }
  }
  
  public final boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.c.c
 * JD-Core Version:    0.7.0.1
 */