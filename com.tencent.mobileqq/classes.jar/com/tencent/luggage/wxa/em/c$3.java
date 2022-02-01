package com.tencent.luggage.wxa.em;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.luggage.setting.ui.WxaSettingActivity;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jj.l;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.ui.base.g;

class c$3
  extends com.tencent.luggage.wxa.nv.a
{
  c$3(c paramc, int paramInt)
  {
    super(paramInt);
  }
  
  public void a(@NonNull Context paramContext, @NonNull u paramu, g paramg, String paramString)
  {
    paramg.add(a(), 2131891819);
  }
  
  public void a(@NonNull Context paramContext, @NonNull u paramu, String paramString, com.tencent.luggage.wxa.nu.a parama)
  {
    paramContext = paramu.q().A();
    boolean bool = paramu.q().W().f();
    WxaSettingActivity.a(this.a.getContext(), this.a.getAppId(), ((com.tencent.luggage.wxa.do.c)paramu.q().B()).b, paramContext.I, bool, new c.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.em.c.3
 * JD-Core Version:    0.7.0.1
 */