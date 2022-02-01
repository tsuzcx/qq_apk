package com.tencent.luggage.wxa.ct;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.cu.g.b;
import com.tencent.luggage.wxa.iu.aa;
import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.jx.j;
import com.tencent.luggage.wxa.jx.k;
import com.tencent.luggage.wxa.jx.m;
import com.tencent.luggage.wxa.jx.n;
import com.tencent.luggage.wxa.jx.u;
import com.tencent.luggage.wxa.qw.gu;
import com.tencent.luggage.wxa.qz.s;
import com.tencent.luggage.wxa.ro.d;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/jsapi/webview/HTMLWebViewComponentImpl;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "htmlWebView", "Lcom/tencent/luggage/jsapi/webview/AppBrandHTMLWebView;", "(Lcom/tencent/luggage/jsapi/webview/AppBrandHTMLWebView;)V", "hostWxaAppId", "", "getHostWxaAppId", "()Ljava/lang/String;", "getHtmlWebView", "()Lcom/tencent/luggage/jsapi/webview/AppBrandHTMLWebView;", "jsApiPool", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "getJsApiPool", "()Ljava/util/Map;", "jsApiPool$delegate", "Lkotlin/Lazy;", "lifecycleOwner", "Lcom/tencent/mm/plugin/appbrand/RuntimeVendingLifecycleKeeper;", "getLifecycleOwner", "()Lcom/tencent/mm/plugin/appbrand/RuntimeVendingLifecycleKeeper;", "mAsyncHandler", "Landroid/os/Handler;", "getMAsyncHandler", "()Landroid/os/Handler;", "mAsyncHandler$delegate", "mAsyncHandlerInitialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mJsBridgeDelegate", "Lcom/tencent/luggage/jsapi/webview/HTMLWebViewJsBridgeDelegate;", "mJsRuntimeWrapper", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "getMJsRuntimeWrapper", "()Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "mJsRuntimeWrapper$delegate", "mUiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "permissionController", "Lcom/tencent/luggage/jsapi/webview/model/HTMLWebViewJsApiPermissionController;", "getPermissionController", "()Lcom/tencent/luggage/jsapi/webview/model/HTMLWebViewJsApiPermissionController;", "attachConfig", "", "config", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandConfig;", "configs", "", "attachEnvContext", "", "context", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandEnvContext;", "callback", "callbackId", "", "data", "cleanup", "createJsApiPool", "", "createJsRuntime", "customize", "T", "Lcom/tencent/luggage/base/ICustomize;", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/tencent/luggage/base/ICustomize;", "dispatch", "event", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "executable", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonExecutable;", "src", "dispatchInvoke", "apiName", "dispatchInvoke$luggage_standalone_mode_ext_release", "emitWeixinJSBridgeReady", "getAppId", "getAppState", "Lcom/tencent/mm/plugin/appbrand/appstate/AppRunningState;", "getAsyncHandler", "getComponentId", "getConfig", "(Ljava/lang/Class;)Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandConfig;", "getContext", "Landroid/content/Context;", "getDialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "getEnvContext", "(Ljava/lang/Class;)Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandEnvContext;", "getFileSystem", "Lcom/tencent/mm/plugin/appbrand/appstorage/IFileSystem;", "getJsRuntime", "isRunning", "isServiceProcessPreloadedBeforeInitialized", "notifyKeyboardStateChanged", "shown", "height", "onBackground", "onForeground", "publish", "dst", "", "runCgi", "Lcom/tencent/mm/vending/pipeline/Pipeable;", "RESP", "REQ", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "url", "request", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/BaseProtoBuf;Ljava/lang/Class;)Lcom/tencent/mm/vending/pipeline/Pipeable;", "scheduleToUiThread", "runnable", "Ljava/lang/Runnable;", "scheduleToUiThreadDelayed", "delayMs", "", "setInterceptor", "interceptor", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent$Interceptor;", "toJson", "Lorg/json/JSONObject;", "EventOnGetKeyboardHeight", "EventPageStateChange", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class b
  implements com.tencent.luggage.wxa.jx.c
{
  private final s a;
  private final AtomicBoolean b;
  private final Lazy c;
  private final Lazy d;
  private final c e;
  @NotNull
  private final Lazy f;
  @NotNull
  private final com.tencent.luggage.wxa.cv.b g;
  @NotNull
  private final aa h;
  @NotNull
  private final a i;
  
  public b(@NotNull a parama)
  {
    this.i = parama;
    this.a = new s(Looper.getMainLooper());
    this.b = new AtomicBoolean(false);
    this.c = LazyKt.lazy((Function0)new b.h(this));
    this.d = LazyKt.lazy((Function0)new b.i(this));
    this.e = new c(this);
    this.f = LazyKt.lazy((Function0)b.g.a);
    this.g = new com.tencent.luggage.wxa.cv.b(this);
    this.h = new aa();
  }
  
  private final JSONObject a(@Nullable String paramString)
  {
    CharSequence localCharSequence = (CharSequence)paramString;
    int j;
    if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
      j = 0;
    } else {
      j = 1;
    }
    if (j != 0) {
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString);
      return paramString;
    }
    catch (JSONException paramString)
    {
      label45:
      break label45;
    }
    return null;
  }
  
  private final Handler m()
  {
    return (Handler)this.c.getValue();
  }
  
  private final com.tencent.mm.plugin.appbrand.jsruntime.i n()
  {
    return (com.tencent.mm.plugin.appbrand.jsruntime.i)this.d.getValue();
  }
  
  @Nullable
  public <T extends com.tencent.luggage.wxa.ba.b> T a(@Nullable Class<T> paramClass)
  {
    Object localObject = this.i.getPageView();
    if (localObject != null)
    {
      localObject = ((com.tencent.luggage.wxa.dq.c)localObject).a(paramClass);
      if (localObject != null) {
        return localObject;
      }
    }
    return e.a(paramClass);
  }
  
  @NotNull
  public final <REQ extends com.tencent.luggage.wxa.qu.a, RESP extends gu> d<RESP> a(@NotNull String paramString, @NotNull REQ paramREQ, @NotNull Class<RESP> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    Intrinsics.checkParameterIsNotNull(paramREQ, "request");
    Intrinsics.checkParameterIsNotNull(paramClass, "clazz");
    com.tencent.luggage.wxa.ba.b localb = a(com.tencent.luggage.wxa.ob.b.class);
    if (localb == null) {
      Intrinsics.throwNpe();
    }
    paramString = ((com.tencent.luggage.wxa.ob.b)localb).b(paramString, b(), paramREQ, paramClass).a((com.tencent.luggage.wxa.rm.b)this.h);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "this.customize(ICgiServi…ycle(this.lifecycleOwner)");
    return paramString;
  }
  
  @Nullable
  public final String a(@NotNull String paramString1, @Nullable String paramString2, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "apiName");
    paramString1 = (m)a().get(paramString1);
    if (paramString1 == null) {
      return com.tencent.luggage.wxa.cu.a.a.a();
    }
    if ((paramString1 instanceof com.tencent.luggage.wxa.jx.a))
    {
      paramString2 = a(paramString2);
      if (paramString2 != null)
      {
        this.g.a(paramString1, paramString2, (Function0)new b.c(this, paramString1, paramString2, paramInt), (Function0)new b.d(this, paramInt));
        return "";
      }
      return com.tencent.luggage.wxa.cu.a.a.b();
    }
    if ((paramString1 instanceof u))
    {
      paramString2 = a(paramString2);
      if (paramString2 != null)
      {
        com.tencent.luggage.wxa.pc.i locali = new com.tencent.luggage.wxa.pc.i();
        this.g.a(paramString1, paramString2, (Function0)new b.e(this, locali, paramString1, paramString2), (Function0)new b.f(locali));
        return (String)locali.a;
      }
      return com.tencent.luggage.wxa.cu.a.a.b();
    }
    return com.tencent.luggage.wxa.cu.a.a.c();
  }
  
  @NotNull
  public final Map<String, m> a()
  {
    return (Map)this.f.getValue();
  }
  
  public void a(int paramInt, @Nullable String paramString)
  {
    this.e.a(paramInt, paramString);
  }
  
  public void a(@Nullable ah paramah)
  {
    if (paramah != null) {
      a(paramah.d(), paramah.c());
    }
  }
  
  public void a(@Nullable ah paramah, @Nullable com.tencent.mm.plugin.appbrand.jsruntime.o paramo)
  {
    a(paramah);
  }
  
  public void a(@Nullable ah paramah, @Nullable int[] paramArrayOfInt)
  {
    if (paramah != null)
    {
      if ((paramah instanceof g.b))
      {
        paramArrayOfInt = this.i.getPageView();
        if (paramArrayOfInt != null)
        {
          paramArrayOfInt = paramArrayOfInt.i();
          if (paramArrayOfInt != null)
          {
            paramah = (g.b)paramah;
            paramArrayOfInt = (com.tencent.luggage.wxa.jx.c)paramArrayOfInt;
            com.tencent.luggage.wxa.dq.c localc = this.i.getPageView();
            Intrinsics.checkExpressionValueIsNotNull(localc, "htmlWebView.pageView");
            paramah.a(paramArrayOfInt, localc.getComponentId()).a();
            return;
          }
        }
        return;
      }
      a(paramah);
    }
  }
  
  public void a(@Nullable Runnable paramRunnable)
  {
    com.tencent.luggage.wxa.dq.c localc = this.i.getPageView();
    if (localc != null) {
      localc.a(paramRunnable);
    }
  }
  
  public void a(@Nullable String paramString1, @Nullable String paramString2)
  {
    b(paramString1, paramString2, 0);
  }
  
  public void a(@Nullable String paramString1, @Nullable String paramString2, @Nullable int[] paramArrayOfInt)
  {
    a(paramString1, paramString2);
  }
  
  public final void a(boolean paramBoolean, int paramInt)
  {
    a(new b.a().a("height", Integer.valueOf(paramInt)));
  }
  
  public boolean a(@Nullable k paramk)
  {
    return false;
  }
  
  @Nullable
  public <T extends j> T b(@Nullable Class<T> paramClass)
  {
    Object localObject1 = this.i.getPageView();
    boolean bool = localObject1 instanceof com.tencent.luggage.wxa.jx.c;
    Object localObject2 = null;
    if (!bool) {
      localObject1 = null;
    }
    com.tencent.luggage.wxa.jx.c localc = (com.tencent.luggage.wxa.jx.c)localObject1;
    localObject1 = localObject2;
    if (localc != null) {
      localObject1 = localc.b(paramClass);
    }
    return localObject1;
  }
  
  @Nullable
  public final String b()
  {
    com.tencent.luggage.wxa.dq.c localc = this.i.getPageView();
    if (localc != null) {
      return localc.getAppId();
    }
    return null;
  }
  
  public void b(@Nullable String paramString1, @Nullable String paramString2, int paramInt)
  {
    this.e.a(paramString1, paramString2);
  }
  
  @NotNull
  public final com.tencent.luggage.wxa.cv.b c()
  {
    return this.g;
  }
  
  @Nullable
  public <T extends k> T c(@NotNull Class<T> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "clazz");
    com.tencent.luggage.wxa.dq.c localc = this.i.getPageView();
    if (localc != null) {
      return localc.c(paramClass);
    }
    return null;
  }
  
  public boolean d()
  {
    com.tencent.luggage.wxa.dq.c localc = this.i.getPageView();
    return (localc != null) && (localc.d() == true);
  }
  
  public boolean e()
  {
    return false;
  }
  
  public void f()
  {
    this.a.a(null);
    if (this.b.get()) {
      m().getLooper().quit();
    }
    this.e.a();
    n().destroy();
    this.h.a();
  }
  
  @NotNull
  public Map<String, m> g()
  {
    return (Map)new LinkedHashMap();
  }
  
  @NotNull
  public String getAppId()
  {
    Object localObject = this.i.getPageView();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "htmlWebView.pageView");
    localObject = ((com.tencent.luggage.wxa.dq.c)localObject).getAppId();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "htmlWebView.pageView.appId");
    return localObject;
  }
  
  @NotNull
  public com.tencent.luggage.wxa.ix.b getAppState()
  {
    com.tencent.luggage.wxa.dq.c localc = this.i.getPageView();
    if ((localc != null) && (localc.R() == true)) {
      return com.tencent.luggage.wxa.ix.b.a;
    }
    return com.tencent.luggage.wxa.ix.b.b;
  }
  
  @NotNull
  public Handler getAsyncHandler()
  {
    return m();
  }
  
  public int getComponentId()
  {
    return hashCode();
  }
  
  @NotNull
  public Context getContext()
  {
    Object localObject = com.tencent.luggage.wxa.rc.a.a(this.i.getContext());
    if (localObject != null) {
      return (Context)localObject;
    }
    localObject = this.i.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "htmlWebView.context");
    return localObject;
  }
  
  @Nullable
  public com.tencent.mm.plugin.appbrand.widget.dialog.l getDialogContainer()
  {
    com.tencent.luggage.wxa.dq.c localc = this.i.getPageView();
    if (localc != null) {
      return localc.getDialogContainer();
    }
    return null;
  }
  
  @Nullable
  public com.tencent.mm.plugin.appbrand.appstorage.o getFileSystem()
  {
    Object localObject1 = this.i.getPageView();
    Object localObject3 = null;
    if (localObject1 != null) {
      localObject1 = ((com.tencent.luggage.wxa.dq.c)localObject1).getFileSystem();
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject3;
    if (localObject1 != null)
    {
      if ((localObject1 instanceof t)) {
        return ((t)localObject1).a(com.tencent.mm.plugin.appbrand.appstorage.l.class);
      }
      localObject2 = localObject3;
      if ((localObject1 instanceof com.tencent.mm.plugin.appbrand.appstorage.l)) {
        localObject2 = localObject1;
      }
    }
    return localObject2;
  }
  
  @NotNull
  public com.tencent.mm.plugin.appbrand.jsruntime.i getJsRuntime()
  {
    return n();
  }
  
  @NotNull
  public com.tencent.mm.plugin.appbrand.jsruntime.i h()
  {
    return n();
  }
  
  public final void i()
  {
    a(new b.b().a("active", Boolean.valueOf(true)));
  }
  
  public final void j()
  {
    a(new b.b().a("active", Boolean.valueOf(false)));
  }
  
  public final void k()
  {
    a("sys:init", "{}");
  }
  
  @NotNull
  public final a l()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ct.b
 * JD-Core Version:    0.7.0.1
 */