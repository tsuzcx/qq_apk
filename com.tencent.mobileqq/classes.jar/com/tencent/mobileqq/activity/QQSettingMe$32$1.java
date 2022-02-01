package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.vas.PrettyAccountUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQSettingMe$32$1
  implements View.OnClickListener
{
  QQSettingMe$32$1(QQSettingMe.32 param32) {}
  
  public void onClick(View paramView)
  {
    PrettyAccountUtil.a();
    PrettyAccountUtil.a("0X800B232", PrettyAccountUtil.a(), PrettyAccountUtil.b());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.32.1
 * JD-Core Version:    0.7.0.1
 */