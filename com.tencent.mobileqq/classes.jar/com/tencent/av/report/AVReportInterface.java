package com.tencent.av.report;

import com.tencent.ilive.opensdk.reporterinterface.SimpleCoreHttpImpl;
import java.util.Map;

public abstract interface AVReportInterface
{
  public abstract AVReportInterface addAll(Map<String, String> paramMap);
  
  public abstract AVReportInterface addKeyValue(String paramString, double paramDouble);
  
  public abstract AVReportInterface addKeyValue(String paramString, int paramInt);
  
  public abstract AVReportInterface addKeyValue(String paramString, long paramLong);
  
  public abstract AVReportInterface addKeyValue(String paramString1, String paramString2);
  
  public abstract void send();
  
  public abstract void setHttpComponent(SimpleCoreHttpImpl paramSimpleCoreHttpImpl);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.report.AVReportInterface
 * JD-Core Version:    0.7.0.1
 */