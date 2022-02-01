package com.tencent.luggage.wxa.jx;

import com.tencent.luggage.wxa.qw.aa;
import com.tencent.luggage.wxa.qw.lh;
import com.tencent.luggage.wxa.qw.n;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rl.b;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class an$1
  implements b<Object, lh>
{
  an$1(an paraman, c paramc, int paramInt) {}
  
  public Object a(lh paramlh)
  {
    if (paramlh == null)
    {
      o.b("MicroMsg.JsApiGetSetting", "WxaAppGetAuthInfoReq cgi failed, null response");
      this.a.a(this.b, this.c.b("fail:cgi fail"));
      return null;
    }
    if (paramlh.z.a != 0)
    {
      o.b("MicroMsg.JsApiGetSetting", "WxaAppGetAuthInfoReq cgi failed, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramlh.z.a), paramlh.z.b });
      this.a.a(this.b, this.c.b("fail:cgi fail"));
      return null;
    }
    try
    {
      Object localObject = paramlh.b;
      paramlh = new JSONArray();
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        n localn = (n)((Iterator)localObject).next();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("scope", localn.a);
          localJSONObject.put("state", localn.c);
          localJSONObject.put("desc", localn.b);
          paramlh.put(localJSONObject);
        }
        catch (Exception localException)
        {
          o.b("MicroMsg.JsApiGetSetting", "parse json failed : %s", new Object[] { localException.getMessage() });
        }
      }
      localObject = paramlh.toString();
      o.e("MicroMsg.JsApiGetSetting", "authInfo %s", new Object[] { paramlh });
      paramlh = new JSONObject();
      try
      {
        paramlh.put("errMsg", "getSetting:ok");
        paramlh.put("authSetting", new JSONArray(af.b((String)localObject)));
        this.a.a(this.b, paramlh.toString());
        return null;
      }
      catch (JSONException paramlh)
      {
        o.a("MicroMsg.JsApiGetSetting", paramlh, "set json error!", new Object[0]);
      }
    }
    catch (Exception paramlh)
    {
      label304:
      break label304;
    }
    this.a.a(this.b, this.c.b("fail:resp invalid"));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.an.1
 * JD-Core Version:    0.7.0.1
 */