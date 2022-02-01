package com.tencent.luggage.wxa.kt;

import android.content.Context;
import android.content.res.Resources;
import android.text.StaticLayout;
import com.tencent.luggage.wxa.jx.u;
import com.tencent.luggage.wxa.pc.g;
import java.util.HashMap;
import org.json.JSONObject;

public class i
  extends u<com.tencent.luggage.wxa.jx.c>
{
  private static final int CTRL_INDEX = -2;
  private static final String NAME = "measureTextString";
  
  public String a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject.optJSONObject("size");
    paramJSONObject = paramJSONObject.optJSONObject("label");
    if ((localJSONObject != null) && (paramJSONObject != null))
    {
      int i = localJSONObject.optInt("width", 2147483647);
      int j = localJSONObject.optInt("height", 2147483647);
      if (paramc.getContext() == null) {
        paramc = Resources.getSystem();
      } else {
        paramc = paramc.getContext().getResources();
      }
      paramc = new a(paramc, i);
      com.tencent.luggage.wxa.mn.c.a(paramc, paramJSONObject);
      paramc = paramc.a();
      float f1 = 0.0F;
      i = 0;
      while (i < paramc.getLineCount())
      {
        f1 = Math.max(f1, paramc.getLineWidth(i));
        i += 1;
      }
      float f2 = Math.min(paramc.getHeight(), j);
      paramc = new HashMap(2);
      paramc.put("width", Float.valueOf(g.a(f1)));
      paramc.put("height", Float.valueOf(g.a(f2)));
      return a("ok", new i.1(this, paramc));
    }
    return b("fail:invalid data");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kt.i
 * JD-Core Version:    0.7.0.1
 */