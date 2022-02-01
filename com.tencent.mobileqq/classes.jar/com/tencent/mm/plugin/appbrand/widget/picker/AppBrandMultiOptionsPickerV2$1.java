package com.tencent.mm.plugin.appbrand.widget.picker;

import com.tencent.luggage.wxa.ir.c;

class AppBrandMultiOptionsPickerV2$1
  implements c
{
  AppBrandMultiOptionsPickerV2$1(AppBrandMultiOptionsPickerV2 paramAppBrandMultiOptionsPickerV2, int paramInt) {}
  
  public void onOptionsSelectChanged(int paramInt)
  {
    if (AppBrandMultiOptionsPickerV2.a(this.b) != null) {
      AppBrandMultiOptionsPickerV2.a(this.b).a(new int[] { this.a, paramInt });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPickerV2.1
 * JD-Core Version:    0.7.0.1
 */