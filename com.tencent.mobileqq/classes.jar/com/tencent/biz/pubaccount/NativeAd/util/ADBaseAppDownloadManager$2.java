package com.tencent.biz.pubaccount.NativeAd.util;

import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Iterator;
import java.util.List;
import oil;
import ukq;
import ule;

public class ADBaseAppDownloadManager$2
  implements Runnable
{
  public ADBaseAppDownloadManager$2(oil paramoil, DownloadInfo paramDownloadInfo, int paramInt) {}
  
  public void run()
  {
    ule localule;
    label139:
    do
    {
      try
      {
        if (this.this$0.a.size() == 0) {
          ukq.a("ADBaseAppDownloadManager", "notifyState error : empty downloads");
        }
        Iterator localIterator = this.this$0.a.iterator();
        while (localIterator.hasNext())
        {
          localule = (ule)localIterator.next();
          if ((localule.d != null) && (localule.jdField_a_of_type_JavaLangString != null)) {
            break label139;
          }
          ukq.a("ADBaseAppDownloadManager", "notifyState error : packageName = " + localule.d + " appId = " + localule.jdField_a_of_type_JavaLangString);
        }
        return;
      }
      catch (Exception localException)
      {
        ukq.a("ADBaseAppDownloadManager", "notifyState error " + localException.getMessage());
      }
    } while (!localule.d.equals(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.e));
    localule.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localule.b = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f;
    ukq.a("ADBaseAppDownloadManager", "notifyState success : progress = " + this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f + " packageName = " + localule.d + " appId = " + localule.jdField_a_of_type_JavaLangString);
    if (localule.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
    {
      localule.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState = this.jdField_a_of_type_Int;
      localule.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.progress = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f;
    }
    if (localule.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null)
    {
      localule.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.b = this.jdField_a_of_type_Int;
      localule.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.c = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f;
    }
    if (localule.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null)
    {
      localule.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.i = this.jdField_a_of_type_Int;
      localule.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.h = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f;
    }
    ukq.a("ADBaseAppDownloadManager", "progress " + this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f);
    this.this$0.a(localule, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager.2
 * JD-Core Version:    0.7.0.1
 */