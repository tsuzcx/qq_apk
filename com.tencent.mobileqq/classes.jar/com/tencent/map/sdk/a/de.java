package com.tencent.map.sdk.a;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import com.tencent.mobileqq.qmethodmonitor.monitor.LocationMonitor;

public final class de
{
  public static String a;
  public static String b;
  public static boolean c = false;
  
  public static boolean a(Context paramContext)
  {
    try
    {
      if (as.a("platform_obtain_location", 0, 1, 1) == 0) {
        return false;
      }
      paramContext = (LocationManager)paramContext.getSystemService("location");
      Object localObject = new Criteria();
      ((Criteria)localObject).setAccuracy(2);
      ((Criteria)localObject).setAltitudeRequired(false);
      ((Criteria)localObject).setBearingRequired(false);
      ((Criteria)localObject).setSpeedRequired(false);
      ((Criteria)localObject).setPowerRequirement(1);
      ((Criteria)localObject).setHorizontalAccuracy(2);
      ((Criteria)localObject).setVerticalAccuracy(2);
      localObject = paramContext.getBestProvider((Criteria)localObject, false);
      if (localObject == null) {
        return false;
      }
      paramContext = LocationMonitor.getLastKnownLocation(paramContext, (String)localObject);
      if (paramContext != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramContext.getLatitude());
        b = ((StringBuilder)localObject).toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramContext.getLongitude());
        a = ((StringBuilder)localObject).toString();
        c = true;
        return true;
      }
      return false;
    }
    catch (Throwable paramContext) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.de
 * JD-Core Version:    0.7.0.1
 */