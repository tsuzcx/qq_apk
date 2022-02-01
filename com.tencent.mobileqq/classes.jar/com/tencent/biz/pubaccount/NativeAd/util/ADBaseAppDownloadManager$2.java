package com.tencent.biz.pubaccount.NativeAd.util;

import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Iterator;
import java.util.List;
import nzj;
import tpx;
import tqt;

public class ADBaseAppDownloadManager$2
  implements Runnable
{
  public ADBaseAppDownloadManager$2(nzj paramnzj, DownloadInfo paramDownloadInfo, int paramInt) {}
  
  public void run()
  {
    tqt localtqt;
    label139:
    do
    {
      try
      {
        if (this.this$0.a.size() == 0) {
          tpx.a("ADBaseAppDownloadManager", "notifyState error : empty downloads");
        }
        Iterator localIterator = this.this$0.a.iterator();
        while (localIterator.hasNext())
        {
          localtqt = (tqt)localIterator.next();
          if ((localtqt.d != null) && (localtqt.jdField_a_of_type_JavaLangString != null)) {
            break label139;
          }
          tpx.a("ADBaseAppDownloadManager", "notifyState error : packageName = " + localtqt.d + " appId = " + localtqt.jdField_a_of_type_JavaLangString);
        }
        return;
      }
      catch (Exception localException)
      {
        tpx.a("ADBaseAppDownloadManager", "notifyState error " + localException.getMessage());
      }
    } while (!localtqt.d.equals(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.e));
    localtqt.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localtqt.b = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f;
    tpx.a("ADBaseAppDownloadManager", "notifyState success : progress = " + this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f + " packageName = " + localtqt.d + " appId = " + localtqt.jdField_a_of_type_JavaLangString);
    if (localtqt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
    {
      localtqt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState = this.jdField_a_of_type_Int;
      localtqt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.progress = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f;
    }
    if (localtqt.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null)
    {
      localtqt.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.b = this.jdField_a_of_type_Int;
      localtqt.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.c = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f;
    }
    if (localtqt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null)
    {
      localtqt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.i = this.jdField_a_of_type_Int;
      localtqt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.h = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f;
    }
    tpx.a("ADBaseAppDownloadManager", "progress " + this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f);
    this.this$0.a(localtqt, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager.2
 * JD-Core Version:    0.7.0.1
 */