package com.tencent.mm.plugin.appbrand.appcache;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class aj$b
  extends Lambda
  implements Function0<Unit>
{
  aj$b(aj paramaj)
  {
    super(0);
  }
  
  public final void a()
  {
    Object localObject = aj.d(this.a).entrySet();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "pkgsMap.entries");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((v)((Map.Entry)((Iterator)localObject).next()).getValue()).close();
    }
    aj.d(this.a).clear();
    aj.c(this.a).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aj.b
 * JD-Core Version:    0.7.0.1
 */