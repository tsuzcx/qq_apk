package com.tencent.luggage.wxa.ct;

import android.view.View;
import com.tencent.luggage.wxa.jx.e;
import com.tencent.luggage.wxa.kd.c;
import org.json.JSONObject;

public class f
  extends c
{
  public static final int CTRL_INDEX = 299;
  public static final String NAME = "removeHTMLWebView";
  
  protected int a(JSONObject paramJSONObject)
  {
    return paramJSONObject.getInt("htmlId");
  }
  
  protected boolean a(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    if ((paramView instanceof a)) {
      ((a)paramView).d();
    }
    return super.a(parame, paramInt, paramView, paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ct.f
 * JD-Core Version:    0.7.0.1
 */