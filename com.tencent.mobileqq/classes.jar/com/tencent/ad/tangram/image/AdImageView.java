package com.tencent.ad.tangram.image;

import android.support.annotation.Keep;
import android.view.View;
import java.lang.ref.WeakReference;

@Keep
public enum AdImageView
{
  INSTANCE;
  
  private WeakReference<AdImageViewAdapter> adapter;
  
  private AdImageView() {}
  
  private static AdImageViewAdapter getAdapter()
  {
    if (INSTANCE.adapter != null) {
      return (AdImageViewAdapter)INSTANCE.adapter.get();
    }
    return null;
  }
  
  public static View getImageView(AdImageViewAdapter.Params paramParams)
  {
    AdImageViewAdapter localAdImageViewAdapter = getAdapter();
    if (localAdImageViewAdapter != null) {
      return localAdImageViewAdapter.getImageView(paramParams);
    }
    return null;
  }
  
  public static void setAdapter(WeakReference<AdImageViewAdapter> paramWeakReference)
  {
    INSTANCE.adapter = paramWeakReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.image.AdImageView
 * JD-Core Version:    0.7.0.1
 */