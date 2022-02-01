package com.tencent.luggage.wxa.dc;

import com.tencent.luggage.wxa.qw.ix;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.c;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "response", "Lcom/tencent/mm/protocal/protobuf/UpdateWxaUsageRecordResponse;", "kotlin.jvm.PlatformType", "onTerminate"}, k=3, mv={1, 1, 16})
final class n$a<T>
  implements e.c<ix>
{
  n$a(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  public final void a(ix paramix)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("addUsage username=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", appId=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", versionType=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", visitSessionId=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", visitScene=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", response=");
    localStringBuilder.append(n.a(n.a, paramix));
    o.d("WMPF.UpdateWxaUsageRecord", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.n.a
 * JD-Core Version:    0.7.0.1
 */