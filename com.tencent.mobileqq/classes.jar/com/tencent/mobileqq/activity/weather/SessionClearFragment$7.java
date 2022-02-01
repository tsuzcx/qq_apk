package com.tencent.mobileqq.activity.weather;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SessionClearFragment$7
  implements View.OnClickListener
{
  SessionClearFragment$7(SessionClearFragment paramSessionClearFragment) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SessionClearFragment", 2, "close_btn click");
    }
    SessionClearFragment.a(this.a).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.SessionClearFragment.7
 * JD-Core Version:    0.7.0.1
 */