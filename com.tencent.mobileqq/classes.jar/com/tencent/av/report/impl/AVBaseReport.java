package com.tencent.av.report.impl;

import com.tencent.av.report.AVReportInterface;
import com.tencent.av.report.AVReportLog;
import com.tencent.ilive.opensdk.reporterinterface.SimpleCoreHttpImpl;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class AVBaseReport
  implements AVReportInterface
{
  private static final String REPORT_URL = "https://h.trace.qq.com/kv";
  private static final String TAG = "AVReport";
  SimpleCoreHttpImpl httpComponent;
  protected Map<String, String> reportData = new HashMap();
  
  private String getUrl()
  {
    Object localObject = new StringBuilder("https://h.trace.qq.com/kv");
    ((StringBuilder)localObject).append("?");
    ((StringBuilder)localObject).append("_dc=");
    ((StringBuilder)localObject).append(Math.random());
    Iterator localIterator = this.reportData.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((StringBuilder)localObject).append("&");
      ((StringBuilder)localObject).append((String)localEntry.getKey());
      ((StringBuilder)localObject).append("=");
      ((StringBuilder)localObject).append((String)localEntry.getValue());
    }
    localObject = ((StringBuilder)localObject).toString();
    AVReportLog.d("AVReport", "url=" + (String)localObject, new Object[0]);
    return localObject;
  }
  
  public AVReportInterface addAll(Map<String, String> paramMap)
  {
    this.reportData.putAll(paramMap);
    return this;
  }
  
  public AVReportInterface addKeyValue(String paramString, double paramDouble)
  {
    this.reportData.put(paramString, String.valueOf(paramDouble));
    return this;
  }
  
  public AVReportInterface addKeyValue(String paramString, int paramInt)
  {
    this.reportData.put(paramString, String.valueOf(paramInt));
    return this;
  }
  
  public AVReportInterface addKeyValue(String paramString, long paramLong)
  {
    this.reportData.put(paramString, String.valueOf(paramLong));
    return this;
  }
  
  public AVReportInterface addKeyValue(String paramString1, String paramString2)
  {
    this.reportData.put(paramString1, String.valueOf(paramString2));
    return this;
  }
  
  public abstract String getReportId();
  
  public abstract String getToken();
  
  public void init()
  {
    prepareData();
  }
  
  public abstract void prepareData();
  
  public void send()
  {
    this.httpComponent.get(getUrl(), new AVBaseReport.1(this));
  }
  
  public void setHttpComponent(SimpleCoreHttpImpl paramSimpleCoreHttpImpl)
  {
    this.httpComponent = paramSimpleCoreHttpImpl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.report.impl.AVBaseReport
 * JD-Core Version:    0.7.0.1
 */