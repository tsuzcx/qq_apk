package com.tencent.luggage.wxa.fj;

import com.tencent.luggage.wxa.dj.a;
import com.tencent.luggage.wxa.dj.e;
import com.tencent.luggage.wxa.dj.f;
import com.tencent.luggage.wxa.qz.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/luggage/reporter/ISmcKVReportService;", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 1, 16})
final class f$a
  extends Lambda
  implements Function0<a>
{
  public static final a a = new a();
  
  f$a()
  {
    super(0);
  }
  
  public final a a()
  {
    Object localObject = r.c();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "processName");
    localObject = (CharSequence)localObject;
    int i;
    if (((CharSequence)localObject).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i == 0) && (!r.h()))
    {
      if (StringsKt.contains$default((CharSequence)localObject, (CharSequence)":wxa_container", false, 2, null))
      {
        localObject = r.i();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "MMApplicationContext.getMainProcessName()");
        return (a)new f((String)localObject);
      }
      return (a)com.tencent.luggage.wxa.pd.g.a("SmcReporter.Dummy", a.class);
    }
    return (a)new e((com.tencent.luggage.wxa.dj.g)new f.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fj.f.a
 * JD-Core Version:    0.7.0.1
 */