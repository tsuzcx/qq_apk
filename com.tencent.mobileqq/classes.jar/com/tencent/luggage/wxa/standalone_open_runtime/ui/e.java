package com.tencent.luggage.wxa.standalone_open_runtime.ui;

import android.content.Context;
import android.view.View;
import com.tencent.luggage.wxa.ed.d;
import com.tencent.luggage.wxa.fc.b.d;
import com.tencent.luggage.wxa.fc.b.e;
import com.tencent.luggage.wxa.iu.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/ui/WxaRuntimeContainer;", "Lcom/tencent/luggage/container/AppBrandRuntimeContainerStandaloneImpl;", "ctrl", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandTaskUIController;", "clz", "Ljava/lang/Class;", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "(Lcom/tencent/mm/plugin/appbrand/task/AppBrandTaskUIController;Ljava/lang/Class;)V", "createRuntime", "cfg", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfig;", "provideLoadingPlaceHolderView", "Landroid/view/View;", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class e
  extends com.tencent.luggage.wxa.bi.a
{
  private final com.tencent.luggage.wxa.pa.a b;
  
  public e(@NotNull com.tencent.luggage.wxa.pa.a parama, @NotNull Class<? extends d> paramClass)
  {
    super(parama, paramClass);
    this.b = parama;
  }
  
  @NotNull
  protected d a(@NotNull com.tencent.luggage.wxa.jj.h paramh)
  {
    Intrinsics.checkParameterIsNotNull(paramh, "cfg");
    if ((paramh instanceof b.d)) {
      return (d)new b.e((n)this);
    }
    paramh = super.a(paramh);
    Intrinsics.checkExpressionValueIsNotNull(paramh, "super.createRuntime(cfg)");
    return paramh;
  }
  
  @NotNull
  protected View b()
  {
    Context localContext = this.b.g();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "ctrl.context");
    return (View)new h(localContext, null, false).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.ui.e
 * JD-Core Version:    0.7.0.1
 */