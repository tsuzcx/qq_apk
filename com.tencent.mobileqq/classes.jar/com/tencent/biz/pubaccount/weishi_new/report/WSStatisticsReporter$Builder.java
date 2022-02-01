package com.tencent.biz.pubaccount.weishi_new.report;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class WSStatisticsReporter$Builder
{
  private WSStatisticsBaseCollector baseCollector = new WSStatisticsBaseCollector();
  private String eventName = "";
  private Map<String, String> extParams = new HashMap();
  private boolean flush;
  private boolean isSendServer = true;
  private Map<String, String> params = new HashMap();
  
  public Builder addExtParams(Map<String, String> paramMap)
  {
    if (paramMap != null) {
      this.extParams.putAll(paramMap);
    }
    return this;
  }
  
  public Builder addParams(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      Map localMap = this.params;
      String str = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        str = "";
      }
      localMap.put(paramString1, str);
    }
    return this;
  }
  
  public Builder addParams(Map<String, String> paramMap)
  {
    if (paramMap != null) {
      this.params.putAll(paramMap);
    }
    return this;
  }
  
  public WSStatisticsReporter build(String paramString)
  {
    this.eventName = paramString;
    if (TextUtils.equals(paramString, "gzh_click")) {
      WSReportEventConstants.c = true;
    }
    return new WSStatisticsReporter(this, null);
  }
  
  public Map<String, String> getParams()
  {
    return this.params;
  }
  
  public String getSopName()
  {
    WSStatisticsBaseCollector localWSStatisticsBaseCollector = this.baseCollector;
    if (localWSStatisticsBaseCollector != null) {
      return localWSStatisticsBaseCollector.getSopName();
    }
    return "";
  }
  
  public Builder setFlush(boolean paramBoolean)
  {
    this.flush = paramBoolean;
    return this;
  }
  
  public Builder setOperationId(String paramString)
  {
    WSStatisticsBaseCollector localWSStatisticsBaseCollector = this.baseCollector;
    if (localWSStatisticsBaseCollector != null) {
      localWSStatisticsBaseCollector.setOperationId(paramString);
    }
    return this;
  }
  
  public Builder setPushId(String paramString)
  {
    WSStatisticsBaseCollector localWSStatisticsBaseCollector = this.baseCollector;
    if (localWSStatisticsBaseCollector != null) {
      localWSStatisticsBaseCollector.setPushId(paramString);
    }
    return this;
  }
  
  public Builder setSendWeSeeServer(boolean paramBoolean)
  {
    this.isSendServer = paramBoolean;
    return this;
  }
  
  public Builder setSopName(String paramString)
  {
    WSStatisticsBaseCollector localWSStatisticsBaseCollector = this.baseCollector;
    if (localWSStatisticsBaseCollector != null) {
      localWSStatisticsBaseCollector.setSopName(paramString);
    }
    return this;
  }
  
  public Builder setTabId(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.extParams.put("tab_id", paramString);
    }
    return this;
  }
  
  public Builder setTestId(String paramString)
  {
    WSStatisticsBaseCollector localWSStatisticsBaseCollector = this.baseCollector;
    if (localWSStatisticsBaseCollector != null) {
      localWSStatisticsBaseCollector.setTestId(paramString);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter.Builder
 * JD-Core Version:    0.7.0.1
 */