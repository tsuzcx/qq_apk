package com.tencent.falco.base.libapi.datareport;

public abstract interface QualityReportTask
{
  public static final int QUALITY_TYPE_ANCHOR = 1;
  public static final int QUALITY_TYPE_AUDIENCE = 2;
  public static final int QUALITY_TYPE_CUSTOM = 3;
  
  public abstract QualityReportTask addKeyValue(String paramString, double paramDouble);
  
  public abstract QualityReportTask addKeyValue(String paramString, int paramInt);
  
  public abstract QualityReportTask addKeyValue(String paramString, long paramLong);
  
  public abstract QualityReportTask addKeyValue(String paramString1, String paramString2);
  
  public abstract void send();
  
  public abstract QualityReportTask setActType(String paramString);
  
  public abstract QualityReportTask setActTypeDesc(String paramString);
  
  public abstract void setDataReportService(DataReportInterface paramDataReportInterface);
  
  public abstract QualityReportTask setModule(String paramString);
  
  public abstract QualityReportTask setModuleDes(String paramString);
  
  public abstract QualityReportTask setPage(String paramString);
  
  public abstract QualityReportTask setPageDes(String paramString);
  
  public abstract void setQualityType(int paramInt);
  
  public abstract QualityReportTask setRealTimeUpload(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.base.libapi.datareport.QualityReportTask
 * JD-Core Version:    0.7.0.1
 */