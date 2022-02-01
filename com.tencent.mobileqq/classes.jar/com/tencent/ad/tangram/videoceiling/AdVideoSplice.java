package com.tencent.ad.tangram.videoceiling;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Keep;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.log.AdLog;
import java.lang.ref.WeakReference;

@Keep
public enum AdVideoSplice
{
  INSTANCE;
  
  private static final String TAG = "AdVideoSplice";
  private WeakReference<AdVideoSpliceAdapter> mAdapter;
  
  private AdVideoSplice() {}
  
  public static AdVideoSpliceAdapter getAdapter()
  {
    WeakReference localWeakReference = INSTANCE.mAdapter;
    if (localWeakReference != null) {
      return (AdVideoSpliceAdapter)localWeakReference.get();
    }
    return null;
  }
  
  public static void setAdapter(WeakReference<AdVideoSpliceAdapter> paramWeakReference)
  {
    INSTANCE.mAdapter = paramWeakReference;
  }
  
  public static AdError show(WeakReference<Activity> paramWeakReference, Ad paramAd, String paramString1, String paramString2, Rect paramRect, int paramInt, boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle)
  {
    AdVideoSpliceAdapter localAdVideoSpliceAdapter = getAdapter();
    if (localAdVideoSpliceAdapter == null)
    {
      AdLog.e("AdVideoSplice", "show error");
      return new AdError(305);
    }
    AdLog.e("AdVideoSplice", "AdVideoSpliceAdapter show");
    AdVideoSpliceAdapter.Params localParams = new AdVideoSpliceAdapter.Params();
    localParams.activity = paramWeakReference;
    localParams.ad = paramAd;
    localParams.webUrl = paramString1;
    localParams.videoUrl2 = paramString2;
    localParams.mediaViewLocationRect = paramRect;
    localParams.videoSplicePageStyle = paramInt;
    localParams.videoPlayForced = paramBoolean1;
    localParams.videoLoop = paramBoolean2;
    localParams.extrasForIntent = paramBundle;
    return localAdVideoSpliceAdapter.show(localParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.videoceiling.AdVideoSplice
 * JD-Core Version:    0.7.0.1
 */