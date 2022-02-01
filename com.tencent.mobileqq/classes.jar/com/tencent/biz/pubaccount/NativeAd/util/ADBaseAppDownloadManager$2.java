package com.tencent.biz.pubaccount.NativeAd.util;

import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Iterator;
import java.util.List;
import nxp;
import oqh;
import orb;

public class ADBaseAppDownloadManager$2
  implements Runnable
{
  public ADBaseAppDownloadManager$2(nxp paramnxp, DownloadInfo paramDownloadInfo, int paramInt) {}
  
  public void run()
  {
    orb localorb;
    label139:
    do
    {
      try
      {
        if (this.this$0.a.size() == 0) {
          oqh.a("ADBaseAppDownloadManager", "notifyState error : empty downloads");
        }
        Iterator localIterator = this.this$0.a.iterator();
        while (localIterator.hasNext())
        {
          localorb = (orb)localIterator.next();
          if ((localorb.d != null) && (localorb.jdField_a_of_type_JavaLangString != null)) {
            break label139;
          }
          oqh.a("ADBaseAppDownloadManager", "notifyState error : packageName = " + localorb.d + " appId = " + localorb.jdField_a_of_type_JavaLangString);
        }
        return;
      }
      catch (Exception localException)
      {
        oqh.a("ADBaseAppDownloadManager", "notifyState error " + localException.getMessage());
      }
    } while (!localorb.d.equals(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.e));
    localorb.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localorb.b = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f;
    oqh.a("ADBaseAppDownloadManager", "notifyState success : progress = " + this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f + " packageName = " + localorb.d + " appId = " + localorb.jdField_a_of_type_JavaLangString);
    if (localorb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
    {
      localorb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState = this.jdField_a_of_type_Int;
      localorb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.progress = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f;
    }
    if (localorb.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null)
    {
      localorb.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.b = this.jdField_a_of_type_Int;
      localorb.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.c = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f;
    }
    if (localorb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null)
    {
      localorb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k = this.jdField_a_of_type_Int;
      localorb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.j = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f;
    }
    oqh.a("ADBaseAppDownloadManager", "progress " + this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f);
    this.this$0.a(localorb, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager.2
 * JD-Core Version:    0.7.0.1
 */