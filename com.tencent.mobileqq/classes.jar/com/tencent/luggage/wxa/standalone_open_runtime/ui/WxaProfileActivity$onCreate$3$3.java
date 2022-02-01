package com.tencent.luggage.wxa.standalone_open_runtime.ui;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class WxaProfileActivity$onCreate$3$3
  extends Lambda
  implements Function0<String>
{
  WxaProfileActivity$onCreate$3$3(WxaProfileActivity.onCreate.3 param3)
  {
    super(0);
  }
  
  @NotNull
  public final String invoke()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n                    {\n                        \"username\": \"");
    localStringBuilder.append(WxaProfileActivity.c(this.a.a));
    localStringBuilder.append("\"\n                    }\n                    ");
    return StringsKt.trimIndent(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.ui.WxaProfileActivity.onCreate.3.3
 * JD-Core Version:    0.7.0.1
 */