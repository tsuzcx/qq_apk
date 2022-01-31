package com.tencent.ad.tangram.device;

import android.support.annotation.Keep;
import java.lang.ref.WeakReference;

@Keep
public enum AdImei
{
  INSTANCE;
  
  private static final String TAG = "AdImei";
  private WeakReference<AdImeiAdapter> adapter;
  
  private AdImei() {}
  
  private static AdImeiAdapter getAdapter()
  {
    if (INSTANCE.adapter != null) {
      return (AdImeiAdapter)INSTANCE.adapter.get();
    }
    return null;
  }
  
  public static String getIMEI()
  {
    AdImeiAdapter localAdImeiAdapter = getAdapter();
    if (localAdImeiAdapter != null) {
      return localAdImeiAdapter.getIMEI();
    }
    return null;
  }
  
  public static void setAdapter(WeakReference<AdImeiAdapter> paramWeakReference)
  {
    INSTANCE.adapter = paramWeakReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.device.AdImei
 * JD-Core Version:    0.7.0.1
 */