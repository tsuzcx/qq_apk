package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingService;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class TroopAssistantActivity$3
  implements View.OnClickListener
{
  TroopAssistantActivity$3(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.jdField_a_of_type_JavaUtilList != null) && (this.a.jdField_a_of_type_JavaUtilList.size() != 0))
    {
      ReportController.b(this.a.app, "dc00899", "Grp_msg", "", "helper-guide", "Clk_confirm", 0, 0, "", "", "", "");
      Object localObject = this.a;
      ((TroopAssistantActivity)localObject).jdField_a_of_type_ComTencentMobileqqTroopRoamsettingApiIRoamSettingService = ((IRoamSettingService)((TroopAssistantActivity)localObject).app.getRuntimeService(IRoamSettingService.class, ""));
      localObject = this.a.b;
      int i = 0;
      ((Button)localObject).setCompoundDrawablesWithIntrinsicBounds(2130839401, 0, 0, 0);
      while (i < this.a.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = String.valueOf(this.a.jdField_a_of_type_JavaUtilList.get(i));
        this.a.a((String)localObject, 4);
        i += 1;
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssistantActivity.3
 * JD-Core Version:    0.7.0.1
 */