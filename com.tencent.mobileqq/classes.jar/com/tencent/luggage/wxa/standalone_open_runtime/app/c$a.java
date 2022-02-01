package com.tencent.luggage.wxa.standalone_open_runtime.app;

import android.app.Activity;
import android.os.Bundle;
import android.os.MessageQueue.IdleHandler;
import com.tencent.luggage.wxa.pc.a;
import com.tencent.luggage.wxa.rc.c;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/wxa/standalone_open_runtime/app/WxaProcessSuicideLogic$watch$1", "Lcom/tencent/mm/plugin/appbrand/util/ActivityLifecycleCallbacksAdapter;", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class c$a
  extends a
{
  c$a(AtomicInteger paramAtomicInteger) {}
  
  public void onActivityCreated(@Nullable Activity paramActivity, @Nullable Bundle paramBundle)
  {
    this.a.incrementAndGet();
  }
  
  public void onActivityDestroyed(@Nullable Activity paramActivity)
  {
    this.a.decrementAndGet();
    if (this.a.get() <= 0) {
      c.a((MessageQueue.IdleHandler)new c.a.a(this, paramActivity));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.app.c.a
 * JD-Core Version:    0.7.0.1
 */