package com.tencent.luggage.wxa.ld;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.nz.k.c;
import com.tencent.luggage.wxa.nz.l;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.d;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class g
  extends a
{
  public static final int CTRL_INDEX = 347;
  public static final String NAME = "operateSocketTask";
  private boolean a = false;
  private boolean b = false;
  private final AtomicBoolean c = new AtomicBoolean(false);
  private k.c d;
  
  public g(k.c paramc)
  {
    this.d = paramc;
  }
  
  private void a(@NonNull com.tencent.luggage.wxa.jx.c paramc)
  {
    k.c localc = this.d;
    if (localc != null)
    {
      this.a = localc.a(paramc.getAppId());
      this.b = this.d.b(paramc.getAppId());
    }
  }
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    o.e("MicroMsg.JsApiOperateSocketTask", "JsApiOperateSocketTask");
    if (!this.c.getAndSet(true)) {
      a(paramc);
    }
    if (paramJSONObject == null)
    {
      paramc.a(paramInt, b("fail:data is null"));
      o.b("MicroMsg.JsApiOperateSocketTask", "data is null");
      return;
    }
    String str1 = paramJSONObject.optString("socketTaskId");
    if (af.c(str1))
    {
      o.b("MicroMsg.JsApiOperateSocketTask", "taskId is null");
      paramc.a(paramInt, b("fail:taskId is null or nil"));
      return;
    }
    String str2 = paramJSONObject.optString("operationType");
    if (af.c(str2))
    {
      o.b("MicroMsg.JsApiOperateSocketTask", "operationType is null");
      paramc.a(paramInt, b("fail:operationType is null or nil"));
      return;
    }
    Object localObject = l.a().a(paramc.getAppId());
    if (localObject == null)
    {
      paramc.a(paramInt, b("fail:no task"));
      o.c("MicroMsg.JsApiOperateSocketTask", "client is null");
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.websocket.e locale = ((d)localObject).a(str1);
    if (locale == null)
    {
      paramc.a(paramInt, b("fail:taskID not exist"));
      o.c("MicroMsg.JsApiOperateSocketTask", "webSocketClient is null");
      return;
    }
    if (str2.equals("close"))
    {
      int i = paramJSONObject.optInt("code", 1000);
      if ((i != 1000) && ((i < 3000) || (i >= 5000)))
      {
        paramc.a(paramInt, b("fail:The code must be either 1000, or between 3000 and 4999"));
        return;
      }
      paramJSONObject = paramJSONObject.optString("reason", "");
      ((d)localObject).a(locale, i, paramJSONObject);
      paramc.a(paramInt, b("ok"));
      o.d("MicroMsg.JsApiOperateSocketTask", "closeSocket taskId:%s, code %d, reason %s", new Object[] { str1, Integer.valueOf(i), paramJSONObject });
      return;
    }
    if (str2.equals("send"))
    {
      if (!((d)localObject).c(locale))
      {
        paramc.a(paramInt, b("fail:don't send before socket connected"));
        o.c("MicroMsg.JsApiOperateSocketTask", "send fail taskId: %s", new Object[] { str1 });
        return;
      }
      paramJSONObject = paramJSONObject.opt("data");
      if (paramJSONObject != null) {
        try
        {
          if ((paramJSONObject instanceof ByteBuffer))
          {
            o.e("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage ok message:%s", new Object[] { paramJSONObject });
            ((d)localObject).a(locale, (ByteBuffer)paramJSONObject);
            ((com.tencent.luggage.wxa.ot.c)com.tencent.luggage.wxa.ba.e.b(com.tencent.luggage.wxa.ot.c.class)).a(972L, 4L, 1L, false);
          }
          else
          {
            if (!(paramJSONObject instanceof String)) {
              break label505;
            }
            o.e("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage ok message");
            ((d)localObject).a(locale, (String)paramJSONObject);
            ((com.tencent.luggage.wxa.ot.c)com.tencent.luggage.wxa.ba.e.b(com.tencent.luggage.wxa.ot.c.class)).a(972L, 4L, 1L, false);
          }
          paramc.a(paramInt, b("ok"));
          return;
          label505:
          o.c("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage error message type wrong");
          paramc.a(paramInt, b("fail:unknown data"));
          return;
        }
        catch (Exception paramJSONObject)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("fail:");
          ((StringBuilder)localObject).append(paramJSONObject.getMessage());
          paramc.a(paramInt, b(((StringBuilder)localObject).toString()));
          if ((!this.a) && (!this.b))
          {
            ((com.tencent.luggage.wxa.ot.c)com.tencent.luggage.wxa.ba.e.b(com.tencent.luggage.wxa.ot.c.class)).a(972L, 5L, 1L, false);
            return;
          }
          ((com.tencent.luggage.wxa.ot.c)com.tencent.luggage.wxa.ba.e.b(com.tencent.luggage.wxa.ot.c.class)).a(972L, 6L, 1L, false);
          return;
        }
      }
      paramc.a(paramInt, b("fail:message is null or nil"));
      o.c("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage fail:%s", new Object[] { paramJSONObject });
      return;
    }
    paramc.a(paramInt, b("fail:unknown operationType"));
    o.c("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage fail:unknown operationType");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ld.g
 * JD-Core Version:    0.7.0.1
 */