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
  public String guassianUrl;
  public String url;
  
  public boolean isValid()
  {
    return (this.context != null) && (this.context.get() != null) && (!TextUtils.isEmpty(this.url)) && (this.callback != null) && (this.callback.get() != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.image.AdImageViewAdapter.Params
 * JD-Core Version:    0.7.0.1
 */