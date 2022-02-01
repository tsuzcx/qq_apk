package com.tencent.luggage.wxa.fq;

import android.content.Context;
import com.tencent.luggage.wxa.ft.a;
import com.tencent.luggage.wxa.fu.d;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.c;
import com.tencent.luggage.wxaapi.LaunchWxaAppResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "appId", "", "kotlin.jvm.PlatformType", "onTerminate"}, k=3, mv={1, 1, 16})
final class g$l<T>
  implements e.c<String>
{
  g$l(g paramg, long paramLong, String paramString1, Context paramContext, int paramInt, String paramString2) {}
  
  public final void a(String paramString)
  {
    CharSequence localCharSequence = (CharSequence)paramString;
    int i;
    if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      g.a();
      o.b("Luggage.WxaApiImpl", "launchByUsername fail, appId is null");
      a.a.a(this.b, LaunchWxaAppResult.FailWxaAppIdSync);
      return;
    }
    d.a.a((Function0)new g.l.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.g.l
 * JD-Core Version:    0.7.0.1
 */