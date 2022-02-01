package com.tencent.luggage.wxa.ky;

import android.view.View;
import com.tencent.luggage.wxa.kd.d;
import com.tencent.luggage.wxa.kd.j;
import com.tencent.luggage.wxa.kt.b;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONArray;
import org.json.JSONObject;

public class e
  extends d
{
  private static final int CTRL_INDEX = 367;
  public static final String NAME = "operateLivePlayer";
  
  private void a(a parama, com.tencent.luggage.wxa.jx.e parame, j paramj, JSONObject paramJSONObject)
  {
    parama.a(new e.1(this, paramj, parame));
    if (!parama.a("snapshot", paramJSONObject)) {
      paramj.a(b("fail:snapshot error"));
    }
  }
  
  protected int a(JSONObject paramJSONObject)
  {
    return paramJSONObject.optInt("livePlayerId");
  }
  
  protected boolean a(com.tencent.luggage.wxa.jx.e parame, int paramInt, View paramView, JSONObject paramJSONObject, j paramj)
  {
    int i = 0;
    o.d("MicroMsg.JsApiOperateLivePlayer", "onOperateView : livePlayerId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof b))
    {
      o.c("MicroMsg.JsApiOperateLivePlayer", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    Object localObject1 = (View)((b)paramView).a(View.class);
    if (!(localObject1 instanceof a))
    {
      o.b("MicroMsg.JsApiOperateLivePlayer", "targetView not AppBrandLivePlayerView");
      return false;
    }
    a locala = (a)localObject1;
    Object localObject2 = paramJSONObject.optString("type");
    o.d("MicroMsg.JsApiOperateLivePlayer", "onOperateView operateType=%s", new Object[] { localObject2 });
    if (((String)localObject2).equalsIgnoreCase("snapshot"))
    {
      a(locala, parame, paramj, paramJSONObject);
    }
    else
    {
      boolean bool = ((String)localObject2).equalsIgnoreCase("requestFullScreen");
      localObject1 = "ok";
      if (bool)
      {
        localObject2 = paramJSONObject.optJSONArray("data");
        if ((localObject2 != null) && (((JSONArray)localObject2).length() != 0)) {
          i = ((JSONArray)localObject2).optInt(0, 0);
        } else {
          o.c("MicroMsg.JsApiOperateLivePlayer", "onOperateView directionArr nil");
        }
        if (!locala.b(i)) {
          localObject1 = "fail";
        }
        paramj.a(b((String)localObject1));
      }
      else if (((String)localObject2).equalsIgnoreCase("exitFullScreen"))
      {
        if (!locala.c()) {
          localObject1 = "fail";
        }
        paramj.a(b((String)localObject1));
      }
      else
      {
        if (!locala.a((String)localObject2, paramJSONObject)) {
          localObject1 = "fail";
        }
        paramj.a(b((String)localObject1));
      }
    }
    return super.a(parame, paramInt, paramView, paramJSONObject, paramj);
  }
  
  protected boolean f()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ky.e
 * JD-Core Version:    0.7.0.1
 */