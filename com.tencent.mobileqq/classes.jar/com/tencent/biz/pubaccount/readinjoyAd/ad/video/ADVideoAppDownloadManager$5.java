package com.tencent.biz.pubaccount.readinjoyAd.ad.video;

import android.text.TextUtils;
import bjsz;
import tpx;
import tqt;

class ADVideoAppDownloadManager$5
  implements Runnable
{
  ADVideoAppDownloadManager$5(ADVideoAppDownloadManager paramADVideoAppDownloadManager, tqt paramtqt) {}
  
  public void run()
  {
    this.a.c = ADVideoAppDownloadManager.a(this.this$0, this.a.b, 1);
    if (!TextUtils.isEmpty(this.a.c))
    {
      bjsz.a().a(this.a.c);
      tpx.a("ADVideoAppDownloadManager", "pauseDownload : url = " + this.a.c);
      return;
    }
    tpx.a("ADVideoAppDownloadManager", "pauseDownload : url = null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadManager.5
 * JD-Core Version:    0.7.0.1
 */