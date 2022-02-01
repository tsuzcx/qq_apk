package com.tencent.luggage.wxa.kx;

import android.os.Bundle;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

public class d<CONTEXT extends c>
  extends a<CONTEXT>
{
  private static final int CTRL_INDEX = 340;
  private static final String NAME = "enableLocationUpdate";
  protected j a;
  
  protected Bundle a(CONTEXT paramCONTEXT, JSONObject paramJSONObject)
  {
    return null;
  }
  
  protected j b(CONTEXT paramCONTEXT)
  {
    return new j(paramCONTEXT);
  }
  
  public void b(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt)
  {
    o.d("MicroMsg.AppBrand.JsApiEnableLocationUpdate", "enableLocationUpdate:%s", new Object[] { paramJSONObject });
    this.a = ((j)paramCONTEXT.c(j.class));
    if (this.a == null)
    {
      this.a = b(paramCONTEXT);
      this.a.d();
      paramCONTEXT.a(this.a);
    }
    this.a.a(a(paramCONTEXT, paramJSONObject));
    this.a.g();
    paramCONTEXT.a(paramInt, b("ok"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kx.d
 * JD-Core Version:    0.7.0.1
 */