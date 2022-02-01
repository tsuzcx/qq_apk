package com.tencent.luggage.wxa.ka;

import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.qw.ek;
import com.tencent.luggage.wxa.qw.md;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"createConfirmRequest", "Lcom/tencent/mm/protocal/protobuf/JSAuthorizeConfirmRequest;", "invoke"}, k=3, mv={1, 1, 16})
final class h$b$1$b$a
  extends Lambda
  implements Function0<ek>
{
  h$b$1$b$a(h.b.1.b paramb, ArrayList paramArrayList, int paramInt)
  {
    super(0);
  }
  
  @NotNull
  public final ek a()
  {
    ek localek = new ek();
    localek.a = this.a.a.a.b.getAppId();
    localek.b.add(CollectionsKt.firstOrNull((List)this.b));
    localek.c = this.c;
    d locald = this.a.a.a.b.q();
    Intrinsics.checkExpressionValueIsNotNull(locald, "service.runtime");
    localek.d = locald.ab();
    localek.e = this.a.a.a.a.a(new md(), (com.tencent.luggage.wxa.jx.h)this.a.a.a.b);
    return localek;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ka.h.b.1.b.a
 * JD-Core Version:    0.7.0.1
 */