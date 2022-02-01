package com.tencent.biz.pubaccount.serviceAccountFolder;

import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class ServiceAccountFolderFeedAdapter$1
  implements Runnable
{
  ServiceAccountFolderFeedAdapter$1(ServiceAccountFolderFeedAdapter paramServiceAccountFolderFeedAdapter, ServiceAccountFolderFeed paramServiceAccountFolderFeed) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (!ServiceAccountFolderFeedAdapter.a(this.this$0, this.a.b)) {
          break label98;
        }
        str2 = this.a.b;
        str3 = this.a.h;
        if (this.a.i == null) {
          str1 = "";
        } else {
          str1 = this.a.i.toString();
        }
      }
      catch (Exception localException)
      {
        String str2;
        String str3;
        String str1;
        QLog.e("ServiceAccountFolderFeedAdapter", 2, QLog.getStackTraceString(localException));
      }
      ReportController.b(null, "dc00898", "", str2, "auth_page", "left_unfollow", 0, 0, "", "", str3, str1);
      return;
      label98:
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeedAdapter.1
 * JD-Core Version:    0.7.0.1
 */