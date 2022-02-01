package com.tencent.luggage.wxa.kb;

import android.text.TextUtils;
import com.tencent.luggage.wxa.ob.b;
import com.tencent.luggage.wxa.qw.bb;
import com.tencent.luggage.wxa.qw.bc;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.d;
import com.tencent.mm.plugin.appbrand.page.u;
import org.json.JSONObject;

public class a
  extends com.tencent.luggage.wxa.jx.a<u>
{
  public static final int CTRL_INDEX = 206;
  public static final String NAME = "deleteUserAutoFillData";
  
  public void a(u paramu, JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject == null)
    {
      o.b("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData data is invalid");
      paramu.a(paramInt, b("fail:data is invalid"));
      return;
    }
    String str1 = paramJSONObject.optString("groupKey");
    int i = paramJSONObject.optInt("groupId", 0);
    if (TextUtils.isEmpty(str1))
    {
      o.b("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData groupKey is invalid");
      paramu.a(paramInt, b("fail:groupKey is invalid"));
      return;
    }
    String str2 = paramu.getAppId();
    int j = paramJSONObject.optInt("clientVersion", 0);
    o.d("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData appId:%s, clientVersion:%s, groupId:%d, groupKey:%s", new Object[] { str2, Integer.valueOf(j), Integer.valueOf(i), str1 });
    paramJSONObject = new bb();
    paramJSONObject.b = str1;
    paramJSONObject.a = str2;
    paramJSONObject.c = i;
    paramJSONObject.d = 1;
    paramJSONObject.f = j;
    ((b)paramu.a(b.class)).b("/cgi-bin/mmbiz-bin/wxaapp/autofill/deleteinfo", str2, paramJSONObject, bc.class).a(new a.1(this, paramu, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kb.a
 * JD-Core Version:    0.7.0.1
 */