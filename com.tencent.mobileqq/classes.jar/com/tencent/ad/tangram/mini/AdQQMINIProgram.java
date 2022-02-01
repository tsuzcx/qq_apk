package com.tencent.ad.tangram.mini;

import android.content.Context;
import android.support.annotation.Keep;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.log.AdLog;
import java.lang.ref.WeakReference;

@Keep
public enum AdQQMINIProgram
{
  INSTANCE;
  
  private static final String TAG = "AdQQMINIProgram";
  private WeakReference<AdQQMINIProgramAdapter> adapter;
  
  private AdQQMINIProgram() {}
  
  private static AdQQMINIProgramAdapter getAdapter()
  {
    WeakReference localWeakReference = INSTANCE.adapter;
    if (localWeakReference != null) {
      return (AdQQMINIProgramAdapter)localWeakReference.get();
    }
    return null;
  }
  
  public static void setAdapter(WeakReference<AdQQMINIProgramAdapter> paramWeakReference)
  {
    INSTANCE.adapter = paramWeakReference;
  }
  
  public static AdError show(WeakReference<Context> paramWeakReference, Ad paramAd)
  {
    AdQQMINIProgramAdapter localAdQQMINIProgramAdapter = getAdapter();
    if (localAdQQMINIProgramAdapter == null)
    {
      AdLog.e("AdQQMINIProgram", "show");
      return new AdError(304);
    }
    AdQQMINIProgramAdapter.Params localParams = new AdQQMINIProgramAdapter.Params();
    localParams.context = paramWeakReference;
    localParams.ad = paramAd;
    return localAdQQMINIProgramAdapter.show(localParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.mini.AdQQMINIProgram
 * JD-Core Version:    0.7.0.1
 */