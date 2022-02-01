package com.tencent.ad.tangram.halfScreen;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Keep;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.log.AdLog;
import java.lang.ref.WeakReference;

@Keep
public enum AdHalfScreen
{
  INSTANCE;
  
  private static final String TAG = "AdHalfScreen";
  private WeakReference<AdHalfScreenAdapter> mAdapter;
  
  private AdHalfScreen() {}
  
  public static AdHalfScreenAdapter getAdapter()
  {
    if (INSTANCE.mAdapter != null) {
      return (AdHalfScreenAdapter)INSTANCE.mAdapter.get();
    }
    return null;
  }
  
  public static void setAdapter(WeakReference<AdHalfScreenAdapter> paramWeakReference)
  {
    INSTANCE.mAdapter = paramWeakReference;
  }
  
  public static AdError show(WeakReference<Activity> paramWeakReference, Ad paramAd, boolean paramBoolean, int paramInt, String paramString, Bundle paramBundle)
  {
    AdHalfScreenAdapter localAdHalfScreenAdapter = getAdapter();
    if (localAdHalfScreenAdapter == null)
    {
      AdLog.e("AdHalfScreen", "show error");
      return new AdError(306);
    }
    AdHalfScreenAdapter.Params localParams = new AdHalfScreenAdapter.Params();
    localParams.activity = paramWeakReference;
    localParams.ad = paramAd;
    localParams.autodownload = paramBoolean;
    localParams.style = paramInt;
    localParams.webUrl = paramString;
    localParams.extrasForIntent = paramBundle;
    return localAdHalfScreenAdapter.show(localParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.halfScreen.AdHalfScreen
 * JD-Core Version:    0.7.0.1
 */