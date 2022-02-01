package com.tencent.luggage.wxa.es;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import androidx.annotation.Dimension;
import com.tencent.luggage.wxa.jj.n;
import com.tencent.mm.ui.base.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/standalone_ext/menu/MenuDelegate_EnableDebugStandalone;", "Lcom/tencent/mm/plugin/appbrand/menu/base/BaseMenuDelegate;", "Lcom/tencent/luggage/sdk/jsapi/component/AppBrandPageViewLU;", "()V", "attachTo", "", "context", "Landroid/content/Context;", "pageView", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "appId", "", "getMenuItemTitle", "", "performItemClick", "menuInfo", "Lcom/tencent/mm/plugin/appbrand/menu/MenuInfo;", "dp2Pixel", "", "dp", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class a
  extends com.tencent.luggage.wxa.nv.a<com.tencent.luggage.wxa.dq.c>
{
  public a()
  {
    super(com.tencent.luggage.wxa.nu.b.f.ordinal());
  }
  
  private final int a(@NotNull Context paramContext, @Dimension(unit=0) int paramInt)
  {
    paramContext = paramContext.getResources();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "this.resources");
    return Math.round(paramContext.getDisplayMetrics().density * paramInt);
  }
  
  private final CharSequence a(Context paramContext, com.tencent.luggage.wxa.dq.c paramc)
  {
    CharSequence localCharSequence = com.tencent.luggage.wxa.nx.a.a(paramContext, paramc);
    Intrinsics.checkExpressionValueIsNotNull(localCharSequence, "SecondaryMenuDelegate_En…mTitle(context, pageView)");
    paramc = paramc.f();
    Intrinsics.checkExpressionValueIsNotNull(paramc, "pageView.runtime");
    int i = paramc.j().G;
    if (i != 1) {
      if (i != 2) {
        paramc = "";
      }
    }
    for (;;)
    {
      break;
      paramc = paramContext.getResources().getString(2131886757);
      Intrinsics.checkExpressionValueIsNotNull(paramc, "context.resources.getStr…pp_debug_type_previewing)");
      continue;
      paramc = paramContext.getResources().getString(2131886758);
      Intrinsics.checkExpressionValueIsNotNull(paramc, "context.resources.getStr…d_app_debug_type_testing)");
    }
    i = paramContext.getResources().getDimensionPixelSize(2131296964);
    int j = paramContext.getResources().getColor(2131165610);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(localCharSequence);
    localSpannableStringBuilder.setSpan(new AbsoluteSizeSpan(i, false), 0, localCharSequence.length(), 18);
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(j), 0, localCharSequence.length(), 18);
    localSpannableStringBuilder.append((CharSequence)paramc);
    localSpannableStringBuilder.setSpan(new com.tencent.luggage.wxa.pz.b(paramc, a(paramContext, 11), a(paramContext, 11), a(paramContext, 9), -1, Color.parseColor("#42000000"), a(paramContext, 2)), localCharSequence.length(), localSpannableStringBuilder.length(), 18);
    return (CharSequence)localSpannableStringBuilder;
  }
  
  public void a(@NotNull Context paramContext, @NotNull com.tencent.luggage.wxa.dq.c paramc, @Nullable g paramg, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramc, "pageView");
    if (n.a(paramc.f()))
    {
      paramContext = a(paramContext, paramc);
      if (paramg != null) {
        paramg.add(com.tencent.luggage.wxa.nu.b.f.ordinal(), paramContext);
      }
    }
  }
  
  public void a(@NotNull Context paramContext, @NotNull com.tencent.luggage.wxa.dq.c paramc, @Nullable String paramString, @Nullable com.tencent.luggage.wxa.nu.a parama)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramc, "pageView");
    paramContext = (com.tencent.luggage.wxa.iu.b)paramc;
    paramc = paramc.f();
    Intrinsics.checkExpressionValueIsNotNull(paramc, "pageView.runtime");
    com.tencent.luggage.wxa.nx.a.a(paramContext, paramString, paramc.i().b ^ true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.es.a
 * JD-Core Version:    0.7.0.1
 */