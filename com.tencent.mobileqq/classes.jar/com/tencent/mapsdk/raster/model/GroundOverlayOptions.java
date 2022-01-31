package com.tencent.mapsdk.raster.model;

import android.os.IBinder;

public final class GroundOverlayOptions
{
  private float anchorU = 0.5F;
  private float anchorV = 0.5F;
  private float bearing;
  private BitmapDescriptor bitmapDescriptor;
  private float height;
  private boolean isVisible = true;
  private LatLng latLng;
  private LatLngBounds latlngBounds;
  private float transparency = 0.0F;
  private float width;
  private float zIndex;
  
  public GroundOverlayOptions() {}
  
  protected GroundOverlayOptions(int paramInt, IBinder paramIBinder, LatLng paramLatLng, float paramFloat1, float paramFloat2, LatLngBounds paramLatLngBounds, float paramFloat3, float paramFloat4, boolean paramBoolean, float paramFloat5, float paramFloat6, float paramFloat7)
  {
    this.bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(null);
    this.latLng = paramLatLng;
    this.width = paramFloat1;
    this.height = paramFloat2;
    this.latlngBounds = paramLatLngBounds;
    this.bearing = paramFloat3;
    this.zIndex = paramFloat4;
    this.isVisible = paramBoolean;
    this.transparency = paramFloat5;
    this.anchorU = paramFloat6;
    this.anchorV = paramFloat7;
  }
  
  public final GroundOverlayOptions anchor(float paramFloat1, float paramFloat2)
  {
    this.anchorU = paramFloat1;
    this.anchorV = paramFloat2;
    return this;
  }
  
  public final GroundOverlayOptions bearing(float paramFloat)
  {
    this.bearing = paramFloat;
    return this;
  }
  
  public final float getAnchorU()
  {
    return this.anchorU;
  }
  
  public final float getAnchorV()
  {
    return this.anchorV;
  }
  
  public final float getBearing()
  {
    return this.bearing;
  }
  
  public final LatLngBounds getBounds()
  {
    return this.latlngBounds;
  }
  
  public final float getHeight()
  {
    return this.height;
  }
  
  public final BitmapDescriptor getImage()
  {
    return this.bitmapDescriptor;
  }
  
  public final LatLng getLocation()
  {
    return this.latLng;
  }
  
  public final float getTransparency()
  {
    return this.transparency;
  }
  
  public final float getWidth()
  {
    return this.width;
  }
  
  public final float getZIndex()
  {
    return this.zIndex;
  }
  
  public final GroundOverlayOptions image(BitmapDescriptor paramBitmapDescriptor)
  {
    this.bitmapDescriptor = paramBitmapDescriptor;
    return this;
  }
  
  public final boolean isVisible()
  {
    return this.isVisible;
  }
  
  public final GroundOverlayOptions position(LatLng paramLatLng, float paramFloat)
  {
    return putGroundOverlayOptions(paramLatLng, paramFloat, paramFloat);
  }
  
  public final GroundOverlayOptions position(LatLng paramLatLng, float paramFloat1, float paramFloat2)
  {
    return putGroundOverlayOptions(paramLatLng, paramFloat1, paramFloat2);
  }
  
  public final GroundOverlayOptions positionFromBounds(LatLngBounds paramLatLngBounds)
  {
    this.latlngBounds = paramLatLngBounds;
    return this;
  }
  
  protected final GroundOverlayOptions putGroundOverlayOptions(LatLng paramLatLng, float paramFloat1, float paramFloat2)
  {
    this.latLng = paramLatLng;
    this.width = paramFloat1;
    this.height = paramFloat2;
    return this;
  }
  
  public final GroundOverlayOptions transparency(float paramFloat)
  {
    this.transparency = paramFloat;
    return this;
  }
  
  public final GroundOverlayOptions visible(boolean paramBoolean)
  {
    this.isVisible = paramBoolean;
    return this;
  }
  
  public final GroundOverlayOptions zIndex(float paramFloat)
  {
    this.zIndex = paramFloat;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.GroundOverlayOptions
 * JD-Core Version:    0.7.0.1
 */