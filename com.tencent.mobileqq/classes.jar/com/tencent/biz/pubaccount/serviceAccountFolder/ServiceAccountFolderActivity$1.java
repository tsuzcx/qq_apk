package com.tencent.biz.pubaccount.serviceAccountFolder;

import mqq.os.MqqHandler;

class ServiceAccountFolderActivity$1
  implements Runnable
{
  ServiceAccountFolderActivity$1(ServiceAccountFolderActivity paramServiceAccountFolderActivity) {}
  
  public void run()
  {
    ServiceAccountFolderManager localServiceAccountFolderManager = ServiceAccountFolderManager.a();
    ServiceAccountFolderActivity.a(this.this$0, localServiceAccountFolderManager.b());
    ServiceAccountFolderActivity.a(this.this$0).sendEmptyMessage(101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity.1
 * JD-Core Version:    0.7.0.1
 */