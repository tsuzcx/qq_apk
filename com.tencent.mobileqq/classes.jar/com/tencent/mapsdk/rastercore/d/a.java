package com.tencent.mapsdk.rastercore.d;

import android.graphics.Canvas;
import android.os.Handler;
import android.view.MotionEvent;
import com.tencent.mapsdk.raster.model.CircleOptions;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.raster.model.GroundOverlayOptions;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mapsdk.raster.model.PolygonOptions;
import com.tencent.mapsdk.raster.model.PolylineOptions;
import com.tencent.mapsdk.rastercore.tile.MapTile.MapSource;
import com.tencent.tencentmap.mapsdk.map.Overlay;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class a
{
  private static int e = 0;
  private e a;
  private CopyOnWriteArrayList<com.tencent.mapsdk.rastercore.e.b> b = new CopyOnWriteArrayList();
  private SortedMap<String, com.tencent.mapsdk.rastercore.e.a.c> c = new TreeMap();
  private a d = new a((byte)0);
  
  public a(e parame)
  {
    this.a = parame;
  }
  
  public static String a(String paramString)
  {
    e += 1;
    return paramString + e;
  }
  
  public final com.tencent.mapsdk.rastercore.e.a.c a(MarkerOptions paramMarkerOptions)
  {
    paramMarkerOptions = new com.tencent.mapsdk.rastercore.e.a.c(this.a, paramMarkerOptions);
    this.c.put(paramMarkerOptions.m(), paramMarkerOptions);
    return paramMarkerOptions;
  }
  
  public final com.tencent.mapsdk.rastercore.e.a a(GroundOverlayOptions paramGroundOverlayOptions)
  {
    paramGroundOverlayOptions = new com.tencent.mapsdk.rastercore.e.a(this.a, paramGroundOverlayOptions);
    a(paramGroundOverlayOptions);
    return paramGroundOverlayOptions;
  }
  
  public final com.tencent.mapsdk.rastercore.e.c a(PolygonOptions paramPolygonOptions)
  {
    paramPolygonOptions = new com.tencent.mapsdk.rastercore.e.c(this.a, paramPolygonOptions);
    a(paramPolygonOptions);
    return paramPolygonOptions;
  }
  
  public final com.tencent.mapsdk.rastercore.e.d a(PolylineOptions paramPolylineOptions)
  {
    paramPolylineOptions = new com.tencent.mapsdk.rastercore.e.a.d(this.a, paramPolylineOptions);
    a(paramPolylineOptions);
    return paramPolylineOptions;
  }
  
  public final com.tencent.mapsdk.rastercore.tile.a.b a(CircleOptions paramCircleOptions)
  {
    paramCircleOptions = new com.tencent.mapsdk.rastercore.tile.a.b(this.a, paramCircleOptions);
    a(paramCircleOptions);
    return paramCircleOptions;
  }
  
  public final void a()
  {
    try
    {
      Iterator localIterator1 = this.c.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        ((com.tencent.mapsdk.rastercore.e.a.c)((Map.Entry)localIterator1.next()).getValue()).c();
        continue;
        this.a.a(false, false);
      }
    }
    catch (Exception localException) {}
    for (;;)
    {
      return;
      this.c.clear();
      Iterator localIterator2 = this.b.iterator();
      while (localIterator2.hasNext()) {
        ((com.tencent.mapsdk.rastercore.e.b)localIterator2.next()).destroy();
      }
      this.b.clear();
    }
  }
  
  public final void a(Canvas paramCanvas)
  {
    int i = this.b.size();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mapsdk.rastercore.e.b localb = (com.tencent.mapsdk.rastercore.e.b)localIterator.next();
      if ((localb.isVisible()) && ((i <= 20) || (localb.checkInBounds()))) {
        localb.draw(paramCanvas);
      }
    }
  }
  
  public final void a(com.tencent.mapsdk.rastercore.e.b paramb)
  {
    b(paramb.getId());
    this.b.add(paramb);
    c();
    this.a.a(false, false);
  }
  
  public final boolean a(MotionEvent paramMotionEvent)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mapsdk.rastercore.e.b localb = (com.tencent.mapsdk.rastercore.e.b)localIterator.next();
      if ((localb instanceof Overlay)) {
        ((Overlay)localb).onTouchEvent(paramMotionEvent, this.a.d());
      }
    }
    return false;
  }
  
  public final boolean a(GeoPoint paramGeoPoint)
  {
    boolean bool2 = false;
    Iterator localIterator = this.b.iterator();
    com.tencent.mapsdk.rastercore.e.b localb;
    do
    {
      bool1 = bool2;
      if (!localIterator.hasNext()) {
        break;
      }
      localb = (com.tencent.mapsdk.rastercore.e.b)localIterator.next();
    } while ((!(localb instanceof Overlay)) || (!((Overlay)localb).onTap(paramGeoPoint, this.a.d())));
    boolean bool1 = true;
    if (!bool1)
    {
      localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        localb = (com.tencent.mapsdk.rastercore.e.b)localIterator.next();
        if ((localb instanceof Overlay)) {
          ((Overlay)localb).onEmptyTap(paramGeoPoint);
        }
      }
    }
    return bool1;
  }
  
  public final boolean a(GeoPoint paramGeoPoint, MotionEvent paramMotionEvent)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mapsdk.rastercore.e.b localb = (com.tencent.mapsdk.rastercore.e.b)localIterator.next();
      if (((localb instanceof Overlay)) && (((Overlay)localb).onLongPress(paramGeoPoint, paramMotionEvent, this.a.d()))) {
        return true;
      }
    }
    return false;
  }
  
  protected final void b()
  {
    a();
  }
  
  public final boolean b(String paramString)
  {
    Iterator localIterator = this.b.iterator();
    com.tencent.mapsdk.rastercore.e.b localb;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localb = (com.tencent.mapsdk.rastercore.e.b)localIterator.next();
    } while ((localb == null) || (!localb.getId().equals(paramString)));
    for (paramString = localb; paramString != null; paramString = null)
    {
      boolean bool = this.b.remove(paramString);
      this.a.a(false, false);
      return bool;
    }
    return false;
  }
  
  public final void c()
  {
    Object[] arrayOfObject = this.b.toArray();
    Arrays.sort(arrayOfObject, this.d);
    this.b.clear();
    int j = arrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfObject[i];
      this.b.add((com.tencent.mapsdk.rastercore.e.b)localObject);
      i += 1;
    }
  }
  
  public final boolean c(String paramString)
  {
    paramString = (com.tencent.mapsdk.rastercore.e.a.c)this.c.remove(paramString);
    if (paramString == null) {
      return false;
    }
    paramString.c();
    return true;
  }
  
  final class a
    implements Comparator<Object>
  {
    private a() {}
    
    public final int compare(Object paramObject1, Object paramObject2)
    {
      paramObject1 = (com.tencent.mapsdk.rastercore.e.b)paramObject1;
      paramObject2 = (com.tencent.mapsdk.rastercore.e.b)paramObject2;
      if ((paramObject1 != null) && (paramObject2 != null)) {
        try
        {
          if (paramObject1.getZIndex() > paramObject2.getZIndex()) {
            return 1;
          }
          float f1 = paramObject1.getZIndex();
          float f2 = paramObject2.getZIndex();
          if (f1 < f2) {
            return -1;
          }
        }
        catch (Exception paramObject1)
        {
          paramObject1.printStackTrace();
        }
      }
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.d.a
 * JD-Core Version:    0.7.0.1
 */