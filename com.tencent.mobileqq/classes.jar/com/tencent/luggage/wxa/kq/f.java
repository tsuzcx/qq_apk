package com.tencent.luggage.wxa.kq;

import android.content.Context;
import android.view.View;
import com.tencent.luggage.wxa.ja.d;
import com.tencent.luggage.wxa.ji.a;
import org.json.JSONObject;

public class f
  extends com.tencent.luggage.wxa.kd.b
{
  public static final int CTRL_INDEX = 67;
  public static final String NAME = "insertCanvas";
  
  protected int a(JSONObject paramJSONObject)
  {
    return paramJSONObject.getInt("canvasId");
  }
  
  protected View a(com.tencent.luggage.wxa.jx.e parame, JSONObject paramJSONObject)
  {
    paramJSONObject = parame.getContext();
    a locala = new a(paramJSONObject);
    locala.getDrawContext().a((com.tencent.luggage.wxa.ja.e)parame.a(com.tencent.luggage.wxa.ja.e.class));
    locala.getDrawContext().a(parame);
    locala.setContentDescription(paramJSONObject.getString(2131886746));
    parame.a(new f.1(this, locala));
    parame.a(new f.2(this, locala));
    return new com.tencent.luggage.wxa.kt.b(paramJSONObject, locala);
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
 * Qualified Name:     com.tencent.luggage.wxa.kq.f
 * JD-Core Version:    0.7.0.1
 */