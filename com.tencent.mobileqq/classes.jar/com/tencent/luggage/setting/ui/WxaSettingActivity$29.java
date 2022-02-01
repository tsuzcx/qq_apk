package com.tencent.luggage.setting.ui;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.qx.a;
import com.tencent.luggage.wxa.qz.b;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.h;

class WxaSettingActivity$29
  implements AppBrandSimpleImageLoader.h
{
  WxaSettingActivity$29(WxaSettingActivity paramWxaSettingActivity) {}
  
  @NonNull
  public Bitmap a(@NonNull Bitmap paramBitmap)
  {
    return b.a(paramBitmap, false, a.e(WxaSettingActivity.h(this.a), 4), false);
  }
  
  @NonNull
  public String a()
  {
    return "setting_wxa_user_info_icon";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.setting.ui.WxaSettingActivity.29
 * JD-Core Version:    0.7.0.1
 */