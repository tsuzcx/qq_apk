package com.tencent.gathererga.core.internal.util;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;

public class LocationInfoUtil
{
  private static volatile LocationInfoUtil jdField_a_of_type_ComTencentGatherergaCoreInternalUtilLocationInfoUtil;
  private double jdField_a_of_type_Double = 0.0D;
  private float jdField_a_of_type_Float = 0.0F;
  private LocationListener jdField_a_of_type_AndroidLocationLocationListener = new LocationInfoUtil.2(this);
  private LocationManager jdField_a_of_type_AndroidLocationLocationManager = null;
  private double b = 0.0D;
  
  private LocationInfoUtil(Context paramContext)
  {
    b(paramContext);
  }
  
  private Location a(Location paramLocation1, Location paramLocation2)
  {
    if (paramLocation1 != null)
    {
      if (paramLocation2 == null) {
        return paramLocation2;
      }
      if (Build.VERSION.SDK_INT >= 17)
      {
        if (paramLocation1.getElapsedRealtimeNanos() >= paramLocation2.getElapsedRealtimeNanos()) {
          return paramLocation1;
        }
        return paramLocation2;
      }
      if (paramLocation1.getTime() >= paramLocation2.getTime()) {
        return paramLocation1;
      }
      return paramLocation2;
    }
    return paramLocation2;
  }
  
  public static LocationInfoUtil a(Context paramContext)
  {
    if (jdField_a_of_type_ComTencentGatherergaCoreInternalUtilLocationInfoUtil == null) {
      try
      {
        if (jdField_a_of_type_ComTencentGatherergaCoreInternalUtilLocationInfoUtil == null) {
          jdField_a_of_type_ComTencentGatherergaCoreInternalUtilLocationInfoUtil = new LocationInfoUtil(paramContext);
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentGatherergaCoreInternalUtilLocationInfoUtil;
  }
  
  private void a()
  {
    GLog.b("stop request location updates.");
    LocationManager localLocationManager = this.jdField_a_of_type_AndroidLocationLocationManager;
    if (localLocationManager != null) {
      localLocationManager.removeUpdates(this.jdField_a_of_type_AndroidLocationLocationListener);
    }
  }
  
  private void a(Context paramContext, LocationManager paramLocationManager)
  {
    GLog.b("--- Init Default Location ---");
    int i = paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION");
    Location localLocation2 = null;
    Location localLocation1;
    if (i == 0) {
      localLocation1 = paramLocationManager.getLastKnownLocation("gps");
    } else {
      localLocation1 = null;
    }
    if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
      localLocation2 = paramLocationManager.getLastKnownLocation("network");
    }
    paramContext = a(localLocation1, localLocation2);
    if (paramContext != null) {
      a(paramContext);
    }
  }
  
  private void a(Location paramLocation)
  {
    this.jdField_a_of_type_Double = paramLocation.getLatitude();
    this.b = paramLocation.getLongitude();
    this.jdField_a_of_type_Float = paramLocation.getAccuracy();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("--- Set current location: ");
    localStringBuilder.append(paramLocation.toString());
    localStringBuilder.append("-timeStamp: ");
    localStringBuilder.append(paramLocation.getTime());
    GLog.b(localStringBuilder.toString());
  }
  
  private static boolean a(Context paramContext)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "android.permission.ACCESS_FINE_LOCATION";
    arrayOfString[1] = "android.permission.ACCESS_COARSE_LOCATION";
    try
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if (paramContext.checkCallingOrSelfPermission(str) == 0)
        {
          GLog.d(String.format("Location Permission %s is required in AndroidManifest.xml", new Object[] { str }));
          return true;
        }
        i += 1;
      }
      return false;
    }
    catch (Throwable paramContext)
    {
      GLog.b("Check required Permissions error", paramContext);
    }
    return false;
  }
  
  private void b(Context paramContext)
  {
    a(paramContext);
  }
  
  private void c(Context paramContext)
  {
    this.jdField_a_of_type_AndroidLocationLocationManager = ((LocationManager)paramContext.getSystemService("location"));
    if (this.jdField_a_of_type_AndroidLocationLocationManager == null)
    {
      GLog.b("### LocationManager unavailable!");
      return;
    }
    GLog.b("use system location");
    this.jdField_a_of_type_AndroidLocationLocationManager.requestLocationUpdates("network", 0L, 0.0F, this.jdField_a_of_type_AndroidLocationLocationListener);
  }
  
  public double a()
  {
    return this.jdField_a_of_type_Double;
  }
  
  public void a(Context paramContext)
  {
    if (!a(paramContext)) {
      return;
    }
    try
    {
      GLog.b("--- Update Location ---");
      a(paramContext, this.jdField_a_of_type_AndroidLocationLocationManager);
      c(paramContext);
      new Handler(Looper.getMainLooper()).postDelayed(new LocationInfoUtil.1(this), 30000L);
      return;
    }
    catch (Exception paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Update location encounter exception: ");
      localStringBuilder.append(paramContext.getMessage());
      GLog.b(localStringBuilder.toString());
    }
  }
  
  public double b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gathererga.core.internal.util.LocationInfoUtil
 * JD-Core Version:    0.7.0.1
 */