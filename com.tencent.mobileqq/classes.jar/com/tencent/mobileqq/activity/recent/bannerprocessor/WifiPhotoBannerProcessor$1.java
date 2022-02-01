package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqdataline.QQProxyForDataline;

class WifiPhotoBannerProcessor$1
  implements View.OnClickListener
{
  WifiPhotoBannerProcessor$1(WifiPhotoBannerProcessor paramWifiPhotoBannerProcessor) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131381140)
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("string_from", false);
      localBundle.putBoolean("string_uin", true);
      localBundle.putLong("device_din", 0L);
      localBundle.putInt("sTitleID", 0);
      QQProxyForDataline.a(WifiPhotoBannerProcessor.a(this.a), localBundle, "com.qqdataline.activity.LiteWifiphotoActivity");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.WifiPhotoBannerProcessor.1
 * JD-Core Version:    0.7.0.1
 */