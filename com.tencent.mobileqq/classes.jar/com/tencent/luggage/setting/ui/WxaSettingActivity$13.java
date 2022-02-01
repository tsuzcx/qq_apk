package com.tencent.luggage.setting.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.luggage.wxa.ek.a;

class WxaSettingActivity$13
  implements Runnable
{
  WxaSettingActivity$13(WxaSettingActivity paramWxaSettingActivity) {}
  
  public void run()
  {
    if (!WxaSettingActivity.r(this.a)) {
      return;
    }
    WxaSettingActivity.e(this.a, false);
    if (WxaSettingActivity.g(this.a) == 1)
    {
      WxaSettingActivity.j(this.a).o();
      return;
    }
    FrameLayout localFrameLayout = (FrameLayout)WxaSettingActivity.s(this.a).findViewById(2131450323);
    if (localFrameLayout != null)
    {
      localFrameLayout.setVisibility(8);
      ((ViewGroup)localFrameLayout.getParent()).removeView(localFrameLayout);
    }
    WxaSettingActivity.s(this.a).findViewById(2131438781).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.setting.ui.WxaSettingActivity.13
 * JD-Core Version:    0.7.0.1
 */