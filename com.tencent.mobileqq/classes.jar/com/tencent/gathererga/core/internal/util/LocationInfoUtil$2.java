package com.tencent.gathererga.core.internal.util;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

class LocationInfoUtil$2
  implements LocationListener
{
  LocationInfoUtil$2(LocationInfoUtil paramLocationInfoUtil) {}
  
  public void onLocationChanged(Location paramLocation)
  {
    if (paramLocation != null)
    {
      GLog.b("--- LocationListener ## onLocationChanged");
      LocationInfoUtil.a(this.a, paramLocation);
      LocationInfoUtil.a(this.a);
    }
  }
  
  public void onProviderDisabled(String paramString) {}
  
  public void onProviderEnabled(String paramString) {}
  
  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.core.internal.util.LocationInfoUtil.2
 * JD-Core Version:    0.7.0.1
 */