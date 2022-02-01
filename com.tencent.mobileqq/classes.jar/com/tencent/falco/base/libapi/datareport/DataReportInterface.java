package com.tencent.falco.base.libapi.datareport;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import java.util.Map;

public abstract interface DataReportInterface
  extends ServiceBaseInterface
{
  public static final String QUALITY_REPORT_STARTLIVE_KEY = "startLive";
  
  public abstract void init(DataReportInterface.DataReportAdapter paramDataReportAdapter);
  
  public abstract QualityReportTask newAudQualityTask();
  
  public abstract QualityReportTask newQualityTask();
  
  public abstract QualityReportTask newQualityTaskCustom();
  
  public abstract ReportTask newTask();
  
  public abstract void reportEvent(String paramString);
  
  @Deprecated
  public abstract void reportEvent(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap);
  
  public abstract void reportEvent(String paramString, Map<String, String> paramMap, boolean paramBoolean);
  
  public abstract void reportEvent(String paramString, boolean paramBoolean);
  
  public abstract void reportEvent(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3);
  
  public abstract void reportEvent(String paramString, boolean paramBoolean, Map<String, String> paramMap);
  
  public abstract void setUserUid(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.libapi.datareport.DataReportInterface
 * JD-Core Version:    0.7.0.1
 */