package com.tencent.luggage.wxa.kt;

import android.view.View;
import com.tencent.luggage.wxa.id.a.b;
import com.tencent.luggage.wxa.jx.e;
import com.tencent.luggage.wxa.jx.e.a;
import com.tencent.luggage.wxa.mn.c;
import com.tencent.luggage.wxa.mn.f;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.widget.g;
import org.json.JSONObject;

public class h
  extends com.tencent.luggage.wxa.kd.b
{
  private static final int CTRL_INDEX = 253;
  public static final String NAME = "insertTextView";
  
  protected int a(JSONObject paramJSONObject)
  {
    return paramJSONObject.getInt("viewId");
  }
  
  protected View a(e parame, JSONObject paramJSONObject)
  {
    parame = parame.getContext();
    return new b(parame, new g(parame));
  }
  
  protected void a(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    o.e("MicroMsg.JsApiInsertTextView", "onInsertView(viewId : %s, %s)", new Object[] { Integer.valueOf(paramInt), paramJSONObject });
    b localb = (b)paramView;
    g localg = (g)localb.a(g.class);
    if (localg == null)
    {
      o.c("MicroMsg.JsApiInsertTextView", "onInsertView(viewId : %d) failed, targetView is null", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    boolean bool2 = paramJSONObject.optBoolean("clickable");
    boolean bool1 = paramJSONObject.optBoolean("transEvt");
    boolean bool3 = paramJSONObject.optBoolean("gesture");
    boolean bool4 = i(paramJSONObject);
    String str1 = paramJSONObject.optString("sendTo", "appservice");
    String str2 = paramJSONObject.optString("data", "");
    c.a(localg, paramJSONObject.optJSONObject("label"));
    com.tencent.luggage.wxa.mn.b.a(localg, paramJSONObject);
    f.a(paramView, paramJSONObject.optJSONObject("style"));
    a.b localb1 = parame.c(h(paramJSONObject)).a(paramInt, true);
    localb1.a("data", str2);
    localb1.a("sendTo", str1);
    localb1.a("transEvt", Boolean.valueOf(bool1));
    localb1.a("clickable", Boolean.valueOf(bool2));
    boolean bool5 = h(paramJSONObject);
    int i = -1;
    if (bool5)
    {
      int j = b(paramJSONObject);
      if (j != 0)
      {
        bool1 = parame.c(bool5).h(j);
        i = parame.c(bool5).i(j);
        break label288;
      }
    }
    bool1 = false;
    label288:
    o.d("MicroMsg.JsApiInsertTextView", "clickable:%b, gesture:%b, draggable:%b， independent:%b, isParentCanDrag:%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool1) });
    if ((bool5) && ((bool1) || (bool4)))
    {
      o.d("MicroMsg.JsApiInsertTextView", "CoverViewContainer setOnClickListener");
      if (bool2)
      {
        paramJSONObject = localb;
        paramJSONObject.a(paramInt, i);
        paramJSONObject.setIsInterceptEvent(true);
        paramJSONObject.setOnCustomerClickListener(new h.1(this, localb1, parame));
      }
      localb.setDragEventCallback(new h.2(this, localb1, parame));
    }
    else
    {
      o.d("MicroMsg.JsApiInsertTextView", "targetView setOnClickListener");
      localg.setOnClickListener(new h.3(this, localb1, parame));
      localg.setClickable(bool2);
    }
    if ((!bool2) && (bool3) && (!bool4))
    {
      paramView.setDuplicateParentStateEnabled(true);
      localg.setDuplicateParentStateEnabled(true);
      localg.setOnTouchListener(new h.4(this, localb1, parame, paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kt.h
 * JD-Core Version:    0.7.0.1
 */