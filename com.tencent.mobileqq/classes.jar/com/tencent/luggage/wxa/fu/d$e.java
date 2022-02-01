package com.tencent.luggage.wxa.fu;

import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/wxaapi/internal/process/MainProcessStartup$waitForLoaded$1", "Ljava/lang/Runnable;", "run", "", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class d$e
  implements Runnable
{
  d$e(Function0 paramFunction0) {}
  
  public void run()
  {
    if (d.a(d.a).get())
    {
      this.a.invoke();
      return;
    }
    f.a.b((Runnable)this, 100L, "MainProcessStartup-LoadLazyModules");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fu.d.e
 * JD-Core Version:    0.7.0.1
 */