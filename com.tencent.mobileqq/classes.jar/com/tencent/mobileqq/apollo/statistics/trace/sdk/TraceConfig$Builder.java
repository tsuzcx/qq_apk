package com.tencent.mobileqq.apollo.statistics.trace.sdk;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.statistics.trace.TraceMappingIml;
import com.tencent.mobileqq.apollo.statistics.trace.sdk.component.DefaultTraceNetwork;
import com.tencent.mobileqq.apollo.statistics.trace.sdk.component.DefaultTraceStorage;
import com.tencent.mobileqq.apollo.statistics.trace.sdk.component.ITraceMapping;
import com.tencent.mobileqq.apollo.statistics.trace.sdk.component.ITraceNetwork;
import com.tencent.mobileqq.apollo.statistics.trace.sdk.component.ITraceStorage;

public class TraceConfig$Builder
{
  int a;
  String b;
  int c = 30000;
  private ITraceStorage d;
  private ITraceNetwork e;
  private ITraceMapping f;
  
  public Builder a(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
  
  public Builder a(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public TraceConfig a()
  {
    if (this.d == null) {
      this.d = new DefaultTraceStorage();
    }
    if (this.e == null) {
      this.e = new DefaultTraceNetwork();
    }
    if (this.f == null) {
      this.f = new TraceMappingIml();
    }
    if (this.a != 0)
    {
      if (!TextUtils.isEmpty(this.b)) {
        return new TraceConfig(this.a, this.b, this.c, this.d, this.e, this.f, null);
      }
      throw new IllegalArgumentException("current account uid is required.");
    }
    throw new IllegalArgumentException("appId required.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.trace.sdk.TraceConfig.Builder
 * JD-Core Version:    0.7.0.1
 */