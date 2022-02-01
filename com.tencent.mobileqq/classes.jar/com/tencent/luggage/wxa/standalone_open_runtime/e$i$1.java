package com.tencent.luggage.wxa.standalone_open_runtime;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke", "com/tencent/luggage/wxa/standalone_open_runtime/WxaPageView$createMenuInfoList$1$4$1$1", "com/tencent/luggage/wxa/standalone_open_runtime/WxaPageView$$special$$inlined$apply$lambda$6$1"}, k=3, mv={1, 1, 16})
final class e$i$1
  extends Lambda
  implements Function0<String>
{
  e$i$1(e parame)
  {
    super(0);
  }
  
  @NotNull
  public final String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n                            {\n                                \"appId\": \"");
    localStringBuilder.append(this.a.getAppId());
    localStringBuilder.append("\",\n                                \"pageId\": \"");
    localStringBuilder.append(this.a.an());
    localStringBuilder.append("\",\n                                \"appVersion\": ");
    com.tencent.luggage.wxa.ed.d locald = this.a.f();
    Intrinsics.checkExpressionValueIsNotNull(locald, "pageView.runtime");
    localStringBuilder.append(locald.i().b());
    localStringBuilder.append(",\n                                \"versionType\": ");
    locald = this.a.f();
    Intrinsics.checkExpressionValueIsNotNull(locald, "pageView.runtime");
    localStringBuilder.append(locald.ab());
    localStringBuilder.append("\n                            }\n                        ");
    return StringsKt.trimIndent(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.e.i.1
 * JD-Core Version:    0.7.0.1
 */