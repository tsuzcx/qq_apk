package com.tencent.gdtad.web;

import com.tencent.ad.tangram.settings.AdSettingsManager.Listener;

class GdtLandingPageConfig$AddSettingListener
  implements AdSettingsManager.Listener
{
  private GdtLandingPageConfig$AddSettingListener(GdtLandingPageConfig paramGdtLandingPageConfig) {}
  
  public void onUpdated()
  {
    GdtLandingPageConfig.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.web.GdtLandingPageConfig.AddSettingListener
 * JD-Core Version:    0.7.0.1
 */