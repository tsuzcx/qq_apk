package com.tencent.luggage.wxa.kl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class j
{
  public static final j a = new j(0, "");
  public static final j b = new j(-1, "fail:internal error");
  public static final j c = new j(10000, "fail:not init");
  public static final j d = new j(10001, "fail:not available");
  public static final j e = new j(10002, "fail:no device");
  public static final j f = new j(10003, "fail:connection fail");
  public static final j g = new j(10004, "fail:no service");
  public static final j h = new j(10005, "fail:no characteristic");
  public static final j i = new j(10006, "fail:no connection");
  public static final j j = new j(10007, "fail:property not support");
  public static final j k = new j(10008, "fail:system error");
  public static final j l = new j(10009, "fail:system not support");
  public static final j m = new j(10008, "fail:no descriptor");
  public static final j n = new j(10008, "fail:fail to set descriptor");
  public static final j o = new j(10008, "fail:fail to write descriptor");
  public static final j p = new j(10012, "fail:operate time out");
  public static final j q = new j(-1, "fail:already connect");
  public static final j r = new j(10013, "fail:invalid data");
  public static final j s = new j(10008, "fail:not found service");
  public static final j t = new j(10014, "fail:need pin");
  public int u;
  public String v;
  @Nullable
  public final Object w;
  
  public j(int paramInt, String paramString)
  {
    this.u = paramInt;
    this.v = paramString;
    this.w = null;
  }
  
  private j(int paramInt, String paramString, @Nullable Object paramObject)
  {
    this.u = paramInt;
    this.v = paramString;
    this.w = paramObject;
  }
  
  public static j a(@NonNull Object paramObject)
  {
    return new j(0, "", paramObject);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Result{errCode=");
    localStringBuilder.append(this.u);
    localStringBuilder.append(", errMsg='");
    localStringBuilder.append(this.v);
    localStringBuilder.append('\'');
    localStringBuilder.append(", retObj=");
    localStringBuilder.append(this.w);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kl.j
 * JD-Core Version:    0.7.0.1
 */