package com.tencent.biz.pubaccount.NativeAd.util;

import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.download_action.AdDownloadUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.qroute.QRoute;

class ADBaseAppDownloadManager$3
  implements Runnable
{
  ADBaseAppDownloadManager$3(ADBaseAppDownloadManager paramADBaseAppDownloadManager, ADVideoAppDownloadData paramADVideoAppDownloadData) {}
  
  public void run()
  {
    if (AdDownloadUtil.a(this.a))
    {
      IRIJAdLogService localIRIJAdLogService = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("already installed.");
      localStringBuilder.append(this.a.d);
      localIRIJAdLogService.d("ADBaseAppDownloadManager", localStringBuilder.toString());
      this.this$0.a(this.a, 1, 100);
      return;
    }
    AdDownloadUtil.a(this.a, new ADBaseAppDownloadManager.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager.3
 * JD-Core Version:    0.7.0.1
 */