package com.tencent.av.wtogether.util;

import java.util.concurrent.ConcurrentHashMap;

public class WatchTogetherDataReportHelper
{
  private ConcurrentHashMap<String, WatchTogetherDataReportHelper.WTFilePlayInfo> a = new ConcurrentHashMap();
  
  public WatchTogetherDataReportHelper.WTFilePlayInfo a(String paramString)
  {
    return (WatchTogetherDataReportHelper.WTFilePlayInfo)this.a.get(paramString);
  }
  
  public void a()
  {
    this.a.clear();
  }
  
  public void a(String paramString, int paramInt)
  {
    WatchTogetherDataReportHelper.WTFilePlayInfo localWTFilePlayInfo2 = (WatchTogetherDataReportHelper.WTFilePlayInfo)this.a.get(paramString);
    WatchTogetherDataReportHelper.WTFilePlayInfo localWTFilePlayInfo1 = localWTFilePlayInfo2;
    if (localWTFilePlayInfo2 == null)
    {
      localWTFilePlayInfo1 = new WatchTogetherDataReportHelper.WTFilePlayInfo(paramString);
      this.a.put(paramString, localWTFilePlayInfo1);
    }
    localWTFilePlayInfo1.b = paramInt;
  }
  
  public void b(String paramString)
  {
    this.a.remove(paramString);
  }
  
  public void b(String paramString, int paramInt)
  {
    WatchTogetherDataReportHelper.WTFilePlayInfo localWTFilePlayInfo2 = (WatchTogetherDataReportHelper.WTFilePlayInfo)this.a.get(paramString);
    WatchTogetherDataReportHelper.WTFilePlayInfo localWTFilePlayInfo1 = localWTFilePlayInfo2;
    if (localWTFilePlayInfo2 == null)
    {
      localWTFilePlayInfo1 = new WatchTogetherDataReportHelper.WTFilePlayInfo(paramString);
      this.a.put(paramString, localWTFilePlayInfo1);
    }
    localWTFilePlayInfo1.c += paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.util.WatchTogetherDataReportHelper
 * JD-Core Version:    0.7.0.1
 */