package com.tencent.mobileqq.activity;

import adxt;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.widget.ListView;

public class FontSettingActivity$AioListAdapter$1
  implements Runnable
{
  public FontSettingActivity$AioListAdapter$1(adxt paramadxt) {}
  
  public void run()
  {
    this.jdField_a_of_type_Adxt.a.jdField_a_of_type_ComTencentWidgetListView.setAdapter(null);
    this.jdField_a_of_type_Adxt.a.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Adxt.a.jdField_a_of_type_Adxt);
    FontSettingManager.revertToLsatDendisy(this.jdField_a_of_type_Adxt.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FontSettingActivity.AioListAdapter.1
 * JD-Core Version:    0.7.0.1
 */