package com.tencent.ark;

import java.util.HashMap;

class ArkViewModelBase$9
  implements ArkPerfMonitor.IReport
{
  ArkViewModelBase$9(ArkViewModelBase paramArkViewModelBase) {}
  
  public void report(String paramString1, String paramString2, int paramInt)
  {
    Logger.logI("ArkApp.ViewModel", StringUtil.format("perf report: app=%s-%s, avg-block-time=%d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) }));
    HashMap localHashMap = new HashMap();
    localHashMap.put("view", paramString2);
    ArkViewModelBase.ENV.doDataReport(paramString1, "DisplayTimeConsuming", true, paramInt, localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.ArkViewModelBase.9
 * JD-Core Version:    0.7.0.1
 */