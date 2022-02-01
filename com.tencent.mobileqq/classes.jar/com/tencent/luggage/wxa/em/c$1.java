package com.tencent.luggage.wxa.em;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jj.h;
import com.tencent.luggage.wxa.jj.l;
import com.tencent.luggage.wxa.jx.ah;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.ui.base.g;
import java.util.HashMap;
import java.util.Map;

class c$1
  extends com.tencent.luggage.wxa.nv.a
{
  c$1(c paramc, int paramInt)
  {
    super(paramInt);
  }
  
  public void a(@NonNull Context paramContext, @NonNull u paramu, g paramg, String paramString)
  {
    paramg.add(a(), 2131891821);
  }
  
  public void a(@NonNull Context paramContext, @NonNull u paramu, String paramString, com.tencent.luggage.wxa.nu.a parama)
  {
    paramContext = new com.tencent.luggage.wxa.cq.a();
    paramString = paramu.q().A();
    parama = new HashMap();
    parama.put("title", paramString.I);
    parama.put("desc", "");
    parama.put("path", paramu.ao());
    parama.put("imgUrl", paramu.q().B().F);
    parama.put("mode", "common");
    paramContext.b(paramu.q().ae(), paramu.getComponentId()).b(parama).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.em.c.1
 * JD-Core Version:    0.7.0.1
 */