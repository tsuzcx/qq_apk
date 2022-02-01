package com.tencent.luggage.wxa.ky;

import android.view.View;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.jx.e;
import com.tencent.luggage.wxa.kd.d;
import com.tencent.luggage.wxa.kd.j;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

public class f
  extends d
{
  private static final int CTRL_INDEX = 363;
  public static final String NAME = "operateLivePusher";
  
  private void a(c paramc, b paramb, JSONObject paramJSONObject, j paramj)
  {
    paramJSONObject = paramJSONObject.optString("url");
    if (af.c(paramJSONObject))
    {
      o.c("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, url is nil");
      paramj.a(b("fail:url is nil"));
      return;
    }
    com.tencent.luggage.wxa.pd.b.a(paramc, paramJSONObject, null, new f.1(this, paramb, paramJSONObject));
    paramj.a(b("ok"));
  }
  
  private void a(b paramb, e parame, j paramj, JSONObject paramJSONObject)
  {
    paramb.a(new f.2(this, paramj, parame));
    if (!paramb.a("snapshot", paramJSONObject)) {
      paramj.a(b("fail:snapshot error"));
    }
  }
  
  protected int a(JSONObject paramJSONObject)
  {
    return paramJSONObject.optInt("livePusherId");
  }
  
  protected boolean a(e parame, int paramInt, View paramView, JSONObject paramJSONObject, j paramj)
  {
    o.d("MicroMsg.JsApiOperateLivePusher", "onOperateView : livePusherId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof com.tencent.luggage.wxa.kt.b))
    {
      o.c("MicroMsg.JsApiOperateLivePusher", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    Object localObject = (View)((com.tencent.luggage.wxa.kt.b)paramView).a(View.class);
    if (!(localObject instanceof b))
    {
      o.b("MicroMsg.JsApiOperateLivePusher", "targetView not AppBrandLivePusherView");
      return false;
    }
    localObject = (b)localObject;
    String str = paramJSONObject.optString("type");
    o.d("MicroMsg.JsApiOperateLivePusher", "onOperateView operateType=%s", new Object[] { str });
    if (str.equalsIgnoreCase("snapshot")) {
      a((b)localObject, parame, paramj, paramJSONObject);
    } else if (str.equalsIgnoreCase("playBGM")) {
      a(parame, (b)localObject, paramJSONObject, paramj);
    } else if (((b)localObject).a(str, paramJSONObject)) {
      paramj.a(b("ok"));
    } else {
      paramj.a(b("fail"));
    }
    return super.a(parame, paramInt, paramView, paramJSONObject, paramj);
  }
  
  protected boolean f()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ky.f
 * JD-Core Version:    0.7.0.1
 */