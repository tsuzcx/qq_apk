package com.tencent.ad.tangram.web;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import java.lang.ref.WeakReference;

@Keep
public final class AdBrowserAdapter$Params
{
  public WeakReference<Activity> activity;
  public Ad ad;
  public Bundle extrasForIntent;
  public String url;
  
  public boolean isValid()
  {
    WeakReference localWeakReference = this.activity;
    return (localWeakReference != null) && (localWeakReference.get() != null) && (!TextUtils.isEmpty(this.url));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.web.AdBrowserAdapter.Params
 * JD-Core Version:    0.7.0.1
 */