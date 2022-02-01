package com.tencent.camerasdk.avreport;

import java.lang.reflect.Field;
import java.util.HashMap;

public class BaseBean
{
  @ReportField
  public Long avg_cost_time = Long.valueOf(0L);
  @ReportField
  public int avg_memory_usage = 0;
  @ReportField
  public Long duration = Long.valueOf(0L);
  @ReportField
  public String event;
  @ReportField
  public int failure_count = 0;
  @ReportField
  public int max_memory_usage = 0;
  @ReportField
  public String service;
  @ReportField
  public int success_count = 0;
  @ReportField
  public Long timestamp = Long.valueOf(0L);
  @ReportField
  public String version = "0.0.0";
  
  public BaseBean(String paramString1, String paramString2, String paramString3)
  {
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
    for (;;)
    {
      if (i < j)
      {
        Object localObject2 = localObject1[i];
        if (localObject2.isAnnotationPresent(ReportField.class)) {}
        try
        {
          localHashMap.put(localObject2.getName(), localObject2.get(this));
          i += 1;
        }
        catch (IllegalAccessException localIllegalAccessException2)
        {
          for (;;)
          {
            localIllegalAccessException2.printStackTrace();
          }
        }
      }
    }
    Field[] arrayOfField = getClass().getDeclaredFields();
    j = arrayOfField.length;
    i = 0;
    for (;;)
    {
      if (i < j)
      {
        Field localField = arrayOfField[i];
        label149:
        boolean bool;
        Boolean localBoolean;
        if ((paramBoolean.booleanValue()) && (!localField.isAnnotationPresent(ReportField.class)))
        {
          localObject1 = (ReportKey)localField.getAnnotation(ReportKey.class);
          if (localObject1 != null) {
            break label216;
          }
          localObject1 = localField.getName();
          if (localField.isAccessible()) {
            break label228;
          }
          bool = true;
          localBoolean = Boolean.valueOf(bool);
          if (localBoolean.booleanValue()) {
            localField.setAccessible(true);
          }
        }
        try
        {
          localHashMap.put(localObject1, localField.get(this));
          if (localBoolean.booleanValue()) {
            localField.setAccessible(false);
          }
          i += 1;
          continue;
          label216:
          localObject1 = ((ReportKey)localObject1).name();
          break label149;
          label228:
          bool = false;
        }
        catch (IllegalAccessException localIllegalAccessException1)
        {
          for (;;)
          {
            localIllegalAccessException1.printStackTrace();
          }
        }
      }
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.camerasdk.avreport.BaseBean
 * JD-Core Version:    0.7.0.1
 */