package com.tencent.luggage.wxa.lw;

import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jj.l;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.jx.h;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import org.json.JSONObject;

public class n
  extends com.tencent.luggage.wxa.jx.a<h>
{
  public static final int CTRL_INDEX = 98;
  public static final String NAME = "removeStorage";
  
  private void a(h paramh, String paramString, int paramInt)
  {
    p localp = new p();
    localp.a = a(paramh);
    localp.b = paramInt;
    localp.c = paramString;
    localp.g();
  }
  
  private void b(h paramh, String paramString, int paramInt)
  {
    com.tencent.luggage.wxa.rd.a.b(new n.1(this, paramh, paramInt, paramString), "JsApiRemoveStorage");
  }
  
  protected String a(c paramc)
  {
    return paramc.getAppId();
  }
  
  public void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    String str = paramJSONObject.optString("key");
    int i = paramJSONObject.optInt("storageId", 0);
    if (af.c(str))
    {
      paramh.a(paramInt, b("fail"));
      return;
    }
    if (r.a(i))
    {
      paramh.a(paramInt, b("fail:nonexistent storage space"));
      return;
    }
    paramJSONObject = paramh.q();
    if ((paramJSONObject != null) && (paramJSONObject.A() != null))
    {
      int j = paramJSONObject.A().T;
      if (j == 2)
      {
        b(paramh, str, i);
      }
      else if (j == 3)
      {
        a(paramh, str, i);
        b(paramh, str, i);
      }
      else
      {
        a(paramh, str, i);
      }
      paramh.a(paramInt, b("ok"));
      return;
    }
    paramh.a(paramInt, b("fail:internal error"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lw.n
 * JD-Core Version:    0.7.0.1
 */