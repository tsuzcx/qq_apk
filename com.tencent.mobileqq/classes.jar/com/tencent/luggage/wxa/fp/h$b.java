package com.tencent.luggage.wxa.fp;

import com.tencent.luggage.storage.b;
import com.tencent.luggage.wxa.rb.a;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "username", "", "versionType", "", "invoke"}, k=3, mv={1, 1, 16})
final class h$b
  extends Lambda
  implements Function2<String, Integer, Boolean>
{
  public static final b a = new b();
  
  h$b()
  {
    super(2);
  }
  
  public final boolean a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "username");
    g localg = (g)b.a(g.class);
    if ((localg != null) && (!localg.a((a)f.a(paramString, paramInt), new String[0]))) {
      return localg.a((a)f.a(paramString, paramInt));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fp.h.b
 * JD-Core Version:    0.7.0.1
 */