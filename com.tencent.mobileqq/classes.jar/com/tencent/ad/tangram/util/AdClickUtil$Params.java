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
    Object localObject = this.activity;
    boolean bool3 = false;
    boolean bool2 = bool3;
    if (localObject != null)
    {
      bool2 = bool3;
      if (((WeakReference)localObject).get() != null)
      {
        localObject = this.ad;
        bool2 = bool3;
        if (localObject != null)
        {
          if (!((Ad)localObject).isValid()) {
            return false;
          }
          boolean bool1;
          if ((!TextUtils.isEmpty(this.ad.getTraceId())) && (!TextUtils.isEmpty(this.ad.getUrlForEffect())) && (!TextUtils.isEmpty(this.ad.getUrlForAction())) && (!TextUtils.isEmpty(this.ad.getUrlForLandingPage()))) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          if (this.isAppPreOrderPublished) {
            return bool1;
          }
          bool2 = bool3;
          if (bool1)
          {
            bool2 = bool3;
            if (!TextUtils.isEmpty(this.ad.getUrlForImpression()))
            {
              bool2 = bool3;
              if (!TextUtils.isEmpty(this.ad.getUrlForClick())) {
                bool2 = true;
              }
            }
          }
        }
      }
    }
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdClickUtil.Params
 * JD-Core Version:    0.7.0.1
 */