package com.tencent.beacon.event.open;

import java.util.concurrent.ScheduledExecutorService;

public final class BeaconConfig$Builder
{
  private int a = 10000;
  private boolean b = true;
  private boolean c = true;
  private boolean d = true;
  private ScheduledExecutorService e;
  private com.tencent.beacon.base.net.adapter.a f;
  private long g;
  private long h;
  private String i;
  private String j;
  private boolean k = false;
  private boolean l = true;
  private boolean m = true;
  
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
    ScheduledExecutorService localScheduledExecutorService = this.e;
    if (localScheduledExecutorService != null) {
      com.tencent.beacon.a.b.a.a(localScheduledExecutorService);
    }
    return new BeaconConfig(this.a, this.b, this.c, this.d, this.g, this.h, this.f, this.i, this.j, this.k, this.l, this.m, null);
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
    this.m = paramBoolean;
    return this;
  }
  
  public Builder qmspEnable(boolean paramBoolean)
  {
    this.l = paramBoolean;
    return this;
  }
  
  public Builder setConfigHost(String paramString)
  {
    this.j = paramString;
    return this;
  }
  
  public Builder setExecutorService(ScheduledExecutorService paramScheduledExecutorService)
  {
    this.e = paramScheduledExecutorService;
    return this;
  }
  
  public Builder setForceEnableAtta(boolean paramBoolean)
  {
    this.k = paramBoolean;
    return this;
  }
  
  public Builder setHttpAdapter(com.tencent.beacon.base.net.adapter.a parama)
  {
    this.f = parama;
    return this;
  }
  
  public Builder setNormalPollingTime(long paramLong)
  {
    this.h = paramLong;
    return this;
  }
  
  public Builder setRealtimePollingTime(long paramLong)
  {
    this.g = paramLong;
    return this;
  }
  
  public Builder setUploadHost(String paramString)
  {
    this.i = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.event.open.BeaconConfig.Builder
 * JD-Core Version:    0.7.0.1
 */