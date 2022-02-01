package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.wxa.qz.w;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "key", "invoke"}, k=3, mv={1, 1, 16})
final class e$c
  extends Lambda
  implements Function1<String, String>
{
  e$c(e parame)
  {
    super(1);
  }
  
  @NotNull
  public final String a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    paramString = e.a(this.a).getString(paramString, "");
    if (paramString != null) {
      return paramString;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.e.c
 * JD-Core Version:    0.7.0.1
 */