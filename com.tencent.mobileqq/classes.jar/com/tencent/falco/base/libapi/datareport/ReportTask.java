package com.tencent.falco.base.libapi.datareport;

public abstract interface ReportTask
{
  public abstract ReportTask addKeyValue(String paramString, double paramDouble);
  
  public abstract ReportTask addKeyValue(String paramString, int paramInt);
  
  public abstract ReportTask addKeyValue(String paramString, long paramLong);
  
  public abstract ReportTask addKeyValue(String paramString1, String paramString2);
  
  public abstract void send();
  
  public abstract ReportTask setActType(String paramString);
  
  public abstract ReportTask setActTypeDesc(String paramString);
  
  public abstract ReportTask setCommonet(String paramString);
  
  public abstract void setDataReportService(DataReportInterface paramDataReportInterface);
  
  public abstract ReportTask setModule(String paramString);
  
  public abstract ReportTask setModuleDesc(String paramString);
  
  public abstract ReportTask setPage(String paramString);
  
  public abstract ReportTask setPageDesc(String paramString);
  
  public abstract ReportTask setRealTimeUpload(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.libapi.datareport.ReportTask
 * JD-Core Version:    0.7.0.1
 */