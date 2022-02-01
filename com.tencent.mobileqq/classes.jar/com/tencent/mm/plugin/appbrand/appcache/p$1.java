package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcelable;
import com.tencent.luggage.wxa.cx.h;
import com.tencent.luggage.wxa.hj.b;
import com.tencent.luggage.wxa.hu.d;
import com.tencent.luggage.wxa.qw.fb;
import com.tencent.luggage.wxa.qw.gf;
import com.tencent.luggage.wxa.qz.r;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/appcache/WxaCommLibCheckerIPC$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/luggage/launch/OnLaunchWxaResponseReceivedEvent;", "callback", "", "event", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class p$1
  extends com.tencent.luggage.wxa.qy.c<h>
{
  public boolean a(@Nullable h paramh)
  {
    if (paramh != null)
    {
      paramh = paramh.a();
      if (paramh != null)
      {
        paramh = paramh.d;
        if ((paramh != null) && (paramh.a == true))
        {
          paramh = r.i();
          Intrinsics.checkExpressionValueIsNotNull(paramh, "MMApplicationContext.getMainProcessName()");
          b.a(paramh, (Parcelable)d.a, (com.tencent.luggage.wxa.hj.c)p.1.a.a, null, 8, null);
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.p.1
 * JD-Core Version:    0.7.0.1
 */