package com.tencent.luggage.wxa.fk;

import android.content.Context;
import android.graphics.Rect;
import com.tencent.luggage.wxa.ed.a;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.oq.c.a;
import com.tencent.luggage.wxa.oq.c.c;
import com.tencent.luggage.wxa.oq.e;
import com.tencent.luggage.wxa.oq.f;
import com.tencent.luggage.wxa.oq.j;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/runtime/WxaCenterInsideWindowLayoutManager;", "Lcom/tencent/luggage/sdk/runtime/AppBrandCenterInsideWindowLayoutManager;", "Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "ctx", "Landroid/content/Context;", "orientationHandler", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;", "base", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;)V", "getBase", "()Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "mayDisableInHuaWeiDevices", "", "Ljava/lang/Boolean;", "compareTo", "", "other", "getContext", "getNavigationBar", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid$WindowNavigationBar;", "getSafeAreaInsets", "Landroid/graphics/Rect;", "getStatusBar", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid$WindowStatusBar;", "isInMultiWindowMode", "isLargeScreenWindow", "runInStandaloneTask", "setWindowBackgroundColor", "", "backgroundColor", "runtime", "setWindowDescription", "description", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid$WindowDescription;", "setWindowLayoutParams", "params", "Lcom/tencent/mm/plugin/appbrand/platform/window/WxaWindowLayoutParams;", "shouldInLargeScreenCompatMode", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class b
  extends a<com.tencent.luggage.wxa.do.c>
  implements com.tencent.luggage.wxa.oq.c
{
  private Boolean b;
  @NotNull
  private final com.tencent.luggage.wxa.oq.c c;
  
  public b(@NotNull d paramd, @NotNull Context paramContext, @NotNull e parame, @NotNull com.tencent.luggage.wxa.oq.c paramc)
  {
    super(paramd, paramContext, parame);
    this.c = paramc;
  }
  
  private final boolean j()
  {
    if (this.b == null)
    {
      boolean bool;
      if ((com.tencent.luggage.wxa.re.b.a()) && (com.tencent.luggage.wxa.re.b.b())) {
        bool = true;
      } else {
        bool = false;
      }
      this.b = Boolean.valueOf(bool);
    }
    Boolean localBoolean = this.b;
    if (localBoolean == null) {
      Intrinsics.throwNpe();
    }
    return localBoolean.booleanValue();
  }
  
  public int a(@Nullable com.tencent.luggage.wxa.oq.c paramc)
  {
    if ((paramc instanceof f))
    {
      paramc = (f)paramc;
      if ((Intrinsics.areEqual(paramc.b(), (b)this) ^ true)) {
        return -1;
      }
      return this.c.compareTo(paramc.a());
    }
    return -1;
  }
  
  public void a(int paramInt, @NotNull d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "runtime");
    this.c.a(paramInt, paramd);
  }
  
  public void a(@Nullable j paramj, @Nullable d paramd)
  {
    this.c.a(paramj, paramd);
  }
  
  public boolean f()
  {
    return this.c.f();
  }
  
  public boolean g_()
  {
    return this.c.g_();
  }
  
  @NotNull
  public Context getContext()
  {
    Context localContext = this.c.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "base.context");
    return localContext;
  }
  
  @Nullable
  public Rect getSafeAreaInsets()
  {
    return this.c.getSafeAreaInsets();
  }
  
  @Nullable
  public c.c getStatusBar()
  {
    return this.c.getStatusBar();
  }
  
  public boolean h_()
  {
    if (!a())
    {
      if (c() == null) {
        return false;
      }
      com.tencent.luggage.wxa.do.c localc = c();
      if ((localc != null) && (localc.g() == true)) {
        return false;
      }
      if (j()) {
        return false;
      }
      if (g()) {
        return true;
      }
      return super.h_();
    }
    return false;
  }
  
  public boolean i()
  {
    return this.c.i();
  }
  
  public void setWindowDescription(@Nullable c.a parama)
  {
    this.c.setWindowDescription(parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fk.b
 * JD-Core Version:    0.7.0.1
 */