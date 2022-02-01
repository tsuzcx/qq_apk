package com.tencent.featuretoggle.hltxkg.access.http;

import java.util.Map;

public abstract interface IHttpResponse
{
  public abstract Map<String, String> getAllHeaders();
  
  public abstract int getErrorCode();
  
  public abstract String getErrorInfo();
  
  public abstract byte[] getHttpBody();
  
  public abstract int getHttpBodyLen();
  
  public abstract String getHttpHeader(String paramString);
  
  public abstract int getHttpStatus();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.access.http.IHttpResponse
 * JD-Core Version:    0.7.0.1
 */