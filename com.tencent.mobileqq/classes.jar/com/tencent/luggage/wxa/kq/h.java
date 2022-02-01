package com.tencent.luggage.wxa.kq;

import com.tencent.luggage.wxa.jx.e;
import com.tencent.luggage.wxa.kd.c;
import org.json.JSONObject;

public class h
  extends c<e>
{
  public static final int CTRL_INDEX = 68;
  public static final String NAME = "removeCanvas";
  
  protected int a(JSONObject paramJSONObject)
  {
    return paramJSONObject.optInt("canvasId");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kq.h
 * JD-Core Version:    0.7.0.1
 */