package com.tencent.luggage.wxa.fc;

import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"navigateBackOnTransferFailure", "", "Lcom/tencent/luggage/wxa/standalone_open_runtime/jsapi/JsApiNavigateToMiniProgramBridged$BridgedWxaRuntime;", "message", "", "invoke"}, k=3, mv={1, 1, 16})
final class b$g$2
  extends Lambda
  implements Function2<b.e, String, Unit>
{
  b$g$2(b.g paramg)
  {
    super(2);
  }
  
  public final void a(@NotNull b.e parame, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(parame, "$this$navigateBackOnTransferFailure");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("invoke appId:");
    localStringBuilder.append(this.a.c.getAppId());
    localStringBuilder.append(" callbackId:");
    localStringBuilder.append(this.a.e);
    localStringBuilder.append(" navigateBackOnTransferFailure");
    o.b("Luggage.Wxa.JsApiNavigateToMiniProgramBridged", localStringBuilder.toString());
    parame.E();
    if (paramString == null) {
      paramString = "";
    }
    parame = paramString;
    if (!StringsKt.startsWith$default(paramString, "fail", false, 2, null))
    {
      parame = new StringBuilder();
      parame.append("fail ");
      parame.append(paramString);
      parame = parame.toString();
    }
    this.a.c.a(this.a.e, this.a.a.b(parame));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fc.b.g.2
 * JD-Core Version:    0.7.0.1
 */