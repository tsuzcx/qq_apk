package com.tencent.mm.plugin.appbrand.widget.picker;

import android.util.Log;
import com.tencent.luggage.wxa.ir.f;
import java.util.Date;

class AppBrandDatePickerV2$2
  implements f
{
  AppBrandDatePickerV2$2(AppBrandDatePickerV2 paramAppBrandDatePickerV2) {}
  
  public void onTimeSelect(Date paramDate)
  {
    AppBrandDatePickerV2.a(this.a, paramDate);
    Log.i("pvTime", "onTimeSelect");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.AppBrandDatePickerV2.2
 * JD-Core Version:    0.7.0.1
 */