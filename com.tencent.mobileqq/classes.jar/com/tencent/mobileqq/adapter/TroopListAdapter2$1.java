package com.tencent.mobileqq.adapter;

import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.Switch;
import java.util.HashMap;

class TroopListAdapter2$1
  extends TroopBusinessObserver
{
  TroopListAdapter2$1(TroopListAdapter2 paramTroopListAdapter2, TroopActivity paramTroopActivity) {}
  
  public void onBeKickOutTroop(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {
      ((BaseActivity)this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.jdField_a_of_type_AndroidContentContext).runOnUiThread(new TroopListAdapter2.1.1(this));
    }
  }
  
  public void onSetTroopShowExternalStatus(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!paramBoolean)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.getString(2131696175), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.getTitleBarHeight());
      if ((this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)))
      {
        Switch localSwitch = (Switch)this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.jdField_a_of_type_JavaUtilHashMap.get(paramString);
        if (this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.jdField_a_of_type_ComTencentMobileqqAppTroopManager != null) {
          localSwitch.setChecked(this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.jdField_a_of_type_ComTencentMobileqqAppTroopManager.d(paramString));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.TroopListAdapter2.1
 * JD-Core Version:    0.7.0.1
 */