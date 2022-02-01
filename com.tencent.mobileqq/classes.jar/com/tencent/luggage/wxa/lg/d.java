package com.tencent.luggage.wxa.lg;

import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.nz.g;
import com.tencent.luggage.wxa.nz.h;
import com.tencent.luggage.wxa.nz.i;
import com.tencent.luggage.wxa.qz.af;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class d
  extends a
{
  public static final int CTRL_INDEX = 273;
  public static final String NAME = "operateUploadTask";
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    a(paramc, paramJSONObject, paramInt, paramc.getJsRuntime());
  }
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt, com.tencent.mm.plugin.appbrand.jsruntime.o paramo)
  {
    com.tencent.luggage.wxa.qz.o.e("MicroMsg.JsApiOperateUploadTask", "JsApiOperateUploadTask");
    if (paramJSONObject == null)
    {
      paramc.a(paramInt, b("fail:data is null"));
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiOperateUploadTask", "data is null");
      return;
    }
    String str = paramJSONObject.optString("uploadTaskId");
    if (af.c(str))
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiOperateUploadTask", "uploadTaskId is null");
      paramc.a(paramInt, b("fail:uploadTaskId is null or nil"));
      return;
    }
    paramJSONObject = paramJSONObject.optString("operationType");
    if (af.c(paramJSONObject))
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiOperateUploadTask", "operationType is null");
      paramc.a(paramInt, b("fail:operationType is null or nil"));
      return;
    }
    if (paramJSONObject.equals("abort"))
    {
      paramJSONObject = i.b().a(paramc.getAppId());
      if (paramJSONObject == null)
      {
        com.tencent.luggage.wxa.qz.o.d("MicroMsg.JsApiOperateUploadTask", "upload is null");
        paramc.a(paramInt, b("fail:no task"));
        return;
      }
      Object localObject = paramJSONObject.a(str);
      if (localObject == null)
      {
        com.tencent.luggage.wxa.qz.o.d("MicroMsg.JsApiOperateUploadTask", "uploadInfo is null %s", new Object[] { str });
        paramc.a(paramInt, b("fail:no task"));
        return;
      }
      paramJSONObject.a((h)localObject);
      paramc.a(paramInt, b("ok"));
      paramJSONObject = new HashMap();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("");
      paramJSONObject.put("uploadTaskId", ((StringBuilder)localObject).toString());
      paramJSONObject.put("state", "fail");
      paramJSONObject.put("errMsg", "abort");
      paramJSONObject = new JSONObject(paramJSONObject).toString();
      new a.a().b(paramc).b(paramJSONObject).a(paramo);
      com.tencent.luggage.wxa.qz.o.e("MicroMsg.JsApiOperateUploadTask", "abortTask finish %s", new Object[] { str });
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
 * Qualified Name:     com.tencent.luggage.wxa.lg.d
 * JD-Core Version:    0.7.0.1
 */