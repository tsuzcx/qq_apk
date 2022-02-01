package com.tencent.ad.tangram.analysis;

import android.support.annotation.Keep;
import java.lang.ref.WeakReference;

@Keep
public enum AdUin
{
  INSTANCE;
  
  private static final String TAG = "AdUin";
  private WeakReference<AdUinAdapter> adapter;
  
  private AdUin() {}
  
  private AdUinAdapter getAdapter()
  {
    if (this.adapter != null) {
      return (AdUinAdapter)this.adapter.get();
    }
    return null;
  }
  
  public String getUIN()
  {
    AdUinAdapter localAdUinAdapter = getAdapter();
    if (localAdUinAdapter != null) {
      return localAdUinAdapter.getUIN();
    }
    return null;
  }
  
  public void setAdapter(WeakReference<AdUinAdapter> paramWeakReference)
  {
    this.adapter = paramWeakReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.analysis.AdUin
 * JD-Core Version:    0.7.0.1
 */