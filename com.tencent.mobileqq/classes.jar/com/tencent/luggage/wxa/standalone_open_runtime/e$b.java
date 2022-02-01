package com.tencent.luggage.wxa.standalone_open_runtime;

import android.content.Context;
import com.tencent.luggage.wxa.do.d;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/Context;", "<anonymous parameter 1>", "Lcom/tencent/luggage/wxa/standalone_open_runtime/WxaPageView;", "<anonymous parameter 2>", "", "invoke", "com/tencent/luggage/wxa/standalone_open_runtime/WxaPageView$createMenuInfoList$1$6$3"}, k=3, mv={1, 1, 16})
final class e$b
  extends Lambda
  implements Function3<Context, e, String, Boolean>
{
  e$b(d paramd, int paramInt)
  {
    super(3);
  }
  
  public final boolean a(@NotNull Context paramContext, @NotNull e parame, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "<anonymous parameter 0>");
    Intrinsics.checkParameterIsNotNull(parame, "<anonymous parameter 1>");
    Intrinsics.checkParameterIsNotNull(paramString, "<anonymous parameter 2>");
    return this.b != 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.e.b
 * JD-Core Version:    0.7.0.1
 */