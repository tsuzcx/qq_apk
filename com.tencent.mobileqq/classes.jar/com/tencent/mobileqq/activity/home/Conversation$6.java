package com.tencent.mobileqq.activity.home;

import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.mobileqq.statistics.ReportController;

class Conversation$6
  implements Runnable
{
  Conversation$6(Conversation paramConversation, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    long l = ServiceAccountFolderManager.a().d();
    ReportController.b(this.this$0.aF, "dc00899", "Pb_account_lifeservice", "", "0X8006E12", "0X8006E12", 0, 0, String.valueOf(this.a), String.valueOf(this.b), String.valueOf(this.c), String.valueOf(l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.6
 * JD-Core Version:    0.7.0.1
 */