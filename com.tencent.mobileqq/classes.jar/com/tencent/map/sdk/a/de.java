package com.tencent.map.sdk.a;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;

public final class de
{
  public static String a = null;
  public static String b = null;
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
      paramContext = paramContext.getLastKnownLocation((String)localObject);
      if (paramContext != null)
      {
        b = paramContext.getLatitude();
        a = paramContext.getLongitude();
        c = true;
        return true;
      }
      return false;
    }
    catch (Throwable paramContext) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.de
 * JD-Core Version:    0.7.0.1
 */