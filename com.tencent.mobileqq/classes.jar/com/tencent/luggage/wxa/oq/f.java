package com.tencent.luggage.wxa.oq;

import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/platform/window/WindowViewImplProxy;", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "base", "windowViewImplScope", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowViewImplScope;", "(Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;Lcom/tencent/mm/plugin/appbrand/platform/window/WindowViewImplScope;)V", "getBase", "()Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "getWindowViewImplScope", "()Lcom/tencent/mm/plugin/appbrand/platform/window/WindowViewImplScope;", "compareTo", "", "other", "createFullscreenHandler", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler;", "provider", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler$FullScreenViewContainerProvider;", "forceLightMode", "", "getContext", "Landroid/content/Context;", "getNavigationBar", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid$WindowNavigationBar;", "getOrientationHandler", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;", "getSafeAreaInsets", "Landroid/graphics/Rect;", "getScale", "", "getStatusBar", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid$WindowStatusBar;", "getVDisplayMetrics", "Landroid/util/DisplayMetrics;", "isInMultiWindowMode", "isLargeScreenWindow", "runInStandaloneTask", "setSoftOrientation", "", "name", "", "setWindowBackgroundColor", "backgroundColor", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "setWindowDescription", "description", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid$WindowDescription;", "setWindowLayoutParams", "params", "Lcom/tencent/mm/plugin/appbrand/platform/window/WxaWindowLayoutParams;", "shouldInLargeScreenCompatMode", "luggage-wxa-app_release"}, k=1, mv={1, 1, 16})
public class f
  implements c
{
  @NotNull
  private final c a;
  @NotNull
  private final g b;
  
  public int a(@NotNull c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "other");
    if ((paramc instanceof f))
    {
      paramc = (f)paramc;
      if ((Intrinsics.areEqual(paramc.b, this.b) ^ true)) {
        return -1;
      }
      return this.a.compareTo(paramc.a);
    }
    return -1;
  }
  
  @NotNull
  public final c a()
  {
    return this.a;
  }
  
  @NotNull
  public d a(@Nullable d.b paramb)
  {
    d locald = this.b.a(paramb);
    if (locald != null) {
      return locald;
    }
    paramb = this.a.a(paramb);
    Intrinsics.checkExpressionValueIsNotNull(paramb, "base.createFullscreenHandler(provider)");
    return paramb;
  }
  
  public void a(int paramInt, @NotNull com.tencent.luggage.wxa.iu.d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "runtime");
    this.a.a(paramInt, paramd);
  }
  
  public void a(@NotNull j paramj, @NotNull com.tencent.luggage.wxa.iu.d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramj, "params");
    Intrinsics.checkParameterIsNotNull(paramd, "runtime");
    this.a.a(paramj, paramd);
  }
  
  @NotNull
  public final g b()
  {
    return this.b;
  }
  
  public boolean f()
  {
    return this.b.f();
  }
  
  public boolean g_()
  {
    return this.a.g_();
  }
  
  @NotNull
  public Context getContext()
  {
    Context localContext = this.a.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "base.context");
    return localContext;
  }
  
  @NotNull
  public e getOrientationHandler()
  {
    e locale = this.b.getOrientationHandler();
    if (locale != null) {
      return locale;
    }
    locale = this.a.getOrientationHandler();
    Intrinsics.checkExpressionValueIsNotNull(locale, "base.orientationHandler");
    return locale;
  }
  
  @Nullable
  public Rect getSafeAreaInsets()
  {
    return this.a.getSafeAreaInsets();
  }
  
  public float getScale()
  {
    return this.b.getScale();
  }
  
  @Nullable
  public c.c getStatusBar()
  {
    return this.b.getStatusBar();
  }
  
  @NotNull
  public DisplayMetrics getVDisplayMetrics()
  {
    DisplayMetrics localDisplayMetrics = this.b.getVDisplayMetrics();
    Intrinsics.checkExpressionValueIsNotNull(localDisplayMetrics, "windowViewImplScope.vDisplayMetrics");
    return localDisplayMetrics;
  }
  
  public boolean h_()
  {
    return this.b.h_();
  }
  
  public boolean i()
  {
    return this.a.i();
  }
  
  public boolean i_()
  {
    return this.b.i_();
  }
  
  public void setSoftOrientation(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    this.b.setSoftOrientation(paramString);
  }
  
  public void setWindowDescription(@NotNull c.a parama)
  {
    Intrinsics.checkParameterIsNotNull(parama, "description");
    this.a.setWindowDescription(parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.oq.f
 * JD-Core Version:    0.7.0.1
 */