package com.tencent.biz.pubaccount.weishi_new.report;

import android.text.TextUtils;
import com.google.gson.Gson;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WSRecommendReportManager
{
  private ConcurrentHashMap<String, String> a = new ConcurrentHashMap();
  
  public static WSRecommendReportManager a()
  {
    return WSRecommendReportManager.SingleInstance.a();
  }
  
  public String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return (String)this.a.get(paramString);
    }
    return "";
  }
  
  public void a()
  {
    this.a.clear();
  }
  
  public void a(String paramString, Map<String, String> paramMap)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramMap != null)) {
      this.a.put(paramString, new Gson().toJson(paramMap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.WSRecommendReportManager
 * JD-Core Version:    0.7.0.1
 */