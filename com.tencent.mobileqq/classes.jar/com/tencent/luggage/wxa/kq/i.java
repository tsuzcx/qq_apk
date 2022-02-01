package com.tencent.luggage.wxa.kq;

import com.tencent.luggage.wxa.kd.d;
import org.json.JSONObject;

public class i
  extends d
{
  public static final int CTRL_INDEX = 83;
  public static final String NAME = "updateCanvas";
  
  protected int a(JSONObject paramJSONObject)
  {
    return paramJSONObject.optInt("canvasId");
  }
  
  protected boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kq.i
 * JD-Core Version:    0.7.0.1
 */