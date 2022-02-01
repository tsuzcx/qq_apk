package com.tencent.luggage.wxa.lc;

import com.tencent.luggage.wxa.ih.b.a;
import com.tencent.luggage.wxa.ih.c;
import com.tencent.mm.msgsubscription.ui.a.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<no name provided>", "", "event", "", "items", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "alwaysKeepSelected", "", "invoke"}, k=3, mv={1, 1, 16})
final class b$d$a
  extends Lambda
  implements Function3<Integer, List<a.b>, Boolean, Unit>
{
  b$d$a(b.d paramd)
  {
    super(3);
  }
  
  public final void a(int paramInt, @NotNull List<a.b> paramList, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "items");
    paramList = com.tencent.luggage.wxa.ih.b.a.a(paramInt, paramList, paramBoolean);
    b.c localc = this.a.a.b();
    if (localc != null) {
      localc.a(b.a(this.a.a), (List)this.a.b.c(), paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lc.b.d.a
 * JD-Core Version:    0.7.0.1
 */