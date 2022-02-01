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
  public boolean isAppPreOrderPublished = false;
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
    boolean bool3 = true;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.activity != null)
    {
      bool1 = bool2;
      if (this.activity.get() != null)
      {
        bool1 = bool2;
        if (this.ad != null)
        {
          if (this.ad.isValid()) {
            break label52;
          }
          bool1 = bool2;
        }
      }
    }
    bool2 = bool1;
    label52:
    label114:
    do
    {
      return bool2;
      if ((TextUtils.isEmpty(this.ad.getTraceId())) || (TextUtils.isEmpty(this.ad.getUrlForEffect())) || (TextUtils.isEmpty(this.ad.getUrlForAction())) || (TextUtils.isEmpty(this.ad.getUrlForLandingPage()))) {
        break;
      }
      bool1 = true;
      bool2 = bool1;
    } while (this.isAppPreOrderPublished);
    if ((bool1) && (!TextUtils.isEmpty(this.ad.getUrlForImpression())) && (!TextUtils.isEmpty(this.ad.getUrlForClick()))) {}
    for (bool1 = bool3;; bool1 = false)
    {
      break;
      bool1 = false;
      break label114;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdClickUtil.Params
 * JD-Core Version:    0.7.0.1
 */