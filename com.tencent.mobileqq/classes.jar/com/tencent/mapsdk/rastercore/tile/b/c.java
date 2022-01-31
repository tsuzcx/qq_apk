package com.tencent.mapsdk.rastercore.tile.b;

import com.tencent.mapsdk.raster.model.TileProvider;
import com.tencent.mapsdk.rastercore.tile.MapTile.MapSource;
import java.util.Map;
import java.util.WeakHashMap;

public final class c
{
  private static Map<MapTile.MapSource, TileProvider> a = new WeakHashMap();
  
  public static TileProvider a(MapTile.MapSource paramMapSource)
  {
    Object localObject = (TileProvider)a.get(paramMapSource);
    if (localObject != null) {
      return localObject;
    }
    switch (1.a[paramMapSource.ordinal()])
    {
    default: 
      return null;
    case 1: 
      localObject = new f();
    }
    for (;;)
    {
      a.put(paramMapSource, localObject);
      return localObject;
      localObject = new b();
      continue;
      localObject = new e();
      continue;
      localObject = new g();
      continue;
      localObject = new d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.tile.b.c
 * JD-Core Version:    0.7.0.1
 */