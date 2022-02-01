package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.ai;
import com.tencent.mm.plugin.appbrand.appcache.aj;
import com.tencent.mm.plugin.appbrand.appcache.aj.a;
import com.tencent.mm.plugin.appbrand.appcache.h;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper$Factory$IMPL;", "Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper;", "renderer", "Lcom/tencent/mm/plugin/appbrand/page/AbstractMPPageViewRenderer;", "separatedPluginsMap", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;", "(Lcom/tencent/mm/plugin/appbrand/page/AbstractMPPageViewRenderer;Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;)V", "TAG", "", "injectedScriptNames", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "pkgReader", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "getPkgReader", "()Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "pkgReader$delegate", "Lkotlin/Lazy;", "injectPlugins", "", "moduleName", "useLazyCodeLoading", "", "onReloadURL", "evaluateScriptFile", "fileName", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
final class as$a$a
  implements as
{
  private final String b;
  private final Lazy c;
  private final HashSet<String> d;
  private final a<?> e;
  private final ai f;
  
  public as$a$a(@NotNull a<?> parama, @NotNull ai paramai)
  {
    this.e = parama;
    this.f = paramai;
    this.b = "Luggage.FULL.IWxaPageSeparatedPluginsInjectHelper.IMPL";
    this.c = LazyKt.lazy((Function0)new as.a.a.a(this));
    this.d = new HashSet();
  }
  
  private final void a(@NotNull a<?> parama, String paramString)
  {
    if (this.d.contains(paramString)) {
      return;
    }
    String str = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("inner evaluateScriptFile fileName(");
    localStringBuilder.append(paramString);
    localStringBuilder.append(") hash(");
    localStringBuilder.append(hashCode());
    localStringBuilder.append(')');
    o.d(str, localStringBuilder.toString());
    parama.a(paramString, parama.F().a(paramString));
    this.d.add(paramString);
  }
  
  private final h b()
  {
    return (h)this.c.getValue();
  }
  
  public void a()
  {
    this.d.clear();
  }
  
  public void a(@NotNull String paramString, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "moduleName");
    Object localObject1 = this.b;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("injectPlugins moduleName(");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(") useLazyCodeLoading(");
    ((StringBuilder)localObject2).append(paramBoolean);
    ((StringBuilder)localObject2).append(") hash(");
    ((StringBuilder)localObject2).append(hashCode());
    ((StringBuilder)localObject2).append(')');
    o.d((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = this.f.a(paramString);
    if (localObject1 == null)
    {
      localObject1 = com.tencent.luggage.wxa.nn.a.a(paramString);
      if (Intrinsics.areEqual(localObject1, paramString))
      {
        localObject1 = null;
      }
      else
      {
        localObject2 = this.f;
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "fixedName");
        localObject1 = ((ai)localObject2).a((String)localObject1);
      }
    }
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (WxaPluginPkgInfo)((Iterator)localObject1).next();
        localObject2 = aj.a.a(paramString, (WxaPluginPkgInfo)localObject2);
        if (paramBoolean)
        {
          localObject3 = b();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append("/common.app.js");
          if (((h)localObject3).d(localStringBuilder.toString()))
          {
            localObject3 = this.e;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject2);
            localStringBuilder.append("/common.app.js");
            a((a)localObject3, localStringBuilder.toString());
            localObject3 = this.e;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject2);
            localStringBuilder.append("/webview.app.js");
            a((a)localObject3, localStringBuilder.toString());
            continue;
          }
        }
        Object localObject3 = this.e;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append("/pageframe.js");
        a((a)localObject3, localStringBuilder.toString());
      }
      return;
    }
    localObject1 = this.b;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("injectPlugins, try with module(");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append("), get empty pluginList");
    o.d((String)localObject1, ((StringBuilder)localObject2).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.as.a.a
 * JD-Core Version:    0.7.0.1
 */