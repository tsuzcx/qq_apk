package com.tencent.luggage.wxa.jx;

import com.tencent.luggage.wxa.ob.b;
import com.tencent.luggage.wxa.qw.lg;
import com.tencent.luggage.wxa.qw.lh;
import com.tencent.luggage.wxa.ro.d;
import org.json.JSONObject;

public class an
  extends a
{
  public static final int CTRL_INDEX = 236;
  public static final String NAME = "getSetting";
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = new lg();
    paramJSONObject.a = paramc.getAppId();
    ((b)paramc.a(b.class)).b("/cgi-bin/mmbiz-bin/wxaapp_getauthinfo", paramJSONObject.a, paramJSONObject, lh.class).a(new an.1(this, paramc, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.an
 * JD-Core Version:    0.7.0.1
 */