package com.tencent.biz.pubaccount.NativeAd.util;

import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.callback.AdDownloadCallback;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import java.util.ArrayList;
import java.util.Iterator;

class ADBaseAppDownloadManager$1
  implements Runnable
{
  ADBaseAppDownloadManager$1(ADBaseAppDownloadManager paramADBaseAppDownloadManager, ADVideoAppDownloadData paramADVideoAppDownloadData, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Iterator localIterator = ADBaseAppDownloadManager.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((AdDownloadCallback)localIterator.next()).a(this.a, this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */