package com.tencent.biz.pubaccount.NativeAd.util;

import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Iterator;
import java.util.List;

class ADBaseAppDownloadManager$2
  implements Runnable
{
  ADBaseAppDownloadManager$2(ADBaseAppDownloadManager paramADBaseAppDownloadManager, DownloadInfo paramDownloadInfo, int paramInt) {}
  
  public void run()
  {
    ADVideoAppDownloadData localADVideoAppDownloadData;
    label139:
    do
    {
      try
      {
        if (this.this$0.a.size() == 0) {
          ReadInJoyAdLog.a("ADBaseAppDownloadManager", "notifyState error : empty downloads");
        }
        Iterator localIterator = this.this$0.a.iterator();
        while (localIterator.hasNext())
        {
          localADVideoAppDownloadData = (ADVideoAppDownloadData)localIterator.next();
          if ((localADVideoAppDownloadData.d != null) && (localADVideoAppDownloadData.jdField_a_of_type_JavaLangString != null)) {
            break label139;
          }
          ReadInJoyAdLog.a("ADBaseAppDownloadManager", "notifyState error : packageName = " + localADVideoAppDownloadData.d + " appId = " + localADVideoAppDownloadData.jdField_a_of_type_JavaLangString);
        }
        return;
      }
      catch (Exception localException)
      {
        ReadInJoyAdLog.a("ADBaseAppDownloadManager", "notifyState error " + localException.getMessage());
      }
    } while (!localADVideoAppDownloadData.d.equals(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.e));
    localADVideoAppDownloadData.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localADVideoAppDownloadData.b = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f;
    ReadInJoyAdLog.a("ADBaseAppDownloadManager", "notifyState success : progress = " + this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f + " packageName = " + localADVideoAppDownloadData.d + " appId = " + localADVideoAppDownloadData.jdField_a_of_type_JavaLangString);
    if (localADVideoAppDownloadData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
    {
      localADVideoAppDownloadData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState = this.jdField_a_of_type_Int;
      localADVideoAppDownloadData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.progress = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f;
    }
    if (localADVideoAppDownloadData.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null)
    {
      localADVideoAppDownloadData.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.b = this.jdField_a_of_type_Int;
      localADVideoAppDownloadData.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.c = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f;
    }
    if (localADVideoAppDownloadData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null)
    {
      localADVideoAppDownloadData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.j = this.jdField_a_of_type_Int;
      localADVideoAppDownloadData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.i = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f;
    }
    ReadInJoyAdLog.a("ADBaseAppDownloadManager", "progress " + this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f);
    this.this$0.a(localADVideoAppDownloadData, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager.2
 * JD-Core Version:    0.7.0.1
 */