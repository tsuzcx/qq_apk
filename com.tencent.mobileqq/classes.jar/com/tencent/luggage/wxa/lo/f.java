package com.tencent.luggage.wxa.lo;

import com.tencent.luggage.wxa.jx.e;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPickerV2.a;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f
  extends a
{
  private static final int CTRL_INDEX = 257;
  private static final String NAME = "showMultiPickerView";
  
  private static AppBrandMultiOptionsPickerV2.a b(JSONArray paramJSONArray, int paramInt)
  {
    String[] arrayOfString = new String[paramJSONArray.length()];
    int i = 0;
    while (i < arrayOfString.length)
    {
      arrayOfString[i] = paramJSONArray.getString(i);
      i += 1;
    }
    return new AppBrandMultiOptionsPickerV2.a(arrayOfString, paramInt);
  }
  
  public void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    if (c()) {
      new f.b(null).a(this, parame, paramJSONObject, paramInt, c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lo.f
 * JD-Core Version:    0.7.0.1
 */