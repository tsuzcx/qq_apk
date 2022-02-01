package com.tencent.luggage.wxa.lf;

import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.nz.e;
import com.tencent.luggage.wxa.nz.f;
import com.tencent.luggage.wxa.qz.af;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class d
  extends a
{
  public static final int CTRL_INDEX = 243;
  public static final String NAME = "operateRequestTask";
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    a(paramc, paramJSONObject, paramInt, paramc.getJsRuntime());
  }
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt, com.tencent.mm.plugin.appbrand.jsruntime.o paramo)
  {
    com.tencent.luggage.wxa.qz.o.e("MicroMsg.JsApiOperateRequestTask", "JsApiOperateRequestTask");
    if (paramJSONObject == null)
    {
      paramc.a(paramInt, b("fail:data is null"));
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiOperateRequestTask", "data is null");
      return;
    }
    String str = paramJSONObject.optString("requestTaskId");
    if (af.c(str))
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiOperateRequestTask", "requestTaskId is null");
      paramc.a(paramInt, b("fail:requestTaskId is null or nil"));
      return;
    }
    paramJSONObject = paramJSONObject.optString("operationType");
    if (af.c(paramJSONObject))
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiOperateRequestTask", "operationType is null");
      paramc.a(paramInt, b("fail:operationType is null or nil"));
      return;
    }
    if (paramJSONObject.equals("abort"))
    {
      paramJSONObject = f.b().a(paramc.getAppId());
      if (paramJSONObject == null)
      {
        paramc.a(paramInt, b("fail:no task"));
        com.tencent.luggage.wxa.qz.o.c("MicroMsg.JsApiOperateRequestTask", "request is null");
        return;
      }
      e locale = paramJSONObject.c(str);
      boolean bool;
      if (locale != null)
      {
        paramJSONObject.a(locale);
        bool = true;
      }
      else
      {
        bool = paramJSONObject.a(str);
      }
      if (!bool)
      {
        paramc.a(paramInt, b("fail:no task"));
        com.tencent.luggage.wxa.qz.o.c("MicroMsg.JsApiOperateRequestTask", "requestInfo is null requestTaskId:%s, appId:%s", new Object[] { str, paramc.getAppId() });
        return;
      }
      paramc.a(paramInt, b("ok"));
      paramJSONObject = new HashMap();
      paramJSONObject.put("requestTaskId", str);
      paramJSONObject.put("state", "fail");
      paramJSONObject.put("errMsg", "abort");
      paramJSONObject = new JSONObject(paramJSONObject).toString();
      new a.a().b(paramc).b(paramJSONObject).a(paramo);
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.JsApiOperateRequestTask", "abortTask finish requestId:%s, appId:%s", new Object[] { str, paramc.getAppId() });
      return;
    }
    paramc.a(paramInt, b("fail:unknown operationType"));
  }
  
  public boolean e()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lf.d
 * JD-Core Version:    0.7.0.1
 */