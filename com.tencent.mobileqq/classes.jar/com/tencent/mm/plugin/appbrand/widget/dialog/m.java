package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.luggage.wxa.oq.c;
import com.tencent.luggage.wxa.pd.w;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/RequestDialogRotationHelper;", "", "()V", "applyStyleByRotation", "", "context", "Landroid/content/Context;", "rootView", "Landroid/view/View;", "buttonGroup", "rotation", "", "window", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "getAppropriateLargeScreenRequestDialogWidth", "dialogMeasuredWidthHeight", "", "dm", "Landroid/util/DisplayMetrics;", "dp2Px", "dp", "isLargeScreenEnv", "", "onPreDrawOnce", "block", "Lkotlin/Function0;", "postRequestLayout", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class m
{
  public static final m a = new m();
  
  private final int a(@NotNull Context paramContext, int paramInt)
  {
    paramContext = paramContext.getResources();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "this.resources");
    return MathKt.roundToInt(paramContext.getDisplayMetrics().density * paramInt);
  }
  
  @JvmStatic
  public static final void a(@NotNull Context paramContext, @NotNull int[] paramArrayOfInt, @NotNull DisplayMetrics paramDisplayMetrics)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "dialogMeasuredWidthHeight");
    Intrinsics.checkParameterIsNotNull(paramDisplayMetrics, "dm");
    if (!w.a(paramContext))
    {
      Resources localResources = paramContext.getResources();
      Intrinsics.checkExpressionValueIsNotNull(localResources, "context.resources");
      if (localResources.getConfiguration().orientation != 2) {}
    }
    else
    {
      int m = a.a(paramContext, 19);
      int i = a.a(paramContext, 26);
      paramArrayOfInt[0] = Math.max(paramContext.getResources().getDimensionPixelSize(2131296908), paramArrayOfInt[0]);
      int j = paramArrayOfInt[0];
      int k = paramDisplayMetrics.widthPixels;
      m *= 2;
      if (j > k - m) {
        paramArrayOfInt[0] = (paramDisplayMetrics.widthPixels - m);
      }
      j = paramArrayOfInt[1];
      k = paramDisplayMetrics.heightPixels;
      i *= 2;
      if (j > k - i) {
        paramArrayOfInt[1] = (paramDisplayMetrics.heightPixels - i);
      }
    }
  }
  
  private final boolean a(@NotNull Context paramContext)
  {
    return w.a(paramContext);
  }
  
  public final void a(@NotNull Context paramContext, @NotNull View paramView1, @Nullable View paramView2, int paramInt, @NotNull c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramView1, "rootView");
    Intrinsics.checkParameterIsNotNull(paramc, "window");
    ViewParent localViewParent = null;
    Object localObject = null;
    ViewGroup.LayoutParams localLayoutParams;
    if (paramView2 != null) {
      localLayoutParams = paramView2.getLayoutParams();
    } else {
      localLayoutParams = null;
    }
    if ((paramInt != 1) && (paramInt != 3))
    {
      if (paramView2 != null) {
        localViewParent = paramView2.getParent();
      } else {
        localViewParent = null;
      }
      if ((localViewParent instanceof RelativeLayout)) {
        if (localLayoutParams != null) {
          ((RelativeLayout.LayoutParams)localLayoutParams).bottomMargin = paramContext.getResources().getDimensionPixelSize(2131296906);
        } else {
          throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        }
      }
      if ((!paramc.h_()) && (a(paramContext)))
      {
        paramView1 = localObject;
        if (paramView2 != null) {
          paramView1 = paramView2.getParent();
        }
        if ((paramView1 instanceof RelativeLayout))
        {
          if (localLayoutParams != null)
          {
            ((RelativeLayout.LayoutParams)localLayoutParams).bottomMargin = paramContext.getResources().getDimensionPixelSize(2131296905);
            return;
          }
          throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        }
      }
      else
      {
        paramContext = paramView1.getLayoutParams();
        paramContext.width = -1;
        paramView1.setLayoutParams(paramContext);
      }
    }
    else
    {
      if (paramView2 != null) {
        localViewParent = paramView2.getParent();
      }
      if ((localViewParent instanceof RelativeLayout)) {
        if (localLayoutParams != null) {
          ((RelativeLayout.LayoutParams)localLayoutParams).bottomMargin = paramContext.getResources().getDimensionPixelSize(2131296905);
        } else {
          throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        }
      }
      if (!paramc.h_())
      {
        paramView2 = paramView1.getLayoutParams();
        paramView2.width = paramContext.getResources().getDimensionPixelSize(2131296908);
        paramView1.setLayoutParams(paramView2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.m
 * JD-Core Version:    0.7.0.1
 */