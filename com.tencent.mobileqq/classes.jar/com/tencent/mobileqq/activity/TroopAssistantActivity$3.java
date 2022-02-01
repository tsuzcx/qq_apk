package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.RoamSettingController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class TroopAssistantActivity$3
  implements View.OnClickListener
{
  TroopAssistantActivity$3(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void onClick(View paramView)
  {
    int i = 0;
    if ((this.a.jdField_a_of_type_JavaUtilList == null) || (this.a.jdField_a_of_type_JavaUtilList.size() == 0)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ReportController.b(this.a.app, "dc00899", "Grp_msg", "", "helper-guide", "Clk_confirm", 0, 0, "", "", "", "");
      this.a.jdField_a_of_type_ComTencentMobileqqUtilsRoamSettingController = ((RoamSettingController)this.a.app.getManager(QQManagerFactory.MGR_TROOP_FILTER));
      this.a.b.setCompoundDrawablesWithIntrinsicBounds(2130839545, 0, 0, 0);
      while (i < this.a.jdField_a_of_type_JavaUtilList.size())
      {
        String str = String.valueOf(this.a.jdField_a_of_type_JavaUtilList.get(i));
        this.a.a(str, 4);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssistantActivity.3
 * JD-Core Version:    0.7.0.1
 */