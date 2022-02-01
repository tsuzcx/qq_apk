package com.tencent.luggage.wxa.ky;

import android.view.View;
import com.tencent.luggage.wxa.jx.e;
import com.tencent.luggage.wxa.kd.c;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

public class h
  extends c
{
  private static final int CTRL_INDEX = 362;
  public static final String NAME = "removeLivePusher";
  
  protected int a(JSONObject paramJSONObject)
  {
    return paramJSONObject.optInt("livePusherId");
  }
  
  protected boolean a(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    super.a(parame, paramInt, paramView, paramJSONObject);
    o.d("MicroMsg.JsApiRemoveLivePusher", "onRemoveView livePusherId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof com.tencent.luggage.wxa.kt.b))
    {
      o.c("MicroMsg.JsApiRemoveLivePusher", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    parame = (View)((com.tencent.luggage.wxa.kt.b)paramView).a(View.class);
    if (!(parame instanceof b))
    {
      o.b("MicroMsg.JsApiRemoveLivePusher", "targetView not AppBrandLivePusherView");
      return false;
    }
    ((b)parame).d();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ky.h
 * JD-Core Version:    0.7.0.1
 */