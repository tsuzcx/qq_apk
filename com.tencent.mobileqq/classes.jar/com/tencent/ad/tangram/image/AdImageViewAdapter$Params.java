package com.tencent.ad.tangram.image;

import android.content.Context;
import android.support.annotation.Keep;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

@Keep
public class AdImageViewAdapter$Params
{
  public WeakReference<AdImageViewAdapter.Callback> callback;
  public WeakReference<Context> context;
  public String gaussianUrl;
  public boolean isHitImageExp;
  public boolean isOnlyLoadGaussianUrl;
  public String url;
  
  public boolean isValid()
  {
    WeakReference localWeakReference = this.context;
    if ((localWeakReference != null) && (localWeakReference.get() != null) && (!TextUtils.isEmpty(this.url)))
    {
      localWeakReference = this.callback;
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.image.AdImageViewAdapter.Params
 * JD-Core Version:    0.7.0.1
 */