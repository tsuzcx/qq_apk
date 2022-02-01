package com.tencent.luggage.wxa.ef;

import com.tencent.luggage.wxa.qz.w;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "T", "", "invoke"}, k=3, mv={1, 1, 16})
final class h$b
  extends Lambda
  implements Function0<w>
{
  h$b(h paramh)
  {
    super(0);
  }
  
  public final w a()
  {
    Object localObject = (CharSequence)h.a(this.a);
    int i;
    if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      String str = h.b(this.a).getClass().getCanonicalName();
      localObject = str;
      if (str == null)
      {
        Intrinsics.throwNpe();
        localObject = str;
      }
    }
    else
    {
      localObject = h.a(this.a);
    }
    return w.a((String)localObject, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ef.h.b
 * JD-Core Version:    0.7.0.1
 */