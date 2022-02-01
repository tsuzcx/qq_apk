package com.tencent.luggage.wxa.fw;

import com.tencent.luggage.wxa.jj.s.f;
import com.tencent.luggage.wxa.nl.b;
import com.tencent.luggage.wxa.nl.l;
import com.tencent.luggage.wxa.ny.e;
import com.tencent.luggage.wxa.ny.e.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxapkg/WxaRuntimeModularizingPkgRetrieverNew;", "Lcom/tencent/mm/plugin/appbrand/modularizing/ModularizingPkgRetriever;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "moduleName", "", "moduleMd5", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/plugin/appbrand/modularizing/ModularizingPkgRetriever$RetrieveCallback;", "setCallback", "", "start", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class a
  implements e
{
  public static final a.a a = new a.a(null);
  private e.a b;
  private final com.tencent.luggage.wxa.iu.d c;
  private final String d;
  
  public a(@NotNull com.tencent.luggage.wxa.iu.d paramd, @NotNull String paramString1, @NotNull String paramString2)
  {
    this.c = paramd;
    this.d = paramString1;
  }
  
  @JvmStatic
  public static final void b()
  {
    a.a();
  }
  
  public void a()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = (com.tencent.luggage.wxa.em.d)localObject;
      localObject = l.a;
      String str1 = ((com.tencent.luggage.wxa.em.d)this.c).aa();
      Intrinsics.checkExpressionValueIsNotNull(str1, "rt.appId");
      boolean bool = ((l)localObject).a(str1, ((com.tencent.luggage.wxa.em.d)this.c).ab(), ((com.tencent.luggage.wxa.em.d)this.c).b(), ((com.tencent.luggage.wxa.em.d)this.c).t(), ((com.tencent.luggage.wxa.em.d)this.c).f());
      localObject = b.a;
      str1 = ((com.tencent.luggage.wxa.em.d)this.c).aa();
      Intrinsics.checkExpressionValueIsNotNull(str1, "rt.appId");
      int i = ((com.tencent.luggage.wxa.em.d)this.c).b();
      int j = ((com.tencent.luggage.wxa.em.d)this.c).ab();
      List localList = CollectionsKt.listOf(this.d);
      l locall = l.a;
      s.f localf = ((com.tencent.luggage.wxa.em.d)this.c).G().p;
      Intrinsics.checkExpressionValueIsNotNull(localf, "rt.initConfig.wxaVersionInfo");
      String str2 = ((com.tencent.luggage.wxa.em.d)this.c).aa();
      Intrinsics.checkExpressionValueIsNotNull(str2, "rt.appId");
      ((b)localObject).a(str1, i, j, localList, locall.a(localf, str2, bool), (Function1)new a.b(this), (Function1)new a.c(this), (Function2)new a.d(this), ((com.tencent.luggage.wxa.em.d)this.c).u(), null);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.luggage.standalone_ext.Runtime");
  }
  
  public void a(@Nullable e.a parama)
  {
    this.b = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fw.a
 * JD-Core Version:    0.7.0.1
 */