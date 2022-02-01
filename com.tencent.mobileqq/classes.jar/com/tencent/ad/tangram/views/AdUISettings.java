package com.tencent.ad.tangram.views;

import android.support.annotation.Keep;
import java.lang.ref.WeakReference;

@Keep
public enum AdUISettings
{
  INSTANCE;
  
  private static final String TAG = AdUISettings.class.getSimpleName();
  private WeakReference<AdUISettingsAdapter> adapter;
  
  private AdUISettings() {}
  
  public AdUISettingsAdapter getAdapter()
  {
    WeakReference localWeakReference = this.adapter;
    if (localWeakReference != null) {
      return (AdUISettingsAdapter)localWeakReference.get();
    }
    return null;
  }
  
  public boolean isNightMode()
  {
    AdUISettingsAdapter localAdUISettingsAdapter = getAdapter();
    return (localAdUISettingsAdapter != null) && (localAdUISettingsAdapter.isNightMode());
  }
  
  public void setAdapter(WeakReference<AdUISettingsAdapter> paramWeakReference)
  {
    this.adapter = paramWeakReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.AdUISettings
 * JD-Core Version:    0.7.0.1
 */