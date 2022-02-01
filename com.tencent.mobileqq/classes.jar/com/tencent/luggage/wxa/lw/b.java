package com.tencent.luggage.wxa.lw;

import com.tencent.luggage.wxa.jj.l;
import com.tencent.luggage.wxa.jx.h;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import org.json.JSONObject;

public class b
  extends com.tencent.luggage.wxa.jx.a<h>
{
  public static final int CTRL_INDEX = 18;
  public static final String NAME = "clearStorage";
  
  private void a(h paramh, int paramInt)
  {
    d locald = new d();
    locald.a = paramh.getAppId();
    locald.b = paramInt;
    locald.g();
  }
  
  private void b(h paramh, int paramInt)
  {
    com.tencent.luggage.wxa.rd.a.b(new b.1(this, paramh, paramInt), "JsApiClearStorage");
  }
  
  public void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    int i = paramh.q().A().T;
    int j = paramJSONObject.optInt("storageId", 0);
    if (r.a(j))
    {
      paramh.a(paramInt, b("fail:nonexistent storage space"));
      return;
    }
    if (i == 2)
    {
      b(paramh, j);
    }
    else if (i == 3)
    {
      b(paramh, j);
      a(paramh, j);
    }
    else
    {
      a(paramh, j);
    }
    paramh.a(paramInt, b("ok"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lw.b
 * JD-Core Version:    0.7.0.1
 */