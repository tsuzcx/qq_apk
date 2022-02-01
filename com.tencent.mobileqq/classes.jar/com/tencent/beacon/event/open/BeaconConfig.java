package com.tencent.beacon.event.open;

import com.tencent.beacon.base.net.adapter.a;

public class BeaconConfig
{
  private final int a;
  private final boolean b;
  private final boolean c;
  private final boolean d;
  private final long e;
  private final long f;
  private final a g;
  private final String h;
  private final String i;
  private final boolean j;
  private final boolean k;
  private final boolean l;
  
  private BeaconConfig(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong1, long paramLong2, a parama, String paramString1, String paramString2, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    this.a = paramInt;
    this.b = paramBoolean1;
    this.c = paramBoolean2;
    this.d = paramBoolean3;
    this.e = paramLong1;
    this.f = paramLong2;
    this.g = parama;
    this.h = paramString1;
    this.i = paramString2;
    this.j = paramBoolean4;
    this.k = paramBoolean5;
    this.l = paramBoolean6;
  }
  
  public static BeaconConfig.Builder builder()
  {
    return new BeaconConfig.Builder();
  }
  
  public String getConfigHost()
  {
    return this.i;
  }
  
  public a getHttpAdapter()
  {
    return this.g;
  }
  
  public int getMaxDBCount()
  {
    return this.a;
  }
  
  public long getNormalPollingTIme()
  {
    return this.f;
  }
  
  public long getRealtimePollingTime()
  {
    return this.e;
  }
  
  public String getUploadHost()
  {
    return this.h;
  }
  
  public boolean isAuditEnable()
  {
    return this.c;
  }
  
  public boolean isBidEnable()
  {
    return this.d;
  }
  
  public boolean isEnableQmsp()
  {
    return this.k;
  }
  
  public boolean isEventReportEnable()
  {
    return this.b;
  }
  
  public boolean isForceEnableAtta()
  {
    return this.j;
  }
  
  public boolean isPagePathEnable()
  {
    return this.l;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BeaconConfig{maxDBCount=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", eventReportEnable=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", auditEnable=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", bidEnable=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", realtimePollingTime=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", normalPollingTIme=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", httpAdapter=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", uploadHost='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append(", configHost='");
    localStringBuilder.append(this.i);
    localStringBuilder.append('\'');
    localStringBuilder.append(", forceEnableAtta=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", enableQmsp=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", pagePathEnable=");
    localStringBuilder.append(this.l);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.event.open.BeaconConfig
 * JD-Core Version:    0.7.0.1
 */