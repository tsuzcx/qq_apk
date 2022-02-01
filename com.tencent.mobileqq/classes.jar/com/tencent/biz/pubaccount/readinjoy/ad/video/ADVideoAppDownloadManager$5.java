package com.tencent.biz.pubaccount.readinjoy.ad.video;

import android.text.TextUtils;
import bisa;
import oqh;
import orb;

class ADVideoAppDownloadManager$5
  implements Runnable
{
  ADVideoAppDownloadManager$5(ADVideoAppDownloadManager paramADVideoAppDownloadManager, orb paramorb) {}
  
  public void run()
  {
    this.a.c = ADVideoAppDownloadManager.a(this.this$0, this.a.b, 1);
    if (!TextUtils.isEmpty(this.a.c))
    {
      bisa.a().a(this.a.c);
      oqh.a("ADVideoAppDownloadManager", "pauseDownload : url = " + this.a.c);
      return;
    }
    oqh.a("ADVideoAppDownloadManager", "pauseDownload : url = null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.video.ADVideoAppDownloadManager.5
 * JD-Core Version:    0.7.0.1
 */