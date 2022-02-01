package com.tencent.luggage.wxa.standalone_open_runtime;

import android.content.Context;
import com.tencent.luggage.wxa.do.d;
import com.tencent.luggage.wxa.nu.a;
import com.tencent.luggage.wxa.nu.b;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/Context;", "pageview", "Lcom/tencent/luggage/wxa/standalone_open_runtime/WxaPageView;", "invoke", "com/tencent/luggage/wxa/standalone_open_runtime/WxaPageView$createMenuInfoList$1$6$2"}, k=3, mv={1, 1, 16})
final class e$a
  extends Lambda
  implements Function2<Context, e, Boolean>
{
  e$a(d paramd, int paramInt)
  {
    super(2);
  }
  
  public final boolean a(@NotNull Context paramContext, @NotNull e parame)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "<anonymous parameter 0>");
    Intrinsics.checkParameterIsNotNull(parame, "pageview");
    int i = this.a.c();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i == 0)
    {
      paramContext = parame.d(b.d.ordinal());
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "pageview.getMenuItem(Men…emId.ShareAppMsg.ordinal)");
      if (!paramContext.d())
      {
        bool1 = bool2;
        if (this.b != 2) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.e.a
 * JD-Core Version:    0.7.0.1
 */