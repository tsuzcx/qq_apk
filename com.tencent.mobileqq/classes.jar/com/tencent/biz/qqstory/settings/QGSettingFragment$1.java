package com.tencent.biz.qqstory.settings;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QGSettingFragment$1
  implements CompoundButton.OnCheckedChangeListener
{
  QGSettingFragment$1(QGSettingFragment paramQGSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean) {
      QGSettingFragment.b(true);
    } else {
      QGSettingFragment.b(false);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QGSettingFragment.1
 * JD-Core Version:    0.7.0.1
 */