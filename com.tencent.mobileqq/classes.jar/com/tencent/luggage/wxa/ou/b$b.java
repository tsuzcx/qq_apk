package com.tencent.luggage.wxa.ou;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.a;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"}, k=3, mv={1, 1, 16})
final class b$b<T>
  implements e.a<Object>
{
  b$b(String paramString, LinkedList paramLinkedList) {}
  
  public final void a(Object arg1)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportNow, reason=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", reportList.size=");
    localStringBuilder.append(this.b.size());
    localStringBuilder.append(", cgi error ");
    if (??? != null) {
      ??? = ???.toString();
    } else {
      ??? = null;
    }
    localStringBuilder.append(???);
    o.b("Luggage.AppBrandIDKeyBatchReportNew", localStringBuilder.toString());
    synchronized (b.a(b.a))
    {
      b.a(b.a).addAll((Collection)this.b);
      this.b.clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ou.b.b
 * JD-Core Version:    0.7.0.1
 */