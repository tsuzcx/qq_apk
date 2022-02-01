package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.wxa.qz.w;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<no name provided>", "", "key", "", "value", "invoke"}, k=3, mv={1, 1, 16})
final class e$d
  extends Lambda
  implements Function2<String, String, Unit>
{
  e$d(e parame)
  {
    super(2);
  }
  
  public final void a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "key");
    Intrinsics.checkParameterIsNotNull(paramString2, "value");
    e.a(this.a).putString(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.e.d
 * JD-Core Version:    0.7.0.1
 */