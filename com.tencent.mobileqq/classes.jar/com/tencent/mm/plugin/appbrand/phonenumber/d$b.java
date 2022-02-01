package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"}, k=3, mv={1, 1, 16})
final class d$b<T>
  implements e.a<Object>
{
  d$b(Function4 paramFunction4) {}
  
  public final void a(Object paramObject)
  {
    o.b("Luggage.FULL.CgiPhoneNumber", "getPhoneNumber fail");
    if ((paramObject instanceof Exception))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CgiGetAllPhone ");
      localStringBuilder.append(((Exception)paramObject).getMessage());
      o.b("Luggage.FULL.CgiPhoneNumber", localStringBuilder.toString());
    }
    paramObject = this.a;
    if (paramObject != null) {
      paramObject = (Unit)paramObject.invoke(Boolean.valueOf(false), "cgi fail", null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.d.b
 * JD-Core Version:    0.7.0.1
 */