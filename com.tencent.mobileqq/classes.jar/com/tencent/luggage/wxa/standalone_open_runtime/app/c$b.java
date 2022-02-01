package com.tencent.luggage.wxa.standalone_open_runtime.app;

import com.tencent.luggage.wxa.ed.g;
import com.tencent.luggage.wxa.fa.b;
import com.tencent.luggage.wxa.fa.b.a;
import com.tencent.luggage.wxa.qz.o;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/wxa/standalone_open_runtime/app/WxaProcessSuicideLogic$watch$2", "Lcom/tencent/luggage/wxa/WxaRuntimeStore$Listener;", "onRuntimeRemoved", "", "rt", "Lcom/tencent/luggage/standalone_ext/Runtime;", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class c$b
  implements b.a
{
  c$b(AtomicInteger paramAtomicInteger) {}
  
  public void a(@NotNull com.tencent.luggage.wxa.em.d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "rt");
    g.a.b((com.tencent.luggage.wxa.ed.d)paramd);
    boolean bool2 = b.a.b();
    boolean bool1 = true;
    bool2 ^= true;
    boolean bool3 = g.a.a() ^ true;
    boolean bool4 = a.a();
    if (this.a.get() <= 0) {
      bool1 = false;
    }
    paramd = new StringBuilder();
    paramd.append("before suicide maybe (onRuntimeRemoved), hasPendingLaunchActivity:");
    paramd.append(bool4);
    paramd.append(", hasActiveActivity:");
    paramd.append(bool1);
    paramd.append(", hasRuntimeStashed:");
    paramd.append(bool3);
    paramd.append(", hasActiveRuntime:");
    paramd.append(bool2);
    o.d("Luggage.WxaProcessSuicideLogic", paramd.toString());
    if ((!bool4) && (!bool1) && (!bool3) && (!bool2)) {
      c.a(c.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.app.c.b
 * JD-Core Version:    0.7.0.1
 */