package com.tencent.biz.pubaccount.readinjoyAd.ad.video;

import android.text.TextUtils;
import bhyo;
import twp;
import txh;

class ADVideoAppDownloadManager$5
  implements Runnable
{
  ADVideoAppDownloadManager$5(ADVideoAppDownloadManager paramADVideoAppDownloadManager, txh paramtxh) {}
  
  public void run()
  {
    this.a.c = ADVideoAppDownloadManager.a(this.this$0, this.a.b, 1);
    if (!TextUtils.isEmpty(this.a.c))
    {
      bhyo.a().a(this.a.c);
      twp.a("ADVideoAppDownloadManager", "pauseDownload : url = " + this.a.c);
      return;
    }
    twp.a("ADVideoAppDownloadManager", "pauseDownload : url = null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadManager.5
 * JD-Core Version:    0.7.0.1
 */