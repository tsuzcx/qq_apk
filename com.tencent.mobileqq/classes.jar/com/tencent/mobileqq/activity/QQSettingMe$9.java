package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.qqsettingme.IQQSettingMeProcessor;
import com.tencent.mobileqq.activity.qqsettingme.QQSettingMeViewModel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQSettingMe$9
  implements View.OnClickListener
{
  QQSettingMe$9(QQSettingMe paramQQSettingMe) {}
  
  public void onClick(View paramView)
  {
    QQSettingMe.k(this.a).a("d_pretty_num").onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.9
 * JD-Core Version:    0.7.0.1
 */