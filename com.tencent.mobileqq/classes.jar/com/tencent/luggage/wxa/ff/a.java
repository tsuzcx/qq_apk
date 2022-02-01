package com.tencent.luggage.wxa.ff;

import android.util.SparseArray;
import com.tencent.luggage.wxa.jx.b;
import com.tencent.luggage.wxa.jx.h;
import com.tencent.luggage.wxa.qz.af;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/jsapi/report/AppBrandJsApiReporter;", "", "()V", "mInfoMap", "Landroid/util/SparseArray;", "Lcom/tencent/luggage/wxa/standalone_open_runtime/jsapi/report/JsApiInfo;", "mObjectPool", "Lcom/tencent/luggage/wxa/standalone_open_runtime/jsapi/report/AppBrandJsApiReporter$JsApiInfoPool;", "doCleanupJobOnRuntimeDestroyed", "", "doCleanupJobOnRuntimeSuspended", "report", "callbackId", "", "ret", "", "setJsApiInfo", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandBaseJsApi;", "data", "path", "getPermissionValue", "safeClear", "T", "safePut", "key", "value", "(Landroid/util/SparseArray;ILjava/lang/Object;)V", "safeRemoveReturnOld", "(Landroid/util/SparseArray;I)Ljava/lang/Object;", "JsApiInfoPool", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class a
{
  private final SparseArray<d> a = new SparseArray();
  private final a.a b = new a.a();
  
  private final int a(@NotNull d paramd)
  {
    Object localObject = paramd.a;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "this.component");
    com.tencent.luggage.wxa.iu.d locald = ((h)localObject).q();
    localObject = locald;
    if (!(locald instanceof com.tencent.luggage.wxa.fk.e)) {
      localObject = null;
    }
    localObject = (com.tencent.luggage.wxa.fk.e)localObject;
    if (localObject != null)
    {
      localObject = ((com.tencent.luggage.wxa.fk.e)localObject).a();
      if (localObject != null) {
        return ((com.tencent.luggage.wxa.on.c)localObject).a((com.tencent.luggage.wxa.jx.c)paramd.a, paramd.b, paramd.c, false);
      }
    }
    return -1;
  }
  
  private final <T> T a(@NotNull SparseArray<T> paramSparseArray, int paramInt)
  {
    try
    {
      Object localObject1 = paramSparseArray.get(paramInt, null);
      if (localObject1 != null) {
        paramSparseArray.remove(paramInt);
      }
      return localObject1;
    }
    finally {}
  }
  
  private final <T> void a(@NotNull SparseArray<T> paramSparseArray, int paramInt, T paramT)
  {
    try
    {
      paramSparseArray.put(paramInt, paramT);
      paramT = Unit.INSTANCE;
      return;
    }
    finally
    {
      paramT = finally;
      throw paramT;
    }
  }
  
  public final void a(int paramInt, @NotNull h paramh, @NotNull b paramb, @Nullable String paramString1, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramh, "component");
    Intrinsics.checkParameterIsNotNull(paramb, "api");
    if (e.a.a(paramb.d())) {
      return;
    }
    d locald = this.b.a();
    locald.a(paramh, paramb, paramString1, af.b(), paramString2);
    a(this.a, paramInt, locald);
  }
  
  public final void a(int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "ret");
    d locald = (d)a(this.a, paramInt);
    if (locald != null)
    {
      long l1 = af.b();
      long l2 = locald.d;
      e locale = e.a;
      Object localObject1 = locald.a;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "info.component");
      localObject1 = ((h)localObject1).q();
      if (localObject1 != null)
      {
        localObject1 = (com.tencent.luggage.wxa.fk.e)localObject1;
        Object localObject2 = locald.a;
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "info.component");
        localObject2 = ((h)localObject2).getAppId();
        String str = locald.e;
        b localb = locald.b;
        Intrinsics.checkExpressionValueIsNotNull(localb, "info.api");
        locale.a((com.tencent.luggage.wxa.fk.e)localObject1, (String)localObject2, str, localb.d(), locald.c, a(locald), l1 - l2, paramString);
        this.b.a(locald);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.luggage.wxa.standalone_open_runtime.runtime.WxaRuntime");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ff.a
 * JD-Core Version:    0.7.0.1
 */