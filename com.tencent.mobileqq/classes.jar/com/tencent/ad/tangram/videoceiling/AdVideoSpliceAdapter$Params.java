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
    Object localObject = this.activity;
    boolean bool = true;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      localObject = this.ad;
      if ((localObject != null) && (((Ad)localObject).isValid()) && (this.mediaViewLocationRect != null) && (this.videoSplicePageStyle != -2147483648))
      {
        j = 1;
        break label65;
      }
    }
    int j = 0;
    label65:
    int i;
    if ((j != 0) && (this.ad.getCreativeSize() == 585) && (this.webUrl == null)) {
      i = 1;
    } else {
      i = 0;
    }
    if ((j != 0) && (this.ad.getCreativeSize() == 930) && (!TextUtils.isEmpty(this.webUrl)) && (!TextUtils.isEmpty(this.videoUrl2))) {
      j = 1;
    } else {
      j = 0;
    }
    if (i == 0)
    {
      if (j != 0) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.videoceiling.AdVideoSpliceAdapter.Params
 * JD-Core Version:    0.7.0.1
 */