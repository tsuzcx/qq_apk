package com.tencent.luggage.wxa.cq;

import com.tencent.luggage.opensdk.f;
import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.jx.h;
import com.tencent.luggage.wxa.ro.d;
import org.json.JSONObject;

public class e
  extends f<b>
{
  public static final int CTRL_INDEX = 240;
  public static final String NAME = "shareAppMessageDirectly";
  private final g<h> a = new g();
  
  public final d<String> a(b paramb, JSONObject paramJSONObject, int paramInt)
  {
    return this.a.a(paramb, paramJSONObject, paramInt).a(new e.1(this, paramJSONObject, paramb, paramInt));
  }
  
  protected boolean k_()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cq.e
 * JD-Core Version:    0.7.0.1
 */