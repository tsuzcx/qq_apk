package com.tencent.featuretoggle.hltxkg.common.e;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import com.tencent.featuretoggle.hltxkg.common.a.i;

public final class a
{
  public static boolean a = false;
  
  public static boolean a(Context paramContext)
  {
    try
    {
      if (i.a("platform_obtain_location", 0, 1, 1) == 0) {
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
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramContext.getLatitude());
        ((StringBuilder)localObject).toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramContext.getLongitude());
        ((StringBuilder)localObject).toString();
        a = true;
        return true;
      }
      return false;
    }
    catch (Throwable paramContext) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.e.a
 * JD-Core Version:    0.7.0.1
 */