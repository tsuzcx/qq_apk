package com.tencent.luggage.wxa.fm;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.ui.base.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/ui/menu/WxaMenuInfo;", "T", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "Lcom/tencent/mm/plugin/appbrand/menu/MenuInfo;", "menuItemId", "", "desc", "", "iconRes", "isMainGroup", "", "color", "delegate", "Lcom/tencent/luggage/wxa/standalone_open_runtime/ui/menu/WxaBaseMenuDelegate;", "(ILjava/lang/String;IZILcom/tencent/luggage/wxa/standalone_open_runtime/ui/menu/WxaBaseMenuDelegate;)V", "addToMenuCondition", "Lkotlin/Function3;", "Landroid/content/Context;", "Lkotlin/ParameterName;", "name", "context", "pageView", "appId", "getAddToMenuCondition", "()Lkotlin/jvm/functions/Function3;", "setAddToMenuCondition", "(Lkotlin/jvm/functions/Function3;)V", "onClick", "", "getOnClick", "setOnClick", "wantDisable", "Lkotlin/Function2;", "getWantDisable", "()Lkotlin/jvm/functions/Function2;", "setWantDisable", "(Lkotlin/jvm/functions/Function2;)V", "onMenuCreatedFun", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;Lcom/tencent/mm/ui/base/MMMenu;Ljava/lang/String;)V", "performItemClick", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;Ljava/lang/String;)V", "Companion", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class c<T extends u>
  extends com.tencent.luggage.wxa.nu.a
{
  public static final c.a a = new c.a(null);
  @NotNull
  private Function3<? super Context, ? super T, ? super String, Boolean> b;
  @NotNull
  private Function3<? super Context, ? super T, ? super String, Unit> c;
  @NotNull
  private Function2<? super Context, ? super T, Boolean> d;
  private final int e;
  private final String f;
  private final int g;
  private final int h;
  
  public c(int paramInt1, @NotNull String paramString, int paramInt2, boolean paramBoolean, int paramInt3, @NotNull b<T> paramb)
  {
    super(paramInt1, paramBoolean, (com.tencent.luggage.wxa.nv.a)paramb);
    this.e = paramInt1;
    this.f = paramString;
    this.g = paramInt2;
    this.h = paramInt3;
    this.b = ((Function3)c.b.a);
    this.c = ((Function3)c.c.a);
    this.d = ((Function2)new c.d(this));
  }
  
  @NotNull
  public final Function3<Context, T, String, Boolean> a()
  {
    return this.b;
  }
  
  public final void a(@NotNull Context paramContext, @NotNull T paramT, @NotNull g paramg, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramT, "pageView");
    Intrinsics.checkParameterIsNotNull(paramg, "menu");
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    if (((Boolean)this.b.invoke(paramContext, paramT, paramString)).booleanValue()) {
      paramg.add(this.e, (CharSequence)this.f, this.g, this.h, ((Boolean)this.d.invoke(paramContext, paramT)).booleanValue());
    }
  }
  
  public final void a(@NotNull Context paramContext, @NotNull T paramT, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramT, "pageView");
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    if (!d()) {
      this.c.invoke(paramContext, paramT, paramString);
    }
  }
  
  public final void a(@NotNull Function2<? super Context, ? super T, Boolean> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "<set-?>");
    this.d = paramFunction2;
  }
  
  public final void a(@NotNull Function3<? super Context, ? super T, ? super String, Boolean> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction3, "<set-?>");
    this.b = paramFunction3;
  }
  
  @NotNull
  public final Function2<Context, T, Boolean> b()
  {
    return this.d;
  }
  
  public final void b(@NotNull Function3<? super Context, ? super T, ? super String, Unit> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction3, "<set-?>");
    this.c = paramFunction3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fm.c
 * JD-Core Version:    0.7.0.1
 */