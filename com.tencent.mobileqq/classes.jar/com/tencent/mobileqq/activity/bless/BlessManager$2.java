package com.tencent.mobileqq.activity.bless;

import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class BlessManager$2
  extends DownloadListener
{
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
        paramDownloadTask.append(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessPtvModule.id);
        QLog.d("BlessManager", 2, paramDownloadTask.toString());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessPtvModule))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessPtvModule.broken = false;
        BlessManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager);
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("downloadZipFile failed: ");
        localStringBuilder.append(paramDownloadTask.b);
        localStringBuilder.append(" code=");
        localStringBuilder.append(paramDownloadTask.a);
        QLog.d("BlessManager", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessPtvModule, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessManager.2
 * JD-Core Version:    0.7.0.1
 */