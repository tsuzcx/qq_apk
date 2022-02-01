package com.tencent.mm.msgsubscription.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.luggage.wxa.qz.t;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"getAppropriateLargeScreenRequestDialogWidth", "", "context", "Landroid/content/Context;", "dialogMeasuredWidth", "dp2Px", "dp", "isLargeScreenEnv", "", "onPreDrawOnce", "", "Landroid/view/View;", "block", "Lkotlin/Function0;", "postRequestLayout", "wxbiz-msgsubscription-sdk_release"}, k=2, mv={1, 1, 16})
public final class b
{
  private static final void b(@NotNull View paramView)
  {
    t.a((Runnable)new b.b(paramView));
  }
  
  private static final void b(@NotNull View paramView, Function0<Unit> paramFunction0)
  {
    ViewTreeObserver localViewTreeObserver = paramView.getViewTreeObserver();
    Intrinsics.checkExpressionValueIsNotNull(localViewTreeObserver, "this.viewTreeObserver");
    if (!localViewTreeObserver.isAlive()) {
      return;
    }
    paramView.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new b.a(paramView, paramFunction0));
  }
  
  private static final boolean b(@NotNull Context paramContext)
  {
    paramContext = paramContext.getResources();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "this.resources");
    return (paramContext.getConfiguration().screenLayout & 0xF) >= 3;
  }
  
  private static final int c(Context paramContext, int paramInt)
  {
    int i = d(paramContext, 375);
    Resources localResources = paramContext.getResources();
    Intrinsics.checkExpressionValueIsNotNull(localResources, "context.resources");
    int j = Math.max(i, localResources.getDisplayMetrics().widthPixels / 2);
    if (paramInt >= i)
    {
      i = paramInt;
      if (paramInt > j) {
        i = j;
      }
    }
    paramContext = paramContext.getResources();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "context.resources");
    return Math.min(i, paramContext.getDisplayMetrics().widthPixels);
  }
  
  private static final int d(@NotNull Context paramContext, int paramInt)
  {
    paramContext = paramContext.getResources();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "this.resources");
    return MathKt.roundToInt(paramContext.getDisplayMetrics().density * paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.b
 * JD-Core Version:    0.7.0.1
 */