package com.tencent.biz.pubaccount.readinjoyAd.ad.video;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import txh;

public class ADVideoAppDownloadManager$LoadTask
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private WeakReference<ADVideoAppDownloadManager> jdField_a_of_type_JavaLangRefWeakReference;
  private txh jdField_a_of_type_Txh;
  
  public ADVideoAppDownloadManager$LoadTask(ADVideoAppDownloadManager paramADVideoAppDownloadManager, txh paramtxh)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramADVideoAppDownloadManager);
    this.jdField_a_of_type_Txh = paramtxh;
  }
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ADVideoAppDownloadManager", 2, " mLoadAppJob running... ");
      }
      if (this.jdField_a_of_type_Txh != null)
      {
        localADVideoAppDownloadManager = (ADVideoAppDownloadManager)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localADVideoAppDownloadManager == null) {
          return;
        }
        l = System.currentTimeMillis();
        this.jdField_a_of_type_Int += 1;
        txh localtxh = this.jdField_a_of_type_Txh;
        if (!localtxh.a()) {
          break label192;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ADVideoAppDownloadManager", 2, "mLoadAppJob loader sucess!!! " + localtxh.c);
        }
        if ((ADVideoAppDownloadManager.a(localADVideoAppDownloadManager) != null) && (!TextUtils.isEmpty(ADVideoAppDownloadManager.a(localADVideoAppDownloadManager).d)) && (ADVideoAppDownloadManager.a(localADVideoAppDownloadManager).d.equals(localtxh.d))) {
          localADVideoAppDownloadManager.a(localtxh);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadManager.LoadTask
 * JD-Core Version:    0.7.0.1
 */