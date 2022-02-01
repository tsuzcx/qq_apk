package com.tencent.luggage.wxa.le;

import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.qz.af;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class d
  extends a
{
  public static final int CTRL_INDEX = 270;
  public static final String NAME = "operateDownloadTask";
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    a(paramc, paramJSONObject, paramInt, paramc.getJsRuntime());
  }
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt, com.tencent.mm.plugin.appbrand.jsruntime.o paramo)
  {
    com.tencent.luggage.wxa.qz.o.e("MicroMsg.JsApiOperateDownloadTask", "JsApiOperateDownloadTask");
    if (paramJSONObject == null)
    {
      paramc.a(paramInt, b("fail:data is null"));
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiOperateDownloadTask", "data is null");
      return;
    }
    String str = paramJSONObject.optString("downloadTaskId");
    if (af.c(str))
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiOperateDownloadTask", "downloadTaskId is null");
      paramc.a(paramInt, b("fail:downloadTaskId is null or nil"));
      return;
    }
    paramJSONObject = paramJSONObject.optString("operationType");
    if (af.c(paramJSONObject))
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiOperateDownloadTask", "operationType is null");
      paramc.a(paramInt, b("fail:operationType is null or nil"));
      return;
    }
    if (paramJSONObject.equals("abort"))
    {
      paramJSONObject = com.tencent.luggage.wxa.nz.c.b().a(paramc.getAppId());
      if (paramJSONObject == null)
      {
        paramc.a(paramInt, b("fail:no task"));
        com.tencent.luggage.wxa.qz.o.c("MicroMsg.JsApiOperateDownloadTask", "download is null");
        return;
      }
      Object localObject = paramJSONObject.a(str);
      if (localObject == null)
      {
        paramc.a(paramInt, b("fail:no task"));
        com.tencent.luggage.wxa.qz.o.c("MicroMsg.JsApiOperateDownloadTask", "downloadWorker is null %s", new Object[] { str });
        return;
      }
      paramJSONObject.a((com.tencent.luggage.wxa.oa.b)localObject);
      paramc.a(paramInt, b("ok"));
      paramJSONObject = new HashMap();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("");
      paramJSONObject.put("downloadTaskId", ((StringBuilder)localObject).toString());
      paramJSONObject.put("state", "fail");
      paramJSONObject.put("errMsg", "abort");
      paramJSONObject = new JSONObject(paramJSONObject).toString();
      new a.a().b(paramc).b(paramJSONObject).a(paramo);
      com.tencent.luggage.wxa.qz.o.e("MicroMsg.JsApiOperateDownloadTask", "abortTask finish %s", new Object[] { str });
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
 * Qualified Name:     com.tencent.luggage.wxa.le.d
 * JD-Core Version:    0.7.0.1
 */