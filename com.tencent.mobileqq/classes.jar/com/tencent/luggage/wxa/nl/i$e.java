package com.tencent.luggage.wxa.nl;

import com.tencent.luggage.wxa.ob.a;
import com.tencent.luggage.wxa.ob.a.a;
import com.tencent.luggage.wxa.ro.e.a;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"}, k=3, mv={1, 1, 16})
final class i$e<T>
  implements e.a<Object>
{
  i$e(Function3 paramFunction3) {}
  
  public final void a(Object paramObject)
  {
    if ((paramObject instanceof a))
    {
      localFunction3 = this.a;
      paramObject = (a)paramObject;
      localFunction3.invoke(Integer.valueOf(paramObject.b().j), Integer.valueOf(paramObject.c()), paramObject.d());
      return;
    }
    Function3 localFunction3 = this.a;
    if (paramObject != null) {
      paramObject = paramObject.toString();
    } else {
      paramObject = null;
    }
    localFunction3.invoke(Integer.valueOf(-1), Integer.valueOf(-1), paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nl.i.e
 * JD-Core Version:    0.7.0.1
 */