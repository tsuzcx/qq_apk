package com.tencent.luggage.wxa.dc;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.a;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"}, k=3, mv={1, 1, 16})
final class w$b<T>
  implements e.a<Object>
{
  public static final b a = new b();
  
  public final void a(Object paramObject)
  {
    if ((paramObject instanceof Throwable))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("fail:");
      localStringBuilder.append(((Throwable)paramObject).getMessage());
      paramObject = localStringBuilder.toString();
    }
    else if ((paramObject instanceof String))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("fail:");
      localStringBuilder.append(paramObject);
      paramObject = localStringBuilder.toString();
    }
    else
    {
      paramObject = "fail:internal error";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("boot fail: ");
    localStringBuilder.append(paramObject);
    o.b("Luggage.WxaTdiLoginBoot", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.w.b
 * JD-Core Version:    0.7.0.1
 */