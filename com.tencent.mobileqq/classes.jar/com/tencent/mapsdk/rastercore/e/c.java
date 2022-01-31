package com.tencent.mapsdk.rastercore.e;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.raster.model.LatLngBounds.Builder;
import com.tencent.mapsdk.raster.model.PolygonOptions;
import com.tencent.mapsdk.rastercore.d.a;
import com.tencent.mapsdk.rastercore.d.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c
  implements b
{
  private List<LatLng> a = new ArrayList();
  private int b;
  private int c;
  private LatLngBounds d = null;
  private boolean e = true;
  private float f;
  private float g = 0.0F;
  private String h;
  private e i;
  private a j;
  
  public c(e parame, PolygonOptions paramPolygonOptions)
  {
    this.i = parame;
    this.j = parame.e();
    this.h = getId();
    this.b = paramPolygonOptions.getFillColor();
    b(paramPolygonOptions.getPoints());
    this.e = paramPolygonOptions.isVisible();
    this.f = paramPolygonOptions.getStrokeWidth();
    this.g = paramPolygonOptions.getZIndex();
    this.c = paramPolygonOptions.getStrokeColor();
  }
  
  private void b(List<LatLng> paramList)
  {
    LatLngBounds.Builder localBuilder = LatLngBounds.builder();
    this.a.clear();
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      paramList = null;
      while (localIterator.hasNext())
      {
        LatLng localLatLng = (LatLng)localIterator.next();
        if (!localLatLng.equals(paramList))
        {
          this.a.add(localLatLng);
          localBuilder.include(localLatLng);
          paramList = localLatLng;
        }
      }
      int k = this.a.size();
      if ((k > 1) && (((LatLng)this.a.get(0)).equals((LatLng)this.a.get(k - 1)))) {
        this.a.remove(k - 1);
      }
    }
    this.d = localBuilder.build();
  }
  
  public float a()
  {
    return this.f;
  }
  
  public void a(float paramFloat)
  {
    this.f = paramFloat;
    this.i.a(false, false);
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
    this.i.a(false, false);
  }
  
  public void a(List<LatLng> paramList)
  {
    b(paramList);
    this.i.a(false, false);
  }
  
  public boolean a(LatLng paramLatLng)
  {
    return com.tencent.mapsdk.rastercore.f.b.a(paramLatLng, c());
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void b(int paramInt)
  {
    this.c = paramInt;
    this.i.a(false, false);
  }
  
  public List<LatLng> c()
  {
    return this.a;
  }
  
  public boolean checkInBounds()
  {
    if (this.d == null) {}
    LatLngBounds localLatLngBounds;
    do
    {
      return false;
      localLatLngBounds = this.i.b().c();
      if (localLatLngBounds == null) {
        return true;
      }
    } while ((!this.d.contains(localLatLngBounds)) && (!this.d.intersects(localLatLngBounds)));
    return true;
  }
  
  public int d()
  {
    return this.c;
  }
  
  public void destroy() {}
  
  public void draw(Canvas paramCanvas)
  {
    if ((this.a == null) || (this.a.size() == 0)) {}
    Path localPath;
    Object localObject;
    do
    {
      return;
      localPath = new Path();
      localObject = (LatLng)this.a.get(0);
      new PointF();
      localObject = this.i.b().a((LatLng)localObject);
      localPath.moveTo(((PointF)localObject).x, ((PointF)localObject).y);
      int k = 1;
      while (k < this.a.size())
      {
        localObject = (LatLng)this.a.get(k);
        new PointF();
        localObject = this.i.b().a((LatLng)localObject);
        localPath.lineTo(((PointF)localObject).x, ((PointF)localObject).y);
        k += 1;
      }
      localObject = new Paint();
      ((Paint)localObject).setColor(b());
      ((Paint)localObject).setAntiAlias(true);
      ((Paint)localObject).setStyle(Paint.Style.FILL);
      localPath.close();
      paramCanvas.drawPath(localPath, (Paint)localObject);
    } while (com.tencent.mapsdk.rastercore.f.b.a(a(), 0.0F));
    ((Paint)localObject).setStyle(Paint.Style.STROKE);
    ((Paint)localObject).setColor(d());
    ((Paint)localObject).setStrokeWidth(a());
    paramCanvas.drawPath(localPath, (Paint)localObject);
  }
  
  public boolean equalsRemote(b paramb)
  {
    return (equals(paramb)) || (paramb.getId().equals(getId()));
  }
  
  public String getId()
  {
    if (this.h == null) {
      this.h = a.a("Polygon");
    }
    return this.h;
  }
  
  public float getZIndex()
  {
    return this.g;
  }
  
  public int hashCodeRemote()
  {
    return super.hashCode();
  }
  
  public boolean isVisible()
  {
    return this.e;
  }
  
  public void remove()
  {
    this.j.b(getId());
  }
  
  public void setVisible(boolean paramBoolean)
  {
    this.e = paramBoolean;
    this.i.a(false, false);
  }
  
  public void setZIndex(float paramFloat)
  {
    this.g = paramFloat;
    this.j.c();
    this.i.a(false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.e.c
 * JD-Core Version:    0.7.0.1
 */