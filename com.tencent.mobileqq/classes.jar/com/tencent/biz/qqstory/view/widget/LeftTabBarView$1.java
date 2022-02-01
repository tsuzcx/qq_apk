package com.tencent.biz.qqstory.view.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LeftTabBarView$1
  implements View.OnClickListener
{
  LeftTabBarView$1(LeftTabBarView paramLeftTabBarView, int paramInt) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - LeftTabBarView.a(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLeftTabBarView) < 500L) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      LeftTabBarView.a(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLeftTabBarView, l);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLeftTabBarView.setSelectedTab(this.jdField_a_of_type_Int, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.LeftTabBarView.1
 * JD-Core Version:    0.7.0.1
 */