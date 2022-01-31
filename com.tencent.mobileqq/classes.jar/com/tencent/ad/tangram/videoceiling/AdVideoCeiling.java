package com.tencent.ad.tangram.videoceiling;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Keep;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.log.AdLog;
import java.lang.ref.WeakReference;

@Keep
public enum AdVideoCeiling
{
  INSTANCE;
  
  private static final String TAG = "AdVideoCeiling";
  private WeakReference<AdVideoCeilingAdapter> adapter;
  
  private AdVideoCeiling() {}
  
  public static AdVideoCeilingAdapter getAdapter()
  {
    if (INSTANCE.adapter != null) {
      return (AdVideoCeilingAdapter)INSTANCE.adapter.get();
    }
    return null;
  }
  
  public static void setAdapter(WeakReference<AdVideoCeilingAdapter> paramWeakReference)
  {
    INSTANCE.adapter = paramWeakReference;
  }
  
  public static AdError show(WeakReference<Activity> paramWeakReference, Ad paramAd, String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, Bundle paramBundle, boolean paramBoolean3)
  {
    AdVideoCeilingAdapter localAdVideoCeilingAdapter = getAdapter();
    if (localAdVideoCeilingAdapter == null)
    {
      AdLog.e("AdVideoCeiling", "show error");
      return new AdError(303);
    }
    AdVideoCeilingAdapter.Params localParams = new AdVideoCeilingAdapter.Params();
    localParams.activity = paramWeakReference;
    localParams.ad = paramAd;
    localParams.webUrl = paramString1;
    localParams.videoUrl = paramString2;
    localParams.style = paramInt;
    localParams.videoPlayForced = paramBoolean1;
    localParams.videoLoop = paramBoolean2;
    localParams.videoStartPositionMillis = paramLong;
    localParams.extrasForIntent = paramBundle;
    localParams.autodownload = paramBoolean3;
    return localAdVideoCeilingAdapter.show(localParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.videoceiling.AdVideoCeiling
 * JD-Core Version:    0.7.0.1
 */