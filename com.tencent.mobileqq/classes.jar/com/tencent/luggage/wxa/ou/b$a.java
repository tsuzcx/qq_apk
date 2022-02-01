package com.tencent.luggage.wxa.ou;

import com.tencent.luggage.wxa.qw.lm;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.c;
import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/WxaAppIDKeyBatchReportResponse;", "kotlin.jvm.PlatformType", "onTerminate"}, k=3, mv={1, 1, 16})
final class b$a<T>
  implements e.c<lm>
{
  b$a(String paramString, LinkedList paramLinkedList) {}
  
  public final void a(lm paramlm)
  {
    paramlm = new StringBuilder();
    paramlm.append("reportNow, reason=");
    paramlm.append(this.a);
    paramlm.append(", reportList.size=");
    paramlm.append(this.b.size());
    paramlm.append(", cgi back ok");
    o.d("Luggage.AppBrandIDKeyBatchReportNew", paramlm.toString());
    this.b.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ou.b.a
 * JD-Core Version:    0.7.0.1
 */