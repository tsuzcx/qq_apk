package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import pxh;

public class ADVideoAppDownloadManager$LoadTask
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private WeakReference<ADVideoAppDownloadManager> jdField_a_of_type_JavaLangRefWeakReference;
  private pxh jdField_a_of_type_Pxh;
  
  public ADVideoAppDownloadManager$LoadTask(ADVideoAppDownloadManager paramADVideoAppDownloadManager, pxh parampxh)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramADVideoAppDownloadManager);
    this.jdField_a_of_type_Pxh = parampxh;
  }
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ADVideoAppDownloadManager", 2, " mLoadAppJob running... ");
      }
      if (this.jdField_a_of_type_Pxh != null)
      {
        localADVideoAppDownloadManager = (ADVideoAppDownloadManager)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localADVideoAppDownloadManager == null) {
          return;
        }
        l = System.currentTimeMillis();
        this.jdField_a_of_type_Int += 1;
        pxh localpxh = this.jdField_a_of_type_Pxh;
        if (!localpxh.a()) {
          break label192;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ADVideoAppDownloadManager", 2, "mLoadAppJob loader sucess!!! " + localpxh.c);
        }
        if ((ADVideoAppDownloadManager.a(localADVideoAppDownloadManager) != null) && (!TextUtils.isEmpty(ADVideoAppDownloadManager.a(localADVideoAppDownloadManager).d)) && (ADVideoAppDownloadManager.a(localADVideoAppDownloadManager).d.equals(localpxh.d))) {
          localADVideoAppDownloadManager.a(localpxh);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.ADVideoAppDownloadManager.LoadTask
 * JD-Core Version:    0.7.0.1
 */