package com.tencent.luggage.wxa.lo;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPickerV2.a;
import org.json.JSONArray;
import org.json.JSONObject;

class h$1
  extends d
{
  h$1(h paramh) {}
  
  void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
  }
  
  void b(JSONObject paramJSONObject)
  {
    int j = paramJSONObject.optInt("column", -1);
    JSONArray localJSONArray = paramJSONObject.optJSONArray("array");
    if ((j >= 0) && (localJSONArray != null) && (localJSONArray.length() >= 0)) {
      try
      {
        String[] arrayOfString = new String[localJSONArray.length()];
        int i = 0;
        while (i < arrayOfString.length)
        {
          arrayOfString[i] = localJSONArray.getString(i);
          i += 1;
        }
        paramJSONObject = new AppBrandMultiOptionsPickerV2.a(arrayOfString, paramJSONObject.optInt("current", 0));
        a(new h.1.1(this, j, paramJSONObject));
        return;
      }
      catch (Exception paramJSONObject)
      {
        o.a("MicroMsg.AppBrand.JsApiUpdateMultiPickerView", paramJSONObject, "opt params", new Object[0]);
        a("fail:invalid data");
        return;
      }
    }
    a("fail:invalid data");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lo.h.1
 * JD-Core Version:    0.7.0.1
 */