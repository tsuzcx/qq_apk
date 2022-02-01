package com.tencent.ark;

class ArkViewModelBase$9
  implements ArkPerfMonitor.IReport
{
  ArkViewModelBase$9(ArkViewModelBase paramArkViewModelBase) {}
  
  public void report(String paramString1, String paramString2, int paramInt)
  {
    ArkViewModelBase.ENV.logI("ArkApp.ArkViewModelBase", String.format("perf report: app=%s-%s, avg-block-time=%d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) }));
    ArkViewModelBase.ENV.doDataReport(paramString1, paramString2, "DisplayTimeConsuming", 0, 0, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.ArkViewModelBase.9
 * JD-Core Version:    0.7.0.1
 */