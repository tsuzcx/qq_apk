package com.tencent.biz.pubaccount.readinjoyAd.ad.video;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ADVideoAppDownloadManager$LoadTask
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private ADVideoAppDownloadData jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
  private WeakReference<ADVideoAppDownloadManager> jdField_a_of_type_JavaLangRefWeakReference;
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ADVideoAppDownloadManager", 2, " mLoadAppJob running... ");
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData != null)
      {
        localADVideoAppDownloadManager = (ADVideoAppDownloadManager)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localADVideoAppDownloadManager == null) {
          return;
        }
        long l = System.currentTimeMillis();
        this.jdField_a_of_type_Int += 1;
        ADVideoAppDownloadData localADVideoAppDownloadData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
        if (localADVideoAppDownloadData.a())
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("mLoadAppJob loader sucess!!! ");
            localStringBuilder.append(localADVideoAppDownloadData.c);
            QLog.d("ADVideoAppDownloadManager", 2, localStringBuilder.toString());
          }
          if ((ADVideoAppDownloadManager.a(localADVideoAppDownloadManager) != null) && (!TextUtils.isEmpty(ADVideoAppDownloadManager.a(localADVideoAppDownloadManager).d)) && (ADVideoAppDownloadManager.a(localADVideoAppDownloadManager).d.equals(localADVideoAppDownloadData.d))) {
            localADVideoAppDownloadManager.a(localADVideoAppDownloadData);
          }
          ADVideoAppDownloadManager.a(localADVideoAppDownloadManager, true, System.currentTimeMillis() - l);
        }
        else
        {
          QLog.d("ADVideoAppDownloadManager", 1, "mLoadAppJob loader failed!!!");
          ADVideoAppDownloadManager.a(localADVideoAppDownloadManager, false, System.currentTimeMillis() - l);
        }
      }
      ADVideoAppDownloadManager localADVideoAppDownloadManager = (ADVideoAppDownloadManager)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localADVideoAppDownloadManager == null) {
        break label221;
      }
      ADVideoAppDownloadManager.a(localADVideoAppDownloadManager, false);
      return;
    }
    catch (Exception localException)
    {
      label207:
      label221:
      break label207;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppDownloadManager", 2, " mLoadAppJob exception");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadManager.LoadTask
 * JD-Core Version:    0.7.0.1
 */