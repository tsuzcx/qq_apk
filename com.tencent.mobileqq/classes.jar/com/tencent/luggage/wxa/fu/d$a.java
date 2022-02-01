package com.tencent.luggage.wxa.fu;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.luggage.wxa.pc.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/wxaapi/internal/process/MainProcessStartup$initialize$1", "Lcom/tencent/mm/plugin/appbrand/util/ActivityLifecycleCallbacksAdapter;", "activityRetainedCount", "", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class d$a
  extends a
{
  private int b;
  
  d$a(Application paramApplication) {}
  
  public void onActivityCreated(@Nullable Activity paramActivity, @Nullable Bundle paramBundle)
  {
    this.b += 1;
    int i = this.b;
    o.d("Luggage.WXA.MainProcessStartup", "onActivityCreated: wxa lazy load start...");
    if (d.a(d.a).get())
    {
      this.a.unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)this);
      return;
    }
    f.a.c((Runnable)new e((Function0)new d.a.a(d.a)), "MainProcessStartup-LoadLazyModules");
  }
  
  public void onActivityDestroyed(@Nullable Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    this.b -= 1;
    if (this.b <= 0) {
      f.a.e((Runnable)d.a.b.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fu.d.a
 * JD-Core Version:    0.7.0.1
 */