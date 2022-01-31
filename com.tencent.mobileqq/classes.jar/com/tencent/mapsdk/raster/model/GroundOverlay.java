package com.tencent.mapsdk.raster.model;

import android.os.RemoteException;
import com.tencent.mapsdk.rastercore.e.a;

public final class GroundOverlay
  implements IOverlay
{
  private a iGroundOverlayDelegate;
  
  public GroundOverlay(a parama)
  {
    this.iGroundOverlayDelegate = parama;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof GroundOverlay)) {
      return false;
    }
    try
    {
      throw new RemoteException();
    }
    catch (RemoteException paramObject) {}
    return false;
  }
  
  public final float getBearing()
  {
    return this.iGroundOverlayDelegate.e();
  }
  
  protected final LatLngBounds getBounds()
  {
    return this.iGroundOverlayDelegate.d();
  }
  
  protected final float getHeight()
  {
    return this.iGroundOverlayDelegate.c();
  }
  
  public final String getId()
  {
    return this.iGroundOverlayDelegate.getId();
  }
  
  protected final LatLng getPosition()
  {
    return this.iGroundOverlayDelegate.a();
  }
  
  protected final float getTransparency()
  {
    return this.iGroundOverlayDelegate.f();
  }
  
  protected final float getWidth()
  {
    return this.iGroundOverlayDelegate.b();
  }
  
  public final float getZIndex()
  {
    return this.iGroundOverlayDelegate.getZIndex();
  }
  
  public final int hashCode()
  {
    return this.iGroundOverlayDelegate.hashCode();
  }
  
  public final boolean isVisible()
  {
    return this.iGroundOverlayDelegate.isVisible();
  }
  
  public final void remove()
  {
    this.iGroundOverlayDelegate.remove();
  }
  
  public final void setAnchor(float paramFloat1, float paramFloat2)
  {
    this.iGroundOverlayDelegate.b(paramFloat1, paramFloat2);
  }
  
  public final void setBearing(float paramFloat)
  {
    this.iGroundOverlayDelegate.b(paramFloat);
  }
  
  protected final void setDimensions(float paramFloat)
  {
    this.iGroundOverlayDelegate.a(paramFloat);
  }
  
  protected final void setDimensions(float paramFloat1, float paramFloat2)
  {
    this.iGroundOverlayDelegate.a(paramFloat1, paramFloat2);
  }
  
  protected final void setImage(BitmapDescriptor paramBitmapDescriptor)
  {
    this.iGroundOverlayDelegate.a(paramBitmapDescriptor);
  }
  
  protected final void setPosition(LatLng paramLatLng)
  {
    this.iGroundOverlayDelegate.a(paramLatLng);
  }
  
  protected final void setPositionFromBounds(LatLngBounds paramLatLngBounds)
  {
    this.iGroundOverlayDelegate.a(paramLatLngBounds);
  }
  
  protected final void setTransparency(float paramFloat)
  {
    this.iGroundOverlayDelegate.c(paramFloat);
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    this.iGroundOverlayDelegate.setVisible(paramBoolean);
  }
  
  public final void setZIndex(float paramFloat)
  {
    this.iGroundOverlayDelegate.setZIndex(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.GroundOverlay
 * JD-Core Version:    0.7.0.1
 */