package com.tencent.biz.pubaccount.weishi_new.report;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class WSStatisticsReporter$Builder
{
  private String eventName = "";
  private Map<String, String> extParams = new HashMap();
  private boolean flush;
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
    return new WSStatisticsReporter(this, null);
  }
  
  public Builder setFlush(boolean paramBoolean)
  {
    this.flush = paramBoolean;
    return this;
  }
  
  public Builder setOperationId(String paramString)
  {
    WSStatisticsBaseCollector.setOperationId(paramString);
    return this;
  }
  
  public Builder setPushId(String paramString)
  {
    WSStatisticsBaseCollector.setPushId(paramString);
    return this;
  }
  
  public Builder setSceneFrom(String paramString)
  {
    WSStatisticsBaseCollector.setSceneFrom(paramString);
    return this;
  }
  
  public Builder setSopName(String paramString)
  {
    WSStatisticsBaseCollector.setSopName(paramString);
    return this;
  }
  
  public Builder setTestId(String paramString)
  {
    WSStatisticsBaseCollector.setTestId(paramString);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter.Builder
 * JD-Core Version:    0.7.0.1
 */