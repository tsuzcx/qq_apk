package com.tencent.ad.tangram.device;

import android.content.Context;
import android.support.annotation.Keep;
import com.tencent.ad.tangram.log.AdLog;
import java.lang.ref.WeakReference;

@Keep
public final class AdTAID
{
  private static final String TAG = "AdTAID";
  private static volatile AdTAID instance;
  private volatile WeakReference<AdTAIDAdapter> adapter;
  private volatile boolean initialized = false;
  
  private AdTAIDAdapter getAdapter()
  {
    if (this.adapter != null) {
      return (AdTAIDAdapter)this.adapter.get();
    }
    return null;
  }
  
  public static AdTAID getInstance()
  {
    if (instance == null) {
      try
      {
        if (instance == null) {
          instance = new AdTAID();
        }
      }
      finally {}
    }
    return instance;
  }
  
  public AdTAID.Entity getEntity(Context paramContext, String paramString)
  {
    AdTAIDAdapter localAdTAIDAdapter = getAdapter();
    if (localAdTAIDAdapter == null)
    {
      AdLog.e("AdTAID", "getEntity error, adapter is null");
      return null;
    }
    return localAdTAIDAdapter.getEntity(paramContext, paramString);
  }
  
  public void init(Context paramContext)
  {
    AdTAIDAdapter localAdTAIDAdapter = getAdapter();
    if (localAdTAIDAdapter == null)
    {
      AdLog.e("AdTAID", "getEntity error, adapter is null");
      return;
    }
    if (this.initialized) {
      return;
    }
    try
    {
      if (this.initialized) {
        return;
      }
      this.initialized = true;
      localAdTAIDAdapter.init(paramContext);
      return;
    }
    finally {}
  }
  
  public void setAdapter(WeakReference<AdTAIDAdapter> paramWeakReference)
  {
    this.adapter = paramWeakReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.device.AdTAID
 * JD-Core Version:    0.7.0.1
 */