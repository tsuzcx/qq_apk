package com.tencent.luggage.wxa.fc;

import android.content.Context;
import com.tencent.luggage.wxa.dq.c;
import com.tencent.luggage.wxa.standalone_open_runtime.e;
import com.tencent.mm.plugin.appbrand.page.a;
import com.tencent.mm.plugin.appbrand.page.aj;
import com.tencent.mm.plugin.appbrand.page.am;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/jsapi/JsApiNavigateToMiniProgramBridged$BridgedPageRenderer;", "Lcom/tencent/mm/plugin/appbrand/page/AbstractMPPageViewRenderer;", "Lcom/tencent/luggage/wxa/standalone_open_runtime/WxaPageView;", "p", "(Lcom/tencent/luggage/wxa/standalone_open_runtime/WxaPageView;)V", "onCreateCustomWebView", "Lcom/tencent/mm/plugin/appbrand/page/IAppBrandWebView;", "context", "Landroid/content/Context;", "onLoadURL", "", "url", "", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class b$b
  extends a<e>
{
  public b$b(@NotNull e parame)
  {
    super((c)parame);
  }
  
  @NotNull
  protected am a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return (am)new aj();
  }
  
  public boolean a(@Nullable String paramString)
  {
    paramString = (e)y();
    if (paramString == null) {
      Intrinsics.throwNpe();
    }
    paramString.a((Runnable)new b.b.a(this));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fc.b.b
 * JD-Core Version:    0.7.0.1
 */