package com.tencent.luggage.wxa.fc;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.luggage.wxa.fk.e;
import com.tencent.luggage.wxa.iu.d.b;
import com.tencent.luggage.wxa.iu.n;
import com.tencent.luggage.wxa.on.c;
import com.tencent.luggage.wxa.standalone_open_runtime.service.a.a;
import com.tencent.mm.plugin.appbrand.page.o;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/jsapi/JsApiNavigateToMiniProgramBridged$BridgedWxaRuntime;", "Lcom/tencent/luggage/wxa/standalone_open_runtime/runtime/WxaRuntime;", "container", "Lcom/tencent/mm/plugin/appbrand/IRuntimeContainerHandler;", "(Lcom/tencent/mm/plugin/appbrand/IRuntimeContainerHandler;)V", "createLoadingSplash", "Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplash;", "createPageContainer", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageContainer;", "createService", "Lcom/tencent/luggage/wxa/standalone_open_runtime/service/WxaAppService;", "hideSplash", "", "mockConfigs", "startPrepareProcesses", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class b$e
  extends e
{
  public b$e(@NotNull n paramn)
  {
    super(paramn);
  }
  
  private final void aX()
  {
    Object localObject = b.c.a.a(this);
    if (localObject != null)
    {
      at().add(localObject);
      localObject = com.tencent.luggage.wxa.jj.a.a(aa(), "{}");
      ((com.tencent.luggage.wxa.jj.a)localObject).b = G().I;
      a((com.tencent.luggage.wxa.jj.a)localObject);
      a(new c((com.tencent.luggage.wxa.iu.d)this, -1, true));
      an();
      M();
      return;
    }
    ((Function0)new b.e.a(this)).invoke();
  }
  
  @NotNull
  protected com.tencent.mm.plugin.appbrand.ui.d H()
  {
    Object localObject = ah();
    if (localObject != null) {
      localObject = (Context)localObject;
    } else {
      localObject = ag();
    }
    return (com.tencent.mm.plugin.appbrand.ui.d)new com.tencent.luggage.wxa.standalone_open_runtime.ui.a((Context)localObject, (com.tencent.luggage.wxa.iu.d)this, null);
  }
  
  @NotNull
  protected o J()
  {
    Context localContext = ag();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "appContext");
    return (o)new b.a(localContext, (e)this);
  }
  
  @SuppressLint({"MissingSuperCall"})
  protected void L()
  {
    a((d.b)new b.e.b(this));
  }
  
  public void Q() {}
  
  @NotNull
  protected com.tencent.luggage.wxa.standalone_open_runtime.service.a R()
  {
    return com.tencent.luggage.wxa.standalone_open_runtime.service.a.c.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fc.b.e
 * JD-Core Version:    0.7.0.1
 */