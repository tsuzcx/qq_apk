package com.tencent.ad.tangram.net;

import android.support.annotation.Keep;
import java.lang.ref.WeakReference;

@Keep
public enum AdTime
{
  INSTANCE;
  
  private WeakReference<AdTimeAdapter> adapter;
  
  private AdTime() {}
  
  public AdTimeAdapter getAdapter()
  {
    if (this.adapter != null) {
      return (AdTimeAdapter)this.adapter.get();
    }
    return null;
  }
  
  public long getServerTimeMillis()
  {
    AdTimeAdapter localAdTimeAdapter = getAdapter();
    if (localAdTimeAdapter != null) {
      return localAdTimeAdapter.getServerTimeMillis();
    }
    return System.currentTimeMillis();
  }
  
  public void setAdapter(WeakReference<AdTimeAdapter> paramWeakReference)
  {
    this.adapter = paramWeakReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.net.AdTime
 * JD-Core Version:    0.7.0.1
 */