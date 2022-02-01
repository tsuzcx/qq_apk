package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.ark.setting.ArkAppListActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class AssistantSettingActivity$19
  implements View.OnClickListener
{
  AssistantSettingActivity$19(AssistantSettingActivity paramAssistantSettingActivity, ArrayList paramArrayList) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity, ArkAppListActivity.class);
    localIntent.putExtra("intent_extra_authority_app_list", (String[])this.jdField_a_of_type_JavaUtilArrayList.toArray(new String[this.jdField_a_of_type_JavaUtilArrayList.size()]));
    this.jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity.startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity.19
 * JD-Core Version:    0.7.0.1
 */