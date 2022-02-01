package com.tencent.luggage.wxa.nl;

import com.tencent.luggage.wxa.qw.ab;
import com.tencent.luggage.wxa.qw.ac;
import com.tencent.luggage.wxa.qw.bz;
import com.tencent.luggage.wxa.qw.ca;
import com.tencent.luggage.wxa.qw.ff;
import com.tencent.luggage.wxa.qw.gs;
import com.tencent.luggage.wxa.qw.gt;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rl.b;
import com.tencent.luggage.wxa.ro.d;
import com.tencent.luggage.wxa.ro.e.a;
import com.tencent.luggage.wxa.ru.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/GetPkgDownloadUrlUnifiedCgiRouter;", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;", "()V", "TAG", "", "waitForBatchGetDownloadUrl", "", "inRequestList", "", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;", "onSuccess", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "onError", "Lkotlin/Function3;", "", "scene", "waitForDownloadUrl", "request", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "createNewProtocolReqItemList", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlReqItem;", "createRequestPackageInfo", "Lcom/tencent/mm/protocal/protobuf/RequestPackageInfo;", "RouterController", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class i
  implements k
{
  public static final i a = new i();
  
  private final gs a(@NotNull k.b paramb)
  {
    gs localgs = new gs();
    localgs.a = paramb.a();
    int i = paramb.c();
    int[] arrayOfInt = a.e;
    Intrinsics.checkExpressionValueIsNotNull(arrayOfInt, "ConstantsWxaPackageProto…_INTEGRATED_PACKAGE_TYPES");
    if (ArraysKt.contains(arrayOfInt, i))
    {
      localgs.c = ((String)null);
    }
    else
    {
      arrayOfInt = a.d;
      Intrinsics.checkExpressionValueIsNotNull(arrayOfInt, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      if (ArraysKt.contains(arrayOfInt, i)) {
        localgs.c = ((String)null);
      } else {
        localgs.c = paramb.b();
      }
    }
    localgs.d = paramb.c();
    localgs.e = paramb.d();
    return localgs;
  }
  
  private final List<bz> b(@NotNull k.b paramb)
  {
    LinkedList localLinkedList = new LinkedList();
    Object localObject = new i.b(paramb);
    bz localbz = ((i.b)localObject).a();
    ff localff = (ff)null;
    localbz.b = localff;
    localbz.f = false;
    localLinkedList.add(localbz);
    localbz = ((i.b)localObject).a();
    localbz.b = localff;
    localbz.f = true;
    localLinkedList.add(localbz);
    if (paramb.g() > 0)
    {
      localObject = ((i.b)localObject).a();
      ((bz)localObject).b = new ff();
      ((bz)localObject).b.a = paramb.g();
      ((bz)localObject).b.b = paramb.h();
      ((bz)localObject).f = false;
      localLinkedList.add(localObject);
    }
    return (List)localLinkedList;
  }
  
  public void a(@NotNull k.b paramb, @NotNull Function1<? super ca[], Unit> paramFunction1, @NotNull Function3<? super Integer, ? super Integer, ? super String, Unit> paramFunction3, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "request");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "onSuccess");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "onError");
    ab localab = new ab();
    localab.a.addAll((Collection)a.b(paramb));
    new c().a(paramb.a(), (gt)localab, ac.class).b((b)new i.f(paramFunction1, paramb)).a((e.a)new i.g(paramFunction3));
  }
  
  public final void a(@NotNull List<k.b> paramList, @NotNull Function1<? super ac, Unit> paramFunction1, @NotNull Function3<? super Integer, ? super Integer, ? super String, Unit> paramFunction3, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "inRequestList");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "onSuccess");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "onError");
    if (paramList.size() == 1)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("waitForBatchGetDownloadUrl, use single routine instead, with ");
      ((StringBuilder)localObject1).append((k.b)CollectionsKt.first(paramList));
      o.d("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", ((StringBuilder)localObject1).toString());
      a((k.b)paramList.get(0), (Function1)new i.c(paramFunction1), paramFunction3, paramInt);
      return;
    }
    Object localObject1 = new LinkedList();
    Object localObject2 = new LinkedList((Collection)paramList);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("waitForBatchGetDownloadUrl, inRequestList.size=");
    ((StringBuilder)localObject3).append(paramList.size());
    ((StringBuilder)localObject3).append(", realRequestList.size=");
    ((StringBuilder)localObject3).append(((LinkedList)localObject2).size());
    ((StringBuilder)localObject3).append(", preGetRespItemList.size=");
    ((StringBuilder)localObject3).append(((LinkedList)localObject1).size());
    o.d("MicroMsg.AppBrand.GetPkgDownloadUrlUnifiedCgiRouter", ((StringBuilder)localObject3).toString());
    if (((LinkedList)localObject2).size() <= 0)
    {
      paramList = new ac();
      paramList.a.addAll((Collection)localObject1);
      paramFunction1.invoke(paramList);
      return;
    }
    localObject1 = new ab();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (k.b)((Iterator)localObject2).next();
      ((ab)localObject1).a.addAll((Collection)a.b((k.b)localObject3));
    }
    new c().a(((k.b)CollectionsKt.first(paramList)).a(), (gt)localObject1, ac.class).b((b)new i.d(paramFunction1)).a((e.a)new i.e(paramFunction3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nl.i
 * JD-Core Version:    0.7.0.1
 */