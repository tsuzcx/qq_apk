package com.tencent.mapsdk.raster.model;

import android.graphics.DashPathEffect;
import com.tencent.mapsdk.rastercore.e.a;

public final class Circle
  implements IOverlay
{
  private final a iCircleDel;
  
  public Circle(a parama)
  {
    this.iCircleDel = parama;
  }
  
  public final boolean contains(LatLng paramLatLng)
  {
    return this.iCircleDel.b(paramLatLng);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Circle)) {
      return false;
    }
    return this.iCircleDel.equalsRemote(((Circle)paramObject).iCircleDel);
  }
  
  public final LatLng getCenter()
  {
    return this.iCircleDel.a();
  }
  
  public final int getFillColor()
  {
    return this.iCircleDel.e();
  }
  
  public final String getId()
  {
    return this.iCircleDel.getId();
  }
  
  public final double getRadius()
  {
    return this.iCircleDel.b();
  }
  
  public final int getStrokeColor()
  {
    return this.iCircleDel.d();
  }
  
  public final boolean getStrokeDash()
  {
    return this.iCircleDel.f();
  }
  
  public final DashPathEffect getStrokeDashPathEffect()
  {
    return this.iCircleDel.g();
  }
  
  public final float getStrokeWidth()
  {
    return this.iCircleDel.c();
  }
  
  public final float getZIndex()
  {
    return this.iCircleDel.getZIndex();
  }
  
  public final int hashCode()
  {
    return this.iCircleDel.hashCodeRemote();
  }
  
  public final boolean isVisible()
  {
    return this.iCircleDel.isVisible();
  }
  
  public final void remove()
  {
    this.iCircleDel.remove();
  }
  
  public final void setCenter(LatLng paramLatLng)
  {
    this.iCircleDel.a(paramLatLng);
  }
  
  public final void setFillColor(int paramInt)
  {
    this.iCircleDel.b(paramInt);
  }
  
  public final void setRadius(double paramDouble)
  {
    this.iCircleDel.a(paramDouble);
  }
  
  public final void setStrokeColor(int paramInt)
  {
    this.iCircleDel.a(paramInt);
  }
  
  public final void setStrokeDash(boolean paramBoolean)
  {
    this.iCircleDel.a(paramBoolean);
  }
  
  public final void setStrokeWidth(float paramFloat)
  {
    this.iCircleDel.a(paramFloat);
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    this.iCircleDel.setVisible(paramBoolean);
  }
  
  public final void setZIndex(float paramFloat)
  {
    this.iCircleDel.setZIndex(paramFloat);
  }
  
  public final void strokeDashPathEffect(DashPathEffect paramDashPathEffect)
  {
    this.iCircleDel.a(paramDashPathEffect);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.Circle
 * JD-Core Version:    0.7.0.1
 */