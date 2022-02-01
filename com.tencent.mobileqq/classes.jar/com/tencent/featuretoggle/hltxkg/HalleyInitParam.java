package com.tencent.featuretoggle.hltxkg;

import android.content.Context;
import android.text.TextUtils;

public final class HalleyInitParam
{
  public static final String CommonBeaconAppKey = "0M100WJ33N1CQ08O";
  private Context a;
  private int b;
  private boolean c;
  private String d = "";
  private String e = "";
  private String f = "0M100WJ33N1CQ08O";
  private boolean g = false;
  private int h = -1;
  public boolean maskDeviceInfo = false;
  
  public HalleyInitParam(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    this.a = paramContext.getApplicationContext();
    this.b = paramInt;
    this.c = true;
    this.d = paramString1;
    this.e = paramString2;
  }
  
  public final int getAppid()
  {
    return this.b;
  }
  
  public final String getBeaconAppKey()
  {
    return this.f;
  }
  
  public final String getChannelid()
  {
    return this.e;
  }
  
  public final Context getContext()
  {
    return this.a;
  }
  
  public final int getTestAppid()
  {
    return this.h;
  }
  
  public final String getUuid()
  {
    return this.d;
  }
  
  public final boolean isSDKMode()
  {
    return this.c;
  }
  
  public final boolean isTestMode()
  {
    return this.g;
  }
  
  public final void setBeaconAppKey(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.f = paramString;
    }
  }
  
  public final void setTestMode(int paramInt)
  {
    this.g = true;
    this.h = paramInt;
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
    localStringBuilder2.append(this.g);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder(",testAppid:");
    localStringBuilder2.append(this.h);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder(",maskDeviceInfo:");
    localStringBuilder2.append(this.maskDeviceInfo);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append("]");
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.HalleyInitParam
 * JD-Core Version:    0.7.0.1
 */