package com.tencent.mobileqq.app;

import ampm;
import ampp;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import protocol.KQQConfig.GetResourceRespInfo;

public class ConditionSearchManager$DownloadTask$1
  implements Runnable
{
  public ConditionSearchManager$DownloadTask$1(ampp paramampp, String paramString, File paramFile, QQAppInterface paramQQAppInterface, GetResourceRespInfo paramGetResourceRespInfo) {}
  
  public void run()
  {
    long l2 = -1L;
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearch.Manager", 2, "DownloadTask runnable start, url=" + this.jdField_a_of_type_JavaLangString);
    }
    Object localObject = MsfSdkUtils.insertMtype("ConfigCheck", this.jdField_a_of_type_JavaLangString);
    int i = HttpDownloadUtil.downloadData(ampp.a(this.this$0), (String)localObject, this.jdField_a_of_type_JavaIoFile);
    if (i == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearch.Manager", 2, "onCheckupConfig | download result = " + bool);
      }
      localObject = (ampm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
      if (localObject != null) {
        ((ampm)localObject).a(i, this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_ProtocolKQQConfigGetResourceRespInfo);
      }
      localObject = (PreDownloadController)ampp.b(this.this$0).getManager(193);
      String str = this.jdField_a_of_type_JavaLangString;
      long l1 = l2;
      if (bool)
      {
        l1 = l2;
        if (this.jdField_a_of_type_JavaIoFile.exists()) {
          l1 = this.jdField_a_of_type_JavaIoFile.length();
        }
      }
      ((PreDownloadController)localObject).preDownloadSuccess(str, l1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConditionSearchManager.DownloadTask.1
 * JD-Core Version:    0.7.0.1
 */