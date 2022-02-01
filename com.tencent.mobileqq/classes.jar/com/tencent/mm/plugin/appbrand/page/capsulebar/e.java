package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.luggage.wxa.ef.i;
import com.tencent.mm.plugin.appbrand.page.be;
import com.tencent.mm.plugin.appbrand.page.bf;
import com.tencent.mm.plugin.appbrand.page.bf.a;
import com.tencent.mm.plugin.appbrand.page.bg;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager;", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "blinkHelperExport", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarBlinkHelper;", "getBlinkHelperExport$luggage_wxa_app_release", "()Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarBlinkHelper;", "setBlinkHelperExport$luggage_wxa_app_release", "(Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarBlinkHelper;)V", "blinkWrapper", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/CapsuleBarBlinkWrapper;", "capsuleBarContainerLayout", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarContainerLayout;", "capsuleBarView", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarImplView;", "currentActivePage", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "pageContexts", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager$PageContextMapImpl;", "applyFixedWidthToPlaceHolderView", "", "placeHolderView", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarPlaceHolderView;", "destroy", "getOptionButton", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandOptionButton;", "installCapsuleBar", "onEnterFullscreen", "onExitFullscreen", "onPageDestroyed", "page", "onPageSwitchedIn", "type", "Lcom/tencent/mm/plugin/appbrand/page/PageOpenType;", "registerPage", "resetCapsuleBarContext", "newBase", "Landroid/content/Context;", "setCapsuleHomeButtonLongClickListener", "listener", "Landroid/view/View$OnLongClickListener;", "toFrameLayout_LayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "Landroid/view/ViewGroup$LayoutParams;", "gravity", "", "PageContext", "PageContextMapImpl", "luggage-wxa-app_release"}, k=1, mv={1, 1, 16})
public final class e
{
  @NotNull
  public a a;
  private c b;
  private d c;
  private h d;
  private final e.b e;
  private u f;
  private final com.tencent.luggage.wxa.iu.d g;
  
  public e(@NotNull com.tencent.luggage.wxa.iu.d paramd)
  {
    this.g = paramd;
    this.e = new e.b(this);
  }
  
  private final FrameLayout.LayoutParams a(@NotNull ViewGroup.LayoutParams paramLayoutParams, int paramInt)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams))
    {
      if (paramLayoutParams != null) {
        paramLayoutParams = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
      } else {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
    }
    else
    {
      if (paramLayoutParams == null) {
        break label56;
      }
      paramLayoutParams = new FrameLayout.LayoutParams(paramLayoutParams);
    }
    paramLayoutParams.gravity = paramInt;
    return paramLayoutParams;
    label56:
    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
  }
  
  private final void b(u paramu)
  {
    paramu = this.e.c(paramu);
    if (paramu != null) {
      paramu.c();
    }
  }
  
  private final void c()
  {
    Object localObject = this.d;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("blinkWrapper");
    }
    ((h)localObject).e();
    localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("capsuleBarContainerLayout");
    }
    ((c)localObject).setVisibility(4);
  }
  
  private final void d()
  {
    Object localObject = this.d;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("blinkWrapper");
    }
    ((h)localObject).d();
    localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("capsuleBarContainerLayout");
    }
    ((c)localObject).setVisibility(0);
  }
  
  public final void a()
  {
    Object localObject1 = this.g.a(be.a);
    if (localObject1 == null) {
      localObject1 = (bf)new bf.a();
    }
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "runtime.getDecorWidgetFa…tFactory.DefaultFactory()");
    Object localObject2 = this.g.ag();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "runtime.appContext");
    Object localObject3 = ((bf)localObject1).a((Context)localObject2, d.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "widgetFactory.onCreateWi…eBarImplView::class.java)");
    this.c = ((d)localObject3);
    localObject3 = this.g;
    Object localObject4 = this.c;
    if (localObject4 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("capsuleBarView");
    }
    localObject4 = ((d)localObject4).getOptionBtn();
    Intrinsics.checkExpressionValueIsNotNull(localObject4, "capsuleBarView.optionBtn");
    localObject4 = new h((AppBrandOptionButton)localObject4);
    this.d = ((h)localObject4);
    i.a.a(this.g, (Function1)new e.c(this));
    localObject3 = a.a.a((com.tencent.luggage.wxa.iu.d)localObject3, (i.a)localObject4);
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "AppBrandCapsuleBarBlinkH…}\n            }\n        )");
    this.a = ((a)localObject3);
    localObject1 = ((bf)localObject1).a((Context)localObject2, c.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "widgetFactory.onCreateWi…tainerLayout::class.java)");
    this.b = ((c)localObject1);
    localObject1 = this.b;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("capsuleBarContainerLayout");
    }
    localObject2 = this.c;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("capsuleBarView");
    }
    ((c)localObject1).addView((View)localObject2);
    localObject1 = this.g.aU();
    localObject2 = this.b;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("capsuleBarContainerLayout");
    }
    ((com.tencent.mm.plugin.appbrand.page.e)localObject1).a((c)localObject2);
  }
  
  public final void a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "newBase");
    c localc = this.b;
    if (localc == null) {
      Intrinsics.throwUninitializedPropertyAccessException("capsuleBarContainerLayout");
    }
    localc.a(paramContext);
  }
  
  public final void a(@Nullable AppBrandCapsuleBarPlaceHolderView paramAppBrandCapsuleBarPlaceHolderView)
  {
    if (paramAppBrandCapsuleBarPlaceHolderView != null)
    {
      Object localObject = this.c;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("capsuleBarView");
      }
      localObject = ((d)localObject).getCapsuleContentAreaView();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "this.capsuleBarView.capsuleContentAreaView");
      paramAppBrandCapsuleBarPlaceHolderView.setFixedWidth(((View)localObject).getMeasuredWidth());
    }
  }
  
  public final void a(@NotNull u paramu)
  {
    Intrinsics.checkParameterIsNotNull(paramu, "page");
    this.e.a(paramu, new e.a(this, paramu));
  }
  
  public final void a(@NotNull u paramu, @NotNull bg parambg)
  {
    Intrinsics.checkParameterIsNotNull(paramu, "page");
    Intrinsics.checkParameterIsNotNull(parambg, "type");
    parambg = this.f;
    if (parambg != null)
    {
      e.b localb = this.e;
      if (parambg == null) {
        Intrinsics.throwNpe();
      }
      parambg = localb.a(parambg);
      if (parambg != null) {
        parambg.c();
      }
    }
    this.f = paramu;
    this.e.b(paramu).b();
  }
  
  public final void b()
  {
    Object localObject = (e)this;
    if (((e)localObject).c != null)
    {
      d locald = this.c;
      if (locald == null) {
        Intrinsics.throwUninitializedPropertyAccessException("capsuleBarView");
      }
      locald.a();
    }
    if (((e)localObject).d != null)
    {
      localObject = this.d;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("blinkWrapper");
      }
      ((h)localObject).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.e
 * JD-Core Version:    0.7.0.1
 */