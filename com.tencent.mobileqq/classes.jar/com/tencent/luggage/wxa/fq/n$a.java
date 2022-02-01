package com.tencent.luggage.wxa.fq;

import android.app.Activity;
import com.tencent.luggage.wxa.pc.a;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/wxaapi/internal/WxaPeriodTaskChecker$installPeriodChecker$1", "Lcom/tencent/mm/plugin/appbrand/util/ActivityLifecycleCallbacksAdapter;", "onActivityStopped", "", "activity", "Landroid/app/Activity;", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class n$a
  extends a
{
  public void onActivityStopped(@Nullable Activity paramActivity)
  {
    paramActivity = (Function0)new n.a.a(this);
    if (this.a.d())
    {
      f.a.c((Runnable)new o(paramActivity));
      return;
    }
    paramActivity.invoke();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.n.a
 * JD-Core Version:    0.7.0.1
 */