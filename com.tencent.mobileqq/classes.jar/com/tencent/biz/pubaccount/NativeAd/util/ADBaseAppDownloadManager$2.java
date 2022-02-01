package com.tencent.biz.pubaccount.NativeAd.util;

import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Iterator;
import java.util.List;

class ADBaseAppDownloadManager$2
  implements Runnable
{
  ADBaseAppDownloadManager$2(ADBaseAppDownloadManager paramADBaseAppDownloadManager, DownloadInfo paramDownloadInfo, int paramInt) {}
  
  public void run()
  {
    try
    {
      if (this.this$0.a.size() == 0) {
        ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("ADBaseAppDownloadManager", "notifyState error : empty downloads");
      }
      Object localObject1 = this.this$0.a.iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        ADVideoAppDownloadData localADVideoAppDownloadData = (ADVideoAppDownloadData)((Iterator)localObject1).next();
        localObject2 = localADVideoAppDownloadData.d;
        if ((localObject2 != null) && (localADVideoAppDownloadData.jdField_a_of_type_JavaLangString != null))
        {
          if (localADVideoAppDownloadData.d.equals(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.e))
          {
            localADVideoAppDownloadData.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
            localADVideoAppDownloadData.b = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f;
            localObject1 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("notifyState success : progress = ");
            ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f);
            ((StringBuilder)localObject2).append(" packageName = ");
            ((StringBuilder)localObject2).append(localADVideoAppDownloadData.d);
            ((StringBuilder)localObject2).append(" appId = ");
            ((StringBuilder)localObject2).append(localADVideoAppDownloadData.jdField_a_of_type_JavaLangString);
            ((IRIJAdLogService)localObject1).d("ADBaseAppDownloadManager", ((StringBuilder)localObject2).toString());
            if (localADVideoAppDownloadData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
            {
              localADVideoAppDownloadData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState = this.jdField_a_of_type_Int;
              localADVideoAppDownloadData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.progress = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f;
            }
            if (localADVideoAppDownloadData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData != null)
            {
              localADVideoAppDownloadData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData.b = this.jdField_a_of_type_Int;
              localADVideoAppDownloadData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData.c = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f;
            }
            if (localADVideoAppDownloadData.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebDataAdData != null)
            {
              localADVideoAppDownloadData.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebDataAdData.l = this.jdField_a_of_type_Int;
              localADVideoAppDownloadData.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebDataAdData.k = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f;
            }
            localObject1 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("progress ");
            ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f);
            ((IRIJAdLogService)localObject1).d("ADBaseAppDownloadManager", ((StringBuilder)localObject2).toString());
            this.this$0.a(localADVideoAppDownloadData, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f);
          }
        }
        else
        {
          localObject2 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("notifyState error : packageName = ");
          localStringBuilder.append(localADVideoAppDownloadData.d);
          localStringBuilder.append(" appId = ");
          localStringBuilder.append(localADVideoAppDownloadData.jdField_a_of_type_JavaLangString);
          ((IRIJAdLogService)localObject2).d("ADBaseAppDownloadManager", localStringBuilder.toString());
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localObject1 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("notifyState error ");
      ((StringBuilder)localObject2).append(localException.getMessage());
      ((IRIJAdLogService)localObject1).d("ADBaseAppDownloadManager", ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager.2
 * JD-Core Version:    0.7.0.1
 */