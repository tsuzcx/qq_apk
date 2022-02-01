package com.tencent.luggage.wxa.cn;

import com.tencent.mm.plugin.appbrand.page.u;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

public final class a
  extends com.tencent.luggage.wxa.jx.a<u>
{
  private static final int CTRL_INDEX = 280;
  private static final String NAME = "getRegionData";
  private static final AtomicReference<String> a = new AtomicReference();
  
  public void a(u paramu, JSONObject paramJSONObject, int paramInt)
  {
    com.tencent.luggage.wxa.rd.a.b(new a.1(this, new WeakReference(paramu), paramInt), "LuggageJsApiGetRegionData");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cn.a
 * JD-Core Version:    0.7.0.1
 */