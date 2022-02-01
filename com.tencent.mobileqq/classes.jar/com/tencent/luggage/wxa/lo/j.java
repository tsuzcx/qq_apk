package com.tencent.luggage.wxa.lo;

import com.tencent.luggage.wxa.qz.af;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandTimePickerV2;
import com.tencent.mm.plugin.appbrand.widget.picker.a;
import com.tencent.mm.plugin.appbrand.widget.picker.e;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class j
  extends d
{
  private int b = -1;
  private int c = -1;
  private int d = 2147483647;
  private int e = 2147483647;
  private int f = -1;
  private int g = -1;
  
  private void a(boolean paramBoolean, String paramString)
  {
    if (c() != null) {
      c().b();
    }
    if (!paramBoolean)
    {
      a("fail cancel", null);
      return;
    }
    if (af.c(paramString))
    {
      a("fail", null);
      return;
    }
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("value", paramString);
    a("ok", localHashMap);
  }
  
  private void d()
  {
    AppBrandTimePickerV2 localAppBrandTimePickerV2 = (AppBrandTimePickerV2)a(AppBrandTimePickerV2.class);
    if (localAppBrandTimePickerV2 == null)
    {
      a("fail cant init view");
      return;
    }
    a locala = c();
    localAppBrandTimePickerV2.setMinTime(this.b, this.c);
    localAppBrandTimePickerV2.setMaxTime(this.d, this.e);
    localAppBrandTimePickerV2.init(this.f, this.g);
    locala.setOnResultListener(new j.2(this));
    locala.setHeader(this.a);
    locala.a();
  }
  
  void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
  }
  
  void b(JSONObject paramJSONObject)
  {
    Object localObject2 = paramJSONObject.optJSONObject("range");
    if (localObject2 != null)
    {
      Object localObject1 = ((JSONObject)localObject2).optString("start");
      localObject2 = ((JSONObject)localObject2).optString("end");
      localObject1 = e.a((String)localObject1);
      if (localObject1 != null)
      {
        this.b = localObject1[0];
        this.c = localObject1[1];
      }
      localObject1 = e.a((String)localObject2);
      if (localObject1 != null)
      {
        this.d = localObject1[0];
        this.e = localObject1[1];
      }
    }
    this.b = Math.max(this.b, 0);
    this.c = Math.max(this.c, 0);
    this.d = Math.min(this.d, 23);
    this.e = Math.min(this.e, 59);
    paramJSONObject = e.a(paramJSONObject.optString("current"));
    if (paramJSONObject != null)
    {
      this.f = paramJSONObject[0];
      this.g = paramJSONObject[1];
    }
    a(new j.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lo.j
 * JD-Core Version:    0.7.0.1
 */