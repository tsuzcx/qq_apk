package com.tencent.biz.pubaccount.NativeAd.util;

import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.download_action.AdDownloadUtil.PkgExistCallback;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.NetworkUtil;

class ADBaseAppDownloadManager$3$1
  implements AdDownloadUtil.PkgExistCallback
{
  ADBaseAppDownloadManager$3$1(ADBaseAppDownloadManager.3 param3) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.this$0.a(this.a.a, 5, 100);
      this.a.this$0.f(this.a.a);
      return;
    }
    if (this.a.a.l)
    {
      ADBaseAppDownloadManager.a(this.a.this$0, this.a.a);
      return;
    }
    if (NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext())) {
      this.a.this$0.a(this.a.a, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager.3.1
 * JD-Core Version:    0.7.0.1
 */