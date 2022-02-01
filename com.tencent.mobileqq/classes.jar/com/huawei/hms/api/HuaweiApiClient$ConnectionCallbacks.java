package com.huawei.hms.api;

public abstract interface HuaweiApiClient$ConnectionCallbacks
{
  public static final int CAUSE_API_CLIENT_EXPIRED = 3;
  public static final int CAUSE_NETWORK_LOST = 2;
  public static final int CAUSE_SERVICE_DISCONNECTED = 1;
  
  public abstract void onConnected();
  
  public abstract void onConnectionSuspended(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.api.HuaweiApiClient.ConnectionCallbacks
 * JD-Core Version:    0.7.0.1
 */