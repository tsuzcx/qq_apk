package com.tencent.luggage.wxa.my;

import android.view.View;
import com.tencent.luggage.wxa.jx.e;
import com.tencent.luggage.wxa.kd.c;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

public class b
  extends c
{
  private static final int CTRL_INDEX = 673;
  public static final String NAME = "removeXWebCanvas";
  
  protected int a(JSONObject paramJSONObject)
  {
    return paramJSONObject.optInt("viewId");
  }
  
  protected boolean a(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    parame = (View)((com.tencent.luggage.wxa.kt.b)paramView).a(View.class);
    if ((parame != null) && ((parame instanceof d)))
    {
      ((d)parame).a();
      return true;
    }
    o.c("Luggage.JsApiRemoveXWebCanvasTextureView", "the skia canvas view(%s) is null", new Object[] { Integer.valueOf(paramInt) });
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.my.b
 * JD-Core Version:    0.7.0.1
 */