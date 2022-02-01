package com.tencent.luggage.wxa.fp;

import com.tencent.luggage.wxa.qw.id;
import com.tencent.luggage.wxa.qw.ie;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.a;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"}, k=3, mv={1, 1, 16})
final class a$b<T>
  implements e.a<Object>
{
  a$b(ie paramie) {}
  
  public final void a(Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("run op[");
    localStringBuilder.append(this.a.a.a);
    localStringBuilder.append(' ');
    localStringBuilder.append(this.a.a.b);
    localStringBuilder.append(' ');
    localStringBuilder.append(this.a.e);
    localStringBuilder.append("], interrupted by ");
    localStringBuilder.append(paramObject);
    o.b("Luggage.CgiModCollection", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fp.a.b
 * JD-Core Version:    0.7.0.1
 */