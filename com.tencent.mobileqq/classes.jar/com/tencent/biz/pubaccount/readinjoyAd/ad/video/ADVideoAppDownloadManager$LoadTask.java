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
        l = System.currentTimeMillis();
        this.jdField_a_of_type_Int += 1;
        ADVideoAppDownloadData localADVideoAppDownloadData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
        if (!localADVideoAppDownloadData.a()) {
          break label192;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ADVideoAppDownloadManager", 2, "mLoadAppJob loader sucess!!! " + localADVideoAppDownloadData.c);
        }
        if ((ADVideoAppDownloadManager.a(localADVideoAppDownloadManager) != null) && (!TextUtils.isEmpty(ADVideoAppDownloadManager.a(localADVideoAppDownloadManager).d)) && (ADVideoAppDownloadManager.a(localADVideoAppDownloadManager).d.equals(localADVideoAppDownloadData.d))) {
          localADVideoAppDownloadManager.a(localADVideoAppDownloadData);
        }
        ADVideoAppDownloadManager.a(localADVideoAppDownloadManager, true, System.currentTimeMillis() - l);
      }
    }
    catch (Exception localException)
    {
      ADVideoAppDownloadManager localADVideoAppDownloadManager;
      long l;
      while (QLog.isColorLevel())
      {
        QLog.d("ADVideoAppDownloadManager", 2, " mLoadAppJob exception");
        return;
        label192:
        QLog.d("ADVideoAppDownloadManager", 1, "mLoadAppJob loader failed!!!");
        ADVideoAppDownloadManager.a(localException, false, System.currentTimeMillis() - l);
      }
    }
    localADVideoAppDownloadManager = (ADVideoAppDownloadManager)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localADVideoAppDownloadManager != null)
    {
      ADVideoAppDownloadManager.a(localADVideoAppDownloadManager, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadManager.LoadTask
 * JD-Core Version:    0.7.0.1
 */