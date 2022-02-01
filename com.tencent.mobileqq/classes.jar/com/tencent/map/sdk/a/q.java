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
    StringBuilder localStringBuilder1 = new StringBuilder("[");
    StringBuilder localStringBuilder2 = new StringBuilder("appid:");
    localStringBuilder2.append(this.b);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder(",uuid:");
    localStringBuilder2.append(this.d);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder(",channelid:");
    localStringBuilder2.append(this.e);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder(",isSDKMode:");
    localStringBuilder2.append(this.c);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder(",isTest:");
    localStringBuilder2.append(this.h);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder(",testAppid:");
    localStringBuilder2.append(this.i);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder(",maskDeviceInfo:");
    localStringBuilder2.append(this.g);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append("]");
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.q
 * JD-Core Version:    0.7.0.1
 */