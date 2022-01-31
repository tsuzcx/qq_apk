package com.tencent.map.sdk.a;

import android.content.Context;

public final class q
{
  public Context a;
  int b;
  public boolean c;
  public String d = "";
  public String e = "";
  String f = "0M100WJ33N1CQ08O";
  public boolean g = false;
  boolean h = false;
  int i = -1;
  
  public q(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    this.a = paramContext.getApplicationContext();
    this.b = paramInt;
    this.c = true;
    this.d = paramString1;
    this.e = paramString2;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("[");
    localStringBuilder.append("appid:" + this.b);
    localStringBuilder.append(",uuid:" + this.d);
    localStringBuilder.append(",channelid:" + this.e);
    localStringBuilder.append(",isSDKMode:" + this.c);
    localStringBuilder.append(",isTest:" + this.h);
    localStringBuilder.append(",testAppid:" + this.i);
    localStringBuilder.append(",maskDeviceInfo:" + this.g);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.q
 * JD-Core Version:    0.7.0.1
 */