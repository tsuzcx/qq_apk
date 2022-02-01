package com.tencent.luggage.wxa.gh;

import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONException;
import org.json.JSONObject;

public class a$a
{
  public String a = "";
  public String b = "";
  public String c = "";
  public Integer d = null;
  public boolean e = false;
  public boolean f = false;
  public boolean g = false;
  
  public a$a(a parama, String paramString)
  {
    parama = new StringBuilder();
    parama.append("totalInfo:");
    parama.append(paramString);
    o.d("TextAreaInfo", parama.toString());
    this.a = paramString;
    label131:
    try
    {
      parama = new JSONObject(paramString);
    }
    catch (Exception parama)
    {
      label94:
      break label94;
    }
    o.b("TextAreaInfo", "TextAreaInfo convert to json error");
    parama = new JSONObject();
    try
    {
      if (!parama.has("element-tag")) {
        break label138;
      }
      this.b = parama.getString("element-tag");
    }
    catch (JSONException paramString)
    {
      break label131;
    }
    o.b("TextAreaInfo", "TextAreaInfo add elementTag error");
    label138:
    label160:
    label167:
    label196:
    label206:
    label216:
    label348:
    try
    {
      if (!parama.has("keyboard-type")) {
        break label167;
      }
      this.c = parama.getString("keyboard-type");
    }
    catch (JSONException paramString)
    {
      label223:
      label249:
      break label160;
    }
    o.b("TextAreaInfo", "TextAreaInfo add keyboardType error");
    try
    {
      if (!parama.has("cursor-spacing")) {
        break label223;
      }
      this.d = Integer.valueOf(af.a(parama.getString("cursor-spacing"), 0));
    }
    catch (JSONException paramString)
    {
      break label216;
    }
    catch (NumberFormatException paramString)
    {
      break label206;
    }
    catch (Exception paramString)
    {
      break label196;
    }
    o.b("TextAreaInfo", "TextAreaInfo get cursor-spacing parseInt error");
    break label223;
    o.b("TextAreaInfo", "TextAreaInfo get cursor-spacing parseInt error");
    break label223;
    o.b("TextAreaInfo", "TextAreaInfo get cursor-spacing error");
    try
    {
      if (!parama.has("show-confirm-bar")) {
        break label266;
      }
      this.e = af.a(parama.getString("show-confirm-bar"), false);
    }
    catch (JSONException paramString)
    {
      break label259;
    }
    catch (Exception paramString)
    {
      break label249;
    }
    o.b("TextAreaInfo", "TextAreaInfo get show-confirm-bar error");
    break label266;
    label259:
    o.b("TextAreaInfo", "TextAreaInfo get show-confirm-bar error");
    try
    {
      label266:
      if (!parama.has("password")) {
        break label309;
      }
      this.f = af.a(parama.getString("password"), false);
    }
    catch (JSONException paramString)
    {
      break label302;
    }
    catch (Exception paramString)
    {
      label292:
      break label292;
    }
    o.b("TextAreaInfo", "TextAreaInfo get password error");
    break label309;
    label302:
    o.b("TextAreaInfo", "TextAreaInfo get password error");
    try
    {
      label309:
      if (!parama.has("show-cover-view")) {
        break label348;
      }
      this.g = af.a(parama.getString("show-cover-view"), false);
      return;
    }
    catch (JSONException parama)
    {
      break label341;
    }
    catch (Exception parama)
    {
      label333:
      break label333;
    }
    o.b("TextAreaInfo", "TextAreaInfo get show-cover-view error");
    return;
    label341:
    o.b("TextAreaInfo", "TextAreaInfo get show-cover-view error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gh.a.a
 * JD-Core Version:    0.7.0.1
 */