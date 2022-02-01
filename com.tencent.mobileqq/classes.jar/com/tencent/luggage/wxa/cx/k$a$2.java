package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.b;
import com.tencent.luggage.wxa.ro.e.a;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"}, k=3, mv={1, 1, 16})
final class k$a$2<T>
  implements e.a<Object>
{
  k$a$2(b paramb) {}
  
  public final void a(Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getAppIdByUserName fail: ");
    localStringBuilder.append(paramObject);
    o.b("Luggage.WxaAttrSyncHelper", localStringBuilder.toString());
    this.a.a(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.k.a.2
 * JD-Core Version:    0.7.0.1
 */