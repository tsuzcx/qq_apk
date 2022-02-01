package com.tencent.mobileqq.activity.bless;

import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class BlessManager$3
  extends DownloadListener
{
  BlessManager$3(BlessManager paramBlessManager, String paramString1, String paramString2) {}
  
  public void onCancel(DownloadTask paramDownloadTask)
  {
    BlessManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager).remove(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    BlessManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager).remove(this.jdField_a_of_type_JavaLangString);
    if (paramDownloadTask.a() == 3)
    {
      if (QLog.isColorLevel())
      {
        paramDownloadTask = new StringBuilder();
        paramDownloadTask.append("download finished ");
        paramDownloadTask.append(this.b);
        QLog.d("BlessManager", 2, paramDownloadTask.toString());
      }
      if ((this.b != null) && (BlessManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager) != null) && (this.b.equals(BlessManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager).starVideo)))
      {
        BlessManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager);
        return;
      }
      BlessManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager);
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("downloadFile failed: ");
      localStringBuilder.append(paramDownloadTask.b);
      localStringBuilder.append(" code=");
      localStringBuilder.append(paramDownloadTask.a);
      QLog.d("BlessManager", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessManager.3
 * JD-Core Version:    0.7.0.1
 */