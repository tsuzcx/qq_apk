package com.tencent.ad.tangram.videoceiling;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import java.lang.ref.WeakReference;

@Keep
public final class AdVideoCeilingAdapter$Params
{
  public static final int STYLE_APP_DEEP_LINK = 3;
  public static final int STYLE_APP_MAIN = 2;
  public static final int STYLE_CANVAS = 4;
  public static final int STYLE_WEB = 1;
  public WeakReference<Activity> activity;
  public Ad ad;
  public boolean autodownload;
  public Bundle extrasForIntent;
  public int style = -2147483648;
  public boolean videoLoop = true;
  public boolean videoPlayForced = false;
  public long videoStartPositionMillis = 0L;
  public String videoUrl;
  public String webUrl;
  
  public boolean isValid()
  {
    return (this.activity != null) && (this.activity.get() != null) && (this.ad != null) && (this.ad.isValid()) && (!TextUtils.isEmpty(this.webUrl)) && (!TextUtils.isEmpty(this.videoUrl)) && (this.style != -2147483648) && (this.videoStartPositionMillis >= 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.videoceiling.AdVideoCeilingAdapter.Params
 * JD-Core Version:    0.7.0.1
 */