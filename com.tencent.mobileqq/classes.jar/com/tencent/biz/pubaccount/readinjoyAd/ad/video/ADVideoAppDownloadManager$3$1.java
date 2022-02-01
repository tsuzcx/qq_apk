package com.tencent.biz.pubaccount.readinjoyAd.ad.video;

import android.text.TextUtils;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.util.Iterator;
import java.util.List;

class ADVideoAppDownloadManager$3$1
  implements Runnable
{
  ADVideoAppDownloadManager$3$1(ADVideoAppDownloadManager.3 param3, String paramString, int paramInt) {}
  
  public void run()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager$3.a.a.iterator();
    ADVideoAppDownloadData localADVideoAppDownloadData;
    label233:
    do
    {
      int j;
      int i;
      while (((Iterator)localObject1).hasNext())
      {
        localADVideoAppDownloadData = (ADVideoAppDownloadData)((Iterator)localObject1).next();
        Object localObject2 = localADVideoAppDownloadData.c;
        j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager$3.a.a(localADVideoAppDownloadData);
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (((String)localObject2).equals(this.jdField_a_of_type_JavaLangString)) && ((j == 0) || (j == 4) || (j == 3)))
        {
          localObject2 = DownloadManagerV2.a().a((String)localObject2);
          i = 0;
          if (localObject2 != null) {
            i = (int)((float)((TMAssistantDownloadTaskInfo)localObject2).mReceiveDataLen / (float)((TMAssistantDownloadTaskInfo)localObject2).mTotalDataLen * 100.0F);
          }
          if ((j != 3) || (this.jdField_a_of_type_Int != 3)) {
            break label233;
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager$3.a.b(localADVideoAppDownloadData);
          localObject1 = new DownloadInfo();
          ((DownloadInfo)localObject1).e = localADVideoAppDownloadData.d;
          ((DownloadInfo)localObject1).f = i;
          ((DownloadInfo)localObject1).c = localADVideoAppDownloadData.jdField_a_of_type_JavaLangString;
          ADVideoAppDownloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager$3.a).a = true;
          ADVideoAppDownloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager$3.a).a();
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager$3.a.a((DownloadInfo)localObject1, 4);
        }
      }
      return;
      if ((j == 4) && ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 1)))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager$3.a.a(localADVideoAppDownloadData);
        localObject1 = new DownloadInfo();
        ((DownloadInfo)localObject1).e = localADVideoAppDownloadData.d;
        ((DownloadInfo)localObject1).f = i;
        ((DownloadInfo)localObject1).c = localADVideoAppDownloadData.jdField_a_of_type_JavaLangString;
        ADVideoAppDownloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager$3.a).a = true;
        ADVideoAppDownloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager$3.a).a();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager$3.a.a((DownloadInfo)localObject1, 3);
        return;
      }
    } while (this.jdField_a_of_type_Int != 4);
    localObject1 = new DownloadInfo();
    ((DownloadInfo)localObject1).e = localADVideoAppDownloadData.d;
    ((DownloadInfo)localObject1).f = 100;
    ((DownloadInfo)localObject1).c = localADVideoAppDownloadData.jdField_a_of_type_JavaLangString;
    ADVideoAppDownloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager$3.a).a = true;
    ADVideoAppDownloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager$3.a).a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager$3.a.a((DownloadInfo)localObject1, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadManager.3.1
 * JD-Core Version:    0.7.0.1
 */