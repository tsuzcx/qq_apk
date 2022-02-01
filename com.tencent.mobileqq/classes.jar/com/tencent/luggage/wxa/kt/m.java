package com.tencent.luggage.wxa.kt;

import android.view.View;
import com.tencent.luggage.wxa.jx.e;
import com.tencent.luggage.wxa.kd.d;
import com.tencent.luggage.wxa.mn.f;
import com.tencent.luggage.wxa.po.a;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

public class m
  extends d
{
  private static final int CTRL_INDEX = 254;
  public static final String NAME = "updateImageView";
  
  protected int a(JSONObject paramJSONObject)
  {
    return paramJSONObject.getInt("viewId");
  }
  
  protected boolean a(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    o.e("MicroMsg.JsApiUpdateImageView", "onUpdateView(viewId : %s, %s)", new Object[] { Integer.valueOf(paramInt), paramJSONObject });
    if (!(paramView instanceof b))
    {
      o.c("MicroMsg.JsApiUpdateImageView", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    a locala = (a)((b)paramView).a(a.class);
    if (locala == null)
    {
      o.c("MicroMsg.JsApiUpdateImageView", "the target view(%s) is null", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    f.a(paramView, paramJSONObject.optJSONObject("style"));
    com.tencent.luggage.wxa.mn.c.a(parame, paramInt, locala, paramJSONObject, new c(paramInt, locala.getKeyValueSet(), parame));
    return super.a(parame, paramInt, paramView, paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kt.m
 * JD-Core Version:    0.7.0.1
 */