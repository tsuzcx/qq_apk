package com.tencent.biz.pubaccount.serviceAccountFolder;

import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.os.MqqHandler;

class ServiceAccountFolderActivity$3
  implements Runnable
{
  ServiceAccountFolderActivity$3(ServiceAccountFolderActivity paramServiceAccountFolderActivity, TextView paramTextView) {}
  
  public void run()
  {
    int i = this.this$0.app.getMessageFacade().getUnreadMsgsNum();
    ServiceAccountFolderActivity.a(this.this$0).post(new ServiceAccountFolderActivity.3.1(this, i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity.3
 * JD-Core Version:    0.7.0.1
 */