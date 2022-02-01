package com.tencent.mm.plugin.appbrand.appcache;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkg;", "invoke"}, k=3, mv={1, 1, 16})
final class aj$c
  extends Lambda
  implements Function0<v>
{
  aj$c(aj paramaj, String paramString)
  {
    super(0);
  }
  
  @Nullable
  public final v a()
  {
    Object localObject1 = (h.a)aj.c(this.a).get(this.b);
    if (localObject1 != null) {
      localObject1 = ((h.a)localObject1).g;
    } else {
      localObject1 = null;
    }
    if (localObject1 != null) {
      return localObject1;
    }
    localObject1 = ((Map)aj.c(this.a)).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      String str = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (h.a)((Map.Entry)localObject2).getValue();
      if (StringsKt.startsWith$default(str, this.b, false, 2, null)) {
        return ((h.a)localObject2).g;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aj.c
 * JD-Core Version:    0.7.0.1
 */