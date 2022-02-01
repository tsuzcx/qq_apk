package com.tencent.gdtad.web;

import android.content.Context;
import com.tencent.ad.tangram.settings.AdSettingsUtil.a;
import java.lang.ref.WeakReference;

class GdtLandingPageConfig$AddSettingListener
  implements AdSettingsUtil.a
{
  private GdtLandingPageConfig$AddSettingListener(GdtLandingPageConfig paramGdtLandingPageConfig) {}
  
  public void onUpdated(WeakReference<Context> paramWeakReference, boolean paramBoolean)
  {
    if (paramBoolean) {
      GdtLandingPageConfig.b(this.a, paramWeakReference);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.web.GdtLandingPageConfig.AddSettingListener
 * JD-Core Version:    0.7.0.1
 */