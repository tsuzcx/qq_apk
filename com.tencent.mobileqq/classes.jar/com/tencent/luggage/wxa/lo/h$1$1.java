package com.tencent.luggage.wxa.lo;

import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPickerV2;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPickerV2.a;

class h$1$1
  implements Runnable
{
  h$1$1(h.1 param1, int paramInt, AppBrandMultiOptionsPickerV2.a parama) {}
  
  public void run()
  {
    AppBrandMultiOptionsPickerV2 localAppBrandMultiOptionsPickerV2 = (AppBrandMultiOptionsPickerV2)h.1.a(this.c, AppBrandMultiOptionsPickerV2.class);
    if (localAppBrandMultiOptionsPickerV2 == null)
    {
      this.c.a("fail picker not exists");
      return;
    }
    localAppBrandMultiOptionsPickerV2.a(this.a, this.b);
    this.c.a("ok");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lo.h.1.1
 * JD-Core Version:    0.7.0.1
 */