package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vashealth.api.IQQHealthApi;

class Conversation$UICallBack$2
  implements Runnable
{
  Conversation$UICallBack$2(Conversation.UICallBack paramUICallBack) {}
  
  public void run()
  {
    ((IQQHealthApi)QRoute.api(IQQHealthApi.class)).checkRedPackRequest(this.a.a.aF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.UICallBack.2
 * JD-Core Version:    0.7.0.1
 */