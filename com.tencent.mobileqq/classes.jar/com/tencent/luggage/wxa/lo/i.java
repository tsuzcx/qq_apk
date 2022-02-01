package com.tencent.luggage.wxa.lo;

import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandOptionsPickerV3;
import com.tencent.mm.plugin.appbrand.widget.picker.a;
import org.json.JSONArray;
import org.json.JSONObject;

final class i
  extends d
{
  private void a(String[] paramArrayOfString, int paramInt)
  {
    AppBrandOptionsPickerV3 localAppBrandOptionsPickerV3 = (AppBrandOptionsPickerV3)a(AppBrandOptionsPickerV3.class);
    if (localAppBrandOptionsPickerV3 == null)
    {
      a("fail cant init view");
      return;
    }
    a locala = c();
    locala.post(new i.3(this, locala));
    localAppBrandOptionsPickerV3.a(paramInt);
    localAppBrandOptionsPickerV3.a();
    localAppBrandOptionsPickerV3.a(paramArrayOfString);
    locala.setOnResultListener(new i.4(this, locala, localAppBrandOptionsPickerV3));
    locala.setHeader(this.a);
    locala.a();
  }
  
  void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
  }
  
  void b(JSONObject paramJSONObject)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray("array");
    int j = paramJSONObject.optInt("current", 0);
    if ((localJSONArray != null) && (localJSONArray.length() > 0))
    {
      paramJSONObject = new String[localJSONArray.length()];
      int i = 0;
      try
      {
        while (i < localJSONArray.length())
        {
          paramJSONObject[i] = localJSONArray.getString(i);
          i += 1;
        }
        a(new i.2(this, paramJSONObject, j));
        return;
      }
      catch (Exception paramJSONObject)
      {
        o.b("MicroMsg.AppBrand.JsApi.OptionsPickerHandler", "opt data.array, exp = %s", new Object[] { af.a(paramJSONObject) });
        a("fail", null);
        return;
      }
    }
    o.d("MicroMsg.AppBrand.JsApi.OptionsPickerHandler", "showPickerView as selector, empty range");
    a("ok", null);
    a(new i.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lo.i
 * JD-Core Version:    0.7.0.1
 */