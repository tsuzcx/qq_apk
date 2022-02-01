package com.tencent.ad.tangram.util;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import java.lang.ref.WeakReference;

@Keep
public class AdClickUtil$Params
{
  public WeakReference<Activity> activity;
  public Ad ad;
  public String antiSpamParams = null;
  public WeakReference<AdAppReceiver> appReceiver;
  public int componentID = -2147483648;
  public boolean enableAutoDownload = false;
  public Bundle extrasForIntent;
  public boolean halfScreenPageEnabled = false;
  public Rect mediaViewLocationRect = null;
  public boolean reportForClick = true;
  public int sceneID = -2147483648;
  public boolean videoCeilingSupportedIfInstalled = false;
  public boolean videoCeilingSupportedIfNotInstalled = false;
  private final boolean videoLoop = false;
  public boolean videoPlayForced = false;
  public boolean videoSpliceSupported = false;
  public long videoStartPositionMillis = 0L;
  
  public boolean isValid()
  {
    return (this.activity != null) && (this.activity.get() != null) && (this.ad != null) && (this.ad.isValid()) && (!TextUtils.isEmpty(this.ad.getTraceId())) && (!TextUtils.isEmpty(this.ad.getUrlForImpression())) && (!TextUtils.isEmpty(this.ad.getUrlForClick())) && (!TextUtils.isEmpty(this.ad.getUrlForEffect())) && (!TextUtils.isEmpty(this.ad.getUrlForAction())) && (!TextUtils.isEmpty(this.ad.getUrlForLandingPage()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdClickUtil.Params
 * JD-Core Version:    0.7.0.1
 */