package com.huawei.hms.push.utils.ha;

public class PushAnalyticsCenter
{
  public PushBaseAnalytics a;
  
  public static PushAnalyticsCenter getInstance()
  {
    return PushAnalyticsCenter.a.a();
  }
  
  public PushBaseAnalytics getPushAnalytics()
  {
    return this.a;
  }
  
  public void register(PushBaseAnalytics paramPushBaseAnalytics)
  {
    this.a = paramPushBaseAnalytics;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.push.utils.ha.PushAnalyticsCenter
 * JD-Core Version:    0.7.0.1
 */