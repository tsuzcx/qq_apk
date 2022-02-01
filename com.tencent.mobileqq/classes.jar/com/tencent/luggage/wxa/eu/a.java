package com.tencent.luggage.wxa.eu;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ProgressBar;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.ed.d;
import com.tencent.luggage.wxa.em.c;
import com.tencent.luggage.wxa.jx.f.g;
import com.tencent.mm.plugin.appbrand.page.f;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/standalone_ext/page/MPEntryPageFastLoadHelper;", "", "()V", "TAG", "", "createFastLoadPrompt", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "tryFastLoadEntryPage", "", "Lcom/tencent/luggage/standalone_ext/PageView;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class a
{
  public static final a a = new a();
  
  private final View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new ProgressBar((Context)new ContextThemeWrapper(paramViewGroup.getContext(), 2131953184));
    paramViewGroup.setIndeterminateDrawable(ContextCompat.getDrawable(paramViewGroup.getContext(), 2130842550));
    Object localObject = paramViewGroup.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
    localObject = ((Context)localObject).getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context.resources");
    int i = MathKt.roundToInt(((Resources)localObject).getDisplayMetrics().density * 36);
    paramViewGroup.setLayoutParams(new ViewGroup.LayoutParams(i, i));
    return (View)paramViewGroup;
  }
  
  @JvmStatic
  public static final void a(@NotNull c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "$this$tryFastLoadEntryPage");
    if (paramc.f() == null) {
      return;
    }
    Object localObject = paramc.f();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "this.runtime");
    if (((d)localObject).au()) {
      return;
    }
    localObject = paramc.f();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "this.runtime");
    if (((d)localObject).t()) {
      return;
    }
    if (!paramc.aL()) {
      return;
    }
    localObject = paramc.ah();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "this.actionBar");
    int i;
    if ((((b)localObject).h()) && (!(paramc.T() instanceof f))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0) {
      return;
    }
    localObject = new Boolean[1];
    localObject[0] = Boolean.valueOf(false);
    View[] arrayOfView = new View[1];
    Long[] arrayOfLong = new Long[1];
    arrayOfLong[0] = Long.valueOf(0L);
    paramc.a((f.g)new a.a(paramc, (Boolean[])localObject, arrayOfLong, arrayOfView));
    View localView = paramc.getContentView();
    if (localView != null) {
      localView.post((Runnable)new a.b(paramc, (Boolean[])localObject, arrayOfView, arrayOfLong));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.eu.a
 * JD-Core Version:    0.7.0.1
 */