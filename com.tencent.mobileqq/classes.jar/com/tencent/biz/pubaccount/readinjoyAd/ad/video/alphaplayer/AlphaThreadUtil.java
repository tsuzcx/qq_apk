package com.tencent.biz.pubaccount.readinjoyAd.ad.video.alphaplayer;

import android.os.Handler;
import android.os.Looper;

public class AlphaThreadUtil
{
  private static final Handler a = new Handler(Looper.getMainLooper());
  
  public static void a(Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      a.post(paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.alphaplayer.AlphaThreadUtil
 * JD-Core Version:    0.7.0.1
 */