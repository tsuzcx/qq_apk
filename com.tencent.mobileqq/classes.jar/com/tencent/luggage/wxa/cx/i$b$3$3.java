package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.b;
import com.tencent.luggage.wxa.ro.e.a;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"}, k=3, mv={1, 1, 16})
final class i$b$3$3<T>
  implements e.a<Object>
{
  i$b$3$3(i.b.3 param3, int paramInt, String paramString) {}
  
  public final void a(Object paramObject)
  {
    i.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("syncPipeline ");
    localStringBuilder.append(this.a.a.b);
    localStringBuilder.append(", fail: ");
    localStringBuilder.append(paramObject);
    o.b("Luggage.SubProcessGetCodePkgNew", localStringBuilder.toString());
    paramObject = this.a.a.j;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b);
    localStringBuilder.append(',');
    localStringBuilder.append(this.c);
    paramObject.a(new Error(localStringBuilder.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.i.b.3.3
 * JD-Core Version:    0.7.0.1
 */