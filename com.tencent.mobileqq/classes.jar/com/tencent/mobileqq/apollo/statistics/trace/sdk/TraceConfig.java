package com.tencent.mobileqq.apollo.statistics.trace.sdk;

import com.tencent.mobileqq.apollo.statistics.trace.sdk.component.ITraceMapping;
import com.tencent.mobileqq.apollo.statistics.trace.sdk.component.ITraceNetwork;
import com.tencent.mobileqq.apollo.statistics.trace.sdk.component.ITraceStorage;

public class TraceConfig
{
  private int a;
  private String b;
  private int c;
  private ITraceStorage d;
  private ITraceNetwork e;
  private ITraceMapping f;
  
  private TraceConfig(int paramInt1, String paramString, int paramInt2, ITraceStorage paramITraceStorage, ITraceNetwork paramITraceNetwork, ITraceMapping paramITraceMapping)
  {
    this.a = paramInt1;
    this.b = paramString;
    this.c = paramInt2;
    this.d = paramITraceStorage;
    this.e = paramITraceNetwork;
    this.f = paramITraceMapping;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public String a(int paramInt)
  {
    return this.f.a(paramInt);
  }
  
  public int b()
  {
    return this.c;
  }
  
  public boolean b(int paramInt)
  {
    return this.f.b(paramInt);
  }
  
  public ITraceStorage c()
  {
    return this.d;
  }
  
  public boolean c(int paramInt)
  {
    return this.f.c(paramInt);
  }
  
  public ITraceNetwork d()
  {
    return this.e;
  }
  
  public ITraceMapping e()
  {
    return this.f;
  }
  
  public String f()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.trace.sdk.TraceConfig
 * JD-Core Version:    0.7.0.1
 */