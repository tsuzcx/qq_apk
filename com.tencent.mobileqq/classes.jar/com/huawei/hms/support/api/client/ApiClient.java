package com.huawei.hms.support.api.client;

import android.content.Context;

public abstract interface ApiClient
{
  public abstract String getAppID();
  
  public abstract Context getContext();
  
  public abstract String getCpID();
  
  public abstract String getPackageName();
  
  public abstract String getSessionId();
  
  public abstract SubAppInfo getSubAppInfo();
  
  public abstract String getTransportName();
  
  public abstract boolean isConnected();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.support.api.client.ApiClient
 * JD-Core Version:    0.7.0.1
 */