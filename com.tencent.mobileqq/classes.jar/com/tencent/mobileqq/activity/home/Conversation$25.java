package com.tencent.mobileqq.activity.home;

import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.mobileqq.qroute.QRoute;

class Conversation$25
  implements Runnable
{
  Conversation$25(Conversation paramConversation) {}
  
  public void run()
  {
    ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).preloadWebProcess(this.this$0.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.25
 * JD-Core Version:    0.7.0.1
 */