package com.tencent.luggage.wxa.dj;

import com.tencent.luggage.wxa.hj.c;
import com.tencent.luggage.wxa.hj.e;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "toReportList", "Lcom/tencent/luggage/reporter/ReportLogDataList;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"}, k=3, mv={1, 1, 16})
final class f$a<InputType, ResultType>
  implements c<d, com.tencent.luggage.wxa.hu.d>
{
  public static final a a = new a();
  
  public final void a(d paramd, e<com.tencent.luggage.wxa.hu.d> parame)
  {
    a locala = a.a.b.a();
    if (locala != null)
    {
      ((b)locala).a(paramd);
      if (parame != null) {
        parame.a(com.tencent.luggage.wxa.hu.d.a);
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.luggage.reporter.ISmcKVReportServiceEx");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dj.f.a
 * JD-Core Version:    0.7.0.1
 */