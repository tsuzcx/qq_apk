package com.tencent.biz.pubaccount.readinjoyAd.ad.video;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.open.appstore.dl.DownloadProxy;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;

class ADVideoAppDownloadManager$2
  implements Runnable
{
  public void run()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.d;
    String str1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.a;
    String str2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.e;
    Object localObject2;
    if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2))) {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("startRealDownload packageName:").append((String)localObject1).append(", appid:").append(str1).append(", appName:").append(str2);
        QLog.d("ADVideoAppDownloadManager", 2, ((StringBuilder)localObject2).toString());
      }
    }
    do
    {
      String str3;
      do
      {
        return;
        if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.c)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.b))) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.c = ADVideoAppDownloadManager.a(this.this$0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.b, 1);
        }
        str3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.c;
        if (!TextUtils.isEmpty(str3)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ADVideoAppDownloadManager", 2, "downloadUrl null");
      return;
      ReadInJoyAdLog.a("ADVideoAppDownloadManager", "VideoDownloadUrl : " + str3);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString(DownloadConstants.f, (String)localObject1);
      ((Bundle)localObject2).putString(DownloadConstants.b, str1);
      ((Bundle)localObject2).putString(DownloadConstants.j, str3);
      ((Bundle)localObject2).putString(DownloadConstants.l, str2);
      ((Bundle)localObject2).putInt(DownloadConstants.k, 2);
      ((Bundle)localObject2).putInt(DownloadConstants.F, 0);
      ((Bundle)localObject2).putBoolean(DownloadConstants.x, false);
      ((Bundle)localObject2).putInt(DownloadConstants.I, 0);
      ((Bundle)localObject2).putBoolean(DownloadConstants.y, true);
      ((Bundle)localObject2).putBoolean(DownloadConstants.h, true);
      ((Bundle)localObject2).putBoolean(DownloadConstants.r, false);
      ((Bundle)localObject2).putBoolean(DownloadConstants.K, false);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.f)) {
        ((Bundle)localObject2).putString(DownloadConstants.i, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.f);
      }
      ((Bundle)localObject2).putString("big_brother_ref_source_key", "biz_src_feeds_kandian");
      if (QLog.isColorLevel()) {
        QLog.d("ADVideoAppDownloadManager", 2, "startRealDownload pkg:" + (String)localObject1 + ", appid:" + str1 + ", name:" + str2 + ", url:" + str3);
      }
      this.this$0.a.remove(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData);
      this.this$0.a.add(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData);
      localObject1 = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject1 != null) && (!((Activity)localObject1).isFinishing())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ADVideoAppDownloadManager", 2, "ac=null");
    return;
    DownloadProxy.a().a((Activity)localObject1, (Bundle)localObject2, "biz_src_feeds_kandianads", null, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadManager.2
 * JD-Core Version:    0.7.0.1
 */