package com.tencent.luggage.wxa.kt;

import android.view.View;
import com.tencent.luggage.wxa.id.a.b;
import com.tencent.luggage.wxa.jx.e;
import com.tencent.luggage.wxa.jx.e.a;
import com.tencent.luggage.wxa.kd.b;
import com.tencent.luggage.wxa.mn.f;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

public class g
  extends b
{
  private static final int CTRL_INDEX = 446;
  public static final String NAME = "insertScrollView";
  
  protected int a(JSONObject paramJSONObject)
  {
    return paramJSONObject.getInt("viewId");
  }
  
  protected View a(e parame, JSONObject paramJSONObject)
  {
    return new t(parame.getContext());
  }
  
  protected void a(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    o.e("MicroMsg.JsApiInsertScrollView", "onInsertView(viewId : %s, %s)", new Object[] { Integer.valueOf(paramInt), paramJSONObject });
    t localt = (t)paramView;
    boolean bool1 = paramJSONObject.optBoolean("needScrollEvent");
    String str = paramJSONObject.optString("data", "");
    f.a(paramView, paramJSONObject.optJSONObject("style"));
    boolean bool2 = h(paramJSONObject);
    parame.c(bool2).a(paramInt, true).a("data", str);
    if (bool1) {
      localt.setOnScrollChangedListener(new g.1(this, parame, bool2, paramInt));
    }
    paramJSONObject.optInt("scrollLeft", 0);
    if (paramJSONObject.has("scrollX"))
    {
      bool1 = paramJSONObject.optBoolean("scrollX", true);
      o.d("MicroMsg.JsApiInsertScrollView", "scrollHorizontal:%b", new Object[] { Boolean.valueOf(bool1) });
      localt.setScrollHorizontal(bool1);
    }
    if (paramJSONObject.has("scrollY"))
    {
      bool1 = paramJSONObject.optBoolean("scrollY", true);
      o.d("MicroMsg.JsApiInsertScrollView", "scrollVertical:%b", new Object[] { Boolean.valueOf(bool1) });
      localt.setScrollVertical(bool1);
    }
    if (paramJSONObject.has("scrollTop"))
    {
      paramInt = com.tencent.luggage.wxa.pc.g.a(paramJSONObject, "scrollTop", localt.getScrollY());
      o.d("MicroMsg.JsApiInsertScrollView", "scrollTop:%d", new Object[] { Integer.valueOf(paramInt) });
      localt.postDelayed(new g.2(this, localt, paramInt), 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kt.g
 * JD-Core Version:    0.7.0.1
 */