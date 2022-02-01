package com.tencent.luggage.wxa.fm;

import android.content.Context;
import com.tencent.luggage.wxa.em.c;
import com.tencent.luggage.wxa.fk.f;
import com.tencent.luggage.wxa.ou.m;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.standalone_open_runtime.e;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.l;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/ui/menu/MenuDelegateGrowthCare;", "Lcom/tencent/mm/plugin/appbrand/menu/base/BaseMenuDelegate;", "Lcom/tencent/luggage/wxa/standalone_open_runtime/WxaPageView;", "()V", "attachTo", "", "context", "Landroid/content/Context;", "pageView", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "appId", "", "performItemClick", "menuInfo", "Lcom/tencent/mm/plugin/appbrand/menu/MenuInfo;", "Companion", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class a
  extends com.tencent.luggage.wxa.nv.a<e>
{
  public static final a.a a = new a.a(null);
  
  public a()
  {
    super(com.tencent.luggage.wxa.nu.b.z.ordinal());
  }
  
  public void a(@NotNull Context paramContext, @NotNull e parame, @NotNull g paramg, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(parame, "pageView");
    Intrinsics.checkParameterIsNotNull(paramg, "menu");
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    parame = (f)parame.b(f.class);
    if ((parame != null) && (parame.a() == true))
    {
      int i = a();
      paramContext = (CharSequence)l.d(paramContext, 2131918162);
      parame = r.a();
      Intrinsics.checkExpressionValueIsNotNull(parame, "MMApplicationContext.getContext()");
      paramg.add(i, paramContext, 2130853704, l.c(parame, 2131165265), false);
    }
  }
  
  public void a(@NotNull Context paramContext, @NotNull e parame, @NotNull String paramString, @NotNull com.tencent.luggage.wxa.nu.a parama)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(parame, "pageView");
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    Intrinsics.checkParameterIsNotNull(parama, "menuInfo");
    m.a(m.a, (c)parame, 32, null, 0L, 0, 0, 60, null);
    com.tencent.luggage.wxa.standalone_open_runtime.ui.b.a.a(paramString, paramContext, "sdk_openGrowthCare", (Function0)a.b.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fm.a
 * JD-Core Version:    0.7.0.1
 */