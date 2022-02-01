package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"}, k=3, mv={1, 1, 16})
final class c$b<T>
  implements e.a<Object>
{
  c$b(Function1 paramFunction1) {}
  
  public final void a(Object paramObject)
  {
    if ((paramObject instanceof Exception))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CgiCheckVerifyCodeWxaPhone ");
      localStringBuilder.append(((Exception)paramObject).getMessage());
      o.b("Luggage.FULL.CgiPhoneNumber", localStringBuilder.toString());
    }
    paramObject = this.a;
    if (paramObject != null) {
      paramObject = (Unit)paramObject.invoke(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.c.b
 * JD-Core Version:    0.7.0.1
 */