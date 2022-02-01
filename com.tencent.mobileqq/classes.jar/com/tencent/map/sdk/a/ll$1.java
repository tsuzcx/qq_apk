package com.tencent.map.sdk.a;

import android.location.Location;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.LocationSource.OnLocationChangedListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMyLocationChangeListener;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.Circle;
import com.tencent.tencentmap.mapsdk.maps.model.CircleOptions;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.MyLocationStyle;

final class ll$1
  implements LocationSource.OnLocationChangedListener
{
  ll$1(ll paramll) {}
  
  public final void onLocationChanged(Location paramLocation)
  {
    if (paramLocation == null) {
      return;
    }
    if (this.a.h == null)
    {
      this.a.h = new Location(paramLocation);
    }
    else
    {
      this.a.h.setLongitude(paramLocation.getLongitude());
      this.a.h.setLatitude(paramLocation.getLatitude());
      this.a.h.setAccuracy(paramLocation.getAccuracy());
      this.a.h.setProvider(paramLocation.getProvider());
      this.a.h.setTime(paramLocation.getTime());
      this.a.h.setSpeed(paramLocation.getSpeed());
      this.a.h.setAltitude(paramLocation.getAltitude());
    }
    ll localll = this.a;
    if (paramLocation != null)
    {
      Object localObject1 = new LatLng(paramLocation.getLatitude(), paramLocation.getLongitude());
      Object localObject2;
      if (localll.e == null)
      {
        localObject2 = new CircleOptions();
        ((CircleOptions)localObject2).radius(paramLocation.getAccuracy()).center((LatLng)localObject1).fillColor(localll.g.getFillColor()).strokeColor(localll.g.getStrokeColor()).strokeWidth(localll.g.getStrokeWidth());
        localll.e = localll.b.a((CircleOptions)localObject2);
      }
      if (localll.d == null)
      {
        localObject1 = new MarkerOptions();
        ((MarkerOptions)localObject1).position(new LatLng(paramLocation.getLatitude(), paramLocation.getLongitude())).anchor(localll.g.getAnchorU(), localll.g.getAnchorV()).icon(localll.g.getMyLocationIcon());
        localll.d = localll.a.a((MarkerOptions)localObject1, localll.a);
        if (localll.d != null) {
          localll.d.setInfoWindowEnable(false);
        }
      }
      localObject1 = localll.g;
      if ((paramLocation != null) && (localObject1 != null))
      {
        localObject2 = new LatLng(paramLocation.getLatitude(), paramLocation.getLongitude());
        if (localll.e != null)
        {
          localll.e.setCenter((LatLng)localObject2);
          localll.e.setRadius(paramLocation.getAccuracy());
        }
        if (localll.d != null) {
          localll.d.setPosition((LatLng)localObject2);
        }
        int i = ((MyLocationStyle)localObject1).getMyLocationType();
        if (i != 1)
        {
          if (i != 2) {
            if (i != 3)
            {
              if (localll.d != null) {
                localll.d.setRotation(paramLocation.getBearing());
              }
              if (localll.c != null) {
                localll.c.a(CameraUpdateFactory.newLatLng((LatLng)localObject2));
              }
            }
            else if (localll.c != null)
            {
              localObject1 = localll.c.a();
              localll.c.a(CameraUpdateFactory.rotateTo(paramLocation.getBearing(), ((CameraPosition)localObject1).tilt));
            }
          }
        }
        else if (localll.d != null) {
          localll.d.setRotation(paramLocation.getBearing());
        }
      }
    }
    if (this.a.f != null) {
      this.a.f.onMyLocationChange(paramLocation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.ll.1
 * JD-Core Version:    0.7.0.1
 */