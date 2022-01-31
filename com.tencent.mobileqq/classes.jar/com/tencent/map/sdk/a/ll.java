package com.tencent.map.sdk.a;

import android.graphics.Color;
import android.location.Location;
import com.tencent.tencentmap.mapsdk.maps.LocationSource;
import com.tencent.tencentmap.mapsdk.maps.LocationSource.OnLocationChangedListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMyLocationChangeListener;
import com.tencent.tencentmap.mapsdk.maps.model.Circle;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MyLocationStyle;

public final class ll
  implements kv
{
  public km a = null;
  public kh b = null;
  public ki c = null;
  Marker d = null;
  Circle e = null;
  public TencentMap.OnMyLocationChangeListener f = null;
  MyLocationStyle g = new MyLocationStyle();
  Location h = null;
  private LocationSource.OnLocationChangedListener i = null;
  private LocationSource j = null;
  private boolean k = false;
  private int l = Color.argb(102, 0, 163, 255);
  
  public ll(km paramkm, kh paramkh, ki paramki)
  {
    this.a = paramkm;
    this.b = paramkh;
    this.c = paramki;
    this.i = e();
  }
  
  private LocationSource.OnLocationChangedListener e()
  {
    return new ll.1(this);
  }
  
  public final void a()
  {
    if (this.k == true) {}
    do
    {
      return;
      this.k = true;
      if (this.i == null) {
        this.i = e();
      }
      if (this.d != null) {
        this.d.setVisible(true);
      }
      if (this.e != null) {
        this.e.setVisible(true);
      }
    } while (this.j == null);
    this.j.activate(this.i);
  }
  
  public final void a(LocationSource paramLocationSource)
  {
    this.j = paramLocationSource;
    if ((!this.k) || (paramLocationSource == null)) {
      return;
    }
    this.j.activate(this.i);
  }
  
  public final void a(MyLocationStyle paramMyLocationStyle)
  {
    this.g = paramMyLocationStyle;
    if (this.e != null)
    {
      this.e.setFillColor(paramMyLocationStyle.getFillColor());
      this.e.setStrokeColor(paramMyLocationStyle.getStrokeColor());
      this.e.setStrokeWidth(paramMyLocationStyle.getStrokeWidth());
    }
    if (this.d != null)
    {
      this.d.setIcon(paramMyLocationStyle.getMyLocationIcon());
      this.d.setAnchor(paramMyLocationStyle.getAnchorU(), paramMyLocationStyle.getAnchorV());
    }
  }
  
  public final void b()
  {
    if (this.d != null)
    {
      this.d.setVisible(false);
      this.d.remove();
      this.d = null;
    }
    if (this.e != null)
    {
      this.e.setVisible(false);
      this.e.remove();
      this.e = null;
    }
    if (!this.k) {}
    do
    {
      return;
      this.k = false;
      this.i = null;
    } while (this.j == null);
    this.j.deactivate();
  }
  
  public final boolean c()
  {
    return this.k;
  }
  
  public final Location d()
  {
    if (this.h == null) {
      return null;
    }
    return new Location(this.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.ll
 * JD-Core Version:    0.7.0.1
 */