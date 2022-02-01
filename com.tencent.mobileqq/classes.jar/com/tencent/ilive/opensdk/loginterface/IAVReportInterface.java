package com.tencent.ilive.opensdk.loginterface;

import java.util.Map;

public abstract interface IAVReportInterface
{
  public abstract IAVReportInterface addAll(Map<String, String> paramMap);
  
  public abstract IAVReportInterface addKeyValue(String paramString1, String paramString2);
  
  public abstract void send();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.opensdk.loginterface.IAVReportInterface
 * JD-Core Version:    0.7.0.1
 */