package com.tencent.gathererga.core.internal.util;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.qmethodmonitor.monitor.LocationMonitor;

public class LocationInfoUtil
{
  private static volatile LocationInfoUtil a;
  private double b = 0.0D;
  private double c = 0.0D;
  private float d = 0.0F;
  private LocationManager e = null;
  private LocationListener f = new LocationInfoUtil.2(this);
  
  private LocationInfoUtil(Context paramContext)
  {
    c(paramContext);
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
    if (a == null) {
      try
      {
        if (a == null) {
          a = new LocationInfoUtil(paramContext);
        }
      }
      finally {}
    }
    return a;
  }
  
  private void a(Context paramContext, LocationManager paramLocationManager)
  {
    GLog.b("--- Init Default Location ---");
    int i = paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION");
    Location localLocation2 = null;
    Location localLocation1;
    if (i == 0) {
      localLocation1 = LocationMonitor.getLastKnownLocation(paramLocationManager, "gps");
    } else {
      localLocation1 = null;
    }
    if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
      localLocation2 = LocationMonitor.getLastKnownLocation(paramLocationManager, "network");
    }
    paramContext = a(localLocation1, localLocation2);
    if (paramContext != null) {
      a(paramContext);
    }
  }
  
  private void a(Location paramLocation)
  {
    this.b = paramLocation.getLatitude();
    this.c = paramLocation.getLongitude();
    this.d = paramLocation.getAccuracy();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("--- Set current location: ");
    localStringBuilder.append(paramLocation.toString());
    localStringBuilder.append("-timeStamp: ");
    localStringBuilder.append(paramLocation.getTime());
    GLog.b(localStringBuilder.toString());
  }
  
  private void c()
  {
    GLog.b("stop request location updates.");
    LocationManager localLocationManager = this.e;
    if (localLocationManager != null) {
      localLocationManager.removeUpdates(this.f);
    }
  }
  
  private void c(Context paramContext)
  {
    b(paramContext);
  }
  
  private static boolean d(Context paramContext)
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
  
  private void e(Context paramContext)
  {
    this.e = ((LocationManager)paramContext.getSystemService("location"));
    if (this.e == null)
    {
      GLog.b("### LocationManager unavailable!");
      return;
    }
    GLog.b("use system location");
    LocationMonitor.requestLocationUpdates(this.e, "network", 0L, 0.0F, this.f);
  }
  
  public double a()
  {
    return this.b;
  }
  
  public double b()
  {
    return this.c;
  }
  
  public void b(Context paramContext)
  {
    if (!d(paramContext)) {
      return;
    }
    try
    {
      GLog.b("--- Update Location ---");
      a(paramContext, this.e);
      e(paramContext);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.core.internal.util.LocationInfoUtil
 * JD-Core Version:    0.7.0.1
 */