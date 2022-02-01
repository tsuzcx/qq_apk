package com.tencent.luggage.wxa.fc;

import com.tencent.luggage.wxa.jx.m;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/jsapi/WxaJsApiPool;", "Lcom/tencent/luggage/standalone_ext/JsApiPool;", "()V", "BLACK_LIST", "Ljava/util/LinkedList;", "", "createForAppService", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "createForPage", "initPagePool", "", "initServicePool", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class g
  extends com.tencent.luggage.wxa.em.a
{
  public static final g a = new g();
  private static final LinkedList<String> b;
  
  static
  {
    LinkedList localLinkedList = new LinkedList();
    CollectionsKt.addAll((Collection)localLinkedList, new String[] { "verifyPaymentPassword", "bindPaymentCard" });
    b = localLinkedList;
  }
  
  @NotNull
  public Map<String, m> a()
  {
    Map localMap = super.a();
    Iterator localIterator = ((Iterable)b).iterator();
    while (localIterator.hasNext()) {
      localMap.remove((String)localIterator.next());
    }
    Intrinsics.checkExpressionValueIsNotNull(localMap, "super.createForAppServic…)\n            }\n        }");
    return localMap;
  }
  
  @NotNull
  public Map<String, m> b()
  {
    Map localMap = super.b();
    Iterator localIterator = ((Iterable)b).iterator();
    while (localIterator.hasNext()) {
      localMap.remove((String)localIterator.next());
    }
    Intrinsics.checkExpressionValueIsNotNull(localMap, "super.createForPage().ap…)\n            }\n        }");
    return localMap;
  }
  
  protected void c()
  {
    super.c();
    a((m)new com.tencent.luggage.wxa.fd.b());
    a((m)new com.tencent.luggage.wxa.fd.a());
    a((m)new a());
    a((m)new e());
    a((m)new f());
    a((m)new com.tencent.luggage.wxa.fg.a());
    a((m)new d());
    a((m)new com.tencent.luggage.wxa.lv.e());
    a((m)new com.tencent.luggage.wxa.lv.b());
    a((m)new c());
    a((m)new b());
    a(com.tencent.luggage.wxa.fe.f.a.a());
  }
  
  protected void d()
  {
    super.d();
    b((m)new com.tencent.luggage.wxa.fd.b());
    b((m)new com.tencent.luggage.wxa.fd.a());
    b((m)new a());
    b((m)new e());
    b((m)new f());
    b((m)new d());
    b((m)new c());
    b((m)new b());
    b(com.tencent.luggage.wxa.fe.f.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fc.g
 * JD-Core Version:    0.7.0.1
 */