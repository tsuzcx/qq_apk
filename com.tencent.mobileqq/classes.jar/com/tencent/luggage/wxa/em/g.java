package com.tencent.luggage.wxa.em;

import com.tencent.luggage.wxa.iu.d.b;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.Job.DefaultImpls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/standalone_ext/WxaRuntimeBoostPrepareProcess;", "SERVICE", "Lcom/tencent/luggage/standalone_ext/service/AppService;", "PAGEVIEW", "Lcom/tencent/luggage/standalone_ext/PageView;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime$PrepareProcess;", "appId", "", "isGame", "", "processSharedPreloader", "Lcom/tencent/luggage/standalone_ext/boost/IRuntimePreloader;", "serviceFactory", "Lkotlin/Function0;", "pageViewFactory", "(Ljava/lang/String;ZLcom/tencent/luggage/standalone_ext/boost/IRuntimePreloader;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "coroutineJob", "Lkotlinx/coroutines/Job;", "preloadedPage", "Lcom/tencent/luggage/standalone_ext/PageView;", "preloadedService", "Lcom/tencent/luggage/standalone_ext/service/AppService;", "checkProcessPreloadResult", "T", "getter", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureXWeb", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPageView", "()Lcom/tencent/luggage/standalone_ext/PageView;", "getService", "()Lcom/tencent/luggage/standalone_ext/service/AppService;", "interrupt", "", "name", "preloadPage", "preloadService", "prepare", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class g<SERVICE extends com.tencent.luggage.standalone_ext.service.a, PAGEVIEW extends c>
  extends d.b
{
  @Deprecated
  public static final g.a a = new g.a(null);
  private SERVICE b;
  private PAGEVIEW c;
  private Job d;
  private final String e;
  private final boolean f;
  private final com.tencent.luggage.wxa.en.a<SERVICE, PAGEVIEW> g;
  private final Function0<SERVICE> h;
  private final Function0<PAGEVIEW> i;
  
  public g(@NotNull String paramString, boolean paramBoolean, @NotNull com.tencent.luggage.wxa.en.a<SERVICE, PAGEVIEW> parama, @NotNull Function0<? extends SERVICE> paramFunction0, @NotNull Function0<? extends PAGEVIEW> paramFunction01)
  {
    this.e = paramString;
    this.f = paramBoolean;
    this.g = parama;
    this.h = paramFunction0;
    this.i = paramFunction01;
  }
  
  public void a()
  {
    if (((g)this).d != null)
    {
      Job localJob = this.d;
      if (localJob == null) {
        Intrinsics.throwUninitializedPropertyAccessException("coroutineJob");
      }
      Job.DefaultImpls.cancel$default(localJob, null, 1, null);
    }
  }
  
  public void b()
  {
    this.d = BuildersKt.launch$default((CoroutineScope)GlobalScope.INSTANCE, null, null, (Function2)new g.f(this, null), 3, null);
  }
  
  @NotNull
  public String c()
  {
    return "WxaRuntimeBoostPrepareProcess";
  }
  
  @Nullable
  public final SERVICE d()
  {
    return this.b;
  }
  
  @Nullable
  public final PAGEVIEW e()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.em.g
 * JD-Core Version:    0.7.0.1
 */