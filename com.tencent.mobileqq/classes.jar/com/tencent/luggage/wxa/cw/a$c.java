package com.tencent.luggage.wxa.cw;

import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.a;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "thr", "", "kotlin.jvm.PlatformType", "onInterrupt"}, k=3, mv={1, 1, 16})
final class a$c<T>
  implements e.a<Object>
{
  a$c(a parama, h paramh, int paramInt) {}
  
  public final void a(Object paramObject)
  {
    if ((paramObject instanceof Throwable))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fail ");
      localStringBuilder.append(((Throwable)paramObject).getMessage());
      paramObject = localStringBuilder.toString();
    }
    else
    {
      o.b("Luggage.WxaStandalone.JsApiOpenWeRunSetting", "Unknown error %s", new Object[] { paramObject.getClass().getName() });
      paramObject = "fail:internal error";
    }
    this.b.a(this.c, this.a.b(paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cw.a.c
 * JD-Core Version:    0.7.0.1
 */