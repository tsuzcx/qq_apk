package com.tencent.mobileqq.activity.aio.intimate.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.intimate.BaseIntimateView;
import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class IntimateContentItemCommonTroopView$2
  implements View.OnClickListener
{
  IntimateContentItemCommonTroopView$2(IntimateContentItemCommonTroopView paramIntimateContentItemCommonTroopView) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.jdField_a_of_type_JavaUtilList == null) || (this.a.jdField_a_of_type_JavaUtilList.isEmpty())) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      TroopWithCommonFriendsFragment.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a());
      TroopWithCommonFriendsFragment.a(paramView.getContext(), 2);
      ReportController.b(null, "dc00898", "", "", "0X800AD22", "0X800AD22", 0, 0, "0", "0", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemCommonTroopView.2
 * JD-Core Version:    0.7.0.1
 */