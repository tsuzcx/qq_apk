package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import com.tencent.luggage.wxa.oi.i;
import com.tencent.luggage.wxa.ok.a;
import com.tencent.luggage.wxa.ok.c.b;
import com.tencent.luggage.wxa.qz.t;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/MPPageViewStatusBarExtensionImpl;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewStatusBarExtension;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewExtensionLifecycle;", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "H", "Lcom/tencent/mm/plugin/appbrand/page/statusbar/IPageStatusBarHelper;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;Lcom/tencent/mm/plugin/appbrand/page/statusbar/IPageStatusBarHelper;)V", "hideStatusBar", "", "isStatusBarHidden", "", "onActionbarInstalled", "actionBar", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar;", "onBackground", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroy", "onForeground", "showStatusBar", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public class ay
  implements com.tencent.luggage.wxa.oi.b, i
{
  private final u a;
  private final com.tencent.luggage.wxa.ok.c b;
  
  public ay(@NotNull u paramu)
  {
    this(paramu, localc);
  }
  
  public ay(@NotNull u paramu, @NotNull com.tencent.luggage.wxa.ok.c paramc)
  {
    this.a = paramu;
    this.b = paramc;
  }
  
  public void a()
  {
    Object localObject = (c)this.a;
    if (t.a())
    {
      a(this).a();
      return;
    }
    localObject = ((c)localObject).getContentView();
    if (localObject != null) {
      ((View)localObject).post((Runnable)new ay.c(this));
    }
  }
  
  public void a(@NotNull Configuration paramConfiguration)
  {
    Intrinsics.checkParameterIsNotNull(paramConfiguration, "newConfig");
    com.tencent.luggage.wxa.ok.c localc = this.b;
    Object localObject = localc;
    if (!(localc instanceof a)) {
      localObject = null;
    }
    localObject = (a)localObject;
    if (localObject != null) {
      this.a.b((Runnable)new ay.b((a)localObject, this, paramConfiguration));
    }
  }
  
  public void a(@NotNull com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "actionBar");
  }
  
  public void b()
  {
    Object localObject = (c)this.a;
    if (t.a())
    {
      a(this).b();
      return;
    }
    localObject = ((c)localObject).getContentView();
    if (localObject != null) {
      ((View)localObject).post((Runnable)new ay.a(this));
    }
  }
  
  public void c()
  {
    this.b.c();
    Object localObject2 = this.b;
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof a)) {
      localObject1 = null;
    }
    localObject1 = (a)localObject1;
    if (localObject1 != null)
    {
      boolean bool = this.a.y().h_();
      localObject2 = this.a.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "page.context");
      localObject2 = ((Context)localObject2).getResources();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "page.context.resources");
      ((a)localObject1).a(bool, ((Resources)localObject2).getConfiguration().orientation);
    }
  }
  
  public void d()
  {
    this.b.d();
  }
  
  public void e() {}
  
  public boolean f()
  {
    return this.b.e() == c.b.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ay
 * JD-Core Version:    0.7.0.1
 */