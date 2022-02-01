package com.tencent.luggage.wxa.mw;

import com.tencent.luggage.wxa.ju.c;
import org.json.JSONObject;

public class a
  extends c
{
  public int a(JSONObject paramJSONObject)
  {
    return paramJSONObject.optInt("cameraId");
  }
  
  public String c()
  {
    return "camera";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mw.a
 * JD-Core Version:    0.7.0.1
 */