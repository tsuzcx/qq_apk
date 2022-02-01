package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.qcircle.api.IQCircleConfigApi;
import com.tencent.mobileqq.qroute.QRoute;

class ConversationTitleBtnCtrl$10
  implements Runnable
{
  ConversationTitleBtnCtrl$10(ConversationTitleBtnCtrl paramConversationTitleBtnCtrl) {}
  
  public void run()
  {
    ((IQCircleConfigApi)QRoute.api(IQCircleConfigApi.class)).tryGetSplashVideoAsync();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationTitleBtnCtrl.10
 * JD-Core Version:    0.7.0.1
 */