package com.tencent.luggage.wxa.nl;

import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "invoke"}, k=3, mv={1, 1, 16})
final class b$b$b
  extends Lambda
  implements Function3<Integer, Integer, String, Unit>
{
  b$b$b(b.b paramb)
  {
    super(3);
  }
  
  public final void a(int paramInt1, int paramInt2, @Nullable String paramString)
  {
    Object localObject = b.b.a(this.a).values();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "requestMap.values");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Function3)((Pair)((Iterator)localObject).next()).component2()).invoke(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nl.b.b.b
 * JD-Core Version:    0.7.0.1
 */