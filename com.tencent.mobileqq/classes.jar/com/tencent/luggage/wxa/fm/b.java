package com.tencent.luggage.wxa.fm;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.ui.base.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/ui/menu/WxaBaseMenuDelegate;", "T", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "Lcom/tencent/mm/plugin/appbrand/menu/base/BaseMenuDelegate;", "id", "", "(I)V", "menuInfo", "Lcom/tencent/luggage/wxa/standalone_open_runtime/ui/menu/WxaMenuInfo;", "getMenuInfo", "()Lcom/tencent/luggage/wxa/standalone_open_runtime/ui/menu/WxaMenuInfo;", "setMenuInfo", "(Lcom/tencent/luggage/wxa/standalone_open_runtime/ui/menu/WxaMenuInfo;)V", "attachTo", "", "context", "Landroid/content/Context;", "pageView", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "appId", "", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;Lcom/tencent/mm/ui/base/MMMenu;Ljava/lang/String;)V", "performItemClick", "Lcom/tencent/mm/plugin/appbrand/menu/MenuInfo;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/menu/MenuInfo;)V", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class b<T extends u>
  extends com.tencent.luggage.wxa.nv.a<T>
{
  @Nullable
  private c<T> a;
  
  public b(int paramInt)
  {
    super(paramInt);
  }
  
  public void a(@NotNull Context paramContext, @NotNull T paramT, @NotNull g paramg, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramT, "pageView");
    Intrinsics.checkParameterIsNotNull(paramg, "menu");
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    c localc = this.a;
    if (localc != null) {
      localc.a(paramContext, paramT, paramg, paramString);
    }
  }
  
  public void a(@NotNull Context paramContext, @NotNull T paramT, @NotNull String paramString, @NotNull com.tencent.luggage.wxa.nu.a parama)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramT, "pageView");
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    Intrinsics.checkParameterIsNotNull(parama, "menuInfo");
    parama = this.a;
    if (parama != null) {
      parama.a(paramContext, paramT, paramString);
    }
  }
  
  public final void a(@Nullable c<T> paramc)
  {
    this.a = paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fm.b
 * JD-Core Version:    0.7.0.1
 */