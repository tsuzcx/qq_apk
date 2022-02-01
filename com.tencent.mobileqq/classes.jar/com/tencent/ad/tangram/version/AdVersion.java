package com.tencent.ad.tangram.version;

import android.support.annotation.Keep;
import java.lang.ref.WeakReference;

@Keep
public enum AdVersion
{
  INSTANCE;
  
  private static final String TAG = "AdAnalysis";
  private WeakReference<AdVersionAdapter> adapter;
  
  private AdVersion() {}
  
  private AdVersionAdapter getAdapter()
  {
    WeakReference localWeakReference = INSTANCE.adapter;
    if (localWeakReference != null) {
      return (AdVersionAdapter)localWeakReference.get();
    }
    return null;
  }
  
  public String getAppVersion()
  {
    AdVersionAdapter localAdVersionAdapter = getAdapter();
    if (localAdVersionAdapter != null) {
      return localAdVersionAdapter.getAppVersion();
    }
    return null;
  }
  
  public void setAdapter(WeakReference<AdVersionAdapter> paramWeakReference)
  {
    INSTANCE.adapter = paramWeakReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.version.AdVersion
 * JD-Core Version:    0.7.0.1
 */