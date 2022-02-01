package com.tencent.luggage.wxa.standalone_open_runtime.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.view.View.OnClickListener;
import com.tencent.luggage.wxa.or.n;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUILoadingSplash;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/ui/WxaUILoadingSplash$WxaUILoadingSplashViewInner;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUILoadingSplash;", "ctx", "Landroid/content/Context;", "runtime", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "isGame", "", "(Landroid/content/Context;Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;Z)V", "finishOnClickListener", "Landroid/view/View$OnClickListener;", "resetStatusBarVisibility", "", "config", "Landroid/content/res/Configuration;", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
@SuppressLint({"ViewConstructor"})
public final class h$a
  extends AppBrandUILoadingSplash
{
  private final com.tencent.luggage.wxa.ed.d c;
  private final boolean d;
  
  public h$a(@NotNull Context paramContext, @Nullable com.tencent.luggage.wxa.ed.d paramd, boolean paramBoolean)
  {
    super(paramContext, (com.tencent.luggage.wxa.iu.d)paramd);
    this.c = paramd;
    this.d = paramBoolean;
  }
  
  @NotNull
  protected View.OnClickListener a()
  {
    return (View.OnClickListener)new h.a.a(this, super.a());
  }
  
  protected void a(@NotNull Configuration paramConfiguration)
  {
    Intrinsics.checkParameterIsNotNull(paramConfiguration, "config");
    if (this.d)
    {
      Object localObject = this.c;
      if (localObject != null) {
        localObject = ((com.tencent.luggage.wxa.ed.d)localObject).W();
      } else {
        localObject = null;
      }
      if ((localObject instanceof n)) {
        return;
      }
    }
    super.a(paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.ui.h.a
 * JD-Core Version:    0.7.0.1
 */