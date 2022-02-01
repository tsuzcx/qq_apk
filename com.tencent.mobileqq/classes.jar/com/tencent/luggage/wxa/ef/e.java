package com.tencent.luggage.wxa.ef;

import android.util.ArrayMap;
import com.tencent.luggage.wxa.ix.b;
import com.tencent.luggage.wxa.ix.c.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/sdk/wxa_ktx/RuntimeLifecycleListenerBuilder;", "Lcom/tencent/mm/plugin/appbrand/appstate/AppRunningStateController$OnRunningStateChangedListener;", "()V", "mEventInvokeMap", "Landroid/util/ArrayMap;", "Lcom/tencent/mm/plugin/appbrand/appstate/AppRunningState;", "Lkotlin/Function0;", "", "Lcom/tencent/luggage/sdk/wxa_ktx/LifecycleEventInvoke;", "onBackground", "callback", "onDestroy", "onForeground", "onRunningStateChanged", "appId", "", "state", "onSuspend", "registerCallback", "luggage-wxa-app_release"}, k=1, mv={1, 1, 16})
public final class e
  implements c.a
{
  private final ArrayMap<b, Function0<Unit>> a = new ArrayMap();
  
  private final void a(b paramb, Function0<Unit> paramFunction0)
  {
    ((Map)this.a).put(paramb, paramFunction0);
  }
  
  public void a(@Nullable String paramString, @Nullable b paramb)
  {
    paramString = (CharSequence)paramString;
    int i;
    if ((paramString != null) && (paramString.length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return;
    }
    if (paramb != null)
    {
      paramString = (Function0)this.a.get(paramb);
      if (paramString != null) {
        paramString = (Unit)paramString.invoke();
      }
    }
  }
  
  public final void a(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "callback");
    a(b.a, paramFunction0);
  }
  
  public final void b(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "callback");
    a(b.b, paramFunction0);
  }
  
  public final void c(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "callback");
    a(b.c, paramFunction0);
  }
  
  public final void d(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "callback");
    a(b.d, paramFunction0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ef.e
 * JD-Core Version:    0.7.0.1
 */