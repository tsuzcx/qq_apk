package com.tencent.map.geolocation;

import android.content.Context;
import c.t.m.g.fm;
import c.t.m.g.fp;

public class TencentLocationUtils
{
  private TencentLocationUtils()
  {
    throw new UnsupportedOperationException();
  }
  
  public static boolean contains(TencentLocation paramTencentLocation1, double paramDouble, TencentLocation paramTencentLocation2)
  {
    if ((paramTencentLocation1 != null) && (paramTencentLocation2 != null)) {
      return distanceBetween(paramTencentLocation1, paramTencentLocation2) <= paramDouble;
    }
    throw new NullPointerException();
  }
  
  public static double distanceBetween(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    return fp.a(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
  }
  
  public static double distanceBetween(TencentLocation paramTencentLocation1, TencentLocation paramTencentLocation2)
  {
    if ((paramTencentLocation1 != null) && (paramTencentLocation2 != null)) {
      return fp.a(paramTencentLocation1.getLatitude(), paramTencentLocation1.getLongitude(), paramTencentLocation2.getLatitude(), paramTencentLocation2.getLongitude());
    }
    throw new NullPointerException();
  }
  
  public static boolean isFromGps(TencentLocation paramTencentLocation)
  {
    if (paramTencentLocation == null) {
      return false;
    }
    return "gps".equals(paramTencentLocation.getProvider());
  }
  
  public static boolean isFromNetwork(TencentLocation paramTencentLocation)
  {
    if (paramTencentLocation == null) {
      return false;
    }
    return "network".equals(paramTencentLocation.getProvider());
  }
  
  public static boolean isSupportGps(Context paramContext)
  {
    if (paramContext != null)
    {
      fm.a();
      return (fm.a(paramContext) & 0x10) == 0;
    }
    throw new NullPointerException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.geolocation.TencentLocationUtils
 * JD-Core Version:    0.7.0.1
 */