package com.tencent.luggage.wxa.lt;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority$Companion;", "", "()V", "of", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "str", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class b$c$a
{
  @NotNull
  public final b.c a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "str");
    b.c[] arrayOfc = b.c.values();
    int j = arrayOfc.length;
    int i = 0;
    while (i < j)
    {
      b.c localc = arrayOfc[i];
      if (StringsKt.equals(localc.name(), paramString, true)) {
        return localc;
      }
      i += 1;
    }
    return b.c.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lt.b.c.a
 * JD-Core Version:    0.7.0.1
 */