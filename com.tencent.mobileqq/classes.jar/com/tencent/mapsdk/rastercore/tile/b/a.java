package com.tencent.mapsdk.rastercore.tile.b;

import com.tencent.mapsdk.raster.model.UrlTileProvider;

public abstract class a
  extends UrlTileProvider
{
  protected static int a(int paramInt1, int paramInt2)
  {
    int i = paramInt1 % paramInt2;
    paramInt1 = i;
    if (i * paramInt2 < 0) {
      paramInt1 = i + paramInt2;
    }
    return paramInt1;
  }
  
  public int getTileHeight()
  {
    return 256;
  }
  
  public int getTileWidth()
  {
    return 256;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.tile.b.a
 * JD-Core Version:    0.7.0.1
 */