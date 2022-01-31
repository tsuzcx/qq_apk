package com.tencent.ad.tangram.ark;

import android.content.Context;
import android.support.annotation.Keep;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

@Keep
public class AdArkAdapter$Params
{
  public String appName;
  public WeakReference<AdArkAdapter.Callback> callback;
  public WeakReference<Context> context;
  public String metaData;
  public String viewName;
  
  public boolean isValid()
  {
    return (this.context != null) && (this.context.get() != null) && (!TextUtils.isEmpty(this.metaData));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.ark.AdArkAdapter.Params
 * JD-Core Version:    0.7.0.1
 */