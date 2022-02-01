package com.tencent.luggage.wxa.cb;

import com.tencent.luggage.wxa.id.a.b;
import com.tencent.luggage.wxa.iu.c.c;
import com.tencent.luggage.wxa.iu.h;
import org.json.JSONObject;

public class a
  extends com.tencent.luggage.wxa.jx.a<h>
{
  public static final int CTRL_INDEX = 47;
  public static final String NAME = "operateMusicPlayer";
  private a.d a;
  
  public void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    this.a = new a.d(this, paramh, paramInt);
    ??? = new StringBuilder();
    ((StringBuilder)???).append("AppBrandService#");
    ((StringBuilder)???).append(paramh.hashCode());
    ??? = com.tencent.luggage.wxa.id.a.c(((StringBuilder)???).toString());
    synchronized (com.tencent.luggage.wxa.id.a.a().a((String)???, true))
    {
      if ((c.c)((a.b)???).b("AppBrandLifeCycle.Listener", null) == null)
      {
        ((a.b)???).a("appId", paramh.getAppId());
        a.1 local1 = new a.1(this, (a.b)???, paramh);
        ((a.b)???).a("AppBrandLifeCycle.Listener", local1);
        this.a.b = local1;
      }
      this.a.a = ((a.b)???);
      this.a.c = paramJSONObject.toString();
      this.a.d = paramh.getAppId();
      this.a.g();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cb.a
 * JD-Core Version:    0.7.0.1
 */