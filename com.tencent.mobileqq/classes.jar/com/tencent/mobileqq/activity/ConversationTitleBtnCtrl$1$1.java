package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostConfig;

class ConversationTitleBtnCtrl$1$1
  implements Runnable
{
  ConversationTitleBtnCtrl$1$1(ConversationTitleBtnCtrl.1 param1) {}
  
  public void run()
  {
    QCircleHostConfig.setNeedShowMessageEntranceAnim(false);
    if (ConversationTitleBtnCtrl.a(this.a.a) != null) {
      ConversationTitleBtnCtrl.a(this.a.a).setVisibility(0);
    }
    if (ConversationTitleBtnCtrl.b(this.a.a) != null) {
      ConversationTitleBtnCtrl.b(this.a.a).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationTitleBtnCtrl.1.1
 * JD-Core Version:    0.7.0.1
 */