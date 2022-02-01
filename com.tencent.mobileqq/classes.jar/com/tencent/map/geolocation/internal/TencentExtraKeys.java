package com.tencent.map.geolocation.internal;

import android.location.Location;
import android.os.Bundle;
import androidx.annotation.Nullable;
import c.t.m.g.dh;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.map.geolocation.TencentLocationUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TencentExtraKeys
{
  public static boolean COMPHTTPIO = false;
  public static final TencentLog DEFAULT_TENCENT_LOG = new TencentExtraKeys.1();
  public static final String LOCATION_KEY_ADMIN_LEVEL1 = "admin_level_1";
  public static final String LOCATION_KEY_ADMIN_LEVEL2 = "admin_level_2";
  public static final String LOCATION_KEY_ADMIN_LEVEL3 = "admin_level_3";
  public static final String LOCATION_KEY_LOCALITY = "locality";
  public static final String LOCATION_KEY_NATION = "nation";
  public static final String LOCATION_KEY_ROUTE = "route";
  public static final String LOCATION_KEY_SUBLOCALITY = "sublocality";
  public static final String LOCATION_SOURCE_CELL = "cell";
  public static final String LOCATION_SOURCE_GPS = "gps";
  public static final String LOCATION_SOURCE_WIFI = "wifi";
  public static boolean MOCK_LOCATION_FILTER = true;
  public static final String RAW_DATA = "raw_data";
  public static final String REQUEST_RAW_DATA = "request_raw_data";
  public static final boolean START_LOCAL_SERVER = false;
  public static final boolean STRICT_CELL_FILTER = true;
  public static final boolean TENCENT_INTERNAL = true;
  private static File sLogDir;
  private static TencentLog sTencentLog;
  private static List<TencentLog> sTencentLogs = new ArrayList();
  
  public static void addTencentLog(TencentLog paramTencentLog)
  {
    try
    {
      Iterator localIterator = sTencentLogs.iterator();
      TencentLog localTencentLog;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localTencentLog = (TencentLog)localIterator.next();
      } while ((localTencentLog.getDirString() == null) || (!localTencentLog.getDirString().equals(paramTencentLog.getDirString())));
      i = 1;
    }
    finally
    {
      for (;;)
      {
        for (;;)
        {
          throw paramTencentLog;
        }
        int i = 0;
      }
    }
    if (i == 0)
    {
      sTencentLogs.add(paramTencentLog);
      if (paramTencentLog == null) {
        paramTencentLog = null;
      } else {
        paramTencentLog = new TencentExtraKeys.a((byte)0);
      }
      dh.a(paramTencentLog);
    }
  }
  
  public static String getLocationSource(TencentLocation paramTencentLocation)
  {
    if (paramTencentLocation == null) {
      return "";
    }
    boolean bool1 = TencentLocationUtils.isFromGps(paramTencentLocation);
    boolean bool2 = TencentLocationUtils.isFromNetwork(paramTencentLocation);
    int i = paramTencentLocation.getExtra().getInt("wifi_ap_num");
    if (bool1) {
      return "gps";
    }
    if ((bool2) && (i >= 3)) {
      return "wifi";
    }
    return "cell";
  }
  
  public static File getLogDir()
  {
    try
    {
      File localFile = sLogDir;
      return localFile;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static byte[] getRawData(TencentLocation paramTencentLocation)
  {
    if (paramTencentLocation == null) {
      return null;
    }
    return paramTencentLocation.getExtra().getByteArray("raw_data");
  }
  
  public static Location getRawGps(TencentLocation paramTencentLocation)
  {
    if (paramTencentLocation == null) {
      return null;
    }
    return (Location)paramTencentLocation.getExtra().getParcelable("raw_gps");
  }
  
  public static String getRawQuery(TencentLocation paramTencentLocation)
  {
    if (paramTencentLocation == null) {
      return null;
    }
    return paramTencentLocation.getExtra().getString("raw_query");
  }
  
  @Nullable
  public static List<TencentLog> getTencentLogs()
  {
    try
    {
      List localList = sTencentLogs;
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean isAllowedLevel(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 3) && (paramInt != 4)) {
      return paramInt == 7;
    }
    return true;
  }
  
  /* Error */
  @java.lang.Deprecated
  public static boolean isDebugEnabled()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 183	com/tencent/map/geolocation/internal/TencentExtraKeys:sTencentLog	Lcom/tencent/map/geolocation/internal/TencentLog;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +10 -> 18
    //   11: iconst_1
    //   12: istore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: iload_0
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_0
    //   20: goto -7 -> 13
    //   23: astore_1
    //   24: ldc 2
    //   26: monitorexit
    //   27: goto +5 -> 32
    //   30: aload_1
    //   31: athrow
    //   32: goto -2 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	8	0	bool	boolean
    //   6	2	1	localTencentLog	TencentLog
    //   23	8	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	23	finally
  }
  
  public static boolean isRequestRawData(TencentLocationRequest paramTencentLocationRequest)
  {
    if (paramTencentLocationRequest == null) {
      return false;
    }
    return paramTencentLocationRequest.getExtras().getBoolean("request_raw_data");
  }
  
  public static void loadLibrary(String paramString)
  {
    System.load(paramString);
  }
  
  public static boolean removeTencentLog(TencentLog paramTencentLog)
  {
    try
    {
      dh.a(null);
      boolean bool = sTencentLogs.remove(paramTencentLog);
      return bool;
    }
    finally
    {
      paramTencentLog = finally;
      throw paramTencentLog;
    }
  }
  
  public static void setLogDir(File paramFile)
  {
    try
    {
      sLogDir = paramFile;
      return;
    }
    finally
    {
      paramFile = finally;
      throw paramFile;
    }
  }
  
  public static TencentLocation setRawData(TencentLocation paramTencentLocation, byte[] paramArrayOfByte)
  {
    paramTencentLocation.getExtra().putByteArray("raw_data", paramArrayOfByte);
    return paramTencentLocation;
  }
  
  public static void setRawGps(TencentLocation paramTencentLocation, Location paramLocation)
  {
    if (paramTencentLocation == null) {
      return;
    }
    paramTencentLocation.getExtra().putParcelable("raw_gps", paramLocation);
  }
  
  public static void setRawQuery(TencentLocation paramTencentLocation, String paramString)
  {
    if (paramTencentLocation == null) {
      return;
    }
    paramTencentLocation.getExtra().putString("raw_query", paramString);
  }
  
  public static TencentLocationRequest setRequestRawData(TencentLocationRequest paramTencentLocationRequest, boolean paramBoolean)
  {
    if (paramTencentLocationRequest != null) {
      paramTencentLocationRequest.getExtras().putBoolean("request_raw_data", paramBoolean);
    }
    return paramTencentLocationRequest;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.geolocation.internal.TencentExtraKeys
 * JD-Core Version:    0.7.0.1
 */