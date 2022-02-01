package com.tencent.luggage.wxa.my;

import android.content.Context;
import android.view.View;
import com.tencent.luggage.wxa.jx.e;
import com.tencent.luggage.wxa.kd.j;
import com.tencent.luggage.wxa.mx.c;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends com.tencent.luggage.wxa.kd.b
{
  private static final int CTRL_INDEX = 672;
  public static final String NAME = "insertXWebCanvas";
  
  protected int a(JSONObject paramJSONObject)
  {
    return paramJSONObject.getInt("viewId");
  }
  
  protected View a(e parame, JSONObject paramJSONObject)
  {
    Context localContext = parame.getContext();
    try
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject("position");
      localJSONObject.optInt("width", 300);
      localJSONObject.optInt("height", 150);
      paramJSONObject = new d(localContext, c.a(parame), a(paramJSONObject), parame.getAppId());
      parame.a(new a.1(this, paramJSONObject));
      parame.a(new a.2(this, paramJSONObject));
      parame.a(new a.3(this, paramJSONObject));
      return new com.tencent.luggage.wxa.kt.b(localContext, paramJSONObject);
    }
    catch (JSONException parame)
    {
      o.h("Luggage.JsApiInsertXWebCanvasTextureView", "insertXWebCanvas fail: %s", new Object[] { parame });
    }
    return null;
  }
  
  protected void a(e parame, int paramInt, View paramView, JSONObject paramJSONObject, j paramj)
  {
    ((d)((com.tencent.luggage.wxa.kt.b)paramView).a(d.class)).setOnReadyListener(new a.4(this, paramj));
  }
  
  protected boolean c()
  {
    return true;
  }
  
  protected boolean f()
  {
    return true;
  }
  
  protected boolean g()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.my.a
 * JD-Core Version:    0.7.0.1
 */