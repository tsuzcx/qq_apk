package com.tencent.luggage.wxa.mh;

import android.view.View;
import com.tencent.luggage.wxa.jx.e;
import com.tencent.luggage.wxa.kd.c;
import com.tencent.luggage.wxa.kt.b;
import com.tencent.luggage.wxa.ma.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.t;
import org.json.JSONObject;

public class d
  extends c
{
  private static final int CTRL_INDEX = 7;
  public static final String NAME = "removeVideoPlayer";
  
  protected int a(JSONObject paramJSONObject)
  {
    return paramJSONObject.optInt("videoPlayerId", 0);
  }
  
  protected boolean a(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    o.d("MicroMsg.JsApiRemoveVideoPlayer", "onRemoveView videoPlayerId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof b))
    {
      o.c("MicroMsg.JsApiRemoveVideoPlayer", "view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    a locala = (a)((b)paramView).a(a.class);
    if (locala == null)
    {
      o.c("MicroMsg.JsApiRemoveVideoPlayer", "view not AppBrandVideoView");
      return false;
    }
    t.a(new d.1(this, locala));
    super.a(parame, paramInt, paramView, paramJSONObject);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mh.d
 * JD-Core Version:    0.7.0.1
 */