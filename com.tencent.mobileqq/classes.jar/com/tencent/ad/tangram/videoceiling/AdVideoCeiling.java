package com.tencent.ad.tangram.videoceiling;

import android.support.annotation.Keep;
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
    WeakReference localWeakReference = INSTANCE.adapter;
    if (localWeakReference != null) {
      return (AdVideoCeilingAdapter)localWeakReference.get();
    }
    return null;
  }
  
  public static void setAdapter(WeakReference<AdVideoCeilingAdapter> paramWeakReference)
  {
    INSTANCE.adapter = paramWeakReference;
  }
  
  public static AdError show(AdVideoCeiling.Params paramParams)
  {
    AdVideoCeilingAdapter localAdVideoCeilingAdapter = getAdapter();
    if (localAdVideoCeilingAdapter == null)
    {
      AdLog.e("AdVideoCeiling", "show error");
      return new AdError(303);
    }
    return localAdVideoCeilingAdapter.show(paramParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.videoceiling.AdVideoCeiling
 * JD-Core Version:    0.7.0.1
 */