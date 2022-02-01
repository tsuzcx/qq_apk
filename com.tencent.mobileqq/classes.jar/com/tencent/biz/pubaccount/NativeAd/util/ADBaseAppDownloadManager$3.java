package com.tencent.biz.pubaccount.NativeAd.util;

import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.download_action.AdDownloadUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;

class ADBaseAppDownloadManager$3
  implements Runnable
{
  ADBaseAppDownloadManager$3(ADBaseAppDownloadManager paramADBaseAppDownloadManager, ADVideoAppDownloadData paramADVideoAppDownloadData) {}
  
  public void run()
  {
    if (AdDownloadUtil.a(this.a))
    {
      ReadInJoyAdLog.a("ADBaseAppDownloadManager", "already installed." + this.a.d);
      this.this$0.a(this.a, 1, 100);
      return;
    }
    AdDownloadUtil.a(this.a, new ADBaseAppDownloadManager.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager.3
 * JD-Core Version:    0.7.0.1
 */