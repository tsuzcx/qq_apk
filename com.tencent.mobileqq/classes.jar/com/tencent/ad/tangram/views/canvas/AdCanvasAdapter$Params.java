package com.tencent.ad.tangram.views.canvas;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Keep;
import com.tencent.ad.tangram.Ad;
import java.lang.ref.WeakReference;

@Keep
public final class AdCanvasAdapter$Params
{
  public WeakReference<Activity> activity;
  public Ad ad;
  public boolean autoDownload = false;
  public Bundle extrasForIntent;
  
  public boolean isValid()
  {
    Object localObject = this.activity;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      localObject = this.ad;
      if ((localObject != null) && (((Ad)localObject).isValid())) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.AdCanvasAdapter.Params
 * JD-Core Version:    0.7.0.1
 */