package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.luggage.wxa.nn.a;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader$FileEntry;", "invoke"}, k=3, mv={1, 1, 16})
final class aj$j
  extends Lambda
  implements Function0<h.a>
{
  aj$j(aj paramaj, String paramString)
  {
    super(0);
  }
  
  @Nullable
  public final h.a a()
  {
    Object localObject1 = (h.a)aj.c(this.a).get(this.b);
    if (localObject1 != null) {
      return localObject1;
    }
    localObject1 = (h.a)null;
    String[] arrayOfString = new String[2];
    Object localObject2 = k.b(this.b);
    int i = 0;
    arrayOfString[0] = localObject2;
    arrayOfString[1] = a.a(this.b);
    int j = arrayOfString.length;
    while (i < j)
    {
      localObject2 = arrayOfString[i];
      if (!Intrinsics.areEqual(localObject2, this.b))
      {
        localObject2 = (h.a)aj.c(this.a).get(localObject2);
        localObject1 = localObject2;
        if (localObject2 != null) {
          return localObject2;
        }
      }
      i += 1;
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aj.j
 * JD-Core Version:    0.7.0.1
 */