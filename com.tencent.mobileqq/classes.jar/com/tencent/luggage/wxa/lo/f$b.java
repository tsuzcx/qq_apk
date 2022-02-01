package com.tencent.luggage.wxa.lo;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPickerV2;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPickerV2.a;
import com.tencent.mm.plugin.appbrand.widget.picker.a;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

final class f$b
  extends d
  implements Runnable
{
  private final AtomicReference<AppBrandMultiOptionsPickerV2.a[]> b = new AtomicReference();
  
  void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    JSONArray localJSONArray1 = paramJSONObject.optJSONArray("array");
    paramJSONObject = paramJSONObject.optJSONArray("current");
    if ((localJSONArray1 != null) && (paramJSONObject != null) && (localJSONArray1.length() == paramJSONObject.length())) {
      if (localJSONArray1.length() <= 0)
      {
        a("ok");
        o.d("MicroMsg.JsApiShowMultiPickerView", "showMultiPickerView , empty range (one-dimensional)");
        a(new f.b.1(this));
        return;
      }
    }
    for (;;)
    {
      int i;
      int j;
      try
      {
        AppBrandMultiOptionsPickerV2.a[] arrayOfa = new AppBrandMultiOptionsPickerV2.a[localJSONArray1.length()];
        i = 0;
        j = 1;
        if (i < localJSONArray1.length())
        {
          JSONArray localJSONArray2 = localJSONArray1.getJSONArray(i);
          arrayOfa[i] = f.a(localJSONArray2, paramJSONObject.getInt(i));
          if (localJSONArray2.length() > 0) {
            break label209;
          }
          k = 1;
          break label212;
        }
        if (j != 0)
        {
          a("ok");
          o.d("MicroMsg.JsApiShowMultiPickerView", "showMultiPickerView , empty range (multi-dimensional)");
          a(new f.b.2(this));
          return;
        }
        this.b.set(arrayOfa);
        a(this);
        return;
      }
      catch (Exception paramJSONObject)
      {
        o.a("MicroMsg.JsApiShowMultiPickerView", paramJSONObject, "opt params", new Object[0]);
        a("fail:invalid data");
        return;
      }
      a("fail:invalid data");
      return;
      label209:
      int k = 0;
      label212:
      j &= k;
      i += 1;
    }
  }
  
  void b(JSONObject paramJSONObject) {}
  
  public void run()
  {
    AppBrandMultiOptionsPickerV2 localAppBrandMultiOptionsPickerV2 = (AppBrandMultiOptionsPickerV2)a(AppBrandMultiOptionsPickerV2.class);
    if (localAppBrandMultiOptionsPickerV2 == null)
    {
      a("fail cant init view");
      return;
    }
    AppBrandMultiOptionsPickerV2.a[] arrayOfa = (AppBrandMultiOptionsPickerV2.a[])this.b.get();
    if ((arrayOfa != null) && (arrayOfa.length > 0))
    {
      localAppBrandMultiOptionsPickerV2.a(arrayOfa);
      c().setOnResultListener(new f.b.3(this));
      c().setOnValueUpdateListener(new f.b.4(this));
      c().setHeader(this.a);
      c().a();
      return;
    }
    a("fail error data");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lo.f.b
 * JD-Core Version:    0.7.0.1
 */