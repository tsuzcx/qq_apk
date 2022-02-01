package com.tencent.luggage.wxa.fp;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.a;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "thr", "", "kotlin.jvm.PlatformType", "onInterrupt"}, k=3, mv={1, 1, 16})
final class i$a$b$c<T>
  implements e.a<Object>
{
  public static final c a = new c();
  
  public final void a(Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[syncCollectionStatusToLocal] onInterrupt: error =");
    localStringBuilder.append(paramObject);
    o.d("MicroMsg.WxaCollectionStorage", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fp.i.a.b.c
 * JD-Core Version:    0.7.0.1
 */