package com.tencent.mapsdk.raster.model;

import android.graphics.DashPathEffect;
import com.tencent.mapsdk.rastercore.tile.a.b;

public final class Circle
  implements IOverlay
{
  private final b iCircleDel$6689bbe;
  
  public Circle(b paramb)
  {
    this.iCircleDel$6689bbe = paramb;
  }
  
  public final boolean contains(LatLng paramLatLng)
  {
    return this.iCircleDel$6689bbe.b(paramLatLng);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Circle)) {
      return false;
    }
    return this.iCircleDel$6689bbe.equalsRemote(((Circle)paramObject).iCircleDel$6689bbe);
  }
  
  public final LatLng getCenter()
  {
    return this.iCircleDel$6689bbe.a();
  }
  
  public final int getFillColor()
  {
    return this.iCircleDel$6689bbe.e();
  }
  
  public final String getId()
  {
    return this.iCircleDel$6689bbe.getId();
  }
  
  public final double getRadius()
  {
    return this.iCircleDel$6689bbe.b();
  }
  
  public final int getStrokeColor()
  {
    return this.iCircleDel$6689bbe.d();
  }
  
  public final boolean getStrokeDash()
  {
    return this.iCircleDel$6689bbe.f();
  }
  
  public final DashPathEffect getStrokeDashPathEffect()
  {
    return this.iCircleDel$6689bbe.g();
  }
  
  public final float getStrokeWidth()
  {
    return this.iCircleDel$6689bbe.c();
  }
  
  public final float getZIndex()
  {
    return this.iCircleDel$6689bbe.getZIndex();
  }
  
  public final int hashCode()
  {
    return this.iCircleDel$6689bbe.hashCodeRemote();
  }
  
  public final boolean isVisible()
  {
    return this.iCircleDel$6689bbe.isVisible();
  }
  
  public final void remove()
  {
    this.iCircleDel$6689bbe.remove();
  }
  
  public final void setCenter(LatLng paramLatLng)
  {
    this.iCircleDel$6689bbe.a(paramLatLng);
  }
  
  public final void setFillColor(int paramInt)
  {
    this.iCircleDel$6689bbe.b(paramInt);
  }
  
  public final void setRadius(double paramDouble)
  {
    this.iCircleDel$6689bbe.a(paramDouble);
  }
  
  public final void setStrokeColor(int paramInt)
  {
    this.iCircleDel$6689bbe.a(paramInt);
  }
  
  public final void setStrokeDash(boolean paramBoolean)
  {
    this.iCircleDel$6689bbe.a(paramBoolean);
  }
  
  public final void setStrokeWidth(float paramFloat)
  {
    this.iCircleDel$6689bbe.a(paramFloat);
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    this.iCircleDel$6689bbe.setVisible(paramBoolean);
  }
  
  public final void setZIndex(float paramFloat)
  {
    this.iCircleDel$6689bbe.setZIndex(paramFloat);
  }
  
  public final void strokeDashPathEffect(DashPathEffect paramDashPathEffect)
  {
    this.iCircleDel$6689bbe.a(paramDashPathEffect);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.Circle
 * JD-Core Version:    0.7.0.1
 */