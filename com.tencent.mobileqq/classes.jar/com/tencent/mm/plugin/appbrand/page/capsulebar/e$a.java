package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.jx.f.c;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager$PageContext;", "Lcom/tencent/mm/plugin/appbrand/platform/window/FullscreenStatusListener;", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$CapsuleBarInteractionDelegate;", "Landroid/view/View$OnLayoutChangeListener;", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "(Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager;Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "homeButtonOnClickListener", "Landroid/view/View$OnClickListener;", "isAttached", "", "optionButtonOnClickListener", "getPage", "()Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "styleColor", "", "adjustCapsuleBarViewProperties", "", "dispatchCapsuleViewVisibilityChanged", "visibility", "onAttached", "onDetached", "onEnterFullscreen", "onExitFullscreen", "onLayoutChange", "v", "Landroid/view/View;", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "setHomeButtonOnClickListener", "l", "setOptionButtonOnClickListener", "setStyleColor", "color", "luggage-wxa-app_release"}, k=1, mv={1, 1, 16})
final class e$a
  extends com.tencent.luggage.wxa.oq.b
  implements View.OnLayoutChangeListener, b.b
{
  private int b;
  private View.OnClickListener c;
  private View.OnClickListener d;
  private boolean e;
  @NotNull
  private final u f;
  
  public e$a(u paramu)
  {
    this.f = localObject;
    this.b = -1;
    this.f.a((f.c)new e.a.1(this));
    this.f.ah().setCapsuleBarInteractionDelegate((b.b)this);
  }
  
  private final void f()
  {
    d locald = e.a(this.a);
    Object localObject1 = locald.getCapsuleContentAreaView();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "capsuleBarImplView.capsuleContentAreaView");
    Object localObject2;
    if (((View)localObject1).isLaidOut())
    {
      localObject1 = this.f.ah();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "page.actionBar");
      localObject1 = ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject1).getCapsuleView();
      if (localObject1 != null)
      {
        localObject2 = locald.getCapsuleContentAreaView();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "capsuleBarImplView.capsuleContentAreaView");
        ((AppBrandCapsuleBarPlaceHolderView)localObject1).setFixedWidth(((View)localObject2).getMeasuredWidth());
      }
    }
    localObject1 = this.f.ah();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "page.actionBar");
    localObject1 = ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject1).getCapsuleView();
    if (localObject1 != null)
    {
      localObject2 = ((AppBrandCapsuleBarPlaceHolderView)localObject1).getLayoutParams();
      if (localObject2 != null)
      {
        localObject1 = locald.getCapsuleContentAreaView();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "capsuleBarImplView.capsuleContentAreaView");
        localObject2 = e.a(this.a, (ViewGroup.LayoutParams)localObject2, 21);
        ((FrameLayout.LayoutParams)localObject2).width = -2;
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
    }
    localObject1 = locald.getLayoutParams();
    int i;
    if (localObject1 != null)
    {
      i = ((ViewGroup.LayoutParams)localObject1).height;
      localObject2 = this.f.ah();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "page.actionBar");
      if ((i != ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject2).getMeasuredHeight()) && (ViewCompat.isLaidOut((View)this.f.ah())))
      {
        localObject2 = this.f.ah();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "page.actionBar");
        ((ViewGroup.LayoutParams)localObject1).height = ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject2).getMeasuredHeight();
        locald.requestLayout();
      }
    }
    localObject1 = this.f.ah();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "page.actionBar");
    localObject1 = ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject1).getCapsuleView();
    if (localObject1 != null)
    {
      i = ((AppBrandCapsuleBarPlaceHolderView)localObject1).getVisibility();
      if (locald.getVisibility() != i) {
        locald.setVisibility(i);
      }
    }
  }
  
  public void a()
  {
    e.c(this.a);
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
    if (this.e) {
      e.a(this.a).setStyleColor(this.b);
    }
  }
  
  public void a(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.c = paramOnClickListener;
    if (this.e) {
      e.a(this.a).setHomeButtonOnClickListener(this.c);
    }
  }
  
  public final void b()
  {
    this.e = true;
    Object localObject1 = this.f.af();
    if ((localObject1 != null) && (((com.tencent.luggage.wxa.oq.d)localObject1).d() == true)) {
      d();
    } else {
      a();
    }
    localObject1 = this.f.af();
    if (localObject1 != null) {
      ((com.tencent.luggage.wxa.oq.d)localObject1).a((com.tencent.luggage.wxa.oq.b)this);
    }
    localObject1 = e.a(this.a);
    View.OnLayoutChangeListener localOnLayoutChangeListener = (View.OnLayoutChangeListener)this;
    ((d)localObject1).addOnLayoutChangeListener(localOnLayoutChangeListener);
    localObject1 = this.f.ah();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "page.actionBar");
    localObject1 = ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject1).getCapsuleView();
    if (localObject1 != null) {
      localObject1 = ((AppBrandCapsuleBarPlaceHolderView)localObject1).getParent();
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (!(localObject1 instanceof View)) {
      localObject2 = null;
    }
    localObject1 = (View)localObject2;
    if (localObject1 != null) {
      ((View)localObject1).addOnLayoutChangeListener(localOnLayoutChangeListener);
    }
    this.f.ah().addOnLayoutChangeListener(localOnLayoutChangeListener);
    a(this.c);
    b(this.d);
    a(this.b);
    f();
  }
  
  public void b(int paramInt)
  {
    f();
  }
  
  public void b(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.d = paramOnClickListener;
    if (this.e) {
      e.a(this.a).setOptionButtonOnClickListener(this.d);
    }
  }
  
  public final void c()
  {
    this.e = false;
    Object localObject1 = this.f.af();
    if (localObject1 != null) {
      ((com.tencent.luggage.wxa.oq.d)localObject1).b((com.tencent.luggage.wxa.oq.b)this);
    }
    localObject1 = e.a(this.a);
    View.OnLayoutChangeListener localOnLayoutChangeListener = (View.OnLayoutChangeListener)this;
    ((d)localObject1).removeOnLayoutChangeListener(localOnLayoutChangeListener);
    localObject1 = this.f.ah();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "page.actionBar");
    localObject1 = ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject1).getCapsuleView();
    if (localObject1 != null) {
      localObject1 = ((AppBrandCapsuleBarPlaceHolderView)localObject1).getParent();
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (!(localObject1 instanceof View)) {
      localObject2 = null;
    }
    localObject1 = (View)localObject2;
    if (localObject1 != null) {
      ((View)localObject1).removeOnLayoutChangeListener(localOnLayoutChangeListener);
    }
    this.f.ah().removeOnLayoutChangeListener(localOnLayoutChangeListener);
  }
  
  public void d()
  {
    e.b(this.a);
  }
  
  @NotNull
  public final u e()
  {
    return this.f;
  }
  
  public void onLayoutChange(@Nullable View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((this.e) && ((paramInt1 != paramInt5) || (paramInt2 != paramInt6) || (paramInt3 != paramInt7) || (paramInt4 != paramInt8))) {
      f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.e.a
 * JD-Core Version:    0.7.0.1
 */