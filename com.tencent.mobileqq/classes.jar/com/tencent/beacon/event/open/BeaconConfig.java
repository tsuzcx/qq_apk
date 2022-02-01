package com.tencent.beacon.event.open;

import com.tencent.beacon.base.net.adapter.a;

public class BeaconConfig
{
  private final int a;
  private final boolean b;
  private final boolean c;
  private final boolean d;
  private final boolean e;
  private final boolean f;
  private final boolean g;
  private final boolean h;
  private final long i;
  private final long j;
  private final a k;
  private String l;
  private String m;
  private boolean n;
  private boolean o;
  private boolean p;
  
  private BeaconConfig(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, long paramLong1, long paramLong2, a parama, String paramString1, String paramString2, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10)
  {
    this.a = paramInt;
    this.b = paramBoolean1;
    this.c = paramBoolean2;
    this.d = paramBoolean3;
    this.e = paramBoolean4;
    this.f = paramBoolean5;
    this.g = paramBoolean6;
    this.h = paramBoolean7;
    this.i = paramLong1;
    this.j = paramLong2;
    this.k = parama;
    this.l = paramString1;
    this.m = paramString2;
    this.n = paramBoolean8;
    this.o = paramBoolean9;
    this.p = paramBoolean10;
  }
  
  public static BeaconConfig.Builder builder()
  {
    return new BeaconConfig.Builder();
  }
  
  public String getConfigHost()
  {
    return this.m;
  }
  
  public a getHttpAdapter()
  {
    return this.k;
  }
  
  public int getMaxDBCount()
  {
    return this.a;
  }
  
  public long getNormalPollingTIme()
  {
    return this.j;
  }
  
  public long getRealtimePollingTime()
  {
    return this.i;
  }
  
  public String getUploadHost()
  {
    return this.l;
  }
  
  public boolean isAuditEnable()
  {
    return this.c;
  }
  
  public boolean isBidEnable()
  {
    return this.d;
  }
  
  public boolean isCollectAndroidIdEnable()
  {
    return this.g;
  }
  
  public boolean isCollectIMEIEnable()
  {
    return this.f;
  }
  
  public boolean isCollectMACEnable()
  {
    return this.e;
  }
  
  public boolean isCollectProcessInfoEnable()
  {
    return this.h;
  }
  
  public boolean isEnableQmsp()
  {
    return this.o;
  }
  
  public boolean isEventReportEnable()
  {
    return this.b;
  }
  
  public boolean isForceEnableAtta()
  {
    return this.n;
  }
  
  public boolean isPagePathEnable()
  {
    return this.p;
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
    localStringBuilder.append(", collectMACEnable=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", collectIMEIEnable=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", collectAndroidIdEnable=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", collectProcessInfoEnable=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", realtimePollingTime=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", normalPollingTIme=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", httpAdapter=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", uploadHost='");
    localStringBuilder.append(this.l);
    localStringBuilder.append('\'');
    localStringBuilder.append(", configHost='");
    localStringBuilder.append(this.m);
    localStringBuilder.append('\'');
    localStringBuilder.append(", forceEnableAtta=");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", enableQmsp=");
    localStringBuilder.append(this.o);
    localStringBuilder.append(", pagePathEnable=");
    localStringBuilder.append(this.p);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.event.open.BeaconConfig
 * JD-Core Version:    0.7.0.1
 */