package com.tencent.luggage.wxa.de;

import com.tencent.luggage.wxa.ro.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "RESP", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "TRAN_REQ", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "TRAN_RESP", "isSuccess", "", "errMsg", "", "invoke"}, k=3, mv={1, 1, 16})
final class j$g$1
  extends Lambda
  implements Function2<Boolean, String, Unit>
{
  j$g$1(b paramb)
  {
    super(2);
  }
  
  public final void a(boolean paramBoolean, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errMsg");
    if (paramBoolean)
    {
      this.a.a(new Object[] { Boolean.valueOf(true) });
      return;
    }
    this.a.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.de.j.g.1
 * JD-Core Version:    0.7.0.1
 */