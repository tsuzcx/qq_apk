package com.tencent.luggage.wxa.kt;

import android.view.View;
import com.tencent.luggage.wxa.jx.e;
import com.tencent.luggage.wxa.kd.d;
import com.tencent.luggage.wxa.mn.f;
import com.tencent.luggage.wxa.pc.g;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONException;
import org.json.JSONObject;

public class n
  extends d
{
  private static final int CTRL_INDEX = 447;
  public static final String NAME = "updateScrollView";
  
  protected int a(JSONObject paramJSONObject)
  {
    return paramJSONObject.getInt("viewId");
  }
  
  protected boolean a(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    o.e("MicroMsg.JsApiUpdateScrollView", "onUpdateView(viewId : %s, %s)", new Object[] { Integer.valueOf(paramInt), paramJSONObject });
    if (!(paramView instanceof t))
    {
      o.c("MicroMsg.JsApiUpdateScrollView", "the view(%s) is not a instance of WxaScrollView", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    t localt = (t)paramView;
    f.a(paramView, paramJSONObject.optJSONObject("style"));
    try
    {
      if (paramJSONObject.getBoolean("needScrollEvent")) {
        localt.setOnScrollChangedListener(new n.1(this, parame, paramJSONObject, paramInt));
      } else {
        localt.setOnScrollChangedListener(null);
      }
    }
    catch (JSONException localJSONException)
    {
      label103:
      boolean bool;
      int i;
      break label103;
    }
    paramJSONObject.optInt("scrollLeft", 0);
    if (paramJSONObject.has("scrollX"))
    {
      bool = paramJSONObject.optBoolean("scrollX", true);
      o.d("MicroMsg.JsApiUpdateScrollView", "scrollHorizontal:%b", new Object[] { Boolean.valueOf(bool) });
      localt.setScrollHorizontal(bool);
    }
    if (paramJSONObject.has("scrollY"))
    {
      bool = paramJSONObject.optBoolean("scrollY", true);
      o.d("MicroMsg.JsApiUpdateScrollView", "scrollVertical:%b", new Object[] { Boolean.valueOf(bool) });
      localt.setScrollVertical(bool);
    }
    if (paramJSONObject.has("scrollTop"))
    {
      i = g.a(paramJSONObject, "scrollTop", localt.getScrollY());
      o.d("MicroMsg.JsApiUpdateScrollView", "scrollTop:%d", new Object[] { Integer.valueOf(i) });
      localt.scrollTo(localt.getScrollX(), i);
    }
    return super.a(parame, paramInt, paramView, paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kt.n
 * JD-Core Version:    0.7.0.1
 */