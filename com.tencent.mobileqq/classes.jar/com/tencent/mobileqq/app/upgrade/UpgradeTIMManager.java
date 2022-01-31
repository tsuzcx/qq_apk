package com.tencent.mobileqq.app.upgrade;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.common.offline.util.OfflineDownloader;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import ztj;

public class UpgradeTIMManager
  implements INetInfoHandler, Manager
{
  private static final String jdField_a_of_type_JavaLangString = AppConstants.aJ + "tim";
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private OfflineDownloader jdField_a_of_type_ComTencentBizCommonOfflineUtilOfflineDownloader;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private UpgradeTIMWrapper jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeTIMWrapper;
  private File jdField_a_of_type_JavaIoFile;
  private ztj jdField_a_of_type_Ztj;
  private boolean jdField_a_of_type_Boolean;
  
  public UpgradeTIMManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizCommonOfflineUtilOfflineDownloader = new OfflineDownloader();
    this.jdField_a_of_type_JavaIoFile = new File(jdField_a_of_type_JavaLangString, "tim.apk");
  }
  
  private void a()
  {
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.getContext(), this);
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Ztj = new ztj(this, paramString1, paramString2);
    ThreadManager.post(this.jdField_a_of_type_Ztj, 5, null, true);
    a();
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_JavaIoFile.exists())
    {
      long l = this.jdField_a_of_type_JavaIoFile.lastModified();
      if ((System.currentTimeMillis() - l) / 86400000L > 14L) {
        this.jdField_a_of_type_JavaIoFile.delete();
      }
    }
    else
    {
      return false;
    }
    return true;
  }
  
  private void b()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    AppNetConnInfo.unregisterNetInfoHandler(this);
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void b(QQAppInterface paramQQAppInterface, UpgradeTIMWrapper paramUpgradeTIMWrapper)
  {
    if (QLog.isColorLevel()) {
      QLog.i("UpgradeTIMWrapper", 2, "UpgradeTIMManager |showUpgradeInfo");
    }
    paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.obtainMessage(1134045, paramUpgradeTIMWrapper).sendToTarget();
    }
  }
  
  private void c()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8008A48", "0X8008A48", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_JavaIoFile.exists())
    {
      PackageInfo localPackageInfo = BaseApplication.getContext().getPackageManager().getPackageArchiveInfo(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 64);
      if (localPackageInfo == null) {
        break label85;
      }
      if (!"com.tencent.tim".equals(localPackageInfo.packageName)) {
        this.jdField_a_of_type_JavaIoFile.delete();
      }
    }
    for (;;)
    {
      d();
      return;
      label85:
      this.jdField_a_of_type_JavaIoFile.delete();
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_Ztj = null;
    b();
    if (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeTIMWrapper != null) {
      b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeTIMWrapper);
    }
  }
  
  public void a(Context paramContext, String paramString)
  {
    int j = 0;
    int i = j;
    if (a())
    {
      i = j;
      if (UniformDownloadUtil.a(this.jdField_a_of_type_JavaIoFile.getAbsolutePath()) == 0) {
        i = 1;
      }
    }
    if (i == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeTIMManager", 2, "jumpToDownloadTIM| no existing apk file, download.");
      }
      Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("hide_operation_bar", true);
      paramContext.startActivity(localIntent);
      if (this.jdField_a_of_type_Ztj != null)
      {
        ztj.a(this.jdField_a_of_type_Ztj);
        this.jdField_a_of_type_Ztj = null;
      }
      b();
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, UpgradeTIMWrapper paramUpgradeTIMWrapper)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeTIMManager", 2, "onReceiveUpgradeInfo, with wrapper");
    }
    if (this.jdField_a_of_type_Ztj != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeTIMWrapper = paramUpgradeTIMWrapper;
      return;
    }
    if (a())
    {
      b(paramQQAppInterface, paramUpgradeTIMWrapper);
      return;
    }
    if (!NetworkUtil.h(BaseApplication.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeTIMManager", 2, "onReceiveUpgradeInfo, wifi not connected...");
      }
      b(paramQQAppInterface, paramUpgradeTIMWrapper);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeTIMWrapper = paramUpgradeTIMWrapper;
    a(paramUpgradeTIMWrapper.c, this.jdField_a_of_type_JavaIoFile.getPath());
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeTIMManager", 2, "onReceiveUpgradeInfo");
    }
    if (this.jdField_a_of_type_Ztj != null) {}
    while ((a()) || (!NetworkUtil.h(BaseApplication.getContext()))) {
      return;
    }
    a(paramString, this.jdField_a_of_type_JavaIoFile.getPath());
  }
  
  public void onDestroy()
  {
    b();
  }
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeTIMManager", 2, "onNetWifi2None, resume download");
    }
    if (this.jdField_a_of_type_Ztj != null) {
      ztj.b(this.jdField_a_of_type_Ztj);
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeTIMManager", 2, "onNetNone2Mobile, pause download");
    }
    if (this.jdField_a_of_type_Ztj != null) {
      ztj.a(this.jdField_a_of_type_Ztj);
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeTIMManager", 2, "onNetWifi2None, resume download");
    }
    if (this.jdField_a_of_type_Ztj != null) {
      ztj.b(this.jdField_a_of_type_Ztj);
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeTIMManager", 2, "onNetWifi2Mobile, pause download");
    }
    if (this.jdField_a_of_type_Ztj != null) {
      ztj.a(this.jdField_a_of_type_Ztj);
    }
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeTIMManager", 2, "onNetWifi2None, pause download");
    }
    if (this.jdField_a_of_type_Ztj != null) {
      ztj.a(this.jdField_a_of_type_Ztj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.upgrade.UpgradeTIMManager
 * JD-Core Version:    0.7.0.1
 */