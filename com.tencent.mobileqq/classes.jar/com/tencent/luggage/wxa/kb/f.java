package com.tencent.luggage.wxa.kb;

import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.ob.b;
import com.tencent.luggage.wxa.qw.hl;
import com.tencent.luggage.wxa.qw.hm;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.d;
import com.tencent.mm.plugin.appbrand.page.u;
import org.json.JSONObject;

public class f
  extends a<u>
{
  public static final int CTRL_INDEX = 205;
  public static final String NAME = "setUserAutoFillData";
  
  public void a(u paramu, JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject == null)
    {
      o.b("MicroMsg.JsApiSetUserAutoFillData", "setUserAutoFillData data is invalid");
      paramu.a(paramInt, b("fail:data is invalid"));
      return;
    }
    String str1 = paramJSONObject.optString("dataList");
    String str2 = paramu.getAppId();
    int i = paramJSONObject.optInt("clientVersion", 0);
    o.d("MicroMsg.JsApiSetUserAutoFillData", "setUserAutoFillData appId:%s, clientVersion:%s, dataList:%s", new Object[] { str2, Integer.valueOf(i), str1 });
    paramJSONObject = new hl();
    paramJSONObject.a = str2;
    paramJSONObject.b = str1;
    paramJSONObject.c = 1;
    paramJSONObject.d = i;
    ((b)paramu.a(b.class)).b("/cgi-bin/mmbiz-bin/wxaapp/autofill/saveinfo", str2, paramJSONObject, hm.class).a(new f.1(this, paramu, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kb.f
 * JD-Core Version:    0.7.0.1
 */