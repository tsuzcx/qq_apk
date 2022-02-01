package com.tencent.biz.pubaccount.serviceAccountFolder;

import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class ServiceAccountFolderFeedAdapter$3
  implements Runnable
{
  ServiceAccountFolderFeedAdapter$3(ServiceAccountFolderFeedAdapter paramServiceAccountFolderFeedAdapter, ServiceAccountFolderFeed paramServiceAccountFolderFeed) {}
  
  public void run()
  {
    try
    {
      if (ServiceAccountFolderFeedAdapter.a(this.this$0, this.a.jdField_a_of_type_JavaLangString))
      {
        String str2 = this.a.jdField_a_of_type_JavaLangString;
        String str3 = this.a.c;
        if (this.a.jdField_a_of_type_JavaLangCharSequence == null) {}
        for (String str1 = "";; str1 = this.a.jdField_a_of_type_JavaLangCharSequence.toString())
        {
          ReportController.b(null, "dc00898", "", str2, "auth_page", "left_delete", 0, 0, "", "", str3, str1);
          return;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ServiceAccountFolderFeedAdapter", 2, QLog.getStackTraceString(localException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeedAdapter.3
 * JD-Core Version:    0.7.0.1
 */