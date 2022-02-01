package com.tencent.luggage.wxa.fq;

import com.tencent.luggage.wxa.ft.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.a;
import com.tencent.luggage.wxaapi.LaunchWxaAppResult;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"}, k=3, mv={1, 1, 16})
final class g$m<T>
  implements e.a<Object>
{
  g$m(long paramLong) {}
  
  public final void a(Object paramObject)
  {
    g.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("launchByUserName fail: ");
    localStringBuilder.append(paramObject);
    o.b("Luggage.WxaApiImpl", localStringBuilder.toString());
    a.a.a(this.a, LaunchWxaAppResult.FailWxaAppIdSync);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.g.m
 * JD-Core Version:    0.7.0.1
 */