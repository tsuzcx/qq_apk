package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QFSPersonalBottomWidget$4
  implements RadioGroup.OnCheckedChangeListener
{
  QFSPersonalBottomWidget$4(QFSPersonalBottomWidget paramQFSPersonalBottomWidget) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if (QFSPersonalBottomWidget.a(this.a).getId() == paramInt)
    {
      QFSPersonalBottomWidget.e(this.a).setCurrentItem(0);
      QFSPersonalBottomWidget.a(this.a, 20101);
    }
    else if (QFSPersonalBottomWidget.c(this.a).getId() == paramInt)
    {
      QFSPersonalBottomWidget.e(this.a).setCurrentItem(1);
      QFSPersonalBottomWidget.a(this.a, 20103);
    }
    else if (QFSPersonalBottomWidget.b(this.a).getId() == paramInt)
    {
      QFSPersonalBottomWidget.e(this.a).setCurrentItem(2);
      QFSPersonalBottomWidget.a(this.a, 20102);
    }
    EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalBottomWidget.4
 * JD-Core Version:    0.7.0.1
 */