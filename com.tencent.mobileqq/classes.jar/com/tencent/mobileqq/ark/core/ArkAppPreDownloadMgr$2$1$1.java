package com.tencent.mobileqq.ark.core;

import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback;
import com.tencent.mobileqq.ark.config.PreloadItem;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

class ArkAppPreDownloadMgr$2$1$1
  implements ArkAppMgr.IGetAppPathByNameCallback
{
  ArkAppPreDownloadMgr$2$1$1(ArkAppPreDownloadMgr.2.1 param1) {}
  
  public void onGetAppPathByName(int paramInt, String paramString, ArkAppMgr.AppPathInfo paramAppPathInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkApp.ArkAppPreDownloadMgr", 2, new Object[] { "profiling preDownloadApp app=", this.a.jdField_a_of_type_ComTencentMobileqqArkCoreArkAppPreDownloadMgr$2.a.a, ",retcode=", Integer.valueOf(paramInt), ",msg=", paramString });
    }
    if ((AppRuntime)ArkAppPreDownloadMgr.a(this.a.jdField_a_of_type_ComTencentMobileqqArkCoreArkAppPreDownloadMgr$2.this$0).get() == null) {
      return;
    }
    if ((paramInt == 0) && (paramAppPathInfo != null) && (paramAppPathInfo.path != null))
    {
      long l = 0L;
      paramString = new File(paramAppPathInfo.path);
      if (paramString.exists()) {
        l = paramString.length();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkAppPreDownloadMgr", 2, new Object[] { "profiling preDownloadApp app=", this.a.jdField_a_of_type_ComTencentMobileqqArkCoreArkAppPreDownloadMgr$2.a.a, ",filesize=", Long.valueOf(l) });
      }
      this.a.jdField_a_of_type_ComTencentMobileqqArkCoreArkPredownloader$Task.a(this.a.jdField_a_of_type_ComTencentMobileqqArkCoreArkAppPreDownloadMgr$2.a.a, l);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqArkCoreArkPredownloader$Task.a(this.a.jdField_a_of_type_ComTencentMobileqqArkCoreArkAppPreDownloadMgr$2.a.a, -1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.core.ArkAppPreDownloadMgr.2.1.1
 * JD-Core Version:    0.7.0.1
 */