package com.tencent.luggage.wxa.fi;

import com.tencent.luggage.wxa.oo.d;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.a;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"}, k=3, mv={1, 1, 16})
final class a$e<T>
  implements e.a<Object>
{
  a$e(d paramd, a.b paramb) {}
  
  public final void a(Object paramObject)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleCgiTransferActionIfNeed, interrupted by ");
    ((StringBuilder)localObject).append(paramObject);
    ((StringBuilder)localObject).append(", context:");
    ((StringBuilder)localObject).append(this.a);
    o.b("Luggage.STANDALONE.JsAuthTransferLogic", ((StringBuilder)localObject).toString());
    localObject = this.b;
    if (localObject != null) {
      ((a.b)localObject).a(paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fi.a.e
 * JD-Core Version:    0.7.0.1
 */