package com.tencent.luggage.opensdk;

import com.tencent.luggage.wxa.ro.e.a;
import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"}, k=3, mv={1, 1, 16})
final class i$b$h<T>
  implements e.a<Object>
{
  i$b$h(i.b paramb) {}
  
  public final void a(Object paramObject)
  {
    Object localObject1 = this.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("GetDeepLinkTicket interrupted by ");
    ((StringBuilder)localObject2).append(paramObject);
    i.b.a((i.b)localObject1, ((StringBuilder)localObject2).toString());
    if ((paramObject instanceof TimeoutException))
    {
      paramObject = ((TimeoutException)paramObject).getMessage();
      if (paramObject == null) {
        paramObject = "fail:timeout";
      }
    }
    else if ((paramObject instanceof Exception))
    {
      paramObject = ((Exception)paramObject).getMessage();
      if (paramObject == null) {
        paramObject = "";
      }
    }
    else if ((paramObject instanceof String))
    {
      paramObject = (String)paramObject;
    }
    else
    {
      paramObject = "fail";
    }
    localObject1 = paramObject;
    if (!StringsKt.startsWith$default(paramObject, "fail", false, 2, null))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("fail:");
      ((StringBuilder)localObject1).append(paramObject);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    i.b.d(this.a);
    paramObject = i.b.e(this.a);
    localObject2 = this.a;
    paramObject.invoke(i.b.a((i.b)localObject2, i.b.b((i.b)localObject2), (String)localObject1, null, 2, null));
    i.b.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.i.b.h
 * JD-Core Version:    0.7.0.1
 */