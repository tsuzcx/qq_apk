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
      if (QLog.isColorLevel()) {
        QLog.d("BlessManager", 2, "download finished " + this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessPtvModule.id);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessPtvModule))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessPtvModule.broken = false;
        BlessManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "downloadZipFile failed: " + paramDownloadTask.b + " code=" + paramDownloadTask.a);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessPtvModule, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessManager.2
 * JD-Core Version:    0.7.0.1
 */