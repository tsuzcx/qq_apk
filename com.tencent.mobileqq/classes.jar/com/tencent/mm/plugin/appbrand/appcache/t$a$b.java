package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.a;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"}, k=3, mv={1, 1, 16})
final class t$a$b<T>
  implements e.a<Object>
{
  public static final b a = new b();
  
  public final void a(Object paramObject)
  {
    String str = t.a.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CgiGetPublicInfo interrupted: ");
    localStringBuilder.append(paramObject);
    o.b(str, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.t.a.b
 * JD-Core Version:    0.7.0.1
 */