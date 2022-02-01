package com.tencent.biz.qqcircle.fragments.person;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.biz.richframework.widget.MultiTabViewPager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCirclePersonalBottomView$3
  implements RadioGroup.OnCheckedChangeListener
{
  QCirclePersonalBottomView$3(QCirclePersonalBottomView paramQCirclePersonalBottomView) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if (QCirclePersonalBottomView.c(this.a).getId() == paramInt)
    {
      QCirclePersonalBottomView.d(this.a).setCurrentItem(0);
      QCirclePersonalBottomView.a(this.a, 0);
      QCirclePersonalBottomView.a(this.a, 19, 6);
    }
    else if (QCirclePersonalBottomView.e(this.a).getId() == paramInt)
    {
      QCirclePersonalBottomView.d(this.a).setCurrentItem(1);
      QCirclePersonalBottomView.a(this.a, 1);
      QCirclePersonalBottomView.a(this.a, 20, 2);
    }
    else if (QCirclePersonalBottomView.f(this.a).getId() == paramInt)
    {
      QCirclePersonalBottomView.d(this.a).setCurrentItem(2);
      QCirclePersonalBottomView.a(this.a, 2);
      QCirclePersonalBottomView.a(this.a, 21, 2);
    }
    this.a.a();
    EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCirclePersonalBottomView.3
 * JD-Core Version:    0.7.0.1
 */