package com.tencent.mobileqq.ar.ARPromotionMgr;

import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ArConfigService;
import com.tencent.mobileqq.ar.aidl.IArConfigManager;
import com.tencent.mobileqq.ar.aidl.IArSoCallback;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class DownloadDependRes
{
  ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = null;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  IArConfigManager jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager = null;
  private IArSoCallback jdField_a_of_type_ComTencentMobileqqArAidlIArSoCallback = null;
  
  void a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqArAidlIArSoCallback != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager.b(this.jdField_a_of_type_ComTencentMobileqqArAidlIArSoCallback);
          this.jdField_a_of_type_ComTencentMobileqqArAidlIArSoCallback = null;
        }
        if (this.jdField_a_of_type_AndroidContentServiceConnection != null)
        {
          this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
          this.jdField_a_of_type_AndroidContentServiceConnection = null;
        }
        this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager = null;
      }
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
      return;
    }
    catch (Exception localException)
    {
      QLog.w(PromotionUtil.a, 1, "DownloadDependRes.clean, Exception", localException);
    }
  }
  
  void a(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    if (!ArConfigService.e(BaseApplicationImpl.getApplication().getRuntime()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(PromotionUtil.a, 1, "tryDownload, so未准备");
      }
      b();
    }
  }
  
  void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager != null) {}
    do
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager.c();
        return;
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d(PromotionUtil.a, 2, "downloadArSo Exception", localException);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqArAidlIArSoCallback = new DownloadDependRes.1(this);
      this.jdField_a_of_type_AndroidContentServiceConnection = new DownloadDependRes.2(this);
    } while (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null);
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), ArConfigService.class);
    boolean bool = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().bindService(localIntent, this.jdField_a_of_type_AndroidContentServiceConnection, 1);
    QLog.w(PromotionUtil.a, 1, "bindServer, ret[" + bool + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotionMgr.DownloadDependRes
 * JD-Core Version:    0.7.0.1
 */