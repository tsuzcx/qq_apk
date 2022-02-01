package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.luggage.wxa.oi.a;
import com.tencent.luggage.wxa.qz.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.capsulebar.AppBrandCapsuleBarPlaceHolderView;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b.a;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/MPPageViewActionBarExtensionImpl;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewActionBarExtension;", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "isInForeground", "", "applyActionBarSizeProperty", "", "actionBar", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar;", "onActionbarInstalled", "onBackground", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroy", "onForeground", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public class au
  implements a
{
  public static final au.a a = new au.a(null);
  private boolean b;
  private final u c;
  
  public au(@NotNull u paramu)
  {
    this.c = paramu;
  }
  
  private final void b(b paramb)
  {
    Object localObject1 = paramb.getContext();
    Object localObject2 = paramb.getCapsuleView();
    if (localObject2 != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "it");
      if ((((AppBrandCapsuleBarPlaceHolderView)localObject2).getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
      {
        Object localObject3 = ((AppBrandCapsuleBarPlaceHolderView)localObject2).getLayoutParams();
        if (localObject3 != null)
        {
          localObject3 = (ViewGroup.MarginLayoutParams)localObject3;
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "context");
          i = ((Context)localObject1).getResources().getDimensionPixelSize(2131296751);
          if (((ViewGroup.MarginLayoutParams)localObject3).rightMargin != i)
          {
            ((ViewGroup.MarginLayoutParams)localObject3).rightMargin = i;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("[applyActionBarSizeProperty] reset capsule rightMargin:");
            ((StringBuilder)localObject3).append(i);
            o.d("MPPageViewActionBarExtensionImpl", ((StringBuilder)localObject3).toString());
            ((AppBrandCapsuleBarPlaceHolderView)localObject2).requestLayout();
          }
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
      }
      else if ((c.b) || (c.a))
      {
        throw ((Throwable)new RuntimeException("it is not MarginLayoutParams"));
      }
    }
    localObject2 = paramb.getNavResetStyleListener();
    if (localObject2 != null) {
      i = ((b.a)localObject2).b();
    } else {
      i = b.a.d;
    }
    paramb.e();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "context");
    paramb.setNavContainerMinimumWidth(((Context)localObject1).getResources().getDimensionPixelOffset(i));
    int i = ((Context)localObject1).getResources().getDimensionPixelOffset(2131296752);
    paramb.setActionBarHeight(i);
    paramb = new StringBuilder();
    paramb.append("[applyActionBarSizeProperty] ActionBar height=");
    paramb.append(i);
    paramb.append("  dpi = ");
    localObject2 = ((Context)localObject1).getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context.resources");
    paramb.append(((Resources)localObject2).getDisplayMetrics().densityDpi);
    paramb.append(" density=");
    localObject1 = ((Context)localObject1).getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "context.resources");
    paramb.append(((Resources)localObject1).getDisplayMetrics().density);
    o.d("MPPageViewActionBarExtensionImpl", paramb.toString());
  }
  
  public void a(@NotNull Configuration paramConfiguration)
  {
    Intrinsics.checkParameterIsNotNull(paramConfiguration, "newConfig");
    if (!this.b) {
      return;
    }
    paramConfiguration = this.c.ah();
    Intrinsics.checkExpressionValueIsNotNull(paramConfiguration, "page.actionBar");
    b(paramConfiguration);
  }
  
  public void a(@NotNull b paramb)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "actionBar");
    b(paramb);
  }
  
  public void c()
  {
    this.b = true;
    b localb = this.c.ah();
    Intrinsics.checkExpressionValueIsNotNull(localb, "page.actionBar");
    b(localb);
  }
  
  public void d()
  {
    this.b = false;
  }
  
  public void e()
  {
    this.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.au
 * JD-Core Version:    0.7.0.1
 */