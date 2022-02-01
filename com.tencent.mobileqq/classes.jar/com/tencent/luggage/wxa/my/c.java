package com.tencent.luggage.wxa.my;

import com.tencent.luggage.wxa.kd.d;
import org.json.JSONObject;

public class c
  extends d
{
  private static final int CTRL_INDEX = 674;
  public static final String NAME = "updateXWebCanvas";
  
  protected int a(JSONObject paramJSONObject)
  {
    return paramJSONObject.optInt("viewId");
  }
  
  protected boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.my.c
 * JD-Core Version:    0.7.0.1
 */