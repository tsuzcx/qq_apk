package com.tencent.mobileqq.apollo.debug.page;

import aktg;
import akth;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class CmGameDebugToolFragment
  extends CmGameDebugBaseFragment
  implements View.OnClickListener
{
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  FormSwitchItem b;
  
  private void b()
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("cmgame_sp", 4);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("game_whitelist_verify_switch", true));
    this.b.setChecked(this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("game_storage_switch", false));
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new aktg(this));
    this.b.setOnCheckedChangeListener(new akth(this));
  }
  
  public void onClick(View paramView)
  {
    paramView.getId();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = paramLayoutInflater.inflate(2131558832, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)paramLayoutInflater.findViewById(2131364388));
    this.b = ((FormSwitchItem)paramLayoutInflater.findViewById(2131364387));
    b();
    c();
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.debug.page.CmGameDebugToolFragment
 * JD-Core Version:    0.7.0.1
 */