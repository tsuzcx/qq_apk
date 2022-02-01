package com.tencent.luggage.wxa.jz;

import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.jx.c;
import org.json.JSONObject;

public class j
  extends a<c>
{
  public static final int CTRL_INDEX = 46;
  public static final String NAME = "getMusicPlayerState";
  private j.a a;
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    this.a = new j.a(this, paramc, paramInt);
    this.a.a = paramc.getAppId();
    this.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jz.j
 * JD-Core Version:    0.7.0.1
 */