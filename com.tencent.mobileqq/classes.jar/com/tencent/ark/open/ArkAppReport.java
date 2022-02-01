package com.tencent.ark.open;

import android.text.TextUtils;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.open.delegate.ArkDelegateManager;
import com.tencent.ark.open.delegate.IArkDelegateSetup;

public class ArkAppReport
{
  public static final String Action_PerfCreateContext = "PerfCreateContext";
  public static final String Action_PerfCreateView = "PerfCreateView";
  public static final String Action_PerfDisplayTotalCost = "PerfDisplayTotalCost";
  public static final String Action_PerfDisplayView = "PerfDisplayView";
  public static final String Action_PerfFirstDraw = "PerfFirstDraw";
  public static final String Action_PerfGetApp = "PerfGetApp";
  public static final String Action_PerfSurfacePrepare = "PerfSurfacePrepare";
  private static final ArkEnvironmentManager ENV = ;
  private static final int NET_TYPE_2G = 3;
  private static final int NET_TYPE_3G = 4;
  private static final int NET_TYPE_4G = 5;
  private static final int NET_TYPE_UNKNOWN = -1;
  private static final int NET_TYPE_UNREACHABLE = 0;
  private static final int NET_TYPE_WIFI = 1;
  private static final int NET_TYPE_WWAN = 2;
  private static final int NET_TYPE_XG = 6;
  private static final String TAG = "ArkApp.DataReport";
  
  public static int AQQNetTypeToArkReportNetType(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    default: 
      return -1;
    case 0: 
      return 0;
    case 1: 
      return 1;
    case 2: 
      return 3;
    case 3: 
      return 4;
    }
    return 5;
  }
  
  public static void platformEventReport(String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, String paramString3, String paramString4)
  {
    if ((TextUtils.isEmpty(paramString1)) || (!ArkAppMgr.isValidAppName(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      ENV.logI("ArkApp.DataReport", String.format("platformEventReport, invalid args, app-name=%s, op-name=%s", new Object[] { paramString1, paramString2 }));
    }
    IArkDelegateSetup localIArkDelegateSetup;
    do
    {
      return;
      ENV.logI("ArkApp.DataReport", String.format("platformEventReport, app=%s, op-name=%s, entry=%d, result=%d, r1=%d, r2=%d, r3=%s, r4=%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), paramString3, paramString4 }));
      localIArkDelegateSetup = ArkDelegateManager.getInstance().getSetupDelegate();
    } while (localIArkDelegateSetup == null);
    localIArkDelegateSetup.reportEvent(paramString1, "__platform__", paramString2, paramInt1, paramInt2, paramLong1, paramLong2, paramLong3, paramString3, paramString4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppReport
 * JD-Core Version:    0.7.0.1
 */