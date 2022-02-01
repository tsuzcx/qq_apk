package com.tencent.luggage.wxa.kp;

import android.view.View;
import com.tencent.luggage.wxa.kd.c;
import com.tencent.luggage.wxa.kt.b;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

public class m
  extends c
{
  private static final int CTRL_INDEX = 330;
  public static final String NAME = "removeCamera";
  
  protected int a(JSONObject paramJSONObject)
  {
    return paramJSONObject.optInt("cameraId", 0);
  }
  
  protected boolean a(com.tencent.luggage.wxa.jx.e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    super.a(parame, paramInt, paramView, paramJSONObject);
    o.d("MicroMsg.JsApiRemoveCamera", "onRemoveView cameraId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof b))
    {
      o.c("MicroMsg.JsApiRemoveCamera", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    paramView = (View)((b)paramView).a(View.class);
    if ((paramView != null) && ((paramView instanceof e)))
    {
      paramView = (e)paramView;
      parame.b(paramView);
      parame.b(paramView);
      parame.b(paramView);
      a.a().b(paramView.getCameraId());
      paramView.g();
      return true;
    }
    o.c("MicroMsg.JsApiRemoveCamera", "the camera view(%s) is null", new Object[] { Integer.valueOf(paramInt) });
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kp.m
 * JD-Core Version:    0.7.0.1
 */