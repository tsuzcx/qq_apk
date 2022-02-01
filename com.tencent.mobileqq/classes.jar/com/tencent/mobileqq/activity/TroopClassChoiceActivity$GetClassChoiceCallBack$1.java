package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.troop.troopcatalog.GroupCatalogBean;
import com.tencent.mobileqq.troop.troopcatalog.GroupCatalogTool;
import java.util.ArrayList;

class TroopClassChoiceActivity$GetClassChoiceCallBack$1
  implements Runnable
{
  TroopClassChoiceActivity$GetClassChoiceCallBack$1(TroopClassChoiceActivity.GetClassChoiceCallBack paramGetClassChoiceCallBack) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.a.a.jdField_a_of_type_JavaLangString))
    {
      this.a.a.jdField_a_of_type_JavaUtilArrayList = GroupCatalogTool.a(this.a.a).a();
    }
    else
    {
      this.a.a.jdField_a_of_type_JavaUtilArrayList = GroupCatalogTool.a(this.a.a).a(this.a.a.jdField_a_of_type_JavaLangString);
      if ((this.a.a.jdField_a_of_type_JavaUtilArrayList != null) && (this.a.a.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        GroupCatalogBean localGroupCatalogBean = (GroupCatalogBean)this.a.a.jdField_a_of_type_JavaUtilArrayList.get(0);
        if (localGroupCatalogBean.jdField_a_of_type_ComTencentMobileqqTroopTroopcatalogGroupCatalogBean != null) {
          this.a.a.setTitle(localGroupCatalogBean.jdField_a_of_type_ComTencentMobileqqTroopTroopcatalogGroupCatalogBean.jdField_a_of_type_JavaLangString);
        }
      }
    }
    TroopClassChoiceActivity.a(this.a.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopClassChoiceActivity.GetClassChoiceCallBack.1
 * JD-Core Version:    0.7.0.1
 */