package com.tencent.luggage.wxa.ky;

import android.view.View;
import com.tencent.luggage.wxa.jx.e;
import com.tencent.luggage.wxa.kd.d;
import com.tencent.luggage.wxa.kt.b;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

public class i
  extends d
{
  private static final int CTRL_INDEX = 365;
  public static final String NAME = "updateLivePlayer";
  
  protected int a(JSONObject paramJSONObject)
  {
    return paramJSONObject.optInt("livePlayerId");
  }
  
  protected boolean a(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    o.d("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView : livePlayerId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof b))
    {
      o.c("MicroMsg.JsApiUpdateLivePlayer", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    parame = (View)((b)paramView).a(View.class);
    if (!(parame instanceof a))
    {
      o.b("MicroMsg.JsApiUpdateLivePlayer", "targetView not AppBrandLivePlayerView");
      return false;
    }
    ((a)parame).b(m.a(paramJSONObject));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ky.i
 * JD-Core Version:    0.7.0.1
 */