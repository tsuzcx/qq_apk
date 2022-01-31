package com.tencent.ad.tangram.videoceiling;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import java.lang.ref.WeakReference;

@Keep
public final class AdVideoSpliceAdapter$Params
{
  public WeakReference<Activity> activity;
  public Ad ad;
  public Bundle extrasForIntent;
  public Rect mediaViewLocationRect;
  public boolean videoLoop = true;
  public boolean videoPlayForced = false;
  public int videoSplicePageStyle = -2147483648;
  public String videoUrl2;
  public String webUrl;
  
  public boolean isValid()
  {
    boolean bool = false;
    int i;
    if ((this.activity != null) && (this.activity.get() != null) && (this.ad != null) && (this.ad.isValid()) && (this.mediaViewLocationRect != null) && (this.videoSplicePageStyle != -2147483648))
    {
      j = 1;
      if ((j == 0) || (this.ad.getCreativeSize() != 585) || (this.webUrl != null)) {
        break label142;
      }
      i = 1;
      label84:
      if ((j == 0) || (this.ad.getCreativeSize() != 930) || (TextUtils.isEmpty(this.webUrl)) || (TextUtils.isEmpty(this.videoUrl2))) {
        break label147;
      }
    }
    label142:
    label147:
    for (int j = 1;; j = 0)
    {
      if ((i != 0) || (j != 0)) {
        bool = true;
      }
      return bool;
      j = 0;
      break;
      i = 0;
      break label84;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.videoceiling.AdVideoSpliceAdapter.Params
 * JD-Core Version:    0.7.0.1
 */