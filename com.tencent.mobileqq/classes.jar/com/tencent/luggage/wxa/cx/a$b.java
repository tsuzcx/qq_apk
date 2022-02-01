package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.a;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "DELIVER", "interrupt", "", "kotlin.jvm.PlatformType", "onInterrupt"}, k=3, mv={1, 1, 16})
final class a$b<T>
  implements e.a<Object>
{
  a$b(a parama, Object paramObject, com.tencent.luggage.wxa.ro.b paramb) {}
  
  public final void a(Object paramObject)
  {
    if ((paramObject instanceof Throwable)) {
      paramObject = ((Throwable)paramObject).getMessage();
    } else if (paramObject != null) {
      paramObject = paramObject.toString();
    } else {
      paramObject = null;
    }
    String str = a.a(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onInterrupt ");
    localStringBuilder.append(paramObject);
    o.b(str, localStringBuilder.toString());
    a.a(this.a, this.b, t.d.e, t.c.d, paramObject);
    this.c.a(new com.tencent.luggage.wxa.cy.b(1, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.a.b
 * JD-Core Version:    0.7.0.1
 */