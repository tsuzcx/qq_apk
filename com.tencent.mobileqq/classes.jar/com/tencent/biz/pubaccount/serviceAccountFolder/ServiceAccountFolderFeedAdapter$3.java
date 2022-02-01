package com.tencent.biz.pubaccount.serviceAccountFolder;

import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class ServiceAccountFolderFeedAdapter$3
  implements Runnable
{
  ServiceAccountFolderFeedAdapter$3(ServiceAccountFolderFeedAdapter paramServiceAccountFolderFeedAdapter, ServiceAccountFolderFeed paramServiceAccountFolderFeed) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (!ServiceAccountFolderFeedAdapter.a(this.this$0, this.a.jdField_a_of_type_JavaLangString)) {
          break label98;
        }
        str2 = this.a.jdField_a_of_type_JavaLangString;
        str3 = this.a.c;
        if (this.a.jdField_a_of_type_JavaLangCharSequence == null) {
          str1 = "";
        } else {
          str1 = this.a.jdField_a_of_type_JavaLangCharSequence.toString();
        }
      }
      catch (Exception localException)
      {
        String str2;
        String str3;
        String str1;
        QLog.e("ServiceAccountFolderFeedAdapter", 2, QLog.getStackTraceString(localException));
      }
      ReportController.b(null, "dc00898", "", str2, "auth_page", "left_delete", 0, 0, "", "", str3, str1);
      return;
      label98:
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeedAdapter.3
 * JD-Core Version:    0.7.0.1
 */