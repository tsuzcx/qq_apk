package com.tencent.luggage.setting.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.luggage.wxa.ek.a;

class WxaSettingActivity$11
  implements Runnable
{
  WxaSettingActivity$11(WxaSettingActivity paramWxaSettingActivity) {}
  
  public void run()
  {
    if (WxaSettingActivity.r(this.a)) {
      return;
    }
    WxaSettingActivity.e(this.a, true);
    if (WxaSettingActivity.g(this.a) == 1)
    {
      WxaSettingActivity.j(this.a).n();
      return;
    }
    Object localObject = WxaSettingActivity.s(this.a).findViewById(2131438781);
    ((View)localObject).setVisibility(8);
    localObject = (ViewGroup)((View)localObject).getParent();
    View localView = LayoutInflater.from(WxaSettingActivity.h(this.a)).inflate(2131625250, null);
    localView.findViewById(2131450323).setVisibility(0);
    ((ViewGroup)localObject).addView(localView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.setting.ui.WxaSettingActivity.11
 * JD-Core Version:    0.7.0.1
 */