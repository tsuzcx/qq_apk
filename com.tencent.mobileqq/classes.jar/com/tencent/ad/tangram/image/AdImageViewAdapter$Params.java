package com.tencent.ad.tangram.image;

import android.content.Context;
import android.support.annotation.Keep;
import android.text.TextUtils;

@Keep
public class AdImageViewAdapter$Params
{
  public Context context;
  public String guassianUrl;
  public Object loadListener;
  public String url;
  
  public boolean isValid()
  {
    return (this.context != null) && (!TextUtils.isEmpty(this.url)) && (!TextUtils.isEmpty(this.guassianUrl)) && (this.loadListener != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.image.AdImageViewAdapter.Params
 * JD-Core Version:    0.7.0.1
 */