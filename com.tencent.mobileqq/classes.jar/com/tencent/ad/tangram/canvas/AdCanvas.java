package com.tencent.ad.tangram.canvas;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Keep;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.log.AdLog;
import java.lang.ref.WeakReference;

@Keep
public enum AdCanvas
{
  INSTANCE;
  
  private static final String TAG = "AdCanvas";
  private WeakReference<AdCanvasAdapter> adapter;
  
  private AdCanvas() {}
  
  public static AdCanvasAdapter getAdapter()
  {
    if (INSTANCE.adapter != null) {
      return (AdCanvasAdapter)INSTANCE.adapter.get();
    }
    return null;
  }
  
  public static void setAdapter(WeakReference<AdCanvasAdapter> paramWeakReference)
  {
    INSTANCE.adapter = paramWeakReference;
  }
  
  public static AdError show(WeakReference<Activity> paramWeakReference, Ad paramAd, boolean paramBoolean, Bundle paramBundle)
  {
    AdCanvasAdapter localAdCanvasAdapter = getAdapter();
    if (localAdCanvasAdapter == null)
    {
      AdLog.e("AdCanvas", "show");
      return new AdError(302);
    }
    AdCanvasAdapter.Params localParams = new AdCanvasAdapter.Params();
    localParams.activity = paramWeakReference;
    localParams.ad = paramAd;
    localParams.autoDownload = paramBoolean;
    localParams.extrasForIntent = paramBundle;
    return localAdCanvasAdapter.show(localParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.AdCanvas
 * JD-Core Version:    0.7.0.1
 */