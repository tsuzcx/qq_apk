package com.tencent.luggage.wxa.kt;

import android.view.View;
import com.tencent.luggage.wxa.jx.e;
import com.tencent.luggage.wxa.jx.e.a;
import com.tencent.luggage.wxa.kd.c;
import org.json.JSONObject;

public class k
  extends c
{
  private static final int CTRL_INDEX = 448;
  public static final String NAME = "removeScrollView";
  
  protected int a(JSONObject paramJSONObject)
  {
    return paramJSONObject.getInt("viewId");
  }
  
  protected boolean a(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    parame.c(h(paramJSONObject)).a(paramInt);
    return super.a(parame, paramInt, paramView, paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kt.k
 * JD-Core Version:    0.7.0.1
 */