package com.tencent.luggage.wxa.kt;

import android.content.Context;
import android.view.View;
import android.widget.ImageView.ScaleType;
import com.tencent.luggage.wxa.id.a.b;
import com.tencent.luggage.wxa.jx.e.a;
import com.tencent.luggage.wxa.po.a;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

public class f
  extends com.tencent.luggage.wxa.kd.b
{
  private static final int CTRL_INDEX = 253;
  public static final String NAME = "insertImageView";
  
  protected int a(JSONObject paramJSONObject)
  {
    return paramJSONObject.getInt("viewId");
  }
  
  protected View a(com.tencent.luggage.wxa.jx.e parame, JSONObject paramJSONObject)
  {
    Context localContext = parame.getContext();
    if (com.tencent.luggage.wxa.ba.e.a(com.tencent.luggage.wxa.po.b.class) != null) {
      parame = ((com.tencent.luggage.wxa.po.b)com.tencent.luggage.wxa.ba.e.a(com.tencent.luggage.wxa.po.b.class)).a(localContext);
    } else {
      parame = null;
    }
    paramJSONObject = parame;
    if (parame == null)
    {
      o.b("MicroMsg.JsApiInsertImageView", "view is null, may not support IGifCoverViewFactory.");
      paramJSONObject = new com.tencent.luggage.wxa.po.e(localContext);
    }
    paramJSONObject.setScaleType(ImageView.ScaleType.FIT_XY);
    return new b(localContext, paramJSONObject.getView());
  }
  
  protected void a(com.tencent.luggage.wxa.jx.e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    o.e("MicroMsg.JsApiInsertImageView", "onInsertView(viewId : %s, %s)", new Object[] { Integer.valueOf(paramInt), paramJSONObject });
    b localb = (b)paramView;
    a locala = (a)localb.a(a.class);
    if (locala == null)
    {
      o.c("MicroMsg.JsApiInsertImageView", "onInsertView(viewId : %d) failed, targetView is null", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    boolean bool2 = paramJSONObject.optBoolean("clickable");
    boolean bool3 = paramJSONObject.optBoolean("gesture");
    boolean bool4 = i(paramJSONObject);
    boolean bool1 = paramJSONObject.optBoolean("transEvt");
    String str1 = paramJSONObject.optString("sendTo", "appservice");
    String str2 = paramJSONObject.optString("data", "");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("style");
    a.b localb1 = parame.c(h(paramJSONObject)).a(paramInt, true);
    localb1.a("data", str2);
    localb1.a("sendTo", str1);
    localb1.a("transEvt", Boolean.valueOf(bool1));
    localb1.a("clickable", Boolean.valueOf(bool2));
    locala.setKeyValueSet(localb1);
    com.tencent.luggage.wxa.mn.f.a(paramView, localJSONObject);
    com.tencent.luggage.wxa.mn.c.a(parame, paramInt, locala, paramJSONObject, new c(paramInt, localb1, parame));
    com.tencent.luggage.wxa.mn.b.a(locala.getView(), paramJSONObject);
    boolean bool5 = h(paramJSONObject);
    int i;
    if (bool5)
    {
      i = b(paramJSONObject);
      if (i != 0)
      {
        bool1 = parame.c(bool5).h(i);
        i = parame.c(bool5).i(i);
      }
      else
      {
        i = -1;
        bool1 = false;
      }
      localb1.a("sendTo", "appservice");
    }
    else
    {
      i = -1;
      bool1 = false;
    }
    o.d("MicroMsg.JsApiInsertImageView", "clickable:%b, gesture:%b, draggable:%b， independent:%b, isParentCanDrag:%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool1) });
    if ((bool5) && ((bool1) || (bool4)))
    {
      o.d("MicroMsg.JsApiInsertImageView", "CoverViewContainer setOnClickListener");
      if (bool2)
      {
        paramJSONObject = localb;
        paramJSONObject.a(paramInt, i);
        paramJSONObject.setIsInterceptEvent(true);
        paramJSONObject.setOnCustomerClickListener(new f.1(this, localb1, parame));
      }
      localb.setDragEventCallback(new f.2(this, localb1, parame));
    }
    else
    {
      o.d("MicroMsg.JsApiInsertImageView", "targetView setOnClickListener");
      locala.getView().setOnClickListener(new f.3(this, localb1, parame));
      locala.getView().setClickable(bool2);
    }
    o.d("MicroMsg.JsApiInsertImageView", "clickable:%b, gesture:%b, draggable:%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
    if ((!bool2) && (bool3) && (!bool4))
    {
      paramView.setDuplicateParentStateEnabled(true);
      locala.getView().setDuplicateParentStateEnabled(true);
      locala.getView().setOnTouchListener(new f.4(this, localb1, parame, paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kt.f
 * JD-Core Version:    0.7.0.1
 */