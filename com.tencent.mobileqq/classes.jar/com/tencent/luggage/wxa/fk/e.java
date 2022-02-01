package com.tencent.luggage.wxa.fk;

import android.content.Context;
import android.content.res.Configuration;
import com.tencent.luggage.wxa.cx.t;
import com.tencent.luggage.wxa.cx.t.c;
import com.tencent.luggage.wxa.em.g;
import com.tencent.luggage.wxa.fl.a.b;
import com.tencent.luggage.wxa.fq.f;
import com.tencent.luggage.wxa.iu.d.b;
import com.tencent.luggage.wxa.iu.n;
import com.tencent.luggage.wxa.standalone_open_runtime.d.a;
import com.tencent.mm.plugin.appbrand.appcache.p;
import com.tencent.mm.plugin.appbrand.page.bf;
import com.tencent.mm.plugin.appbrand.page.o;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/runtime/WxaRuntime;", "Lcom/tencent/luggage/standalone_ext/Runtime;", "container", "Lcom/tencent/mm/plugin/appbrand/IRuntimeContainerHandler;", "(Lcom/tencent/mm/plugin/appbrand/IRuntimeContainerHandler;)V", "apiReporter", "Lcom/tencent/luggage/wxa/standalone_open_runtime/jsapi/report/AppBrandJsApiReporter;", "getApiReporter", "()Lcom/tencent/luggage/wxa/standalone_open_runtime/jsapi/report/AppBrandJsApiReporter;", "boostPrepareProcess", "Lcom/tencent/luggage/standalone_ext/WxaRuntimeBoostPrepareProcess;", "Lcom/tencent/luggage/wxa/standalone_open_runtime/service/WxaAppService;", "Lcom/tencent/luggage/wxa/standalone_open_runtime/WxaPageView;", "windowLayoutManager", "Lcom/tencent/luggage/sdk/runtime/IAppBrandWindowLayoutManager;", "Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;", "wxaDecorWidgetFactory", "Lcom/tencent/mm/plugin/appbrand/page/PageDecorWidgetFactory;", "createLoadingSplash", "Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplash;", "createPageContainer", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageContainer;", "createService", "getDecorWidgetFactory", "getWindowAndroid", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "onBackPressed", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "onDestroy", "onInitBeforeComponentsInstalled", "onLaunch", "onPrepareDone", "onReady", "reload", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfig;", "reason", "", "startPrepareProcesses", "updateConfig", "", "config", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public class e
  extends com.tencent.luggage.wxa.em.d
{
  private com.tencent.luggage.wxa.ed.e<com.tencent.luggage.wxa.do.c> c;
  @NotNull
  private final com.tencent.luggage.wxa.ff.a d;
  private g<com.tencent.luggage.wxa.standalone_open_runtime.service.a, com.tencent.luggage.wxa.standalone_open_runtime.e> e;
  private bf f;
  
  public e(@NotNull n paramn)
  {
    super(paramn);
    if (f.a.e()) {
      com.tencent.luggage.wxa.fl.a.b.a((com.tencent.luggage.wxa.fl.a)new e.1(this));
    }
    com.tencent.luggage.wxa.fj.e.a.a();
    p.a.a();
    this.d = new com.tencent.luggage.wxa.ff.a();
  }
  
  @NotNull
  protected com.tencent.mm.plugin.appbrand.ui.d H()
  {
    Object localObject = ah();
    if (localObject != null)
    {
      localObject = (Context)localObject;
    }
    else
    {
      localObject = ag();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "appContext");
    }
    return (com.tencent.mm.plugin.appbrand.ui.d)new com.tencent.luggage.wxa.standalone_open_runtime.ui.h((Context)localObject, (com.tencent.luggage.wxa.ed.d)this, t());
  }
  
  @NotNull
  protected o J()
  {
    d.a locala;
    Object localObject1;
    if (t())
    {
      locala = com.tencent.luggage.wxa.standalone_open_runtime.d.b;
      localObject1 = ah();
      if (localObject1 != null)
      {
        localObject1 = (Context)localObject1;
      }
      else
      {
        localObject1 = ag();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "appContext");
      }
      localObject1 = locala.a((Context)localObject1, (com.tencent.luggage.wxa.ed.d)this);
    }
    else
    {
      locala = com.tencent.luggage.wxa.standalone_open_runtime.d.b;
      localObject1 = ah();
      if (localObject1 != null)
      {
        localObject1 = (Context)localObject1;
      }
      else
      {
        localObject1 = ag();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "appContext");
      }
      com.tencent.luggage.wxa.ed.d locald = (com.tencent.luggage.wxa.ed.d)this;
      Object localObject2 = this.e;
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      localObject2 = ((g)localObject2).e();
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      localObject1 = locala.a((Context)localObject1, locald, (com.tencent.luggage.wxa.standalone_open_runtime.e)localObject2);
    }
    ((com.tencent.luggage.wxa.standalone_open_runtime.d)localObject1).setDecorWidgetFactory(U());
    return (o)localObject1;
  }
  
  protected void L()
  {
    super.L();
    String str = aa();
    Intrinsics.checkExpressionValueIsNotNull(str, "appId");
    boolean bool = t();
    if (t()) {
      localObject = c.a;
    } else {
      localObject = a.a;
    }
    Object localObject = new g(str, bool, (com.tencent.luggage.wxa.en.a)localObject, (Function0)new e.a(this), (Function0)new e.b(this));
    this.e = ((g)localObject);
    a((d.b)localObject);
    a((d.b)new e.c(this));
  }
  
  protected void O()
  {
    com.tencent.luggage.wxa.ed.e locale = this.c;
    if (locale != null)
    {
      com.tencent.luggage.wxa.jj.a locala = aj();
      Intrinsics.checkExpressionValueIsNotNull(locala, "appConfig");
      locale.a(locala);
    }
    super.O();
  }
  
  @NotNull
  protected com.tencent.luggage.wxa.standalone_open_runtime.service.a R()
  {
    Object localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    localObject = ((g)localObject).d();
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    return (com.tencent.luggage.wxa.standalone_open_runtime.service.a)localObject;
  }
  
  @NotNull
  public final com.tencent.luggage.wxa.ff.a S()
  {
    return this.d;
  }
  
  protected void T()
  {
    Object localObject2 = (com.tencent.luggage.wxa.iu.d)this;
    Object localObject1 = ah();
    if (localObject1 != null)
    {
      localObject1 = (Context)localObject1;
    }
    else
    {
      localObject1 = ag();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "appContext");
    }
    Object localObject3 = super.W();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "super.getWindowAndroid()");
    localObject3 = ((com.tencent.luggage.wxa.oq.c)localObject3).getOrientationHandler();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "super.getWindowAndroid().orientationHandler");
    com.tencent.luggage.wxa.oq.c localc = super.W();
    Intrinsics.checkExpressionValueIsNotNull(localc, "super.getWindowAndroid()");
    this.c = ((com.tencent.luggage.wxa.ed.e)new b((com.tencent.luggage.wxa.iu.d)localObject2, (Context)localObject1, (com.tencent.luggage.wxa.oq.e)localObject3, localc));
    localObject1 = this.c;
    if (localObject1 != null)
    {
      localObject2 = G();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "initConfig");
      ((com.tencent.luggage.wxa.ed.e)localObject1).a((com.tencent.luggage.wxa.do.c)localObject2);
    }
    super.T();
  }
  
  @NotNull
  public bf U()
  {
    bf localbf = this.f;
    if (localbf == null) {
      Intrinsics.throwUninitializedPropertyAccessException("wxaDecorWidgetFactory");
    }
    return localbf;
  }
  
  protected void V()
  {
    super.V();
    if (av())
    {
      t localt = t.a;
      Object localObject = G();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "initConfig");
      localObject = ((com.tencent.luggage.wxa.eo.a)localObject).i();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "initConfig.wxaLaunchInstanceId");
      localt.a((String)localObject, t.c.e);
    }
  }
  
  @NotNull
  public com.tencent.luggage.wxa.oq.c W()
  {
    if (af() == null)
    {
      localObject = super.W();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "super.getWindowAndroid()");
      return localObject;
    }
    Object localObject = (b)this.c;
    if ((localObject != null) && (((b)localObject).h_() == true))
    {
      localObject = this.c;
      if (localObject != null) {
        return (com.tencent.luggage.wxa.oq.c)localObject;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.luggage.wxa.standalone_open_runtime.runtime.WxaCenterInsideWindowLayoutManager");
    }
    localObject = super.W();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "super.getWindowAndroid()");
    return localObject;
  }
  
  protected void a(@Nullable Configuration paramConfiguration)
  {
    if (paramConfiguration != null)
    {
      com.tencent.luggage.wxa.ed.e locale = this.c;
      if (locale != null) {
        locale.a(paramConfiguration);
      }
    }
    super.a(paramConfiguration);
  }
  
  protected void a(@Nullable com.tencent.luggage.wxa.jj.h paramh, @Nullable String paramString)
  {
    if (com.tencent.luggage.wxa.fa.b.a.c() <= 1) {
      com.tencent.luggage.wxa.en.e.b();
    }
    super.a(paramh, paramString);
  }
  
  protected boolean a(@Nullable com.tencent.luggage.wxa.jj.h paramh)
  {
    Object localObject;
    if (paramh != null)
    {
      localObject = this.c;
      if (localObject != null) {
        ((com.tencent.luggage.wxa.ed.e)localObject).b((com.tencent.luggage.wxa.do.c)paramh);
      }
    }
    boolean bool = super.a(paramh);
    if ((bool) && (!aG()) && (aw()))
    {
      if (paramh != null)
      {
        paramh = (com.tencent.luggage.wxa.do.c)paramh;
        localObject = com.tencent.luggage.wxa.ft.b.a;
        String str = paramh.i();
        Intrinsics.checkExpressionValueIsNotNull(str, "config.wxaLaunchInstanceId");
        ((com.tencent.luggage.wxa.ft.b)localObject).b(str, paramh.m);
        return bool;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.luggage.sdk.config.AppBrandInitConfigLU");
    }
    return bool;
  }
  
  public void d()
  {
    this.f = ((bf)new com.tencent.luggage.ui.c());
    try
    {
      super.d();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      if (Intrinsics.areEqual("Mini-game is not support in this SDK version.", localRuntimeException.getMessage()))
      {
        com.tencent.luggage.wxa.ft.b localb = com.tencent.luggage.wxa.ft.b.a;
        Object localObject = G();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "initConfig");
        localObject = ((com.tencent.luggage.wxa.eo.a)localObject).i();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "initConfig.wxaLaunchInstanceId");
        localb.c((String)localObject, G().m);
        E();
      }
    }
  }
  
  protected void m()
  {
    super.m();
    com.tencent.luggage.wxa.ft.b localb = com.tencent.luggage.wxa.ft.b.a;
    Object localObject = G();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "initConfig");
    localObject = ((com.tencent.luggage.wxa.eo.a)localObject).i();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "initConfig.wxaLaunchInstanceId");
    localb.a((String)localObject, G().m);
  }
  
  protected void n()
  {
    super.n();
    com.tencent.mm.plugin.appbrand.appstorage.a.a((com.tencent.luggage.wxa.ed.d)this);
  }
  
  protected void o()
  {
    super.o();
    this.e = ((g)null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fk.e
 * JD-Core Version:    0.7.0.1
 */