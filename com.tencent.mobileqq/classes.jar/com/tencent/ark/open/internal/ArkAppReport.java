package com.tencent.ark.open.internal;

import com.tencent.ark.ArkEnvironmentManager;
import java.util.HashMap;

public class ArkAppReport
{
  private static final String TAG = "ArkApp.DataReport";
  
  @Deprecated
  public static void legacyReport(String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, String paramString3, String paramString4)
  {
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("result", String.valueOf(paramInt1));
      localHashMap.put("entry", String.valueOf(paramInt2));
      localHashMap.put("r1", String.valueOf(paramLong2));
      localHashMap.put("r2", String.valueOf(paramLong3));
      if (paramString3 != null) {
        localHashMap.put("r3", paramString3);
      }
      if (paramString4 != null) {
        localHashMap.put("r4", paramString4);
      }
      paramString3 = ArkEnvironmentManager.getInstance();
      boolean bool;
      if (paramInt1 == 0) {
        bool = true;
      } else {
        bool = false;
      }
      paramString3.doDataReport(paramString1, paramString2, bool, (int)paramLong1, localHashMap);
    }
  }
  
  public static void reportDisplayView(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("view", paramString2);
    localHashMap.put("state", String.valueOf(paramInt1));
    localHashMap.put("displayTime", String.valueOf(paramInt3));
    ArkEnvironmentManager.getInstance().doDataReport(paramString1, "ArkAppDisplayMonitor", paramBoolean, paramInt2, localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.internal.ArkAppReport
 * JD-Core Version:    0.7.0.1
 */