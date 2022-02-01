package com.tencent.luggage.wxa.ln;

import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.ri.a.a;
import com.tencent.luggage.wxa.rj.b;
import org.json.JSONObject;

public class z
  extends com.tencent.luggage.wxa.jx.a<h>
{
  public static final int CTRL_INDEX = 389;
  public static final String NAME = "setTabBarBadge";
  
  public void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    try
    {
      int i = paramJSONObject.getInt("index");
      String str2 = paramJSONObject.optString("type", "none");
      String str1 = paramJSONObject.optString("badgeValue", "");
      String str3 = paramJSONObject.optString("badgeColor", "");
      String str4 = paramJSONObject.optString("badgeTextColor", "");
      paramJSONObject = new com.tencent.luggage.wxa.qt.a();
      paramJSONObject.a = false;
      b.a(str1).a(a.a.b).b(4).a(true).a(new z.1(this, paramJSONObject));
      if (paramJSONObject.a) {
        paramJSONObject = "…";
      } else {
        paramJSONObject = str1;
      }
      paramJSONObject = new z.2(this, paramh, paramInt, i, str2, paramJSONObject, str3, str4);
      if (!paramh.q().F())
      {
        paramJSONObject.run();
        return;
      }
      paramh.q().c(paramJSONObject);
      return;
    }
    catch (Exception paramJSONObject)
    {
      label154:
      break label154;
    }
    paramh.a(paramInt, b("fail"));
  }
  
  protected boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ln.z
 * JD-Core Version:    0.7.0.1
 */