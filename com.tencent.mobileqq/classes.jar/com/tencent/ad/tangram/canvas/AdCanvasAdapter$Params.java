package com.tencent.ad.tangram.canvas;

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
    return (this.activity != null) && (this.activity.get() != null) && (this.ad != null) && (this.ad.isValid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.AdCanvasAdapter.Params
 * JD-Core Version:    0.7.0.1
 */