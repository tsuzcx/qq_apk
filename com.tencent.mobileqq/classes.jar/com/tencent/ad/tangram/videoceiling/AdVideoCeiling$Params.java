package com.tencent.ad.tangram.videoceiling;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import java.lang.ref.WeakReference;

@Keep
public final class AdVideoCeiling$Params
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
  public String widthHeightRatio;
  
  public boolean isValid()
  {
    Object localObject = this.activity;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      localObject = this.ad;
      if ((localObject != null) && (((Ad)localObject).isValid()) && (!TextUtils.isEmpty(this.webUrl)) && (!TextUtils.isEmpty(this.videoUrl)) && (this.style != -2147483648) && (!TextUtils.isEmpty(this.widthHeightRatio)) && (this.videoStartPositionMillis >= 0L)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.videoceiling.AdVideoCeiling.Params
 * JD-Core Version:    0.7.0.1
 */