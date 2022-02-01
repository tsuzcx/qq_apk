package com.tencent.map.geolocation.sapp;

import android.content.Context;
import c.t.m.sapp.c.q;
import com.tencent.map.geolocation.sapp.internal.TencentExtraKeys;

public class TencentLocationUtils
{
  public TencentLocationUtils()
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
    return q.a(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
  }
  
  public static double distanceBetween(TencentLocation paramTencentLocation1, TencentLocation paramTencentLocation2)
  {
    if ((paramTencentLocation1 != null) && (paramTencentLocation2 != null)) {
      return q.a(paramTencentLocation1.getLatitude(), paramTencentLocation1.getLongitude(), paramTencentLocation2.getLatitude(), paramTencentLocation2.getLongitude());
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
    if (paramContext != null) {
      return (q.g(paramContext) & 0x10) == 0;
    }
    throw new NullPointerException();
  }
  
  public static boolean wgs84ToGcj02(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    if ((paramArrayOfDouble1 != null) && (paramArrayOfDouble2 != null)) {
      try
      {
        if ((paramArrayOfDouble1.length == 2) && (paramArrayOfDouble2.length == 2))
        {
          boolean bool = TencentExtraKeys.wgs84ToGcj02(paramArrayOfDouble1, paramArrayOfDouble2);
          return bool;
        }
      }
      catch (Exception paramArrayOfDouble1)
      {
        paramArrayOfDouble1.printStackTrace();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.geolocation.sapp.TencentLocationUtils
 * JD-Core Version:    0.7.0.1
 */