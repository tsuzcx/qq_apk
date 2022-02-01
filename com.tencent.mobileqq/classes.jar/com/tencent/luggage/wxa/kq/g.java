package com.tencent.luggage.wxa.kq;

import android.graphics.Paint.FontMetrics;
import android.text.TextUtils;
import com.tencent.luggage.wxa.jf.a;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.jx.u;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class g
  extends u
{
  public static final int CTRL_INDEX = 436;
  public static final String NAME = "measureText";
  
  public String a(c paramc, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      o.b("MicroMsg.JsApiMeasureText", "measureText, data is null");
      return b("fail:data is null");
    }
    paramc = paramJSONObject.optString("text");
    float f1 = (float)paramJSONObject.optDouble("fontSize", 16.0D);
    o.d("MicroMsg.JsApiMeasureText", "measureText data:%s", new Object[] { paramJSONObject.toString() });
    a locala;
    if ((!TextUtils.isEmpty(paramc)) && (f1 > 0.0F))
    {
      locala = new a();
      locala.setTextSize(com.tencent.luggage.wxa.pc.g.b(f1));
    }
    try
    {
      locala.a(paramJSONObject.getString("fontFamily"));
    }
    catch (JSONException localJSONException1)
    {
      label102:
      int j;
      break label102;
    }
    o.d("MicroMsg.JsApiMeasureText", "get 'fontFamily' error");
    j = -1;
    try
    {
      String str = paramJSONObject.getString("fontStyle");
      i = str.hashCode();
      if (i != -1657669071)
      {
        if (i != -1178781136)
        {
          if ((i != -1039745817) || (!str.equals("normal"))) {
            break label504;
          }
          i = 2;
          break label507;
        }
        if (!str.equals("italic")) {
          break label504;
        }
        i = 1;
        break label507;
      }
      if (!str.equals("oblique")) {
        break label504;
      }
      i = 0;
    }
    catch (JSONException localJSONException2)
    {
      for (;;)
      {
        continue;
        int i = -1;
        if (i != 0) {
          if (i != 1) {
            if (i != 2)
            {
              continue;
              if (i != 0) {
                if (i == 1) {}
              }
            }
          }
        }
      }
    }
    locala.a(0);
    break label233;
    locala.a(2);
    break label233;
    locala.a(2);
    break label233;
    o.d("MicroMsg.JsApiMeasureText", "get 'fontStyle' error.");
    try
    {
      label233:
      paramJSONObject = paramJSONObject.getString("fontWeight");
      i = paramJSONObject.hashCode();
      if (i != -1039745817)
      {
        if (i != 3029637)
        {
          i = j;
        }
        else
        {
          i = j;
          if (paramJSONObject.equals("bold")) {
            i = 0;
          }
        }
      }
      else
      {
        i = j;
        if (paramJSONObject.equals("normal")) {
          i = 1;
        }
      }
    }
    catch (JSONException paramJSONObject)
    {
      label323:
      label330:
      float f2;
      break label323;
    }
    locala.setFakeBoldText(false);
    break label330;
    locala.setFakeBoldText(true);
    break label330;
    o.d("MicroMsg.JsApiMeasureText", "get 'fontWeight' error.");
    f2 = locala.measureText(paramc);
    paramc = locala.getFontMetrics();
    f1 = Math.abs(paramc.bottom - paramc.top);
    o.d("MicroMsg.JsApiMeasureText", "fontMetrics.bottom : %f, fontMetrics.top : %f, width : %f, height : %f", new Object[] { Float.valueOf(paramc.bottom), Float.valueOf(paramc.top), Float.valueOf(f2), Float.valueOf(f1) });
    f2 = com.tencent.luggage.wxa.pc.g.a(f2);
    f1 = com.tencent.luggage.wxa.pc.g.a(f1);
    paramc = new HashMap();
    paramc.put("width", Float.valueOf(f2));
    paramc.put("height", Float.valueOf(f1));
    o.d("MicroMsg.JsApiMeasureText", "map:%s", new Object[] { paramc.toString() });
    return a("ok", paramc);
    o.b("MicroMsg.JsApiMeasureText", "measureText, param is illegal");
    return b("fail:param is illegal");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kq.g
 * JD-Core Version:    0.7.0.1
 */