package com.tencent.ad.tangram.web;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Keep;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.log.AdLog;
import java.lang.ref.WeakReference;

@Keep
public enum AdBrowser
{
  INSTANCE;
  
  private static final String TAG = "AdBrowser";
  private WeakReference<AdBrowserAdapter> adapter;
  
  private AdBrowser() {}
  
  private static AdBrowserAdapter getAdapter()
  {
    WeakReference localWeakReference = INSTANCE.adapter;
    if (localWeakReference != null) {
      return (AdBrowserAdapter)localWeakReference.get();
    }
    return null;
  }
  
  public static void setAdapter(WeakReference<AdBrowserAdapter> paramWeakReference)
  {
    INSTANCE.adapter = paramWeakReference;
  }
  
  public static AdError show(WeakReference<Activity> paramWeakReference, Ad paramAd, String paramString, Bundle paramBundle)
  {
    AdBrowserAdapter localAdBrowserAdapter = getAdapter();
    if (localAdBrowserAdapter == null)
    {
      AdLog.e("AdBrowser", "show error");
      return new AdError(301);
    }
    AdBrowserAdapter.Params localParams = new AdBrowserAdapter.Params();
    localParams.activity = paramWeakReference;
    localParams.ad = paramAd;
    localParams.url = paramString;
    localParams.extrasForIntent = paramBundle;
    return localAdBrowserAdapter.show(localParams);
  }
  
  public static AdError showWithoutAd(WeakReference<Activity> paramWeakReference, String paramString, Bundle paramBundle)
  {
    AdBrowserAdapter localAdBrowserAdapter = getAdapter();
    if (localAdBrowserAdapter == null)
    {
      AdLog.e("AdBrowser", "showWithoutAd error");
      return new AdError(301);
    }
    AdBrowserAdapter.Params localParams = new AdBrowserAdapter.Params();
    localParams.activity = paramWeakReference;
    localParams.url = paramString;
    localParams.extrasForIntent = paramBundle;
    return localAdBrowserAdapter.showWithoutAd(localParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.web.AdBrowser
 * JD-Core Version:    0.7.0.1
 */