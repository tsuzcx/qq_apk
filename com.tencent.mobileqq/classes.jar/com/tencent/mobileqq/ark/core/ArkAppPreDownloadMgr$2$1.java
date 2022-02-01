package com.tencent.mobileqq.ark.core;

import android.text.TextUtils;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.mobileqq.ark.config.PreloadItem;
import com.tencent.qphone.base.util.QLog;

class ArkAppPreDownloadMgr$2$1
  implements Runnable
{
  ArkAppPreDownloadMgr$2$1(ArkAppPreDownloadMgr.2 param2, ArkPredownloader.Task paramTask) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArkCoreArkAppPreDownloadMgr$2.a.a)) {
      return;
    }
    if (!TextUtils.isEmpty(ArkAppMgr.getInstance().getAppPathFromLocal(this.jdField_a_of_type_ComTencentMobileqqArkCoreArkAppPreDownloadMgr$2.a.a)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkAppPreDownloadMgr", 2, new Object[] { "profiling preDownloadApp app", this.jdField_a_of_type_ComTencentMobileqqArkCoreArkAppPreDownloadMgr$2.a.a, "allready downloaded" });
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArkApp.ArkAppPreDownloadMgr", 2, new Object[] { "profiling preDownloadApp begin app = ", this.jdField_a_of_type_ComTencentMobileqqArkCoreArkAppPreDownloadMgr$2.a.a });
    }
    ArkAppMgr.getInstance().getAppPathByName(this.jdField_a_of_type_ComTencentMobileqqArkCoreArkAppPreDownloadMgr$2.a.a, "0.0.0.1", new ArkAppPreDownloadMgr.2.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.core.ArkAppPreDownloadMgr.2.1
 * JD-Core Version:    0.7.0.1
 */