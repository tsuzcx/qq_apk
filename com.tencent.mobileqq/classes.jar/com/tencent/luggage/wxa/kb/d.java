package com.tencent.luggage.wxa.kb;

import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.ob.b;
import com.tencent.luggage.wxa.qw.co;
import com.tencent.luggage.wxa.qw.cp;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.u;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class d
  extends a<u>
{
  public static final int CTRL_INDEX = 204;
  public static final String NAME = "getUserAutoFillData";
  
  public void a(u paramu, JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject == null)
    {
      o.b("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData data is invalid");
      paramu.a(paramInt, b("fail:data is invalid"));
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    Object localObject = paramJSONObject.optJSONArray("fields");
    if ((localObject != null) && (((JSONArray)localObject).length() > 0))
    {
      i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        localLinkedList.add(((JSONArray)localObject).optString(i));
        i += 1;
      }
    }
    if (localLinkedList.size() == 0)
    {
      o.b("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData fields is empty");
      paramu.a(paramInt, b("fail:fields is empty"));
      return;
    }
    localObject = paramu.getAppId();
    int i = paramJSONObject.optInt("clientVersion", 0);
    o.d("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData appId:%s, clientVersion:%s data:%s", new Object[] { localObject, Integer.valueOf(i), paramJSONObject.toString() });
    co localco = new co();
    localco.c = localLinkedList;
    localco.a = ((String)localObject);
    localco.b = paramJSONObject.optBoolean("getAllInfo", false);
    localco.d = 1;
    localco.e = i;
    ((b)paramu.a(b.class)).b("/cgi-bin/mmbiz-bin/wxaapp/autofill/getinfo", (String)localObject, localco, cp.class).a(new d.1(this, paramu, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kb.d
 * JD-Core Version:    0.7.0.1
 */