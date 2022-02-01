package com.tencent.luggage.wxa.lo;

import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandOptionsPickerV3;
import com.tencent.mm.plugin.appbrand.widget.picker.a;
import com.tencent.mm.plugin.appbrand.widget.picker.d.a;
import java.util.HashMap;
import java.util.Map;

class i$4
  implements d.a<String>
{
  i$4(i parami, a parama, AppBrandOptionsPickerV3 paramAppBrandOptionsPickerV3) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    this.a.b();
    if (!paramBoolean)
    {
      this.c.a("fail cancel", null);
      return;
    }
    paramString = new HashMap(2);
    paramString.put("value", this.b.d());
    paramString.put("index", Integer.valueOf(this.b.c()));
    this.c.a("ok", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lo.i.4
 * JD-Core Version:    0.7.0.1
 */