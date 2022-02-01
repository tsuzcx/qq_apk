package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.DarkModeManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.mobilereport.MobileReportManager;

class SimpleUIChoiceView$ColorListAdapter$3
  implements View.OnClickListener
{
  SimpleUIChoiceView$ColorListAdapter$3(SimpleUIChoiceView.ColorListAdapter paramColorListAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (SimpleUIChoiceView.a(this.jdField_a_of_type_ComTencentMobileqqActivitySimpleUIChoiceView$ColorListAdapter.a))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySimpleUIChoiceView$ColorListAdapter.a(this.jdField_a_of_type_Int);
      if (localObject != null)
      {
        localObject = SimpleUIUtil.a(((SimpleUIChoiceView.ColorItemInfo)localObject).jdField_a_of_type_Int);
        if (!DarkModeManager.a(SimpleUIChoiceView.a(this.jdField_a_of_type_ComTencentMobileqqActivitySimpleUIChoiceView$ColorListAdapter.a), (String)localObject, new SimpleUIChoiceView.ColorListAdapter.3.1(this))) {
          SimpleUIChoiceView.ColorListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivitySimpleUIChoiceView$ColorListAdapter, this.jdField_a_of_type_Int);
        }
        MobileReportManager.getInstance().reportAction((String)localObject, "4", "platform898", "4", "1", 102, 1, System.currentTimeMillis());
        ReportController.b(SimpleUIChoiceView.a(this.jdField_a_of_type_ComTencentMobileqqActivitySimpleUIChoiceView$ColorListAdapter.a).app, "dc00898", "", "", "qq_vip", "0X800B15C", Integer.decode((String)localObject).intValue(), 0, "", "", "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SimpleUIChoiceView.ColorListAdapter.3
 * JD-Core Version:    0.7.0.1
 */