package com.tencent.luggage.wxa.jx;

import com.tencent.luggage.wxa.jj.u;
import com.tencent.luggage.wxa.qw.ai;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/BatchWxaAttrSyncResponse;", "invoke"}, k=3, mv={1, 1, 16})
final class ae$c$a$a
  extends Lambda
  implements Function1<ai, Unit>
{
  ae$c$a$a(ae.c.a parama)
  {
    super(1);
  }
  
  public final void a(@Nullable ai paramai)
  {
    if (paramai == null)
    {
      this.a.b.invoke("get contact fail response is null");
      return;
    }
    if (u.a().a(paramai))
    {
      paramai = u.a().a(ae.c.a(this.a.a), new String[0]);
      if (paramai != null)
      {
        this.a.d.invoke(paramai);
        if (paramai != null) {
          return;
        }
      }
      this.a.b.invoke("get contact fail");
      return;
    }
    this.a.b.invoke("update contacts fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.ae.c.a.a
 * JD-Core Version:    0.7.0.1
 */