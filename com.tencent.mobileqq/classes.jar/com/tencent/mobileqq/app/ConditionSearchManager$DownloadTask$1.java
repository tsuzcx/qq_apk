package com.tencent.mobileqq.app;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import protocol.KQQConfig.GetResourceRespInfo;

class ConditionSearchManager$DownloadTask$1
  implements Runnable
{
  ConditionSearchManager$DownloadTask$1(ConditionSearchManager.DownloadTask paramDownloadTask, String paramString, File paramFile, BaseQQAppInterface paramBaseQQAppInterface, GetResourceRespInfo paramGetResourceRespInfo) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("DownloadTask runnable start, url=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      QLog.d("ConditionSearch.Manager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = MsfSdkUtils.insertMtype("ConfigCheck", this.jdField_a_of_type_JavaLangString);
    int i = HttpDownloadUtil.downloadData(ConditionSearchManager.DownloadTask.a(this.this$0), (String)localObject, this.jdField_a_of_type_JavaIoFile);
    boolean bool;
    if (i == 0) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCheckupConfig | download result = ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("ConditionSearch.Manager", 2, ((StringBuilder)localObject).toString());
    }
    localObject = (ConditionSearchManager)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER);
    if (localObject != null) {
      ((ConditionSearchManager)localObject).a(i, this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_ProtocolKQQConfigGetResourceRespInfo);
    }
    localObject = (IPreDownloadController)ConditionSearchManager.DownloadTask.b(this.this$0).getRuntimeService(IPreDownloadController.class);
    String str = this.jdField_a_of_type_JavaLangString;
    long l2 = -1L;
    long l1 = l2;
    if (bool)
    {
      l1 = l2;
      if (this.jdField_a_of_type_JavaIoFile.exists()) {
        l1 = this.jdField_a_of_type_JavaIoFile.length();
      }
    }
    ((IPreDownloadController)localObject).preDownloadSuccess(str, l1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConditionSearchManager.DownloadTask.1
 * JD-Core Version:    0.7.0.1
 */