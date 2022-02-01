package com.tencent.luggage.wxa.bn;

import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

public class a
  extends com.tencent.luggage.wxa.jx.a<h>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "logInJava";
  
  public void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    try
    {
      paramInt = paramJSONObject.getInt("level");
      paramh = paramJSONObject.getString("logs");
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3)
            {
              o.e("MicroMsg.JsApiLogInJava", paramh);
              return;
            }
            o.b("MicroMsg.JsApiLogInJava", paramh);
            return;
          }
          o.c("MicroMsg.JsApiLogInJava", paramh);
          return;
        }
        o.d("MicroMsg.JsApiLogInJava", paramh);
        return;
      }
      o.e("MicroMsg.JsApiLogInJava", paramh);
      return;
    }
    catch (Exception paramh)
    {
      o.b("MicroMsg.JsApiLogInJava", paramh.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bn.a
 * JD-Core Version:    0.7.0.1
 */