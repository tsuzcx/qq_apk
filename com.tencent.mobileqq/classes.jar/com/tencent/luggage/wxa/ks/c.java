package com.tencent.luggage.wxa.ks;

import org.json.JSONObject;

public class c
  extends com.tencent.luggage.wxa.kd.c
{
  public static final int CTRL_INDEX = 512;
  public static final String NAME = "removePositioningContainer";
  
  protected int a(JSONObject paramJSONObject)
  {
    return paramJSONObject.getInt("containerId");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ks.c
 * JD-Core Version:    0.7.0.1
 */