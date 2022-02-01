package com.tencent.luggage.wxa.cq;

import com.tencent.luggage.opensdk.f;
import com.tencent.luggage.wxa.du.c;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

public class d
  extends f<c>
{
  public static final int CTRL_INDEX = 73;
  public static final String NAME = "shareAppMessage";
  private final g<c> a = new g();
  
  public final com.tencent.luggage.wxa.ro.d<String> a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    return this.a.a(paramc, paramJSONObject, paramInt).a(new d.1(this, paramJSONObject, paramc, paramInt));
  }
  
  protected String a(String paramString)
  {
    paramString = paramString.replace("shareAppMessageDirectly", "shareAppMessage");
    o.e("Luggage.JsApiShareAppMessage", "result:%s", new Object[] { paramString });
    return paramString;
  }
  
  protected boolean k_()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cq.d
 * JD-Core Version:    0.7.0.1
 */