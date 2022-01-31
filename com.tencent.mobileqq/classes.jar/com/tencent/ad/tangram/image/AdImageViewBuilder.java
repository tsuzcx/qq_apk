package com.tencent.ad.tangram.image;

import android.support.annotation.Keep;
import android.view.View;
import java.lang.ref.WeakReference;

@Keep
public enum AdImageViewBuilder
{
  INSTANCE;
  
  private WeakReference<AdImageViewAdapter> adapter;
  
  private AdImageViewBuilder() {}
  
  public static View buildImageView(AdImageViewAdapter.Params paramParams)
  {
    AdImageViewAdapter localAdImageViewAdapter = getAdapter();
    if (localAdImageViewAdapter != null) {
      return localAdImageViewAdapter.buildImageView(paramParams);
    }
    return null;
  }
  
  private static AdImageViewAdapter getAdapter()
  {
    if (INSTANCE.adapter != null) {
      return (AdImageViewAdapter)INSTANCE.adapter.get();
    }
    return null;
  }
  
  public static void setAdapter(WeakReference<AdImageViewAdapter> paramWeakReference)
  {
    INSTANCE.adapter = paramWeakReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.image.AdImageViewBuilder
 * JD-Core Version:    0.7.0.1
 */