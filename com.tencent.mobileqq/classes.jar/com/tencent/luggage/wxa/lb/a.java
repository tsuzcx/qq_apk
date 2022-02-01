package com.tencent.luggage.wxa.lb;

import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jx.h;
import com.tencent.luggage.wxa.ld.b;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

public class a
  extends b
{
  public static final int CTRL_INDEX = 467;
  public static final String NAME = "createLoadSubPackageTask";
  
  private void a(com.tencent.luggage.wxa.jx.c paramc, String paramString1, String paramString2)
  {
    a.a.a(paramc, paramString1, "fail", paramString2);
  }
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, String paramString)
  {
    h localh = (h)paramc;
    paramc = paramc.getAppId();
    paramJSONObject = paramJSONObject.optString("moduleName");
    if (af.c(paramJSONObject))
    {
      o.b("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: null or nil moduleName");
      a(localh, paramString, paramJSONObject);
      return;
    }
    Object localObject = localh.q();
    if ((localObject != null) && (!((d)localObject).au()))
    {
      localObject = ((d)localObject).am();
      if (localObject == null)
      {
        o.b("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: modularizingHelper null!");
        a(localh, paramString, paramJSONObject);
        return;
      }
      if ((!((com.tencent.luggage.wxa.ny.a)localObject).a()) && (!paramJSONObject.equals("__APP__")))
      {
        o.c("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: not support modularizing but still called JsApiCreateLoadSubPackageTask");
        a(localh, paramString, paramJSONObject);
        return;
      }
      try
      {
        ((com.tencent.luggage.wxa.ny.a)localObject).a(paramJSONObject, new a.1(this, paramc, paramJSONObject, localh, paramString), new a.2(this, paramJSONObject, localh, paramString), false);
        return;
      }
      catch (IllegalAccessError paramc)
      {
        o.a("MicroMsg.JsApiCreateLoadSubPackageTask", paramc, "loadModule(%s)", new Object[] { paramJSONObject });
        a(localh, paramString, paramJSONObject);
        return;
      }
    }
    o.b("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: runtime is not in valid state!");
    a(localh, paramString, paramJSONObject);
  }
  
  public String x_()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(com.tencent.luggage.wxa.nz.c.b().a());
    localStringBuilder.append("");
    return localStringBuilder.toString();
  }
  
  public String y_()
  {
    return "loadTaskId";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lb.a
 * JD-Core Version:    0.7.0.1
 */