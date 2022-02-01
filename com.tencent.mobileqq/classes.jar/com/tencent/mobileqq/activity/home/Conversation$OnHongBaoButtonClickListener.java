package com.tencent.mobileqq.activity.home;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class Conversation$OnHongBaoButtonClickListener
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "OnHongBaoButtonClickListener");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.OnHongBaoButtonClickListener
 * JD-Core Version:    0.7.0.1
 */