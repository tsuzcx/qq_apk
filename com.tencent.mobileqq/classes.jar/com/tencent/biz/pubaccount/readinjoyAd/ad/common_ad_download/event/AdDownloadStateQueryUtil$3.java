package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdUrlChangeUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;

final class AdDownloadStateQueryUtil$3
  implements Runnable
{
  AdDownloadStateQueryUtil$3(AdvertisementInfo paramAdvertisementInfo, ValueCallback paramValueCallback) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = (SoftReference)AdDownloadStateQueryUtil.a().get(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.getTicket());
      if (localObject1 == null) {
        break label370;
      }
      localObject1 = (ADVideoAppDownloadData)((SoftReference)localObject1).get();
      if (localObject1 != null) {
        break label367;
      }
      localObject1 = ADVideoAppDownloadData.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, false);
      label42:
      if ((localObject1 == null) || (TextUtils.isEmpty(((ADVideoAppDownloadData)localObject1).d)))
      {
        this.jdField_a_of_type_AndroidWebkitValueCallback.onReceiveValue(Integer.valueOf(0));
        return;
      }
      if ((TextUtils.isEmpty(((ADVideoAppDownloadData)localObject1).c)) && (!TextUtils.isEmpty(((ADVideoAppDownloadData)localObject1).b))) {
        ((ADVideoAppDownloadData)localObject1).c = RIJAdUrlChangeUtil.a.a(null, ((ADVideoAppDownloadData)localObject1).b);
      }
      if (TextUtils.isEmpty(((ADVideoAppDownloadData)localObject1).c))
      {
        this.jdField_a_of_type_AndroidWebkitValueCallback.onReceiveValue(Integer.valueOf(0));
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("AdDownloadStateQueryUtil", 1, localThrowable, new Object[0]);
      this.jdField_a_of_type_AndroidWebkitValueCallback.onReceiveValue(Integer.valueOf(0));
      return;
    }
    AdDownloadStateQueryUtil.a().put(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.getTicket(), new SoftReference(localThrowable));
    DownloadInfo localDownloadInfo2 = DownloadManagerV2.a().b(localThrowable.c);
    DownloadInfo localDownloadInfo1;
    if (localDownloadInfo2 != null)
    {
      localDownloadInfo1 = localDownloadInfo2;
      if (localDownloadInfo2.a() != 1) {}
    }
    else
    {
      localDownloadInfo1 = DownloadManagerV2.a().c(localThrowable.d);
    }
    if (localDownloadInfo1 == null)
    {
      this.jdField_a_of_type_AndroidWebkitValueCallback.onReceiveValue(Integer.valueOf(0));
      return;
    }
    AdDownloadStateQueryUtil.a(localDownloadInfo1);
    switch (localDownloadInfo1.a())
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWebkitValueCallback.onReceiveValue(Integer.valueOf(i));
      return;
      int i = 0;
      continue;
      i = 3;
      continue;
      i = 4;
      continue;
      i = 5;
      continue;
      i = 2;
      continue;
      i = 7;
      continue;
      i = 6;
      continue;
      label367:
      break label42;
      label370:
      Object localObject2 = null;
      break;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadStateQueryUtil.3
 * JD-Core Version:    0.7.0.1
 */