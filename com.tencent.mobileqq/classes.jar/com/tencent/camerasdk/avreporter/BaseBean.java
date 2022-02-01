package com.tencent.camerasdk.avreporter;

import java.lang.reflect.Field;
import java.util.HashMap;

public class BaseBean
{
  @ReportField
  public Long avg_cost_time;
  @ReportField
  public int avg_memory_usage;
  @ReportField
  public Long duration;
  @ReportField
  public String event;
  @ReportField
  public int failure_count;
  @ReportField
  public int max_memory_usage;
  @ReportField
  public String service;
  @ReportField
  public int success_count;
  @ReportField
  public Long timestamp;
  @ReportField
  public String version;
  
  public BaseBean(String paramString1, String paramString2, String paramString3)
  {
    Long localLong = Long.valueOf(0L);
    this.timestamp = localLong;
    this.duration = localLong;
    this.success_count = 0;
    this.failure_count = 0;
    this.avg_cost_time = localLong;
    this.avg_memory_usage = 0;
    this.max_memory_usage = 0;
    this.version = "0.0.0";
    this.service = paramString1;
    this.event = paramString2;
    this.version = paramString3;
  }
  
  public HashMap<String, Object> extractReportData(Boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = getClass().getSuperclass().getDeclaredFields();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if (localObject2.isAnnotationPresent(ReportField.class)) {
        try
        {
          localHashMap.put(localObject2.getName(), localObject2.get(this));
        }
        catch (IllegalAccessException localIllegalAccessException2)
        {
          localIllegalAccessException2.printStackTrace();
        }
      }
      i += 1;
    }
    Field[] arrayOfField = getClass().getDeclaredFields();
    j = arrayOfField.length;
    i = 0;
    while (i < j)
    {
      Field localField = arrayOfField[i];
      if ((!paramBoolean.booleanValue()) || (localField.isAnnotationPresent(ReportField.class)))
      {
        localObject1 = (ReportKey)localField.getAnnotation(ReportKey.class);
        if (localObject1 == null) {
          localObject1 = localField.getName();
        } else {
          localObject1 = ((ReportKey)localObject1).name();
        }
        boolean bool = localField.isAccessible() ^ true;
        if (bool) {
          localField.setAccessible(true);
        }
        try
        {
          localHashMap.put(localObject1, localField.get(this));
        }
        catch (IllegalAccessException localIllegalAccessException1)
        {
          localIllegalAccessException1.printStackTrace();
        }
        if (bool) {
          localField.setAccessible(false);
        }
      }
      i += 1;
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.camerasdk.avreporter.BaseBean
 * JD-Core Version:    0.7.0.1
 */