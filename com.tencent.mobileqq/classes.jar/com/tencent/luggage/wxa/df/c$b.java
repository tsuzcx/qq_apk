package com.tencent.luggage.wxa.df;

import com.tencent.luggage.wxa.hj.e;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.a;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "e", "", "kotlin.jvm.PlatformType", "onInterrupt"}, k=3, mv={1, 1, 16})
final class c$b<T>
  implements e.a<Object>
{
  c$b(c paramc, e parame) {}
  
  public final void a(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      paramObject = (String)paramObject;
    } else if ((paramObject instanceof Exception)) {
      paramObject = ((Exception)paramObject).getMessage();
    } else {
      paramObject = "internal error";
    }
    Object localObject1 = this.a.a();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("invoke fail ");
    ((StringBuilder)localObject2).append(paramObject);
    o.b((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = this.b;
    if (localObject1 != null)
    {
      localObject2 = new f(0, null, null, 7, null);
      ((f)localObject2).a(-1);
      ((f)localObject2).a(String.valueOf(paramObject));
      ((e)localObject1).a(localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.df.c.b
 * JD-Core Version:    0.7.0.1
 */