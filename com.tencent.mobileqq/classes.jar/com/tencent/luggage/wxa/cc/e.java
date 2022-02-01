package com.tencent.luggage.wxa.cc;

import com.tencent.luggage.wxa.cj.a;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.jj.l;
import com.tencent.luggage.wxa.ob.b;
import com.tencent.luggage.wxa.qw.eu;
import com.tencent.luggage.wxa.qw.ev;
import com.tencent.luggage.wxa.qw.md;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.appcache.af;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class e
  extends a<h>
{
  private static final int CTRL_INDEX = 118;
  private static final String NAME = "refreshSession";
  
  private com.tencent.luggage.wxa.ro.d<ev> a(String paramString, int paramInt1, int paramInt2)
  {
    o.d("Luggage.JsApiRefreshSessionStandalone", "refreshSession appId %s, versionType, statScene %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    eu localeu = new eu();
    localeu.a = paramString;
    localeu.b = paramInt1;
    if (paramInt2 > 0)
    {
      localeu.c = new md();
      localeu.c.b = paramInt2;
    }
    return ((b)com.tencent.luggage.wxa.ba.e.a(b.class)).b("/cgi-bin/mmbiz-bin/js-refreshsession", paramString, localeu, ev.class);
  }
  
  public void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = (l)paramh.b(l.class);
    int i;
    if (paramJSONObject != null) {
      i = paramJSONObject.S.b;
    } else {
      i = 0;
    }
    paramJSONObject = new HashMap();
    paramJSONObject.put("errCode", "-1");
    a(paramh.getAppId(), i, 0).a(new e.3(this, paramJSONObject)).a(com.tencent.luggage.wxa.rp.d.b, new e.2(this, paramh, paramInt)).a(com.tencent.luggage.wxa.rp.d.b, new e.1(this, paramh, paramInt, paramJSONObject));
  }
  
  protected boolean a(JSONObject paramJSONObject)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cc.e
 * JD-Core Version:    0.7.0.1
 */