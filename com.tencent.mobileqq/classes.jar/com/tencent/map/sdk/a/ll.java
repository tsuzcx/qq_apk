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
    if (this.k == true) {
      return;
    }
    this.k = true;
    if (this.i == null) {
      this.i = e();
    }
    Object localObject = this.d;
    if (localObject != null) {
      ((Marker)localObject).setVisible(true);
    }
    localObject = this.e;
    if (localObject != null) {
      ((Circle)localObject).setVisible(true);
    }
    localObject = this.j;
    if (localObject != null) {
      ((LocationSource)localObject).activate(this.i);
    }
  }
  
  public final void a(LocationSource paramLocationSource)
  {
    this.j = paramLocationSource;
    if (this.k)
    {
      if (paramLocationSource == null) {
        return;
      }
      this.j.activate(this.i);
    }
  }
  
  public final void a(MyLocationStyle paramMyLocationStyle)
  {
    this.g = paramMyLocationStyle;
    Object localObject = this.e;
    if (localObject != null)
    {
      ((Circle)localObject).setFillColor(paramMyLocationStyle.getFillColor());
      this.e.setStrokeColor(paramMyLocationStyle.getStrokeColor());
      this.e.setStrokeWidth(paramMyLocationStyle.getStrokeWidth());
    }
    localObject = this.d;
    if (localObject != null)
    {
      ((Marker)localObject).setIcon(paramMyLocationStyle.getMyLocationIcon());
      this.d.setAnchor(paramMyLocationStyle.getAnchorU(), paramMyLocationStyle.getAnchorV());
    }
  }
  
  public final void b()
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      ((Marker)localObject).setVisible(false);
      this.d.remove();
      this.d = null;
    }
    localObject = this.e;
    if (localObject != null)
    {
      ((Circle)localObject).setVisible(false);
      this.e.remove();
      this.e = null;
    }
    if (!this.k) {
      return;
    }
    this.k = false;
    this.i = null;
    localObject = this.j;
    if (localObject != null) {
      ((LocationSource)localObject).deactivate();
    }
  }
  
  public final boolean c()
  {
    return this.k;
  }
  
  public final Location d()
  {
    Location localLocation = this.h;
    if (localLocation == null) {
      return null;
    }
    return new Location(localLocation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.ll
 * JD-Core Version:    0.7.0.1
 */