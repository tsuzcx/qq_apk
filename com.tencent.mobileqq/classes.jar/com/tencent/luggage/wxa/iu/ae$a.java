package com.tencent.luggage.wxa.iu;

import com.tencent.luggage.wxa.do.c;
import com.tencent.luggage.wxa.em.d;
import com.tencent.luggage.wxa.jj.h;
import com.tencent.luggage.wxa.pd.u;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/WxaPreRenderColdStartService$PreRenderedRuntimeStore;", "", "()V", "runtimeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/luggage/standalone_ext/Runtime;", "notifyRemovedToMainProcess", "", "appId", "processIndex", "", "poll", "cfg", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfig;", "push", "rt", "action", "Lcom/tencent/luggage/struct/LaunchContainerAction;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class ae$a
{
  public static final a a = new a();
  private static final ConcurrentHashMap<String, d> b = new ConcurrentHashMap();
  
  @JvmStatic
  @Nullable
  public static final d a(@NotNull h paramh)
  {
    Intrinsics.checkParameterIsNotNull(paramh, "cfg");
    Object localObject2 = paramh.D;
    Object localObject1 = null;
    if (localObject2 == null) {
      return null;
    }
    c localc = (c)paramh;
    synchronized (b)
    {
      localObject2 = (d)b.remove(paramh.D);
      if (localObject2 != null)
      {
        localObject1 = a;
        paramh = paramh.D;
        Intrinsics.checkExpressionValueIsNotNull(paramh, "cfg.appId");
        ((a)localObject1).a(paramh, localc.r);
        localObject1 = localObject2;
      }
      return localObject1;
    }
  }
  
  private final void a(String paramString, int paramInt)
  {
    paramString = (Runnable)new ae.a.a(paramString, paramInt);
    if (u.a())
    {
      f.a.e(paramString);
      return;
    }
    paramString.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.ae.a
 * JD-Core Version:    0.7.0.1
 */