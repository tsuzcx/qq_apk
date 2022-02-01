package com.tencent.featuretoggle.hltxkg.access.http;

public abstract interface IHttpRequest
{
  public abstract void abort();
  
  public abstract void enableRetry(boolean paramBoolean);
  
  public abstract Object getTag();
  
  public abstract String getUniqueId();
  
  public abstract void setAppScene(String paramString);
  
  public abstract void setFollowRedirects(boolean paramBoolean);
  
  public abstract void setForceRetTimeout(int paramInt);
  
  public abstract void setHttpHeader(String paramString1, String paramString2);
  
  public abstract void setHttpMethod(boolean paramBoolean);
  
  public abstract void setMode(int paramInt);
  
  public abstract void setTag(Object paramObject);
  
  public abstract void setTimeout(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.access.http.IHttpRequest
 * JD-Core Version:    0.7.0.1
 */