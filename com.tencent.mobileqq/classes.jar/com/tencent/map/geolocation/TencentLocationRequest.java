package com.tencent.map.geolocation;

import android.os.Bundle;
import com.tencent.map.geolocation.internal.TencentExtraKeys;

public final class TencentLocationRequest
{
  public static final int REQUEST_LEVEL_ADMIN_AREA = 3;
  public static final int REQUEST_LEVEL_FORMATTED_ADDRESS = 5;
  public static final int REQUEST_LEVEL_GEO = 0;
  public static final int REQUEST_LEVEL_GLOBAL_ADMIN_AREA = 7;
  public static final int REQUEST_LEVEL_NAME = 1;
  public static final int REQUEST_LEVEL_POI = 4;
  private long a;
  private long b;
  private int c;
  private boolean d;
  private boolean e;
  private int f;
  private boolean g;
  private boolean h;
  private String i;
  private Bundle j;
  
  private TencentLocationRequest() {}
  
  public TencentLocationRequest(TencentLocationRequest paramTencentLocationRequest)
  {
    this.a = paramTencentLocationRequest.a;
    this.c = paramTencentLocationRequest.c;
    this.d = paramTencentLocationRequest.d;
    this.e = paramTencentLocationRequest.e;
    this.f = paramTencentLocationRequest.f;
    this.b = paramTencentLocationRequest.b;
    this.g = paramTencentLocationRequest.g;
    this.h = paramTencentLocationRequest.h;
    this.i = paramTencentLocationRequest.i;
    this.j = new Bundle();
    this.j.putAll(paramTencentLocationRequest.j);
  }
  
  public static void copy(TencentLocationRequest paramTencentLocationRequest1, TencentLocationRequest paramTencentLocationRequest2)
  {
    paramTencentLocationRequest1.a = paramTencentLocationRequest2.a;
    paramTencentLocationRequest1.c = paramTencentLocationRequest2.c;
    paramTencentLocationRequest1.d = paramTencentLocationRequest2.d;
    paramTencentLocationRequest1.e = paramTencentLocationRequest2.e;
    paramTencentLocationRequest1.f = paramTencentLocationRequest2.f;
    paramTencentLocationRequest1.i = paramTencentLocationRequest2.i;
    paramTencentLocationRequest1.b = paramTencentLocationRequest2.b;
    paramTencentLocationRequest1.g = paramTencentLocationRequest2.g;
    paramTencentLocationRequest1.h = paramTencentLocationRequest2.h;
    paramTencentLocationRequest1.j.clear();
    paramTencentLocationRequest1.j.putAll(paramTencentLocationRequest2.j);
  }
  
  public static TencentLocationRequest create()
  {
    TencentLocationRequest localTencentLocationRequest = new TencentLocationRequest();
    localTencentLocationRequest.a = 10000L;
    localTencentLocationRequest.c = 1;
    localTencentLocationRequest.d = true;
    localTencentLocationRequest.h = true;
    localTencentLocationRequest.e = false;
    localTencentLocationRequest.f = 2147483647;
    localTencentLocationRequest.b = -1L;
    localTencentLocationRequest.g = false;
    localTencentLocationRequest.i = "";
    localTencentLocationRequest.j = new Bundle();
    return localTencentLocationRequest;
  }
  
  public final long getCheckInterval()
  {
    return this.b;
  }
  
  public final Bundle getExtras()
  {
    return this.j;
  }
  
  public final long getInterval()
  {
    return this.a;
  }
  
  public final String getPhoneNumber()
  {
    String str2 = this.j.getString("phoneNumber");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String getQQ()
  {
    return this.i;
  }
  
  public final int getRequestLevel()
  {
    return this.c;
  }
  
  public final boolean isAllowCache()
  {
    return this.d;
  }
  
  public final boolean isAllowDirection()
  {
    return this.e;
  }
  
  public final boolean isAllowGPS()
  {
    return this.h;
  }
  
  public final boolean isAllowPedometer()
  {
    return this.g;
  }
  
  public final TencentLocationRequest setAllowCache(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }
  
  public final TencentLocationRequest setAllowDirection(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }
  
  public final TencentLocationRequest setAllowGPS(boolean paramBoolean)
  {
    this.h = paramBoolean;
    return this;
  }
  
  public final TencentLocationRequest setAllowPedometer(boolean paramBoolean)
  {
    this.g = paramBoolean;
    return this;
  }
  
  public final TencentLocationRequest setCheckInterval(long paramLong)
  {
    if (paramLong >= 30000L)
    {
      this.b = paramLong;
      return this;
    }
    throw new IllegalArgumentException("interval should >= 30*1000");
  }
  
  public final TencentLocationRequest setInterval(long paramLong)
  {
    if (paramLong >= 0L)
    {
      this.a = paramLong;
      return this;
    }
    throw new IllegalArgumentException("interval should >= 0");
  }
  
  public final TencentLocationRequest setPhoneNumber(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.j.putString("phoneNumber", str);
    return this;
  }
  
  public final TencentLocationRequest setQQ(String paramString)
  {
    this.i = paramString;
    return this;
  }
  
  public final TencentLocationRequest setRequestLevel(int paramInt)
  {
    if (TencentExtraKeys.isAllowedLevel(paramInt))
    {
      this.c = paramInt;
      return this;
    }
    StringBuilder localStringBuilder = new StringBuilder("request_level: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" not supported!");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("TencentLocationRequest [mInterval=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mCheckInterval=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mRequestLevel=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mAllowCache=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", mAllowDirection=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", mNumUpdates=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", mAllowStepCount=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", mAllowGps=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", mQQ=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", mExtras=");
    localStringBuilder.append(this.j);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.geolocation.TencentLocationRequest
 * JD-Core Version:    0.7.0.1
 */