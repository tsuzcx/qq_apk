package com.tencent.mapsdk.raster.model;

import com.tencent.mapsdk.rastercore.e.a.f;

public final class TileOverlay
  implements IOverlay
{
  private f delegate;
  
  public TileOverlay(f paramf)
  {
    this.delegate = paramf;
  }
  
  public final void clearTileCache()
  {
    f localf = this.delegate;
    f.c();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof TileOverlay)) {
      return false;
    }
    paramObject = (TileOverlay)paramObject;
    return this.delegate.equals(paramObject.delegate);
  }
  
  public final String getId()
  {
    return this.delegate.d();
  }
  
  public final int hashCode()
  {
    return this.delegate.hashCode();
  }
  
  public final boolean isVisible()
  {
    return this.delegate.e();
  }
  
  public final void remove()
  {
    this.delegate.b();
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    this.delegate.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.TileOverlay
 * JD-Core Version:    0.7.0.1
 */