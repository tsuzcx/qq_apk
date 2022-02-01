package com.tencent.luggage.wxa.cx;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.do.c;
import com.tencent.luggage.wxa.iu.ad;
import com.tencent.luggage.wxa.jj.g;
import com.tencent.luggage.wxa.jj.q;
import com.tencent.luggage.wxa.jj.s;
import com.tencent.luggage.wxa.qw.fb;
import com.tencent.luggage.wxa.qw.fv;
import com.tencent.luggage.wxa.ro.e;
import com.tencent.mm.plugin.appbrand.appcache.d.a;
import org.json.JSONException;
import org.json.JSONObject;

public class f
{
  static com.tencent.luggage.wxa.do.d a(String paramString, @NonNull s params, @NonNull com.tencent.mm.plugin.appbrand.appcache.af paramaf, @NonNull fb paramfb)
  {
    long l = com.tencent.luggage.wxa.qz.af.d();
    com.tencent.luggage.wxa.do.d locald = new com.tencent.luggage.wxa.do.d();
    locald.S = paramaf;
    locald.g = new com.tencent.luggage.wxa.on.b(paramfb.b);
    if ((paramfb.f != null) && (!com.tencent.luggage.wxa.qz.af.c(paramfb.f.a))) {
      locald.i = paramfb.f.a;
    }
    try
    {
      paramaf = new JSONObject(paramfb.f.a).getJSONObject("privacy");
      if (paramaf.getInt("banLocationIfEmptyDesc") != 1) {
        break label251;
      }
      bool = true;
    }
    catch (JSONException paramaf)
    {
      for (;;)
      {
        label149:
        continue;
        boolean bool = false;
        continue;
        bool = false;
      }
    }
    locald.O = bool;
    if (paramaf.getInt("banGetWifiListIfEmptyDesc") == 1)
    {
      bool = true;
      locald.P = bool;
      break label149;
      locald.O = false;
      locald.P = false;
      q.a(locald, locald.i);
      locald.D = g.a;
      ad.a(locald, params);
      a(locald);
      locald.T = 2;
      if ((paramfb.e != null) && (paramfb.e.e != null)) {
        locald.H = paramfb.e.e.c();
      }
      com.tencent.luggage.wxa.qz.o.d("Luggage.WxaLaunchPrepareProcess|runProfiled", "[perf] prepare assemble sysConfig cost %dms, appId[%s]", new Object[] { Long.valueOf(com.tencent.luggage.wxa.qz.af.d() - l), paramString });
      return locald;
    }
  }
  
  @Deprecated
  private static void a(com.tencent.luggage.wxa.do.d paramd) {}
  
  static void a(com.tencent.luggage.wxa.em.d paramd, c paramc, com.tencent.luggage.wxa.do.d paramd1)
  {
    long l = com.tencent.luggage.wxa.qz.af.d();
    if (paramd1 != null) {
      if (d.a.a(paramc.G))
      {
        paramd1 = paramc.D;
        int i = paramc.G;
        if ((!paramc.d()) && (com.tencent.luggage.wxa.dc.o.a(paramd1)))
        {
          com.tencent.luggage.wxa.qz.o.d("Luggage.WxaLaunchPrepareProcess|runProfiled", "async update attr, appId=%s", new Object[] { paramd1 });
          com.tencent.luggage.wxa.dc.o.c(paramc.D).a(com.tencent.luggage.wxa.rp.d.c, new f.2(paramd1, paramd, paramc)).a(new f.1(paramd1, paramd));
        }
        else
        {
          b(paramd, com.tencent.luggage.wxa.lz.a.b, null);
        }
      }
      else
      {
        b(paramd, com.tencent.luggage.wxa.lz.a.b, null);
      }
    }
    com.tencent.luggage.wxa.qz.o.d("Luggage.WxaLaunchPrepareProcess|runProfiled", "[perf] prepare bonus cost %dms, appId[%s]", new Object[] { Long.valueOf(com.tencent.luggage.wxa.qz.af.d() - l), paramd.aa() });
  }
  
  private static void b(com.tencent.luggage.wxa.em.d paramd, com.tencent.luggage.wxa.lz.a parama, @Nullable String paramString)
  {
    paramd.c(new f.3(parama, paramd, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.f
 * JD-Core Version:    0.7.0.1
 */