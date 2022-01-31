package com.tencent.mapsdk.raster.model;

import com.tencent.mapsdk.rastercore.tile.MapTile.MapSource;
import com.tencent.mapsdk.rastercore.tile.c;
import java.net.URL;

public abstract class UrlTileProvider
  implements TileProvider
{
  public final Tile getTile(int paramInt1, int paramInt2, int paramInt3, MapTile.MapSource paramMapSource, Object... paramVarArgs)
  {
    paramMapSource = getTileUrl(paramInt1, paramInt2, paramInt3, paramVarArgs);
    if (paramMapSource == null) {
      return null;
    }
    return new Tile(paramInt1, paramInt2, paramInt3, c.a(paramMapSource));
  }
  
  public abstract URL getTileUrl(int paramInt1, int paramInt2, int paramInt3, Object... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.UrlTileProvider
 * JD-Core Version:    0.7.0.1
 */