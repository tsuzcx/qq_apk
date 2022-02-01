package com.tencent.map.geolocation.sapp;

import android.os.Bundle;
import android.text.TextUtils;

public final class TencentLocationRequest
{
  public static final int REQUEST_LEVEL_ADMIN_AREA = 3;
  public static final int REQUEST_LEVEL_GEO = 0;
  public static final int REQUEST_LEVEL_NAME = 1;
  public static final int REQUEST_LEVEL_POI = 4;
  public boolean mAllowCache;
  public boolean mAllowDirection;
  public boolean mAllowGps;
  public long mExpirationTime;
  public Bundle mExtras;
  public boolean mIndoorLocationMode;
  public long mInterval;
  public int mNumUpdates;
  public String mQQ;
  public int mRequestLevel;
  public String mSmallAppKey;
  
  public TencentLocationRequest() {}
  
  public TencentLocationRequest(TencentLocationRequest paramTencentLocationRequest)
  {
    this.mInterval = paramTencentLocationRequest.mInterval;
    this.mRequestLevel = paramTencentLocationRequest.mRequestLevel;
    this.mAllowCache = paramTencentLocationRequest.mAllowCache;
    this.mAllowDirection = paramTencentLocationRequest.mAllowDirection;
    this.mExpirationTime = paramTencentLocationRequest.mExpirationTime;
    this.mNumUpdates = paramTencentLocationRequest.mNumUpdates;
    this.mAllowGps = paramTencentLocationRequest.mAllowGps;
    this.mIndoorLocationMode = paramTencentLocationRequest.mIndoorLocationMode;
    this.mQQ = paramTencentLocationRequest.mQQ;
    this.mSmallAppKey = paramTencentLocationRequest.mSmallAppKey;
    this.mExtras = new Bundle();
    this.mExtras.putAll(paramTencentLocationRequest.mExtras);
  }
  
  public static void copy(TencentLocationRequest paramTencentLocationRequest1, TencentLocationRequest paramTencentLocationRequest2)
  {
    paramTencentLocationRequest1.mInterval = paramTencentLocationRequest2.mInterval;
    paramTencentLocationRequest1.mRequestLevel = paramTencentLocationRequest2.mRequestLevel;
    paramTencentLocationRequest1.mAllowCache = paramTencentLocationRequest2.mAllowCache;
    paramTencentLocationRequest1.mAllowDirection = paramTencentLocationRequest2.mAllowDirection;
    paramTencentLocationRequest1.mExpirationTime = paramTencentLocationRequest2.mExpirationTime;
    paramTencentLocationRequest1.mNumUpdates = paramTencentLocationRequest2.mNumUpdates;
    paramTencentLocationRequest1.mIndoorLocationMode = paramTencentLocationRequest2.mIndoorLocationMode;
    paramTencentLocationRequest1.mAllowGps = paramTencentLocationRequest2.mAllowGps;
    paramTencentLocationRequest1.mQQ = paramTencentLocationRequest2.mQQ;
    paramTencentLocationRequest1.mSmallAppKey = paramTencentLocationRequest2.mSmallAppKey;
    paramTencentLocationRequest1.mExtras.clear();
    paramTencentLocationRequest1.mExtras.putAll(paramTencentLocationRequest2.mExtras);
  }
  
  public static TencentLocationRequest create()
  {
    TencentLocationRequest localTencentLocationRequest = new TencentLocationRequest();
    localTencentLocationRequest.mInterval = 10000L;
    localTencentLocationRequest.mRequestLevel = 1;
    localTencentLocationRequest.mAllowCache = true;
    localTencentLocationRequest.mAllowDirection = false;
    localTencentLocationRequest.mIndoorLocationMode = false;
    localTencentLocationRequest.mExpirationTime = 0L;
    localTencentLocationRequest.mNumUpdates = 2147483647;
    localTencentLocationRequest.mAllowGps = true;
    localTencentLocationRequest.mQQ = "";
    localTencentLocationRequest.mSmallAppKey = "";
    localTencentLocationRequest.mExtras = new Bundle();
    return localTencentLocationRequest;
  }
  
  private boolean isAllowedLevel(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 3) && (paramInt != 4)) {
      return paramInt == 7;
    }
    return true;
  }
  
  public Bundle getExtras()
  {
    return this.mExtras;
  }
  
  public long getInterval()
  {
    return this.mInterval;
  }
  
  public String getPhoneNumber()
  {
    String str2 = this.mExtras.getString("phoneNumber");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public String getQQ()
  {
    return this.mQQ;
  }
  
  public int getRequestLevel()
  {
    return this.mRequestLevel;
  }
  
  public String getSmallAppKey()
  {
    return this.mSmallAppKey;
  }
  
  public long getmExpirationTime()
  {
    return this.mExpirationTime;
  }
  
  public boolean isAllowCache()
  {
    return this.mAllowCache;
  }
  
  public boolean isAllowDirection()
  {
    return this.mAllowDirection;
  }
  
  public boolean isAllowGPS()
  {
    return this.mAllowGps;
  }
  
  public boolean isIndoorLocationMode()
  {
    return this.mIndoorLocationMode;
  }
  
  public TencentLocationRequest setAllowCache(boolean paramBoolean)
  {
    this.mAllowCache = paramBoolean;
    return this;
  }
  
  public TencentLocationRequest setAllowDirection(boolean paramBoolean)
  {
    this.mAllowDirection = paramBoolean;
    return this;
  }
  
  public TencentLocationRequest setAllowGPS(boolean paramBoolean)
  {
    this.mAllowGps = paramBoolean;
    return this;
  }
  
  public TencentLocationRequest setIndoorLocationMode(boolean paramBoolean)
  {
    this.mIndoorLocationMode = paramBoolean;
    return this;
  }
  
  public TencentLocationRequest setInterval(long paramLong)
  {
    if (paramLong >= 0L)
    {
      this.mInterval = paramLong;
      return this;
    }
    throw new IllegalArgumentException("interval should >= 0");
  }
  
  public TencentLocationRequest setPhoneNumber(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.mExtras.putString("phoneNumber", str);
    return this;
  }
  
  public TencentLocationRequest setQQ(String paramString)
  {
    this.mQQ = paramString;
    return this;
  }
  
  public TencentLocationRequest setRequestLevel(int paramInt)
  {
    if (isAllowedLevel(paramInt))
    {
      this.mRequestLevel = paramInt;
      return this;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("request_level: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" not supported!");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public TencentLocationRequest setSmallAppKey(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.mSmallAppKey = paramString;
    }
    return this;
  }
  
  public void setmExpirationTime(long paramLong)
  {
    this.mExpirationTime = paramLong;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TencentLocationRequest {interval=");
    localStringBuilder.append(this.mInterval);
    localStringBuilder.append("ms,level=");
    localStringBuilder.append(this.mRequestLevel);
    localStringBuilder.append(",allowCache=");
    localStringBuilder.append(this.mAllowCache);
    localStringBuilder.append(",allowGps=");
    localStringBuilder.append(this.mAllowGps);
    localStringBuilder.append(",allowDirection=");
    localStringBuilder.append(this.mAllowDirection);
    localStringBuilder.append(",QQ=");
    localStringBuilder.append(this.mQQ);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.geolocation.sapp.TencentLocationRequest
 * JD-Core Version:    0.7.0.1
 */