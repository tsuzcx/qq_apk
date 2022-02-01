package com.tencent.luggage.wxa.nl;

import com.tencent.luggage.wxa.qw.ac;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "batchResp", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "invoke"}, k=3, mv={1, 1, 16})
final class b$b$a
  extends Lambda
  implements Function1<ac, Unit>
{
  b$b$a(b.b paramb)
  {
    super(1);
  }
  
  public final void a(@NotNull ac paramac)
  {
    Intrinsics.checkParameterIsNotNull(paramac, "batchResp");
    Object localObject1 = b.b.a(this.a).entrySet();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "requestMap.entries");
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (Map.Entry)((Iterator)localObject1).next();
      Object localObject2 = (k.b)e.a((Map.Entry)localObject3);
      localObject3 = (Function1)((Pair)e.b((Map.Entry)localObject3)).component1();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "req");
      localObject2 = e.a(paramac, (k.b)localObject2);
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      ((Function1)localObject3).invoke(localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nl.b.b.a
 * JD-Core Version:    0.7.0.1
 */