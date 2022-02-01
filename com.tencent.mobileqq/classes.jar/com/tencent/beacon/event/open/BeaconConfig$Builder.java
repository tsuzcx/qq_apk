package com.tencent.beacon.event.open;

import java.util.concurrent.ScheduledExecutorService;

public final class BeaconConfig$Builder
{
  private int a = 10000;
  private boolean b = true;
  private boolean c = true;
  private boolean d = true;
  private boolean e = true;
  private boolean f = true;
  private boolean g = true;
  private boolean h = true;
  private ScheduledExecutorService i;
  private com.tencent.beacon.base.net.adapter.a j;
  private long k;
  private long l;
  private String m;
  private String n;
  private boolean o = false;
  private boolean p = true;
  private boolean q = true;
  
  public Builder auditEnable(boolean paramBoolean)
  {
    this.c = paramBoolean;
    return this;
  }
  
  public Builder bidEnable(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }
  
  public BeaconConfig build()
  {
    ScheduledExecutorService localScheduledExecutorService = this.i;
    if (localScheduledExecutorService != null) {
      com.tencent.beacon.a.b.a.a(localScheduledExecutorService);
    }
    return new BeaconConfig(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.k, this.l, this.j, this.m, this.n, this.o, this.p, this.q, null);
  }
  
  public Builder collectAndroidIdEnable(boolean paramBoolean)
  {
    this.g = paramBoolean;
    return this;
  }
  
  public Builder collectIMEIEnable(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }
  
  public Builder collectMACEnable(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }
  
  public Builder collectProcessInfoEnable(boolean paramBoolean)
  {
    this.h = paramBoolean;
    return this;
  }
  
  public Builder eventReportEnable(boolean paramBoolean)
  {
    this.b = paramBoolean;
    return this;
  }
  
  public Builder maxDBCount(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
  
  public Builder pagePathEnable(boolean paramBoolean)
  {
    this.q = paramBoolean;
    return this;
  }
  
  public Builder qmspEnable(boolean paramBoolean)
  {
    this.p = paramBoolean;
    return this;
  }
  
  public Builder setConfigHost(String paramString)
  {
    this.n = paramString;
    return this;
  }
  
  public Builder setExecutorService(ScheduledExecutorService paramScheduledExecutorService)
  {
    this.i = paramScheduledExecutorService;
    return this;
  }
  
  public Builder setForceEnableAtta(boolean paramBoolean)
  {
    this.o = paramBoolean;
    return this;
  }
  
  public Builder setHttpAdapter(com.tencent.beacon.base.net.adapter.a parama)
  {
    this.j = parama;
    return this;
  }
  
  public Builder setNormalPollingTime(long paramLong)
  {
    this.l = paramLong;
    return this;
  }
  
  public Builder setRealtimePollingTime(long paramLong)
  {
    this.k = paramLong;
    return this;
  }
  
  public Builder setUploadHost(String paramString)
  {
    this.m = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.event.open.BeaconConfig.Builder
 * JD-Core Version:    0.7.0.1
 */