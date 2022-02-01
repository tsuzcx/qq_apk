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
    for (;;)
    {
      try
      {
        Object localObject1 = (SoftReference)AdDownloadStateQueryUtil.a().get(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.getTicket());
        if (localObject1 != null)
        {
          localObject1 = (ADVideoAppDownloadData)((SoftReference)localObject1).get();
          Object localObject3 = localObject1;
          if (localObject1 == null) {
            localObject3 = ADVideoAppDownloadData.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, false);
          }
          if ((localObject3 != null) && (!TextUtils.isEmpty(((ADVideoAppDownloadData)localObject3).d)))
          {
            if ((TextUtils.isEmpty(((ADVideoAppDownloadData)localObject3).c)) && (!TextUtils.isEmpty(((ADVideoAppDownloadData)localObject3).b))) {
              ((ADVideoAppDownloadData)localObject3).c = RIJAdUrlChangeUtil.a.a(null, ((ADVideoAppDownloadData)localObject3).b);
            }
            if (TextUtils.isEmpty(((ADVideoAppDownloadData)localObject3).c))
            {
              this.jdField_a_of_type_AndroidWebkitValueCallback.onReceiveValue(Integer.valueOf(0));
              return;
            }
            AdDownloadStateQueryUtil.a().put(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.getTicket(), new SoftReference(localObject3));
            DownloadInfo localDownloadInfo = DownloadManagerV2.a().b(((ADVideoAppDownloadData)localObject3).c);
            if (localDownloadInfo != null)
            {
              localObject1 = localDownloadInfo;
              if (localDownloadInfo.a() != 1) {}
            }
            else
            {
              localObject1 = DownloadManagerV2.a().c(((ADVideoAppDownloadData)localObject3).d);
            }
            if (localObject1 == null)
            {
              this.jdField_a_of_type_AndroidWebkitValueCallback.onReceiveValue(Integer.valueOf(0));
              return;
            }
            AdDownloadStateQueryUtil.a((DownloadInfo)localObject1);
            i = ((DownloadInfo)localObject1).a();
            if (i == 1) {
              break label318;
            }
            if (i == 2) {
              break label350;
            }
            if (i == 3) {
              break label345;
            }
            if (i == 4) {
              break label340;
            }
            if (i == 10) {
              break label334;
            }
            if (i == 20) {
              break label329;
            }
            if ((i == 30) || (i == 40)) {
              break label323;
            }
            break label318;
            this.jdField_a_of_type_AndroidWebkitValueCallback.onReceiveValue(Integer.valueOf(i));
            return;
          }
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
      Object localObject2 = null;
      continue;
      label318:
      int i = 0;
      continue;
      label323:
      i = 6;
      continue;
      label329:
      i = 2;
      continue;
      label334:
      i = 7;
      continue;
      label340:
      i = 5;
      continue;
      label345:
      i = 4;
      continue;
      label350:
      i = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadStateQueryUtil.3
 * JD-Core Version:    0.7.0.1
 */