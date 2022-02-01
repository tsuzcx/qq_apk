package com.tencent.luggage.wxa.ow;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.a;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"}, k=3, mv={1, 1, 16})
final class a$d<T>
  implements e.a<Object>
{
  a$d(Function2 paramFunction2) {}
  
  public final void a(Object paramObject)
  {
    if ((paramObject instanceof Exception))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkAsync exception");
      localStringBuilder.append(((Exception)paramObject).getMessage());
      o.b("MicroMsg.CgiCheckWxaShortLink", localStringBuilder.toString());
    }
    this.a.invoke(Boolean.valueOf(false), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ow.a.d
 * JD-Core Version:    0.7.0.1
 */