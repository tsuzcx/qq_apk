package com.tencent.luggage.wxa.standalone_open_runtime.ui;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.luggage.opensdk.a.a;
import com.tencent.luggage.wxa.ba.b;
import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.jx.m;
import com.tencent.luggage.wxa.rm.a;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.ConcurrentSkipListSet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/wxa/standalone_open_runtime/ui/WxaEnterWechatInvokeManager$invoke$invokeContext$1", "Lcom/tencent/luggage/opensdk/BridgedJsApiInvokeProtocol$InvokeContext;", "Landroidx/lifecycle/LifecycleObserver;", "_callbackActivityClass", "", "get_callbackActivityClass", "()Ljava/lang/String;", "_callbackActivityClass$delegate", "Lkotlin/Lazy;", "_onResumeListeners", "Ljava/util/concurrent/ConcurrentSkipListSet;", "Ljava/lang/Runnable;", "addOnResumeListener", "", "runnable", "customize", "T", "Lcom/tencent/luggage/base/ICustomize;", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/tencent/luggage/base/ICustomize;", "getAppId", "getCallbackActivityClass", "getContext", "Landroid/content/Context;", "getDebugType", "", "getJsApi", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "apiName", "getPagePath", "getPageTitle", "isWaitingForJSCallback", "", "keep", "target", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "onActivityResumed", "release", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class WxaEnterWechatInvokeManager$invoke$invokeContext$1
  implements LifecycleObserver, a.a
{
  private final Lazy c = LazyKt.lazy((Function0)new WxaEnterWechatInvokeManager.invoke.invokeContext.1.a(this));
  private final ConcurrentSkipListSet<Runnable> d = new ConcurrentSkipListSet((Comparator)WxaEnterWechatInvokeManager.invoke.invokeContext.1.b.a);
  
  WxaEnterWechatInvokeManager$invoke$invokeContext$1(String paramString, Context paramContext)
  {
    paramString = paramContext;
    if (!(paramContext instanceof LifecycleOwner)) {
      paramString = null;
    }
    paramString = (LifecycleOwner)paramString;
    if (paramString != null)
    {
      paramString = paramString.getLifecycle();
      if (paramString != null) {
        paramString.addObserver((LifecycleObserver)this);
      }
    }
  }
  
  private final String i()
  {
    return (String)this.c.getValue();
  }
  
  @Nullable
  public <T extends b> T a(@Nullable Class<T> paramClass)
  {
    return e.a(paramClass);
  }
  
  @Nullable
  public m a(@Nullable String paramString)
  {
    return null;
  }
  
  @NotNull
  public String a()
  {
    return this.a;
  }
  
  public void a(@Nullable a parama) {}
  
  public void a(@Nullable Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      this.d.add(paramRunnable);
    }
  }
  
  @Nullable
  public String b()
  {
    String str = i();
    if (str != null) {
      return str;
    }
    return "";
  }
  
  public boolean c()
  {
    return false;
  }
  
  @Nullable
  public Context d()
  {
    return this.b;
  }
  
  public void e()
  {
    Context localContext = this.b;
    Object localObject = localContext;
    if (!(localContext instanceof LifecycleOwner)) {
      localObject = null;
    }
    localObject = (LifecycleOwner)localObject;
    if (localObject != null)
    {
      localObject = ((LifecycleOwner)localObject).getLifecycle();
      if (localObject != null) {
        ((Lifecycle)localObject).removeObserver((LifecycleObserver)this);
      }
    }
    this.d.clear();
  }
  
  public int f()
  {
    return 0;
  }
  
  @NotNull
  public String g()
  {
    return "";
  }
  
  @NotNull
  public String h()
  {
    return "";
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public final void onActivityResumed()
  {
    Iterator localIterator = ((Iterable)this.d).iterator();
    while (localIterator.hasNext()) {
      ((Runnable)localIterator.next()).run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.ui.WxaEnterWechatInvokeManager.invoke.invokeContext.1
 * JD-Core Version:    0.7.0.1
 */