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
import com.tencent.mapsdk.rastercore.e.e;
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
  private f a;
  private CopyOnWriteArrayList<com.tencent.mapsdk.rastercore.e.c> b = new CopyOnWriteArrayList();
  private SortedMap<String, com.tencent.mapsdk.rastercore.e.a.c> c = new TreeMap();
  private a d = new a((byte)0);
  private int f = 0;
  
  public a(f paramf)
  {
    this.a = paramf;
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
  
  public final com.tencent.mapsdk.rastercore.e.a a(CircleOptions paramCircleOptions)
  {
    paramCircleOptions = new com.tencent.mapsdk.rastercore.e.a(this.a, paramCircleOptions);
    a(paramCircleOptions);
    return paramCircleOptions;
  }
  
  public final com.tencent.mapsdk.rastercore.e.b a(GroundOverlayOptions paramGroundOverlayOptions)
  {
    paramGroundOverlayOptions = new com.tencent.mapsdk.rastercore.e.b(this.a, paramGroundOverlayOptions);
    a(paramGroundOverlayOptions);
    return paramGroundOverlayOptions;
  }
  
  public final com.tencent.mapsdk.rastercore.e.d a(PolygonOptions paramPolygonOptions)
  {
    paramPolygonOptions = new com.tencent.mapsdk.rastercore.e.d(this.a, paramPolygonOptions);
    a(paramPolygonOptions);
    return paramPolygonOptions;
  }
  
  public final e a(PolylineOptions paramPolylineOptions)
  {
    paramPolylineOptions = new com.tencent.mapsdk.rastercore.e.a.d(this.a, paramPolylineOptions);
    a(paramPolylineOptions);
    return paramPolylineOptions;
  }
  
  public final void a()
  {
    try
    {
      Iterator localIterator = this.c.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mapsdk.rastercore.e.a.c)((Map.Entry)localIterator.next()).getValue()).c();
      }
      this.c.clear();
      localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mapsdk.rastercore.e.c)localIterator.next()).destroy();
      }
      this.b.clear();
      com.tencent.mapsdk.rastercore.f.b.a(this.a.c(), 2);
      return;
    }
    catch (Exception localException) {}
  }
  
  public final void a(Canvas paramCanvas)
  {
    int i = this.b.size();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mapsdk.rastercore.e.c localc = (com.tencent.mapsdk.rastercore.e.c)localIterator.next();
      if ((localc.isVisible()) && ((i <= 20) || (localc.checkInBounds()))) {
        localc.draw(paramCanvas);
      }
    }
  }
  
  public final void a(com.tencent.mapsdk.rastercore.e.c paramc)
  {
    b(paramc.getId());
    this.b.add(paramc);
    if (!(paramc instanceof com.tencent.mapsdk.rastercore.e.a))
    {
      int i = this.f + 1;
      this.f = i;
      if (i > 0) {
        com.tencent.mapsdk.rastercore.f.b.a(this.a.c(), 1);
      }
    }
    if (this.f > 0) {
      this.a.f(false);
    }
    c();
    this.a.a(false, false);
  }
  
  public final boolean a(MotionEvent paramMotionEvent)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mapsdk.rastercore.e.c localc = (com.tencent.mapsdk.rastercore.e.c)localIterator.next();
      if ((localc instanceof Overlay)) {
        ((Overlay)localc).onTouchEvent(paramMotionEvent, this.a.d());
      }
    }
    return false;
  }
  
  public final boolean a(GeoPoint paramGeoPoint)
  {
    boolean bool2 = false;
    Iterator localIterator = this.b.iterator();
    com.tencent.mapsdk.rastercore.e.c localc;
    do
    {
      bool1 = bool2;
      if (!localIterator.hasNext()) {
        break;
      }
      localc = (com.tencent.mapsdk.rastercore.e.c)localIterator.next();
    } while ((!(localc instanceof Overlay)) || (!((Overlay)localc).onTap(paramGeoPoint, this.a.d())));
    boolean bool1 = true;
    if (!bool1)
    {
      localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        localc = (com.tencent.mapsdk.rastercore.e.c)localIterator.next();
        if ((localc instanceof Overlay)) {
          ((Overlay)localc).onEmptyTap(paramGeoPoint);
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
      com.tencent.mapsdk.rastercore.e.c localc = (com.tencent.mapsdk.rastercore.e.c)localIterator.next();
      if (((localc instanceof Overlay)) && (((Overlay)localc).onLongPress(paramGeoPoint, paramMotionEvent, this.a.d()))) {
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
    com.tencent.mapsdk.rastercore.e.c localc;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localc = (com.tencent.mapsdk.rastercore.e.c)localIterator.next();
    } while ((localc == null) || (!localc.getId().equals(paramString)));
    for (paramString = localc; paramString != null; paramString = null)
    {
      boolean bool = this.b.remove(paramString);
      if ((bool) && (!(paramString instanceof com.tencent.mapsdk.rastercore.e.a)))
      {
        int i = this.f - 1;
        this.f = i;
        if (i == 0) {
          com.tencent.mapsdk.rastercore.f.b.a(this.a.c(), 2);
        }
      }
      if (this.f <= 0) {
        this.a.f(true);
      }
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
      this.b.add((com.tencent.mapsdk.rastercore.e.c)localObject);
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
      paramObject1 = (com.tencent.mapsdk.rastercore.e.c)paramObject1;
      paramObject2 = (com.tencent.mapsdk.rastercore.e.c)paramObject2;
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