package com.tencent.luggage.wxa.jx;

import com.tencent.luggage.wxa.ro.e.a;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"}, k=3, mv={1, 1, 16})
final class ae$c$b$1<T>
  implements e.a<Object>
{
  ae$c$b$1(ae.c.b paramb) {}
  
  public final void a(Object paramObject)
  {
    if (paramObject == null) {
      paramObject = null;
    } else if ((paramObject instanceof Throwable)) {
      paramObject = ((Throwable)paramObject).getMessage();
    } else {
      paramObject = paramObject.toString();
    }
    this.a.d.invoke(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.ae.c.b.1
 * JD-Core Version:    0.7.0.1
 */