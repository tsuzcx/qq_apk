package com.tencent.luggage.wxa.lo;

import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.n;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandDatePickerV2;
import com.tencent.mm.plugin.appbrand.widget.picker.a;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class b
  extends d
{
  private volatile b.a b;
  private volatile Long c = null;
  private volatile Long d = null;
  private volatile int e = -1;
  private volatile int f = -1;
  private volatile int g = -1;
  
  private void a(boolean paramBoolean, String paramString)
  {
    if (c() == null) {
      return;
    }
    if (!paramBoolean) {
      a("fail cancel", null);
    }
    if (af.c(paramString))
    {
      a("fail", null);
    }
    else
    {
      HashMap localHashMap = new HashMap(1);
      localHashMap.put("value", paramString);
      a("ok", localHashMap);
    }
    c().b();
  }
  
  private void d()
  {
    AppBrandDatePickerV2 localAppBrandDatePickerV2 = (AppBrandDatePickerV2)a(AppBrandDatePickerV2.class);
    if (localAppBrandDatePickerV2 == null)
    {
      a("fail cant init view");
      return;
    }
    a locala = c();
    locala.setOnResultListener(new b.2(this));
    if (this.c != null) {
      localAppBrandDatePickerV2.b(this.c);
    }
    if (this.d != null) {
      localAppBrandDatePickerV2.a(this.d);
    }
    int i = this.e;
    int j = this.f;
    int k = this.g;
    int m = this.b.ordinal();
    int n = b.a.a.ordinal();
    boolean bool3 = true;
    boolean bool1;
    if (m >= n) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if (this.b.ordinal() >= b.a.b.ordinal()) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if (this.b.ordinal() < b.a.c.ordinal()) {
      bool3 = false;
    }
    localAppBrandDatePickerV2.a(i, j, k, bool1, bool2, bool3);
    locala.setHeader(this.a);
    locala.a();
  }
  
  void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
  }
  
  void b(JSONObject paramJSONObject)
  {
    this.b = b.a.a(paramJSONObject.optString("fields"));
    Object localObject2 = paramJSONObject.optJSONObject("range");
    if (localObject2 != null)
    {
      localObject1 = ((JSONObject)localObject2).optString("start", "");
      localObject1 = this.b.b((String)localObject1);
      localObject2 = ((JSONObject)localObject2).optString("end", "");
      localObject2 = this.b.b((String)localObject2);
      if (localObject1 != null) {
        this.c = Long.valueOf(((Date)localObject1).getTime());
      }
      if (localObject2 != null) {
        this.d = Long.valueOf(((Date)localObject2).getTime());
      }
    }
    if (this.c == null)
    {
      localObject1 = Calendar.getInstance(n.a);
      ((Calendar)localObject1).set(1900, 0, 1);
      this.c = Long.valueOf(((Calendar)localObject1).getTimeInMillis());
    }
    if (this.d == null)
    {
      localObject1 = Calendar.getInstance(n.a);
      ((Calendar)localObject1).set(2100, 11, 31);
      this.d = Long.valueOf(((Calendar)localObject1).getTimeInMillis());
    }
    paramJSONObject = paramJSONObject.optString("current", "");
    Object localObject1 = this.b.b(paramJSONObject);
    paramJSONObject = (JSONObject)localObject1;
    if (localObject1 == null)
    {
      localObject1 = new Date(System.currentTimeMillis());
      paramJSONObject = new Date(this.d.longValue());
      localObject2 = new Date(this.c.longValue());
      if (!((Date)localObject1).after(paramJSONObject))
      {
        paramJSONObject = (JSONObject)localObject1;
        if (((Date)localObject1).before((Date)localObject2)) {
          paramJSONObject = (JSONObject)localObject2;
        }
      }
    }
    this.e = (paramJSONObject.getYear() + 1900);
    this.f = (paramJSONObject.getMonth() + 1);
    this.g = paramJSONObject.getDate();
    a(new b.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lo.b
 * JD-Core Version:    0.7.0.1
 */