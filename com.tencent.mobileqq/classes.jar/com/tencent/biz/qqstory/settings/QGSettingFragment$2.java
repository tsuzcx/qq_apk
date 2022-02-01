package com.tencent.biz.qqstory.settings;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QGSettingFragment$2
  implements CompoundButton.OnCheckedChangeListener
{
  QGSettingFragment$2(QGSettingFragment paramQGSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean) {
      QGSettingFragment.a(true);
    } else {
      QGSettingFragment.a(false);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QGSettingFragment.2
 * JD-Core Version:    0.7.0.1
 */