package com.tencent.luggage.wxa.kq;

import android.view.View;
import com.tencent.luggage.wxa.kd.d;
import com.tencent.luggage.wxa.kd.j;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONArray;
import org.json.JSONObject;

public class e
  extends d<com.tencent.luggage.wxa.jx.e>
{
  public static final int CTRL_INDEX = 69;
  public static final String NAME = "drawCanvas";
  
  protected int a(JSONObject paramJSONObject)
  {
    return paramJSONObject.getInt("canvasId");
  }
  
  protected boolean a(com.tencent.luggage.wxa.jx.e parame, int paramInt, View paramView, JSONObject paramJSONObject, j paramj)
  {
    if (!(paramView instanceof com.tencent.luggage.wxa.kt.b))
    {
      o.d("MicroMsg.JsApiDrawCanvas", "drawCanvas failed, view is not a instance of CoverViewContainer.(%s)", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    Object localObject = (View)((com.tencent.luggage.wxa.kt.b)paramView).a(View.class);
    o.e("MicroMsg.JsApiDrawCanvas", "drawCanvas(id : %s)", new Object[] { Integer.valueOf(paramInt) });
    if (!(localObject instanceof com.tencent.luggage.wxa.ji.b))
    {
      o.d("MicroMsg.JsApiDrawCanvas", "drawCanvas failed, view is not a instance of AppBrandDrawableView.(%s)", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    long l = System.currentTimeMillis();
    JSONArray localJSONArray = paramJSONObject.optJSONArray("actions");
    boolean bool = paramJSONObject.optBoolean("reserve");
    localObject = (com.tencent.luggage.wxa.ji.b)localObject;
    if (bool) {
      ((com.tencent.luggage.wxa.ji.b)localObject).b(localJSONArray, new e.1(this, paramj));
    } else {
      ((com.tencent.luggage.wxa.ji.b)localObject).a(localJSONArray, new e.2(this, paramj));
    }
    ((com.tencent.luggage.wxa.ji.b)localObject).b();
    o.f("MicroMsg.JsApiDrawCanvas", "post drawCanvas cost : %sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    return super.a(parame, paramInt, paramView, paramJSONObject, paramj);
  }
  
  protected boolean f()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kq.e
 * JD-Core Version:    0.7.0.1
 */