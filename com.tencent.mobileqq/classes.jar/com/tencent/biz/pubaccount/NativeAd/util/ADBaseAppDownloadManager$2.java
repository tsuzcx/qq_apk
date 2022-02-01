package com.tencent.biz.pubaccount.NativeAd.util;

import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Iterator;
import java.util.List;
import oau;
import twp;
import txh;

public class ADBaseAppDownloadManager$2
  implements Runnable
{
  public ADBaseAppDownloadManager$2(oau paramoau, DownloadInfo paramDownloadInfo, int paramInt) {}
  
  public void run()
  {
    txh localtxh;
    label139:
    do
    {
      try
      {
        if (this.this$0.a.size() == 0) {
          twp.a("ADBaseAppDownloadManager", "notifyState error : empty downloads");
        }
        Iterator localIterator = this.this$0.a.iterator();
        while (localIterator.hasNext())
        {
          localtxh = (txh)localIterator.next();
          if ((localtxh.d != null) && (localtxh.jdField_a_of_type_JavaLangString != null)) {
            break label139;
          }
          twp.a("ADBaseAppDownloadManager", "notifyState error : packageName = " + localtxh.d + " appId = " + localtxh.jdField_a_of_type_JavaLangString);
        }
        return;
      }
      catch (Exception localException)
      {
        twp.a("ADBaseAppDownloadManager", "notifyState error " + localException.getMessage());
      }
    } while (!localtxh.d.equals(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.e));
    localtxh.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localtxh.b = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f;
    twp.a("ADBaseAppDownloadManager", "notifyState success : progress = " + this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f + " packageName = " + localtxh.d + " appId = " + localtxh.jdField_a_of_type_JavaLangString);
    if (localtxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
    {
      localtxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState = this.jdField_a_of_type_Int;
      localtxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.progress = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f;
    }
    if (localtxh.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null)
    {
      localtxh.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.b = this.jdField_a_of_type_Int;
      localtxh.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.c = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f;
    }
    if (localtxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null)
    {
      localtxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.i = this.jdField_a_of_type_Int;
      localtxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.h = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f;
    }
    twp.a("ADBaseAppDownloadManager", "progress " + this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f);
    this.this$0.a(localtxh, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager.2
 * JD-Core Version:    0.7.0.1
 */