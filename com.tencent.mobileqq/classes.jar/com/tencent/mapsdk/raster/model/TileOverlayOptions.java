package com.tencent.mapsdk.raster.model;

public final class TileOverlayOptions
{
  private boolean diskCacheEnabled = true;
  private TileProvider tileProvider;
  private boolean visible = true;
  private float zIndex = 1.0F;
  
  public final TileOverlayOptions diskCacheEnabled(boolean paramBoolean)
  {
    this.diskCacheEnabled = paramBoolean;
    return this;
  }
  
  public final boolean getDiskCacheEnabled()
  {
    return this.diskCacheEnabled;
  }
  
  public final TileProvider getTileProvider()
  {
    return this.tileProvider;
  }
  
  public final float getZIndex()
  {
    return this.zIndex;
  }
  
  public final boolean isVisible()
  {
    return this.visible;
  }
  
  public final TileOverlayOptions tileProvider(TileProvider paramTileProvider)
  {
    this.tileProvider = paramTileProvider;
    return this;
  }
  
  public final TileOverlayOptions visible(boolean paramBoolean)
  {
    this.visible = paramBoolean;
    return this;
  }
  
  public final TileOverlayOptions zIndex(float paramFloat)
  {
    this.zIndex = paramFloat;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.TileOverlayOptions
 * JD-Core Version:    0.7.0.1
 */