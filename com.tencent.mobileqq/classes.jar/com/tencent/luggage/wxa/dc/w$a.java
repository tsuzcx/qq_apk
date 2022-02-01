package com.tencent.luggage.wxa.dc;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.c;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onTerminate", "(Ljava/lang/Boolean;)V"}, k=3, mv={1, 1, 16})
final class w$a<T>
  implements e.c<Boolean>
{
  public static final a a = new a();
  
  public final void a(Boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Wxa login logic boot success:");
    localStringBuilder.append(paramBoolean);
    o.d("Luggage.WxaTdiLoginBoot", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.w.a
 * JD-Core Version:    0.7.0.1
 */