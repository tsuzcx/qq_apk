package com.tencent.luggage.wxa.ln;

import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.jx.a;
import org.json.JSONObject;

public class aa
  extends a<h>
{
  public static final int CTRL_INDEX = 418;
  public static final String NAME = "setTabBarItem";
  
  public void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    try
    {
      int i = paramJSONObject.getInt("index");
      String str = paramJSONObject.optString("text", null);
      paramJSONObject = new aa.1(this, paramh, paramInt, paramJSONObject.optString("iconPath", ""), i, str, paramJSONObject.optString("selectedIconPath", ""));
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
      label74:
      break label74;
    }
    paramh.a(paramInt, b("fail:invalid data"));
  }
  
  protected boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ln.aa
 * JD-Core Version:    0.7.0.1
 */