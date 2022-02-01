package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.qcircle.api.IQCircleService;

class ConversationTitleBtnCtrl$2
  implements Runnable
{
  ConversationTitleBtnCtrl$2(ConversationTitleBtnCtrl paramConversationTitleBtnCtrl) {}
  
  public void run()
  {
    QCircleUtils.a().sendGetRainBowRequest();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationTitleBtnCtrl.2
 * JD-Core Version:    0.7.0.1
 */