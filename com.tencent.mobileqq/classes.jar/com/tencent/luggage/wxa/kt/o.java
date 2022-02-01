package com.tencent.luggage.wxa.kt;

import android.view.View;
import com.tencent.luggage.wxa.jx.e;
import com.tencent.luggage.wxa.kd.d;
import com.tencent.luggage.wxa.mn.c;
import com.tencent.luggage.wxa.mn.f;
import com.tencent.mm.plugin.appbrand.widget.g;
import org.json.JSONObject;

public class o
  extends d
{
  private static final int CTRL_INDEX = 254;
  public static final String NAME = "updateTextView";
  
  protected int a(JSONObject paramJSONObject)
  {
    return paramJSONObject.getInt("viewId");
  }
  
  protected boolean a(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    com.tencent.luggage.wxa.qz.o.e("MicroMsg.JsApiUpdateTextView", "onUpdateView(viewId : %s, %s)", new Object[] { Integer.valueOf(paramInt), paramJSONObject });
    if (!(paramView instanceof b))
    {
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.JsApiUpdateTextView", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    g localg = (g)((b)paramView).a(g.class);
    if (localg == null) {
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.JsApiUpdateTextView", "the target view(%s) is null", new Object[] { Integer.valueOf(paramInt) });
    }
    c.a(localg, paramJSONObject.optJSONObject("label"));
    f.a(paramView, paramJSONObject.optJSONObject("style"));
    return super.a(parame, paramInt, paramView, paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kt.o
 * JD-Core Version:    0.7.0.1
 */