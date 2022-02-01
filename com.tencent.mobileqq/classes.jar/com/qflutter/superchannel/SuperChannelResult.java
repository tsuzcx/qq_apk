package com.qflutter.superchannel;

import java.util.HashMap;
import java.util.Map;

public class SuperChannelResult
{
  private static final String KEY_ERROR_CODE = "error_code";
  private static final String KEY_ERROR_DESC = "error_desc";
  private final int STATUS_FAIL = 2;
  private final int STATUS_IDLE = 0;
  private final int STATUS_SUCCESS = 1;
  private String errorCode;
  private String errorMsg;
  private Map results;
  private int status = 0;
  
  public Map encode()
  {
    HashMap localHashMap = new HashMap();
    int i = this.status;
    if (2 == i)
    {
      localHashMap.put("error_code", this.errorCode);
      localHashMap.put("error_desc", this.errorMsg);
      return localHashMap;
    }
    if (1 == i)
    {
      localHashMap.putAll(this.results);
      return localHashMap;
    }
    throw new IllegalStateException("this result is nether success or fail, please call success() or fail() first");
  }
  
  public void fail(String paramString1, String paramString2)
  {
    if (1 != this.status)
    {
      this.errorCode = paramString1;
      this.errorMsg = paramString2;
      this.status = 2;
      return;
    }
    throw new IllegalStateException("this result has succeed already");
  }
  
  public void success(Map paramMap)
  {
    if (2 != this.status)
    {
      this.results = paramMap;
      this.status = 1;
      return;
    }
    throw new IllegalStateException("this result has failed already");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SuperChannelResult{results=");
    localStringBuilder.append(this.results);
    localStringBuilder.append(", errorCode='");
    localStringBuilder.append(this.errorCode);
    localStringBuilder.append('\'');
    localStringBuilder.append(", errorMsg='");
    localStringBuilder.append(this.errorMsg);
    localStringBuilder.append('\'');
    localStringBuilder.append(", status=");
    localStringBuilder.append(this.status);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qflutter.superchannel.SuperChannelResult
 * JD-Core Version:    0.7.0.1
 */