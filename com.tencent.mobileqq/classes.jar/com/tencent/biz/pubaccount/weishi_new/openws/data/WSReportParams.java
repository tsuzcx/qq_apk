package com.tencent.biz.pubaccount.weishi_new.openws.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;

public class WSReportParams
{
  private String a;
  private Map<String, String> b;
  private Map<String, String> c;
  
  public WSReportParams(@Nullable String paramString, @NonNull Map<String, String> paramMap1, @NonNull Map<String, String> paramMap2)
  {
    this.a = paramString;
    this.b = paramMap1;
    this.c = paramMap2;
  }
  
  public Map<String, String> a()
  {
    return this.b;
  }
  
  public Map<String, String> b()
  {
    return this.c;
  }
  
  public String c()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.openws.data.WSReportParams
 * JD-Core Version:    0.7.0.1
 */