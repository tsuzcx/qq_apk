package com.tencent.luggage.wxa.kb;

import android.text.TextUtils;
import com.tencent.luggage.wxa.qw.aa;
import com.tencent.luggage.wxa.qw.cp;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rl.b;
import com.tencent.mm.plugin.appbrand.page.u;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;

class d$1
  implements b<Object, cp>
{
  d$1(d paramd, u paramu, int paramInt) {}
  
  public Object a(cp paramcp)
  {
    HashMap localHashMap = new HashMap();
    if (paramcp == null)
    {
      o.b("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData cgi failed, null response");
      localHashMap.put("ret", Integer.valueOf(-99));
      this.a.a(this.b, this.c.a("fail: ErrMsg: cgi fail", localHashMap));
      return null;
    }
    Object localObject1;
    if (paramcp.z.a != 0)
    {
      o.b("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData cgi failed, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramcp.z.a), paramcp.z.b });
      localHashMap.put("ret", Integer.valueOf(paramcp.z.a));
      localObject1 = this.a;
      i = this.b;
      localObject2 = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fail: ErrMsg:");
      localStringBuilder.append(paramcp.z.b);
      ((u)localObject1).a(i, ((d)localObject2).a(localStringBuilder.toString(), localHashMap));
      return null;
    }
    o.d("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData success");
    boolean bool = TextUtils.isEmpty(paramcp.a);
    Object localObject2 = "";
    if (!bool) {
      localObject1 = paramcp.a;
    } else {
      localObject1 = "";
    }
    if (!TextUtils.isEmpty(paramcp.c)) {
      localObject2 = paramcp.c;
    }
    int i = paramcp.b;
    paramcp = paramcp.d;
    o.d("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData auth_info:%s, auth_status:%d", new Object[] { localObject2, Integer.valueOf(i) });
    o.d("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData user_info_json:%s", new Object[] { localObject1 });
    localHashMap.put("userData", localObject1);
    localHashMap.put("authStatus", Integer.valueOf(i));
    localHashMap.put("authInfo", localObject2);
    if ((paramcp != null) && (paramcp.size() > 0))
    {
      localHashMap.put("authGroupList", new JSONArray(paramcp));
      o.d("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData authGroupList:%s", new Object[] { new JSONArray(paramcp).toString() });
    }
    this.a.a(this.b, this.c.a("ok", localHashMap));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kb.d.1
 * JD-Core Version:    0.7.0.1
 */