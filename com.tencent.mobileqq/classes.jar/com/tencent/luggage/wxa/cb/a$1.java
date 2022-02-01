package com.tencent.luggage.wxa.cb;

import com.tencent.luggage.wxa.id.a.b;
import com.tencent.luggage.wxa.iu.c.c;
import com.tencent.luggage.wxa.iu.c.d;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.jx.m;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONException;
import org.json.JSONObject;

class a$1
  extends c.c
{
  a$1(a parama, a.b paramb, h paramh) {}
  
  public void a(c.d paramd)
  {
    String str = this.a.b("appId", "");
    this.a.a("pkgType", 0);
    int i = a.2.a[paramd.ordinal()];
    if ((i != 1) && (i != 2)) {
      return;
    }
    paramd = new JSONObject();
    try
    {
      paramd.put("operationType", "pause");
      label60:
      Object localObject = this.c;
      localObject = new a.d((m)localObject, this.b, a.d.a(a.a((a)localObject)));
      ((a.d)localObject).c = paramd.toString();
      ((a.d)localObject).d = str;
      ((a.d)localObject).a = this.a;
      ((a.d)localObject).g();
      return;
    }
    catch (JSONException localJSONException)
    {
      break label60;
    }
  }
  
  public void c()
  {
    o.e("MicroMsg.JsApiOperateMusicPlayer", "onDestroy");
    String str = this.a.b("appId", "");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("operationType", "stop");
      label36:
      Object localObject = this.c;
      localObject = new a.d((m)localObject, this.b, a.d.a(a.a((a)localObject)));
      ((a.d)localObject).c = localJSONObject.toString();
      ((a.d)localObject).d = str;
      ((a.d)localObject).g = -1;
      ((a.d)localObject).a = this.a;
      ((a.d)localObject).f();
      return;
    }
    catch (JSONException localJSONException)
    {
      break label36;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cb.a.1
 * JD-Core Version:    0.7.0.1
 */