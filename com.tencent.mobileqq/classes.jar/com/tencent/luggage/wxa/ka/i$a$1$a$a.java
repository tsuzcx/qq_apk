package com.tencent.luggage.wxa.ka;

import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jx.h;
import com.tencent.luggage.wxa.qw.eo;
import com.tencent.luggage.wxa.qw.md;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"createConfirmRequest", "Lcom/tencent/mm/protocal/protobuf/JSLoginConfirmRequest;", "invoke"}, k=3, mv={1, 1, 16})
final class i$a$1$a$a
  extends Lambda
  implements Function0<eo>
{
  i$a$1$a$a(i.a.1.a parama, ArrayList paramArrayList, int paramInt)
  {
    super(0);
  }
  
  @NotNull
  public final eo a()
  {
    eo localeo = new eo();
    localeo.a = this.a.a.a.b.getAppId();
    LinkedList localLinkedList = localeo.b;
    Object localObject = (List)this.b;
    if (localObject == null) {
      localObject = CollectionsKt.emptyList();
    }
    localLinkedList.addAll((Collection)localObject);
    localeo.e = this.c;
    localObject = this.a.a.a.b.q();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "service.runtime");
    localeo.f = ((d)localObject).ab();
    localeo.g = this.a.a.a.a.a(new md(), (h)this.a.a.a.b);
    return localeo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ka.i.a.1.a.a
 * JD-Core Version:    0.7.0.1
 */