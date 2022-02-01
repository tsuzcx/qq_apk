package com.tencent.ad.tangram.halfScreen;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import java.lang.ref.WeakReference;

@Keep
public final class AdHalfScreenAdapter$Params
{
  public static final int STYLE_CANVAS = 2;
  public static final int STYLE_WEB = 1;
  public WeakReference<Activity> activity;
  public Ad ad;
  public boolean autodownload;
  public Bundle extrasForIntent;
  public int style = -2147483648;
  public String webUrl;
  
  public boolean isValid()
  {
    return (this.activity != null) && (this.activity.get() != null) && (this.ad != null) && (this.ad.isValid()) && (!TextUtils.isEmpty(this.webUrl)) && (this.style != -2147483648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.halfScreen.AdHalfScreenAdapter.Params
 * JD-Core Version:    0.7.0.1
 */