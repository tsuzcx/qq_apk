package com.tencent.luggage.wxa.ky;

import android.view.View;
import com.tencent.luggage.wxa.jx.e;
import com.tencent.luggage.wxa.kd.c;
import com.tencent.luggage.wxa.kt.b;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

public class g
  extends c
{
  private static final int CTRL_INDEX = 366;
  public static final String NAME = "removeLivePlayer";
  
  protected int a(JSONObject paramJSONObject)
  {
    return paramJSONObject.optInt("livePlayerId");
  }
  
  protected boolean a(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    super.a(parame, paramInt, paramView, paramJSONObject);
    o.d("MicroMsg.JsApiRemoveLivePlayer", "onRemoveView livePlayerId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof b))
    {
      o.c("MicroMsg.JsApiRemoveLivePlayer", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    parame = (View)((b)paramView).a(View.class);
    if (!(parame instanceof a))
    {
      o.b("MicroMsg.JsApiRemoveLivePlayer", "targetView not AppBrandLivePlayerView");
      return false;
    }
    ((a)parame).a();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ky.g
 * JD-Core Version:    0.7.0.1
 */