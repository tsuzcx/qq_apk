package com.tencent.mapsdk.rastercore.tile.b;

import com.tencent.mapsdk.raster.model.TileProvider;
import com.tencent.mapsdk.rastercore.d.a.1;
import com.tencent.mapsdk.rastercore.tile.MapTile.MapSource;
import java.util.Map;
import java.util.WeakHashMap;

public final class b
{
  private static Map<MapTile.MapSource, TileProvider> a = new WeakHashMap();
  
  public static TileProvider a(com.tencent.mapsdk.rastercore.d.f paramf, MapTile.MapSource paramMapSource)
  {
    if (paramf.f().a() > 1) {}
    for (int i = 2;; i = 1)
    {
      paramf = (TileProvider)a.get(paramMapSource);
      if (paramf == null) {
        break;
      }
      return paramf;
    }
    switch (1.a[paramMapSource.ordinal()])
    {
    default: 
      return null;
    case 1: 
      paramf = new d(i);
    }
    for (;;)
    {
      a.put(paramMapSource, paramf);
      return paramf;
      paramf = new f(i);
      continue;
      paramf = new c(i);
      continue;
      paramf = new e(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.tile.b.b
 * JD-Core Version:    0.7.0.1
 */